// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.costexplorer.outputs;

import com.pulumi.aws.costexplorer.outputs.GetCostCategoryRuleRuleOrNotCostCategory;
import com.pulumi.aws.costexplorer.outputs.GetCostCategoryRuleRuleOrNotDimension;
import com.pulumi.aws.costexplorer.outputs.GetCostCategoryRuleRuleOrNotTag;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetCostCategoryRuleRuleOrNot {
    /**
     * @return Configuration block for the filter that&#39;s based on `CostCategory` values. See below.
     * 
     */
    private List<GetCostCategoryRuleRuleOrNotCostCategory> costCategories;
    /**
     * @return Configuration block for the specific `Dimension` to use for `Expression`. See below.
     * 
     */
    private List<GetCostCategoryRuleRuleOrNotDimension> dimensions;
    /**
     * @return Configuration block for the specific `Tag` to use for `Expression`. See below.
     * 
     */
    private List<GetCostCategoryRuleRuleOrNotTag> tags;

    private GetCostCategoryRuleRuleOrNot() {}
    /**
     * @return Configuration block for the filter that&#39;s based on `CostCategory` values. See below.
     * 
     */
    public List<GetCostCategoryRuleRuleOrNotCostCategory> costCategories() {
        return this.costCategories;
    }
    /**
     * @return Configuration block for the specific `Dimension` to use for `Expression`. See below.
     * 
     */
    public List<GetCostCategoryRuleRuleOrNotDimension> dimensions() {
        return this.dimensions;
    }
    /**
     * @return Configuration block for the specific `Tag` to use for `Expression`. See below.
     * 
     */
    public List<GetCostCategoryRuleRuleOrNotTag> tags() {
        return this.tags;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetCostCategoryRuleRuleOrNot defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetCostCategoryRuleRuleOrNotCostCategory> costCategories;
        private List<GetCostCategoryRuleRuleOrNotDimension> dimensions;
        private List<GetCostCategoryRuleRuleOrNotTag> tags;
        public Builder() {}
        public Builder(GetCostCategoryRuleRuleOrNot defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.costCategories = defaults.costCategories;
    	      this.dimensions = defaults.dimensions;
    	      this.tags = defaults.tags;
        }

        @CustomType.Setter
        public Builder costCategories(List<GetCostCategoryRuleRuleOrNotCostCategory> costCategories) {
            if (costCategories == null) {
              throw new MissingRequiredPropertyException("GetCostCategoryRuleRuleOrNot", "costCategories");
            }
            this.costCategories = costCategories;
            return this;
        }
        public Builder costCategories(GetCostCategoryRuleRuleOrNotCostCategory... costCategories) {
            return costCategories(List.of(costCategories));
        }
        @CustomType.Setter
        public Builder dimensions(List<GetCostCategoryRuleRuleOrNotDimension> dimensions) {
            if (dimensions == null) {
              throw new MissingRequiredPropertyException("GetCostCategoryRuleRuleOrNot", "dimensions");
            }
            this.dimensions = dimensions;
            return this;
        }
        public Builder dimensions(GetCostCategoryRuleRuleOrNotDimension... dimensions) {
            return dimensions(List.of(dimensions));
        }
        @CustomType.Setter
        public Builder tags(List<GetCostCategoryRuleRuleOrNotTag> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetCostCategoryRuleRuleOrNot", "tags");
            }
            this.tags = tags;
            return this;
        }
        public Builder tags(GetCostCategoryRuleRuleOrNotTag... tags) {
            return tags(List.of(tags));
        }
        public GetCostCategoryRuleRuleOrNot build() {
            final var _resultValue = new GetCostCategoryRuleRuleOrNot();
            _resultValue.costCategories = costCategories;
            _resultValue.dimensions = dimensions;
            _resultValue.tags = tags;
            return _resultValue;
        }
    }
}
