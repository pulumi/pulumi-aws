// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.msk.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetBootstrapBrokersResult {
    /**
     * @return Comma separated list of one or more hostname:port pairs of kafka brokers suitable to bootstrap connectivity to the kafka cluster.
     * 
     */
    private String bootstrapBrokers;
    /**
     * @return One or more DNS names (or IP addresses) and SASL IAM port pairs.
     * 
     */
    private String bootstrapBrokersPublicSaslIam;
    /**
     * @return One or more DNS names (or IP addresses) and SASL SCRAM port pairs.
     * 
     */
    private String bootstrapBrokersPublicSaslScram;
    /**
     * @return One or more DNS names (or IP addresses) and TLS port pairs.
     * 
     */
    private String bootstrapBrokersPublicTls;
    /**
     * @return One or more DNS names (or IP addresses) and SASL IAM port pairs.
     * 
     */
    private String bootstrapBrokersSaslIam;
    /**
     * @return One or more DNS names (or IP addresses) and SASL SCRAM port pairs.
     * 
     */
    private String bootstrapBrokersSaslScram;
    /**
     * @return One or more DNS names (or IP addresses) and TLS port pairs.
     * 
     */
    private String bootstrapBrokersTls;
    /**
     * @return A string containing one or more DNS names (or IP addresses) and SASL IAM port pairs for VPC connectivity.
     * 
     */
    private String bootstrapBrokersVpcConnectivitySaslIam;
    /**
     * @return A string containing one or more DNS names (or IP addresses) and SASL SCRAM port pairs for VPC connectivity.
     * 
     */
    private String bootstrapBrokersVpcConnectivitySaslScram;
    /**
     * @return A string containing one or more DNS names (or IP addresses) and TLS port pairs for VPC connectivity.
     * 
     */
    private String bootstrapBrokersVpcConnectivityTls;
    private String clusterArn;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;

    private GetBootstrapBrokersResult() {}
    /**
     * @return Comma separated list of one or more hostname:port pairs of kafka brokers suitable to bootstrap connectivity to the kafka cluster.
     * 
     */
    public String bootstrapBrokers() {
        return this.bootstrapBrokers;
    }
    /**
     * @return One or more DNS names (or IP addresses) and SASL IAM port pairs.
     * 
     */
    public String bootstrapBrokersPublicSaslIam() {
        return this.bootstrapBrokersPublicSaslIam;
    }
    /**
     * @return One or more DNS names (or IP addresses) and SASL SCRAM port pairs.
     * 
     */
    public String bootstrapBrokersPublicSaslScram() {
        return this.bootstrapBrokersPublicSaslScram;
    }
    /**
     * @return One or more DNS names (or IP addresses) and TLS port pairs.
     * 
     */
    public String bootstrapBrokersPublicTls() {
        return this.bootstrapBrokersPublicTls;
    }
    /**
     * @return One or more DNS names (or IP addresses) and SASL IAM port pairs.
     * 
     */
    public String bootstrapBrokersSaslIam() {
        return this.bootstrapBrokersSaslIam;
    }
    /**
     * @return One or more DNS names (or IP addresses) and SASL SCRAM port pairs.
     * 
     */
    public String bootstrapBrokersSaslScram() {
        return this.bootstrapBrokersSaslScram;
    }
    /**
     * @return One or more DNS names (or IP addresses) and TLS port pairs.
     * 
     */
    public String bootstrapBrokersTls() {
        return this.bootstrapBrokersTls;
    }
    /**
     * @return A string containing one or more DNS names (or IP addresses) and SASL IAM port pairs for VPC connectivity.
     * 
     */
    public String bootstrapBrokersVpcConnectivitySaslIam() {
        return this.bootstrapBrokersVpcConnectivitySaslIam;
    }
    /**
     * @return A string containing one or more DNS names (or IP addresses) and SASL SCRAM port pairs for VPC connectivity.
     * 
     */
    public String bootstrapBrokersVpcConnectivitySaslScram() {
        return this.bootstrapBrokersVpcConnectivitySaslScram;
    }
    /**
     * @return A string containing one or more DNS names (or IP addresses) and TLS port pairs for VPC connectivity.
     * 
     */
    public String bootstrapBrokersVpcConnectivityTls() {
        return this.bootstrapBrokersVpcConnectivityTls;
    }
    public String clusterArn() {
        return this.clusterArn;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetBootstrapBrokersResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String bootstrapBrokers;
        private String bootstrapBrokersPublicSaslIam;
        private String bootstrapBrokersPublicSaslScram;
        private String bootstrapBrokersPublicTls;
        private String bootstrapBrokersSaslIam;
        private String bootstrapBrokersSaslScram;
        private String bootstrapBrokersTls;
        private String bootstrapBrokersVpcConnectivitySaslIam;
        private String bootstrapBrokersVpcConnectivitySaslScram;
        private String bootstrapBrokersVpcConnectivityTls;
        private String clusterArn;
        private String id;
        public Builder() {}
        public Builder(GetBootstrapBrokersResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.bootstrapBrokers = defaults.bootstrapBrokers;
    	      this.bootstrapBrokersPublicSaslIam = defaults.bootstrapBrokersPublicSaslIam;
    	      this.bootstrapBrokersPublicSaslScram = defaults.bootstrapBrokersPublicSaslScram;
    	      this.bootstrapBrokersPublicTls = defaults.bootstrapBrokersPublicTls;
    	      this.bootstrapBrokersSaslIam = defaults.bootstrapBrokersSaslIam;
    	      this.bootstrapBrokersSaslScram = defaults.bootstrapBrokersSaslScram;
    	      this.bootstrapBrokersTls = defaults.bootstrapBrokersTls;
    	      this.bootstrapBrokersVpcConnectivitySaslIam = defaults.bootstrapBrokersVpcConnectivitySaslIam;
    	      this.bootstrapBrokersVpcConnectivitySaslScram = defaults.bootstrapBrokersVpcConnectivitySaslScram;
    	      this.bootstrapBrokersVpcConnectivityTls = defaults.bootstrapBrokersVpcConnectivityTls;
    	      this.clusterArn = defaults.clusterArn;
    	      this.id = defaults.id;
        }

        @CustomType.Setter
        public Builder bootstrapBrokers(String bootstrapBrokers) {
            if (bootstrapBrokers == null) {
              throw new MissingRequiredPropertyException("GetBootstrapBrokersResult", "bootstrapBrokers");
            }
            this.bootstrapBrokers = bootstrapBrokers;
            return this;
        }
        @CustomType.Setter
        public Builder bootstrapBrokersPublicSaslIam(String bootstrapBrokersPublicSaslIam) {
            if (bootstrapBrokersPublicSaslIam == null) {
              throw new MissingRequiredPropertyException("GetBootstrapBrokersResult", "bootstrapBrokersPublicSaslIam");
            }
            this.bootstrapBrokersPublicSaslIam = bootstrapBrokersPublicSaslIam;
            return this;
        }
        @CustomType.Setter
        public Builder bootstrapBrokersPublicSaslScram(String bootstrapBrokersPublicSaslScram) {
            if (bootstrapBrokersPublicSaslScram == null) {
              throw new MissingRequiredPropertyException("GetBootstrapBrokersResult", "bootstrapBrokersPublicSaslScram");
            }
            this.bootstrapBrokersPublicSaslScram = bootstrapBrokersPublicSaslScram;
            return this;
        }
        @CustomType.Setter
        public Builder bootstrapBrokersPublicTls(String bootstrapBrokersPublicTls) {
            if (bootstrapBrokersPublicTls == null) {
              throw new MissingRequiredPropertyException("GetBootstrapBrokersResult", "bootstrapBrokersPublicTls");
            }
            this.bootstrapBrokersPublicTls = bootstrapBrokersPublicTls;
            return this;
        }
        @CustomType.Setter
        public Builder bootstrapBrokersSaslIam(String bootstrapBrokersSaslIam) {
            if (bootstrapBrokersSaslIam == null) {
              throw new MissingRequiredPropertyException("GetBootstrapBrokersResult", "bootstrapBrokersSaslIam");
            }
            this.bootstrapBrokersSaslIam = bootstrapBrokersSaslIam;
            return this;
        }
        @CustomType.Setter
        public Builder bootstrapBrokersSaslScram(String bootstrapBrokersSaslScram) {
            if (bootstrapBrokersSaslScram == null) {
              throw new MissingRequiredPropertyException("GetBootstrapBrokersResult", "bootstrapBrokersSaslScram");
            }
            this.bootstrapBrokersSaslScram = bootstrapBrokersSaslScram;
            return this;
        }
        @CustomType.Setter
        public Builder bootstrapBrokersTls(String bootstrapBrokersTls) {
            if (bootstrapBrokersTls == null) {
              throw new MissingRequiredPropertyException("GetBootstrapBrokersResult", "bootstrapBrokersTls");
            }
            this.bootstrapBrokersTls = bootstrapBrokersTls;
            return this;
        }
        @CustomType.Setter
        public Builder bootstrapBrokersVpcConnectivitySaslIam(String bootstrapBrokersVpcConnectivitySaslIam) {
            if (bootstrapBrokersVpcConnectivitySaslIam == null) {
              throw new MissingRequiredPropertyException("GetBootstrapBrokersResult", "bootstrapBrokersVpcConnectivitySaslIam");
            }
            this.bootstrapBrokersVpcConnectivitySaslIam = bootstrapBrokersVpcConnectivitySaslIam;
            return this;
        }
        @CustomType.Setter
        public Builder bootstrapBrokersVpcConnectivitySaslScram(String bootstrapBrokersVpcConnectivitySaslScram) {
            if (bootstrapBrokersVpcConnectivitySaslScram == null) {
              throw new MissingRequiredPropertyException("GetBootstrapBrokersResult", "bootstrapBrokersVpcConnectivitySaslScram");
            }
            this.bootstrapBrokersVpcConnectivitySaslScram = bootstrapBrokersVpcConnectivitySaslScram;
            return this;
        }
        @CustomType.Setter
        public Builder bootstrapBrokersVpcConnectivityTls(String bootstrapBrokersVpcConnectivityTls) {
            if (bootstrapBrokersVpcConnectivityTls == null) {
              throw new MissingRequiredPropertyException("GetBootstrapBrokersResult", "bootstrapBrokersVpcConnectivityTls");
            }
            this.bootstrapBrokersVpcConnectivityTls = bootstrapBrokersVpcConnectivityTls;
            return this;
        }
        @CustomType.Setter
        public Builder clusterArn(String clusterArn) {
            if (clusterArn == null) {
              throw new MissingRequiredPropertyException("GetBootstrapBrokersResult", "clusterArn");
            }
            this.clusterArn = clusterArn;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetBootstrapBrokersResult", "id");
            }
            this.id = id;
            return this;
        }
        public GetBootstrapBrokersResult build() {
            final var _resultValue = new GetBootstrapBrokersResult();
            _resultValue.bootstrapBrokers = bootstrapBrokers;
            _resultValue.bootstrapBrokersPublicSaslIam = bootstrapBrokersPublicSaslIam;
            _resultValue.bootstrapBrokersPublicSaslScram = bootstrapBrokersPublicSaslScram;
            _resultValue.bootstrapBrokersPublicTls = bootstrapBrokersPublicTls;
            _resultValue.bootstrapBrokersSaslIam = bootstrapBrokersSaslIam;
            _resultValue.bootstrapBrokersSaslScram = bootstrapBrokersSaslScram;
            _resultValue.bootstrapBrokersTls = bootstrapBrokersTls;
            _resultValue.bootstrapBrokersVpcConnectivitySaslIam = bootstrapBrokersVpcConnectivitySaslIam;
            _resultValue.bootstrapBrokersVpcConnectivitySaslScram = bootstrapBrokersVpcConnectivitySaslScram;
            _resultValue.bootstrapBrokersVpcConnectivityTls = bootstrapBrokersVpcConnectivityTls;
            _resultValue.clusterArn = clusterArn;
            _resultValue.id = id;
            return _resultValue;
        }
    }
}
