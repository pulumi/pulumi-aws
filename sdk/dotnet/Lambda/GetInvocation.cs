// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lambda
{
    public static class GetInvocation
    {
        /// <summary>
        /// Use this data source to invoke custom lambda functions as data source.
        /// The lambda function is invoked with [RequestResponse](https://docs.aws.amazon.com/lambda/latest/dg/API_Invoke.html#API_Invoke_RequestSyntax)
        /// invocation type.
        /// 
        /// &gt; **NOTE:** The `aws.lambda.Invocation` data source invokes the function during the first `apply` and every subsequent `plan` when the function is known.
        /// 
        /// &gt; **NOTE:** If you get a `KMSAccessDeniedException: Lambda was unable to decrypt the environment variables because KMS access was denied` error when invoking an `aws.lambda.Function` with environment variables, the IAM role associated with the function may have been deleted and recreated _after_ the function was created. You can fix the problem two ways: 1) updating the function's role to another role and then updating it back again to the recreated role, or 2) by using Pulumi to `taint` the function and `apply` your configuration again to recreate the function. (When you create a function, Lambda grants permissions on the KMS key to the function's IAM role. If the IAM role is recreated, the grant is no longer valid. Changing the function's role or recreating the function causes Lambda to update the grant.)
        /// </summary>
        public static Task<GetInvocationResult> InvokeAsync(GetInvocationArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetInvocationResult>("aws:lambda/getInvocation:getInvocation", args ?? new GetInvocationArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to invoke custom lambda functions as data source.
        /// The lambda function is invoked with [RequestResponse](https://docs.aws.amazon.com/lambda/latest/dg/API_Invoke.html#API_Invoke_RequestSyntax)
        /// invocation type.
        /// 
        /// &gt; **NOTE:** The `aws.lambda.Invocation` data source invokes the function during the first `apply` and every subsequent `plan` when the function is known.
        /// 
        /// &gt; **NOTE:** If you get a `KMSAccessDeniedException: Lambda was unable to decrypt the environment variables because KMS access was denied` error when invoking an `aws.lambda.Function` with environment variables, the IAM role associated with the function may have been deleted and recreated _after_ the function was created. You can fix the problem two ways: 1) updating the function's role to another role and then updating it back again to the recreated role, or 2) by using Pulumi to `taint` the function and `apply` your configuration again to recreate the function. (When you create a function, Lambda grants permissions on the KMS key to the function's IAM role. If the IAM role is recreated, the grant is no longer valid. Changing the function's role or recreating the function causes Lambda to update the grant.)
        /// </summary>
        public static Output<GetInvocationResult> Invoke(GetInvocationInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetInvocationResult>("aws:lambda/getInvocation:getInvocation", args ?? new GetInvocationInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to invoke custom lambda functions as data source.
        /// The lambda function is invoked with [RequestResponse](https://docs.aws.amazon.com/lambda/latest/dg/API_Invoke.html#API_Invoke_RequestSyntax)
        /// invocation type.
        /// 
        /// &gt; **NOTE:** The `aws.lambda.Invocation` data source invokes the function during the first `apply` and every subsequent `plan` when the function is known.
        /// 
        /// &gt; **NOTE:** If you get a `KMSAccessDeniedException: Lambda was unable to decrypt the environment variables because KMS access was denied` error when invoking an `aws.lambda.Function` with environment variables, the IAM role associated with the function may have been deleted and recreated _after_ the function was created. You can fix the problem two ways: 1) updating the function's role to another role and then updating it back again to the recreated role, or 2) by using Pulumi to `taint` the function and `apply` your configuration again to recreate the function. (When you create a function, Lambda grants permissions on the KMS key to the function's IAM role. If the IAM role is recreated, the grant is no longer valid. Changing the function's role or recreating the function causes Lambda to update the grant.)
        /// </summary>
        public static Output<GetInvocationResult> Invoke(GetInvocationInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetInvocationResult>("aws:lambda/getInvocation:getInvocation", args ?? new GetInvocationInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetInvocationArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the lambda function.
        /// </summary>
        [Input("functionName", required: true)]
        public string FunctionName { get; set; } = null!;

        /// <summary>
        /// String in JSON format that is passed as payload to the lambda function.
        /// </summary>
        [Input("input", required: true)]
        public string Input { get; set; } = null!;

        /// <summary>
        /// Qualifier (a.k.a version) of the lambda function. Defaults
        /// to `$LATEST`.
        /// </summary>
        [Input("qualifier")]
        public string? Qualifier { get; set; }

        public GetInvocationArgs()
        {
        }
        public static new GetInvocationArgs Empty => new GetInvocationArgs();
    }

    public sealed class GetInvocationInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the lambda function.
        /// </summary>
        [Input("functionName", required: true)]
        public Input<string> FunctionName { get; set; } = null!;

        /// <summary>
        /// String in JSON format that is passed as payload to the lambda function.
        /// </summary>
        [Input("input", required: true)]
        public Input<string> Input { get; set; } = null!;

        /// <summary>
        /// Qualifier (a.k.a version) of the lambda function. Defaults
        /// to `$LATEST`.
        /// </summary>
        [Input("qualifier")]
        public Input<string>? Qualifier { get; set; }

        public GetInvocationInvokeArgs()
        {
        }
        public static new GetInvocationInvokeArgs Empty => new GetInvocationInvokeArgs();
    }


    [OutputType]
    public sealed class GetInvocationResult
    {
        public readonly string FunctionName;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string Input;
        public readonly string? Qualifier;
        /// <summary>
        /// String result of the lambda function invocation.
        /// </summary>
        public readonly string Result;

        [OutputConstructor]
        private GetInvocationResult(
            string functionName,

            string id,

            string input,

            string? qualifier,

            string result)
        {
            FunctionName = functionName;
            Id = id;
            Input = input;
            Qualifier = qualifier;
            Result = result;
        }
    }
}
