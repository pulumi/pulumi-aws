// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ecr.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetLifecyclePolicyDocumentRuleSelectionArgs extends com.pulumi.resources.ResourceArgs {

    public static final GetLifecyclePolicyDocumentRuleSelectionArgs Empty = new GetLifecyclePolicyDocumentRuleSelectionArgs();

    /**
     * Specify a count number. If the `count_type` used is &#34;imageCountMoreThan&#34;, then the value is the maximum number of images that you want to retain in your repository. If the `count_type` used is &#34;sinceImagePushed&#34;, then the value is the maximum age limit for your images.
     * 
     */
    @Import(name="countNumber", required=true)
    private Output<Integer> countNumber;

    /**
     * @return Specify a count number. If the `count_type` used is &#34;imageCountMoreThan&#34;, then the value is the maximum number of images that you want to retain in your repository. If the `count_type` used is &#34;sinceImagePushed&#34;, then the value is the maximum age limit for your images.
     * 
     */
    public Output<Integer> countNumber() {
        return this.countNumber;
    }

    /**
     * Specify a count type to apply to the images. If `count_type` is set to &#34;imageCountMoreThan&#34;, you also specify `count_number` to create a rule that sets a limit on the number of images that exist in your repository. If `count_type` is set to &#34;sinceImagePushed&#34;, you also specify `count_unit` and `count_number` to specify a time limit on the images that exist in your repository.
     * 
     */
    @Import(name="countType", required=true)
    private Output<String> countType;

    /**
     * @return Specify a count type to apply to the images. If `count_type` is set to &#34;imageCountMoreThan&#34;, you also specify `count_number` to create a rule that sets a limit on the number of images that exist in your repository. If `count_type` is set to &#34;sinceImagePushed&#34;, you also specify `count_unit` and `count_number` to specify a time limit on the images that exist in your repository.
     * 
     */
    public Output<String> countType() {
        return this.countType;
    }

    /**
     * Specify a count unit of days to indicate that as the unit of time, in addition to `count_number`, which is the number of days.
     * 
     */
    @Import(name="countUnit")
    private @Nullable Output<String> countUnit;

    /**
     * @return Specify a count unit of days to indicate that as the unit of time, in addition to `count_number`, which is the number of days.
     * 
     */
    public Optional<Output<String>> countUnit() {
        return Optional.ofNullable(this.countUnit);
    }

    /**
     * You must specify a comma-separated list of image tag patterns that may contain wildcards (\*) on which to take action with your lifecycle policy. For example, if your images are tagged as `prod`, `prod1`, `prod2`, and so on, you would use the tag pattern list `[&#34;prod\*&#34;]` to specify all of them. If you specify multiple tags, only the images with all specified tags are selected. There is a maximum limit of four wildcards (\*) per string. For example, `[&#34;*test*1*2*3&#34;, &#34;test*1*2*3*&#34;]` is valid but `[&#34;test*1*2*3*4*5*6&#34;]` is invalid.
     * 
     */
    @Import(name="tagPatternLists")
    private @Nullable Output<List<String>> tagPatternLists;

    /**
     * @return You must specify a comma-separated list of image tag patterns that may contain wildcards (\*) on which to take action with your lifecycle policy. For example, if your images are tagged as `prod`, `prod1`, `prod2`, and so on, you would use the tag pattern list `[&#34;prod\*&#34;]` to specify all of them. If you specify multiple tags, only the images with all specified tags are selected. There is a maximum limit of four wildcards (\*) per string. For example, `[&#34;*test*1*2*3&#34;, &#34;test*1*2*3*&#34;]` is valid but `[&#34;test*1*2*3*4*5*6&#34;]` is invalid.
     * 
     */
    public Optional<Output<List<String>>> tagPatternLists() {
        return Optional.ofNullable(this.tagPatternLists);
    }

    /**
     * You must specify a comma-separated list of image tag prefixes on which to take action with your lifecycle policy. For example, if your images are tagged as `prod`, `prod1`, `prod2`, and so on, you would use the tag prefix &#34;prod&#34; to specify all of them. If you specify multiple tags, only images with all specified tags are selected.
     * 
     */
    @Import(name="tagPrefixLists")
    private @Nullable Output<List<String>> tagPrefixLists;

    /**
     * @return You must specify a comma-separated list of image tag prefixes on which to take action with your lifecycle policy. For example, if your images are tagged as `prod`, `prod1`, `prod2`, and so on, you would use the tag prefix &#34;prod&#34; to specify all of them. If you specify multiple tags, only images with all specified tags are selected.
     * 
     */
    public Optional<Output<List<String>>> tagPrefixLists() {
        return Optional.ofNullable(this.tagPrefixLists);
    }

    /**
     * Determines whether the lifecycle policy rule that you are adding specifies a tag for an image. Acceptable options are &#34;tagged&#34;, &#34;untagged&#34;, or &#34;any&#34;. If you specify &#34;any&#34;, then all images have the rule applied to them. If you specify &#34;tagged&#34;, then you must also specify a `tag_prefix_list` value. If you specify &#34;untagged&#34;, then you must omit `tag_prefix_list`.
     * 
     */
    @Import(name="tagStatus", required=true)
    private Output<String> tagStatus;

    /**
     * @return Determines whether the lifecycle policy rule that you are adding specifies a tag for an image. Acceptable options are &#34;tagged&#34;, &#34;untagged&#34;, or &#34;any&#34;. If you specify &#34;any&#34;, then all images have the rule applied to them. If you specify &#34;tagged&#34;, then you must also specify a `tag_prefix_list` value. If you specify &#34;untagged&#34;, then you must omit `tag_prefix_list`.
     * 
     */
    public Output<String> tagStatus() {
        return this.tagStatus;
    }

    private GetLifecyclePolicyDocumentRuleSelectionArgs() {}

    private GetLifecyclePolicyDocumentRuleSelectionArgs(GetLifecyclePolicyDocumentRuleSelectionArgs $) {
        this.countNumber = $.countNumber;
        this.countType = $.countType;
        this.countUnit = $.countUnit;
        this.tagPatternLists = $.tagPatternLists;
        this.tagPrefixLists = $.tagPrefixLists;
        this.tagStatus = $.tagStatus;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetLifecyclePolicyDocumentRuleSelectionArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetLifecyclePolicyDocumentRuleSelectionArgs $;

        public Builder() {
            $ = new GetLifecyclePolicyDocumentRuleSelectionArgs();
        }

        public Builder(GetLifecyclePolicyDocumentRuleSelectionArgs defaults) {
            $ = new GetLifecyclePolicyDocumentRuleSelectionArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param countNumber Specify a count number. If the `count_type` used is &#34;imageCountMoreThan&#34;, then the value is the maximum number of images that you want to retain in your repository. If the `count_type` used is &#34;sinceImagePushed&#34;, then the value is the maximum age limit for your images.
         * 
         * @return builder
         * 
         */
        public Builder countNumber(Output<Integer> countNumber) {
            $.countNumber = countNumber;
            return this;
        }

        /**
         * @param countNumber Specify a count number. If the `count_type` used is &#34;imageCountMoreThan&#34;, then the value is the maximum number of images that you want to retain in your repository. If the `count_type` used is &#34;sinceImagePushed&#34;, then the value is the maximum age limit for your images.
         * 
         * @return builder
         * 
         */
        public Builder countNumber(Integer countNumber) {
            return countNumber(Output.of(countNumber));
        }

        /**
         * @param countType Specify a count type to apply to the images. If `count_type` is set to &#34;imageCountMoreThan&#34;, you also specify `count_number` to create a rule that sets a limit on the number of images that exist in your repository. If `count_type` is set to &#34;sinceImagePushed&#34;, you also specify `count_unit` and `count_number` to specify a time limit on the images that exist in your repository.
         * 
         * @return builder
         * 
         */
        public Builder countType(Output<String> countType) {
            $.countType = countType;
            return this;
        }

        /**
         * @param countType Specify a count type to apply to the images. If `count_type` is set to &#34;imageCountMoreThan&#34;, you also specify `count_number` to create a rule that sets a limit on the number of images that exist in your repository. If `count_type` is set to &#34;sinceImagePushed&#34;, you also specify `count_unit` and `count_number` to specify a time limit on the images that exist in your repository.
         * 
         * @return builder
         * 
         */
        public Builder countType(String countType) {
            return countType(Output.of(countType));
        }

        /**
         * @param countUnit Specify a count unit of days to indicate that as the unit of time, in addition to `count_number`, which is the number of days.
         * 
         * @return builder
         * 
         */
        public Builder countUnit(@Nullable Output<String> countUnit) {
            $.countUnit = countUnit;
            return this;
        }

        /**
         * @param countUnit Specify a count unit of days to indicate that as the unit of time, in addition to `count_number`, which is the number of days.
         * 
         * @return builder
         * 
         */
        public Builder countUnit(String countUnit) {
            return countUnit(Output.of(countUnit));
        }

        /**
         * @param tagPatternLists You must specify a comma-separated list of image tag patterns that may contain wildcards (\*) on which to take action with your lifecycle policy. For example, if your images are tagged as `prod`, `prod1`, `prod2`, and so on, you would use the tag pattern list `[&#34;prod\*&#34;]` to specify all of them. If you specify multiple tags, only the images with all specified tags are selected. There is a maximum limit of four wildcards (\*) per string. For example, `[&#34;*test*1*2*3&#34;, &#34;test*1*2*3*&#34;]` is valid but `[&#34;test*1*2*3*4*5*6&#34;]` is invalid.
         * 
         * @return builder
         * 
         */
        public Builder tagPatternLists(@Nullable Output<List<String>> tagPatternLists) {
            $.tagPatternLists = tagPatternLists;
            return this;
        }

        /**
         * @param tagPatternLists You must specify a comma-separated list of image tag patterns that may contain wildcards (\*) on which to take action with your lifecycle policy. For example, if your images are tagged as `prod`, `prod1`, `prod2`, and so on, you would use the tag pattern list `[&#34;prod\*&#34;]` to specify all of them. If you specify multiple tags, only the images with all specified tags are selected. There is a maximum limit of four wildcards (\*) per string. For example, `[&#34;*test*1*2*3&#34;, &#34;test*1*2*3*&#34;]` is valid but `[&#34;test*1*2*3*4*5*6&#34;]` is invalid.
         * 
         * @return builder
         * 
         */
        public Builder tagPatternLists(List<String> tagPatternLists) {
            return tagPatternLists(Output.of(tagPatternLists));
        }

        /**
         * @param tagPatternLists You must specify a comma-separated list of image tag patterns that may contain wildcards (\*) on which to take action with your lifecycle policy. For example, if your images are tagged as `prod`, `prod1`, `prod2`, and so on, you would use the tag pattern list `[&#34;prod\*&#34;]` to specify all of them. If you specify multiple tags, only the images with all specified tags are selected. There is a maximum limit of four wildcards (\*) per string. For example, `[&#34;*test*1*2*3&#34;, &#34;test*1*2*3*&#34;]` is valid but `[&#34;test*1*2*3*4*5*6&#34;]` is invalid.
         * 
         * @return builder
         * 
         */
        public Builder tagPatternLists(String... tagPatternLists) {
            return tagPatternLists(List.of(tagPatternLists));
        }

        /**
         * @param tagPrefixLists You must specify a comma-separated list of image tag prefixes on which to take action with your lifecycle policy. For example, if your images are tagged as `prod`, `prod1`, `prod2`, and so on, you would use the tag prefix &#34;prod&#34; to specify all of them. If you specify multiple tags, only images with all specified tags are selected.
         * 
         * @return builder
         * 
         */
        public Builder tagPrefixLists(@Nullable Output<List<String>> tagPrefixLists) {
            $.tagPrefixLists = tagPrefixLists;
            return this;
        }

        /**
         * @param tagPrefixLists You must specify a comma-separated list of image tag prefixes on which to take action with your lifecycle policy. For example, if your images are tagged as `prod`, `prod1`, `prod2`, and so on, you would use the tag prefix &#34;prod&#34; to specify all of them. If you specify multiple tags, only images with all specified tags are selected.
         * 
         * @return builder
         * 
         */
        public Builder tagPrefixLists(List<String> tagPrefixLists) {
            return tagPrefixLists(Output.of(tagPrefixLists));
        }

        /**
         * @param tagPrefixLists You must specify a comma-separated list of image tag prefixes on which to take action with your lifecycle policy. For example, if your images are tagged as `prod`, `prod1`, `prod2`, and so on, you would use the tag prefix &#34;prod&#34; to specify all of them. If you specify multiple tags, only images with all specified tags are selected.
         * 
         * @return builder
         * 
         */
        public Builder tagPrefixLists(String... tagPrefixLists) {
            return tagPrefixLists(List.of(tagPrefixLists));
        }

        /**
         * @param tagStatus Determines whether the lifecycle policy rule that you are adding specifies a tag for an image. Acceptable options are &#34;tagged&#34;, &#34;untagged&#34;, or &#34;any&#34;. If you specify &#34;any&#34;, then all images have the rule applied to them. If you specify &#34;tagged&#34;, then you must also specify a `tag_prefix_list` value. If you specify &#34;untagged&#34;, then you must omit `tag_prefix_list`.
         * 
         * @return builder
         * 
         */
        public Builder tagStatus(Output<String> tagStatus) {
            $.tagStatus = tagStatus;
            return this;
        }

        /**
         * @param tagStatus Determines whether the lifecycle policy rule that you are adding specifies a tag for an image. Acceptable options are &#34;tagged&#34;, &#34;untagged&#34;, or &#34;any&#34;. If you specify &#34;any&#34;, then all images have the rule applied to them. If you specify &#34;tagged&#34;, then you must also specify a `tag_prefix_list` value. If you specify &#34;untagged&#34;, then you must omit `tag_prefix_list`.
         * 
         * @return builder
         * 
         */
        public Builder tagStatus(String tagStatus) {
            return tagStatus(Output.of(tagStatus));
        }

        public GetLifecyclePolicyDocumentRuleSelectionArgs build() {
            if ($.countNumber == null) {
                throw new MissingRequiredPropertyException("GetLifecyclePolicyDocumentRuleSelectionArgs", "countNumber");
            }
            if ($.countType == null) {
                throw new MissingRequiredPropertyException("GetLifecyclePolicyDocumentRuleSelectionArgs", "countType");
            }
            if ($.tagStatus == null) {
                throw new MissingRequiredPropertyException("GetLifecyclePolicyDocumentRuleSelectionArgs", "tagStatus");
            }
            return $;
        }
    }

}
