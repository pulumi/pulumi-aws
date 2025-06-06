// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.RedshiftServerless
{
    /// <summary>
    /// Resource for managing an AWS Redshift Serverless Custom Domain Association.
    /// 
    /// ## Example Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Acm.Certificate("example", new()
    ///     {
    ///         DomainName = "example.com",
    ///     });
    /// 
    ///     var exampleNamespace = new Aws.RedshiftServerless.Namespace("example", new()
    ///     {
    ///         NamespaceName = "example-namespace",
    ///     });
    /// 
    ///     var exampleWorkgroup = new Aws.RedshiftServerless.Workgroup("example", new()
    ///     {
    ///         WorkgroupName = "example-workgroup",
    ///         NamespaceName = exampleNamespace.NamespaceName,
    ///     });
    /// 
    ///     var exampleCustomDomainAssociation = new Aws.RedshiftServerless.CustomDomainAssociation("example", new()
    ///     {
    ///         WorkgroupName = exampleWorkgroup.WorkgroupName,
    ///         CustomDomainName = "example.com",
    ///         CustomDomainCertificateArn = example.Arn,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Redshift Serverless Custom Domain Association using the `workgroup_name` and `custom_domain_name`, separated by the coma. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:redshiftserverless/customDomainAssociation:CustomDomainAssociation example example-workgroup,example.com
    /// ```
    /// </summary>
    [AwsResourceType("aws:redshiftserverless/customDomainAssociation:CustomDomainAssociation")]
    public partial class CustomDomainAssociation : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the certificate for the custom domain association.
        /// </summary>
        [Output("customDomainCertificateArn")]
        public Output<string> CustomDomainCertificateArn { get; private set; } = null!;

        /// <summary>
        /// Expiration time for the certificate.
        /// </summary>
        [Output("customDomainCertificateExpiryTime")]
        public Output<string> CustomDomainCertificateExpiryTime { get; private set; } = null!;

        /// <summary>
        /// Custom domain to associate with the workgroup.
        /// </summary>
        [Output("customDomainName")]
        public Output<string> CustomDomainName { get; private set; } = null!;

        /// <summary>
        /// Name of the workgroup.
        /// </summary>
        [Output("workgroupName")]
        public Output<string> WorkgroupName { get; private set; } = null!;


        /// <summary>
        /// Create a CustomDomainAssociation resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public CustomDomainAssociation(string name, CustomDomainAssociationArgs args, CustomResourceOptions? options = null)
            : base("aws:redshiftserverless/customDomainAssociation:CustomDomainAssociation", name, args ?? new CustomDomainAssociationArgs(), MakeResourceOptions(options, ""))
        {
        }

        private CustomDomainAssociation(string name, Input<string> id, CustomDomainAssociationState? state = null, CustomResourceOptions? options = null)
            : base("aws:redshiftserverless/customDomainAssociation:CustomDomainAssociation", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing CustomDomainAssociation resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static CustomDomainAssociation Get(string name, Input<string> id, CustomDomainAssociationState? state = null, CustomResourceOptions? options = null)
        {
            return new CustomDomainAssociation(name, id, state, options);
        }
    }

    public sealed class CustomDomainAssociationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the certificate for the custom domain association.
        /// </summary>
        [Input("customDomainCertificateArn", required: true)]
        public Input<string> CustomDomainCertificateArn { get; set; } = null!;

        /// <summary>
        /// Custom domain to associate with the workgroup.
        /// </summary>
        [Input("customDomainName", required: true)]
        public Input<string> CustomDomainName { get; set; } = null!;

        /// <summary>
        /// Name of the workgroup.
        /// </summary>
        [Input("workgroupName", required: true)]
        public Input<string> WorkgroupName { get; set; } = null!;

        public CustomDomainAssociationArgs()
        {
        }
        public static new CustomDomainAssociationArgs Empty => new CustomDomainAssociationArgs();
    }

    public sealed class CustomDomainAssociationState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the certificate for the custom domain association.
        /// </summary>
        [Input("customDomainCertificateArn")]
        public Input<string>? CustomDomainCertificateArn { get; set; }

        /// <summary>
        /// Expiration time for the certificate.
        /// </summary>
        [Input("customDomainCertificateExpiryTime")]
        public Input<string>? CustomDomainCertificateExpiryTime { get; set; }

        /// <summary>
        /// Custom domain to associate with the workgroup.
        /// </summary>
        [Input("customDomainName")]
        public Input<string>? CustomDomainName { get; set; }

        /// <summary>
        /// Name of the workgroup.
        /// </summary>
        [Input("workgroupName")]
        public Input<string>? WorkgroupName { get; set; }

        public CustomDomainAssociationState()
        {
        }
        public static new CustomDomainAssociationState Empty => new CustomDomainAssociationState();
    }
}
