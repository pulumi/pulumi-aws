// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2transitgateway.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetMulticastDomainAssociation {
    /**
     * @return The ID of the subnet associated with the transit gateway multicast domain.
     * 
     */
    private String subnetId;
    /**
     * @return The ID of the transit gateway attachment.
     * 
     */
    private String transitGatewayAttachmentId;

    private GetMulticastDomainAssociation() {}
    /**
     * @return The ID of the subnet associated with the transit gateway multicast domain.
     * 
     */
    public String subnetId() {
        return this.subnetId;
    }
    /**
     * @return The ID of the transit gateway attachment.
     * 
     */
    public String transitGatewayAttachmentId() {
        return this.transitGatewayAttachmentId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetMulticastDomainAssociation defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String subnetId;
        private String transitGatewayAttachmentId;
        public Builder() {}
        public Builder(GetMulticastDomainAssociation defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.subnetId = defaults.subnetId;
    	      this.transitGatewayAttachmentId = defaults.transitGatewayAttachmentId;
        }

        @CustomType.Setter
        public Builder subnetId(String subnetId) {
            if (subnetId == null) {
              throw new MissingRequiredPropertyException("GetMulticastDomainAssociation", "subnetId");
            }
            this.subnetId = subnetId;
            return this;
        }
        @CustomType.Setter
        public Builder transitGatewayAttachmentId(String transitGatewayAttachmentId) {
            if (transitGatewayAttachmentId == null) {
              throw new MissingRequiredPropertyException("GetMulticastDomainAssociation", "transitGatewayAttachmentId");
            }
            this.transitGatewayAttachmentId = transitGatewayAttachmentId;
            return this;
        }
        public GetMulticastDomainAssociation build() {
            final var _resultValue = new GetMulticastDomainAssociation();
            _resultValue.subnetId = subnetId;
            _resultValue.transitGatewayAttachmentId = transitGatewayAttachmentId;
            return _resultValue;
        }
    }
}
