// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iot.outputs;

import com.pulumi.aws.iot.outputs.ThingGroupMetadataRootToParentGroup;
import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ThingGroupMetadata {
    private @Nullable String creationDate;
    /**
     * @return The name of the parent Thing Group.
     * 
     */
    private @Nullable String parentGroupName;
    private @Nullable List<ThingGroupMetadataRootToParentGroup> rootToParentGroups;

    private ThingGroupMetadata() {}
    public Optional<String> creationDate() {
        return Optional.ofNullable(this.creationDate);
    }
    /**
     * @return The name of the parent Thing Group.
     * 
     */
    public Optional<String> parentGroupName() {
        return Optional.ofNullable(this.parentGroupName);
    }
    public List<ThingGroupMetadataRootToParentGroup> rootToParentGroups() {
        return this.rootToParentGroups == null ? List.of() : this.rootToParentGroups;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ThingGroupMetadata defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String creationDate;
        private @Nullable String parentGroupName;
        private @Nullable List<ThingGroupMetadataRootToParentGroup> rootToParentGroups;
        public Builder() {}
        public Builder(ThingGroupMetadata defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.creationDate = defaults.creationDate;
    	      this.parentGroupName = defaults.parentGroupName;
    	      this.rootToParentGroups = defaults.rootToParentGroups;
        }

        @CustomType.Setter
        public Builder creationDate(@Nullable String creationDate) {

            this.creationDate = creationDate;
            return this;
        }
        @CustomType.Setter
        public Builder parentGroupName(@Nullable String parentGroupName) {

            this.parentGroupName = parentGroupName;
            return this;
        }
        @CustomType.Setter
        public Builder rootToParentGroups(@Nullable List<ThingGroupMetadataRootToParentGroup> rootToParentGroups) {

            this.rootToParentGroups = rootToParentGroups;
            return this;
        }
        public Builder rootToParentGroups(ThingGroupMetadataRootToParentGroup... rootToParentGroups) {
            return rootToParentGroups(List.of(rootToParentGroups));
        }
        public ThingGroupMetadata build() {
            final var _resultValue = new ThingGroupMetadata();
            _resultValue.creationDate = creationDate;
            _resultValue.parentGroupName = parentGroupName;
            _resultValue.rootToParentGroups = rootToParentGroups;
            return _resultValue;
        }
    }
}
