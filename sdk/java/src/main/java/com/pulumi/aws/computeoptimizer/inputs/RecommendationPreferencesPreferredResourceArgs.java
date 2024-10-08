// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.computeoptimizer.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RecommendationPreferencesPreferredResourceArgs extends com.pulumi.resources.ResourceArgs {

    public static final RecommendationPreferencesPreferredResourceArgs Empty = new RecommendationPreferencesPreferredResourceArgs();

    /**
     * The preferred resource type values to exclude from the recommendation candidates. If this isn’t specified, all supported resources are included by default.
     * 
     */
    @Import(name="excludeLists")
    private @Nullable Output<List<String>> excludeLists;

    /**
     * @return The preferred resource type values to exclude from the recommendation candidates. If this isn’t specified, all supported resources are included by default.
     * 
     */
    public Optional<Output<List<String>>> excludeLists() {
        return Optional.ofNullable(this.excludeLists);
    }

    /**
     * The preferred resource type values to include in the recommendation candidates. You can specify the exact resource type value, such as `&#34;m5.large&#34;`, or use wild card expressions, such as `&#34;m5&#34;`. If this isn’t specified, all supported resources are included by default.
     * 
     */
    @Import(name="includeLists")
    private @Nullable Output<List<String>> includeLists;

    /**
     * @return The preferred resource type values to include in the recommendation candidates. You can specify the exact resource type value, such as `&#34;m5.large&#34;`, or use wild card expressions, such as `&#34;m5&#34;`. If this isn’t specified, all supported resources are included by default.
     * 
     */
    public Optional<Output<List<String>>> includeLists() {
        return Optional.ofNullable(this.includeLists);
    }

    @Import(name="name", required=true)
    private Output<String> name;

    public Output<String> name() {
        return this.name;
    }

    private RecommendationPreferencesPreferredResourceArgs() {}

    private RecommendationPreferencesPreferredResourceArgs(RecommendationPreferencesPreferredResourceArgs $) {
        this.excludeLists = $.excludeLists;
        this.includeLists = $.includeLists;
        this.name = $.name;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RecommendationPreferencesPreferredResourceArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RecommendationPreferencesPreferredResourceArgs $;

        public Builder() {
            $ = new RecommendationPreferencesPreferredResourceArgs();
        }

        public Builder(RecommendationPreferencesPreferredResourceArgs defaults) {
            $ = new RecommendationPreferencesPreferredResourceArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param excludeLists The preferred resource type values to exclude from the recommendation candidates. If this isn’t specified, all supported resources are included by default.
         * 
         * @return builder
         * 
         */
        public Builder excludeLists(@Nullable Output<List<String>> excludeLists) {
            $.excludeLists = excludeLists;
            return this;
        }

        /**
         * @param excludeLists The preferred resource type values to exclude from the recommendation candidates. If this isn’t specified, all supported resources are included by default.
         * 
         * @return builder
         * 
         */
        public Builder excludeLists(List<String> excludeLists) {
            return excludeLists(Output.of(excludeLists));
        }

        /**
         * @param excludeLists The preferred resource type values to exclude from the recommendation candidates. If this isn’t specified, all supported resources are included by default.
         * 
         * @return builder
         * 
         */
        public Builder excludeLists(String... excludeLists) {
            return excludeLists(List.of(excludeLists));
        }

        /**
         * @param includeLists The preferred resource type values to include in the recommendation candidates. You can specify the exact resource type value, such as `&#34;m5.large&#34;`, or use wild card expressions, such as `&#34;m5&#34;`. If this isn’t specified, all supported resources are included by default.
         * 
         * @return builder
         * 
         */
        public Builder includeLists(@Nullable Output<List<String>> includeLists) {
            $.includeLists = includeLists;
            return this;
        }

        /**
         * @param includeLists The preferred resource type values to include in the recommendation candidates. You can specify the exact resource type value, such as `&#34;m5.large&#34;`, or use wild card expressions, such as `&#34;m5&#34;`. If this isn’t specified, all supported resources are included by default.
         * 
         * @return builder
         * 
         */
        public Builder includeLists(List<String> includeLists) {
            return includeLists(Output.of(includeLists));
        }

        /**
         * @param includeLists The preferred resource type values to include in the recommendation candidates. You can specify the exact resource type value, such as `&#34;m5.large&#34;`, or use wild card expressions, such as `&#34;m5&#34;`. If this isn’t specified, all supported resources are included by default.
         * 
         * @return builder
         * 
         */
        public Builder includeLists(String... includeLists) {
            return includeLists(List.of(includeLists));
        }

        public Builder name(Output<String> name) {
            $.name = name;
            return this;
        }

        public Builder name(String name) {
            return name(Output.of(name));
        }

        public RecommendationPreferencesPreferredResourceArgs build() {
            if ($.name == null) {
                throw new MissingRequiredPropertyException("RecommendationPreferencesPreferredResourceArgs", "name");
            }
            return $;
        }
    }

}
