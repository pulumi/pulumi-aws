// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class WebAclLoggingConfigurationLoggingFilterFilterConditionLabelNameConditionArgs extends com.pulumi.resources.ResourceArgs {

    public static final WebAclLoggingConfigurationLoggingFilterFilterConditionLabelNameConditionArgs Empty = new WebAclLoggingConfigurationLoggingFilterFilterConditionLabelNameConditionArgs();

    /**
     * Name of the label that a log record must contain in order to meet the condition. It must be a fully qualified label name, which includes a prefix, optional namespaces, and the label name itself. The prefix identifies the rule group or web ACL context of the rule that added the label.
     * 
     */
    @Import(name="labelName", required=true)
    private Output<String> labelName;

    /**
     * @return Name of the label that a log record must contain in order to meet the condition. It must be a fully qualified label name, which includes a prefix, optional namespaces, and the label name itself. The prefix identifies the rule group or web ACL context of the rule that added the label.
     * 
     */
    public Output<String> labelName() {
        return this.labelName;
    }

    private WebAclLoggingConfigurationLoggingFilterFilterConditionLabelNameConditionArgs() {}

    private WebAclLoggingConfigurationLoggingFilterFilterConditionLabelNameConditionArgs(WebAclLoggingConfigurationLoggingFilterFilterConditionLabelNameConditionArgs $) {
        this.labelName = $.labelName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(WebAclLoggingConfigurationLoggingFilterFilterConditionLabelNameConditionArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private WebAclLoggingConfigurationLoggingFilterFilterConditionLabelNameConditionArgs $;

        public Builder() {
            $ = new WebAclLoggingConfigurationLoggingFilterFilterConditionLabelNameConditionArgs();
        }

        public Builder(WebAclLoggingConfigurationLoggingFilterFilterConditionLabelNameConditionArgs defaults) {
            $ = new WebAclLoggingConfigurationLoggingFilterFilterConditionLabelNameConditionArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param labelName Name of the label that a log record must contain in order to meet the condition. It must be a fully qualified label name, which includes a prefix, optional namespaces, and the label name itself. The prefix identifies the rule group or web ACL context of the rule that added the label.
         * 
         * @return builder
         * 
         */
        public Builder labelName(Output<String> labelName) {
            $.labelName = labelName;
            return this;
        }

        /**
         * @param labelName Name of the label that a log record must contain in order to meet the condition. It must be a fully qualified label name, which includes a prefix, optional namespaces, and the label name itself. The prefix identifies the rule group or web ACL context of the rule that added the label.
         * 
         * @return builder
         * 
         */
        public Builder labelName(String labelName) {
            return labelName(Output.of(labelName));
        }

        public WebAclLoggingConfigurationLoggingFilterFilterConditionLabelNameConditionArgs build() {
            if ($.labelName == null) {
                throw new MissingRequiredPropertyException("WebAclLoggingConfigurationLoggingFilterFilterConditionLabelNameConditionArgs", "labelName");
            }
            return $;
        }
    }

}
