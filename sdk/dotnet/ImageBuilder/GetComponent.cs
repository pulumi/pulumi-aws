// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ImageBuilder
{
    public static class GetComponent
    {
        /// <summary>
        /// Provides details about an Image Builder Component.
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
        ///     var example = Aws.ImageBuilder.GetComponent.Invoke(new()
        ///     {
        ///         Arn = "arn:aws:imagebuilder:us-west-2:aws:component/amazon-cloudwatch-agent-linux/1.0.0",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetComponentResult> InvokeAsync(GetComponentArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetComponentResult>("aws:imagebuilder/getComponent:getComponent", args ?? new GetComponentArgs(), options.WithDefaults());

        /// <summary>
        /// Provides details about an Image Builder Component.
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
        ///     var example = Aws.ImageBuilder.GetComponent.Invoke(new()
        ///     {
        ///         Arn = "arn:aws:imagebuilder:us-west-2:aws:component/amazon-cloudwatch-agent-linux/1.0.0",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetComponentResult> Invoke(GetComponentInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetComponentResult>("aws:imagebuilder/getComponent:getComponent", args ?? new GetComponentInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Provides details about an Image Builder Component.
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
        ///     var example = Aws.ImageBuilder.GetComponent.Invoke(new()
        ///     {
        ///         Arn = "arn:aws:imagebuilder:us-west-2:aws:component/amazon-cloudwatch-agent-linux/1.0.0",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetComponentResult> Invoke(GetComponentInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetComponentResult>("aws:imagebuilder/getComponent:getComponent", args ?? new GetComponentInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetComponentArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// ARN of the component.
        /// </summary>
        [Input("arn", required: true)]
        public string Arn { get; set; } = null!;

        [Input("tags")]
        private Dictionary<string, string>? _tags;

        /// <summary>
        /// Key-value map of resource tags for the component.
        /// </summary>
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        public GetComponentArgs()
        {
        }
        public static new GetComponentArgs Empty => new GetComponentArgs();
    }

    public sealed class GetComponentInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// ARN of the component.
        /// </summary>
        [Input("arn", required: true)]
        public Input<string> Arn { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of resource tags for the component.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public GetComponentInvokeArgs()
        {
        }
        public static new GetComponentInvokeArgs Empty => new GetComponentInvokeArgs();
    }


    [OutputType]
    public sealed class GetComponentResult
    {
        public readonly string Arn;
        /// <summary>
        /// Change description of the component.
        /// </summary>
        public readonly string ChangeDescription;
        /// <summary>
        /// Data of the component.
        /// </summary>
        public readonly string Data;
        /// <summary>
        /// Date the component was created.
        /// </summary>
        public readonly string DateCreated;
        /// <summary>
        /// Description of the component.
        /// </summary>
        public readonly string Description;
        /// <summary>
        /// Encryption status of the component.
        /// </summary>
        public readonly bool Encrypted;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// ARN of the Key Management Service (KMS) Key used to encrypt the component.
        /// </summary>
        public readonly string KmsKeyId;
        /// <summary>
        /// Name of the component.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Owner of the component.
        /// </summary>
        public readonly string Owner;
        /// <summary>
        /// Platform of the component.
        /// </summary>
        public readonly string Platform;
        /// <summary>
        /// Operating Systems (OSes) supported by the component.
        /// </summary>
        public readonly ImmutableArray<string> SupportedOsVersions;
        /// <summary>
        /// Key-value map of resource tags for the component.
        /// </summary>
        public readonly ImmutableDictionary<string, string> Tags;
        /// <summary>
        /// Type of the component.
        /// </summary>
        public readonly string Type;
        /// <summary>
        /// Version of the component.
        /// </summary>
        public readonly string Version;

        [OutputConstructor]
        private GetComponentResult(
            string arn,

            string changeDescription,

            string data,

            string dateCreated,

            string description,

            bool encrypted,

            string id,

            string kmsKeyId,

            string name,

            string owner,

            string platform,

            ImmutableArray<string> supportedOsVersions,

            ImmutableDictionary<string, string> tags,

            string type,

            string version)
        {
            Arn = arn;
            ChangeDescription = changeDescription;
            Data = data;
            DateCreated = dateCreated;
            Description = description;
            Encrypted = encrypted;
            Id = id;
            KmsKeyId = kmsKeyId;
            Name = name;
            Owner = owner;
            Platform = platform;
            SupportedOsVersions = supportedOsVersions;
            Tags = tags;
            Type = type;
            Version = version;
        }
    }
}
