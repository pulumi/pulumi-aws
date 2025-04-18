// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.timestreaminfluxdb.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class DbInstanceLogDeliveryConfigurationS3Configuration {
    /**
     * @return Name of the S3 bucket to deliver logs to.
     * 
     */
    private String bucketName;
    /**
     * @return Indicates whether log delivery to the S3 bucket is enabled.
     * 
     * **Note**: The following arguments do updates in-place: `db_parameter_group_identifier`, `log_delivery_configuration`, `port`, `deployment_type`, `db_instance_type`, and `tags`. Changes to any other argument after a DB instance has been deployed will cause destruction and re-creation of the DB instance. Additionally, when `db_parameter_group_identifier` is added to a DB instance or modified, the DB instance will be updated in-place but if `db_parameter_group_identifier` is removed from a DB instance, the DB instance will be destroyed and re-created.
     * 
     */
    private Boolean enabled;

    private DbInstanceLogDeliveryConfigurationS3Configuration() {}
    /**
     * @return Name of the S3 bucket to deliver logs to.
     * 
     */
    public String bucketName() {
        return this.bucketName;
    }
    /**
     * @return Indicates whether log delivery to the S3 bucket is enabled.
     * 
     * **Note**: The following arguments do updates in-place: `db_parameter_group_identifier`, `log_delivery_configuration`, `port`, `deployment_type`, `db_instance_type`, and `tags`. Changes to any other argument after a DB instance has been deployed will cause destruction and re-creation of the DB instance. Additionally, when `db_parameter_group_identifier` is added to a DB instance or modified, the DB instance will be updated in-place but if `db_parameter_group_identifier` is removed from a DB instance, the DB instance will be destroyed and re-created.
     * 
     */
    public Boolean enabled() {
        return this.enabled;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DbInstanceLogDeliveryConfigurationS3Configuration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String bucketName;
        private Boolean enabled;
        public Builder() {}
        public Builder(DbInstanceLogDeliveryConfigurationS3Configuration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.bucketName = defaults.bucketName;
    	      this.enabled = defaults.enabled;
        }

        @CustomType.Setter
        public Builder bucketName(String bucketName) {
            if (bucketName == null) {
              throw new MissingRequiredPropertyException("DbInstanceLogDeliveryConfigurationS3Configuration", "bucketName");
            }
            this.bucketName = bucketName;
            return this;
        }
        @CustomType.Setter
        public Builder enabled(Boolean enabled) {
            if (enabled == null) {
              throw new MissingRequiredPropertyException("DbInstanceLogDeliveryConfigurationS3Configuration", "enabled");
            }
            this.enabled = enabled;
            return this;
        }
        public DbInstanceLogDeliveryConfigurationS3Configuration build() {
            final var _resultValue = new DbInstanceLogDeliveryConfigurationS3Configuration();
            _resultValue.bucketName = bucketName;
            _resultValue.enabled = enabled;
            return _resultValue;
        }
    }
}
