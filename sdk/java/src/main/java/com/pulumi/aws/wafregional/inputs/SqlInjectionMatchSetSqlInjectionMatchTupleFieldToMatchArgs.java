// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafregional.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class SqlInjectionMatchSetSqlInjectionMatchTupleFieldToMatchArgs extends com.pulumi.resources.ResourceArgs {

    public static final SqlInjectionMatchSetSqlInjectionMatchTupleFieldToMatchArgs Empty = new SqlInjectionMatchSetSqlInjectionMatchTupleFieldToMatchArgs();

    /**
     * When `type` is `HEADER`, enter the name of the header that you want to search, e.g., `User-Agent` or `Referer`.
     * If `type` is any other value, omit this field.
     * 
     */
    @Import(name="data")
    private @Nullable Output<String> data;

    /**
     * @return When `type` is `HEADER`, enter the name of the header that you want to search, e.g., `User-Agent` or `Referer`.
     * If `type` is any other value, omit this field.
     * 
     */
    public Optional<Output<String>> data() {
        return Optional.ofNullable(this.data);
    }

    /**
     * The part of the web request that you want AWS WAF to search for a specified string.
     * e.g., `HEADER`, `METHOD` or `BODY`.
     * See [docs](https://docs.aws.amazon.com/waf/latest/APIReference/API_regional_FieldToMatch.html)
     * for all supported values.
     * 
     */
    @Import(name="type", required=true)
    private Output<String> type;

    /**
     * @return The part of the web request that you want AWS WAF to search for a specified string.
     * e.g., `HEADER`, `METHOD` or `BODY`.
     * See [docs](https://docs.aws.amazon.com/waf/latest/APIReference/API_regional_FieldToMatch.html)
     * for all supported values.
     * 
     */
    public Output<String> type() {
        return this.type;
    }

    private SqlInjectionMatchSetSqlInjectionMatchTupleFieldToMatchArgs() {}

    private SqlInjectionMatchSetSqlInjectionMatchTupleFieldToMatchArgs(SqlInjectionMatchSetSqlInjectionMatchTupleFieldToMatchArgs $) {
        this.data = $.data;
        this.type = $.type;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(SqlInjectionMatchSetSqlInjectionMatchTupleFieldToMatchArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private SqlInjectionMatchSetSqlInjectionMatchTupleFieldToMatchArgs $;

        public Builder() {
            $ = new SqlInjectionMatchSetSqlInjectionMatchTupleFieldToMatchArgs();
        }

        public Builder(SqlInjectionMatchSetSqlInjectionMatchTupleFieldToMatchArgs defaults) {
            $ = new SqlInjectionMatchSetSqlInjectionMatchTupleFieldToMatchArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param data When `type` is `HEADER`, enter the name of the header that you want to search, e.g., `User-Agent` or `Referer`.
         * If `type` is any other value, omit this field.
         * 
         * @return builder
         * 
         */
        public Builder data(@Nullable Output<String> data) {
            $.data = data;
            return this;
        }

        /**
         * @param data When `type` is `HEADER`, enter the name of the header that you want to search, e.g., `User-Agent` or `Referer`.
         * If `type` is any other value, omit this field.
         * 
         * @return builder
         * 
         */
        public Builder data(String data) {
            return data(Output.of(data));
        }

        /**
         * @param type The part of the web request that you want AWS WAF to search for a specified string.
         * e.g., `HEADER`, `METHOD` or `BODY`.
         * See [docs](https://docs.aws.amazon.com/waf/latest/APIReference/API_regional_FieldToMatch.html)
         * for all supported values.
         * 
         * @return builder
         * 
         */
        public Builder type(Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type The part of the web request that you want AWS WAF to search for a specified string.
         * e.g., `HEADER`, `METHOD` or `BODY`.
         * See [docs](https://docs.aws.amazon.com/waf/latest/APIReference/API_regional_FieldToMatch.html)
         * for all supported values.
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        public SqlInjectionMatchSetSqlInjectionMatchTupleFieldToMatchArgs build() {
            if ($.type == null) {
                throw new MissingRequiredPropertyException("SqlInjectionMatchSetSqlInjectionMatchTupleFieldToMatchArgs", "type");
            }
            return $;
        }
    }

}
