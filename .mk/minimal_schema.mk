minimal_schema:		tfgen minimal_schema_no_deps

minimal_schema_no_deps:
	echo "Computing minimal schema"
	cd provider/cmd/pulumi-resource-aws && PULUMI_AWS_MINIMAL_SCHEMA=true VERSION=$(VERSION_GENERIC) go generate

# To work around CI limitations, ensure that minimal schema is rebuilt for embedding right before the provider binary is
# built for a given platform.
provider_dist-linux-amd64: minimal_schema_no_deps
provider_dist-linux-arm64: minimal_schema_no_deps
provider_dist-darwin-amd64: minimal_schema_no_deps
provider_dist-darwin-arm64: minimal_schema_no_deps
provider_dist-windows-amd64: minimal_schema_no_deps
