// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkfirewall.outputs;

import com.pulumi.aws.networkfirewall.outputs.GetFirewallPolicyFirewallPolicy;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class GetFirewallPolicyResult {
    private @Nullable String arn;
    /**
     * @return Description of the firewall policy.
     * 
     */
    private String description;
    /**
     * @return The [policy][2] for the specified firewall policy.
     * 
     */
    private List<GetFirewallPolicyFirewallPolicy> firewallPolicies;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private @Nullable String name;
    /**
     * @return Key-value tags for the firewall policy.
     * 
     */
    private Map<String,String> tags;
    /**
     * @return Token used for optimistic locking.
     * 
     */
    private String updateToken;

    private GetFirewallPolicyResult() {}
    public Optional<String> arn() {
        return Optional.ofNullable(this.arn);
    }
    /**
     * @return Description of the firewall policy.
     * 
     */
    public String description() {
        return this.description;
    }
    /**
     * @return The [policy][2] for the specified firewall policy.
     * 
     */
    public List<GetFirewallPolicyFirewallPolicy> firewallPolicies() {
        return this.firewallPolicies;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    public Optional<String> name() {
        return Optional.ofNullable(this.name);
    }
    /**
     * @return Key-value tags for the firewall policy.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }
    /**
     * @return Token used for optimistic locking.
     * 
     */
    public String updateToken() {
        return this.updateToken;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetFirewallPolicyResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String arn;
        private String description;
        private List<GetFirewallPolicyFirewallPolicy> firewallPolicies;
        private String id;
        private @Nullable String name;
        private Map<String,String> tags;
        private String updateToken;
        public Builder() {}
        public Builder(GetFirewallPolicyResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.description = defaults.description;
    	      this.firewallPolicies = defaults.firewallPolicies;
    	      this.id = defaults.id;
    	      this.name = defaults.name;
    	      this.tags = defaults.tags;
    	      this.updateToken = defaults.updateToken;
        }

        @CustomType.Setter
        public Builder arn(@Nullable String arn) {

            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyResult", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder firewallPolicies(List<GetFirewallPolicyFirewallPolicy> firewallPolicies) {
            if (firewallPolicies == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyResult", "firewallPolicies");
            }
            this.firewallPolicies = firewallPolicies;
            return this;
        }
        public Builder firewallPolicies(GetFirewallPolicyFirewallPolicy... firewallPolicies) {
            return firewallPolicies(List.of(firewallPolicies));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder name(@Nullable String name) {

            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        @CustomType.Setter
        public Builder updateToken(String updateToken) {
            if (updateToken == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyResult", "updateToken");
            }
            this.updateToken = updateToken;
            return this;
        }
        public GetFirewallPolicyResult build() {
            final var _resultValue = new GetFirewallPolicyResult();
            _resultValue.arn = arn;
            _resultValue.description = description;
            _resultValue.firewallPolicies = firewallPolicies;
            _resultValue.id = id;
            _resultValue.name = name;
            _resultValue.tags = tags;
            _resultValue.updateToken = updateToken;
            return _resultValue;
        }
    }
}
