// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ResolverFirewallDomainListArgs extends com.pulumi.resources.ResourceArgs {

    public static final ResolverFirewallDomainListArgs Empty = new ResolverFirewallDomainListArgs();

    /**
     * A array of domains for the firewall domain list.
     * 
     */
    @Import(name="domains")
    private @Nullable Output<List<String>> domains;

    /**
     * @return A array of domains for the firewall domain list.
     * 
     */
    public Optional<Output<List<String>>> domains() {
        return Optional.ofNullable(this.domains);
    }

    /**
     * A name that lets you identify the domain list, to manage and use it.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return A name that lets you identify the domain list, to manage and use it.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * A map of tags to assign to the resource. f configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the resource. f configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private ResolverFirewallDomainListArgs() {}

    private ResolverFirewallDomainListArgs(ResolverFirewallDomainListArgs $) {
        this.domains = $.domains;
        this.name = $.name;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ResolverFirewallDomainListArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ResolverFirewallDomainListArgs $;

        public Builder() {
            $ = new ResolverFirewallDomainListArgs();
        }

        public Builder(ResolverFirewallDomainListArgs defaults) {
            $ = new ResolverFirewallDomainListArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param domains A array of domains for the firewall domain list.
         * 
         * @return builder
         * 
         */
        public Builder domains(@Nullable Output<List<String>> domains) {
            $.domains = domains;
            return this;
        }

        /**
         * @param domains A array of domains for the firewall domain list.
         * 
         * @return builder
         * 
         */
        public Builder domains(List<String> domains) {
            return domains(Output.of(domains));
        }

        /**
         * @param domains A array of domains for the firewall domain list.
         * 
         * @return builder
         * 
         */
        public Builder domains(String... domains) {
            return domains(List.of(domains));
        }

        /**
         * @param name A name that lets you identify the domain list, to manage and use it.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name A name that lets you identify the domain list, to manage and use it.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param tags A map of tags to assign to the resource. f configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags A map of tags to assign to the resource. f configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public ResolverFirewallDomainListArgs build() {
            return $;
        }
    }

}
