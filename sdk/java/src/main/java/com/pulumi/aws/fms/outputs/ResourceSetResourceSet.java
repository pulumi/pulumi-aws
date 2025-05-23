// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.fms.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ResourceSetResourceSet {
    /**
     * @return Description of the resource set.
     * 
     */
    private @Nullable String description;
    /**
     * @return Unique identifier for the resource set. It&#39;s returned in the responses to create and list commands. You provide it to operations like update and delete.
     * 
     */
    private @Nullable String id;
    /**
     * @return Last time that the reosurce set was changed.
     * 
     */
    private @Nullable String lastUpdateTime;
    /**
     * @return Descriptive name of the resource set. You can&#39;t change the name of a resource set after you create it.
     * 
     */
    private String name;
    /**
     * @return Indicates whether the resource set is in or out of the admin&#39;s Region scope. Valid values are `ACTIVE` (Admin can manage and delete the resource set) or `OUT_OF_ADMIN_SCOPE` (Admin can view the resource set, but they can&#39;t edit or delete the resource set.)
     * 
     */
    private @Nullable String resourceSetStatus;
    /**
     * @return Determines the resources that can be associated to the resource set. Depending on your setting for max results and the number of resource sets, a single call might not return the full list.
     * 
     */
    private @Nullable List<String> resourceTypeLists;
    private @Nullable String updateToken;

    private ResourceSetResourceSet() {}
    /**
     * @return Description of the resource set.
     * 
     */
    public Optional<String> description() {
        return Optional.ofNullable(this.description);
    }
    /**
     * @return Unique identifier for the resource set. It&#39;s returned in the responses to create and list commands. You provide it to operations like update and delete.
     * 
     */
    public Optional<String> id() {
        return Optional.ofNullable(this.id);
    }
    /**
     * @return Last time that the reosurce set was changed.
     * 
     */
    public Optional<String> lastUpdateTime() {
        return Optional.ofNullable(this.lastUpdateTime);
    }
    /**
     * @return Descriptive name of the resource set. You can&#39;t change the name of a resource set after you create it.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return Indicates whether the resource set is in or out of the admin&#39;s Region scope. Valid values are `ACTIVE` (Admin can manage and delete the resource set) or `OUT_OF_ADMIN_SCOPE` (Admin can view the resource set, but they can&#39;t edit or delete the resource set.)
     * 
     */
    public Optional<String> resourceSetStatus() {
        return Optional.ofNullable(this.resourceSetStatus);
    }
    /**
     * @return Determines the resources that can be associated to the resource set. Depending on your setting for max results and the number of resource sets, a single call might not return the full list.
     * 
     */
    public List<String> resourceTypeLists() {
        return this.resourceTypeLists == null ? List.of() : this.resourceTypeLists;
    }
    public Optional<String> updateToken() {
        return Optional.ofNullable(this.updateToken);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ResourceSetResourceSet defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String description;
        private @Nullable String id;
        private @Nullable String lastUpdateTime;
        private String name;
        private @Nullable String resourceSetStatus;
        private @Nullable List<String> resourceTypeLists;
        private @Nullable String updateToken;
        public Builder() {}
        public Builder(ResourceSetResourceSet defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.description = defaults.description;
    	      this.id = defaults.id;
    	      this.lastUpdateTime = defaults.lastUpdateTime;
    	      this.name = defaults.name;
    	      this.resourceSetStatus = defaults.resourceSetStatus;
    	      this.resourceTypeLists = defaults.resourceTypeLists;
    	      this.updateToken = defaults.updateToken;
        }

        @CustomType.Setter
        public Builder description(@Nullable String description) {

            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder id(@Nullable String id) {

            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder lastUpdateTime(@Nullable String lastUpdateTime) {

            this.lastUpdateTime = lastUpdateTime;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("ResourceSetResourceSet", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder resourceSetStatus(@Nullable String resourceSetStatus) {

            this.resourceSetStatus = resourceSetStatus;
            return this;
        }
        @CustomType.Setter
        public Builder resourceTypeLists(@Nullable List<String> resourceTypeLists) {

            this.resourceTypeLists = resourceTypeLists;
            return this;
        }
        public Builder resourceTypeLists(String... resourceTypeLists) {
            return resourceTypeLists(List.of(resourceTypeLists));
        }
        @CustomType.Setter
        public Builder updateToken(@Nullable String updateToken) {

            this.updateToken = updateToken;
            return this;
        }
        public ResourceSetResourceSet build() {
            final var _resultValue = new ResourceSetResourceSet();
            _resultValue.description = description;
            _resultValue.id = id;
            _resultValue.lastUpdateTime = lastUpdateTime;
            _resultValue.name = name;
            _resultValue.resourceSetStatus = resourceSetStatus;
            _resultValue.resourceTypeLists = resourceTypeLists;
            _resultValue.updateToken = updateToken;
            return _resultValue;
        }
    }
}
