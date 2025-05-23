// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssm;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ssm.QuicksetupConfigurationManagerArgs;
import com.pulumi.aws.ssm.inputs.QuicksetupConfigurationManagerState;
import com.pulumi.aws.ssm.outputs.QuicksetupConfigurationManagerConfigurationDefinition;
import com.pulumi.aws.ssm.outputs.QuicksetupConfigurationManagerStatusSummary;
import com.pulumi.aws.ssm.outputs.QuicksetupConfigurationManagerTimeouts;
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
 * Resource for managing an AWS SSM Quick Setup Configuration Manager.
 * 
 * ## Example Usage
 * 
 * ### Patch Policy Configuration Type
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import SSM Quick Setup Configuration Manager using the `manager_arn`. For example:
 * 
 * ```sh
 * $ pulumi import aws:ssm/quicksetupConfigurationManager:QuicksetupConfigurationManager example arn:aws:ssm-quicksetup:us-east-1:012345678901:configuration-manager/abcd-1234
 * ```
 * 
 */
@ResourceType(type="aws:ssm/quicksetupConfigurationManager:QuicksetupConfigurationManager")
public class QuicksetupConfigurationManager extends com.pulumi.resources.CustomResource {
    /**
     * Definition of the Quick Setup configuration that the configuration manager deploys. See `configuration_definition` below.
     * 
     */
    @Export(name="configurationDefinition", refs={QuicksetupConfigurationManagerConfigurationDefinition.class}, tree="[0]")
    private Output</* @Nullable */ QuicksetupConfigurationManagerConfigurationDefinition> configurationDefinition;

    /**
     * @return Definition of the Quick Setup configuration that the configuration manager deploys. See `configuration_definition` below.
     * 
     */
    public Output<Optional<QuicksetupConfigurationManagerConfigurationDefinition>> configurationDefinition() {
        return Codegen.optional(this.configurationDefinition);
    }
    /**
     * Description of the configuration manager.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output<String> description;

    /**
     * @return Description of the configuration manager.
     * 
     */
    public Output<String> description() {
        return this.description;
    }
    /**
     * ARN of the Configuration Manager.
     * 
     */
    @Export(name="managerArn", refs={String.class}, tree="[0]")
    private Output<String> managerArn;

    /**
     * @return ARN of the Configuration Manager.
     * 
     */
    public Output<String> managerArn() {
        return this.managerArn;
    }
    /**
     * Configuration manager name.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Configuration manager name.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * A summary of the state of the configuration manager. This includes deployment statuses, association statuses, drift statuses, health checks, and more. See `status_summaries` below.
     * 
     */
    @Export(name="statusSummaries", refs={List.class,QuicksetupConfigurationManagerStatusSummary.class}, tree="[0,1]")
    private Output<List<QuicksetupConfigurationManagerStatusSummary>> statusSummaries;

    /**
     * @return A summary of the state of the configuration manager. This includes deployment statuses, association statuses, drift statuses, health checks, and more. See `status_summaries` below.
     * 
     */
    public Output<List<QuicksetupConfigurationManagerStatusSummary>> statusSummaries() {
        return this.statusSummaries;
    }
    /**
     * Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    /**
     * @return Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     */
    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }
    @Export(name="timeouts", refs={QuicksetupConfigurationManagerTimeouts.class}, tree="[0]")
    private Output</* @Nullable */ QuicksetupConfigurationManagerTimeouts> timeouts;

    public Output<Optional<QuicksetupConfigurationManagerTimeouts>> timeouts() {
        return Codegen.optional(this.timeouts);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public QuicksetupConfigurationManager(java.lang.String name) {
        this(name, QuicksetupConfigurationManagerArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public QuicksetupConfigurationManager(java.lang.String name, @Nullable QuicksetupConfigurationManagerArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public QuicksetupConfigurationManager(java.lang.String name, @Nullable QuicksetupConfigurationManagerArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssm/quicksetupConfigurationManager:QuicksetupConfigurationManager", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private QuicksetupConfigurationManager(java.lang.String name, Output<java.lang.String> id, @Nullable QuicksetupConfigurationManagerState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssm/quicksetupConfigurationManager:QuicksetupConfigurationManager", name, state, makeResourceOptions(options, id), false);
    }

    private static QuicksetupConfigurationManagerArgs makeArgs(@Nullable QuicksetupConfigurationManagerArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? QuicksetupConfigurationManagerArgs.Empty : args;
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
    public static QuicksetupConfigurationManager get(java.lang.String name, Output<java.lang.String> id, @Nullable QuicksetupConfigurationManagerState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new QuicksetupConfigurationManager(name, id, state, options);
    }
}
