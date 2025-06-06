// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package lex

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an Amazon Lex Intent resource. For more information see
// [Amazon Lex: How It Works](https://docs.aws.amazon.com/lex/latest/dg/how-it-works.html)
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lex"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := lex.NewIntent(ctx, "order_flowers_intent", &lex.IntentArgs{
//				ConfirmationPrompt: &lex.IntentConfirmationPromptArgs{
//					MaxAttempts: pulumi.Int(2),
//					Messages: lex.IntentConfirmationPromptMessageArray{
//						&lex.IntentConfirmationPromptMessageArgs{
//							Content:     pulumi.String("Okay, your {FlowerType} will be ready for pickup by {PickupTime} on {PickupDate}.  Does this sound okay?"),
//							ContentType: pulumi.String("PlainText"),
//						},
//					},
//				},
//				CreateVersion: pulumi.Bool(false),
//				Name:          pulumi.String("OrderFlowers"),
//				Description:   pulumi.String("Intent to order a bouquet of flowers for pick up"),
//				FulfillmentActivity: &lex.IntentFulfillmentActivityArgs{
//					Type: pulumi.String("ReturnIntent"),
//				},
//				RejectionStatement: &lex.IntentRejectionStatementArgs{
//					Messages: lex.IntentRejectionStatementMessageArray{
//						&lex.IntentRejectionStatementMessageArgs{
//							Content:     pulumi.String("Okay, I will not place your order."),
//							ContentType: pulumi.String("PlainText"),
//						},
//					},
//				},
//				SampleUtterances: pulumi.StringArray{
//					pulumi.String("I would like to order some flowers"),
//					pulumi.String("I would like to pick up flowers"),
//				},
//				Slots: lex.IntentSlotArray{
//					&lex.IntentSlotArgs{
//						Description: pulumi.String("The type of flowers to pick up"),
//						Name:        pulumi.String("FlowerType"),
//						Priority:    pulumi.Int(1),
//						SampleUtterances: pulumi.StringArray{
//							pulumi.String("I would like to order {FlowerType}"),
//						},
//						SlotConstraint:  pulumi.String("Required"),
//						SlotType:        pulumi.String("FlowerTypes"),
//						SlotTypeVersion: pulumi.String("$$LATEST"),
//						ValueElicitationPrompt: &lex.IntentSlotValueElicitationPromptArgs{
//							MaxAttempts: pulumi.Int(2),
//							Messages: lex.IntentSlotValueElicitationPromptMessageArray{
//								&lex.IntentSlotValueElicitationPromptMessageArgs{
//									Content:     pulumi.String("What type of flowers would you like to order?"),
//									ContentType: pulumi.String("PlainText"),
//								},
//							},
//						},
//					},
//					&lex.IntentSlotArgs{
//						Description: pulumi.String("The date to pick up the flowers"),
//						Name:        pulumi.String("PickupDate"),
//						Priority:    pulumi.Int(2),
//						SampleUtterances: pulumi.StringArray{
//							pulumi.String("I would like to order {FlowerType}"),
//						},
//						SlotConstraint:  pulumi.String("Required"),
//						SlotType:        pulumi.String("AMAZON.DATE"),
//						SlotTypeVersion: pulumi.String("$$LATEST"),
//						ValueElicitationPrompt: &lex.IntentSlotValueElicitationPromptArgs{
//							MaxAttempts: pulumi.Int(2),
//							Messages: lex.IntentSlotValueElicitationPromptMessageArray{
//								&lex.IntentSlotValueElicitationPromptMessageArgs{
//									Content:     pulumi.String("What day do you want the {FlowerType} to be picked up?"),
//									ContentType: pulumi.String("PlainText"),
//								},
//							},
//						},
//					},
//					&lex.IntentSlotArgs{
//						Description: pulumi.String("The time to pick up the flowers"),
//						Name:        pulumi.String("PickupTime"),
//						Priority:    pulumi.Int(3),
//						SampleUtterances: pulumi.StringArray{
//							pulumi.String("I would like to order {FlowerType}"),
//						},
//						SlotConstraint:  pulumi.String("Required"),
//						SlotType:        pulumi.String("AMAZON.TIME"),
//						SlotTypeVersion: pulumi.String("$$LATEST"),
//						ValueElicitationPrompt: &lex.IntentSlotValueElicitationPromptArgs{
//							MaxAttempts: pulumi.Int(2),
//							Messages: lex.IntentSlotValueElicitationPromptMessageArray{
//								&lex.IntentSlotValueElicitationPromptMessageArgs{
//									Content:     pulumi.String("Pick up the {FlowerType} at what time on {PickupDate}?"),
//									ContentType: pulumi.String("PlainText"),
//								},
//							},
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ## Import
//
// Using `pulumi import`, import intents using their name. For example:
//
// ```sh
// $ pulumi import aws:lex/intent:Intent order_flowers_intent OrderFlowers
// ```
type Intent struct {
	pulumi.CustomResourceState

	// The ARN of the Lex intent.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Checksum identifying the version of the intent that was created. The checksum is not
	// included as an argument because the resource will add it automatically when updating the intent.
	Checksum pulumi.StringOutput `pulumi:"checksum"`
	// The statement that you want Amazon Lex to convey to the user
	// after the intent is successfully fulfilled by the Lambda function. This element is relevant only if
	// you provide a Lambda function in the `fulfillmentActivity`. If you return the intent to the client
	// application, you can't specify this element. The `followUpPrompt` and `conclusionStatement` are
	// mutually exclusive. You can specify only one. Attributes are documented under statement.
	ConclusionStatement IntentConclusionStatementPtrOutput `pulumi:"conclusionStatement"`
	// Prompts the user to confirm the intent. This question should
	// have a yes or no answer. You you must provide both the `rejectionStatement` and `confirmationPrompt`,
	// or neither. Attributes are documented under prompt.
	ConfirmationPrompt IntentConfirmationPromptPtrOutput `pulumi:"confirmationPrompt"`
	// Determines if a new slot type version is created when the initial
	// resource is created and on each update. Defaults to `false`.
	CreateVersion pulumi.BoolPtrOutput `pulumi:"createVersion"`
	// The date when the intent version was created.
	CreatedDate pulumi.StringOutput `pulumi:"createdDate"`
	// A description of the intent. Must be less than or equal to 200 characters in length.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// Specifies a Lambda function to invoke for each user input. You can
	// invoke this Lambda function to personalize user interaction. Attributes are documented under code_hook.
	DialogCodeHook IntentDialogCodeHookPtrOutput `pulumi:"dialogCodeHook"`
	// Amazon Lex uses this prompt to solicit additional activity after
	// fulfilling an intent. For example, after the OrderPizza intent is fulfilled, you might prompt the
	// user to order a drink. The `followUpPrompt` field and the `conclusionStatement` field are mutually
	// exclusive. You can specify only one. Attributes are documented under follow_up_prompt.
	FollowUpPrompt IntentFollowUpPromptPtrOutput `pulumi:"followUpPrompt"`
	// Describes how the intent is fulfilled. For example, after a
	// user provides all of the information for a pizza order, `fulfillmentActivity` defines how the bot
	// places an order with a local pizza store. Attributes are documented under fulfillment_activity.
	FulfillmentActivity IntentFulfillmentActivityOutput `pulumi:"fulfillmentActivity"`
	// The date when the $LATEST version of this intent was updated.
	LastUpdatedDate pulumi.StringOutput `pulumi:"lastUpdatedDate"`
	// The name of the intent, not case sensitive. Must be less than or equal to 100 characters in length.
	Name pulumi.StringOutput `pulumi:"name"`
	// A unique identifier for the built-in intent to base this
	// intent on. To find the signature for an intent, see
	// [Standard Built-in Intents](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/built-in-intent-ref/standard-intents)
	// in the Alexa Skills Kit.
	ParentIntentSignature pulumi.StringPtrOutput `pulumi:"parentIntentSignature"`
	// When the user answers "no" to the question defined in
	// `confirmationPrompt`, Amazon Lex responds with this statement to acknowledge that the intent was
	// canceled. You must provide both the `rejectionStatement` and the `confirmationPrompt`, or neither.
	// Attributes are documented under statement.
	RejectionStatement IntentRejectionStatementPtrOutput `pulumi:"rejectionStatement"`
	// An array of utterances (strings) that a user might say to signal
	// the intent. For example, "I want {PizzaSize} pizza", "Order {Quantity} {PizzaSize} pizzas".
	// In each utterance, a slot name is enclosed in curly braces. Must have between 1 and 10 items in the list, and each item must be less than or equal to 200 characters in length.
	SampleUtterances pulumi.StringArrayOutput `pulumi:"sampleUtterances"`
	// An list of intent slots. At runtime, Amazon Lex elicits required slot values
	// from the user using prompts defined in the slots. Attributes are documented under slot.
	Slots IntentSlotArrayOutput `pulumi:"slots"`
	// The version of the bot.
	Version pulumi.StringOutput `pulumi:"version"`
}

// NewIntent registers a new resource with the given unique name, arguments, and options.
func NewIntent(ctx *pulumi.Context,
	name string, args *IntentArgs, opts ...pulumi.ResourceOption) (*Intent, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.FulfillmentActivity == nil {
		return nil, errors.New("invalid value for required argument 'FulfillmentActivity'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Intent
	err := ctx.RegisterResource("aws:lex/intent:Intent", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetIntent gets an existing Intent resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetIntent(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *IntentState, opts ...pulumi.ResourceOption) (*Intent, error) {
	var resource Intent
	err := ctx.ReadResource("aws:lex/intent:Intent", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Intent resources.
type intentState struct {
	// The ARN of the Lex intent.
	Arn *string `pulumi:"arn"`
	// Checksum identifying the version of the intent that was created. The checksum is not
	// included as an argument because the resource will add it automatically when updating the intent.
	Checksum *string `pulumi:"checksum"`
	// The statement that you want Amazon Lex to convey to the user
	// after the intent is successfully fulfilled by the Lambda function. This element is relevant only if
	// you provide a Lambda function in the `fulfillmentActivity`. If you return the intent to the client
	// application, you can't specify this element. The `followUpPrompt` and `conclusionStatement` are
	// mutually exclusive. You can specify only one. Attributes are documented under statement.
	ConclusionStatement *IntentConclusionStatement `pulumi:"conclusionStatement"`
	// Prompts the user to confirm the intent. This question should
	// have a yes or no answer. You you must provide both the `rejectionStatement` and `confirmationPrompt`,
	// or neither. Attributes are documented under prompt.
	ConfirmationPrompt *IntentConfirmationPrompt `pulumi:"confirmationPrompt"`
	// Determines if a new slot type version is created when the initial
	// resource is created and on each update. Defaults to `false`.
	CreateVersion *bool `pulumi:"createVersion"`
	// The date when the intent version was created.
	CreatedDate *string `pulumi:"createdDate"`
	// A description of the intent. Must be less than or equal to 200 characters in length.
	Description *string `pulumi:"description"`
	// Specifies a Lambda function to invoke for each user input. You can
	// invoke this Lambda function to personalize user interaction. Attributes are documented under code_hook.
	DialogCodeHook *IntentDialogCodeHook `pulumi:"dialogCodeHook"`
	// Amazon Lex uses this prompt to solicit additional activity after
	// fulfilling an intent. For example, after the OrderPizza intent is fulfilled, you might prompt the
	// user to order a drink. The `followUpPrompt` field and the `conclusionStatement` field are mutually
	// exclusive. You can specify only one. Attributes are documented under follow_up_prompt.
	FollowUpPrompt *IntentFollowUpPrompt `pulumi:"followUpPrompt"`
	// Describes how the intent is fulfilled. For example, after a
	// user provides all of the information for a pizza order, `fulfillmentActivity` defines how the bot
	// places an order with a local pizza store. Attributes are documented under fulfillment_activity.
	FulfillmentActivity *IntentFulfillmentActivity `pulumi:"fulfillmentActivity"`
	// The date when the $LATEST version of this intent was updated.
	LastUpdatedDate *string `pulumi:"lastUpdatedDate"`
	// The name of the intent, not case sensitive. Must be less than or equal to 100 characters in length.
	Name *string `pulumi:"name"`
	// A unique identifier for the built-in intent to base this
	// intent on. To find the signature for an intent, see
	// [Standard Built-in Intents](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/built-in-intent-ref/standard-intents)
	// in the Alexa Skills Kit.
	ParentIntentSignature *string `pulumi:"parentIntentSignature"`
	// When the user answers "no" to the question defined in
	// `confirmationPrompt`, Amazon Lex responds with this statement to acknowledge that the intent was
	// canceled. You must provide both the `rejectionStatement` and the `confirmationPrompt`, or neither.
	// Attributes are documented under statement.
	RejectionStatement *IntentRejectionStatement `pulumi:"rejectionStatement"`
	// An array of utterances (strings) that a user might say to signal
	// the intent. For example, "I want {PizzaSize} pizza", "Order {Quantity} {PizzaSize} pizzas".
	// In each utterance, a slot name is enclosed in curly braces. Must have between 1 and 10 items in the list, and each item must be less than or equal to 200 characters in length.
	SampleUtterances []string `pulumi:"sampleUtterances"`
	// An list of intent slots. At runtime, Amazon Lex elicits required slot values
	// from the user using prompts defined in the slots. Attributes are documented under slot.
	Slots []IntentSlot `pulumi:"slots"`
	// The version of the bot.
	Version *string `pulumi:"version"`
}

type IntentState struct {
	// The ARN of the Lex intent.
	Arn pulumi.StringPtrInput
	// Checksum identifying the version of the intent that was created. The checksum is not
	// included as an argument because the resource will add it automatically when updating the intent.
	Checksum pulumi.StringPtrInput
	// The statement that you want Amazon Lex to convey to the user
	// after the intent is successfully fulfilled by the Lambda function. This element is relevant only if
	// you provide a Lambda function in the `fulfillmentActivity`. If you return the intent to the client
	// application, you can't specify this element. The `followUpPrompt` and `conclusionStatement` are
	// mutually exclusive. You can specify only one. Attributes are documented under statement.
	ConclusionStatement IntentConclusionStatementPtrInput
	// Prompts the user to confirm the intent. This question should
	// have a yes or no answer. You you must provide both the `rejectionStatement` and `confirmationPrompt`,
	// or neither. Attributes are documented under prompt.
	ConfirmationPrompt IntentConfirmationPromptPtrInput
	// Determines if a new slot type version is created when the initial
	// resource is created and on each update. Defaults to `false`.
	CreateVersion pulumi.BoolPtrInput
	// The date when the intent version was created.
	CreatedDate pulumi.StringPtrInput
	// A description of the intent. Must be less than or equal to 200 characters in length.
	Description pulumi.StringPtrInput
	// Specifies a Lambda function to invoke for each user input. You can
	// invoke this Lambda function to personalize user interaction. Attributes are documented under code_hook.
	DialogCodeHook IntentDialogCodeHookPtrInput
	// Amazon Lex uses this prompt to solicit additional activity after
	// fulfilling an intent. For example, after the OrderPizza intent is fulfilled, you might prompt the
	// user to order a drink. The `followUpPrompt` field and the `conclusionStatement` field are mutually
	// exclusive. You can specify only one. Attributes are documented under follow_up_prompt.
	FollowUpPrompt IntentFollowUpPromptPtrInput
	// Describes how the intent is fulfilled. For example, after a
	// user provides all of the information for a pizza order, `fulfillmentActivity` defines how the bot
	// places an order with a local pizza store. Attributes are documented under fulfillment_activity.
	FulfillmentActivity IntentFulfillmentActivityPtrInput
	// The date when the $LATEST version of this intent was updated.
	LastUpdatedDate pulumi.StringPtrInput
	// The name of the intent, not case sensitive. Must be less than or equal to 100 characters in length.
	Name pulumi.StringPtrInput
	// A unique identifier for the built-in intent to base this
	// intent on. To find the signature for an intent, see
	// [Standard Built-in Intents](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/built-in-intent-ref/standard-intents)
	// in the Alexa Skills Kit.
	ParentIntentSignature pulumi.StringPtrInput
	// When the user answers "no" to the question defined in
	// `confirmationPrompt`, Amazon Lex responds with this statement to acknowledge that the intent was
	// canceled. You must provide both the `rejectionStatement` and the `confirmationPrompt`, or neither.
	// Attributes are documented under statement.
	RejectionStatement IntentRejectionStatementPtrInput
	// An array of utterances (strings) that a user might say to signal
	// the intent. For example, "I want {PizzaSize} pizza", "Order {Quantity} {PizzaSize} pizzas".
	// In each utterance, a slot name is enclosed in curly braces. Must have between 1 and 10 items in the list, and each item must be less than or equal to 200 characters in length.
	SampleUtterances pulumi.StringArrayInput
	// An list of intent slots. At runtime, Amazon Lex elicits required slot values
	// from the user using prompts defined in the slots. Attributes are documented under slot.
	Slots IntentSlotArrayInput
	// The version of the bot.
	Version pulumi.StringPtrInput
}

func (IntentState) ElementType() reflect.Type {
	return reflect.TypeOf((*intentState)(nil)).Elem()
}

type intentArgs struct {
	// The statement that you want Amazon Lex to convey to the user
	// after the intent is successfully fulfilled by the Lambda function. This element is relevant only if
	// you provide a Lambda function in the `fulfillmentActivity`. If you return the intent to the client
	// application, you can't specify this element. The `followUpPrompt` and `conclusionStatement` are
	// mutually exclusive. You can specify only one. Attributes are documented under statement.
	ConclusionStatement *IntentConclusionStatement `pulumi:"conclusionStatement"`
	// Prompts the user to confirm the intent. This question should
	// have a yes or no answer. You you must provide both the `rejectionStatement` and `confirmationPrompt`,
	// or neither. Attributes are documented under prompt.
	ConfirmationPrompt *IntentConfirmationPrompt `pulumi:"confirmationPrompt"`
	// Determines if a new slot type version is created when the initial
	// resource is created and on each update. Defaults to `false`.
	CreateVersion *bool `pulumi:"createVersion"`
	// A description of the intent. Must be less than or equal to 200 characters in length.
	Description *string `pulumi:"description"`
	// Specifies a Lambda function to invoke for each user input. You can
	// invoke this Lambda function to personalize user interaction. Attributes are documented under code_hook.
	DialogCodeHook *IntentDialogCodeHook `pulumi:"dialogCodeHook"`
	// Amazon Lex uses this prompt to solicit additional activity after
	// fulfilling an intent. For example, after the OrderPizza intent is fulfilled, you might prompt the
	// user to order a drink. The `followUpPrompt` field and the `conclusionStatement` field are mutually
	// exclusive. You can specify only one. Attributes are documented under follow_up_prompt.
	FollowUpPrompt *IntentFollowUpPrompt `pulumi:"followUpPrompt"`
	// Describes how the intent is fulfilled. For example, after a
	// user provides all of the information for a pizza order, `fulfillmentActivity` defines how the bot
	// places an order with a local pizza store. Attributes are documented under fulfillment_activity.
	FulfillmentActivity IntentFulfillmentActivity `pulumi:"fulfillmentActivity"`
	// The name of the intent, not case sensitive. Must be less than or equal to 100 characters in length.
	Name *string `pulumi:"name"`
	// A unique identifier for the built-in intent to base this
	// intent on. To find the signature for an intent, see
	// [Standard Built-in Intents](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/built-in-intent-ref/standard-intents)
	// in the Alexa Skills Kit.
	ParentIntentSignature *string `pulumi:"parentIntentSignature"`
	// When the user answers "no" to the question defined in
	// `confirmationPrompt`, Amazon Lex responds with this statement to acknowledge that the intent was
	// canceled. You must provide both the `rejectionStatement` and the `confirmationPrompt`, or neither.
	// Attributes are documented under statement.
	RejectionStatement *IntentRejectionStatement `pulumi:"rejectionStatement"`
	// An array of utterances (strings) that a user might say to signal
	// the intent. For example, "I want {PizzaSize} pizza", "Order {Quantity} {PizzaSize} pizzas".
	// In each utterance, a slot name is enclosed in curly braces. Must have between 1 and 10 items in the list, and each item must be less than or equal to 200 characters in length.
	SampleUtterances []string `pulumi:"sampleUtterances"`
	// An list of intent slots. At runtime, Amazon Lex elicits required slot values
	// from the user using prompts defined in the slots. Attributes are documented under slot.
	Slots []IntentSlot `pulumi:"slots"`
}

// The set of arguments for constructing a Intent resource.
type IntentArgs struct {
	// The statement that you want Amazon Lex to convey to the user
	// after the intent is successfully fulfilled by the Lambda function. This element is relevant only if
	// you provide a Lambda function in the `fulfillmentActivity`. If you return the intent to the client
	// application, you can't specify this element. The `followUpPrompt` and `conclusionStatement` are
	// mutually exclusive. You can specify only one. Attributes are documented under statement.
	ConclusionStatement IntentConclusionStatementPtrInput
	// Prompts the user to confirm the intent. This question should
	// have a yes or no answer. You you must provide both the `rejectionStatement` and `confirmationPrompt`,
	// or neither. Attributes are documented under prompt.
	ConfirmationPrompt IntentConfirmationPromptPtrInput
	// Determines if a new slot type version is created when the initial
	// resource is created and on each update. Defaults to `false`.
	CreateVersion pulumi.BoolPtrInput
	// A description of the intent. Must be less than or equal to 200 characters in length.
	Description pulumi.StringPtrInput
	// Specifies a Lambda function to invoke for each user input. You can
	// invoke this Lambda function to personalize user interaction. Attributes are documented under code_hook.
	DialogCodeHook IntentDialogCodeHookPtrInput
	// Amazon Lex uses this prompt to solicit additional activity after
	// fulfilling an intent. For example, after the OrderPizza intent is fulfilled, you might prompt the
	// user to order a drink. The `followUpPrompt` field and the `conclusionStatement` field are mutually
	// exclusive. You can specify only one. Attributes are documented under follow_up_prompt.
	FollowUpPrompt IntentFollowUpPromptPtrInput
	// Describes how the intent is fulfilled. For example, after a
	// user provides all of the information for a pizza order, `fulfillmentActivity` defines how the bot
	// places an order with a local pizza store. Attributes are documented under fulfillment_activity.
	FulfillmentActivity IntentFulfillmentActivityInput
	// The name of the intent, not case sensitive. Must be less than or equal to 100 characters in length.
	Name pulumi.StringPtrInput
	// A unique identifier for the built-in intent to base this
	// intent on. To find the signature for an intent, see
	// [Standard Built-in Intents](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/built-in-intent-ref/standard-intents)
	// in the Alexa Skills Kit.
	ParentIntentSignature pulumi.StringPtrInput
	// When the user answers "no" to the question defined in
	// `confirmationPrompt`, Amazon Lex responds with this statement to acknowledge that the intent was
	// canceled. You must provide both the `rejectionStatement` and the `confirmationPrompt`, or neither.
	// Attributes are documented under statement.
	RejectionStatement IntentRejectionStatementPtrInput
	// An array of utterances (strings) that a user might say to signal
	// the intent. For example, "I want {PizzaSize} pizza", "Order {Quantity} {PizzaSize} pizzas".
	// In each utterance, a slot name is enclosed in curly braces. Must have between 1 and 10 items in the list, and each item must be less than or equal to 200 characters in length.
	SampleUtterances pulumi.StringArrayInput
	// An list of intent slots. At runtime, Amazon Lex elicits required slot values
	// from the user using prompts defined in the slots. Attributes are documented under slot.
	Slots IntentSlotArrayInput
}

func (IntentArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*intentArgs)(nil)).Elem()
}

type IntentInput interface {
	pulumi.Input

	ToIntentOutput() IntentOutput
	ToIntentOutputWithContext(ctx context.Context) IntentOutput
}

func (*Intent) ElementType() reflect.Type {
	return reflect.TypeOf((**Intent)(nil)).Elem()
}

func (i *Intent) ToIntentOutput() IntentOutput {
	return i.ToIntentOutputWithContext(context.Background())
}

func (i *Intent) ToIntentOutputWithContext(ctx context.Context) IntentOutput {
	return pulumi.ToOutputWithContext(ctx, i).(IntentOutput)
}

// IntentArrayInput is an input type that accepts IntentArray and IntentArrayOutput values.
// You can construct a concrete instance of `IntentArrayInput` via:
//
//	IntentArray{ IntentArgs{...} }
type IntentArrayInput interface {
	pulumi.Input

	ToIntentArrayOutput() IntentArrayOutput
	ToIntentArrayOutputWithContext(context.Context) IntentArrayOutput
}

type IntentArray []IntentInput

func (IntentArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Intent)(nil)).Elem()
}

func (i IntentArray) ToIntentArrayOutput() IntentArrayOutput {
	return i.ToIntentArrayOutputWithContext(context.Background())
}

func (i IntentArray) ToIntentArrayOutputWithContext(ctx context.Context) IntentArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(IntentArrayOutput)
}

// IntentMapInput is an input type that accepts IntentMap and IntentMapOutput values.
// You can construct a concrete instance of `IntentMapInput` via:
//
//	IntentMap{ "key": IntentArgs{...} }
type IntentMapInput interface {
	pulumi.Input

	ToIntentMapOutput() IntentMapOutput
	ToIntentMapOutputWithContext(context.Context) IntentMapOutput
}

type IntentMap map[string]IntentInput

func (IntentMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Intent)(nil)).Elem()
}

func (i IntentMap) ToIntentMapOutput() IntentMapOutput {
	return i.ToIntentMapOutputWithContext(context.Background())
}

func (i IntentMap) ToIntentMapOutputWithContext(ctx context.Context) IntentMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(IntentMapOutput)
}

type IntentOutput struct{ *pulumi.OutputState }

func (IntentOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Intent)(nil)).Elem()
}

func (o IntentOutput) ToIntentOutput() IntentOutput {
	return o
}

func (o IntentOutput) ToIntentOutputWithContext(ctx context.Context) IntentOutput {
	return o
}

// The ARN of the Lex intent.
func (o IntentOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Intent) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Checksum identifying the version of the intent that was created. The checksum is not
// included as an argument because the resource will add it automatically when updating the intent.
func (o IntentOutput) Checksum() pulumi.StringOutput {
	return o.ApplyT(func(v *Intent) pulumi.StringOutput { return v.Checksum }).(pulumi.StringOutput)
}

// The statement that you want Amazon Lex to convey to the user
// after the intent is successfully fulfilled by the Lambda function. This element is relevant only if
// you provide a Lambda function in the `fulfillmentActivity`. If you return the intent to the client
// application, you can't specify this element. The `followUpPrompt` and `conclusionStatement` are
// mutually exclusive. You can specify only one. Attributes are documented under statement.
func (o IntentOutput) ConclusionStatement() IntentConclusionStatementPtrOutput {
	return o.ApplyT(func(v *Intent) IntentConclusionStatementPtrOutput { return v.ConclusionStatement }).(IntentConclusionStatementPtrOutput)
}

// Prompts the user to confirm the intent. This question should
// have a yes or no answer. You you must provide both the `rejectionStatement` and `confirmationPrompt`,
// or neither. Attributes are documented under prompt.
func (o IntentOutput) ConfirmationPrompt() IntentConfirmationPromptPtrOutput {
	return o.ApplyT(func(v *Intent) IntentConfirmationPromptPtrOutput { return v.ConfirmationPrompt }).(IntentConfirmationPromptPtrOutput)
}

// Determines if a new slot type version is created when the initial
// resource is created and on each update. Defaults to `false`.
func (o IntentOutput) CreateVersion() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *Intent) pulumi.BoolPtrOutput { return v.CreateVersion }).(pulumi.BoolPtrOutput)
}

// The date when the intent version was created.
func (o IntentOutput) CreatedDate() pulumi.StringOutput {
	return o.ApplyT(func(v *Intent) pulumi.StringOutput { return v.CreatedDate }).(pulumi.StringOutput)
}

// A description of the intent. Must be less than or equal to 200 characters in length.
func (o IntentOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Intent) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// Specifies a Lambda function to invoke for each user input. You can
// invoke this Lambda function to personalize user interaction. Attributes are documented under code_hook.
func (o IntentOutput) DialogCodeHook() IntentDialogCodeHookPtrOutput {
	return o.ApplyT(func(v *Intent) IntentDialogCodeHookPtrOutput { return v.DialogCodeHook }).(IntentDialogCodeHookPtrOutput)
}

// Amazon Lex uses this prompt to solicit additional activity after
// fulfilling an intent. For example, after the OrderPizza intent is fulfilled, you might prompt the
// user to order a drink. The `followUpPrompt` field and the `conclusionStatement` field are mutually
// exclusive. You can specify only one. Attributes are documented under follow_up_prompt.
func (o IntentOutput) FollowUpPrompt() IntentFollowUpPromptPtrOutput {
	return o.ApplyT(func(v *Intent) IntentFollowUpPromptPtrOutput { return v.FollowUpPrompt }).(IntentFollowUpPromptPtrOutput)
}

// Describes how the intent is fulfilled. For example, after a
// user provides all of the information for a pizza order, `fulfillmentActivity` defines how the bot
// places an order with a local pizza store. Attributes are documented under fulfillment_activity.
func (o IntentOutput) FulfillmentActivity() IntentFulfillmentActivityOutput {
	return o.ApplyT(func(v *Intent) IntentFulfillmentActivityOutput { return v.FulfillmentActivity }).(IntentFulfillmentActivityOutput)
}

// The date when the $LATEST version of this intent was updated.
func (o IntentOutput) LastUpdatedDate() pulumi.StringOutput {
	return o.ApplyT(func(v *Intent) pulumi.StringOutput { return v.LastUpdatedDate }).(pulumi.StringOutput)
}

// The name of the intent, not case sensitive. Must be less than or equal to 100 characters in length.
func (o IntentOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *Intent) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// A unique identifier for the built-in intent to base this
// intent on. To find the signature for an intent, see
// [Standard Built-in Intents](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/built-in-intent-ref/standard-intents)
// in the Alexa Skills Kit.
func (o IntentOutput) ParentIntentSignature() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Intent) pulumi.StringPtrOutput { return v.ParentIntentSignature }).(pulumi.StringPtrOutput)
}

// When the user answers "no" to the question defined in
// `confirmationPrompt`, Amazon Lex responds with this statement to acknowledge that the intent was
// canceled. You must provide both the `rejectionStatement` and the `confirmationPrompt`, or neither.
// Attributes are documented under statement.
func (o IntentOutput) RejectionStatement() IntentRejectionStatementPtrOutput {
	return o.ApplyT(func(v *Intent) IntentRejectionStatementPtrOutput { return v.RejectionStatement }).(IntentRejectionStatementPtrOutput)
}

// An array of utterances (strings) that a user might say to signal
// the intent. For example, "I want {PizzaSize} pizza", "Order {Quantity} {PizzaSize} pizzas".
// In each utterance, a slot name is enclosed in curly braces. Must have between 1 and 10 items in the list, and each item must be less than or equal to 200 characters in length.
func (o IntentOutput) SampleUtterances() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *Intent) pulumi.StringArrayOutput { return v.SampleUtterances }).(pulumi.StringArrayOutput)
}

// An list of intent slots. At runtime, Amazon Lex elicits required slot values
// from the user using prompts defined in the slots. Attributes are documented under slot.
func (o IntentOutput) Slots() IntentSlotArrayOutput {
	return o.ApplyT(func(v *Intent) IntentSlotArrayOutput { return v.Slots }).(IntentSlotArrayOutput)
}

// The version of the bot.
func (o IntentOutput) Version() pulumi.StringOutput {
	return o.ApplyT(func(v *Intent) pulumi.StringOutput { return v.Version }).(pulumi.StringOutput)
}

type IntentArrayOutput struct{ *pulumi.OutputState }

func (IntentArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Intent)(nil)).Elem()
}

func (o IntentArrayOutput) ToIntentArrayOutput() IntentArrayOutput {
	return o
}

func (o IntentArrayOutput) ToIntentArrayOutputWithContext(ctx context.Context) IntentArrayOutput {
	return o
}

func (o IntentArrayOutput) Index(i pulumi.IntInput) IntentOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Intent {
		return vs[0].([]*Intent)[vs[1].(int)]
	}).(IntentOutput)
}

type IntentMapOutput struct{ *pulumi.OutputState }

func (IntentMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Intent)(nil)).Elem()
}

func (o IntentMapOutput) ToIntentMapOutput() IntentMapOutput {
	return o
}

func (o IntentMapOutput) ToIntentMapOutputWithContext(ctx context.Context) IntentMapOutput {
	return o
}

func (o IntentMapOutput) MapIndex(k pulumi.StringInput) IntentOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Intent {
		return vs[0].(map[string]*Intent)[vs[1].(string)]
	}).(IntentOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*IntentInput)(nil)).Elem(), &Intent{})
	pulumi.RegisterInputType(reflect.TypeOf((*IntentArrayInput)(nil)).Elem(), IntentArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*IntentMapInput)(nil)).Elem(), IntentMap{})
	pulumi.RegisterOutputType(IntentOutput{})
	pulumi.RegisterOutputType(IntentArrayOutput{})
	pulumi.RegisterOutputType(IntentMapOutput{})
}
