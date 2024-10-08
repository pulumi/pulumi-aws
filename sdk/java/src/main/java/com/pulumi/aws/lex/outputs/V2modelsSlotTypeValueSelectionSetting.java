// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.aws.lex.outputs.V2modelsSlotTypeValueSelectionSettingAdvancedRecognitionSetting;
import com.pulumi.aws.lex.outputs.V2modelsSlotTypeValueSelectionSettingRegexFilter;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class V2modelsSlotTypeValueSelectionSetting {
    /**
     * @return Provides settings that enable advanced recognition settings for slot values.
     * You can use this to enable using slot values as a custom vocabulary for recognizing user utterances.
     * See `advanced_recognition_setting` argument reference below.
     * 
     */
    private @Nullable List<V2modelsSlotTypeValueSelectionSettingAdvancedRecognitionSetting> advancedRecognitionSettings;
    /**
     * @return Used to validate the value of the slot.
     * See `regex_filter` argument reference below.
     * 
     */
    private @Nullable List<V2modelsSlotTypeValueSelectionSettingRegexFilter> regexFilters;
    /**
     * @return Determines the slot resolution strategy that Amazon Lex uses to return slot type values.
     * Valid values are `OriginalValue`, `TopResolution`, and `Concatenation`.
     * 
     */
    private String resolutionStrategy;

    private V2modelsSlotTypeValueSelectionSetting() {}
    /**
     * @return Provides settings that enable advanced recognition settings for slot values.
     * You can use this to enable using slot values as a custom vocabulary for recognizing user utterances.
     * See `advanced_recognition_setting` argument reference below.
     * 
     */
    public List<V2modelsSlotTypeValueSelectionSettingAdvancedRecognitionSetting> advancedRecognitionSettings() {
        return this.advancedRecognitionSettings == null ? List.of() : this.advancedRecognitionSettings;
    }
    /**
     * @return Used to validate the value of the slot.
     * See `regex_filter` argument reference below.
     * 
     */
    public List<V2modelsSlotTypeValueSelectionSettingRegexFilter> regexFilters() {
        return this.regexFilters == null ? List.of() : this.regexFilters;
    }
    /**
     * @return Determines the slot resolution strategy that Amazon Lex uses to return slot type values.
     * Valid values are `OriginalValue`, `TopResolution`, and `Concatenation`.
     * 
     */
    public String resolutionStrategy() {
        return this.resolutionStrategy;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsSlotTypeValueSelectionSetting defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<V2modelsSlotTypeValueSelectionSettingAdvancedRecognitionSetting> advancedRecognitionSettings;
        private @Nullable List<V2modelsSlotTypeValueSelectionSettingRegexFilter> regexFilters;
        private String resolutionStrategy;
        public Builder() {}
        public Builder(V2modelsSlotTypeValueSelectionSetting defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.advancedRecognitionSettings = defaults.advancedRecognitionSettings;
    	      this.regexFilters = defaults.regexFilters;
    	      this.resolutionStrategy = defaults.resolutionStrategy;
        }

        @CustomType.Setter
        public Builder advancedRecognitionSettings(@Nullable List<V2modelsSlotTypeValueSelectionSettingAdvancedRecognitionSetting> advancedRecognitionSettings) {

            this.advancedRecognitionSettings = advancedRecognitionSettings;
            return this;
        }
        public Builder advancedRecognitionSettings(V2modelsSlotTypeValueSelectionSettingAdvancedRecognitionSetting... advancedRecognitionSettings) {
            return advancedRecognitionSettings(List.of(advancedRecognitionSettings));
        }
        @CustomType.Setter
        public Builder regexFilters(@Nullable List<V2modelsSlotTypeValueSelectionSettingRegexFilter> regexFilters) {

            this.regexFilters = regexFilters;
            return this;
        }
        public Builder regexFilters(V2modelsSlotTypeValueSelectionSettingRegexFilter... regexFilters) {
            return regexFilters(List.of(regexFilters));
        }
        @CustomType.Setter
        public Builder resolutionStrategy(String resolutionStrategy) {
            if (resolutionStrategy == null) {
              throw new MissingRequiredPropertyException("V2modelsSlotTypeValueSelectionSetting", "resolutionStrategy");
            }
            this.resolutionStrategy = resolutionStrategy;
            return this;
        }
        public V2modelsSlotTypeValueSelectionSetting build() {
            final var _resultValue = new V2modelsSlotTypeValueSelectionSetting();
            _resultValue.advancedRecognitionSettings = advancedRecognitionSettings;
            _resultValue.regexFilters = regexFilters;
            _resultValue.resolutionStrategy = resolutionStrategy;
            return _resultValue;
        }
    }
}
