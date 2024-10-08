// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.servicecatalog.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class BudgetResourceAssociationState extends com.pulumi.resources.ResourceArgs {

    public static final BudgetResourceAssociationState Empty = new BudgetResourceAssociationState();

    /**
     * Budget name.
     * 
     */
    @Import(name="budgetName")
    private @Nullable Output<String> budgetName;

    /**
     * @return Budget name.
     * 
     */
    public Optional<Output<String>> budgetName() {
        return Optional.ofNullable(this.budgetName);
    }

    /**
     * Resource identifier.
     * 
     */
    @Import(name="resourceId")
    private @Nullable Output<String> resourceId;

    /**
     * @return Resource identifier.
     * 
     */
    public Optional<Output<String>> resourceId() {
        return Optional.ofNullable(this.resourceId);
    }

    private BudgetResourceAssociationState() {}

    private BudgetResourceAssociationState(BudgetResourceAssociationState $) {
        this.budgetName = $.budgetName;
        this.resourceId = $.resourceId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(BudgetResourceAssociationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private BudgetResourceAssociationState $;

        public Builder() {
            $ = new BudgetResourceAssociationState();
        }

        public Builder(BudgetResourceAssociationState defaults) {
            $ = new BudgetResourceAssociationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param budgetName Budget name.
         * 
         * @return builder
         * 
         */
        public Builder budgetName(@Nullable Output<String> budgetName) {
            $.budgetName = budgetName;
            return this;
        }

        /**
         * @param budgetName Budget name.
         * 
         * @return builder
         * 
         */
        public Builder budgetName(String budgetName) {
            return budgetName(Output.of(budgetName));
        }

        /**
         * @param resourceId Resource identifier.
         * 
         * @return builder
         * 
         */
        public Builder resourceId(@Nullable Output<String> resourceId) {
            $.resourceId = resourceId;
            return this;
        }

        /**
         * @param resourceId Resource identifier.
         * 
         * @return builder
         * 
         */
        public Builder resourceId(String resourceId) {
            return resourceId(Output.of(resourceId));
        }

        public BudgetResourceAssociationState build() {
            return $;
        }
    }

}
