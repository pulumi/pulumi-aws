// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.storagegateway.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetLocalDiskArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetLocalDiskArgs Empty = new GetLocalDiskArgs();

    /**
     * Device node of the local disk to retrieve. For example, `/dev/sdb`.
     * 
     */
    @Import(name="diskNode")
    private @Nullable Output<String> diskNode;

    /**
     * @return Device node of the local disk to retrieve. For example, `/dev/sdb`.
     * 
     */
    public Optional<Output<String>> diskNode() {
        return Optional.ofNullable(this.diskNode);
    }

    /**
     * Device path of the local disk to retrieve. For example, `/dev/xvdb` or `/dev/nvme1n1`.
     * 
     */
    @Import(name="diskPath")
    private @Nullable Output<String> diskPath;

    /**
     * @return Device path of the local disk to retrieve. For example, `/dev/xvdb` or `/dev/nvme1n1`.
     * 
     */
    public Optional<Output<String>> diskPath() {
        return Optional.ofNullable(this.diskPath);
    }

    /**
     * ARN of the gateway.
     * 
     */
    @Import(name="gatewayArn", required=true)
    private Output<String> gatewayArn;

    /**
     * @return ARN of the gateway.
     * 
     */
    public Output<String> gatewayArn() {
        return this.gatewayArn;
    }

    private GetLocalDiskArgs() {}

    private GetLocalDiskArgs(GetLocalDiskArgs $) {
        this.diskNode = $.diskNode;
        this.diskPath = $.diskPath;
        this.gatewayArn = $.gatewayArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetLocalDiskArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetLocalDiskArgs $;

        public Builder() {
            $ = new GetLocalDiskArgs();
        }

        public Builder(GetLocalDiskArgs defaults) {
            $ = new GetLocalDiskArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param diskNode Device node of the local disk to retrieve. For example, `/dev/sdb`.
         * 
         * @return builder
         * 
         */
        public Builder diskNode(@Nullable Output<String> diskNode) {
            $.diskNode = diskNode;
            return this;
        }

        /**
         * @param diskNode Device node of the local disk to retrieve. For example, `/dev/sdb`.
         * 
         * @return builder
         * 
         */
        public Builder diskNode(String diskNode) {
            return diskNode(Output.of(diskNode));
        }

        /**
         * @param diskPath Device path of the local disk to retrieve. For example, `/dev/xvdb` or `/dev/nvme1n1`.
         * 
         * @return builder
         * 
         */
        public Builder diskPath(@Nullable Output<String> diskPath) {
            $.diskPath = diskPath;
            return this;
        }

        /**
         * @param diskPath Device path of the local disk to retrieve. For example, `/dev/xvdb` or `/dev/nvme1n1`.
         * 
         * @return builder
         * 
         */
        public Builder diskPath(String diskPath) {
            return diskPath(Output.of(diskPath));
        }

        /**
         * @param gatewayArn ARN of the gateway.
         * 
         * @return builder
         * 
         */
        public Builder gatewayArn(Output<String> gatewayArn) {
            $.gatewayArn = gatewayArn;
            return this;
        }

        /**
         * @param gatewayArn ARN of the gateway.
         * 
         * @return builder
         * 
         */
        public Builder gatewayArn(String gatewayArn) {
            return gatewayArn(Output.of(gatewayArn));
        }

        public GetLocalDiskArgs build() {
            if ($.gatewayArn == null) {
                throw new MissingRequiredPropertyException("GetLocalDiskArgs", "gatewayArn");
            }
            return $;
        }
    }

}
