// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Rds.Inputs
{

    public sealed class ReservedInstanceRecurringChargeGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("recurringChargeAmount")]
        public Input<int>? RecurringChargeAmount { get; set; }

        [Input("recurringChargeFrequency")]
        public Input<string>? RecurringChargeFrequency { get; set; }

        public ReservedInstanceRecurringChargeGetArgs()
        {
        }
        public static new ReservedInstanceRecurringChargeGetArgs Empty => new ReservedInstanceRecurringChargeGetArgs();
    }
}
