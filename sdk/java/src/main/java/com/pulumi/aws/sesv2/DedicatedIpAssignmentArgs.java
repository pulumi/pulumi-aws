// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sesv2;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class DedicatedIpAssignmentArgs extends com.pulumi.resources.ResourceArgs {

    public static final DedicatedIpAssignmentArgs Empty = new DedicatedIpAssignmentArgs();

    /**
     * Dedicated IP address.
     * 
     */
    @Import(name="destinationPoolName", required=true)
    private Output<String> destinationPoolName;

    /**
     * @return Dedicated IP address.
     * 
     */
    public Output<String> destinationPoolName() {
        return this.destinationPoolName;
    }

    /**
     * Dedicated IP address.
     * 
     */
    @Import(name="ip", required=true)
    private Output<String> ip;

    /**
     * @return Dedicated IP address.
     * 
     */
    public Output<String> ip() {
        return this.ip;
    }

    private DedicatedIpAssignmentArgs() {}

    private DedicatedIpAssignmentArgs(DedicatedIpAssignmentArgs $) {
        this.destinationPoolName = $.destinationPoolName;
        this.ip = $.ip;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DedicatedIpAssignmentArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DedicatedIpAssignmentArgs $;

        public Builder() {
            $ = new DedicatedIpAssignmentArgs();
        }

        public Builder(DedicatedIpAssignmentArgs defaults) {
            $ = new DedicatedIpAssignmentArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param destinationPoolName Dedicated IP address.
         * 
         * @return builder
         * 
         */
        public Builder destinationPoolName(Output<String> destinationPoolName) {
            $.destinationPoolName = destinationPoolName;
            return this;
        }

        /**
         * @param destinationPoolName Dedicated IP address.
         * 
         * @return builder
         * 
         */
        public Builder destinationPoolName(String destinationPoolName) {
            return destinationPoolName(Output.of(destinationPoolName));
        }

        /**
         * @param ip Dedicated IP address.
         * 
         * @return builder
         * 
         */
        public Builder ip(Output<String> ip) {
            $.ip = ip;
            return this;
        }

        /**
         * @param ip Dedicated IP address.
         * 
         * @return builder
         * 
         */
        public Builder ip(String ip) {
            return ip(Output.of(ip));
        }

        public DedicatedIpAssignmentArgs build() {
            if ($.destinationPoolName == null) {
                throw new MissingRequiredPropertyException("DedicatedIpAssignmentArgs", "destinationPoolName");
            }
            if ($.ip == null) {
                throw new MissingRequiredPropertyException("DedicatedIpAssignmentArgs", "ip");
            }
            return $;
        }
    }

}
