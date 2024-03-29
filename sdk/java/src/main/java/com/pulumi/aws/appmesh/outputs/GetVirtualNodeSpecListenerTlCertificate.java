// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.GetVirtualNodeSpecListenerTlCertificateAcm;
import com.pulumi.aws.appmesh.outputs.GetVirtualNodeSpecListenerTlCertificateFile;
import com.pulumi.aws.appmesh.outputs.GetVirtualNodeSpecListenerTlCertificateSd;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetVirtualNodeSpecListenerTlCertificate {
    private List<GetVirtualNodeSpecListenerTlCertificateAcm> acms;
    private List<GetVirtualNodeSpecListenerTlCertificateFile> files;
    private List<GetVirtualNodeSpecListenerTlCertificateSd> sds;

    private GetVirtualNodeSpecListenerTlCertificate() {}
    public List<GetVirtualNodeSpecListenerTlCertificateAcm> acms() {
        return this.acms;
    }
    public List<GetVirtualNodeSpecListenerTlCertificateFile> files() {
        return this.files;
    }
    public List<GetVirtualNodeSpecListenerTlCertificateSd> sds() {
        return this.sds;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetVirtualNodeSpecListenerTlCertificate defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetVirtualNodeSpecListenerTlCertificateAcm> acms;
        private List<GetVirtualNodeSpecListenerTlCertificateFile> files;
        private List<GetVirtualNodeSpecListenerTlCertificateSd> sds;
        public Builder() {}
        public Builder(GetVirtualNodeSpecListenerTlCertificate defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.acms = defaults.acms;
    	      this.files = defaults.files;
    	      this.sds = defaults.sds;
        }

        @CustomType.Setter
        public Builder acms(List<GetVirtualNodeSpecListenerTlCertificateAcm> acms) {
            if (acms == null) {
              throw new MissingRequiredPropertyException("GetVirtualNodeSpecListenerTlCertificate", "acms");
            }
            this.acms = acms;
            return this;
        }
        public Builder acms(GetVirtualNodeSpecListenerTlCertificateAcm... acms) {
            return acms(List.of(acms));
        }
        @CustomType.Setter
        public Builder files(List<GetVirtualNodeSpecListenerTlCertificateFile> files) {
            if (files == null) {
              throw new MissingRequiredPropertyException("GetVirtualNodeSpecListenerTlCertificate", "files");
            }
            this.files = files;
            return this;
        }
        public Builder files(GetVirtualNodeSpecListenerTlCertificateFile... files) {
            return files(List.of(files));
        }
        @CustomType.Setter
        public Builder sds(List<GetVirtualNodeSpecListenerTlCertificateSd> sds) {
            if (sds == null) {
              throw new MissingRequiredPropertyException("GetVirtualNodeSpecListenerTlCertificate", "sds");
            }
            this.sds = sds;
            return this;
        }
        public Builder sds(GetVirtualNodeSpecListenerTlCertificateSd... sds) {
            return sds(List.of(sds));
        }
        public GetVirtualNodeSpecListenerTlCertificate build() {
            final var _resultValue = new GetVirtualNodeSpecListenerTlCertificate();
            _resultValue.acms = acms;
            _resultValue.files = files;
            _resultValue.sds = sds;
            return _resultValue;
        }
    }
}
