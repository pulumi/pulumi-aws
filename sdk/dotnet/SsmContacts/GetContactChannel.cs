// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SsmContacts
{
    public static class GetContactChannel
    {
        /// <summary>
        /// Data source for managing an AWS SSM Contacts Contact Channel.
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
        ///     var example = Aws.SsmContacts.GetContactChannel.Invoke(new()
        ///     {
        ///         Arn = "arn:aws:ssm-contacts:us-west-2:123456789012:contact-channel/example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetContactChannelResult> InvokeAsync(GetContactChannelArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetContactChannelResult>("aws:ssmcontacts/getContactChannel:getContactChannel", args ?? new GetContactChannelArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS SSM Contacts Contact Channel.
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
        ///     var example = Aws.SsmContacts.GetContactChannel.Invoke(new()
        ///     {
        ///         Arn = "arn:aws:ssm-contacts:us-west-2:123456789012:contact-channel/example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetContactChannelResult> Invoke(GetContactChannelInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetContactChannelResult>("aws:ssmcontacts/getContactChannel:getContactChannel", args ?? new GetContactChannelInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS SSM Contacts Contact Channel.
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
        ///     var example = Aws.SsmContacts.GetContactChannel.Invoke(new()
        ///     {
        ///         Arn = "arn:aws:ssm-contacts:us-west-2:123456789012:contact-channel/example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetContactChannelResult> Invoke(GetContactChannelInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetContactChannelResult>("aws:ssmcontacts/getContactChannel:getContactChannel", args ?? new GetContactChannelInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetContactChannelArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of the contact channel.
        /// </summary>
        [Input("arn", required: true)]
        public string Arn { get; set; } = null!;

        public GetContactChannelArgs()
        {
        }
        public static new GetContactChannelArgs Empty => new GetContactChannelArgs();
    }

    public sealed class GetContactChannelInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of the contact channel.
        /// </summary>
        [Input("arn", required: true)]
        public Input<string> Arn { get; set; } = null!;

        public GetContactChannelInvokeArgs()
        {
        }
        public static new GetContactChannelInvokeArgs Empty => new GetContactChannelInvokeArgs();
    }


    [OutputType]
    public sealed class GetContactChannelResult
    {
        /// <summary>
        /// Whether the contact channel is activated.
        /// </summary>
        public readonly string ActivationStatus;
        public readonly string Arn;
        /// <summary>
        /// Amazon Resource Name (ARN) of the AWS SSM Contact that the contact channel belongs to.
        /// </summary>
        public readonly string ContactId;
        /// <summary>
        /// Details used to engage the contact channel.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetContactChannelDeliveryAddressResult> DeliveryAddresses;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Name of the contact channel.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Type of the contact channel.
        /// </summary>
        public readonly string Type;

        [OutputConstructor]
        private GetContactChannelResult(
            string activationStatus,

            string arn,

            string contactId,

            ImmutableArray<Outputs.GetContactChannelDeliveryAddressResult> deliveryAddresses,

            string id,

            string name,

            string type)
        {
            ActivationStatus = activationStatus;
            Arn = arn;
            ContactId = contactId;
            DeliveryAddresses = deliveryAddresses;
            Id = id;
            Name = name;
            Type = type;
        }
    }
}
