// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DataExchange.Inputs
{

    public sealed class EventActionEventGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration for a Revision Published event.
        /// Described in `revision_published` Configuration Block below.
        /// </summary>
        [Input("revisionPublished")]
        public Input<Inputs.EventActionEventRevisionPublishedGetArgs>? RevisionPublished { get; set; }

        public EventActionEventGetArgs()
        {
        }
        public static new EventActionEventGetArgs Empty => new EventActionEventGetArgs();
    }
}
