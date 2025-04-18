// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lakeformation.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class GetPermissionsLfTagPolicyExpressionArgs extends com.pulumi.resources.ResourceArgs {

    public static final GetPermissionsLfTagPolicyExpressionArgs Empty = new GetPermissionsLfTagPolicyExpressionArgs();

    /**
     * Key-name of an LF-Tag.
     * 
     */
    @Import(name="key", required=true)
    private Output<String> key;

    /**
     * @return Key-name of an LF-Tag.
     * 
     */
    public Output<String> key() {
        return this.key;
    }

    /**
     * List of possible values of an LF-Tag.
     * 
     */
    @Import(name="values", required=true)
    private Output<List<String>> values;

    /**
     * @return List of possible values of an LF-Tag.
     * 
     */
    public Output<List<String>> values() {
        return this.values;
    }

    private GetPermissionsLfTagPolicyExpressionArgs() {}

    private GetPermissionsLfTagPolicyExpressionArgs(GetPermissionsLfTagPolicyExpressionArgs $) {
        this.key = $.key;
        this.values = $.values;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetPermissionsLfTagPolicyExpressionArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetPermissionsLfTagPolicyExpressionArgs $;

        public Builder() {
            $ = new GetPermissionsLfTagPolicyExpressionArgs();
        }

        public Builder(GetPermissionsLfTagPolicyExpressionArgs defaults) {
            $ = new GetPermissionsLfTagPolicyExpressionArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param key Key-name of an LF-Tag.
         * 
         * @return builder
         * 
         */
        public Builder key(Output<String> key) {
            $.key = key;
            return this;
        }

        /**
         * @param key Key-name of an LF-Tag.
         * 
         * @return builder
         * 
         */
        public Builder key(String key) {
            return key(Output.of(key));
        }

        /**
         * @param values List of possible values of an LF-Tag.
         * 
         * @return builder
         * 
         */
        public Builder values(Output<List<String>> values) {
            $.values = values;
            return this;
        }

        /**
         * @param values List of possible values of an LF-Tag.
         * 
         * @return builder
         * 
         */
        public Builder values(List<String> values) {
            return values(Output.of(values));
        }

        /**
         * @param values List of possible values of an LF-Tag.
         * 
         * @return builder
         * 
         */
        public Builder values(String... values) {
            return values(List.of(values));
        }

        public GetPermissionsLfTagPolicyExpressionArgs build() {
            if ($.key == null) {
                throw new MissingRequiredPropertyException("GetPermissionsLfTagPolicyExpressionArgs", "key");
            }
            if ($.values == null) {
                throw new MissingRequiredPropertyException("GetPermissionsLfTagPolicyExpressionArgs", "values");
            }
            return $;
        }
    }

}
