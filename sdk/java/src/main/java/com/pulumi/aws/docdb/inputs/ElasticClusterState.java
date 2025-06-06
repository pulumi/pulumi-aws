// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.docdb.inputs;

import com.pulumi.aws.docdb.inputs.ElasticClusterTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ElasticClusterState extends com.pulumi.resources.ResourceArgs {

    public static final ElasticClusterState Empty = new ElasticClusterState();

    /**
     * Name of the Elastic DocumentDB cluster administrator
     * 
     */
    @Import(name="adminUserName")
    private @Nullable Output<String> adminUserName;

    /**
     * @return Name of the Elastic DocumentDB cluster administrator
     * 
     */
    public Optional<Output<String>> adminUserName() {
        return Optional.ofNullable(this.adminUserName);
    }

    /**
     * Password for the Elastic DocumentDB cluster administrator. Can contain any printable ASCII characters. Must be at least 8 characters
     * 
     */
    @Import(name="adminUserPassword")
    private @Nullable Output<String> adminUserPassword;

    /**
     * @return Password for the Elastic DocumentDB cluster administrator. Can contain any printable ASCII characters. Must be at least 8 characters
     * 
     */
    public Optional<Output<String>> adminUserPassword() {
        return Optional.ofNullable(this.adminUserPassword);
    }

    /**
     * ARN of the DocumentDB Elastic Cluster
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN of the DocumentDB Elastic Cluster
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Authentication type for the Elastic DocumentDB cluster. Valid values are `PLAIN_TEXT` and `SECRET_ARN`
     * 
     */
    @Import(name="authType")
    private @Nullable Output<String> authType;

    /**
     * @return Authentication type for the Elastic DocumentDB cluster. Valid values are `PLAIN_TEXT` and `SECRET_ARN`
     * 
     */
    public Optional<Output<String>> authType() {
        return Optional.ofNullable(this.authType);
    }

    /**
     * The number of days for which automatic snapshots are retained. It should be in between 1 and 35. If not specified, the default value of 1 is set.
     * 
     */
    @Import(name="backupRetentionPeriod")
    private @Nullable Output<Integer> backupRetentionPeriod;

    /**
     * @return The number of days for which automatic snapshots are retained. It should be in between 1 and 35. If not specified, the default value of 1 is set.
     * 
     */
    public Optional<Output<Integer>> backupRetentionPeriod() {
        return Optional.ofNullable(this.backupRetentionPeriod);
    }

    /**
     * The DNS address of the DocDB instance
     * 
     */
    @Import(name="endpoint")
    private @Nullable Output<String> endpoint;

    /**
     * @return The DNS address of the DocDB instance
     * 
     */
    public Optional<Output<String>> endpoint() {
        return Optional.ofNullable(this.endpoint);
    }

    /**
     * ARN of a KMS key that is used to encrypt the Elastic DocumentDB cluster. If not specified, the default encryption key that KMS creates for your account is used.
     * 
     */
    @Import(name="kmsKeyId")
    private @Nullable Output<String> kmsKeyId;

    /**
     * @return ARN of a KMS key that is used to encrypt the Elastic DocumentDB cluster. If not specified, the default encryption key that KMS creates for your account is used.
     * 
     */
    public Optional<Output<String>> kmsKeyId() {
        return Optional.ofNullable(this.kmsKeyId);
    }

    /**
     * Name of the Elastic DocumentDB cluster
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name of the Elastic DocumentDB cluster
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * The daily time range during which automated backups are created if automated backups are enabled, as determined by the `backup_retention_period`.
     * 
     */
    @Import(name="preferredBackupWindow")
    private @Nullable Output<String> preferredBackupWindow;

    /**
     * @return The daily time range during which automated backups are created if automated backups are enabled, as determined by the `backup_retention_period`.
     * 
     */
    public Optional<Output<String>> preferredBackupWindow() {
        return Optional.ofNullable(this.preferredBackupWindow);
    }

    /**
     * Weekly time range during which system maintenance can occur in UTC. Format: `ddd:hh24:mi-ddd:hh24:mi`. If not specified, AWS will choose a random 30-minute window on a random day of the week.
     * 
     */
    @Import(name="preferredMaintenanceWindow")
    private @Nullable Output<String> preferredMaintenanceWindow;

    /**
     * @return Weekly time range during which system maintenance can occur in UTC. Format: `ddd:hh24:mi-ddd:hh24:mi`. If not specified, AWS will choose a random 30-minute window on a random day of the week.
     * 
     */
    public Optional<Output<String>> preferredMaintenanceWindow() {
        return Optional.ofNullable(this.preferredMaintenanceWindow);
    }

    /**
     * Number of vCPUs assigned to each elastic cluster shard. Maximum is 64. Allowed values are 2, 4, 8, 16, 32, 64
     * 
     */
    @Import(name="shardCapacity")
    private @Nullable Output<Integer> shardCapacity;

    /**
     * @return Number of vCPUs assigned to each elastic cluster shard. Maximum is 64. Allowed values are 2, 4, 8, 16, 32, 64
     * 
     */
    public Optional<Output<Integer>> shardCapacity() {
        return Optional.ofNullable(this.shardCapacity);
    }

    /**
     * Number of shards assigned to the elastic cluster. Maximum is 32
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="shardCount")
    private @Nullable Output<Integer> shardCount;

    /**
     * @return Number of shards assigned to the elastic cluster. Maximum is 32
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<Integer>> shardCount() {
        return Optional.ofNullable(this.shardCount);
    }

    /**
     * IDs of subnets in which the Elastic DocumentDB Cluster operates.
     * 
     */
    @Import(name="subnetIds")
    private @Nullable Output<List<String>> subnetIds;

    /**
     * @return IDs of subnets in which the Elastic DocumentDB Cluster operates.
     * 
     */
    public Optional<Output<List<String>>> subnetIds() {
        return Optional.ofNullable(this.subnetIds);
    }

    /**
     * A map of tags to assign to the collection. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the collection. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    @Import(name="timeouts")
    private @Nullable Output<ElasticClusterTimeoutsArgs> timeouts;

    public Optional<Output<ElasticClusterTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    /**
     * List of VPC security groups to associate with the Elastic DocumentDB Cluster
     * 
     * For more detailed documentation about each argument, refer to
     * the [AWS official documentation](https://docs.aws.amazon.com/cli/latest/reference/docdb-elastic/create-cluster.html).
     * 
     */
    @Import(name="vpcSecurityGroupIds")
    private @Nullable Output<List<String>> vpcSecurityGroupIds;

    /**
     * @return List of VPC security groups to associate with the Elastic DocumentDB Cluster
     * 
     * For more detailed documentation about each argument, refer to
     * the [AWS official documentation](https://docs.aws.amazon.com/cli/latest/reference/docdb-elastic/create-cluster.html).
     * 
     */
    public Optional<Output<List<String>>> vpcSecurityGroupIds() {
        return Optional.ofNullable(this.vpcSecurityGroupIds);
    }

    private ElasticClusterState() {}

    private ElasticClusterState(ElasticClusterState $) {
        this.adminUserName = $.adminUserName;
        this.adminUserPassword = $.adminUserPassword;
        this.arn = $.arn;
        this.authType = $.authType;
        this.backupRetentionPeriod = $.backupRetentionPeriod;
        this.endpoint = $.endpoint;
        this.kmsKeyId = $.kmsKeyId;
        this.name = $.name;
        this.preferredBackupWindow = $.preferredBackupWindow;
        this.preferredMaintenanceWindow = $.preferredMaintenanceWindow;
        this.shardCapacity = $.shardCapacity;
        this.shardCount = $.shardCount;
        this.subnetIds = $.subnetIds;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
        this.timeouts = $.timeouts;
        this.vpcSecurityGroupIds = $.vpcSecurityGroupIds;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ElasticClusterState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ElasticClusterState $;

        public Builder() {
            $ = new ElasticClusterState();
        }

        public Builder(ElasticClusterState defaults) {
            $ = new ElasticClusterState(Objects.requireNonNull(defaults));
        }

        /**
         * @param adminUserName Name of the Elastic DocumentDB cluster administrator
         * 
         * @return builder
         * 
         */
        public Builder adminUserName(@Nullable Output<String> adminUserName) {
            $.adminUserName = adminUserName;
            return this;
        }

        /**
         * @param adminUserName Name of the Elastic DocumentDB cluster administrator
         * 
         * @return builder
         * 
         */
        public Builder adminUserName(String adminUserName) {
            return adminUserName(Output.of(adminUserName));
        }

        /**
         * @param adminUserPassword Password for the Elastic DocumentDB cluster administrator. Can contain any printable ASCII characters. Must be at least 8 characters
         * 
         * @return builder
         * 
         */
        public Builder adminUserPassword(@Nullable Output<String> adminUserPassword) {
            $.adminUserPassword = adminUserPassword;
            return this;
        }

        /**
         * @param adminUserPassword Password for the Elastic DocumentDB cluster administrator. Can contain any printable ASCII characters. Must be at least 8 characters
         * 
         * @return builder
         * 
         */
        public Builder adminUserPassword(String adminUserPassword) {
            return adminUserPassword(Output.of(adminUserPassword));
        }

        /**
         * @param arn ARN of the DocumentDB Elastic Cluster
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN of the DocumentDB Elastic Cluster
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param authType Authentication type for the Elastic DocumentDB cluster. Valid values are `PLAIN_TEXT` and `SECRET_ARN`
         * 
         * @return builder
         * 
         */
        public Builder authType(@Nullable Output<String> authType) {
            $.authType = authType;
            return this;
        }

        /**
         * @param authType Authentication type for the Elastic DocumentDB cluster. Valid values are `PLAIN_TEXT` and `SECRET_ARN`
         * 
         * @return builder
         * 
         */
        public Builder authType(String authType) {
            return authType(Output.of(authType));
        }

        /**
         * @param backupRetentionPeriod The number of days for which automatic snapshots are retained. It should be in between 1 and 35. If not specified, the default value of 1 is set.
         * 
         * @return builder
         * 
         */
        public Builder backupRetentionPeriod(@Nullable Output<Integer> backupRetentionPeriod) {
            $.backupRetentionPeriod = backupRetentionPeriod;
            return this;
        }

        /**
         * @param backupRetentionPeriod The number of days for which automatic snapshots are retained. It should be in between 1 and 35. If not specified, the default value of 1 is set.
         * 
         * @return builder
         * 
         */
        public Builder backupRetentionPeriod(Integer backupRetentionPeriod) {
            return backupRetentionPeriod(Output.of(backupRetentionPeriod));
        }

        /**
         * @param endpoint The DNS address of the DocDB instance
         * 
         * @return builder
         * 
         */
        public Builder endpoint(@Nullable Output<String> endpoint) {
            $.endpoint = endpoint;
            return this;
        }

        /**
         * @param endpoint The DNS address of the DocDB instance
         * 
         * @return builder
         * 
         */
        public Builder endpoint(String endpoint) {
            return endpoint(Output.of(endpoint));
        }

        /**
         * @param kmsKeyId ARN of a KMS key that is used to encrypt the Elastic DocumentDB cluster. If not specified, the default encryption key that KMS creates for your account is used.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(@Nullable Output<String> kmsKeyId) {
            $.kmsKeyId = kmsKeyId;
            return this;
        }

        /**
         * @param kmsKeyId ARN of a KMS key that is used to encrypt the Elastic DocumentDB cluster. If not specified, the default encryption key that KMS creates for your account is used.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(String kmsKeyId) {
            return kmsKeyId(Output.of(kmsKeyId));
        }

        /**
         * @param name Name of the Elastic DocumentDB cluster
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the Elastic DocumentDB cluster
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param preferredBackupWindow The daily time range during which automated backups are created if automated backups are enabled, as determined by the `backup_retention_period`.
         * 
         * @return builder
         * 
         */
        public Builder preferredBackupWindow(@Nullable Output<String> preferredBackupWindow) {
            $.preferredBackupWindow = preferredBackupWindow;
            return this;
        }

        /**
         * @param preferredBackupWindow The daily time range during which automated backups are created if automated backups are enabled, as determined by the `backup_retention_period`.
         * 
         * @return builder
         * 
         */
        public Builder preferredBackupWindow(String preferredBackupWindow) {
            return preferredBackupWindow(Output.of(preferredBackupWindow));
        }

        /**
         * @param preferredMaintenanceWindow Weekly time range during which system maintenance can occur in UTC. Format: `ddd:hh24:mi-ddd:hh24:mi`. If not specified, AWS will choose a random 30-minute window on a random day of the week.
         * 
         * @return builder
         * 
         */
        public Builder preferredMaintenanceWindow(@Nullable Output<String> preferredMaintenanceWindow) {
            $.preferredMaintenanceWindow = preferredMaintenanceWindow;
            return this;
        }

        /**
         * @param preferredMaintenanceWindow Weekly time range during which system maintenance can occur in UTC. Format: `ddd:hh24:mi-ddd:hh24:mi`. If not specified, AWS will choose a random 30-minute window on a random day of the week.
         * 
         * @return builder
         * 
         */
        public Builder preferredMaintenanceWindow(String preferredMaintenanceWindow) {
            return preferredMaintenanceWindow(Output.of(preferredMaintenanceWindow));
        }

        /**
         * @param shardCapacity Number of vCPUs assigned to each elastic cluster shard. Maximum is 64. Allowed values are 2, 4, 8, 16, 32, 64
         * 
         * @return builder
         * 
         */
        public Builder shardCapacity(@Nullable Output<Integer> shardCapacity) {
            $.shardCapacity = shardCapacity;
            return this;
        }

        /**
         * @param shardCapacity Number of vCPUs assigned to each elastic cluster shard. Maximum is 64. Allowed values are 2, 4, 8, 16, 32, 64
         * 
         * @return builder
         * 
         */
        public Builder shardCapacity(Integer shardCapacity) {
            return shardCapacity(Output.of(shardCapacity));
        }

        /**
         * @param shardCount Number of shards assigned to the elastic cluster. Maximum is 32
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder shardCount(@Nullable Output<Integer> shardCount) {
            $.shardCount = shardCount;
            return this;
        }

        /**
         * @param shardCount Number of shards assigned to the elastic cluster. Maximum is 32
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder shardCount(Integer shardCount) {
            return shardCount(Output.of(shardCount));
        }

        /**
         * @param subnetIds IDs of subnets in which the Elastic DocumentDB Cluster operates.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(@Nullable Output<List<String>> subnetIds) {
            $.subnetIds = subnetIds;
            return this;
        }

        /**
         * @param subnetIds IDs of subnets in which the Elastic DocumentDB Cluster operates.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(List<String> subnetIds) {
            return subnetIds(Output.of(subnetIds));
        }

        /**
         * @param subnetIds IDs of subnets in which the Elastic DocumentDB Cluster operates.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(String... subnetIds) {
            return subnetIds(List.of(subnetIds));
        }

        /**
         * @param tags A map of tags to assign to the collection. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags A map of tags to assign to the collection. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
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

        public Builder timeouts(@Nullable Output<ElasticClusterTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(ElasticClusterTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        /**
         * @param vpcSecurityGroupIds List of VPC security groups to associate with the Elastic DocumentDB Cluster
         * 
         * For more detailed documentation about each argument, refer to
         * the [AWS official documentation](https://docs.aws.amazon.com/cli/latest/reference/docdb-elastic/create-cluster.html).
         * 
         * @return builder
         * 
         */
        public Builder vpcSecurityGroupIds(@Nullable Output<List<String>> vpcSecurityGroupIds) {
            $.vpcSecurityGroupIds = vpcSecurityGroupIds;
            return this;
        }

        /**
         * @param vpcSecurityGroupIds List of VPC security groups to associate with the Elastic DocumentDB Cluster
         * 
         * For more detailed documentation about each argument, refer to
         * the [AWS official documentation](https://docs.aws.amazon.com/cli/latest/reference/docdb-elastic/create-cluster.html).
         * 
         * @return builder
         * 
         */
        public Builder vpcSecurityGroupIds(List<String> vpcSecurityGroupIds) {
            return vpcSecurityGroupIds(Output.of(vpcSecurityGroupIds));
        }

        /**
         * @param vpcSecurityGroupIds List of VPC security groups to associate with the Elastic DocumentDB Cluster
         * 
         * For more detailed documentation about each argument, refer to
         * the [AWS official documentation](https://docs.aws.amazon.com/cli/latest/reference/docdb-elastic/create-cluster.html).
         * 
         * @return builder
         * 
         */
        public Builder vpcSecurityGroupIds(String... vpcSecurityGroupIds) {
            return vpcSecurityGroupIds(List.of(vpcSecurityGroupIds));
        }

        public ElasticClusterState build() {
            return $;
        }
    }

}
