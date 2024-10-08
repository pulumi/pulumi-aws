// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockCustomResponseArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockArgs extends com.pulumi.resources.ResourceArgs {

    public static final WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockArgs Empty = new WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockArgs();

    /**
     * Defines a custom response for the web request. See `custom_response` below for details.
     * 
     */
    @Import(name="customResponse")
    private @Nullable Output<WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockCustomResponseArgs> customResponse;

    /**
     * @return Defines a custom response for the web request. See `custom_response` below for details.
     * 
     */
    public Optional<Output<WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockCustomResponseArgs>> customResponse() {
        return Optional.ofNullable(this.customResponse);
    }

    private WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockArgs() {}

    private WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockArgs(WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockArgs $) {
        this.customResponse = $.customResponse;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockArgs $;

        public Builder() {
            $ = new WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockArgs();
        }

        public Builder(WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockArgs defaults) {
            $ = new WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param customResponse Defines a custom response for the web request. See `custom_response` below for details.
         * 
         * @return builder
         * 
         */
        public Builder customResponse(@Nullable Output<WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockCustomResponseArgs> customResponse) {
            $.customResponse = customResponse;
            return this;
        }

        /**
         * @param customResponse Defines a custom response for the web request. See `custom_response` below for details.
         * 
         * @return builder
         * 
         */
        public Builder customResponse(WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockCustomResponseArgs customResponse) {
            return customResponse(Output.of(customResponse));
        }

        public WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockArgs build() {
            return $;
        }
    }

}
