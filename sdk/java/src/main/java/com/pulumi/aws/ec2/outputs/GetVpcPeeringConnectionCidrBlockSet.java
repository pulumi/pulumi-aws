// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetVpcPeeringConnectionCidrBlockSet {
    /**
     * @return Primary CIDR block of the requester VPC of the specific VPC Peering Connection to retrieve.
     * 
     */
    private String cidrBlock;

    private GetVpcPeeringConnectionCidrBlockSet() {}
    /**
     * @return Primary CIDR block of the requester VPC of the specific VPC Peering Connection to retrieve.
     * 
     */
    public String cidrBlock() {
        return this.cidrBlock;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetVpcPeeringConnectionCidrBlockSet defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String cidrBlock;
        public Builder() {}
        public Builder(GetVpcPeeringConnectionCidrBlockSet defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.cidrBlock = defaults.cidrBlock;
        }

        @CustomType.Setter
        public Builder cidrBlock(String cidrBlock) {
            if (cidrBlock == null) {
              throw new MissingRequiredPropertyException("GetVpcPeeringConnectionCidrBlockSet", "cidrBlock");
            }
            this.cidrBlock = cidrBlock;
            return this;
        }
        public GetVpcPeeringConnectionCidrBlockSet build() {
            final var _resultValue = new GetVpcPeeringConnectionCidrBlockSet();
            _resultValue.cidrBlock = cidrBlock;
            return _resultValue;
        }
    }
}
