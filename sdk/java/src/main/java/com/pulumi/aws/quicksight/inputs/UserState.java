// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.quicksight.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class UserState extends com.pulumi.resources.ResourceArgs {

    public static final UserState Empty = new UserState();

    /**
     * Amazon Resource Name (ARN) for the user.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN) for the user.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * ID for the AWS account that the user is in. Use the ID for the AWS account that contains your Amazon QuickSight account.
     * 
     */
    @Import(name="awsAccountId")
    private @Nullable Output<String> awsAccountId;

    /**
     * @return ID for the AWS account that the user is in. Use the ID for the AWS account that contains your Amazon QuickSight account.
     * 
     */
    public Optional<Output<String>> awsAccountId() {
        return Optional.ofNullable(this.awsAccountId);
    }

    /**
     * Email address of the user that you want to register.
     * 
     */
    @Import(name="email")
    private @Nullable Output<String> email;

    /**
     * @return Email address of the user that you want to register.
     * 
     */
    public Optional<Output<String>> email() {
        return Optional.ofNullable(this.email);
    }

    /**
     * ARN of the IAM user or role that you are registering with Amazon QuickSight. Required only for users with an identity type of `IAM`.
     * 
     */
    @Import(name="iamArn")
    private @Nullable Output<String> iamArn;

    /**
     * @return ARN of the IAM user or role that you are registering with Amazon QuickSight. Required only for users with an identity type of `IAM`.
     * 
     */
    public Optional<Output<String>> iamArn() {
        return Optional.ofNullable(this.iamArn);
    }

    /**
     * Identity type that your Amazon QuickSight account uses to manage the identity of users. Valid values: `IAM`, `QUICKSIGHT`.
     * 
     */
    @Import(name="identityType")
    private @Nullable Output<String> identityType;

    /**
     * @return Identity type that your Amazon QuickSight account uses to manage the identity of users. Valid values: `IAM`, `QUICKSIGHT`.
     * 
     */
    public Optional<Output<String>> identityType() {
        return Optional.ofNullable(this.identityType);
    }

    /**
     * The Amazon Quicksight namespace to create the user in. Defaults to `default`.
     * 
     */
    @Import(name="namespace")
    private @Nullable Output<String> namespace;

    /**
     * @return The Amazon Quicksight namespace to create the user in. Defaults to `default`.
     * 
     */
    public Optional<Output<String>> namespace() {
        return Optional.ofNullable(this.namespace);
    }

    /**
     * Name of the IAM session to use when assuming roles that can embed QuickSight dashboards. Only valid for registering users using an assumed IAM role. Additionally, if registering multiple users using the same IAM role, each user needs to have a unique session name.
     * 
     */
    @Import(name="sessionName")
    private @Nullable Output<String> sessionName;

    /**
     * @return Name of the IAM session to use when assuming roles that can embed QuickSight dashboards. Only valid for registering users using an assumed IAM role. Additionally, if registering multiple users using the same IAM role, each user needs to have a unique session name.
     * 
     */
    public Optional<Output<String>> sessionName() {
        return Optional.ofNullable(this.sessionName);
    }

    /**
     * URL the user visits to complete registration and provide a password. Returned only for users with an identity type of `QUICKSIGHT`.
     * 
     */
    @Import(name="userInvitationUrl")
    private @Nullable Output<String> userInvitationUrl;

    /**
     * @return URL the user visits to complete registration and provide a password. Returned only for users with an identity type of `QUICKSIGHT`.
     * 
     */
    public Optional<Output<String>> userInvitationUrl() {
        return Optional.ofNullable(this.userInvitationUrl);
    }

    /**
     * Amazon QuickSight user name that you want to create for the user you are registering. Required only for users with an identity type of `QUICKSIGHT`.
     * 
     */
    @Import(name="userName")
    private @Nullable Output<String> userName;

    /**
     * @return Amazon QuickSight user name that you want to create for the user you are registering. Required only for users with an identity type of `QUICKSIGHT`.
     * 
     */
    public Optional<Output<String>> userName() {
        return Optional.ofNullable(this.userName);
    }

    /**
     * Amazon QuickSight role for the user. Value values: `READER`, `AUTHOR`, `ADMIN`, `READER_PRO`, `AUTHOR_PRO`, `ADMIN_PRO`.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="userRole")
    private @Nullable Output<String> userRole;

    /**
     * @return Amazon QuickSight role for the user. Value values: `READER`, `AUTHOR`, `ADMIN`, `READER_PRO`, `AUTHOR_PRO`, `ADMIN_PRO`.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<String>> userRole() {
        return Optional.ofNullable(this.userRole);
    }

    private UserState() {}

    private UserState(UserState $) {
        this.arn = $.arn;
        this.awsAccountId = $.awsAccountId;
        this.email = $.email;
        this.iamArn = $.iamArn;
        this.identityType = $.identityType;
        this.namespace = $.namespace;
        this.sessionName = $.sessionName;
        this.userInvitationUrl = $.userInvitationUrl;
        this.userName = $.userName;
        this.userRole = $.userRole;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(UserState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private UserState $;

        public Builder() {
            $ = new UserState();
        }

        public Builder(UserState defaults) {
            $ = new UserState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn Amazon Resource Name (ARN) for the user.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn Amazon Resource Name (ARN) for the user.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param awsAccountId ID for the AWS account that the user is in. Use the ID for the AWS account that contains your Amazon QuickSight account.
         * 
         * @return builder
         * 
         */
        public Builder awsAccountId(@Nullable Output<String> awsAccountId) {
            $.awsAccountId = awsAccountId;
            return this;
        }

        /**
         * @param awsAccountId ID for the AWS account that the user is in. Use the ID for the AWS account that contains your Amazon QuickSight account.
         * 
         * @return builder
         * 
         */
        public Builder awsAccountId(String awsAccountId) {
            return awsAccountId(Output.of(awsAccountId));
        }

        /**
         * @param email Email address of the user that you want to register.
         * 
         * @return builder
         * 
         */
        public Builder email(@Nullable Output<String> email) {
            $.email = email;
            return this;
        }

        /**
         * @param email Email address of the user that you want to register.
         * 
         * @return builder
         * 
         */
        public Builder email(String email) {
            return email(Output.of(email));
        }

        /**
         * @param iamArn ARN of the IAM user or role that you are registering with Amazon QuickSight. Required only for users with an identity type of `IAM`.
         * 
         * @return builder
         * 
         */
        public Builder iamArn(@Nullable Output<String> iamArn) {
            $.iamArn = iamArn;
            return this;
        }

        /**
         * @param iamArn ARN of the IAM user or role that you are registering with Amazon QuickSight. Required only for users with an identity type of `IAM`.
         * 
         * @return builder
         * 
         */
        public Builder iamArn(String iamArn) {
            return iamArn(Output.of(iamArn));
        }

        /**
         * @param identityType Identity type that your Amazon QuickSight account uses to manage the identity of users. Valid values: `IAM`, `QUICKSIGHT`.
         * 
         * @return builder
         * 
         */
        public Builder identityType(@Nullable Output<String> identityType) {
            $.identityType = identityType;
            return this;
        }

        /**
         * @param identityType Identity type that your Amazon QuickSight account uses to manage the identity of users. Valid values: `IAM`, `QUICKSIGHT`.
         * 
         * @return builder
         * 
         */
        public Builder identityType(String identityType) {
            return identityType(Output.of(identityType));
        }

        /**
         * @param namespace The Amazon Quicksight namespace to create the user in. Defaults to `default`.
         * 
         * @return builder
         * 
         */
        public Builder namespace(@Nullable Output<String> namespace) {
            $.namespace = namespace;
            return this;
        }

        /**
         * @param namespace The Amazon Quicksight namespace to create the user in. Defaults to `default`.
         * 
         * @return builder
         * 
         */
        public Builder namespace(String namespace) {
            return namespace(Output.of(namespace));
        }

        /**
         * @param sessionName Name of the IAM session to use when assuming roles that can embed QuickSight dashboards. Only valid for registering users using an assumed IAM role. Additionally, if registering multiple users using the same IAM role, each user needs to have a unique session name.
         * 
         * @return builder
         * 
         */
        public Builder sessionName(@Nullable Output<String> sessionName) {
            $.sessionName = sessionName;
            return this;
        }

        /**
         * @param sessionName Name of the IAM session to use when assuming roles that can embed QuickSight dashboards. Only valid for registering users using an assumed IAM role. Additionally, if registering multiple users using the same IAM role, each user needs to have a unique session name.
         * 
         * @return builder
         * 
         */
        public Builder sessionName(String sessionName) {
            return sessionName(Output.of(sessionName));
        }

        /**
         * @param userInvitationUrl URL the user visits to complete registration and provide a password. Returned only for users with an identity type of `QUICKSIGHT`.
         * 
         * @return builder
         * 
         */
        public Builder userInvitationUrl(@Nullable Output<String> userInvitationUrl) {
            $.userInvitationUrl = userInvitationUrl;
            return this;
        }

        /**
         * @param userInvitationUrl URL the user visits to complete registration and provide a password. Returned only for users with an identity type of `QUICKSIGHT`.
         * 
         * @return builder
         * 
         */
        public Builder userInvitationUrl(String userInvitationUrl) {
            return userInvitationUrl(Output.of(userInvitationUrl));
        }

        /**
         * @param userName Amazon QuickSight user name that you want to create for the user you are registering. Required only for users with an identity type of `QUICKSIGHT`.
         * 
         * @return builder
         * 
         */
        public Builder userName(@Nullable Output<String> userName) {
            $.userName = userName;
            return this;
        }

        /**
         * @param userName Amazon QuickSight user name that you want to create for the user you are registering. Required only for users with an identity type of `QUICKSIGHT`.
         * 
         * @return builder
         * 
         */
        public Builder userName(String userName) {
            return userName(Output.of(userName));
        }

        /**
         * @param userRole Amazon QuickSight role for the user. Value values: `READER`, `AUTHOR`, `ADMIN`, `READER_PRO`, `AUTHOR_PRO`, `ADMIN_PRO`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder userRole(@Nullable Output<String> userRole) {
            $.userRole = userRole;
            return this;
        }

        /**
         * @param userRole Amazon QuickSight role for the user. Value values: `READER`, `AUTHOR`, `ADMIN`, `READER_PRO`, `AUTHOR_PRO`, `ADMIN_PRO`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder userRole(String userRole) {
            return userRole(Output.of(userRole));
        }

        public UserState build() {
            return $;
        }
    }

}
