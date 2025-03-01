// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kendra.outputs;

import com.pulumi.aws.kendra.outputs.GetThesaurusSourceS3Path;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetThesaurusResult {
    /**
     * @return ARN of the Thesaurus.
     * 
     */
    private String arn;
    /**
     * @return Unix datetime that the Thesaurus was created.
     * 
     */
    private String createdAt;
    /**
     * @return Description of the Thesaurus.
     * 
     */
    private String description;
    /**
     * @return When the `status` field value is `FAILED`, this contains a message that explains why.
     * 
     */
    private String errorMessage;
    /**
     * @return Size of the Thesaurus file in bytes.
     * 
     */
    private Integer fileSizeBytes;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private String indexId;
    /**
     * @return Name of the Thesaurus.
     * 
     */
    private String name;
    /**
     * @return ARN of a role with permission to access the S3 bucket that contains the Thesaurus. For more information, see [IAM Roles for Amazon Kendra](https://docs.aws.amazon.com/kendra/latest/dg/iam-roles.html).
     * 
     */
    private String roleArn;
    /**
     * @return S3 location of the Thesaurus input data. Detailed below.
     * 
     */
    private List<GetThesaurusSourceS3Path> sourceS3Paths;
    /**
     * @return Status of the Thesaurus. It is ready to use when the status is `ACTIVE`.
     * 
     */
    private String status;
    /**
     * @return Number of synonym rules in the Thesaurus file.
     * 
     */
    private Integer synonymRuleCount;
    /**
     * @return Metadata that helps organize the Thesaurus you create.
     * 
     */
    private Map<String,String> tags;
    /**
     * @return Number of unique terms in the Thesaurus file. For example, the synonyms `a,b,c` and `a=&gt;d`, the term count would be 4.
     * 
     */
    private Integer termCount;
    private String thesaurusId;
    /**
     * @return Date and time that the Thesaurus was last updated.
     * 
     */
    private String updatedAt;

    private GetThesaurusResult() {}
    /**
     * @return ARN of the Thesaurus.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return Unix datetime that the Thesaurus was created.
     * 
     */
    public String createdAt() {
        return this.createdAt;
    }
    /**
     * @return Description of the Thesaurus.
     * 
     */
    public String description() {
        return this.description;
    }
    /**
     * @return When the `status` field value is `FAILED`, this contains a message that explains why.
     * 
     */
    public String errorMessage() {
        return this.errorMessage;
    }
    /**
     * @return Size of the Thesaurus file in bytes.
     * 
     */
    public Integer fileSizeBytes() {
        return this.fileSizeBytes;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    public String indexId() {
        return this.indexId;
    }
    /**
     * @return Name of the Thesaurus.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return ARN of a role with permission to access the S3 bucket that contains the Thesaurus. For more information, see [IAM Roles for Amazon Kendra](https://docs.aws.amazon.com/kendra/latest/dg/iam-roles.html).
     * 
     */
    public String roleArn() {
        return this.roleArn;
    }
    /**
     * @return S3 location of the Thesaurus input data. Detailed below.
     * 
     */
    public List<GetThesaurusSourceS3Path> sourceS3Paths() {
        return this.sourceS3Paths;
    }
    /**
     * @return Status of the Thesaurus. It is ready to use when the status is `ACTIVE`.
     * 
     */
    public String status() {
        return this.status;
    }
    /**
     * @return Number of synonym rules in the Thesaurus file.
     * 
     */
    public Integer synonymRuleCount() {
        return this.synonymRuleCount;
    }
    /**
     * @return Metadata that helps organize the Thesaurus you create.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }
    /**
     * @return Number of unique terms in the Thesaurus file. For example, the synonyms `a,b,c` and `a=&gt;d`, the term count would be 4.
     * 
     */
    public Integer termCount() {
        return this.termCount;
    }
    public String thesaurusId() {
        return this.thesaurusId;
    }
    /**
     * @return Date and time that the Thesaurus was last updated.
     * 
     */
    public String updatedAt() {
        return this.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetThesaurusResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String createdAt;
        private String description;
        private String errorMessage;
        private Integer fileSizeBytes;
        private String id;
        private String indexId;
        private String name;
        private String roleArn;
        private List<GetThesaurusSourceS3Path> sourceS3Paths;
        private String status;
        private Integer synonymRuleCount;
        private Map<String,String> tags;
        private Integer termCount;
        private String thesaurusId;
        private String updatedAt;
        public Builder() {}
        public Builder(GetThesaurusResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.createdAt = defaults.createdAt;
    	      this.description = defaults.description;
    	      this.errorMessage = defaults.errorMessage;
    	      this.fileSizeBytes = defaults.fileSizeBytes;
    	      this.id = defaults.id;
    	      this.indexId = defaults.indexId;
    	      this.name = defaults.name;
    	      this.roleArn = defaults.roleArn;
    	      this.sourceS3Paths = defaults.sourceS3Paths;
    	      this.status = defaults.status;
    	      this.synonymRuleCount = defaults.synonymRuleCount;
    	      this.tags = defaults.tags;
    	      this.termCount = defaults.termCount;
    	      this.thesaurusId = defaults.thesaurusId;
    	      this.updatedAt = defaults.updatedAt;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder createdAt(String createdAt) {
            if (createdAt == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "createdAt");
            }
            this.createdAt = createdAt;
            return this;
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder errorMessage(String errorMessage) {
            if (errorMessage == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "errorMessage");
            }
            this.errorMessage = errorMessage;
            return this;
        }
        @CustomType.Setter
        public Builder fileSizeBytes(Integer fileSizeBytes) {
            if (fileSizeBytes == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "fileSizeBytes");
            }
            this.fileSizeBytes = fileSizeBytes;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder indexId(String indexId) {
            if (indexId == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "indexId");
            }
            this.indexId = indexId;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder roleArn(String roleArn) {
            if (roleArn == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "roleArn");
            }
            this.roleArn = roleArn;
            return this;
        }
        @CustomType.Setter
        public Builder sourceS3Paths(List<GetThesaurusSourceS3Path> sourceS3Paths) {
            if (sourceS3Paths == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "sourceS3Paths");
            }
            this.sourceS3Paths = sourceS3Paths;
            return this;
        }
        public Builder sourceS3Paths(GetThesaurusSourceS3Path... sourceS3Paths) {
            return sourceS3Paths(List.of(sourceS3Paths));
        }
        @CustomType.Setter
        public Builder status(String status) {
            if (status == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "status");
            }
            this.status = status;
            return this;
        }
        @CustomType.Setter
        public Builder synonymRuleCount(Integer synonymRuleCount) {
            if (synonymRuleCount == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "synonymRuleCount");
            }
            this.synonymRuleCount = synonymRuleCount;
            return this;
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        @CustomType.Setter
        public Builder termCount(Integer termCount) {
            if (termCount == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "termCount");
            }
            this.termCount = termCount;
            return this;
        }
        @CustomType.Setter
        public Builder thesaurusId(String thesaurusId) {
            if (thesaurusId == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "thesaurusId");
            }
            this.thesaurusId = thesaurusId;
            return this;
        }
        @CustomType.Setter
        public Builder updatedAt(String updatedAt) {
            if (updatedAt == null) {
              throw new MissingRequiredPropertyException("GetThesaurusResult", "updatedAt");
            }
            this.updatedAt = updatedAt;
            return this;
        }
        public GetThesaurusResult build() {
            final var _resultValue = new GetThesaurusResult();
            _resultValue.arn = arn;
            _resultValue.createdAt = createdAt;
            _resultValue.description = description;
            _resultValue.errorMessage = errorMessage;
            _resultValue.fileSizeBytes = fileSizeBytes;
            _resultValue.id = id;
            _resultValue.indexId = indexId;
            _resultValue.name = name;
            _resultValue.roleArn = roleArn;
            _resultValue.sourceS3Paths = sourceS3Paths;
            _resultValue.status = status;
            _resultValue.synonymRuleCount = synonymRuleCount;
            _resultValue.tags = tags;
            _resultValue.termCount = termCount;
            _resultValue.thesaurusId = thesaurusId;
            _resultValue.updatedAt = updatedAt;
            return _resultValue;
        }
    }
}
