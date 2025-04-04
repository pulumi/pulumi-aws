// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.eks.inputs;

import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetClusterVersionsPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetClusterVersionsPlainArgs Empty = new GetClusterVersionsPlainArgs();

    /**
     * Type of clusters to filter by.
     * Currently, the only valid value is `eks`.
     * 
     */
    @Import(name="clusterType")
    private @Nullable String clusterType;

    /**
     * @return Type of clusters to filter by.
     * Currently, the only valid value is `eks`.
     * 
     */
    public Optional<String> clusterType() {
        return Optional.ofNullable(this.clusterType);
    }

    @Import(name="clusterVersionsOnlies")
    private @Nullable List<String> clusterVersionsOnlies;

    public Optional<List<String>> clusterVersionsOnlies() {
        return Optional.ofNullable(this.clusterVersionsOnlies);
    }

    /**
     * Whether to show only the default versions of Kubernetes supported by EKS.
     * 
     */
    @Import(name="defaultOnly")
    private @Nullable Boolean defaultOnly;

    /**
     * @return Whether to show only the default versions of Kubernetes supported by EKS.
     * 
     */
    public Optional<Boolean> defaultOnly() {
        return Optional.ofNullable(this.defaultOnly);
    }

    /**
     * Whether to include all kubernetes versions in the response.
     * 
     */
    @Import(name="includeAll")
    private @Nullable Boolean includeAll;

    /**
     * @return Whether to include all kubernetes versions in the response.
     * 
     */
    public Optional<Boolean> includeAll() {
        return Optional.ofNullable(this.includeAll);
    }

    /**
     * Status of the EKS cluster versions to list.
     * Valid values are `STANDARD_SUPPORT` or `UNSUPPORTED` or `EXTENDED_SUPPORT`.
     * 
     */
    @Import(name="versionStatus")
    private @Nullable String versionStatus;

    /**
     * @return Status of the EKS cluster versions to list.
     * Valid values are `STANDARD_SUPPORT` or `UNSUPPORTED` or `EXTENDED_SUPPORT`.
     * 
     */
    public Optional<String> versionStatus() {
        return Optional.ofNullable(this.versionStatus);
    }

    private GetClusterVersionsPlainArgs() {}

    private GetClusterVersionsPlainArgs(GetClusterVersionsPlainArgs $) {
        this.clusterType = $.clusterType;
        this.clusterVersionsOnlies = $.clusterVersionsOnlies;
        this.defaultOnly = $.defaultOnly;
        this.includeAll = $.includeAll;
        this.versionStatus = $.versionStatus;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetClusterVersionsPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetClusterVersionsPlainArgs $;

        public Builder() {
            $ = new GetClusterVersionsPlainArgs();
        }

        public Builder(GetClusterVersionsPlainArgs defaults) {
            $ = new GetClusterVersionsPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param clusterType Type of clusters to filter by.
         * Currently, the only valid value is `eks`.
         * 
         * @return builder
         * 
         */
        public Builder clusterType(@Nullable String clusterType) {
            $.clusterType = clusterType;
            return this;
        }

        public Builder clusterVersionsOnlies(@Nullable List<String> clusterVersionsOnlies) {
            $.clusterVersionsOnlies = clusterVersionsOnlies;
            return this;
        }

        public Builder clusterVersionsOnlies(String... clusterVersionsOnlies) {
            return clusterVersionsOnlies(List.of(clusterVersionsOnlies));
        }

        /**
         * @param defaultOnly Whether to show only the default versions of Kubernetes supported by EKS.
         * 
         * @return builder
         * 
         */
        public Builder defaultOnly(@Nullable Boolean defaultOnly) {
            $.defaultOnly = defaultOnly;
            return this;
        }

        /**
         * @param includeAll Whether to include all kubernetes versions in the response.
         * 
         * @return builder
         * 
         */
        public Builder includeAll(@Nullable Boolean includeAll) {
            $.includeAll = includeAll;
            return this;
        }

        /**
         * @param versionStatus Status of the EKS cluster versions to list.
         * Valid values are `STANDARD_SUPPORT` or `UNSUPPORTED` or `EXTENDED_SUPPORT`.
         * 
         * @return builder
         * 
         */
        public Builder versionStatus(@Nullable String versionStatus) {
            $.versionStatus = versionStatus;
            return this;
        }

        public GetClusterVersionsPlainArgs build() {
            return $;
        }
    }

}
