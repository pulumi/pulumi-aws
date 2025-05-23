// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.opensearch.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class OutboundConnectionRemoteDomainInfoArgs extends com.pulumi.resources.ResourceArgs {

    public static final OutboundConnectionRemoteDomainInfoArgs Empty = new OutboundConnectionRemoteDomainInfoArgs();

    /**
     * The name of the remote domain.
     * 
     */
    @Import(name="domainName", required=true)
    private Output<String> domainName;

    /**
     * @return The name of the remote domain.
     * 
     */
    public Output<String> domainName() {
        return this.domainName;
    }

    /**
     * The Account ID of the owner of the remote domain.
     * 
     */
    @Import(name="ownerId", required=true)
    private Output<String> ownerId;

    /**
     * @return The Account ID of the owner of the remote domain.
     * 
     */
    public Output<String> ownerId() {
        return this.ownerId;
    }

    /**
     * The region of the remote domain.
     * 
     */
    @Import(name="region", required=true)
    private Output<String> region;

    /**
     * @return The region of the remote domain.
     * 
     */
    public Output<String> region() {
        return this.region;
    }

    private OutboundConnectionRemoteDomainInfoArgs() {}

    private OutboundConnectionRemoteDomainInfoArgs(OutboundConnectionRemoteDomainInfoArgs $) {
        this.domainName = $.domainName;
        this.ownerId = $.ownerId;
        this.region = $.region;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(OutboundConnectionRemoteDomainInfoArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private OutboundConnectionRemoteDomainInfoArgs $;

        public Builder() {
            $ = new OutboundConnectionRemoteDomainInfoArgs();
        }

        public Builder(OutboundConnectionRemoteDomainInfoArgs defaults) {
            $ = new OutboundConnectionRemoteDomainInfoArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param domainName The name of the remote domain.
         * 
         * @return builder
         * 
         */
        public Builder domainName(Output<String> domainName) {
            $.domainName = domainName;
            return this;
        }

        /**
         * @param domainName The name of the remote domain.
         * 
         * @return builder
         * 
         */
        public Builder domainName(String domainName) {
            return domainName(Output.of(domainName));
        }

        /**
         * @param ownerId The Account ID of the owner of the remote domain.
         * 
         * @return builder
         * 
         */
        public Builder ownerId(Output<String> ownerId) {
            $.ownerId = ownerId;
            return this;
        }

        /**
         * @param ownerId The Account ID of the owner of the remote domain.
         * 
         * @return builder
         * 
         */
        public Builder ownerId(String ownerId) {
            return ownerId(Output.of(ownerId));
        }

        /**
         * @param region The region of the remote domain.
         * 
         * @return builder
         * 
         */
        public Builder region(Output<String> region) {
            $.region = region;
            return this;
        }

        /**
         * @param region The region of the remote domain.
         * 
         * @return builder
         * 
         */
        public Builder region(String region) {
            return region(Output.of(region));
        }

        public OutboundConnectionRemoteDomainInfoArgs build() {
            if ($.domainName == null) {
                throw new MissingRequiredPropertyException("OutboundConnectionRemoteDomainInfoArgs", "domainName");
            }
            if ($.ownerId == null) {
                throw new MissingRequiredPropertyException("OutboundConnectionRemoteDomainInfoArgs", "ownerId");
            }
            if ($.region == null) {
                throw new MissingRequiredPropertyException("OutboundConnectionRemoteDomainInfoArgs", "region");
            }
            return $;
        }
    }

}
