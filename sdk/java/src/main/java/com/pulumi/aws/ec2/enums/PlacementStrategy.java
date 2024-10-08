// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.enums;

import com.pulumi.core.annotations.EnumType;
import java.lang.String;
import java.util.Objects;
import java.util.StringJoiner;

    /**
     * The strategy of the placement group determines how the instances are organized within the group.
     * See https://docs.aws.amazon.com/cli/latest/reference/ec2/create-placement-group.html
     * 
     */
    @EnumType
    public enum PlacementStrategy {
        /**
         * A `spread` placement group places instances on distinct hardware.
         * 
         */
        Spread("spread"),
        /**
         * A `cluster` placement group is a logical grouping of instances within a single
         * Availability Zone that benefit from low network latency, high network throughput.
         * 
         */
        Cluster("cluster");

        private final String value;

        PlacementStrategy(String value) {
            this.value = Objects.requireNonNull(value);
        }

        @EnumType.Converter
        public String getValue() {
            return this.value;
        }

        @Override
        public java.lang.String toString() {
            return new StringJoiner(", ", "PlacementStrategy[", "]")
                .add("value='" + this.value + "'")
                .toString();
        }
    }
