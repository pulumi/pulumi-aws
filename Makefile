PROJECT_NAME := Amazon Web Services (AWS) Package
include build/common.mk

PACK             := aws
PACKDIR          := pack
PROJECT          := github.com/pulumi/pulumi-aws
NODE_MODULE_NAME := @pulumi/aws

TFGEN           := pulumi-tfgen-${PACK}
PROVIDER        := pulumi-provider-${PACK}
VERSION         := $(shell git describe --tags --dirty 2>/dev/null)

GOMETALINTERBIN=gometalinter
GOMETALINTER=${GOMETALINTERBIN} --config=Gometalinter.json

TESTPARALLELISM := 10

build::
	go install -ldflags "-X github.com/pulumi/pulumi-aws/pkg/version.Version=${VERSION}" ${PROJECT}/cmd/${TFGEN}
	go install -ldflags "-X github.com/pulumi/pulumi-aws/pkg/version.Version=${VERSION}" ${PROJECT}/cmd/${PROVIDER}
	$(TFGEN) --out pack/
	cd pack/ && yarn install
	cd ${PACKDIR} && yarn link pulumi # ensure we resolve to Pulumi's stdlibs.
	cd ${PACKDIR} && yarn run tsc

lint::
	$(GOMETALINTER) ./cmd/... ./examples/... ./tests/... resources.go | sort ; exit "$${PIPESTATUS[0]}"

install::
	GOBIN=$(PULUMI_BIN) go install -ldflags "-X github.com/pulumi/pulumi-aws/pkg/version.Version=${VERSION}" ${PROJECT}/cmd/${PROVIDER}
	[ ! -e "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)" ] || rm -rf "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)"
	mkdir -p "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)"
	cp -r pack/bin/. "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)"
	cp pack/package.json "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)"
	cp pack/yarn.lock "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)"
	rm -rf "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)/node_modules"
	cd "$(PULUMI_NODE_MODULES)/$(NODE_MODULE_NAME)" && \
	yarn install --offline --production && \
	(yarn unlink > /dev/null 2>&1 || true) && \
	yarn link

test_all::
	PATH=$(PULUMI_BIN):$(PATH) go test -v -cover -timeout 1h -parallel ${TESTPARALLELISM} ./examples ./tests

.PHONY: publish
publish:
	$(call STEP_MESSAGE)
	./scripts/publish.sh

# The travis_* targets are entrypoints for CI.
.PHONY: travis_cron travis_push travis_pull_request travis_api
travis_cron: all
travis_push: only_build publish only_test
travis_pull_request: all
travis_api: all
