// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws
{
    /// <summary>
    /// The provider type for the aws package. By default, resources use package-wide configuration
    /// settings, however an explicit `Provider` instance may be created and passed during resource
    /// construction to achieve fine-grained programmatic control over provider settings. See the
    /// [documentation](https://www.pulumi.com/docs/reference/programming-model/#providers) for more information.
    /// </summary>
    [AwsResourceType("pulumi:providers:aws")]
    public partial class Provider : global::Pulumi.ProviderResource
    {
        /// <summary>
        /// The access key for API operations. You can retrieve this from the 'Security &amp; Credentials' section of the AWS console.
        /// </summary>
        [Output("accessKey")]
        public Output<string?> AccessKey { get; private set; } = null!;

        /// <summary>
        /// File containing custom root and intermediate certificates. Can also be configured using the `AWS_CA_BUNDLE` environment
        /// variable. (Setting `ca_bundle` in the shared config file is not supported.)
        /// </summary>
        [Output("customCaBundle")]
        public Output<string?> CustomCaBundle { get; private set; } = null!;

        /// <summary>
        /// Address of the EC2 metadata service endpoint to use. Can also be configured using the
        /// `AWS_EC2_METADATA_SERVICE_ENDPOINT` environment variable.
        /// </summary>
        [Output("ec2MetadataServiceEndpoint")]
        public Output<string?> Ec2MetadataServiceEndpoint { get; private set; } = null!;

        /// <summary>
        /// Protocol to use with EC2 metadata service endpoint.Valid values are `IPv4` and `IPv6`. Can also be configured using the
        /// `AWS_EC2_METADATA_SERVICE_ENDPOINT_MODE` environment variable.
        /// </summary>
        [Output("ec2MetadataServiceEndpointMode")]
        public Output<string?> Ec2MetadataServiceEndpointMode { get; private set; } = null!;

        /// <summary>
        /// URL of a proxy to use for HTTP requests when accessing the AWS API. Can also be set using the `HTTP_PROXY` or
        /// `http_proxy` environment variables.
        /// </summary>
        [Output("httpProxy")]
        public Output<string?> HttpProxy { get; private set; } = null!;

        /// <summary>
        /// URL of a proxy to use for HTTPS requests when accessing the AWS API. Can also be set using the `HTTPS_PROXY` or
        /// `https_proxy` environment variables.
        /// </summary>
        [Output("httpsProxy")]
        public Output<string?> HttpsProxy { get; private set; } = null!;

        /// <summary>
        /// Comma-separated list of hosts that should not use HTTP or HTTPS proxies. Can also be set using the `NO_PROXY` or
        /// `no_proxy` environment variables.
        /// </summary>
        [Output("noProxy")]
        public Output<string?> NoProxy { get; private set; } = null!;

        /// <summary>
        /// The profile for API operations. If not set, the default profile created with `aws configure` will be used.
        /// </summary>
        [Output("profile")]
        public Output<string?> Profile { get; private set; } = null!;

        /// <summary>
        /// The region where AWS operations will take place. Examples are us-east-1, us-west-2, etc.
        /// </summary>
        [Output("region")]
        public Output<string?> Region { get; private set; } = null!;

        /// <summary>
        /// Specifies how retries are attempted. Valid values are `standard` and `adaptive`. Can also be configured using the
        /// `AWS_RETRY_MODE` environment variable.
        /// </summary>
        [Output("retryMode")]
        public Output<string?> RetryMode { get; private set; } = null!;

        /// <summary>
        /// Specifies whether S3 API calls in the `us-east-1` region use the legacy global endpoint or a regional endpoint. Valid
        /// values are `legacy` or `regional`. Can also be configured using the `AWS_S3_US_EAST_1_REGIONAL_ENDPOINT` environment
        /// variable or the `s3_us_east_1_regional_endpoint` shared config file parameter
        /// </summary>
        [Output("s3UsEast1RegionalEndpoint")]
        public Output<string?> S3UsEast1RegionalEndpoint { get; private set; } = null!;

        /// <summary>
        /// The secret key for API operations. You can retrieve this from the 'Security &amp; Credentials' section of the AWS console.
        /// </summary>
        [Output("secretKey")]
        public Output<string?> SecretKey { get; private set; } = null!;

        /// <summary>
        /// The region where AWS STS operations will take place. Examples are us-east-1 and us-west-2.
        /// </summary>
        [Output("stsRegion")]
        public Output<string?> StsRegion { get; private set; } = null!;

        /// <summary>
        /// session token. A session token is only required if you are using temporary security credentials.
        /// </summary>
        [Output("token")]
        public Output<string?> Token { get; private set; } = null!;


        /// <summary>
        /// Create a Provider resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Provider(string name, ProviderArgs? args = null, CustomResourceOptions? options = null)
            : base("aws", name, args ?? new ProviderArgs(), MakeResourceOptions(options, ""))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
                AdditionalSecretOutputs =
                {
                    "accessKey",
                    "secretKey",
                    "token",
                },
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }

        /// <summary>
        /// This function returns a Terraform config object with terraform-namecased keys,to be used with the Terraform Module Provider.
        /// </summary>
        public global::Pulumi.Output<ProviderTerraformConfigResult> TerraformConfig()
            => global::Pulumi.Deployment.Instance.Call<ProviderTerraformConfigResult>("pulumi:providers:aws/terraformConfig", CallArgs.Empty, this);
    }

    public sealed class ProviderArgs : global::Pulumi.ResourceArgs
    {
        [Input("accessKey")]
        private Input<string>? _accessKey;

        /// <summary>
        /// The access key for API operations. You can retrieve this from the 'Security &amp; Credentials' section of the AWS console.
        /// </summary>
        public Input<string>? AccessKey
        {
            get => _accessKey;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _accessKey = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        [Input("allowedAccountIds", json: true)]
        private InputList<string>? _allowedAccountIds;
        public InputList<string> AllowedAccountIds
        {
            get => _allowedAccountIds ?? (_allowedAccountIds = new InputList<string>());
            set => _allowedAccountIds = value;
        }

        [Input("assumeRole", json: true)]
        public Input<Inputs.ProviderAssumeRoleArgs>? AssumeRole { get; set; }

        [Input("assumeRoleWithWebIdentity", json: true)]
        public Input<Inputs.ProviderAssumeRoleWithWebIdentityArgs>? AssumeRoleWithWebIdentity { get; set; }

        /// <summary>
        /// File containing custom root and intermediate certificates. Can also be configured using the `AWS_CA_BUNDLE` environment
        /// variable. (Setting `ca_bundle` in the shared config file is not supported.)
        /// </summary>
        [Input("customCaBundle")]
        public Input<string>? CustomCaBundle { get; set; }

        /// <summary>
        /// Configuration block with settings to default resource tags across all resources.
        /// </summary>
        [Input("defaultTags", json: true)]
        public Input<Inputs.ProviderDefaultTagsArgs>? DefaultTags { get; set; }

        /// <summary>
        /// Address of the EC2 metadata service endpoint to use. Can also be configured using the
        /// `AWS_EC2_METADATA_SERVICE_ENDPOINT` environment variable.
        /// </summary>
        [Input("ec2MetadataServiceEndpoint")]
        public Input<string>? Ec2MetadataServiceEndpoint { get; set; }

        /// <summary>
        /// Protocol to use with EC2 metadata service endpoint.Valid values are `IPv4` and `IPv6`. Can also be configured using the
        /// `AWS_EC2_METADATA_SERVICE_ENDPOINT_MODE` environment variable.
        /// </summary>
        [Input("ec2MetadataServiceEndpointMode")]
        public Input<string>? Ec2MetadataServiceEndpointMode { get; set; }

        [Input("endpoints", json: true)]
        private InputList<Inputs.ProviderEndpointArgs>? _endpoints;
        public InputList<Inputs.ProviderEndpointArgs> Endpoints
        {
            get => _endpoints ?? (_endpoints = new InputList<Inputs.ProviderEndpointArgs>());
            set => _endpoints = value;
        }

        [Input("forbiddenAccountIds", json: true)]
        private InputList<string>? _forbiddenAccountIds;
        public InputList<string> ForbiddenAccountIds
        {
            get => _forbiddenAccountIds ?? (_forbiddenAccountIds = new InputList<string>());
            set => _forbiddenAccountIds = value;
        }

        /// <summary>
        /// URL of a proxy to use for HTTP requests when accessing the AWS API. Can also be set using the `HTTP_PROXY` or
        /// `http_proxy` environment variables.
        /// </summary>
        [Input("httpProxy")]
        public Input<string>? HttpProxy { get; set; }

        /// <summary>
        /// URL of a proxy to use for HTTPS requests when accessing the AWS API. Can also be set using the `HTTPS_PROXY` or
        /// `https_proxy` environment variables.
        /// </summary>
        [Input("httpsProxy")]
        public Input<string>? HttpsProxy { get; set; }

        /// <summary>
        /// Configuration block with settings to ignore resource tags across all resources.
        /// </summary>
        [Input("ignoreTags", json: true)]
        public Input<Inputs.ProviderIgnoreTagsArgs>? IgnoreTags { get; set; }

        /// <summary>
        /// Explicitly allow the provider to perform "insecure" SSL requests. If omitted, default value is `false`
        /// </summary>
        [Input("insecure", json: true)]
        public Input<bool>? Insecure { get; set; }

        /// <summary>
        /// The maximum number of times an AWS API request is being executed. If the API request still fails, an error is thrown.
        /// </summary>
        [Input("maxRetries", json: true)]
        public Input<int>? MaxRetries { get; set; }

        /// <summary>
        /// Comma-separated list of hosts that should not use HTTP or HTTPS proxies. Can also be set using the `NO_PROXY` or
        /// `no_proxy` environment variables.
        /// </summary>
        [Input("noProxy")]
        public Input<string>? NoProxy { get; set; }

        /// <summary>
        /// The profile for API operations. If not set, the default profile created with `aws configure` will be used.
        /// </summary>
        [Input("profile")]
        public Input<string>? Profile { get; set; }

        /// <summary>
        /// The region where AWS operations will take place. Examples are us-east-1, us-west-2, etc.
        /// </summary>
        [Input("region")]
        public Input<string>? Region { get; set; }

        /// <summary>
        /// Specifies how retries are attempted. Valid values are `standard` and `adaptive`. Can also be configured using the
        /// `AWS_RETRY_MODE` environment variable.
        /// </summary>
        [Input("retryMode")]
        public Input<string>? RetryMode { get; set; }

        /// <summary>
        /// Specifies whether S3 API calls in the `us-east-1` region use the legacy global endpoint or a regional endpoint. Valid
        /// values are `legacy` or `regional`. Can also be configured using the `AWS_S3_US_EAST_1_REGIONAL_ENDPOINT` environment
        /// variable or the `s3_us_east_1_regional_endpoint` shared config file parameter
        /// </summary>
        [Input("s3UsEast1RegionalEndpoint")]
        public Input<string>? S3UsEast1RegionalEndpoint { get; set; }

        /// <summary>
        /// Set this to true to enable the request to use path-style addressing, i.e., https://s3.amazonaws.com/BUCKET/KEY. By
        /// default, the S3 client will use virtual hosted bucket addressing when possible (https://BUCKET.s3.amazonaws.com/KEY).
        /// Specific to the Amazon S3 service.
        /// </summary>
        [Input("s3UsePathStyle", json: true)]
        public Input<bool>? S3UsePathStyle { get; set; }

        [Input("secretKey")]
        private Input<string>? _secretKey;

        /// <summary>
        /// The secret key for API operations. You can retrieve this from the 'Security &amp; Credentials' section of the AWS console.
        /// </summary>
        public Input<string>? SecretKey
        {
            get => _secretKey;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _secretKey = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        [Input("sharedConfigFiles", json: true)]
        private InputList<string>? _sharedConfigFiles;

        /// <summary>
        /// List of paths to shared config files. If not set, defaults to [~/.aws/config].
        /// </summary>
        public InputList<string> SharedConfigFiles
        {
            get => _sharedConfigFiles ?? (_sharedConfigFiles = new InputList<string>());
            set => _sharedConfigFiles = value;
        }

        [Input("sharedCredentialsFiles", json: true)]
        private InputList<string>? _sharedCredentialsFiles;

        /// <summary>
        /// List of paths to shared credentials files. If not set, defaults to [~/.aws/credentials].
        /// </summary>
        public InputList<string> SharedCredentialsFiles
        {
            get => _sharedCredentialsFiles ?? (_sharedCredentialsFiles = new InputList<string>());
            set => _sharedCredentialsFiles = value;
        }

        /// <summary>
        /// Skip the credentials validation via STS API. Used for AWS API implementations that do not have STS
        /// available/implemented.
        /// </summary>
        [Input("skipCredentialsValidation", json: true)]
        public Input<bool>? SkipCredentialsValidation { get; set; }

        /// <summary>
        /// Skip the AWS Metadata API check. Used for AWS API implementations that do not have a metadata api endpoint.
        /// </summary>
        [Input("skipMetadataApiCheck", json: true)]
        public Input<bool>? SkipMetadataApiCheck { get; set; }

        /// <summary>
        /// Skip static validation of region name. Used by users of alternative AWS-like APIs or users w/ access to regions that are
        /// not public (yet).
        /// </summary>
        [Input("skipRegionValidation", json: true)]
        public Input<bool>? SkipRegionValidation { get; set; }

        /// <summary>
        /// Skip requesting the account ID. Used for AWS API implementations that do not have IAM/STS API and/or metadata API.
        /// </summary>
        [Input("skipRequestingAccountId", json: true)]
        public Input<bool>? SkipRequestingAccountId { get; set; }

        /// <summary>
        /// The region where AWS STS operations will take place. Examples are us-east-1 and us-west-2.
        /// </summary>
        [Input("stsRegion")]
        public Input<string>? StsRegion { get; set; }

        [Input("token")]
        private Input<string>? _token;

        /// <summary>
        /// session token. A session token is only required if you are using temporary security credentials.
        /// </summary>
        public Input<string>? Token
        {
            get => _token;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _token = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// The capacity of the AWS SDK's token bucket rate limiter.
        /// </summary>
        [Input("tokenBucketRateLimiterCapacity", json: true)]
        public Input<int>? TokenBucketRateLimiterCapacity { get; set; }

        /// <summary>
        /// Resolve an endpoint with DualStack capability
        /// </summary>
        [Input("useDualstackEndpoint", json: true)]
        public Input<bool>? UseDualstackEndpoint { get; set; }

        /// <summary>
        /// Resolve an endpoint with FIPS capability
        /// </summary>
        [Input("useFipsEndpoint", json: true)]
        public Input<bool>? UseFipsEndpoint { get; set; }

        public ProviderArgs()
        {
            Region = Utilities.GetEnv("AWS_REGION", "AWS_DEFAULT_REGION");
            SkipCredentialsValidation = false;
            SkipRegionValidation = true;
        }
        public static new ProviderArgs Empty => new ProviderArgs();
    }

    /// <summary>
    /// The results of the <see cref="Provider.TerraformConfig"/> method.
    /// </summary>
    [OutputType]
    public sealed class ProviderTerraformConfigResult
    {
        public readonly ImmutableDictionary<string, object> Result;

        [OutputConstructor]
        private ProviderTerraformConfigResult(ImmutableDictionary<string, object> result)
        {
            Result = result;
        }
    }
}
