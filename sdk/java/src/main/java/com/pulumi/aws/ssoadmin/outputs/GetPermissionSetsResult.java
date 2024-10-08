// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssoadmin.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetPermissionSetsResult {
    /**
     * @return Set of string contain the ARN of all Permission Sets.
     * 
     */
    private List<String> arns;
    private String id;
    private String instanceArn;

    private GetPermissionSetsResult() {}
    /**
     * @return Set of string contain the ARN of all Permission Sets.
     * 
     */
    public List<String> arns() {
        return this.arns;
    }
    public String id() {
        return this.id;
    }
    public String instanceArn() {
        return this.instanceArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetPermissionSetsResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<String> arns;
        private String id;
        private String instanceArn;
        public Builder() {}
        public Builder(GetPermissionSetsResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arns = defaults.arns;
    	      this.id = defaults.id;
    	      this.instanceArn = defaults.instanceArn;
        }

        @CustomType.Setter
        public Builder arns(List<String> arns) {
            if (arns == null) {
              throw new MissingRequiredPropertyException("GetPermissionSetsResult", "arns");
            }
            this.arns = arns;
            return this;
        }
        public Builder arns(String... arns) {
            return arns(List.of(arns));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetPermissionSetsResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder instanceArn(String instanceArn) {
            if (instanceArn == null) {
              throw new MissingRequiredPropertyException("GetPermissionSetsResult", "instanceArn");
            }
            this.instanceArn = instanceArn;
            return this;
        }
        public GetPermissionSetsResult build() {
            final var _resultValue = new GetPermissionSetsResult();
            _resultValue.arns = arns;
            _resultValue.id = id;
            _resultValue.instanceArn = instanceArn;
            return _resultValue;
        }
    }
}
