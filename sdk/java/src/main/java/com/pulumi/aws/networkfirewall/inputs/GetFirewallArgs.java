// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkfirewall.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetFirewallArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetFirewallArgs Empty = new GetFirewallArgs();

    /**
     * ARN of the firewall.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN of the firewall.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Descriptive name of the firewall.
     * 
     * One or more of these arguments is required.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Descriptive name of the firewall.
     * 
     * One or more of these arguments is required.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Map of resource tags to associate with the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of resource tags to associate with the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetFirewallArgs() {}

    private GetFirewallArgs(GetFirewallArgs $) {
        this.arn = $.arn;
        this.name = $.name;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetFirewallArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetFirewallArgs $;

        public Builder() {
            $ = new GetFirewallArgs();
        }

        public Builder(GetFirewallArgs defaults) {
            $ = new GetFirewallArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn ARN of the firewall.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN of the firewall.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param name Descriptive name of the firewall.
         * 
         * One or more of these arguments is required.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Descriptive name of the firewall.
         * 
         * One or more of these arguments is required.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param tags Map of resource tags to associate with the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of resource tags to associate with the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public GetFirewallArgs build() {
            return $;
        }
    }

}
