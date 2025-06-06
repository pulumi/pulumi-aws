// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssm;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ssm.PatchBaselineArgs;
import com.pulumi.aws.ssm.inputs.PatchBaselineState;
import com.pulumi.aws.ssm.outputs.PatchBaselineApprovalRule;
import com.pulumi.aws.ssm.outputs.PatchBaselineGlobalFilter;
import com.pulumi.aws.ssm.outputs.PatchBaselineSource;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides an SSM Patch Baseline resource.
 * 
 * &gt; **NOTE on Patch Baselines:** The `approved_patches` and `approval_rule` are
 * both marked as optional fields, but the Patch Baseline requires that at least one
 * of them is specified.
 * 
 * ## Example Usage
 * 
 * ### Basic Usage
 * 
 * Using `approved_patches` only.
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ssm.PatchBaseline;
 * import com.pulumi.aws.ssm.PatchBaselineArgs;
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
 *         var production = new PatchBaseline("production", PatchBaselineArgs.builder()
 *             .name("patch-baseline")
 *             .approvedPatches("KB123456")
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Advanced Usage, specifying patch filters
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ssm.PatchBaseline;
 * import com.pulumi.aws.ssm.PatchBaselineArgs;
 * import com.pulumi.aws.ssm.inputs.PatchBaselineGlobalFilterArgs;
 * import com.pulumi.aws.ssm.inputs.PatchBaselineApprovalRuleArgs;
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
 *         var production = new PatchBaseline("production", PatchBaselineArgs.builder()
 *             .name("patch-baseline")
 *             .description("Patch Baseline Description")
 *             .approvedPatches(            
 *                 "KB123456",
 *                 "KB456789")
 *             .rejectedPatches("KB987654")
 *             .globalFilters(            
 *                 PatchBaselineGlobalFilterArgs.builder()
 *                     .key("PRODUCT")
 *                     .values("WindowsServer2008")
 *                     .build(),
 *                 PatchBaselineGlobalFilterArgs.builder()
 *                     .key("CLASSIFICATION")
 *                     .values("ServicePacks")
 *                     .build(),
 *                 PatchBaselineGlobalFilterArgs.builder()
 *                     .key("MSRC_SEVERITY")
 *                     .values("Low")
 *                     .build())
 *             .approvalRules(            
 *                 PatchBaselineApprovalRuleArgs.builder()
 *                     .approveAfterDays(7)
 *                     .complianceLevel("HIGH")
 *                     .patchFilters(                    
 *                         PatchBaselineApprovalRulePatchFilterArgs.builder()
 *                             .key("PRODUCT")
 *                             .values("WindowsServer2016")
 *                             .build(),
 *                         PatchBaselineApprovalRulePatchFilterArgs.builder()
 *                             .key("CLASSIFICATION")
 *                             .values(                            
 *                                 "CriticalUpdates",
 *                                 "SecurityUpdates",
 *                                 "Updates")
 *                             .build(),
 *                         PatchBaselineApprovalRulePatchFilterArgs.builder()
 *                             .key("MSRC_SEVERITY")
 *                             .values(                            
 *                                 "Critical",
 *                                 "Important",
 *                                 "Moderate")
 *                             .build())
 *                     .build(),
 *                 PatchBaselineApprovalRuleArgs.builder()
 *                     .approveAfterDays(7)
 *                     .patchFilters(PatchBaselineApprovalRulePatchFilterArgs.builder()
 *                         .key("PRODUCT")
 *                         .values("WindowsServer2012")
 *                         .build())
 *                     .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Advanced usage, specifying Microsoft application and Windows patch rules
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ssm.PatchBaseline;
 * import com.pulumi.aws.ssm.PatchBaselineArgs;
 * import com.pulumi.aws.ssm.inputs.PatchBaselineApprovalRuleArgs;
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
 *         var windowsOsApps = new PatchBaseline("windowsOsApps", PatchBaselineArgs.builder()
 *             .name("WindowsOSAndMicrosoftApps")
 *             .description("Patch both Windows and Microsoft apps")
 *             .operatingSystem("WINDOWS")
 *             .approvalRules(            
 *                 PatchBaselineApprovalRuleArgs.builder()
 *                     .approveAfterDays(7)
 *                     .patchFilters(                    
 *                         PatchBaselineApprovalRulePatchFilterArgs.builder()
 *                             .key("CLASSIFICATION")
 *                             .values(                            
 *                                 "CriticalUpdates",
 *                                 "SecurityUpdates")
 *                             .build(),
 *                         PatchBaselineApprovalRulePatchFilterArgs.builder()
 *                             .key("MSRC_SEVERITY")
 *                             .values(                            
 *                                 "Critical",
 *                                 "Important")
 *                             .build())
 *                     .build(),
 *                 PatchBaselineApprovalRuleArgs.builder()
 *                     .approveAfterDays(7)
 *                     .patchFilters(                    
 *                         PatchBaselineApprovalRulePatchFilterArgs.builder()
 *                             .key("PATCH_SET")
 *                             .values("APPLICATION")
 *                             .build(),
 *                         PatchBaselineApprovalRulePatchFilterArgs.builder()
 *                             .key("PRODUCT")
 *                             .values(                            
 *                                 "Office 2013",
 *                                 "Office 2016")
 *                             .build())
 *                     .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Advanced usage, specifying alternate patch source repository
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ssm.PatchBaseline;
 * import com.pulumi.aws.ssm.PatchBaselineArgs;
 * import com.pulumi.aws.ssm.inputs.PatchBaselineApprovalRuleArgs;
 * import com.pulumi.aws.ssm.inputs.PatchBaselineSourceArgs;
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
 *         var al201709 = new PatchBaseline("al201709", PatchBaselineArgs.builder()
 *             .approvalRules(PatchBaselineApprovalRuleArgs.builder()
 *                 .build())
 *             .name("Amazon-Linux-2017.09")
 *             .description("My patch repository for Amazon Linux 2017.09")
 *             .operatingSystem("AMAZON_LINUX")
 *             .sources(PatchBaselineSourceArgs.builder()
 *                 .name("My-AL2017.09")
 *                 .products("AmazonLinux2017.09")
 *                 .configuration("""
 * [amzn-main]
 * name=amzn-main-Base
 * mirrorlist=http://repo./$awsregion./$awsdomain//$releasever/main/mirror.list
 * mirrorlist_expire=300
 * metadata_expire=300
 * priority=10
 * failovermethod=priority
 * fastestmirror_enabled=0
 * gpgcheck=1
 * gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-amazon-ga
 * enabled=1
 * retries=3
 * timeout=5
 * report_instanceid=yes
 *                 """)
 *                 .build())
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
 * Using `pulumi import`, import SSM Patch Baselines using their baseline ID. For example:
 * 
 * ```sh
 * $ pulumi import aws:ssm/patchBaseline:PatchBaseline example pb-12345678
 * ```
 * 
 */
@ResourceType(type="aws:ssm/patchBaseline:PatchBaseline")
public class PatchBaseline extends com.pulumi.resources.CustomResource {
    /**
     * Set of rules used to include patches in the baseline. Up to 10 approval rules can be specified. See `approval_rule` below.
     * 
     */
    @Export(name="approvalRules", refs={List.class,PatchBaselineApprovalRule.class}, tree="[0,1]")
    private Output</* @Nullable */ List<PatchBaselineApprovalRule>> approvalRules;

    /**
     * @return Set of rules used to include patches in the baseline. Up to 10 approval rules can be specified. See `approval_rule` below.
     * 
     */
    public Output<Optional<List<PatchBaselineApprovalRule>>> approvalRules() {
        return Codegen.optional(this.approvalRules);
    }
    /**
     * List of explicitly approved patches for the baseline. Cannot be specified with `approval_rule`.
     * 
     */
    @Export(name="approvedPatches", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> approvedPatches;

    /**
     * @return List of explicitly approved patches for the baseline. Cannot be specified with `approval_rule`.
     * 
     */
    public Output<Optional<List<String>>> approvedPatches() {
        return Codegen.optional(this.approvedPatches);
    }
    /**
     * Compliance level for approved patches. This means that if an approved patch is reported as missing, this is the severity of the compliance violation. Valid values are `CRITICAL`, `HIGH`, `MEDIUM`, `LOW`, `INFORMATIONAL`, `UNSPECIFIED`. The default value is `UNSPECIFIED`.
     * 
     */
    @Export(name="approvedPatchesComplianceLevel", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> approvedPatchesComplianceLevel;

    /**
     * @return Compliance level for approved patches. This means that if an approved patch is reported as missing, this is the severity of the compliance violation. Valid values are `CRITICAL`, `HIGH`, `MEDIUM`, `LOW`, `INFORMATIONAL`, `UNSPECIFIED`. The default value is `UNSPECIFIED`.
     * 
     */
    public Output<Optional<String>> approvedPatchesComplianceLevel() {
        return Codegen.optional(this.approvedPatchesComplianceLevel);
    }
    /**
     * Whether the list of approved patches includes non-security updates that should be applied to the instances. Applies to Linux instances only.
     * 
     */
    @Export(name="approvedPatchesEnableNonSecurity", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> approvedPatchesEnableNonSecurity;

    /**
     * @return Whether the list of approved patches includes non-security updates that should be applied to the instances. Applies to Linux instances only.
     * 
     */
    public Output<Optional<Boolean>> approvedPatchesEnableNonSecurity() {
        return Codegen.optional(this.approvedPatchesEnableNonSecurity);
    }
    /**
     * ARN of the baseline.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN of the baseline.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Description of the patch baseline.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return Description of the patch baseline.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * Set of global filters used to exclude patches from the baseline. Up to 4 global filters can be specified using Key/Value pairs. Valid Keys are `PRODUCT`, `CLASSIFICATION`, `MSRC_SEVERITY`, and `PATCH_ID`.
     * 
     */
    @Export(name="globalFilters", refs={List.class,PatchBaselineGlobalFilter.class}, tree="[0,1]")
    private Output</* @Nullable */ List<PatchBaselineGlobalFilter>> globalFilters;

    /**
     * @return Set of global filters used to exclude patches from the baseline. Up to 4 global filters can be specified using Key/Value pairs. Valid Keys are `PRODUCT`, `CLASSIFICATION`, `MSRC_SEVERITY`, and `PATCH_ID`.
     * 
     */
    public Output<Optional<List<PatchBaselineGlobalFilter>>> globalFilters() {
        return Codegen.optional(this.globalFilters);
    }
    /**
     * JSON definition of the baseline.
     * 
     */
    @Export(name="json", refs={String.class}, tree="[0]")
    private Output<String> json;

    /**
     * @return JSON definition of the baseline.
     * 
     */
    public Output<String> json() {
        return this.json;
    }
    /**
     * Name of the patch baseline.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the patch baseline.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Operating system the patch baseline applies to. Valid values are `ALMA_LINUX`, `AMAZON_LINUX`, `AMAZON_LINUX_2`, `AMAZON_LINUX_2022`, `AMAZON_LINUX_2023`, `CENTOS`, `DEBIAN`, `MACOS`, `ORACLE_LINUX`, `RASPBIAN`, `REDHAT_ENTERPRISE_LINUX`, `ROCKY_LINUX`, `SUSE`, `UBUNTU`, and `WINDOWS`. The default value is `WINDOWS`.
     * 
     */
    @Export(name="operatingSystem", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> operatingSystem;

    /**
     * @return Operating system the patch baseline applies to. Valid values are `ALMA_LINUX`, `AMAZON_LINUX`, `AMAZON_LINUX_2`, `AMAZON_LINUX_2022`, `AMAZON_LINUX_2023`, `CENTOS`, `DEBIAN`, `MACOS`, `ORACLE_LINUX`, `RASPBIAN`, `REDHAT_ENTERPRISE_LINUX`, `ROCKY_LINUX`, `SUSE`, `UBUNTU`, and `WINDOWS`. The default value is `WINDOWS`.
     * 
     */
    public Output<Optional<String>> operatingSystem() {
        return Codegen.optional(this.operatingSystem);
    }
    /**
     * List of rejected patches.
     * 
     */
    @Export(name="rejectedPatches", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> rejectedPatches;

    /**
     * @return List of rejected patches.
     * 
     */
    public Output<Optional<List<String>>> rejectedPatches() {
        return Codegen.optional(this.rejectedPatches);
    }
    /**
     * Action for Patch Manager to take on patches included in the `rejected_patches` list. Valid values are `ALLOW_AS_DEPENDENCY` and `BLOCK`.
     * 
     */
    @Export(name="rejectedPatchesAction", refs={String.class}, tree="[0]")
    private Output<String> rejectedPatchesAction;

    /**
     * @return Action for Patch Manager to take on patches included in the `rejected_patches` list. Valid values are `ALLOW_AS_DEPENDENCY` and `BLOCK`.
     * 
     */
    public Output<String> rejectedPatchesAction() {
        return this.rejectedPatchesAction;
    }
    /**
     * Configuration block with alternate sources for patches. Applies to Linux instances only. See `source` below.
     * 
     */
    @Export(name="sources", refs={List.class,PatchBaselineSource.class}, tree="[0,1]")
    private Output</* @Nullable */ List<PatchBaselineSource>> sources;

    /**
     * @return Configuration block with alternate sources for patches. Applies to Linux instances only. See `source` below.
     * 
     */
    public Output<Optional<List<PatchBaselineSource>>> sources() {
        return Codegen.optional(this.sources);
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
     * Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    /**
     * @return Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     */
    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public PatchBaseline(java.lang.String name) {
        this(name, PatchBaselineArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public PatchBaseline(java.lang.String name, @Nullable PatchBaselineArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public PatchBaseline(java.lang.String name, @Nullable PatchBaselineArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssm/patchBaseline:PatchBaseline", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private PatchBaseline(java.lang.String name, Output<java.lang.String> id, @Nullable PatchBaselineState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssm/patchBaseline:PatchBaseline", name, state, makeResourceOptions(options, id), false);
    }

    private static PatchBaselineArgs makeArgs(@Nullable PatchBaselineArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? PatchBaselineArgs.Empty : args;
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
    public static PatchBaseline get(java.lang.String name, Output<java.lang.String> id, @Nullable PatchBaselineState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new PatchBaseline(name, id, state, options);
    }
}
