// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.drs;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.drs.ReplicationConfigurationTemplateArgs;
import com.pulumi.aws.drs.inputs.ReplicationConfigurationTemplateState;
import com.pulumi.aws.drs.outputs.ReplicationConfigurationTemplatePitPolicy;
import com.pulumi.aws.drs.outputs.ReplicationConfigurationTemplateTimeouts;
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
 * Provides an Elastic Disaster Recovery replication configuration template resource. Before using DRS, your account must be [initialized](https://docs.aws.amazon.com/drs/latest/userguide/getting-started-initializing.html).
 * 
 * &gt; **NOTE:** Your configuration must use the PIT policy shown in the basic configuration due to AWS rules. The only value that you can change is the `retention_duration` of `rule_id` 3.
 * 
 * ## Example Usage
 * 
 * ### Basic configuration
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.drs.ReplicationConfigurationTemplate;
 * import com.pulumi.aws.drs.ReplicationConfigurationTemplateArgs;
 * import com.pulumi.aws.drs.inputs.ReplicationConfigurationTemplatePitPolicyArgs;
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
 *         var example = new ReplicationConfigurationTemplate("example", ReplicationConfigurationTemplateArgs.builder()
 *             .associateDefaultSecurityGroup(false)
 *             .bandwidthThrottling(12)
 *             .createPublicIp(false)
 *             .dataPlaneRouting("PRIVATE_IP")
 *             .defaultLargeStagingDiskType("GP2")
 *             .ebsEncryption("DEFAULT")
 *             .ebsEncryptionKeyArn("arn:aws:kms:us-east-1:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab")
 *             .replicationServerInstanceType("t3.small")
 *             .replicationServersSecurityGroupsIds(exampleAwsSecurityGroup.stream().map(element -> element.id()).collect(toList()))
 *             .stagingAreaSubnetId(exampleAwsSubnet.id())
 *             .useDedicatedReplicationServer(false)
 *             .pitPolicies(            
 *                 ReplicationConfigurationTemplatePitPolicyArgs.builder()
 *                     .enabled(true)
 *                     .interval(10)
 *                     .retentionDuration(60)
 *                     .units("MINUTE")
 *                     .ruleId(1)
 *                     .build(),
 *                 ReplicationConfigurationTemplatePitPolicyArgs.builder()
 *                     .enabled(true)
 *                     .interval(1)
 *                     .retentionDuration(24)
 *                     .units("HOUR")
 *                     .ruleId(2)
 *                     .build(),
 *                 ReplicationConfigurationTemplatePitPolicyArgs.builder()
 *                     .enabled(true)
 *                     .interval(1)
 *                     .retentionDuration(3)
 *                     .units("DAY")
 *                     .ruleId(3)
 *                     .build())
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
 * Using `pulumi import`, import DRS Replication Configuration Template using the `id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:drs/replicationConfigurationTemplate:ReplicationConfigurationTemplate example templateid
 * ```
 * 
 */
@ResourceType(type="aws:drs/replicationConfigurationTemplate:ReplicationConfigurationTemplate")
public class ReplicationConfigurationTemplate extends com.pulumi.resources.CustomResource {
    /**
     * Replication configuration template ARN.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return Replication configuration template ARN.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Whether to associate the default Elastic Disaster Recovery Security group with the Replication Configuration Template.
     * 
     */
    @Export(name="associateDefaultSecurityGroup", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> associateDefaultSecurityGroup;

    /**
     * @return Whether to associate the default Elastic Disaster Recovery Security group with the Replication Configuration Template.
     * 
     */
    public Output<Boolean> associateDefaultSecurityGroup() {
        return this.associateDefaultSecurityGroup;
    }
    /**
     * Whether to allow the AWS replication agent to automatically replicate newly added disks.
     * 
     */
    @Export(name="autoReplicateNewDisks", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> autoReplicateNewDisks;

    /**
     * @return Whether to allow the AWS replication agent to automatically replicate newly added disks.
     * 
     */
    public Output<Boolean> autoReplicateNewDisks() {
        return this.autoReplicateNewDisks;
    }
    /**
     * Configure bandwidth throttling for the outbound data transfer rate of the Source Server in Mbps.
     * 
     */
    @Export(name="bandwidthThrottling", refs={Integer.class}, tree="[0]")
    private Output<Integer> bandwidthThrottling;

    /**
     * @return Configure bandwidth throttling for the outbound data transfer rate of the Source Server in Mbps.
     * 
     */
    public Output<Integer> bandwidthThrottling() {
        return this.bandwidthThrottling;
    }
    /**
     * Whether to create a Public IP for the Recovery Instance by default.
     * 
     */
    @Export(name="createPublicIp", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> createPublicIp;

    /**
     * @return Whether to create a Public IP for the Recovery Instance by default.
     * 
     */
    public Output<Boolean> createPublicIp() {
        return this.createPublicIp;
    }
    /**
     * Data plane routing mechanism that will be used for replication. Valid values are `PUBLIC_IP` and `PRIVATE_IP`.
     * 
     */
    @Export(name="dataPlaneRouting", refs={String.class}, tree="[0]")
    private Output<String> dataPlaneRouting;

    /**
     * @return Data plane routing mechanism that will be used for replication. Valid values are `PUBLIC_IP` and `PRIVATE_IP`.
     * 
     */
    public Output<String> dataPlaneRouting() {
        return this.dataPlaneRouting;
    }
    /**
     * Staging Disk EBS volume type to be used during replication. Valid values are `GP2`, `GP3`, `ST1`, or `AUTO`.
     * 
     */
    @Export(name="defaultLargeStagingDiskType", refs={String.class}, tree="[0]")
    private Output<String> defaultLargeStagingDiskType;

    /**
     * @return Staging Disk EBS volume type to be used during replication. Valid values are `GP2`, `GP3`, `ST1`, or `AUTO`.
     * 
     */
    public Output<String> defaultLargeStagingDiskType() {
        return this.defaultLargeStagingDiskType;
    }
    /**
     * Type of EBS encryption to be used during replication. Valid values are `DEFAULT` and `CUSTOM`.
     * 
     */
    @Export(name="ebsEncryption", refs={String.class}, tree="[0]")
    private Output<String> ebsEncryption;

    /**
     * @return Type of EBS encryption to be used during replication. Valid values are `DEFAULT` and `CUSTOM`.
     * 
     */
    public Output<String> ebsEncryption() {
        return this.ebsEncryption;
    }
    /**
     * ARN of the EBS encryption key to be used during replication.
     * 
     */
    @Export(name="ebsEncryptionKeyArn", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> ebsEncryptionKeyArn;

    /**
     * @return ARN of the EBS encryption key to be used during replication.
     * 
     */
    public Output<Optional<String>> ebsEncryptionKeyArn() {
        return Codegen.optional(this.ebsEncryptionKeyArn);
    }
    /**
     * Configuration block for Point in time (PIT) policy to manage snapshots taken during replication. See below.
     * 
     */
    @Export(name="pitPolicies", refs={List.class,ReplicationConfigurationTemplatePitPolicy.class}, tree="[0,1]")
    private Output</* @Nullable */ List<ReplicationConfigurationTemplatePitPolicy>> pitPolicies;

    /**
     * @return Configuration block for Point in time (PIT) policy to manage snapshots taken during replication. See below.
     * 
     */
    public Output<Optional<List<ReplicationConfigurationTemplatePitPolicy>>> pitPolicies() {
        return Codegen.optional(this.pitPolicies);
    }
    /**
     * Instance type to be used for the replication server.
     * 
     */
    @Export(name="replicationServerInstanceType", refs={String.class}, tree="[0]")
    private Output<String> replicationServerInstanceType;

    /**
     * @return Instance type to be used for the replication server.
     * 
     */
    public Output<String> replicationServerInstanceType() {
        return this.replicationServerInstanceType;
    }
    /**
     * Security group IDs that will be used by the replication server.
     * 
     */
    @Export(name="replicationServersSecurityGroupsIds", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> replicationServersSecurityGroupsIds;

    /**
     * @return Security group IDs that will be used by the replication server.
     * 
     */
    public Output<List<String>> replicationServersSecurityGroupsIds() {
        return this.replicationServersSecurityGroupsIds;
    }
    /**
     * Subnet to be used by the replication staging area.
     * 
     */
    @Export(name="stagingAreaSubnetId", refs={String.class}, tree="[0]")
    private Output<String> stagingAreaSubnetId;

    /**
     * @return Subnet to be used by the replication staging area.
     * 
     */
    public Output<String> stagingAreaSubnetId() {
        return this.stagingAreaSubnetId;
    }
    /**
     * Set of tags to be associated with all resources created in the replication staging area: EC2 replication server, EBS volumes, EBS snapshots, etc.
     * 
     */
    @Export(name="stagingAreaTags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> stagingAreaTags;

    /**
     * @return Set of tags to be associated with all resources created in the replication staging area: EC2 replication server, EBS volumes, EBS snapshots, etc.
     * 
     */
    public Output<Map<String,String>> stagingAreaTags() {
        return this.stagingAreaTags;
    }
    /**
     * Set of tags to be associated with the Replication Configuration Template resource.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Set of tags to be associated with the Replication Configuration Template resource.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    /**
     * @return Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     */
    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }
    @Export(name="timeouts", refs={ReplicationConfigurationTemplateTimeouts.class}, tree="[0]")
    private Output</* @Nullable */ ReplicationConfigurationTemplateTimeouts> timeouts;

    public Output<Optional<ReplicationConfigurationTemplateTimeouts>> timeouts() {
        return Codegen.optional(this.timeouts);
    }
    /**
     * Whether to use a dedicated Replication Server in the replication staging area.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="useDedicatedReplicationServer", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> useDedicatedReplicationServer;

    /**
     * @return Whether to use a dedicated Replication Server in the replication staging area.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<Boolean> useDedicatedReplicationServer() {
        return this.useDedicatedReplicationServer;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public ReplicationConfigurationTemplate(java.lang.String name) {
        this(name, ReplicationConfigurationTemplateArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public ReplicationConfigurationTemplate(java.lang.String name, ReplicationConfigurationTemplateArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public ReplicationConfigurationTemplate(java.lang.String name, ReplicationConfigurationTemplateArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:drs/replicationConfigurationTemplate:ReplicationConfigurationTemplate", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private ReplicationConfigurationTemplate(java.lang.String name, Output<java.lang.String> id, @Nullable ReplicationConfigurationTemplateState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:drs/replicationConfigurationTemplate:ReplicationConfigurationTemplate", name, state, makeResourceOptions(options, id), false);
    }

    private static ReplicationConfigurationTemplateArgs makeArgs(ReplicationConfigurationTemplateArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? ReplicationConfigurationTemplateArgs.Empty : args;
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
    public static ReplicationConfigurationTemplate get(java.lang.String name, Output<java.lang.String> id, @Nullable ReplicationConfigurationTemplateState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new ReplicationConfigurationTemplate(name, id, state, options);
    }
}
