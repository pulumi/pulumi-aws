// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package lightsail

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages a Lightsail Key Pair for use with Lightsail Instances. Use this resource to create or import key pairs that are separate from EC2 Key Pairs and required for Lightsail instances.
//
// > **Note:** Lightsail is currently only supported in a limited number of AWS Regions, please see ["Regions and Availability Zones in Amazon Lightsail"](https://lightsail.aws.amazon.com/ls/docs/overview/article/understanding-regions-and-availability-zones-in-amazon-lightsail) for more details
//
// ## Example Usage
//
// ### Create New Key Pair
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lightsail"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := lightsail.NewKeyPair(ctx, "example", &lightsail.KeyPairArgs{
//				Name: pulumi.String("example"),
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
// ### Create New Key Pair with PGP Encrypted Private Key
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lightsail"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := lightsail.NewKeyPair(ctx, "example", &lightsail.KeyPairArgs{
//				Name:   pulumi.String("example"),
//				PgpKey: pulumi.String("keybase:keybaseusername"),
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
// ### Existing Public Key Import
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lightsail"
//	"github.com/pulumi/pulumi-std/sdk/go/std"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			invokeFile, err := std.File(ctx, &std.FileArgs{
//				Input: "~/.ssh/id_rsa.pub",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = lightsail.NewKeyPair(ctx, "example", &lightsail.KeyPairArgs{
//				Name:      pulumi.String("example"),
//				PublicKey: pulumi.String(invokeFile.Result),
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
// You cannot import Lightsail Key Pairs because the private and public key are only available on initial creation.
type KeyPair struct {
	pulumi.CustomResourceState

	// ARN of the Lightsail key pair.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// MD5 public key fingerprint for the encrypted private key.
	EncryptedFingerprint pulumi.StringOutput `pulumi:"encryptedFingerprint"`
	// Private key material, base 64 encoded and encrypted with the given `pgpKey`. This is only populated when creating a new key and `pgpKey` is supplied.
	EncryptedPrivateKey pulumi.StringOutput `pulumi:"encryptedPrivateKey"`
	// MD5 public key fingerprint as specified in section 4 of RFC 4716.
	Fingerprint pulumi.StringOutput `pulumi:"fingerprint"`
	// Name of the Lightsail Key Pair. If omitted, the provider will assign a random, unique name. Conflicts with `namePrefix`.
	Name pulumi.StringOutput `pulumi:"name"`
	// Creates a unique name beginning with the specified prefix. Conflicts with `name`.
	NamePrefix pulumi.StringOutput `pulumi:"namePrefix"`
	// PGP key to encrypt the resulting private key material. Only used when creating a new key pair.
	PgpKey pulumi.StringPtrOutput `pulumi:"pgpKey"`
	// Private key, base64 encoded. This is only populated when creating a new key, and when no `pgpKey` is provided.
	PrivateKey pulumi.StringOutput `pulumi:"privateKey"`
	// Public key material. This public key will be imported into Lightsail.
	PublicKey pulumi.StringOutput `pulumi:"publicKey"`
	// Map of tags to assign to the resource. To create a key-only tag, use an empty string as the value. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	//
	// > **Note:** A PGP key is not required, however it is strongly encouraged. Without a PGP key, the private key material will be stored in state unencrypted. `pgpKey` is ignored if `publicKey` is supplied.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewKeyPair registers a new resource with the given unique name, arguments, and options.
func NewKeyPair(ctx *pulumi.Context,
	name string, args *KeyPairArgs, opts ...pulumi.ResourceOption) (*KeyPair, error) {
	if args == nil {
		args = &KeyPairArgs{}
	}

	opts = internal.PkgResourceDefaultOpts(opts)
	var resource KeyPair
	err := ctx.RegisterResource("aws:lightsail/keyPair:KeyPair", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetKeyPair gets an existing KeyPair resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetKeyPair(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *KeyPairState, opts ...pulumi.ResourceOption) (*KeyPair, error) {
	var resource KeyPair
	err := ctx.ReadResource("aws:lightsail/keyPair:KeyPair", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering KeyPair resources.
type keyPairState struct {
	// ARN of the Lightsail key pair.
	Arn *string `pulumi:"arn"`
	// MD5 public key fingerprint for the encrypted private key.
	EncryptedFingerprint *string `pulumi:"encryptedFingerprint"`
	// Private key material, base 64 encoded and encrypted with the given `pgpKey`. This is only populated when creating a new key and `pgpKey` is supplied.
	EncryptedPrivateKey *string `pulumi:"encryptedPrivateKey"`
	// MD5 public key fingerprint as specified in section 4 of RFC 4716.
	Fingerprint *string `pulumi:"fingerprint"`
	// Name of the Lightsail Key Pair. If omitted, the provider will assign a random, unique name. Conflicts with `namePrefix`.
	Name *string `pulumi:"name"`
	// Creates a unique name beginning with the specified prefix. Conflicts with `name`.
	NamePrefix *string `pulumi:"namePrefix"`
	// PGP key to encrypt the resulting private key material. Only used when creating a new key pair.
	PgpKey *string `pulumi:"pgpKey"`
	// Private key, base64 encoded. This is only populated when creating a new key, and when no `pgpKey` is provided.
	PrivateKey *string `pulumi:"privateKey"`
	// Public key material. This public key will be imported into Lightsail.
	PublicKey *string `pulumi:"publicKey"`
	// Map of tags to assign to the resource. To create a key-only tag, use an empty string as the value. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	//
	// > **Note:** A PGP key is not required, however it is strongly encouraged. Without a PGP key, the private key material will be stored in state unencrypted. `pgpKey` is ignored if `publicKey` is supplied.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type KeyPairState struct {
	// ARN of the Lightsail key pair.
	Arn pulumi.StringPtrInput
	// MD5 public key fingerprint for the encrypted private key.
	EncryptedFingerprint pulumi.StringPtrInput
	// Private key material, base 64 encoded and encrypted with the given `pgpKey`. This is only populated when creating a new key and `pgpKey` is supplied.
	EncryptedPrivateKey pulumi.StringPtrInput
	// MD5 public key fingerprint as specified in section 4 of RFC 4716.
	Fingerprint pulumi.StringPtrInput
	// Name of the Lightsail Key Pair. If omitted, the provider will assign a random, unique name. Conflicts with `namePrefix`.
	Name pulumi.StringPtrInput
	// Creates a unique name beginning with the specified prefix. Conflicts with `name`.
	NamePrefix pulumi.StringPtrInput
	// PGP key to encrypt the resulting private key material. Only used when creating a new key pair.
	PgpKey pulumi.StringPtrInput
	// Private key, base64 encoded. This is only populated when creating a new key, and when no `pgpKey` is provided.
	PrivateKey pulumi.StringPtrInput
	// Public key material. This public key will be imported into Lightsail.
	PublicKey pulumi.StringPtrInput
	// Map of tags to assign to the resource. To create a key-only tag, use an empty string as the value. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	//
	// > **Note:** A PGP key is not required, however it is strongly encouraged. Without a PGP key, the private key material will be stored in state unencrypted. `pgpKey` is ignored if `publicKey` is supplied.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (KeyPairState) ElementType() reflect.Type {
	return reflect.TypeOf((*keyPairState)(nil)).Elem()
}

type keyPairArgs struct {
	// Name of the Lightsail Key Pair. If omitted, the provider will assign a random, unique name. Conflicts with `namePrefix`.
	Name *string `pulumi:"name"`
	// Creates a unique name beginning with the specified prefix. Conflicts with `name`.
	NamePrefix *string `pulumi:"namePrefix"`
	// PGP key to encrypt the resulting private key material. Only used when creating a new key pair.
	PgpKey *string `pulumi:"pgpKey"`
	// Public key material. This public key will be imported into Lightsail.
	PublicKey *string `pulumi:"publicKey"`
	// Map of tags to assign to the resource. To create a key-only tag, use an empty string as the value. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	//
	// > **Note:** A PGP key is not required, however it is strongly encouraged. Without a PGP key, the private key material will be stored in state unencrypted. `pgpKey` is ignored if `publicKey` is supplied.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a KeyPair resource.
type KeyPairArgs struct {
	// Name of the Lightsail Key Pair. If omitted, the provider will assign a random, unique name. Conflicts with `namePrefix`.
	Name pulumi.StringPtrInput
	// Creates a unique name beginning with the specified prefix. Conflicts with `name`.
	NamePrefix pulumi.StringPtrInput
	// PGP key to encrypt the resulting private key material. Only used when creating a new key pair.
	PgpKey pulumi.StringPtrInput
	// Public key material. This public key will be imported into Lightsail.
	PublicKey pulumi.StringPtrInput
	// Map of tags to assign to the resource. To create a key-only tag, use an empty string as the value. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	//
	// > **Note:** A PGP key is not required, however it is strongly encouraged. Without a PGP key, the private key material will be stored in state unencrypted. `pgpKey` is ignored if `publicKey` is supplied.
	Tags pulumi.StringMapInput
}

func (KeyPairArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*keyPairArgs)(nil)).Elem()
}

type KeyPairInput interface {
	pulumi.Input

	ToKeyPairOutput() KeyPairOutput
	ToKeyPairOutputWithContext(ctx context.Context) KeyPairOutput
}

func (*KeyPair) ElementType() reflect.Type {
	return reflect.TypeOf((**KeyPair)(nil)).Elem()
}

func (i *KeyPair) ToKeyPairOutput() KeyPairOutput {
	return i.ToKeyPairOutputWithContext(context.Background())
}

func (i *KeyPair) ToKeyPairOutputWithContext(ctx context.Context) KeyPairOutput {
	return pulumi.ToOutputWithContext(ctx, i).(KeyPairOutput)
}

// KeyPairArrayInput is an input type that accepts KeyPairArray and KeyPairArrayOutput values.
// You can construct a concrete instance of `KeyPairArrayInput` via:
//
//	KeyPairArray{ KeyPairArgs{...} }
type KeyPairArrayInput interface {
	pulumi.Input

	ToKeyPairArrayOutput() KeyPairArrayOutput
	ToKeyPairArrayOutputWithContext(context.Context) KeyPairArrayOutput
}

type KeyPairArray []KeyPairInput

func (KeyPairArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*KeyPair)(nil)).Elem()
}

func (i KeyPairArray) ToKeyPairArrayOutput() KeyPairArrayOutput {
	return i.ToKeyPairArrayOutputWithContext(context.Background())
}

func (i KeyPairArray) ToKeyPairArrayOutputWithContext(ctx context.Context) KeyPairArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(KeyPairArrayOutput)
}

// KeyPairMapInput is an input type that accepts KeyPairMap and KeyPairMapOutput values.
// You can construct a concrete instance of `KeyPairMapInput` via:
//
//	KeyPairMap{ "key": KeyPairArgs{...} }
type KeyPairMapInput interface {
	pulumi.Input

	ToKeyPairMapOutput() KeyPairMapOutput
	ToKeyPairMapOutputWithContext(context.Context) KeyPairMapOutput
}

type KeyPairMap map[string]KeyPairInput

func (KeyPairMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*KeyPair)(nil)).Elem()
}

func (i KeyPairMap) ToKeyPairMapOutput() KeyPairMapOutput {
	return i.ToKeyPairMapOutputWithContext(context.Background())
}

func (i KeyPairMap) ToKeyPairMapOutputWithContext(ctx context.Context) KeyPairMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(KeyPairMapOutput)
}

type KeyPairOutput struct{ *pulumi.OutputState }

func (KeyPairOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**KeyPair)(nil)).Elem()
}

func (o KeyPairOutput) ToKeyPairOutput() KeyPairOutput {
	return o
}

func (o KeyPairOutput) ToKeyPairOutputWithContext(ctx context.Context) KeyPairOutput {
	return o
}

// ARN of the Lightsail key pair.
func (o KeyPairOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *KeyPair) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// MD5 public key fingerprint for the encrypted private key.
func (o KeyPairOutput) EncryptedFingerprint() pulumi.StringOutput {
	return o.ApplyT(func(v *KeyPair) pulumi.StringOutput { return v.EncryptedFingerprint }).(pulumi.StringOutput)
}

// Private key material, base 64 encoded and encrypted with the given `pgpKey`. This is only populated when creating a new key and `pgpKey` is supplied.
func (o KeyPairOutput) EncryptedPrivateKey() pulumi.StringOutput {
	return o.ApplyT(func(v *KeyPair) pulumi.StringOutput { return v.EncryptedPrivateKey }).(pulumi.StringOutput)
}

// MD5 public key fingerprint as specified in section 4 of RFC 4716.
func (o KeyPairOutput) Fingerprint() pulumi.StringOutput {
	return o.ApplyT(func(v *KeyPair) pulumi.StringOutput { return v.Fingerprint }).(pulumi.StringOutput)
}

// Name of the Lightsail Key Pair. If omitted, the provider will assign a random, unique name. Conflicts with `namePrefix`.
func (o KeyPairOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *KeyPair) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Creates a unique name beginning with the specified prefix. Conflicts with `name`.
func (o KeyPairOutput) NamePrefix() pulumi.StringOutput {
	return o.ApplyT(func(v *KeyPair) pulumi.StringOutput { return v.NamePrefix }).(pulumi.StringOutput)
}

// PGP key to encrypt the resulting private key material. Only used when creating a new key pair.
func (o KeyPairOutput) PgpKey() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *KeyPair) pulumi.StringPtrOutput { return v.PgpKey }).(pulumi.StringPtrOutput)
}

// Private key, base64 encoded. This is only populated when creating a new key, and when no `pgpKey` is provided.
func (o KeyPairOutput) PrivateKey() pulumi.StringOutput {
	return o.ApplyT(func(v *KeyPair) pulumi.StringOutput { return v.PrivateKey }).(pulumi.StringOutput)
}

// Public key material. This public key will be imported into Lightsail.
func (o KeyPairOutput) PublicKey() pulumi.StringOutput {
	return o.ApplyT(func(v *KeyPair) pulumi.StringOutput { return v.PublicKey }).(pulumi.StringOutput)
}

// Map of tags to assign to the resource. To create a key-only tag, use an empty string as the value. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
//
// > **Note:** A PGP key is not required, however it is strongly encouraged. Without a PGP key, the private key material will be stored in state unencrypted. `pgpKey` is ignored if `publicKey` is supplied.
func (o KeyPairOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *KeyPair) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o KeyPairOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *KeyPair) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type KeyPairArrayOutput struct{ *pulumi.OutputState }

func (KeyPairArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*KeyPair)(nil)).Elem()
}

func (o KeyPairArrayOutput) ToKeyPairArrayOutput() KeyPairArrayOutput {
	return o
}

func (o KeyPairArrayOutput) ToKeyPairArrayOutputWithContext(ctx context.Context) KeyPairArrayOutput {
	return o
}

func (o KeyPairArrayOutput) Index(i pulumi.IntInput) KeyPairOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *KeyPair {
		return vs[0].([]*KeyPair)[vs[1].(int)]
	}).(KeyPairOutput)
}

type KeyPairMapOutput struct{ *pulumi.OutputState }

func (KeyPairMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*KeyPair)(nil)).Elem()
}

func (o KeyPairMapOutput) ToKeyPairMapOutput() KeyPairMapOutput {
	return o
}

func (o KeyPairMapOutput) ToKeyPairMapOutputWithContext(ctx context.Context) KeyPairMapOutput {
	return o
}

func (o KeyPairMapOutput) MapIndex(k pulumi.StringInput) KeyPairOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *KeyPair {
		return vs[0].(map[string]*KeyPair)[vs[1].(string)]
	}).(KeyPairOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*KeyPairInput)(nil)).Elem(), &KeyPair{})
	pulumi.RegisterInputType(reflect.TypeOf((*KeyPairArrayInput)(nil)).Elem(), KeyPairArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*KeyPairMapInput)(nil)).Elem(), KeyPairMap{})
	pulumi.RegisterOutputType(KeyPairOutput{})
	pulumi.RegisterOutputType(KeyPairArrayOutput{})
	pulumi.RegisterOutputType(KeyPairMapOutput{})
}
