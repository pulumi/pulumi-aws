// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudTrail.Inputs
{

    public sealed class TrailAdvancedEventSelectorArgs : global::Pulumi.ResourceArgs
    {
        [Input("fieldSelectors", required: true)]
        private InputList<Inputs.TrailAdvancedEventSelectorFieldSelectorArgs>? _fieldSelectors;

        /// <summary>
        /// Specifies the selector statements in an advanced event selector. Fields documented below.
        /// </summary>
        public InputList<Inputs.TrailAdvancedEventSelectorFieldSelectorArgs> FieldSelectors
        {
            get => _fieldSelectors ?? (_fieldSelectors = new InputList<Inputs.TrailAdvancedEventSelectorFieldSelectorArgs>());
            set => _fieldSelectors = value;
        }

        /// <summary>
        /// Name of the trail.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        public TrailAdvancedEventSelectorArgs()
        {
        }
        public static new TrailAdvancedEventSelectorArgs Empty => new TrailAdvancedEventSelectorArgs();
    }
}
