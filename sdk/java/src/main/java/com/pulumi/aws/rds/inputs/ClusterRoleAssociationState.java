// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.rds.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ClusterRoleAssociationState extends com.pulumi.resources.ResourceArgs {

    public static final ClusterRoleAssociationState Empty = new ClusterRoleAssociationState();

    /**
     * DB Cluster Identifier to associate with the IAM Role.
     * 
     */
    @Import(name="dbClusterIdentifier")
    private @Nullable Output<String> dbClusterIdentifier;

    /**
     * @return DB Cluster Identifier to associate with the IAM Role.
     * 
     */
    public Optional<Output<String>> dbClusterIdentifier() {
        return Optional.ofNullable(this.dbClusterIdentifier);
    }

    /**
     * Name of the feature for association. This can be found in the AWS documentation relevant to the integration or a full list is available in the `SupportedFeatureNames` list returned by [AWS CLI rds describe-db-engine-versions](https://docs.aws.amazon.com/cli/latest/reference/rds/describe-db-engine-versions.html).
     * 
     */
    @Import(name="featureName")
    private @Nullable Output<String> featureName;

    /**
     * @return Name of the feature for association. This can be found in the AWS documentation relevant to the integration or a full list is available in the `SupportedFeatureNames` list returned by [AWS CLI rds describe-db-engine-versions](https://docs.aws.amazon.com/cli/latest/reference/rds/describe-db-engine-versions.html).
     * 
     */
    public Optional<Output<String>> featureName() {
        return Optional.ofNullable(this.featureName);
    }

    /**
     * Amazon Resource Name (ARN) of the IAM Role to associate with the DB Cluster.
     * 
     */
    @Import(name="roleArn")
    private @Nullable Output<String> roleArn;

    /**
     * @return Amazon Resource Name (ARN) of the IAM Role to associate with the DB Cluster.
     * 
     */
    public Optional<Output<String>> roleArn() {
        return Optional.ofNullable(this.roleArn);
    }

    private ClusterRoleAssociationState() {}

    private ClusterRoleAssociationState(ClusterRoleAssociationState $) {
        this.dbClusterIdentifier = $.dbClusterIdentifier;
        this.featureName = $.featureName;
        this.roleArn = $.roleArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ClusterRoleAssociationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ClusterRoleAssociationState $;

        public Builder() {
            $ = new ClusterRoleAssociationState();
        }

        public Builder(ClusterRoleAssociationState defaults) {
            $ = new ClusterRoleAssociationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param dbClusterIdentifier DB Cluster Identifier to associate with the IAM Role.
         * 
         * @return builder
         * 
         */
        public Builder dbClusterIdentifier(@Nullable Output<String> dbClusterIdentifier) {
            $.dbClusterIdentifier = dbClusterIdentifier;
            return this;
        }

        /**
         * @param dbClusterIdentifier DB Cluster Identifier to associate with the IAM Role.
         * 
         * @return builder
         * 
         */
        public Builder dbClusterIdentifier(String dbClusterIdentifier) {
            return dbClusterIdentifier(Output.of(dbClusterIdentifier));
        }

        /**
         * @param featureName Name of the feature for association. This can be found in the AWS documentation relevant to the integration or a full list is available in the `SupportedFeatureNames` list returned by [AWS CLI rds describe-db-engine-versions](https://docs.aws.amazon.com/cli/latest/reference/rds/describe-db-engine-versions.html).
         * 
         * @return builder
         * 
         */
        public Builder featureName(@Nullable Output<String> featureName) {
            $.featureName = featureName;
            return this;
        }

        /**
         * @param featureName Name of the feature for association. This can be found in the AWS documentation relevant to the integration or a full list is available in the `SupportedFeatureNames` list returned by [AWS CLI rds describe-db-engine-versions](https://docs.aws.amazon.com/cli/latest/reference/rds/describe-db-engine-versions.html).
         * 
         * @return builder
         * 
         */
        public Builder featureName(String featureName) {
            return featureName(Output.of(featureName));
        }

        /**
         * @param roleArn Amazon Resource Name (ARN) of the IAM Role to associate with the DB Cluster.
         * 
         * @return builder
         * 
         */
        public Builder roleArn(@Nullable Output<String> roleArn) {
            $.roleArn = roleArn;
            return this;
        }

        /**
         * @param roleArn Amazon Resource Name (ARN) of the IAM Role to associate with the DB Cluster.
         * 
         * @return builder
         * 
         */
        public Builder roleArn(String roleArn) {
            return roleArn(Output.of(roleArn));
        }

        public ClusterRoleAssociationState build() {
            return $;
        }
    }

}
