// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.redshift.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ScheduledActionTargetActionResizeCluster {
    /**
     * @return A boolean value indicating whether the resize operation is using the classic resize process. Default: `false`.
     * 
     */
    private @Nullable Boolean classic;
    /**
     * @return The unique identifier for the cluster to resize.
     * 
     */
    private String clusterIdentifier;
    /**
     * @return The new cluster type for the specified cluster.
     * 
     */
    private @Nullable String clusterType;
    /**
     * @return The new node type for the nodes you are adding.
     * 
     */
    private @Nullable String nodeType;
    /**
     * @return The new number of nodes for the cluster.
     * 
     */
    private @Nullable Integer numberOfNodes;

    private ScheduledActionTargetActionResizeCluster() {}
    /**
     * @return A boolean value indicating whether the resize operation is using the classic resize process. Default: `false`.
     * 
     */
    public Optional<Boolean> classic() {
        return Optional.ofNullable(this.classic);
    }
    /**
     * @return The unique identifier for the cluster to resize.
     * 
     */
    public String clusterIdentifier() {
        return this.clusterIdentifier;
    }
    /**
     * @return The new cluster type for the specified cluster.
     * 
     */
    public Optional<String> clusterType() {
        return Optional.ofNullable(this.clusterType);
    }
    /**
     * @return The new node type for the nodes you are adding.
     * 
     */
    public Optional<String> nodeType() {
        return Optional.ofNullable(this.nodeType);
    }
    /**
     * @return The new number of nodes for the cluster.
     * 
     */
    public Optional<Integer> numberOfNodes() {
        return Optional.ofNullable(this.numberOfNodes);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ScheduledActionTargetActionResizeCluster defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean classic;
        private String clusterIdentifier;
        private @Nullable String clusterType;
        private @Nullable String nodeType;
        private @Nullable Integer numberOfNodes;
        public Builder() {}
        public Builder(ScheduledActionTargetActionResizeCluster defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.classic = defaults.classic;
    	      this.clusterIdentifier = defaults.clusterIdentifier;
    	      this.clusterType = defaults.clusterType;
    	      this.nodeType = defaults.nodeType;
    	      this.numberOfNodes = defaults.numberOfNodes;
        }

        @CustomType.Setter
        public Builder classic(@Nullable Boolean classic) {

            this.classic = classic;
            return this;
        }
        @CustomType.Setter
        public Builder clusterIdentifier(String clusterIdentifier) {
            if (clusterIdentifier == null) {
              throw new MissingRequiredPropertyException("ScheduledActionTargetActionResizeCluster", "clusterIdentifier");
            }
            this.clusterIdentifier = clusterIdentifier;
            return this;
        }
        @CustomType.Setter
        public Builder clusterType(@Nullable String clusterType) {

            this.clusterType = clusterType;
            return this;
        }
        @CustomType.Setter
        public Builder nodeType(@Nullable String nodeType) {

            this.nodeType = nodeType;
            return this;
        }
        @CustomType.Setter
        public Builder numberOfNodes(@Nullable Integer numberOfNodes) {

            this.numberOfNodes = numberOfNodes;
            return this;
        }
        public ScheduledActionTargetActionResizeCluster build() {
            final var _resultValue = new ScheduledActionTargetActionResizeCluster();
            _resultValue.classic = classic;
            _resultValue.clusterIdentifier = clusterIdentifier;
            _resultValue.clusterType = clusterType;
            _resultValue.nodeType = nodeType;
            _resultValue.numberOfNodes = numberOfNodes;
            return _resultValue;
        }
    }
}
