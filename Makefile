SHELL=/bin/bash
.SHELLFLAGS=-e

PACK   =aws
PACKDIR=pack
NAME   =AWS

TFGEN           = lumi-tfgen
TFBRIDGE        = lumi-tfbridge
TFBRIDGE_BIN    = ${GOPATH}/bin/${TFBRIDGE}
LUMIROOT       ?= /usr/local/lumi
LUMILIB         = ${LUMIROOT}/packs
LUMIPLUG        = lumi-resource
TESTPARALLELISM = 10

ECHO=echo -e
GOMETALINTERBIN=gometalinter
GOMETALINTER=${GOMETALINTERBIN} --config=Gometalinter.json

all: banner gen build test install
.PHONY: all

banner:
	@$(ECHO) "\033[1;37m================================\033[0m"
	@$(ECHO) "\033[1;37m${FLUX} Lumi Package\033[0m"
	@$(ECHO) "\033[1;37m================================\033[0m"
	@go version
.PHONY: banner

gen:
	$(TFGEN) ${PACK} --out pack/
.PHONY: gen

build:
	@$(ECHO) "[Building ${PACK} package:]"
	cd ${PACKDIR} && yarn link @lumi/lumi @lumi/lumirt      # ensure we resolve to Lumi's stdlibs.
	cd ${PACKDIR} && lumijs                                 # compile the LumiPack.
	cd ${PACKDIR} && lumi pack verify                       # ensure the pack verifies.
	$(eval INSTALLDIR := ${LUMILIB}/${PACK})
.PHONY: build

test:
	go test -cover -parallel ${TESTPARALLELISM} ${GOPKGS}
	go tool vet -printf=false ./
	which ${GOMETALINTERBIN} >/dev/null
	$(GOMETALINTER) ./... | sort ; exit "$${PIPESTATUS[0]}"
.PHONY: test

install:
	@$(ECHO) "[Installing ${PACK} package to ${INSTALLDIR}:]"
	mkdir -p ${INSTALLDIR}
	cp ${PACKDIR}/VERSION ${INSTALLDIR}                     # remember the version we gen'd this from.
	cp -r ${PACKDIR}/.lumi/bin/* ${INSTALLDIR}              # copy the binary/metadata.
	cp ${TFBRIDGE_BIN} ${INSTALLDIR}/${LUMIPLUG}-${PACK}    # bring along the Lumi plugin.
	cp ${PACKDIR}/package.json ${INSTALLDIR}                # ensure the result is a proper NPM package.
	cp -r ${PACKDIR}/node_modules ${INSTALLDIR}             # keep the links we installed.
	cd ${INSTALLDIR} && yarn link --force                   # make the pack easily available for devs.
.PHONY: install

clean:
	rm -rf ${LUMILIB}/$$(basename $$pack) ; \
.PHONY: clean

