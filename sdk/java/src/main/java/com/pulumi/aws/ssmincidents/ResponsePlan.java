// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssmincidents;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ssmincidents.ResponsePlanArgs;
import com.pulumi.aws.ssmincidents.inputs.ResponsePlanState;
import com.pulumi.aws.ssmincidents.outputs.ResponsePlanAction;
import com.pulumi.aws.ssmincidents.outputs.ResponsePlanIncidentTemplate;
import com.pulumi.aws.ssmincidents.outputs.ResponsePlanIntegration;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a resource to manage response plans in AWS Systems Manager Incident Manager.
 * 
 * &gt; NOTE: A response plan implicitly depends on a replication set. If you configured your replication set in Pulumi, we recommend you add it to the `depends_on` argument for the ResponsePlan Resource.
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
 * import com.pulumi.aws.ssmincidents.ResponsePlan;
 * import com.pulumi.aws.ssmincidents.ResponsePlanArgs;
 * import com.pulumi.aws.ssmincidents.inputs.ResponsePlanIncidentTemplateArgs;
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
 *         var example = new ResponsePlan("example", ResponsePlanArgs.builder()
 *             .name("name")
 *             .incidentTemplate(ResponsePlanIncidentTemplateArgs.builder()
 *                 .title("title")
 *                 .impact(3)
 *                 .build())
 *             .tags(Map.of("key", "value"))
 *             .build(), CustomResourceOptions.builder()
 *                 .dependsOn(exampleAwsSsmincidentsReplicationSet)
 *                 .build());
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
 * import com.pulumi.aws.ssmincidents.ResponsePlan;
 * import com.pulumi.aws.ssmincidents.ResponsePlanArgs;
 * import com.pulumi.aws.ssmincidents.inputs.ResponsePlanIncidentTemplateArgs;
 * import com.pulumi.aws.ssmincidents.inputs.ResponsePlanActionArgs;
 * import com.pulumi.aws.ssmincidents.inputs.ResponsePlanIntegrationArgs;
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
 *         var example = new ResponsePlan("example", ResponsePlanArgs.builder()
 *             .name("name")
 *             .incidentTemplate(ResponsePlanIncidentTemplateArgs.builder()
 *                 .title("title")
 *                 .impact(3)
 *                 .dedupeString("dedupe")
 *                 .incidentTags(Map.of("key", "value"))
 *                 .notificationTargets(                
 *                     ResponsePlanIncidentTemplateNotificationTargetArgs.builder()
 *                         .snsTopicArn(example1.arn())
 *                         .build(),
 *                     ResponsePlanIncidentTemplateNotificationTargetArgs.builder()
 *                         .snsTopicArn(example2.arn())
 *                         .build())
 *                 .summary("summary")
 *                 .build())
 *             .displayName("display name")
 *             .chatChannels(topic.arn())
 *             .engagements("arn:aws:ssm-contacts:us-east-2:111122223333:contact/test1")
 *             .action(ResponsePlanActionArgs.builder()
 *                 .ssmAutomations(ResponsePlanActionSsmAutomationArgs.builder()
 *                     .documentName(document1.name())
 *                     .roleArn(role1.arn())
 *                     .documentVersion("version1")
 *                     .targetAccount("RESPONSE_PLAN_OWNER_ACCOUNT")
 *                     .parameters(                    
 *                         ResponsePlanActionSsmAutomationParameterArgs.builder()
 *                             .name("key")
 *                             .values(                            
 *                                 "value1",
 *                                 "value2")
 *                             .build(),
 *                         ResponsePlanActionSsmAutomationParameterArgs.builder()
 *                             .name("foo")
 *                             .values("bar")
 *                             .build())
 *                     .dynamicParameters(Map.ofEntries(
 *                         Map.entry("someKey", "INVOLVED_RESOURCES"),
 *                         Map.entry("anotherKey", "INCIDENT_RECORD_ARN")
 *                     ))
 *                     .build())
 *                 .build())
 *             .integration(ResponsePlanIntegrationArgs.builder()
 *                 .pagerduties(ResponsePlanIntegrationPagerdutyArgs.builder()
 *                     .name("pagerdutyIntergration")
 *                     .serviceId("example")
 *                     .secretId("example")
 *                     .build())
 *                 .build())
 *             .tags(Map.of("key", "value"))
 *             .build(), CustomResourceOptions.builder()
 *                 .dependsOn(exampleAwsSsmincidentsReplicationSet)
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
 * Using `pulumi import`, import an Incident Manager response plan using the response plan ARN. You can find the response plan ARN in the AWS Management Console. For example:
 * 
 * ```sh
 * $ pulumi import aws:ssmincidents/responsePlan:ResponsePlan responsePlanName ARNValue
 * ```
 * 
 */
@ResourceType(type="aws:ssmincidents/responsePlan:ResponsePlan")
public class ResponsePlan extends com.pulumi.resources.CustomResource {
    /**
     * The actions that the response plan starts at the beginning of an incident.
     * 
     */
    @Export(name="action", refs={ResponsePlanAction.class}, tree="[0]")
    private Output</* @Nullable */ ResponsePlanAction> action;

    /**
     * @return The actions that the response plan starts at the beginning of an incident.
     * 
     */
    public Output<Optional<ResponsePlanAction>> action() {
        return Codegen.optional(this.action);
    }
    /**
     * The ARN of the response plan.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The ARN of the response plan.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The Chatbot chat channel used for collaboration during an incident.
     * 
     */
    @Export(name="chatChannels", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> chatChannels;

    /**
     * @return The Chatbot chat channel used for collaboration during an incident.
     * 
     */
    public Output<Optional<List<String>>> chatChannels() {
        return Codegen.optional(this.chatChannels);
    }
    /**
     * The long format of the response plan name. This field can contain spaces.
     * 
     */
    @Export(name="displayName", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> displayName;

    /**
     * @return The long format of the response plan name. This field can contain spaces.
     * 
     */
    public Output<Optional<String>> displayName() {
        return Codegen.optional(this.displayName);
    }
    /**
     * The Amazon Resource Name (ARN) for the contacts and escalation plans that the response plan engages during an incident.
     * 
     */
    @Export(name="engagements", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> engagements;

    /**
     * @return The Amazon Resource Name (ARN) for the contacts and escalation plans that the response plan engages during an incident.
     * 
     */
    public Output<Optional<List<String>>> engagements() {
        return Codegen.optional(this.engagements);
    }
    /**
     * The `incident_template` configuration block is required and supports the following arguments:
     * 
     */
    @Export(name="incidentTemplate", refs={ResponsePlanIncidentTemplate.class}, tree="[0]")
    private Output<ResponsePlanIncidentTemplate> incidentTemplate;

    /**
     * @return The `incident_template` configuration block is required and supports the following arguments:
     * 
     */
    public Output<ResponsePlanIncidentTemplate> incidentTemplate() {
        return this.incidentTemplate;
    }
    /**
     * Information about third-party services integrated into the response plan. The following values are supported:
     * 
     */
    @Export(name="integration", refs={ResponsePlanIntegration.class}, tree="[0]")
    private Output</* @Nullable */ ResponsePlanIntegration> integration;

    /**
     * @return Information about third-party services integrated into the response plan. The following values are supported:
     * 
     */
    public Output<Optional<ResponsePlanIntegration>> integration() {
        return Codegen.optional(this.integration);
    }
    /**
     * The name of the response plan.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return The name of the response plan.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * The tags applied to the response plan.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return The tags applied to the response plan.
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
    public ResponsePlan(java.lang.String name) {
        this(name, ResponsePlanArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public ResponsePlan(java.lang.String name, ResponsePlanArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public ResponsePlan(java.lang.String name, ResponsePlanArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssmincidents/responsePlan:ResponsePlan", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private ResponsePlan(java.lang.String name, Output<java.lang.String> id, @Nullable ResponsePlanState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssmincidents/responsePlan:ResponsePlan", name, state, makeResourceOptions(options, id), false);
    }

    private static ResponsePlanArgs makeArgs(ResponsePlanArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? ResponsePlanArgs.Empty : args;
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
    public static ResponsePlan get(java.lang.String name, Output<java.lang.String> id, @Nullable ResponsePlanState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new ResponsePlan(name, id, state, options);
    }
}
