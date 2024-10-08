// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.elasticache.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class UserGroupAssociationState extends com.pulumi.resources.ResourceArgs {

    public static final UserGroupAssociationState Empty = new UserGroupAssociationState();

    /**
     * ID of the user group.
     * 
     */
    @Import(name="userGroupId")
    private @Nullable Output<String> userGroupId;

    /**
     * @return ID of the user group.
     * 
     */
    public Optional<Output<String>> userGroupId() {
        return Optional.ofNullable(this.userGroupId);
    }

    /**
     * ID of the user to associated with the user group.
     * 
     */
    @Import(name="userId")
    private @Nullable Output<String> userId;

    /**
     * @return ID of the user to associated with the user group.
     * 
     */
    public Optional<Output<String>> userId() {
        return Optional.ofNullable(this.userId);
    }

    private UserGroupAssociationState() {}

    private UserGroupAssociationState(UserGroupAssociationState $) {
        this.userGroupId = $.userGroupId;
        this.userId = $.userId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(UserGroupAssociationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private UserGroupAssociationState $;

        public Builder() {
            $ = new UserGroupAssociationState();
        }

        public Builder(UserGroupAssociationState defaults) {
            $ = new UserGroupAssociationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param userGroupId ID of the user group.
         * 
         * @return builder
         * 
         */
        public Builder userGroupId(@Nullable Output<String> userGroupId) {
            $.userGroupId = userGroupId;
            return this;
        }

        /**
         * @param userGroupId ID of the user group.
         * 
         * @return builder
         * 
         */
        public Builder userGroupId(String userGroupId) {
            return userGroupId(Output.of(userGroupId));
        }

        /**
         * @param userId ID of the user to associated with the user group.
         * 
         * @return builder
         * 
         */
        public Builder userId(@Nullable Output<String> userId) {
            $.userId = userId;
            return this;
        }

        /**
         * @param userId ID of the user to associated with the user group.
         * 
         * @return builder
         * 
         */
        public Builder userId(String userId) {
            return userId(Output.of(userId));
        }

        public UserGroupAssociationState build() {
            return $;
        }
    }

}
