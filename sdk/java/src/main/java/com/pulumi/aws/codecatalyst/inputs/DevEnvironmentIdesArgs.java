// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codecatalyst.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DevEnvironmentIdesArgs extends com.pulumi.resources.ResourceArgs {

    public static final DevEnvironmentIdesArgs Empty = new DevEnvironmentIdesArgs();

    /**
     * The name of the IDE. Valid values include Cloud9, IntelliJ, PyCharm, GoLand, and VSCode.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The name of the IDE. Valid values include Cloud9, IntelliJ, PyCharm, GoLand, and VSCode.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * A link to the IDE runtime image. This parameter is not required if the name is VSCode. Values of the runtime can be for example public.ecr.aws/jetbrains/py,public.ecr.aws/jetbrains/go
     * 
     */
    @Import(name="runtime")
    private @Nullable Output<String> runtime;

    /**
     * @return A link to the IDE runtime image. This parameter is not required if the name is VSCode. Values of the runtime can be for example public.ecr.aws/jetbrains/py,public.ecr.aws/jetbrains/go
     * 
     */
    public Optional<Output<String>> runtime() {
        return Optional.ofNullable(this.runtime);
    }

    private DevEnvironmentIdesArgs() {}

    private DevEnvironmentIdesArgs(DevEnvironmentIdesArgs $) {
        this.name = $.name;
        this.runtime = $.runtime;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DevEnvironmentIdesArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DevEnvironmentIdesArgs $;

        public Builder() {
            $ = new DevEnvironmentIdesArgs();
        }

        public Builder(DevEnvironmentIdesArgs defaults) {
            $ = new DevEnvironmentIdesArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param name The name of the IDE. Valid values include Cloud9, IntelliJ, PyCharm, GoLand, and VSCode.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of the IDE. Valid values include Cloud9, IntelliJ, PyCharm, GoLand, and VSCode.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param runtime A link to the IDE runtime image. This parameter is not required if the name is VSCode. Values of the runtime can be for example public.ecr.aws/jetbrains/py,public.ecr.aws/jetbrains/go
         * 
         * @return builder
         * 
         */
        public Builder runtime(@Nullable Output<String> runtime) {
            $.runtime = runtime;
            return this;
        }

        /**
         * @param runtime A link to the IDE runtime image. This parameter is not required if the name is VSCode. Values of the runtime can be for example public.ecr.aws/jetbrains/py,public.ecr.aws/jetbrains/go
         * 
         * @return builder
         * 
         */
        public Builder runtime(String runtime) {
            return runtime(Output.of(runtime));
        }

        public DevEnvironmentIdesArgs build() {
            return $;
        }
    }

}
