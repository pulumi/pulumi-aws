// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis.Outputs
{

    [OutputType]
    public sealed class FirehoseDeliveryStreamExtendedS3ConfigurationDataFormatConversionConfigurationOutputFormatConfigurationSerializerParquetSerDe
    {
        /// <summary>
        /// The Hadoop Distributed File System (HDFS) block size. This is useful if you intend to copy the data from Amazon S3 to HDFS before querying. The default is 256 MiB and the minimum is 64 MiB. Kinesis Data Firehose uses this value for padding calculations.
        /// </summary>
        public readonly int? BlockSizeBytes;
        /// <summary>
        /// The compression code to use over data blocks. The possible values are `UNCOMPRESSED`, `SNAPPY`, and `GZIP`, with the default being `SNAPPY`. Use `SNAPPY` for higher decompression speed. Use `GZIP` if the compression ratio is more important than speed.
        /// </summary>
        public readonly string? Compression;
        /// <summary>
        /// Indicates whether to enable dictionary compression.
        /// </summary>
        public readonly bool? EnableDictionaryCompression;
        /// <summary>
        /// The maximum amount of padding to apply. This is useful if you intend to copy the data from Amazon S3 to HDFS before querying. The default is `0`.
        /// </summary>
        public readonly int? MaxPaddingBytes;
        /// <summary>
        /// The Parquet page size. Column chunks are divided into pages. A page is conceptually an indivisible unit (in terms of compression and encoding). The minimum value is 64 KiB and the default is 1 MiB.
        /// </summary>
        public readonly int? PageSizeBytes;
        /// <summary>
        /// Indicates the version of row format to output. The possible values are `V1` and `V2`. The default is `V1`.
        /// </summary>
        public readonly string? WriterVersion;

        [OutputConstructor]
        private FirehoseDeliveryStreamExtendedS3ConfigurationDataFormatConversionConfigurationOutputFormatConfigurationSerializerParquetSerDe(
            int? blockSizeBytes,

            string? compression,

            bool? enableDictionaryCompression,

            int? maxPaddingBytes,

            int? pageSizeBytes,

            string? writerVersion)
        {
            BlockSizeBytes = blockSizeBytes;
            Compression = compression;
            EnableDictionaryCompression = enableDictionaryCompression;
            MaxPaddingBytes = maxPaddingBytes;
            PageSizeBytes = pageSizeBytes;
            WriterVersion = writerVersion;
        }
    }
}
