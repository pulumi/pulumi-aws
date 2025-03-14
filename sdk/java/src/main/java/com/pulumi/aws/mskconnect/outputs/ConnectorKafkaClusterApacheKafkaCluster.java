// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.mskconnect.outputs;

import com.pulumi.aws.mskconnect.outputs.ConnectorKafkaClusterApacheKafkaClusterVpc;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class ConnectorKafkaClusterApacheKafkaCluster {
    /**
     * @return The bootstrap servers of the cluster.
     * 
     */
    private String bootstrapServers;
    /**
     * @return Details of an Amazon VPC which has network connectivity to the Apache Kafka cluster. See `vpc` Block for details.
     * 
     */
    private ConnectorKafkaClusterApacheKafkaClusterVpc vpc;

    private ConnectorKafkaClusterApacheKafkaCluster() {}
    /**
     * @return The bootstrap servers of the cluster.
     * 
     */
    public String bootstrapServers() {
        return this.bootstrapServers;
    }
    /**
     * @return Details of an Amazon VPC which has network connectivity to the Apache Kafka cluster. See `vpc` Block for details.
     * 
     */
    public ConnectorKafkaClusterApacheKafkaClusterVpc vpc() {
        return this.vpc;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ConnectorKafkaClusterApacheKafkaCluster defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String bootstrapServers;
        private ConnectorKafkaClusterApacheKafkaClusterVpc vpc;
        public Builder() {}
        public Builder(ConnectorKafkaClusterApacheKafkaCluster defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.bootstrapServers = defaults.bootstrapServers;
    	      this.vpc = defaults.vpc;
        }

        @CustomType.Setter
        public Builder bootstrapServers(String bootstrapServers) {
            if (bootstrapServers == null) {
              throw new MissingRequiredPropertyException("ConnectorKafkaClusterApacheKafkaCluster", "bootstrapServers");
            }
            this.bootstrapServers = bootstrapServers;
            return this;
        }
        @CustomType.Setter
        public Builder vpc(ConnectorKafkaClusterApacheKafkaClusterVpc vpc) {
            if (vpc == null) {
              throw new MissingRequiredPropertyException("ConnectorKafkaClusterApacheKafkaCluster", "vpc");
            }
            this.vpc = vpc;
            return this;
        }
        public ConnectorKafkaClusterApacheKafkaCluster build() {
            final var _resultValue = new ConnectorKafkaClusterApacheKafkaCluster();
            _resultValue.bootstrapServers = bootstrapServers;
            _resultValue.vpc = vpc;
            return _resultValue;
        }
    }
}
