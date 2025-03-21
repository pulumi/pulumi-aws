// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.costexplorer.inputs;

import com.pulumi.aws.costexplorer.inputs.CostCategoryRuleRuleOrAndArgs;
import com.pulumi.aws.costexplorer.inputs.CostCategoryRuleRuleOrCostCategoryArgs;
import com.pulumi.aws.costexplorer.inputs.CostCategoryRuleRuleOrDimensionArgs;
import com.pulumi.aws.costexplorer.inputs.CostCategoryRuleRuleOrNotArgs;
import com.pulumi.aws.costexplorer.inputs.CostCategoryRuleRuleOrOrArgs;
import com.pulumi.aws.costexplorer.inputs.CostCategoryRuleRuleOrTagsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class CostCategoryRuleRuleOrArgs extends com.pulumi.resources.ResourceArgs {

    public static final CostCategoryRuleRuleOrArgs Empty = new CostCategoryRuleRuleOrArgs();

    /**
     * Return results that match both `Dimension` objects.
     * 
     */
    @Import(name="ands")
    private @Nullable Output<List<CostCategoryRuleRuleOrAndArgs>> ands;

    /**
     * @return Return results that match both `Dimension` objects.
     * 
     */
    public Optional<Output<List<CostCategoryRuleRuleOrAndArgs>>> ands() {
        return Optional.ofNullable(this.ands);
    }

    /**
     * Configuration block for the filter that&#39;s based on `CostCategory` values. See below.
     * 
     */
    @Import(name="costCategory")
    private @Nullable Output<CostCategoryRuleRuleOrCostCategoryArgs> costCategory;

    /**
     * @return Configuration block for the filter that&#39;s based on `CostCategory` values. See below.
     * 
     */
    public Optional<Output<CostCategoryRuleRuleOrCostCategoryArgs>> costCategory() {
        return Optional.ofNullable(this.costCategory);
    }

    /**
     * Configuration block for the specific `Dimension` to use for `Expression`. See below.
     * 
     */
    @Import(name="dimension")
    private @Nullable Output<CostCategoryRuleRuleOrDimensionArgs> dimension;

    /**
     * @return Configuration block for the specific `Dimension` to use for `Expression`. See below.
     * 
     */
    public Optional<Output<CostCategoryRuleRuleOrDimensionArgs>> dimension() {
        return Optional.ofNullable(this.dimension);
    }

    /**
     * Return results that match both `Dimension` object.
     * 
     */
    @Import(name="not")
    private @Nullable Output<CostCategoryRuleRuleOrNotArgs> not;

    /**
     * @return Return results that match both `Dimension` object.
     * 
     */
    public Optional<Output<CostCategoryRuleRuleOrNotArgs>> not() {
        return Optional.ofNullable(this.not);
    }

    /**
     * Return results that match both `Dimension` object.
     * 
     */
    @Import(name="ors")
    private @Nullable Output<List<CostCategoryRuleRuleOrOrArgs>> ors;

    /**
     * @return Return results that match both `Dimension` object.
     * 
     */
    public Optional<Output<List<CostCategoryRuleRuleOrOrArgs>>> ors() {
        return Optional.ofNullable(this.ors);
    }

    /**
     * Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<CostCategoryRuleRuleOrTagsArgs> tags;

    /**
     * @return Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<CostCategoryRuleRuleOrTagsArgs>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private CostCategoryRuleRuleOrArgs() {}

    private CostCategoryRuleRuleOrArgs(CostCategoryRuleRuleOrArgs $) {
        this.ands = $.ands;
        this.costCategory = $.costCategory;
        this.dimension = $.dimension;
        this.not = $.not;
        this.ors = $.ors;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CostCategoryRuleRuleOrArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CostCategoryRuleRuleOrArgs $;

        public Builder() {
            $ = new CostCategoryRuleRuleOrArgs();
        }

        public Builder(CostCategoryRuleRuleOrArgs defaults) {
            $ = new CostCategoryRuleRuleOrArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param ands Return results that match both `Dimension` objects.
         * 
         * @return builder
         * 
         */
        public Builder ands(@Nullable Output<List<CostCategoryRuleRuleOrAndArgs>> ands) {
            $.ands = ands;
            return this;
        }

        /**
         * @param ands Return results that match both `Dimension` objects.
         * 
         * @return builder
         * 
         */
        public Builder ands(List<CostCategoryRuleRuleOrAndArgs> ands) {
            return ands(Output.of(ands));
        }

        /**
         * @param ands Return results that match both `Dimension` objects.
         * 
         * @return builder
         * 
         */
        public Builder ands(CostCategoryRuleRuleOrAndArgs... ands) {
            return ands(List.of(ands));
        }

        /**
         * @param costCategory Configuration block for the filter that&#39;s based on `CostCategory` values. See below.
         * 
         * @return builder
         * 
         */
        public Builder costCategory(@Nullable Output<CostCategoryRuleRuleOrCostCategoryArgs> costCategory) {
            $.costCategory = costCategory;
            return this;
        }

        /**
         * @param costCategory Configuration block for the filter that&#39;s based on `CostCategory` values. See below.
         * 
         * @return builder
         * 
         */
        public Builder costCategory(CostCategoryRuleRuleOrCostCategoryArgs costCategory) {
            return costCategory(Output.of(costCategory));
        }

        /**
         * @param dimension Configuration block for the specific `Dimension` to use for `Expression`. See below.
         * 
         * @return builder
         * 
         */
        public Builder dimension(@Nullable Output<CostCategoryRuleRuleOrDimensionArgs> dimension) {
            $.dimension = dimension;
            return this;
        }

        /**
         * @param dimension Configuration block for the specific `Dimension` to use for `Expression`. See below.
         * 
         * @return builder
         * 
         */
        public Builder dimension(CostCategoryRuleRuleOrDimensionArgs dimension) {
            return dimension(Output.of(dimension));
        }

        /**
         * @param not Return results that match both `Dimension` object.
         * 
         * @return builder
         * 
         */
        public Builder not(@Nullable Output<CostCategoryRuleRuleOrNotArgs> not) {
            $.not = not;
            return this;
        }

        /**
         * @param not Return results that match both `Dimension` object.
         * 
         * @return builder
         * 
         */
        public Builder not(CostCategoryRuleRuleOrNotArgs not) {
            return not(Output.of(not));
        }

        /**
         * @param ors Return results that match both `Dimension` object.
         * 
         * @return builder
         * 
         */
        public Builder ors(@Nullable Output<List<CostCategoryRuleRuleOrOrArgs>> ors) {
            $.ors = ors;
            return this;
        }

        /**
         * @param ors Return results that match both `Dimension` object.
         * 
         * @return builder
         * 
         */
        public Builder ors(List<CostCategoryRuleRuleOrOrArgs> ors) {
            return ors(Output.of(ors));
        }

        /**
         * @param ors Return results that match both `Dimension` object.
         * 
         * @return builder
         * 
         */
        public Builder ors(CostCategoryRuleRuleOrOrArgs... ors) {
            return ors(List.of(ors));
        }

        /**
         * @param tags Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<CostCategoryRuleRuleOrTagsArgs> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(CostCategoryRuleRuleOrTagsArgs tags) {
            return tags(Output.of(tags));
        }

        public CostCategoryRuleRuleOrArgs build() {
            return $;
        }
    }

}
