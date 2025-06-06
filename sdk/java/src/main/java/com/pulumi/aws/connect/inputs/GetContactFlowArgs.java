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


public final class GetContactFlowArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetContactFlowArgs Empty = new GetContactFlowArgs();

    /**
     * Returns information on a specific Contact Flow by contact flow id
     * 
     */
    @Import(name="contactFlowId")
    private @Nullable Output<String> contactFlowId;

    /**
     * @return Returns information on a specific Contact Flow by contact flow id
     * 
     */
    public Optional<Output<String>> contactFlowId() {
        return Optional.ofNullable(this.contactFlowId);
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
     * Returns information on a specific Contact Flow by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `contact_flow_id` is required.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Returns information on a specific Contact Flow by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `contact_flow_id` is required.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Tags to assign to the Contact Flow.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Tags to assign to the Contact Flow.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * Type of Contact Flow.
     * 
     */
    @Import(name="type")
    private @Nullable Output<String> type;

    /**
     * @return Type of Contact Flow.
     * 
     */
    public Optional<Output<String>> type() {
        return Optional.ofNullable(this.type);
    }

    private GetContactFlowArgs() {}

    private GetContactFlowArgs(GetContactFlowArgs $) {
        this.contactFlowId = $.contactFlowId;
        this.instanceId = $.instanceId;
        this.name = $.name;
        this.tags = $.tags;
        this.type = $.type;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetContactFlowArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetContactFlowArgs $;

        public Builder() {
            $ = new GetContactFlowArgs();
        }

        public Builder(GetContactFlowArgs defaults) {
            $ = new GetContactFlowArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param contactFlowId Returns information on a specific Contact Flow by contact flow id
         * 
         * @return builder
         * 
         */
        public Builder contactFlowId(@Nullable Output<String> contactFlowId) {
            $.contactFlowId = contactFlowId;
            return this;
        }

        /**
         * @param contactFlowId Returns information on a specific Contact Flow by contact flow id
         * 
         * @return builder
         * 
         */
        public Builder contactFlowId(String contactFlowId) {
            return contactFlowId(Output.of(contactFlowId));
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
         * @param name Returns information on a specific Contact Flow by name
         * 
         * &gt; **NOTE:** `instance_id` and one of either `name` or `contact_flow_id` is required.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Returns information on a specific Contact Flow by name
         * 
         * &gt; **NOTE:** `instance_id` and one of either `name` or `contact_flow_id` is required.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param tags Tags to assign to the Contact Flow.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Tags to assign to the Contact Flow.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param type Type of Contact Flow.
         * 
         * @return builder
         * 
         */
        public Builder type(@Nullable Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type Type of Contact Flow.
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        public GetContactFlowArgs build() {
            if ($.instanceId == null) {
                throw new MissingRequiredPropertyException("GetContactFlowArgs", "instanceId");
            }
            return $;
        }
    }

}
