module github.com/hashicorp/terraform-provider-aws/shim

go 1.18

require (
	github.com/hashicorp/terraform-plugin-sdk/v2 v2.23.0
	github.com/hashicorp/terraform-provider-aws v1.60.1-0.20220923175450-ca71523cdc36
)

replace github.com/hashicorp/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v1.38.1-0.20221018102234-4da7991d3c2a

require (
	github.com/ProtonMail/go-crypto v0.0.0-20210428141323-04723f9f07d7 // indirect
	github.com/agext/levenshtein v1.2.2 // indirect
	github.com/apparentlymart/go-textseg/v13 v13.0.0 // indirect
	github.com/aws/aws-sdk-go v1.44.114 // indirect
	github.com/aws/aws-sdk-go-v2 v1.16.16 // indirect
	github.com/aws/aws-sdk-go-v2/config v1.15.4 // indirect
	github.com/aws/aws-sdk-go-v2/credentials v1.12.0 // indirect
	github.com/aws/aws-sdk-go-v2/feature/ec2/imds v1.12.17 // indirect
	github.com/aws/aws-sdk-go-v2/internal/configsources v1.1.23 // indirect
	github.com/aws/aws-sdk-go-v2/internal/endpoints/v2 v2.4.17 // indirect
	github.com/aws/aws-sdk-go-v2/internal/ini v1.3.11 // indirect
	github.com/aws/aws-sdk-go-v2/service/comprehend v1.19.0 // indirect
	github.com/aws/aws-sdk-go-v2/service/fis v1.13.1 // indirect
	github.com/aws/aws-sdk-go-v2/service/iam v1.18.4 // indirect
	github.com/aws/aws-sdk-go-v2/service/identitystore v1.15.5 // indirect
	github.com/aws/aws-sdk-go-v2/service/inspector2 v1.8.1 // indirect
	github.com/aws/aws-sdk-go-v2/service/internal/presigned-url v1.9.4 // indirect
	github.com/aws/aws-sdk-go-v2/service/internal/s3shared v1.13.17 // indirect
	github.com/aws/aws-sdk-go-v2/service/kendra v1.35.0 // indirect
	github.com/aws/aws-sdk-go-v2/service/medialive v1.23.1 // indirect
	github.com/aws/aws-sdk-go-v2/service/rolesanywhere v1.0.10 // indirect
	github.com/aws/aws-sdk-go-v2/service/route53domains v1.12.17 // indirect
	github.com/aws/aws-sdk-go-v2/service/s3control v1.24.0 // indirect
	github.com/aws/aws-sdk-go-v2/service/sesv2 v1.13.18 // indirect
	github.com/aws/aws-sdk-go-v2/service/sso v1.11.4 // indirect
	github.com/aws/aws-sdk-go-v2/service/sts v1.16.4 // indirect
	github.com/aws/aws-sdk-go-v2/service/transcribe v1.21.9 // indirect
	github.com/aws/smithy-go v1.13.3 // indirect
	github.com/beevik/etree v1.1.0 // indirect
	github.com/davecgh/go-spew v1.1.1 // indirect
	github.com/fatih/color v1.13.0 // indirect
	github.com/golang/protobuf v1.5.2 // indirect
	github.com/google/go-cmp v0.5.9 // indirect
	github.com/hashicorp/aws-cloudformation-resource-schema-sdk-go v0.18.0 // indirect
	github.com/hashicorp/aws-sdk-go-base v1.1.0 // indirect
	github.com/hashicorp/aws-sdk-go-base/v2 v2.0.0-beta.17 // indirect
	github.com/hashicorp/aws-sdk-go-base/v2/awsv1shim/v2 v2.0.0-beta.18 // indirect
	github.com/hashicorp/awspolicyequivalence v1.6.0 // indirect
	github.com/hashicorp/errwrap v1.1.0 // indirect
	github.com/hashicorp/go-checkpoint v0.5.0 // indirect
	github.com/hashicorp/go-cleanhttp v0.5.2 // indirect
	github.com/hashicorp/go-cty v1.4.1-0.20200414143053-d3edf31b6320 // indirect
	github.com/hashicorp/go-hclog v1.2.1 // indirect
	github.com/hashicorp/go-multierror v1.1.1 // indirect
	github.com/hashicorp/go-plugin v1.4.4 // indirect
	github.com/hashicorp/go-uuid v1.0.3 // indirect
	github.com/hashicorp/go-version v1.6.0 // indirect
	github.com/hashicorp/hc-install v0.4.0 // indirect
	github.com/hashicorp/hcl/v2 v2.14.1 // indirect
	github.com/hashicorp/logutils v1.0.0 // indirect
	github.com/hashicorp/terraform-exec v0.17.3 // indirect
	github.com/hashicorp/terraform-json v0.14.0 // indirect
	github.com/hashicorp/terraform-plugin-framework v0.14.0 // indirect
	github.com/hashicorp/terraform-plugin-framework-validators v0.5.0 // indirect
	github.com/hashicorp/terraform-plugin-go v0.14.0 // indirect
	github.com/hashicorp/terraform-plugin-log v0.7.0 // indirect
	github.com/hashicorp/terraform-plugin-mux v0.7.0 // indirect
	github.com/hashicorp/terraform-registry-address v0.0.0-20220623143253-7d51757b572c // indirect
	github.com/hashicorp/terraform-svchost v0.0.0-20200729002733-f050f53b9734 // indirect
	github.com/hashicorp/yamux v0.0.0-20181012175058-2f1d1f20f75d // indirect
	github.com/jmespath/go-jmespath v0.4.0 // indirect
	github.com/mattbaird/jsonpatch v0.0.0-20200820163806-098863c1fc24 // indirect
	github.com/mattn/go-colorable v0.1.12 // indirect
	github.com/mattn/go-isatty v0.0.14 // indirect
	github.com/mitchellh/copystructure v1.2.0 // indirect
	github.com/mitchellh/go-homedir v1.1.0 // indirect
	github.com/mitchellh/go-testing-interface v1.14.1 // indirect
	github.com/mitchellh/go-wordwrap v1.0.0 // indirect
	github.com/mitchellh/mapstructure v1.5.0 // indirect
	github.com/mitchellh/reflectwalk v1.0.2 // indirect
	github.com/oklog/run v1.0.0 // indirect
	github.com/shopspring/decimal v1.3.1 // indirect
	github.com/vmihailenco/msgpack v4.0.4+incompatible // indirect
	github.com/vmihailenco/msgpack/v4 v4.3.12 // indirect
	github.com/vmihailenco/tagparser v0.1.2 // indirect
	github.com/xeipuuv/gojsonpointer v0.0.0-20180127040702-4e3ac2762d5f // indirect
	github.com/xeipuuv/gojsonreference v0.0.0-20180127040603-bd5ef7bd5415 // indirect
	github.com/xeipuuv/gojsonschema v1.2.0 // indirect
	github.com/zclconf/go-cty v1.11.0 // indirect
	golang.org/x/crypto v0.0.0-20220517005047-85d78b3ac167 // indirect
	golang.org/x/exp v0.0.0-20220722155223-a9213eeb770e // indirect
	golang.org/x/net v0.0.0-20220722155237-a158d28d115b // indirect
	golang.org/x/sys v0.0.0-20220722155257-8c9f86f7a55f // indirect
	golang.org/x/text v0.3.7 // indirect
	google.golang.org/appengine v1.6.7 // indirect
	google.golang.org/genproto v0.0.0-20200711021454-869866162049 // indirect
	google.golang.org/grpc v1.48.0 // indirect
	google.golang.org/protobuf v1.28.1 // indirect
	gopkg.in/yaml.v2 v2.4.0 // indirect
)
