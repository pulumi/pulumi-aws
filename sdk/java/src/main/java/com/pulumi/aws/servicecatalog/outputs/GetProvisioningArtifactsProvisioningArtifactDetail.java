// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.servicecatalog.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetProvisioningArtifactsProvisioningArtifactDetail {
    /**
     * @return Indicates whether the product version is active.
     * 
     */
    private Boolean active;
    /**
     * @return The UTC time stamp of the creation time.
     * 
     */
    private String createdTime;
    /**
     * @return The description of the provisioning artifact.
     * 
     */
    private String description;
    /**
     * @return Information set by the administrator to provide guidance to end users about which provisioning artifacts to use.
     * 
     */
    private String guidance;
    /**
     * @return The identifier of the provisioning artifact.
     * 
     */
    private String id;
    /**
     * @return The name of the provisioning artifact.
     * 
     */
    private String name;
    /**
     * @return The type of provisioning artifact.
     * 
     */
    private String type;

    private GetProvisioningArtifactsProvisioningArtifactDetail() {}
    /**
     * @return Indicates whether the product version is active.
     * 
     */
    public Boolean active() {
        return this.active;
    }
    /**
     * @return The UTC time stamp of the creation time.
     * 
     */
    public String createdTime() {
        return this.createdTime;
    }
    /**
     * @return The description of the provisioning artifact.
     * 
     */
    public String description() {
        return this.description;
    }
    /**
     * @return Information set by the administrator to provide guidance to end users about which provisioning artifacts to use.
     * 
     */
    public String guidance() {
        return this.guidance;
    }
    /**
     * @return The identifier of the provisioning artifact.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return The name of the provisioning artifact.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return The type of provisioning artifact.
     * 
     */
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetProvisioningArtifactsProvisioningArtifactDetail defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean active;
        private String createdTime;
        private String description;
        private String guidance;
        private String id;
        private String name;
        private String type;
        public Builder() {}
        public Builder(GetProvisioningArtifactsProvisioningArtifactDetail defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.active = defaults.active;
    	      this.createdTime = defaults.createdTime;
    	      this.description = defaults.description;
    	      this.guidance = defaults.guidance;
    	      this.id = defaults.id;
    	      this.name = defaults.name;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder active(Boolean active) {
            if (active == null) {
              throw new MissingRequiredPropertyException("GetProvisioningArtifactsProvisioningArtifactDetail", "active");
            }
            this.active = active;
            return this;
        }
        @CustomType.Setter
        public Builder createdTime(String createdTime) {
            if (createdTime == null) {
              throw new MissingRequiredPropertyException("GetProvisioningArtifactsProvisioningArtifactDetail", "createdTime");
            }
            this.createdTime = createdTime;
            return this;
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetProvisioningArtifactsProvisioningArtifactDetail", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder guidance(String guidance) {
            if (guidance == null) {
              throw new MissingRequiredPropertyException("GetProvisioningArtifactsProvisioningArtifactDetail", "guidance");
            }
            this.guidance = guidance;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetProvisioningArtifactsProvisioningArtifactDetail", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetProvisioningArtifactsProvisioningArtifactDetail", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("GetProvisioningArtifactsProvisioningArtifactDetail", "type");
            }
            this.type = type;
            return this;
        }
        public GetProvisioningArtifactsProvisioningArtifactDetail build() {
            final var _resultValue = new GetProvisioningArtifactsProvisioningArtifactDetail();
            _resultValue.active = active;
            _resultValue.createdTime = createdTime;
            _resultValue.description = description;
            _resultValue.guidance = guidance;
            _resultValue.id = id;
            _resultValue.name = name;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
