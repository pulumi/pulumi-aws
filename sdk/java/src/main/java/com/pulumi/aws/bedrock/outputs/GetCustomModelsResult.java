// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.aws.bedrock.outputs.GetCustomModelsModelSummary;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetCustomModelsResult {
    private String id;
    /**
     * @return Model summaries.
     * 
     */
    private List<GetCustomModelsModelSummary> modelSummaries;

    private GetCustomModelsResult() {}
    public String id() {
        return this.id;
    }
    /**
     * @return Model summaries.
     * 
     */
    public List<GetCustomModelsModelSummary> modelSummaries() {
        return this.modelSummaries;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetCustomModelsResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String id;
        private List<GetCustomModelsModelSummary> modelSummaries;
        public Builder() {}
        public Builder(GetCustomModelsResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.id = defaults.id;
    	      this.modelSummaries = defaults.modelSummaries;
        }

        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetCustomModelsResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder modelSummaries(List<GetCustomModelsModelSummary> modelSummaries) {
            if (modelSummaries == null) {
              throw new MissingRequiredPropertyException("GetCustomModelsResult", "modelSummaries");
            }
            this.modelSummaries = modelSummaries;
            return this;
        }
        public Builder modelSummaries(GetCustomModelsModelSummary... modelSummaries) {
            return modelSummaries(List.of(modelSummaries));
        }
        public GetCustomModelsResult build() {
            final var _resultValue = new GetCustomModelsResult();
            _resultValue.id = id;
            _resultValue.modelSummaries = modelSummaries;
            return _resultValue;
        }
    }
}
