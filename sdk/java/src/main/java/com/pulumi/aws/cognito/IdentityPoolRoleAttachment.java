// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cognito;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.cognito.IdentityPoolRoleAttachmentArgs;
import com.pulumi.aws.cognito.inputs.IdentityPoolRoleAttachmentState;
import com.pulumi.aws.cognito.outputs.IdentityPoolRoleAttachmentRoleMapping;
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
 * Provides an AWS Cognito Identity Pool Roles Attachment.
 * 
 * ## Import
 * 
 * Using `pulumi import`, import Cognito Identity Pool Roles Attachment using the Identity Pool ID. For example:
 * 
 * ```sh
 * $ pulumi import aws:cognito/identityPoolRoleAttachment:IdentityPoolRoleAttachment example us-west-2:b64805ad-cb56-40ba-9ffc-f5d8207e6d42
 * ```
 * 
 */
@ResourceType(type="aws:cognito/identityPoolRoleAttachment:IdentityPoolRoleAttachment")
public class IdentityPoolRoleAttachment extends com.pulumi.resources.CustomResource {
    /**
     * An identity pool ID in the format `REGION_GUID`.
     * 
     */
    @Export(name="identityPoolId", refs={String.class}, tree="[0]")
    private Output<String> identityPoolId;

    /**
     * @return An identity pool ID in the format `REGION_GUID`.
     * 
     */
    public Output<String> identityPoolId() {
        return this.identityPoolId;
    }
    /**
     * A List of Role Mapping.
     * 
     */
    @Export(name="roleMappings", refs={List.class,IdentityPoolRoleAttachmentRoleMapping.class}, tree="[0,1]")
    private Output</* @Nullable */ List<IdentityPoolRoleAttachmentRoleMapping>> roleMappings;

    /**
     * @return A List of Role Mapping.
     * 
     */
    public Output<Optional<List<IdentityPoolRoleAttachmentRoleMapping>>> roleMappings() {
        return Codegen.optional(this.roleMappings);
    }
    /**
     * The map of roles associated with this pool. For a given role, the key will be either &#34;authenticated&#34; or &#34;unauthenticated&#34; and the value will be the Role ARN.
     * 
     */
    @Export(name="roles", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> roles;

    /**
     * @return The map of roles associated with this pool. For a given role, the key will be either &#34;authenticated&#34; or &#34;unauthenticated&#34; and the value will be the Role ARN.
     * 
     */
    public Output<Map<String,String>> roles() {
        return this.roles;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public IdentityPoolRoleAttachment(java.lang.String name) {
        this(name, IdentityPoolRoleAttachmentArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public IdentityPoolRoleAttachment(java.lang.String name, IdentityPoolRoleAttachmentArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public IdentityPoolRoleAttachment(java.lang.String name, IdentityPoolRoleAttachmentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cognito/identityPoolRoleAttachment:IdentityPoolRoleAttachment", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private IdentityPoolRoleAttachment(java.lang.String name, Output<java.lang.String> id, @Nullable IdentityPoolRoleAttachmentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cognito/identityPoolRoleAttachment:IdentityPoolRoleAttachment", name, state, makeResourceOptions(options, id), false);
    }

    private static IdentityPoolRoleAttachmentArgs makeArgs(IdentityPoolRoleAttachmentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? IdentityPoolRoleAttachmentArgs.Empty : args;
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
    public static IdentityPoolRoleAttachment get(java.lang.String name, Output<java.lang.String> id, @Nullable IdentityPoolRoleAttachmentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new IdentityPoolRoleAttachment(name, id, state, options);
    }
}
