// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpenSearch
{
    public static class GetServerlessSecurityConfig
    {
        /// <summary>
        /// Data source for managing an AWS OpenSearch Serverless Security Config.
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
        ///     var example = Aws.OpenSearch.GetServerlessSecurityConfig.Invoke(new()
        ///     {
        ///         Id = "saml/12345678912/example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetServerlessSecurityConfigResult> InvokeAsync(GetServerlessSecurityConfigArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetServerlessSecurityConfigResult>("aws:opensearch/getServerlessSecurityConfig:getServerlessSecurityConfig", args ?? new GetServerlessSecurityConfigArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS OpenSearch Serverless Security Config.
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
        ///     var example = Aws.OpenSearch.GetServerlessSecurityConfig.Invoke(new()
        ///     {
        ///         Id = "saml/12345678912/example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetServerlessSecurityConfigResult> Invoke(GetServerlessSecurityConfigInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetServerlessSecurityConfigResult>("aws:opensearch/getServerlessSecurityConfig:getServerlessSecurityConfig", args ?? new GetServerlessSecurityConfigInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS OpenSearch Serverless Security Config.
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
        ///     var example = Aws.OpenSearch.GetServerlessSecurityConfig.Invoke(new()
        ///     {
        ///         Id = "saml/12345678912/example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetServerlessSecurityConfigResult> Invoke(GetServerlessSecurityConfigInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetServerlessSecurityConfigResult>("aws:opensearch/getServerlessSecurityConfig:getServerlessSecurityConfig", args ?? new GetServerlessSecurityConfigInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetServerlessSecurityConfigArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The unique identifier of the security configuration.
        /// </summary>
        [Input("id", required: true)]
        public string Id { get; set; } = null!;

        /// <summary>
        /// SAML options for the security configuration.
        /// </summary>
        [Input("samlOptions")]
        public Inputs.GetServerlessSecurityConfigSamlOptionsArgs? SamlOptions { get; set; }

        public GetServerlessSecurityConfigArgs()
        {
        }
        public static new GetServerlessSecurityConfigArgs Empty => new GetServerlessSecurityConfigArgs();
    }

    public sealed class GetServerlessSecurityConfigInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The unique identifier of the security configuration.
        /// </summary>
        [Input("id", required: true)]
        public Input<string> Id { get; set; } = null!;

        /// <summary>
        /// SAML options for the security configuration.
        /// </summary>
        [Input("samlOptions")]
        public Input<Inputs.GetServerlessSecurityConfigSamlOptionsInputArgs>? SamlOptions { get; set; }

        public GetServerlessSecurityConfigInvokeArgs()
        {
        }
        public static new GetServerlessSecurityConfigInvokeArgs Empty => new GetServerlessSecurityConfigInvokeArgs();
    }


    [OutputType]
    public sealed class GetServerlessSecurityConfigResult
    {
        /// <summary>
        /// The version of the security configuration.
        /// </summary>
        public readonly string ConfigVersion;
        /// <summary>
        /// The date the configuration was created.
        /// </summary>
        public readonly string CreatedDate;
        /// <summary>
        /// The description of the security configuration.
        /// </summary>
        public readonly string Description;
        public readonly string Id;
        /// <summary>
        /// The date the configuration was last modified.
        /// </summary>
        public readonly string LastModifiedDate;
        /// <summary>
        /// SAML options for the security configuration.
        /// </summary>
        public readonly Outputs.GetServerlessSecurityConfigSamlOptionsResult? SamlOptions;
        /// <summary>
        /// The type of security configuration.
        /// </summary>
        public readonly string Type;

        [OutputConstructor]
        private GetServerlessSecurityConfigResult(
            string configVersion,

            string createdDate,

            string description,

            string id,

            string lastModifiedDate,

            Outputs.GetServerlessSecurityConfigSamlOptionsResult? samlOptions,

            string type)
        {
            ConfigVersion = configVersion;
            CreatedDate = createdDate;
            Description = description;
            Id = id;
            LastModifiedDate = lastModifiedDate;
            SamlOptions = samlOptions;
            Type = type;
        }
    }
}
