// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class GetResolverFirewallDomainListPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetResolverFirewallDomainListPlainArgs Empty = new GetResolverFirewallDomainListPlainArgs();

    /**
     * The ID of the domain list.
     * 
     */
    @Import(name="firewallDomainListId", required=true)
    private String firewallDomainListId;

    /**
     * @return The ID of the domain list.
     * 
     */
    public String firewallDomainListId() {
        return this.firewallDomainListId;
    }

    private GetResolverFirewallDomainListPlainArgs() {}

    private GetResolverFirewallDomainListPlainArgs(GetResolverFirewallDomainListPlainArgs $) {
        this.firewallDomainListId = $.firewallDomainListId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetResolverFirewallDomainListPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetResolverFirewallDomainListPlainArgs $;

        public Builder() {
            $ = new GetResolverFirewallDomainListPlainArgs();
        }

        public Builder(GetResolverFirewallDomainListPlainArgs defaults) {
            $ = new GetResolverFirewallDomainListPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param firewallDomainListId The ID of the domain list.
         * 
         * @return builder
         * 
         */
        public Builder firewallDomainListId(String firewallDomainListId) {
            $.firewallDomainListId = firewallDomainListId;
            return this;
        }

        public GetResolverFirewallDomainListPlainArgs build() {
            if ($.firewallDomainListId == null) {
                throw new MissingRequiredPropertyException("GetResolverFirewallDomainListPlainArgs", "firewallDomainListId");
            }
            return $;
        }
    }

}
