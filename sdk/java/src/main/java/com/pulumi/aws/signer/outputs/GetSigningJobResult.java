// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.signer.outputs;

import com.pulumi.aws.signer.outputs.GetSigningJobRevocationRecord;
import com.pulumi.aws.signer.outputs.GetSigningJobSignedObject;
import com.pulumi.aws.signer.outputs.GetSigningJobSource;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetSigningJobResult {
    /**
     * @return Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the signing job was completed.
     * 
     */
    private String completedAt;
    /**
     * @return Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the signing job was created.
     * 
     */
    private String createdAt;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private String jobId;
    /**
     * @return IAM entity that initiated the signing job.
     * 
     */
    private String jobInvoker;
    /**
     * @return AWS account ID of the job owner.
     * 
     */
    private String jobOwner;
    /**
     * @return A human-readable name for the signing platform associated with the signing job.
     * 
     */
    private String platformDisplayName;
    /**
     * @return Platform to which your signed code image will be distributed.
     * 
     */
    private String platformId;
    /**
     * @return Name of the profile that initiated the signing operation.
     * 
     */
    private String profileName;
    /**
     * @return Version of the signing profile used to initiate the signing job.
     * 
     */
    private String profileVersion;
    /**
     * @return IAM principal that requested the signing job.
     * 
     */
    private String requestedBy;
    /**
     * @return Revocation record if the signature generated by the signing job has been revoked. Contains a timestamp and the ID of the IAM entity that revoked the signature.
     * 
     */
    private List<GetSigningJobRevocationRecord> revocationRecords;
    /**
     * @return The time when the signature of a signing job expires.
     * 
     */
    private String signatureExpiresAt;
    /**
     * @return Name of the S3 bucket where the signed code image is saved by code signing.
     * 
     */
    private List<GetSigningJobSignedObject> signedObjects;
    /**
     * @return Object that contains the name of your S3 bucket or your raw code.
     * 
     */
    private List<GetSigningJobSource> sources;
    /**
     * @return Status of the signing job.
     * 
     */
    private String status;
    /**
     * @return String value that contains the status reason.
     * 
     */
    private String statusReason;

    private GetSigningJobResult() {}
    /**
     * @return Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the signing job was completed.
     * 
     */
    public String completedAt() {
        return this.completedAt;
    }
    /**
     * @return Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the signing job was created.
     * 
     */
    public String createdAt() {
        return this.createdAt;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    public String jobId() {
        return this.jobId;
    }
    /**
     * @return IAM entity that initiated the signing job.
     * 
     */
    public String jobInvoker() {
        return this.jobInvoker;
    }
    /**
     * @return AWS account ID of the job owner.
     * 
     */
    public String jobOwner() {
        return this.jobOwner;
    }
    /**
     * @return A human-readable name for the signing platform associated with the signing job.
     * 
     */
    public String platformDisplayName() {
        return this.platformDisplayName;
    }
    /**
     * @return Platform to which your signed code image will be distributed.
     * 
     */
    public String platformId() {
        return this.platformId;
    }
    /**
     * @return Name of the profile that initiated the signing operation.
     * 
     */
    public String profileName() {
        return this.profileName;
    }
    /**
     * @return Version of the signing profile used to initiate the signing job.
     * 
     */
    public String profileVersion() {
        return this.profileVersion;
    }
    /**
     * @return IAM principal that requested the signing job.
     * 
     */
    public String requestedBy() {
        return this.requestedBy;
    }
    /**
     * @return Revocation record if the signature generated by the signing job has been revoked. Contains a timestamp and the ID of the IAM entity that revoked the signature.
     * 
     */
    public List<GetSigningJobRevocationRecord> revocationRecords() {
        return this.revocationRecords;
    }
    /**
     * @return The time when the signature of a signing job expires.
     * 
     */
    public String signatureExpiresAt() {
        return this.signatureExpiresAt;
    }
    /**
     * @return Name of the S3 bucket where the signed code image is saved by code signing.
     * 
     */
    public List<GetSigningJobSignedObject> signedObjects() {
        return this.signedObjects;
    }
    /**
     * @return Object that contains the name of your S3 bucket or your raw code.
     * 
     */
    public List<GetSigningJobSource> sources() {
        return this.sources;
    }
    /**
     * @return Status of the signing job.
     * 
     */
    public String status() {
        return this.status;
    }
    /**
     * @return String value that contains the status reason.
     * 
     */
    public String statusReason() {
        return this.statusReason;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetSigningJobResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String completedAt;
        private String createdAt;
        private String id;
        private String jobId;
        private String jobInvoker;
        private String jobOwner;
        private String platformDisplayName;
        private String platformId;
        private String profileName;
        private String profileVersion;
        private String requestedBy;
        private List<GetSigningJobRevocationRecord> revocationRecords;
        private String signatureExpiresAt;
        private List<GetSigningJobSignedObject> signedObjects;
        private List<GetSigningJobSource> sources;
        private String status;
        private String statusReason;
        public Builder() {}
        public Builder(GetSigningJobResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.completedAt = defaults.completedAt;
    	      this.createdAt = defaults.createdAt;
    	      this.id = defaults.id;
    	      this.jobId = defaults.jobId;
    	      this.jobInvoker = defaults.jobInvoker;
    	      this.jobOwner = defaults.jobOwner;
    	      this.platformDisplayName = defaults.platformDisplayName;
    	      this.platformId = defaults.platformId;
    	      this.profileName = defaults.profileName;
    	      this.profileVersion = defaults.profileVersion;
    	      this.requestedBy = defaults.requestedBy;
    	      this.revocationRecords = defaults.revocationRecords;
    	      this.signatureExpiresAt = defaults.signatureExpiresAt;
    	      this.signedObjects = defaults.signedObjects;
    	      this.sources = defaults.sources;
    	      this.status = defaults.status;
    	      this.statusReason = defaults.statusReason;
        }

        @CustomType.Setter
        public Builder completedAt(String completedAt) {
            if (completedAt == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "completedAt");
            }
            this.completedAt = completedAt;
            return this;
        }
        @CustomType.Setter
        public Builder createdAt(String createdAt) {
            if (createdAt == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "createdAt");
            }
            this.createdAt = createdAt;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder jobId(String jobId) {
            if (jobId == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "jobId");
            }
            this.jobId = jobId;
            return this;
        }
        @CustomType.Setter
        public Builder jobInvoker(String jobInvoker) {
            if (jobInvoker == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "jobInvoker");
            }
            this.jobInvoker = jobInvoker;
            return this;
        }
        @CustomType.Setter
        public Builder jobOwner(String jobOwner) {
            if (jobOwner == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "jobOwner");
            }
            this.jobOwner = jobOwner;
            return this;
        }
        @CustomType.Setter
        public Builder platformDisplayName(String platformDisplayName) {
            if (platformDisplayName == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "platformDisplayName");
            }
            this.platformDisplayName = platformDisplayName;
            return this;
        }
        @CustomType.Setter
        public Builder platformId(String platformId) {
            if (platformId == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "platformId");
            }
            this.platformId = platformId;
            return this;
        }
        @CustomType.Setter
        public Builder profileName(String profileName) {
            if (profileName == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "profileName");
            }
            this.profileName = profileName;
            return this;
        }
        @CustomType.Setter
        public Builder profileVersion(String profileVersion) {
            if (profileVersion == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "profileVersion");
            }
            this.profileVersion = profileVersion;
            return this;
        }
        @CustomType.Setter
        public Builder requestedBy(String requestedBy) {
            if (requestedBy == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "requestedBy");
            }
            this.requestedBy = requestedBy;
            return this;
        }
        @CustomType.Setter
        public Builder revocationRecords(List<GetSigningJobRevocationRecord> revocationRecords) {
            if (revocationRecords == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "revocationRecords");
            }
            this.revocationRecords = revocationRecords;
            return this;
        }
        public Builder revocationRecords(GetSigningJobRevocationRecord... revocationRecords) {
            return revocationRecords(List.of(revocationRecords));
        }
        @CustomType.Setter
        public Builder signatureExpiresAt(String signatureExpiresAt) {
            if (signatureExpiresAt == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "signatureExpiresAt");
            }
            this.signatureExpiresAt = signatureExpiresAt;
            return this;
        }
        @CustomType.Setter
        public Builder signedObjects(List<GetSigningJobSignedObject> signedObjects) {
            if (signedObjects == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "signedObjects");
            }
            this.signedObjects = signedObjects;
            return this;
        }
        public Builder signedObjects(GetSigningJobSignedObject... signedObjects) {
            return signedObjects(List.of(signedObjects));
        }
        @CustomType.Setter
        public Builder sources(List<GetSigningJobSource> sources) {
            if (sources == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "sources");
            }
            this.sources = sources;
            return this;
        }
        public Builder sources(GetSigningJobSource... sources) {
            return sources(List.of(sources));
        }
        @CustomType.Setter
        public Builder status(String status) {
            if (status == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "status");
            }
            this.status = status;
            return this;
        }
        @CustomType.Setter
        public Builder statusReason(String statusReason) {
            if (statusReason == null) {
              throw new MissingRequiredPropertyException("GetSigningJobResult", "statusReason");
            }
            this.statusReason = statusReason;
            return this;
        }
        public GetSigningJobResult build() {
            final var _resultValue = new GetSigningJobResult();
            _resultValue.completedAt = completedAt;
            _resultValue.createdAt = createdAt;
            _resultValue.id = id;
            _resultValue.jobId = jobId;
            _resultValue.jobInvoker = jobInvoker;
            _resultValue.jobOwner = jobOwner;
            _resultValue.platformDisplayName = platformDisplayName;
            _resultValue.platformId = platformId;
            _resultValue.profileName = profileName;
            _resultValue.profileVersion = profileVersion;
            _resultValue.requestedBy = requestedBy;
            _resultValue.revocationRecords = revocationRecords;
            _resultValue.signatureExpiresAt = signatureExpiresAt;
            _resultValue.signedObjects = signedObjects;
            _resultValue.sources = sources;
            _resultValue.status = status;
            _resultValue.statusReason = statusReason;
            return _resultValue;
        }
    }
}
