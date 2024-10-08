// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.waf.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class SizeConstraintSetSizeConstraintFieldToMatchArgs extends com.pulumi.resources.ResourceArgs {

    public static final SizeConstraintSetSizeConstraintFieldToMatchArgs Empty = new SizeConstraintSetSizeConstraintFieldToMatchArgs();

    /**
     * When the `type` is `HEADER`, specify the name of the header that you want to search using the `data` field, for example, `User-Agent` or `Referer`. If the `type` is any other value, you can omit this field.
     * 
     */
    @Import(name="data")
    private @Nullable Output<String> data;

    /**
     * @return When the `type` is `HEADER`, specify the name of the header that you want to search using the `data` field, for example, `User-Agent` or `Referer`. If the `type` is any other value, you can omit this field.
     * 
     */
    public Optional<Output<String>> data() {
        return Optional.ofNullable(this.data);
    }

    /**
     * Part of the web request that you want AWS WAF to search for a specified string. For example, `HEADER`, `METHOD`, or `BODY`. See the [docs](http://docs.aws.amazon.com/waf/latest/APIReference/API_FieldToMatch.html) for all supported values.
     * 
     */
    @Import(name="type", required=true)
    private Output<String> type;

    /**
     * @return Part of the web request that you want AWS WAF to search for a specified string. For example, `HEADER`, `METHOD`, or `BODY`. See the [docs](http://docs.aws.amazon.com/waf/latest/APIReference/API_FieldToMatch.html) for all supported values.
     * 
     */
    public Output<String> type() {
        return this.type;
    }

    private SizeConstraintSetSizeConstraintFieldToMatchArgs() {}

    private SizeConstraintSetSizeConstraintFieldToMatchArgs(SizeConstraintSetSizeConstraintFieldToMatchArgs $) {
        this.data = $.data;
        this.type = $.type;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(SizeConstraintSetSizeConstraintFieldToMatchArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private SizeConstraintSetSizeConstraintFieldToMatchArgs $;

        public Builder() {
            $ = new SizeConstraintSetSizeConstraintFieldToMatchArgs();
        }

        public Builder(SizeConstraintSetSizeConstraintFieldToMatchArgs defaults) {
            $ = new SizeConstraintSetSizeConstraintFieldToMatchArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param data When the `type` is `HEADER`, specify the name of the header that you want to search using the `data` field, for example, `User-Agent` or `Referer`. If the `type` is any other value, you can omit this field.
         * 
         * @return builder
         * 
         */
        public Builder data(@Nullable Output<String> data) {
            $.data = data;
            return this;
        }

        /**
         * @param data When the `type` is `HEADER`, specify the name of the header that you want to search using the `data` field, for example, `User-Agent` or `Referer`. If the `type` is any other value, you can omit this field.
         * 
         * @return builder
         * 
         */
        public Builder data(String data) {
            return data(Output.of(data));
        }

        /**
         * @param type Part of the web request that you want AWS WAF to search for a specified string. For example, `HEADER`, `METHOD`, or `BODY`. See the [docs](http://docs.aws.amazon.com/waf/latest/APIReference/API_FieldToMatch.html) for all supported values.
         * 
         * @return builder
         * 
         */
        public Builder type(Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type Part of the web request that you want AWS WAF to search for a specified string. For example, `HEADER`, `METHOD`, or `BODY`. See the [docs](http://docs.aws.amazon.com/waf/latest/APIReference/API_FieldToMatch.html) for all supported values.
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        public SizeConstraintSetSizeConstraintFieldToMatchArgs build() {
            if ($.type == null) {
                throw new MissingRequiredPropertyException("SizeConstraintSetSizeConstraintFieldToMatchArgs", "type");
            }
            return $;
        }
    }

}
