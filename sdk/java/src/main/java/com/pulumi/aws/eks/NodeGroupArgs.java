// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.eks;

import com.pulumi.aws.eks.inputs.NodeGroupLaunchTemplateArgs;
import com.pulumi.aws.eks.inputs.NodeGroupNodeRepairConfigArgs;
import com.pulumi.aws.eks.inputs.NodeGroupRemoteAccessArgs;
import com.pulumi.aws.eks.inputs.NodeGroupScalingConfigArgs;
import com.pulumi.aws.eks.inputs.NodeGroupTaintArgs;
import com.pulumi.aws.eks.inputs.NodeGroupUpdateConfigArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class NodeGroupArgs extends com.pulumi.resources.ResourceArgs {

    public static final NodeGroupArgs Empty = new NodeGroupArgs();

    /**
     * Type of Amazon Machine Image (AMI) associated with the EKS Node Group. See the [AWS documentation](https://docs.aws.amazon.com/eks/latest/APIReference/API_Nodegroup.html#AmazonEKS-Type-Nodegroup-amiType) for valid values. This provider will only perform drift detection if a configuration value is provided.
     * 
     */
    @Import(name="amiType")
    private @Nullable Output<String> amiType;

    /**
     * @return Type of Amazon Machine Image (AMI) associated with the EKS Node Group. See the [AWS documentation](https://docs.aws.amazon.com/eks/latest/APIReference/API_Nodegroup.html#AmazonEKS-Type-Nodegroup-amiType) for valid values. This provider will only perform drift detection if a configuration value is provided.
     * 
     */
    public Optional<Output<String>> amiType() {
        return Optional.ofNullable(this.amiType);
    }

    /**
     * Type of capacity associated with the EKS Node Group. Valid values: `ON_DEMAND`, `SPOT`. This provider will only perform drift detection if a configuration value is provided.
     * 
     */
    @Import(name="capacityType")
    private @Nullable Output<String> capacityType;

    /**
     * @return Type of capacity associated with the EKS Node Group. Valid values: `ON_DEMAND`, `SPOT`. This provider will only perform drift detection if a configuration value is provided.
     * 
     */
    public Optional<Output<String>> capacityType() {
        return Optional.ofNullable(this.capacityType);
    }

    /**
     * Name of the EKS Cluster.
     * 
     */
    @Import(name="clusterName", required=true)
    private Output<String> clusterName;

    /**
     * @return Name of the EKS Cluster.
     * 
     */
    public Output<String> clusterName() {
        return this.clusterName;
    }

    /**
     * Disk size in GiB for worker nodes. Defaults to `50` for Windows, `20` all other node groups. The provider will only perform drift detection if a configuration value is provided.
     * 
     */
    @Import(name="diskSize")
    private @Nullable Output<Integer> diskSize;

    /**
     * @return Disk size in GiB for worker nodes. Defaults to `50` for Windows, `20` all other node groups. The provider will only perform drift detection if a configuration value is provided.
     * 
     */
    public Optional<Output<Integer>> diskSize() {
        return Optional.ofNullable(this.diskSize);
    }

    /**
     * Force version update if existing pods are unable to be drained due to a pod disruption budget issue.
     * 
     */
    @Import(name="forceUpdateVersion")
    private @Nullable Output<Boolean> forceUpdateVersion;

    /**
     * @return Force version update if existing pods are unable to be drained due to a pod disruption budget issue.
     * 
     */
    public Optional<Output<Boolean>> forceUpdateVersion() {
        return Optional.ofNullable(this.forceUpdateVersion);
    }

    /**
     * List of instance types associated with the EKS Node Group. Defaults to `[&#34;t3.medium&#34;]`. The provider will only perform drift detection if a configuration value is provided.
     * 
     */
    @Import(name="instanceTypes")
    private @Nullable Output<List<String>> instanceTypes;

    /**
     * @return List of instance types associated with the EKS Node Group. Defaults to `[&#34;t3.medium&#34;]`. The provider will only perform drift detection if a configuration value is provided.
     * 
     */
    public Optional<Output<List<String>>> instanceTypes() {
        return Optional.ofNullable(this.instanceTypes);
    }

    /**
     * Key-value map of Kubernetes labels. Only labels that are applied with the EKS API are managed by this argument. Other Kubernetes labels applied to the EKS Node Group will not be managed.
     * 
     */
    @Import(name="labels")
    private @Nullable Output<Map<String,String>> labels;

    /**
     * @return Key-value map of Kubernetes labels. Only labels that are applied with the EKS API are managed by this argument. Other Kubernetes labels applied to the EKS Node Group will not be managed.
     * 
     */
    public Optional<Output<Map<String,String>>> labels() {
        return Optional.ofNullable(this.labels);
    }

    /**
     * Configuration block with Launch Template settings. See `launch_template` below for details. Conflicts with `remote_access`.
     * 
     */
    @Import(name="launchTemplate")
    private @Nullable Output<NodeGroupLaunchTemplateArgs> launchTemplate;

    /**
     * @return Configuration block with Launch Template settings. See `launch_template` below for details. Conflicts with `remote_access`.
     * 
     */
    public Optional<Output<NodeGroupLaunchTemplateArgs>> launchTemplate() {
        return Optional.ofNullable(this.launchTemplate);
    }

    /**
     * Name of the EKS Node Group. If omitted, the provider will assign a random, unique name. Conflicts with `node_group_name_prefix`. The node group name can&#39;t be longer than 63 characters. It must start with a letter or digit, but can also include hyphens and underscores for the remaining characters.
     * 
     */
    @Import(name="nodeGroupName")
    private @Nullable Output<String> nodeGroupName;

    /**
     * @return Name of the EKS Node Group. If omitted, the provider will assign a random, unique name. Conflicts with `node_group_name_prefix`. The node group name can&#39;t be longer than 63 characters. It must start with a letter or digit, but can also include hyphens and underscores for the remaining characters.
     * 
     */
    public Optional<Output<String>> nodeGroupName() {
        return Optional.ofNullable(this.nodeGroupName);
    }

    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `node_group_name`.
     * 
     */
    @Import(name="nodeGroupNamePrefix")
    private @Nullable Output<String> nodeGroupNamePrefix;

    /**
     * @return Creates a unique name beginning with the specified prefix. Conflicts with `node_group_name`.
     * 
     */
    public Optional<Output<String>> nodeGroupNamePrefix() {
        return Optional.ofNullable(this.nodeGroupNamePrefix);
    }

    /**
     * The node auto repair configuration for the node group. See `node_repair_config` below for details.
     * 
     */
    @Import(name="nodeRepairConfig")
    private @Nullable Output<NodeGroupNodeRepairConfigArgs> nodeRepairConfig;

    /**
     * @return The node auto repair configuration for the node group. See `node_repair_config` below for details.
     * 
     */
    public Optional<Output<NodeGroupNodeRepairConfigArgs>> nodeRepairConfig() {
        return Optional.ofNullable(this.nodeRepairConfig);
    }

    /**
     * Amazon Resource Name (ARN) of the IAM Role that provides permissions for the EKS Node Group.
     * 
     */
    @Import(name="nodeRoleArn", required=true)
    private Output<String> nodeRoleArn;

    /**
     * @return Amazon Resource Name (ARN) of the IAM Role that provides permissions for the EKS Node Group.
     * 
     */
    public Output<String> nodeRoleArn() {
        return this.nodeRoleArn;
    }

    /**
     * AMI version of the EKS Node Group. Defaults to latest version for Kubernetes version.
     * 
     */
    @Import(name="releaseVersion")
    private @Nullable Output<String> releaseVersion;

    /**
     * @return AMI version of the EKS Node Group. Defaults to latest version for Kubernetes version.
     * 
     */
    public Optional<Output<String>> releaseVersion() {
        return Optional.ofNullable(this.releaseVersion);
    }

    /**
     * Configuration block with remote access settings. See `remote_access` below for details. Conflicts with `launch_template`.
     * 
     */
    @Import(name="remoteAccess")
    private @Nullable Output<NodeGroupRemoteAccessArgs> remoteAccess;

    /**
     * @return Configuration block with remote access settings. See `remote_access` below for details. Conflicts with `launch_template`.
     * 
     */
    public Optional<Output<NodeGroupRemoteAccessArgs>> remoteAccess() {
        return Optional.ofNullable(this.remoteAccess);
    }

    /**
     * Configuration block with scaling settings. See `scaling_config` below for details.
     * 
     */
    @Import(name="scalingConfig", required=true)
    private Output<NodeGroupScalingConfigArgs> scalingConfig;

    /**
     * @return Configuration block with scaling settings. See `scaling_config` below for details.
     * 
     */
    public Output<NodeGroupScalingConfigArgs> scalingConfig() {
        return this.scalingConfig;
    }

    /**
     * Identifiers of EC2 Subnets to associate with the EKS Node Group.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="subnetIds", required=true)
    private Output<List<String>> subnetIds;

    /**
     * @return Identifiers of EC2 Subnets to associate with the EKS Node Group.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<List<String>> subnetIds() {
        return this.subnetIds;
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
     * The Kubernetes taints to be applied to the nodes in the node group. Maximum of 50 taints per node group. See taint below for details.
     * 
     */
    @Import(name="taints")
    private @Nullable Output<List<NodeGroupTaintArgs>> taints;

    /**
     * @return The Kubernetes taints to be applied to the nodes in the node group. Maximum of 50 taints per node group. See taint below for details.
     * 
     */
    public Optional<Output<List<NodeGroupTaintArgs>>> taints() {
        return Optional.ofNullable(this.taints);
    }

    /**
     * Configuration block with update settings. See `update_config` below for details.
     * 
     */
    @Import(name="updateConfig")
    private @Nullable Output<NodeGroupUpdateConfigArgs> updateConfig;

    /**
     * @return Configuration block with update settings. See `update_config` below for details.
     * 
     */
    public Optional<Output<NodeGroupUpdateConfigArgs>> updateConfig() {
        return Optional.ofNullable(this.updateConfig);
    }

    /**
     * Kubernetes version. Defaults to EKS Cluster Kubernetes version. The provider will only perform drift detection if a configuration value is provided.
     * 
     */
    @Import(name="version")
    private @Nullable Output<String> version;

    /**
     * @return Kubernetes version. Defaults to EKS Cluster Kubernetes version. The provider will only perform drift detection if a configuration value is provided.
     * 
     */
    public Optional<Output<String>> version() {
        return Optional.ofNullable(this.version);
    }

    private NodeGroupArgs() {}

    private NodeGroupArgs(NodeGroupArgs $) {
        this.amiType = $.amiType;
        this.capacityType = $.capacityType;
        this.clusterName = $.clusterName;
        this.diskSize = $.diskSize;
        this.forceUpdateVersion = $.forceUpdateVersion;
        this.instanceTypes = $.instanceTypes;
        this.labels = $.labels;
        this.launchTemplate = $.launchTemplate;
        this.nodeGroupName = $.nodeGroupName;
        this.nodeGroupNamePrefix = $.nodeGroupNamePrefix;
        this.nodeRepairConfig = $.nodeRepairConfig;
        this.nodeRoleArn = $.nodeRoleArn;
        this.releaseVersion = $.releaseVersion;
        this.remoteAccess = $.remoteAccess;
        this.scalingConfig = $.scalingConfig;
        this.subnetIds = $.subnetIds;
        this.tags = $.tags;
        this.taints = $.taints;
        this.updateConfig = $.updateConfig;
        this.version = $.version;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(NodeGroupArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private NodeGroupArgs $;

        public Builder() {
            $ = new NodeGroupArgs();
        }

        public Builder(NodeGroupArgs defaults) {
            $ = new NodeGroupArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param amiType Type of Amazon Machine Image (AMI) associated with the EKS Node Group. See the [AWS documentation](https://docs.aws.amazon.com/eks/latest/APIReference/API_Nodegroup.html#AmazonEKS-Type-Nodegroup-amiType) for valid values. This provider will only perform drift detection if a configuration value is provided.
         * 
         * @return builder
         * 
         */
        public Builder amiType(@Nullable Output<String> amiType) {
            $.amiType = amiType;
            return this;
        }

        /**
         * @param amiType Type of Amazon Machine Image (AMI) associated with the EKS Node Group. See the [AWS documentation](https://docs.aws.amazon.com/eks/latest/APIReference/API_Nodegroup.html#AmazonEKS-Type-Nodegroup-amiType) for valid values. This provider will only perform drift detection if a configuration value is provided.
         * 
         * @return builder
         * 
         */
        public Builder amiType(String amiType) {
            return amiType(Output.of(amiType));
        }

        /**
         * @param capacityType Type of capacity associated with the EKS Node Group. Valid values: `ON_DEMAND`, `SPOT`. This provider will only perform drift detection if a configuration value is provided.
         * 
         * @return builder
         * 
         */
        public Builder capacityType(@Nullable Output<String> capacityType) {
            $.capacityType = capacityType;
            return this;
        }

        /**
         * @param capacityType Type of capacity associated with the EKS Node Group. Valid values: `ON_DEMAND`, `SPOT`. This provider will only perform drift detection if a configuration value is provided.
         * 
         * @return builder
         * 
         */
        public Builder capacityType(String capacityType) {
            return capacityType(Output.of(capacityType));
        }

        /**
         * @param clusterName Name of the EKS Cluster.
         * 
         * @return builder
         * 
         */
        public Builder clusterName(Output<String> clusterName) {
            $.clusterName = clusterName;
            return this;
        }

        /**
         * @param clusterName Name of the EKS Cluster.
         * 
         * @return builder
         * 
         */
        public Builder clusterName(String clusterName) {
            return clusterName(Output.of(clusterName));
        }

        /**
         * @param diskSize Disk size in GiB for worker nodes. Defaults to `50` for Windows, `20` all other node groups. The provider will only perform drift detection if a configuration value is provided.
         * 
         * @return builder
         * 
         */
        public Builder diskSize(@Nullable Output<Integer> diskSize) {
            $.diskSize = diskSize;
            return this;
        }

        /**
         * @param diskSize Disk size in GiB for worker nodes. Defaults to `50` for Windows, `20` all other node groups. The provider will only perform drift detection if a configuration value is provided.
         * 
         * @return builder
         * 
         */
        public Builder diskSize(Integer diskSize) {
            return diskSize(Output.of(diskSize));
        }

        /**
         * @param forceUpdateVersion Force version update if existing pods are unable to be drained due to a pod disruption budget issue.
         * 
         * @return builder
         * 
         */
        public Builder forceUpdateVersion(@Nullable Output<Boolean> forceUpdateVersion) {
            $.forceUpdateVersion = forceUpdateVersion;
            return this;
        }

        /**
         * @param forceUpdateVersion Force version update if existing pods are unable to be drained due to a pod disruption budget issue.
         * 
         * @return builder
         * 
         */
        public Builder forceUpdateVersion(Boolean forceUpdateVersion) {
            return forceUpdateVersion(Output.of(forceUpdateVersion));
        }

        /**
         * @param instanceTypes List of instance types associated with the EKS Node Group. Defaults to `[&#34;t3.medium&#34;]`. The provider will only perform drift detection if a configuration value is provided.
         * 
         * @return builder
         * 
         */
        public Builder instanceTypes(@Nullable Output<List<String>> instanceTypes) {
            $.instanceTypes = instanceTypes;
            return this;
        }

        /**
         * @param instanceTypes List of instance types associated with the EKS Node Group. Defaults to `[&#34;t3.medium&#34;]`. The provider will only perform drift detection if a configuration value is provided.
         * 
         * @return builder
         * 
         */
        public Builder instanceTypes(List<String> instanceTypes) {
            return instanceTypes(Output.of(instanceTypes));
        }

        /**
         * @param instanceTypes List of instance types associated with the EKS Node Group. Defaults to `[&#34;t3.medium&#34;]`. The provider will only perform drift detection if a configuration value is provided.
         * 
         * @return builder
         * 
         */
        public Builder instanceTypes(String... instanceTypes) {
            return instanceTypes(List.of(instanceTypes));
        }

        /**
         * @param labels Key-value map of Kubernetes labels. Only labels that are applied with the EKS API are managed by this argument. Other Kubernetes labels applied to the EKS Node Group will not be managed.
         * 
         * @return builder
         * 
         */
        public Builder labels(@Nullable Output<Map<String,String>> labels) {
            $.labels = labels;
            return this;
        }

        /**
         * @param labels Key-value map of Kubernetes labels. Only labels that are applied with the EKS API are managed by this argument. Other Kubernetes labels applied to the EKS Node Group will not be managed.
         * 
         * @return builder
         * 
         */
        public Builder labels(Map<String,String> labels) {
            return labels(Output.of(labels));
        }

        /**
         * @param launchTemplate Configuration block with Launch Template settings. See `launch_template` below for details. Conflicts with `remote_access`.
         * 
         * @return builder
         * 
         */
        public Builder launchTemplate(@Nullable Output<NodeGroupLaunchTemplateArgs> launchTemplate) {
            $.launchTemplate = launchTemplate;
            return this;
        }

        /**
         * @param launchTemplate Configuration block with Launch Template settings. See `launch_template` below for details. Conflicts with `remote_access`.
         * 
         * @return builder
         * 
         */
        public Builder launchTemplate(NodeGroupLaunchTemplateArgs launchTemplate) {
            return launchTemplate(Output.of(launchTemplate));
        }

        /**
         * @param nodeGroupName Name of the EKS Node Group. If omitted, the provider will assign a random, unique name. Conflicts with `node_group_name_prefix`. The node group name can&#39;t be longer than 63 characters. It must start with a letter or digit, but can also include hyphens and underscores for the remaining characters.
         * 
         * @return builder
         * 
         */
        public Builder nodeGroupName(@Nullable Output<String> nodeGroupName) {
            $.nodeGroupName = nodeGroupName;
            return this;
        }

        /**
         * @param nodeGroupName Name of the EKS Node Group. If omitted, the provider will assign a random, unique name. Conflicts with `node_group_name_prefix`. The node group name can&#39;t be longer than 63 characters. It must start with a letter or digit, but can also include hyphens and underscores for the remaining characters.
         * 
         * @return builder
         * 
         */
        public Builder nodeGroupName(String nodeGroupName) {
            return nodeGroupName(Output.of(nodeGroupName));
        }

        /**
         * @param nodeGroupNamePrefix Creates a unique name beginning with the specified prefix. Conflicts with `node_group_name`.
         * 
         * @return builder
         * 
         */
        public Builder nodeGroupNamePrefix(@Nullable Output<String> nodeGroupNamePrefix) {
            $.nodeGroupNamePrefix = nodeGroupNamePrefix;
            return this;
        }

        /**
         * @param nodeGroupNamePrefix Creates a unique name beginning with the specified prefix. Conflicts with `node_group_name`.
         * 
         * @return builder
         * 
         */
        public Builder nodeGroupNamePrefix(String nodeGroupNamePrefix) {
            return nodeGroupNamePrefix(Output.of(nodeGroupNamePrefix));
        }

        /**
         * @param nodeRepairConfig The node auto repair configuration for the node group. See `node_repair_config` below for details.
         * 
         * @return builder
         * 
         */
        public Builder nodeRepairConfig(@Nullable Output<NodeGroupNodeRepairConfigArgs> nodeRepairConfig) {
            $.nodeRepairConfig = nodeRepairConfig;
            return this;
        }

        /**
         * @param nodeRepairConfig The node auto repair configuration for the node group. See `node_repair_config` below for details.
         * 
         * @return builder
         * 
         */
        public Builder nodeRepairConfig(NodeGroupNodeRepairConfigArgs nodeRepairConfig) {
            return nodeRepairConfig(Output.of(nodeRepairConfig));
        }

        /**
         * @param nodeRoleArn Amazon Resource Name (ARN) of the IAM Role that provides permissions for the EKS Node Group.
         * 
         * @return builder
         * 
         */
        public Builder nodeRoleArn(Output<String> nodeRoleArn) {
            $.nodeRoleArn = nodeRoleArn;
            return this;
        }

        /**
         * @param nodeRoleArn Amazon Resource Name (ARN) of the IAM Role that provides permissions for the EKS Node Group.
         * 
         * @return builder
         * 
         */
        public Builder nodeRoleArn(String nodeRoleArn) {
            return nodeRoleArn(Output.of(nodeRoleArn));
        }

        /**
         * @param releaseVersion AMI version of the EKS Node Group. Defaults to latest version for Kubernetes version.
         * 
         * @return builder
         * 
         */
        public Builder releaseVersion(@Nullable Output<String> releaseVersion) {
            $.releaseVersion = releaseVersion;
            return this;
        }

        /**
         * @param releaseVersion AMI version of the EKS Node Group. Defaults to latest version for Kubernetes version.
         * 
         * @return builder
         * 
         */
        public Builder releaseVersion(String releaseVersion) {
            return releaseVersion(Output.of(releaseVersion));
        }

        /**
         * @param remoteAccess Configuration block with remote access settings. See `remote_access` below for details. Conflicts with `launch_template`.
         * 
         * @return builder
         * 
         */
        public Builder remoteAccess(@Nullable Output<NodeGroupRemoteAccessArgs> remoteAccess) {
            $.remoteAccess = remoteAccess;
            return this;
        }

        /**
         * @param remoteAccess Configuration block with remote access settings. See `remote_access` below for details. Conflicts with `launch_template`.
         * 
         * @return builder
         * 
         */
        public Builder remoteAccess(NodeGroupRemoteAccessArgs remoteAccess) {
            return remoteAccess(Output.of(remoteAccess));
        }

        /**
         * @param scalingConfig Configuration block with scaling settings. See `scaling_config` below for details.
         * 
         * @return builder
         * 
         */
        public Builder scalingConfig(Output<NodeGroupScalingConfigArgs> scalingConfig) {
            $.scalingConfig = scalingConfig;
            return this;
        }

        /**
         * @param scalingConfig Configuration block with scaling settings. See `scaling_config` below for details.
         * 
         * @return builder
         * 
         */
        public Builder scalingConfig(NodeGroupScalingConfigArgs scalingConfig) {
            return scalingConfig(Output.of(scalingConfig));
        }

        /**
         * @param subnetIds Identifiers of EC2 Subnets to associate with the EKS Node Group.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(Output<List<String>> subnetIds) {
            $.subnetIds = subnetIds;
            return this;
        }

        /**
         * @param subnetIds Identifiers of EC2 Subnets to associate with the EKS Node Group.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(List<String> subnetIds) {
            return subnetIds(Output.of(subnetIds));
        }

        /**
         * @param subnetIds Identifiers of EC2 Subnets to associate with the EKS Node Group.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(String... subnetIds) {
            return subnetIds(List.of(subnetIds));
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
         * @param taints The Kubernetes taints to be applied to the nodes in the node group. Maximum of 50 taints per node group. See taint below for details.
         * 
         * @return builder
         * 
         */
        public Builder taints(@Nullable Output<List<NodeGroupTaintArgs>> taints) {
            $.taints = taints;
            return this;
        }

        /**
         * @param taints The Kubernetes taints to be applied to the nodes in the node group. Maximum of 50 taints per node group. See taint below for details.
         * 
         * @return builder
         * 
         */
        public Builder taints(List<NodeGroupTaintArgs> taints) {
            return taints(Output.of(taints));
        }

        /**
         * @param taints The Kubernetes taints to be applied to the nodes in the node group. Maximum of 50 taints per node group. See taint below for details.
         * 
         * @return builder
         * 
         */
        public Builder taints(NodeGroupTaintArgs... taints) {
            return taints(List.of(taints));
        }

        /**
         * @param updateConfig Configuration block with update settings. See `update_config` below for details.
         * 
         * @return builder
         * 
         */
        public Builder updateConfig(@Nullable Output<NodeGroupUpdateConfigArgs> updateConfig) {
            $.updateConfig = updateConfig;
            return this;
        }

        /**
         * @param updateConfig Configuration block with update settings. See `update_config` below for details.
         * 
         * @return builder
         * 
         */
        public Builder updateConfig(NodeGroupUpdateConfigArgs updateConfig) {
            return updateConfig(Output.of(updateConfig));
        }

        /**
         * @param version Kubernetes version. Defaults to EKS Cluster Kubernetes version. The provider will only perform drift detection if a configuration value is provided.
         * 
         * @return builder
         * 
         */
        public Builder version(@Nullable Output<String> version) {
            $.version = version;
            return this;
        }

        /**
         * @param version Kubernetes version. Defaults to EKS Cluster Kubernetes version. The provider will only perform drift detection if a configuration value is provided.
         * 
         * @return builder
         * 
         */
        public Builder version(String version) {
            return version(Output.of(version));
        }

        public NodeGroupArgs build() {
            if ($.clusterName == null) {
                throw new MissingRequiredPropertyException("NodeGroupArgs", "clusterName");
            }
            if ($.nodeRoleArn == null) {
                throw new MissingRequiredPropertyException("NodeGroupArgs", "nodeRoleArn");
            }
            if ($.scalingConfig == null) {
                throw new MissingRequiredPropertyException("NodeGroupArgs", "scalingConfig");
            }
            if ($.subnetIds == null) {
                throw new MissingRequiredPropertyException("NodeGroupArgs", "subnetIds");
            }
            return $;
        }
    }

}
