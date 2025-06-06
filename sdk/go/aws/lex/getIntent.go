// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package lex

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides details about a specific Amazon Lex Intent.
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
//			_, err := lex.LookupIntent(ctx, &lex.LookupIntentArgs{
//				Name:    "OrderFlowers",
//				Version: pulumi.StringRef("$LATEST"),
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupIntent(ctx *pulumi.Context, args *LookupIntentArgs, opts ...pulumi.InvokeOption) (*LookupIntentResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupIntentResult
	err := ctx.Invoke("aws:lex/getIntent:getIntent", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getIntent.
type LookupIntentArgs struct {
	// Name of the intent. The name is case sensitive.
	Name string `pulumi:"name"`
	// Version of the intent.
	Version *string `pulumi:"version"`
}

// A collection of values returned by getIntent.
type LookupIntentResult struct {
	// ARN of the Lex intent.
	Arn string `pulumi:"arn"`
	// Checksum identifying the version of the intent that was created. The checksum is not
	// included as an argument because the resource will add it automatically when updating the intent.
	Checksum string `pulumi:"checksum"`
	// Date when the intent version was created.
	CreatedDate string `pulumi:"createdDate"`
	// Description of the intent.
	Description string `pulumi:"description"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Date when the $LATEST version of this intent was updated.
	LastUpdatedDate string `pulumi:"lastUpdatedDate"`
	// Name of the intent, not case sensitive.
	Name string `pulumi:"name"`
	// A unique identifier for the built-in intent to base this
	// intent on. To find the signature for an intent, see
	// [Standard Built-in Intents](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/built-in-intent-ref/standard-intents)
	// in the Alexa Skills Kit.
	ParentIntentSignature string `pulumi:"parentIntentSignature"`
	// Version of the bot.
	Version *string `pulumi:"version"`
}

func LookupIntentOutput(ctx *pulumi.Context, args LookupIntentOutputArgs, opts ...pulumi.InvokeOption) LookupIntentResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupIntentResultOutput, error) {
			args := v.(LookupIntentArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:lex/getIntent:getIntent", args, LookupIntentResultOutput{}, options).(LookupIntentResultOutput), nil
		}).(LookupIntentResultOutput)
}

// A collection of arguments for invoking getIntent.
type LookupIntentOutputArgs struct {
	// Name of the intent. The name is case sensitive.
	Name pulumi.StringInput `pulumi:"name"`
	// Version of the intent.
	Version pulumi.StringPtrInput `pulumi:"version"`
}

func (LookupIntentOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupIntentArgs)(nil)).Elem()
}

// A collection of values returned by getIntent.
type LookupIntentResultOutput struct{ *pulumi.OutputState }

func (LookupIntentResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupIntentResult)(nil)).Elem()
}

func (o LookupIntentResultOutput) ToLookupIntentResultOutput() LookupIntentResultOutput {
	return o
}

func (o LookupIntentResultOutput) ToLookupIntentResultOutputWithContext(ctx context.Context) LookupIntentResultOutput {
	return o
}

// ARN of the Lex intent.
func (o LookupIntentResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupIntentResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Checksum identifying the version of the intent that was created. The checksum is not
// included as an argument because the resource will add it automatically when updating the intent.
func (o LookupIntentResultOutput) Checksum() pulumi.StringOutput {
	return o.ApplyT(func(v LookupIntentResult) string { return v.Checksum }).(pulumi.StringOutput)
}

// Date when the intent version was created.
func (o LookupIntentResultOutput) CreatedDate() pulumi.StringOutput {
	return o.ApplyT(func(v LookupIntentResult) string { return v.CreatedDate }).(pulumi.StringOutput)
}

// Description of the intent.
func (o LookupIntentResultOutput) Description() pulumi.StringOutput {
	return o.ApplyT(func(v LookupIntentResult) string { return v.Description }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupIntentResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupIntentResult) string { return v.Id }).(pulumi.StringOutput)
}

// Date when the $LATEST version of this intent was updated.
func (o LookupIntentResultOutput) LastUpdatedDate() pulumi.StringOutput {
	return o.ApplyT(func(v LookupIntentResult) string { return v.LastUpdatedDate }).(pulumi.StringOutput)
}

// Name of the intent, not case sensitive.
func (o LookupIntentResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupIntentResult) string { return v.Name }).(pulumi.StringOutput)
}

// A unique identifier for the built-in intent to base this
// intent on. To find the signature for an intent, see
// [Standard Built-in Intents](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/built-in-intent-ref/standard-intents)
// in the Alexa Skills Kit.
func (o LookupIntentResultOutput) ParentIntentSignature() pulumi.StringOutput {
	return o.ApplyT(func(v LookupIntentResult) string { return v.ParentIntentSignature }).(pulumi.StringOutput)
}

// Version of the bot.
func (o LookupIntentResultOutput) Version() pulumi.StringPtrOutput {
	return o.ApplyT(func(v LookupIntentResult) *string { return v.Version }).(pulumi.StringPtrOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupIntentResultOutput{})
}
