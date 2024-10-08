// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.aws.bedrock.outputs.GetCustomModelOutputDataConfig;
import com.pulumi.aws.bedrock.outputs.GetCustomModelTrainingDataConfig;
import com.pulumi.aws.bedrock.outputs.GetCustomModelTrainingMetric;
import com.pulumi.aws.bedrock.outputs.GetCustomModelValidationDataConfig;
import com.pulumi.aws.bedrock.outputs.GetCustomModelValidationMetric;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetCustomModelResult {
    /**
     * @return ARN of the base model.
     * 
     */
    private String baseModelArn;
    /**
     * @return Creation time of the model.
     * 
     */
    private String creationTime;
    /**
     * @return Hyperparameter values associated with this model.
     * 
     */
    private Map<String,String> hyperparameters;
    private String id;
    /**
     * @return Job ARN associated with this model.
     * 
     */
    private String jobArn;
    /**
     * @return Job name associated with this model.
     * 
     */
    private String jobName;
    /**
     * @return Key-value mapping of tags for the fine-tuning job.
     * 
     */
    private Map<String,String> jobTags;
    /**
     * @return ARN associated with this model.
     * 
     */
    private String modelArn;
    private String modelId;
    /**
     * @return The custom model is encrypted at rest using this key.
     * 
     */
    private String modelKmsKeyArn;
    /**
     * @return Model name associated with this model.
     * 
     */
    private String modelName;
    /**
     * @return Key-value mapping of tags for the model.
     * 
     */
    private Map<String,String> modelTags;
    /**
     * @return Output data configuration associated with this custom model.
     * 
     */
    private List<GetCustomModelOutputDataConfig> outputDataConfigs;
    /**
     * @return Information about the training dataset.
     * 
     */
    private List<GetCustomModelTrainingDataConfig> trainingDataConfigs;
    /**
     * @return Metrics associated with the customization job.
     * 
     */
    private List<GetCustomModelTrainingMetric> trainingMetrics;
    /**
     * @return Information about the validation dataset.
     * 
     */
    private List<GetCustomModelValidationDataConfig> validationDataConfigs;
    /**
     * @return The loss metric for each validator that you provided.
     * 
     */
    private List<GetCustomModelValidationMetric> validationMetrics;

    private GetCustomModelResult() {}
    /**
     * @return ARN of the base model.
     * 
     */
    public String baseModelArn() {
        return this.baseModelArn;
    }
    /**
     * @return Creation time of the model.
     * 
     */
    public String creationTime() {
        return this.creationTime;
    }
    /**
     * @return Hyperparameter values associated with this model.
     * 
     */
    public Map<String,String> hyperparameters() {
        return this.hyperparameters;
    }
    public String id() {
        return this.id;
    }
    /**
     * @return Job ARN associated with this model.
     * 
     */
    public String jobArn() {
        return this.jobArn;
    }
    /**
     * @return Job name associated with this model.
     * 
     */
    public String jobName() {
        return this.jobName;
    }
    /**
     * @return Key-value mapping of tags for the fine-tuning job.
     * 
     */
    public Map<String,String> jobTags() {
        return this.jobTags;
    }
    /**
     * @return ARN associated with this model.
     * 
     */
    public String modelArn() {
        return this.modelArn;
    }
    public String modelId() {
        return this.modelId;
    }
    /**
     * @return The custom model is encrypted at rest using this key.
     * 
     */
    public String modelKmsKeyArn() {
        return this.modelKmsKeyArn;
    }
    /**
     * @return Model name associated with this model.
     * 
     */
    public String modelName() {
        return this.modelName;
    }
    /**
     * @return Key-value mapping of tags for the model.
     * 
     */
    public Map<String,String> modelTags() {
        return this.modelTags;
    }
    /**
     * @return Output data configuration associated with this custom model.
     * 
     */
    public List<GetCustomModelOutputDataConfig> outputDataConfigs() {
        return this.outputDataConfigs;
    }
    /**
     * @return Information about the training dataset.
     * 
     */
    public List<GetCustomModelTrainingDataConfig> trainingDataConfigs() {
        return this.trainingDataConfigs;
    }
    /**
     * @return Metrics associated with the customization job.
     * 
     */
    public List<GetCustomModelTrainingMetric> trainingMetrics() {
        return this.trainingMetrics;
    }
    /**
     * @return Information about the validation dataset.
     * 
     */
    public List<GetCustomModelValidationDataConfig> validationDataConfigs() {
        return this.validationDataConfigs;
    }
    /**
     * @return The loss metric for each validator that you provided.
     * 
     */
    public List<GetCustomModelValidationMetric> validationMetrics() {
        return this.validationMetrics;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetCustomModelResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String baseModelArn;
        private String creationTime;
        private Map<String,String> hyperparameters;
        private String id;
        private String jobArn;
        private String jobName;
        private Map<String,String> jobTags;
        private String modelArn;
        private String modelId;
        private String modelKmsKeyArn;
        private String modelName;
        private Map<String,String> modelTags;
        private List<GetCustomModelOutputDataConfig> outputDataConfigs;
        private List<GetCustomModelTrainingDataConfig> trainingDataConfigs;
        private List<GetCustomModelTrainingMetric> trainingMetrics;
        private List<GetCustomModelValidationDataConfig> validationDataConfigs;
        private List<GetCustomModelValidationMetric> validationMetrics;
        public Builder() {}
        public Builder(GetCustomModelResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.baseModelArn = defaults.baseModelArn;
    	      this.creationTime = defaults.creationTime;
    	      this.hyperparameters = defaults.hyperparameters;
    	      this.id = defaults.id;
    	      this.jobArn = defaults.jobArn;
    	      this.jobName = defaults.jobName;
    	      this.jobTags = defaults.jobTags;
    	      this.modelArn = defaults.modelArn;
    	      this.modelId = defaults.modelId;
    	      this.modelKmsKeyArn = defaults.modelKmsKeyArn;
    	      this.modelName = defaults.modelName;
    	      this.modelTags = defaults.modelTags;
    	      this.outputDataConfigs = defaults.outputDataConfigs;
    	      this.trainingDataConfigs = defaults.trainingDataConfigs;
    	      this.trainingMetrics = defaults.trainingMetrics;
    	      this.validationDataConfigs = defaults.validationDataConfigs;
    	      this.validationMetrics = defaults.validationMetrics;
        }

        @CustomType.Setter
        public Builder baseModelArn(String baseModelArn) {
            if (baseModelArn == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "baseModelArn");
            }
            this.baseModelArn = baseModelArn;
            return this;
        }
        @CustomType.Setter
        public Builder creationTime(String creationTime) {
            if (creationTime == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "creationTime");
            }
            this.creationTime = creationTime;
            return this;
        }
        @CustomType.Setter
        public Builder hyperparameters(Map<String,String> hyperparameters) {
            if (hyperparameters == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "hyperparameters");
            }
            this.hyperparameters = hyperparameters;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder jobArn(String jobArn) {
            if (jobArn == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "jobArn");
            }
            this.jobArn = jobArn;
            return this;
        }
        @CustomType.Setter
        public Builder jobName(String jobName) {
            if (jobName == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "jobName");
            }
            this.jobName = jobName;
            return this;
        }
        @CustomType.Setter
        public Builder jobTags(Map<String,String> jobTags) {
            if (jobTags == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "jobTags");
            }
            this.jobTags = jobTags;
            return this;
        }
        @CustomType.Setter
        public Builder modelArn(String modelArn) {
            if (modelArn == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "modelArn");
            }
            this.modelArn = modelArn;
            return this;
        }
        @CustomType.Setter
        public Builder modelId(String modelId) {
            if (modelId == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "modelId");
            }
            this.modelId = modelId;
            return this;
        }
        @CustomType.Setter
        public Builder modelKmsKeyArn(String modelKmsKeyArn) {
            if (modelKmsKeyArn == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "modelKmsKeyArn");
            }
            this.modelKmsKeyArn = modelKmsKeyArn;
            return this;
        }
        @CustomType.Setter
        public Builder modelName(String modelName) {
            if (modelName == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "modelName");
            }
            this.modelName = modelName;
            return this;
        }
        @CustomType.Setter
        public Builder modelTags(Map<String,String> modelTags) {
            if (modelTags == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "modelTags");
            }
            this.modelTags = modelTags;
            return this;
        }
        @CustomType.Setter
        public Builder outputDataConfigs(List<GetCustomModelOutputDataConfig> outputDataConfigs) {
            if (outputDataConfigs == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "outputDataConfigs");
            }
            this.outputDataConfigs = outputDataConfigs;
            return this;
        }
        public Builder outputDataConfigs(GetCustomModelOutputDataConfig... outputDataConfigs) {
            return outputDataConfigs(List.of(outputDataConfigs));
        }
        @CustomType.Setter
        public Builder trainingDataConfigs(List<GetCustomModelTrainingDataConfig> trainingDataConfigs) {
            if (trainingDataConfigs == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "trainingDataConfigs");
            }
            this.trainingDataConfigs = trainingDataConfigs;
            return this;
        }
        public Builder trainingDataConfigs(GetCustomModelTrainingDataConfig... trainingDataConfigs) {
            return trainingDataConfigs(List.of(trainingDataConfigs));
        }
        @CustomType.Setter
        public Builder trainingMetrics(List<GetCustomModelTrainingMetric> trainingMetrics) {
            if (trainingMetrics == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "trainingMetrics");
            }
            this.trainingMetrics = trainingMetrics;
            return this;
        }
        public Builder trainingMetrics(GetCustomModelTrainingMetric... trainingMetrics) {
            return trainingMetrics(List.of(trainingMetrics));
        }
        @CustomType.Setter
        public Builder validationDataConfigs(List<GetCustomModelValidationDataConfig> validationDataConfigs) {
            if (validationDataConfigs == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "validationDataConfigs");
            }
            this.validationDataConfigs = validationDataConfigs;
            return this;
        }
        public Builder validationDataConfigs(GetCustomModelValidationDataConfig... validationDataConfigs) {
            return validationDataConfigs(List.of(validationDataConfigs));
        }
        @CustomType.Setter
        public Builder validationMetrics(List<GetCustomModelValidationMetric> validationMetrics) {
            if (validationMetrics == null) {
              throw new MissingRequiredPropertyException("GetCustomModelResult", "validationMetrics");
            }
            this.validationMetrics = validationMetrics;
            return this;
        }
        public Builder validationMetrics(GetCustomModelValidationMetric... validationMetrics) {
            return validationMetrics(List.of(validationMetrics));
        }
        public GetCustomModelResult build() {
            final var _resultValue = new GetCustomModelResult();
            _resultValue.baseModelArn = baseModelArn;
            _resultValue.creationTime = creationTime;
            _resultValue.hyperparameters = hyperparameters;
            _resultValue.id = id;
            _resultValue.jobArn = jobArn;
            _resultValue.jobName = jobName;
            _resultValue.jobTags = jobTags;
            _resultValue.modelArn = modelArn;
            _resultValue.modelId = modelId;
            _resultValue.modelKmsKeyArn = modelKmsKeyArn;
            _resultValue.modelName = modelName;
            _resultValue.modelTags = modelTags;
            _resultValue.outputDataConfigs = outputDataConfigs;
            _resultValue.trainingDataConfigs = trainingDataConfigs;
            _resultValue.trainingMetrics = trainingMetrics;
            _resultValue.validationDataConfigs = validationDataConfigs;
            _resultValue.validationMetrics = validationMetrics;
            return _resultValue;
        }
    }
}
