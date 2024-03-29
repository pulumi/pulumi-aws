// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.location.outputs;

import com.pulumi.aws.location.outputs.GetMapConfiguration;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetMapResult {
    /**
     * @return List of configurations that specify the map tile style selected from a partner data provider.
     * 
     */
    private List<GetMapConfiguration> configurations;
    /**
     * @return Timestamp for when the map resource was created in ISO 8601 format.
     * 
     */
    private String createTime;
    /**
     * @return Optional description for the map resource.
     * 
     */
    private String description;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return ARN for the map resource.
     * 
     */
    private String mapArn;
    private String mapName;
    /**
     * @return Key-value map of resource tags for the map.
     * 
     */
    private Map<String,String> tags;
    /**
     * @return Timestamp for when the map resource was last updated in ISO 8601 format.
     * 
     */
    private String updateTime;

    private GetMapResult() {}
    /**
     * @return List of configurations that specify the map tile style selected from a partner data provider.
     * 
     */
    public List<GetMapConfiguration> configurations() {
        return this.configurations;
    }
    /**
     * @return Timestamp for when the map resource was created in ISO 8601 format.
     * 
     */
    public String createTime() {
        return this.createTime;
    }
    /**
     * @return Optional description for the map resource.
     * 
     */
    public String description() {
        return this.description;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return ARN for the map resource.
     * 
     */
    public String mapArn() {
        return this.mapArn;
    }
    public String mapName() {
        return this.mapName;
    }
    /**
     * @return Key-value map of resource tags for the map.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }
    /**
     * @return Timestamp for when the map resource was last updated in ISO 8601 format.
     * 
     */
    public String updateTime() {
        return this.updateTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetMapResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetMapConfiguration> configurations;
        private String createTime;
        private String description;
        private String id;
        private String mapArn;
        private String mapName;
        private Map<String,String> tags;
        private String updateTime;
        public Builder() {}
        public Builder(GetMapResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.configurations = defaults.configurations;
    	      this.createTime = defaults.createTime;
    	      this.description = defaults.description;
    	      this.id = defaults.id;
    	      this.mapArn = defaults.mapArn;
    	      this.mapName = defaults.mapName;
    	      this.tags = defaults.tags;
    	      this.updateTime = defaults.updateTime;
        }

        @CustomType.Setter
        public Builder configurations(List<GetMapConfiguration> configurations) {
            if (configurations == null) {
              throw new MissingRequiredPropertyException("GetMapResult", "configurations");
            }
            this.configurations = configurations;
            return this;
        }
        public Builder configurations(GetMapConfiguration... configurations) {
            return configurations(List.of(configurations));
        }
        @CustomType.Setter
        public Builder createTime(String createTime) {
            if (createTime == null) {
              throw new MissingRequiredPropertyException("GetMapResult", "createTime");
            }
            this.createTime = createTime;
            return this;
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetMapResult", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetMapResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder mapArn(String mapArn) {
            if (mapArn == null) {
              throw new MissingRequiredPropertyException("GetMapResult", "mapArn");
            }
            this.mapArn = mapArn;
            return this;
        }
        @CustomType.Setter
        public Builder mapName(String mapName) {
            if (mapName == null) {
              throw new MissingRequiredPropertyException("GetMapResult", "mapName");
            }
            this.mapName = mapName;
            return this;
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetMapResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        @CustomType.Setter
        public Builder updateTime(String updateTime) {
            if (updateTime == null) {
              throw new MissingRequiredPropertyException("GetMapResult", "updateTime");
            }
            this.updateTime = updateTime;
            return this;
        }
        public GetMapResult build() {
            final var _resultValue = new GetMapResult();
            _resultValue.configurations = configurations;
            _resultValue.createTime = createTime;
            _resultValue.description = description;
            _resultValue.id = id;
            _resultValue.mapArn = mapArn;
            _resultValue.mapName = mapName;
            _resultValue.tags = tags;
            _resultValue.updateTime = updateTime;
            return _resultValue;
        }
    }
}
