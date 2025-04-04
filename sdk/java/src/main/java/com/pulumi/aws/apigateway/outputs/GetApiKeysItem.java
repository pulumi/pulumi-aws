// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.apigateway.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetApiKeysItem {
    /**
     * @return Date and time when the API Key was created.
     * 
     */
    private String createdDate;
    /**
     * @return Amazon Web Services Marketplace customer identifier, when integrating with the Amazon Web Services SaaS Marketplace.
     * 
     */
    private String customerId;
    /**
     * @return Description of the API Key.
     * 
     */
    private String description;
    /**
     * @return Whether the API Key is enabled.
     * 
     */
    private Boolean enabled;
    /**
     * @return ID of the API Key.
     * 
     */
    private String id;
    /**
     * @return Date and time when the API Key was last updated.
     * 
     */
    private String lastUpdatedDate;
    /**
     * @return Name of the API Key.
     * 
     */
    private String name;
    private List<String> stageKeys;
    /**
     * @return Map of tags for the resource.
     * 
     */
    private Map<String,String> tags;
    /**
     * @return Value of the API Key.
     * 
     */
    private String value;

    private GetApiKeysItem() {}
    /**
     * @return Date and time when the API Key was created.
     * 
     */
    public String createdDate() {
        return this.createdDate;
    }
    /**
     * @return Amazon Web Services Marketplace customer identifier, when integrating with the Amazon Web Services SaaS Marketplace.
     * 
     */
    public String customerId() {
        return this.customerId;
    }
    /**
     * @return Description of the API Key.
     * 
     */
    public String description() {
        return this.description;
    }
    /**
     * @return Whether the API Key is enabled.
     * 
     */
    public Boolean enabled() {
        return this.enabled;
    }
    /**
     * @return ID of the API Key.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return Date and time when the API Key was last updated.
     * 
     */
    public String lastUpdatedDate() {
        return this.lastUpdatedDate;
    }
    /**
     * @return Name of the API Key.
     * 
     */
    public String name() {
        return this.name;
    }
    public List<String> stageKeys() {
        return this.stageKeys;
    }
    /**
     * @return Map of tags for the resource.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }
    /**
     * @return Value of the API Key.
     * 
     */
    public String value() {
        return this.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetApiKeysItem defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String createdDate;
        private String customerId;
        private String description;
        private Boolean enabled;
        private String id;
        private String lastUpdatedDate;
        private String name;
        private List<String> stageKeys;
        private Map<String,String> tags;
        private String value;
        public Builder() {}
        public Builder(GetApiKeysItem defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.createdDate = defaults.createdDate;
    	      this.customerId = defaults.customerId;
    	      this.description = defaults.description;
    	      this.enabled = defaults.enabled;
    	      this.id = defaults.id;
    	      this.lastUpdatedDate = defaults.lastUpdatedDate;
    	      this.name = defaults.name;
    	      this.stageKeys = defaults.stageKeys;
    	      this.tags = defaults.tags;
    	      this.value = defaults.value;
        }

        @CustomType.Setter
        public Builder createdDate(String createdDate) {
            if (createdDate == null) {
              throw new MissingRequiredPropertyException("GetApiKeysItem", "createdDate");
            }
            this.createdDate = createdDate;
            return this;
        }
        @CustomType.Setter
        public Builder customerId(String customerId) {
            if (customerId == null) {
              throw new MissingRequiredPropertyException("GetApiKeysItem", "customerId");
            }
            this.customerId = customerId;
            return this;
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetApiKeysItem", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder enabled(Boolean enabled) {
            if (enabled == null) {
              throw new MissingRequiredPropertyException("GetApiKeysItem", "enabled");
            }
            this.enabled = enabled;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetApiKeysItem", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder lastUpdatedDate(String lastUpdatedDate) {
            if (lastUpdatedDate == null) {
              throw new MissingRequiredPropertyException("GetApiKeysItem", "lastUpdatedDate");
            }
            this.lastUpdatedDate = lastUpdatedDate;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetApiKeysItem", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder stageKeys(List<String> stageKeys) {
            if (stageKeys == null) {
              throw new MissingRequiredPropertyException("GetApiKeysItem", "stageKeys");
            }
            this.stageKeys = stageKeys;
            return this;
        }
        public Builder stageKeys(String... stageKeys) {
            return stageKeys(List.of(stageKeys));
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetApiKeysItem", "tags");
            }
            this.tags = tags;
            return this;
        }
        @CustomType.Setter
        public Builder value(String value) {
            if (value == null) {
              throw new MissingRequiredPropertyException("GetApiKeysItem", "value");
            }
            this.value = value;
            return this;
        }
        public GetApiKeysItem build() {
            final var _resultValue = new GetApiKeysItem();
            _resultValue.createdDate = createdDate;
            _resultValue.customerId = customerId;
            _resultValue.description = description;
            _resultValue.enabled = enabled;
            _resultValue.id = id;
            _resultValue.lastUpdatedDate = lastUpdatedDate;
            _resultValue.name = name;
            _resultValue.stageKeys = stageKeys;
            _resultValue.tags = tags;
            _resultValue.value = value;
            return _resultValue;
        }
    }
}
