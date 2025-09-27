# Install Pulumi and plugins required at build time.
install_plugins: .make/install_plugins
.make/install_plugins: export PULUMI_HOME := $(WORKING_DIR)/.pulumi
.make/install_plugins:
	pulumi plugin install resource archive 0.0.1
	pulumi plugin install resource tls 4.10.0
	pulumi plugin install resource github 4.10.0
	pulumi plugin install resource kubernetes 4.11.0
	pulumi plugin install resource null 0.0.3
	pulumi plugin install resource local 0.1.0
	pulumi plugin install resource random 4.8.2
	pulumi plugin install resource github 5.14.0
	pulumi plugin install resource std 1.6.2
	pulumi plugin install converter terraform 1.0.17
	@touch $@
.PHONY: install_plugins
