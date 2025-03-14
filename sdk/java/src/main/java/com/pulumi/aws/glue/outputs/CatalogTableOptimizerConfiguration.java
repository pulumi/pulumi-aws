// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.glue.outputs;

import com.pulumi.aws.glue.outputs.CatalogTableOptimizerConfigurationOrphanFileDeletionConfiguration;
import com.pulumi.aws.glue.outputs.CatalogTableOptimizerConfigurationRetentionConfiguration;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class CatalogTableOptimizerConfiguration {
    /**
     * @return Indicates whether the table optimizer is enabled.
     * 
     */
    private Boolean enabled;
    /**
     * @return The configuration block for an orphan file deletion optimizer. See Orphan File Deletion Configuration for additional details.
     * 
     */
    private @Nullable CatalogTableOptimizerConfigurationOrphanFileDeletionConfiguration orphanFileDeletionConfiguration;
    /**
     * @return The configuration block for a snapshot retention optimizer. See Retention Configuration for additional details.
     * 
     */
    private @Nullable CatalogTableOptimizerConfigurationRetentionConfiguration retentionConfiguration;
    /**
     * @return The ARN of the IAM role to use for the table optimizer.
     * 
     */
    private String roleArn;

    private CatalogTableOptimizerConfiguration() {}
    /**
     * @return Indicates whether the table optimizer is enabled.
     * 
     */
    public Boolean enabled() {
        return this.enabled;
    }
    /**
     * @return The configuration block for an orphan file deletion optimizer. See Orphan File Deletion Configuration for additional details.
     * 
     */
    public Optional<CatalogTableOptimizerConfigurationOrphanFileDeletionConfiguration> orphanFileDeletionConfiguration() {
        return Optional.ofNullable(this.orphanFileDeletionConfiguration);
    }
    /**
     * @return The configuration block for a snapshot retention optimizer. See Retention Configuration for additional details.
     * 
     */
    public Optional<CatalogTableOptimizerConfigurationRetentionConfiguration> retentionConfiguration() {
        return Optional.ofNullable(this.retentionConfiguration);
    }
    /**
     * @return The ARN of the IAM role to use for the table optimizer.
     * 
     */
    public String roleArn() {
        return this.roleArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CatalogTableOptimizerConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean enabled;
        private @Nullable CatalogTableOptimizerConfigurationOrphanFileDeletionConfiguration orphanFileDeletionConfiguration;
        private @Nullable CatalogTableOptimizerConfigurationRetentionConfiguration retentionConfiguration;
        private String roleArn;
        public Builder() {}
        public Builder(CatalogTableOptimizerConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enabled = defaults.enabled;
    	      this.orphanFileDeletionConfiguration = defaults.orphanFileDeletionConfiguration;
    	      this.retentionConfiguration = defaults.retentionConfiguration;
    	      this.roleArn = defaults.roleArn;
        }

        @CustomType.Setter
        public Builder enabled(Boolean enabled) {
            if (enabled == null) {
              throw new MissingRequiredPropertyException("CatalogTableOptimizerConfiguration", "enabled");
            }
            this.enabled = enabled;
            return this;
        }
        @CustomType.Setter
        public Builder orphanFileDeletionConfiguration(@Nullable CatalogTableOptimizerConfigurationOrphanFileDeletionConfiguration orphanFileDeletionConfiguration) {

            this.orphanFileDeletionConfiguration = orphanFileDeletionConfiguration;
            return this;
        }
        @CustomType.Setter
        public Builder retentionConfiguration(@Nullable CatalogTableOptimizerConfigurationRetentionConfiguration retentionConfiguration) {

            this.retentionConfiguration = retentionConfiguration;
            return this;
        }
        @CustomType.Setter
        public Builder roleArn(String roleArn) {
            if (roleArn == null) {
              throw new MissingRequiredPropertyException("CatalogTableOptimizerConfiguration", "roleArn");
            }
            this.roleArn = roleArn;
            return this;
        }
        public CatalogTableOptimizerConfiguration build() {
            final var _resultValue = new CatalogTableOptimizerConfiguration();
            _resultValue.enabled = enabled;
            _resultValue.orphanFileDeletionConfiguration = orphanFileDeletionConfiguration;
            _resultValue.retentionConfiguration = retentionConfiguration;
            _resultValue.roleArn = roleArn;
            return _resultValue;
        }
    }
}
