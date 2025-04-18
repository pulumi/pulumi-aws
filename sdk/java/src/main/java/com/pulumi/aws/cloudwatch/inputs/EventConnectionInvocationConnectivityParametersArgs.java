// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch.inputs;

import com.pulumi.aws.cloudwatch.inputs.EventConnectionInvocationConnectivityParametersResourceParametersArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.Objects;


public final class EventConnectionInvocationConnectivityParametersArgs extends com.pulumi.resources.ResourceArgs {

    public static final EventConnectionInvocationConnectivityParametersArgs Empty = new EventConnectionInvocationConnectivityParametersArgs();

    /**
     * The parameters for EventBridge to use when invoking the resource endpoint. Documented below.
     * 
     */
    @Import(name="resourceParameters", required=true)
    private Output<EventConnectionInvocationConnectivityParametersResourceParametersArgs> resourceParameters;

    /**
     * @return The parameters for EventBridge to use when invoking the resource endpoint. Documented below.
     * 
     */
    public Output<EventConnectionInvocationConnectivityParametersResourceParametersArgs> resourceParameters() {
        return this.resourceParameters;
    }

    private EventConnectionInvocationConnectivityParametersArgs() {}

    private EventConnectionInvocationConnectivityParametersArgs(EventConnectionInvocationConnectivityParametersArgs $) {
        this.resourceParameters = $.resourceParameters;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EventConnectionInvocationConnectivityParametersArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EventConnectionInvocationConnectivityParametersArgs $;

        public Builder() {
            $ = new EventConnectionInvocationConnectivityParametersArgs();
        }

        public Builder(EventConnectionInvocationConnectivityParametersArgs defaults) {
            $ = new EventConnectionInvocationConnectivityParametersArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param resourceParameters The parameters for EventBridge to use when invoking the resource endpoint. Documented below.
         * 
         * @return builder
         * 
         */
        public Builder resourceParameters(Output<EventConnectionInvocationConnectivityParametersResourceParametersArgs> resourceParameters) {
            $.resourceParameters = resourceParameters;
            return this;
        }

        /**
         * @param resourceParameters The parameters for EventBridge to use when invoking the resource endpoint. Documented below.
         * 
         * @return builder
         * 
         */
        public Builder resourceParameters(EventConnectionInvocationConnectivityParametersResourceParametersArgs resourceParameters) {
            return resourceParameters(Output.of(resourceParameters));
        }

        public EventConnectionInvocationConnectivityParametersArgs build() {
            if ($.resourceParameters == null) {
                throw new MissingRequiredPropertyException("EventConnectionInvocationConnectivityParametersArgs", "resourceParameters");
            }
            return $;
        }
    }

}
