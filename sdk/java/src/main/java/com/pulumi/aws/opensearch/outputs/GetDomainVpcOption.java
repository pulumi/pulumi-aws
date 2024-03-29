// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.opensearch.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetDomainVpcOption {
    /**
     * @return Availability zones used by the domain.
     * 
     */
    private List<String> availabilityZones;
    /**
     * @return Security groups used by the domain.
     * 
     */
    private List<String> securityGroupIds;
    /**
     * @return Subnets used by the domain.
     * 
     */
    private List<String> subnetIds;
    /**
     * @return VPC used by the domain.
     * 
     */
    private String vpcId;

    private GetDomainVpcOption() {}
    /**
     * @return Availability zones used by the domain.
     * 
     */
    public List<String> availabilityZones() {
        return this.availabilityZones;
    }
    /**
     * @return Security groups used by the domain.
     * 
     */
    public List<String> securityGroupIds() {
        return this.securityGroupIds;
    }
    /**
     * @return Subnets used by the domain.
     * 
     */
    public List<String> subnetIds() {
        return this.subnetIds;
    }
    /**
     * @return VPC used by the domain.
     * 
     */
    public String vpcId() {
        return this.vpcId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetDomainVpcOption defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<String> availabilityZones;
        private List<String> securityGroupIds;
        private List<String> subnetIds;
        private String vpcId;
        public Builder() {}
        public Builder(GetDomainVpcOption defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.availabilityZones = defaults.availabilityZones;
    	      this.securityGroupIds = defaults.securityGroupIds;
    	      this.subnetIds = defaults.subnetIds;
    	      this.vpcId = defaults.vpcId;
        }

        @CustomType.Setter
        public Builder availabilityZones(List<String> availabilityZones) {
            if (availabilityZones == null) {
              throw new MissingRequiredPropertyException("GetDomainVpcOption", "availabilityZones");
            }
            this.availabilityZones = availabilityZones;
            return this;
        }
        public Builder availabilityZones(String... availabilityZones) {
            return availabilityZones(List.of(availabilityZones));
        }
        @CustomType.Setter
        public Builder securityGroupIds(List<String> securityGroupIds) {
            if (securityGroupIds == null) {
              throw new MissingRequiredPropertyException("GetDomainVpcOption", "securityGroupIds");
            }
            this.securityGroupIds = securityGroupIds;
            return this;
        }
        public Builder securityGroupIds(String... securityGroupIds) {
            return securityGroupIds(List.of(securityGroupIds));
        }
        @CustomType.Setter
        public Builder subnetIds(List<String> subnetIds) {
            if (subnetIds == null) {
              throw new MissingRequiredPropertyException("GetDomainVpcOption", "subnetIds");
            }
            this.subnetIds = subnetIds;
            return this;
        }
        public Builder subnetIds(String... subnetIds) {
            return subnetIds(List.of(subnetIds));
        }
        @CustomType.Setter
        public Builder vpcId(String vpcId) {
            if (vpcId == null) {
              throw new MissingRequiredPropertyException("GetDomainVpcOption", "vpcId");
            }
            this.vpcId = vpcId;
            return this;
        }
        public GetDomainVpcOption build() {
            final var _resultValue = new GetDomainVpcOption();
            _resultValue.availabilityZones = availabilityZones;
            _resultValue.securityGroupIds = securityGroupIds;
            _resultValue.subnetIds = subnetIds;
            _resultValue.vpcId = vpcId;
            return _resultValue;
        }
    }
}
