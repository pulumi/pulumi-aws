// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssm.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class GetPatchBaselinesFilterArgs extends com.pulumi.resources.ResourceArgs {

    public static final GetPatchBaselinesFilterArgs Empty = new GetPatchBaselinesFilterArgs();

    /**
     * Filter key. See the [AWS SSM documentation](https://docs.aws.amazon.com/systems-manager/latest/APIReference/API_DescribePatchBaselines.html) for valid values.
     * 
     */
    @Import(name="key", required=true)
    private Output<String> key;

    /**
     * @return Filter key. See the [AWS SSM documentation](https://docs.aws.amazon.com/systems-manager/latest/APIReference/API_DescribePatchBaselines.html) for valid values.
     * 
     */
    public Output<String> key() {
        return this.key;
    }

    /**
     * Filter values. See the [AWS SSM documentation](https://docs.aws.amazon.com/systems-manager/latest/APIReference/API_DescribePatchBaselines.html) for example values.
     * 
     */
    @Import(name="values", required=true)
    private Output<List<String>> values;

    /**
     * @return Filter values. See the [AWS SSM documentation](https://docs.aws.amazon.com/systems-manager/latest/APIReference/API_DescribePatchBaselines.html) for example values.
     * 
     */
    public Output<List<String>> values() {
        return this.values;
    }

    private GetPatchBaselinesFilterArgs() {}

    private GetPatchBaselinesFilterArgs(GetPatchBaselinesFilterArgs $) {
        this.key = $.key;
        this.values = $.values;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetPatchBaselinesFilterArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetPatchBaselinesFilterArgs $;

        public Builder() {
            $ = new GetPatchBaselinesFilterArgs();
        }

        public Builder(GetPatchBaselinesFilterArgs defaults) {
            $ = new GetPatchBaselinesFilterArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param key Filter key. See the [AWS SSM documentation](https://docs.aws.amazon.com/systems-manager/latest/APIReference/API_DescribePatchBaselines.html) for valid values.
         * 
         * @return builder
         * 
         */
        public Builder key(Output<String> key) {
            $.key = key;
            return this;
        }

        /**
         * @param key Filter key. See the [AWS SSM documentation](https://docs.aws.amazon.com/systems-manager/latest/APIReference/API_DescribePatchBaselines.html) for valid values.
         * 
         * @return builder
         * 
         */
        public Builder key(String key) {
            return key(Output.of(key));
        }

        /**
         * @param values Filter values. See the [AWS SSM documentation](https://docs.aws.amazon.com/systems-manager/latest/APIReference/API_DescribePatchBaselines.html) for example values.
         * 
         * @return builder
         * 
         */
        public Builder values(Output<List<String>> values) {
            $.values = values;
            return this;
        }

        /**
         * @param values Filter values. See the [AWS SSM documentation](https://docs.aws.amazon.com/systems-manager/latest/APIReference/API_DescribePatchBaselines.html) for example values.
         * 
         * @return builder
         * 
         */
        public Builder values(List<String> values) {
            return values(Output.of(values));
        }

        /**
         * @param values Filter values. See the [AWS SSM documentation](https://docs.aws.amazon.com/systems-manager/latest/APIReference/API_DescribePatchBaselines.html) for example values.
         * 
         * @return builder
         * 
         */
        public Builder values(String... values) {
            return values(List.of(values));
        }

        public GetPatchBaselinesFilterArgs build() {
            if ($.key == null) {
                throw new MissingRequiredPropertyException("GetPatchBaselinesFilterArgs", "key");
            }
            if ($.values == null) {
                throw new MissingRequiredPropertyException("GetPatchBaselinesFilterArgs", "values");
            }
            return $;
        }
    }

}
