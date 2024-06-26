// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.backup.outputs;

import com.pulumi.aws.backup.outputs.GetReportPlanReportDeliveryChannel;
import com.pulumi.aws.backup.outputs.GetReportPlanReportSetting;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetReportPlanResult {
    /**
     * @return ARN of the backup report plan.
     * 
     */
    private String arn;
    /**
     * @return Date and time that a report plan is created, in Unix format and Coordinated Universal Time (UTC).
     * 
     */
    private String creationTime;
    /**
     * @return Deployment status of a report plan. The statuses are: `CREATE_IN_PROGRESS` | `UPDATE_IN_PROGRESS` | `DELETE_IN_PROGRESS` | `COMPLETED`.
     * 
     */
    private String deploymentStatus;
    /**
     * @return Description of the report plan.
     * 
     */
    private String description;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private String name;
    /**
     * @return An object that contains information about where and how to deliver your reports, specifically your Amazon S3 bucket name, S3 key prefix, and the formats of your reports. Detailed below.
     * 
     */
    private List<GetReportPlanReportDeliveryChannel> reportDeliveryChannels;
    /**
     * @return An object that identifies the report template for the report. Reports are built using a report template. Detailed below.
     * 
     */
    private List<GetReportPlanReportSetting> reportSettings;
    /**
     * @return Metadata that you can assign to help organize the report plans you create.
     * 
     */
    private Map<String,String> tags;

    private GetReportPlanResult() {}
    /**
     * @return ARN of the backup report plan.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return Date and time that a report plan is created, in Unix format and Coordinated Universal Time (UTC).
     * 
     */
    public String creationTime() {
        return this.creationTime;
    }
    /**
     * @return Deployment status of a report plan. The statuses are: `CREATE_IN_PROGRESS` | `UPDATE_IN_PROGRESS` | `DELETE_IN_PROGRESS` | `COMPLETED`.
     * 
     */
    public String deploymentStatus() {
        return this.deploymentStatus;
    }
    /**
     * @return Description of the report plan.
     * 
     */
    public String description() {
        return this.description;
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
    /**
     * @return An object that contains information about where and how to deliver your reports, specifically your Amazon S3 bucket name, S3 key prefix, and the formats of your reports. Detailed below.
     * 
     */
    public List<GetReportPlanReportDeliveryChannel> reportDeliveryChannels() {
        return this.reportDeliveryChannels;
    }
    /**
     * @return An object that identifies the report template for the report. Reports are built using a report template. Detailed below.
     * 
     */
    public List<GetReportPlanReportSetting> reportSettings() {
        return this.reportSettings;
    }
    /**
     * @return Metadata that you can assign to help organize the report plans you create.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetReportPlanResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String creationTime;
        private String deploymentStatus;
        private String description;
        private String id;
        private String name;
        private List<GetReportPlanReportDeliveryChannel> reportDeliveryChannels;
        private List<GetReportPlanReportSetting> reportSettings;
        private Map<String,String> tags;
        public Builder() {}
        public Builder(GetReportPlanResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.creationTime = defaults.creationTime;
    	      this.deploymentStatus = defaults.deploymentStatus;
    	      this.description = defaults.description;
    	      this.id = defaults.id;
    	      this.name = defaults.name;
    	      this.reportDeliveryChannels = defaults.reportDeliveryChannels;
    	      this.reportSettings = defaults.reportSettings;
    	      this.tags = defaults.tags;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetReportPlanResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder creationTime(String creationTime) {
            if (creationTime == null) {
              throw new MissingRequiredPropertyException("GetReportPlanResult", "creationTime");
            }
            this.creationTime = creationTime;
            return this;
        }
        @CustomType.Setter
        public Builder deploymentStatus(String deploymentStatus) {
            if (deploymentStatus == null) {
              throw new MissingRequiredPropertyException("GetReportPlanResult", "deploymentStatus");
            }
            this.deploymentStatus = deploymentStatus;
            return this;
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetReportPlanResult", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetReportPlanResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetReportPlanResult", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder reportDeliveryChannels(List<GetReportPlanReportDeliveryChannel> reportDeliveryChannels) {
            if (reportDeliveryChannels == null) {
              throw new MissingRequiredPropertyException("GetReportPlanResult", "reportDeliveryChannels");
            }
            this.reportDeliveryChannels = reportDeliveryChannels;
            return this;
        }
        public Builder reportDeliveryChannels(GetReportPlanReportDeliveryChannel... reportDeliveryChannels) {
            return reportDeliveryChannels(List.of(reportDeliveryChannels));
        }
        @CustomType.Setter
        public Builder reportSettings(List<GetReportPlanReportSetting> reportSettings) {
            if (reportSettings == null) {
              throw new MissingRequiredPropertyException("GetReportPlanResult", "reportSettings");
            }
            this.reportSettings = reportSettings;
            return this;
        }
        public Builder reportSettings(GetReportPlanReportSetting... reportSettings) {
            return reportSettings(List.of(reportSettings));
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetReportPlanResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        public GetReportPlanResult build() {
            final var _resultValue = new GetReportPlanResult();
            _resultValue.arn = arn;
            _resultValue.creationTime = creationTime;
            _resultValue.deploymentStatus = deploymentStatus;
            _resultValue.description = description;
            _resultValue.id = id;
            _resultValue.name = name;
            _resultValue.reportDeliveryChannels = reportDeliveryChannels;
            _resultValue.reportSettings = reportSettings;
            _resultValue.tags = tags;
            return _resultValue;
        }
    }
}
