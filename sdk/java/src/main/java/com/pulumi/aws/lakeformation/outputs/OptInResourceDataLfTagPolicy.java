// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lakeformation.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class OptInResourceDataLfTagPolicy {
    /**
     * @return Identifier for the Data Catalog. By default, it is the account ID of the caller.
     * 
     */
    private @Nullable String catalogId;
    /**
     * @return If provided, permissions are granted to the Data Catalog resources whose assigned LF-Tags match the expression body of the saved expression under the provided ExpressionName .
     * 
     */
    private @Nullable String expressionName;
    /**
     * @return List of LF-tag conditions or a saved expression that apply to the resource&#39;s LF-Tag policy.
     * 
     */
    private @Nullable List<String> expressions;
    /**
     * @return Resource type for which the LF-tag policy applies.
     * 
     */
    private String resourceType;

    private OptInResourceDataLfTagPolicy() {}
    /**
     * @return Identifier for the Data Catalog. By default, it is the account ID of the caller.
     * 
     */
    public Optional<String> catalogId() {
        return Optional.ofNullable(this.catalogId);
    }
    /**
     * @return If provided, permissions are granted to the Data Catalog resources whose assigned LF-Tags match the expression body of the saved expression under the provided ExpressionName .
     * 
     */
    public Optional<String> expressionName() {
        return Optional.ofNullable(this.expressionName);
    }
    /**
     * @return List of LF-tag conditions or a saved expression that apply to the resource&#39;s LF-Tag policy.
     * 
     */
    public List<String> expressions() {
        return this.expressions == null ? List.of() : this.expressions;
    }
    /**
     * @return Resource type for which the LF-tag policy applies.
     * 
     */
    public String resourceType() {
        return this.resourceType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(OptInResourceDataLfTagPolicy defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String catalogId;
        private @Nullable String expressionName;
        private @Nullable List<String> expressions;
        private String resourceType;
        public Builder() {}
        public Builder(OptInResourceDataLfTagPolicy defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.catalogId = defaults.catalogId;
    	      this.expressionName = defaults.expressionName;
    	      this.expressions = defaults.expressions;
    	      this.resourceType = defaults.resourceType;
        }

        @CustomType.Setter
        public Builder catalogId(@Nullable String catalogId) {

            this.catalogId = catalogId;
            return this;
        }
        @CustomType.Setter
        public Builder expressionName(@Nullable String expressionName) {

            this.expressionName = expressionName;
            return this;
        }
        @CustomType.Setter
        public Builder expressions(@Nullable List<String> expressions) {

            this.expressions = expressions;
            return this;
        }
        public Builder expressions(String... expressions) {
            return expressions(List.of(expressions));
        }
        @CustomType.Setter
        public Builder resourceType(String resourceType) {
            if (resourceType == null) {
              throw new MissingRequiredPropertyException("OptInResourceDataLfTagPolicy", "resourceType");
            }
            this.resourceType = resourceType;
            return this;
        }
        public OptInResourceDataLfTagPolicy build() {
            final var _resultValue = new OptInResourceDataLfTagPolicy();
            _resultValue.catalogId = catalogId;
            _resultValue.expressionName = expressionName;
            _resultValue.expressions = expressions;
            _resultValue.resourceType = resourceType;
            return _resultValue;
        }
    }
}
