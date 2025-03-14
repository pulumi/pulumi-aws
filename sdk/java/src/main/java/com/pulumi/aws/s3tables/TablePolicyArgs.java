// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3tables;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class TablePolicyArgs extends com.pulumi.resources.ResourceArgs {

    public static final TablePolicyArgs Empty = new TablePolicyArgs();

    /**
     * Name of the table.
     * Must be between 1 and 255 characters in length.
     * Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name of the table.
     * Must be between 1 and 255 characters in length.
     * Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Name of the namespace for this table.
     * Must be between 1 and 255 characters in length.
     * Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
     * 
     */
    @Import(name="namespace", required=true)
    private Output<String> namespace;

    /**
     * @return Name of the namespace for this table.
     * Must be between 1 and 255 characters in length.
     * Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
     * 
     */
    public Output<String> namespace() {
        return this.namespace;
    }

    /**
     * Amazon Web Services resource-based policy document in JSON format.
     * 
     */
    @Import(name="resourcePolicy", required=true)
    private Output<String> resourcePolicy;

    /**
     * @return Amazon Web Services resource-based policy document in JSON format.
     * 
     */
    public Output<String> resourcePolicy() {
        return this.resourcePolicy;
    }

    /**
     * ARN referencing the Table Bucket that contains this Namespace.
     * 
     */
    @Import(name="tableBucketArn", required=true)
    private Output<String> tableBucketArn;

    /**
     * @return ARN referencing the Table Bucket that contains this Namespace.
     * 
     */
    public Output<String> tableBucketArn() {
        return this.tableBucketArn;
    }

    private TablePolicyArgs() {}

    private TablePolicyArgs(TablePolicyArgs $) {
        this.name = $.name;
        this.namespace = $.namespace;
        this.resourcePolicy = $.resourcePolicy;
        this.tableBucketArn = $.tableBucketArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(TablePolicyArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private TablePolicyArgs $;

        public Builder() {
            $ = new TablePolicyArgs();
        }

        public Builder(TablePolicyArgs defaults) {
            $ = new TablePolicyArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param name Name of the table.
         * Must be between 1 and 255 characters in length.
         * Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the table.
         * Must be between 1 and 255 characters in length.
         * Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param namespace Name of the namespace for this table.
         * Must be between 1 and 255 characters in length.
         * Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
         * 
         * @return builder
         * 
         */
        public Builder namespace(Output<String> namespace) {
            $.namespace = namespace;
            return this;
        }

        /**
         * @param namespace Name of the namespace for this table.
         * Must be between 1 and 255 characters in length.
         * Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
         * 
         * @return builder
         * 
         */
        public Builder namespace(String namespace) {
            return namespace(Output.of(namespace));
        }

        /**
         * @param resourcePolicy Amazon Web Services resource-based policy document in JSON format.
         * 
         * @return builder
         * 
         */
        public Builder resourcePolicy(Output<String> resourcePolicy) {
            $.resourcePolicy = resourcePolicy;
            return this;
        }

        /**
         * @param resourcePolicy Amazon Web Services resource-based policy document in JSON format.
         * 
         * @return builder
         * 
         */
        public Builder resourcePolicy(String resourcePolicy) {
            return resourcePolicy(Output.of(resourcePolicy));
        }

        /**
         * @param tableBucketArn ARN referencing the Table Bucket that contains this Namespace.
         * 
         * @return builder
         * 
         */
        public Builder tableBucketArn(Output<String> tableBucketArn) {
            $.tableBucketArn = tableBucketArn;
            return this;
        }

        /**
         * @param tableBucketArn ARN referencing the Table Bucket that contains this Namespace.
         * 
         * @return builder
         * 
         */
        public Builder tableBucketArn(String tableBucketArn) {
            return tableBucketArn(Output.of(tableBucketArn));
        }

        public TablePolicyArgs build() {
            if ($.namespace == null) {
                throw new MissingRequiredPropertyException("TablePolicyArgs", "namespace");
            }
            if ($.resourcePolicy == null) {
                throw new MissingRequiredPropertyException("TablePolicyArgs", "resourcePolicy");
            }
            if ($.tableBucketArn == null) {
                throw new MissingRequiredPropertyException("TablePolicyArgs", "tableBucketArn");
            }
            return $;
        }
    }

}
