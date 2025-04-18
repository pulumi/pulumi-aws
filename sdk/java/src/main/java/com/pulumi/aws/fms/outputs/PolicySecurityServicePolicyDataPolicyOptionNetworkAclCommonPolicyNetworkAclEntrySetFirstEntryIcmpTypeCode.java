// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.fms.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Integer;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCode {
    /**
     * @return An integer value containing ICMP code.
     * 
     */
    private @Nullable Integer code;
    /**
     * @return An integer value containing ICMP type.
     * 
     */
    private @Nullable Integer type;

    private PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCode() {}
    /**
     * @return An integer value containing ICMP code.
     * 
     */
    public Optional<Integer> code() {
        return Optional.ofNullable(this.code);
    }
    /**
     * @return An integer value containing ICMP type.
     * 
     */
    public Optional<Integer> type() {
        return Optional.ofNullable(this.type);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCode defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Integer code;
        private @Nullable Integer type;
        public Builder() {}
        public Builder(PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCode defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.code = defaults.code;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder code(@Nullable Integer code) {

            this.code = code;
            return this;
        }
        @CustomType.Setter
        public Builder type(@Nullable Integer type) {

            this.type = type;
            return this;
        }
        public PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCode build() {
            final var _resultValue = new PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCode();
            _resultValue.code = code;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
