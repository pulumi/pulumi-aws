minimal_schema:		provider/cmd/pulumi-resource-aws/schema-minimal-embed.json

.PHONY: minimal_schema

provider/cmd/pulumi-resource-aws/schema-minimal-embed.json:	.make/schema
	echo "Computing minimal schema"
	cd provider/cmd/pulumi-resource-aws && PULUMI_AWS_MINIMAL_SCHEMA=true VERSION=$(VERSION_GENERIC) go generate

# In build_provider.yml workflow, minimal schema needs to be rebuilt right before the provider binary.
bin/linux-amd64/$(PROVIDER): minimal_schema_no_deps
bin/linux-arm64/$(PROVIDER): minimal_schema_no_deps
bin/darwin-amd64/$(PROVIDER): minimal_schema_no_deps
bin/darwin-arm64/$(PROVIDER): minimal_schema_no_deps
bin/windows-amd64/$(PROVIDER).exe: minimal_schema_no_deps

# In prerequisites.yml workflow, minimal schema needs to be rebuilt right before the provider binary.
bin/pulumi-resource-aws: minimal_schema_no_deps
