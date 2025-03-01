// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.aws.ec2.outputs.GetVpcEndpointDnsEntry;
import com.pulumi.aws.ec2.outputs.GetVpcEndpointDnsOption;
import com.pulumi.aws.ec2.outputs.GetVpcEndpointFilter;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class GetVpcEndpointResult {
    /**
     * @return ARN of the VPC endpoint.
     * 
     */
    private String arn;
    /**
     * @return List of CIDR blocks for the exposed AWS service. Applicable for endpoints of type `Gateway`.
     * 
     */
    private List<String> cidrBlocks;
    /**
     * @return DNS entries for the VPC Endpoint. Applicable for endpoints of type `Interface`. DNS entry blocks are documented below.
     * 
     */
    private List<GetVpcEndpointDnsEntry> dnsEntries;
    /**
     * @return DNS options for the VPC Endpoint. DNS options blocks are documented below.
     * 
     */
    private List<GetVpcEndpointDnsOption> dnsOptions;
    private @Nullable List<GetVpcEndpointFilter> filters;
    private String id;
    private String ipAddressType;
    /**
     * @return One or more network interfaces for the VPC Endpoint. Applicable for endpoints of type `Interface`.
     * 
     */
    private List<String> networkInterfaceIds;
    /**
     * @return ID of the AWS account that owns the VPC endpoint.
     * 
     */
    private String ownerId;
    /**
     * @return Policy document associated with the VPC Endpoint. Applicable for endpoints of type `Gateway`.
     * 
     */
    private String policy;
    /**
     * @return Prefix list ID of the exposed AWS service. Applicable for endpoints of type `Gateway`.
     * 
     */
    private String prefixListId;
    /**
     * @return Whether or not the VPC is associated with a private hosted zone - `true` or `false`. Applicable for endpoints of type `Interface`.
     * 
     */
    private Boolean privateDnsEnabled;
    /**
     * @return Whether or not the VPC Endpoint is being managed by its service - `true` or `false`.
     * 
     */
    private Boolean requesterManaged;
    /**
     * @return One or more route tables associated with the VPC Endpoint. Applicable for endpoints of type `Gateway`.
     * 
     */
    private List<String> routeTableIds;
    /**
     * @return One or more security groups associated with the network interfaces. Applicable for endpoints of type `Interface`.
     * 
     */
    private List<String> securityGroupIds;
    private String serviceName;
    private String state;
    /**
     * @return One or more subnets in which the VPC Endpoint is located. Applicable for endpoints of type `Interface`.
     * 
     */
    private List<String> subnetIds;
    private Map<String,String> tags;
    /**
     * @return VPC Endpoint type, `Gateway` or `Interface`.
     * 
     */
    private String vpcEndpointType;
    private String vpcId;

    private GetVpcEndpointResult() {}
    /**
     * @return ARN of the VPC endpoint.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return List of CIDR blocks for the exposed AWS service. Applicable for endpoints of type `Gateway`.
     * 
     */
    public List<String> cidrBlocks() {
        return this.cidrBlocks;
    }
    /**
     * @return DNS entries for the VPC Endpoint. Applicable for endpoints of type `Interface`. DNS entry blocks are documented below.
     * 
     */
    public List<GetVpcEndpointDnsEntry> dnsEntries() {
        return this.dnsEntries;
    }
    /**
     * @return DNS options for the VPC Endpoint. DNS options blocks are documented below.
     * 
     */
    public List<GetVpcEndpointDnsOption> dnsOptions() {
        return this.dnsOptions;
    }
    public List<GetVpcEndpointFilter> filters() {
        return this.filters == null ? List.of() : this.filters;
    }
    public String id() {
        return this.id;
    }
    public String ipAddressType() {
        return this.ipAddressType;
    }
    /**
     * @return One or more network interfaces for the VPC Endpoint. Applicable for endpoints of type `Interface`.
     * 
     */
    public List<String> networkInterfaceIds() {
        return this.networkInterfaceIds;
    }
    /**
     * @return ID of the AWS account that owns the VPC endpoint.
     * 
     */
    public String ownerId() {
        return this.ownerId;
    }
    /**
     * @return Policy document associated with the VPC Endpoint. Applicable for endpoints of type `Gateway`.
     * 
     */
    public String policy() {
        return this.policy;
    }
    /**
     * @return Prefix list ID of the exposed AWS service. Applicable for endpoints of type `Gateway`.
     * 
     */
    public String prefixListId() {
        return this.prefixListId;
    }
    /**
     * @return Whether or not the VPC is associated with a private hosted zone - `true` or `false`. Applicable for endpoints of type `Interface`.
     * 
     */
    public Boolean privateDnsEnabled() {
        return this.privateDnsEnabled;
    }
    /**
     * @return Whether or not the VPC Endpoint is being managed by its service - `true` or `false`.
     * 
     */
    public Boolean requesterManaged() {
        return this.requesterManaged;
    }
    /**
     * @return One or more route tables associated with the VPC Endpoint. Applicable for endpoints of type `Gateway`.
     * 
     */
    public List<String> routeTableIds() {
        return this.routeTableIds;
    }
    /**
     * @return One or more security groups associated with the network interfaces. Applicable for endpoints of type `Interface`.
     * 
     */
    public List<String> securityGroupIds() {
        return this.securityGroupIds;
    }
    public String serviceName() {
        return this.serviceName;
    }
    public String state() {
        return this.state;
    }
    /**
     * @return One or more subnets in which the VPC Endpoint is located. Applicable for endpoints of type `Interface`.
     * 
     */
    public List<String> subnetIds() {
        return this.subnetIds;
    }
    public Map<String,String> tags() {
        return this.tags;
    }
    /**
     * @return VPC Endpoint type, `Gateway` or `Interface`.
     * 
     */
    public String vpcEndpointType() {
        return this.vpcEndpointType;
    }
    public String vpcId() {
        return this.vpcId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetVpcEndpointResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private List<String> cidrBlocks;
        private List<GetVpcEndpointDnsEntry> dnsEntries;
        private List<GetVpcEndpointDnsOption> dnsOptions;
        private @Nullable List<GetVpcEndpointFilter> filters;
        private String id;
        private String ipAddressType;
        private List<String> networkInterfaceIds;
        private String ownerId;
        private String policy;
        private String prefixListId;
        private Boolean privateDnsEnabled;
        private Boolean requesterManaged;
        private List<String> routeTableIds;
        private List<String> securityGroupIds;
        private String serviceName;
        private String state;
        private List<String> subnetIds;
        private Map<String,String> tags;
        private String vpcEndpointType;
        private String vpcId;
        public Builder() {}
        public Builder(GetVpcEndpointResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.cidrBlocks = defaults.cidrBlocks;
    	      this.dnsEntries = defaults.dnsEntries;
    	      this.dnsOptions = defaults.dnsOptions;
    	      this.filters = defaults.filters;
    	      this.id = defaults.id;
    	      this.ipAddressType = defaults.ipAddressType;
    	      this.networkInterfaceIds = defaults.networkInterfaceIds;
    	      this.ownerId = defaults.ownerId;
    	      this.policy = defaults.policy;
    	      this.prefixListId = defaults.prefixListId;
    	      this.privateDnsEnabled = defaults.privateDnsEnabled;
    	      this.requesterManaged = defaults.requesterManaged;
    	      this.routeTableIds = defaults.routeTableIds;
    	      this.securityGroupIds = defaults.securityGroupIds;
    	      this.serviceName = defaults.serviceName;
    	      this.state = defaults.state;
    	      this.subnetIds = defaults.subnetIds;
    	      this.tags = defaults.tags;
    	      this.vpcEndpointType = defaults.vpcEndpointType;
    	      this.vpcId = defaults.vpcId;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder cidrBlocks(List<String> cidrBlocks) {
            if (cidrBlocks == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "cidrBlocks");
            }
            this.cidrBlocks = cidrBlocks;
            return this;
        }
        public Builder cidrBlocks(String... cidrBlocks) {
            return cidrBlocks(List.of(cidrBlocks));
        }
        @CustomType.Setter
        public Builder dnsEntries(List<GetVpcEndpointDnsEntry> dnsEntries) {
            if (dnsEntries == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "dnsEntries");
            }
            this.dnsEntries = dnsEntries;
            return this;
        }
        public Builder dnsEntries(GetVpcEndpointDnsEntry... dnsEntries) {
            return dnsEntries(List.of(dnsEntries));
        }
        @CustomType.Setter
        public Builder dnsOptions(List<GetVpcEndpointDnsOption> dnsOptions) {
            if (dnsOptions == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "dnsOptions");
            }
            this.dnsOptions = dnsOptions;
            return this;
        }
        public Builder dnsOptions(GetVpcEndpointDnsOption... dnsOptions) {
            return dnsOptions(List.of(dnsOptions));
        }
        @CustomType.Setter
        public Builder filters(@Nullable List<GetVpcEndpointFilter> filters) {

            this.filters = filters;
            return this;
        }
        public Builder filters(GetVpcEndpointFilter... filters) {
            return filters(List.of(filters));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder ipAddressType(String ipAddressType) {
            if (ipAddressType == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "ipAddressType");
            }
            this.ipAddressType = ipAddressType;
            return this;
        }
        @CustomType.Setter
        public Builder networkInterfaceIds(List<String> networkInterfaceIds) {
            if (networkInterfaceIds == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "networkInterfaceIds");
            }
            this.networkInterfaceIds = networkInterfaceIds;
            return this;
        }
        public Builder networkInterfaceIds(String... networkInterfaceIds) {
            return networkInterfaceIds(List.of(networkInterfaceIds));
        }
        @CustomType.Setter
        public Builder ownerId(String ownerId) {
            if (ownerId == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "ownerId");
            }
            this.ownerId = ownerId;
            return this;
        }
        @CustomType.Setter
        public Builder policy(String policy) {
            if (policy == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "policy");
            }
            this.policy = policy;
            return this;
        }
        @CustomType.Setter
        public Builder prefixListId(String prefixListId) {
            if (prefixListId == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "prefixListId");
            }
            this.prefixListId = prefixListId;
            return this;
        }
        @CustomType.Setter
        public Builder privateDnsEnabled(Boolean privateDnsEnabled) {
            if (privateDnsEnabled == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "privateDnsEnabled");
            }
            this.privateDnsEnabled = privateDnsEnabled;
            return this;
        }
        @CustomType.Setter
        public Builder requesterManaged(Boolean requesterManaged) {
            if (requesterManaged == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "requesterManaged");
            }
            this.requesterManaged = requesterManaged;
            return this;
        }
        @CustomType.Setter
        public Builder routeTableIds(List<String> routeTableIds) {
            if (routeTableIds == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "routeTableIds");
            }
            this.routeTableIds = routeTableIds;
            return this;
        }
        public Builder routeTableIds(String... routeTableIds) {
            return routeTableIds(List.of(routeTableIds));
        }
        @CustomType.Setter
        public Builder securityGroupIds(List<String> securityGroupIds) {
            if (securityGroupIds == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "securityGroupIds");
            }
            this.securityGroupIds = securityGroupIds;
            return this;
        }
        public Builder securityGroupIds(String... securityGroupIds) {
            return securityGroupIds(List.of(securityGroupIds));
        }
        @CustomType.Setter
        public Builder serviceName(String serviceName) {
            if (serviceName == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "serviceName");
            }
            this.serviceName = serviceName;
            return this;
        }
        @CustomType.Setter
        public Builder state(String state) {
            if (state == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "state");
            }
            this.state = state;
            return this;
        }
        @CustomType.Setter
        public Builder subnetIds(List<String> subnetIds) {
            if (subnetIds == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "subnetIds");
            }
            this.subnetIds = subnetIds;
            return this;
        }
        public Builder subnetIds(String... subnetIds) {
            return subnetIds(List.of(subnetIds));
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        @CustomType.Setter
        public Builder vpcEndpointType(String vpcEndpointType) {
            if (vpcEndpointType == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "vpcEndpointType");
            }
            this.vpcEndpointType = vpcEndpointType;
            return this;
        }
        @CustomType.Setter
        public Builder vpcId(String vpcId) {
            if (vpcId == null) {
              throw new MissingRequiredPropertyException("GetVpcEndpointResult", "vpcId");
            }
            this.vpcId = vpcId;
            return this;
        }
        public GetVpcEndpointResult build() {
            final var _resultValue = new GetVpcEndpointResult();
            _resultValue.arn = arn;
            _resultValue.cidrBlocks = cidrBlocks;
            _resultValue.dnsEntries = dnsEntries;
            _resultValue.dnsOptions = dnsOptions;
            _resultValue.filters = filters;
            _resultValue.id = id;
            _resultValue.ipAddressType = ipAddressType;
            _resultValue.networkInterfaceIds = networkInterfaceIds;
            _resultValue.ownerId = ownerId;
            _resultValue.policy = policy;
            _resultValue.prefixListId = prefixListId;
            _resultValue.privateDnsEnabled = privateDnsEnabled;
            _resultValue.requesterManaged = requesterManaged;
            _resultValue.routeTableIds = routeTableIds;
            _resultValue.securityGroupIds = securityGroupIds;
            _resultValue.serviceName = serviceName;
            _resultValue.state = state;
            _resultValue.subnetIds = subnetIds;
            _resultValue.tags = tags;
            _resultValue.vpcEndpointType = vpcEndpointType;
            _resultValue.vpcId = vpcId;
            return _resultValue;
        }
    }
}
