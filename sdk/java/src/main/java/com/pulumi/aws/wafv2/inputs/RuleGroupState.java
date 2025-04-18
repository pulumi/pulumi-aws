// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.aws.wafv2.inputs.RuleGroupCustomResponseBodyArgs;
import com.pulumi.aws.wafv2.inputs.RuleGroupRuleArgs;
import com.pulumi.aws.wafv2.inputs.RuleGroupVisibilityConfigArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RuleGroupState extends com.pulumi.resources.ResourceArgs {

    public static final RuleGroupState Empty = new RuleGroupState();

    /**
     * The ARN of the WAF rule group.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return The ARN of the WAF rule group.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * The web ACL capacity units (WCUs) required for this rule group. See [here](https://docs.aws.amazon.com/waf/latest/APIReference/API_CreateRuleGroup.html#API_CreateRuleGroup_RequestSyntax) for general information and [here](https://docs.aws.amazon.com/waf/latest/developerguide/waf-rule-statements-list.html) for capacity specific information.
     * 
     */
    @Import(name="capacity")
    private @Nullable Output<Integer> capacity;

    /**
     * @return The web ACL capacity units (WCUs) required for this rule group. See [here](https://docs.aws.amazon.com/waf/latest/APIReference/API_CreateRuleGroup.html#API_CreateRuleGroup_RequestSyntax) for general information and [here](https://docs.aws.amazon.com/waf/latest/developerguide/waf-rule-statements-list.html) for capacity specific information.
     * 
     */
    public Optional<Output<Integer>> capacity() {
        return Optional.ofNullable(this.capacity);
    }

    /**
     * Defines custom response bodies that can be referenced by `custom_response` actions. See Custom Response Body below for details.
     * 
     */
    @Import(name="customResponseBodies")
    private @Nullable Output<List<RuleGroupCustomResponseBodyArgs>> customResponseBodies;

    /**
     * @return Defines custom response bodies that can be referenced by `custom_response` actions. See Custom Response Body below for details.
     * 
     */
    public Optional<Output<List<RuleGroupCustomResponseBodyArgs>>> customResponseBodies() {
        return Optional.ofNullable(this.customResponseBodies);
    }

    /**
     * A friendly description of the rule group.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return A friendly description of the rule group.
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
     * A friendly name of the rule group.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return A friendly name of the rule group.
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
     * The rule blocks used to identify the web requests that you want to `allow`, `block`, or `count`. See Rules below for details.
     * 
     */
    @Import(name="rules")
    private @Nullable Output<List<RuleGroupRuleArgs>> rules;

    /**
     * @return The rule blocks used to identify the web requests that you want to `allow`, `block`, or `count`. See Rules below for details.
     * 
     */
    public Optional<Output<List<RuleGroupRuleArgs>>> rules() {
        return Optional.ofNullable(this.rules);
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

    /**
     * Defines and enables Amazon CloudWatch metrics and web request sample collection. See Visibility Configuration below for details.
     * 
     */
    @Import(name="visibilityConfig")
    private @Nullable Output<RuleGroupVisibilityConfigArgs> visibilityConfig;

    /**
     * @return Defines and enables Amazon CloudWatch metrics and web request sample collection. See Visibility Configuration below for details.
     * 
     */
    public Optional<Output<RuleGroupVisibilityConfigArgs>> visibilityConfig() {
        return Optional.ofNullable(this.visibilityConfig);
    }

    private RuleGroupState() {}

    private RuleGroupState(RuleGroupState $) {
        this.arn = $.arn;
        this.capacity = $.capacity;
        this.customResponseBodies = $.customResponseBodies;
        this.description = $.description;
        this.lockToken = $.lockToken;
        this.name = $.name;
        this.namePrefix = $.namePrefix;
        this.rules = $.rules;
        this.scope = $.scope;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
        this.visibilityConfig = $.visibilityConfig;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RuleGroupState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RuleGroupState $;

        public Builder() {
            $ = new RuleGroupState();
        }

        public Builder(RuleGroupState defaults) {
            $ = new RuleGroupState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn The ARN of the WAF rule group.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn The ARN of the WAF rule group.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param capacity The web ACL capacity units (WCUs) required for this rule group. See [here](https://docs.aws.amazon.com/waf/latest/APIReference/API_CreateRuleGroup.html#API_CreateRuleGroup_RequestSyntax) for general information and [here](https://docs.aws.amazon.com/waf/latest/developerguide/waf-rule-statements-list.html) for capacity specific information.
         * 
         * @return builder
         * 
         */
        public Builder capacity(@Nullable Output<Integer> capacity) {
            $.capacity = capacity;
            return this;
        }

        /**
         * @param capacity The web ACL capacity units (WCUs) required for this rule group. See [here](https://docs.aws.amazon.com/waf/latest/APIReference/API_CreateRuleGroup.html#API_CreateRuleGroup_RequestSyntax) for general information and [here](https://docs.aws.amazon.com/waf/latest/developerguide/waf-rule-statements-list.html) for capacity specific information.
         * 
         * @return builder
         * 
         */
        public Builder capacity(Integer capacity) {
            return capacity(Output.of(capacity));
        }

        /**
         * @param customResponseBodies Defines custom response bodies that can be referenced by `custom_response` actions. See Custom Response Body below for details.
         * 
         * @return builder
         * 
         */
        public Builder customResponseBodies(@Nullable Output<List<RuleGroupCustomResponseBodyArgs>> customResponseBodies) {
            $.customResponseBodies = customResponseBodies;
            return this;
        }

        /**
         * @param customResponseBodies Defines custom response bodies that can be referenced by `custom_response` actions. See Custom Response Body below for details.
         * 
         * @return builder
         * 
         */
        public Builder customResponseBodies(List<RuleGroupCustomResponseBodyArgs> customResponseBodies) {
            return customResponseBodies(Output.of(customResponseBodies));
        }

        /**
         * @param customResponseBodies Defines custom response bodies that can be referenced by `custom_response` actions. See Custom Response Body below for details.
         * 
         * @return builder
         * 
         */
        public Builder customResponseBodies(RuleGroupCustomResponseBodyArgs... customResponseBodies) {
            return customResponseBodies(List.of(customResponseBodies));
        }

        /**
         * @param description A friendly description of the rule group.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description A friendly description of the rule group.
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
         * @param name A friendly name of the rule group.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name A friendly name of the rule group.
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
         * @param rules The rule blocks used to identify the web requests that you want to `allow`, `block`, or `count`. See Rules below for details.
         * 
         * @return builder
         * 
         */
        public Builder rules(@Nullable Output<List<RuleGroupRuleArgs>> rules) {
            $.rules = rules;
            return this;
        }

        /**
         * @param rules The rule blocks used to identify the web requests that you want to `allow`, `block`, or `count`. See Rules below for details.
         * 
         * @return builder
         * 
         */
        public Builder rules(List<RuleGroupRuleArgs> rules) {
            return rules(Output.of(rules));
        }

        /**
         * @param rules The rule blocks used to identify the web requests that you want to `allow`, `block`, or `count`. See Rules below for details.
         * 
         * @return builder
         * 
         */
        public Builder rules(RuleGroupRuleArgs... rules) {
            return rules(List.of(rules));
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

        /**
         * @param visibilityConfig Defines and enables Amazon CloudWatch metrics and web request sample collection. See Visibility Configuration below for details.
         * 
         * @return builder
         * 
         */
        public Builder visibilityConfig(@Nullable Output<RuleGroupVisibilityConfigArgs> visibilityConfig) {
            $.visibilityConfig = visibilityConfig;
            return this;
        }

        /**
         * @param visibilityConfig Defines and enables Amazon CloudWatch metrics and web request sample collection. See Visibility Configuration below for details.
         * 
         * @return builder
         * 
         */
        public Builder visibilityConfig(RuleGroupVisibilityConfigArgs visibilityConfig) {
            return visibilityConfig(Output.of(visibilityConfig));
        }

        public RuleGroupState build() {
            return $;
        }
    }

}
