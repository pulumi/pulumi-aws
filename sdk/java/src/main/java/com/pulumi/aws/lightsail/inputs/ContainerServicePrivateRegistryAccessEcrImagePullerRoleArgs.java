// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lightsail.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ContainerServicePrivateRegistryAccessEcrImagePullerRoleArgs extends com.pulumi.resources.ResourceArgs {

    public static final ContainerServicePrivateRegistryAccessEcrImagePullerRoleArgs Empty = new ContainerServicePrivateRegistryAccessEcrImagePullerRoleArgs();

    /**
     * Whether to activate the role. Defaults to `false`.
     * 
     */
    @Import(name="isActive")
    private @Nullable Output<Boolean> isActive;

    /**
     * @return Whether to activate the role. Defaults to `false`.
     * 
     */
    public Optional<Output<Boolean>> isActive() {
        return Optional.ofNullable(this.isActive);
    }

    /**
     * Principal ARN of the container service. The principal ARN can be used to create a trust relationship between your standard AWS account and your Lightsail container service.
     * 
     */
    @Import(name="principalArn")
    private @Nullable Output<String> principalArn;

    /**
     * @return Principal ARN of the container service. The principal ARN can be used to create a trust relationship between your standard AWS account and your Lightsail container service.
     * 
     */
    public Optional<Output<String>> principalArn() {
        return Optional.ofNullable(this.principalArn);
    }

    private ContainerServicePrivateRegistryAccessEcrImagePullerRoleArgs() {}

    private ContainerServicePrivateRegistryAccessEcrImagePullerRoleArgs(ContainerServicePrivateRegistryAccessEcrImagePullerRoleArgs $) {
        this.isActive = $.isActive;
        this.principalArn = $.principalArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ContainerServicePrivateRegistryAccessEcrImagePullerRoleArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ContainerServicePrivateRegistryAccessEcrImagePullerRoleArgs $;

        public Builder() {
            $ = new ContainerServicePrivateRegistryAccessEcrImagePullerRoleArgs();
        }

        public Builder(ContainerServicePrivateRegistryAccessEcrImagePullerRoleArgs defaults) {
            $ = new ContainerServicePrivateRegistryAccessEcrImagePullerRoleArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param isActive Whether to activate the role. Defaults to `false`.
         * 
         * @return builder
         * 
         */
        public Builder isActive(@Nullable Output<Boolean> isActive) {
            $.isActive = isActive;
            return this;
        }

        /**
         * @param isActive Whether to activate the role. Defaults to `false`.
         * 
         * @return builder
         * 
         */
        public Builder isActive(Boolean isActive) {
            return isActive(Output.of(isActive));
        }

        /**
         * @param principalArn Principal ARN of the container service. The principal ARN can be used to create a trust relationship between your standard AWS account and your Lightsail container service.
         * 
         * @return builder
         * 
         */
        public Builder principalArn(@Nullable Output<String> principalArn) {
            $.principalArn = principalArn;
            return this;
        }

        /**
         * @param principalArn Principal ARN of the container service. The principal ARN can be used to create a trust relationship between your standard AWS account and your Lightsail container service.
         * 
         * @return builder
         * 
         */
        public Builder principalArn(String principalArn) {
            return principalArn(Output.of(principalArn));
        }

        public ContainerServicePrivateRegistryAccessEcrImagePullerRoleArgs build() {
            return $;
        }
    }

}
