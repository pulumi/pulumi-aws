// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LicenseManager
{
    public static class GetReceivedLicense
    {
        /// <summary>
        /// This resource can be used to get data on a received license using an ARN. This can be helpful for pulling in data on a license from the AWS marketplace and sharing that license with another account.
        /// 
        /// ## Example Usage
        /// 
        /// The following shows getting the received license data using and ARN.
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var test = Aws.LicenseManager.GetReceivedLicense.Invoke(new()
        ///     {
        ///         LicenseArn = "arn:aws:license-manager::111111111111:license:l-ecbaa94eb71a4830b6d7e49268fecaa0",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetReceivedLicenseResult> InvokeAsync(GetReceivedLicenseArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetReceivedLicenseResult>("aws:licensemanager/getReceivedLicense:getReceivedLicense", args ?? new GetReceivedLicenseArgs(), options.WithDefaults());

        /// <summary>
        /// This resource can be used to get data on a received license using an ARN. This can be helpful for pulling in data on a license from the AWS marketplace and sharing that license with another account.
        /// 
        /// ## Example Usage
        /// 
        /// The following shows getting the received license data using and ARN.
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var test = Aws.LicenseManager.GetReceivedLicense.Invoke(new()
        ///     {
        ///         LicenseArn = "arn:aws:license-manager::111111111111:license:l-ecbaa94eb71a4830b6d7e49268fecaa0",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetReceivedLicenseResult> Invoke(GetReceivedLicenseInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetReceivedLicenseResult>("aws:licensemanager/getReceivedLicense:getReceivedLicense", args ?? new GetReceivedLicenseInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// This resource can be used to get data on a received license using an ARN. This can be helpful for pulling in data on a license from the AWS marketplace and sharing that license with another account.
        /// 
        /// ## Example Usage
        /// 
        /// The following shows getting the received license data using and ARN.
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var test = Aws.LicenseManager.GetReceivedLicense.Invoke(new()
        ///     {
        ///         LicenseArn = "arn:aws:license-manager::111111111111:license:l-ecbaa94eb71a4830b6d7e49268fecaa0",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetReceivedLicenseResult> Invoke(GetReceivedLicenseInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetReceivedLicenseResult>("aws:licensemanager/getReceivedLicense:getReceivedLicense", args ?? new GetReceivedLicenseInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetReceivedLicenseArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The ARN of the received license you want data for.
        /// </summary>
        [Input("licenseArn", required: true)]
        public string LicenseArn { get; set; } = null!;

        public GetReceivedLicenseArgs()
        {
        }
        public static new GetReceivedLicenseArgs Empty => new GetReceivedLicenseArgs();
    }

    public sealed class GetReceivedLicenseInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The ARN of the received license you want data for.
        /// </summary>
        [Input("licenseArn", required: true)]
        public Input<string> LicenseArn { get; set; } = null!;

        public GetReceivedLicenseInvokeArgs()
        {
        }
        public static new GetReceivedLicenseInvokeArgs Empty => new GetReceivedLicenseInvokeArgs();
    }


    [OutputType]
    public sealed class GetReceivedLicenseResult
    {
        /// <summary>
        /// Granted license beneficiary. This is in the form of the ARN of the root user of the account.
        /// </summary>
        public readonly string Beneficiary;
        /// <summary>
        /// Configuration for consumption of the license. Detailed below
        /// </summary>
        public readonly ImmutableArray<Outputs.GetReceivedLicenseConsumptionConfigurationResult> ConsumptionConfigurations;
        /// <summary>
        /// Creation time of the granted license in RFC 3339 format.
        /// </summary>
        public readonly string CreateTime;
        /// <summary>
        /// License entitlements. Detailed below
        /// </summary>
        public readonly ImmutableArray<Outputs.GetReceivedLicenseEntitlementResult> Entitlements;
        /// <summary>
        /// Home Region of the granted license.
        /// </summary>
        public readonly string HomeRegion;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Granted license issuer. Detailed below
        /// </summary>
        public readonly ImmutableArray<Outputs.GetReceivedLicenseIssuerResult> Issuers;
        /// <summary>
        /// Amazon Resource Name (ARN) of the license.
        /// </summary>
        public readonly string LicenseArn;
        /// <summary>
        /// Granted license metadata. This is in the form of a set of all meta data. Detailed below
        /// </summary>
        public readonly ImmutableArray<Outputs.GetReceivedLicenseLicenseMetadataResult> LicenseMetadatas;
        /// <summary>
        /// License name.
        /// </summary>
        public readonly string LicenseName;
        /// <summary>
        /// Product name.
        /// * `product_sku ` - Product SKU.
        /// </summary>
        public readonly string ProductName;
        public readonly string ProductSku;
        /// <summary>
        /// Granted license received metadata. Detailed below
        /// </summary>
        public readonly ImmutableArray<Outputs.GetReceivedLicenseReceivedMetadataResult> ReceivedMetadatas;
        /// <summary>
        /// Granted license status.
        /// </summary>
        public readonly string Status;
        /// <summary>
        /// Date and time range during which the granted license is valid, in ISO8601-UTC format. Detailed below
        /// </summary>
        public readonly ImmutableArray<Outputs.GetReceivedLicenseValidityResult> Validities;
        /// <summary>
        /// Version of the granted license.
        /// </summary>
        public readonly string Version;

        [OutputConstructor]
        private GetReceivedLicenseResult(
            string beneficiary,

            ImmutableArray<Outputs.GetReceivedLicenseConsumptionConfigurationResult> consumptionConfigurations,

            string createTime,

            ImmutableArray<Outputs.GetReceivedLicenseEntitlementResult> entitlements,

            string homeRegion,

            string id,

            ImmutableArray<Outputs.GetReceivedLicenseIssuerResult> issuers,

            string licenseArn,

            ImmutableArray<Outputs.GetReceivedLicenseLicenseMetadataResult> licenseMetadatas,

            string licenseName,

            string productName,

            string productSku,

            ImmutableArray<Outputs.GetReceivedLicenseReceivedMetadataResult> receivedMetadatas,

            string status,

            ImmutableArray<Outputs.GetReceivedLicenseValidityResult> validities,

            string version)
        {
            Beneficiary = beneficiary;
            ConsumptionConfigurations = consumptionConfigurations;
            CreateTime = createTime;
            Entitlements = entitlements;
            HomeRegion = homeRegion;
            Id = id;
            Issuers = issuers;
            LicenseArn = licenseArn;
            LicenseMetadatas = licenseMetadatas;
            LicenseName = licenseName;
            ProductName = productName;
            ProductSku = productSku;
            ReceivedMetadatas = receivedMetadatas;
            Status = status;
            Validities = validities;
            Version = version;
        }
    }
}
