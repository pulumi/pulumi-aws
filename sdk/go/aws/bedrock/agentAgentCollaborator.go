// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package bedrock

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS Bedrock Agents Agent Collaborator.
//
// ## Example Usage
//
// ### Basic Usage
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/bedrock"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
// func main() {
// pulumi.Run(func(ctx *pulumi.Context) error {
// current, err := aws.GetCallerIdentity(ctx, &aws.GetCallerIdentityArgs{
// }, nil);
// if err != nil {
// return err
// }
// currentGetPartition, err := aws.GetPartition(ctx, &aws.GetPartitionArgs{
// }, nil);
// if err != nil {
// return err
// }
// currentGetRegion, err := aws.GetRegion(ctx, &aws.GetRegionArgs{
// }, nil);
// if err != nil {
// return err
// }
// exampleAgentTrust, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
// Statements: []iam.GetPolicyDocumentStatement{
// {
// Actions: []string{
// "sts:AssumeRole",
// },
// Principals: []iam.GetPolicyDocumentStatementPrincipal{
// {
// Identifiers: []string{
// "bedrock.amazonaws.com",
// },
// Type: "Service",
// },
// },
// Conditions: []iam.GetPolicyDocumentStatementCondition{
// {
// Test: "StringEquals",
// Values: interface{}{
// current.AccountId,
// },
// Variable: "aws:SourceAccount",
// },
// {
// Test: "ArnLike",
// Values: []string{
// fmt.Sprintf("arn:%v:bedrock:%v:%v:agent/*", currentGetPartition.Partition, currentGetRegion.Name, current.AccountId),
// },
// Variable: "AWS:SourceArn",
// },
// },
// },
// },
// }, nil);
// if err != nil {
// return err
// }
// exampleAgentPermissions, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
// Statements: []iam.GetPolicyDocumentStatement{
// {
// Actions: []string{
// "bedrock:InvokeModel",
// },
// Resources: []string{
// fmt.Sprintf("arn:%v:bedrock:%v::foundation-model/anthropic.claude-3-5-sonnet-20241022-v2:0", currentGetPartition.Partition, currentGetRegion.Name),
// },
// },
// {
// Actions: []string{
// "bedrock:GetAgentAlias",
// "bedrock:InvokeAgent",
// },
// Resources: []string{
// fmt.Sprintf("arn:%v:bedrock:%v:%v:agent/*", currentAgent.Partition, currentGetRegion.Name, current.AccountId),
// fmt.Sprintf("arn:%v:bedrock:%v:%v:agent-alias/*", currentAgent.Partition, currentGetRegion.Name, current.AccountId),
// },
// },
// },
// }, nil);
// if err != nil {
// return err
// }
// example, err := iam.NewRole(ctx, "example", &iam.RoleArgs{
// AssumeRolePolicy: pulumi.String(exampleAgentTrust.Json),
// NamePrefix: pulumi.String("AmazonBedrockExecutionRoleForAgents_"),
// })
// if err != nil {
// return err
// }
// _, err = iam.NewRolePolicy(ctx, "example", &iam.RolePolicyArgs{
// Policy: pulumi.String(exampleAgentPermissions.Json),
// Role: example.ID(),
// })
// if err != nil {
// return err
// }
// exampleCollaborator, err := bedrock.NewAgentAgent(ctx, "example_collaborator", &bedrock.AgentAgentArgs{
// AgentName: pulumi.String("my-agent-collaborator"),
// AgentResourceRoleArn: example.Arn,
// IdleSessionTtlInSeconds: pulumi.Int(500),
// FoundationModel: pulumi.String("anthropic.claude-3-5-sonnet-20241022-v2:0"),
// Instruction: pulumi.String("do what the supervisor tells you to do"),
// })
// if err != nil {
// return err
// }
// exampleSupervisor, err := bedrock.NewAgentAgent(ctx, "example_supervisor", &bedrock.AgentAgentArgs{
// AgentName: pulumi.String("my-agent-supervisor"),
// AgentResourceRoleArn: example.Arn,
// AgentCollaboration: pulumi.String("SUPERVISOR"),
// IdleSessionTtlInSeconds: pulumi.Int(500),
// FoundationModel: pulumi.String("anthropic.claude-3-5-sonnet-20241022-v2:0"),
// Instruction: pulumi.String("tell the sub agent what to do"),
// PrepareAgent: pulumi.Bool(false),
// })
// if err != nil {
// return err
// }
// exampleAgentAgentAlias, err := bedrock.NewAgentAgentAlias(ctx, "example", &bedrock.AgentAgentAliasArgs{
// AgentAliasName: pulumi.String("my-agent-alias"),
// AgentId: exampleCollaborator.AgentId,
// Description: pulumi.String("Test Alias"),
// })
// if err != nil {
// return err
// }
// _, err = bedrock.NewAgentAgentCollaborator(ctx, "example", &bedrock.AgentAgentCollaboratorArgs{
// AgentId: exampleSupervisor.AgentId,
// CollaborationInstruction: pulumi.String("tell the other agent what to do"),
// CollaboratorName: pulumi.String("my-collab-example"),
// RelayConversationHistory: pulumi.String("TO_COLLABORATOR"),
// AgentDescriptor: &bedrock.AgentAgentCollaboratorAgentDescriptorArgs{
// AliasArn: exampleAgentAgentAlias.AgentAliasArn,
// },
// })
// if err != nil {
// return err
// }
// return nil
// })
// }
// ```
//
// ## Import
//
// Using `pulumi import`, import Bedrock Agents Agent Collaborator using a comma-delimited string combining `agent_id`, `agent_version`, and `collaborator_id`. For example:
//
// ```sh
// $ pulumi import aws:bedrock/agentAgentCollaborator:AgentAgentCollaborator example 9LSJO0BFI8,DRAFT,AG3TN4RQIY
// ```
type AgentAgentCollaborator struct {
	pulumi.CustomResourceState

	AgentDescriptor AgentAgentCollaboratorAgentDescriptorPtrOutput `pulumi:"agentDescriptor"`
	// ID if the agent to associate the collaborator.
	AgentId      pulumi.StringOutput `pulumi:"agentId"`
	AgentVersion pulumi.StringOutput `pulumi:"agentVersion"`
	// Instruction to give the collaborator.
	CollaborationInstruction pulumi.StringOutput `pulumi:"collaborationInstruction"`
	// ID of the Agent Collaborator.
	CollaboratorId   pulumi.StringOutput `pulumi:"collaboratorId"`
	CollaboratorName pulumi.StringOutput `pulumi:"collaboratorName"`
	// Whether to prepare the agent after creation or modification. Defaults to `true`.
	PrepareAgent pulumi.BoolOutput `pulumi:"prepareAgent"`
	// Configure relaying the history to the collaborator.
	RelayConversationHistory pulumi.StringOutput                     `pulumi:"relayConversationHistory"`
	Timeouts                 AgentAgentCollaboratorTimeoutsPtrOutput `pulumi:"timeouts"`
}

// NewAgentAgentCollaborator registers a new resource with the given unique name, arguments, and options.
func NewAgentAgentCollaborator(ctx *pulumi.Context,
	name string, args *AgentAgentCollaboratorArgs, opts ...pulumi.ResourceOption) (*AgentAgentCollaborator, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.AgentId == nil {
		return nil, errors.New("invalid value for required argument 'AgentId'")
	}
	if args.CollaborationInstruction == nil {
		return nil, errors.New("invalid value for required argument 'CollaborationInstruction'")
	}
	if args.CollaboratorName == nil {
		return nil, errors.New("invalid value for required argument 'CollaboratorName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource AgentAgentCollaborator
	err := ctx.RegisterResource("aws:bedrock/agentAgentCollaborator:AgentAgentCollaborator", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAgentAgentCollaborator gets an existing AgentAgentCollaborator resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAgentAgentCollaborator(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AgentAgentCollaboratorState, opts ...pulumi.ResourceOption) (*AgentAgentCollaborator, error) {
	var resource AgentAgentCollaborator
	err := ctx.ReadResource("aws:bedrock/agentAgentCollaborator:AgentAgentCollaborator", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering AgentAgentCollaborator resources.
type agentAgentCollaboratorState struct {
	AgentDescriptor *AgentAgentCollaboratorAgentDescriptor `pulumi:"agentDescriptor"`
	// ID if the agent to associate the collaborator.
	AgentId      *string `pulumi:"agentId"`
	AgentVersion *string `pulumi:"agentVersion"`
	// Instruction to give the collaborator.
	CollaborationInstruction *string `pulumi:"collaborationInstruction"`
	// ID of the Agent Collaborator.
	CollaboratorId   *string `pulumi:"collaboratorId"`
	CollaboratorName *string `pulumi:"collaboratorName"`
	// Whether to prepare the agent after creation or modification. Defaults to `true`.
	PrepareAgent *bool `pulumi:"prepareAgent"`
	// Configure relaying the history to the collaborator.
	RelayConversationHistory *string                         `pulumi:"relayConversationHistory"`
	Timeouts                 *AgentAgentCollaboratorTimeouts `pulumi:"timeouts"`
}

type AgentAgentCollaboratorState struct {
	AgentDescriptor AgentAgentCollaboratorAgentDescriptorPtrInput
	// ID if the agent to associate the collaborator.
	AgentId      pulumi.StringPtrInput
	AgentVersion pulumi.StringPtrInput
	// Instruction to give the collaborator.
	CollaborationInstruction pulumi.StringPtrInput
	// ID of the Agent Collaborator.
	CollaboratorId   pulumi.StringPtrInput
	CollaboratorName pulumi.StringPtrInput
	// Whether to prepare the agent after creation or modification. Defaults to `true`.
	PrepareAgent pulumi.BoolPtrInput
	// Configure relaying the history to the collaborator.
	RelayConversationHistory pulumi.StringPtrInput
	Timeouts                 AgentAgentCollaboratorTimeoutsPtrInput
}

func (AgentAgentCollaboratorState) ElementType() reflect.Type {
	return reflect.TypeOf((*agentAgentCollaboratorState)(nil)).Elem()
}

type agentAgentCollaboratorArgs struct {
	AgentDescriptor *AgentAgentCollaboratorAgentDescriptor `pulumi:"agentDescriptor"`
	// ID if the agent to associate the collaborator.
	AgentId      string  `pulumi:"agentId"`
	AgentVersion *string `pulumi:"agentVersion"`
	// Instruction to give the collaborator.
	CollaborationInstruction string `pulumi:"collaborationInstruction"`
	CollaboratorName         string `pulumi:"collaboratorName"`
	// Whether to prepare the agent after creation or modification. Defaults to `true`.
	PrepareAgent *bool `pulumi:"prepareAgent"`
	// Configure relaying the history to the collaborator.
	RelayConversationHistory *string                         `pulumi:"relayConversationHistory"`
	Timeouts                 *AgentAgentCollaboratorTimeouts `pulumi:"timeouts"`
}

// The set of arguments for constructing a AgentAgentCollaborator resource.
type AgentAgentCollaboratorArgs struct {
	AgentDescriptor AgentAgentCollaboratorAgentDescriptorPtrInput
	// ID if the agent to associate the collaborator.
	AgentId      pulumi.StringInput
	AgentVersion pulumi.StringPtrInput
	// Instruction to give the collaborator.
	CollaborationInstruction pulumi.StringInput
	CollaboratorName         pulumi.StringInput
	// Whether to prepare the agent after creation or modification. Defaults to `true`.
	PrepareAgent pulumi.BoolPtrInput
	// Configure relaying the history to the collaborator.
	RelayConversationHistory pulumi.StringPtrInput
	Timeouts                 AgentAgentCollaboratorTimeoutsPtrInput
}

func (AgentAgentCollaboratorArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*agentAgentCollaboratorArgs)(nil)).Elem()
}

type AgentAgentCollaboratorInput interface {
	pulumi.Input

	ToAgentAgentCollaboratorOutput() AgentAgentCollaboratorOutput
	ToAgentAgentCollaboratorOutputWithContext(ctx context.Context) AgentAgentCollaboratorOutput
}

func (*AgentAgentCollaborator) ElementType() reflect.Type {
	return reflect.TypeOf((**AgentAgentCollaborator)(nil)).Elem()
}

func (i *AgentAgentCollaborator) ToAgentAgentCollaboratorOutput() AgentAgentCollaboratorOutput {
	return i.ToAgentAgentCollaboratorOutputWithContext(context.Background())
}

func (i *AgentAgentCollaborator) ToAgentAgentCollaboratorOutputWithContext(ctx context.Context) AgentAgentCollaboratorOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AgentAgentCollaboratorOutput)
}

// AgentAgentCollaboratorArrayInput is an input type that accepts AgentAgentCollaboratorArray and AgentAgentCollaboratorArrayOutput values.
// You can construct a concrete instance of `AgentAgentCollaboratorArrayInput` via:
//
//	AgentAgentCollaboratorArray{ AgentAgentCollaboratorArgs{...} }
type AgentAgentCollaboratorArrayInput interface {
	pulumi.Input

	ToAgentAgentCollaboratorArrayOutput() AgentAgentCollaboratorArrayOutput
	ToAgentAgentCollaboratorArrayOutputWithContext(context.Context) AgentAgentCollaboratorArrayOutput
}

type AgentAgentCollaboratorArray []AgentAgentCollaboratorInput

func (AgentAgentCollaboratorArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AgentAgentCollaborator)(nil)).Elem()
}

func (i AgentAgentCollaboratorArray) ToAgentAgentCollaboratorArrayOutput() AgentAgentCollaboratorArrayOutput {
	return i.ToAgentAgentCollaboratorArrayOutputWithContext(context.Background())
}

func (i AgentAgentCollaboratorArray) ToAgentAgentCollaboratorArrayOutputWithContext(ctx context.Context) AgentAgentCollaboratorArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AgentAgentCollaboratorArrayOutput)
}

// AgentAgentCollaboratorMapInput is an input type that accepts AgentAgentCollaboratorMap and AgentAgentCollaboratorMapOutput values.
// You can construct a concrete instance of `AgentAgentCollaboratorMapInput` via:
//
//	AgentAgentCollaboratorMap{ "key": AgentAgentCollaboratorArgs{...} }
type AgentAgentCollaboratorMapInput interface {
	pulumi.Input

	ToAgentAgentCollaboratorMapOutput() AgentAgentCollaboratorMapOutput
	ToAgentAgentCollaboratorMapOutputWithContext(context.Context) AgentAgentCollaboratorMapOutput
}

type AgentAgentCollaboratorMap map[string]AgentAgentCollaboratorInput

func (AgentAgentCollaboratorMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AgentAgentCollaborator)(nil)).Elem()
}

func (i AgentAgentCollaboratorMap) ToAgentAgentCollaboratorMapOutput() AgentAgentCollaboratorMapOutput {
	return i.ToAgentAgentCollaboratorMapOutputWithContext(context.Background())
}

func (i AgentAgentCollaboratorMap) ToAgentAgentCollaboratorMapOutputWithContext(ctx context.Context) AgentAgentCollaboratorMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AgentAgentCollaboratorMapOutput)
}

type AgentAgentCollaboratorOutput struct{ *pulumi.OutputState }

func (AgentAgentCollaboratorOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AgentAgentCollaborator)(nil)).Elem()
}

func (o AgentAgentCollaboratorOutput) ToAgentAgentCollaboratorOutput() AgentAgentCollaboratorOutput {
	return o
}

func (o AgentAgentCollaboratorOutput) ToAgentAgentCollaboratorOutputWithContext(ctx context.Context) AgentAgentCollaboratorOutput {
	return o
}

func (o AgentAgentCollaboratorOutput) AgentDescriptor() AgentAgentCollaboratorAgentDescriptorPtrOutput {
	return o.ApplyT(func(v *AgentAgentCollaborator) AgentAgentCollaboratorAgentDescriptorPtrOutput {
		return v.AgentDescriptor
	}).(AgentAgentCollaboratorAgentDescriptorPtrOutput)
}

// ID if the agent to associate the collaborator.
func (o AgentAgentCollaboratorOutput) AgentId() pulumi.StringOutput {
	return o.ApplyT(func(v *AgentAgentCollaborator) pulumi.StringOutput { return v.AgentId }).(pulumi.StringOutput)
}

func (o AgentAgentCollaboratorOutput) AgentVersion() pulumi.StringOutput {
	return o.ApplyT(func(v *AgentAgentCollaborator) pulumi.StringOutput { return v.AgentVersion }).(pulumi.StringOutput)
}

// Instruction to give the collaborator.
func (o AgentAgentCollaboratorOutput) CollaborationInstruction() pulumi.StringOutput {
	return o.ApplyT(func(v *AgentAgentCollaborator) pulumi.StringOutput { return v.CollaborationInstruction }).(pulumi.StringOutput)
}

// ID of the Agent Collaborator.
func (o AgentAgentCollaboratorOutput) CollaboratorId() pulumi.StringOutput {
	return o.ApplyT(func(v *AgentAgentCollaborator) pulumi.StringOutput { return v.CollaboratorId }).(pulumi.StringOutput)
}

func (o AgentAgentCollaboratorOutput) CollaboratorName() pulumi.StringOutput {
	return o.ApplyT(func(v *AgentAgentCollaborator) pulumi.StringOutput { return v.CollaboratorName }).(pulumi.StringOutput)
}

// Whether to prepare the agent after creation or modification. Defaults to `true`.
func (o AgentAgentCollaboratorOutput) PrepareAgent() pulumi.BoolOutput {
	return o.ApplyT(func(v *AgentAgentCollaborator) pulumi.BoolOutput { return v.PrepareAgent }).(pulumi.BoolOutput)
}

// Configure relaying the history to the collaborator.
func (o AgentAgentCollaboratorOutput) RelayConversationHistory() pulumi.StringOutput {
	return o.ApplyT(func(v *AgentAgentCollaborator) pulumi.StringOutput { return v.RelayConversationHistory }).(pulumi.StringOutput)
}

func (o AgentAgentCollaboratorOutput) Timeouts() AgentAgentCollaboratorTimeoutsPtrOutput {
	return o.ApplyT(func(v *AgentAgentCollaborator) AgentAgentCollaboratorTimeoutsPtrOutput { return v.Timeouts }).(AgentAgentCollaboratorTimeoutsPtrOutput)
}

type AgentAgentCollaboratorArrayOutput struct{ *pulumi.OutputState }

func (AgentAgentCollaboratorArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AgentAgentCollaborator)(nil)).Elem()
}

func (o AgentAgentCollaboratorArrayOutput) ToAgentAgentCollaboratorArrayOutput() AgentAgentCollaboratorArrayOutput {
	return o
}

func (o AgentAgentCollaboratorArrayOutput) ToAgentAgentCollaboratorArrayOutputWithContext(ctx context.Context) AgentAgentCollaboratorArrayOutput {
	return o
}

func (o AgentAgentCollaboratorArrayOutput) Index(i pulumi.IntInput) AgentAgentCollaboratorOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *AgentAgentCollaborator {
		return vs[0].([]*AgentAgentCollaborator)[vs[1].(int)]
	}).(AgentAgentCollaboratorOutput)
}

type AgentAgentCollaboratorMapOutput struct{ *pulumi.OutputState }

func (AgentAgentCollaboratorMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AgentAgentCollaborator)(nil)).Elem()
}

func (o AgentAgentCollaboratorMapOutput) ToAgentAgentCollaboratorMapOutput() AgentAgentCollaboratorMapOutput {
	return o
}

func (o AgentAgentCollaboratorMapOutput) ToAgentAgentCollaboratorMapOutputWithContext(ctx context.Context) AgentAgentCollaboratorMapOutput {
	return o
}

func (o AgentAgentCollaboratorMapOutput) MapIndex(k pulumi.StringInput) AgentAgentCollaboratorOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *AgentAgentCollaborator {
		return vs[0].(map[string]*AgentAgentCollaborator)[vs[1].(string)]
	}).(AgentAgentCollaboratorOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AgentAgentCollaboratorInput)(nil)).Elem(), &AgentAgentCollaborator{})
	pulumi.RegisterInputType(reflect.TypeOf((*AgentAgentCollaboratorArrayInput)(nil)).Elem(), AgentAgentCollaboratorArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AgentAgentCollaboratorMapInput)(nil)).Elem(), AgentAgentCollaboratorMap{})
	pulumi.RegisterOutputType(AgentAgentCollaboratorOutput{})
	pulumi.RegisterOutputType(AgentAgentCollaboratorArrayOutput{})
	pulumi.RegisterOutputType(AgentAgentCollaboratorMapOutput{})
}
