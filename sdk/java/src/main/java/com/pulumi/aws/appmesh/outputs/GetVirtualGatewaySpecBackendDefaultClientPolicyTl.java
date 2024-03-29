// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.GetVirtualGatewaySpecBackendDefaultClientPolicyTlCertificate;
import com.pulumi.aws.appmesh.outputs.GetVirtualGatewaySpecBackendDefaultClientPolicyTlValidation;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetVirtualGatewaySpecBackendDefaultClientPolicyTl {
    private List<GetVirtualGatewaySpecBackendDefaultClientPolicyTlCertificate> certificates;
    private Boolean enforce;
    private List<Integer> ports;
    private List<GetVirtualGatewaySpecBackendDefaultClientPolicyTlValidation> validations;

    private GetVirtualGatewaySpecBackendDefaultClientPolicyTl() {}
    public List<GetVirtualGatewaySpecBackendDefaultClientPolicyTlCertificate> certificates() {
        return this.certificates;
    }
    public Boolean enforce() {
        return this.enforce;
    }
    public List<Integer> ports() {
        return this.ports;
    }
    public List<GetVirtualGatewaySpecBackendDefaultClientPolicyTlValidation> validations() {
        return this.validations;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetVirtualGatewaySpecBackendDefaultClientPolicyTl defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetVirtualGatewaySpecBackendDefaultClientPolicyTlCertificate> certificates;
        private Boolean enforce;
        private List<Integer> ports;
        private List<GetVirtualGatewaySpecBackendDefaultClientPolicyTlValidation> validations;
        public Builder() {}
        public Builder(GetVirtualGatewaySpecBackendDefaultClientPolicyTl defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.certificates = defaults.certificates;
    	      this.enforce = defaults.enforce;
    	      this.ports = defaults.ports;
    	      this.validations = defaults.validations;
        }

        @CustomType.Setter
        public Builder certificates(List<GetVirtualGatewaySpecBackendDefaultClientPolicyTlCertificate> certificates) {
            if (certificates == null) {
              throw new MissingRequiredPropertyException("GetVirtualGatewaySpecBackendDefaultClientPolicyTl", "certificates");
            }
            this.certificates = certificates;
            return this;
        }
        public Builder certificates(GetVirtualGatewaySpecBackendDefaultClientPolicyTlCertificate... certificates) {
            return certificates(List.of(certificates));
        }
        @CustomType.Setter
        public Builder enforce(Boolean enforce) {
            if (enforce == null) {
              throw new MissingRequiredPropertyException("GetVirtualGatewaySpecBackendDefaultClientPolicyTl", "enforce");
            }
            this.enforce = enforce;
            return this;
        }
        @CustomType.Setter
        public Builder ports(List<Integer> ports) {
            if (ports == null) {
              throw new MissingRequiredPropertyException("GetVirtualGatewaySpecBackendDefaultClientPolicyTl", "ports");
            }
            this.ports = ports;
            return this;
        }
        public Builder ports(Integer... ports) {
            return ports(List.of(ports));
        }
        @CustomType.Setter
        public Builder validations(List<GetVirtualGatewaySpecBackendDefaultClientPolicyTlValidation> validations) {
            if (validations == null) {
              throw new MissingRequiredPropertyException("GetVirtualGatewaySpecBackendDefaultClientPolicyTl", "validations");
            }
            this.validations = validations;
            return this;
        }
        public Builder validations(GetVirtualGatewaySpecBackendDefaultClientPolicyTlValidation... validations) {
            return validations(List.of(validations));
        }
        public GetVirtualGatewaySpecBackendDefaultClientPolicyTl build() {
            final var _resultValue = new GetVirtualGatewaySpecBackendDefaultClientPolicyTl();
            _resultValue.certificates = certificates;
            _resultValue.enforce = enforce;
            _resultValue.ports = ports;
            _resultValue.validations = validations;
            return _resultValue;
        }
    }
}
