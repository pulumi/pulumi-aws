SHELL=/bin/bash
.SHELLFLAGS=-e

PACK    =aws
PACKDIR =pack
PACKNAME=Amazon Web Services (AWS)
PROJECT =github.com/pulumi/aws

TFGEN           = lumi-tfgen-${PACK}
TFBRIDGE        = lumi-tfbridge-${PACK}
TFBRIDGE_BIN    = ${GOPATH}/bin/${TFBRIDGE}
LUMIROOT       ?= /usr/local/lumi
LUMILIB         = ${LUMIROOT}/packs
LUMIPLUG        = lumi-resource
TESTPARALLELISM = 10

INSTALLDIR      = ${LUMILIB}/${PACK}

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
	go install ${PROJECT}/cmd/${TFBRIDGE}

gen:
	$(TFGEN) --out pack/
.PHONY: gen

build:
	@$(ECHO) "[Building ${PACK} package:]"
	cd ${PACKDIR} && yarn link @lumi/lumi @lumi/lumirt      # ensure we resolve to Lumi's stdlibs.
	cd ${PACKDIR} && lumijs                                 # compile the LumiPack.
	cd ${PACKDIR} && lumi pack verify                       # ensure the pack verifies.
.PHONY: build

test:
	go test -cover -parallel ${TESTPARALLELISM} ${GOPKGS}
	go tool vet -printf=false ./cmd
	go tool vet -printf=false resources.go
	@#$(GOMETALINTER) ./cmd/... | sort ; exit "$${PIPESTATUS[0]}"
	@#$(GOMETALINTER) resources.go | sort ; exit "$${PIPESTATUS[0]}"
.PHONY: test

install:
	@$(ECHO) "[Installing ${PACK} package to ${INSTALLDIR}:]"
	mkdir -p ${INSTALLDIR}
	cp ${PACKDIR}/VERSION ${INSTALLDIR}                     # remember the version we gen'd this from.
	cp -r ${PACKDIR}/.lumi/bin/* ${INSTALLDIR}              # copy the binary/metadata.
	cp ${TFBRIDGE_BIN} ${INSTALLDIR}/${LUMIPLUG}-${PACK}    # bring along the Lumi plugin.
	cp ${PACKDIR}/package.json ${INSTALLDIR}                # ensure the result is a proper NPM package.
	cp -RL ${PACKDIR}/node_modules ${INSTALLDIR}            # copy the links we installed.
	cd ${INSTALLDIR} && yarn link --force                   # make the pack easily available for devs.
.PHONY: install

publish:
	@$(ECHO) "\033[0;32mPublishing current release:\033[0m"
	./scripts/publish.sh
.PHONY: publish

sync:
	govendor sync -v
.PHONY: sync

updatedeps:
	govendor init # initialize the vendor/ directory if it's missing.
	govendor add +external # ensure all external dependencies exist.
	sed -i.bck '/\"origin\":/d' ./vendor/vendor.json # get rid of origins; they don't work with recursive vendoring.
	rm ./vendor/vendor.json.bck
	govendor fetch github.com/terraform-providers/terraform-provider-aws/aws::github.com/pulumi/terraform-provider-aws/aws@pulumi-master
	govendor update +v # now enure that, after the above edits, we have the latest versions.
.PHONY: updatedeps

clean:
	rm -rf ${INSTALLDIR}
.PHONY: clean

examples:
	@echo "\033[0;32mTEST EXAMPLES:\033[0m"
	go test -v -cover -timeout 1h -parallel ${TESTPARALLELISM} ./examples
.PHONY: examples
