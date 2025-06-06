// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.opensearch.outputs;

import com.pulumi.aws.opensearch.outputs.DomainAutoTuneOptionsMaintenanceSchedule;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class DomainAutoTuneOptions {
    /**
     * @return Auto-Tune desired state for the domain. Valid values: `ENABLED` or `DISABLED`.
     * 
     */
    private String desiredState;
    /**
     * @return Configuration block for Auto-Tune maintenance windows. Can be specified multiple times for each maintenance window. Detailed below.
     * 
     * **NOTE:** Maintenance windows are deprecated and have been replaced with [off-peak windows](https://docs.aws.amazon.com/opensearch-service/latest/developerguide/off-peak.html). Consequently, `maintenance_schedule` configuration blocks cannot be specified when `use_off_peak_window` is set to `true`.
     * 
     */
    private @Nullable List<DomainAutoTuneOptionsMaintenanceSchedule> maintenanceSchedules;
    /**
     * @return Whether to roll back to default Auto-Tune settings when disabling Auto-Tune. Valid values: `DEFAULT_ROLLBACK` or `NO_ROLLBACK`.
     * 
     */
    private @Nullable String rollbackOnDisable;
    /**
     * @return Whether to schedule Auto-Tune optimizations that require blue/green deployments during the domain&#39;s configured daily off-peak window. Defaults to `false`.
     * 
     */
    private @Nullable Boolean useOffPeakWindow;

    private DomainAutoTuneOptions() {}
    /**
     * @return Auto-Tune desired state for the domain. Valid values: `ENABLED` or `DISABLED`.
     * 
     */
    public String desiredState() {
        return this.desiredState;
    }
    /**
     * @return Configuration block for Auto-Tune maintenance windows. Can be specified multiple times for each maintenance window. Detailed below.
     * 
     * **NOTE:** Maintenance windows are deprecated and have been replaced with [off-peak windows](https://docs.aws.amazon.com/opensearch-service/latest/developerguide/off-peak.html). Consequently, `maintenance_schedule` configuration blocks cannot be specified when `use_off_peak_window` is set to `true`.
     * 
     */
    public List<DomainAutoTuneOptionsMaintenanceSchedule> maintenanceSchedules() {
        return this.maintenanceSchedules == null ? List.of() : this.maintenanceSchedules;
    }
    /**
     * @return Whether to roll back to default Auto-Tune settings when disabling Auto-Tune. Valid values: `DEFAULT_ROLLBACK` or `NO_ROLLBACK`.
     * 
     */
    public Optional<String> rollbackOnDisable() {
        return Optional.ofNullable(this.rollbackOnDisable);
    }
    /**
     * @return Whether to schedule Auto-Tune optimizations that require blue/green deployments during the domain&#39;s configured daily off-peak window. Defaults to `false`.
     * 
     */
    public Optional<Boolean> useOffPeakWindow() {
        return Optional.ofNullable(this.useOffPeakWindow);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DomainAutoTuneOptions defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String desiredState;
        private @Nullable List<DomainAutoTuneOptionsMaintenanceSchedule> maintenanceSchedules;
        private @Nullable String rollbackOnDisable;
        private @Nullable Boolean useOffPeakWindow;
        public Builder() {}
        public Builder(DomainAutoTuneOptions defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.desiredState = defaults.desiredState;
    	      this.maintenanceSchedules = defaults.maintenanceSchedules;
    	      this.rollbackOnDisable = defaults.rollbackOnDisable;
    	      this.useOffPeakWindow = defaults.useOffPeakWindow;
        }

        @CustomType.Setter
        public Builder desiredState(String desiredState) {
            if (desiredState == null) {
              throw new MissingRequiredPropertyException("DomainAutoTuneOptions", "desiredState");
            }
            this.desiredState = desiredState;
            return this;
        }
        @CustomType.Setter
        public Builder maintenanceSchedules(@Nullable List<DomainAutoTuneOptionsMaintenanceSchedule> maintenanceSchedules) {

            this.maintenanceSchedules = maintenanceSchedules;
            return this;
        }
        public Builder maintenanceSchedules(DomainAutoTuneOptionsMaintenanceSchedule... maintenanceSchedules) {
            return maintenanceSchedules(List.of(maintenanceSchedules));
        }
        @CustomType.Setter
        public Builder rollbackOnDisable(@Nullable String rollbackOnDisable) {

            this.rollbackOnDisable = rollbackOnDisable;
            return this;
        }
        @CustomType.Setter
        public Builder useOffPeakWindow(@Nullable Boolean useOffPeakWindow) {

            this.useOffPeakWindow = useOffPeakWindow;
            return this;
        }
        public DomainAutoTuneOptions build() {
            final var _resultValue = new DomainAutoTuneOptions();
            _resultValue.desiredState = desiredState;
            _resultValue.maintenanceSchedules = maintenanceSchedules;
            _resultValue.rollbackOnDisable = rollbackOnDisable;
            _resultValue.useOffPeakWindow = useOffPeakWindow;
            return _resultValue;
        }
    }
}
