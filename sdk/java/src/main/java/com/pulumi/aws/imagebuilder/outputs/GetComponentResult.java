// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.imagebuilder.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetComponentResult {
    private String arn;
    /**
     * @return Change description of the component.
     * 
     */
    private String changeDescription;
    /**
     * @return Data of the component.
     * 
     */
    private String data;
    /**
     * @return Date the component was created.
     * 
     */
    private String dateCreated;
    /**
     * @return Description of the component.
     * 
     */
    private String description;
    /**
     * @return Encryption status of the component.
     * 
     */
    private Boolean encrypted;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return ARN of the Key Management Service (KMS) Key used to encrypt the component.
     * 
     */
    private String kmsKeyId;
    /**
     * @return Name of the component.
     * 
     */
    private String name;
    /**
     * @return Owner of the component.
     * 
     */
    private String owner;
    /**
     * @return Platform of the component.
     * 
     */
    private String platform;
    /**
     * @return Operating Systems (OSes) supported by the component.
     * 
     */
    private List<String> supportedOsVersions;
    /**
     * @return Key-value map of resource tags for the component.
     * 
     */
    private Map<String,String> tags;
    /**
     * @return Type of the component.
     * 
     */
    private String type;
    /**
     * @return Version of the component.
     * 
     */
    private String version;

    private GetComponentResult() {}
    public String arn() {
        return this.arn;
    }
    /**
     * @return Change description of the component.
     * 
     */
    public String changeDescription() {
        return this.changeDescription;
    }
    /**
     * @return Data of the component.
     * 
     */
    public String data() {
        return this.data;
    }
    /**
     * @return Date the component was created.
     * 
     */
    public String dateCreated() {
        return this.dateCreated;
    }
    /**
     * @return Description of the component.
     * 
     */
    public String description() {
        return this.description;
    }
    /**
     * @return Encryption status of the component.
     * 
     */
    public Boolean encrypted() {
        return this.encrypted;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return ARN of the Key Management Service (KMS) Key used to encrypt the component.
     * 
     */
    public String kmsKeyId() {
        return this.kmsKeyId;
    }
    /**
     * @return Name of the component.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return Owner of the component.
     * 
     */
    public String owner() {
        return this.owner;
    }
    /**
     * @return Platform of the component.
     * 
     */
    public String platform() {
        return this.platform;
    }
    /**
     * @return Operating Systems (OSes) supported by the component.
     * 
     */
    public List<String> supportedOsVersions() {
        return this.supportedOsVersions;
    }
    /**
     * @return Key-value map of resource tags for the component.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }
    /**
     * @return Type of the component.
     * 
     */
    public String type() {
        return this.type;
    }
    /**
     * @return Version of the component.
     * 
     */
    public String version() {
        return this.version;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetComponentResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String changeDescription;
        private String data;
        private String dateCreated;
        private String description;
        private Boolean encrypted;
        private String id;
        private String kmsKeyId;
        private String name;
        private String owner;
        private String platform;
        private List<String> supportedOsVersions;
        private Map<String,String> tags;
        private String type;
        private String version;
        public Builder() {}
        public Builder(GetComponentResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.changeDescription = defaults.changeDescription;
    	      this.data = defaults.data;
    	      this.dateCreated = defaults.dateCreated;
    	      this.description = defaults.description;
    	      this.encrypted = defaults.encrypted;
    	      this.id = defaults.id;
    	      this.kmsKeyId = defaults.kmsKeyId;
    	      this.name = defaults.name;
    	      this.owner = defaults.owner;
    	      this.platform = defaults.platform;
    	      this.supportedOsVersions = defaults.supportedOsVersions;
    	      this.tags = defaults.tags;
    	      this.type = defaults.type;
    	      this.version = defaults.version;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder changeDescription(String changeDescription) {
            if (changeDescription == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "changeDescription");
            }
            this.changeDescription = changeDescription;
            return this;
        }
        @CustomType.Setter
        public Builder data(String data) {
            if (data == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "data");
            }
            this.data = data;
            return this;
        }
        @CustomType.Setter
        public Builder dateCreated(String dateCreated) {
            if (dateCreated == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "dateCreated");
            }
            this.dateCreated = dateCreated;
            return this;
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder encrypted(Boolean encrypted) {
            if (encrypted == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "encrypted");
            }
            this.encrypted = encrypted;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder kmsKeyId(String kmsKeyId) {
            if (kmsKeyId == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "kmsKeyId");
            }
            this.kmsKeyId = kmsKeyId;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder owner(String owner) {
            if (owner == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "owner");
            }
            this.owner = owner;
            return this;
        }
        @CustomType.Setter
        public Builder platform(String platform) {
            if (platform == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "platform");
            }
            this.platform = platform;
            return this;
        }
        @CustomType.Setter
        public Builder supportedOsVersions(List<String> supportedOsVersions) {
            if (supportedOsVersions == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "supportedOsVersions");
            }
            this.supportedOsVersions = supportedOsVersions;
            return this;
        }
        public Builder supportedOsVersions(String... supportedOsVersions) {
            return supportedOsVersions(List.of(supportedOsVersions));
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "type");
            }
            this.type = type;
            return this;
        }
        @CustomType.Setter
        public Builder version(String version) {
            if (version == null) {
              throw new MissingRequiredPropertyException("GetComponentResult", "version");
            }
            this.version = version;
            return this;
        }
        public GetComponentResult build() {
            final var _resultValue = new GetComponentResult();
            _resultValue.arn = arn;
            _resultValue.changeDescription = changeDescription;
            _resultValue.data = data;
            _resultValue.dateCreated = dateCreated;
            _resultValue.description = description;
            _resultValue.encrypted = encrypted;
            _resultValue.id = id;
            _resultValue.kmsKeyId = kmsKeyId;
            _resultValue.name = name;
            _resultValue.owner = owner;
            _resultValue.platform = platform;
            _resultValue.supportedOsVersions = supportedOsVersions;
            _resultValue.tags = tags;
            _resultValue.type = type;
            _resultValue.version = version;
            return _resultValue;
        }
    }
}
