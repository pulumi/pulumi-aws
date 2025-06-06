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


public final class GetHoursOfOperationArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetHoursOfOperationArgs Empty = new GetHoursOfOperationArgs();

    /**
     * Returns information on a specific Hours of Operation by hours of operation id
     * 
     */
    @Import(name="hoursOfOperationId")
    private @Nullable Output<String> hoursOfOperationId;

    /**
     * @return Returns information on a specific Hours of Operation by hours of operation id
     * 
     */
    public Optional<Output<String>> hoursOfOperationId() {
        return Optional.ofNullable(this.hoursOfOperationId);
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
     * Returns information on a specific Hours of Operation by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `hours_of_operation_id` is required.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Returns information on a specific Hours of Operation by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `hours_of_operation_id` is required.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Map of tags to assign to the Hours of Operation.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the Hours of Operation.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetHoursOfOperationArgs() {}

    private GetHoursOfOperationArgs(GetHoursOfOperationArgs $) {
        this.hoursOfOperationId = $.hoursOfOperationId;
        this.instanceId = $.instanceId;
        this.name = $.name;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetHoursOfOperationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetHoursOfOperationArgs $;

        public Builder() {
            $ = new GetHoursOfOperationArgs();
        }

        public Builder(GetHoursOfOperationArgs defaults) {
            $ = new GetHoursOfOperationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param hoursOfOperationId Returns information on a specific Hours of Operation by hours of operation id
         * 
         * @return builder
         * 
         */
        public Builder hoursOfOperationId(@Nullable Output<String> hoursOfOperationId) {
            $.hoursOfOperationId = hoursOfOperationId;
            return this;
        }

        /**
         * @param hoursOfOperationId Returns information on a specific Hours of Operation by hours of operation id
         * 
         * @return builder
         * 
         */
        public Builder hoursOfOperationId(String hoursOfOperationId) {
            return hoursOfOperationId(Output.of(hoursOfOperationId));
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
         * @param name Returns information on a specific Hours of Operation by name
         * 
         * &gt; **NOTE:** `instance_id` and one of either `name` or `hours_of_operation_id` is required.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Returns information on a specific Hours of Operation by name
         * 
         * &gt; **NOTE:** `instance_id` and one of either `name` or `hours_of_operation_id` is required.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param tags Map of tags to assign to the Hours of Operation.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags to assign to the Hours of Operation.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public GetHoursOfOperationArgs build() {
            if ($.instanceId == null) {
                throw new MissingRequiredPropertyException("GetHoursOfOperationArgs", "instanceId");
            }
            return $;
        }
    }

}
