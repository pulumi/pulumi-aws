// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.costexplorer;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.costexplorer.CostCategoryArgs;
import com.pulumi.aws.costexplorer.inputs.CostCategoryState;
import com.pulumi.aws.costexplorer.outputs.CostCategoryRule;
import com.pulumi.aws.costexplorer.outputs.CostCategorySplitChargeRule;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a CE Cost Category.
 * 
 * ## Example Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.costexplorer.CostCategory;
 * import com.pulumi.aws.costexplorer.CostCategoryArgs;
 * import com.pulumi.aws.costexplorer.inputs.CostCategoryRuleArgs;
 * import com.pulumi.aws.costexplorer.inputs.CostCategoryRuleRuleArgs;
 * import com.pulumi.aws.costexplorer.inputs.CostCategoryRuleRuleDimensionArgs;
 * import java.util.List;
 * import java.util.ArrayList;
 * import java.util.Map;
 * import java.io.File;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * 
 * public class App {
 *     public static void main(String[] args) {
 *         Pulumi.run(App::stack);
 *     }
 * 
 *     public static void stack(Context ctx) {
 *         var test = new CostCategory("test", CostCategoryArgs.builder()
 *             .name("NAME")
 *             .ruleVersion("CostCategoryExpression.v1")
 *             .rules(            
 *                 CostCategoryRuleArgs.builder()
 *                     .value("production")
 *                     .rule(CostCategoryRuleRuleArgs.builder()
 *                         .dimension(CostCategoryRuleRuleDimensionArgs.builder()
 *                             .key("LINKED_ACCOUNT_NAME")
 *                             .values("-prod")
 *                             .matchOptions("ENDS_WITH")
 *                             .build())
 *                         .build())
 *                     .build(),
 *                 CostCategoryRuleArgs.builder()
 *                     .value("staging")
 *                     .rule(CostCategoryRuleRuleArgs.builder()
 *                         .dimension(CostCategoryRuleRuleDimensionArgs.builder()
 *                             .key("LINKED_ACCOUNT_NAME")
 *                             .values("-stg")
 *                             .matchOptions("ENDS_WITH")
 *                             .build())
 *                         .build())
 *                     .build(),
 *                 CostCategoryRuleArgs.builder()
 *                     .value("testing")
 *                     .rule(CostCategoryRuleRuleArgs.builder()
 *                         .dimension(CostCategoryRuleRuleDimensionArgs.builder()
 *                             .key("LINKED_ACCOUNT_NAME")
 *                             .values("-dev")
 *                             .matchOptions("ENDS_WITH")
 *                             .build())
 *                         .build())
 *                     .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import `aws_ce_cost_category` using the id. For example:
 * 
 * ```sh
 * $ pulumi import aws:costexplorer/costCategory:CostCategory example costCategoryARN
 * ```
 * 
 */
@ResourceType(type="aws:costexplorer/costCategory:CostCategory")
public class CostCategory extends com.pulumi.resources.CustomResource {
    /**
     * ARN of the cost category.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN of the cost category.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Default value for the cost category.
     * 
     */
    @Export(name="defaultValue", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> defaultValue;

    /**
     * @return Default value for the cost category.
     * 
     */
    public Output<Optional<String>> defaultValue() {
        return Codegen.optional(this.defaultValue);
    }
    /**
     * Effective end data of your Cost Category.
     * 
     */
    @Export(name="effectiveEnd", refs={String.class}, tree="[0]")
    private Output<String> effectiveEnd;

    /**
     * @return Effective end data of your Cost Category.
     * 
     */
    public Output<String> effectiveEnd() {
        return this.effectiveEnd;
    }
    /**
     * The Cost Category&#39;s effective start date. It can only be a billing start date (first day of the month). If the date isn&#39;t provided, it&#39;s the first day of the current month. Dates can&#39;t be before the previous twelve months, or in the future. For example `2022-11-01T00:00:00Z`.
     * 
     */
    @Export(name="effectiveStart", refs={String.class}, tree="[0]")
    private Output<String> effectiveStart;

    /**
     * @return The Cost Category&#39;s effective start date. It can only be a billing start date (first day of the month). If the date isn&#39;t provided, it&#39;s the first day of the current month. Dates can&#39;t be before the previous twelve months, or in the future. For example `2022-11-01T00:00:00Z`.
     * 
     */
    public Output<String> effectiveStart() {
        return this.effectiveStart;
    }
    /**
     * Unique name for the Cost Category.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Unique name for the Cost Category.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Rule schema version in this particular Cost Category.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="ruleVersion", refs={String.class}, tree="[0]")
    private Output<String> ruleVersion;

    /**
     * @return Rule schema version in this particular Cost Category.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> ruleVersion() {
        return this.ruleVersion;
    }
    /**
     * Configuration block for the Cost Category rules used to categorize costs. See below.
     * 
     */
    @Export(name="rules", refs={List.class,CostCategoryRule.class}, tree="[0,1]")
    private Output<List<CostCategoryRule>> rules;

    /**
     * @return Configuration block for the Cost Category rules used to categorize costs. See below.
     * 
     */
    public Output<List<CostCategoryRule>> rules() {
        return this.rules;
    }
    /**
     * Configuration block for the split charge rules used to allocate your charges between your Cost Category values. See below.
     * 
     */
    @Export(name="splitChargeRules", refs={List.class,CostCategorySplitChargeRule.class}, tree="[0,1]")
    private Output</* @Nullable */ List<CostCategorySplitChargeRule>> splitChargeRules;

    /**
     * @return Configuration block for the split charge rules used to allocate your charges between your Cost Category values. See below.
     * 
     */
    public Output<Optional<List<CostCategorySplitChargeRule>>> splitChargeRules() {
        return Codegen.optional(this.splitChargeRules);
    }
    /**
     * Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     */
    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public CostCategory(java.lang.String name) {
        this(name, CostCategoryArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public CostCategory(java.lang.String name, CostCategoryArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public CostCategory(java.lang.String name, CostCategoryArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:costexplorer/costCategory:CostCategory", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private CostCategory(java.lang.String name, Output<java.lang.String> id, @Nullable CostCategoryState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:costexplorer/costCategory:CostCategory", name, state, makeResourceOptions(options, id), false);
    }

    private static CostCategoryArgs makeArgs(CostCategoryArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? CostCategoryArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .build();
        return com.pulumi.resources.CustomResourceOptions.merge(defaultOptions, options, id);
    }

    /**
     * Get an existing Host resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state
     * @param options Optional settings to control the behavior of the CustomResource.
     */
    public static CostCategory get(java.lang.String name, Output<java.lang.String> id, @Nullable CostCategoryState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new CostCategory(name, id, state, options);
    }
}
