// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dataexchange.inputs;

import com.pulumi.aws.dataexchange.inputs.RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceKmsKeysToGrantArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceArgs extends com.pulumi.resources.ResourceArgs {

    public static final RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceArgs Empty = new RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceArgs();

    /**
     * The name of the S3 bucket.
     * 
     */
    @Import(name="bucket", required=true)
    private Output<String> bucket;

    /**
     * @return The name of the S3 bucket.
     * 
     */
    public Output<String> bucket() {
        return this.bucket;
    }

    /**
     * List of key prefixes in the S3 bucket.
     * 
     */
    @Import(name="keyPrefixes")
    private @Nullable Output<List<String>> keyPrefixes;

    /**
     * @return List of key prefixes in the S3 bucket.
     * 
     */
    public Optional<Output<List<String>>> keyPrefixes() {
        return Optional.ofNullable(this.keyPrefixes);
    }

    /**
     * List of object keys in the S3 bucket.
     * 
     */
    @Import(name="keys")
    private @Nullable Output<List<String>> keys;

    /**
     * @return List of object keys in the S3 bucket.
     * 
     */
    public Optional<Output<List<String>>> keys() {
        return Optional.ofNullable(this.keys);
    }

    @Import(name="kmsKeysToGrants")
    private @Nullable Output<List<RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceKmsKeysToGrantArgs>> kmsKeysToGrants;

    public Optional<Output<List<RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceKmsKeysToGrantArgs>>> kmsKeysToGrants() {
        return Optional.ofNullable(this.kmsKeysToGrants);
    }

    private RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceArgs() {}

    private RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceArgs(RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceArgs $) {
        this.bucket = $.bucket;
        this.keyPrefixes = $.keyPrefixes;
        this.keys = $.keys;
        this.kmsKeysToGrants = $.kmsKeysToGrants;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceArgs $;

        public Builder() {
            $ = new RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceArgs();
        }

        public Builder(RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceArgs defaults) {
            $ = new RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param bucket The name of the S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder bucket(Output<String> bucket) {
            $.bucket = bucket;
            return this;
        }

        /**
         * @param bucket The name of the S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder bucket(String bucket) {
            return bucket(Output.of(bucket));
        }

        /**
         * @param keyPrefixes List of key prefixes in the S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder keyPrefixes(@Nullable Output<List<String>> keyPrefixes) {
            $.keyPrefixes = keyPrefixes;
            return this;
        }

        /**
         * @param keyPrefixes List of key prefixes in the S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder keyPrefixes(List<String> keyPrefixes) {
            return keyPrefixes(Output.of(keyPrefixes));
        }

        /**
         * @param keyPrefixes List of key prefixes in the S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder keyPrefixes(String... keyPrefixes) {
            return keyPrefixes(List.of(keyPrefixes));
        }

        /**
         * @param keys List of object keys in the S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder keys(@Nullable Output<List<String>> keys) {
            $.keys = keys;
            return this;
        }

        /**
         * @param keys List of object keys in the S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder keys(List<String> keys) {
            return keys(Output.of(keys));
        }

        /**
         * @param keys List of object keys in the S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder keys(String... keys) {
            return keys(List.of(keys));
        }

        public Builder kmsKeysToGrants(@Nullable Output<List<RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceKmsKeysToGrantArgs>> kmsKeysToGrants) {
            $.kmsKeysToGrants = kmsKeysToGrants;
            return this;
        }

        public Builder kmsKeysToGrants(List<RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceKmsKeysToGrantArgs> kmsKeysToGrants) {
            return kmsKeysToGrants(Output.of(kmsKeysToGrants));
        }

        public Builder kmsKeysToGrants(RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceKmsKeysToGrantArgs... kmsKeysToGrants) {
            return kmsKeysToGrants(List.of(kmsKeysToGrants));
        }

        public RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceArgs build() {
            if ($.bucket == null) {
                throw new MissingRequiredPropertyException("RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceArgs", "bucket");
            }
            return $;
        }
    }

}
