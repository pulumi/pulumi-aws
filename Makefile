PROJECT_NAME := Amazon Web Services (AWS) Package
include build/common.mk

PACK             := aws
PACKDIR          := pack
PROJECT          := github.com/pulumi/pulumi-aws
NODE_MODULE_NAME := @pulumi/aws

TFGEN           := pulumi-tfgen-${PACK}
PROVIDER        := pulumi-resource-${PACK}
VERSION         := $(shell scripts/get-version)

GOMETALINTERBIN=gometalinter
GOMETALINTER=${GOMETALINTERBIN} --config=Gometalinter.json

TESTPARALLELISM := 10

build::
	go install -ldflags "-X github.com/pulumi/pulumi-aws/pkg/version.Version=${VERSION}" ${PROJECT}/cmd/${TFGEN}
	go install -ldflags "-X github.com/pulumi/pulumi-aws/pkg/version.Version=${VERSION}" ${PROJECT}/cmd/${PROVIDER}
	for LANGUAGE in "nodejs" "python" ; do \
		$(TFGEN) $$LANGUAGE --overlays overlays/$$LANGUAGE/ --out ${PACKDIR}/$$LANGUAGE/ || exit 3 ; \
	done
	cd ${PACKDIR}/nodejs/ && \
		yarn install && \
		yarn link @pulumi/pulumi && \
		yarn run tsc
	cp README.md LICENSE ${PACKDIR}/nodejs/package.json ${PACKDIR}/nodejs/yarn.lock ${PACKDIR}/nodejs/bin/
	cd ${PACKDIR}/python/ && \
		$(PYTHON) setup.py clean --all 2>/dev/null && \
		rm -rf ./bin/ ../python.bin/ && cp -R . ../python.bin && mv ../python.bin ./bin && \
		sed -i.bak "s/\$${VERSION}/$(VERSION)/g" ./bin/setup.py && rm ./bin/setup.py.bak && \
		cd ./bin && $(PYTHON) setup.py build bdist_wheel --universal

lint::
	$(GOMETALINTER) ./cmd/... resources.go | sort ; exit "$${PIPESTATUS[0]}"

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
	cd ${PACKDIR}/python/bin && $(PIP) install --user -e .

test_all::
	PATH=$(PULUMI_BIN):$(PATH) go test -v -cover -timeout 1h -parallel ${TESTPARALLELISM} ./examples

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
