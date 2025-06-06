// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFront
{
    /// <summary>
    /// Provides a CloudFront response headers policy resource.
    /// A response headers policy contains information about a set of HTTP response headers and their values.
    /// After you create a response headers policy, you can use its ID to attach it to one or more cache behaviors in a CloudFront distribution.
    /// When it’s attached to a cache behavior, CloudFront adds the headers in the policy to every response that it sends for requests that match the cache behavior.
    /// 
    /// ## Example Usage
    /// 
    /// The example below creates a CloudFront response headers policy.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.CloudFront.ResponseHeadersPolicy("example", new()
    ///     {
    ///         Name = "example-policy",
    ///         Comment = "test comment",
    ///         CorsConfig = new Aws.CloudFront.Inputs.ResponseHeadersPolicyCorsConfigArgs
    ///         {
    ///             AccessControlAllowCredentials = true,
    ///             AccessControlAllowHeaders = new Aws.CloudFront.Inputs.ResponseHeadersPolicyCorsConfigAccessControlAllowHeadersArgs
    ///             {
    ///                 Items = new[]
    ///                 {
    ///                     "test",
    ///                 },
    ///             },
    ///             AccessControlAllowMethods = new Aws.CloudFront.Inputs.ResponseHeadersPolicyCorsConfigAccessControlAllowMethodsArgs
    ///             {
    ///                 Items = new[]
    ///                 {
    ///                     "GET",
    ///                 },
    ///             },
    ///             AccessControlAllowOrigins = new Aws.CloudFront.Inputs.ResponseHeadersPolicyCorsConfigAccessControlAllowOriginsArgs
    ///             {
    ///                 Items = new[]
    ///                 {
    ///                     "test.example.comtest",
    ///                 },
    ///             },
    ///             OriginOverride = true,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// The example below creates a CloudFront response headers policy with a custom headers config.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.CloudFront.ResponseHeadersPolicy("example", new()
    ///     {
    ///         Name = "example-headers-policy",
    ///         CustomHeadersConfig = new Aws.CloudFront.Inputs.ResponseHeadersPolicyCustomHeadersConfigArgs
    ///         {
    ///             Items = new[]
    ///             {
    ///                 new Aws.CloudFront.Inputs.ResponseHeadersPolicyCustomHeadersConfigItemArgs
    ///                 {
    ///                     Header = "X-Permitted-Cross-Domain-Policies",
    ///                     Override = true,
    ///                     Value = "none",
    ///                 },
    ///                 new Aws.CloudFront.Inputs.ResponseHeadersPolicyCustomHeadersConfigItemArgs
    ///                 {
    ///                     Header = "X-Test",
    ///                     Override = true,
    ///                     Value = "none",
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// The example below creates a CloudFront response headers policy with a custom headers config, remove headers config and server timing headers config.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.CloudFront.ResponseHeadersPolicy("example", new()
    ///     {
    ///         Name = "example-headers-policy",
    ///         CustomHeadersConfig = new Aws.CloudFront.Inputs.ResponseHeadersPolicyCustomHeadersConfigArgs
    ///         {
    ///             Items = new[]
    ///             {
    ///                 new Aws.CloudFront.Inputs.ResponseHeadersPolicyCustomHeadersConfigItemArgs
    ///                 {
    ///                     Header = "X-Permitted-Cross-Domain-Policies",
    ///                     Override = true,
    ///                     Value = "none",
    ///                 },
    ///             },
    ///         },
    ///         RemoveHeadersConfig = new Aws.CloudFront.Inputs.ResponseHeadersPolicyRemoveHeadersConfigArgs
    ///         {
    ///             Items = new[]
    ///             {
    ///                 new Aws.CloudFront.Inputs.ResponseHeadersPolicyRemoveHeadersConfigItemArgs
    ///                 {
    ///                     Header = "Set-Cookie",
    ///                 },
    ///             },
    ///         },
    ///         ServerTimingHeadersConfig = new Aws.CloudFront.Inputs.ResponseHeadersPolicyServerTimingHeadersConfigArgs
    ///         {
    ///             Enabled = true,
    ///             SamplingRate = 50,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Cloudfront Response Headers Policies using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:cloudfront/responseHeadersPolicy:ResponseHeadersPolicy policy 658327ea-f89d-4fab-a63d-7e88639e58f9
    /// ```
    /// </summary>
    [AwsResourceType("aws:cloudfront/responseHeadersPolicy:ResponseHeadersPolicy")]
    public partial class ResponseHeadersPolicy : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The response headers policy ARN.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// A comment to describe the response headers policy. The comment cannot be longer than 128 characters.
        /// </summary>
        [Output("comment")]
        public Output<string?> Comment { get; private set; } = null!;

        /// <summary>
        /// A configuration for a set of HTTP response headers that are used for Cross-Origin Resource Sharing (CORS). See Cors Config for more information.
        /// </summary>
        [Output("corsConfig")]
        public Output<Outputs.ResponseHeadersPolicyCorsConfig?> CorsConfig { get; private set; } = null!;

        /// <summary>
        /// Object that contains an attribute `items` that contains a list of custom headers. See Custom Header for more information.
        /// </summary>
        [Output("customHeadersConfig")]
        public Output<Outputs.ResponseHeadersPolicyCustomHeadersConfig?> CustomHeadersConfig { get; private set; } = null!;

        /// <summary>
        /// The current version of the response headers policy.
        /// </summary>
        [Output("etag")]
        public Output<string> Etag { get; private set; } = null!;

        /// <summary>
        /// A unique name to identify the response headers policy.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// A configuration for a set of HTTP headers to remove from the HTTP response. Object that contains an attribute `items` that contains a list of headers. See Remove Header for more information.
        /// </summary>
        [Output("removeHeadersConfig")]
        public Output<Outputs.ResponseHeadersPolicyRemoveHeadersConfig?> RemoveHeadersConfig { get; private set; } = null!;

        /// <summary>
        /// A configuration for a set of security-related HTTP response headers. See Security Headers Config for more information.
        /// </summary>
        [Output("securityHeadersConfig")]
        public Output<Outputs.ResponseHeadersPolicySecurityHeadersConfig?> SecurityHeadersConfig { get; private set; } = null!;

        /// <summary>
        /// A configuration for enabling the Server-Timing header in HTTP responses sent from CloudFront. See Server Timing Headers Config for more information.
        /// </summary>
        [Output("serverTimingHeadersConfig")]
        public Output<Outputs.ResponseHeadersPolicyServerTimingHeadersConfig?> ServerTimingHeadersConfig { get; private set; } = null!;


        /// <summary>
        /// Create a ResponseHeadersPolicy resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ResponseHeadersPolicy(string name, ResponseHeadersPolicyArgs? args = null, CustomResourceOptions? options = null)
            : base("aws:cloudfront/responseHeadersPolicy:ResponseHeadersPolicy", name, args ?? new ResponseHeadersPolicyArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ResponseHeadersPolicy(string name, Input<string> id, ResponseHeadersPolicyState? state = null, CustomResourceOptions? options = null)
            : base("aws:cloudfront/responseHeadersPolicy:ResponseHeadersPolicy", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ResponseHeadersPolicy resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ResponseHeadersPolicy Get(string name, Input<string> id, ResponseHeadersPolicyState? state = null, CustomResourceOptions? options = null)
        {
            return new ResponseHeadersPolicy(name, id, state, options);
        }
    }

    public sealed class ResponseHeadersPolicyArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A comment to describe the response headers policy. The comment cannot be longer than 128 characters.
        /// </summary>
        [Input("comment")]
        public Input<string>? Comment { get; set; }

        /// <summary>
        /// A configuration for a set of HTTP response headers that are used for Cross-Origin Resource Sharing (CORS). See Cors Config for more information.
        /// </summary>
        [Input("corsConfig")]
        public Input<Inputs.ResponseHeadersPolicyCorsConfigArgs>? CorsConfig { get; set; }

        /// <summary>
        /// Object that contains an attribute `items` that contains a list of custom headers. See Custom Header for more information.
        /// </summary>
        [Input("customHeadersConfig")]
        public Input<Inputs.ResponseHeadersPolicyCustomHeadersConfigArgs>? CustomHeadersConfig { get; set; }

        /// <summary>
        /// The current version of the response headers policy.
        /// </summary>
        [Input("etag")]
        public Input<string>? Etag { get; set; }

        /// <summary>
        /// A unique name to identify the response headers policy.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// A configuration for a set of HTTP headers to remove from the HTTP response. Object that contains an attribute `items` that contains a list of headers. See Remove Header for more information.
        /// </summary>
        [Input("removeHeadersConfig")]
        public Input<Inputs.ResponseHeadersPolicyRemoveHeadersConfigArgs>? RemoveHeadersConfig { get; set; }

        /// <summary>
        /// A configuration for a set of security-related HTTP response headers. See Security Headers Config for more information.
        /// </summary>
        [Input("securityHeadersConfig")]
        public Input<Inputs.ResponseHeadersPolicySecurityHeadersConfigArgs>? SecurityHeadersConfig { get; set; }

        /// <summary>
        /// A configuration for enabling the Server-Timing header in HTTP responses sent from CloudFront. See Server Timing Headers Config for more information.
        /// </summary>
        [Input("serverTimingHeadersConfig")]
        public Input<Inputs.ResponseHeadersPolicyServerTimingHeadersConfigArgs>? ServerTimingHeadersConfig { get; set; }

        public ResponseHeadersPolicyArgs()
        {
        }
        public static new ResponseHeadersPolicyArgs Empty => new ResponseHeadersPolicyArgs();
    }

    public sealed class ResponseHeadersPolicyState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The response headers policy ARN.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// A comment to describe the response headers policy. The comment cannot be longer than 128 characters.
        /// </summary>
        [Input("comment")]
        public Input<string>? Comment { get; set; }

        /// <summary>
        /// A configuration for a set of HTTP response headers that are used for Cross-Origin Resource Sharing (CORS). See Cors Config for more information.
        /// </summary>
        [Input("corsConfig")]
        public Input<Inputs.ResponseHeadersPolicyCorsConfigGetArgs>? CorsConfig { get; set; }

        /// <summary>
        /// Object that contains an attribute `items` that contains a list of custom headers. See Custom Header for more information.
        /// </summary>
        [Input("customHeadersConfig")]
        public Input<Inputs.ResponseHeadersPolicyCustomHeadersConfigGetArgs>? CustomHeadersConfig { get; set; }

        /// <summary>
        /// The current version of the response headers policy.
        /// </summary>
        [Input("etag")]
        public Input<string>? Etag { get; set; }

        /// <summary>
        /// A unique name to identify the response headers policy.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// A configuration for a set of HTTP headers to remove from the HTTP response. Object that contains an attribute `items` that contains a list of headers. See Remove Header for more information.
        /// </summary>
        [Input("removeHeadersConfig")]
        public Input<Inputs.ResponseHeadersPolicyRemoveHeadersConfigGetArgs>? RemoveHeadersConfig { get; set; }

        /// <summary>
        /// A configuration for a set of security-related HTTP response headers. See Security Headers Config for more information.
        /// </summary>
        [Input("securityHeadersConfig")]
        public Input<Inputs.ResponseHeadersPolicySecurityHeadersConfigGetArgs>? SecurityHeadersConfig { get; set; }

        /// <summary>
        /// A configuration for enabling the Server-Timing header in HTTP responses sent from CloudFront. See Server Timing Headers Config for more information.
        /// </summary>
        [Input("serverTimingHeadersConfig")]
        public Input<Inputs.ResponseHeadersPolicyServerTimingHeadersConfigGetArgs>? ServerTimingHeadersConfig { get; set; }

        public ResponseHeadersPolicyState()
        {
        }
        public static new ResponseHeadersPolicyState Empty => new ResponseHeadersPolicyState();
    }
}
