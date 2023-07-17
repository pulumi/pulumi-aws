.PHONY: check_schema

PACK := aws
ORG := pulumi
PROJECT := github.com/$(ORG)/pulumi-$(PACK)
PROVIDER_PATH := provider/v6
VERSION_PATH := $(PROVIDER_PATH)/pkg/version.Version
TFGEN := pulumi-tfgen-$(PACK)
PROVIDER := pulumi-resource-$(PACK)
VERSION := $(shell pulumictl get version)
JAVA_GEN := pulumi-java-gen
JAVA_GEN_VERSION := v0.9.5
TESTPARALLELISM := 10
WORKING_DIR := $(shell pwd)
SCHEMA_TOOLS_VERSION := $(shell cat .schema-tools.version)
PULUMI_PROVIDER_BUILD_PARALLELISM ?= -p 2

# Override repo path discovery because we're using a local checkout instead of the go mod
export PULUMI_REPO_PATHS=github.com/hashicorp/terraform-provider-aws=$(WORKING_DIR)/upstream

# Download local copy of schema-tools based on the version in .schema-tools.version
bin/schema-tools: SCHEMA_TOOLS_VERSION := $(shell cat .schema-tools.version)
bin/schema-tools: PLAT := $(shell go version | sed -En "s/go version go.* (.*)\/(.*)/\1-\2/p")
bin/schema-tools: SCHEMA_TOOLS_URL := "https://github.com/pulumi/schema-tools/releases/download/v$(SCHEMA_TOOLS_VERSION)/schema-tools-v$(SCHEMA_TOOLS_VERSION)-$(PLAT).tar.gz"
bin/schema-tools: .schema-tools.version
	@echo "Installing schema-tools"
	@mkdir -p bin
	wget -q -O - "$(SCHEMA_TOOLS_URL)" | tar -xzf - -C $(WORKING_DIR)/bin schema-tools
	@touch bin/schema-tools
	@echo "schema-tools" $$(./bin/schema-tools version)

check_schema: bin/schema-tools
	./bin/schema-tools compare -p $(PACK) -o master -n --local-path=provider/cmd/pulumi-resource-$(PACK)/schema.json

development: install_plugins provider build_sdks install_sdks

build: install_plugins provider build_sdks install_sdks

build_sdks: build_nodejs build_python build_go build_dotnet build_java

install_go_sdk:

install_java_sdk:

install_python_sdk:

install_sdks: install_dotnet_sdk install_python_sdk install_nodejs_sdk install_java_sdk

only_build: build

build_dotnet: DOTNET_VERSION := $(shell pulumictl get version --language dotnet)
build_dotnet: patch_upstream
	pulumictl get version --language dotnet
	$(WORKING_DIR)/bin/$(TFGEN) dotnet --overlays provider/overlays/dotnet --out sdk/dotnet/
	cd sdk/dotnet/ && \
		echo "module fake_dotnet_module // Exclude this directory from Go tools\n\ngo 1.17" > go.mod && \
		echo "$(DOTNET_VERSION)" >version.txt && \
		dotnet build /p:Version=$(DOTNET_VERSION)

build_go: patch_upstream
	$(WORKING_DIR)/bin/$(TFGEN) go --overlays provider/overlays/go --out sdk/go/

build_java: PACKAGE_VERSION := $(shell pulumictl get version --language generic)
build_java: bin/pulumi-java-gen patch_upstream
	$(WORKING_DIR)/bin/$(JAVA_GEN) generate --schema provider/cmd/$(PROVIDER)/schema.json --out sdk/java  --build gradle-nexus
	cd sdk/java/ && \
		echo "module fake_java_module // Exclude this directory from Go tools\n\ngo 1.17" > go.mod && \
		gradle --console=plain build

build_nodejs: VERSION := $(shell pulumictl get version --language javascript)
build_nodejs: patch_upstream
	$(WORKING_DIR)/bin/$(TFGEN) nodejs --overlays provider/overlays/nodejs --out sdk/nodejs/
	cd sdk/nodejs/ && \
		echo "module fake_nodejs_module // Exclude this directory from Go tools\n\ngo 1.17" > go.mod && \
		yarn install && \
		yarn run tsc && \
		cp ../../README.md ../../LICENSE* package.json yarn.lock ./bin/ && \
		sed -i.bak -e "s/\$${VERSION}/$(VERSION)/g" ./bin/package.json

build_python: PYPI_VERSION := $(shell pulumictl get version --language python)
build_python: patch_upstream
	$(WORKING_DIR)/bin/$(TFGEN) python --overlays provider/overlays/python --out sdk/python/
	cd sdk/python/ && \
		echo "module fake_python_module // Exclude this directory from Go tools\n\ngo 1.17" > go.mod && \
		cp ../../README.md . && \
		python3 setup.py clean --all 2>/dev/null && \
		rm -rf ./bin/ ../python.bin/ && cp -R . ../python.bin && mv ../python.bin ./bin && \
		sed -i.bak -e 's/^VERSION = .*/VERSION = "$(PYPI_VERSION)"/g' -e 's/^PLUGIN_VERSION = .*/PLUGIN_VERSION = "$(VERSION)"/g' ./bin/setup.py && \
		rm ./bin/setup.py.bak && rm ./bin/go.mod && \
		cd ./bin && python3 setup.py build sdist

clean:
	rm -rf sdk/{dotnet,nodejs,go,python}

cleanup:
	rm -r $(WORKING_DIR)/bin
	rm -f provider/cmd/$(PROVIDER)/schema.go

help:
	@grep '^[^.#]\+:\s\+.*#' Makefile | \
	sed "s/\(.\+\):\s*\(.*\) #\s*\(.*\)/`printf "\033[93m"`\1`printf "\033[0m"`	\3 [\2]/" | \
	expand -t20

install_dotnet_sdk:
	mkdir -p $(WORKING_DIR)/nuget
	find . -name '*.nupkg' -print -exec cp -p {} $(WORKING_DIR)/nuget \;

install_nodejs_sdk:
	yarn link --cwd $(WORKING_DIR)/sdk/nodejs/bin

install_plugins:
	[ -x $(shell which pulumi) ] || curl -fsSL https://get.pulumi.com | sh
	pulumi plugin install resource archive 0.0.1
	pulumi plugin install resource tls 4.10.0
	pulumi plugin install resource github 4.10.0
	pulumi plugin install resource kubernetes 3.17.0
	pulumi plugin install resource random 4.8.2

lint_provider: provider
	cd provider && golangci-lint run -c ../.golangci.yml

provider: tfgen install_plugins
	(cd provider && go build $(PULUMI_PROVIDER_BUILD_PARALLELISM) -o $(WORKING_DIR)/bin/$(PROVIDER) -ldflags "-X $(PROJECT)/$(VERSION_PATH)=$(VERSION) -X github.com/hashicorp/terraform-provider-aws/version.ProviderVersion=$(VERSION)" $(PROJECT)/$(PROVIDER_PATH)/cmd/$(PROVIDER))

test:
	cd provider/shim && go test -v .
	cd examples && go test -v -tags=all -parallel $(TESTPARALLELISM) -timeout 2h

tfgen: install_plugins patch_upstream
	(cd provider && go build $(PULUMI_PROVIDER_BUILD_PARALLELISM) -o $(WORKING_DIR)/bin/$(TFGEN) -ldflags "-X $(PROJECT)/$(VERSION_PATH)=$(VERSION)" $(PROJECT)/$(PROVIDER_PATH)/cmd/$(TFGEN))
	$(WORKING_DIR)/bin/$(TFGEN) schema --out provider/cmd/$(PROVIDER)
	(cd provider && VERSION=$(VERSION) go generate cmd/$(PROVIDER)/main.go)

bin/pulumi-java-gen:
	pulumictl download-binary -n pulumi-language-java -v $(JAVA_GEN_VERSION) -r pulumi/pulumi-java

init_upstream:
	@if [ ! -f "upstream/.git" ]; then \
			echo "Initializing upstream submodule" ; \
			(cd upstream && git submodule update --init && git remote add source git@github.com:hashicorp/terraform-provider-aws.git && git fetch source) ; \
		fi; \

export_upstream_patches: init_upstream
ifeq ($(shell cd upstream && git rev-parse --is-shallow-repository), false)
	find upstream-patches -type f -delete
	# Find the most recent tag before the current checkout - don't abbreviate the tag name
	# Create patch files for each commit since the last tag
	cd upstream && LAST_TAG=$$(git describe --abbrev=0 --tags) && \
		git format-patch  -o ../upstream-patches --minimal --no-signature HEAD...$${LAST_TAG}
endif

patch_upstream: init_upstream export_upstream_patches
	@# Ensure tool is installed
	cd upstream-tools && yarn install --frozen-lockfile
	@# Reset all changes in the submodule so we're starting from a clean slate
	cd upstream && git checkout . && git clean -fdx
	@# Apply all automated changed
	cd upstream-tools && yarn --silent run apply
	@# Check for any pending replacements
	cd upstream-tools && yarn --silent run check

update_upstream: init_upstream
	@echo "\033[1;33mupdate_upstream is still under construction and will likely fail.\033[0m"
	cd upstream && git fetch --all && cd -
	# Find latest tag, create new branch, rebase on new tag, push
	export TAG=$$(cd upstream && git for-each-ref refs/tags --sort=-taggerdate --format='%(refname:short) && cd -' --count=1) && \
		cd upstream && \
		git checkout -b "patched-$$TAG" && \
		git rebase "$$TAG" && \
		git push origin "patched-$$TAG"

.PHONY: development build build_sdks install_go_sdk install_java_sdk install_python_sdk install_sdks only_build build_dotnet build_go build_java build_nodejs build_python clean cleanup help install_dotnet_sdk install_nodejs_sdk install_plugins lint_provider provider test tfgen
