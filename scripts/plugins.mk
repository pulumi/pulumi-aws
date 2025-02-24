# Install Pulumi and plugins required at build time.
install_plugins: .make/install_plugins
.make/install_plugins: export PULUMI_HOME := $(WORKING_DIR)/.pulumi
.make/install_plugins: export PATH := $(WORKING_DIR)/.pulumi/bin:$(PATH)
.make/install_plugins: .pulumi/bin/pulumi
	.pulumi/bin/pulumi plugin install resource archive 0.0.1
	.pulumi/bin/pulumi plugin install resource tls 4.10.0
	.pulumi/bin/pulumi plugin install resource github 4.10.0
	.pulumi/bin/pulumi plugin install resource kubernetes 4.11.0
	.pulumi/bin/pulumi plugin install resource null 0.0.3
	.pulumi/bin/pulumi plugin install resource local 0.1.0
	.pulumi/bin/pulumi plugin install resource random 4.8.2
	.pulumi/bin/pulumi plugin install resource github 5.14.0
	.pulumi/bin/pulumi plugin install resource std 1.6.2
	.pulumi/bin/pulumi plugin install converter terraform 1.0.17
	@touch $@
.PHONY: install_plugins

# Because some codegen depends on the version of the CLI used, we install a local CLI
# version pinned to the same version as the provider `go.mod`.
#
# This logic compares the version of .pulumi/bin/pulumi already installed. If it matches
# the desired version, we just print. Otherwise we (re)install pulumi at the desired
# version.
.pulumi/bin/pulumi: .pulumi/version
	@if [ -x .pulumi/bin/pulumi ] && [ "v$$(cat .pulumi/version)" = "$$(.pulumi/bin/pulumi version)" ]; then \
		echo "pulumi/bin/pulumi version: v$$(cat .pulumi/version)"; \
		touch $@; \
	else \
		curl -fsSL https://get.pulumi.com | \
			HOME=$(WORKING_DIR) sh -s -- --version "$$(cat .pulumi/version)"; \
	fi

# Compute the version of Pulumi to use by inspecting the Go dependencies of the provider.
.pulumi/version: provider/go.mod
	(cd provider && go list -f "{{slice .Version 1}}" -m github.com/pulumi/pulumi/pkg/v3) | tee $@
