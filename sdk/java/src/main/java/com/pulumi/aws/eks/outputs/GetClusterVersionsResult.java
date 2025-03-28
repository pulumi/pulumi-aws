// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.eks.outputs;

import com.pulumi.aws.eks.outputs.GetClusterVersionsClusterVersion;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class GetClusterVersionsResult {
    /**
     * @return Type of cluster that the version belongs to.
     * 
     */
    private @Nullable String clusterType;
    private List<GetClusterVersionsClusterVersion> clusterVersions;
    private @Nullable List<String> clusterVersionsOnlies;
    private @Nullable Boolean defaultOnly;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private @Nullable Boolean includeAll;
    /**
     * @return Status of the EKS cluster version.
     * 
     */
    private @Nullable String versionStatus;

    private GetClusterVersionsResult() {}
    /**
     * @return Type of cluster that the version belongs to.
     * 
     */
    public Optional<String> clusterType() {
        return Optional.ofNullable(this.clusterType);
    }
    public List<GetClusterVersionsClusterVersion> clusterVersions() {
        return this.clusterVersions;
    }
    public List<String> clusterVersionsOnlies() {
        return this.clusterVersionsOnlies == null ? List.of() : this.clusterVersionsOnlies;
    }
    public Optional<Boolean> defaultOnly() {
        return Optional.ofNullable(this.defaultOnly);
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    public Optional<Boolean> includeAll() {
        return Optional.ofNullable(this.includeAll);
    }
    /**
     * @return Status of the EKS cluster version.
     * 
     */
    public Optional<String> versionStatus() {
        return Optional.ofNullable(this.versionStatus);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetClusterVersionsResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String clusterType;
        private List<GetClusterVersionsClusterVersion> clusterVersions;
        private @Nullable List<String> clusterVersionsOnlies;
        private @Nullable Boolean defaultOnly;
        private String id;
        private @Nullable Boolean includeAll;
        private @Nullable String versionStatus;
        public Builder() {}
        public Builder(GetClusterVersionsResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.clusterType = defaults.clusterType;
    	      this.clusterVersions = defaults.clusterVersions;
    	      this.clusterVersionsOnlies = defaults.clusterVersionsOnlies;
    	      this.defaultOnly = defaults.defaultOnly;
    	      this.id = defaults.id;
    	      this.includeAll = defaults.includeAll;
    	      this.versionStatus = defaults.versionStatus;
        }

        @CustomType.Setter
        public Builder clusterType(@Nullable String clusterType) {

            this.clusterType = clusterType;
            return this;
        }
        @CustomType.Setter
        public Builder clusterVersions(List<GetClusterVersionsClusterVersion> clusterVersions) {
            if (clusterVersions == null) {
              throw new MissingRequiredPropertyException("GetClusterVersionsResult", "clusterVersions");
            }
            this.clusterVersions = clusterVersions;
            return this;
        }
        public Builder clusterVersions(GetClusterVersionsClusterVersion... clusterVersions) {
            return clusterVersions(List.of(clusterVersions));
        }
        @CustomType.Setter
        public Builder clusterVersionsOnlies(@Nullable List<String> clusterVersionsOnlies) {

            this.clusterVersionsOnlies = clusterVersionsOnlies;
            return this;
        }
        public Builder clusterVersionsOnlies(String... clusterVersionsOnlies) {
            return clusterVersionsOnlies(List.of(clusterVersionsOnlies));
        }
        @CustomType.Setter
        public Builder defaultOnly(@Nullable Boolean defaultOnly) {

            this.defaultOnly = defaultOnly;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetClusterVersionsResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder includeAll(@Nullable Boolean includeAll) {

            this.includeAll = includeAll;
            return this;
        }
        @CustomType.Setter
        public Builder versionStatus(@Nullable String versionStatus) {

            this.versionStatus = versionStatus;
            return this;
        }
        public GetClusterVersionsResult build() {
            final var _resultValue = new GetClusterVersionsResult();
            _resultValue.clusterType = clusterType;
            _resultValue.clusterVersions = clusterVersions;
            _resultValue.clusterVersionsOnlies = clusterVersionsOnlies;
            _resultValue.defaultOnly = defaultOnly;
            _resultValue.id = id;
            _resultValue.includeAll = includeAll;
            _resultValue.versionStatus = versionStatus;
            return _resultValue;
        }
    }
}
