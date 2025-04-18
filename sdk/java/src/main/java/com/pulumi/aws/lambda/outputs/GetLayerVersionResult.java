// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lambda.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class GetLayerVersionResult {
    /**
     * @return ARN of the Lambda Layer with version.
     * 
     */
    private String arn;
    /**
     * @return Base64-encoded representation of raw SHA-256 sum of the zip file.
     * 
     */
    private String codeSha256;
    private @Nullable String compatibleArchitecture;
    /**
     * @return A list of [Architectures](https://docs.aws.amazon.com/lambda/latest/dg/API_GetLayerVersion.html#SSS-GetLayerVersion-response-CompatibleArchitectures) the specific Lambda Layer version is compatible with.
     * 
     */
    private List<String> compatibleArchitectures;
    private @Nullable String compatibleRuntime;
    /**
     * @return List of [Runtimes](https://docs.aws.amazon.com/lambda/latest/dg/API_GetLayerVersion.html#SSS-GetLayerVersion-response-CompatibleRuntimes) the specific Lambda Layer version is compatible with.
     * 
     */
    private List<String> compatibleRuntimes;
    /**
     * @return Date this resource was created.
     * 
     */
    private String createdDate;
    /**
     * @return Description of the specific Lambda Layer version.
     * 
     */
    private String description;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return ARN of the Lambda Layer without version.
     * 
     */
    private String layerArn;
    private String layerName;
    /**
     * @return License info associated with the specific Lambda Layer version.
     * 
     */
    private String licenseInfo;
    /**
     * @return ARN of a signing job.
     * 
     */
    private String signingJobArn;
    /**
     * @return The ARN for a signing profile version.
     * 
     */
    private String signingProfileVersionArn;
    /**
     * @return (**Deprecated** use `code_sha256` instead) Base64-encoded representation of raw SHA-256 sum of the zip file.
     * 
     * @deprecated
     * source_code_hash is deprecated. Use code_sha256 instead.
     * 
     */
    @Deprecated /* source_code_hash is deprecated. Use code_sha256 instead. */
    private String sourceCodeHash;
    /**
     * @return Size in bytes of the function .zip file.
     * 
     */
    private Integer sourceCodeSize;
    /**
     * @return This Lambda Layer version.
     * 
     */
    private Integer version;

    private GetLayerVersionResult() {}
    /**
     * @return ARN of the Lambda Layer with version.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return Base64-encoded representation of raw SHA-256 sum of the zip file.
     * 
     */
    public String codeSha256() {
        return this.codeSha256;
    }
    public Optional<String> compatibleArchitecture() {
        return Optional.ofNullable(this.compatibleArchitecture);
    }
    /**
     * @return A list of [Architectures](https://docs.aws.amazon.com/lambda/latest/dg/API_GetLayerVersion.html#SSS-GetLayerVersion-response-CompatibleArchitectures) the specific Lambda Layer version is compatible with.
     * 
     */
    public List<String> compatibleArchitectures() {
        return this.compatibleArchitectures;
    }
    public Optional<String> compatibleRuntime() {
        return Optional.ofNullable(this.compatibleRuntime);
    }
    /**
     * @return List of [Runtimes](https://docs.aws.amazon.com/lambda/latest/dg/API_GetLayerVersion.html#SSS-GetLayerVersion-response-CompatibleRuntimes) the specific Lambda Layer version is compatible with.
     * 
     */
    public List<String> compatibleRuntimes() {
        return this.compatibleRuntimes;
    }
    /**
     * @return Date this resource was created.
     * 
     */
    public String createdDate() {
        return this.createdDate;
    }
    /**
     * @return Description of the specific Lambda Layer version.
     * 
     */
    public String description() {
        return this.description;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return ARN of the Lambda Layer without version.
     * 
     */
    public String layerArn() {
        return this.layerArn;
    }
    public String layerName() {
        return this.layerName;
    }
    /**
     * @return License info associated with the specific Lambda Layer version.
     * 
     */
    public String licenseInfo() {
        return this.licenseInfo;
    }
    /**
     * @return ARN of a signing job.
     * 
     */
    public String signingJobArn() {
        return this.signingJobArn;
    }
    /**
     * @return The ARN for a signing profile version.
     * 
     */
    public String signingProfileVersionArn() {
        return this.signingProfileVersionArn;
    }
    /**
     * @return (**Deprecated** use `code_sha256` instead) Base64-encoded representation of raw SHA-256 sum of the zip file.
     * 
     * @deprecated
     * source_code_hash is deprecated. Use code_sha256 instead.
     * 
     */
    @Deprecated /* source_code_hash is deprecated. Use code_sha256 instead. */
    public String sourceCodeHash() {
        return this.sourceCodeHash;
    }
    /**
     * @return Size in bytes of the function .zip file.
     * 
     */
    public Integer sourceCodeSize() {
        return this.sourceCodeSize;
    }
    /**
     * @return This Lambda Layer version.
     * 
     */
    public Integer version() {
        return this.version;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetLayerVersionResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String codeSha256;
        private @Nullable String compatibleArchitecture;
        private List<String> compatibleArchitectures;
        private @Nullable String compatibleRuntime;
        private List<String> compatibleRuntimes;
        private String createdDate;
        private String description;
        private String id;
        private String layerArn;
        private String layerName;
        private String licenseInfo;
        private String signingJobArn;
        private String signingProfileVersionArn;
        private String sourceCodeHash;
        private Integer sourceCodeSize;
        private Integer version;
        public Builder() {}
        public Builder(GetLayerVersionResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.codeSha256 = defaults.codeSha256;
    	      this.compatibleArchitecture = defaults.compatibleArchitecture;
    	      this.compatibleArchitectures = defaults.compatibleArchitectures;
    	      this.compatibleRuntime = defaults.compatibleRuntime;
    	      this.compatibleRuntimes = defaults.compatibleRuntimes;
    	      this.createdDate = defaults.createdDate;
    	      this.description = defaults.description;
    	      this.id = defaults.id;
    	      this.layerArn = defaults.layerArn;
    	      this.layerName = defaults.layerName;
    	      this.licenseInfo = defaults.licenseInfo;
    	      this.signingJobArn = defaults.signingJobArn;
    	      this.signingProfileVersionArn = defaults.signingProfileVersionArn;
    	      this.sourceCodeHash = defaults.sourceCodeHash;
    	      this.sourceCodeSize = defaults.sourceCodeSize;
    	      this.version = defaults.version;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder codeSha256(String codeSha256) {
            if (codeSha256 == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "codeSha256");
            }
            this.codeSha256 = codeSha256;
            return this;
        }
        @CustomType.Setter
        public Builder compatibleArchitecture(@Nullable String compatibleArchitecture) {

            this.compatibleArchitecture = compatibleArchitecture;
            return this;
        }
        @CustomType.Setter
        public Builder compatibleArchitectures(List<String> compatibleArchitectures) {
            if (compatibleArchitectures == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "compatibleArchitectures");
            }
            this.compatibleArchitectures = compatibleArchitectures;
            return this;
        }
        public Builder compatibleArchitectures(String... compatibleArchitectures) {
            return compatibleArchitectures(List.of(compatibleArchitectures));
        }
        @CustomType.Setter
        public Builder compatibleRuntime(@Nullable String compatibleRuntime) {

            this.compatibleRuntime = compatibleRuntime;
            return this;
        }
        @CustomType.Setter
        public Builder compatibleRuntimes(List<String> compatibleRuntimes) {
            if (compatibleRuntimes == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "compatibleRuntimes");
            }
            this.compatibleRuntimes = compatibleRuntimes;
            return this;
        }
        public Builder compatibleRuntimes(String... compatibleRuntimes) {
            return compatibleRuntimes(List.of(compatibleRuntimes));
        }
        @CustomType.Setter
        public Builder createdDate(String createdDate) {
            if (createdDate == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "createdDate");
            }
            this.createdDate = createdDate;
            return this;
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder layerArn(String layerArn) {
            if (layerArn == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "layerArn");
            }
            this.layerArn = layerArn;
            return this;
        }
        @CustomType.Setter
        public Builder layerName(String layerName) {
            if (layerName == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "layerName");
            }
            this.layerName = layerName;
            return this;
        }
        @CustomType.Setter
        public Builder licenseInfo(String licenseInfo) {
            if (licenseInfo == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "licenseInfo");
            }
            this.licenseInfo = licenseInfo;
            return this;
        }
        @CustomType.Setter
        public Builder signingJobArn(String signingJobArn) {
            if (signingJobArn == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "signingJobArn");
            }
            this.signingJobArn = signingJobArn;
            return this;
        }
        @CustomType.Setter
        public Builder signingProfileVersionArn(String signingProfileVersionArn) {
            if (signingProfileVersionArn == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "signingProfileVersionArn");
            }
            this.signingProfileVersionArn = signingProfileVersionArn;
            return this;
        }
        @CustomType.Setter
        public Builder sourceCodeHash(String sourceCodeHash) {
            if (sourceCodeHash == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "sourceCodeHash");
            }
            this.sourceCodeHash = sourceCodeHash;
            return this;
        }
        @CustomType.Setter
        public Builder sourceCodeSize(Integer sourceCodeSize) {
            if (sourceCodeSize == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "sourceCodeSize");
            }
            this.sourceCodeSize = sourceCodeSize;
            return this;
        }
        @CustomType.Setter
        public Builder version(Integer version) {
            if (version == null) {
              throw new MissingRequiredPropertyException("GetLayerVersionResult", "version");
            }
            this.version = version;
            return this;
        }
        public GetLayerVersionResult build() {
            final var _resultValue = new GetLayerVersionResult();
            _resultValue.arn = arn;
            _resultValue.codeSha256 = codeSha256;
            _resultValue.compatibleArchitecture = compatibleArchitecture;
            _resultValue.compatibleArchitectures = compatibleArchitectures;
            _resultValue.compatibleRuntime = compatibleRuntime;
            _resultValue.compatibleRuntimes = compatibleRuntimes;
            _resultValue.createdDate = createdDate;
            _resultValue.description = description;
            _resultValue.id = id;
            _resultValue.layerArn = layerArn;
            _resultValue.layerName = layerName;
            _resultValue.licenseInfo = licenseInfo;
            _resultValue.signingJobArn = signingJobArn;
            _resultValue.signingProfileVersionArn = signingProfileVersionArn;
            _resultValue.sourceCodeHash = sourceCodeHash;
            _resultValue.sourceCodeSize = sourceCodeSize;
            _resultValue.version = version;
            return _resultValue;
        }
    }
}
