// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dms.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ReplicationConfigComputeConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final ReplicationConfigComputeConfigArgs Empty = new ReplicationConfigComputeConfigArgs();

    /**
     * The Availability Zone where the DMS Serverless replication using this configuration will run. The default value is a random.
     * 
     */
    @Import(name="availabilityZone")
    private @Nullable Output<String> availabilityZone;

    /**
     * @return The Availability Zone where the DMS Serverless replication using this configuration will run. The default value is a random.
     * 
     */
    public Optional<Output<String>> availabilityZone() {
        return Optional.ofNullable(this.availabilityZone);
    }

    /**
     * A list of custom DNS name servers supported for the DMS Serverless replication to access your source or target database.
     * 
     */
    @Import(name="dnsNameServers")
    private @Nullable Output<String> dnsNameServers;

    /**
     * @return A list of custom DNS name servers supported for the DMS Serverless replication to access your source or target database.
     * 
     */
    public Optional<Output<String>> dnsNameServers() {
        return Optional.ofNullable(this.dnsNameServers);
    }

    /**
     * An Key Management Service (KMS) key Amazon Resource Name (ARN) that is used to encrypt the data during DMS Serverless replication. If you don&#39;t specify a value for the KmsKeyId parameter, DMS uses your default encryption key.
     * 
     */
    @Import(name="kmsKeyId")
    private @Nullable Output<String> kmsKeyId;

    /**
     * @return An Key Management Service (KMS) key Amazon Resource Name (ARN) that is used to encrypt the data during DMS Serverless replication. If you don&#39;t specify a value for the KmsKeyId parameter, DMS uses your default encryption key.
     * 
     */
    public Optional<Output<String>> kmsKeyId() {
        return Optional.ofNullable(this.kmsKeyId);
    }

    /**
     * Specifies the maximum value of the DMS capacity units (DCUs) for which a given DMS Serverless replication can be provisioned. A single DCU is 2GB of RAM, with 1 DCUs as the minimum value allowed. The list of valid DCU values includes 1, 2, 4, 8, 16, 32, 64, 128, 192, 256, and 384.
     * 
     */
    @Import(name="maxCapacityUnits")
    private @Nullable Output<Integer> maxCapacityUnits;

    /**
     * @return Specifies the maximum value of the DMS capacity units (DCUs) for which a given DMS Serverless replication can be provisioned. A single DCU is 2GB of RAM, with 1 DCUs as the minimum value allowed. The list of valid DCU values includes 1, 2, 4, 8, 16, 32, 64, 128, 192, 256, and 384.
     * 
     */
    public Optional<Output<Integer>> maxCapacityUnits() {
        return Optional.ofNullable(this.maxCapacityUnits);
    }

    /**
     * Specifies the minimum value of the DMS capacity units (DCUs) for which a given DMS Serverless replication can be provisioned. The list of valid DCU values includes 1, 2, 4, 8, 16, 32, 64, 128, 192, 256, and 384. If this value isn&#39;t set DMS sets the lowest allowed value, 1.
     * 
     */
    @Import(name="minCapacityUnits")
    private @Nullable Output<Integer> minCapacityUnits;

    /**
     * @return Specifies the minimum value of the DMS capacity units (DCUs) for which a given DMS Serverless replication can be provisioned. The list of valid DCU values includes 1, 2, 4, 8, 16, 32, 64, 128, 192, 256, and 384. If this value isn&#39;t set DMS sets the lowest allowed value, 1.
     * 
     */
    public Optional<Output<Integer>> minCapacityUnits() {
        return Optional.ofNullable(this.minCapacityUnits);
    }

    /**
     * Specifies if the replication instance is a multi-az deployment. You cannot set the `availability_zone` parameter if the `multi_az` parameter is set to `true`.
     * 
     */
    @Import(name="multiAz")
    private @Nullable Output<Boolean> multiAz;

    /**
     * @return Specifies if the replication instance is a multi-az deployment. You cannot set the `availability_zone` parameter if the `multi_az` parameter is set to `true`.
     * 
     */
    public Optional<Output<Boolean>> multiAz() {
        return Optional.ofNullable(this.multiAz);
    }

    /**
     * The weekly time range during which system maintenance can occur, in Universal Coordinated Time (UTC).
     * 
     * - Default: A 30-minute window selected at random from an 8-hour block of time per region, occurring on a random day of the week.
     * - Format: `ddd:hh24:mi-ddd:hh24:mi`
     * - Valid Days: `mon, tue, wed, thu, fri, sat, sun`
     * - Constraints: Minimum 30-minute window.
     * 
     */
    @Import(name="preferredMaintenanceWindow")
    private @Nullable Output<String> preferredMaintenanceWindow;

    /**
     * @return The weekly time range during which system maintenance can occur, in Universal Coordinated Time (UTC).
     * 
     * - Default: A 30-minute window selected at random from an 8-hour block of time per region, occurring on a random day of the week.
     * - Format: `ddd:hh24:mi-ddd:hh24:mi`
     * - Valid Days: `mon, tue, wed, thu, fri, sat, sun`
     * - Constraints: Minimum 30-minute window.
     * 
     */
    public Optional<Output<String>> preferredMaintenanceWindow() {
        return Optional.ofNullable(this.preferredMaintenanceWindow);
    }

    /**
     * Specifies a subnet group identifier to associate with the DMS Serverless replication.
     * 
     */
    @Import(name="replicationSubnetGroupId", required=true)
    private Output<String> replicationSubnetGroupId;

    /**
     * @return Specifies a subnet group identifier to associate with the DMS Serverless replication.
     * 
     */
    public Output<String> replicationSubnetGroupId() {
        return this.replicationSubnetGroupId;
    }

    /**
     * Specifies the virtual private cloud (VPC) security group to use with the DMS Serverless replication. The VPC security group must work with the VPC containing the replication.
     * 
     */
    @Import(name="vpcSecurityGroupIds")
    private @Nullable Output<List<String>> vpcSecurityGroupIds;

    /**
     * @return Specifies the virtual private cloud (VPC) security group to use with the DMS Serverless replication. The VPC security group must work with the VPC containing the replication.
     * 
     */
    public Optional<Output<List<String>>> vpcSecurityGroupIds() {
        return Optional.ofNullable(this.vpcSecurityGroupIds);
    }

    private ReplicationConfigComputeConfigArgs() {}

    private ReplicationConfigComputeConfigArgs(ReplicationConfigComputeConfigArgs $) {
        this.availabilityZone = $.availabilityZone;
        this.dnsNameServers = $.dnsNameServers;
        this.kmsKeyId = $.kmsKeyId;
        this.maxCapacityUnits = $.maxCapacityUnits;
        this.minCapacityUnits = $.minCapacityUnits;
        this.multiAz = $.multiAz;
        this.preferredMaintenanceWindow = $.preferredMaintenanceWindow;
        this.replicationSubnetGroupId = $.replicationSubnetGroupId;
        this.vpcSecurityGroupIds = $.vpcSecurityGroupIds;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ReplicationConfigComputeConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ReplicationConfigComputeConfigArgs $;

        public Builder() {
            $ = new ReplicationConfigComputeConfigArgs();
        }

        public Builder(ReplicationConfigComputeConfigArgs defaults) {
            $ = new ReplicationConfigComputeConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param availabilityZone The Availability Zone where the DMS Serverless replication using this configuration will run. The default value is a random.
         * 
         * @return builder
         * 
         */
        public Builder availabilityZone(@Nullable Output<String> availabilityZone) {
            $.availabilityZone = availabilityZone;
            return this;
        }

        /**
         * @param availabilityZone The Availability Zone where the DMS Serverless replication using this configuration will run. The default value is a random.
         * 
         * @return builder
         * 
         */
        public Builder availabilityZone(String availabilityZone) {
            return availabilityZone(Output.of(availabilityZone));
        }

        /**
         * @param dnsNameServers A list of custom DNS name servers supported for the DMS Serverless replication to access your source or target database.
         * 
         * @return builder
         * 
         */
        public Builder dnsNameServers(@Nullable Output<String> dnsNameServers) {
            $.dnsNameServers = dnsNameServers;
            return this;
        }

        /**
         * @param dnsNameServers A list of custom DNS name servers supported for the DMS Serverless replication to access your source or target database.
         * 
         * @return builder
         * 
         */
        public Builder dnsNameServers(String dnsNameServers) {
            return dnsNameServers(Output.of(dnsNameServers));
        }

        /**
         * @param kmsKeyId An Key Management Service (KMS) key Amazon Resource Name (ARN) that is used to encrypt the data during DMS Serverless replication. If you don&#39;t specify a value for the KmsKeyId parameter, DMS uses your default encryption key.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(@Nullable Output<String> kmsKeyId) {
            $.kmsKeyId = kmsKeyId;
            return this;
        }

        /**
         * @param kmsKeyId An Key Management Service (KMS) key Amazon Resource Name (ARN) that is used to encrypt the data during DMS Serverless replication. If you don&#39;t specify a value for the KmsKeyId parameter, DMS uses your default encryption key.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(String kmsKeyId) {
            return kmsKeyId(Output.of(kmsKeyId));
        }

        /**
         * @param maxCapacityUnits Specifies the maximum value of the DMS capacity units (DCUs) for which a given DMS Serverless replication can be provisioned. A single DCU is 2GB of RAM, with 1 DCUs as the minimum value allowed. The list of valid DCU values includes 1, 2, 4, 8, 16, 32, 64, 128, 192, 256, and 384.
         * 
         * @return builder
         * 
         */
        public Builder maxCapacityUnits(@Nullable Output<Integer> maxCapacityUnits) {
            $.maxCapacityUnits = maxCapacityUnits;
            return this;
        }

        /**
         * @param maxCapacityUnits Specifies the maximum value of the DMS capacity units (DCUs) for which a given DMS Serverless replication can be provisioned. A single DCU is 2GB of RAM, with 1 DCUs as the minimum value allowed. The list of valid DCU values includes 1, 2, 4, 8, 16, 32, 64, 128, 192, 256, and 384.
         * 
         * @return builder
         * 
         */
        public Builder maxCapacityUnits(Integer maxCapacityUnits) {
            return maxCapacityUnits(Output.of(maxCapacityUnits));
        }

        /**
         * @param minCapacityUnits Specifies the minimum value of the DMS capacity units (DCUs) for which a given DMS Serverless replication can be provisioned. The list of valid DCU values includes 1, 2, 4, 8, 16, 32, 64, 128, 192, 256, and 384. If this value isn&#39;t set DMS sets the lowest allowed value, 1.
         * 
         * @return builder
         * 
         */
        public Builder minCapacityUnits(@Nullable Output<Integer> minCapacityUnits) {
            $.minCapacityUnits = minCapacityUnits;
            return this;
        }

        /**
         * @param minCapacityUnits Specifies the minimum value of the DMS capacity units (DCUs) for which a given DMS Serverless replication can be provisioned. The list of valid DCU values includes 1, 2, 4, 8, 16, 32, 64, 128, 192, 256, and 384. If this value isn&#39;t set DMS sets the lowest allowed value, 1.
         * 
         * @return builder
         * 
         */
        public Builder minCapacityUnits(Integer minCapacityUnits) {
            return minCapacityUnits(Output.of(minCapacityUnits));
        }

        /**
         * @param multiAz Specifies if the replication instance is a multi-az deployment. You cannot set the `availability_zone` parameter if the `multi_az` parameter is set to `true`.
         * 
         * @return builder
         * 
         */
        public Builder multiAz(@Nullable Output<Boolean> multiAz) {
            $.multiAz = multiAz;
            return this;
        }

        /**
         * @param multiAz Specifies if the replication instance is a multi-az deployment. You cannot set the `availability_zone` parameter if the `multi_az` parameter is set to `true`.
         * 
         * @return builder
         * 
         */
        public Builder multiAz(Boolean multiAz) {
            return multiAz(Output.of(multiAz));
        }

        /**
         * @param preferredMaintenanceWindow The weekly time range during which system maintenance can occur, in Universal Coordinated Time (UTC).
         * 
         * - Default: A 30-minute window selected at random from an 8-hour block of time per region, occurring on a random day of the week.
         * - Format: `ddd:hh24:mi-ddd:hh24:mi`
         * - Valid Days: `mon, tue, wed, thu, fri, sat, sun`
         * - Constraints: Minimum 30-minute window.
         * 
         * @return builder
         * 
         */
        public Builder preferredMaintenanceWindow(@Nullable Output<String> preferredMaintenanceWindow) {
            $.preferredMaintenanceWindow = preferredMaintenanceWindow;
            return this;
        }

        /**
         * @param preferredMaintenanceWindow The weekly time range during which system maintenance can occur, in Universal Coordinated Time (UTC).
         * 
         * - Default: A 30-minute window selected at random from an 8-hour block of time per region, occurring on a random day of the week.
         * - Format: `ddd:hh24:mi-ddd:hh24:mi`
         * - Valid Days: `mon, tue, wed, thu, fri, sat, sun`
         * - Constraints: Minimum 30-minute window.
         * 
         * @return builder
         * 
         */
        public Builder preferredMaintenanceWindow(String preferredMaintenanceWindow) {
            return preferredMaintenanceWindow(Output.of(preferredMaintenanceWindow));
        }

        /**
         * @param replicationSubnetGroupId Specifies a subnet group identifier to associate with the DMS Serverless replication.
         * 
         * @return builder
         * 
         */
        public Builder replicationSubnetGroupId(Output<String> replicationSubnetGroupId) {
            $.replicationSubnetGroupId = replicationSubnetGroupId;
            return this;
        }

        /**
         * @param replicationSubnetGroupId Specifies a subnet group identifier to associate with the DMS Serverless replication.
         * 
         * @return builder
         * 
         */
        public Builder replicationSubnetGroupId(String replicationSubnetGroupId) {
            return replicationSubnetGroupId(Output.of(replicationSubnetGroupId));
        }

        /**
         * @param vpcSecurityGroupIds Specifies the virtual private cloud (VPC) security group to use with the DMS Serverless replication. The VPC security group must work with the VPC containing the replication.
         * 
         * @return builder
         * 
         */
        public Builder vpcSecurityGroupIds(@Nullable Output<List<String>> vpcSecurityGroupIds) {
            $.vpcSecurityGroupIds = vpcSecurityGroupIds;
            return this;
        }

        /**
         * @param vpcSecurityGroupIds Specifies the virtual private cloud (VPC) security group to use with the DMS Serverless replication. The VPC security group must work with the VPC containing the replication.
         * 
         * @return builder
         * 
         */
        public Builder vpcSecurityGroupIds(List<String> vpcSecurityGroupIds) {
            return vpcSecurityGroupIds(Output.of(vpcSecurityGroupIds));
        }

        /**
         * @param vpcSecurityGroupIds Specifies the virtual private cloud (VPC) security group to use with the DMS Serverless replication. The VPC security group must work with the VPC containing the replication.
         * 
         * @return builder
         * 
         */
        public Builder vpcSecurityGroupIds(String... vpcSecurityGroupIds) {
            return vpcSecurityGroupIds(List.of(vpcSecurityGroupIds));
        }

        public ReplicationConfigComputeConfigArgs build() {
            if ($.replicationSubnetGroupId == null) {
                throw new MissingRequiredPropertyException("ReplicationConfigComputeConfigArgs", "replicationSubnetGroupId");
            }
            return $;
        }
    }

}
