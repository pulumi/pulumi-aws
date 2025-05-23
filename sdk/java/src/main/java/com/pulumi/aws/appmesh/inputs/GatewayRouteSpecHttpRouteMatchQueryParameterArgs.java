// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.inputs;

import com.pulumi.aws.appmesh.inputs.GatewayRouteSpecHttpRouteMatchQueryParameterMatchArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GatewayRouteSpecHttpRouteMatchQueryParameterArgs extends com.pulumi.resources.ResourceArgs {

    public static final GatewayRouteSpecHttpRouteMatchQueryParameterArgs Empty = new GatewayRouteSpecHttpRouteMatchQueryParameterArgs();

    /**
     * The query parameter to match on.
     * 
     */
    @Import(name="match")
    private @Nullable Output<GatewayRouteSpecHttpRouteMatchQueryParameterMatchArgs> match;

    /**
     * @return The query parameter to match on.
     * 
     */
    public Optional<Output<GatewayRouteSpecHttpRouteMatchQueryParameterMatchArgs>> match() {
        return Optional.ofNullable(this.match);
    }

    /**
     * Name for the query parameter that will be matched on.
     * 
     */
    @Import(name="name", required=true)
    private Output<String> name;

    /**
     * @return Name for the query parameter that will be matched on.
     * 
     */
    public Output<String> name() {
        return this.name;
    }

    private GatewayRouteSpecHttpRouteMatchQueryParameterArgs() {}

    private GatewayRouteSpecHttpRouteMatchQueryParameterArgs(GatewayRouteSpecHttpRouteMatchQueryParameterArgs $) {
        this.match = $.match;
        this.name = $.name;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GatewayRouteSpecHttpRouteMatchQueryParameterArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GatewayRouteSpecHttpRouteMatchQueryParameterArgs $;

        public Builder() {
            $ = new GatewayRouteSpecHttpRouteMatchQueryParameterArgs();
        }

        public Builder(GatewayRouteSpecHttpRouteMatchQueryParameterArgs defaults) {
            $ = new GatewayRouteSpecHttpRouteMatchQueryParameterArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param match The query parameter to match on.
         * 
         * @return builder
         * 
         */
        public Builder match(@Nullable Output<GatewayRouteSpecHttpRouteMatchQueryParameterMatchArgs> match) {
            $.match = match;
            return this;
        }

        /**
         * @param match The query parameter to match on.
         * 
         * @return builder
         * 
         */
        public Builder match(GatewayRouteSpecHttpRouteMatchQueryParameterMatchArgs match) {
            return match(Output.of(match));
        }

        /**
         * @param name Name for the query parameter that will be matched on.
         * 
         * @return builder
         * 
         */
        public Builder name(Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name for the query parameter that will be matched on.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        public GatewayRouteSpecHttpRouteMatchQueryParameterArgs build() {
            if ($.name == null) {
                throw new MissingRequiredPropertyException("GatewayRouteSpecHttpRouteMatchQueryParameterArgs", "name");
            }
            return $;
        }
    }

}
