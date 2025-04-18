// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.servicediscovery.outputs;

import com.pulumi.aws.servicediscovery.outputs.GetServiceDnsConfig;
import com.pulumi.aws.servicediscovery.outputs.GetServiceHealthCheckConfig;
import com.pulumi.aws.servicediscovery.outputs.GetServiceHealthCheckCustomConfig;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class GetServiceResult {
    /**
     * @return ARN of the service.
     * 
     */
    private String arn;
    /**
     * @return Description of the service.
     * 
     */
    private String description;
    /**
     * @return Complex type that contains information about the resource record sets that you want Amazon Route 53 to create when you register an instance. See `dns_config` Block for details.
     * 
     */
    private List<GetServiceDnsConfig> dnsConfigs;
    /**
     * @return Complex type that contains settings for an optional health check. Only for Public DNS namespaces. See `health_check_config` Block for details.
     * 
     */
    private List<GetServiceHealthCheckConfig> healthCheckConfigs;
    /**
     * @return A complex type that contains settings for ECS managed health checks. See `health_check_custom_config` Block for details.
     * 
     */
    private List<GetServiceHealthCheckCustomConfig> healthCheckCustomConfigs;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private String name;
    /**
     * @return ID of the namespace to use for DNS configuration.
     * 
     */
    private String namespaceId;
    /**
     * @return Map of tags to assign to the service. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    private @Nullable Map<String,String> tags;
    /**
     * @return (**Deprecated**) Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * tags_all is deprecated. This argument will be removed in a future major version.
     * 
     */
    @Deprecated /* tags_all is deprecated. This argument will be removed in a future major version. */
    private Map<String,String> tagsAll;

    private GetServiceResult() {}
    /**
     * @return ARN of the service.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return Description of the service.
     * 
     */
    public String description() {
        return this.description;
    }
    /**
     * @return Complex type that contains information about the resource record sets that you want Amazon Route 53 to create when you register an instance. See `dns_config` Block for details.
     * 
     */
    public List<GetServiceDnsConfig> dnsConfigs() {
        return this.dnsConfigs;
    }
    /**
     * @return Complex type that contains settings for an optional health check. Only for Public DNS namespaces. See `health_check_config` Block for details.
     * 
     */
    public List<GetServiceHealthCheckConfig> healthCheckConfigs() {
        return this.healthCheckConfigs;
    }
    /**
     * @return A complex type that contains settings for ECS managed health checks. See `health_check_custom_config` Block for details.
     * 
     */
    public List<GetServiceHealthCheckCustomConfig> healthCheckCustomConfigs() {
        return this.healthCheckCustomConfigs;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    public String name() {
        return this.name;
    }
    /**
     * @return ID of the namespace to use for DNS configuration.
     * 
     */
    public String namespaceId() {
        return this.namespaceId;
    }
    /**
     * @return Map of tags to assign to the service. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Map<String,String> tags() {
        return this.tags == null ? Map.of() : this.tags;
    }
    /**
     * @return (**Deprecated**) Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * tags_all is deprecated. This argument will be removed in a future major version.
     * 
     */
    @Deprecated /* tags_all is deprecated. This argument will be removed in a future major version. */
    public Map<String,String> tagsAll() {
        return this.tagsAll;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetServiceResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String description;
        private List<GetServiceDnsConfig> dnsConfigs;
        private List<GetServiceHealthCheckConfig> healthCheckConfigs;
        private List<GetServiceHealthCheckCustomConfig> healthCheckCustomConfigs;
        private String id;
        private String name;
        private String namespaceId;
        private @Nullable Map<String,String> tags;
        private Map<String,String> tagsAll;
        public Builder() {}
        public Builder(GetServiceResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.description = defaults.description;
    	      this.dnsConfigs = defaults.dnsConfigs;
    	      this.healthCheckConfigs = defaults.healthCheckConfigs;
    	      this.healthCheckCustomConfigs = defaults.healthCheckCustomConfigs;
    	      this.id = defaults.id;
    	      this.name = defaults.name;
    	      this.namespaceId = defaults.namespaceId;
    	      this.tags = defaults.tags;
    	      this.tagsAll = defaults.tagsAll;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetServiceResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetServiceResult", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder dnsConfigs(List<GetServiceDnsConfig> dnsConfigs) {
            if (dnsConfigs == null) {
              throw new MissingRequiredPropertyException("GetServiceResult", "dnsConfigs");
            }
            this.dnsConfigs = dnsConfigs;
            return this;
        }
        public Builder dnsConfigs(GetServiceDnsConfig... dnsConfigs) {
            return dnsConfigs(List.of(dnsConfigs));
        }
        @CustomType.Setter
        public Builder healthCheckConfigs(List<GetServiceHealthCheckConfig> healthCheckConfigs) {
            if (healthCheckConfigs == null) {
              throw new MissingRequiredPropertyException("GetServiceResult", "healthCheckConfigs");
            }
            this.healthCheckConfigs = healthCheckConfigs;
            return this;
        }
        public Builder healthCheckConfigs(GetServiceHealthCheckConfig... healthCheckConfigs) {
            return healthCheckConfigs(List.of(healthCheckConfigs));
        }
        @CustomType.Setter
        public Builder healthCheckCustomConfigs(List<GetServiceHealthCheckCustomConfig> healthCheckCustomConfigs) {
            if (healthCheckCustomConfigs == null) {
              throw new MissingRequiredPropertyException("GetServiceResult", "healthCheckCustomConfigs");
            }
            this.healthCheckCustomConfigs = healthCheckCustomConfigs;
            return this;
        }
        public Builder healthCheckCustomConfigs(GetServiceHealthCheckCustomConfig... healthCheckCustomConfigs) {
            return healthCheckCustomConfigs(List.of(healthCheckCustomConfigs));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetServiceResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetServiceResult", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder namespaceId(String namespaceId) {
            if (namespaceId == null) {
              throw new MissingRequiredPropertyException("GetServiceResult", "namespaceId");
            }
            this.namespaceId = namespaceId;
            return this;
        }
        @CustomType.Setter
        public Builder tags(@Nullable Map<String,String> tags) {

            this.tags = tags;
            return this;
        }
        @CustomType.Setter
        public Builder tagsAll(Map<String,String> tagsAll) {
            if (tagsAll == null) {
              throw new MissingRequiredPropertyException("GetServiceResult", "tagsAll");
            }
            this.tagsAll = tagsAll;
            return this;
        }
        public GetServiceResult build() {
            final var _resultValue = new GetServiceResult();
            _resultValue.arn = arn;
            _resultValue.description = description;
            _resultValue.dnsConfigs = dnsConfigs;
            _resultValue.healthCheckConfigs = healthCheckConfigs;
            _resultValue.healthCheckCustomConfigs = healthCheckCustomConfigs;
            _resultValue.id = id;
            _resultValue.name = name;
            _resultValue.namespaceId = namespaceId;
            _resultValue.tags = tags;
            _resultValue.tagsAll = tagsAll;
            return _resultValue;
        }
    }
}
