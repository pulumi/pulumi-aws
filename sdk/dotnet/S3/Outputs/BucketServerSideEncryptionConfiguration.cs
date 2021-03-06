// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Outputs
{

    [OutputType]
    public sealed class BucketServerSideEncryptionConfiguration
    {
        /// <summary>
        /// A single object for server-side encryption by default configuration. (documented below)
        /// </summary>
        public readonly Outputs.BucketServerSideEncryptionConfigurationRule Rule;

        [OutputConstructor]
        private BucketServerSideEncryptionConfiguration(Outputs.BucketServerSideEncryptionConfigurationRule rule)
        {
            Rule = rule;
        }
    }
}
