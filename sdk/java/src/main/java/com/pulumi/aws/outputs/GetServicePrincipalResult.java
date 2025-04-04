// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetServicePrincipalResult {
    /**
     * @return Identifier of the current Service Principal (compound of service, region and suffix). (e.g. `logs.us-east-1.amazonaws.com`in AWS Commercial, `logs.cn-north-1.amazonaws.com.cn` in AWS China).
     * 
     */
    private String id;
    /**
     * @return Service Principal Name (e.g., `logs.amazonaws.com` in AWS Commercial, `logs.amazonaws.com.cn` in AWS China).
     * 
     */
    private String name;
    /**
     * @return Region identifier of the generated SPN (e.g., `us-east-1` in AWS Commercial, `cn-north-1` in AWS China).
     * 
     */
    private String region;
    private String serviceName;
    /**
     * @return Suffix of the SPN (e.g., `amazonaws.com` in AWS Commercial, `amazonaws.com.cn` in AWS China).
     * 
     */
    private String suffix;

    private GetServicePrincipalResult() {}
    /**
     * @return Identifier of the current Service Principal (compound of service, region and suffix). (e.g. `logs.us-east-1.amazonaws.com`in AWS Commercial, `logs.cn-north-1.amazonaws.com.cn` in AWS China).
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return Service Principal Name (e.g., `logs.amazonaws.com` in AWS Commercial, `logs.amazonaws.com.cn` in AWS China).
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return Region identifier of the generated SPN (e.g., `us-east-1` in AWS Commercial, `cn-north-1` in AWS China).
     * 
     */
    public String region() {
        return this.region;
    }
    public String serviceName() {
        return this.serviceName;
    }
    /**
     * @return Suffix of the SPN (e.g., `amazonaws.com` in AWS Commercial, `amazonaws.com.cn` in AWS China).
     * 
     */
    public String suffix() {
        return this.suffix;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetServicePrincipalResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String id;
        private String name;
        private String region;
        private String serviceName;
        private String suffix;
        public Builder() {}
        public Builder(GetServicePrincipalResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.id = defaults.id;
    	      this.name = defaults.name;
    	      this.region = defaults.region;
    	      this.serviceName = defaults.serviceName;
    	      this.suffix = defaults.suffix;
        }

        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetServicePrincipalResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetServicePrincipalResult", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder region(String region) {
            if (region == null) {
              throw new MissingRequiredPropertyException("GetServicePrincipalResult", "region");
            }
            this.region = region;
            return this;
        }
        @CustomType.Setter
        public Builder serviceName(String serviceName) {
            if (serviceName == null) {
              throw new MissingRequiredPropertyException("GetServicePrincipalResult", "serviceName");
            }
            this.serviceName = serviceName;
            return this;
        }
        @CustomType.Setter
        public Builder suffix(String suffix) {
            if (suffix == null) {
              throw new MissingRequiredPropertyException("GetServicePrincipalResult", "suffix");
            }
            this.suffix = suffix;
            return this;
        }
        public GetServicePrincipalResult build() {
            final var _resultValue = new GetServicePrincipalResult();
            _resultValue.id = id;
            _resultValue.name = name;
            _resultValue.region = region;
            _resultValue.serviceName = serviceName;
            _resultValue.suffix = suffix;
            return _resultValue;
        }
    }
}
