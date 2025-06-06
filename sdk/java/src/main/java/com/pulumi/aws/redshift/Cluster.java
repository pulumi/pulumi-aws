// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.redshift;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.redshift.ClusterArgs;
import com.pulumi.aws.redshift.inputs.ClusterState;
import com.pulumi.aws.redshift.outputs.ClusterClusterNode;
import com.pulumi.aws.redshift.outputs.ClusterLogging;
import com.pulumi.aws.redshift.outputs.ClusterSnapshotCopy;
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
 * import com.pulumi.aws.redshift.Cluster;
 * import com.pulumi.aws.redshift.ClusterArgs;
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
 *         var example = new Cluster("example", ClusterArgs.builder()
 *             .clusterIdentifier("tf-redshift-cluster")
 *             .databaseName("mydb")
 *             .masterUsername("exampleuser")
 *             .masterPassword("Mustbe8characters")
 *             .nodeType("dc1.large")
 *             .clusterType("single-node")
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### With Managed Credentials
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.redshift.Cluster;
 * import com.pulumi.aws.redshift.ClusterArgs;
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
 *         var example = new Cluster("example", ClusterArgs.builder()
 *             .clusterIdentifier("tf-redshift-cluster")
 *             .databaseName("mydb")
 *             .masterUsername("exampleuser")
 *             .nodeType("dc1.large")
 *             .clusterType("single-node")
 *             .manageMasterPassword(true)
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
 * Using `pulumi import`, import Redshift Clusters using the `cluster_identifier`. For example:
 * 
 * ```sh
 * $ pulumi import aws:redshift/cluster:Cluster myprodcluster tf-redshift-cluster-12345
 * ```
 * 
 */
@ResourceType(type="aws:redshift/cluster:Cluster")
public class Cluster extends com.pulumi.resources.CustomResource {
    /**
     * If true , major version upgrades can be applied during the maintenance window to the Amazon Redshift engine that is running on the cluster. Default is `true`.
     * 
     */
    @Export(name="allowVersionUpgrade", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> allowVersionUpgrade;

    /**
     * @return If true , major version upgrades can be applied during the maintenance window to the Amazon Redshift engine that is running on the cluster. Default is `true`.
     * 
     */
    public Output<Optional<Boolean>> allowVersionUpgrade() {
        return Codegen.optional(this.allowVersionUpgrade);
    }
    /**
     * Specifies whether any cluster modifications are applied immediately, or during the next maintenance window. Default is `false`.
     * 
     */
    @Export(name="applyImmediately", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> applyImmediately;

    /**
     * @return Specifies whether any cluster modifications are applied immediately, or during the next maintenance window. Default is `false`.
     * 
     */
    public Output<Optional<Boolean>> applyImmediately() {
        return Codegen.optional(this.applyImmediately);
    }
    /**
     * The value represents how the cluster is configured to use AQUA (Advanced Query Accelerator) after the cluster is restored.
     * No longer supported by the AWS API.
     * Always returns `auto`.
     * 
     * @deprecated
     * aqua_configuration_status is deprecated. This parameter is no longer supported by the AWS API. It will be removed in the next major version of the provider.
     * 
     */
    @Deprecated /* aqua_configuration_status is deprecated. This parameter is no longer supported by the AWS API. It will be removed in the next major version of the provider. */
    @Export(name="aquaConfigurationStatus", refs={String.class}, tree="[0]")
    private Output<String> aquaConfigurationStatus;

    /**
     * @return The value represents how the cluster is configured to use AQUA (Advanced Query Accelerator) after the cluster is restored.
     * No longer supported by the AWS API.
     * Always returns `auto`.
     * 
     */
    public Output<String> aquaConfigurationStatus() {
        return this.aquaConfigurationStatus;
    }
    /**
     * Amazon Resource Name (ARN) of cluster
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN) of cluster
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The number of days that automated snapshots are retained. If the value is 0, automated snapshots are disabled. Even if automated snapshots are disabled, you can still create manual snapshots when you want with create-cluster-snapshot. Default is 1.
     * 
     */
    @Export(name="automatedSnapshotRetentionPeriod", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> automatedSnapshotRetentionPeriod;

    /**
     * @return The number of days that automated snapshots are retained. If the value is 0, automated snapshots are disabled. Even if automated snapshots are disabled, you can still create manual snapshots when you want with create-cluster-snapshot. Default is 1.
     * 
     */
    public Output<Optional<Integer>> automatedSnapshotRetentionPeriod() {
        return Codegen.optional(this.automatedSnapshotRetentionPeriod);
    }
    /**
     * The EC2 Availability Zone (AZ) in which you want Amazon Redshift to provision the cluster. For example, if you have several EC2 instances running in a specific Availability Zone, then you might want the cluster to be provisioned in the same zone in order to decrease network latency. Can only be changed if `availability_zone_relocation_enabled` is `true`.
     * 
     */
    @Export(name="availabilityZone", refs={String.class}, tree="[0]")
    private Output<String> availabilityZone;

    /**
     * @return The EC2 Availability Zone (AZ) in which you want Amazon Redshift to provision the cluster. For example, if you have several EC2 instances running in a specific Availability Zone, then you might want the cluster to be provisioned in the same zone in order to decrease network latency. Can only be changed if `availability_zone_relocation_enabled` is `true`.
     * 
     */
    public Output<String> availabilityZone() {
        return this.availabilityZone;
    }
    /**
     * If true, the cluster can be relocated to another availabity zone, either automatically by AWS or when requested. Default is `false`. Available for use on clusters from the RA3 instance family.
     * 
     */
    @Export(name="availabilityZoneRelocationEnabled", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> availabilityZoneRelocationEnabled;

    /**
     * @return If true, the cluster can be relocated to another availabity zone, either automatically by AWS or when requested. Default is `false`. Available for use on clusters from the RA3 instance family.
     * 
     */
    public Output<Optional<Boolean>> availabilityZoneRelocationEnabled() {
        return Codegen.optional(this.availabilityZoneRelocationEnabled);
    }
    /**
     * The Cluster Identifier. Must be a lower case string.
     * 
     */
    @Export(name="clusterIdentifier", refs={String.class}, tree="[0]")
    private Output<String> clusterIdentifier;

    /**
     * @return The Cluster Identifier. Must be a lower case string.
     * 
     */
    public Output<String> clusterIdentifier() {
        return this.clusterIdentifier;
    }
    /**
     * The namespace Amazon Resource Name (ARN) of the cluster
     * 
     */
    @Export(name="clusterNamespaceArn", refs={String.class}, tree="[0]")
    private Output<String> clusterNamespaceArn;

    /**
     * @return The namespace Amazon Resource Name (ARN) of the cluster
     * 
     */
    public Output<String> clusterNamespaceArn() {
        return this.clusterNamespaceArn;
    }
    /**
     * The nodes in the cluster. Cluster node blocks are documented below
     * 
     */
    @Export(name="clusterNodes", refs={List.class,ClusterClusterNode.class}, tree="[0,1]")
    private Output<List<ClusterClusterNode>> clusterNodes;

    /**
     * @return The nodes in the cluster. Cluster node blocks are documented below
     * 
     */
    public Output<List<ClusterClusterNode>> clusterNodes() {
        return this.clusterNodes;
    }
    /**
     * The name of the parameter group to be associated with this cluster.
     * 
     */
    @Export(name="clusterParameterGroupName", refs={String.class}, tree="[0]")
    private Output<String> clusterParameterGroupName;

    /**
     * @return The name of the parameter group to be associated with this cluster.
     * 
     */
    public Output<String> clusterParameterGroupName() {
        return this.clusterParameterGroupName;
    }
    /**
     * The public key for the cluster
     * 
     */
    @Export(name="clusterPublicKey", refs={String.class}, tree="[0]")
    private Output<String> clusterPublicKey;

    /**
     * @return The public key for the cluster
     * 
     */
    public Output<String> clusterPublicKey() {
        return this.clusterPublicKey;
    }
    /**
     * The specific revision number of the database in the cluster
     * 
     */
    @Export(name="clusterRevisionNumber", refs={String.class}, tree="[0]")
    private Output<String> clusterRevisionNumber;

    /**
     * @return The specific revision number of the database in the cluster
     * 
     */
    public Output<String> clusterRevisionNumber() {
        return this.clusterRevisionNumber;
    }
    /**
     * The name of a cluster subnet group to be associated with this cluster. If this parameter is not provided the resulting cluster will be deployed outside virtual private cloud (VPC).
     * 
     */
    @Export(name="clusterSubnetGroupName", refs={String.class}, tree="[0]")
    private Output<String> clusterSubnetGroupName;

    /**
     * @return The name of a cluster subnet group to be associated with this cluster. If this parameter is not provided the resulting cluster will be deployed outside virtual private cloud (VPC).
     * 
     */
    public Output<String> clusterSubnetGroupName() {
        return this.clusterSubnetGroupName;
    }
    /**
     * The cluster type to use. Either `single-node` or `multi-node`.
     * 
     */
    @Export(name="clusterType", refs={String.class}, tree="[0]")
    private Output<String> clusterType;

    /**
     * @return The cluster type to use. Either `single-node` or `multi-node`.
     * 
     */
    public Output<String> clusterType() {
        return this.clusterType;
    }
    /**
     * The version of the Amazon Redshift engine software that you want to deploy on the cluster.
     * The version selected runs on all the nodes in the cluster.
     * 
     */
    @Export(name="clusterVersion", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> clusterVersion;

    /**
     * @return The version of the Amazon Redshift engine software that you want to deploy on the cluster.
     * The version selected runs on all the nodes in the cluster.
     * 
     */
    public Output<Optional<String>> clusterVersion() {
        return Codegen.optional(this.clusterVersion);
    }
    /**
     * The name of the first database to be created when the cluster is created.
     * If you do not provide a name, Amazon Redshift will create a default database called `dev`.
     * 
     */
    @Export(name="databaseName", refs={String.class}, tree="[0]")
    private Output<String> databaseName;

    /**
     * @return The name of the first database to be created when the cluster is created.
     * If you do not provide a name, Amazon Redshift will create a default database called `dev`.
     * 
     */
    public Output<String> databaseName() {
        return this.databaseName;
    }
    /**
     * The Amazon Resource Name (ARN) for the IAM role that was set as default for the cluster when the cluster was created.
     * 
     */
    @Export(name="defaultIamRoleArn", refs={String.class}, tree="[0]")
    private Output<String> defaultIamRoleArn;

    /**
     * @return The Amazon Resource Name (ARN) for the IAM role that was set as default for the cluster when the cluster was created.
     * 
     */
    public Output<String> defaultIamRoleArn() {
        return this.defaultIamRoleArn;
    }
    /**
     * The DNS name of the cluster
     * 
     */
    @Export(name="dnsName", refs={String.class}, tree="[0]")
    private Output<String> dnsName;

    /**
     * @return The DNS name of the cluster
     * 
     */
    public Output<String> dnsName() {
        return this.dnsName;
    }
    /**
     * The Elastic IP (EIP) address for the cluster.
     * 
     */
    @Export(name="elasticIp", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> elasticIp;

    /**
     * @return The Elastic IP (EIP) address for the cluster.
     * 
     */
    public Output<Optional<String>> elasticIp() {
        return Codegen.optional(this.elasticIp);
    }
    /**
     * If true , the data in the cluster is encrypted at rest.
     * 
     */
    @Export(name="encrypted", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> encrypted;

    /**
     * @return If true , the data in the cluster is encrypted at rest.
     * 
     */
    public Output<Optional<Boolean>> encrypted() {
        return Codegen.optional(this.encrypted);
    }
    /**
     * The connection endpoint
     * 
     */
    @Export(name="endpoint", refs={String.class}, tree="[0]")
    private Output<String> endpoint;

    /**
     * @return The connection endpoint
     * 
     */
    public Output<String> endpoint() {
        return this.endpoint;
    }
    /**
     * If true , enhanced VPC routing is enabled.
     * 
     */
    @Export(name="enhancedVpcRouting", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> enhancedVpcRouting;

    /**
     * @return If true , enhanced VPC routing is enabled.
     * 
     */
    public Output<Boolean> enhancedVpcRouting() {
        return this.enhancedVpcRouting;
    }
    /**
     * The identifier of the final snapshot that is to be created immediately before deleting the cluster. If this parameter is provided, `skip_final_snapshot` must be false.
     * 
     */
    @Export(name="finalSnapshotIdentifier", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> finalSnapshotIdentifier;

    /**
     * @return The identifier of the final snapshot that is to be created immediately before deleting the cluster. If this parameter is provided, `skip_final_snapshot` must be false.
     * 
     */
    public Output<Optional<String>> finalSnapshotIdentifier() {
        return Codegen.optional(this.finalSnapshotIdentifier);
    }
    /**
     * A list of IAM Role ARNs to associate with the cluster. A Maximum of 10 can be associated to the cluster at any time.
     * 
     */
    @Export(name="iamRoles", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> iamRoles;

    /**
     * @return A list of IAM Role ARNs to associate with the cluster. A Maximum of 10 can be associated to the cluster at any time.
     * 
     */
    public Output<List<String>> iamRoles() {
        return this.iamRoles;
    }
    /**
     * The ARN for the KMS encryption key. When specifying `kms_key_id`, `encrypted` needs to be set to true.
     * 
     */
    @Export(name="kmsKeyId", refs={String.class}, tree="[0]")
    private Output<String> kmsKeyId;

    /**
     * @return The ARN for the KMS encryption key. When specifying `kms_key_id`, `encrypted` needs to be set to true.
     * 
     */
    public Output<String> kmsKeyId() {
        return this.kmsKeyId;
    }
    /**
     * Logging, documented below.
     * 
     * @deprecated
     * logging is deprecated. Use the aws.redshift.Logging resource instead. This argument will be removed in a future major version.
     * 
     */
    @Deprecated /* logging is deprecated. Use the aws.redshift.Logging resource instead. This argument will be removed in a future major version. */
    @Export(name="logging", refs={ClusterLogging.class}, tree="[0]")
    private Output<ClusterLogging> logging;

    /**
     * @return Logging, documented below.
     * 
     */
    public Output<ClusterLogging> logging() {
        return this.logging;
    }
    /**
     * The name of the maintenance track for the restored cluster. When you take a snapshot, the snapshot inherits the MaintenanceTrack value from the cluster. The snapshot might be on a different track than the cluster that was the source for the snapshot. For example, suppose that you take a snapshot of  a cluster that is on the current track and then change the cluster to be on the trailing track. In this case, the snapshot and the source cluster are on different tracks. Default value is `current`.
     * 
     */
    @Export(name="maintenanceTrackName", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> maintenanceTrackName;

    /**
     * @return The name of the maintenance track for the restored cluster. When you take a snapshot, the snapshot inherits the MaintenanceTrack value from the cluster. The snapshot might be on a different track than the cluster that was the source for the snapshot. For example, suppose that you take a snapshot of  a cluster that is on the current track and then change the cluster to be on the trailing track. In this case, the snapshot and the source cluster are on different tracks. Default value is `current`.
     * 
     */
    public Output<Optional<String>> maintenanceTrackName() {
        return Codegen.optional(this.maintenanceTrackName);
    }
    /**
     * Whether to use AWS SecretsManager to manage the cluster admin credentials.
     * Conflicts with `master_password` and `master_password_wo`.
     * One of `master_password` or `manage_master_password` is required unless `snapshot_identifier` is provided.
     * 
     */
    @Export(name="manageMasterPassword", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> manageMasterPassword;

    /**
     * @return Whether to use AWS SecretsManager to manage the cluster admin credentials.
     * Conflicts with `master_password` and `master_password_wo`.
     * One of `master_password` or `manage_master_password` is required unless `snapshot_identifier` is provided.
     * 
     */
    public Output<Optional<Boolean>> manageMasterPassword() {
        return Codegen.optional(this.manageMasterPassword);
    }
    /**
     * The default number of days to retain a manual snapshot. If the value is -1, the snapshot is retained indefinitely. This setting doesn&#39;t change the retention period of existing snapshots. Valid values are between `-1` and `3653`. Default value is `-1`.
     * 
     */
    @Export(name="manualSnapshotRetentionPeriod", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> manualSnapshotRetentionPeriod;

    /**
     * @return The default number of days to retain a manual snapshot. If the value is -1, the snapshot is retained indefinitely. This setting doesn&#39;t change the retention period of existing snapshots. Valid values are between `-1` and `3653`. Default value is `-1`.
     * 
     */
    public Output<Optional<Integer>> manualSnapshotRetentionPeriod() {
        return Codegen.optional(this.manualSnapshotRetentionPeriod);
    }
    /**
     * Password for the master DB user.
     * Conflicts with `manage_master_password` and `master_password_wo`.
     * One of `master_password`, `master_password_wo` or `manage_master_password` is required unless `snapshot_identifier` is provided.
     * Note that this may show up in logs, and it will be stored in the state file.
     * Password must contain at least 8 characters and contain at least one uppercase letter, one lowercase letter, and one number.
     * 
     */
    @Export(name="masterPassword", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> masterPassword;

    /**
     * @return Password for the master DB user.
     * Conflicts with `manage_master_password` and `master_password_wo`.
     * One of `master_password`, `master_password_wo` or `manage_master_password` is required unless `snapshot_identifier` is provided.
     * Note that this may show up in logs, and it will be stored in the state file.
     * Password must contain at least 8 characters and contain at least one uppercase letter, one lowercase letter, and one number.
     * 
     */
    public Output<Optional<String>> masterPassword() {
        return Codegen.optional(this.masterPassword);
    }
    /**
     * ARN of the cluster admin credentials secret
     * 
     */
    @Export(name="masterPasswordSecretArn", refs={String.class}, tree="[0]")
    private Output<String> masterPasswordSecretArn;

    /**
     * @return ARN of the cluster admin credentials secret
     * 
     */
    public Output<String> masterPasswordSecretArn() {
        return this.masterPasswordSecretArn;
    }
    /**
     * ID of the KMS key used to encrypt the cluster admin credentials secret.
     * 
     */
    @Export(name="masterPasswordSecretKmsKeyId", refs={String.class}, tree="[0]")
    private Output<String> masterPasswordSecretKmsKeyId;

    /**
     * @return ID of the KMS key used to encrypt the cluster admin credentials secret.
     * 
     */
    public Output<String> masterPasswordSecretKmsKeyId() {
        return this.masterPasswordSecretKmsKeyId;
    }
    /**
     * Username for the master DB user.
     * 
     */
    @Export(name="masterUsername", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> masterUsername;

    /**
     * @return Username for the master DB user.
     * 
     */
    public Output<Optional<String>> masterUsername() {
        return Codegen.optional(this.masterUsername);
    }
    /**
     * Specifies if the Redshift cluster is multi-AZ.
     * 
     */
    @Export(name="multiAz", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> multiAz;

    /**
     * @return Specifies if the Redshift cluster is multi-AZ.
     * 
     */
    public Output<Optional<Boolean>> multiAz() {
        return Codegen.optional(this.multiAz);
    }
    /**
     * The node type to be provisioned for the cluster.
     * 
     */
    @Export(name="nodeType", refs={String.class}, tree="[0]")
    private Output<String> nodeType;

    /**
     * @return The node type to be provisioned for the cluster.
     * 
     */
    public Output<String> nodeType() {
        return this.nodeType;
    }
    /**
     * The number of compute nodes in the cluster. This parameter is required when the ClusterType parameter is specified as multi-node. Default is 1.
     * 
     */
    @Export(name="numberOfNodes", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> numberOfNodes;

    /**
     * @return The number of compute nodes in the cluster. This parameter is required when the ClusterType parameter is specified as multi-node. Default is 1.
     * 
     */
    public Output<Optional<Integer>> numberOfNodes() {
        return Codegen.optional(this.numberOfNodes);
    }
    /**
     * The AWS customer account used to create or copy the snapshot. Required if you are restoring a snapshot you do not own, optional if you own the snapshot.
     * 
     */
    @Export(name="ownerAccount", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> ownerAccount;

    /**
     * @return The AWS customer account used to create or copy the snapshot. Required if you are restoring a snapshot you do not own, optional if you own the snapshot.
     * 
     */
    public Output<Optional<String>> ownerAccount() {
        return Codegen.optional(this.ownerAccount);
    }
    /**
     * The port number on which the cluster accepts incoming connections. Valid values are between `1115` and `65535`.
     * The cluster is accessible only via the JDBC and ODBC connection strings.
     * Part of the connection string requires the port on which the cluster will listen for incoming connections.
     * Default port is `5439`.
     * 
     */
    @Export(name="port", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> port;

    /**
     * @return The port number on which the cluster accepts incoming connections. Valid values are between `1115` and `65535`.
     * The cluster is accessible only via the JDBC and ODBC connection strings.
     * Part of the connection string requires the port on which the cluster will listen for incoming connections.
     * Default port is `5439`.
     * 
     */
    public Output<Optional<Integer>> port() {
        return Codegen.optional(this.port);
    }
    /**
     * The weekly time range (in UTC) during which automated cluster maintenance can occur.
     * Format: ddd:hh24:mi-ddd:hh24:mi
     * 
     */
    @Export(name="preferredMaintenanceWindow", refs={String.class}, tree="[0]")
    private Output<String> preferredMaintenanceWindow;

    /**
     * @return The weekly time range (in UTC) during which automated cluster maintenance can occur.
     * Format: ddd:hh24:mi-ddd:hh24:mi
     * 
     */
    public Output<String> preferredMaintenanceWindow() {
        return this.preferredMaintenanceWindow;
    }
    /**
     * If true, the cluster can be accessed from a public network. Default is `true`.
     * 
     */
    @Export(name="publiclyAccessible", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> publiclyAccessible;

    /**
     * @return If true, the cluster can be accessed from a public network. Default is `true`.
     * 
     */
    public Output<Optional<Boolean>> publiclyAccessible() {
        return Codegen.optional(this.publiclyAccessible);
    }
    /**
     * Determines whether a final snapshot of the cluster is created before Amazon Redshift deletes the cluster. If true , a final cluster snapshot is not created. If false , a final cluster snapshot is created before the cluster is deleted. Default is false.
     * 
     */
    @Export(name="skipFinalSnapshot", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> skipFinalSnapshot;

    /**
     * @return Determines whether a final snapshot of the cluster is created before Amazon Redshift deletes the cluster. If true , a final cluster snapshot is not created. If false , a final cluster snapshot is created before the cluster is deleted. Default is false.
     * 
     */
    public Output<Optional<Boolean>> skipFinalSnapshot() {
        return Codegen.optional(this.skipFinalSnapshot);
    }
    /**
     * The ARN of the snapshot from which to create the new cluster. Conflicts with `snapshot_identifier`.
     * 
     */
    @Export(name="snapshotArn", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> snapshotArn;

    /**
     * @return The ARN of the snapshot from which to create the new cluster. Conflicts with `snapshot_identifier`.
     * 
     */
    public Output<Optional<String>> snapshotArn() {
        return Codegen.optional(this.snapshotArn);
    }
    /**
     * The name of the cluster the source snapshot was created from.
     * 
     */
    @Export(name="snapshotClusterIdentifier", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> snapshotClusterIdentifier;

    /**
     * @return The name of the cluster the source snapshot was created from.
     * 
     */
    public Output<Optional<String>> snapshotClusterIdentifier() {
        return Codegen.optional(this.snapshotClusterIdentifier);
    }
    /**
     * Configuration of automatic copy of snapshots from one region to another. Documented below.
     * 
     * @deprecated
     * snapshot_copy is deprecated. Use the aws.redshift.SnapshotCopy resource instead. This argument will be removed in a future major version.
     * 
     */
    @Deprecated /* snapshot_copy is deprecated. Use the aws.redshift.SnapshotCopy resource instead. This argument will be removed in a future major version. */
    @Export(name="snapshotCopy", refs={ClusterSnapshotCopy.class}, tree="[0]")
    private Output<ClusterSnapshotCopy> snapshotCopy;

    /**
     * @return Configuration of automatic copy of snapshots from one region to another. Documented below.
     * 
     */
    public Output<ClusterSnapshotCopy> snapshotCopy() {
        return this.snapshotCopy;
    }
    /**
     * The name of the snapshot from which to create the new cluster.  Conflicts with `snapshot_arn`.
     * 
     */
    @Export(name="snapshotIdentifier", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> snapshotIdentifier;

    /**
     * @return The name of the snapshot from which to create the new cluster.  Conflicts with `snapshot_arn`.
     * 
     */
    public Output<Optional<String>> snapshotIdentifier() {
        return Codegen.optional(this.snapshotIdentifier);
    }
    /**
     * A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     * For more detailed documentation about each argument, refer to
     * the [AWS official documentation](http://docs.aws.amazon.com/cli/latest/reference/redshift/index.html#cli-aws-redshift).
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     * For more detailed documentation about each argument, refer to
     * the [AWS official documentation](http://docs.aws.amazon.com/cli/latest/reference/redshift/index.html#cli-aws-redshift).
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
     * A list of Virtual Private Cloud (VPC) security groups to be associated with the cluster.
     * 
     */
    @Export(name="vpcSecurityGroupIds", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> vpcSecurityGroupIds;

    /**
     * @return A list of Virtual Private Cloud (VPC) security groups to be associated with the cluster.
     * 
     */
    public Output<List<String>> vpcSecurityGroupIds() {
        return this.vpcSecurityGroupIds;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Cluster(java.lang.String name) {
        this(name, ClusterArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Cluster(java.lang.String name, ClusterArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Cluster(java.lang.String name, ClusterArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:redshift/cluster:Cluster", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Cluster(java.lang.String name, Output<java.lang.String> id, @Nullable ClusterState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:redshift/cluster:Cluster", name, state, makeResourceOptions(options, id), false);
    }

    private static ClusterArgs makeArgs(ClusterArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? ClusterArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .additionalSecretOutputs(List.of(
                "masterPassword"
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
    public static Cluster get(java.lang.String name, Output<java.lang.String> id, @Nullable ClusterState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Cluster(name, id, state, options);
    }
}
