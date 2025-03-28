// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dataexchange.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class EventActionEventRevisionPublishedArgs extends com.pulumi.resources.ResourceArgs {

    public static final EventActionEventRevisionPublishedArgs Empty = new EventActionEventRevisionPublishedArgs();

    /**
     * The ID of the data set to monitor for revision publications.
     * Changing this value will recreate the resource.
     * 
     */
    @Import(name="dataSetId", required=true)
    private Output<String> dataSetId;

    /**
     * @return The ID of the data set to monitor for revision publications.
     * Changing this value will recreate the resource.
     * 
     */
    public Output<String> dataSetId() {
        return this.dataSetId;
    }

    private EventActionEventRevisionPublishedArgs() {}

    private EventActionEventRevisionPublishedArgs(EventActionEventRevisionPublishedArgs $) {
        this.dataSetId = $.dataSetId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EventActionEventRevisionPublishedArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EventActionEventRevisionPublishedArgs $;

        public Builder() {
            $ = new EventActionEventRevisionPublishedArgs();
        }

        public Builder(EventActionEventRevisionPublishedArgs defaults) {
            $ = new EventActionEventRevisionPublishedArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param dataSetId The ID of the data set to monitor for revision publications.
         * Changing this value will recreate the resource.
         * 
         * @return builder
         * 
         */
        public Builder dataSetId(Output<String> dataSetId) {
            $.dataSetId = dataSetId;
            return this;
        }

        /**
         * @param dataSetId The ID of the data set to monitor for revision publications.
         * Changing this value will recreate the resource.
         * 
         * @return builder
         * 
         */
        public Builder dataSetId(String dataSetId) {
            return dataSetId(Output.of(dataSetId));
        }

        public EventActionEventRevisionPublishedArgs build() {
            if ($.dataSetId == null) {
                throw new MissingRequiredPropertyException("EventActionEventRevisionPublishedArgs", "dataSetId");
            }
            return $;
        }
    }

}
