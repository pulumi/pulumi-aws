// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ecr.outputs;

import com.pulumi.aws.ecr.outputs.GetLifecyclePolicyDocumentRule;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class GetLifecyclePolicyDocumentResult {
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return The above arguments serialized as a standard JSON policy document.
     * 
     */
    private String json;
    private @Nullable List<GetLifecyclePolicyDocumentRule> rules;

    private GetLifecyclePolicyDocumentResult() {}
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return The above arguments serialized as a standard JSON policy document.
     * 
     */
    public String json() {
        return this.json;
    }
    public List<GetLifecyclePolicyDocumentRule> rules() {
        return this.rules == null ? List.of() : this.rules;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetLifecyclePolicyDocumentResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String id;
        private String json;
        private @Nullable List<GetLifecyclePolicyDocumentRule> rules;
        public Builder() {}
        public Builder(GetLifecyclePolicyDocumentResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.id = defaults.id;
    	      this.json = defaults.json;
    	      this.rules = defaults.rules;
        }

        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetLifecyclePolicyDocumentResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder json(String json) {
            if (json == null) {
              throw new MissingRequiredPropertyException("GetLifecyclePolicyDocumentResult", "json");
            }
            this.json = json;
            return this;
        }
        @CustomType.Setter
        public Builder rules(@Nullable List<GetLifecyclePolicyDocumentRule> rules) {

            this.rules = rules;
            return this;
        }
        public Builder rules(GetLifecyclePolicyDocumentRule... rules) {
            return rules(List.of(rules));
        }
        public GetLifecyclePolicyDocumentResult build() {
            final var _resultValue = new GetLifecyclePolicyDocumentResult();
            _resultValue.id = id;
            _resultValue.json = json;
            _resultValue.rules = rules;
            return _resultValue;
        }
    }
}
