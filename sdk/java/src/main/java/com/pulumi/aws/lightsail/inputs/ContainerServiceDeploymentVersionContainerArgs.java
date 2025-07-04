// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lightsail.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ContainerServiceDeploymentVersionContainerArgs extends com.pulumi.resources.ResourceArgs {

    public static final ContainerServiceDeploymentVersionContainerArgs Empty = new ContainerServiceDeploymentVersionContainerArgs();

    /**
     * Launch command for the container. A list of strings.
     * 
     */
    @Import(name="commands")
    private @Nullable Output<List<String>> commands;

    /**
     * @return Launch command for the container. A list of strings.
     * 
     */
    public Optional<Output<List<String>>> commands() {
        return Optional.ofNullable(this.commands);
    }

    /**
     * Name of the container.
     * 
     */
    @Import(name="containerName", required=true)
    private Output<String> containerName;

    /**
     * @return Name of the container.
     * 
     */
    public Output<String> containerName() {
        return this.containerName;
    }

    /**
     * Key-value map of the environment variables of the container.
     * 
     */
    @Import(name="environment")
    private @Nullable Output<Map<String,String>> environment;

    /**
     * @return Key-value map of the environment variables of the container.
     * 
     */
    public Optional<Output<Map<String,String>>> environment() {
        return Optional.ofNullable(this.environment);
    }

    /**
     * Name of the image used for the container. Container images sourced from your Lightsail container service, that are registered and stored on your service, start with a colon (`:`). For example, `:container-service-1.mystaticwebsite.1`. Container images sourced from a public registry like Docker Hub don&#39;t start with a colon. For example, `nginx:latest` or `nginx`.
     * 
     */
    @Import(name="image", required=true)
    private Output<String> image;

    /**
     * @return Name of the image used for the container. Container images sourced from your Lightsail container service, that are registered and stored on your service, start with a colon (`:`). For example, `:container-service-1.mystaticwebsite.1`. Container images sourced from a public registry like Docker Hub don&#39;t start with a colon. For example, `nginx:latest` or `nginx`.
     * 
     */
    public Output<String> image() {
        return this.image;
    }

    /**
     * Key-value map of the open firewall ports of the container. Valid values: `HTTP`, `HTTPS`, `TCP`, `UDP`.
     * 
     */
    @Import(name="ports")
    private @Nullable Output<Map<String,String>> ports;

    /**
     * @return Key-value map of the open firewall ports of the container. Valid values: `HTTP`, `HTTPS`, `TCP`, `UDP`.
     * 
     */
    public Optional<Output<Map<String,String>>> ports() {
        return Optional.ofNullable(this.ports);
    }

    private ContainerServiceDeploymentVersionContainerArgs() {}

    private ContainerServiceDeploymentVersionContainerArgs(ContainerServiceDeploymentVersionContainerArgs $) {
        this.commands = $.commands;
        this.containerName = $.containerName;
        this.environment = $.environment;
        this.image = $.image;
        this.ports = $.ports;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ContainerServiceDeploymentVersionContainerArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ContainerServiceDeploymentVersionContainerArgs $;

        public Builder() {
            $ = new ContainerServiceDeploymentVersionContainerArgs();
        }

        public Builder(ContainerServiceDeploymentVersionContainerArgs defaults) {
            $ = new ContainerServiceDeploymentVersionContainerArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param commands Launch command for the container. A list of strings.
         * 
         * @return builder
         * 
         */
        public Builder commands(@Nullable Output<List<String>> commands) {
            $.commands = commands;
            return this;
        }

        /**
         * @param commands Launch command for the container. A list of strings.
         * 
         * @return builder
         * 
         */
        public Builder commands(List<String> commands) {
            return commands(Output.of(commands));
        }

        /**
         * @param commands Launch command for the container. A list of strings.
         * 
         * @return builder
         * 
         */
        public Builder commands(String... commands) {
            return commands(List.of(commands));
        }

        /**
         * @param containerName Name of the container.
         * 
         * @return builder
         * 
         */
        public Builder containerName(Output<String> containerName) {
            $.containerName = containerName;
            return this;
        }

        /**
         * @param containerName Name of the container.
         * 
         * @return builder
         * 
         */
        public Builder containerName(String containerName) {
            return containerName(Output.of(containerName));
        }

        /**
         * @param environment Key-value map of the environment variables of the container.
         * 
         * @return builder
         * 
         */
        public Builder environment(@Nullable Output<Map<String,String>> environment) {
            $.environment = environment;
            return this;
        }

        /**
         * @param environment Key-value map of the environment variables of the container.
         * 
         * @return builder
         * 
         */
        public Builder environment(Map<String,String> environment) {
            return environment(Output.of(environment));
        }

        /**
         * @param image Name of the image used for the container. Container images sourced from your Lightsail container service, that are registered and stored on your service, start with a colon (`:`). For example, `:container-service-1.mystaticwebsite.1`. Container images sourced from a public registry like Docker Hub don&#39;t start with a colon. For example, `nginx:latest` or `nginx`.
         * 
         * @return builder
         * 
         */
        public Builder image(Output<String> image) {
            $.image = image;
            return this;
        }

        /**
         * @param image Name of the image used for the container. Container images sourced from your Lightsail container service, that are registered and stored on your service, start with a colon (`:`). For example, `:container-service-1.mystaticwebsite.1`. Container images sourced from a public registry like Docker Hub don&#39;t start with a colon. For example, `nginx:latest` or `nginx`.
         * 
         * @return builder
         * 
         */
        public Builder image(String image) {
            return image(Output.of(image));
        }

        /**
         * @param ports Key-value map of the open firewall ports of the container. Valid values: `HTTP`, `HTTPS`, `TCP`, `UDP`.
         * 
         * @return builder
         * 
         */
        public Builder ports(@Nullable Output<Map<String,String>> ports) {
            $.ports = ports;
            return this;
        }

        /**
         * @param ports Key-value map of the open firewall ports of the container. Valid values: `HTTP`, `HTTPS`, `TCP`, `UDP`.
         * 
         * @return builder
         * 
         */
        public Builder ports(Map<String,String> ports) {
            return ports(Output.of(ports));
        }

        public ContainerServiceDeploymentVersionContainerArgs build() {
            if ($.containerName == null) {
                throw new MissingRequiredPropertyException("ContainerServiceDeploymentVersionContainerArgs", "containerName");
            }
            if ($.image == null) {
                throw new MissingRequiredPropertyException("ContainerServiceDeploymentVersionContainerArgs", "image");
            }
            return $;
        }
    }

}
