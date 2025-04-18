// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssoadmin;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ssoadmin.ManagedPolicyAttachmentArgs;
import com.pulumi.aws.ssoadmin.inputs.ManagedPolicyAttachmentState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * Provides an IAM managed policy for a Single Sign-On (SSO) Permission Set resource
 * 
 * &gt; **NOTE:** Creating this resource will automatically [Provision the Permission Set](https://docs.aws.amazon.com/singlesignon/latest/APIReference/API_ProvisionPermissionSet.html) to apply the corresponding updates to all assigned accounts.
 * 
 * ## Example Usage
 * 
 * ### Basic Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ssoadmin.SsoadminFunctions;
 * import com.pulumi.aws.ssoadmin.PermissionSet;
 * import com.pulumi.aws.ssoadmin.PermissionSetArgs;
 * import com.pulumi.aws.ssoadmin.ManagedPolicyAttachment;
 * import com.pulumi.aws.ssoadmin.ManagedPolicyAttachmentArgs;
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
 *         final var example = SsoadminFunctions.getInstances(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
 * 
 *         var examplePermissionSet = new PermissionSet("examplePermissionSet", PermissionSetArgs.builder()
 *             .name("Example")
 *             .instanceArn(example.arns()[0])
 *             .build());
 * 
 *         var exampleManagedPolicyAttachment = new ManagedPolicyAttachment("exampleManagedPolicyAttachment", ManagedPolicyAttachmentArgs.builder()
 *             .instanceArn(example.arns()[0])
 *             .managedPolicyArn("arn:aws:iam::aws:policy/AlexaForBusinessDeviceSetup")
 *             .permissionSetArn(examplePermissionSet.arn())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### With Account Assignment
 * 
 * &gt; Because destruction of a managed policy attachment resource also re-provisions the associated permission set to all accounts, explicitly indicating the dependency with the account assignment resource via the `depends_on` meta argument is necessary to ensure proper deletion order when these resources are used together.
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ssoadmin.SsoadminFunctions;
 * import com.pulumi.aws.ssoadmin.PermissionSet;
 * import com.pulumi.aws.ssoadmin.PermissionSetArgs;
 * import com.pulumi.aws.identitystore.Group;
 * import com.pulumi.aws.identitystore.GroupArgs;
 * import com.pulumi.aws.ssoadmin.AccountAssignment;
 * import com.pulumi.aws.ssoadmin.AccountAssignmentArgs;
 * import com.pulumi.aws.ssoadmin.ManagedPolicyAttachment;
 * import com.pulumi.aws.ssoadmin.ManagedPolicyAttachmentArgs;
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
 *         final var example = SsoadminFunctions.getInstances(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
 * 
 *         var examplePermissionSet = new PermissionSet("examplePermissionSet", PermissionSetArgs.builder()
 *             .name("Example")
 *             .instanceArn(example.arns()[0])
 *             .build());
 * 
 *         var exampleGroup = new Group("exampleGroup", GroupArgs.builder()
 *             .identityStoreId(example.identityStoreIds()[0])
 *             .displayName("Admin")
 *             .description("Admin Group")
 *             .build());
 * 
 *         var exampleAccountAssignment = new AccountAssignment("exampleAccountAssignment", AccountAssignmentArgs.builder()
 *             .instanceArn(example.arns()[0])
 *             .permissionSetArn(examplePermissionSet.arn())
 *             .principalId(exampleGroup.groupId())
 *             .principalType("GROUP")
 *             .targetId("123456789012")
 *             .targetType("AWS_ACCOUNT")
 *             .build());
 * 
 *         var exampleManagedPolicyAttachment = new ManagedPolicyAttachment("exampleManagedPolicyAttachment", ManagedPolicyAttachmentArgs.builder()
 *             .instanceArn(example.arns()[0])
 *             .managedPolicyArn("arn:aws:iam::aws:policy/AlexaForBusinessDeviceSetup")
 *             .permissionSetArn(examplePermissionSet.arn())
 *             .build(), CustomResourceOptions.builder()
 *                 .dependsOn(exampleAccountAssignment)
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
 * Using `pulumi import`, import SSO Managed Policy Attachments using the `managed_policy_arn`, `permission_set_arn`, and `instance_arn` separated by a comma (`,`). For example:
 * 
 * ```sh
 * $ pulumi import aws:ssoadmin/managedPolicyAttachment:ManagedPolicyAttachment example arn:aws:iam::aws:policy/AlexaForBusinessDeviceSetup,arn:aws:sso:::permissionSet/ssoins-2938j0x8920sbj72/ps-80383020jr9302rk,arn:aws:sso:::instance/ssoins-2938j0x8920sbj72
 * ```
 * 
 */
@ResourceType(type="aws:ssoadmin/managedPolicyAttachment:ManagedPolicyAttachment")
public class ManagedPolicyAttachment extends com.pulumi.resources.CustomResource {
    /**
     * The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
     * 
     */
    @Export(name="instanceArn", refs={String.class}, tree="[0]")
    private Output<String> instanceArn;

    /**
     * @return The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
     * 
     */
    public Output<String> instanceArn() {
        return this.instanceArn;
    }
    /**
     * The IAM managed policy Amazon Resource Name (ARN) to be attached to the Permission Set.
     * 
     */
    @Export(name="managedPolicyArn", refs={String.class}, tree="[0]")
    private Output<String> managedPolicyArn;

    /**
     * @return The IAM managed policy Amazon Resource Name (ARN) to be attached to the Permission Set.
     * 
     */
    public Output<String> managedPolicyArn() {
        return this.managedPolicyArn;
    }
    /**
     * The name of the IAM Managed Policy.
     * 
     */
    @Export(name="managedPolicyName", refs={String.class}, tree="[0]")
    private Output<String> managedPolicyName;

    /**
     * @return The name of the IAM Managed Policy.
     * 
     */
    public Output<String> managedPolicyName() {
        return this.managedPolicyName;
    }
    /**
     * The Amazon Resource Name (ARN) of the Permission Set.
     * 
     */
    @Export(name="permissionSetArn", refs={String.class}, tree="[0]")
    private Output<String> permissionSetArn;

    /**
     * @return The Amazon Resource Name (ARN) of the Permission Set.
     * 
     */
    public Output<String> permissionSetArn() {
        return this.permissionSetArn;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public ManagedPolicyAttachment(java.lang.String name) {
        this(name, ManagedPolicyAttachmentArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public ManagedPolicyAttachment(java.lang.String name, ManagedPolicyAttachmentArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public ManagedPolicyAttachment(java.lang.String name, ManagedPolicyAttachmentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssoadmin/managedPolicyAttachment:ManagedPolicyAttachment", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private ManagedPolicyAttachment(java.lang.String name, Output<java.lang.String> id, @Nullable ManagedPolicyAttachmentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssoadmin/managedPolicyAttachment:ManagedPolicyAttachment", name, state, makeResourceOptions(options, id), false);
    }

    private static ManagedPolicyAttachmentArgs makeArgs(ManagedPolicyAttachmentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? ManagedPolicyAttachmentArgs.Empty : args;
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
    public static ManagedPolicyAttachment get(java.lang.String name, Output<java.lang.String> id, @Nullable ManagedPolicyAttachmentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new ManagedPolicyAttachment(name, id, state, options);
    }
}
