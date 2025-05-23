// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.eks;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.eks.PodIdentityAssociationArgs;
import com.pulumi.aws.eks.inputs.PodIdentityAssociationState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS EKS (Elastic Kubernetes) Pod Identity Association.
 * 
 * Creates an EKS Pod Identity association between a service account in an Amazon EKS cluster and an IAM role with EKS Pod Identity. Use EKS Pod Identity to give temporary IAM credentials to pods and the credentials are rotated automatically.
 * 
 * Amazon EKS Pod Identity associations provide the ability to manage credentials for your applications, similar to the way that EC2 instance profiles provide credentials to Amazon EC2 instances.
 * 
 * If a pod uses a service account that has an association, Amazon EKS sets environment variables in the containers of the pod. The environment variables configure the Amazon Web Services SDKs, including the Command Line Interface, to use the EKS Pod Identity credentials.
 * 
 * Pod Identity is a simpler method than IAM roles for service accounts, as this method doesn’t use OIDC identity providers. Additionally, you can configure a role for Pod Identity once, and reuse it across clusters.
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
 * import com.pulumi.aws.iam.IamFunctions;
 * import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
 * import com.pulumi.aws.iam.Role;
 * import com.pulumi.aws.iam.RoleArgs;
 * import com.pulumi.aws.iam.RolePolicyAttachment;
 * import com.pulumi.aws.iam.RolePolicyAttachmentArgs;
 * import com.pulumi.aws.eks.PodIdentityAssociation;
 * import com.pulumi.aws.eks.PodIdentityAssociationArgs;
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
 *         final var assumeRole = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
 *             .statements(GetPolicyDocumentStatementArgs.builder()
 *                 .effect("Allow")
 *                 .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
 *                     .type("Service")
 *                     .identifiers("pods.eks.amazonaws.com")
 *                     .build())
 *                 .actions(                
 *                     "sts:AssumeRole",
 *                     "sts:TagSession")
 *                 .build())
 *             .build());
 * 
 *         var example = new Role("example", RoleArgs.builder()
 *             .name("eks-pod-identity-example")
 *             .assumeRolePolicy(assumeRole.json())
 *             .build());
 * 
 *         var exampleS3 = new RolePolicyAttachment("exampleS3", RolePolicyAttachmentArgs.builder()
 *             .policyArn("arn:aws:iam::aws:policy/AmazonS3ReadOnlyAccess")
 *             .role(example.name())
 *             .build());
 * 
 *         var examplePodIdentityAssociation = new PodIdentityAssociation("examplePodIdentityAssociation", PodIdentityAssociationArgs.builder()
 *             .clusterName(exampleAwsEksCluster.name())
 *             .namespace("example")
 *             .serviceAccount("example-sa")
 *             .roleArn(example.arn())
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
 * Using `pulumi import`, import EKS (Elastic Kubernetes) Pod Identity Association using the `cluster_name` and `association_id` separated by a comma (`,`). For example:
 * 
 * ```sh
 * $ pulumi import aws:eks/podIdentityAssociation:PodIdentityAssociation example example,a-12345678
 * ```
 * 
 */
@ResourceType(type="aws:eks/podIdentityAssociation:PodIdentityAssociation")
public class PodIdentityAssociation extends com.pulumi.resources.CustomResource {
    /**
     * The Amazon Resource Name (ARN) of the association.
     * 
     */
    @Export(name="associationArn", refs={String.class}, tree="[0]")
    private Output<String> associationArn;

    /**
     * @return The Amazon Resource Name (ARN) of the association.
     * 
     */
    public Output<String> associationArn() {
        return this.associationArn;
    }
    /**
     * The ID of the association.
     * 
     */
    @Export(name="associationId", refs={String.class}, tree="[0]")
    private Output<String> associationId;

    /**
     * @return The ID of the association.
     * 
     */
    public Output<String> associationId() {
        return this.associationId;
    }
    /**
     * The name of the cluster to create the association in.
     * 
     */
    @Export(name="clusterName", refs={String.class}, tree="[0]")
    private Output<String> clusterName;

    /**
     * @return The name of the cluster to create the association in.
     * 
     */
    public Output<String> clusterName() {
        return this.clusterName;
    }
    /**
     * The name of the Kubernetes namespace inside the cluster to create the association in. The service account and the pods that use the service account must be in this namespace.
     * 
     */
    @Export(name="namespace", refs={String.class}, tree="[0]")
    private Output<String> namespace;

    /**
     * @return The name of the Kubernetes namespace inside the cluster to create the association in. The service account and the pods that use the service account must be in this namespace.
     * 
     */
    public Output<String> namespace() {
        return this.namespace;
    }
    /**
     * The Amazon Resource Name (ARN) of the IAM role to associate with the service account. The EKS Pod Identity agent manages credentials to assume this role for applications in the containers in the pods that use this service account.
     * 
     */
    @Export(name="roleArn", refs={String.class}, tree="[0]")
    private Output<String> roleArn;

    /**
     * @return The Amazon Resource Name (ARN) of the IAM role to associate with the service account. The EKS Pod Identity agent manages credentials to assume this role for applications in the containers in the pods that use this service account.
     * 
     */
    public Output<String> roleArn() {
        return this.roleArn;
    }
    /**
     * The name of the Kubernetes service account inside the cluster to associate the IAM credentials with.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="serviceAccount", refs={String.class}, tree="[0]")
    private Output<String> serviceAccount;

    /**
     * @return The name of the Kubernetes service account inside the cluster to associate the IAM credentials with.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> serviceAccount() {
        return this.serviceAccount;
    }
    /**
     * Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
    public PodIdentityAssociation(java.lang.String name) {
        this(name, PodIdentityAssociationArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public PodIdentityAssociation(java.lang.String name, PodIdentityAssociationArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public PodIdentityAssociation(java.lang.String name, PodIdentityAssociationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:eks/podIdentityAssociation:PodIdentityAssociation", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private PodIdentityAssociation(java.lang.String name, Output<java.lang.String> id, @Nullable PodIdentityAssociationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:eks/podIdentityAssociation:PodIdentityAssociation", name, state, makeResourceOptions(options, id), false);
    }

    private static PodIdentityAssociationArgs makeArgs(PodIdentityAssociationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? PodIdentityAssociationArgs.Empty : args;
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
    public static PodIdentityAssociation get(java.lang.String name, Output<java.lang.String> id, @Nullable PodIdentityAssociationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new PodIdentityAssociation(name, id, state, options);
    }
}
