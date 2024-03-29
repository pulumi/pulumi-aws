// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.eks.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetAccessEntryPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetAccessEntryPlainArgs Empty = new GetAccessEntryPlainArgs();

    /**
     * Name of the EKS Cluster.
     * 
     */
    @Import(name="clusterName", required=true)
    private String clusterName;

    /**
     * @return Name of the EKS Cluster.
     * 
     */
    public String clusterName() {
        return this.clusterName;
    }

    /**
     * The IAM Principal ARN which requires Authentication access to the EKS cluster.
     * 
     */
    @Import(name="principalArn", required=true)
    private String principalArn;

    /**
     * @return The IAM Principal ARN which requires Authentication access to the EKS cluster.
     * 
     */
    public String principalArn() {
        return this.principalArn;
    }

    @Import(name="tags")
    private @Nullable Map<String,String> tags;

    public Optional<Map<String,String>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetAccessEntryPlainArgs() {}

    private GetAccessEntryPlainArgs(GetAccessEntryPlainArgs $) {
        this.clusterName = $.clusterName;
        this.principalArn = $.principalArn;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetAccessEntryPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetAccessEntryPlainArgs $;

        public Builder() {
            $ = new GetAccessEntryPlainArgs();
        }

        public Builder(GetAccessEntryPlainArgs defaults) {
            $ = new GetAccessEntryPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param clusterName Name of the EKS Cluster.
         * 
         * @return builder
         * 
         */
        public Builder clusterName(String clusterName) {
            $.clusterName = clusterName;
            return this;
        }

        /**
         * @param principalArn The IAM Principal ARN which requires Authentication access to the EKS cluster.
         * 
         * @return builder
         * 
         */
        public Builder principalArn(String principalArn) {
            $.principalArn = principalArn;
            return this;
        }

        public Builder tags(@Nullable Map<String,String> tags) {
            $.tags = tags;
            return this;
        }

        public GetAccessEntryPlainArgs build() {
            if ($.clusterName == null) {
                throw new MissingRequiredPropertyException("GetAccessEntryPlainArgs", "clusterName");
            }
            if ($.principalArn == null) {
                throw new MissingRequiredPropertyException("GetAccessEntryPlainArgs", "principalArn");
            }
            return $;
        }
    }

}
