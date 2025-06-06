// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.bedrock.AgentAgentArgs;
import com.pulumi.aws.bedrock.inputs.AgentAgentState;
import com.pulumi.aws.bedrock.outputs.AgentAgentGuardrailConfiguration;
import com.pulumi.aws.bedrock.outputs.AgentAgentMemoryConfiguration;
import com.pulumi.aws.bedrock.outputs.AgentAgentPromptOverrideConfiguration;
import com.pulumi.aws.bedrock.outputs.AgentAgentTimeouts;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS Agents for Amazon Bedrock Agent.
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
 * import com.pulumi.aws.AwsFunctions;
 * import com.pulumi.aws.inputs.GetCallerIdentityArgs;
 * import com.pulumi.aws.inputs.GetPartitionArgs;
 * import com.pulumi.aws.inputs.GetRegionArgs;
 * import com.pulumi.aws.iam.IamFunctions;
 * import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
 * import com.pulumi.aws.iam.Role;
 * import com.pulumi.aws.iam.RoleArgs;
 * import com.pulumi.aws.iam.RolePolicy;
 * import com.pulumi.aws.iam.RolePolicyArgs;
 * import com.pulumi.aws.bedrock.AgentAgent;
 * import com.pulumi.aws.bedrock.AgentAgentArgs;
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
 *         final var currentGetPartition = AwsFunctions.getPartition(GetPartitionArgs.builder()
 *             .build());
 * 
 *         final var currentGetRegion = AwsFunctions.getRegion(GetRegionArgs.builder()
 *             .build());
 * 
 *         final var exampleAgentTrust = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
 *             .statements(GetPolicyDocumentStatementArgs.builder()
 *                 .actions("sts:AssumeRole")
 *                 .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
 *                     .identifiers("bedrock.amazonaws.com")
 *                     .type("Service")
 *                     .build())
 *                 .conditions(                
 *                     GetPolicyDocumentStatementConditionArgs.builder()
 *                         .test("StringEquals")
 *                         .values(current.accountId())
 *                         .variable("aws:SourceAccount")
 *                         .build(),
 *                     GetPolicyDocumentStatementConditionArgs.builder()
 *                         .test("ArnLike")
 *                         .values(String.format("arn:%s:bedrock:%s:%s:agent/*", currentGetPartition.partition(),currentGetRegion.name(),current.accountId()))
 *                         .variable("AWS:SourceArn")
 *                         .build())
 *                 .build())
 *             .build());
 * 
 *         final var exampleAgentPermissions = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
 *             .statements(GetPolicyDocumentStatementArgs.builder()
 *                 .actions("bedrock:InvokeModel")
 *                 .resources(String.format("arn:%s:bedrock:%s::foundation-model/anthropic.claude-v2", currentGetPartition.partition(),currentGetRegion.name()))
 *                 .build())
 *             .build());
 * 
 *         var example = new Role("example", RoleArgs.builder()
 *             .assumeRolePolicy(exampleAgentTrust.json())
 *             .namePrefix("AmazonBedrockExecutionRoleForAgents_")
 *             .build());
 * 
 *         var exampleRolePolicy = new RolePolicy("exampleRolePolicy", RolePolicyArgs.builder()
 *             .policy(exampleAgentPermissions.json())
 *             .role(example.id())
 *             .build());
 * 
 *         var exampleAgentAgent = new AgentAgent("exampleAgentAgent", AgentAgentArgs.builder()
 *             .agentName("my-agent-name")
 *             .agentResourceRoleArn(example.arn())
 *             .idleSessionTtlInSeconds(500)
 *             .foundationModel("anthropic.claude-v2")
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
 * Using `pulumi import`, import Agents for Amazon Bedrock Agent using the agent ID. For example:
 * 
 * ```sh
 * $ pulumi import aws:bedrock/agentAgent:AgentAgent example GGRRAED6JP
 * ```
 * 
 */
@ResourceType(type="aws:bedrock/agentAgent:AgentAgent")
public class AgentAgent extends com.pulumi.resources.CustomResource {
    /**
     * ARN of the agent.
     * 
     */
    @Export(name="agentArn", refs={String.class}, tree="[0]")
    private Output<String> agentArn;

    /**
     * @return ARN of the agent.
     * 
     */
    public Output<String> agentArn() {
        return this.agentArn;
    }
    /**
     * Agents collaboration role. Valid values: `SUPERVISOR`, `SUPERVISOR_ROUTER`, `DISABLED`.
     * 
     */
    @Export(name="agentCollaboration", refs={String.class}, tree="[0]")
    private Output<String> agentCollaboration;

    /**
     * @return Agents collaboration role. Valid values: `SUPERVISOR`, `SUPERVISOR_ROUTER`, `DISABLED`.
     * 
     */
    public Output<String> agentCollaboration() {
        return this.agentCollaboration;
    }
    /**
     * Unique identifier of the agent.
     * 
     */
    @Export(name="agentId", refs={String.class}, tree="[0]")
    private Output<String> agentId;

    /**
     * @return Unique identifier of the agent.
     * 
     */
    public Output<String> agentId() {
        return this.agentId;
    }
    /**
     * Name of the agent.
     * 
     */
    @Export(name="agentName", refs={String.class}, tree="[0]")
    private Output<String> agentName;

    /**
     * @return Name of the agent.
     * 
     */
    public Output<String> agentName() {
        return this.agentName;
    }
    /**
     * ARN of the IAM role with permissions to invoke API operations on the agent.
     * 
     */
    @Export(name="agentResourceRoleArn", refs={String.class}, tree="[0]")
    private Output<String> agentResourceRoleArn;

    /**
     * @return ARN of the IAM role with permissions to invoke API operations on the agent.
     * 
     */
    public Output<String> agentResourceRoleArn() {
        return this.agentResourceRoleArn;
    }
    /**
     * Version of the agent.
     * 
     */
    @Export(name="agentVersion", refs={String.class}, tree="[0]")
    private Output<String> agentVersion;

    /**
     * @return Version of the agent.
     * 
     */
    public Output<String> agentVersion() {
        return this.agentVersion;
    }
    /**
     * ARN of the AWS KMS key that encrypts the agent.
     * 
     */
    @Export(name="customerEncryptionKeyArn", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> customerEncryptionKeyArn;

    /**
     * @return ARN of the AWS KMS key that encrypts the agent.
     * 
     */
    public Output<Optional<String>> customerEncryptionKeyArn() {
        return Codegen.optional(this.customerEncryptionKeyArn);
    }
    /**
     * Description of the agent.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return Description of the agent.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * Foundation model used for orchestration by the agent.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="foundationModel", refs={String.class}, tree="[0]")
    private Output<String> foundationModel;

    /**
     * @return Foundation model used for orchestration by the agent.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> foundationModel() {
        return this.foundationModel;
    }
    /**
     * Details about the guardrail associated with the agent. See `guardrail_configuration` Block for details.
     * 
     */
    @Export(name="guardrailConfigurations", refs={List.class,AgentAgentGuardrailConfiguration.class}, tree="[0,1]")
    private Output</* @Nullable */ List<AgentAgentGuardrailConfiguration>> guardrailConfigurations;

    /**
     * @return Details about the guardrail associated with the agent. See `guardrail_configuration` Block for details.
     * 
     */
    public Output<Optional<List<AgentAgentGuardrailConfiguration>>> guardrailConfigurations() {
        return Codegen.optional(this.guardrailConfigurations);
    }
    /**
     * Number of seconds for which Amazon Bedrock keeps information about a user&#39;s conversation with the agent. A user interaction remains active for the amount of time specified. If no conversation occurs during this time, the session expires and Amazon Bedrock deletes any data provided before the timeout.
     * 
     */
    @Export(name="idleSessionTtlInSeconds", refs={Integer.class}, tree="[0]")
    private Output<Integer> idleSessionTtlInSeconds;

    /**
     * @return Number of seconds for which Amazon Bedrock keeps information about a user&#39;s conversation with the agent. A user interaction remains active for the amount of time specified. If no conversation occurs during this time, the session expires and Amazon Bedrock deletes any data provided before the timeout.
     * 
     */
    public Output<Integer> idleSessionTtlInSeconds() {
        return this.idleSessionTtlInSeconds;
    }
    /**
     * Instructions that tell the agent what it should do and how it should interact with users. The valid range is 40 - 20000 characters.
     * 
     */
    @Export(name="instruction", refs={String.class}, tree="[0]")
    private Output<String> instruction;

    /**
     * @return Instructions that tell the agent what it should do and how it should interact with users. The valid range is 40 - 20000 characters.
     * 
     */
    public Output<String> instruction() {
        return this.instruction;
    }
    /**
     * Configurations for the agent&#39;s ability to retain the conversational context.
     * 
     */
    @Export(name="memoryConfigurations", refs={List.class,AgentAgentMemoryConfiguration.class}, tree="[0,1]")
    private Output<List<AgentAgentMemoryConfiguration>> memoryConfigurations;

    /**
     * @return Configurations for the agent&#39;s ability to retain the conversational context.
     * 
     */
    public Output<List<AgentAgentMemoryConfiguration>> memoryConfigurations() {
        return this.memoryConfigurations;
    }
    /**
     * Whether to prepare the agent after creation or modification. Defaults to `true`.
     * 
     */
    @Export(name="prepareAgent", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> prepareAgent;

    /**
     * @return Whether to prepare the agent after creation or modification. Defaults to `true`.
     * 
     */
    public Output<Boolean> prepareAgent() {
        return this.prepareAgent;
    }
    /**
     * Timestamp of when the agent was last prepared.
     * 
     */
    @Export(name="preparedAt", refs={String.class}, tree="[0]")
    private Output<String> preparedAt;

    /**
     * @return Timestamp of when the agent was last prepared.
     * 
     */
    public Output<String> preparedAt() {
        return this.preparedAt;
    }
    /**
     * Configurations to override prompt templates in different parts of an agent sequence. For more information, see [Advanced prompts](https://docs.aws.amazon.com/bedrock/latest/userguide/advanced-prompts.html). See `prompt_override_configuration` Block for details.
     * 
     */
    @Export(name="promptOverrideConfigurations", refs={List.class,AgentAgentPromptOverrideConfiguration.class}, tree="[0,1]")
    private Output<List<AgentAgentPromptOverrideConfiguration>> promptOverrideConfigurations;

    /**
     * @return Configurations to override prompt templates in different parts of an agent sequence. For more information, see [Advanced prompts](https://docs.aws.amazon.com/bedrock/latest/userguide/advanced-prompts.html). See `prompt_override_configuration` Block for details.
     * 
     */
    public Output<List<AgentAgentPromptOverrideConfiguration>> promptOverrideConfigurations() {
        return this.promptOverrideConfigurations;
    }
    /**
     * Whether the in-use check is skipped when deleting the agent.
     * 
     */
    @Export(name="skipResourceInUseCheck", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> skipResourceInUseCheck;

    /**
     * @return Whether the in-use check is skipped when deleting the agent.
     * 
     */
    public Output<Boolean> skipResourceInUseCheck() {
        return this.skipResourceInUseCheck;
    }
    /**
     * Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
    @Export(name="timeouts", refs={AgentAgentTimeouts.class}, tree="[0]")
    private Output</* @Nullable */ AgentAgentTimeouts> timeouts;

    public Output<Optional<AgentAgentTimeouts>> timeouts() {
        return Codegen.optional(this.timeouts);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public AgentAgent(java.lang.String name) {
        this(name, AgentAgentArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public AgentAgent(java.lang.String name, AgentAgentArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public AgentAgent(java.lang.String name, AgentAgentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:bedrock/agentAgent:AgentAgent", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private AgentAgent(java.lang.String name, Output<java.lang.String> id, @Nullable AgentAgentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:bedrock/agentAgent:AgentAgent", name, state, makeResourceOptions(options, id), false);
    }

    private static AgentAgentArgs makeArgs(AgentAgentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? AgentAgentArgs.Empty : args;
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
    public static AgentAgent get(java.lang.String name, Output<java.lang.String> id, @Nullable AgentAgentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new AgentAgent(name, id, state, options);
    }
}
