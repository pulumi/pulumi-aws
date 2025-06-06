// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.rolesanywhere;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.rolesanywhere.ProfileArgs;
import com.pulumi.aws.rolesanywhere.inputs.ProfileState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing a Roles Anywhere Profile.
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
 * import com.pulumi.aws.iam.Role;
 * import com.pulumi.aws.iam.RoleArgs;
 * import com.pulumi.aws.rolesanywhere.Profile;
 * import com.pulumi.aws.rolesanywhere.ProfileArgs;
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
 *         var test = new Role("test", RoleArgs.builder()
 *             .name("test")
 *             .path("/")
 *             .assumeRolePolicy(serializeJson(
 *                 jsonObject(
 *                     jsonProperty("Version", "2012-10-17"),
 *                     jsonProperty("Statement", jsonArray(jsonObject(
 *                         jsonProperty("Action", jsonArray(
 *                             "sts:AssumeRole", 
 *                             "sts:TagSession", 
 *                             "sts:SetSourceIdentity"
 *                         )),
 *                         jsonProperty("Principal", jsonObject(
 *                             jsonProperty("Service", "rolesanywhere.amazonaws.com")
 *                         )),
 *                         jsonProperty("Effect", "Allow"),
 *                         jsonProperty("Sid", "")
 *                     )))
 *                 )))
 *             .build());
 * 
 *         var testProfile = new Profile("testProfile", ProfileArgs.builder()
 *             .name("example")
 *             .roleArns(test.arn())
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
 * Using `pulumi import`, import `aws_rolesanywhere_profile` using its `id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:rolesanywhere/profile:Profile example db138a85-8925-4f9f-a409-08231233cacf
 * ```
 * 
 */
@ResourceType(type="aws:rolesanywhere/profile:Profile")
public class Profile extends com.pulumi.resources.CustomResource {
    /**
     * Amazon Resource Name (ARN) of the Profile
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN) of the Profile
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The number of seconds the vended session credentials are valid for. Defaults to 3600.
     * 
     */
    @Export(name="durationSeconds", refs={Integer.class}, tree="[0]")
    private Output<Integer> durationSeconds;

    /**
     * @return The number of seconds the vended session credentials are valid for. Defaults to 3600.
     * 
     */
    public Output<Integer> durationSeconds() {
        return this.durationSeconds;
    }
    /**
     * Whether or not the Profile is enabled.
     * 
     */
    @Export(name="enabled", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> enabled;

    /**
     * @return Whether or not the Profile is enabled.
     * 
     */
    public Output<Optional<Boolean>> enabled() {
        return Codegen.optional(this.enabled);
    }
    /**
     * A list of managed policy ARNs that apply to the vended session credentials.
     * 
     */
    @Export(name="managedPolicyArns", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> managedPolicyArns;

    /**
     * @return A list of managed policy ARNs that apply to the vended session credentials.
     * 
     */
    public Output<Optional<List<String>>> managedPolicyArns() {
        return Codegen.optional(this.managedPolicyArns);
    }
    /**
     * The name of the Profile.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return The name of the Profile.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Specifies whether instance properties are required in [CreateSession](https://docs.aws.amazon.com/rolesanywhere/latest/APIReference/API_CreateSession.html) requests with this profile.
     * 
     */
    @Export(name="requireInstanceProperties", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> requireInstanceProperties;

    /**
     * @return Specifies whether instance properties are required in [CreateSession](https://docs.aws.amazon.com/rolesanywhere/latest/APIReference/API_CreateSession.html) requests with this profile.
     * 
     */
    public Output<Optional<Boolean>> requireInstanceProperties() {
        return Codegen.optional(this.requireInstanceProperties);
    }
    /**
     * A list of IAM roles that this profile can assume
     * 
     */
    @Export(name="roleArns", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> roleArns;

    /**
     * @return A list of IAM roles that this profile can assume
     * 
     */
    public Output<Optional<List<String>>> roleArns() {
        return Codegen.optional(this.roleArns);
    }
    /**
     * A session policy that applies to the trust boundary of the vended session credentials.
     * 
     */
    @Export(name="sessionPolicy", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> sessionPolicy;

    /**
     * @return A session policy that applies to the trust boundary of the vended session credentials.
     * 
     */
    public Output<Optional<String>> sessionPolicy() {
        return Codegen.optional(this.sessionPolicy);
    }
    /**
     * A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
    public Profile(java.lang.String name) {
        this(name, ProfileArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Profile(java.lang.String name, @Nullable ProfileArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Profile(java.lang.String name, @Nullable ProfileArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:rolesanywhere/profile:Profile", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Profile(java.lang.String name, Output<java.lang.String> id, @Nullable ProfileState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:rolesanywhere/profile:Profile", name, state, makeResourceOptions(options, id), false);
    }

    private static ProfileArgs makeArgs(@Nullable ProfileArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? ProfileArgs.Empty : args;
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
    public static Profile get(java.lang.String name, Output<java.lang.String> id, @Nullable ProfileState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Profile(name, id, state, options);
    }
}
