minimal_schema:		provider/cmd/pulumi-resource-aws/schema-minimal-embed.json

.PHONY: minimal_schema

provider/cmd/pulumi-resource-aws/schema-minimal-embed.json:	provider/cmd/pulumi-resource-aws/schema.json
	echo "Computing minimal schema"
	cd provider/cmd/pulumi-resource-aws && PULUMI_AWS_MINIMAL_SCHEMA=true VERSION=$(VERSION_GENERIC) go generate

# In build_provider.yml workflow, minimal schema needs to be rebuilt right before the provider binary.
bin/linux-amd64/$(PROVIDER): minimal_schema
bin/linux-arm64/$(PROVIDER): minimal_schema
bin/darwin-amd64/$(PROVIDER): minimal_schema
bin/darwin-arm64/$(PROVIDER): minimal_schema
bin/windows-amd64/$(PROVIDER).exe: minimal_schema

# In prerequisites.yml workflow, minimal schema needs to be rebuilt right before the provider binary.
bin/pulumi-resource-aws: minimal_schema
