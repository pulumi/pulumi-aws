// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cognito.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetUserPoolsResult {
    /**
     * @return Set of cognito user pool Amazon Resource Names (ARNs).
     * 
     */
    private List<String> arns;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return Set of cognito user pool ids.
     * 
     */
    private List<String> ids;
    private String name;

    private GetUserPoolsResult() {}
    /**
     * @return Set of cognito user pool Amazon Resource Names (ARNs).
     * 
     */
    public List<String> arns() {
        return this.arns;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return Set of cognito user pool ids.
     * 
     */
    public List<String> ids() {
        return this.ids;
    }
    public String name() {
        return this.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetUserPoolsResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<String> arns;
        private String id;
        private List<String> ids;
        private String name;
        public Builder() {}
        public Builder(GetUserPoolsResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arns = defaults.arns;
    	      this.id = defaults.id;
    	      this.ids = defaults.ids;
    	      this.name = defaults.name;
        }

        @CustomType.Setter
        public Builder arns(List<String> arns) {
            if (arns == null) {
              throw new MissingRequiredPropertyException("GetUserPoolsResult", "arns");
            }
            this.arns = arns;
            return this;
        }
        public Builder arns(String... arns) {
            return arns(List.of(arns));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetUserPoolsResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder ids(List<String> ids) {
            if (ids == null) {
              throw new MissingRequiredPropertyException("GetUserPoolsResult", "ids");
            }
            this.ids = ids;
            return this;
        }
        public Builder ids(String... ids) {
            return ids(List.of(ids));
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetUserPoolsResult", "name");
            }
            this.name = name;
            return this;
        }
        public GetUserPoolsResult build() {
            final var _resultValue = new GetUserPoolsResult();
            _resultValue.arns = arns;
            _resultValue.id = id;
            _resultValue.ids = ids;
            _resultValue.name = name;
            return _resultValue;
        }
    }
}
