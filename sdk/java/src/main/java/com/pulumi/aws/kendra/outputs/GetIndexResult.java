// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kendra.outputs;

import com.pulumi.aws.kendra.outputs.GetIndexCapacityUnit;
import com.pulumi.aws.kendra.outputs.GetIndexDocumentMetadataConfigurationUpdate;
import com.pulumi.aws.kendra.outputs.GetIndexIndexStatistic;
import com.pulumi.aws.kendra.outputs.GetIndexServerSideEncryptionConfiguration;
import com.pulumi.aws.kendra.outputs.GetIndexUserGroupResolutionConfiguration;
import com.pulumi.aws.kendra.outputs.GetIndexUserTokenConfiguration;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetIndexResult {
    /**
     * @return ARN of the Index.
     * 
     */
    private String arn;
    /**
     * @return Block that sets the number of additional document storage and query capacity units that should be used by the index. Documented below.
     * 
     */
    private List<GetIndexCapacityUnit> capacityUnits;
    /**
     * @return Unix datetime that the index was created.
     * 
     */
    private String createdAt;
    /**
     * @return Description of the Index.
     * 
     */
    private String description;
    /**
     * @return One or more blocks that specify the configuration settings for any metadata applied to the documents in the index. Documented below.
     * 
     */
    private List<GetIndexDocumentMetadataConfigurationUpdate> documentMetadataConfigurationUpdates;
    /**
     * @return Amazon Kendra edition for the index.
     * 
     */
    private String edition;
    /**
     * @return When the Status field value is `FAILED`, this contains a message that explains why.
     * 
     */
    private String errorMessage;
    /**
     * @return Identifier of the Index.
     * 
     */
    private String id;
    /**
     * @return Block that provides information about the number of FAQ questions and answers and the number of text documents indexed. Documented below.
     * 
     */
    private List<GetIndexIndexStatistic> indexStatistics;
    /**
     * @return Name of the index field. Minimum length of 1. Maximum length of 30.
     * 
     */
    private String name;
    /**
     * @return An AWS Identity and Access Management (IAM) role that gives Amazon Kendra permissions to access your Amazon CloudWatch logs and metrics. This is also the role you use when you call the `BatchPutDocument` API to index documents from an Amazon S3 bucket.
     * 
     */
    private String roleArn;
    /**
     * @return A block that specifies the identifier of the AWS KMS customer managed key (CMK) that&#39;s used to encrypt data indexed by Amazon Kendra. Amazon Kendra doesn&#39;t support asymmetric CMKs. Documented below.
     * 
     */
    private List<GetIndexServerSideEncryptionConfiguration> serverSideEncryptionConfigurations;
    /**
     * @return Current status of the index. When the value is `ACTIVE`, the index is ready for use. If the Status field value is `FAILED`, the `error_message` field contains a message that explains why.
     * 
     */
    private String status;
    /**
     * @return Metadata that helps organize the Indices you create.
     * 
     */
    private Map<String,String> tags;
    /**
     * @return Unix datetime that the index was last updated.
     * 
     */
    private String updatedAt;
    /**
     * @return User context policy. Valid values are `ATTRIBUTE_FILTER` or `USER_TOKEN`. For more information, refer to [UserContextPolicy](https://docs.aws.amazon.com/kendra/latest/APIReference/API_CreateIndex.html#kendra-CreateIndex-request-UserContextPolicy).
     * 
     */
    private String userContextPolicy;
    /**
     * @return A block that enables fetching access levels of groups and users from an AWS Single Sign-On identity source. Documented below.
     * 
     */
    private List<GetIndexUserGroupResolutionConfiguration> userGroupResolutionConfigurations;
    /**
     * @return A block that specifies the user token configuration. Documented below.
     * 
     */
    private List<GetIndexUserTokenConfiguration> userTokenConfigurations;

    private GetIndexResult() {}
    /**
     * @return ARN of the Index.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return Block that sets the number of additional document storage and query capacity units that should be used by the index. Documented below.
     * 
     */
    public List<GetIndexCapacityUnit> capacityUnits() {
        return this.capacityUnits;
    }
    /**
     * @return Unix datetime that the index was created.
     * 
     */
    public String createdAt() {
        return this.createdAt;
    }
    /**
     * @return Description of the Index.
     * 
     */
    public String description() {
        return this.description;
    }
    /**
     * @return One or more blocks that specify the configuration settings for any metadata applied to the documents in the index. Documented below.
     * 
     */
    public List<GetIndexDocumentMetadataConfigurationUpdate> documentMetadataConfigurationUpdates() {
        return this.documentMetadataConfigurationUpdates;
    }
    /**
     * @return Amazon Kendra edition for the index.
     * 
     */
    public String edition() {
        return this.edition;
    }
    /**
     * @return When the Status field value is `FAILED`, this contains a message that explains why.
     * 
     */
    public String errorMessage() {
        return this.errorMessage;
    }
    /**
     * @return Identifier of the Index.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return Block that provides information about the number of FAQ questions and answers and the number of text documents indexed. Documented below.
     * 
     */
    public List<GetIndexIndexStatistic> indexStatistics() {
        return this.indexStatistics;
    }
    /**
     * @return Name of the index field. Minimum length of 1. Maximum length of 30.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return An AWS Identity and Access Management (IAM) role that gives Amazon Kendra permissions to access your Amazon CloudWatch logs and metrics. This is also the role you use when you call the `BatchPutDocument` API to index documents from an Amazon S3 bucket.
     * 
     */
    public String roleArn() {
        return this.roleArn;
    }
    /**
     * @return A block that specifies the identifier of the AWS KMS customer managed key (CMK) that&#39;s used to encrypt data indexed by Amazon Kendra. Amazon Kendra doesn&#39;t support asymmetric CMKs. Documented below.
     * 
     */
    public List<GetIndexServerSideEncryptionConfiguration> serverSideEncryptionConfigurations() {
        return this.serverSideEncryptionConfigurations;
    }
    /**
     * @return Current status of the index. When the value is `ACTIVE`, the index is ready for use. If the Status field value is `FAILED`, the `error_message` field contains a message that explains why.
     * 
     */
    public String status() {
        return this.status;
    }
    /**
     * @return Metadata that helps organize the Indices you create.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }
    /**
     * @return Unix datetime that the index was last updated.
     * 
     */
    public String updatedAt() {
        return this.updatedAt;
    }
    /**
     * @return User context policy. Valid values are `ATTRIBUTE_FILTER` or `USER_TOKEN`. For more information, refer to [UserContextPolicy](https://docs.aws.amazon.com/kendra/latest/APIReference/API_CreateIndex.html#kendra-CreateIndex-request-UserContextPolicy).
     * 
     */
    public String userContextPolicy() {
        return this.userContextPolicy;
    }
    /**
     * @return A block that enables fetching access levels of groups and users from an AWS Single Sign-On identity source. Documented below.
     * 
     */
    public List<GetIndexUserGroupResolutionConfiguration> userGroupResolutionConfigurations() {
        return this.userGroupResolutionConfigurations;
    }
    /**
     * @return A block that specifies the user token configuration. Documented below.
     * 
     */
    public List<GetIndexUserTokenConfiguration> userTokenConfigurations() {
        return this.userTokenConfigurations;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetIndexResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private List<GetIndexCapacityUnit> capacityUnits;
        private String createdAt;
        private String description;
        private List<GetIndexDocumentMetadataConfigurationUpdate> documentMetadataConfigurationUpdates;
        private String edition;
        private String errorMessage;
        private String id;
        private List<GetIndexIndexStatistic> indexStatistics;
        private String name;
        private String roleArn;
        private List<GetIndexServerSideEncryptionConfiguration> serverSideEncryptionConfigurations;
        private String status;
        private Map<String,String> tags;
        private String updatedAt;
        private String userContextPolicy;
        private List<GetIndexUserGroupResolutionConfiguration> userGroupResolutionConfigurations;
        private List<GetIndexUserTokenConfiguration> userTokenConfigurations;
        public Builder() {}
        public Builder(GetIndexResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.capacityUnits = defaults.capacityUnits;
    	      this.createdAt = defaults.createdAt;
    	      this.description = defaults.description;
    	      this.documentMetadataConfigurationUpdates = defaults.documentMetadataConfigurationUpdates;
    	      this.edition = defaults.edition;
    	      this.errorMessage = defaults.errorMessage;
    	      this.id = defaults.id;
    	      this.indexStatistics = defaults.indexStatistics;
    	      this.name = defaults.name;
    	      this.roleArn = defaults.roleArn;
    	      this.serverSideEncryptionConfigurations = defaults.serverSideEncryptionConfigurations;
    	      this.status = defaults.status;
    	      this.tags = defaults.tags;
    	      this.updatedAt = defaults.updatedAt;
    	      this.userContextPolicy = defaults.userContextPolicy;
    	      this.userGroupResolutionConfigurations = defaults.userGroupResolutionConfigurations;
    	      this.userTokenConfigurations = defaults.userTokenConfigurations;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder capacityUnits(List<GetIndexCapacityUnit> capacityUnits) {
            if (capacityUnits == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "capacityUnits");
            }
            this.capacityUnits = capacityUnits;
            return this;
        }
        public Builder capacityUnits(GetIndexCapacityUnit... capacityUnits) {
            return capacityUnits(List.of(capacityUnits));
        }
        @CustomType.Setter
        public Builder createdAt(String createdAt) {
            if (createdAt == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "createdAt");
            }
            this.createdAt = createdAt;
            return this;
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder documentMetadataConfigurationUpdates(List<GetIndexDocumentMetadataConfigurationUpdate> documentMetadataConfigurationUpdates) {
            if (documentMetadataConfigurationUpdates == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "documentMetadataConfigurationUpdates");
            }
            this.documentMetadataConfigurationUpdates = documentMetadataConfigurationUpdates;
            return this;
        }
        public Builder documentMetadataConfigurationUpdates(GetIndexDocumentMetadataConfigurationUpdate... documentMetadataConfigurationUpdates) {
            return documentMetadataConfigurationUpdates(List.of(documentMetadataConfigurationUpdates));
        }
        @CustomType.Setter
        public Builder edition(String edition) {
            if (edition == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "edition");
            }
            this.edition = edition;
            return this;
        }
        @CustomType.Setter
        public Builder errorMessage(String errorMessage) {
            if (errorMessage == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "errorMessage");
            }
            this.errorMessage = errorMessage;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder indexStatistics(List<GetIndexIndexStatistic> indexStatistics) {
            if (indexStatistics == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "indexStatistics");
            }
            this.indexStatistics = indexStatistics;
            return this;
        }
        public Builder indexStatistics(GetIndexIndexStatistic... indexStatistics) {
            return indexStatistics(List.of(indexStatistics));
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder roleArn(String roleArn) {
            if (roleArn == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "roleArn");
            }
            this.roleArn = roleArn;
            return this;
        }
        @CustomType.Setter
        public Builder serverSideEncryptionConfigurations(List<GetIndexServerSideEncryptionConfiguration> serverSideEncryptionConfigurations) {
            if (serverSideEncryptionConfigurations == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "serverSideEncryptionConfigurations");
            }
            this.serverSideEncryptionConfigurations = serverSideEncryptionConfigurations;
            return this;
        }
        public Builder serverSideEncryptionConfigurations(GetIndexServerSideEncryptionConfiguration... serverSideEncryptionConfigurations) {
            return serverSideEncryptionConfigurations(List.of(serverSideEncryptionConfigurations));
        }
        @CustomType.Setter
        public Builder status(String status) {
            if (status == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "status");
            }
            this.status = status;
            return this;
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        @CustomType.Setter
        public Builder updatedAt(String updatedAt) {
            if (updatedAt == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "updatedAt");
            }
            this.updatedAt = updatedAt;
            return this;
        }
        @CustomType.Setter
        public Builder userContextPolicy(String userContextPolicy) {
            if (userContextPolicy == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "userContextPolicy");
            }
            this.userContextPolicy = userContextPolicy;
            return this;
        }
        @CustomType.Setter
        public Builder userGroupResolutionConfigurations(List<GetIndexUserGroupResolutionConfiguration> userGroupResolutionConfigurations) {
            if (userGroupResolutionConfigurations == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "userGroupResolutionConfigurations");
            }
            this.userGroupResolutionConfigurations = userGroupResolutionConfigurations;
            return this;
        }
        public Builder userGroupResolutionConfigurations(GetIndexUserGroupResolutionConfiguration... userGroupResolutionConfigurations) {
            return userGroupResolutionConfigurations(List.of(userGroupResolutionConfigurations));
        }
        @CustomType.Setter
        public Builder userTokenConfigurations(List<GetIndexUserTokenConfiguration> userTokenConfigurations) {
            if (userTokenConfigurations == null) {
              throw new MissingRequiredPropertyException("GetIndexResult", "userTokenConfigurations");
            }
            this.userTokenConfigurations = userTokenConfigurations;
            return this;
        }
        public Builder userTokenConfigurations(GetIndexUserTokenConfiguration... userTokenConfigurations) {
            return userTokenConfigurations(List.of(userTokenConfigurations));
        }
        public GetIndexResult build() {
            final var _resultValue = new GetIndexResult();
            _resultValue.arn = arn;
            _resultValue.capacityUnits = capacityUnits;
            _resultValue.createdAt = createdAt;
            _resultValue.description = description;
            _resultValue.documentMetadataConfigurationUpdates = documentMetadataConfigurationUpdates;
            _resultValue.edition = edition;
            _resultValue.errorMessage = errorMessage;
            _resultValue.id = id;
            _resultValue.indexStatistics = indexStatistics;
            _resultValue.name = name;
            _resultValue.roleArn = roleArn;
            _resultValue.serverSideEncryptionConfigurations = serverSideEncryptionConfigurations;
            _resultValue.status = status;
            _resultValue.tags = tags;
            _resultValue.updatedAt = updatedAt;
            _resultValue.userContextPolicy = userContextPolicy;
            _resultValue.userGroupResolutionConfigurations = userGroupResolutionConfigurations;
            _resultValue.userTokenConfigurations = userTokenConfigurations;
            return _resultValue;
        }
    }
}
