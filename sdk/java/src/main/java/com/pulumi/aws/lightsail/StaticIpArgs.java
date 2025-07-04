// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lightsail;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class StaticIpArgs extends com.pulumi.resources.ResourceArgs {

    public static final StaticIpArgs Empty = new StaticIpArgs();

    /**
     * Name for the allocated static IP.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name for the allocated static IP.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    private StaticIpArgs() {}

    private StaticIpArgs(StaticIpArgs $) {
        this.name = $.name;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(StaticIpArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private StaticIpArgs $;

        public Builder() {
            $ = new StaticIpArgs();
        }

        public Builder(StaticIpArgs defaults) {
            $ = new StaticIpArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param name Name for the allocated static IP.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name for the allocated static IP.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        public StaticIpArgs build() {
            return $;
        }
    }

}
