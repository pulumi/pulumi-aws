// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.opensearch.outputs;

import com.pulumi.aws.opensearch.outputs.GetDomainClusterConfigNodeOptionNodeConfig;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetDomainClusterConfigNodeOption {
    /**
     * @return Sizing of a node type.
     * 
     */
    private List<GetDomainClusterConfigNodeOptionNodeConfig> nodeConfigs;
    /**
     * @return Type of node this configuration describes.
     * 
     */
    private String nodeType;

    private GetDomainClusterConfigNodeOption() {}
    /**
     * @return Sizing of a node type.
     * 
     */
    public List<GetDomainClusterConfigNodeOptionNodeConfig> nodeConfigs() {
        return this.nodeConfigs;
    }
    /**
     * @return Type of node this configuration describes.
     * 
     */
    public String nodeType() {
        return this.nodeType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetDomainClusterConfigNodeOption defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetDomainClusterConfigNodeOptionNodeConfig> nodeConfigs;
        private String nodeType;
        public Builder() {}
        public Builder(GetDomainClusterConfigNodeOption defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.nodeConfigs = defaults.nodeConfigs;
    	      this.nodeType = defaults.nodeType;
        }

        @CustomType.Setter
        public Builder nodeConfigs(List<GetDomainClusterConfigNodeOptionNodeConfig> nodeConfigs) {
            if (nodeConfigs == null) {
              throw new MissingRequiredPropertyException("GetDomainClusterConfigNodeOption", "nodeConfigs");
            }
            this.nodeConfigs = nodeConfigs;
            return this;
        }
        public Builder nodeConfigs(GetDomainClusterConfigNodeOptionNodeConfig... nodeConfigs) {
            return nodeConfigs(List.of(nodeConfigs));
        }
        @CustomType.Setter
        public Builder nodeType(String nodeType) {
            if (nodeType == null) {
              throw new MissingRequiredPropertyException("GetDomainClusterConfigNodeOption", "nodeType");
            }
            this.nodeType = nodeType;
            return this;
        }
        public GetDomainClusterConfigNodeOption build() {
            final var _resultValue = new GetDomainClusterConfigNodeOption();
            _resultValue.nodeConfigs = nodeConfigs;
            _resultValue.nodeType = nodeType;
            return _resultValue;
        }
    }
}
