// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppSync.Outputs
{

    [OutputType]
    public sealed class ResolverSyncConfig
    {
        /// <summary>
        /// Conflict Detection strategy to use. Valid values are `NONE` and `VERSION`.
        /// </summary>
        public readonly string? ConflictDetection;
        /// <summary>
        /// Conflict Resolution strategy to perform in the event of a conflict. Valid values are `NONE`, `OPTIMISTIC_CONCURRENCY`, `AUTOMERGE`, and `LAMBDA`.
        /// </summary>
        public readonly string? ConflictHandler;
        /// <summary>
        /// Lambda Conflict Handler Config when configuring `LAMBDA` as the Conflict Handler. See Lambda Conflict Handler Config.
        /// </summary>
        public readonly Outputs.ResolverSyncConfigLambdaConflictHandlerConfig? LambdaConflictHandlerConfig;

        [OutputConstructor]
        private ResolverSyncConfig(
            string? conflictDetection,

            string? conflictHandler,

            Outputs.ResolverSyncConfigLambdaConflictHandlerConfig? lambdaConflictHandlerConfig)
        {
            ConflictDetection = conflictDetection;
            ConflictHandler = conflictHandler;
            LambdaConflictHandlerConfig = lambdaConflictHandlerConfig;
        }
    }
}
