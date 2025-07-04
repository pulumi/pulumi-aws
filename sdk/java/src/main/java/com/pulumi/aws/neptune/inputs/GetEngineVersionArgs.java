// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.neptune.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetEngineVersionArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetEngineVersionArgs Empty = new GetEngineVersionArgs();

    /**
     * Whether to return only default engine versions that match all other criteria. AWS may define multiple default versions for a given engine, so using `default_only` alone does not guarantee that only one version will be returned. To ensure a single version is selected, consider combining this with `latest`. Note that default versions are defined by AWS and may not reflect the most recent engine version available.
     * 
     */
    @Import(name="defaultOnly")
    private @Nullable Output<Boolean> defaultOnly;

    /**
     * @return Whether to return only default engine versions that match all other criteria. AWS may define multiple default versions for a given engine, so using `default_only` alone does not guarantee that only one version will be returned. To ensure a single version is selected, consider combining this with `latest`. Note that default versions are defined by AWS and may not reflect the most recent engine version available.
     * 
     */
    public Optional<Output<Boolean>> defaultOnly() {
        return Optional.ofNullable(this.defaultOnly);
    }

    /**
     * DB engine. Must be `neptune`. Default is `neptune`.
     * 
     */
    @Import(name="engine")
    private @Nullable Output<String> engine;

    /**
     * @return DB engine. Must be `neptune`. Default is `neptune`.
     * 
     */
    public Optional<Output<String>> engine() {
        return Optional.ofNullable(this.engine);
    }

    /**
     * Whether to filter for engine versions that have a major target.
     * 
     */
    @Import(name="hasMajorTarget")
    private @Nullable Output<Boolean> hasMajorTarget;

    /**
     * @return Whether to filter for engine versions that have a major target.
     * 
     */
    public Optional<Output<Boolean>> hasMajorTarget() {
        return Optional.ofNullable(this.hasMajorTarget);
    }

    /**
     * Whether to filter for engine versions that have a minor target.
     * 
     */
    @Import(name="hasMinorTarget")
    private @Nullable Output<Boolean> hasMinorTarget;

    /**
     * @return Whether to filter for engine versions that have a minor target.
     * 
     */
    public Optional<Output<Boolean>> hasMinorTarget() {
        return Optional.ofNullable(this.hasMinorTarget);
    }

    /**
     * Whether to return only the latest engine version that matches all other criteria. This differs from `default_only`: AWS may define multiple defaults, and the latest version is not always marked as the default. As a result, `default_only` may still return multiple versions, while `latest` selects a single version. The two options can be used together. **Note:** This argument uses a best-effort approach. Because AWS does not consistently provide version dates or standardized identifiers, the result may not always reflect the true latest version.
     * 
     */
    @Import(name="latest")
    private @Nullable Output<Boolean> latest;

    /**
     * @return Whether to return only the latest engine version that matches all other criteria. This differs from `default_only`: AWS may define multiple defaults, and the latest version is not always marked as the default. As a result, `default_only` may still return multiple versions, while `latest` selects a single version. The two options can be used together. **Note:** This argument uses a best-effort approach. Because AWS does not consistently provide version dates or standardized identifiers, the result may not always reflect the true latest version.
     * 
     */
    public Optional<Output<Boolean>> latest() {
        return Optional.ofNullable(this.latest);
    }

    /**
     * Name of a specific DB parameter group family. An example parameter group family is `neptune1.4`. For some versions, if this is provided, AWS returns no results.
     * 
     */
    @Import(name="parameterGroupFamily")
    private @Nullable Output<String> parameterGroupFamily;

    /**
     * @return Name of a specific DB parameter group family. An example parameter group family is `neptune1.4`. For some versions, if this is provided, AWS returns no results.
     * 
     */
    public Optional<Output<String>> parameterGroupFamily() {
        return Optional.ofNullable(this.parameterGroupFamily);
    }

    /**
     * Ordered list of preferred major engine versions.
     * 
     */
    @Import(name="preferredMajorTargets")
    private @Nullable Output<List<String>> preferredMajorTargets;

    /**
     * @return Ordered list of preferred major engine versions.
     * 
     */
    public Optional<Output<List<String>>> preferredMajorTargets() {
        return Optional.ofNullable(this.preferredMajorTargets);
    }

    /**
     * Ordered list of preferred upgrade engine versions.
     * 
     */
    @Import(name="preferredUpgradeTargets")
    private @Nullable Output<List<String>> preferredUpgradeTargets;

    /**
     * @return Ordered list of preferred upgrade engine versions.
     * 
     */
    public Optional<Output<List<String>>> preferredUpgradeTargets() {
        return Optional.ofNullable(this.preferredUpgradeTargets);
    }

    /**
     * Ordered list of preferred engine versions. The first match in this list will be returned. If no preferred matches are found and the original search returned more than one result, an error is returned. If both the `version` and `preferred_versions` arguments are not configured, the data source will return the default version for the engine.
     * 
     */
    @Import(name="preferredVersions")
    private @Nullable Output<List<String>> preferredVersions;

    /**
     * @return Ordered list of preferred engine versions. The first match in this list will be returned. If no preferred matches are found and the original search returned more than one result, an error is returned. If both the `version` and `preferred_versions` arguments are not configured, the data source will return the default version for the engine.
     * 
     */
    public Optional<Output<List<String>>> preferredVersions() {
        return Optional.ofNullable(this.preferredVersions);
    }

    /**
     * Version of the DB engine. For example, `1.0.1.0`, `1.0.2.2`, and `1.0.3.0`. If both the `version` and `preferred_versions` arguments are not configured, the data source will return the default version for the engine.
     * 
     */
    @Import(name="version")
    private @Nullable Output<String> version;

    /**
     * @return Version of the DB engine. For example, `1.0.1.0`, `1.0.2.2`, and `1.0.3.0`. If both the `version` and `preferred_versions` arguments are not configured, the data source will return the default version for the engine.
     * 
     */
    public Optional<Output<String>> version() {
        return Optional.ofNullable(this.version);
    }

    private GetEngineVersionArgs() {}

    private GetEngineVersionArgs(GetEngineVersionArgs $) {
        this.defaultOnly = $.defaultOnly;
        this.engine = $.engine;
        this.hasMajorTarget = $.hasMajorTarget;
        this.hasMinorTarget = $.hasMinorTarget;
        this.latest = $.latest;
        this.parameterGroupFamily = $.parameterGroupFamily;
        this.preferredMajorTargets = $.preferredMajorTargets;
        this.preferredUpgradeTargets = $.preferredUpgradeTargets;
        this.preferredVersions = $.preferredVersions;
        this.version = $.version;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetEngineVersionArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetEngineVersionArgs $;

        public Builder() {
            $ = new GetEngineVersionArgs();
        }

        public Builder(GetEngineVersionArgs defaults) {
            $ = new GetEngineVersionArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param defaultOnly Whether to return only default engine versions that match all other criteria. AWS may define multiple default versions for a given engine, so using `default_only` alone does not guarantee that only one version will be returned. To ensure a single version is selected, consider combining this with `latest`. Note that default versions are defined by AWS and may not reflect the most recent engine version available.
         * 
         * @return builder
         * 
         */
        public Builder defaultOnly(@Nullable Output<Boolean> defaultOnly) {
            $.defaultOnly = defaultOnly;
            return this;
        }

        /**
         * @param defaultOnly Whether to return only default engine versions that match all other criteria. AWS may define multiple default versions for a given engine, so using `default_only` alone does not guarantee that only one version will be returned. To ensure a single version is selected, consider combining this with `latest`. Note that default versions are defined by AWS and may not reflect the most recent engine version available.
         * 
         * @return builder
         * 
         */
        public Builder defaultOnly(Boolean defaultOnly) {
            return defaultOnly(Output.of(defaultOnly));
        }

        /**
         * @param engine DB engine. Must be `neptune`. Default is `neptune`.
         * 
         * @return builder
         * 
         */
        public Builder engine(@Nullable Output<String> engine) {
            $.engine = engine;
            return this;
        }

        /**
         * @param engine DB engine. Must be `neptune`. Default is `neptune`.
         * 
         * @return builder
         * 
         */
        public Builder engine(String engine) {
            return engine(Output.of(engine));
        }

        /**
         * @param hasMajorTarget Whether to filter for engine versions that have a major target.
         * 
         * @return builder
         * 
         */
        public Builder hasMajorTarget(@Nullable Output<Boolean> hasMajorTarget) {
            $.hasMajorTarget = hasMajorTarget;
            return this;
        }

        /**
         * @param hasMajorTarget Whether to filter for engine versions that have a major target.
         * 
         * @return builder
         * 
         */
        public Builder hasMajorTarget(Boolean hasMajorTarget) {
            return hasMajorTarget(Output.of(hasMajorTarget));
        }

        /**
         * @param hasMinorTarget Whether to filter for engine versions that have a minor target.
         * 
         * @return builder
         * 
         */
        public Builder hasMinorTarget(@Nullable Output<Boolean> hasMinorTarget) {
            $.hasMinorTarget = hasMinorTarget;
            return this;
        }

        /**
         * @param hasMinorTarget Whether to filter for engine versions that have a minor target.
         * 
         * @return builder
         * 
         */
        public Builder hasMinorTarget(Boolean hasMinorTarget) {
            return hasMinorTarget(Output.of(hasMinorTarget));
        }

        /**
         * @param latest Whether to return only the latest engine version that matches all other criteria. This differs from `default_only`: AWS may define multiple defaults, and the latest version is not always marked as the default. As a result, `default_only` may still return multiple versions, while `latest` selects a single version. The two options can be used together. **Note:** This argument uses a best-effort approach. Because AWS does not consistently provide version dates or standardized identifiers, the result may not always reflect the true latest version.
         * 
         * @return builder
         * 
         */
        public Builder latest(@Nullable Output<Boolean> latest) {
            $.latest = latest;
            return this;
        }

        /**
         * @param latest Whether to return only the latest engine version that matches all other criteria. This differs from `default_only`: AWS may define multiple defaults, and the latest version is not always marked as the default. As a result, `default_only` may still return multiple versions, while `latest` selects a single version. The two options can be used together. **Note:** This argument uses a best-effort approach. Because AWS does not consistently provide version dates or standardized identifiers, the result may not always reflect the true latest version.
         * 
         * @return builder
         * 
         */
        public Builder latest(Boolean latest) {
            return latest(Output.of(latest));
        }

        /**
         * @param parameterGroupFamily Name of a specific DB parameter group family. An example parameter group family is `neptune1.4`. For some versions, if this is provided, AWS returns no results.
         * 
         * @return builder
         * 
         */
        public Builder parameterGroupFamily(@Nullable Output<String> parameterGroupFamily) {
            $.parameterGroupFamily = parameterGroupFamily;
            return this;
        }

        /**
         * @param parameterGroupFamily Name of a specific DB parameter group family. An example parameter group family is `neptune1.4`. For some versions, if this is provided, AWS returns no results.
         * 
         * @return builder
         * 
         */
        public Builder parameterGroupFamily(String parameterGroupFamily) {
            return parameterGroupFamily(Output.of(parameterGroupFamily));
        }

        /**
         * @param preferredMajorTargets Ordered list of preferred major engine versions.
         * 
         * @return builder
         * 
         */
        public Builder preferredMajorTargets(@Nullable Output<List<String>> preferredMajorTargets) {
            $.preferredMajorTargets = preferredMajorTargets;
            return this;
        }

        /**
         * @param preferredMajorTargets Ordered list of preferred major engine versions.
         * 
         * @return builder
         * 
         */
        public Builder preferredMajorTargets(List<String> preferredMajorTargets) {
            return preferredMajorTargets(Output.of(preferredMajorTargets));
        }

        /**
         * @param preferredMajorTargets Ordered list of preferred major engine versions.
         * 
         * @return builder
         * 
         */
        public Builder preferredMajorTargets(String... preferredMajorTargets) {
            return preferredMajorTargets(List.of(preferredMajorTargets));
        }

        /**
         * @param preferredUpgradeTargets Ordered list of preferred upgrade engine versions.
         * 
         * @return builder
         * 
         */
        public Builder preferredUpgradeTargets(@Nullable Output<List<String>> preferredUpgradeTargets) {
            $.preferredUpgradeTargets = preferredUpgradeTargets;
            return this;
        }

        /**
         * @param preferredUpgradeTargets Ordered list of preferred upgrade engine versions.
         * 
         * @return builder
         * 
         */
        public Builder preferredUpgradeTargets(List<String> preferredUpgradeTargets) {
            return preferredUpgradeTargets(Output.of(preferredUpgradeTargets));
        }

        /**
         * @param preferredUpgradeTargets Ordered list of preferred upgrade engine versions.
         * 
         * @return builder
         * 
         */
        public Builder preferredUpgradeTargets(String... preferredUpgradeTargets) {
            return preferredUpgradeTargets(List.of(preferredUpgradeTargets));
        }

        /**
         * @param preferredVersions Ordered list of preferred engine versions. The first match in this list will be returned. If no preferred matches are found and the original search returned more than one result, an error is returned. If both the `version` and `preferred_versions` arguments are not configured, the data source will return the default version for the engine.
         * 
         * @return builder
         * 
         */
        public Builder preferredVersions(@Nullable Output<List<String>> preferredVersions) {
            $.preferredVersions = preferredVersions;
            return this;
        }

        /**
         * @param preferredVersions Ordered list of preferred engine versions. The first match in this list will be returned. If no preferred matches are found and the original search returned more than one result, an error is returned. If both the `version` and `preferred_versions` arguments are not configured, the data source will return the default version for the engine.
         * 
         * @return builder
         * 
         */
        public Builder preferredVersions(List<String> preferredVersions) {
            return preferredVersions(Output.of(preferredVersions));
        }

        /**
         * @param preferredVersions Ordered list of preferred engine versions. The first match in this list will be returned. If no preferred matches are found and the original search returned more than one result, an error is returned. If both the `version` and `preferred_versions` arguments are not configured, the data source will return the default version for the engine.
         * 
         * @return builder
         * 
         */
        public Builder preferredVersions(String... preferredVersions) {
            return preferredVersions(List.of(preferredVersions));
        }

        /**
         * @param version Version of the DB engine. For example, `1.0.1.0`, `1.0.2.2`, and `1.0.3.0`. If both the `version` and `preferred_versions` arguments are not configured, the data source will return the default version for the engine.
         * 
         * @return builder
         * 
         */
        public Builder version(@Nullable Output<String> version) {
            $.version = version;
            return this;
        }

        /**
         * @param version Version of the DB engine. For example, `1.0.1.0`, `1.0.2.2`, and `1.0.3.0`. If both the `version` and `preferred_versions` arguments are not configured, the data source will return the default version for the engine.
         * 
         * @return builder
         * 
         */
        public Builder version(String version) {
            return version(Output.of(version));
        }

        public GetEngineVersionArgs build() {
            return $;
        }
    }

}
