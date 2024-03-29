// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlCertificateFile {
    private String certificateChain;
    private String privateKey;

    private GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlCertificateFile() {}
    public String certificateChain() {
        return this.certificateChain;
    }
    public String privateKey() {
        return this.privateKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlCertificateFile defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String certificateChain;
        private String privateKey;
        public Builder() {}
        public Builder(GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlCertificateFile defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.certificateChain = defaults.certificateChain;
    	      this.privateKey = defaults.privateKey;
        }

        @CustomType.Setter
        public Builder certificateChain(String certificateChain) {
            if (certificateChain == null) {
              throw new MissingRequiredPropertyException("GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlCertificateFile", "certificateChain");
            }
            this.certificateChain = certificateChain;
            return this;
        }
        @CustomType.Setter
        public Builder privateKey(String privateKey) {
            if (privateKey == null) {
              throw new MissingRequiredPropertyException("GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlCertificateFile", "privateKey");
            }
            this.privateKey = privateKey;
            return this;
        }
        public GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlCertificateFile build() {
            final var _resultValue = new GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlCertificateFile();
            _resultValue.certificateChain = certificateChain;
            _resultValue.privateKey = privateKey;
            return _resultValue;
        }
    }
}
