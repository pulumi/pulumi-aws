PROJECT_NAME := Amazon Web Services (AWS) Package
include build/common.mk

PACK             := aws
PACKDIR          := sdk
PROJECT          := github.com/pulumi/pulumi-aws
NODE_MODULE_NAME := @pulumi/aws

TFGEN           := pulumi-tfgen-${PACK}
PROVIDER        := pulumi-resource-${PACK}
VERSION         := $(shell scripts/get-version)
PYPI_VERSION    := $(shell scripts/get-py-version)

DOTNET_PREFIX  := $(firstword $(subst -, ,${VERSION:v%=%})) # e.g. 1.5.0
DOTNET_SUFFIX  := $(word 2,$(subst -, ,${VERSION:v%=%}))    # e.g. alpha.1

ifeq ($(strip ${DOTNET_SUFFIX}),)
	DOTNET_VERSION := $(strip ${DOTNET_PREFIX})-preview
else
	DOTNET_VERSION := $(strip ${DOTNET_PREFIX})-preview-$(strip ${DOTNET_SUFFIX})
endif

TESTPARALLELISM := 10

tfgen::
	go install -ldflags "-X github.com/pulumi/pulumi-${PACK}/pkg/version.Version=${VERSION}" ${PROJECT}/cmd/${TFGEN}

generate_schema:: tfgen
	$(TFGEN) schema --out ./cmd/${PROVIDER}

provider::
	go generate ${PROJECT}/cmd/${PROVIDER}
	go install -ldflags "-X github.com/pulumi/pulumi-${PACK}/pkg/version.Version=${VERSION}" ${PROJECT}/cmd/${PROVIDER}

# NOTE: Since the plugin is published using the nodejs style semver version
# We set the PLUGIN_VERSION to be the same as the version we use when building
# the provider (e.g. x.y.z-dev-... instead of x.y.zdev...)
build:: provider tfgen install_plugins
	for LANGUAGE in "nodejs" "python" "go" "dotnet" ; do \
		$(TFGEN) $$LANGUAGE --overlays overlays/$$LANGUAGE/ --out ${PACKDIR}/$$LANGUAGE/ || exit 3 ; \
	done
	cd ${PACKDIR}/nodejs/ && \
		yarn install && \
		yarn run tsc && \
		cp ../../README.md ../../LICENSE package.json yarn.lock ./bin/ && \
		sed -i.bak "s/\$${VERSION}/$(VERSION)/g" ./bin/package.json
	cd ${PACKDIR}/python/ && \
		cp ../../README.md . && \
		$(PYTHON) setup.py clean --all 2>/dev/null && \
		rm -rf ./bin/ ../python.bin/ && cp -R . ../python.bin && mv ../python.bin ./bin && \
		sed -i.bak -e "s/\$${VERSION}/$(PYPI_VERSION)/g" -e "s/\$${PLUGIN_VERSION}/$(VERSION)/g" ./bin/setup.py && \
		rm ./bin/setup.py.bak && \
		cd ./bin && $(PYTHON) setup.py build sdist
	cd ${PACKDIR}/dotnet/ && \
		echo "${VERSION:v%=%}" >version.txt && \
		dotnet build /p:Version=${DOTNET_VERSION}

install_plugins::
	[ -x "$(shell which pulumi)" ] || curl -fsSL https://get.pulumi.com | sh
	pulumi plugin install resource tls 0.18.0

lint::
	#golangci-lint run

install::
	GOBIN=$(PULUMI_BIN) go install -ldflags "-X github.com/pulumi/pulumi-aws/pkg/version.Version=${VERSION}" ${PROJECT}/cmd/${PROVIDER}
	[ ! -e "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)" ] || rm -rf "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)"
	mkdir -p "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)"
	cp -r ${PACKDIR}/nodejs/bin/. "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)"
	rm -rf "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)/node_modules"
	cd "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)" && \
		yarn install --offline --production && \
		(yarn unlink > /dev/null 2>&1 || true) && \
		yarn link
	echo "Copying NuGet packages to ${PULUMI_NUGET}"
	[ ! -e "$(PULUMI_NUGET)" ] || rm -rf "$(PULUMI_NUGET)/*"
	find . -name '*.nupkg' -exec cp -p {} ${PULUMI_NUGET} \;

test_fast::
	$(GO_TEST_FAST) ./examples

test_all::
	$(GO_TEST) ./examples

.PHONY: publish_tgz
publish_tgz:
	$(call STEP_MESSAGE)
	./scripts/publish_tgz.sh

.PHONY: publish_packages
publish_packages:
	$(call STEP_MESSAGE)
	$$(go env GOPATH)/src/github.com/pulumi/scripts/ci/publish-tfgen-package .
	$$(go env GOPATH)/src/github.com/pulumi/scripts/ci/build-package-docs.sh ${PACK}

.PHONY: check_clean_worktree
check_clean_worktree:
	$$(go env GOPATH)/src/github.com/pulumi/scripts/ci/check-worktree-is-clean.sh

# The travis_* targets are entrypoints for CI.
.PHONY: travis_cron travis_push travis_pull_request travis_api
travis_cron: all
travis_push: only_build check_clean_worktree publish_tgz only_test publish_packages
travis_pull_request: only_build check_clean_worktree only_test_fast
travis_api: all
