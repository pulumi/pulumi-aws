// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Inputs
{

    public sealed class RouteSpecHttpRouteActionArgs : global::Pulumi.ResourceArgs
    {
        [Input("weightedTargets", required: true)]
        private InputList<Inputs.RouteSpecHttpRouteActionWeightedTargetArgs>? _weightedTargets;

        /// <summary>
        /// Targets that traffic is routed to when a request matches the route.
        /// You can specify one or more targets and their relative weights with which to distribute traffic.
        /// </summary>
        public InputList<Inputs.RouteSpecHttpRouteActionWeightedTargetArgs> WeightedTargets
        {
            get => _weightedTargets ?? (_weightedTargets = new InputList<Inputs.RouteSpecHttpRouteActionWeightedTargetArgs>());
            set => _weightedTargets = value;
        }

        public RouteSpecHttpRouteActionArgs()
        {
        }
        public static new RouteSpecHttpRouteActionArgs Empty => new RouteSpecHttpRouteActionArgs();
    }
}
