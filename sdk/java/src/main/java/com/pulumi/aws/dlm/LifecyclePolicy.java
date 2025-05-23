// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dlm;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.dlm.LifecyclePolicyArgs;
import com.pulumi.aws.dlm.inputs.LifecyclePolicyState;
import com.pulumi.aws.dlm.outputs.LifecyclePolicyPolicyDetails;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a [Data Lifecycle Manager (DLM) lifecycle policy](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/snapshot-lifecycle.html) for managing snapshots.
 * 
 * ## Example Usage
 * 
 * ### Basic
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.iam.IamFunctions;
 * import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
 * import com.pulumi.aws.iam.Role;
 * import com.pulumi.aws.iam.RoleArgs;
 * import com.pulumi.aws.iam.RolePolicy;
 * import com.pulumi.aws.iam.RolePolicyArgs;
 * import com.pulumi.aws.dlm.LifecyclePolicy;
 * import com.pulumi.aws.dlm.LifecyclePolicyArgs;
 * import com.pulumi.aws.dlm.inputs.LifecyclePolicyPolicyDetailsArgs;
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
 *         final var assumeRole = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
 *             .statements(GetPolicyDocumentStatementArgs.builder()
 *                 .effect("Allow")
 *                 .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
 *                     .type("Service")
 *                     .identifiers("dlm.amazonaws.com")
 *                     .build())
 *                 .actions("sts:AssumeRole")
 *                 .build())
 *             .build());
 * 
 *         var dlmLifecycleRole = new Role("dlmLifecycleRole", RoleArgs.builder()
 *             .name("dlm-lifecycle-role")
 *             .assumeRolePolicy(assumeRole.json())
 *             .build());
 * 
 *         final var dlmLifecycle = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
 *             .statements(            
 *                 GetPolicyDocumentStatementArgs.builder()
 *                     .effect("Allow")
 *                     .actions(                    
 *                         "ec2:CreateSnapshot",
 *                         "ec2:CreateSnapshots",
 *                         "ec2:DeleteSnapshot",
 *                         "ec2:DescribeInstances",
 *                         "ec2:DescribeVolumes",
 *                         "ec2:DescribeSnapshots")
 *                     .resources("*")
 *                     .build(),
 *                 GetPolicyDocumentStatementArgs.builder()
 *                     .effect("Allow")
 *                     .actions("ec2:CreateTags")
 *                     .resources("arn:aws:ec2:*::snapshot/*")
 *                     .build())
 *             .build());
 * 
 *         var dlmLifecycleRolePolicy = new RolePolicy("dlmLifecycleRolePolicy", RolePolicyArgs.builder()
 *             .name("dlm-lifecycle-policy")
 *             .role(dlmLifecycleRole.id())
 *             .policy(dlmLifecycle.json())
 *             .build());
 * 
 *         var example = new LifecyclePolicy("example", LifecyclePolicyArgs.builder()
 *             .description("example DLM lifecycle policy")
 *             .executionRoleArn(dlmLifecycleRole.arn())
 *             .state("ENABLED")
 *             .policyDetails(LifecyclePolicyPolicyDetailsArgs.builder()
 *                 .resourceTypes("VOLUME")
 *                 .schedules(LifecyclePolicyPolicyDetailsScheduleArgs.builder()
 *                     .name("2 weeks of daily snapshots")
 *                     .createRule(LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs.builder()
 *                         .interval(24)
 *                         .intervalUnit("HOURS")
 *                         .times("23:45")
 *                         .build())
 *                     .retainRule(LifecyclePolicyPolicyDetailsScheduleRetainRuleArgs.builder()
 *                         .count(14)
 *                         .build())
 *                     .tagsToAdd(Map.of("SnapshotCreator", "DLM"))
 *                     .copyTags(false)
 *                     .build())
 *                 .targetTags(Map.of("Snapshot", "true"))
 *                 .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Example Cross-Region Snapshot Copy Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.AwsFunctions;
 * import com.pulumi.aws.inputs.GetCallerIdentityArgs;
 * import com.pulumi.aws.iam.IamFunctions;
 * import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
 * import com.pulumi.aws.kms.Key;
 * import com.pulumi.aws.kms.KeyArgs;
 * import com.pulumi.aws.dlm.LifecyclePolicy;
 * import com.pulumi.aws.dlm.LifecyclePolicyArgs;
 * import com.pulumi.aws.dlm.inputs.LifecyclePolicyPolicyDetailsArgs;
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
 *         // ...other configuration...
 *         final var current = AwsFunctions.getCallerIdentity(GetCallerIdentityArgs.builder()
 *             .build());
 * 
 *         final var key = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
 *             .statements(GetPolicyDocumentStatementArgs.builder()
 *                 .sid("Enable IAM User Permissions")
 *                 .effect("Allow")
 *                 .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
 *                     .type("AWS")
 *                     .identifiers(String.format("arn:aws:iam::%s:root", current.accountId()))
 *                     .build())
 *                 .actions("kms:*")
 *                 .resources("*")
 *                 .build())
 *             .build());
 * 
 *         var dlmCrossRegionCopyCmk = new Key("dlmCrossRegionCopyCmk", KeyArgs.builder()
 *             .description("Example Alternate Region KMS Key")
 *             .policy(key.json())
 *             .build());
 * 
 *         var example = new LifecyclePolicy("example", LifecyclePolicyArgs.builder()
 *             .description("example DLM lifecycle policy")
 *             .executionRoleArn(dlmLifecycleRole.arn())
 *             .state("ENABLED")
 *             .policyDetails(LifecyclePolicyPolicyDetailsArgs.builder()
 *                 .resourceTypes("VOLUME")
 *                 .schedules(LifecyclePolicyPolicyDetailsScheduleArgs.builder()
 *                     .name("2 weeks of daily snapshots")
 *                     .createRule(LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs.builder()
 *                         .interval(24)
 *                         .intervalUnit("HOURS")
 *                         .times("23:45")
 *                         .build())
 *                     .retainRule(LifecyclePolicyPolicyDetailsScheduleRetainRuleArgs.builder()
 *                         .count(14)
 *                         .build())
 *                     .tagsToAdd(Map.of("SnapshotCreator", "DLM"))
 *                     .copyTags(false)
 *                     .crossRegionCopyRules(LifecyclePolicyPolicyDetailsScheduleCrossRegionCopyRuleArgs.builder()
 *                         .target("us-west-2")
 *                         .encrypted(true)
 *                         .cmkArn(dlmCrossRegionCopyCmk.arn())
 *                         .copyTags(true)
 *                         .retainRule(LifecyclePolicyPolicyDetailsScheduleCrossRegionCopyRuleRetainRuleArgs.builder()
 *                             .interval(30)
 *                             .intervalUnit("DAYS")
 *                             .build())
 *                         .build())
 *                     .build())
 *                 .targetTags(Map.of("Snapshot", "true"))
 *                 .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Example Event Based Policy Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.AwsFunctions;
 * import com.pulumi.aws.inputs.GetCallerIdentityArgs;
 * import com.pulumi.aws.dlm.LifecyclePolicy;
 * import com.pulumi.aws.dlm.LifecyclePolicyArgs;
 * import com.pulumi.aws.dlm.inputs.LifecyclePolicyPolicyDetailsArgs;
 * import com.pulumi.aws.dlm.inputs.LifecyclePolicyPolicyDetailsActionArgs;
 * import com.pulumi.aws.dlm.inputs.LifecyclePolicyPolicyDetailsEventSourceArgs;
 * import com.pulumi.aws.dlm.inputs.LifecyclePolicyPolicyDetailsEventSourceParametersArgs;
 * import com.pulumi.aws.iam.IamFunctions;
 * import com.pulumi.aws.iam.inputs.GetPolicyArgs;
 * import com.pulumi.aws.iam.RolePolicyAttachment;
 * import com.pulumi.aws.iam.RolePolicyAttachmentArgs;
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
 *         final var current = AwsFunctions.getCallerIdentity(GetCallerIdentityArgs.builder()
 *             .build());
 * 
 *         var exampleLifecyclePolicy = new LifecyclePolicy("exampleLifecyclePolicy", LifecyclePolicyArgs.builder()
 *             .description("tf-acc-basic")
 *             .executionRoleArn(exampleAwsIamRole.arn())
 *             .policyDetails(LifecyclePolicyPolicyDetailsArgs.builder()
 *                 .policyType("EVENT_BASED_POLICY")
 *                 .action(LifecyclePolicyPolicyDetailsActionArgs.builder()
 *                     .name("tf-acc-basic")
 *                     .crossRegionCopies(LifecyclePolicyPolicyDetailsActionCrossRegionCopyArgs.builder()
 *                         .encryptionConfiguration(LifecyclePolicyPolicyDetailsActionCrossRegionCopyEncryptionConfigurationArgs.builder()
 *                             .build())
 *                         .retainRule(LifecyclePolicyPolicyDetailsActionCrossRegionCopyRetainRuleArgs.builder()
 *                             .interval(15)
 *                             .intervalUnit("MONTHS")
 *                             .build())
 *                         .target("us-east-1")
 *                         .build())
 *                     .build())
 *                 .eventSource(LifecyclePolicyPolicyDetailsEventSourceArgs.builder()
 *                     .type("MANAGED_CWE")
 *                     .parameters(LifecyclePolicyPolicyDetailsEventSourceParametersArgs.builder()
 *                         .descriptionRegex("^.*Created for policy: policy-1234567890abcdef0.*$")
 *                         .eventType("shareSnapshot")
 *                         .snapshotOwners(current.accountId())
 *                         .build())
 *                     .build())
 *                 .build())
 *             .build());
 * 
 *         final var example = IamFunctions.getPolicy(GetPolicyArgs.builder()
 *             .name("AWSDataLifecycleManagerServiceRole")
 *             .build());
 * 
 *         var exampleRolePolicyAttachment = new RolePolicyAttachment("exampleRolePolicyAttachment", RolePolicyAttachmentArgs.builder()
 *             .role(exampleAwsIamRole.id())
 *             .policyArn(example.arn())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import DLM lifecycle policies using their policy ID. For example:
 * 
 * ```sh
 * $ pulumi import aws:dlm/lifecyclePolicy:LifecyclePolicy example policy-abcdef12345678901
 * ```
 * 
 */
@ResourceType(type="aws:dlm/lifecyclePolicy:LifecyclePolicy")
public class LifecyclePolicy extends com.pulumi.resources.CustomResource {
    /**
     * Amazon Resource Name (ARN) of the DLM Lifecycle Policy.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN) of the DLM Lifecycle Policy.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * A description for the DLM lifecycle policy.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output<String> description;

    /**
     * @return A description for the DLM lifecycle policy.
     * 
     */
    public Output<String> description() {
        return this.description;
    }
    /**
     * The ARN of an IAM role that is able to be assumed by the DLM service.
     * 
     */
    @Export(name="executionRoleArn", refs={String.class}, tree="[0]")
    private Output<String> executionRoleArn;

    /**
     * @return The ARN of an IAM role that is able to be assumed by the DLM service.
     * 
     */
    public Output<String> executionRoleArn() {
        return this.executionRoleArn;
    }
    /**
     * See the `policy_details` configuration block. Max of 1.
     * 
     */
    @Export(name="policyDetails", refs={LifecyclePolicyPolicyDetails.class}, tree="[0]")
    private Output<LifecyclePolicyPolicyDetails> policyDetails;

    /**
     * @return See the `policy_details` configuration block. Max of 1.
     * 
     */
    public Output<LifecyclePolicyPolicyDetails> policyDetails() {
        return this.policyDetails;
    }
    /**
     * Whether the lifecycle policy should be enabled or disabled. `ENABLED` or `DISABLED` are valid values. Defaults to `ENABLED`.
     * 
     */
    @Export(name="state", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> state;

    /**
     * @return Whether the lifecycle policy should be enabled or disabled. `ENABLED` or `DISABLED` are valid values. Defaults to `ENABLED`.
     * 
     */
    public Output<Optional<String>> state() {
        return Codegen.optional(this.state);
    }
    /**
     * Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public LifecyclePolicy(java.lang.String name) {
        this(name, LifecyclePolicyArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public LifecyclePolicy(java.lang.String name, LifecyclePolicyArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public LifecyclePolicy(java.lang.String name, LifecyclePolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:dlm/lifecyclePolicy:LifecyclePolicy", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private LifecyclePolicy(java.lang.String name, Output<java.lang.String> id, @Nullable LifecyclePolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:dlm/lifecyclePolicy:LifecyclePolicy", name, state, makeResourceOptions(options, id), false);
    }

    private static LifecyclePolicyArgs makeArgs(LifecyclePolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? LifecyclePolicyArgs.Empty : args;
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
    public static LifecyclePolicy get(java.lang.String name, Output<java.lang.String> id, @Nullable LifecyclePolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new LifecyclePolicy(name, id, state, options);
    }
}
