// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.imagebuilder.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetImageRecipesFilter {
    /**
     * @return Name of the filter field. Valid values can be found in the [Image Builder ListImageRecipes API Reference](https://docs.aws.amazon.com/imagebuilder/latest/APIReference/API_ListImageRecipes.html).
     * 
     */
    private String name;
    /**
     * @return Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
     * 
     */
    private List<String> values;

    private GetImageRecipesFilter() {}
    /**
     * @return Name of the filter field. Valid values can be found in the [Image Builder ListImageRecipes API Reference](https://docs.aws.amazon.com/imagebuilder/latest/APIReference/API_ListImageRecipes.html).
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
     * 
     */
    public List<String> values() {
        return this.values;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetImageRecipesFilter defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String name;
        private List<String> values;
        public Builder() {}
        public Builder(GetImageRecipesFilter defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.name = defaults.name;
    	      this.values = defaults.values;
        }

        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetImageRecipesFilter", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder values(List<String> values) {
            if (values == null) {
              throw new MissingRequiredPropertyException("GetImageRecipesFilter", "values");
            }
            this.values = values;
            return this;
        }
        public Builder values(String... values) {
            return values(List.of(values));
        }
        public GetImageRecipesFilter build() {
            final var _resultValue = new GetImageRecipesFilter();
            _resultValue.name = name;
            _resultValue.values = values;
            return _resultValue;
        }
    }
}
