// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.costoptimizationhub;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.costoptimizationhub.PreferencesArgs;
import com.pulumi.aws.costoptimizationhub.inputs.PreferencesState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * Resource for managing AWS Cost Optimization Hub Preferences.
 * 
 * ## Example Usage
 * 
 * ### Basic Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.costoptimizationhub.Preferences;
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
 *         var example = new Preferences("example");
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Usage with all the arguments
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.costoptimizationhub.Preferences;
 * import com.pulumi.aws.costoptimizationhub.PreferencesArgs;
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
 *         var example = new Preferences("example", PreferencesArgs.builder()
 *             .memberAccountDiscountVisibility("None")
 *             .savingsEstimationMode("AfterDiscounts")
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
 * Using `pulumi import`, import Cost Optimization Hub Preferences using the `id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:costoptimizationhub/preferences:Preferences example 111222333444
 * ```
 * 
 */
@ResourceType(type="aws:costoptimizationhub/preferences:Preferences")
public class Preferences extends com.pulumi.resources.CustomResource {
    /**
     * Customize whether the member accounts can see the &#34;After Discounts&#34; savings estimates. Valid values are `All` and `None`. Default value is `All`.
     * 
     */
    @Export(name="memberAccountDiscountVisibility", refs={String.class}, tree="[0]")
    private Output<String> memberAccountDiscountVisibility;

    /**
     * @return Customize whether the member accounts can see the &#34;After Discounts&#34; savings estimates. Valid values are `All` and `None`. Default value is `All`.
     * 
     */
    public Output<String> memberAccountDiscountVisibility() {
        return this.memberAccountDiscountVisibility;
    }
    /**
     * Customize how estimated monthly savings are calculated. Valid values are `BeforeDiscounts` and `AfterDiscounts`. Default value is `BeforeDiscounts`.
     * 
     */
    @Export(name="savingsEstimationMode", refs={String.class}, tree="[0]")
    private Output<String> savingsEstimationMode;

    /**
     * @return Customize how estimated monthly savings are calculated. Valid values are `BeforeDiscounts` and `AfterDiscounts`. Default value is `BeforeDiscounts`.
     * 
     */
    public Output<String> savingsEstimationMode() {
        return this.savingsEstimationMode;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Preferences(java.lang.String name) {
        this(name, PreferencesArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Preferences(java.lang.String name, @Nullable PreferencesArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Preferences(java.lang.String name, @Nullable PreferencesArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:costoptimizationhub/preferences:Preferences", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Preferences(java.lang.String name, Output<java.lang.String> id, @Nullable PreferencesState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:costoptimizationhub/preferences:Preferences", name, state, makeResourceOptions(options, id), false);
    }

    private static PreferencesArgs makeArgs(@Nullable PreferencesArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? PreferencesArgs.Empty : args;
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
    public static Preferences get(java.lang.String name, Output<java.lang.String> id, @Nullable PreferencesState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Preferences(name, id, state, options);
    }
}
