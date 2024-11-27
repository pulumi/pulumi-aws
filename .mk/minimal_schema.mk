minimal_schema:		tfgen minimal_schema_no_deps

minimal_schema_no_deps:
	echo "Computing minimal schema"
	cd provider/cmd/pulumi-resource-aws && PULUMI_AWS_MINIMAL_SCHEMA=true VERSION=$(VERSION_GENERIC) go generate
.PHONY: minimal_schema minimal_schema_no_deps

# To work around CI limitations, ensure that minimal schema is rebuilt for embedding right before the provider binary is
# built for a given platform.
bin/linux-amd64/$(PROVIDER): minimal_schema_no_deps
bin/linux-arm64/$(PROVIDER): minimal_schema_no_deps
bin/darwin-amd64/$(PROVIDER): minimal_schema_no_deps
bin/darwin-arm64/$(PROVIDER): minimal_schema_no_deps
bin/windows-amd64/$(PROVIDER).exe: minimal_schema_no_deps
provider_no_deps: minimal_schema_no_deps
provider: minimal_schema_no_deps
