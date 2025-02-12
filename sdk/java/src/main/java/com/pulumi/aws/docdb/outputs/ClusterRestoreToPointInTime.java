// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.docdb.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ClusterRestoreToPointInTime {
    /**
     * @return The date and time to restore from. Value must be a time in Universal Coordinated Time (UTC) format and must be before the latest restorable time for the DB instance. Cannot be specified with `use_latest_restorable_time`.
     * 
     */
    private @Nullable String restoreToTime;
    /**
     * @return The type of restore to be performed. Valid values are `full-copy`, `copy-on-write`.
     * 
     */
    private @Nullable String restoreType;
    /**
     * @return The identifier of the source DB cluster from which to restore. Must match the identifier of an existing DB cluster.
     * 
     */
    private String sourceClusterIdentifier;
    /**
     * @return A boolean value that indicates whether the DB cluster is restored from the latest backup time. Defaults to `false`. Cannot be specified with `restore_to_time`.
     * 
     */
    private @Nullable Boolean useLatestRestorableTime;

    private ClusterRestoreToPointInTime() {}
    /**
     * @return The date and time to restore from. Value must be a time in Universal Coordinated Time (UTC) format and must be before the latest restorable time for the DB instance. Cannot be specified with `use_latest_restorable_time`.
     * 
     */
    public Optional<String> restoreToTime() {
        return Optional.ofNullable(this.restoreToTime);
    }
    /**
     * @return The type of restore to be performed. Valid values are `full-copy`, `copy-on-write`.
     * 
     */
    public Optional<String> restoreType() {
        return Optional.ofNullable(this.restoreType);
    }
    /**
     * @return The identifier of the source DB cluster from which to restore. Must match the identifier of an existing DB cluster.
     * 
     */
    public String sourceClusterIdentifier() {
        return this.sourceClusterIdentifier;
    }
    /**
     * @return A boolean value that indicates whether the DB cluster is restored from the latest backup time. Defaults to `false`. Cannot be specified with `restore_to_time`.
     * 
     */
    public Optional<Boolean> useLatestRestorableTime() {
        return Optional.ofNullable(this.useLatestRestorableTime);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ClusterRestoreToPointInTime defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String restoreToTime;
        private @Nullable String restoreType;
        private String sourceClusterIdentifier;
        private @Nullable Boolean useLatestRestorableTime;
        public Builder() {}
        public Builder(ClusterRestoreToPointInTime defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.restoreToTime = defaults.restoreToTime;
    	      this.restoreType = defaults.restoreType;
    	      this.sourceClusterIdentifier = defaults.sourceClusterIdentifier;
    	      this.useLatestRestorableTime = defaults.useLatestRestorableTime;
        }

        @CustomType.Setter
        public Builder restoreToTime(@Nullable String restoreToTime) {

            this.restoreToTime = restoreToTime;
            return this;
        }
        @CustomType.Setter
        public Builder restoreType(@Nullable String restoreType) {

            this.restoreType = restoreType;
            return this;
        }
        @CustomType.Setter
        public Builder sourceClusterIdentifier(String sourceClusterIdentifier) {
            if (sourceClusterIdentifier == null) {
              throw new MissingRequiredPropertyException("ClusterRestoreToPointInTime", "sourceClusterIdentifier");
            }
            this.sourceClusterIdentifier = sourceClusterIdentifier;
            return this;
        }
        @CustomType.Setter
        public Builder useLatestRestorableTime(@Nullable Boolean useLatestRestorableTime) {

            this.useLatestRestorableTime = useLatestRestorableTime;
            return this;
        }
        public ClusterRestoreToPointInTime build() {
            final var _resultValue = new ClusterRestoreToPointInTime();
            _resultValue.restoreToTime = restoreToTime;
            _resultValue.restoreType = restoreType;
            _resultValue.sourceClusterIdentifier = sourceClusterIdentifier;
            _resultValue.useLatestRestorableTime = useLatestRestorableTime;
            return _resultValue;
        }
    }
}
