// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.eks.inputs;

import com.pulumi.aws.eks.inputs.AddonPodIdentityAssociationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AddonState extends com.pulumi.resources.ResourceArgs {

    public static final AddonState Empty = new AddonState();

    /**
     * Name of the EKS add-on. The name must match one of
     * the names returned by [describe-addon-versions](https://docs.aws.amazon.com/cli/latest/reference/eks/describe-addon-versions.html).
     * 
     */
    @Import(name="addonName")
    private @Nullable Output<String> addonName;

    /**
     * @return Name of the EKS add-on. The name must match one of
     * the names returned by [describe-addon-versions](https://docs.aws.amazon.com/cli/latest/reference/eks/describe-addon-versions.html).
     * 
     */
    public Optional<Output<String>> addonName() {
        return Optional.ofNullable(this.addonName);
    }

    /**
     * The version of the EKS add-on. The version must
     * match one of the versions returned by [describe-addon-versions](https://docs.aws.amazon.com/cli/latest/reference/eks/describe-addon-versions.html).
     * 
     */
    @Import(name="addonVersion")
    private @Nullable Output<String> addonVersion;

    /**
     * @return The version of the EKS add-on. The version must
     * match one of the versions returned by [describe-addon-versions](https://docs.aws.amazon.com/cli/latest/reference/eks/describe-addon-versions.html).
     * 
     */
    public Optional<Output<String>> addonVersion() {
        return Optional.ofNullable(this.addonVersion);
    }

    /**
     * Amazon Resource Name (ARN) of the EKS add-on.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN) of the EKS add-on.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Name of the EKS Cluster.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="clusterName")
    private @Nullable Output<String> clusterName;

    /**
     * @return Name of the EKS Cluster.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<String>> clusterName() {
        return Optional.ofNullable(this.clusterName);
    }

    /**
     * custom configuration values for addons with single JSON string. This JSON string value must match the JSON schema derived from [describe-addon-configuration](https://docs.aws.amazon.com/cli/latest/reference/eks/describe-addon-configuration.html).
     * 
     */
    @Import(name="configurationValues")
    private @Nullable Output<String> configurationValues;

    /**
     * @return custom configuration values for addons with single JSON string. This JSON string value must match the JSON schema derived from [describe-addon-configuration](https://docs.aws.amazon.com/cli/latest/reference/eks/describe-addon-configuration.html).
     * 
     */
    public Optional<Output<String>> configurationValues() {
        return Optional.ofNullable(this.configurationValues);
    }

    /**
     * Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the EKS add-on was created.
     * 
     */
    @Import(name="createdAt")
    private @Nullable Output<String> createdAt;

    /**
     * @return Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the EKS add-on was created.
     * 
     */
    public Optional<Output<String>> createdAt() {
        return Optional.ofNullable(this.createdAt);
    }

    /**
     * Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the EKS add-on was updated.
     * 
     */
    @Import(name="modifiedAt")
    private @Nullable Output<String> modifiedAt;

    /**
     * @return Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the EKS add-on was updated.
     * 
     */
    public Optional<Output<String>> modifiedAt() {
        return Optional.ofNullable(this.modifiedAt);
    }

    /**
     * Configuration block with EKS Pod Identity association settings. See `pod_identity_association` below for details.
     * 
     */
    @Import(name="podIdentityAssociations")
    private @Nullable Output<List<AddonPodIdentityAssociationArgs>> podIdentityAssociations;

    /**
     * @return Configuration block with EKS Pod Identity association settings. See `pod_identity_association` below for details.
     * 
     */
    public Optional<Output<List<AddonPodIdentityAssociationArgs>>> podIdentityAssociations() {
        return Optional.ofNullable(this.podIdentityAssociations);
    }

    /**
     * Indicates if you want to preserve the created resources when deleting the EKS add-on.
     * 
     */
    @Import(name="preserve")
    private @Nullable Output<Boolean> preserve;

    /**
     * @return Indicates if you want to preserve the created resources when deleting the EKS add-on.
     * 
     */
    public Optional<Output<Boolean>> preserve() {
        return Optional.ofNullable(this.preserve);
    }

    /**
     * Define how to resolve parameter value conflicts when migrating an existing add-on to an Amazon EKS add-on or when applying version updates to the add-on. Valid values are `NONE`, `OVERWRITE` and `PRESERVE`. Note that `PRESERVE` is only valid on addon update, not for initial addon creation. If you need to set this to `PRESERVE`, use the `resolve_conflicts_on_create` and `resolve_conflicts_on_update` attributes instead. For more details check [UpdateAddon](https://docs.aws.amazon.com/eks/latest/APIReference/API_UpdateAddon.html) API Docs.
     * 
     * @deprecated
     * resolve_conflicts is deprecated. The resolve_conflicts attribute can&#39;t be set to &#34;PRESERVE&#34; on initial resource creation. Use resolve_conflicts_on_create and/or resolve_conflicts_on_update instead.
     * 
     */
    @Deprecated /* resolve_conflicts is deprecated. The resolve_conflicts attribute can't be set to ""PRESERVE"" on initial resource creation. Use resolve_conflicts_on_create and/or resolve_conflicts_on_update instead. */
    @Import(name="resolveConflicts")
    private @Nullable Output<String> resolveConflicts;

    /**
     * @return Define how to resolve parameter value conflicts when migrating an existing add-on to an Amazon EKS add-on or when applying version updates to the add-on. Valid values are `NONE`, `OVERWRITE` and `PRESERVE`. Note that `PRESERVE` is only valid on addon update, not for initial addon creation. If you need to set this to `PRESERVE`, use the `resolve_conflicts_on_create` and `resolve_conflicts_on_update` attributes instead. For more details check [UpdateAddon](https://docs.aws.amazon.com/eks/latest/APIReference/API_UpdateAddon.html) API Docs.
     * 
     * @deprecated
     * resolve_conflicts is deprecated. The resolve_conflicts attribute can&#39;t be set to &#34;PRESERVE&#34; on initial resource creation. Use resolve_conflicts_on_create and/or resolve_conflicts_on_update instead.
     * 
     */
    @Deprecated /* resolve_conflicts is deprecated. The resolve_conflicts attribute can't be set to ""PRESERVE"" on initial resource creation. Use resolve_conflicts_on_create and/or resolve_conflicts_on_update instead. */
    public Optional<Output<String>> resolveConflicts() {
        return Optional.ofNullable(this.resolveConflicts);
    }

    /**
     * How to resolve field value conflicts when migrating a self-managed add-on to an Amazon EKS add-on. Valid values are `NONE` and `OVERWRITE`. For more details see the [CreateAddon](https://docs.aws.amazon.com/eks/latest/APIReference/API_CreateAddon.html) API Docs.
     * 
     */
    @Import(name="resolveConflictsOnCreate")
    private @Nullable Output<String> resolveConflictsOnCreate;

    /**
     * @return How to resolve field value conflicts when migrating a self-managed add-on to an Amazon EKS add-on. Valid values are `NONE` and `OVERWRITE`. For more details see the [CreateAddon](https://docs.aws.amazon.com/eks/latest/APIReference/API_CreateAddon.html) API Docs.
     * 
     */
    public Optional<Output<String>> resolveConflictsOnCreate() {
        return Optional.ofNullable(this.resolveConflictsOnCreate);
    }

    /**
     * How to resolve field value conflicts for an Amazon EKS add-on if you&#39;ve changed a value from the Amazon EKS default value. Valid values are `NONE`, `OVERWRITE`, and `PRESERVE`. For more details see the [UpdateAddon](https://docs.aws.amazon.com/eks/latest/APIReference/API_UpdateAddon.html) API Docs.
     * 
     */
    @Import(name="resolveConflictsOnUpdate")
    private @Nullable Output<String> resolveConflictsOnUpdate;

    /**
     * @return How to resolve field value conflicts for an Amazon EKS add-on if you&#39;ve changed a value from the Amazon EKS default value. Valid values are `NONE`, `OVERWRITE`, and `PRESERVE`. For more details see the [UpdateAddon](https://docs.aws.amazon.com/eks/latest/APIReference/API_UpdateAddon.html) API Docs.
     * 
     */
    public Optional<Output<String>> resolveConflictsOnUpdate() {
        return Optional.ofNullable(this.resolveConflictsOnUpdate);
    }

    /**
     * The Amazon Resource Name (ARN) of an
     * existing IAM role to bind to the add-on&#39;s service account. The role must be
     * assigned the IAM permissions required by the add-on. If you don&#39;t specify
     * an existing IAM role, then the add-on uses the permissions assigned to the node
     * IAM role. For more information, see [Amazon EKS node IAM role](https://docs.aws.amazon.com/eks/latest/userguide/create-node-role.html)
     * in the Amazon EKS User Guide.
     * 
     * &gt; **Note:** To specify an existing IAM role, you must have an IAM OpenID Connect (OIDC)
     * provider created for your cluster. For more information, [see Enabling IAM roles
     * for service accounts on your cluster](https://docs.aws.amazon.com/eks/latest/userguide/enable-iam-roles-for-service-accounts.html)
     * in the Amazon EKS User Guide.
     * 
     */
    @Import(name="serviceAccountRoleArn")
    private @Nullable Output<String> serviceAccountRoleArn;

    /**
     * @return The Amazon Resource Name (ARN) of an
     * existing IAM role to bind to the add-on&#39;s service account. The role must be
     * assigned the IAM permissions required by the add-on. If you don&#39;t specify
     * an existing IAM role, then the add-on uses the permissions assigned to the node
     * IAM role. For more information, see [Amazon EKS node IAM role](https://docs.aws.amazon.com/eks/latest/userguide/create-node-role.html)
     * in the Amazon EKS User Guide.
     * 
     * &gt; **Note:** To specify an existing IAM role, you must have an IAM OpenID Connect (OIDC)
     * provider created for your cluster. For more information, [see Enabling IAM roles
     * for service accounts on your cluster](https://docs.aws.amazon.com/eks/latest/userguide/enable-iam-roles-for-service-accounts.html)
     * in the Amazon EKS User Guide.
     * 
     */
    public Optional<Output<String>> serviceAccountRoleArn() {
        return Optional.ofNullable(this.serviceAccountRoleArn);
    }

    /**
     * Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * (Optional) Key-value map of resource tags, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return (Optional) Key-value map of resource tags, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    private AddonState() {}

    private AddonState(AddonState $) {
        this.addonName = $.addonName;
        this.addonVersion = $.addonVersion;
        this.arn = $.arn;
        this.clusterName = $.clusterName;
        this.configurationValues = $.configurationValues;
        this.createdAt = $.createdAt;
        this.modifiedAt = $.modifiedAt;
        this.podIdentityAssociations = $.podIdentityAssociations;
        this.preserve = $.preserve;
        this.resolveConflicts = $.resolveConflicts;
        this.resolveConflictsOnCreate = $.resolveConflictsOnCreate;
        this.resolveConflictsOnUpdate = $.resolveConflictsOnUpdate;
        this.serviceAccountRoleArn = $.serviceAccountRoleArn;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AddonState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AddonState $;

        public Builder() {
            $ = new AddonState();
        }

        public Builder(AddonState defaults) {
            $ = new AddonState(Objects.requireNonNull(defaults));
        }

        /**
         * @param addonName Name of the EKS add-on. The name must match one of
         * the names returned by [describe-addon-versions](https://docs.aws.amazon.com/cli/latest/reference/eks/describe-addon-versions.html).
         * 
         * @return builder
         * 
         */
        public Builder addonName(@Nullable Output<String> addonName) {
            $.addonName = addonName;
            return this;
        }

        /**
         * @param addonName Name of the EKS add-on. The name must match one of
         * the names returned by [describe-addon-versions](https://docs.aws.amazon.com/cli/latest/reference/eks/describe-addon-versions.html).
         * 
         * @return builder
         * 
         */
        public Builder addonName(String addonName) {
            return addonName(Output.of(addonName));
        }

        /**
         * @param addonVersion The version of the EKS add-on. The version must
         * match one of the versions returned by [describe-addon-versions](https://docs.aws.amazon.com/cli/latest/reference/eks/describe-addon-versions.html).
         * 
         * @return builder
         * 
         */
        public Builder addonVersion(@Nullable Output<String> addonVersion) {
            $.addonVersion = addonVersion;
            return this;
        }

        /**
         * @param addonVersion The version of the EKS add-on. The version must
         * match one of the versions returned by [describe-addon-versions](https://docs.aws.amazon.com/cli/latest/reference/eks/describe-addon-versions.html).
         * 
         * @return builder
         * 
         */
        public Builder addonVersion(String addonVersion) {
            return addonVersion(Output.of(addonVersion));
        }

        /**
         * @param arn Amazon Resource Name (ARN) of the EKS add-on.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn Amazon Resource Name (ARN) of the EKS add-on.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param clusterName Name of the EKS Cluster.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder clusterName(@Nullable Output<String> clusterName) {
            $.clusterName = clusterName;
            return this;
        }

        /**
         * @param clusterName Name of the EKS Cluster.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder clusterName(String clusterName) {
            return clusterName(Output.of(clusterName));
        }

        /**
         * @param configurationValues custom configuration values for addons with single JSON string. This JSON string value must match the JSON schema derived from [describe-addon-configuration](https://docs.aws.amazon.com/cli/latest/reference/eks/describe-addon-configuration.html).
         * 
         * @return builder
         * 
         */
        public Builder configurationValues(@Nullable Output<String> configurationValues) {
            $.configurationValues = configurationValues;
            return this;
        }

        /**
         * @param configurationValues custom configuration values for addons with single JSON string. This JSON string value must match the JSON schema derived from [describe-addon-configuration](https://docs.aws.amazon.com/cli/latest/reference/eks/describe-addon-configuration.html).
         * 
         * @return builder
         * 
         */
        public Builder configurationValues(String configurationValues) {
            return configurationValues(Output.of(configurationValues));
        }

        /**
         * @param createdAt Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the EKS add-on was created.
         * 
         * @return builder
         * 
         */
        public Builder createdAt(@Nullable Output<String> createdAt) {
            $.createdAt = createdAt;
            return this;
        }

        /**
         * @param createdAt Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the EKS add-on was created.
         * 
         * @return builder
         * 
         */
        public Builder createdAt(String createdAt) {
            return createdAt(Output.of(createdAt));
        }

        /**
         * @param modifiedAt Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the EKS add-on was updated.
         * 
         * @return builder
         * 
         */
        public Builder modifiedAt(@Nullable Output<String> modifiedAt) {
            $.modifiedAt = modifiedAt;
            return this;
        }

        /**
         * @param modifiedAt Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the EKS add-on was updated.
         * 
         * @return builder
         * 
         */
        public Builder modifiedAt(String modifiedAt) {
            return modifiedAt(Output.of(modifiedAt));
        }

        /**
         * @param podIdentityAssociations Configuration block with EKS Pod Identity association settings. See `pod_identity_association` below for details.
         * 
         * @return builder
         * 
         */
        public Builder podIdentityAssociations(@Nullable Output<List<AddonPodIdentityAssociationArgs>> podIdentityAssociations) {
            $.podIdentityAssociations = podIdentityAssociations;
            return this;
        }

        /**
         * @param podIdentityAssociations Configuration block with EKS Pod Identity association settings. See `pod_identity_association` below for details.
         * 
         * @return builder
         * 
         */
        public Builder podIdentityAssociations(List<AddonPodIdentityAssociationArgs> podIdentityAssociations) {
            return podIdentityAssociations(Output.of(podIdentityAssociations));
        }

        /**
         * @param podIdentityAssociations Configuration block with EKS Pod Identity association settings. See `pod_identity_association` below for details.
         * 
         * @return builder
         * 
         */
        public Builder podIdentityAssociations(AddonPodIdentityAssociationArgs... podIdentityAssociations) {
            return podIdentityAssociations(List.of(podIdentityAssociations));
        }

        /**
         * @param preserve Indicates if you want to preserve the created resources when deleting the EKS add-on.
         * 
         * @return builder
         * 
         */
        public Builder preserve(@Nullable Output<Boolean> preserve) {
            $.preserve = preserve;
            return this;
        }

        /**
         * @param preserve Indicates if you want to preserve the created resources when deleting the EKS add-on.
         * 
         * @return builder
         * 
         */
        public Builder preserve(Boolean preserve) {
            return preserve(Output.of(preserve));
        }

        /**
         * @param resolveConflicts Define how to resolve parameter value conflicts when migrating an existing add-on to an Amazon EKS add-on or when applying version updates to the add-on. Valid values are `NONE`, `OVERWRITE` and `PRESERVE`. Note that `PRESERVE` is only valid on addon update, not for initial addon creation. If you need to set this to `PRESERVE`, use the `resolve_conflicts_on_create` and `resolve_conflicts_on_update` attributes instead. For more details check [UpdateAddon](https://docs.aws.amazon.com/eks/latest/APIReference/API_UpdateAddon.html) API Docs.
         * 
         * @return builder
         * 
         * @deprecated
         * resolve_conflicts is deprecated. The resolve_conflicts attribute can&#39;t be set to &#34;PRESERVE&#34; on initial resource creation. Use resolve_conflicts_on_create and/or resolve_conflicts_on_update instead.
         * 
         */
        @Deprecated /* resolve_conflicts is deprecated. The resolve_conflicts attribute can't be set to ""PRESERVE"" on initial resource creation. Use resolve_conflicts_on_create and/or resolve_conflicts_on_update instead. */
        public Builder resolveConflicts(@Nullable Output<String> resolveConflicts) {
            $.resolveConflicts = resolveConflicts;
            return this;
        }

        /**
         * @param resolveConflicts Define how to resolve parameter value conflicts when migrating an existing add-on to an Amazon EKS add-on or when applying version updates to the add-on. Valid values are `NONE`, `OVERWRITE` and `PRESERVE`. Note that `PRESERVE` is only valid on addon update, not for initial addon creation. If you need to set this to `PRESERVE`, use the `resolve_conflicts_on_create` and `resolve_conflicts_on_update` attributes instead. For more details check [UpdateAddon](https://docs.aws.amazon.com/eks/latest/APIReference/API_UpdateAddon.html) API Docs.
         * 
         * @return builder
         * 
         * @deprecated
         * resolve_conflicts is deprecated. The resolve_conflicts attribute can&#39;t be set to &#34;PRESERVE&#34; on initial resource creation. Use resolve_conflicts_on_create and/or resolve_conflicts_on_update instead.
         * 
         */
        @Deprecated /* resolve_conflicts is deprecated. The resolve_conflicts attribute can't be set to ""PRESERVE"" on initial resource creation. Use resolve_conflicts_on_create and/or resolve_conflicts_on_update instead. */
        public Builder resolveConflicts(String resolveConflicts) {
            return resolveConflicts(Output.of(resolveConflicts));
        }

        /**
         * @param resolveConflictsOnCreate How to resolve field value conflicts when migrating a self-managed add-on to an Amazon EKS add-on. Valid values are `NONE` and `OVERWRITE`. For more details see the [CreateAddon](https://docs.aws.amazon.com/eks/latest/APIReference/API_CreateAddon.html) API Docs.
         * 
         * @return builder
         * 
         */
        public Builder resolveConflictsOnCreate(@Nullable Output<String> resolveConflictsOnCreate) {
            $.resolveConflictsOnCreate = resolveConflictsOnCreate;
            return this;
        }

        /**
         * @param resolveConflictsOnCreate How to resolve field value conflicts when migrating a self-managed add-on to an Amazon EKS add-on. Valid values are `NONE` and `OVERWRITE`. For more details see the [CreateAddon](https://docs.aws.amazon.com/eks/latest/APIReference/API_CreateAddon.html) API Docs.
         * 
         * @return builder
         * 
         */
        public Builder resolveConflictsOnCreate(String resolveConflictsOnCreate) {
            return resolveConflictsOnCreate(Output.of(resolveConflictsOnCreate));
        }

        /**
         * @param resolveConflictsOnUpdate How to resolve field value conflicts for an Amazon EKS add-on if you&#39;ve changed a value from the Amazon EKS default value. Valid values are `NONE`, `OVERWRITE`, and `PRESERVE`. For more details see the [UpdateAddon](https://docs.aws.amazon.com/eks/latest/APIReference/API_UpdateAddon.html) API Docs.
         * 
         * @return builder
         * 
         */
        public Builder resolveConflictsOnUpdate(@Nullable Output<String> resolveConflictsOnUpdate) {
            $.resolveConflictsOnUpdate = resolveConflictsOnUpdate;
            return this;
        }

        /**
         * @param resolveConflictsOnUpdate How to resolve field value conflicts for an Amazon EKS add-on if you&#39;ve changed a value from the Amazon EKS default value. Valid values are `NONE`, `OVERWRITE`, and `PRESERVE`. For more details see the [UpdateAddon](https://docs.aws.amazon.com/eks/latest/APIReference/API_UpdateAddon.html) API Docs.
         * 
         * @return builder
         * 
         */
        public Builder resolveConflictsOnUpdate(String resolveConflictsOnUpdate) {
            return resolveConflictsOnUpdate(Output.of(resolveConflictsOnUpdate));
        }

        /**
         * @param serviceAccountRoleArn The Amazon Resource Name (ARN) of an
         * existing IAM role to bind to the add-on&#39;s service account. The role must be
         * assigned the IAM permissions required by the add-on. If you don&#39;t specify
         * an existing IAM role, then the add-on uses the permissions assigned to the node
         * IAM role. For more information, see [Amazon EKS node IAM role](https://docs.aws.amazon.com/eks/latest/userguide/create-node-role.html)
         * in the Amazon EKS User Guide.
         * 
         * &gt; **Note:** To specify an existing IAM role, you must have an IAM OpenID Connect (OIDC)
         * provider created for your cluster. For more information, [see Enabling IAM roles
         * for service accounts on your cluster](https://docs.aws.amazon.com/eks/latest/userguide/enable-iam-roles-for-service-accounts.html)
         * in the Amazon EKS User Guide.
         * 
         * @return builder
         * 
         */
        public Builder serviceAccountRoleArn(@Nullable Output<String> serviceAccountRoleArn) {
            $.serviceAccountRoleArn = serviceAccountRoleArn;
            return this;
        }

        /**
         * @param serviceAccountRoleArn The Amazon Resource Name (ARN) of an
         * existing IAM role to bind to the add-on&#39;s service account. The role must be
         * assigned the IAM permissions required by the add-on. If you don&#39;t specify
         * an existing IAM role, then the add-on uses the permissions assigned to the node
         * IAM role. For more information, see [Amazon EKS node IAM role](https://docs.aws.amazon.com/eks/latest/userguide/create-node-role.html)
         * in the Amazon EKS User Guide.
         * 
         * &gt; **Note:** To specify an existing IAM role, you must have an IAM OpenID Connect (OIDC)
         * provider created for your cluster. For more information, [see Enabling IAM roles
         * for service accounts on your cluster](https://docs.aws.amazon.com/eks/latest/userguide/enable-iam-roles-for-service-accounts.html)
         * in the Amazon EKS User Guide.
         * 
         * @return builder
         * 
         */
        public Builder serviceAccountRoleArn(String serviceAccountRoleArn) {
            return serviceAccountRoleArn(Output.of(serviceAccountRoleArn));
        }

        /**
         * @param tags Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll (Optional) Key-value map of resource tags, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @param tagsAll (Optional) Key-value map of resource tags, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        public AddonState build() {
            return $;
        }
    }

}
