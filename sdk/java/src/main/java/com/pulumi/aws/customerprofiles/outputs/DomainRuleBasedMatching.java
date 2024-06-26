// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.customerprofiles.outputs;

import com.pulumi.aws.customerprofiles.outputs.DomainRuleBasedMatchingAttributeTypesSelector;
import com.pulumi.aws.customerprofiles.outputs.DomainRuleBasedMatchingConflictResolution;
import com.pulumi.aws.customerprofiles.outputs.DomainRuleBasedMatchingExportingConfig;
import com.pulumi.aws.customerprofiles.outputs.DomainRuleBasedMatchingMatchingRule;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class DomainRuleBasedMatching {
    /**
     * @return A block that configures information about the `AttributeTypesSelector` where the rule-based identity resolution uses to match profiles. Documented below.
     * 
     */
    private @Nullable DomainRuleBasedMatchingAttributeTypesSelector attributeTypesSelector;
    /**
     * @return A block that specifies how the auto-merging process should resolve conflicts between different profiles. Documented below.
     * 
     */
    private @Nullable DomainRuleBasedMatchingConflictResolution conflictResolution;
    /**
     * @return The flag that enables the rule-based matching process of duplicate profiles.
     * 
     */
    private Boolean enabled;
    /**
     * @return A block that specifies the configuration for exporting Identity Resolution results. Documented below.
     * 
     */
    private @Nullable DomainRuleBasedMatchingExportingConfig exportingConfig;
    /**
     * @return A block that configures how the rule-based matching process should match profiles. You can have up to 15 `rule` in the `natching_rules`. Documented below.
     * 
     */
    private @Nullable List<DomainRuleBasedMatchingMatchingRule> matchingRules;
    /**
     * @return Indicates the maximum allowed rule level for matching.
     * 
     */
    private @Nullable Integer maxAllowedRuleLevelForMatching;
    /**
     * @return Indicates the maximum allowed rule level for merging.
     * 
     */
    private @Nullable Integer maxAllowedRuleLevelForMerging;
    private @Nullable String status;

    private DomainRuleBasedMatching() {}
    /**
     * @return A block that configures information about the `AttributeTypesSelector` where the rule-based identity resolution uses to match profiles. Documented below.
     * 
     */
    public Optional<DomainRuleBasedMatchingAttributeTypesSelector> attributeTypesSelector() {
        return Optional.ofNullable(this.attributeTypesSelector);
    }
    /**
     * @return A block that specifies how the auto-merging process should resolve conflicts between different profiles. Documented below.
     * 
     */
    public Optional<DomainRuleBasedMatchingConflictResolution> conflictResolution() {
        return Optional.ofNullable(this.conflictResolution);
    }
    /**
     * @return The flag that enables the rule-based matching process of duplicate profiles.
     * 
     */
    public Boolean enabled() {
        return this.enabled;
    }
    /**
     * @return A block that specifies the configuration for exporting Identity Resolution results. Documented below.
     * 
     */
    public Optional<DomainRuleBasedMatchingExportingConfig> exportingConfig() {
        return Optional.ofNullable(this.exportingConfig);
    }
    /**
     * @return A block that configures how the rule-based matching process should match profiles. You can have up to 15 `rule` in the `natching_rules`. Documented below.
     * 
     */
    public List<DomainRuleBasedMatchingMatchingRule> matchingRules() {
        return this.matchingRules == null ? List.of() : this.matchingRules;
    }
    /**
     * @return Indicates the maximum allowed rule level for matching.
     * 
     */
    public Optional<Integer> maxAllowedRuleLevelForMatching() {
        return Optional.ofNullable(this.maxAllowedRuleLevelForMatching);
    }
    /**
     * @return Indicates the maximum allowed rule level for merging.
     * 
     */
    public Optional<Integer> maxAllowedRuleLevelForMerging() {
        return Optional.ofNullable(this.maxAllowedRuleLevelForMerging);
    }
    public Optional<String> status() {
        return Optional.ofNullable(this.status);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DomainRuleBasedMatching defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable DomainRuleBasedMatchingAttributeTypesSelector attributeTypesSelector;
        private @Nullable DomainRuleBasedMatchingConflictResolution conflictResolution;
        private Boolean enabled;
        private @Nullable DomainRuleBasedMatchingExportingConfig exportingConfig;
        private @Nullable List<DomainRuleBasedMatchingMatchingRule> matchingRules;
        private @Nullable Integer maxAllowedRuleLevelForMatching;
        private @Nullable Integer maxAllowedRuleLevelForMerging;
        private @Nullable String status;
        public Builder() {}
        public Builder(DomainRuleBasedMatching defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.attributeTypesSelector = defaults.attributeTypesSelector;
    	      this.conflictResolution = defaults.conflictResolution;
    	      this.enabled = defaults.enabled;
    	      this.exportingConfig = defaults.exportingConfig;
    	      this.matchingRules = defaults.matchingRules;
    	      this.maxAllowedRuleLevelForMatching = defaults.maxAllowedRuleLevelForMatching;
    	      this.maxAllowedRuleLevelForMerging = defaults.maxAllowedRuleLevelForMerging;
    	      this.status = defaults.status;
        }

        @CustomType.Setter
        public Builder attributeTypesSelector(@Nullable DomainRuleBasedMatchingAttributeTypesSelector attributeTypesSelector) {

            this.attributeTypesSelector = attributeTypesSelector;
            return this;
        }
        @CustomType.Setter
        public Builder conflictResolution(@Nullable DomainRuleBasedMatchingConflictResolution conflictResolution) {

            this.conflictResolution = conflictResolution;
            return this;
        }
        @CustomType.Setter
        public Builder enabled(Boolean enabled) {
            if (enabled == null) {
              throw new MissingRequiredPropertyException("DomainRuleBasedMatching", "enabled");
            }
            this.enabled = enabled;
            return this;
        }
        @CustomType.Setter
        public Builder exportingConfig(@Nullable DomainRuleBasedMatchingExportingConfig exportingConfig) {

            this.exportingConfig = exportingConfig;
            return this;
        }
        @CustomType.Setter
        public Builder matchingRules(@Nullable List<DomainRuleBasedMatchingMatchingRule> matchingRules) {

            this.matchingRules = matchingRules;
            return this;
        }
        public Builder matchingRules(DomainRuleBasedMatchingMatchingRule... matchingRules) {
            return matchingRules(List.of(matchingRules));
        }
        @CustomType.Setter
        public Builder maxAllowedRuleLevelForMatching(@Nullable Integer maxAllowedRuleLevelForMatching) {

            this.maxAllowedRuleLevelForMatching = maxAllowedRuleLevelForMatching;
            return this;
        }
        @CustomType.Setter
        public Builder maxAllowedRuleLevelForMerging(@Nullable Integer maxAllowedRuleLevelForMerging) {

            this.maxAllowedRuleLevelForMerging = maxAllowedRuleLevelForMerging;
            return this;
        }
        @CustomType.Setter
        public Builder status(@Nullable String status) {

            this.status = status;
            return this;
        }
        public DomainRuleBasedMatching build() {
            final var _resultValue = new DomainRuleBasedMatching();
            _resultValue.attributeTypesSelector = attributeTypesSelector;
            _resultValue.conflictResolution = conflictResolution;
            _resultValue.enabled = enabled;
            _resultValue.exportingConfig = exportingConfig;
            _resultValue.matchingRules = matchingRules;
            _resultValue.maxAllowedRuleLevelForMatching = maxAllowedRuleLevelForMatching;
            _resultValue.maxAllowedRuleLevelForMerging = maxAllowedRuleLevelForMerging;
            _resultValue.status = status;
            return _resultValue;
        }
    }
}
