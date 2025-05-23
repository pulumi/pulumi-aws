// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetResolverFirewallDomainListResult {
    /**
     * @return The Amazon Resource Name (ARN) of the firewall domain list.
     * 
     */
    private String arn;
    /**
     * @return The date and time that the domain list was created, in Unix time format and Coordinated Universal Time (UTC).
     * 
     */
    private String creationTime;
    /**
     * @return A unique string defined by you to identify the request.
     * 
     */
    private String creatorRequestId;
    /**
     * @return The number of domain names that are specified in the domain list.
     * 
     */
    private Integer domainCount;
    private String firewallDomainListId;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return The owner of the list, used only for lists that are not managed by you.
     * 
     */
    private String managedOwnerName;
    /**
     * @return The date and time that the domain list was last modified, in Unix time format and Coordinated Universal Time (UTC).
     * 
     */
    private String modificationTime;
    /**
     * @return The name of the domain list.
     * 
     */
    private String name;
    /**
     * @return The status of the domain list.
     * 
     */
    private String status;
    /**
     * @return Additional information about the status of the list, if available.
     * 
     */
    private String statusMessage;

    private GetResolverFirewallDomainListResult() {}
    /**
     * @return The Amazon Resource Name (ARN) of the firewall domain list.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return The date and time that the domain list was created, in Unix time format and Coordinated Universal Time (UTC).
     * 
     */
    public String creationTime() {
        return this.creationTime;
    }
    /**
     * @return A unique string defined by you to identify the request.
     * 
     */
    public String creatorRequestId() {
        return this.creatorRequestId;
    }
    /**
     * @return The number of domain names that are specified in the domain list.
     * 
     */
    public Integer domainCount() {
        return this.domainCount;
    }
    public String firewallDomainListId() {
        return this.firewallDomainListId;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return The owner of the list, used only for lists that are not managed by you.
     * 
     */
    public String managedOwnerName() {
        return this.managedOwnerName;
    }
    /**
     * @return The date and time that the domain list was last modified, in Unix time format and Coordinated Universal Time (UTC).
     * 
     */
    public String modificationTime() {
        return this.modificationTime;
    }
    /**
     * @return The name of the domain list.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return The status of the domain list.
     * 
     */
    public String status() {
        return this.status;
    }
    /**
     * @return Additional information about the status of the list, if available.
     * 
     */
    public String statusMessage() {
        return this.statusMessage;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetResolverFirewallDomainListResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String creationTime;
        private String creatorRequestId;
        private Integer domainCount;
        private String firewallDomainListId;
        private String id;
        private String managedOwnerName;
        private String modificationTime;
        private String name;
        private String status;
        private String statusMessage;
        public Builder() {}
        public Builder(GetResolverFirewallDomainListResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.creationTime = defaults.creationTime;
    	      this.creatorRequestId = defaults.creatorRequestId;
    	      this.domainCount = defaults.domainCount;
    	      this.firewallDomainListId = defaults.firewallDomainListId;
    	      this.id = defaults.id;
    	      this.managedOwnerName = defaults.managedOwnerName;
    	      this.modificationTime = defaults.modificationTime;
    	      this.name = defaults.name;
    	      this.status = defaults.status;
    	      this.statusMessage = defaults.statusMessage;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetResolverFirewallDomainListResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder creationTime(String creationTime) {
            if (creationTime == null) {
              throw new MissingRequiredPropertyException("GetResolverFirewallDomainListResult", "creationTime");
            }
            this.creationTime = creationTime;
            return this;
        }
        @CustomType.Setter
        public Builder creatorRequestId(String creatorRequestId) {
            if (creatorRequestId == null) {
              throw new MissingRequiredPropertyException("GetResolverFirewallDomainListResult", "creatorRequestId");
            }
            this.creatorRequestId = creatorRequestId;
            return this;
        }
        @CustomType.Setter
        public Builder domainCount(Integer domainCount) {
            if (domainCount == null) {
              throw new MissingRequiredPropertyException("GetResolverFirewallDomainListResult", "domainCount");
            }
            this.domainCount = domainCount;
            return this;
        }
        @CustomType.Setter
        public Builder firewallDomainListId(String firewallDomainListId) {
            if (firewallDomainListId == null) {
              throw new MissingRequiredPropertyException("GetResolverFirewallDomainListResult", "firewallDomainListId");
            }
            this.firewallDomainListId = firewallDomainListId;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetResolverFirewallDomainListResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder managedOwnerName(String managedOwnerName) {
            if (managedOwnerName == null) {
              throw new MissingRequiredPropertyException("GetResolverFirewallDomainListResult", "managedOwnerName");
            }
            this.managedOwnerName = managedOwnerName;
            return this;
        }
        @CustomType.Setter
        public Builder modificationTime(String modificationTime) {
            if (modificationTime == null) {
              throw new MissingRequiredPropertyException("GetResolverFirewallDomainListResult", "modificationTime");
            }
            this.modificationTime = modificationTime;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetResolverFirewallDomainListResult", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder status(String status) {
            if (status == null) {
              throw new MissingRequiredPropertyException("GetResolverFirewallDomainListResult", "status");
            }
            this.status = status;
            return this;
        }
        @CustomType.Setter
        public Builder statusMessage(String statusMessage) {
            if (statusMessage == null) {
              throw new MissingRequiredPropertyException("GetResolverFirewallDomainListResult", "statusMessage");
            }
            this.statusMessage = statusMessage;
            return this;
        }
        public GetResolverFirewallDomainListResult build() {
            final var _resultValue = new GetResolverFirewallDomainListResult();
            _resultValue.arn = arn;
            _resultValue.creationTime = creationTime;
            _resultValue.creatorRequestId = creatorRequestId;
            _resultValue.domainCount = domainCount;
            _resultValue.firewallDomainListId = firewallDomainListId;
            _resultValue.id = id;
            _resultValue.managedOwnerName = managedOwnerName;
            _resultValue.modificationTime = modificationTime;
            _resultValue.name = name;
            _resultValue.status = status;
            _resultValue.statusMessage = statusMessage;
            return _resultValue;
        }
    }
}
