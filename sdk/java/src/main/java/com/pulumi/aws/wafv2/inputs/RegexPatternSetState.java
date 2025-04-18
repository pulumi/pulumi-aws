// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.aws.wafv2.inputs.RegexPatternSetRegularExpressionArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RegexPatternSetState extends com.pulumi.resources.ResourceArgs {

    public static final RegexPatternSetState Empty = new RegexPatternSetState();

    /**
     * The Amazon Resource Name (ARN) that identifies the cluster.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) that identifies the cluster.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * A friendly description of the regular expression pattern set.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return A friendly description of the regular expression pattern set.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    @Import(name="lockToken")
    private @Nullable Output<String> lockToken;

    public Optional<Output<String>> lockToken() {
        return Optional.ofNullable(this.lockToken);
    }

    /**
     * A friendly name of the regular expression pattern set. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return A friendly name of the regular expression pattern set. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     * 
     */
    @Import(name="namePrefix")
    private @Nullable Output<String> namePrefix;

    /**
     * @return Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     * 
     */
    public Optional<Output<String>> namePrefix() {
        return Optional.ofNullable(this.namePrefix);
    }

    /**
     * One or more blocks of regular expression patterns that you want AWS WAF to search for, such as `B[a{@literal @}]dB[o0]t`. See Regular Expression below for details. A maximum of 10 `regular_expression` blocks may be specified.
     * 
     */
    @Import(name="regularExpressions")
    private @Nullable Output<List<RegexPatternSetRegularExpressionArgs>> regularExpressions;

    /**
     * @return One or more blocks of regular expression patterns that you want AWS WAF to search for, such as `B[a{@literal @}]dB[o0]t`. See Regular Expression below for details. A maximum of 10 `regular_expression` blocks may be specified.
     * 
     */
    public Optional<Output<List<RegexPatternSetRegularExpressionArgs>>> regularExpressions() {
        return Optional.ofNullable(this.regularExpressions);
    }

    /**
     * Specifies whether this is for an AWS CloudFront distribution or for a regional application. Valid values are `CLOUDFRONT` or `REGIONAL`. To work with CloudFront, you must also specify the region `us-east-1` (N. Virginia) on the AWS provider.
     * 
     */
    @Import(name="scope")
    private @Nullable Output<String> scope;

    /**
     * @return Specifies whether this is for an AWS CloudFront distribution or for a regional application. Valid values are `CLOUDFRONT` or `REGIONAL`. To work with CloudFront, you must also specify the region `us-east-1` (N. Virginia) on the AWS provider.
     * 
     */
    public Optional<Output<String>> scope() {
        return Optional.ofNullable(this.scope);
    }

    /**
     * An array of key:value pairs to associate with the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return An array of key:value pairs to associate with the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    private RegexPatternSetState() {}

    private RegexPatternSetState(RegexPatternSetState $) {
        this.arn = $.arn;
        this.description = $.description;
        this.lockToken = $.lockToken;
        this.name = $.name;
        this.namePrefix = $.namePrefix;
        this.regularExpressions = $.regularExpressions;
        this.scope = $.scope;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RegexPatternSetState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RegexPatternSetState $;

        public Builder() {
            $ = new RegexPatternSetState();
        }

        public Builder(RegexPatternSetState defaults) {
            $ = new RegexPatternSetState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn The Amazon Resource Name (ARN) that identifies the cluster.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn The Amazon Resource Name (ARN) that identifies the cluster.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param description A friendly description of the regular expression pattern set.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description A friendly description of the regular expression pattern set.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        public Builder lockToken(@Nullable Output<String> lockToken) {
            $.lockToken = lockToken;
            return this;
        }

        public Builder lockToken(String lockToken) {
            return lockToken(Output.of(lockToken));
        }

        /**
         * @param name A friendly name of the regular expression pattern set. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name A friendly name of the regular expression pattern set. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param namePrefix Creates a unique name beginning with the specified prefix. Conflicts with `name`.
         * 
         * @return builder
         * 
         */
        public Builder namePrefix(@Nullable Output<String> namePrefix) {
            $.namePrefix = namePrefix;
            return this;
        }

        /**
         * @param namePrefix Creates a unique name beginning with the specified prefix. Conflicts with `name`.
         * 
         * @return builder
         * 
         */
        public Builder namePrefix(String namePrefix) {
            return namePrefix(Output.of(namePrefix));
        }

        /**
         * @param regularExpressions One or more blocks of regular expression patterns that you want AWS WAF to search for, such as `B[a{@literal @}]dB[o0]t`. See Regular Expression below for details. A maximum of 10 `regular_expression` blocks may be specified.
         * 
         * @return builder
         * 
         */
        public Builder regularExpressions(@Nullable Output<List<RegexPatternSetRegularExpressionArgs>> regularExpressions) {
            $.regularExpressions = regularExpressions;
            return this;
        }

        /**
         * @param regularExpressions One or more blocks of regular expression patterns that you want AWS WAF to search for, such as `B[a{@literal @}]dB[o0]t`. See Regular Expression below for details. A maximum of 10 `regular_expression` blocks may be specified.
         * 
         * @return builder
         * 
         */
        public Builder regularExpressions(List<RegexPatternSetRegularExpressionArgs> regularExpressions) {
            return regularExpressions(Output.of(regularExpressions));
        }

        /**
         * @param regularExpressions One or more blocks of regular expression patterns that you want AWS WAF to search for, such as `B[a{@literal @}]dB[o0]t`. See Regular Expression below for details. A maximum of 10 `regular_expression` blocks may be specified.
         * 
         * @return builder
         * 
         */
        public Builder regularExpressions(RegexPatternSetRegularExpressionArgs... regularExpressions) {
            return regularExpressions(List.of(regularExpressions));
        }

        /**
         * @param scope Specifies whether this is for an AWS CloudFront distribution or for a regional application. Valid values are `CLOUDFRONT` or `REGIONAL`. To work with CloudFront, you must also specify the region `us-east-1` (N. Virginia) on the AWS provider.
         * 
         * @return builder
         * 
         */
        public Builder scope(@Nullable Output<String> scope) {
            $.scope = scope;
            return this;
        }

        /**
         * @param scope Specifies whether this is for an AWS CloudFront distribution or for a regional application. Valid values are `CLOUDFRONT` or `REGIONAL`. To work with CloudFront, you must also specify the region `us-east-1` (N. Virginia) on the AWS provider.
         * 
         * @return builder
         * 
         */
        public Builder scope(String scope) {
            return scope(Output.of(scope));
        }

        /**
         * @param tags An array of key:value pairs to associate with the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags An array of key:value pairs to associate with the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        public RegexPatternSetState build() {
            return $;
        }
    }

}
