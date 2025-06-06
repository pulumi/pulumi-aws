// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.BedrockFoundation
{
    public static class GetModel
    {
        /// <summary>
        /// Data source for managing an AWS Bedrock Foundation Model.
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
        ///     var test = Aws.BedrockFoundation.GetModels.Invoke();
        /// 
        ///     var testGetModel = Aws.BedrockFoundation.GetModel.Invoke(new()
        ///     {
        ///         ModelId = test.Apply(getModelsResult =&gt; getModelsResult.ModelSummaries[0]?.ModelId),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetModelResult> InvokeAsync(GetModelArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetModelResult>("aws:bedrockfoundation/getModel:getModel", args ?? new GetModelArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS Bedrock Foundation Model.
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
        ///     var test = Aws.BedrockFoundation.GetModels.Invoke();
        /// 
        ///     var testGetModel = Aws.BedrockFoundation.GetModel.Invoke(new()
        ///     {
        ///         ModelId = test.Apply(getModelsResult =&gt; getModelsResult.ModelSummaries[0]?.ModelId),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetModelResult> Invoke(GetModelInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetModelResult>("aws:bedrockfoundation/getModel:getModel", args ?? new GetModelInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS Bedrock Foundation Model.
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
        ///     var test = Aws.BedrockFoundation.GetModels.Invoke();
        /// 
        ///     var testGetModel = Aws.BedrockFoundation.GetModel.Invoke(new()
        ///     {
        ///         ModelId = test.Apply(getModelsResult =&gt; getModelsResult.ModelSummaries[0]?.ModelId),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetModelResult> Invoke(GetModelInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetModelResult>("aws:bedrockfoundation/getModel:getModel", args ?? new GetModelInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetModelArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Model identifier.
        /// </summary>
        [Input("modelId", required: true)]
        public string ModelId { get; set; } = null!;

        public GetModelArgs()
        {
        }
        public static new GetModelArgs Empty => new GetModelArgs();
    }

    public sealed class GetModelInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Model identifier.
        /// </summary>
        [Input("modelId", required: true)]
        public Input<string> ModelId { get; set; } = null!;

        public GetModelInvokeArgs()
        {
        }
        public static new GetModelInvokeArgs Empty => new GetModelInvokeArgs();
    }


    [OutputType]
    public sealed class GetModelResult
    {
        /// <summary>
        /// Customizations that the model supports.
        /// </summary>
        public readonly ImmutableArray<string> CustomizationsSupporteds;
        public readonly string Id;
        /// <summary>
        /// Inference types that the model supports.
        /// </summary>
        public readonly ImmutableArray<string> InferenceTypesSupporteds;
        /// <summary>
        /// Input modalities that the model supports.
        /// </summary>
        public readonly ImmutableArray<string> InputModalities;
        /// <summary>
        /// Model ARN.
        /// </summary>
        public readonly string ModelArn;
        public readonly string ModelId;
        /// <summary>
        /// Model name.
        /// </summary>
        public readonly string ModelName;
        /// <summary>
        /// Output modalities that the model supports.
        /// </summary>
        public readonly ImmutableArray<string> OutputModalities;
        /// <summary>
        /// Model provider name.
        /// </summary>
        public readonly string ProviderName;
        /// <summary>
        /// Indicates whether the model supports streaming.
        /// </summary>
        public readonly bool ResponseStreamingSupported;

        [OutputConstructor]
        private GetModelResult(
            ImmutableArray<string> customizationsSupporteds,

            string id,

            ImmutableArray<string> inferenceTypesSupporteds,

            ImmutableArray<string> inputModalities,

            string modelArn,

            string modelId,

            string modelName,

            ImmutableArray<string> outputModalities,

            string providerName,

            bool responseStreamingSupported)
        {
            CustomizationsSupporteds = customizationsSupporteds;
            Id = id;
            InferenceTypesSupporteds = inferenceTypesSupporteds;
            InputModalities = inputModalities;
            ModelArn = modelArn;
            ModelId = modelId;
            ModelName = modelName;
            OutputModalities = outputModalities;
            ProviderName = providerName;
            ResponseStreamingSupported = responseStreamingSupported;
        }
    }
}
