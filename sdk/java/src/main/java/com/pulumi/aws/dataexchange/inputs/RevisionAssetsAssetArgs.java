// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dataexchange.inputs;

import com.pulumi.aws.dataexchange.inputs.RevisionAssetsAssetCreateS3DataAccessFromS3BucketArgs;
import com.pulumi.aws.dataexchange.inputs.RevisionAssetsAssetImportAssetsFromS3Args;
import com.pulumi.aws.dataexchange.inputs.RevisionAssetsAssetImportAssetsFromSignedUrlArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RevisionAssetsAssetArgs extends com.pulumi.resources.ResourceArgs {

    public static final RevisionAssetsAssetArgs Empty = new RevisionAssetsAssetArgs();

    /**
     * The ARN of the Data Exchange Revision Assets.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return The ARN of the Data Exchange Revision Assets.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * A block to create S3 data access from an S3 bucket. See Create S3 Data Access from S3 Bucket for more details.
     * 
     */
    @Import(name="createS3DataAccessFromS3Bucket")
    private @Nullable Output<RevisionAssetsAssetCreateS3DataAccessFromS3BucketArgs> createS3DataAccessFromS3Bucket;

    /**
     * @return A block to create S3 data access from an S3 bucket. See Create S3 Data Access from S3 Bucket for more details.
     * 
     */
    public Optional<Output<RevisionAssetsAssetCreateS3DataAccessFromS3BucketArgs>> createS3DataAccessFromS3Bucket() {
        return Optional.ofNullable(this.createS3DataAccessFromS3Bucket);
    }

    /**
     * The timestamp when the revision was created, in RFC3339 format.
     * 
     */
    @Import(name="createdAt")
    private @Nullable Output<String> createdAt;

    /**
     * @return The timestamp when the revision was created, in RFC3339 format.
     * 
     */
    public Optional<Output<String>> createdAt() {
        return Optional.ofNullable(this.createdAt);
    }

    /**
     * The unique identifier for the revision.
     * 
     */
    @Import(name="id")
    private @Nullable Output<String> id;

    /**
     * @return The unique identifier for the revision.
     * 
     */
    public Optional<Output<String>> id() {
        return Optional.ofNullable(this.id);
    }

    /**
     * A block to import assets from S3. See Import Assets from S3 for more details.
     * 
     */
    @Import(name="importAssetsFromS3")
    private @Nullable Output<RevisionAssetsAssetImportAssetsFromS3Args> importAssetsFromS3;

    /**
     * @return A block to import assets from S3. See Import Assets from S3 for more details.
     * 
     */
    public Optional<Output<RevisionAssetsAssetImportAssetsFromS3Args>> importAssetsFromS3() {
        return Optional.ofNullable(this.importAssetsFromS3);
    }

    /**
     * A block to import assets from a signed URL. See Import Assets from Signed URL for more details.
     * 
     */
    @Import(name="importAssetsFromSignedUrl")
    private @Nullable Output<RevisionAssetsAssetImportAssetsFromSignedUrlArgs> importAssetsFromSignedUrl;

    /**
     * @return A block to import assets from a signed URL. See Import Assets from Signed URL for more details.
     * 
     */
    public Optional<Output<RevisionAssetsAssetImportAssetsFromSignedUrlArgs>> importAssetsFromSignedUrl() {
        return Optional.ofNullable(this.importAssetsFromSignedUrl);
    }

    @Import(name="name")
    private @Nullable Output<String> name;

    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * The timestamp when the revision was last updated, in RFC3339 format.
     * 
     */
    @Import(name="updatedAt")
    private @Nullable Output<String> updatedAt;

    /**
     * @return The timestamp when the revision was last updated, in RFC3339 format.
     * 
     */
    public Optional<Output<String>> updatedAt() {
        return Optional.ofNullable(this.updatedAt);
    }

    private RevisionAssetsAssetArgs() {}

    private RevisionAssetsAssetArgs(RevisionAssetsAssetArgs $) {
        this.arn = $.arn;
        this.createS3DataAccessFromS3Bucket = $.createS3DataAccessFromS3Bucket;
        this.createdAt = $.createdAt;
        this.id = $.id;
        this.importAssetsFromS3 = $.importAssetsFromS3;
        this.importAssetsFromSignedUrl = $.importAssetsFromSignedUrl;
        this.name = $.name;
        this.updatedAt = $.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RevisionAssetsAssetArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RevisionAssetsAssetArgs $;

        public Builder() {
            $ = new RevisionAssetsAssetArgs();
        }

        public Builder(RevisionAssetsAssetArgs defaults) {
            $ = new RevisionAssetsAssetArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn The ARN of the Data Exchange Revision Assets.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn The ARN of the Data Exchange Revision Assets.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param createS3DataAccessFromS3Bucket A block to create S3 data access from an S3 bucket. See Create S3 Data Access from S3 Bucket for more details.
         * 
         * @return builder
         * 
         */
        public Builder createS3DataAccessFromS3Bucket(@Nullable Output<RevisionAssetsAssetCreateS3DataAccessFromS3BucketArgs> createS3DataAccessFromS3Bucket) {
            $.createS3DataAccessFromS3Bucket = createS3DataAccessFromS3Bucket;
            return this;
        }

        /**
         * @param createS3DataAccessFromS3Bucket A block to create S3 data access from an S3 bucket. See Create S3 Data Access from S3 Bucket for more details.
         * 
         * @return builder
         * 
         */
        public Builder createS3DataAccessFromS3Bucket(RevisionAssetsAssetCreateS3DataAccessFromS3BucketArgs createS3DataAccessFromS3Bucket) {
            return createS3DataAccessFromS3Bucket(Output.of(createS3DataAccessFromS3Bucket));
        }

        /**
         * @param createdAt The timestamp when the revision was created, in RFC3339 format.
         * 
         * @return builder
         * 
         */
        public Builder createdAt(@Nullable Output<String> createdAt) {
            $.createdAt = createdAt;
            return this;
        }

        /**
         * @param createdAt The timestamp when the revision was created, in RFC3339 format.
         * 
         * @return builder
         * 
         */
        public Builder createdAt(String createdAt) {
            return createdAt(Output.of(createdAt));
        }

        /**
         * @param id The unique identifier for the revision.
         * 
         * @return builder
         * 
         */
        public Builder id(@Nullable Output<String> id) {
            $.id = id;
            return this;
        }

        /**
         * @param id The unique identifier for the revision.
         * 
         * @return builder
         * 
         */
        public Builder id(String id) {
            return id(Output.of(id));
        }

        /**
         * @param importAssetsFromS3 A block to import assets from S3. See Import Assets from S3 for more details.
         * 
         * @return builder
         * 
         */
        public Builder importAssetsFromS3(@Nullable Output<RevisionAssetsAssetImportAssetsFromS3Args> importAssetsFromS3) {
            $.importAssetsFromS3 = importAssetsFromS3;
            return this;
        }

        /**
         * @param importAssetsFromS3 A block to import assets from S3. See Import Assets from S3 for more details.
         * 
         * @return builder
         * 
         */
        public Builder importAssetsFromS3(RevisionAssetsAssetImportAssetsFromS3Args importAssetsFromS3) {
            return importAssetsFromS3(Output.of(importAssetsFromS3));
        }

        /**
         * @param importAssetsFromSignedUrl A block to import assets from a signed URL. See Import Assets from Signed URL for more details.
         * 
         * @return builder
         * 
         */
        public Builder importAssetsFromSignedUrl(@Nullable Output<RevisionAssetsAssetImportAssetsFromSignedUrlArgs> importAssetsFromSignedUrl) {
            $.importAssetsFromSignedUrl = importAssetsFromSignedUrl;
            return this;
        }

        /**
         * @param importAssetsFromSignedUrl A block to import assets from a signed URL. See Import Assets from Signed URL for more details.
         * 
         * @return builder
         * 
         */
        public Builder importAssetsFromSignedUrl(RevisionAssetsAssetImportAssetsFromSignedUrlArgs importAssetsFromSignedUrl) {
            return importAssetsFromSignedUrl(Output.of(importAssetsFromSignedUrl));
        }

        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param updatedAt The timestamp when the revision was last updated, in RFC3339 format.
         * 
         * @return builder
         * 
         */
        public Builder updatedAt(@Nullable Output<String> updatedAt) {
            $.updatedAt = updatedAt;
            return this;
        }

        /**
         * @param updatedAt The timestamp when the revision was last updated, in RFC3339 format.
         * 
         * @return builder
         * 
         */
        public Builder updatedAt(String updatedAt) {
            return updatedAt(Output.of(updatedAt));
        }

        public RevisionAssetsAssetArgs build() {
            return $;
        }
    }

}
