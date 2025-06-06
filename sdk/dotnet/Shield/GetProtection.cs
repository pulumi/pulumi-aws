// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Shield
{
    public static class GetProtection
    {
        /// <summary>
        /// Data source for managing an AWS Shield Protection.
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
        ///     var example = Aws.Shield.GetProtection.Invoke(new()
        ///     {
        ///         ProtectionId = "abc123",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ### By Resource ARN
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Shield.GetProtection.Invoke(new()
        ///     {
        ///         ResourceArn = "arn:aws:globalaccelerator::123456789012:accelerator/1234abcd-abcd-1234-abcd-1234abcdefgh",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetProtectionResult> InvokeAsync(GetProtectionArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetProtectionResult>("aws:shield/getProtection:getProtection", args ?? new GetProtectionArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS Shield Protection.
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
        ///     var example = Aws.Shield.GetProtection.Invoke(new()
        ///     {
        ///         ProtectionId = "abc123",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ### By Resource ARN
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Shield.GetProtection.Invoke(new()
        ///     {
        ///         ResourceArn = "arn:aws:globalaccelerator::123456789012:accelerator/1234abcd-abcd-1234-abcd-1234abcdefgh",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetProtectionResult> Invoke(GetProtectionInvokeArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetProtectionResult>("aws:shield/getProtection:getProtection", args ?? new GetProtectionInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS Shield Protection.
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
        ///     var example = Aws.Shield.GetProtection.Invoke(new()
        ///     {
        ///         ProtectionId = "abc123",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ### By Resource ARN
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Shield.GetProtection.Invoke(new()
        ///     {
        ///         ResourceArn = "arn:aws:globalaccelerator::123456789012:accelerator/1234abcd-abcd-1234-abcd-1234abcdefgh",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetProtectionResult> Invoke(GetProtectionInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetProtectionResult>("aws:shield/getProtection:getProtection", args ?? new GetProtectionInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetProtectionArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Unique identifier for the protection.
        /// </summary>
        [Input("protectionId")]
        public string? ProtectionId { get; set; }

        /// <summary>
        /// ARN (Amazon Resource Name) of the resource being protected.
        /// 
        /// &gt; Exactly one of `protection_id` or `resource_arn` is required.
        /// </summary>
        [Input("resourceArn")]
        public string? ResourceArn { get; set; }

        public GetProtectionArgs()
        {
        }
        public static new GetProtectionArgs Empty => new GetProtectionArgs();
    }

    public sealed class GetProtectionInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Unique identifier for the protection.
        /// </summary>
        [Input("protectionId")]
        public Input<string>? ProtectionId { get; set; }

        /// <summary>
        /// ARN (Amazon Resource Name) of the resource being protected.
        /// 
        /// &gt; Exactly one of `protection_id` or `resource_arn` is required.
        /// </summary>
        [Input("resourceArn")]
        public Input<string>? ResourceArn { get; set; }

        public GetProtectionInvokeArgs()
        {
        }
        public static new GetProtectionInvokeArgs Empty => new GetProtectionInvokeArgs();
    }


    [OutputType]
    public sealed class GetProtectionResult
    {
        public readonly string Id;
        /// <summary>
        /// Name of the protection.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// ARN of the protection.
        /// </summary>
        public readonly string ProtectionArn;
        public readonly string ProtectionId;
        public readonly string ResourceArn;

        [OutputConstructor]
        private GetProtectionResult(
            string id,

            string name,

            string protectionArn,

            string protectionId,

            string resourceArn)
        {
            Id = id;
            Name = name;
            ProtectionArn = protectionArn;
            ProtectionId = protectionId;
            ResourceArn = resourceArn;
        }
    }
}
