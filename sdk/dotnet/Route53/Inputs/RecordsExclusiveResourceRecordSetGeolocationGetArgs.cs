// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53.Inputs
{

    public sealed class RecordsExclusiveResourceRecordSetGeolocationGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("continentCode")]
        public Input<string>? ContinentCode { get; set; }

        [Input("countryCode")]
        public Input<string>? CountryCode { get; set; }

        [Input("subdivisionCode")]
        public Input<string>? SubdivisionCode { get; set; }

        public RecordsExclusiveResourceRecordSetGeolocationGetArgs()
        {
        }
        public static new RecordsExclusiveResourceRecordSetGeolocationGetArgs Empty => new RecordsExclusiveResourceRecordSetGeolocationGetArgs();
    }
}
