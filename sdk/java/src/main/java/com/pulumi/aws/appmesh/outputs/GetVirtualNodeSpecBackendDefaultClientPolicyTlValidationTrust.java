// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustAcm;
import com.pulumi.aws.appmesh.outputs.GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustFile;
import com.pulumi.aws.appmesh.outputs.GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustSd;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrust {
    private List<GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustAcm> acms;
    private List<GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustFile> files;
    private List<GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustSd> sds;

    private GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrust() {}
    public List<GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustAcm> acms() {
        return this.acms;
    }
    public List<GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustFile> files() {
        return this.files;
    }
    public List<GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustSd> sds() {
        return this.sds;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrust defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustAcm> acms;
        private List<GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustFile> files;
        private List<GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustSd> sds;
        public Builder() {}
        public Builder(GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrust defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.acms = defaults.acms;
    	      this.files = defaults.files;
    	      this.sds = defaults.sds;
        }

        @CustomType.Setter
        public Builder acms(List<GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustAcm> acms) {
            if (acms == null) {
              throw new MissingRequiredPropertyException("GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrust", "acms");
            }
            this.acms = acms;
            return this;
        }
        public Builder acms(GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustAcm... acms) {
            return acms(List.of(acms));
        }
        @CustomType.Setter
        public Builder files(List<GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustFile> files) {
            if (files == null) {
              throw new MissingRequiredPropertyException("GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrust", "files");
            }
            this.files = files;
            return this;
        }
        public Builder files(GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustFile... files) {
            return files(List.of(files));
        }
        @CustomType.Setter
        public Builder sds(List<GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustSd> sds) {
            if (sds == null) {
              throw new MissingRequiredPropertyException("GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrust", "sds");
            }
            this.sds = sds;
            return this;
        }
        public Builder sds(GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustSd... sds) {
            return sds(List.of(sds));
        }
        public GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrust build() {
            final var _resultValue = new GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrust();
            _resultValue.acms = acms;
            _resultValue.files = files;
            _resultValue.sds = sds;
            return _resultValue;
        }
    }
}
