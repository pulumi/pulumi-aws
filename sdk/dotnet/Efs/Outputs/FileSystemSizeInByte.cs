// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Efs.Outputs
{

    [OutputType]
    public sealed class FileSystemSizeInByte
    {
        /// <summary>
        /// The latest known metered size (in bytes) of data stored in the file system.
        /// </summary>
        public readonly int? Value;
        /// <summary>
        /// The latest known metered size (in bytes) of data stored in the Infrequent Access storage class.
        /// </summary>
        public readonly int? ValueInIa;
        /// <summary>
        /// The latest known metered size (in bytes) of data stored in the Standard storage class.
        /// </summary>
        public readonly int? ValueInStandard;

        [OutputConstructor]
        private FileSystemSizeInByte(
            int? value,

            int? valueInIa,

            int? valueInStandard)
        {
            Value = value;
            ValueInIa = valueInIa;
            ValueInStandard = valueInStandard;
        }
    }
}
