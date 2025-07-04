// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.workspacesweb.inputs;

import com.pulumi.aws.workspacesweb.inputs.DataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DataProtectionSettingsInlineRedactionConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final DataProtectionSettingsInlineRedactionConfigurationArgs Empty = new DataProtectionSettingsInlineRedactionConfigurationArgs();

    /**
     * The global confidence level for the inline redaction configuration. This indicates the certainty of data type matches in the redaction process. Values range from 1 (low confidence) to 3 (high confidence).
     * 
     */
    @Import(name="globalConfidenceLevel")
    private @Nullable Output<Integer> globalConfidenceLevel;

    /**
     * @return The global confidence level for the inline redaction configuration. This indicates the certainty of data type matches in the redaction process. Values range from 1 (low confidence) to 3 (high confidence).
     * 
     */
    public Optional<Output<Integer>> globalConfidenceLevel() {
        return Optional.ofNullable(this.globalConfidenceLevel);
    }

    /**
     * The global enforced URL configuration for the inline redaction configuration.
     * 
     */
    @Import(name="globalEnforcedUrls")
    private @Nullable Output<List<String>> globalEnforcedUrls;

    /**
     * @return The global enforced URL configuration for the inline redaction configuration.
     * 
     */
    public Optional<Output<List<String>>> globalEnforcedUrls() {
        return Optional.ofNullable(this.globalEnforcedUrls);
    }

    /**
     * The global exempt URL configuration for the inline redaction configuration.
     * 
     */
    @Import(name="globalExemptUrls")
    private @Nullable Output<List<String>> globalExemptUrls;

    /**
     * @return The global exempt URL configuration for the inline redaction configuration.
     * 
     */
    public Optional<Output<List<String>>> globalExemptUrls() {
        return Optional.ofNullable(this.globalExemptUrls);
    }

    /**
     * The inline redaction patterns to be enabled for the inline redaction configuration. Detailed below.
     * 
     */
    @Import(name="inlineRedactionPatterns")
    private @Nullable Output<List<DataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternArgs>> inlineRedactionPatterns;

    /**
     * @return The inline redaction patterns to be enabled for the inline redaction configuration. Detailed below.
     * 
     */
    public Optional<Output<List<DataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternArgs>>> inlineRedactionPatterns() {
        return Optional.ofNullable(this.inlineRedactionPatterns);
    }

    private DataProtectionSettingsInlineRedactionConfigurationArgs() {}

    private DataProtectionSettingsInlineRedactionConfigurationArgs(DataProtectionSettingsInlineRedactionConfigurationArgs $) {
        this.globalConfidenceLevel = $.globalConfidenceLevel;
        this.globalEnforcedUrls = $.globalEnforcedUrls;
        this.globalExemptUrls = $.globalExemptUrls;
        this.inlineRedactionPatterns = $.inlineRedactionPatterns;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DataProtectionSettingsInlineRedactionConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DataProtectionSettingsInlineRedactionConfigurationArgs $;

        public Builder() {
            $ = new DataProtectionSettingsInlineRedactionConfigurationArgs();
        }

        public Builder(DataProtectionSettingsInlineRedactionConfigurationArgs defaults) {
            $ = new DataProtectionSettingsInlineRedactionConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param globalConfidenceLevel The global confidence level for the inline redaction configuration. This indicates the certainty of data type matches in the redaction process. Values range from 1 (low confidence) to 3 (high confidence).
         * 
         * @return builder
         * 
         */
        public Builder globalConfidenceLevel(@Nullable Output<Integer> globalConfidenceLevel) {
            $.globalConfidenceLevel = globalConfidenceLevel;
            return this;
        }

        /**
         * @param globalConfidenceLevel The global confidence level for the inline redaction configuration. This indicates the certainty of data type matches in the redaction process. Values range from 1 (low confidence) to 3 (high confidence).
         * 
         * @return builder
         * 
         */
        public Builder globalConfidenceLevel(Integer globalConfidenceLevel) {
            return globalConfidenceLevel(Output.of(globalConfidenceLevel));
        }

        /**
         * @param globalEnforcedUrls The global enforced URL configuration for the inline redaction configuration.
         * 
         * @return builder
         * 
         */
        public Builder globalEnforcedUrls(@Nullable Output<List<String>> globalEnforcedUrls) {
            $.globalEnforcedUrls = globalEnforcedUrls;
            return this;
        }

        /**
         * @param globalEnforcedUrls The global enforced URL configuration for the inline redaction configuration.
         * 
         * @return builder
         * 
         */
        public Builder globalEnforcedUrls(List<String> globalEnforcedUrls) {
            return globalEnforcedUrls(Output.of(globalEnforcedUrls));
        }

        /**
         * @param globalEnforcedUrls The global enforced URL configuration for the inline redaction configuration.
         * 
         * @return builder
         * 
         */
        public Builder globalEnforcedUrls(String... globalEnforcedUrls) {
            return globalEnforcedUrls(List.of(globalEnforcedUrls));
        }

        /**
         * @param globalExemptUrls The global exempt URL configuration for the inline redaction configuration.
         * 
         * @return builder
         * 
         */
        public Builder globalExemptUrls(@Nullable Output<List<String>> globalExemptUrls) {
            $.globalExemptUrls = globalExemptUrls;
            return this;
        }

        /**
         * @param globalExemptUrls The global exempt URL configuration for the inline redaction configuration.
         * 
         * @return builder
         * 
         */
        public Builder globalExemptUrls(List<String> globalExemptUrls) {
            return globalExemptUrls(Output.of(globalExemptUrls));
        }

        /**
         * @param globalExemptUrls The global exempt URL configuration for the inline redaction configuration.
         * 
         * @return builder
         * 
         */
        public Builder globalExemptUrls(String... globalExemptUrls) {
            return globalExemptUrls(List.of(globalExemptUrls));
        }

        /**
         * @param inlineRedactionPatterns The inline redaction patterns to be enabled for the inline redaction configuration. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder inlineRedactionPatterns(@Nullable Output<List<DataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternArgs>> inlineRedactionPatterns) {
            $.inlineRedactionPatterns = inlineRedactionPatterns;
            return this;
        }

        /**
         * @param inlineRedactionPatterns The inline redaction patterns to be enabled for the inline redaction configuration. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder inlineRedactionPatterns(List<DataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternArgs> inlineRedactionPatterns) {
            return inlineRedactionPatterns(Output.of(inlineRedactionPatterns));
        }

        /**
         * @param inlineRedactionPatterns The inline redaction patterns to be enabled for the inline redaction configuration. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder inlineRedactionPatterns(DataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternArgs... inlineRedactionPatterns) {
            return inlineRedactionPatterns(List.of(inlineRedactionPatterns));
        }

        public DataProtectionSettingsInlineRedactionConfigurationArgs build() {
            return $;
        }
    }

}
