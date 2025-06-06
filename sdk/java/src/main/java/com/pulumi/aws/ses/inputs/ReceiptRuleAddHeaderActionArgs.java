// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ses.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;


public final class ReceiptRuleAddHeaderActionArgs extends com.pulumi.resources.ResourceArgs {

    public static final ReceiptRuleAddHeaderActionArgs Empty = new ReceiptRuleAddHeaderActionArgs();

    /**
     * The name of the header to add
     * 
     */
    @Import(name="headerName", required=true)
    private Output<String> headerName;

    /**
     * @return The name of the header to add
     * 
     */
    public Output<String> headerName() {
        return this.headerName;
    }

    /**
     * The value of the header to add
     * 
     */
    @Import(name="headerValue", required=true)
    private Output<String> headerValue;

    /**
     * @return The value of the header to add
     * 
     */
    public Output<String> headerValue() {
        return this.headerValue;
    }

    /**
     * The position of the action in the receipt rule
     * 
     */
    @Import(name="position", required=true)
    private Output<Integer> position;

    /**
     * @return The position of the action in the receipt rule
     * 
     */
    public Output<Integer> position() {
        return this.position;
    }

    private ReceiptRuleAddHeaderActionArgs() {}

    private ReceiptRuleAddHeaderActionArgs(ReceiptRuleAddHeaderActionArgs $) {
        this.headerName = $.headerName;
        this.headerValue = $.headerValue;
        this.position = $.position;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ReceiptRuleAddHeaderActionArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ReceiptRuleAddHeaderActionArgs $;

        public Builder() {
            $ = new ReceiptRuleAddHeaderActionArgs();
        }

        public Builder(ReceiptRuleAddHeaderActionArgs defaults) {
            $ = new ReceiptRuleAddHeaderActionArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param headerName The name of the header to add
         * 
         * @return builder
         * 
         */
        public Builder headerName(Output<String> headerName) {
            $.headerName = headerName;
            return this;
        }

        /**
         * @param headerName The name of the header to add
         * 
         * @return builder
         * 
         */
        public Builder headerName(String headerName) {
            return headerName(Output.of(headerName));
        }

        /**
         * @param headerValue The value of the header to add
         * 
         * @return builder
         * 
         */
        public Builder headerValue(Output<String> headerValue) {
            $.headerValue = headerValue;
            return this;
        }

        /**
         * @param headerValue The value of the header to add
         * 
         * @return builder
         * 
         */
        public Builder headerValue(String headerValue) {
            return headerValue(Output.of(headerValue));
        }

        /**
         * @param position The position of the action in the receipt rule
         * 
         * @return builder
         * 
         */
        public Builder position(Output<Integer> position) {
            $.position = position;
            return this;
        }

        /**
         * @param position The position of the action in the receipt rule
         * 
         * @return builder
         * 
         */
        public Builder position(Integer position) {
            return position(Output.of(position));
        }

        public ReceiptRuleAddHeaderActionArgs build() {
            if ($.headerName == null) {
                throw new MissingRequiredPropertyException("ReceiptRuleAddHeaderActionArgs", "headerName");
            }
            if ($.headerValue == null) {
                throw new MissingRequiredPropertyException("ReceiptRuleAddHeaderActionArgs", "headerValue");
            }
            if ($.position == null) {
                throw new MissingRequiredPropertyException("ReceiptRuleAddHeaderActionArgs", "position");
            }
            return $;
        }
    }

}
