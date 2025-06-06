// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DataExchange.Inputs
{

    public sealed class EventActionEventArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration for a Revision Published event.
        /// Described in `revision_published` Configuration Block below.
        /// </summary>
        [Input("revisionPublished")]
        public Input<Inputs.EventActionEventRevisionPublishedArgs>? RevisionPublished { get; set; }

        public EventActionEventArgs()
        {
        }
        public static new EventActionEventArgs Empty => new EventActionEventArgs();
    }
}
