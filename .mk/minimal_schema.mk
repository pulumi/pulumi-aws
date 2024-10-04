minimal_schema:		tfgen minimal_schema_no_deps

minimal_schema_no_deps:
	echo "Computing minimal schema"
	cd provider/cmd/pulumi-resource-aws && PULUMI_AWS_MINIMAL_SCHEMA=true VERSION=$(VERSION_GENERIC) go generate
