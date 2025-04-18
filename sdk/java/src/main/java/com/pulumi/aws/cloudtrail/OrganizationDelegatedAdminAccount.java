// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudtrail;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.cloudtrail.OrganizationDelegatedAdminAccountArgs;
import com.pulumi.aws.cloudtrail.inputs.OrganizationDelegatedAdminAccountState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * Provides a resource to manage an AWS CloudTrail Delegated Administrator.
 * 
 * ## Example Usage
 * 
 * Basic usage:
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.AwsFunctions;
 * import com.pulumi.aws.inputs.GetCallerIdentityArgs;
 * import com.pulumi.aws.cloudtrail.OrganizationDelegatedAdminAccount;
 * import com.pulumi.aws.cloudtrail.OrganizationDelegatedAdminAccountArgs;
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
 *         final var delegated = AwsFunctions.getCallerIdentity(GetCallerIdentityArgs.builder()
 *             .build());
 * 
 *         var example = new OrganizationDelegatedAdminAccount("example", OrganizationDelegatedAdminAccountArgs.builder()
 *             .accountId(delegated.accountId())
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
 * Using `pulumi import`, import delegated administrators using the delegate account `id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:cloudtrail/organizationDelegatedAdminAccount:OrganizationDelegatedAdminAccount example 12345678901
 * ```
 * 
 */
@ResourceType(type="aws:cloudtrail/organizationDelegatedAdminAccount:OrganizationDelegatedAdminAccount")
public class OrganizationDelegatedAdminAccount extends com.pulumi.resources.CustomResource {
    /**
     * An organization member account ID that you want to designate as a delegated administrator.
     * 
     */
    @Export(name="accountId", refs={String.class}, tree="[0]")
    private Output<String> accountId;

    /**
     * @return An organization member account ID that you want to designate as a delegated administrator.
     * 
     */
    public Output<String> accountId() {
        return this.accountId;
    }
    /**
     * The Amazon Resource Name (ARN) of the delegated administrator&#39;s account.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) of the delegated administrator&#39;s account.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The email address that is associated with the delegated administrator&#39;s AWS account.
     * 
     */
    @Export(name="email", refs={String.class}, tree="[0]")
    private Output<String> email;

    /**
     * @return The email address that is associated with the delegated administrator&#39;s AWS account.
     * 
     */
    public Output<String> email() {
        return this.email;
    }
    /**
     * The friendly name of the delegated administrator&#39;s account.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return The friendly name of the delegated administrator&#39;s account.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * The AWS CloudTrail service principal name.
     * 
     */
    @Export(name="servicePrincipal", refs={String.class}, tree="[0]")
    private Output<String> servicePrincipal;

    /**
     * @return The AWS CloudTrail service principal name.
     * 
     */
    public Output<String> servicePrincipal() {
        return this.servicePrincipal;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public OrganizationDelegatedAdminAccount(java.lang.String name) {
        this(name, OrganizationDelegatedAdminAccountArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public OrganizationDelegatedAdminAccount(java.lang.String name, OrganizationDelegatedAdminAccountArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public OrganizationDelegatedAdminAccount(java.lang.String name, OrganizationDelegatedAdminAccountArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudtrail/organizationDelegatedAdminAccount:OrganizationDelegatedAdminAccount", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private OrganizationDelegatedAdminAccount(java.lang.String name, Output<java.lang.String> id, @Nullable OrganizationDelegatedAdminAccountState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudtrail/organizationDelegatedAdminAccount:OrganizationDelegatedAdminAccount", name, state, makeResourceOptions(options, id), false);
    }

    private static OrganizationDelegatedAdminAccountArgs makeArgs(OrganizationDelegatedAdminAccountArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? OrganizationDelegatedAdminAccountArgs.Empty : args;
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
    public static OrganizationDelegatedAdminAccount get(java.lang.String name, Output<java.lang.String> id, @Nullable OrganizationDelegatedAdminAccountState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new OrganizationDelegatedAdminAccount(name, id, state, options);
    }
}
