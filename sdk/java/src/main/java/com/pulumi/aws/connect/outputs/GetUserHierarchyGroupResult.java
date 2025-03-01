// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.connect.outputs;

import com.pulumi.aws.connect.outputs.GetUserHierarchyGroupHierarchyPath;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetUserHierarchyGroupResult {
    /**
     * @return ARN of the hierarchy group.
     * 
     */
    private String arn;
    private String hierarchyGroupId;
    /**
     * @return Block that contains information about the levels in the hierarchy group. The `hierarchy_path` block is documented below.
     * 
     */
    private List<GetUserHierarchyGroupHierarchyPath> hierarchyPaths;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private String instanceId;
    /**
     * @return Identifier of the level in the hierarchy group.
     * 
     */
    private String levelId;
    /**
     * @return Name of the hierarchy group.
     * 
     */
    private String name;
    /**
     * @return Map of tags to assign to the hierarchy group.
     * 
     */
    private Map<String,String> tags;

    private GetUserHierarchyGroupResult() {}
    /**
     * @return ARN of the hierarchy group.
     * 
     */
    public String arn() {
        return this.arn;
    }
    public String hierarchyGroupId() {
        return this.hierarchyGroupId;
    }
    /**
     * @return Block that contains information about the levels in the hierarchy group. The `hierarchy_path` block is documented below.
     * 
     */
    public List<GetUserHierarchyGroupHierarchyPath> hierarchyPaths() {
        return this.hierarchyPaths;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    public String instanceId() {
        return this.instanceId;
    }
    /**
     * @return Identifier of the level in the hierarchy group.
     * 
     */
    public String levelId() {
        return this.levelId;
    }
    /**
     * @return Name of the hierarchy group.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return Map of tags to assign to the hierarchy group.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetUserHierarchyGroupResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String hierarchyGroupId;
        private List<GetUserHierarchyGroupHierarchyPath> hierarchyPaths;
        private String id;
        private String instanceId;
        private String levelId;
        private String name;
        private Map<String,String> tags;
        public Builder() {}
        public Builder(GetUserHierarchyGroupResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.hierarchyGroupId = defaults.hierarchyGroupId;
    	      this.hierarchyPaths = defaults.hierarchyPaths;
    	      this.id = defaults.id;
    	      this.instanceId = defaults.instanceId;
    	      this.levelId = defaults.levelId;
    	      this.name = defaults.name;
    	      this.tags = defaults.tags;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetUserHierarchyGroupResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder hierarchyGroupId(String hierarchyGroupId) {
            if (hierarchyGroupId == null) {
              throw new MissingRequiredPropertyException("GetUserHierarchyGroupResult", "hierarchyGroupId");
            }
            this.hierarchyGroupId = hierarchyGroupId;
            return this;
        }
        @CustomType.Setter
        public Builder hierarchyPaths(List<GetUserHierarchyGroupHierarchyPath> hierarchyPaths) {
            if (hierarchyPaths == null) {
              throw new MissingRequiredPropertyException("GetUserHierarchyGroupResult", "hierarchyPaths");
            }
            this.hierarchyPaths = hierarchyPaths;
            return this;
        }
        public Builder hierarchyPaths(GetUserHierarchyGroupHierarchyPath... hierarchyPaths) {
            return hierarchyPaths(List.of(hierarchyPaths));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetUserHierarchyGroupResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder instanceId(String instanceId) {
            if (instanceId == null) {
              throw new MissingRequiredPropertyException("GetUserHierarchyGroupResult", "instanceId");
            }
            this.instanceId = instanceId;
            return this;
        }
        @CustomType.Setter
        public Builder levelId(String levelId) {
            if (levelId == null) {
              throw new MissingRequiredPropertyException("GetUserHierarchyGroupResult", "levelId");
            }
            this.levelId = levelId;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetUserHierarchyGroupResult", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetUserHierarchyGroupResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        public GetUserHierarchyGroupResult build() {
            final var _resultValue = new GetUserHierarchyGroupResult();
            _resultValue.arn = arn;
            _resultValue.hierarchyGroupId = hierarchyGroupId;
            _resultValue.hierarchyPaths = hierarchyPaths;
            _resultValue.id = id;
            _resultValue.instanceId = instanceId;
            _resultValue.levelId = levelId;
            _resultValue.name = name;
            _resultValue.tags = tags;
            return _resultValue;
        }
    }
}
