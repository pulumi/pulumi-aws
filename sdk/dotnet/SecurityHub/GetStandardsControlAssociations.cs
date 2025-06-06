// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityHub
{
    public static class GetStandardsControlAssociations
    {
        /// <summary>
        /// Data source for managing an AWS Security Hub Standards Control Associations.
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
        ///     var testAccount = new Aws.SecurityHub.Account("test");
        /// 
        ///     var test = Aws.SecurityHub.GetStandardsControlAssociations.Invoke(new()
        ///     {
        ///         SecurityControlId = "IAM.1",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetStandardsControlAssociationsResult> InvokeAsync(GetStandardsControlAssociationsArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetStandardsControlAssociationsResult>("aws:securityhub/getStandardsControlAssociations:getStandardsControlAssociations", args ?? new GetStandardsControlAssociationsArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS Security Hub Standards Control Associations.
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
        ///     var testAccount = new Aws.SecurityHub.Account("test");
        /// 
        ///     var test = Aws.SecurityHub.GetStandardsControlAssociations.Invoke(new()
        ///     {
        ///         SecurityControlId = "IAM.1",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetStandardsControlAssociationsResult> Invoke(GetStandardsControlAssociationsInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetStandardsControlAssociationsResult>("aws:securityhub/getStandardsControlAssociations:getStandardsControlAssociations", args ?? new GetStandardsControlAssociationsInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS Security Hub Standards Control Associations.
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
        ///     var testAccount = new Aws.SecurityHub.Account("test");
        /// 
        ///     var test = Aws.SecurityHub.GetStandardsControlAssociations.Invoke(new()
        ///     {
        ///         SecurityControlId = "IAM.1",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetStandardsControlAssociationsResult> Invoke(GetStandardsControlAssociationsInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetStandardsControlAssociationsResult>("aws:securityhub/getStandardsControlAssociations:getStandardsControlAssociations", args ?? new GetStandardsControlAssociationsInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetStandardsControlAssociationsArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The identifier of the control (identified with `SecurityControlId`, `SecurityControlArn`, or a mix of both parameters).
        /// </summary>
        [Input("securityControlId", required: true)]
        public string SecurityControlId { get; set; } = null!;

        public GetStandardsControlAssociationsArgs()
        {
        }
        public static new GetStandardsControlAssociationsArgs Empty => new GetStandardsControlAssociationsArgs();
    }

    public sealed class GetStandardsControlAssociationsInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The identifier of the control (identified with `SecurityControlId`, `SecurityControlArn`, or a mix of both parameters).
        /// </summary>
        [Input("securityControlId", required: true)]
        public Input<string> SecurityControlId { get; set; } = null!;

        public GetStandardsControlAssociationsInvokeArgs()
        {
        }
        public static new GetStandardsControlAssociationsInvokeArgs Empty => new GetStandardsControlAssociationsInvokeArgs();
    }


    [OutputType]
    public sealed class GetStandardsControlAssociationsResult
    {
        public readonly string Id;
        /// <summary>
        /// ID of the security control.
        /// </summary>
        public readonly string SecurityControlId;
        /// <summary>
        /// A list that provides the status and other details for each security control that applies to each enabled standard.
        /// See `standards_control_associations` below.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetStandardsControlAssociationsStandardsControlAssociationResult> StandardsControlAssociations;

        [OutputConstructor]
        private GetStandardsControlAssociationsResult(
            string id,

            string securityControlId,

            ImmutableArray<Outputs.GetStandardsControlAssociationsStandardsControlAssociationResult> standardsControlAssociations)
        {
            Id = id;
            SecurityControlId = securityControlId;
            StandardsControlAssociations = standardsControlAssociations;
        }
    }
}
