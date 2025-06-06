// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.accessanalyzer.inputs;

import com.pulumi.aws.accessanalyzer.inputs.AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AnalyzerConfigurationUnusedAccessAnalysisRuleArgs extends com.pulumi.resources.ResourceArgs {

    public static final AnalyzerConfigurationUnusedAccessAnalysisRuleArgs Empty = new AnalyzerConfigurationUnusedAccessAnalysisRuleArgs();

    /**
     * A block for the analyzer rules containing criteria to exclude from analysis. Documented below
     * 
     */
    @Import(name="exclusions")
    private @Nullable Output<List<AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs>> exclusions;

    /**
     * @return A block for the analyzer rules containing criteria to exclude from analysis. Documented below
     * 
     */
    public Optional<Output<List<AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs>>> exclusions() {
        return Optional.ofNullable(this.exclusions);
    }

    private AnalyzerConfigurationUnusedAccessAnalysisRuleArgs() {}

    private AnalyzerConfigurationUnusedAccessAnalysisRuleArgs(AnalyzerConfigurationUnusedAccessAnalysisRuleArgs $) {
        this.exclusions = $.exclusions;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AnalyzerConfigurationUnusedAccessAnalysisRuleArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AnalyzerConfigurationUnusedAccessAnalysisRuleArgs $;

        public Builder() {
            $ = new AnalyzerConfigurationUnusedAccessAnalysisRuleArgs();
        }

        public Builder(AnalyzerConfigurationUnusedAccessAnalysisRuleArgs defaults) {
            $ = new AnalyzerConfigurationUnusedAccessAnalysisRuleArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param exclusions A block for the analyzer rules containing criteria to exclude from analysis. Documented below
         * 
         * @return builder
         * 
         */
        public Builder exclusions(@Nullable Output<List<AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs>> exclusions) {
            $.exclusions = exclusions;
            return this;
        }

        /**
         * @param exclusions A block for the analyzer rules containing criteria to exclude from analysis. Documented below
         * 
         * @return builder
         * 
         */
        public Builder exclusions(List<AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs> exclusions) {
            return exclusions(Output.of(exclusions));
        }

        /**
         * @param exclusions A block for the analyzer rules containing criteria to exclude from analysis. Documented below
         * 
         * @return builder
         * 
         */
        public Builder exclusions(AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs... exclusions) {
            return exclusions(List.of(exclusions));
        }

        public AnalyzerConfigurationUnusedAccessAnalysisRuleArgs build() {
            return $;
        }
    }

}
