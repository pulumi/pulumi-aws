// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudformation.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class StackSetManagedExecutionArgs extends com.pulumi.resources.ResourceArgs {

    public static final StackSetManagedExecutionArgs Empty = new StackSetManagedExecutionArgs();

    /**
     * When set to true, StackSets performs non-conflicting operations concurrently and queues conflicting operations. After conflicting operations finish, StackSets starts queued operations in request order. Default is false.
     * 
     */
    @Import(name="active")
    private @Nullable Output<Boolean> active;

    /**
     * @return When set to true, StackSets performs non-conflicting operations concurrently and queues conflicting operations. After conflicting operations finish, StackSets starts queued operations in request order. Default is false.
     * 
     */
    public Optional<Output<Boolean>> active() {
        return Optional.ofNullable(this.active);
    }

    private StackSetManagedExecutionArgs() {}

    private StackSetManagedExecutionArgs(StackSetManagedExecutionArgs $) {
        this.active = $.active;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(StackSetManagedExecutionArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private StackSetManagedExecutionArgs $;

        public Builder() {
            $ = new StackSetManagedExecutionArgs();
        }

        public Builder(StackSetManagedExecutionArgs defaults) {
            $ = new StackSetManagedExecutionArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param active When set to true, StackSets performs non-conflicting operations concurrently and queues conflicting operations. After conflicting operations finish, StackSets starts queued operations in request order. Default is false.
         * 
         * @return builder
         * 
         */
        public Builder active(@Nullable Output<Boolean> active) {
            $.active = active;
            return this;
        }

        /**
         * @param active When set to true, StackSets performs non-conflicting operations concurrently and queues conflicting operations. After conflicting operations finish, StackSets starts queued operations in request order. Default is false.
         * 
         * @return builder
         * 
         */
        public Builder active(Boolean active) {
            return active(Output.of(active));
        }

        public StackSetManagedExecutionArgs build() {
            return $;
        }
    }

}
