// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package cloudfront

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// ## Example Usage
//
// ### Basic Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cloudfront"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := cloudfront.NewKeyValueStore(ctx, "example", &cloudfront.KeyValueStoreArgs{
//				Name:    pulumi.String("ExampleKeyValueStore"),
//				Comment: pulumi.String("This is an example key value store"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = cloudfront.NewKeyvaluestoreKey(ctx, "example", &cloudfront.KeyvaluestoreKeyArgs{
//				KeyValueStoreArn: example.Arn,
//				Key:              pulumi.String("Test Key"),
//				Value:            pulumi.String("Test Value"),
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
// Using `pulumi import`, import CloudFront KeyValueStore Key using the `id`. For example:
//
// ```sh
// $ pulumi import aws:cloudfront/keyvaluestoreKey:KeyvaluestoreKey example arn:aws:cloudfront::111111111111:key-value-store/8562g61f-caba-2845-9d99-b97diwae5d3c,someKey
// ```
type KeyvaluestoreKey struct {
	pulumi.CustomResourceState

	// Key to put.
	Key pulumi.StringOutput `pulumi:"key"`
	// Amazon Resource Name (ARN) of the Key Value Store.
	KeyValueStoreArn pulumi.StringOutput `pulumi:"keyValueStoreArn"`
	// Total size of the Key Value Store in bytes.
	TotalSizeInBytes pulumi.IntOutput `pulumi:"totalSizeInBytes"`
	// Value to put.
	Value pulumi.StringOutput `pulumi:"value"`
}

// NewKeyvaluestoreKey registers a new resource with the given unique name, arguments, and options.
func NewKeyvaluestoreKey(ctx *pulumi.Context,
	name string, args *KeyvaluestoreKeyArgs, opts ...pulumi.ResourceOption) (*KeyvaluestoreKey, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Key == nil {
		return nil, errors.New("invalid value for required argument 'Key'")
	}
	if args.KeyValueStoreArn == nil {
		return nil, errors.New("invalid value for required argument 'KeyValueStoreArn'")
	}
	if args.Value == nil {
		return nil, errors.New("invalid value for required argument 'Value'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource KeyvaluestoreKey
	err := ctx.RegisterResource("aws:cloudfront/keyvaluestoreKey:KeyvaluestoreKey", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetKeyvaluestoreKey gets an existing KeyvaluestoreKey resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetKeyvaluestoreKey(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *KeyvaluestoreKeyState, opts ...pulumi.ResourceOption) (*KeyvaluestoreKey, error) {
	var resource KeyvaluestoreKey
	err := ctx.ReadResource("aws:cloudfront/keyvaluestoreKey:KeyvaluestoreKey", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering KeyvaluestoreKey resources.
type keyvaluestoreKeyState struct {
	// Key to put.
	Key *string `pulumi:"key"`
	// Amazon Resource Name (ARN) of the Key Value Store.
	KeyValueStoreArn *string `pulumi:"keyValueStoreArn"`
	// Total size of the Key Value Store in bytes.
	TotalSizeInBytes *int `pulumi:"totalSizeInBytes"`
	// Value to put.
	Value *string `pulumi:"value"`
}

type KeyvaluestoreKeyState struct {
	// Key to put.
	Key pulumi.StringPtrInput
	// Amazon Resource Name (ARN) of the Key Value Store.
	KeyValueStoreArn pulumi.StringPtrInput
	// Total size of the Key Value Store in bytes.
	TotalSizeInBytes pulumi.IntPtrInput
	// Value to put.
	Value pulumi.StringPtrInput
}

func (KeyvaluestoreKeyState) ElementType() reflect.Type {
	return reflect.TypeOf((*keyvaluestoreKeyState)(nil)).Elem()
}

type keyvaluestoreKeyArgs struct {
	// Key to put.
	Key string `pulumi:"key"`
	// Amazon Resource Name (ARN) of the Key Value Store.
	KeyValueStoreArn string `pulumi:"keyValueStoreArn"`
	// Value to put.
	Value string `pulumi:"value"`
}

// The set of arguments for constructing a KeyvaluestoreKey resource.
type KeyvaluestoreKeyArgs struct {
	// Key to put.
	Key pulumi.StringInput
	// Amazon Resource Name (ARN) of the Key Value Store.
	KeyValueStoreArn pulumi.StringInput
	// Value to put.
	Value pulumi.StringInput
}

func (KeyvaluestoreKeyArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*keyvaluestoreKeyArgs)(nil)).Elem()
}

type KeyvaluestoreKeyInput interface {
	pulumi.Input

	ToKeyvaluestoreKeyOutput() KeyvaluestoreKeyOutput
	ToKeyvaluestoreKeyOutputWithContext(ctx context.Context) KeyvaluestoreKeyOutput
}

func (*KeyvaluestoreKey) ElementType() reflect.Type {
	return reflect.TypeOf((**KeyvaluestoreKey)(nil)).Elem()
}

func (i *KeyvaluestoreKey) ToKeyvaluestoreKeyOutput() KeyvaluestoreKeyOutput {
	return i.ToKeyvaluestoreKeyOutputWithContext(context.Background())
}

func (i *KeyvaluestoreKey) ToKeyvaluestoreKeyOutputWithContext(ctx context.Context) KeyvaluestoreKeyOutput {
	return pulumi.ToOutputWithContext(ctx, i).(KeyvaluestoreKeyOutput)
}

// KeyvaluestoreKeyArrayInput is an input type that accepts KeyvaluestoreKeyArray and KeyvaluestoreKeyArrayOutput values.
// You can construct a concrete instance of `KeyvaluestoreKeyArrayInput` via:
//
//	KeyvaluestoreKeyArray{ KeyvaluestoreKeyArgs{...} }
type KeyvaluestoreKeyArrayInput interface {
	pulumi.Input

	ToKeyvaluestoreKeyArrayOutput() KeyvaluestoreKeyArrayOutput
	ToKeyvaluestoreKeyArrayOutputWithContext(context.Context) KeyvaluestoreKeyArrayOutput
}

type KeyvaluestoreKeyArray []KeyvaluestoreKeyInput

func (KeyvaluestoreKeyArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*KeyvaluestoreKey)(nil)).Elem()
}

func (i KeyvaluestoreKeyArray) ToKeyvaluestoreKeyArrayOutput() KeyvaluestoreKeyArrayOutput {
	return i.ToKeyvaluestoreKeyArrayOutputWithContext(context.Background())
}

func (i KeyvaluestoreKeyArray) ToKeyvaluestoreKeyArrayOutputWithContext(ctx context.Context) KeyvaluestoreKeyArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(KeyvaluestoreKeyArrayOutput)
}

// KeyvaluestoreKeyMapInput is an input type that accepts KeyvaluestoreKeyMap and KeyvaluestoreKeyMapOutput values.
// You can construct a concrete instance of `KeyvaluestoreKeyMapInput` via:
//
//	KeyvaluestoreKeyMap{ "key": KeyvaluestoreKeyArgs{...} }
type KeyvaluestoreKeyMapInput interface {
	pulumi.Input

	ToKeyvaluestoreKeyMapOutput() KeyvaluestoreKeyMapOutput
	ToKeyvaluestoreKeyMapOutputWithContext(context.Context) KeyvaluestoreKeyMapOutput
}

type KeyvaluestoreKeyMap map[string]KeyvaluestoreKeyInput

func (KeyvaluestoreKeyMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*KeyvaluestoreKey)(nil)).Elem()
}

func (i KeyvaluestoreKeyMap) ToKeyvaluestoreKeyMapOutput() KeyvaluestoreKeyMapOutput {
	return i.ToKeyvaluestoreKeyMapOutputWithContext(context.Background())
}

func (i KeyvaluestoreKeyMap) ToKeyvaluestoreKeyMapOutputWithContext(ctx context.Context) KeyvaluestoreKeyMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(KeyvaluestoreKeyMapOutput)
}

type KeyvaluestoreKeyOutput struct{ *pulumi.OutputState }

func (KeyvaluestoreKeyOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**KeyvaluestoreKey)(nil)).Elem()
}

func (o KeyvaluestoreKeyOutput) ToKeyvaluestoreKeyOutput() KeyvaluestoreKeyOutput {
	return o
}

func (o KeyvaluestoreKeyOutput) ToKeyvaluestoreKeyOutputWithContext(ctx context.Context) KeyvaluestoreKeyOutput {
	return o
}

// Key to put.
func (o KeyvaluestoreKeyOutput) Key() pulumi.StringOutput {
	return o.ApplyT(func(v *KeyvaluestoreKey) pulumi.StringOutput { return v.Key }).(pulumi.StringOutput)
}

// Amazon Resource Name (ARN) of the Key Value Store.
func (o KeyvaluestoreKeyOutput) KeyValueStoreArn() pulumi.StringOutput {
	return o.ApplyT(func(v *KeyvaluestoreKey) pulumi.StringOutput { return v.KeyValueStoreArn }).(pulumi.StringOutput)
}

// Total size of the Key Value Store in bytes.
func (o KeyvaluestoreKeyOutput) TotalSizeInBytes() pulumi.IntOutput {
	return o.ApplyT(func(v *KeyvaluestoreKey) pulumi.IntOutput { return v.TotalSizeInBytes }).(pulumi.IntOutput)
}

// Value to put.
func (o KeyvaluestoreKeyOutput) Value() pulumi.StringOutput {
	return o.ApplyT(func(v *KeyvaluestoreKey) pulumi.StringOutput { return v.Value }).(pulumi.StringOutput)
}

type KeyvaluestoreKeyArrayOutput struct{ *pulumi.OutputState }

func (KeyvaluestoreKeyArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*KeyvaluestoreKey)(nil)).Elem()
}

func (o KeyvaluestoreKeyArrayOutput) ToKeyvaluestoreKeyArrayOutput() KeyvaluestoreKeyArrayOutput {
	return o
}

func (o KeyvaluestoreKeyArrayOutput) ToKeyvaluestoreKeyArrayOutputWithContext(ctx context.Context) KeyvaluestoreKeyArrayOutput {
	return o
}

func (o KeyvaluestoreKeyArrayOutput) Index(i pulumi.IntInput) KeyvaluestoreKeyOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *KeyvaluestoreKey {
		return vs[0].([]*KeyvaluestoreKey)[vs[1].(int)]
	}).(KeyvaluestoreKeyOutput)
}

type KeyvaluestoreKeyMapOutput struct{ *pulumi.OutputState }

func (KeyvaluestoreKeyMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*KeyvaluestoreKey)(nil)).Elem()
}

func (o KeyvaluestoreKeyMapOutput) ToKeyvaluestoreKeyMapOutput() KeyvaluestoreKeyMapOutput {
	return o
}

func (o KeyvaluestoreKeyMapOutput) ToKeyvaluestoreKeyMapOutputWithContext(ctx context.Context) KeyvaluestoreKeyMapOutput {
	return o
}

func (o KeyvaluestoreKeyMapOutput) MapIndex(k pulumi.StringInput) KeyvaluestoreKeyOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *KeyvaluestoreKey {
		return vs[0].(map[string]*KeyvaluestoreKey)[vs[1].(string)]
	}).(KeyvaluestoreKeyOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*KeyvaluestoreKeyInput)(nil)).Elem(), &KeyvaluestoreKey{})
	pulumi.RegisterInputType(reflect.TypeOf((*KeyvaluestoreKeyArrayInput)(nil)).Elem(), KeyvaluestoreKeyArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*KeyvaluestoreKeyMapInput)(nil)).Elem(), KeyvaluestoreKeyMap{})
	pulumi.RegisterOutputType(KeyvaluestoreKeyOutput{})
	pulumi.RegisterOutputType(KeyvaluestoreKeyArrayOutput{})
	pulumi.RegisterOutputType(KeyvaluestoreKeyMapOutput{})
}
