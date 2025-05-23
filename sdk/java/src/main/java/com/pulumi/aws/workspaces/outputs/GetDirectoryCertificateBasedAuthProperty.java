// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.workspaces.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetDirectoryCertificateBasedAuthProperty {
    private String certificateAuthorityArn;
    private String status;

    private GetDirectoryCertificateBasedAuthProperty() {}
    public String certificateAuthorityArn() {
        return this.certificateAuthorityArn;
    }
    public String status() {
        return this.status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetDirectoryCertificateBasedAuthProperty defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String certificateAuthorityArn;
        private String status;
        public Builder() {}
        public Builder(GetDirectoryCertificateBasedAuthProperty defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.certificateAuthorityArn = defaults.certificateAuthorityArn;
    	      this.status = defaults.status;
        }

        @CustomType.Setter
        public Builder certificateAuthorityArn(String certificateAuthorityArn) {
            if (certificateAuthorityArn == null) {
              throw new MissingRequiredPropertyException("GetDirectoryCertificateBasedAuthProperty", "certificateAuthorityArn");
            }
            this.certificateAuthorityArn = certificateAuthorityArn;
            return this;
        }
        @CustomType.Setter
        public Builder status(String status) {
            if (status == null) {
              throw new MissingRequiredPropertyException("GetDirectoryCertificateBasedAuthProperty", "status");
            }
            this.status = status;
            return this;
        }
        public GetDirectoryCertificateBasedAuthProperty build() {
            final var _resultValue = new GetDirectoryCertificateBasedAuthProperty();
            _resultValue.certificateAuthorityArn = certificateAuthorityArn;
            _resultValue.status = status;
            return _resultValue;
        }
    }
}
