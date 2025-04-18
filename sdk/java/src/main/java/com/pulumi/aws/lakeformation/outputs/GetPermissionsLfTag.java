// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lakeformation.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetPermissionsLfTag {
    /**
     * @return Identifier for the Data Catalog. By default, it is the account ID of the caller.
     * 
     */
    private String catalogId;
    /**
     * @return Key-name for the tag.
     * 
     */
    private String key;
    /**
     * @return List of possible values an attribute can take.
     * 
     * The following argument is optional:
     * 
     */
    private List<String> values;

    private GetPermissionsLfTag() {}
    /**
     * @return Identifier for the Data Catalog. By default, it is the account ID of the caller.
     * 
     */
    public String catalogId() {
        return this.catalogId;
    }
    /**
     * @return Key-name for the tag.
     * 
     */
    public String key() {
        return this.key;
    }
    /**
     * @return List of possible values an attribute can take.
     * 
     * The following argument is optional:
     * 
     */
    public List<String> values() {
        return this.values;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetPermissionsLfTag defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String catalogId;
        private String key;
        private List<String> values;
        public Builder() {}
        public Builder(GetPermissionsLfTag defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.catalogId = defaults.catalogId;
    	      this.key = defaults.key;
    	      this.values = defaults.values;
        }

        @CustomType.Setter
        public Builder catalogId(String catalogId) {
            if (catalogId == null) {
              throw new MissingRequiredPropertyException("GetPermissionsLfTag", "catalogId");
            }
            this.catalogId = catalogId;
            return this;
        }
        @CustomType.Setter
        public Builder key(String key) {
            if (key == null) {
              throw new MissingRequiredPropertyException("GetPermissionsLfTag", "key");
            }
            this.key = key;
            return this;
        }
        @CustomType.Setter
        public Builder values(List<String> values) {
            if (values == null) {
              throw new MissingRequiredPropertyException("GetPermissionsLfTag", "values");
            }
            this.values = values;
            return this;
        }
        public Builder values(String... values) {
            return values(List.of(values));
        }
        public GetPermissionsLfTag build() {
            final var _resultValue = new GetPermissionsLfTag();
            _resultValue.catalogId = catalogId;
            _resultValue.key = key;
            _resultValue.values = values;
            return _resultValue;
        }
    }
}
