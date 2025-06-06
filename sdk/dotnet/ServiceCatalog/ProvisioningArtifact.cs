// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ServiceCatalog
{
    /// <summary>
    /// Manages a Service Catalog Provisioning Artifact for a specified product.
    /// 
    /// &gt; A "provisioning artifact" is also referred to as a "version."
    /// 
    /// &gt; **NOTE:** You cannot create a provisioning artifact for a product that was shared with you.
    /// 
    /// &gt; **NOTE:** The user or role that use this resource must have the `cloudformation:GetTemplate` IAM policy permission. This policy permission is required when using the `template_physical_id` argument.
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
    ///     var example = new Aws.ServiceCatalog.ProvisioningArtifact("example", new()
    ///     {
    ///         Name = "example",
    ///         ProductId = exampleAwsServicecatalogProduct.Id,
    ///         Type = "CLOUD_FORMATION_TEMPLATE",
    ///         TemplateUrl = $"https://{exampleAwsS3Bucket.BucketRegionalDomainName}/{exampleAwsS3Object.Key}",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_servicecatalog_provisioning_artifact` using the provisioning artifact ID and product ID separated by a colon. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:servicecatalog/provisioningArtifact:ProvisioningArtifact example pa-ij2b6lusy6dec:prod-el3an0rma3
    /// ```
    /// </summary>
    [AwsResourceType("aws:servicecatalog/provisioningArtifact:ProvisioningArtifact")]
    public partial class ProvisioningArtifact : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Language code. Valid values: `en` (English), `jp` (Japanese), `zh` (Chinese). The default value is `en`.
        /// </summary>
        [Output("acceptLanguage")]
        public Output<string?> AcceptLanguage { get; private set; } = null!;

        /// <summary>
        /// Whether the product version is active. Inactive provisioning artifacts are invisible to end users. End users cannot launch or update a provisioned product from an inactive provisioning artifact. Default is `true`.
        /// </summary>
        [Output("active")]
        public Output<bool?> Active { get; private set; } = null!;

        /// <summary>
        /// Time when the provisioning artifact was created.
        /// </summary>
        [Output("createdTime")]
        public Output<string> CreatedTime { get; private set; } = null!;

        /// <summary>
        /// Description of the provisioning artifact (i.e., version), including how it differs from the previous provisioning artifact.
        /// </summary>
        [Output("description")]
        public Output<string> Description { get; private set; } = null!;

        /// <summary>
        /// Whether AWS Service Catalog stops validating the specified provisioning artifact template even if it is invalid.
        /// </summary>
        [Output("disableTemplateValidation")]
        public Output<bool?> DisableTemplateValidation { get; private set; } = null!;

        /// <summary>
        /// Information set by the administrator to provide guidance to end users about which provisioning artifacts to use. Valid values are `DEFAULT` and `DEPRECATED`. The default is `DEFAULT`. Users are able to make updates to a provisioned product of a deprecated version but cannot launch new provisioned products using a deprecated version.
        /// </summary>
        [Output("guidance")]
        public Output<string?> Guidance { get; private set; } = null!;

        /// <summary>
        /// Name of the provisioning artifact (for example, `v1`, `v2beta`). No spaces are allowed.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Identifier of the product.
        /// </summary>
        [Output("productId")]
        public Output<string> ProductId { get; private set; } = null!;

        /// <summary>
        /// Provisioning artifact identifier.
        /// </summary>
        [Output("provisioningArtifactId")]
        public Output<string> ProvisioningArtifactId { get; private set; } = null!;

        /// <summary>
        /// Template source as the physical ID of the resource that contains the template. Currently only supports CloudFormation stack ARN. Specify the physical ID as `arn:[partition]:cloudformation:[region]:[account ID]:stack/[stack name]/[resource ID]`.
        /// </summary>
        [Output("templatePhysicalId")]
        public Output<string?> TemplatePhysicalId { get; private set; } = null!;

        /// <summary>
        /// Template source as URL of the CloudFormation template in Amazon S3.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("templateUrl")]
        public Output<string?> TemplateUrl { get; private set; } = null!;

        /// <summary>
        /// Type of provisioning artifact. See [AWS Docs](https://docs.aws.amazon.com/servicecatalog/latest/dg/API_ProvisioningArtifactProperties.html) for valid list of values.
        /// </summary>
        [Output("type")]
        public Output<string?> Type { get; private set; } = null!;


        /// <summary>
        /// Create a ProvisioningArtifact resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ProvisioningArtifact(string name, ProvisioningArtifactArgs args, CustomResourceOptions? options = null)
            : base("aws:servicecatalog/provisioningArtifact:ProvisioningArtifact", name, args ?? new ProvisioningArtifactArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ProvisioningArtifact(string name, Input<string> id, ProvisioningArtifactState? state = null, CustomResourceOptions? options = null)
            : base("aws:servicecatalog/provisioningArtifact:ProvisioningArtifact", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ProvisioningArtifact resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ProvisioningArtifact Get(string name, Input<string> id, ProvisioningArtifactState? state = null, CustomResourceOptions? options = null)
        {
            return new ProvisioningArtifact(name, id, state, options);
        }
    }

    public sealed class ProvisioningArtifactArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Language code. Valid values: `en` (English), `jp` (Japanese), `zh` (Chinese). The default value is `en`.
        /// </summary>
        [Input("acceptLanguage")]
        public Input<string>? AcceptLanguage { get; set; }

        /// <summary>
        /// Whether the product version is active. Inactive provisioning artifacts are invisible to end users. End users cannot launch or update a provisioned product from an inactive provisioning artifact. Default is `true`.
        /// </summary>
        [Input("active")]
        public Input<bool>? Active { get; set; }

        /// <summary>
        /// Description of the provisioning artifact (i.e., version), including how it differs from the previous provisioning artifact.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Whether AWS Service Catalog stops validating the specified provisioning artifact template even if it is invalid.
        /// </summary>
        [Input("disableTemplateValidation")]
        public Input<bool>? DisableTemplateValidation { get; set; }

        /// <summary>
        /// Information set by the administrator to provide guidance to end users about which provisioning artifacts to use. Valid values are `DEFAULT` and `DEPRECATED`. The default is `DEFAULT`. Users are able to make updates to a provisioned product of a deprecated version but cannot launch new provisioned products using a deprecated version.
        /// </summary>
        [Input("guidance")]
        public Input<string>? Guidance { get; set; }

        /// <summary>
        /// Name of the provisioning artifact (for example, `v1`, `v2beta`). No spaces are allowed.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Identifier of the product.
        /// </summary>
        [Input("productId", required: true)]
        public Input<string> ProductId { get; set; } = null!;

        /// <summary>
        /// Template source as the physical ID of the resource that contains the template. Currently only supports CloudFormation stack ARN. Specify the physical ID as `arn:[partition]:cloudformation:[region]:[account ID]:stack/[stack name]/[resource ID]`.
        /// </summary>
        [Input("templatePhysicalId")]
        public Input<string>? TemplatePhysicalId { get; set; }

        /// <summary>
        /// Template source as URL of the CloudFormation template in Amazon S3.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("templateUrl")]
        public Input<string>? TemplateUrl { get; set; }

        /// <summary>
        /// Type of provisioning artifact. See [AWS Docs](https://docs.aws.amazon.com/servicecatalog/latest/dg/API_ProvisioningArtifactProperties.html) for valid list of values.
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        public ProvisioningArtifactArgs()
        {
        }
        public static new ProvisioningArtifactArgs Empty => new ProvisioningArtifactArgs();
    }

    public sealed class ProvisioningArtifactState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Language code. Valid values: `en` (English), `jp` (Japanese), `zh` (Chinese). The default value is `en`.
        /// </summary>
        [Input("acceptLanguage")]
        public Input<string>? AcceptLanguage { get; set; }

        /// <summary>
        /// Whether the product version is active. Inactive provisioning artifacts are invisible to end users. End users cannot launch or update a provisioned product from an inactive provisioning artifact. Default is `true`.
        /// </summary>
        [Input("active")]
        public Input<bool>? Active { get; set; }

        /// <summary>
        /// Time when the provisioning artifact was created.
        /// </summary>
        [Input("createdTime")]
        public Input<string>? CreatedTime { get; set; }

        /// <summary>
        /// Description of the provisioning artifact (i.e., version), including how it differs from the previous provisioning artifact.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Whether AWS Service Catalog stops validating the specified provisioning artifact template even if it is invalid.
        /// </summary>
        [Input("disableTemplateValidation")]
        public Input<bool>? DisableTemplateValidation { get; set; }

        /// <summary>
        /// Information set by the administrator to provide guidance to end users about which provisioning artifacts to use. Valid values are `DEFAULT` and `DEPRECATED`. The default is `DEFAULT`. Users are able to make updates to a provisioned product of a deprecated version but cannot launch new provisioned products using a deprecated version.
        /// </summary>
        [Input("guidance")]
        public Input<string>? Guidance { get; set; }

        /// <summary>
        /// Name of the provisioning artifact (for example, `v1`, `v2beta`). No spaces are allowed.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Identifier of the product.
        /// </summary>
        [Input("productId")]
        public Input<string>? ProductId { get; set; }

        /// <summary>
        /// Provisioning artifact identifier.
        /// </summary>
        [Input("provisioningArtifactId")]
        public Input<string>? ProvisioningArtifactId { get; set; }

        /// <summary>
        /// Template source as the physical ID of the resource that contains the template. Currently only supports CloudFormation stack ARN. Specify the physical ID as `arn:[partition]:cloudformation:[region]:[account ID]:stack/[stack name]/[resource ID]`.
        /// </summary>
        [Input("templatePhysicalId")]
        public Input<string>? TemplatePhysicalId { get; set; }

        /// <summary>
        /// Template source as URL of the CloudFormation template in Amazon S3.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("templateUrl")]
        public Input<string>? TemplateUrl { get; set; }

        /// <summary>
        /// Type of provisioning artifact. See [AWS Docs](https://docs.aws.amazon.com/servicecatalog/latest/dg/API_ProvisioningArtifactProperties.html) for valid list of values.
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        public ProvisioningArtifactState()
        {
        }
        public static new ProvisioningArtifactState Empty => new ProvisioningArtifactState();
    }
}
