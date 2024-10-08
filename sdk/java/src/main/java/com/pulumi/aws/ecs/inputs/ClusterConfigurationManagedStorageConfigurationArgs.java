// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ecs.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ClusterConfigurationManagedStorageConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final ClusterConfigurationManagedStorageConfigurationArgs Empty = new ClusterConfigurationManagedStorageConfigurationArgs();

    /**
     * AWS Key Management Service key ID for the Fargate ephemeral storage.
     * 
     */
    @Import(name="fargateEphemeralStorageKmsKeyId")
    private @Nullable Output<String> fargateEphemeralStorageKmsKeyId;

    /**
     * @return AWS Key Management Service key ID for the Fargate ephemeral storage.
     * 
     */
    public Optional<Output<String>> fargateEphemeralStorageKmsKeyId() {
        return Optional.ofNullable(this.fargateEphemeralStorageKmsKeyId);
    }

    /**
     * AWS Key Management Service key ID to encrypt the managed storage.
     * 
     */
    @Import(name="kmsKeyId")
    private @Nullable Output<String> kmsKeyId;

    /**
     * @return AWS Key Management Service key ID to encrypt the managed storage.
     * 
     */
    public Optional<Output<String>> kmsKeyId() {
        return Optional.ofNullable(this.kmsKeyId);
    }

    private ClusterConfigurationManagedStorageConfigurationArgs() {}

    private ClusterConfigurationManagedStorageConfigurationArgs(ClusterConfigurationManagedStorageConfigurationArgs $) {
        this.fargateEphemeralStorageKmsKeyId = $.fargateEphemeralStorageKmsKeyId;
        this.kmsKeyId = $.kmsKeyId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ClusterConfigurationManagedStorageConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ClusterConfigurationManagedStorageConfigurationArgs $;

        public Builder() {
            $ = new ClusterConfigurationManagedStorageConfigurationArgs();
        }

        public Builder(ClusterConfigurationManagedStorageConfigurationArgs defaults) {
            $ = new ClusterConfigurationManagedStorageConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param fargateEphemeralStorageKmsKeyId AWS Key Management Service key ID for the Fargate ephemeral storage.
         * 
         * @return builder
         * 
         */
        public Builder fargateEphemeralStorageKmsKeyId(@Nullable Output<String> fargateEphemeralStorageKmsKeyId) {
            $.fargateEphemeralStorageKmsKeyId = fargateEphemeralStorageKmsKeyId;
            return this;
        }

        /**
         * @param fargateEphemeralStorageKmsKeyId AWS Key Management Service key ID for the Fargate ephemeral storage.
         * 
         * @return builder
         * 
         */
        public Builder fargateEphemeralStorageKmsKeyId(String fargateEphemeralStorageKmsKeyId) {
            return fargateEphemeralStorageKmsKeyId(Output.of(fargateEphemeralStorageKmsKeyId));
        }

        /**
         * @param kmsKeyId AWS Key Management Service key ID to encrypt the managed storage.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(@Nullable Output<String> kmsKeyId) {
            $.kmsKeyId = kmsKeyId;
            return this;
        }

        /**
         * @param kmsKeyId AWS Key Management Service key ID to encrypt the managed storage.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(String kmsKeyId) {
            return kmsKeyId(Output.of(kmsKeyId));
        }

        public ClusterConfigurationManagedStorageConfigurationArgs build() {
            return $;
        }
    }

}
