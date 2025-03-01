// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.apigateway.outputs;

import com.pulumi.aws.apigateway.outputs.GetDomainNameEndpointConfiguration;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetDomainNameResult {
    /**
     * @return ARN of the found custom domain name.
     * 
     */
    private String arn;
    /**
     * @return ARN for an AWS-managed certificate that is used by edge-optimized endpoint for this domain name.
     * 
     */
    private String certificateArn;
    /**
     * @return Name of the certificate that is used by edge-optimized endpoint for this domain name.
     * 
     */
    private String certificateName;
    /**
     * @return Upload date associated with the domain certificate.
     * 
     */
    private String certificateUploadDate;
    /**
     * @return Hostname created by Cloudfront to represent the distribution that implements this domain name mapping.
     * 
     */
    private String cloudfrontDomainName;
    /**
     * @return For convenience, the hosted zone ID (`Z2FDTNDATAQYW2`) that can be used to create a Route53 alias record for the distribution.
     * 
     */
    private String cloudfrontZoneId;
    private String domainName;
    private String domainNameId;
    /**
     * @return List of objects with the endpoint configuration of this domain name.
     * 
     */
    private List<GetDomainNameEndpointConfiguration> endpointConfigurations;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return A stringified JSON policy document that applies to the execute-api service for this DomainName regardless of the caller and Method configuration. Supported only for private custom domain names.
     * 
     */
    private String policy;
    /**
     * @return ARN for an AWS-managed certificate that is used for validating the regional domain name.
     * 
     */
    private String regionalCertificateArn;
    /**
     * @return User-friendly name of the certificate that is used by regional endpoint for this domain name.
     * 
     */
    private String regionalCertificateName;
    /**
     * @return Hostname for the custom domain&#39;s regional endpoint.
     * 
     */
    private String regionalDomainName;
    /**
     * @return Hosted zone ID that can be used to create a Route53 alias record for the regional endpoint.
     * 
     */
    private String regionalZoneId;
    /**
     * @return Security policy for the domain name.
     * 
     */
    private String securityPolicy;
    /**
     * @return Key-value map of tags for the resource.
     * 
     */
    private Map<String,String> tags;

    private GetDomainNameResult() {}
    /**
     * @return ARN of the found custom domain name.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return ARN for an AWS-managed certificate that is used by edge-optimized endpoint for this domain name.
     * 
     */
    public String certificateArn() {
        return this.certificateArn;
    }
    /**
     * @return Name of the certificate that is used by edge-optimized endpoint for this domain name.
     * 
     */
    public String certificateName() {
        return this.certificateName;
    }
    /**
     * @return Upload date associated with the domain certificate.
     * 
     */
    public String certificateUploadDate() {
        return this.certificateUploadDate;
    }
    /**
     * @return Hostname created by Cloudfront to represent the distribution that implements this domain name mapping.
     * 
     */
    public String cloudfrontDomainName() {
        return this.cloudfrontDomainName;
    }
    /**
     * @return For convenience, the hosted zone ID (`Z2FDTNDATAQYW2`) that can be used to create a Route53 alias record for the distribution.
     * 
     */
    public String cloudfrontZoneId() {
        return this.cloudfrontZoneId;
    }
    public String domainName() {
        return this.domainName;
    }
    public String domainNameId() {
        return this.domainNameId;
    }
    /**
     * @return List of objects with the endpoint configuration of this domain name.
     * 
     */
    public List<GetDomainNameEndpointConfiguration> endpointConfigurations() {
        return this.endpointConfigurations;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return A stringified JSON policy document that applies to the execute-api service for this DomainName regardless of the caller and Method configuration. Supported only for private custom domain names.
     * 
     */
    public String policy() {
        return this.policy;
    }
    /**
     * @return ARN for an AWS-managed certificate that is used for validating the regional domain name.
     * 
     */
    public String regionalCertificateArn() {
        return this.regionalCertificateArn;
    }
    /**
     * @return User-friendly name of the certificate that is used by regional endpoint for this domain name.
     * 
     */
    public String regionalCertificateName() {
        return this.regionalCertificateName;
    }
    /**
     * @return Hostname for the custom domain&#39;s regional endpoint.
     * 
     */
    public String regionalDomainName() {
        return this.regionalDomainName;
    }
    /**
     * @return Hosted zone ID that can be used to create a Route53 alias record for the regional endpoint.
     * 
     */
    public String regionalZoneId() {
        return this.regionalZoneId;
    }
    /**
     * @return Security policy for the domain name.
     * 
     */
    public String securityPolicy() {
        return this.securityPolicy;
    }
    /**
     * @return Key-value map of tags for the resource.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetDomainNameResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String certificateArn;
        private String certificateName;
        private String certificateUploadDate;
        private String cloudfrontDomainName;
        private String cloudfrontZoneId;
        private String domainName;
        private String domainNameId;
        private List<GetDomainNameEndpointConfiguration> endpointConfigurations;
        private String id;
        private String policy;
        private String regionalCertificateArn;
        private String regionalCertificateName;
        private String regionalDomainName;
        private String regionalZoneId;
        private String securityPolicy;
        private Map<String,String> tags;
        public Builder() {}
        public Builder(GetDomainNameResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.certificateArn = defaults.certificateArn;
    	      this.certificateName = defaults.certificateName;
    	      this.certificateUploadDate = defaults.certificateUploadDate;
    	      this.cloudfrontDomainName = defaults.cloudfrontDomainName;
    	      this.cloudfrontZoneId = defaults.cloudfrontZoneId;
    	      this.domainName = defaults.domainName;
    	      this.domainNameId = defaults.domainNameId;
    	      this.endpointConfigurations = defaults.endpointConfigurations;
    	      this.id = defaults.id;
    	      this.policy = defaults.policy;
    	      this.regionalCertificateArn = defaults.regionalCertificateArn;
    	      this.regionalCertificateName = defaults.regionalCertificateName;
    	      this.regionalDomainName = defaults.regionalDomainName;
    	      this.regionalZoneId = defaults.regionalZoneId;
    	      this.securityPolicy = defaults.securityPolicy;
    	      this.tags = defaults.tags;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder certificateArn(String certificateArn) {
            if (certificateArn == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "certificateArn");
            }
            this.certificateArn = certificateArn;
            return this;
        }
        @CustomType.Setter
        public Builder certificateName(String certificateName) {
            if (certificateName == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "certificateName");
            }
            this.certificateName = certificateName;
            return this;
        }
        @CustomType.Setter
        public Builder certificateUploadDate(String certificateUploadDate) {
            if (certificateUploadDate == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "certificateUploadDate");
            }
            this.certificateUploadDate = certificateUploadDate;
            return this;
        }
        @CustomType.Setter
        public Builder cloudfrontDomainName(String cloudfrontDomainName) {
            if (cloudfrontDomainName == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "cloudfrontDomainName");
            }
            this.cloudfrontDomainName = cloudfrontDomainName;
            return this;
        }
        @CustomType.Setter
        public Builder cloudfrontZoneId(String cloudfrontZoneId) {
            if (cloudfrontZoneId == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "cloudfrontZoneId");
            }
            this.cloudfrontZoneId = cloudfrontZoneId;
            return this;
        }
        @CustomType.Setter
        public Builder domainName(String domainName) {
            if (domainName == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "domainName");
            }
            this.domainName = domainName;
            return this;
        }
        @CustomType.Setter
        public Builder domainNameId(String domainNameId) {
            if (domainNameId == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "domainNameId");
            }
            this.domainNameId = domainNameId;
            return this;
        }
        @CustomType.Setter
        public Builder endpointConfigurations(List<GetDomainNameEndpointConfiguration> endpointConfigurations) {
            if (endpointConfigurations == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "endpointConfigurations");
            }
            this.endpointConfigurations = endpointConfigurations;
            return this;
        }
        public Builder endpointConfigurations(GetDomainNameEndpointConfiguration... endpointConfigurations) {
            return endpointConfigurations(List.of(endpointConfigurations));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder policy(String policy) {
            if (policy == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "policy");
            }
            this.policy = policy;
            return this;
        }
        @CustomType.Setter
        public Builder regionalCertificateArn(String regionalCertificateArn) {
            if (regionalCertificateArn == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "regionalCertificateArn");
            }
            this.regionalCertificateArn = regionalCertificateArn;
            return this;
        }
        @CustomType.Setter
        public Builder regionalCertificateName(String regionalCertificateName) {
            if (regionalCertificateName == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "regionalCertificateName");
            }
            this.regionalCertificateName = regionalCertificateName;
            return this;
        }
        @CustomType.Setter
        public Builder regionalDomainName(String regionalDomainName) {
            if (regionalDomainName == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "regionalDomainName");
            }
            this.regionalDomainName = regionalDomainName;
            return this;
        }
        @CustomType.Setter
        public Builder regionalZoneId(String regionalZoneId) {
            if (regionalZoneId == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "regionalZoneId");
            }
            this.regionalZoneId = regionalZoneId;
            return this;
        }
        @CustomType.Setter
        public Builder securityPolicy(String securityPolicy) {
            if (securityPolicy == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "securityPolicy");
            }
            this.securityPolicy = securityPolicy;
            return this;
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetDomainNameResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        public GetDomainNameResult build() {
            final var _resultValue = new GetDomainNameResult();
            _resultValue.arn = arn;
            _resultValue.certificateArn = certificateArn;
            _resultValue.certificateName = certificateName;
            _resultValue.certificateUploadDate = certificateUploadDate;
            _resultValue.cloudfrontDomainName = cloudfrontDomainName;
            _resultValue.cloudfrontZoneId = cloudfrontZoneId;
            _resultValue.domainName = domainName;
            _resultValue.domainNameId = domainNameId;
            _resultValue.endpointConfigurations = endpointConfigurations;
            _resultValue.id = id;
            _resultValue.policy = policy;
            _resultValue.regionalCertificateArn = regionalCertificateArn;
            _resultValue.regionalCertificateName = regionalCertificateName;
            _resultValue.regionalDomainName = regionalDomainName;
            _resultValue.regionalZoneId = regionalZoneId;
            _resultValue.securityPolicy = securityPolicy;
            _resultValue.tags = tags;
            return _resultValue;
        }
    }
}
