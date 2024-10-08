// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.devopsguru.outputs;

import com.pulumi.aws.devopsguru.outputs.GetResourceCollectionCloudformation;
import com.pulumi.aws.devopsguru.outputs.GetResourceCollectionTag;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class GetResourceCollectionResult {
    /**
     * @return A collection of AWS CloudFormation stacks. See `cloudformation` below for additional details.
     * 
     */
    private @Nullable List<GetResourceCollectionCloudformation> cloudformations;
    /**
     * @return Type of AWS resource collection to create (same value as `type`).
     * 
     */
    private String id;
    /**
     * @return AWS tags used to filter the resources in the resource collection. See `tags` below for additional details.
     * 
     */
    private @Nullable List<GetResourceCollectionTag> tags;
    private String type;

    private GetResourceCollectionResult() {}
    /**
     * @return A collection of AWS CloudFormation stacks. See `cloudformation` below for additional details.
     * 
     */
    public List<GetResourceCollectionCloudformation> cloudformations() {
        return this.cloudformations == null ? List.of() : this.cloudformations;
    }
    /**
     * @return Type of AWS resource collection to create (same value as `type`).
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return AWS tags used to filter the resources in the resource collection. See `tags` below for additional details.
     * 
     */
    public List<GetResourceCollectionTag> tags() {
        return this.tags == null ? List.of() : this.tags;
    }
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetResourceCollectionResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<GetResourceCollectionCloudformation> cloudformations;
        private String id;
        private @Nullable List<GetResourceCollectionTag> tags;
        private String type;
        public Builder() {}
        public Builder(GetResourceCollectionResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.cloudformations = defaults.cloudformations;
    	      this.id = defaults.id;
    	      this.tags = defaults.tags;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder cloudformations(@Nullable List<GetResourceCollectionCloudformation> cloudformations) {

            this.cloudformations = cloudformations;
            return this;
        }
        public Builder cloudformations(GetResourceCollectionCloudformation... cloudformations) {
            return cloudformations(List.of(cloudformations));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetResourceCollectionResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder tags(@Nullable List<GetResourceCollectionTag> tags) {

            this.tags = tags;
            return this;
        }
        public Builder tags(GetResourceCollectionTag... tags) {
            return tags(List.of(tags));
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("GetResourceCollectionResult", "type");
            }
            this.type = type;
            return this;
        }
        public GetResourceCollectionResult build() {
            final var _resultValue = new GetResourceCollectionResult();
            _resultValue.cloudformations = cloudformations;
            _resultValue.id = id;
            _resultValue.tags = tags;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
