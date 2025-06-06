// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iam;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.iam.AccountPasswordPolicyArgs;
import com.pulumi.aws.iam.inputs.AccountPasswordPolicyState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * &gt; **Note:** There is only a single policy allowed per AWS account. An existing policy will be lost when using this resource as an effect of this limitation.
 * 
 * Manages Password Policy for the AWS Account.
 * See more about [Account Password Policy](http://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_passwords_account-policy.html)
 * in the official AWS docs.
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
 * import com.pulumi.aws.iam.AccountPasswordPolicy;
 * import com.pulumi.aws.iam.AccountPasswordPolicyArgs;
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
 *         var strict = new AccountPasswordPolicy("strict", AccountPasswordPolicyArgs.builder()
 *             .minimumPasswordLength(8)
 *             .requireLowercaseCharacters(true)
 *             .requireNumbers(true)
 *             .requireUppercaseCharacters(true)
 *             .requireSymbols(true)
 *             .allowUsersToChangePassword(true)
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
 * Using `pulumi import`, import IAM Account Password Policy using the word `iam-account-password-policy`. For example:
 * 
 * ```sh
 * $ pulumi import aws:iam/accountPasswordPolicy:AccountPasswordPolicy strict iam-account-password-policy
 * ```
 * 
 */
@ResourceType(type="aws:iam/accountPasswordPolicy:AccountPasswordPolicy")
public class AccountPasswordPolicy extends com.pulumi.resources.CustomResource {
    /**
     * Whether to allow users to change their own password
     * 
     */
    @Export(name="allowUsersToChangePassword", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> allowUsersToChangePassword;

    /**
     * @return Whether to allow users to change their own password
     * 
     */
    public Output<Optional<Boolean>> allowUsersToChangePassword() {
        return Codegen.optional(this.allowUsersToChangePassword);
    }
    /**
     * Indicates whether passwords in the account expire. Returns `true` if `max_password_age` contains a value greater than `0`. Returns `false` if it is `0` or _not present_.
     * 
     */
    @Export(name="expirePasswords", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> expirePasswords;

    /**
     * @return Indicates whether passwords in the account expire. Returns `true` if `max_password_age` contains a value greater than `0`. Returns `false` if it is `0` or _not present_.
     * 
     */
    public Output<Boolean> expirePasswords() {
        return this.expirePasswords;
    }
    /**
     * Whether users are prevented from setting a new password after their password has expired (i.e., require administrator reset)
     * 
     */
    @Export(name="hardExpiry", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> hardExpiry;

    /**
     * @return Whether users are prevented from setting a new password after their password has expired (i.e., require administrator reset)
     * 
     */
    public Output<Boolean> hardExpiry() {
        return this.hardExpiry;
    }
    /**
     * The number of days that an user password is valid.
     * 
     */
    @Export(name="maxPasswordAge", refs={Integer.class}, tree="[0]")
    private Output<Integer> maxPasswordAge;

    /**
     * @return The number of days that an user password is valid.
     * 
     */
    public Output<Integer> maxPasswordAge() {
        return this.maxPasswordAge;
    }
    /**
     * Minimum length to require for user passwords.
     * 
     */
    @Export(name="minimumPasswordLength", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> minimumPasswordLength;

    /**
     * @return Minimum length to require for user passwords.
     * 
     */
    public Output<Optional<Integer>> minimumPasswordLength() {
        return Codegen.optional(this.minimumPasswordLength);
    }
    /**
     * The number of previous passwords that users are prevented from reusing.
     * 
     */
    @Export(name="passwordReusePrevention", refs={Integer.class}, tree="[0]")
    private Output<Integer> passwordReusePrevention;

    /**
     * @return The number of previous passwords that users are prevented from reusing.
     * 
     */
    public Output<Integer> passwordReusePrevention() {
        return this.passwordReusePrevention;
    }
    /**
     * Whether to require lowercase characters for user passwords.
     * 
     */
    @Export(name="requireLowercaseCharacters", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> requireLowercaseCharacters;

    /**
     * @return Whether to require lowercase characters for user passwords.
     * 
     */
    public Output<Boolean> requireLowercaseCharacters() {
        return this.requireLowercaseCharacters;
    }
    /**
     * Whether to require numbers for user passwords.
     * 
     */
    @Export(name="requireNumbers", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> requireNumbers;

    /**
     * @return Whether to require numbers for user passwords.
     * 
     */
    public Output<Boolean> requireNumbers() {
        return this.requireNumbers;
    }
    /**
     * Whether to require symbols for user passwords.
     * 
     */
    @Export(name="requireSymbols", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> requireSymbols;

    /**
     * @return Whether to require symbols for user passwords.
     * 
     */
    public Output<Boolean> requireSymbols() {
        return this.requireSymbols;
    }
    /**
     * Whether to require uppercase characters for user passwords.
     * 
     */
    @Export(name="requireUppercaseCharacters", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> requireUppercaseCharacters;

    /**
     * @return Whether to require uppercase characters for user passwords.
     * 
     */
    public Output<Boolean> requireUppercaseCharacters() {
        return this.requireUppercaseCharacters;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public AccountPasswordPolicy(java.lang.String name) {
        this(name, AccountPasswordPolicyArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public AccountPasswordPolicy(java.lang.String name, @Nullable AccountPasswordPolicyArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public AccountPasswordPolicy(java.lang.String name, @Nullable AccountPasswordPolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:iam/accountPasswordPolicy:AccountPasswordPolicy", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private AccountPasswordPolicy(java.lang.String name, Output<java.lang.String> id, @Nullable AccountPasswordPolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:iam/accountPasswordPolicy:AccountPasswordPolicy", name, state, makeResourceOptions(options, id), false);
    }

    private static AccountPasswordPolicyArgs makeArgs(@Nullable AccountPasswordPolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? AccountPasswordPolicyArgs.Empty : args;
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
    public static AccountPasswordPolicy get(java.lang.String name, Output<java.lang.String> id, @Nullable AccountPasswordPolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new AccountPasswordPolicy(name, id, state, options);
    }
}
