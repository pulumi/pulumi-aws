// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.quicksight.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class DataSetRowLevelPermissionTagConfigurationTagRule {
    /**
     * @return Column name that a tag key is assigned to.
     * 
     */
    private String columnName;
    /**
     * @return A string that you want to use to filter by all the values in a column in the dataset and don’t want to list the values one by one.
     * 
     */
    private @Nullable String matchAllValue;
    /**
     * @return Unique key for a tag.
     * 
     */
    private String tagKey;
    /**
     * @return A string that you want to use to delimit the values when you pass the values at run time.
     * 
     */
    private @Nullable String tagMultiValueDelimiter;

    private DataSetRowLevelPermissionTagConfigurationTagRule() {}
    /**
     * @return Column name that a tag key is assigned to.
     * 
     */
    public String columnName() {
        return this.columnName;
    }
    /**
     * @return A string that you want to use to filter by all the values in a column in the dataset and don’t want to list the values one by one.
     * 
     */
    public Optional<String> matchAllValue() {
        return Optional.ofNullable(this.matchAllValue);
    }
    /**
     * @return Unique key for a tag.
     * 
     */
    public String tagKey() {
        return this.tagKey;
    }
    /**
     * @return A string that you want to use to delimit the values when you pass the values at run time.
     * 
     */
    public Optional<String> tagMultiValueDelimiter() {
        return Optional.ofNullable(this.tagMultiValueDelimiter);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DataSetRowLevelPermissionTagConfigurationTagRule defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String columnName;
        private @Nullable String matchAllValue;
        private String tagKey;
        private @Nullable String tagMultiValueDelimiter;
        public Builder() {}
        public Builder(DataSetRowLevelPermissionTagConfigurationTagRule defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.columnName = defaults.columnName;
    	      this.matchAllValue = defaults.matchAllValue;
    	      this.tagKey = defaults.tagKey;
    	      this.tagMultiValueDelimiter = defaults.tagMultiValueDelimiter;
        }

        @CustomType.Setter
        public Builder columnName(String columnName) {
            if (columnName == null) {
              throw new MissingRequiredPropertyException("DataSetRowLevelPermissionTagConfigurationTagRule", "columnName");
            }
            this.columnName = columnName;
            return this;
        }
        @CustomType.Setter
        public Builder matchAllValue(@Nullable String matchAllValue) {

            this.matchAllValue = matchAllValue;
            return this;
        }
        @CustomType.Setter
        public Builder tagKey(String tagKey) {
            if (tagKey == null) {
              throw new MissingRequiredPropertyException("DataSetRowLevelPermissionTagConfigurationTagRule", "tagKey");
            }
            this.tagKey = tagKey;
            return this;
        }
        @CustomType.Setter
        public Builder tagMultiValueDelimiter(@Nullable String tagMultiValueDelimiter) {

            this.tagMultiValueDelimiter = tagMultiValueDelimiter;
            return this;
        }
        public DataSetRowLevelPermissionTagConfigurationTagRule build() {
            final var _resultValue = new DataSetRowLevelPermissionTagConfigurationTagRule();
            _resultValue.columnName = columnName;
            _resultValue.matchAllValue = matchAllValue;
            _resultValue.tagKey = tagKey;
            _resultValue.tagMultiValueDelimiter = tagMultiValueDelimiter;
            return _resultValue;
        }
    }
}
