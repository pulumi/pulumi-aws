// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53recoveryreadiness.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ResourceSetResourceDnsTargetResourceTargetResourceR53ResourceArgs extends com.pulumi.resources.ResourceArgs {

    public static final ResourceSetResourceDnsTargetResourceTargetResourceR53ResourceArgs Empty = new ResourceSetResourceDnsTargetResourceTargetResourceR53ResourceArgs();

    /**
     * DNS Name that acts as the ingress point to a portion of application.
     * 
     */
    @Import(name="domainName")
    private @Nullable Output<String> domainName;

    /**
     * @return DNS Name that acts as the ingress point to a portion of application.
     * 
     */
    public Optional<Output<String>> domainName() {
        return Optional.ofNullable(this.domainName);
    }

    /**
     * Route53 record set id to uniquely identify a record given a `domain_name` and a `record_type`.
     * 
     */
    @Import(name="recordSetId")
    private @Nullable Output<String> recordSetId;

    /**
     * @return Route53 record set id to uniquely identify a record given a `domain_name` and a `record_type`.
     * 
     */
    public Optional<Output<String>> recordSetId() {
        return Optional.ofNullable(this.recordSetId);
    }

    private ResourceSetResourceDnsTargetResourceTargetResourceR53ResourceArgs() {}

    private ResourceSetResourceDnsTargetResourceTargetResourceR53ResourceArgs(ResourceSetResourceDnsTargetResourceTargetResourceR53ResourceArgs $) {
        this.domainName = $.domainName;
        this.recordSetId = $.recordSetId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ResourceSetResourceDnsTargetResourceTargetResourceR53ResourceArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ResourceSetResourceDnsTargetResourceTargetResourceR53ResourceArgs $;

        public Builder() {
            $ = new ResourceSetResourceDnsTargetResourceTargetResourceR53ResourceArgs();
        }

        public Builder(ResourceSetResourceDnsTargetResourceTargetResourceR53ResourceArgs defaults) {
            $ = new ResourceSetResourceDnsTargetResourceTargetResourceR53ResourceArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param domainName DNS Name that acts as the ingress point to a portion of application.
         * 
         * @return builder
         * 
         */
        public Builder domainName(@Nullable Output<String> domainName) {
            $.domainName = domainName;
            return this;
        }

        /**
         * @param domainName DNS Name that acts as the ingress point to a portion of application.
         * 
         * @return builder
         * 
         */
        public Builder domainName(String domainName) {
            return domainName(Output.of(domainName));
        }

        /**
         * @param recordSetId Route53 record set id to uniquely identify a record given a `domain_name` and a `record_type`.
         * 
         * @return builder
         * 
         */
        public Builder recordSetId(@Nullable Output<String> recordSetId) {
            $.recordSetId = recordSetId;
            return this;
        }

        /**
         * @param recordSetId Route53 record set id to uniquely identify a record given a `domain_name` and a `record_type`.
         * 
         * @return builder
         * 
         */
        public Builder recordSetId(String recordSetId) {
            return recordSetId(Output.of(recordSetId));
        }

        public ResourceSetResourceDnsTargetResourceTargetResourceR53ResourceArgs build() {
            return $;
        }
    }

}
