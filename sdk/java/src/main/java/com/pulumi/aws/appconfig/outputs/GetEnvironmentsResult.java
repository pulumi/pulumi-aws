// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appconfig.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetEnvironmentsResult {
    private String applicationId;
    /**
     * @return Set of Environment IDs associated with this AppConfig Application.
     * 
     */
    private List<String> environmentIds;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;

    private GetEnvironmentsResult() {}
    public String applicationId() {
        return this.applicationId;
    }
    /**
     * @return Set of Environment IDs associated with this AppConfig Application.
     * 
     */
    public List<String> environmentIds() {
        return this.environmentIds;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetEnvironmentsResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String applicationId;
        private List<String> environmentIds;
        private String id;
        public Builder() {}
        public Builder(GetEnvironmentsResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.applicationId = defaults.applicationId;
    	      this.environmentIds = defaults.environmentIds;
    	      this.id = defaults.id;
        }

        @CustomType.Setter
        public Builder applicationId(String applicationId) {
            if (applicationId == null) {
              throw new MissingRequiredPropertyException("GetEnvironmentsResult", "applicationId");
            }
            this.applicationId = applicationId;
            return this;
        }
        @CustomType.Setter
        public Builder environmentIds(List<String> environmentIds) {
            if (environmentIds == null) {
              throw new MissingRequiredPropertyException("GetEnvironmentsResult", "environmentIds");
            }
            this.environmentIds = environmentIds;
            return this;
        }
        public Builder environmentIds(String... environmentIds) {
            return environmentIds(List.of(environmentIds));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetEnvironmentsResult", "id");
            }
            this.id = id;
            return this;
        }
        public GetEnvironmentsResult build() {
            final var _resultValue = new GetEnvironmentsResult();
            _resultValue.applicationId = applicationId;
            _resultValue.environmentIds = environmentIds;
            _resultValue.id = id;
            return _resultValue;
        }
    }
}
