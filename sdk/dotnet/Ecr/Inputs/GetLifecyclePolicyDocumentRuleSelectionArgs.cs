// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecr.Inputs
{

    public sealed class GetLifecyclePolicyDocumentRuleSelectionInputArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specify a count number. If the `count_type` used is "imageCountMoreThan", then the value is the maximum number of images that you want to retain in your repository. If the `count_type` used is "sinceImagePushed", then the value is the maximum age limit for your images.
        /// </summary>
        [Input("countNumber", required: true)]
        public Input<int> CountNumber { get; set; } = null!;

        /// <summary>
        /// Specify a count type to apply to the images. If `count_type` is set to "imageCountMoreThan", you also specify `count_number` to create a rule that sets a limit on the number of images that exist in your repository. If `count_type` is set to "sinceImagePushed", you also specify `count_unit` and `count_number` to specify a time limit on the images that exist in your repository.
        /// </summary>
        [Input("countType", required: true)]
        public Input<string> CountType { get; set; } = null!;

        /// <summary>
        /// Specify a count unit of days to indicate that as the unit of time, in addition to `count_number`, which is the number of days.
        /// </summary>
        [Input("countUnit")]
        public Input<string>? CountUnit { get; set; }

        [Input("tagPatternLists")]
        private InputList<string>? _tagPatternLists;

        /// <summary>
        /// You must specify a comma-separated list of image tag patterns that may contain wildcards (\*) on which to take action with your lifecycle policy. For example, if your images are tagged as `prod`, `prod1`, `prod2`, and so on, you would use the tag pattern list `["prod\*"]` to specify all of them. If you specify multiple tags, only the images with all specified tags are selected. There is a maximum limit of four wildcards (\*) per string. For example, `["*test*1*2*3", "test*1*2*3*"]` is valid but `["test*1*2*3*4*5*6"]` is invalid.
        /// </summary>
        public InputList<string> TagPatternLists
        {
            get => _tagPatternLists ?? (_tagPatternLists = new InputList<string>());
            set => _tagPatternLists = value;
        }

        [Input("tagPrefixLists")]
        private InputList<string>? _tagPrefixLists;

        /// <summary>
        /// You must specify a comma-separated list of image tag prefixes on which to take action with your lifecycle policy. For example, if your images are tagged as `prod`, `prod1`, `prod2`, and so on, you would use the tag prefix "prod" to specify all of them. If you specify multiple tags, only images with all specified tags are selected.
        /// </summary>
        public InputList<string> TagPrefixLists
        {
            get => _tagPrefixLists ?? (_tagPrefixLists = new InputList<string>());
            set => _tagPrefixLists = value;
        }

        /// <summary>
        /// Determines whether the lifecycle policy rule that you are adding specifies a tag for an image. Acceptable options are "tagged", "untagged", or "any". If you specify "any", then all images have the rule applied to them. If you specify "tagged", then you must also specify a `tag_prefix_list` value. If you specify "untagged", then you must omit `tag_prefix_list`.
        /// </summary>
        [Input("tagStatus", required: true)]
        public Input<string> TagStatus { get; set; } = null!;

        public GetLifecyclePolicyDocumentRuleSelectionInputArgs()
        {
        }
        public static new GetLifecyclePolicyDocumentRuleSelectionInputArgs Empty => new GetLifecyclePolicyDocumentRuleSelectionInputArgs();
    }
}
