// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.connect.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetContactFlowModuleArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetContactFlowModuleArgs Empty = new GetContactFlowModuleArgs();

    /**
     * Returns information on a specific Contact Flow Module by contact flow module id
     * 
     */
    @Import(name="contactFlowModuleId")
    private @Nullable Output<String> contactFlowModuleId;

    /**
     * @return Returns information on a specific Contact Flow Module by contact flow module id
     * 
     */
    public Optional<Output<String>> contactFlowModuleId() {
        return Optional.ofNullable(this.contactFlowModuleId);
    }

    /**
     * Reference to the hosting Amazon Connect Instance
     * 
     */
    @Import(name="instanceId", required=true)
    private Output<String> instanceId;

    /**
     * @return Reference to the hosting Amazon Connect Instance
     * 
     */
    public Output<String> instanceId() {
        return this.instanceId;
    }

    /**
     * Returns information on a specific Contact Flow Module by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `contact_flow_module_id` is required.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Returns information on a specific Contact Flow Module by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `contact_flow_module_id` is required.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Map of tags to assign to the Contact Flow Module.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the Contact Flow Module.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetContactFlowModuleArgs() {}

    private GetContactFlowModuleArgs(GetContactFlowModuleArgs $) {
        this.contactFlowModuleId = $.contactFlowModuleId;
        this.instanceId = $.instanceId;
        this.name = $.name;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetContactFlowModuleArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetContactFlowModuleArgs $;

        public Builder() {
            $ = new GetContactFlowModuleArgs();
        }

        public Builder(GetContactFlowModuleArgs defaults) {
            $ = new GetContactFlowModuleArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param contactFlowModuleId Returns information on a specific Contact Flow Module by contact flow module id
         * 
         * @return builder
         * 
         */
        public Builder contactFlowModuleId(@Nullable Output<String> contactFlowModuleId) {
            $.contactFlowModuleId = contactFlowModuleId;
            return this;
        }

        /**
         * @param contactFlowModuleId Returns information on a specific Contact Flow Module by contact flow module id
         * 
         * @return builder
         * 
         */
        public Builder contactFlowModuleId(String contactFlowModuleId) {
            return contactFlowModuleId(Output.of(contactFlowModuleId));
        }

        /**
         * @param instanceId Reference to the hosting Amazon Connect Instance
         * 
         * @return builder
         * 
         */
        public Builder instanceId(Output<String> instanceId) {
            $.instanceId = instanceId;
            return this;
        }

        /**
         * @param instanceId Reference to the hosting Amazon Connect Instance
         * 
         * @return builder
         * 
         */
        public Builder instanceId(String instanceId) {
            return instanceId(Output.of(instanceId));
        }

        /**
         * @param name Returns information on a specific Contact Flow Module by name
         * 
         * &gt; **NOTE:** `instance_id` and one of either `name` or `contact_flow_module_id` is required.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Returns information on a specific Contact Flow Module by name
         * 
         * &gt; **NOTE:** `instance_id` and one of either `name` or `contact_flow_module_id` is required.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param tags Map of tags to assign to the Contact Flow Module.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags to assign to the Contact Flow Module.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public GetContactFlowModuleArgs build() {
            if ($.instanceId == null) {
                throw new MissingRequiredPropertyException("GetContactFlowModuleArgs", "instanceId");
            }
            return $;
        }
    }

}
