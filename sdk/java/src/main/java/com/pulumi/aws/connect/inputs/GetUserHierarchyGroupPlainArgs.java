// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.connect.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetUserHierarchyGroupPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetUserHierarchyGroupPlainArgs Empty = new GetUserHierarchyGroupPlainArgs();

    /**
     * Returns information on a specific hierarchy group by hierarchy group id
     * 
     */
    @Import(name="hierarchyGroupId")
    private @Nullable String hierarchyGroupId;

    /**
     * @return Returns information on a specific hierarchy group by hierarchy group id
     * 
     */
    public Optional<String> hierarchyGroupId() {
        return Optional.ofNullable(this.hierarchyGroupId);
    }

    /**
     * Reference to the hosting Amazon Connect Instance
     * 
     */
    @Import(name="instanceId", required=true)
    private String instanceId;

    /**
     * @return Reference to the hosting Amazon Connect Instance
     * 
     */
    public String instanceId() {
        return this.instanceId;
    }

    /**
     * Returns information on a specific hierarchy group by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `hierarchy_group_id` is required.
     * 
     */
    @Import(name="name")
    private @Nullable String name;

    /**
     * @return Returns information on a specific hierarchy group by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `hierarchy_group_id` is required.
     * 
     */
    public Optional<String> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Map of tags to assign to the hierarchy group.
     * 
     */
    @Import(name="tags")
    private @Nullable Map<String,String> tags;

    /**
     * @return Map of tags to assign to the hierarchy group.
     * 
     */
    public Optional<Map<String,String>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetUserHierarchyGroupPlainArgs() {}

    private GetUserHierarchyGroupPlainArgs(GetUserHierarchyGroupPlainArgs $) {
        this.hierarchyGroupId = $.hierarchyGroupId;
        this.instanceId = $.instanceId;
        this.name = $.name;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetUserHierarchyGroupPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetUserHierarchyGroupPlainArgs $;

        public Builder() {
            $ = new GetUserHierarchyGroupPlainArgs();
        }

        public Builder(GetUserHierarchyGroupPlainArgs defaults) {
            $ = new GetUserHierarchyGroupPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param hierarchyGroupId Returns information on a specific hierarchy group by hierarchy group id
         * 
         * @return builder
         * 
         */
        public Builder hierarchyGroupId(@Nullable String hierarchyGroupId) {
            $.hierarchyGroupId = hierarchyGroupId;
            return this;
        }

        /**
         * @param instanceId Reference to the hosting Amazon Connect Instance
         * 
         * @return builder
         * 
         */
        public Builder instanceId(String instanceId) {
            $.instanceId = instanceId;
            return this;
        }

        /**
         * @param name Returns information on a specific hierarchy group by name
         * 
         * &gt; **NOTE:** `instance_id` and one of either `name` or `hierarchy_group_id` is required.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable String name) {
            $.name = name;
            return this;
        }

        /**
         * @param tags Map of tags to assign to the hierarchy group.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Map<String,String> tags) {
            $.tags = tags;
            return this;
        }

        public GetUserHierarchyGroupPlainArgs build() {
            if ($.instanceId == null) {
                throw new MissingRequiredPropertyException("GetUserHierarchyGroupPlainArgs", "instanceId");
            }
            return $;
        }
    }

}
