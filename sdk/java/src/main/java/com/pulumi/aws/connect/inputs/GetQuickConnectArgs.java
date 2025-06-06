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


public final class GetQuickConnectArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetQuickConnectArgs Empty = new GetQuickConnectArgs();

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
     * Returns information on a specific Quick Connect by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `quick_connect_id` is required.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Returns information on a specific Quick Connect by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `quick_connect_id` is required.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Returns information on a specific Quick Connect by Quick Connect id
     * 
     */
    @Import(name="quickConnectId")
    private @Nullable Output<String> quickConnectId;

    /**
     * @return Returns information on a specific Quick Connect by Quick Connect id
     * 
     */
    public Optional<Output<String>> quickConnectId() {
        return Optional.ofNullable(this.quickConnectId);
    }

    /**
     * Map of tags to assign to the Quick Connect.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the Quick Connect.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetQuickConnectArgs() {}

    private GetQuickConnectArgs(GetQuickConnectArgs $) {
        this.instanceId = $.instanceId;
        this.name = $.name;
        this.quickConnectId = $.quickConnectId;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetQuickConnectArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetQuickConnectArgs $;

        public Builder() {
            $ = new GetQuickConnectArgs();
        }

        public Builder(GetQuickConnectArgs defaults) {
            $ = new GetQuickConnectArgs(Objects.requireNonNull(defaults));
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
         * @param name Returns information on a specific Quick Connect by name
         * 
         * &gt; **NOTE:** `instance_id` and one of either `name` or `quick_connect_id` is required.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Returns information on a specific Quick Connect by name
         * 
         * &gt; **NOTE:** `instance_id` and one of either `name` or `quick_connect_id` is required.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param quickConnectId Returns information on a specific Quick Connect by Quick Connect id
         * 
         * @return builder
         * 
         */
        public Builder quickConnectId(@Nullable Output<String> quickConnectId) {
            $.quickConnectId = quickConnectId;
            return this;
        }

        /**
         * @param quickConnectId Returns information on a specific Quick Connect by Quick Connect id
         * 
         * @return builder
         * 
         */
        public Builder quickConnectId(String quickConnectId) {
            return quickConnectId(Output.of(quickConnectId));
        }

        /**
         * @param tags Map of tags to assign to the Quick Connect.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags to assign to the Quick Connect.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public GetQuickConnectArgs build() {
            if ($.instanceId == null) {
                throw new MissingRequiredPropertyException("GetQuickConnectArgs", "instanceId");
            }
            return $;
        }
    }

}
