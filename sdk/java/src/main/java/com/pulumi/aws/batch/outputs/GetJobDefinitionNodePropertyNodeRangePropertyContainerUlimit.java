// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.batch.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetJobDefinitionNodePropertyNodeRangePropertyContainerUlimit {
    /**
     * @return The hard limit for the ulimit type.
     * 
     */
    private Integer hardLimit;
    /**
     * @return The name of the job definition to register. It can be up to 128 letters long. It can contain uppercase and lowercase letters, numbers, hyphens (-), and underscores (_).
     * 
     */
    private String name;
    /**
     * @return The soft limit for the ulimit type.
     * 
     */
    private Integer softLimit;

    private GetJobDefinitionNodePropertyNodeRangePropertyContainerUlimit() {}
    /**
     * @return The hard limit for the ulimit type.
     * 
     */
    public Integer hardLimit() {
        return this.hardLimit;
    }
    /**
     * @return The name of the job definition to register. It can be up to 128 letters long. It can contain uppercase and lowercase letters, numbers, hyphens (-), and underscores (_).
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return The soft limit for the ulimit type.
     * 
     */
    public Integer softLimit() {
        return this.softLimit;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetJobDefinitionNodePropertyNodeRangePropertyContainerUlimit defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer hardLimit;
        private String name;
        private Integer softLimit;
        public Builder() {}
        public Builder(GetJobDefinitionNodePropertyNodeRangePropertyContainerUlimit defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.hardLimit = defaults.hardLimit;
    	      this.name = defaults.name;
    	      this.softLimit = defaults.softLimit;
        }

        @CustomType.Setter
        public Builder hardLimit(Integer hardLimit) {
            if (hardLimit == null) {
              throw new MissingRequiredPropertyException("GetJobDefinitionNodePropertyNodeRangePropertyContainerUlimit", "hardLimit");
            }
            this.hardLimit = hardLimit;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetJobDefinitionNodePropertyNodeRangePropertyContainerUlimit", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder softLimit(Integer softLimit) {
            if (softLimit == null) {
              throw new MissingRequiredPropertyException("GetJobDefinitionNodePropertyNodeRangePropertyContainerUlimit", "softLimit");
            }
            this.softLimit = softLimit;
            return this;
        }
        public GetJobDefinitionNodePropertyNodeRangePropertyContainerUlimit build() {
            final var _resultValue = new GetJobDefinitionNodePropertyNodeRangePropertyContainerUlimit();
            _resultValue.hardLimit = hardLimit;
            _resultValue.name = name;
            _resultValue.softLimit = softLimit;
            return _resultValue;
        }
    }
}
