// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.computeoptimizer.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class RecommendationPreferencesScopeArgs extends com.pulumi.resources.ResourceArgs {

    public static final RecommendationPreferencesScopeArgs Empty = new RecommendationPreferencesScopeArgs();

    /**
     * The name of the scope. Valid values: `Organization`, `AccountId`, `ResourceArn`.
     * 
     */
    @Import(name="name", required=true)
    private Output<String> name;

    /**
     * @return The name of the scope. Valid values: `Organization`, `AccountId`, `ResourceArn`.
     * 
     */
    public Output<String> name() {
        return this.name;
    }

    /**
     * The value of the scope. `ALL_ACCOUNTS` for `Organization` scopes, AWS account ID for `AccountId` scopes, ARN of an EC2 instance or an Auto Scaling group for `ResourceArn` scopes.
     * 
     */
    @Import(name="value", required=true)
    private Output<String> value;

    /**
     * @return The value of the scope. `ALL_ACCOUNTS` for `Organization` scopes, AWS account ID for `AccountId` scopes, ARN of an EC2 instance or an Auto Scaling group for `ResourceArn` scopes.
     * 
     */
    public Output<String> value() {
        return this.value;
    }

    private RecommendationPreferencesScopeArgs() {}

    private RecommendationPreferencesScopeArgs(RecommendationPreferencesScopeArgs $) {
        this.name = $.name;
        this.value = $.value;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RecommendationPreferencesScopeArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RecommendationPreferencesScopeArgs $;

        public Builder() {
            $ = new RecommendationPreferencesScopeArgs();
        }

        public Builder(RecommendationPreferencesScopeArgs defaults) {
            $ = new RecommendationPreferencesScopeArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param name The name of the scope. Valid values: `Organization`, `AccountId`, `ResourceArn`.
         * 
         * @return builder
         * 
         */
        public Builder name(Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of the scope. Valid values: `Organization`, `AccountId`, `ResourceArn`.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param value The value of the scope. `ALL_ACCOUNTS` for `Organization` scopes, AWS account ID for `AccountId` scopes, ARN of an EC2 instance or an Auto Scaling group for `ResourceArn` scopes.
         * 
         * @return builder
         * 
         */
        public Builder value(Output<String> value) {
            $.value = value;
            return this;
        }

        /**
         * @param value The value of the scope. `ALL_ACCOUNTS` for `Organization` scopes, AWS account ID for `AccountId` scopes, ARN of an EC2 instance or an Auto Scaling group for `ResourceArn` scopes.
         * 
         * @return builder
         * 
         */
        public Builder value(String value) {
            return value(Output.of(value));
        }

        public RecommendationPreferencesScopeArgs build() {
            if ($.name == null) {
                throw new MissingRequiredPropertyException("RecommendationPreferencesScopeArgs", "name");
            }
            if ($.value == null) {
                throw new MissingRequiredPropertyException("RecommendationPreferencesScopeArgs", "value");
            }
            return $;
        }
    }

}
