// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package s3control

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a resource to manage an S3 Access Grant.
// Each access grant has its own ID and gives an IAM user or role or a directory user, or group (the grantee) access to a registered location. You determine the level of access, such as `READ` or `READWRITE`.
// Before you can create a grant, you must have an S3 Access Grants instance in the same Region as the S3 data.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/s3control"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := s3control.NewAccessGrantsInstance(ctx, "example", nil)
//			if err != nil {
//				return err
//			}
//			exampleAccessGrantsLocation, err := s3control.NewAccessGrantsLocation(ctx, "example", &s3control.AccessGrantsLocationArgs{
//				IamRoleArn:    pulumi.Any(exampleAwsIamRole.Arn),
//				LocationScope: pulumi.Sprintf("s3://%v/prefixA*", exampleAwsS3Bucket.Bucket),
//			}, pulumi.DependsOn([]pulumi.Resource{
//				example,
//			}))
//			if err != nil {
//				return err
//			}
//			_, err = s3control.NewAccessGrant(ctx, "example", &s3control.AccessGrantArgs{
//				AccessGrantsLocationId: exampleAccessGrantsLocation.AccessGrantsLocationId,
//				Permission:             pulumi.String("READ"),
//				AccessGrantsLocationConfiguration: &s3control.AccessGrantAccessGrantsLocationConfigurationArgs{
//					S3SubPrefix: pulumi.String("prefixB*"),
//				},
//				Grantee: &s3control.AccessGrantGranteeArgs{
//					GranteeType:       pulumi.String("IAM"),
//					GranteeIdentifier: pulumi.Any(exampleAwsIamUser.Arn),
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
// Using `pulumi import`, import S3 Access Grants using the `account_id` and `access_grant_id`, separated by a comma (`,`). For example:
//
// ```sh
// $ pulumi import aws:s3control/accessGrant:AccessGrant example 123456789012,04549c5e-2f3c-4a07-824d-2cafe720aa22
// ```
type AccessGrant struct {
	pulumi.CustomResourceState

	// Amazon Resource Name (ARN) of the S3 Access Grant.
	AccessGrantArn pulumi.StringOutput `pulumi:"accessGrantArn"`
	// Unique ID of the S3 Access Grant.
	AccessGrantId pulumi.StringOutput `pulumi:"accessGrantId"`
	// See Location Configuration below for more details.
	AccessGrantsLocationConfiguration AccessGrantAccessGrantsLocationConfigurationPtrOutput `pulumi:"accessGrantsLocationConfiguration"`
	// The ID of the S3 Access Grants location to with the access grant is giving access.
	AccessGrantsLocationId pulumi.StringOutput `pulumi:"accessGrantsLocationId"`
	AccountId              pulumi.StringOutput `pulumi:"accountId"`
	// The access grant's scope.
	GrantScope pulumi.StringOutput `pulumi:"grantScope"`
	// See Grantee below for more details.
	Grantee AccessGrantGranteePtrOutput `pulumi:"grantee"`
	// The access grant's level of access. Valid values: `READ`, `WRITE`, `READWRITE`.
	Permission pulumi.StringOutput `pulumi:"permission"`
	// If you are creating an access grant that grants access to only one object, set this to `Object`. Valid values: `Object`.
	S3PrefixType pulumi.StringPtrOutput `pulumi:"s3PrefixType"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewAccessGrant registers a new resource with the given unique name, arguments, and options.
func NewAccessGrant(ctx *pulumi.Context,
	name string, args *AccessGrantArgs, opts ...pulumi.ResourceOption) (*AccessGrant, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.AccessGrantsLocationId == nil {
		return nil, errors.New("invalid value for required argument 'AccessGrantsLocationId'")
	}
	if args.Permission == nil {
		return nil, errors.New("invalid value for required argument 'Permission'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource AccessGrant
	err := ctx.RegisterResource("aws:s3control/accessGrant:AccessGrant", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAccessGrant gets an existing AccessGrant resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAccessGrant(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AccessGrantState, opts ...pulumi.ResourceOption) (*AccessGrant, error) {
	var resource AccessGrant
	err := ctx.ReadResource("aws:s3control/accessGrant:AccessGrant", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering AccessGrant resources.
type accessGrantState struct {
	// Amazon Resource Name (ARN) of the S3 Access Grant.
	AccessGrantArn *string `pulumi:"accessGrantArn"`
	// Unique ID of the S3 Access Grant.
	AccessGrantId *string `pulumi:"accessGrantId"`
	// See Location Configuration below for more details.
	AccessGrantsLocationConfiguration *AccessGrantAccessGrantsLocationConfiguration `pulumi:"accessGrantsLocationConfiguration"`
	// The ID of the S3 Access Grants location to with the access grant is giving access.
	AccessGrantsLocationId *string `pulumi:"accessGrantsLocationId"`
	AccountId              *string `pulumi:"accountId"`
	// The access grant's scope.
	GrantScope *string `pulumi:"grantScope"`
	// See Grantee below for more details.
	Grantee *AccessGrantGrantee `pulumi:"grantee"`
	// The access grant's level of access. Valid values: `READ`, `WRITE`, `READWRITE`.
	Permission *string `pulumi:"permission"`
	// If you are creating an access grant that grants access to only one object, set this to `Object`. Valid values: `Object`.
	S3PrefixType *string `pulumi:"s3PrefixType"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type AccessGrantState struct {
	// Amazon Resource Name (ARN) of the S3 Access Grant.
	AccessGrantArn pulumi.StringPtrInput
	// Unique ID of the S3 Access Grant.
	AccessGrantId pulumi.StringPtrInput
	// See Location Configuration below for more details.
	AccessGrantsLocationConfiguration AccessGrantAccessGrantsLocationConfigurationPtrInput
	// The ID of the S3 Access Grants location to with the access grant is giving access.
	AccessGrantsLocationId pulumi.StringPtrInput
	AccountId              pulumi.StringPtrInput
	// The access grant's scope.
	GrantScope pulumi.StringPtrInput
	// See Grantee below for more details.
	Grantee AccessGrantGranteePtrInput
	// The access grant's level of access. Valid values: `READ`, `WRITE`, `READWRITE`.
	Permission pulumi.StringPtrInput
	// If you are creating an access grant that grants access to only one object, set this to `Object`. Valid values: `Object`.
	S3PrefixType pulumi.StringPtrInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (AccessGrantState) ElementType() reflect.Type {
	return reflect.TypeOf((*accessGrantState)(nil)).Elem()
}

type accessGrantArgs struct {
	// See Location Configuration below for more details.
	AccessGrantsLocationConfiguration *AccessGrantAccessGrantsLocationConfiguration `pulumi:"accessGrantsLocationConfiguration"`
	// The ID of the S3 Access Grants location to with the access grant is giving access.
	AccessGrantsLocationId string  `pulumi:"accessGrantsLocationId"`
	AccountId              *string `pulumi:"accountId"`
	// See Grantee below for more details.
	Grantee *AccessGrantGrantee `pulumi:"grantee"`
	// The access grant's level of access. Valid values: `READ`, `WRITE`, `READWRITE`.
	Permission string `pulumi:"permission"`
	// If you are creating an access grant that grants access to only one object, set this to `Object`. Valid values: `Object`.
	S3PrefixType *string `pulumi:"s3PrefixType"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a AccessGrant resource.
type AccessGrantArgs struct {
	// See Location Configuration below for more details.
	AccessGrantsLocationConfiguration AccessGrantAccessGrantsLocationConfigurationPtrInput
	// The ID of the S3 Access Grants location to with the access grant is giving access.
	AccessGrantsLocationId pulumi.StringInput
	AccountId              pulumi.StringPtrInput
	// See Grantee below for more details.
	Grantee AccessGrantGranteePtrInput
	// The access grant's level of access. Valid values: `READ`, `WRITE`, `READWRITE`.
	Permission pulumi.StringInput
	// If you are creating an access grant that grants access to only one object, set this to `Object`. Valid values: `Object`.
	S3PrefixType pulumi.StringPtrInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (AccessGrantArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*accessGrantArgs)(nil)).Elem()
}

type AccessGrantInput interface {
	pulumi.Input

	ToAccessGrantOutput() AccessGrantOutput
	ToAccessGrantOutputWithContext(ctx context.Context) AccessGrantOutput
}

func (*AccessGrant) ElementType() reflect.Type {
	return reflect.TypeOf((**AccessGrant)(nil)).Elem()
}

func (i *AccessGrant) ToAccessGrantOutput() AccessGrantOutput {
	return i.ToAccessGrantOutputWithContext(context.Background())
}

func (i *AccessGrant) ToAccessGrantOutputWithContext(ctx context.Context) AccessGrantOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccessGrantOutput)
}

// AccessGrantArrayInput is an input type that accepts AccessGrantArray and AccessGrantArrayOutput values.
// You can construct a concrete instance of `AccessGrantArrayInput` via:
//
//	AccessGrantArray{ AccessGrantArgs{...} }
type AccessGrantArrayInput interface {
	pulumi.Input

	ToAccessGrantArrayOutput() AccessGrantArrayOutput
	ToAccessGrantArrayOutputWithContext(context.Context) AccessGrantArrayOutput
}

type AccessGrantArray []AccessGrantInput

func (AccessGrantArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AccessGrant)(nil)).Elem()
}

func (i AccessGrantArray) ToAccessGrantArrayOutput() AccessGrantArrayOutput {
	return i.ToAccessGrantArrayOutputWithContext(context.Background())
}

func (i AccessGrantArray) ToAccessGrantArrayOutputWithContext(ctx context.Context) AccessGrantArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccessGrantArrayOutput)
}

// AccessGrantMapInput is an input type that accepts AccessGrantMap and AccessGrantMapOutput values.
// You can construct a concrete instance of `AccessGrantMapInput` via:
//
//	AccessGrantMap{ "key": AccessGrantArgs{...} }
type AccessGrantMapInput interface {
	pulumi.Input

	ToAccessGrantMapOutput() AccessGrantMapOutput
	ToAccessGrantMapOutputWithContext(context.Context) AccessGrantMapOutput
}

type AccessGrantMap map[string]AccessGrantInput

func (AccessGrantMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AccessGrant)(nil)).Elem()
}

func (i AccessGrantMap) ToAccessGrantMapOutput() AccessGrantMapOutput {
	return i.ToAccessGrantMapOutputWithContext(context.Background())
}

func (i AccessGrantMap) ToAccessGrantMapOutputWithContext(ctx context.Context) AccessGrantMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccessGrantMapOutput)
}

type AccessGrantOutput struct{ *pulumi.OutputState }

func (AccessGrantOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AccessGrant)(nil)).Elem()
}

func (o AccessGrantOutput) ToAccessGrantOutput() AccessGrantOutput {
	return o
}

func (o AccessGrantOutput) ToAccessGrantOutputWithContext(ctx context.Context) AccessGrantOutput {
	return o
}

// Amazon Resource Name (ARN) of the S3 Access Grant.
func (o AccessGrantOutput) AccessGrantArn() pulumi.StringOutput {
	return o.ApplyT(func(v *AccessGrant) pulumi.StringOutput { return v.AccessGrantArn }).(pulumi.StringOutput)
}

// Unique ID of the S3 Access Grant.
func (o AccessGrantOutput) AccessGrantId() pulumi.StringOutput {
	return o.ApplyT(func(v *AccessGrant) pulumi.StringOutput { return v.AccessGrantId }).(pulumi.StringOutput)
}

// See Location Configuration below for more details.
func (o AccessGrantOutput) AccessGrantsLocationConfiguration() AccessGrantAccessGrantsLocationConfigurationPtrOutput {
	return o.ApplyT(func(v *AccessGrant) AccessGrantAccessGrantsLocationConfigurationPtrOutput {
		return v.AccessGrantsLocationConfiguration
	}).(AccessGrantAccessGrantsLocationConfigurationPtrOutput)
}

// The ID of the S3 Access Grants location to with the access grant is giving access.
func (o AccessGrantOutput) AccessGrantsLocationId() pulumi.StringOutput {
	return o.ApplyT(func(v *AccessGrant) pulumi.StringOutput { return v.AccessGrantsLocationId }).(pulumi.StringOutput)
}

func (o AccessGrantOutput) AccountId() pulumi.StringOutput {
	return o.ApplyT(func(v *AccessGrant) pulumi.StringOutput { return v.AccountId }).(pulumi.StringOutput)
}

// The access grant's scope.
func (o AccessGrantOutput) GrantScope() pulumi.StringOutput {
	return o.ApplyT(func(v *AccessGrant) pulumi.StringOutput { return v.GrantScope }).(pulumi.StringOutput)
}

// See Grantee below for more details.
func (o AccessGrantOutput) Grantee() AccessGrantGranteePtrOutput {
	return o.ApplyT(func(v *AccessGrant) AccessGrantGranteePtrOutput { return v.Grantee }).(AccessGrantGranteePtrOutput)
}

// The access grant's level of access. Valid values: `READ`, `WRITE`, `READWRITE`.
func (o AccessGrantOutput) Permission() pulumi.StringOutput {
	return o.ApplyT(func(v *AccessGrant) pulumi.StringOutput { return v.Permission }).(pulumi.StringOutput)
}

// If you are creating an access grant that grants access to only one object, set this to `Object`. Valid values: `Object`.
func (o AccessGrantOutput) S3PrefixType() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AccessGrant) pulumi.StringPtrOutput { return v.S3PrefixType }).(pulumi.StringPtrOutput)
}

// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o AccessGrantOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *AccessGrant) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o AccessGrantOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *AccessGrant) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type AccessGrantArrayOutput struct{ *pulumi.OutputState }

func (AccessGrantArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AccessGrant)(nil)).Elem()
}

func (o AccessGrantArrayOutput) ToAccessGrantArrayOutput() AccessGrantArrayOutput {
	return o
}

func (o AccessGrantArrayOutput) ToAccessGrantArrayOutputWithContext(ctx context.Context) AccessGrantArrayOutput {
	return o
}

func (o AccessGrantArrayOutput) Index(i pulumi.IntInput) AccessGrantOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *AccessGrant {
		return vs[0].([]*AccessGrant)[vs[1].(int)]
	}).(AccessGrantOutput)
}

type AccessGrantMapOutput struct{ *pulumi.OutputState }

func (AccessGrantMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AccessGrant)(nil)).Elem()
}

func (o AccessGrantMapOutput) ToAccessGrantMapOutput() AccessGrantMapOutput {
	return o
}

func (o AccessGrantMapOutput) ToAccessGrantMapOutputWithContext(ctx context.Context) AccessGrantMapOutput {
	return o
}

func (o AccessGrantMapOutput) MapIndex(k pulumi.StringInput) AccessGrantOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *AccessGrant {
		return vs[0].(map[string]*AccessGrant)[vs[1].(string)]
	}).(AccessGrantOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AccessGrantInput)(nil)).Elem(), &AccessGrant{})
	pulumi.RegisterInputType(reflect.TypeOf((*AccessGrantArrayInput)(nil)).Elem(), AccessGrantArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AccessGrantMapInput)(nil)).Elem(), AccessGrantMap{})
	pulumi.RegisterOutputType(AccessGrantOutput{})
	pulumi.RegisterOutputType(AccessGrantArrayOutput{})
	pulumi.RegisterOutputType(AccessGrantMapOutput{})
}
