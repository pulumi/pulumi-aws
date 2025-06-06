// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package connect

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an Amazon Connect Vocabulary resource. For more information see
// [Amazon Connect: Getting Started](https://docs.aws.amazon.com/connect/latest/adminguide/amazon-connect-get-started.html)
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/connect"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := connect.NewVocabulary(ctx, "example", &connect.VocabularyArgs{
//				InstanceId:   pulumi.String("aaaaaaaa-bbbb-cccc-dddd-111111111111"),
//				Name:         pulumi.String("example"),
//				Content:      pulumi.String("Phrase	IPA	SoundsLike	DisplayAs\nLos-Angeles			Los Angeles\nF.B.I.	ɛ f b i aɪ		FBI\nEtienne		eh-tee-en	"),
//				LanguageCode: pulumi.String("en-US"),
//				Tags: pulumi.StringMap{
//					"Key1": pulumi.String("Value1"),
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
// Using `pulumi import`, import Amazon Connect Vocabularies using the `instance_id` and `vocabulary_id` separated by a colon (`:`). For example:
//
// ```sh
// $ pulumi import aws:connect/vocabulary:Vocabulary example f1288a1f-6193-445a-b47e-af739b2:c1d4e5f6-1b3c-1b3c-1b3c-c1d4e5f6c1d4e5
// ```
type Vocabulary struct {
	pulumi.CustomResourceState

	// The Amazon Resource Name (ARN) of the vocabulary.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The content of the custom vocabulary in plain-text format with a table of values. Each row in the table represents a word or a phrase, described with Phrase, IPA, SoundsLike, and DisplayAs fields. Separate the fields with TAB characters. For more information, see [Create a custom vocabulary using a table](https://docs.aws.amazon.com/transcribe/latest/dg/custom-vocabulary.html#create-vocabulary-table). Minimum length of `1`. Maximum length of `60000`.
	Content pulumi.StringOutput `pulumi:"content"`
	// The reason why the custom vocabulary was not created.
	FailureReason pulumi.StringOutput `pulumi:"failureReason"`
	// Specifies the identifier of the hosting Amazon Connect Instance.
	InstanceId pulumi.StringOutput `pulumi:"instanceId"`
	// The language code of the vocabulary entries. For a list of languages and their corresponding language codes, see [What is Amazon Transcribe?](https://docs.aws.amazon.com/transcribe/latest/dg/transcribe-whatis.html). Valid Values are `ar-AE`, `de-CH`, `de-DE`, `en-AB`, `en-AU`, `en-GB`, `en-IE`, `en-IN`, `en-US`, `en-WL`, `es-ES`, `es-US`, `fr-CA`, `fr-FR`, `hi-IN`, `it-IT`, `ja-JP`, `ko-KR`, `pt-BR`, `pt-PT`, `zh-CN`.
	LanguageCode pulumi.StringOutput `pulumi:"languageCode"`
	// The timestamp when the custom vocabulary was last modified.
	LastModifiedTime pulumi.StringOutput `pulumi:"lastModifiedTime"`
	// A unique name of the custom vocabulary. Must not be more than 140 characters.
	Name pulumi.StringOutput `pulumi:"name"`
	// The current state of the custom vocabulary. Valid values are `CREATION_IN_PROGRESS`, `ACTIVE`, `CREATION_FAILED`, `DELETE_IN_PROGRESS`.
	State pulumi.StringOutput `pulumi:"state"`
	// Tags to apply to the vocabulary. If configured with a provider
	// `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// The identifier of the custom vocabulary.
	VocabularyId pulumi.StringOutput `pulumi:"vocabularyId"`
}

// NewVocabulary registers a new resource with the given unique name, arguments, and options.
func NewVocabulary(ctx *pulumi.Context,
	name string, args *VocabularyArgs, opts ...pulumi.ResourceOption) (*Vocabulary, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Content == nil {
		return nil, errors.New("invalid value for required argument 'Content'")
	}
	if args.InstanceId == nil {
		return nil, errors.New("invalid value for required argument 'InstanceId'")
	}
	if args.LanguageCode == nil {
		return nil, errors.New("invalid value for required argument 'LanguageCode'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Vocabulary
	err := ctx.RegisterResource("aws:connect/vocabulary:Vocabulary", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetVocabulary gets an existing Vocabulary resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetVocabulary(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *VocabularyState, opts ...pulumi.ResourceOption) (*Vocabulary, error) {
	var resource Vocabulary
	err := ctx.ReadResource("aws:connect/vocabulary:Vocabulary", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Vocabulary resources.
type vocabularyState struct {
	// The Amazon Resource Name (ARN) of the vocabulary.
	Arn *string `pulumi:"arn"`
	// The content of the custom vocabulary in plain-text format with a table of values. Each row in the table represents a word or a phrase, described with Phrase, IPA, SoundsLike, and DisplayAs fields. Separate the fields with TAB characters. For more information, see [Create a custom vocabulary using a table](https://docs.aws.amazon.com/transcribe/latest/dg/custom-vocabulary.html#create-vocabulary-table). Minimum length of `1`. Maximum length of `60000`.
	Content *string `pulumi:"content"`
	// The reason why the custom vocabulary was not created.
	FailureReason *string `pulumi:"failureReason"`
	// Specifies the identifier of the hosting Amazon Connect Instance.
	InstanceId *string `pulumi:"instanceId"`
	// The language code of the vocabulary entries. For a list of languages and their corresponding language codes, see [What is Amazon Transcribe?](https://docs.aws.amazon.com/transcribe/latest/dg/transcribe-whatis.html). Valid Values are `ar-AE`, `de-CH`, `de-DE`, `en-AB`, `en-AU`, `en-GB`, `en-IE`, `en-IN`, `en-US`, `en-WL`, `es-ES`, `es-US`, `fr-CA`, `fr-FR`, `hi-IN`, `it-IT`, `ja-JP`, `ko-KR`, `pt-BR`, `pt-PT`, `zh-CN`.
	LanguageCode *string `pulumi:"languageCode"`
	// The timestamp when the custom vocabulary was last modified.
	LastModifiedTime *string `pulumi:"lastModifiedTime"`
	// A unique name of the custom vocabulary. Must not be more than 140 characters.
	Name *string `pulumi:"name"`
	// The current state of the custom vocabulary. Valid values are `CREATION_IN_PROGRESS`, `ACTIVE`, `CREATION_FAILED`, `DELETE_IN_PROGRESS`.
	State *string `pulumi:"state"`
	// Tags to apply to the vocabulary. If configured with a provider
	// `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// The identifier of the custom vocabulary.
	VocabularyId *string `pulumi:"vocabularyId"`
}

type VocabularyState struct {
	// The Amazon Resource Name (ARN) of the vocabulary.
	Arn pulumi.StringPtrInput
	// The content of the custom vocabulary in plain-text format with a table of values. Each row in the table represents a word or a phrase, described with Phrase, IPA, SoundsLike, and DisplayAs fields. Separate the fields with TAB characters. For more information, see [Create a custom vocabulary using a table](https://docs.aws.amazon.com/transcribe/latest/dg/custom-vocabulary.html#create-vocabulary-table). Minimum length of `1`. Maximum length of `60000`.
	Content pulumi.StringPtrInput
	// The reason why the custom vocabulary was not created.
	FailureReason pulumi.StringPtrInput
	// Specifies the identifier of the hosting Amazon Connect Instance.
	InstanceId pulumi.StringPtrInput
	// The language code of the vocabulary entries. For a list of languages and their corresponding language codes, see [What is Amazon Transcribe?](https://docs.aws.amazon.com/transcribe/latest/dg/transcribe-whatis.html). Valid Values are `ar-AE`, `de-CH`, `de-DE`, `en-AB`, `en-AU`, `en-GB`, `en-IE`, `en-IN`, `en-US`, `en-WL`, `es-ES`, `es-US`, `fr-CA`, `fr-FR`, `hi-IN`, `it-IT`, `ja-JP`, `ko-KR`, `pt-BR`, `pt-PT`, `zh-CN`.
	LanguageCode pulumi.StringPtrInput
	// The timestamp when the custom vocabulary was last modified.
	LastModifiedTime pulumi.StringPtrInput
	// A unique name of the custom vocabulary. Must not be more than 140 characters.
	Name pulumi.StringPtrInput
	// The current state of the custom vocabulary. Valid values are `CREATION_IN_PROGRESS`, `ACTIVE`, `CREATION_FAILED`, `DELETE_IN_PROGRESS`.
	State pulumi.StringPtrInput
	// Tags to apply to the vocabulary. If configured with a provider
	// `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// The identifier of the custom vocabulary.
	VocabularyId pulumi.StringPtrInput
}

func (VocabularyState) ElementType() reflect.Type {
	return reflect.TypeOf((*vocabularyState)(nil)).Elem()
}

type vocabularyArgs struct {
	// The content of the custom vocabulary in plain-text format with a table of values. Each row in the table represents a word or a phrase, described with Phrase, IPA, SoundsLike, and DisplayAs fields. Separate the fields with TAB characters. For more information, see [Create a custom vocabulary using a table](https://docs.aws.amazon.com/transcribe/latest/dg/custom-vocabulary.html#create-vocabulary-table). Minimum length of `1`. Maximum length of `60000`.
	Content string `pulumi:"content"`
	// Specifies the identifier of the hosting Amazon Connect Instance.
	InstanceId string `pulumi:"instanceId"`
	// The language code of the vocabulary entries. For a list of languages and their corresponding language codes, see [What is Amazon Transcribe?](https://docs.aws.amazon.com/transcribe/latest/dg/transcribe-whatis.html). Valid Values are `ar-AE`, `de-CH`, `de-DE`, `en-AB`, `en-AU`, `en-GB`, `en-IE`, `en-IN`, `en-US`, `en-WL`, `es-ES`, `es-US`, `fr-CA`, `fr-FR`, `hi-IN`, `it-IT`, `ja-JP`, `ko-KR`, `pt-BR`, `pt-PT`, `zh-CN`.
	LanguageCode string `pulumi:"languageCode"`
	// A unique name of the custom vocabulary. Must not be more than 140 characters.
	Name *string `pulumi:"name"`
	// Tags to apply to the vocabulary. If configured with a provider
	// `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a Vocabulary resource.
type VocabularyArgs struct {
	// The content of the custom vocabulary in plain-text format with a table of values. Each row in the table represents a word or a phrase, described with Phrase, IPA, SoundsLike, and DisplayAs fields. Separate the fields with TAB characters. For more information, see [Create a custom vocabulary using a table](https://docs.aws.amazon.com/transcribe/latest/dg/custom-vocabulary.html#create-vocabulary-table). Minimum length of `1`. Maximum length of `60000`.
	Content pulumi.StringInput
	// Specifies the identifier of the hosting Amazon Connect Instance.
	InstanceId pulumi.StringInput
	// The language code of the vocabulary entries. For a list of languages and their corresponding language codes, see [What is Amazon Transcribe?](https://docs.aws.amazon.com/transcribe/latest/dg/transcribe-whatis.html). Valid Values are `ar-AE`, `de-CH`, `de-DE`, `en-AB`, `en-AU`, `en-GB`, `en-IE`, `en-IN`, `en-US`, `en-WL`, `es-ES`, `es-US`, `fr-CA`, `fr-FR`, `hi-IN`, `it-IT`, `ja-JP`, `ko-KR`, `pt-BR`, `pt-PT`, `zh-CN`.
	LanguageCode pulumi.StringInput
	// A unique name of the custom vocabulary. Must not be more than 140 characters.
	Name pulumi.StringPtrInput
	// Tags to apply to the vocabulary. If configured with a provider
	// `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (VocabularyArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*vocabularyArgs)(nil)).Elem()
}

type VocabularyInput interface {
	pulumi.Input

	ToVocabularyOutput() VocabularyOutput
	ToVocabularyOutputWithContext(ctx context.Context) VocabularyOutput
}

func (*Vocabulary) ElementType() reflect.Type {
	return reflect.TypeOf((**Vocabulary)(nil)).Elem()
}

func (i *Vocabulary) ToVocabularyOutput() VocabularyOutput {
	return i.ToVocabularyOutputWithContext(context.Background())
}

func (i *Vocabulary) ToVocabularyOutputWithContext(ctx context.Context) VocabularyOutput {
	return pulumi.ToOutputWithContext(ctx, i).(VocabularyOutput)
}

// VocabularyArrayInput is an input type that accepts VocabularyArray and VocabularyArrayOutput values.
// You can construct a concrete instance of `VocabularyArrayInput` via:
//
//	VocabularyArray{ VocabularyArgs{...} }
type VocabularyArrayInput interface {
	pulumi.Input

	ToVocabularyArrayOutput() VocabularyArrayOutput
	ToVocabularyArrayOutputWithContext(context.Context) VocabularyArrayOutput
}

type VocabularyArray []VocabularyInput

func (VocabularyArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Vocabulary)(nil)).Elem()
}

func (i VocabularyArray) ToVocabularyArrayOutput() VocabularyArrayOutput {
	return i.ToVocabularyArrayOutputWithContext(context.Background())
}

func (i VocabularyArray) ToVocabularyArrayOutputWithContext(ctx context.Context) VocabularyArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(VocabularyArrayOutput)
}

// VocabularyMapInput is an input type that accepts VocabularyMap and VocabularyMapOutput values.
// You can construct a concrete instance of `VocabularyMapInput` via:
//
//	VocabularyMap{ "key": VocabularyArgs{...} }
type VocabularyMapInput interface {
	pulumi.Input

	ToVocabularyMapOutput() VocabularyMapOutput
	ToVocabularyMapOutputWithContext(context.Context) VocabularyMapOutput
}

type VocabularyMap map[string]VocabularyInput

func (VocabularyMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Vocabulary)(nil)).Elem()
}

func (i VocabularyMap) ToVocabularyMapOutput() VocabularyMapOutput {
	return i.ToVocabularyMapOutputWithContext(context.Background())
}

func (i VocabularyMap) ToVocabularyMapOutputWithContext(ctx context.Context) VocabularyMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(VocabularyMapOutput)
}

type VocabularyOutput struct{ *pulumi.OutputState }

func (VocabularyOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Vocabulary)(nil)).Elem()
}

func (o VocabularyOutput) ToVocabularyOutput() VocabularyOutput {
	return o
}

func (o VocabularyOutput) ToVocabularyOutputWithContext(ctx context.Context) VocabularyOutput {
	return o
}

// The Amazon Resource Name (ARN) of the vocabulary.
func (o VocabularyOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Vocabulary) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The content of the custom vocabulary in plain-text format with a table of values. Each row in the table represents a word or a phrase, described with Phrase, IPA, SoundsLike, and DisplayAs fields. Separate the fields with TAB characters. For more information, see [Create a custom vocabulary using a table](https://docs.aws.amazon.com/transcribe/latest/dg/custom-vocabulary.html#create-vocabulary-table). Minimum length of `1`. Maximum length of `60000`.
func (o VocabularyOutput) Content() pulumi.StringOutput {
	return o.ApplyT(func(v *Vocabulary) pulumi.StringOutput { return v.Content }).(pulumi.StringOutput)
}

// The reason why the custom vocabulary was not created.
func (o VocabularyOutput) FailureReason() pulumi.StringOutput {
	return o.ApplyT(func(v *Vocabulary) pulumi.StringOutput { return v.FailureReason }).(pulumi.StringOutput)
}

// Specifies the identifier of the hosting Amazon Connect Instance.
func (o VocabularyOutput) InstanceId() pulumi.StringOutput {
	return o.ApplyT(func(v *Vocabulary) pulumi.StringOutput { return v.InstanceId }).(pulumi.StringOutput)
}

// The language code of the vocabulary entries. For a list of languages and their corresponding language codes, see [What is Amazon Transcribe?](https://docs.aws.amazon.com/transcribe/latest/dg/transcribe-whatis.html). Valid Values are `ar-AE`, `de-CH`, `de-DE`, `en-AB`, `en-AU`, `en-GB`, `en-IE`, `en-IN`, `en-US`, `en-WL`, `es-ES`, `es-US`, `fr-CA`, `fr-FR`, `hi-IN`, `it-IT`, `ja-JP`, `ko-KR`, `pt-BR`, `pt-PT`, `zh-CN`.
func (o VocabularyOutput) LanguageCode() pulumi.StringOutput {
	return o.ApplyT(func(v *Vocabulary) pulumi.StringOutput { return v.LanguageCode }).(pulumi.StringOutput)
}

// The timestamp when the custom vocabulary was last modified.
func (o VocabularyOutput) LastModifiedTime() pulumi.StringOutput {
	return o.ApplyT(func(v *Vocabulary) pulumi.StringOutput { return v.LastModifiedTime }).(pulumi.StringOutput)
}

// A unique name of the custom vocabulary. Must not be more than 140 characters.
func (o VocabularyOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *Vocabulary) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// The current state of the custom vocabulary. Valid values are `CREATION_IN_PROGRESS`, `ACTIVE`, `CREATION_FAILED`, `DELETE_IN_PROGRESS`.
func (o VocabularyOutput) State() pulumi.StringOutput {
	return o.ApplyT(func(v *Vocabulary) pulumi.StringOutput { return v.State }).(pulumi.StringOutput)
}

// Tags to apply to the vocabulary. If configured with a provider
// `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o VocabularyOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Vocabulary) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o VocabularyOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Vocabulary) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// The identifier of the custom vocabulary.
func (o VocabularyOutput) VocabularyId() pulumi.StringOutput {
	return o.ApplyT(func(v *Vocabulary) pulumi.StringOutput { return v.VocabularyId }).(pulumi.StringOutput)
}

type VocabularyArrayOutput struct{ *pulumi.OutputState }

func (VocabularyArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Vocabulary)(nil)).Elem()
}

func (o VocabularyArrayOutput) ToVocabularyArrayOutput() VocabularyArrayOutput {
	return o
}

func (o VocabularyArrayOutput) ToVocabularyArrayOutputWithContext(ctx context.Context) VocabularyArrayOutput {
	return o
}

func (o VocabularyArrayOutput) Index(i pulumi.IntInput) VocabularyOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Vocabulary {
		return vs[0].([]*Vocabulary)[vs[1].(int)]
	}).(VocabularyOutput)
}

type VocabularyMapOutput struct{ *pulumi.OutputState }

func (VocabularyMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Vocabulary)(nil)).Elem()
}

func (o VocabularyMapOutput) ToVocabularyMapOutput() VocabularyMapOutput {
	return o
}

func (o VocabularyMapOutput) ToVocabularyMapOutputWithContext(ctx context.Context) VocabularyMapOutput {
	return o
}

func (o VocabularyMapOutput) MapIndex(k pulumi.StringInput) VocabularyOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Vocabulary {
		return vs[0].(map[string]*Vocabulary)[vs[1].(string)]
	}).(VocabularyOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*VocabularyInput)(nil)).Elem(), &Vocabulary{})
	pulumi.RegisterInputType(reflect.TypeOf((*VocabularyArrayInput)(nil)).Elem(), VocabularyArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*VocabularyMapInput)(nil)).Elem(), VocabularyMap{})
	pulumi.RegisterOutputType(VocabularyOutput{})
	pulumi.RegisterOutputType(VocabularyArrayOutput{})
	pulumi.RegisterOutputType(VocabularyMapOutput{})
}
