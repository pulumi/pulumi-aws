// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cleanrooms.inputs;

import com.pulumi.aws.cleanrooms.inputs.MembershipDefaultResultConfigurationArgs;
import com.pulumi.aws.cleanrooms.inputs.MembershipPaymentConfigurationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class MembershipState extends com.pulumi.resources.ResourceArgs {

    public static final MembershipState Empty = new MembershipState();

    /**
     * The ARN of the membership.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return The ARN of the membership.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * The ARN of the joined collaboration.
     * 
     */
    @Import(name="collaborationArn")
    private @Nullable Output<String> collaborationArn;

    /**
     * @return The ARN of the joined collaboration.
     * 
     */
    public Optional<Output<String>> collaborationArn() {
        return Optional.ofNullable(this.collaborationArn);
    }

    /**
     * The account ID of the collaboration&#39;s creator.
     * 
     */
    @Import(name="collaborationCreatorAccountId")
    private @Nullable Output<String> collaborationCreatorAccountId;

    /**
     * @return The account ID of the collaboration&#39;s creator.
     * 
     */
    public Optional<Output<String>> collaborationCreatorAccountId() {
        return Optional.ofNullable(this.collaborationCreatorAccountId);
    }

    /**
     * The display name of the collaboration&#39;s creator.
     * 
     */
    @Import(name="collaborationCreatorDisplayName")
    private @Nullable Output<String> collaborationCreatorDisplayName;

    /**
     * @return The display name of the collaboration&#39;s creator.
     * 
     */
    public Optional<Output<String>> collaborationCreatorDisplayName() {
        return Optional.ofNullable(this.collaborationCreatorDisplayName);
    }

    /**
     * The ID of the collaboration to which the member was invited.
     * 
     */
    @Import(name="collaborationId")
    private @Nullable Output<String> collaborationId;

    /**
     * @return The ID of the collaboration to which the member was invited.
     * 
     */
    public Optional<Output<String>> collaborationId() {
        return Optional.ofNullable(this.collaborationId);
    }

    /**
     * The name of the joined collaboration.
     * 
     */
    @Import(name="collaborationName")
    private @Nullable Output<String> collaborationName;

    /**
     * @return The name of the joined collaboration.
     * 
     */
    public Optional<Output<String>> collaborationName() {
        return Optional.ofNullable(this.collaborationName);
    }

    /**
     * The date and time the membership was created.
     * 
     */
    @Import(name="createTime")
    private @Nullable Output<String> createTime;

    /**
     * @return The date and time the membership was created.
     * 
     */
    public Optional<Output<String>> createTime() {
        return Optional.ofNullable(this.createTime);
    }

    /**
     * The default configuration for a query result.
     * 
     */
    @Import(name="defaultResultConfiguration")
    private @Nullable Output<MembershipDefaultResultConfigurationArgs> defaultResultConfiguration;

    /**
     * @return The default configuration for a query result.
     * 
     */
    public Optional<Output<MembershipDefaultResultConfigurationArgs>> defaultResultConfiguration() {
        return Optional.ofNullable(this.defaultResultConfiguration);
    }

    /**
     * The list of abilities for the invited member.
     * 
     */
    @Import(name="memberAbilities")
    private @Nullable Output<List<String>> memberAbilities;

    /**
     * @return The list of abilities for the invited member.
     * 
     */
    public Optional<Output<List<String>>> memberAbilities() {
        return Optional.ofNullable(this.memberAbilities);
    }

    @Import(name="paymentConfiguration")
    private @Nullable Output<MembershipPaymentConfigurationArgs> paymentConfiguration;

    public Optional<Output<MembershipPaymentConfigurationArgs>> paymentConfiguration() {
        return Optional.ofNullable(this.paymentConfiguration);
    }

    /**
     * An indicator as to whether query logging has been enabled or disabled for the membership.
     * 
     */
    @Import(name="queryLogStatus")
    private @Nullable Output<String> queryLogStatus;

    /**
     * @return An indicator as to whether query logging has been enabled or disabled for the membership.
     * 
     */
    public Optional<Output<String>> queryLogStatus() {
        return Optional.ofNullable(this.queryLogStatus);
    }

    /**
     * The status of the membership.
     * 
     */
    @Import(name="status")
    private @Nullable Output<String> status;

    /**
     * @return The status of the membership.
     * 
     */
    public Optional<Output<String>> status() {
        return Optional.ofNullable(this.status);
    }

    /**
     * Key value pairs which tag the membership.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Key value pairs which tag the membership.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    /**
     * The date and time the membership was last updated.
     * 
     */
    @Import(name="updateTime")
    private @Nullable Output<String> updateTime;

    /**
     * @return The date and time the membership was last updated.
     * 
     */
    public Optional<Output<String>> updateTime() {
        return Optional.ofNullable(this.updateTime);
    }

    private MembershipState() {}

    private MembershipState(MembershipState $) {
        this.arn = $.arn;
        this.collaborationArn = $.collaborationArn;
        this.collaborationCreatorAccountId = $.collaborationCreatorAccountId;
        this.collaborationCreatorDisplayName = $.collaborationCreatorDisplayName;
        this.collaborationId = $.collaborationId;
        this.collaborationName = $.collaborationName;
        this.createTime = $.createTime;
        this.defaultResultConfiguration = $.defaultResultConfiguration;
        this.memberAbilities = $.memberAbilities;
        this.paymentConfiguration = $.paymentConfiguration;
        this.queryLogStatus = $.queryLogStatus;
        this.status = $.status;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
        this.updateTime = $.updateTime;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(MembershipState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private MembershipState $;

        public Builder() {
            $ = new MembershipState();
        }

        public Builder(MembershipState defaults) {
            $ = new MembershipState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn The ARN of the membership.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn The ARN of the membership.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param collaborationArn The ARN of the joined collaboration.
         * 
         * @return builder
         * 
         */
        public Builder collaborationArn(@Nullable Output<String> collaborationArn) {
            $.collaborationArn = collaborationArn;
            return this;
        }

        /**
         * @param collaborationArn The ARN of the joined collaboration.
         * 
         * @return builder
         * 
         */
        public Builder collaborationArn(String collaborationArn) {
            return collaborationArn(Output.of(collaborationArn));
        }

        /**
         * @param collaborationCreatorAccountId The account ID of the collaboration&#39;s creator.
         * 
         * @return builder
         * 
         */
        public Builder collaborationCreatorAccountId(@Nullable Output<String> collaborationCreatorAccountId) {
            $.collaborationCreatorAccountId = collaborationCreatorAccountId;
            return this;
        }

        /**
         * @param collaborationCreatorAccountId The account ID of the collaboration&#39;s creator.
         * 
         * @return builder
         * 
         */
        public Builder collaborationCreatorAccountId(String collaborationCreatorAccountId) {
            return collaborationCreatorAccountId(Output.of(collaborationCreatorAccountId));
        }

        /**
         * @param collaborationCreatorDisplayName The display name of the collaboration&#39;s creator.
         * 
         * @return builder
         * 
         */
        public Builder collaborationCreatorDisplayName(@Nullable Output<String> collaborationCreatorDisplayName) {
            $.collaborationCreatorDisplayName = collaborationCreatorDisplayName;
            return this;
        }

        /**
         * @param collaborationCreatorDisplayName The display name of the collaboration&#39;s creator.
         * 
         * @return builder
         * 
         */
        public Builder collaborationCreatorDisplayName(String collaborationCreatorDisplayName) {
            return collaborationCreatorDisplayName(Output.of(collaborationCreatorDisplayName));
        }

        /**
         * @param collaborationId The ID of the collaboration to which the member was invited.
         * 
         * @return builder
         * 
         */
        public Builder collaborationId(@Nullable Output<String> collaborationId) {
            $.collaborationId = collaborationId;
            return this;
        }

        /**
         * @param collaborationId The ID of the collaboration to which the member was invited.
         * 
         * @return builder
         * 
         */
        public Builder collaborationId(String collaborationId) {
            return collaborationId(Output.of(collaborationId));
        }

        /**
         * @param collaborationName The name of the joined collaboration.
         * 
         * @return builder
         * 
         */
        public Builder collaborationName(@Nullable Output<String> collaborationName) {
            $.collaborationName = collaborationName;
            return this;
        }

        /**
         * @param collaborationName The name of the joined collaboration.
         * 
         * @return builder
         * 
         */
        public Builder collaborationName(String collaborationName) {
            return collaborationName(Output.of(collaborationName));
        }

        /**
         * @param createTime The date and time the membership was created.
         * 
         * @return builder
         * 
         */
        public Builder createTime(@Nullable Output<String> createTime) {
            $.createTime = createTime;
            return this;
        }

        /**
         * @param createTime The date and time the membership was created.
         * 
         * @return builder
         * 
         */
        public Builder createTime(String createTime) {
            return createTime(Output.of(createTime));
        }

        /**
         * @param defaultResultConfiguration The default configuration for a query result.
         * 
         * @return builder
         * 
         */
        public Builder defaultResultConfiguration(@Nullable Output<MembershipDefaultResultConfigurationArgs> defaultResultConfiguration) {
            $.defaultResultConfiguration = defaultResultConfiguration;
            return this;
        }

        /**
         * @param defaultResultConfiguration The default configuration for a query result.
         * 
         * @return builder
         * 
         */
        public Builder defaultResultConfiguration(MembershipDefaultResultConfigurationArgs defaultResultConfiguration) {
            return defaultResultConfiguration(Output.of(defaultResultConfiguration));
        }

        /**
         * @param memberAbilities The list of abilities for the invited member.
         * 
         * @return builder
         * 
         */
        public Builder memberAbilities(@Nullable Output<List<String>> memberAbilities) {
            $.memberAbilities = memberAbilities;
            return this;
        }

        /**
         * @param memberAbilities The list of abilities for the invited member.
         * 
         * @return builder
         * 
         */
        public Builder memberAbilities(List<String> memberAbilities) {
            return memberAbilities(Output.of(memberAbilities));
        }

        /**
         * @param memberAbilities The list of abilities for the invited member.
         * 
         * @return builder
         * 
         */
        public Builder memberAbilities(String... memberAbilities) {
            return memberAbilities(List.of(memberAbilities));
        }

        public Builder paymentConfiguration(@Nullable Output<MembershipPaymentConfigurationArgs> paymentConfiguration) {
            $.paymentConfiguration = paymentConfiguration;
            return this;
        }

        public Builder paymentConfiguration(MembershipPaymentConfigurationArgs paymentConfiguration) {
            return paymentConfiguration(Output.of(paymentConfiguration));
        }

        /**
         * @param queryLogStatus An indicator as to whether query logging has been enabled or disabled for the membership.
         * 
         * @return builder
         * 
         */
        public Builder queryLogStatus(@Nullable Output<String> queryLogStatus) {
            $.queryLogStatus = queryLogStatus;
            return this;
        }

        /**
         * @param queryLogStatus An indicator as to whether query logging has been enabled or disabled for the membership.
         * 
         * @return builder
         * 
         */
        public Builder queryLogStatus(String queryLogStatus) {
            return queryLogStatus(Output.of(queryLogStatus));
        }

        /**
         * @param status The status of the membership.
         * 
         * @return builder
         * 
         */
        public Builder status(@Nullable Output<String> status) {
            $.status = status;
            return this;
        }

        /**
         * @param status The status of the membership.
         * 
         * @return builder
         * 
         */
        public Builder status(String status) {
            return status(Output.of(status));
        }

        /**
         * @param tags Key value pairs which tag the membership.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key value pairs which tag the membership.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        /**
         * @param updateTime The date and time the membership was last updated.
         * 
         * @return builder
         * 
         */
        public Builder updateTime(@Nullable Output<String> updateTime) {
            $.updateTime = updateTime;
            return this;
        }

        /**
         * @param updateTime The date and time the membership was last updated.
         * 
         * @return builder
         * 
         */
        public Builder updateTime(String updateTime) {
            return updateTime(Output.of(updateTime));
        }

        public MembershipState build() {
            return $;
        }
    }

}
