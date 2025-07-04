// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dsql.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ClusterMultiRegionProperties {
    /**
     * @return List of DSQL Cluster ARNs peered to this cluster.
     * 
     */
    private @Nullable List<String> clusters;
    /**
     * @return Witness region for the multi-region clusters. Setting this makes this cluster a multi-region cluster. Changing it recreates the resource.
     * 
     */
    private @Nullable String witnessRegion;

    private ClusterMultiRegionProperties() {}
    /**
     * @return List of DSQL Cluster ARNs peered to this cluster.
     * 
     */
    public List<String> clusters() {
        return this.clusters == null ? List.of() : this.clusters;
    }
    /**
     * @return Witness region for the multi-region clusters. Setting this makes this cluster a multi-region cluster. Changing it recreates the resource.
     * 
     */
    public Optional<String> witnessRegion() {
        return Optional.ofNullable(this.witnessRegion);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ClusterMultiRegionProperties defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<String> clusters;
        private @Nullable String witnessRegion;
        public Builder() {}
        public Builder(ClusterMultiRegionProperties defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.clusters = defaults.clusters;
    	      this.witnessRegion = defaults.witnessRegion;
        }

        @CustomType.Setter
        public Builder clusters(@Nullable List<String> clusters) {

            this.clusters = clusters;
            return this;
        }
        public Builder clusters(String... clusters) {
            return clusters(List.of(clusters));
        }
        @CustomType.Setter
        public Builder witnessRegion(@Nullable String witnessRegion) {

            this.witnessRegion = witnessRegion;
            return this;
        }
        public ClusterMultiRegionProperties build() {
            final var _resultValue = new ClusterMultiRegionProperties();
            _resultValue.clusters = clusters;
            _resultValue.witnessRegion = witnessRegion;
            return _resultValue;
        }
    }
}
