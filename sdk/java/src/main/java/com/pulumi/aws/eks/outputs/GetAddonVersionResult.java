// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.eks.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class GetAddonVersionResult {
    private String addonName;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private String kubernetesVersion;
    private @Nullable Boolean mostRecent;
    /**
     * @return Version of the EKS add-on.
     * 
     */
    private String version;

    private GetAddonVersionResult() {}
    public String addonName() {
        return this.addonName;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    public String kubernetesVersion() {
        return this.kubernetesVersion;
    }
    public Optional<Boolean> mostRecent() {
        return Optional.ofNullable(this.mostRecent);
    }
    /**
     * @return Version of the EKS add-on.
     * 
     */
    public String version() {
        return this.version;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetAddonVersionResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String addonName;
        private String id;
        private String kubernetesVersion;
        private @Nullable Boolean mostRecent;
        private String version;
        public Builder() {}
        public Builder(GetAddonVersionResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.addonName = defaults.addonName;
    	      this.id = defaults.id;
    	      this.kubernetesVersion = defaults.kubernetesVersion;
    	      this.mostRecent = defaults.mostRecent;
    	      this.version = defaults.version;
        }

        @CustomType.Setter
        public Builder addonName(String addonName) {
            if (addonName == null) {
              throw new MissingRequiredPropertyException("GetAddonVersionResult", "addonName");
            }
            this.addonName = addonName;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetAddonVersionResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder kubernetesVersion(String kubernetesVersion) {
            if (kubernetesVersion == null) {
              throw new MissingRequiredPropertyException("GetAddonVersionResult", "kubernetesVersion");
            }
            this.kubernetesVersion = kubernetesVersion;
            return this;
        }
        @CustomType.Setter
        public Builder mostRecent(@Nullable Boolean mostRecent) {

            this.mostRecent = mostRecent;
            return this;
        }
        @CustomType.Setter
        public Builder version(String version) {
            if (version == null) {
              throw new MissingRequiredPropertyException("GetAddonVersionResult", "version");
            }
            this.version = version;
            return this;
        }
        public GetAddonVersionResult build() {
            final var _resultValue = new GetAddonVersionResult();
            _resultValue.addonName = addonName;
            _resultValue.id = id;
            _resultValue.kubernetesVersion = kubernetesVersion;
            _resultValue.mostRecent = mostRecent;
            _resultValue.version = version;
            return _resultValue;
        }
    }
}
