// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iam;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.iam.UserLoginProfileArgs;
import com.pulumi.aws.iam.inputs.UserLoginProfileState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Manages an IAM User Login Profile with limited support for password creation during this provider resource creation. Uses PGP to encrypt the password for safe transport to the user. PGP keys can be obtained from Keybase.
 * 
 * &gt; To reset an IAM User login password via this provider, you can use delete and recreate this resource or change any of the arguments.
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
 * import com.pulumi.aws.iam.User;
 * import com.pulumi.aws.iam.UserArgs;
 * import com.pulumi.aws.iam.UserLoginProfile;
 * import com.pulumi.aws.iam.UserLoginProfileArgs;
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
 *         var example = new User("example", UserArgs.builder()
 *             .name("example")
 *             .path("/")
 *             .forceDestroy(true)
 *             .build());
 * 
 *         var exampleUserLoginProfile = new UserLoginProfile("exampleUserLoginProfile", UserLoginProfileArgs.builder()
 *             .user(example.name())
 *             .pgpKey("keybase:some_person_that_exists")
 *             .build());
 * 
 *         ctx.export("password", exampleUserLoginProfile.encryptedPassword());
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import IAM User Login Profiles without password information via the IAM User name. For example:
 * 
 * ```sh
 * $ pulumi import aws:iam/userLoginProfile:UserLoginProfile example myusername
 * ```
 * Since Pulumi has no method to read the PGP or password information during import, use the resource options `ignore_changes` argument to ignore them (unless you want to recreate a password). For example:
 * 
 */
@ResourceType(type="aws:iam/userLoginProfile:UserLoginProfile")
public class UserLoginProfile extends com.pulumi.resources.CustomResource {
    /**
     * The encrypted password, base64 encoded. Only available if password was handled on resource creation, not import.
     * 
     */
    @Export(name="encryptedPassword", refs={String.class}, tree="[0]")
    private Output<String> encryptedPassword;

    /**
     * @return The encrypted password, base64 encoded. Only available if password was handled on resource creation, not import.
     * 
     */
    public Output<String> encryptedPassword() {
        return this.encryptedPassword;
    }
    /**
     * The fingerprint of the PGP key used to encrypt the password. Only available if password was handled on this provider resource creation, not import.
     * 
     */
    @Export(name="keyFingerprint", refs={String.class}, tree="[0]")
    private Output<String> keyFingerprint;

    /**
     * @return The fingerprint of the PGP key used to encrypt the password. Only available if password was handled on this provider resource creation, not import.
     * 
     */
    public Output<String> keyFingerprint() {
        return this.keyFingerprint;
    }
    /**
     * The plain text password, only available when `pgp_key` is not provided.
     * 
     */
    @Export(name="password", refs={String.class}, tree="[0]")
    private Output<String> password;

    /**
     * @return The plain text password, only available when `pgp_key` is not provided.
     * 
     */
    public Output<String> password() {
        return this.password;
    }
    /**
     * The length of the generated password on resource creation. Only applies on resource creation. Drift detection is not possible with this argument. Default value is `20`.
     * 
     */
    @Export(name="passwordLength", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> passwordLength;

    /**
     * @return The length of the generated password on resource creation. Only applies on resource creation. Drift detection is not possible with this argument. Default value is `20`.
     * 
     */
    public Output<Optional<Integer>> passwordLength() {
        return Codegen.optional(this.passwordLength);
    }
    /**
     * Whether the user should be forced to reset the generated password on resource creation. Only applies on resource creation.
     * 
     */
    @Export(name="passwordResetRequired", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> passwordResetRequired;

    /**
     * @return Whether the user should be forced to reset the generated password on resource creation. Only applies on resource creation.
     * 
     */
    public Output<Boolean> passwordResetRequired() {
        return this.passwordResetRequired;
    }
    /**
     * Either a base-64 encoded PGP public key, or a keybase username in the form `keybase:username`. Only applies on resource creation. Drift detection is not possible with this argument.
     * 
     */
    @Export(name="pgpKey", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> pgpKey;

    /**
     * @return Either a base-64 encoded PGP public key, or a keybase username in the form `keybase:username`. Only applies on resource creation. Drift detection is not possible with this argument.
     * 
     */
    public Output<Optional<String>> pgpKey() {
        return Codegen.optional(this.pgpKey);
    }
    /**
     * The IAM user&#39;s name.
     * 
     */
    @Export(name="user", refs={String.class}, tree="[0]")
    private Output<String> user;

    /**
     * @return The IAM user&#39;s name.
     * 
     */
    public Output<String> user() {
        return this.user;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public UserLoginProfile(java.lang.String name) {
        this(name, UserLoginProfileArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public UserLoginProfile(java.lang.String name, UserLoginProfileArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public UserLoginProfile(java.lang.String name, UserLoginProfileArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:iam/userLoginProfile:UserLoginProfile", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private UserLoginProfile(java.lang.String name, Output<java.lang.String> id, @Nullable UserLoginProfileState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:iam/userLoginProfile:UserLoginProfile", name, state, makeResourceOptions(options, id), false);
    }

    private static UserLoginProfileArgs makeArgs(UserLoginProfileArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? UserLoginProfileArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .additionalSecretOutputs(List.of(
                "password"
            ))
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
    public static UserLoginProfile get(java.lang.String name, Output<java.lang.String> id, @Nullable UserLoginProfileState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new UserLoginProfile(name, id, state, options);
    }
}
