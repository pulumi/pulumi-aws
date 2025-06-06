// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.bedrock.AgentAgentCollaboratorArgs;
import com.pulumi.aws.bedrock.inputs.AgentAgentCollaboratorState;
import com.pulumi.aws.bedrock.outputs.AgentAgentCollaboratorAgentDescriptor;
import com.pulumi.aws.bedrock.outputs.AgentAgentCollaboratorTimeouts;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS Bedrock Agents Agent Collaborator.
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
 * import com.pulumi.aws.bedrock.AgentAgentAlias;
 * import com.pulumi.aws.bedrock.AgentAgentAliasArgs;
 * import com.pulumi.aws.bedrock.AgentAgentCollaborator;
 * import com.pulumi.aws.bedrock.AgentAgentCollaboratorArgs;
 * import com.pulumi.aws.bedrock.inputs.AgentAgentCollaboratorAgentDescriptorArgs;
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
 *             .statements(            
 *                 GetPolicyDocumentStatementArgs.builder()
 *                     .actions("bedrock:InvokeModel")
 *                     .resources(String.format("arn:%s:bedrock:%s::foundation-model/anthropic.claude-3-5-sonnet-20241022-v2:0", currentGetPartition.partition(),currentGetRegion.name()))
 *                     .build(),
 *                 GetPolicyDocumentStatementArgs.builder()
 *                     .actions(                    
 *                         "bedrock:GetAgentAlias",
 *                         "bedrock:InvokeAgent")
 *                     .resources(                    
 *                         String.format("arn:%s:bedrock:%s:%s:agent/*", currentAgent.partition(),currentGetRegion.name(),current.accountId()),
 *                         String.format("arn:%s:bedrock:%s:%s:agent-alias/*", currentAgent.partition(),currentGetRegion.name(),current.accountId()))
 *                     .build())
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
 *         var exampleCollaborator = new AgentAgent("exampleCollaborator", AgentAgentArgs.builder()
 *             .agentName("my-agent-collaborator")
 *             .agentResourceRoleArn(example.arn())
 *             .idleSessionTtlInSeconds(500)
 *             .foundationModel("anthropic.claude-3-5-sonnet-20241022-v2:0")
 *             .instruction("do what the supervisor tells you to do")
 *             .build());
 * 
 *         var exampleSupervisor = new AgentAgent("exampleSupervisor", AgentAgentArgs.builder()
 *             .agentName("my-agent-supervisor")
 *             .agentResourceRoleArn(example.arn())
 *             .agentCollaboration("SUPERVISOR")
 *             .idleSessionTtlInSeconds(500)
 *             .foundationModel("anthropic.claude-3-5-sonnet-20241022-v2:0")
 *             .instruction("tell the sub agent what to do")
 *             .prepareAgent(false)
 *             .build());
 * 
 *         var exampleAgentAgentAlias = new AgentAgentAlias("exampleAgentAgentAlias", AgentAgentAliasArgs.builder()
 *             .agentAliasName("my-agent-alias")
 *             .agentId(exampleCollaborator.agentId())
 *             .description("Test Alias")
 *             .build());
 * 
 *         var exampleAgentAgentCollaborator = new AgentAgentCollaborator("exampleAgentAgentCollaborator", AgentAgentCollaboratorArgs.builder()
 *             .agentId(exampleSupervisor.agentId())
 *             .collaborationInstruction("tell the other agent what to do")
 *             .collaboratorName("my-collab-example")
 *             .relayConversationHistory("TO_COLLABORATOR")
 *             .agentDescriptor(AgentAgentCollaboratorAgentDescriptorArgs.builder()
 *                 .aliasArn(exampleAgentAgentAlias.agentAliasArn())
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
 * Using `pulumi import`, import Bedrock Agents Agent Collaborator using a comma-delimited string combining `agent_id`, `agent_version`, and `collaborator_id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:bedrock/agentAgentCollaborator:AgentAgentCollaborator example 9LSJO0BFI8,DRAFT,AG3TN4RQIY
 * ```
 * 
 */
@ResourceType(type="aws:bedrock/agentAgentCollaborator:AgentAgentCollaborator")
public class AgentAgentCollaborator extends com.pulumi.resources.CustomResource {
    @Export(name="agentDescriptor", refs={AgentAgentCollaboratorAgentDescriptor.class}, tree="[0]")
    private Output</* @Nullable */ AgentAgentCollaboratorAgentDescriptor> agentDescriptor;

    public Output<Optional<AgentAgentCollaboratorAgentDescriptor>> agentDescriptor() {
        return Codegen.optional(this.agentDescriptor);
    }
    /**
     * ID if the agent to associate the collaborator.
     * 
     */
    @Export(name="agentId", refs={String.class}, tree="[0]")
    private Output<String> agentId;

    /**
     * @return ID if the agent to associate the collaborator.
     * 
     */
    public Output<String> agentId() {
        return this.agentId;
    }
    @Export(name="agentVersion", refs={String.class}, tree="[0]")
    private Output<String> agentVersion;

    public Output<String> agentVersion() {
        return this.agentVersion;
    }
    /**
     * Instruction to give the collaborator.
     * 
     */
    @Export(name="collaborationInstruction", refs={String.class}, tree="[0]")
    private Output<String> collaborationInstruction;

    /**
     * @return Instruction to give the collaborator.
     * 
     */
    public Output<String> collaborationInstruction() {
        return this.collaborationInstruction;
    }
    /**
     * ID of the Agent Collaborator.
     * 
     */
    @Export(name="collaboratorId", refs={String.class}, tree="[0]")
    private Output<String> collaboratorId;

    /**
     * @return ID of the Agent Collaborator.
     * 
     */
    public Output<String> collaboratorId() {
        return this.collaboratorId;
    }
    @Export(name="collaboratorName", refs={String.class}, tree="[0]")
    private Output<String> collaboratorName;

    public Output<String> collaboratorName() {
        return this.collaboratorName;
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
     * Configure relaying the history to the collaborator.
     * 
     */
    @Export(name="relayConversationHistory", refs={String.class}, tree="[0]")
    private Output<String> relayConversationHistory;

    /**
     * @return Configure relaying the history to the collaborator.
     * 
     */
    public Output<String> relayConversationHistory() {
        return this.relayConversationHistory;
    }
    @Export(name="timeouts", refs={AgentAgentCollaboratorTimeouts.class}, tree="[0]")
    private Output</* @Nullable */ AgentAgentCollaboratorTimeouts> timeouts;

    public Output<Optional<AgentAgentCollaboratorTimeouts>> timeouts() {
        return Codegen.optional(this.timeouts);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public AgentAgentCollaborator(java.lang.String name) {
        this(name, AgentAgentCollaboratorArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public AgentAgentCollaborator(java.lang.String name, AgentAgentCollaboratorArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public AgentAgentCollaborator(java.lang.String name, AgentAgentCollaboratorArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:bedrock/agentAgentCollaborator:AgentAgentCollaborator", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private AgentAgentCollaborator(java.lang.String name, Output<java.lang.String> id, @Nullable AgentAgentCollaboratorState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:bedrock/agentAgentCollaborator:AgentAgentCollaborator", name, state, makeResourceOptions(options, id), false);
    }

    private static AgentAgentCollaboratorArgs makeArgs(AgentAgentCollaboratorArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? AgentAgentCollaboratorArgs.Empty : args;
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
    public static AgentAgentCollaborator get(java.lang.String name, Output<java.lang.String> id, @Nullable AgentAgentCollaboratorState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new AgentAgentCollaborator(name, id, state, options);
    }
}
