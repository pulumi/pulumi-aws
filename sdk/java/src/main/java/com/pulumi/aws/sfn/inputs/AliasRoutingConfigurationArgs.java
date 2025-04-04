// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sfn.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;


public final class AliasRoutingConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final AliasRoutingConfigurationArgs Empty = new AliasRoutingConfigurationArgs();

    /**
     * The Amazon Resource Name (ARN) of the state machine version.
     * 
     */
    @Import(name="stateMachineVersionArn", required=true)
    private Output<String> stateMachineVersionArn;

    /**
     * @return The Amazon Resource Name (ARN) of the state machine version.
     * 
     */
    public Output<String> stateMachineVersionArn() {
        return this.stateMachineVersionArn;
    }

    /**
     * Percentage of traffic routed to the state machine version.
     * 
     */
    @Import(name="weight", required=true)
    private Output<Integer> weight;

    /**
     * @return Percentage of traffic routed to the state machine version.
     * 
     */
    public Output<Integer> weight() {
        return this.weight;
    }

    private AliasRoutingConfigurationArgs() {}

    private AliasRoutingConfigurationArgs(AliasRoutingConfigurationArgs $) {
        this.stateMachineVersionArn = $.stateMachineVersionArn;
        this.weight = $.weight;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AliasRoutingConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AliasRoutingConfigurationArgs $;

        public Builder() {
            $ = new AliasRoutingConfigurationArgs();
        }

        public Builder(AliasRoutingConfigurationArgs defaults) {
            $ = new AliasRoutingConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param stateMachineVersionArn The Amazon Resource Name (ARN) of the state machine version.
         * 
         * @return builder
         * 
         */
        public Builder stateMachineVersionArn(Output<String> stateMachineVersionArn) {
            $.stateMachineVersionArn = stateMachineVersionArn;
            return this;
        }

        /**
         * @param stateMachineVersionArn The Amazon Resource Name (ARN) of the state machine version.
         * 
         * @return builder
         * 
         */
        public Builder stateMachineVersionArn(String stateMachineVersionArn) {
            return stateMachineVersionArn(Output.of(stateMachineVersionArn));
        }

        /**
         * @param weight Percentage of traffic routed to the state machine version.
         * 
         * @return builder
         * 
         */
        public Builder weight(Output<Integer> weight) {
            $.weight = weight;
            return this;
        }

        /**
         * @param weight Percentage of traffic routed to the state machine version.
         * 
         * @return builder
         * 
         */
        public Builder weight(Integer weight) {
            return weight(Output.of(weight));
        }

        public AliasRoutingConfigurationArgs build() {
            if ($.stateMachineVersionArn == null) {
                throw new MissingRequiredPropertyException("AliasRoutingConfigurationArgs", "stateMachineVersionArn");
            }
            if ($.weight == null) {
                throw new MissingRequiredPropertyException("AliasRoutingConfigurationArgs", "weight");
            }
            return $;
        }
    }

}
