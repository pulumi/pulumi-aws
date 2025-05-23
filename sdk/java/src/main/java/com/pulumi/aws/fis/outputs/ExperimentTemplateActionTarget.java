// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.fis.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class ExperimentTemplateActionTarget {
    /**
     * @return Target type. Valid values are `AutoScalingGroups` (EC2 Auto Scaling groups), `Buckets` (S3 Buckets), `Cluster` (EKS Cluster), `Clusters` (ECS Clusters), `DBInstances` (RDS DB Instances), `Instances` (EC2 Instances), `ManagedResources` (EKS clusters, Application and Network Load Balancers, and EC2 Auto Scaling groups that are enabled for ARC zonal shift), `Nodegroups` (EKS Node groups), `Pods` (EKS Pods), `ReplicationGroups`(ElastiCache Redis Replication Groups), `Roles` (IAM Roles), `SpotInstances` (EC2 Spot Instances), `Subnets` (VPC Subnets), `Tables` (DynamoDB encrypted global tables), `Tasks` (ECS Tasks), `TransitGateways` (Transit gateways), `Volumes` (EBS Volumes). See the [documentation](https://docs.aws.amazon.com/fis/latest/userguide/actions.html#action-targets) for more details.
     * 
     */
    private String key;
    /**
     * @return Target name, referencing a corresponding target.
     * 
     */
    private String value;

    private ExperimentTemplateActionTarget() {}
    /**
     * @return Target type. Valid values are `AutoScalingGroups` (EC2 Auto Scaling groups), `Buckets` (S3 Buckets), `Cluster` (EKS Cluster), `Clusters` (ECS Clusters), `DBInstances` (RDS DB Instances), `Instances` (EC2 Instances), `ManagedResources` (EKS clusters, Application and Network Load Balancers, and EC2 Auto Scaling groups that are enabled for ARC zonal shift), `Nodegroups` (EKS Node groups), `Pods` (EKS Pods), `ReplicationGroups`(ElastiCache Redis Replication Groups), `Roles` (IAM Roles), `SpotInstances` (EC2 Spot Instances), `Subnets` (VPC Subnets), `Tables` (DynamoDB encrypted global tables), `Tasks` (ECS Tasks), `TransitGateways` (Transit gateways), `Volumes` (EBS Volumes). See the [documentation](https://docs.aws.amazon.com/fis/latest/userguide/actions.html#action-targets) for more details.
     * 
     */
    public String key() {
        return this.key;
    }
    /**
     * @return Target name, referencing a corresponding target.
     * 
     */
    public String value() {
        return this.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ExperimentTemplateActionTarget defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String key;
        private String value;
        public Builder() {}
        public Builder(ExperimentTemplateActionTarget defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.key = defaults.key;
    	      this.value = defaults.value;
        }

        @CustomType.Setter
        public Builder key(String key) {
            if (key == null) {
              throw new MissingRequiredPropertyException("ExperimentTemplateActionTarget", "key");
            }
            this.key = key;
            return this;
        }
        @CustomType.Setter
        public Builder value(String value) {
            if (value == null) {
              throw new MissingRequiredPropertyException("ExperimentTemplateActionTarget", "value");
            }
            this.value = value;
            return this;
        }
        public ExperimentTemplateActionTarget build() {
            final var _resultValue = new ExperimentTemplateActionTarget();
            _resultValue.key = key;
            _resultValue.value = value;
            return _resultValue;
        }
    }
}
