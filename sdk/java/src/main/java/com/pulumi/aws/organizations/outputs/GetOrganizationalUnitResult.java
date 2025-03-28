// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.organizations.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetOrganizationalUnitResult {
    /**
     * @return ARN of the organizational unit
     * 
     */
    private String arn;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private String name;
    private String parentId;

    private GetOrganizationalUnitResult() {}
    /**
     * @return ARN of the organizational unit
     * 
     */
    public String arn() {
        return this.arn;
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
    public String parentId() {
        return this.parentId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetOrganizationalUnitResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String id;
        private String name;
        private String parentId;
        public Builder() {}
        public Builder(GetOrganizationalUnitResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.id = defaults.id;
    	      this.name = defaults.name;
    	      this.parentId = defaults.parentId;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetOrganizationalUnitResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetOrganizationalUnitResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetOrganizationalUnitResult", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder parentId(String parentId) {
            if (parentId == null) {
              throw new MissingRequiredPropertyException("GetOrganizationalUnitResult", "parentId");
            }
            this.parentId = parentId;
            return this;
        }
        public GetOrganizationalUnitResult build() {
            final var _resultValue = new GetOrganizationalUnitResult();
            _resultValue.arn = arn;
            _resultValue.id = id;
            _resultValue.name = name;
            _resultValue.parentId = parentId;
            return _resultValue;
        }
    }
}
