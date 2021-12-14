PACK             := aws
ORG              := pulumi
PROJECT          := github.com/${ORG}/pulumi-${PACK}
NODE_MODULE_NAME := @pulumi/${PACK}
TF_NAME          := ${PACK}
PROVIDER_PATH    := provider/v4
SDK_PATH		 := sdk/v4
VERSION_PATH     := ${PROVIDER_PATH}/pkg/version.Version

TFGEN           := pulumi-tfgen-${PACK}
PROVIDER        := pulumi-resource-${PACK}
VERSION         := $(shell pulumictl get version)

TESTPARALLELISM := 10

WORKING_DIR     := $(shell pwd)

.PHONY: development provider build_sdks build_nodejs build_dotnet build_go build_python

development:: install_plugins provider build_sdks install_sdks # Build the provider & SDKs for a development environment

# Required for the codegen action that runs in pulumi/pulumi and pulumi/pulumi-terraform-bridge
build:: install_plugins provider build_sdks install_sdks
only_build:: build

tfgen:: install_plugins
	(cd provider && go build -a -o $(WORKING_DIR)/bin/${TFGEN} -ldflags "-X ${PROJECT}/${VERSION_PATH}=${VERSION}" ${PROJECT}/${PROVIDER_PATH}/cmd/${TFGEN})
	$(WORKING_DIR)/bin/${TFGEN} schema --out provider/cmd/${PROVIDER}
	(cd provider && VERSION=$(VERSION) go generate cmd/${PROVIDER}/main.go)

provider:: tfgen install_plugins # build the provider binary
	(cd provider && go build -a -o $(WORKING_DIR)/bin/${PROVIDER} -ldflags "-X ${PROJECT}/${VERSION_PATH}=${VERSION} -X github.com/terraform-providers/terraform-provider-aws/version.ProviderVersion=${VERSION} -w -s" ${PROJECT}/${PROVIDER_PATH}/cmd/${PROVIDER})

build_sdks:: build_nodejs build_python build_go build_dotnet # build all the sdks

build_nodejs:: VERSION := $(shell pulumictl get version --language javascript)
build_nodejs:: # build the node sdk
	$(WORKING_DIR)/bin/$(TFGEN) nodejs --overlays provider/overlays/nodejs --out sdk/nodejs/
	cd sdk/nodejs/ && \
		touch go.mod && \
        yarn install && \
        yarn run tsc && \
        cp ../../README.md ../../LICENSE package.json yarn.lock ./bin/ && \
    	sed -i.bak -e "s/\$${VERSION}/$(VERSION)/g" ./bin/package.json

build_python:: PYPI_VERSION := $(shell pulumictl get version --language python)
build_python:: # build the python sdk
	$(WORKING_DIR)/bin/$(TFGEN) python --overlays provider/overlays/python --out sdk/python/
	cd sdk/python/ && \
		touch go.mod && \
        cp ../../README.md . && \
        python3 setup.py clean --all 2>/dev/null && \
        rm -rf ./bin/ ../python.bin/ && cp -R . ../python.bin && mv ../python.bin ./bin && \
        sed -i.bak -e 's/^VERSION = .*/VERSION = "$(PYPI_VERSION)"/g' -e 's/^PLUGIN_VERSION = .*/PLUGIN_VERSION = "$(VERSION)"/g' ./bin/setup.py && \
        rm ./bin/setup.py.bak && \
        cd ./bin && python3 setup.py build sdist

build_go:: # build the go sdk
	$(WORKING_DIR)/bin/$(TFGEN) go --overlays provider/overlays/go --out sdk/go/
#	cd sdk/ && \
#	  GOGC=50 go list ${PROJECT}/${SDK_PATH}/go/aws/... | xargs -L 1 go build

build_dotnet:: DOTNET_VERSION := $(shell pulumictl get version --language dotnet)
build_dotnet:: # build the dotnet sdk
	pulumictl get version --language dotnet
	$(WORKING_DIR)/bin/$(TFGEN) dotnet --overlays provider/overlays/dotnet --out sdk/dotnet/
	cd sdk/dotnet/ && \
		touch go.mod && \
		echo "${DOTNET_VERSION}" >version.txt && \
        dotnet build /p:Version=${DOTNET_VERSION}

lint_provider:: provider # lint the provider code
	cd provider && golangci-lint run -c ../.golangci.yml

cleanup:: # cleans up the temporary directory
	rm -r $(WORKING_DIR)/bin
	rm -f provider/cmd/${PROVIDER}/schema.go

help::
	@grep '^[^.#]\+:\s\+.*#' Makefile | \
 	sed "s/\(.\+\):\s*\(.*\) #\s*\(.*\)/`printf "\033[93m"`\1`printf "\033[0m"`	\3 [\2]/" | \
 	expand -t20

clean::
	rm -rf sdk/{dotnet,nodejs,go,python}

install_plugins::
	[ -x $(shell which pulumi) ] || curl -fsSL https://get.pulumi.com | sh
	pulumi plugin install resource tls 4.0.0
	pulumi plugin install resource github 4.6.0
	pulumi plugin install resource kubernetes 3.8.3

install_dotnet_sdk::
	mkdir -p $(WORKING_DIR)/nuget
	find . -name '*.nupkg' -print -exec cp -p {} ${WORKING_DIR}/nuget \;

install_python_sdk::

install_go_sdk::

install_nodejs_sdk::
	yarn link --cwd $(WORKING_DIR)/sdk/nodejs/bin

install_sdks:: install_dotnet_sdk install_python_sdk install_nodejs_sdk

test::
	cd examples && go test -v -tags=all -parallel ${TESTPARALLELISM} -timeout 2h
