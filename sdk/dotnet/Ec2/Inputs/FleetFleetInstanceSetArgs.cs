// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Inputs
{

    public sealed class FleetFleetInstanceSetArgs : global::Pulumi.ResourceArgs
    {
        [Input("instanceIds")]
        private InputList<string>? _instanceIds;

        /// <summary>
        /// The IDs of the instances.
        /// </summary>
        public InputList<string> InstanceIds
        {
            get => _instanceIds ?? (_instanceIds = new InputList<string>());
            set => _instanceIds = value;
        }

        /// <summary>
        /// The instance type.
        /// </summary>
        [Input("instanceType")]
        public Input<string>? InstanceType { get; set; }

        /// <summary>
        /// Indicates if the instance that was launched is a Spot Instance or On-Demand Instance.
        /// </summary>
        [Input("lifecycle")]
        public Input<string>? Lifecycle { get; set; }

        /// <summary>
        /// The value is `Windows` for Windows instances. Otherwise, the value is blank.
        /// </summary>
        [Input("platform")]
        public Input<string>? Platform { get; set; }

        public FleetFleetInstanceSetArgs()
        {
        }
        public static new FleetFleetInstanceSetArgs Empty => new FleetFleetInstanceSetArgs();
    }
}
