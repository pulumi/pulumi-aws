// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Iot.Inputs
{

    public sealed class BillingGroupPropertiesGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A description of the Billing Group.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        public BillingGroupPropertiesGetArgs()
        {
        }
        public static new BillingGroupPropertiesGetArgs Empty => new BillingGroupPropertiesGetArgs();
    }
}
