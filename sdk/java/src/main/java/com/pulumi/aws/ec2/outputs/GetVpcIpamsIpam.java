// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.aws.ec2.outputs.GetVpcIpamsIpamOperatingRegion;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetVpcIpamsIpam {
    /**
     * @return ARN of the IPAM.
     * 
     */
    private String arn;
    /**
     * @return The default resource discovery association ID.
     * 
     */
    private String defaultResourceDiscoveryAssociationId;
    /**
     * @return The default resource discovery ID.
     * 
     */
    private String defaultResourceDiscoveryId;
    /**
     * @return Description for the IPAM.
     * 
     */
    private String description;
    /**
     * @return If private GUA is enabled.
     * 
     */
    private Boolean enablePrivateGua;
    /**
     * @return ID of the IPAM resource.
     * 
     */
    private String id;
    /**
     * @return Region that the IPAM exists in.
     * 
     */
    private String ipamRegion;
    /**
     * @return Regions that the IPAM is configured to operate in.
     * 
     */
    private List<GetVpcIpamsIpamOperatingRegion> operatingRegions;
    /**
     * @return ID of the account that owns this IPAM.
     * 
     */
    private String ownerId;
    /**
     * @return ID of the default private scope.
     * 
     */
    private String privateDefaultScopeId;
    /**
     * @return ID of the default public scope.
     * 
     */
    private String publicDefaultScopeId;
    /**
     * @return Number of resource discovery associations.
     * 
     */
    private Integer resourceDiscoveryAssociationCount;
    /**
     * @return Number of scopes on this IPAM.
     * 
     */
    private Integer scopeCount;
    /**
     * @return Current state of the IPAM.
     * 
     */
    private String state;
    /**
     * @return State message of the IPAM.
     * 
     */
    private String stateMessage;
    /**
     * @return IPAM Tier.
     * 
     */
    private String tier;

    private GetVpcIpamsIpam() {}
    /**
     * @return ARN of the IPAM.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return The default resource discovery association ID.
     * 
     */
    public String defaultResourceDiscoveryAssociationId() {
        return this.defaultResourceDiscoveryAssociationId;
    }
    /**
     * @return The default resource discovery ID.
     * 
     */
    public String defaultResourceDiscoveryId() {
        return this.defaultResourceDiscoveryId;
    }
    /**
     * @return Description for the IPAM.
     * 
     */
    public String description() {
        return this.description;
    }
    /**
     * @return If private GUA is enabled.
     * 
     */
    public Boolean enablePrivateGua() {
        return this.enablePrivateGua;
    }
    /**
     * @return ID of the IPAM resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return Region that the IPAM exists in.
     * 
     */
    public String ipamRegion() {
        return this.ipamRegion;
    }
    /**
     * @return Regions that the IPAM is configured to operate in.
     * 
     */
    public List<GetVpcIpamsIpamOperatingRegion> operatingRegions() {
        return this.operatingRegions;
    }
    /**
     * @return ID of the account that owns this IPAM.
     * 
     */
    public String ownerId() {
        return this.ownerId;
    }
    /**
     * @return ID of the default private scope.
     * 
     */
    public String privateDefaultScopeId() {
        return this.privateDefaultScopeId;
    }
    /**
     * @return ID of the default public scope.
     * 
     */
    public String publicDefaultScopeId() {
        return this.publicDefaultScopeId;
    }
    /**
     * @return Number of resource discovery associations.
     * 
     */
    public Integer resourceDiscoveryAssociationCount() {
        return this.resourceDiscoveryAssociationCount;
    }
    /**
     * @return Number of scopes on this IPAM.
     * 
     */
    public Integer scopeCount() {
        return this.scopeCount;
    }
    /**
     * @return Current state of the IPAM.
     * 
     */
    public String state() {
        return this.state;
    }
    /**
     * @return State message of the IPAM.
     * 
     */
    public String stateMessage() {
        return this.stateMessage;
    }
    /**
     * @return IPAM Tier.
     * 
     */
    public String tier() {
        return this.tier;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetVpcIpamsIpam defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String defaultResourceDiscoveryAssociationId;
        private String defaultResourceDiscoveryId;
        private String description;
        private Boolean enablePrivateGua;
        private String id;
        private String ipamRegion;
        private List<GetVpcIpamsIpamOperatingRegion> operatingRegions;
        private String ownerId;
        private String privateDefaultScopeId;
        private String publicDefaultScopeId;
        private Integer resourceDiscoveryAssociationCount;
        private Integer scopeCount;
        private String state;
        private String stateMessage;
        private String tier;
        public Builder() {}
        public Builder(GetVpcIpamsIpam defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.defaultResourceDiscoveryAssociationId = defaults.defaultResourceDiscoveryAssociationId;
    	      this.defaultResourceDiscoveryId = defaults.defaultResourceDiscoveryId;
    	      this.description = defaults.description;
    	      this.enablePrivateGua = defaults.enablePrivateGua;
    	      this.id = defaults.id;
    	      this.ipamRegion = defaults.ipamRegion;
    	      this.operatingRegions = defaults.operatingRegions;
    	      this.ownerId = defaults.ownerId;
    	      this.privateDefaultScopeId = defaults.privateDefaultScopeId;
    	      this.publicDefaultScopeId = defaults.publicDefaultScopeId;
    	      this.resourceDiscoveryAssociationCount = defaults.resourceDiscoveryAssociationCount;
    	      this.scopeCount = defaults.scopeCount;
    	      this.state = defaults.state;
    	      this.stateMessage = defaults.stateMessage;
    	      this.tier = defaults.tier;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder defaultResourceDiscoveryAssociationId(String defaultResourceDiscoveryAssociationId) {
            if (defaultResourceDiscoveryAssociationId == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "defaultResourceDiscoveryAssociationId");
            }
            this.defaultResourceDiscoveryAssociationId = defaultResourceDiscoveryAssociationId;
            return this;
        }
        @CustomType.Setter
        public Builder defaultResourceDiscoveryId(String defaultResourceDiscoveryId) {
            if (defaultResourceDiscoveryId == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "defaultResourceDiscoveryId");
            }
            this.defaultResourceDiscoveryId = defaultResourceDiscoveryId;
            return this;
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder enablePrivateGua(Boolean enablePrivateGua) {
            if (enablePrivateGua == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "enablePrivateGua");
            }
            this.enablePrivateGua = enablePrivateGua;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder ipamRegion(String ipamRegion) {
            if (ipamRegion == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "ipamRegion");
            }
            this.ipamRegion = ipamRegion;
            return this;
        }
        @CustomType.Setter
        public Builder operatingRegions(List<GetVpcIpamsIpamOperatingRegion> operatingRegions) {
            if (operatingRegions == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "operatingRegions");
            }
            this.operatingRegions = operatingRegions;
            return this;
        }
        public Builder operatingRegions(GetVpcIpamsIpamOperatingRegion... operatingRegions) {
            return operatingRegions(List.of(operatingRegions));
        }
        @CustomType.Setter
        public Builder ownerId(String ownerId) {
            if (ownerId == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "ownerId");
            }
            this.ownerId = ownerId;
            return this;
        }
        @CustomType.Setter
        public Builder privateDefaultScopeId(String privateDefaultScopeId) {
            if (privateDefaultScopeId == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "privateDefaultScopeId");
            }
            this.privateDefaultScopeId = privateDefaultScopeId;
            return this;
        }
        @CustomType.Setter
        public Builder publicDefaultScopeId(String publicDefaultScopeId) {
            if (publicDefaultScopeId == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "publicDefaultScopeId");
            }
            this.publicDefaultScopeId = publicDefaultScopeId;
            return this;
        }
        @CustomType.Setter
        public Builder resourceDiscoveryAssociationCount(Integer resourceDiscoveryAssociationCount) {
            if (resourceDiscoveryAssociationCount == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "resourceDiscoveryAssociationCount");
            }
            this.resourceDiscoveryAssociationCount = resourceDiscoveryAssociationCount;
            return this;
        }
        @CustomType.Setter
        public Builder scopeCount(Integer scopeCount) {
            if (scopeCount == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "scopeCount");
            }
            this.scopeCount = scopeCount;
            return this;
        }
        @CustomType.Setter
        public Builder state(String state) {
            if (state == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "state");
            }
            this.state = state;
            return this;
        }
        @CustomType.Setter
        public Builder stateMessage(String stateMessage) {
            if (stateMessage == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "stateMessage");
            }
            this.stateMessage = stateMessage;
            return this;
        }
        @CustomType.Setter
        public Builder tier(String tier) {
            if (tier == null) {
              throw new MissingRequiredPropertyException("GetVpcIpamsIpam", "tier");
            }
            this.tier = tier;
            return this;
        }
        public GetVpcIpamsIpam build() {
            final var _resultValue = new GetVpcIpamsIpam();
            _resultValue.arn = arn;
            _resultValue.defaultResourceDiscoveryAssociationId = defaultResourceDiscoveryAssociationId;
            _resultValue.defaultResourceDiscoveryId = defaultResourceDiscoveryId;
            _resultValue.description = description;
            _resultValue.enablePrivateGua = enablePrivateGua;
            _resultValue.id = id;
            _resultValue.ipamRegion = ipamRegion;
            _resultValue.operatingRegions = operatingRegions;
            _resultValue.ownerId = ownerId;
            _resultValue.privateDefaultScopeId = privateDefaultScopeId;
            _resultValue.publicDefaultScopeId = publicDefaultScopeId;
            _resultValue.resourceDiscoveryAssociationCount = resourceDiscoveryAssociationCount;
            _resultValue.scopeCount = scopeCount;
            _resultValue.state = state;
            _resultValue.stateMessage = stateMessage;
            _resultValue.tier = tier;
            return _resultValue;
        }
    }
}
