// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class GetResolverFirewallRuleGroupArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetResolverFirewallRuleGroupArgs Empty = new GetResolverFirewallRuleGroupArgs();

    /**
     * The ID of the rule group.
     * 
     */
    @Import(name="firewallRuleGroupId", required=true)
    private Output<String> firewallRuleGroupId;

    /**
     * @return The ID of the rule group.
     * 
     */
    public Output<String> firewallRuleGroupId() {
        return this.firewallRuleGroupId;
    }

    private GetResolverFirewallRuleGroupArgs() {}

    private GetResolverFirewallRuleGroupArgs(GetResolverFirewallRuleGroupArgs $) {
        this.firewallRuleGroupId = $.firewallRuleGroupId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetResolverFirewallRuleGroupArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetResolverFirewallRuleGroupArgs $;

        public Builder() {
            $ = new GetResolverFirewallRuleGroupArgs();
        }

        public Builder(GetResolverFirewallRuleGroupArgs defaults) {
            $ = new GetResolverFirewallRuleGroupArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param firewallRuleGroupId The ID of the rule group.
         * 
         * @return builder
         * 
         */
        public Builder firewallRuleGroupId(Output<String> firewallRuleGroupId) {
            $.firewallRuleGroupId = firewallRuleGroupId;
            return this;
        }

        /**
         * @param firewallRuleGroupId The ID of the rule group.
         * 
         * @return builder
         * 
         */
        public Builder firewallRuleGroupId(String firewallRuleGroupId) {
            return firewallRuleGroupId(Output.of(firewallRuleGroupId));
        }

        public GetResolverFirewallRuleGroupArgs build() {
            if ($.firewallRuleGroupId == null) {
                throw new MissingRequiredPropertyException("GetResolverFirewallRuleGroupArgs", "firewallRuleGroupId");
            }
            return $;
        }
    }

}
