// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pricing
{
    public static class GetProduct
    {
        /// <summary>
        /// Use this data source to get the pricing information of all products in AWS.
        /// This data source is only available in a us-east-1 or ap-south-1 provider.
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
        ///     var example = Aws.Pricing.GetProduct.Invoke(new()
        ///     {
        ///         ServiceCode = "AmazonEC2",
        ///         Filters = new[]
        ///         {
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "instanceType",
        ///                 Value = "c5.xlarge",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "operatingSystem",
        ///                 Value = "Linux",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "location",
        ///                 Value = "US East (N. Virginia)",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "preInstalledSw",
        ///                 Value = "NA",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "licenseModel",
        ///                 Value = "No License required",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "tenancy",
        ///                 Value = "Shared",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "capacitystatus",
        ///                 Value = "Used",
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Pricing.GetProduct.Invoke(new()
        ///     {
        ///         ServiceCode = "AmazonRedshift",
        ///         Filters = new[]
        ///         {
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "instanceType",
        ///                 Value = "ds1.xlarge",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "location",
        ///                 Value = "US East (N. Virginia)",
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetProductResult> InvokeAsync(GetProductArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetProductResult>("aws:pricing/getProduct:getProduct", args ?? new GetProductArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get the pricing information of all products in AWS.
        /// This data source is only available in a us-east-1 or ap-south-1 provider.
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
        ///     var example = Aws.Pricing.GetProduct.Invoke(new()
        ///     {
        ///         ServiceCode = "AmazonEC2",
        ///         Filters = new[]
        ///         {
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "instanceType",
        ///                 Value = "c5.xlarge",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "operatingSystem",
        ///                 Value = "Linux",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "location",
        ///                 Value = "US East (N. Virginia)",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "preInstalledSw",
        ///                 Value = "NA",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "licenseModel",
        ///                 Value = "No License required",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "tenancy",
        ///                 Value = "Shared",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "capacitystatus",
        ///                 Value = "Used",
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Pricing.GetProduct.Invoke(new()
        ///     {
        ///         ServiceCode = "AmazonRedshift",
        ///         Filters = new[]
        ///         {
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "instanceType",
        ///                 Value = "ds1.xlarge",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "location",
        ///                 Value = "US East (N. Virginia)",
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetProductResult> Invoke(GetProductInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetProductResult>("aws:pricing/getProduct:getProduct", args ?? new GetProductInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get the pricing information of all products in AWS.
        /// This data source is only available in a us-east-1 or ap-south-1 provider.
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
        ///     var example = Aws.Pricing.GetProduct.Invoke(new()
        ///     {
        ///         ServiceCode = "AmazonEC2",
        ///         Filters = new[]
        ///         {
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "instanceType",
        ///                 Value = "c5.xlarge",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "operatingSystem",
        ///                 Value = "Linux",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "location",
        ///                 Value = "US East (N. Virginia)",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "preInstalledSw",
        ///                 Value = "NA",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "licenseModel",
        ///                 Value = "No License required",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "tenancy",
        ///                 Value = "Shared",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "capacitystatus",
        ///                 Value = "Used",
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Pricing.GetProduct.Invoke(new()
        ///     {
        ///         ServiceCode = "AmazonRedshift",
        ///         Filters = new[]
        ///         {
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "instanceType",
        ///                 Value = "ds1.xlarge",
        ///             },
        ///             new Aws.Pricing.Inputs.GetProductFilterInputArgs
        ///             {
        ///                 Field = "location",
        ///                 Value = "US East (N. Virginia)",
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetProductResult> Invoke(GetProductInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetProductResult>("aws:pricing/getProduct:getProduct", args ?? new GetProductInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetProductArgs : global::Pulumi.InvokeArgs
    {
        [Input("filters", required: true)]
        private List<Inputs.GetProductFilterArgs>? _filters;

        /// <summary>
        /// List of filters. Passed directly to the API (see GetProducts API reference). These filters must describe a single product, this resource will fail if more than one product is returned by the API.
        /// </summary>
        public List<Inputs.GetProductFilterArgs> Filters
        {
            get => _filters ?? (_filters = new List<Inputs.GetProductFilterArgs>());
            set => _filters = value;
        }

        /// <summary>
        /// Code of the service. Available service codes can be fetched using the DescribeServices pricing API call.
        /// </summary>
        [Input("serviceCode", required: true)]
        public string ServiceCode { get; set; } = null!;

        public GetProductArgs()
        {
        }
        public static new GetProductArgs Empty => new GetProductArgs();
    }

    public sealed class GetProductInvokeArgs : global::Pulumi.InvokeArgs
    {
        [Input("filters", required: true)]
        private InputList<Inputs.GetProductFilterInputArgs>? _filters;

        /// <summary>
        /// List of filters. Passed directly to the API (see GetProducts API reference). These filters must describe a single product, this resource will fail if more than one product is returned by the API.
        /// </summary>
        public InputList<Inputs.GetProductFilterInputArgs> Filters
        {
            get => _filters ?? (_filters = new InputList<Inputs.GetProductFilterInputArgs>());
            set => _filters = value;
        }

        /// <summary>
        /// Code of the service. Available service codes can be fetched using the DescribeServices pricing API call.
        /// </summary>
        [Input("serviceCode", required: true)]
        public Input<string> ServiceCode { get; set; } = null!;

        public GetProductInvokeArgs()
        {
        }
        public static new GetProductInvokeArgs Empty => new GetProductInvokeArgs();
    }


    [OutputType]
    public sealed class GetProductResult
    {
        public readonly ImmutableArray<Outputs.GetProductFilterResult> Filters;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Set to the product returned from the API.
        /// </summary>
        public readonly string Result;
        public readonly string ServiceCode;

        [OutputConstructor]
        private GetProductResult(
            ImmutableArray<Outputs.GetProductFilterResult> filters,

            string id,

            string result,

            string serviceCode)
        {
            Filters = filters;
            Id = id;
            Result = result;
            ServiceCode = serviceCode;
        }
    }
}
