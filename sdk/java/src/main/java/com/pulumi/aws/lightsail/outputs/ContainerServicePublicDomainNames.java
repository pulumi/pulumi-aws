// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lightsail.outputs;

import com.pulumi.aws.lightsail.outputs.ContainerServicePublicDomainNamesCertificate;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class ContainerServicePublicDomainNames {
    /**
     * @return Set of certificate configurations for the public domain names. Each element contains the following attributes:
     * 
     */
    private List<ContainerServicePublicDomainNamesCertificate> certificates;

    private ContainerServicePublicDomainNames() {}
    /**
     * @return Set of certificate configurations for the public domain names. Each element contains the following attributes:
     * 
     */
    public List<ContainerServicePublicDomainNamesCertificate> certificates() {
        return this.certificates;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ContainerServicePublicDomainNames defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<ContainerServicePublicDomainNamesCertificate> certificates;
        public Builder() {}
        public Builder(ContainerServicePublicDomainNames defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.certificates = defaults.certificates;
        }

        @CustomType.Setter
        public Builder certificates(List<ContainerServicePublicDomainNamesCertificate> certificates) {
            if (certificates == null) {
              throw new MissingRequiredPropertyException("ContainerServicePublicDomainNames", "certificates");
            }
            this.certificates = certificates;
            return this;
        }
        public Builder certificates(ContainerServicePublicDomainNamesCertificate... certificates) {
            return certificates(List.of(certificates));
        }
        public ContainerServicePublicDomainNames build() {
            final var _resultValue = new ContainerServicePublicDomainNames();
            _resultValue.certificates = certificates;
            return _resultValue;
        }
    }
}
