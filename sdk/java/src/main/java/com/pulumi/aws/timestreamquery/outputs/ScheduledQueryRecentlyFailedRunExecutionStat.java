// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.timestreamquery.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Integer;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ScheduledQueryRecentlyFailedRunExecutionStat {
    /**
     * @return Bytes metered for a single scheduled query run.
     * 
     */
    private @Nullable Integer bytesMetered;
    /**
     * @return Bytes scanned for a single scheduled query run.
     * 
     */
    private @Nullable Integer cumulativeBytesScanned;
    /**
     * @return Data writes metered for records ingested in a single scheduled query run.
     * 
     */
    private @Nullable Integer dataWrites;
    /**
     * @return Total time, measured in milliseconds, that was needed for the scheduled query run to complete.
     * 
     */
    private @Nullable Integer executionTimeInMillis;
    /**
     * @return Number of rows present in the output from running a query before ingestion to destination data source.
     * 
     */
    private @Nullable Integer queryResultRows;
    /**
     * @return Number of records ingested for a single scheduled query run.
     * 
     */
    private @Nullable Integer recordsIngested;

    private ScheduledQueryRecentlyFailedRunExecutionStat() {}
    /**
     * @return Bytes metered for a single scheduled query run.
     * 
     */
    public Optional<Integer> bytesMetered() {
        return Optional.ofNullable(this.bytesMetered);
    }
    /**
     * @return Bytes scanned for a single scheduled query run.
     * 
     */
    public Optional<Integer> cumulativeBytesScanned() {
        return Optional.ofNullable(this.cumulativeBytesScanned);
    }
    /**
     * @return Data writes metered for records ingested in a single scheduled query run.
     * 
     */
    public Optional<Integer> dataWrites() {
        return Optional.ofNullable(this.dataWrites);
    }
    /**
     * @return Total time, measured in milliseconds, that was needed for the scheduled query run to complete.
     * 
     */
    public Optional<Integer> executionTimeInMillis() {
        return Optional.ofNullable(this.executionTimeInMillis);
    }
    /**
     * @return Number of rows present in the output from running a query before ingestion to destination data source.
     * 
     */
    public Optional<Integer> queryResultRows() {
        return Optional.ofNullable(this.queryResultRows);
    }
    /**
     * @return Number of records ingested for a single scheduled query run.
     * 
     */
    public Optional<Integer> recordsIngested() {
        return Optional.ofNullable(this.recordsIngested);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ScheduledQueryRecentlyFailedRunExecutionStat defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Integer bytesMetered;
        private @Nullable Integer cumulativeBytesScanned;
        private @Nullable Integer dataWrites;
        private @Nullable Integer executionTimeInMillis;
        private @Nullable Integer queryResultRows;
        private @Nullable Integer recordsIngested;
        public Builder() {}
        public Builder(ScheduledQueryRecentlyFailedRunExecutionStat defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.bytesMetered = defaults.bytesMetered;
    	      this.cumulativeBytesScanned = defaults.cumulativeBytesScanned;
    	      this.dataWrites = defaults.dataWrites;
    	      this.executionTimeInMillis = defaults.executionTimeInMillis;
    	      this.queryResultRows = defaults.queryResultRows;
    	      this.recordsIngested = defaults.recordsIngested;
        }

        @CustomType.Setter
        public Builder bytesMetered(@Nullable Integer bytesMetered) {

            this.bytesMetered = bytesMetered;
            return this;
        }
        @CustomType.Setter
        public Builder cumulativeBytesScanned(@Nullable Integer cumulativeBytesScanned) {

            this.cumulativeBytesScanned = cumulativeBytesScanned;
            return this;
        }
        @CustomType.Setter
        public Builder dataWrites(@Nullable Integer dataWrites) {

            this.dataWrites = dataWrites;
            return this;
        }
        @CustomType.Setter
        public Builder executionTimeInMillis(@Nullable Integer executionTimeInMillis) {

            this.executionTimeInMillis = executionTimeInMillis;
            return this;
        }
        @CustomType.Setter
        public Builder queryResultRows(@Nullable Integer queryResultRows) {

            this.queryResultRows = queryResultRows;
            return this;
        }
        @CustomType.Setter
        public Builder recordsIngested(@Nullable Integer recordsIngested) {

            this.recordsIngested = recordsIngested;
            return this;
        }
        public ScheduledQueryRecentlyFailedRunExecutionStat build() {
            final var _resultValue = new ScheduledQueryRecentlyFailedRunExecutionStat();
            _resultValue.bytesMetered = bytesMetered;
            _resultValue.cumulativeBytesScanned = cumulativeBytesScanned;
            _resultValue.dataWrites = dataWrites;
            _resultValue.executionTimeInMillis = executionTimeInMillis;
            _resultValue.queryResultRows = queryResultRows;
            _resultValue.recordsIngested = recordsIngested;
            return _resultValue;
        }
    }
}
