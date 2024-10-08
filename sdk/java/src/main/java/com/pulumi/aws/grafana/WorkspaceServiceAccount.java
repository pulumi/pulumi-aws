// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.grafana;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.grafana.WorkspaceServiceAccountArgs;
import com.pulumi.aws.grafana.inputs.WorkspaceServiceAccountState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
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
 * import com.pulumi.aws.grafana.WorkspaceServiceAccount;
 * import com.pulumi.aws.grafana.WorkspaceServiceAccountArgs;
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
 *         var example = new WorkspaceServiceAccount("example", WorkspaceServiceAccountArgs.builder()
 *             .name("example-admin")
 *             .grafanaRole("ADMIN")
 *             .workspaceId(exampleAwsGrafanaWorkspace.id())
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
 * Using `pulumi import`, import Managed Grafana Workspace Service Account using the `workspace_id` and `service_account_id` separated by a comma (`,`). For example:
 * 
 * ```sh
 * $ pulumi import aws:grafana/workspaceServiceAccount:WorkspaceServiceAccount example g-abc12345,1
 * ```
 * 
 */
@ResourceType(type="aws:grafana/workspaceServiceAccount:WorkspaceServiceAccount")
public class WorkspaceServiceAccount extends com.pulumi.resources.CustomResource {
    /**
     * The permission level to use for this service account. For more information about the roles and the permissions each has, see the [User roles](https://docs.aws.amazon.com/grafana/latest/userguide/Grafana-user-roles.html) documentation.
     * 
     */
    @Export(name="grafanaRole", refs={String.class}, tree="[0]")
    private Output<String> grafanaRole;

    /**
     * @return The permission level to use for this service account. For more information about the roles and the permissions each has, see the [User roles](https://docs.aws.amazon.com/grafana/latest/userguide/Grafana-user-roles.html) documentation.
     * 
     */
    public Output<String> grafanaRole() {
        return this.grafanaRole;
    }
    /**
     * A name for the service account. The name must be unique within the workspace, as it determines the ID associated with the service account.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return A name for the service account. The name must be unique within the workspace, as it determines the ID associated with the service account.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Identifier of the service account in the given Grafana workspace
     * 
     */
    @Export(name="serviceAccountId", refs={String.class}, tree="[0]")
    private Output<String> serviceAccountId;

    /**
     * @return Identifier of the service account in the given Grafana workspace
     * 
     */
    public Output<String> serviceAccountId() {
        return this.serviceAccountId;
    }
    /**
     * The Grafana workspace with which the service account is associated.
     * 
     */
    @Export(name="workspaceId", refs={String.class}, tree="[0]")
    private Output<String> workspaceId;

    /**
     * @return The Grafana workspace with which the service account is associated.
     * 
     */
    public Output<String> workspaceId() {
        return this.workspaceId;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public WorkspaceServiceAccount(java.lang.String name) {
        this(name, WorkspaceServiceAccountArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public WorkspaceServiceAccount(java.lang.String name, WorkspaceServiceAccountArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public WorkspaceServiceAccount(java.lang.String name, WorkspaceServiceAccountArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:grafana/workspaceServiceAccount:WorkspaceServiceAccount", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private WorkspaceServiceAccount(java.lang.String name, Output<java.lang.String> id, @Nullable WorkspaceServiceAccountState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:grafana/workspaceServiceAccount:WorkspaceServiceAccount", name, state, makeResourceOptions(options, id), false);
    }

    private static WorkspaceServiceAccountArgs makeArgs(WorkspaceServiceAccountArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? WorkspaceServiceAccountArgs.Empty : args;
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
    public static WorkspaceServiceAccount get(java.lang.String name, Output<java.lang.String> id, @Nullable WorkspaceServiceAccountState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new WorkspaceServiceAccount(name, id, state, options);
    }
}
