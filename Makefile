SHELL=/bin/bash
.SHELLFLAGS=-ec

PACK    =aws
PACKDIR =pack
PACKNAME=Amazon Web Services (AWS)
PROJECT =github.com/pulumi/pulumi-aws

TFGEN           = pulumi-tfgen-${PACK}
PROVIDER        = pulumi-provider-${PACK}
PROVIDER_BIN    = ${GOPATH}/bin/${PROVIDER}
TESTPARALLELISM = 10

ECHO=echo -e
GOMETALINTERBIN=gometalinter
GOMETALINTER=${GOMETALINTERBIN} --config=Gometalinter.json

default: banner buildtools gen build test install
notest: banner buildtools gen build install
all: banner buildtools gen build install examples
.PHONY: default notest all

banner:
	@$(ECHO) "\033[1;37m========================================\033[0m"
	@$(ECHO) "\033[1;37m${PACKNAME} Lumi Package\033[0m"
	@$(ECHO) "\033[1;37m========================================\033[0m"
	@go version
.PHONY: banner

buildtools:
	go install ${PROJECT}/cmd/${TFGEN}
	go install ${PROJECT}/cmd/${PROVIDER}

gen:
	$(TFGEN) --out pack/
	cd pack/ && yarn install
.PHONY: gen

build:
	@$(ECHO) "[Building ${PACK} package:]"
	cd ${PACKDIR} && yarn link pulumi # ensure we resolve to Lumi's stdlibs.
	cd ${PACKDIR} && yarn run build   # compile into a JavaScript NPM package.
.PHONY: build

test:
	go test -cover -parallel ${TESTPARALLELISM} ${GOPKGS}
	go tool vet -printf=false ./cmd
	go tool vet -printf=false resources.go
	which ${GOMETALINTERBIN} >/dev/null
	$(GOMETALINTER) ./cmd/... resources.go | sort ; exit "$${PIPESTATUS[0]}"
.PHONY: test

install:
	@$(ECHO) "[Installing ${PACK} package:]"
	cp ${PACKDIR}/package.json ${PACKDIR}/bin/
	cd ${PACKDIR}/bin && yarn link --force               # ensure this pack is made available.
.PHONY: install

publish:
	@$(ECHO) "\033[0;32mPublishing current release:\033[0m"
	./scripts/publish.sh
.PHONY: publish

clean:
	rm -rf ${INSTALLDIR}
.PHONY: clean

examples:
	@echo "\033[0;32mTEST EXAMPLES:\033[0m"
	go test -v -cover -timeout 1h -parallel ${TESTPARALLELISM} ./examples
.PHONY: examples

