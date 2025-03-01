// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.batch.outputs;

import com.pulumi.aws.batch.outputs.GetJobDefinitionEksPropertyPodPropertyVolumeEmptyDir;
import com.pulumi.aws.batch.outputs.GetJobDefinitionEksPropertyPodPropertyVolumeHostPath;
import com.pulumi.aws.batch.outputs.GetJobDefinitionEksPropertyPodPropertyVolumeSecret;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetJobDefinitionEksPropertyPodPropertyVolume {
    /**
     * @return Specifies the configuration of a Kubernetes emptyDir volume.
     * 
     */
    private List<GetJobDefinitionEksPropertyPodPropertyVolumeEmptyDir> emptyDirs;
    /**
     * @return The path for the device on the host container instance.
     * 
     */
    private List<GetJobDefinitionEksPropertyPodPropertyVolumeHostPath> hostPaths;
    /**
     * @return The name of the job definition to register. It can be up to 128 letters long. It can contain uppercase and lowercase letters, numbers, hyphens (-), and underscores (_).
     * 
     */
    private String name;
    /**
     * @return Specifies the configuration of a Kubernetes secret volume.
     * 
     */
    private List<GetJobDefinitionEksPropertyPodPropertyVolumeSecret> secrets;

    private GetJobDefinitionEksPropertyPodPropertyVolume() {}
    /**
     * @return Specifies the configuration of a Kubernetes emptyDir volume.
     * 
     */
    public List<GetJobDefinitionEksPropertyPodPropertyVolumeEmptyDir> emptyDirs() {
        return this.emptyDirs;
    }
    /**
     * @return The path for the device on the host container instance.
     * 
     */
    public List<GetJobDefinitionEksPropertyPodPropertyVolumeHostPath> hostPaths() {
        return this.hostPaths;
    }
    /**
     * @return The name of the job definition to register. It can be up to 128 letters long. It can contain uppercase and lowercase letters, numbers, hyphens (-), and underscores (_).
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return Specifies the configuration of a Kubernetes secret volume.
     * 
     */
    public List<GetJobDefinitionEksPropertyPodPropertyVolumeSecret> secrets() {
        return this.secrets;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetJobDefinitionEksPropertyPodPropertyVolume defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetJobDefinitionEksPropertyPodPropertyVolumeEmptyDir> emptyDirs;
        private List<GetJobDefinitionEksPropertyPodPropertyVolumeHostPath> hostPaths;
        private String name;
        private List<GetJobDefinitionEksPropertyPodPropertyVolumeSecret> secrets;
        public Builder() {}
        public Builder(GetJobDefinitionEksPropertyPodPropertyVolume defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.emptyDirs = defaults.emptyDirs;
    	      this.hostPaths = defaults.hostPaths;
    	      this.name = defaults.name;
    	      this.secrets = defaults.secrets;
        }

        @CustomType.Setter
        public Builder emptyDirs(List<GetJobDefinitionEksPropertyPodPropertyVolumeEmptyDir> emptyDirs) {
            if (emptyDirs == null) {
              throw new MissingRequiredPropertyException("GetJobDefinitionEksPropertyPodPropertyVolume", "emptyDirs");
            }
            this.emptyDirs = emptyDirs;
            return this;
        }
        public Builder emptyDirs(GetJobDefinitionEksPropertyPodPropertyVolumeEmptyDir... emptyDirs) {
            return emptyDirs(List.of(emptyDirs));
        }
        @CustomType.Setter
        public Builder hostPaths(List<GetJobDefinitionEksPropertyPodPropertyVolumeHostPath> hostPaths) {
            if (hostPaths == null) {
              throw new MissingRequiredPropertyException("GetJobDefinitionEksPropertyPodPropertyVolume", "hostPaths");
            }
            this.hostPaths = hostPaths;
            return this;
        }
        public Builder hostPaths(GetJobDefinitionEksPropertyPodPropertyVolumeHostPath... hostPaths) {
            return hostPaths(List.of(hostPaths));
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetJobDefinitionEksPropertyPodPropertyVolume", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder secrets(List<GetJobDefinitionEksPropertyPodPropertyVolumeSecret> secrets) {
            if (secrets == null) {
              throw new MissingRequiredPropertyException("GetJobDefinitionEksPropertyPodPropertyVolume", "secrets");
            }
            this.secrets = secrets;
            return this;
        }
        public Builder secrets(GetJobDefinitionEksPropertyPodPropertyVolumeSecret... secrets) {
            return secrets(List.of(secrets));
        }
        public GetJobDefinitionEksPropertyPodPropertyVolume build() {
            final var _resultValue = new GetJobDefinitionEksPropertyPodPropertyVolume();
            _resultValue.emptyDirs = emptyDirs;
            _resultValue.hostPaths = hostPaths;
            _resultValue.name = name;
            _resultValue.secrets = secrets;
            return _resultValue;
        }
    }
}
