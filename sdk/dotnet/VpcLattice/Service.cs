// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice
{
    /// <summary>
    /// Resource for managing an AWS VPC Lattice Service.
    /// 
    /// ## Example Usage
    /// 
    /// ### Basic Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.VpcLattice.Service("example", new()
    ///     {
    ///         Name = "example",
    ///         AuthType = "AWS_IAM",
    ///         CustomDomainName = "example.com",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import VPC Lattice Service using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:vpclattice/service:Service example svc-06728e2357ea55f8a
    /// ```
    /// </summary>
    [AwsResourceType("aws:vpclattice/service:Service")]
    public partial class Service : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the service.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Type of IAM policy. Either `NONE` or `AWS_IAM`.
        /// </summary>
        [Output("authType")]
        public Output<string> AuthType { get; private set; } = null!;

        /// <summary>
        /// Amazon Resource Name (ARN) of the certificate.
        /// </summary>
        [Output("certificateArn")]
        public Output<string?> CertificateArn { get; private set; } = null!;

        /// <summary>
        /// Custom domain name of the service.
        /// </summary>
        [Output("customDomainName")]
        public Output<string?> CustomDomainName { get; private set; } = null!;

        /// <summary>
        /// DNS name of the service.
        /// </summary>
        [Output("dnsEntries")]
        public Output<ImmutableArray<Outputs.ServiceDnsEntry>> DnsEntries { get; private set; } = null!;

        /// <summary>
        /// Name of the service. The name must be unique within the account. The valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.Must be between 3 and 40 characters in length.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Status of the service.
        /// </summary>
        [Output("status")]
        public Output<string> Status { get; private set; } = null!;

        /// <summary>
        /// Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a Service resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Service(string name, ServiceArgs? args = null, CustomResourceOptions? options = null)
            : base("aws:vpclattice/service:Service", name, args ?? new ServiceArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Service(string name, Input<string> id, ServiceState? state = null, CustomResourceOptions? options = null)
            : base("aws:vpclattice/service:Service", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing Service resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Service Get(string name, Input<string> id, ServiceState? state = null, CustomResourceOptions? options = null)
        {
            return new Service(name, id, state, options);
        }
    }

    public sealed class ServiceArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Type of IAM policy. Either `NONE` or `AWS_IAM`.
        /// </summary>
        [Input("authType")]
        public Input<string>? AuthType { get; set; }

        /// <summary>
        /// Amazon Resource Name (ARN) of the certificate.
        /// </summary>
        [Input("certificateArn")]
        public Input<string>? CertificateArn { get; set; }

        /// <summary>
        /// Custom domain name of the service.
        /// </summary>
        [Input("customDomainName")]
        public Input<string>? CustomDomainName { get; set; }

        /// <summary>
        /// Name of the service. The name must be unique within the account. The valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.Must be between 3 and 40 characters in length.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public ServiceArgs()
        {
        }
        public static new ServiceArgs Empty => new ServiceArgs();
    }

    public sealed class ServiceState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the service.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Type of IAM policy. Either `NONE` or `AWS_IAM`.
        /// </summary>
        [Input("authType")]
        public Input<string>? AuthType { get; set; }

        /// <summary>
        /// Amazon Resource Name (ARN) of the certificate.
        /// </summary>
        [Input("certificateArn")]
        public Input<string>? CertificateArn { get; set; }

        /// <summary>
        /// Custom domain name of the service.
        /// </summary>
        [Input("customDomainName")]
        public Input<string>? CustomDomainName { get; set; }

        [Input("dnsEntries")]
        private InputList<Inputs.ServiceDnsEntryGetArgs>? _dnsEntries;

        /// <summary>
        /// DNS name of the service.
        /// </summary>
        public InputList<Inputs.ServiceDnsEntryGetArgs> DnsEntries
        {
            get => _dnsEntries ?? (_dnsEntries = new InputList<Inputs.ServiceDnsEntryGetArgs>());
            set => _dnsEntries = value;
        }

        /// <summary>
        /// Name of the service. The name must be unique within the account. The valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.Must be between 3 and 40 characters in length.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Status of the service.
        /// </summary>
        [Input("status")]
        public Input<string>? Status { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        public ServiceState()
        {
        }
        public static new ServiceState Empty => new ServiceState();
    }
}
