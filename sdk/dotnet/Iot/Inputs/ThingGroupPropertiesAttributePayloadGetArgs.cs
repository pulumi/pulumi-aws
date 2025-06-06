// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Iot.Inputs
{

    public sealed class ThingGroupPropertiesAttributePayloadGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("attributes")]
        private InputMap<string>? _attributes;

        /// <summary>
        /// Key-value map.
        /// </summary>
        public InputMap<string> Attributes
        {
            get => _attributes ?? (_attributes = new InputMap<string>());
            set => _attributes = value;
        }

        public ThingGroupPropertiesAttributePayloadGetArgs()
        {
        }
        public static new ThingGroupPropertiesAttributePayloadGetArgs Empty => new ThingGroupPropertiesAttributePayloadGetArgs();
    }
}
