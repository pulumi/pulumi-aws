// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.inputs;

import com.pulumi.aws.appmesh.inputs.GatewayRouteSpecHttpRouteActionArgs;
import com.pulumi.aws.appmesh.inputs.GatewayRouteSpecHttpRouteMatchArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.Objects;


public final class GatewayRouteSpecHttpRouteArgs extends com.pulumi.resources.ResourceArgs {

    public static final GatewayRouteSpecHttpRouteArgs Empty = new GatewayRouteSpecHttpRouteArgs();

    /**
     * Action to take if a match is determined.
     * 
     */
    @Import(name="action", required=true)
    private Output<GatewayRouteSpecHttpRouteActionArgs> action;

    /**
     * @return Action to take if a match is determined.
     * 
     */
    public Output<GatewayRouteSpecHttpRouteActionArgs> action() {
        return this.action;
    }

    /**
     * Criteria for determining a request match.
     * 
     */
    @Import(name="match", required=true)
    private Output<GatewayRouteSpecHttpRouteMatchArgs> match;

    /**
     * @return Criteria for determining a request match.
     * 
     */
    public Output<GatewayRouteSpecHttpRouteMatchArgs> match() {
        return this.match;
    }

    private GatewayRouteSpecHttpRouteArgs() {}

    private GatewayRouteSpecHttpRouteArgs(GatewayRouteSpecHttpRouteArgs $) {
        this.action = $.action;
        this.match = $.match;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GatewayRouteSpecHttpRouteArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GatewayRouteSpecHttpRouteArgs $;

        public Builder() {
            $ = new GatewayRouteSpecHttpRouteArgs();
        }

        public Builder(GatewayRouteSpecHttpRouteArgs defaults) {
            $ = new GatewayRouteSpecHttpRouteArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param action Action to take if a match is determined.
         * 
         * @return builder
         * 
         */
        public Builder action(Output<GatewayRouteSpecHttpRouteActionArgs> action) {
            $.action = action;
            return this;
        }

        /**
         * @param action Action to take if a match is determined.
         * 
         * @return builder
         * 
         */
        public Builder action(GatewayRouteSpecHttpRouteActionArgs action) {
            return action(Output.of(action));
        }

        /**
         * @param match Criteria for determining a request match.
         * 
         * @return builder
         * 
         */
        public Builder match(Output<GatewayRouteSpecHttpRouteMatchArgs> match) {
            $.match = match;
            return this;
        }

        /**
         * @param match Criteria for determining a request match.
         * 
         * @return builder
         * 
         */
        public Builder match(GatewayRouteSpecHttpRouteMatchArgs match) {
            return match(Output.of(match));
        }

        public GatewayRouteSpecHttpRouteArgs build() {
            if ($.action == null) {
                throw new MissingRequiredPropertyException("GatewayRouteSpecHttpRouteArgs", "action");
            }
            if ($.match == null) {
                throw new MissingRequiredPropertyException("GatewayRouteSpecHttpRouteArgs", "match");
            }
            return $;
        }
    }

}
