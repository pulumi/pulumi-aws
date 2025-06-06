// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package ssm

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func GetParametersByPath(ctx *pulumi.Context, args *GetParametersByPathArgs, opts ...pulumi.InvokeOption) (*GetParametersByPathResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetParametersByPathResult
	err := ctx.Invoke("aws:ssm/getParametersByPath:getParametersByPath", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getParametersByPath.
type GetParametersByPathArgs struct {
	// The hierarchy for the parameter. Hierarchies start with a forward slash (/). The hierarchy is the parameter name except the last part of the parameter. The last part of the parameter name can't be in the path. A parameter name hierarchy can have a maximum of 15 levels. **Note:** If the parameter name (e.g., `/my-app/my-param`) is specified, the data source will not retrieve any value as designed, unless there are other parameters that happen to use the former path in their hierarchy (e.g., `/my-app/my-param/my-actual-param`).
	Path string `pulumi:"path"`
	// Whether to retrieve all parameters within the hirerachy. Defaults to `false`.
	Recursive *bool `pulumi:"recursive"`
	// Whether to retrieve all parameters in the hierarchy, particularly those of `SecureString` type, with their value decrypted. Defaults to `true`.
	WithDecryption *bool `pulumi:"withDecryption"`
}

// A collection of values returned by getParametersByPath.
type GetParametersByPathResult struct {
	// A list that contains the Amazon Resource Names (ARNs) of the retrieved parameters.
	Arns []string `pulumi:"arns"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// A list that contains the names of the retrieved parameters.
	Names     []string `pulumi:"names"`
	Path      string   `pulumi:"path"`
	Recursive *bool    `pulumi:"recursive"`
	// A list that contains the types (`String`, `StringList`, or `SecureString`) of retrieved parameters.
	Types []string `pulumi:"types"`
	// A list that contains the retrieved parameter values. **Note:** This value is always marked as sensitive in the pulumi preview output, regardless of whether any retrieved parameters are of `SecureString` type. Use the `nonsensitive` function to override the behavior at your own risk and discretion, if you are certain that there are no sensitive values being retrieved.
	Values         []string `pulumi:"values"`
	WithDecryption *bool    `pulumi:"withDecryption"`
}

func GetParametersByPathOutput(ctx *pulumi.Context, args GetParametersByPathOutputArgs, opts ...pulumi.InvokeOption) GetParametersByPathResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetParametersByPathResultOutput, error) {
			args := v.(GetParametersByPathArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:ssm/getParametersByPath:getParametersByPath", args, GetParametersByPathResultOutput{}, options).(GetParametersByPathResultOutput), nil
		}).(GetParametersByPathResultOutput)
}

// A collection of arguments for invoking getParametersByPath.
type GetParametersByPathOutputArgs struct {
	// The hierarchy for the parameter. Hierarchies start with a forward slash (/). The hierarchy is the parameter name except the last part of the parameter. The last part of the parameter name can't be in the path. A parameter name hierarchy can have a maximum of 15 levels. **Note:** If the parameter name (e.g., `/my-app/my-param`) is specified, the data source will not retrieve any value as designed, unless there are other parameters that happen to use the former path in their hierarchy (e.g., `/my-app/my-param/my-actual-param`).
	Path pulumi.StringInput `pulumi:"path"`
	// Whether to retrieve all parameters within the hirerachy. Defaults to `false`.
	Recursive pulumi.BoolPtrInput `pulumi:"recursive"`
	// Whether to retrieve all parameters in the hierarchy, particularly those of `SecureString` type, with their value decrypted. Defaults to `true`.
	WithDecryption pulumi.BoolPtrInput `pulumi:"withDecryption"`
}

func (GetParametersByPathOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetParametersByPathArgs)(nil)).Elem()
}

// A collection of values returned by getParametersByPath.
type GetParametersByPathResultOutput struct{ *pulumi.OutputState }

func (GetParametersByPathResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetParametersByPathResult)(nil)).Elem()
}

func (o GetParametersByPathResultOutput) ToGetParametersByPathResultOutput() GetParametersByPathResultOutput {
	return o
}

func (o GetParametersByPathResultOutput) ToGetParametersByPathResultOutputWithContext(ctx context.Context) GetParametersByPathResultOutput {
	return o
}

// A list that contains the Amazon Resource Names (ARNs) of the retrieved parameters.
func (o GetParametersByPathResultOutput) Arns() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetParametersByPathResult) []string { return v.Arns }).(pulumi.StringArrayOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o GetParametersByPathResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetParametersByPathResult) string { return v.Id }).(pulumi.StringOutput)
}

// A list that contains the names of the retrieved parameters.
func (o GetParametersByPathResultOutput) Names() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetParametersByPathResult) []string { return v.Names }).(pulumi.StringArrayOutput)
}

func (o GetParametersByPathResultOutput) Path() pulumi.StringOutput {
	return o.ApplyT(func(v GetParametersByPathResult) string { return v.Path }).(pulumi.StringOutput)
}

func (o GetParametersByPathResultOutput) Recursive() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v GetParametersByPathResult) *bool { return v.Recursive }).(pulumi.BoolPtrOutput)
}

// A list that contains the types (`String`, `StringList`, or `SecureString`) of retrieved parameters.
func (o GetParametersByPathResultOutput) Types() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetParametersByPathResult) []string { return v.Types }).(pulumi.StringArrayOutput)
}

// A list that contains the retrieved parameter values. **Note:** This value is always marked as sensitive in the pulumi preview output, regardless of whether any retrieved parameters are of `SecureString` type. Use the `nonsensitive` function to override the behavior at your own risk and discretion, if you are certain that there are no sensitive values being retrieved.
func (o GetParametersByPathResultOutput) Values() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetParametersByPathResult) []string { return v.Values }).(pulumi.StringArrayOutput)
}

func (o GetParametersByPathResultOutput) WithDecryption() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v GetParametersByPathResult) *bool { return v.WithDecryption }).(pulumi.BoolPtrOutput)
}

func init() {
	pulumi.RegisterOutputType(GetParametersByPathResultOutput{})
}
