// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Emr
{
    public static class GetReleaseLabels
    {
        /// <summary>
        /// Retrieve information about EMR Release Labels.
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
        ///     var example = Aws.Emr.GetReleaseLabels.Invoke(new()
        ///     {
        ///         Filters = new Aws.Emr.Inputs.GetReleaseLabelsFiltersInputArgs
        ///         {
        ///             Application = "spark@2.1.0",
        ///             Prefix = "emr-5",
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetReleaseLabelsResult> InvokeAsync(GetReleaseLabelsArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetReleaseLabelsResult>("aws:emr/getReleaseLabels:getReleaseLabels", args ?? new GetReleaseLabelsArgs(), options.WithDefaults());

        /// <summary>
        /// Retrieve information about EMR Release Labels.
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
        ///     var example = Aws.Emr.GetReleaseLabels.Invoke(new()
        ///     {
        ///         Filters = new Aws.Emr.Inputs.GetReleaseLabelsFiltersInputArgs
        ///         {
        ///             Application = "spark@2.1.0",
        ///             Prefix = "emr-5",
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetReleaseLabelsResult> Invoke(GetReleaseLabelsInvokeArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetReleaseLabelsResult>("aws:emr/getReleaseLabels:getReleaseLabels", args ?? new GetReleaseLabelsInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Retrieve information about EMR Release Labels.
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
        ///     var example = Aws.Emr.GetReleaseLabels.Invoke(new()
        ///     {
        ///         Filters = new Aws.Emr.Inputs.GetReleaseLabelsFiltersInputArgs
        ///         {
        ///             Application = "spark@2.1.0",
        ///             Prefix = "emr-5",
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetReleaseLabelsResult> Invoke(GetReleaseLabelsInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetReleaseLabelsResult>("aws:emr/getReleaseLabels:getReleaseLabels", args ?? new GetReleaseLabelsInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetReleaseLabelsArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Filters the results of the request. Prefix specifies the prefix of release labels to return. Application specifies the application (with/without version) of release labels to return. See Filters.
        /// </summary>
        [Input("filters")]
        public Inputs.GetReleaseLabelsFiltersArgs? Filters { get; set; }

        public GetReleaseLabelsArgs()
        {
        }
        public static new GetReleaseLabelsArgs Empty => new GetReleaseLabelsArgs();
    }

    public sealed class GetReleaseLabelsInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Filters the results of the request. Prefix specifies the prefix of release labels to return. Application specifies the application (with/without version) of release labels to return. See Filters.
        /// </summary>
        [Input("filters")]
        public Input<Inputs.GetReleaseLabelsFiltersInputArgs>? Filters { get; set; }

        public GetReleaseLabelsInvokeArgs()
        {
        }
        public static new GetReleaseLabelsInvokeArgs Empty => new GetReleaseLabelsInvokeArgs();
    }


    [OutputType]
    public sealed class GetReleaseLabelsResult
    {
        public readonly Outputs.GetReleaseLabelsFiltersResult? Filters;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Returned release labels.
        /// </summary>
        public readonly ImmutableArray<string> ReleaseLabels;

        [OutputConstructor]
        private GetReleaseLabelsResult(
            Outputs.GetReleaseLabelsFiltersResult? filters,

            string id,

            ImmutableArray<string> releaseLabels)
        {
            Filters = filters;
            Id = id;
            ReleaseLabels = releaseLabels;
        }
    }
}
