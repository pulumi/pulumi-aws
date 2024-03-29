// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.chime.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;


public final class SdkvoiceSipRuleTargetApplicationArgs extends com.pulumi.resources.ResourceArgs {

    public static final SdkvoiceSipRuleTargetApplicationArgs Empty = new SdkvoiceSipRuleTargetApplicationArgs();

    /**
     * The AWS Region of the target application.
     * 
     */
    @Import(name="awsRegion", required=true)
    private Output<String> awsRegion;

    /**
     * @return The AWS Region of the target application.
     * 
     */
    public Output<String> awsRegion() {
        return this.awsRegion;
    }

    /**
     * Priority of the SIP media application in the target list.
     * 
     */
    @Import(name="priority", required=true)
    private Output<Integer> priority;

    /**
     * @return Priority of the SIP media application in the target list.
     * 
     */
    public Output<Integer> priority() {
        return this.priority;
    }

    /**
     * The SIP media application ID.
     * 
     */
    @Import(name="sipMediaApplicationId", required=true)
    private Output<String> sipMediaApplicationId;

    /**
     * @return The SIP media application ID.
     * 
     */
    public Output<String> sipMediaApplicationId() {
        return this.sipMediaApplicationId;
    }

    private SdkvoiceSipRuleTargetApplicationArgs() {}

    private SdkvoiceSipRuleTargetApplicationArgs(SdkvoiceSipRuleTargetApplicationArgs $) {
        this.awsRegion = $.awsRegion;
        this.priority = $.priority;
        this.sipMediaApplicationId = $.sipMediaApplicationId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(SdkvoiceSipRuleTargetApplicationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private SdkvoiceSipRuleTargetApplicationArgs $;

        public Builder() {
            $ = new SdkvoiceSipRuleTargetApplicationArgs();
        }

        public Builder(SdkvoiceSipRuleTargetApplicationArgs defaults) {
            $ = new SdkvoiceSipRuleTargetApplicationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param awsRegion The AWS Region of the target application.
         * 
         * @return builder
         * 
         */
        public Builder awsRegion(Output<String> awsRegion) {
            $.awsRegion = awsRegion;
            return this;
        }

        /**
         * @param awsRegion The AWS Region of the target application.
         * 
         * @return builder
         * 
         */
        public Builder awsRegion(String awsRegion) {
            return awsRegion(Output.of(awsRegion));
        }

        /**
         * @param priority Priority of the SIP media application in the target list.
         * 
         * @return builder
         * 
         */
        public Builder priority(Output<Integer> priority) {
            $.priority = priority;
            return this;
        }

        /**
         * @param priority Priority of the SIP media application in the target list.
         * 
         * @return builder
         * 
         */
        public Builder priority(Integer priority) {
            return priority(Output.of(priority));
        }

        /**
         * @param sipMediaApplicationId The SIP media application ID.
         * 
         * @return builder
         * 
         */
        public Builder sipMediaApplicationId(Output<String> sipMediaApplicationId) {
            $.sipMediaApplicationId = sipMediaApplicationId;
            return this;
        }

        /**
         * @param sipMediaApplicationId The SIP media application ID.
         * 
         * @return builder
         * 
         */
        public Builder sipMediaApplicationId(String sipMediaApplicationId) {
            return sipMediaApplicationId(Output.of(sipMediaApplicationId));
        }

        public SdkvoiceSipRuleTargetApplicationArgs build() {
            if ($.awsRegion == null) {
                throw new MissingRequiredPropertyException("SdkvoiceSipRuleTargetApplicationArgs", "awsRegion");
            }
            if ($.priority == null) {
                throw new MissingRequiredPropertyException("SdkvoiceSipRuleTargetApplicationArgs", "priority");
            }
            if ($.sipMediaApplicationId == null) {
                throw new MissingRequiredPropertyException("SdkvoiceSipRuleTargetApplicationArgs", "sipMediaApplicationId");
            }
            return $;
        }
    }

}
