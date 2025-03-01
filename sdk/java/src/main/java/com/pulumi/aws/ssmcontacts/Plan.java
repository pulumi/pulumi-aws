// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssmcontacts;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ssmcontacts.PlanArgs;
import com.pulumi.aws.ssmcontacts.inputs.PlanState;
import com.pulumi.aws.ssmcontacts.outputs.PlanStage;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS SSM Contact Plan.
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
 * import com.pulumi.aws.ssmcontacts.Plan;
 * import com.pulumi.aws.ssmcontacts.PlanArgs;
 * import com.pulumi.aws.ssmcontacts.inputs.PlanStageArgs;
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
 *         var example = new Plan("example", PlanArgs.builder()
 *             .contactId("arn:aws:ssm-contacts:us-west-2:123456789012:contact/contactalias")
 *             .stages(PlanStageArgs.builder()
 *                 .durationInMinutes(1)
 *                 .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Usage with SSM Contact
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ssmcontacts.Contact;
 * import com.pulumi.aws.ssmcontacts.ContactArgs;
 * import com.pulumi.aws.ssmcontacts.Plan;
 * import com.pulumi.aws.ssmcontacts.PlanArgs;
 * import com.pulumi.aws.ssmcontacts.inputs.PlanStageArgs;
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
 *         var contact = new Contact("contact", ContactArgs.builder()
 *             .alias("alias")
 *             .type("PERSONAL")
 *             .build());
 * 
 *         var plan = new Plan("plan", PlanArgs.builder()
 *             .contactId(contact.arn())
 *             .stages(PlanStageArgs.builder()
 *                 .durationInMinutes(1)
 *                 .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Usage With All Fields
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ssmcontacts.Contact;
 * import com.pulumi.aws.ssmcontacts.ContactArgs;
 * import com.pulumi.aws.ssmcontacts.Plan;
 * import com.pulumi.aws.ssmcontacts.PlanArgs;
 * import com.pulumi.aws.ssmcontacts.inputs.PlanStageArgs;
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
 *         var escalationPlan = new Contact("escalationPlan", ContactArgs.builder()
 *             .alias("escalation-plan-alias")
 *             .type("ESCALATION")
 *             .build());
 * 
 *         var contactOne = new Contact("contactOne", ContactArgs.builder()
 *             .alias("alias")
 *             .type("PERSONAL")
 *             .build());
 * 
 *         var contactTwo = new Contact("contactTwo", ContactArgs.builder()
 *             .alias("alias")
 *             .type("PERSONAL")
 *             .build());
 * 
 *         var test = new Plan("test", PlanArgs.builder()
 *             .contactId(escalationPlan.arn())
 *             .stages(PlanStageArgs.builder()
 *                 .durationInMinutes(0)
 *                 .targets(                
 *                     PlanStageTargetArgs.builder()
 *                         .contactTargetInfo(PlanStageTargetContactTargetInfoArgs.builder()
 *                             .isEssential(false)
 *                             .contactId(contactOne.arn())
 *                             .build())
 *                         .build(),
 *                     PlanStageTargetArgs.builder()
 *                         .contactTargetInfo(PlanStageTargetContactTargetInfoArgs.builder()
 *                             .isEssential(true)
 *                             .contactId(contactTwo.arn())
 *                             .build())
 *                         .build(),
 *                     PlanStageTargetArgs.builder()
 *                         .channelTargetInfo(PlanStageTargetChannelTargetInfoArgs.builder()
 *                             .retryIntervalInMinutes(2)
 *                             .contactChannelId(channel.arn())
 *                             .build())
 *                         .build())
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
 * Using `pulumi import`, import SSM Contact Plan using the Contact ARN. For example:
 * 
 * ```sh
 * $ pulumi import aws:ssmcontacts/plan:Plan example {ARNValue}
 * ```
 * 
 */
@ResourceType(type="aws:ssmcontacts/plan:Plan")
public class Plan extends com.pulumi.resources.CustomResource {
    /**
     * The Amazon Resource Name (ARN) of the contact or escalation plan.
     * 
     */
    @Export(name="contactId", refs={String.class}, tree="[0]")
    private Output<String> contactId;

    /**
     * @return The Amazon Resource Name (ARN) of the contact or escalation plan.
     * 
     */
    public Output<String> contactId() {
        return this.contactId;
    }
    /**
     * One or more configuration blocks for specifying a list of stages that the escalation plan or engagement plan uses to engage contacts and contact methods. See Stage below for more details.
     * 
     */
    @Export(name="stages", refs={List.class,PlanStage.class}, tree="[0,1]")
    private Output<List<PlanStage>> stages;

    /**
     * @return One or more configuration blocks for specifying a list of stages that the escalation plan or engagement plan uses to engage contacts and contact methods. See Stage below for more details.
     * 
     */
    public Output<List<PlanStage>> stages() {
        return this.stages;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Plan(java.lang.String name) {
        this(name, PlanArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Plan(java.lang.String name, PlanArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Plan(java.lang.String name, PlanArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssmcontacts/plan:Plan", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Plan(java.lang.String name, Output<java.lang.String> id, @Nullable PlanState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssmcontacts/plan:Plan", name, state, makeResourceOptions(options, id), false);
    }

    private static PlanArgs makeArgs(PlanArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? PlanArgs.Empty : args;
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
    public static Plan get(java.lang.String name, Output<java.lang.String> id, @Nullable PlanState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Plan(name, id, state, options);
    }
}
