// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.backup.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class RestoreTestingPlanRecoveryPointSelection {
    /**
     * @return Specifies the algorithm used for selecting recovery points. Valid values are &#34;RANDOM_WITHIN_WINDOW&#34; and &#34;LATEST_WITHIN_WINDOW&#34;.
     * 
     */
    private String algorithm;
    /**
     * @return Specifies the backup vaults to exclude from the recovery point selection. Each value must be a valid AWS ARN for a backup vault or &#34;*&#34; to exclude all backup vaults.
     * 
     */
    private @Nullable List<String> excludeVaults;
    /**
     * @return Specifies the backup vaults to include in the recovery point selection. Each value must be a valid AWS ARN for a backup vault or &#34;*&#34; to include all backup vaults.
     * 
     */
    private List<String> includeVaults;
    /**
     * @return Specifies the types of recovery points to include in the selection. Valid values are &#34;CONTINUOUS&#34; and &#34;SNAPSHOT&#34;.
     * 
     */
    private List<String> recoveryPointTypes;
    /**
     * @return Specifies the number of days within which the recovery points should be selected. Must be a value between 1 and 365.
     * 
     */
    private @Nullable Integer selectionWindowDays;

    private RestoreTestingPlanRecoveryPointSelection() {}
    /**
     * @return Specifies the algorithm used for selecting recovery points. Valid values are &#34;RANDOM_WITHIN_WINDOW&#34; and &#34;LATEST_WITHIN_WINDOW&#34;.
     * 
     */
    public String algorithm() {
        return this.algorithm;
    }
    /**
     * @return Specifies the backup vaults to exclude from the recovery point selection. Each value must be a valid AWS ARN for a backup vault or &#34;*&#34; to exclude all backup vaults.
     * 
     */
    public List<String> excludeVaults() {
        return this.excludeVaults == null ? List.of() : this.excludeVaults;
    }
    /**
     * @return Specifies the backup vaults to include in the recovery point selection. Each value must be a valid AWS ARN for a backup vault or &#34;*&#34; to include all backup vaults.
     * 
     */
    public List<String> includeVaults() {
        return this.includeVaults;
    }
    /**
     * @return Specifies the types of recovery points to include in the selection. Valid values are &#34;CONTINUOUS&#34; and &#34;SNAPSHOT&#34;.
     * 
     */
    public List<String> recoveryPointTypes() {
        return this.recoveryPointTypes;
    }
    /**
     * @return Specifies the number of days within which the recovery points should be selected. Must be a value between 1 and 365.
     * 
     */
    public Optional<Integer> selectionWindowDays() {
        return Optional.ofNullable(this.selectionWindowDays);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(RestoreTestingPlanRecoveryPointSelection defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String algorithm;
        private @Nullable List<String> excludeVaults;
        private List<String> includeVaults;
        private List<String> recoveryPointTypes;
        private @Nullable Integer selectionWindowDays;
        public Builder() {}
        public Builder(RestoreTestingPlanRecoveryPointSelection defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.algorithm = defaults.algorithm;
    	      this.excludeVaults = defaults.excludeVaults;
    	      this.includeVaults = defaults.includeVaults;
    	      this.recoveryPointTypes = defaults.recoveryPointTypes;
    	      this.selectionWindowDays = defaults.selectionWindowDays;
        }

        @CustomType.Setter
        public Builder algorithm(String algorithm) {
            if (algorithm == null) {
              throw new MissingRequiredPropertyException("RestoreTestingPlanRecoveryPointSelection", "algorithm");
            }
            this.algorithm = algorithm;
            return this;
        }
        @CustomType.Setter
        public Builder excludeVaults(@Nullable List<String> excludeVaults) {

            this.excludeVaults = excludeVaults;
            return this;
        }
        public Builder excludeVaults(String... excludeVaults) {
            return excludeVaults(List.of(excludeVaults));
        }
        @CustomType.Setter
        public Builder includeVaults(List<String> includeVaults) {
            if (includeVaults == null) {
              throw new MissingRequiredPropertyException("RestoreTestingPlanRecoveryPointSelection", "includeVaults");
            }
            this.includeVaults = includeVaults;
            return this;
        }
        public Builder includeVaults(String... includeVaults) {
            return includeVaults(List.of(includeVaults));
        }
        @CustomType.Setter
        public Builder recoveryPointTypes(List<String> recoveryPointTypes) {
            if (recoveryPointTypes == null) {
              throw new MissingRequiredPropertyException("RestoreTestingPlanRecoveryPointSelection", "recoveryPointTypes");
            }
            this.recoveryPointTypes = recoveryPointTypes;
            return this;
        }
        public Builder recoveryPointTypes(String... recoveryPointTypes) {
            return recoveryPointTypes(List.of(recoveryPointTypes));
        }
        @CustomType.Setter
        public Builder selectionWindowDays(@Nullable Integer selectionWindowDays) {

            this.selectionWindowDays = selectionWindowDays;
            return this;
        }
        public RestoreTestingPlanRecoveryPointSelection build() {
            final var _resultValue = new RestoreTestingPlanRecoveryPointSelection();
            _resultValue.algorithm = algorithm;
            _resultValue.excludeVaults = excludeVaults;
            _resultValue.includeVaults = includeVaults;
            _resultValue.recoveryPointTypes = recoveryPointTypes;
            _resultValue.selectionWindowDays = selectionWindowDays;
            return _resultValue;
        }
    }
}
