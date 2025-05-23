// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.fms;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.fms.PolicyArgs;
import com.pulumi.aws.fms.inputs.PolicyState;
import com.pulumi.aws.fms.outputs.PolicyExcludeMap;
import com.pulumi.aws.fms.outputs.PolicyIncludeMap;
import com.pulumi.aws.fms.outputs.PolicySecurityServicePolicyData;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a resource to create an AWS Firewall Manager policy. You need to be using AWS organizations and have enabled the Firewall Manager administrator account.
 * 
 * &gt; **NOTE:** Due to limitations with testing, we provide it as best effort. If you find it useful, and have the ability to help test or notice issues, consider reaching out to us on GitHub.
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
 * import com.pulumi.aws.wafregional.RuleGroup;
 * import com.pulumi.aws.wafregional.RuleGroupArgs;
 * import com.pulumi.aws.fms.Policy;
 * import com.pulumi.aws.fms.PolicyArgs;
 * import com.pulumi.aws.fms.inputs.PolicySecurityServicePolicyDataArgs;
 * import static com.pulumi.codegen.internal.Serialization.*;
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
 *         var exampleRuleGroup = new RuleGroup("exampleRuleGroup", RuleGroupArgs.builder()
 *             .metricName("WAFRuleGroupExample")
 *             .name("WAF-Rule-Group-Example")
 *             .build());
 * 
 *         var example = new Policy("example", PolicyArgs.builder()
 *             .name("FMS-Policy-Example")
 *             .excludeResourceTags(false)
 *             .remediationEnabled(false)
 *             .resourceType("AWS::ElasticLoadBalancingV2::LoadBalancer")
 *             .securityServicePolicyData(PolicySecurityServicePolicyDataArgs.builder()
 *                 .type("WAF")
 *                 .managedServiceData(exampleRuleGroup.id().applyValue(_id -> serializeJson(
 *                     jsonObject(
 *                         jsonProperty("type", "WAF"),
 *                         jsonProperty("ruleGroups", jsonArray(jsonObject(
 *                             jsonProperty("id", _id),
 *                             jsonProperty("overrideAction", jsonObject(
 *                                 jsonProperty("type", "COUNT")
 *                             ))
 *                         ))),
 *                         jsonProperty("defaultAction", jsonObject(
 *                             jsonProperty("type", "BLOCK")
 *                         )),
 *                         jsonProperty("overrideCustomerWebACLAssociation", false)
 *                     ))))
 *                 .build())
 *             .tags(Map.of("Name", "example-fms-policy"))
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
 * Using `pulumi import`, import Firewall Manager policies using the policy ID. For example:
 * 
 * ```sh
 * $ pulumi import aws:fms/policy:Policy example 5be49585-a7e3-4c49-dde1-a179fe4a619a
 * ```
 * 
 */
@ResourceType(type="aws:fms/policy:Policy")
public class Policy extends com.pulumi.resources.CustomResource {
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    public Output<String> arn() {
        return this.arn;
    }
    /**
     * If true, the request will also perform a clean-up process. Defaults to `true`. More information can be found here [AWS Firewall Manager delete policy](https://docs.aws.amazon.com/fms/2018-01-01/APIReference/API_DeletePolicy.html)
     * 
     */
    @Export(name="deleteAllPolicyResources", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> deleteAllPolicyResources;

    /**
     * @return If true, the request will also perform a clean-up process. Defaults to `true`. More information can be found here [AWS Firewall Manager delete policy](https://docs.aws.amazon.com/fms/2018-01-01/APIReference/API_DeletePolicy.html)
     * 
     */
    public Output<Optional<Boolean>> deleteAllPolicyResources() {
        return Codegen.optional(this.deleteAllPolicyResources);
    }
    /**
     * If true, Firewall Manager will automatically remove protections from resources that leave the policy scope. Defaults to `false`. More information can be found here [AWS Firewall Manager policy contents](https://docs.aws.amazon.com/fms/2018-01-01/APIReference/API_Policy.html)
     * 
     */
    @Export(name="deleteUnusedFmManagedResources", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> deleteUnusedFmManagedResources;

    /**
     * @return If true, Firewall Manager will automatically remove protections from resources that leave the policy scope. Defaults to `false`. More information can be found here [AWS Firewall Manager policy contents](https://docs.aws.amazon.com/fms/2018-01-01/APIReference/API_Policy.html)
     * 
     */
    public Output<Optional<Boolean>> deleteUnusedFmManagedResources() {
        return Codegen.optional(this.deleteUnusedFmManagedResources);
    }
    /**
     * The description of the AWS Network Firewall firewall policy.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return The description of the AWS Network Firewall firewall policy.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * A map of lists of accounts and OU&#39;s to exclude from the policy. See the `exclude_map` block.
     * 
     */
    @Export(name="excludeMap", refs={PolicyExcludeMap.class}, tree="[0]")
    private Output</* @Nullable */ PolicyExcludeMap> excludeMap;

    /**
     * @return A map of lists of accounts and OU&#39;s to exclude from the policy. See the `exclude_map` block.
     * 
     */
    public Output<Optional<PolicyExcludeMap>> excludeMap() {
        return Codegen.optional(this.excludeMap);
    }
    /**
     * A boolean value, if true the tags that are specified in the `resource_tags` are not protected by this policy. If set to false and resource_tags are populated, resources that contain tags will be protected by this policy.
     * 
     */
    @Export(name="excludeResourceTags", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> excludeResourceTags;

    /**
     * @return A boolean value, if true the tags that are specified in the `resource_tags` are not protected by this policy. If set to false and resource_tags are populated, resources that contain tags will be protected by this policy.
     * 
     */
    public Output<Boolean> excludeResourceTags() {
        return this.excludeResourceTags;
    }
    /**
     * A map of lists of accounts and OU&#39;s to include in the policy. See the `include_map` block.
     * 
     */
    @Export(name="includeMap", refs={PolicyIncludeMap.class}, tree="[0]")
    private Output</* @Nullable */ PolicyIncludeMap> includeMap;

    /**
     * @return A map of lists of accounts and OU&#39;s to include in the policy. See the `include_map` block.
     * 
     */
    public Output<Optional<PolicyIncludeMap>> includeMap() {
        return Codegen.optional(this.includeMap);
    }
    /**
     * The friendly name of the AWS Firewall Manager Policy.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return The friendly name of the AWS Firewall Manager Policy.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * A unique identifier for each update to the policy.
     * 
     */
    @Export(name="policyUpdateToken", refs={String.class}, tree="[0]")
    private Output<String> policyUpdateToken;

    /**
     * @return A unique identifier for each update to the policy.
     * 
     */
    public Output<String> policyUpdateToken() {
        return this.policyUpdateToken;
    }
    /**
     * A boolean value, indicates if the policy should automatically applied to resources that already exist in the account.
     * 
     */
    @Export(name="remediationEnabled", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> remediationEnabled;

    /**
     * @return A boolean value, indicates if the policy should automatically applied to resources that already exist in the account.
     * 
     */
    public Output<Optional<Boolean>> remediationEnabled() {
        return Codegen.optional(this.remediationEnabled);
    }
    @Export(name="resourceSetIds", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> resourceSetIds;

    public Output<List<String>> resourceSetIds() {
        return this.resourceSetIds;
    }
    /**
     * A map of resource tags, that if present will filter protections on resources based on the exclude_resource_tags.
     * 
     */
    @Export(name="resourceTags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> resourceTags;

    /**
     * @return A map of resource tags, that if present will filter protections on resources based on the exclude_resource_tags.
     * 
     */
    public Output<Optional<Map<String,String>>> resourceTags() {
        return Codegen.optional(this.resourceTags);
    }
    /**
     * A resource type to protect. Conflicts with `resource_type_list`. See the [FMS API Reference](https://docs.aws.amazon.com/fms/2018-01-01/APIReference/API_Policy.html#fms-Type-Policy-ResourceType) for more information about supported values.
     * 
     */
    @Export(name="resourceType", refs={String.class}, tree="[0]")
    private Output<String> resourceType;

    /**
     * @return A resource type to protect. Conflicts with `resource_type_list`. See the [FMS API Reference](https://docs.aws.amazon.com/fms/2018-01-01/APIReference/API_Policy.html#fms-Type-Policy-ResourceType) for more information about supported values.
     * 
     */
    public Output<String> resourceType() {
        return this.resourceType;
    }
    /**
     * A list of resource types to protect. Conflicts with `resource_type`. See the [FMS API Reference](https://docs.aws.amazon.com/fms/2018-01-01/APIReference/API_Policy.html#fms-Type-Policy-ResourceType) for more information about supported values. Lists with only one element are not supported, instead use `resource_type`.
     * 
     */
    @Export(name="resourceTypeLists", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> resourceTypeLists;

    /**
     * @return A list of resource types to protect. Conflicts with `resource_type`. See the [FMS API Reference](https://docs.aws.amazon.com/fms/2018-01-01/APIReference/API_Policy.html#fms-Type-Policy-ResourceType) for more information about supported values. Lists with only one element are not supported, instead use `resource_type`.
     * 
     */
    public Output<List<String>> resourceTypeLists() {
        return this.resourceTypeLists;
    }
    /**
     * The objects to include in Security Service Policy Data. See the `security_service_policy_data` block.
     * 
     */
    @Export(name="securityServicePolicyData", refs={PolicySecurityServicePolicyData.class}, tree="[0]")
    private Output<PolicySecurityServicePolicyData> securityServicePolicyData;

    /**
     * @return The objects to include in Security Service Policy Data. See the `security_service_policy_data` block.
     * 
     */
    public Output<PolicySecurityServicePolicyData> securityServicePolicyData() {
        return this.securityServicePolicyData;
    }
    /**
     * Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level
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
    public Policy(java.lang.String name) {
        this(name, PolicyArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Policy(java.lang.String name, PolicyArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Policy(java.lang.String name, PolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:fms/policy:Policy", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Policy(java.lang.String name, Output<java.lang.String> id, @Nullable PolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:fms/policy:Policy", name, state, makeResourceOptions(options, id), false);
    }

    private static PolicyArgs makeArgs(PolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? PolicyArgs.Empty : args;
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
    public static Policy get(java.lang.String name, Output<java.lang.String> id, @Nullable PolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Policy(name, id, state, options);
    }
}
