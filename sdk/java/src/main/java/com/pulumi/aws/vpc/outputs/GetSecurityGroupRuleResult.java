// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.vpc.outputs;

import com.pulumi.aws.vpc.outputs.GetSecurityGroupRuleFilter;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class GetSecurityGroupRuleResult {
    /**
     * @return The Amazon Resource Name (ARN) of the security group rule.
     * 
     */
    private String arn;
    /**
     * @return The destination IPv4 CIDR range.
     * 
     */
    private String cidrIpv4;
    /**
     * @return The destination IPv6 CIDR range.
     * 
     */
    private String cidrIpv6;
    /**
     * @return The security group rule description.
     * 
     */
    private String description;
    private @Nullable List<GetSecurityGroupRuleFilter> filters;
    /**
     * @return The start of port range for the TCP and UDP protocols, or an ICMP/ICMPv6 type.
     * 
     */
    private Integer fromPort;
    private String id;
    /**
     * @return The IP protocol name or number. Use `-1` to specify all protocols.
     * 
     */
    private String ipProtocol;
    /**
     * @return Indicates whether the security group rule is an outbound rule.
     * 
     */
    private Boolean isEgress;
    /**
     * @return The ID of the destination prefix list.
     * 
     */
    private String prefixListId;
    /**
     * @return The destination security group that is referenced in the rule.
     * 
     */
    private String referencedSecurityGroupId;
    /**
     * @return The ID of the security group.
     * 
     */
    private String securityGroupId;
    private String securityGroupRuleId;
    /**
     * @return A map of tags assigned to the resource.
     * 
     */
    private Map<String,String> tags;
    /**
     * @return (Optional) The end of port range for the TCP and UDP protocols, or an ICMP/ICMPv6 code.
     * 
     */
    private Integer toPort;

    private GetSecurityGroupRuleResult() {}
    /**
     * @return The Amazon Resource Name (ARN) of the security group rule.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return The destination IPv4 CIDR range.
     * 
     */
    public String cidrIpv4() {
        return this.cidrIpv4;
    }
    /**
     * @return The destination IPv6 CIDR range.
     * 
     */
    public String cidrIpv6() {
        return this.cidrIpv6;
    }
    /**
     * @return The security group rule description.
     * 
     */
    public String description() {
        return this.description;
    }
    public List<GetSecurityGroupRuleFilter> filters() {
        return this.filters == null ? List.of() : this.filters;
    }
    /**
     * @return The start of port range for the TCP and UDP protocols, or an ICMP/ICMPv6 type.
     * 
     */
    public Integer fromPort() {
        return this.fromPort;
    }
    public String id() {
        return this.id;
    }
    /**
     * @return The IP protocol name or number. Use `-1` to specify all protocols.
     * 
     */
    public String ipProtocol() {
        return this.ipProtocol;
    }
    /**
     * @return Indicates whether the security group rule is an outbound rule.
     * 
     */
    public Boolean isEgress() {
        return this.isEgress;
    }
    /**
     * @return The ID of the destination prefix list.
     * 
     */
    public String prefixListId() {
        return this.prefixListId;
    }
    /**
     * @return The destination security group that is referenced in the rule.
     * 
     */
    public String referencedSecurityGroupId() {
        return this.referencedSecurityGroupId;
    }
    /**
     * @return The ID of the security group.
     * 
     */
    public String securityGroupId() {
        return this.securityGroupId;
    }
    public String securityGroupRuleId() {
        return this.securityGroupRuleId;
    }
    /**
     * @return A map of tags assigned to the resource.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }
    /**
     * @return (Optional) The end of port range for the TCP and UDP protocols, or an ICMP/ICMPv6 code.
     * 
     */
    public Integer toPort() {
        return this.toPort;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetSecurityGroupRuleResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String cidrIpv4;
        private String cidrIpv6;
        private String description;
        private @Nullable List<GetSecurityGroupRuleFilter> filters;
        private Integer fromPort;
        private String id;
        private String ipProtocol;
        private Boolean isEgress;
        private String prefixListId;
        private String referencedSecurityGroupId;
        private String securityGroupId;
        private String securityGroupRuleId;
        private Map<String,String> tags;
        private Integer toPort;
        public Builder() {}
        public Builder(GetSecurityGroupRuleResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.cidrIpv4 = defaults.cidrIpv4;
    	      this.cidrIpv6 = defaults.cidrIpv6;
    	      this.description = defaults.description;
    	      this.filters = defaults.filters;
    	      this.fromPort = defaults.fromPort;
    	      this.id = defaults.id;
    	      this.ipProtocol = defaults.ipProtocol;
    	      this.isEgress = defaults.isEgress;
    	      this.prefixListId = defaults.prefixListId;
    	      this.referencedSecurityGroupId = defaults.referencedSecurityGroupId;
    	      this.securityGroupId = defaults.securityGroupId;
    	      this.securityGroupRuleId = defaults.securityGroupRuleId;
    	      this.tags = defaults.tags;
    	      this.toPort = defaults.toPort;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder cidrIpv4(String cidrIpv4) {
            if (cidrIpv4 == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "cidrIpv4");
            }
            this.cidrIpv4 = cidrIpv4;
            return this;
        }
        @CustomType.Setter
        public Builder cidrIpv6(String cidrIpv6) {
            if (cidrIpv6 == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "cidrIpv6");
            }
            this.cidrIpv6 = cidrIpv6;
            return this;
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder filters(@Nullable List<GetSecurityGroupRuleFilter> filters) {

            this.filters = filters;
            return this;
        }
        public Builder filters(GetSecurityGroupRuleFilter... filters) {
            return filters(List.of(filters));
        }
        @CustomType.Setter
        public Builder fromPort(Integer fromPort) {
            if (fromPort == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "fromPort");
            }
            this.fromPort = fromPort;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder ipProtocol(String ipProtocol) {
            if (ipProtocol == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "ipProtocol");
            }
            this.ipProtocol = ipProtocol;
            return this;
        }
        @CustomType.Setter
        public Builder isEgress(Boolean isEgress) {
            if (isEgress == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "isEgress");
            }
            this.isEgress = isEgress;
            return this;
        }
        @CustomType.Setter
        public Builder prefixListId(String prefixListId) {
            if (prefixListId == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "prefixListId");
            }
            this.prefixListId = prefixListId;
            return this;
        }
        @CustomType.Setter
        public Builder referencedSecurityGroupId(String referencedSecurityGroupId) {
            if (referencedSecurityGroupId == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "referencedSecurityGroupId");
            }
            this.referencedSecurityGroupId = referencedSecurityGroupId;
            return this;
        }
        @CustomType.Setter
        public Builder securityGroupId(String securityGroupId) {
            if (securityGroupId == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "securityGroupId");
            }
            this.securityGroupId = securityGroupId;
            return this;
        }
        @CustomType.Setter
        public Builder securityGroupRuleId(String securityGroupRuleId) {
            if (securityGroupRuleId == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "securityGroupRuleId");
            }
            this.securityGroupRuleId = securityGroupRuleId;
            return this;
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        @CustomType.Setter
        public Builder toPort(Integer toPort) {
            if (toPort == null) {
              throw new MissingRequiredPropertyException("GetSecurityGroupRuleResult", "toPort");
            }
            this.toPort = toPort;
            return this;
        }
        public GetSecurityGroupRuleResult build() {
            final var _resultValue = new GetSecurityGroupRuleResult();
            _resultValue.arn = arn;
            _resultValue.cidrIpv4 = cidrIpv4;
            _resultValue.cidrIpv6 = cidrIpv6;
            _resultValue.description = description;
            _resultValue.filters = filters;
            _resultValue.fromPort = fromPort;
            _resultValue.id = id;
            _resultValue.ipProtocol = ipProtocol;
            _resultValue.isEgress = isEgress;
            _resultValue.prefixListId = prefixListId;
            _resultValue.referencedSecurityGroupId = referencedSecurityGroupId;
            _resultValue.securityGroupId = securityGroupId;
            _resultValue.securityGroupRuleId = securityGroupRuleId;
            _resultValue.tags = tags;
            _resultValue.toPort = toPort;
            return _resultValue;
        }
    }
}
