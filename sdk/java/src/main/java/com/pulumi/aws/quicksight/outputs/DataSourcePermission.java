// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.quicksight.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class DataSourcePermission {
    /**
     * @return Set of IAM actions to grant or revoke permissions on. Max of 16 items.
     * 
     */
    private List<String> actions;
    /**
     * @return The Amazon Resource Name (ARN) of the principal.
     * 
     */
    private String principal;

    private DataSourcePermission() {}
    /**
     * @return Set of IAM actions to grant or revoke permissions on. Max of 16 items.
     * 
     */
    public List<String> actions() {
        return this.actions;
    }
    /**
     * @return The Amazon Resource Name (ARN) of the principal.
     * 
     */
    public String principal() {
        return this.principal;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DataSourcePermission defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<String> actions;
        private String principal;
        public Builder() {}
        public Builder(DataSourcePermission defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.actions = defaults.actions;
    	      this.principal = defaults.principal;
        }

        @CustomType.Setter
        public Builder actions(List<String> actions) {
            if (actions == null) {
              throw new MissingRequiredPropertyException("DataSourcePermission", "actions");
            }
            this.actions = actions;
            return this;
        }
        public Builder actions(String... actions) {
            return actions(List.of(actions));
        }
        @CustomType.Setter
        public Builder principal(String principal) {
            if (principal == null) {
              throw new MissingRequiredPropertyException("DataSourcePermission", "principal");
            }
            this.principal = principal;
            return this;
        }
        public DataSourcePermission build() {
            final var _resultValue = new DataSourcePermission();
            _resultValue.actions = actions;
            _resultValue.principal = principal;
            return _resultValue;
        }
    }
}
