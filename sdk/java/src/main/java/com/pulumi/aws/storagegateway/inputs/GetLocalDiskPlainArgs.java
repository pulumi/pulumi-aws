// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.storagegateway.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetLocalDiskPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetLocalDiskPlainArgs Empty = new GetLocalDiskPlainArgs();

    /**
     * Device node of the local disk to retrieve. For example, `/dev/sdb`.
     * 
     */
    @Import(name="diskNode")
    private @Nullable String diskNode;

    /**
     * @return Device node of the local disk to retrieve. For example, `/dev/sdb`.
     * 
     */
    public Optional<String> diskNode() {
        return Optional.ofNullable(this.diskNode);
    }

    /**
     * Device path of the local disk to retrieve. For example, `/dev/xvdb` or `/dev/nvme1n1`.
     * 
     */
    @Import(name="diskPath")
    private @Nullable String diskPath;

    /**
     * @return Device path of the local disk to retrieve. For example, `/dev/xvdb` or `/dev/nvme1n1`.
     * 
     */
    public Optional<String> diskPath() {
        return Optional.ofNullable(this.diskPath);
    }

    /**
     * ARN of the gateway.
     * 
     */
    @Import(name="gatewayArn", required=true)
    private String gatewayArn;

    /**
     * @return ARN of the gateway.
     * 
     */
    public String gatewayArn() {
        return this.gatewayArn;
    }

    private GetLocalDiskPlainArgs() {}

    private GetLocalDiskPlainArgs(GetLocalDiskPlainArgs $) {
        this.diskNode = $.diskNode;
        this.diskPath = $.diskPath;
        this.gatewayArn = $.gatewayArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetLocalDiskPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetLocalDiskPlainArgs $;

        public Builder() {
            $ = new GetLocalDiskPlainArgs();
        }

        public Builder(GetLocalDiskPlainArgs defaults) {
            $ = new GetLocalDiskPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param diskNode Device node of the local disk to retrieve. For example, `/dev/sdb`.
         * 
         * @return builder
         * 
         */
        public Builder diskNode(@Nullable String diskNode) {
            $.diskNode = diskNode;
            return this;
        }

        /**
         * @param diskPath Device path of the local disk to retrieve. For example, `/dev/xvdb` or `/dev/nvme1n1`.
         * 
         * @return builder
         * 
         */
        public Builder diskPath(@Nullable String diskPath) {
            $.diskPath = diskPath;
            return this;
        }

        /**
         * @param gatewayArn ARN of the gateway.
         * 
         * @return builder
         * 
         */
        public Builder gatewayArn(String gatewayArn) {
            $.gatewayArn = gatewayArn;
            return this;
        }

        public GetLocalDiskPlainArgs build() {
            if ($.gatewayArn == null) {
                throw new MissingRequiredPropertyException("GetLocalDiskPlainArgs", "gatewayArn");
            }
            return $;
        }
    }

}
