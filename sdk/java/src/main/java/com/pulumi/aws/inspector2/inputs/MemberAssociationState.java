// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.inspector2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class MemberAssociationState extends com.pulumi.resources.ResourceArgs {

    public static final MemberAssociationState Empty = new MemberAssociationState();

    /**
     * ID of the account to associate
     * 
     */
    @Import(name="accountId")
    private @Nullable Output<String> accountId;

    /**
     * @return ID of the account to associate
     * 
     */
    public Optional<Output<String>> accountId() {
        return Optional.ofNullable(this.accountId);
    }

    /**
     * Account ID of the delegated administrator account
     * 
     */
    @Import(name="delegatedAdminAccountId")
    private @Nullable Output<String> delegatedAdminAccountId;

    /**
     * @return Account ID of the delegated administrator account
     * 
     */
    public Optional<Output<String>> delegatedAdminAccountId() {
        return Optional.ofNullable(this.delegatedAdminAccountId);
    }

    /**
     * Status of the member relationship
     * 
     */
    @Import(name="relationshipStatus")
    private @Nullable Output<String> relationshipStatus;

    /**
     * @return Status of the member relationship
     * 
     */
    public Optional<Output<String>> relationshipStatus() {
        return Optional.ofNullable(this.relationshipStatus);
    }

    /**
     * Date and time of the last update of the relationship
     * 
     */
    @Import(name="updatedAt")
    private @Nullable Output<String> updatedAt;

    /**
     * @return Date and time of the last update of the relationship
     * 
     */
    public Optional<Output<String>> updatedAt() {
        return Optional.ofNullable(this.updatedAt);
    }

    private MemberAssociationState() {}

    private MemberAssociationState(MemberAssociationState $) {
        this.accountId = $.accountId;
        this.delegatedAdminAccountId = $.delegatedAdminAccountId;
        this.relationshipStatus = $.relationshipStatus;
        this.updatedAt = $.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(MemberAssociationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private MemberAssociationState $;

        public Builder() {
            $ = new MemberAssociationState();
        }

        public Builder(MemberAssociationState defaults) {
            $ = new MemberAssociationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param accountId ID of the account to associate
         * 
         * @return builder
         * 
         */
        public Builder accountId(@Nullable Output<String> accountId) {
            $.accountId = accountId;
            return this;
        }

        /**
         * @param accountId ID of the account to associate
         * 
         * @return builder
         * 
         */
        public Builder accountId(String accountId) {
            return accountId(Output.of(accountId));
        }

        /**
         * @param delegatedAdminAccountId Account ID of the delegated administrator account
         * 
         * @return builder
         * 
         */
        public Builder delegatedAdminAccountId(@Nullable Output<String> delegatedAdminAccountId) {
            $.delegatedAdminAccountId = delegatedAdminAccountId;
            return this;
        }

        /**
         * @param delegatedAdminAccountId Account ID of the delegated administrator account
         * 
         * @return builder
         * 
         */
        public Builder delegatedAdminAccountId(String delegatedAdminAccountId) {
            return delegatedAdminAccountId(Output.of(delegatedAdminAccountId));
        }

        /**
         * @param relationshipStatus Status of the member relationship
         * 
         * @return builder
         * 
         */
        public Builder relationshipStatus(@Nullable Output<String> relationshipStatus) {
            $.relationshipStatus = relationshipStatus;
            return this;
        }

        /**
         * @param relationshipStatus Status of the member relationship
         * 
         * @return builder
         * 
         */
        public Builder relationshipStatus(String relationshipStatus) {
            return relationshipStatus(Output.of(relationshipStatus));
        }

        /**
         * @param updatedAt Date and time of the last update of the relationship
         * 
         * @return builder
         * 
         */
        public Builder updatedAt(@Nullable Output<String> updatedAt) {
            $.updatedAt = updatedAt;
            return this;
        }

        /**
         * @param updatedAt Date and time of the last update of the relationship
         * 
         * @return builder
         * 
         */
        public Builder updatedAt(String updatedAt) {
            return updatedAt(Output.of(updatedAt));
        }

        public MemberAssociationState build() {
            return $;
        }
    }

}
