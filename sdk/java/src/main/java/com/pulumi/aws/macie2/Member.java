// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.macie2;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.macie2.MemberArgs;
import com.pulumi.aws.macie2.inputs.MemberState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a resource to manage an [Amazon Macie Member](https://docs.aws.amazon.com/macie/latest/APIReference/members-id.html).
 * 
 * ## Example Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.macie2.Account;
 * import com.pulumi.aws.macie2.Member;
 * import com.pulumi.aws.macie2.MemberArgs;
 * import com.pulumi.resources.CustomResourceOptions;
 * import java.util.List;
 * import java.util.ArrayList;
 * import java.util.Map;
 * import java.io.File;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * 
 * public class App {
 *     public static void main(String[] args) {
 *         Pulumi.run(App::stack);
 *     }
 * 
 *     public static void stack(Context ctx) {
 *         var example = new Account("example");
 * 
 *         var exampleMember = new Member("exampleMember", MemberArgs.builder()
 *             .accountId("AWS ACCOUNT ID")
 *             .email("EMAIL")
 *             .invite(true)
 *             .invitationMessage("Message of the invitation")
 *             .invitationDisableEmailNotification(true)
 *             .build(), CustomResourceOptions.builder()
 *                 .dependsOn(example)
 *                 .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import `aws_macie2_member` using the account ID of the member account. For example:
 * 
 * ```sh
 * $ pulumi import aws:macie2/member:Member example 123456789012
 * ```
 * 
 */
@ResourceType(type="aws:macie2/member:Member")
public class Member extends com.pulumi.resources.CustomResource {
    /**
     * The AWS account ID for the account.
     * 
     */
    @Export(name="accountId", refs={String.class}, tree="[0]")
    private Output<String> accountId;

    /**
     * @return The AWS account ID for the account.
     * 
     */
    public Output<String> accountId() {
        return this.accountId;
    }
    /**
     * The AWS account ID for the administrator account.
     * 
     */
    @Export(name="administratorAccountId", refs={String.class}, tree="[0]")
    private Output<String> administratorAccountId;

    /**
     * @return The AWS account ID for the administrator account.
     * 
     */
    public Output<String> administratorAccountId() {
        return this.administratorAccountId;
    }
    /**
     * The Amazon Resource Name (ARN) of the account.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) of the account.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The email address for the account.
     * 
     */
    @Export(name="email", refs={String.class}, tree="[0]")
    private Output<String> email;

    /**
     * @return The email address for the account.
     * 
     */
    public Output<String> email() {
        return this.email;
    }
    /**
     * Specifies whether to send an email notification to the root user of each account that the invitation will be sent to. This notification is in addition to an alert that the root user receives in AWS Personal Health Dashboard. To send an email notification to the root user of each account, set this value to `true`.
     * 
     */
    @Export(name="invitationDisableEmailNotification", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> invitationDisableEmailNotification;

    /**
     * @return Specifies whether to send an email notification to the root user of each account that the invitation will be sent to. This notification is in addition to an alert that the root user receives in AWS Personal Health Dashboard. To send an email notification to the root user of each account, set this value to `true`.
     * 
     */
    public Output<Optional<Boolean>> invitationDisableEmailNotification() {
        return Codegen.optional(this.invitationDisableEmailNotification);
    }
    /**
     * A custom message to include in the invitation. Amazon Macie adds this message to the standard content that it sends for an invitation.
     * 
     */
    @Export(name="invitationMessage", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> invitationMessage;

    /**
     * @return A custom message to include in the invitation. Amazon Macie adds this message to the standard content that it sends for an invitation.
     * 
     */
    public Output<Optional<String>> invitationMessage() {
        return Codegen.optional(this.invitationMessage);
    }
    /**
     * Send an invitation to a member
     * 
     */
    @Export(name="invite", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> invite;

    /**
     * @return Send an invitation to a member
     * 
     */
    public Output<Boolean> invite() {
        return this.invite;
    }
    /**
     * The date and time, in UTC and extended RFC 3339 format, when an Amazon Macie membership invitation was last sent to the account. This value is null if a Macie invitation hasn&#39;t been sent to the account.
     * 
     */
    @Export(name="invitedAt", refs={String.class}, tree="[0]")
    private Output<String> invitedAt;

    /**
     * @return The date and time, in UTC and extended RFC 3339 format, when an Amazon Macie membership invitation was last sent to the account. This value is null if a Macie invitation hasn&#39;t been sent to the account.
     * 
     */
    public Output<String> invitedAt() {
        return this.invitedAt;
    }
    @Export(name="masterAccountId", refs={String.class}, tree="[0]")
    private Output<String> masterAccountId;

    public Output<String> masterAccountId() {
        return this.masterAccountId;
    }
    /**
     * The current status of the relationship between the account and the administrator account.
     * 
     */
    @Export(name="relationshipStatus", refs={String.class}, tree="[0]")
    private Output<String> relationshipStatus;

    /**
     * @return The current status of the relationship between the account and the administrator account.
     * 
     */
    public Output<String> relationshipStatus() {
        return this.relationshipStatus;
    }
    /**
     * Specifies the status for the account. To enable Amazon Macie and start all Macie activities for the account, set this value to `ENABLED`. Valid values are `ENABLED` or `PAUSED`.
     * 
     */
    @Export(name="status", refs={String.class}, tree="[0]")
    private Output<String> status;

    /**
     * @return Specifies the status for the account. To enable Amazon Macie and start all Macie activities for the account, set this value to `ENABLED`. Valid values are `ENABLED` or `PAUSED`.
     * 
     */
    public Output<String> status() {
        return this.status;
    }
    /**
     * Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     */
    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }
    /**
     * The date and time, in UTC and extended RFC 3339 format, of the most recent change to the status of the relationship between the account and the administrator account.
     * 
     */
    @Export(name="updatedAt", refs={String.class}, tree="[0]")
    private Output<String> updatedAt;

    /**
     * @return The date and time, in UTC and extended RFC 3339 format, of the most recent change to the status of the relationship between the account and the administrator account.
     * 
     */
    public Output<String> updatedAt() {
        return this.updatedAt;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Member(java.lang.String name) {
        this(name, MemberArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Member(java.lang.String name, MemberArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Member(java.lang.String name, MemberArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:macie2/member:Member", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Member(java.lang.String name, Output<java.lang.String> id, @Nullable MemberState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:macie2/member:Member", name, state, makeResourceOptions(options, id), false);
    }

    private static MemberArgs makeArgs(MemberArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? MemberArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .build();
        return com.pulumi.resources.CustomResourceOptions.merge(defaultOptions, options, id);
    }

    /**
     * Get an existing Host resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state
     * @param options Optional settings to control the behavior of the CustomResource.
     */
    public static Member get(java.lang.String name, Output<java.lang.String> id, @Nullable MemberState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Member(name, id, state, options);
    }
}
