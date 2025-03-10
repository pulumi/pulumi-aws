// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codegurureviewer.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class RepositoryAssociationRepositoryS3BucketArgs extends com.pulumi.resources.ResourceArgs {

    public static final RepositoryAssociationRepositoryS3BucketArgs Empty = new RepositoryAssociationRepositoryS3BucketArgs();

    /**
     * The name of the S3 bucket used for associating a new S3 repository. Note: The name must begin with `codeguru-reviewer-`.
     * 
     */
    @Import(name="bucketName", required=true)
    private Output<String> bucketName;

    /**
     * @return The name of the S3 bucket used for associating a new S3 repository. Note: The name must begin with `codeguru-reviewer-`.
     * 
     */
    public Output<String> bucketName() {
        return this.bucketName;
    }

    /**
     * The name of the repository in the S3 bucket.
     * 
     */
    @Import(name="name", required=true)
    private Output<String> name;

    /**
     * @return The name of the repository in the S3 bucket.
     * 
     */
    public Output<String> name() {
        return this.name;
    }

    private RepositoryAssociationRepositoryS3BucketArgs() {}

    private RepositoryAssociationRepositoryS3BucketArgs(RepositoryAssociationRepositoryS3BucketArgs $) {
        this.bucketName = $.bucketName;
        this.name = $.name;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RepositoryAssociationRepositoryS3BucketArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RepositoryAssociationRepositoryS3BucketArgs $;

        public Builder() {
            $ = new RepositoryAssociationRepositoryS3BucketArgs();
        }

        public Builder(RepositoryAssociationRepositoryS3BucketArgs defaults) {
            $ = new RepositoryAssociationRepositoryS3BucketArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param bucketName The name of the S3 bucket used for associating a new S3 repository. Note: The name must begin with `codeguru-reviewer-`.
         * 
         * @return builder
         * 
         */
        public Builder bucketName(Output<String> bucketName) {
            $.bucketName = bucketName;
            return this;
        }

        /**
         * @param bucketName The name of the S3 bucket used for associating a new S3 repository. Note: The name must begin with `codeguru-reviewer-`.
         * 
         * @return builder
         * 
         */
        public Builder bucketName(String bucketName) {
            return bucketName(Output.of(bucketName));
        }

        /**
         * @param name The name of the repository in the S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder name(Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of the repository in the S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        public RepositoryAssociationRepositoryS3BucketArgs build() {
            if ($.bucketName == null) {
                throw new MissingRequiredPropertyException("RepositoryAssociationRepositoryS3BucketArgs", "bucketName");
            }
            if ($.name == null) {
                throw new MissingRequiredPropertyException("RepositoryAssociationRepositoryS3BucketArgs", "name");
            }
            return $;
        }
    }

}
