// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.devopsguru.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class GetResourceCollectionCloudformation extends com.pulumi.resources.InvokeArgs {

    public static final GetResourceCollectionCloudformation Empty = new GetResourceCollectionCloudformation();

    /**
     * Array of the names of the AWS CloudFormation stacks.
     * 
     */
    @Import(name="stackNames", required=true)
    private List<String> stackNames;

    /**
     * @return Array of the names of the AWS CloudFormation stacks.
     * 
     */
    public List<String> stackNames() {
        return this.stackNames;
    }

    private GetResourceCollectionCloudformation() {}

    private GetResourceCollectionCloudformation(GetResourceCollectionCloudformation $) {
        this.stackNames = $.stackNames;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetResourceCollectionCloudformation defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetResourceCollectionCloudformation $;

        public Builder() {
            $ = new GetResourceCollectionCloudformation();
        }

        public Builder(GetResourceCollectionCloudformation defaults) {
            $ = new GetResourceCollectionCloudformation(Objects.requireNonNull(defaults));
        }

        /**
         * @param stackNames Array of the names of the AWS CloudFormation stacks.
         * 
         * @return builder
         * 
         */
        public Builder stackNames(List<String> stackNames) {
            $.stackNames = stackNames;
            return this;
        }

        /**
         * @param stackNames Array of the names of the AWS CloudFormation stacks.
         * 
         * @return builder
         * 
         */
        public Builder stackNames(String... stackNames) {
            return stackNames(List.of(stackNames));
        }

        public GetResourceCollectionCloudformation build() {
            if ($.stackNames == null) {
                throw new MissingRequiredPropertyException("GetResourceCollectionCloudformation", "stackNames");
            }
            return $;
        }
    }

}
