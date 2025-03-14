// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.emr.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ClusterCoreInstanceGroupEbsConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final ClusterCoreInstanceGroupEbsConfigArgs Empty = new ClusterCoreInstanceGroupEbsConfigArgs();

    /**
     * Number of I/O operations per second (IOPS) that the volume supports.
     * 
     */
    @Import(name="iops")
    private @Nullable Output<Integer> iops;

    /**
     * @return Number of I/O operations per second (IOPS) that the volume supports.
     * 
     */
    public Optional<Output<Integer>> iops() {
        return Optional.ofNullable(this.iops);
    }

    /**
     * Volume size, in gibibytes (GiB).
     * 
     */
    @Import(name="size", required=true)
    private Output<Integer> size;

    /**
     * @return Volume size, in gibibytes (GiB).
     * 
     */
    public Output<Integer> size() {
        return this.size;
    }

    /**
     * The throughput, in mebibyte per second (MiB/s).
     * 
     */
    @Import(name="throughput")
    private @Nullable Output<Integer> throughput;

    /**
     * @return The throughput, in mebibyte per second (MiB/s).
     * 
     */
    public Optional<Output<Integer>> throughput() {
        return Optional.ofNullable(this.throughput);
    }

    /**
     * Volume type. Valid options are `gp3`, `gp2`, `io1`, `io2`, `standard`, `st1` and `sc1`. See [EBS Volume Types](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumeTypes.html).
     * 
     */
    @Import(name="type", required=true)
    private Output<String> type;

    /**
     * @return Volume type. Valid options are `gp3`, `gp2`, `io1`, `io2`, `standard`, `st1` and `sc1`. See [EBS Volume Types](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumeTypes.html).
     * 
     */
    public Output<String> type() {
        return this.type;
    }

    /**
     * Number of EBS volumes with this configuration to attach to each EC2 instance in the instance group (default is 1).
     * 
     */
    @Import(name="volumesPerInstance")
    private @Nullable Output<Integer> volumesPerInstance;

    /**
     * @return Number of EBS volumes with this configuration to attach to each EC2 instance in the instance group (default is 1).
     * 
     */
    public Optional<Output<Integer>> volumesPerInstance() {
        return Optional.ofNullable(this.volumesPerInstance);
    }

    private ClusterCoreInstanceGroupEbsConfigArgs() {}

    private ClusterCoreInstanceGroupEbsConfigArgs(ClusterCoreInstanceGroupEbsConfigArgs $) {
        this.iops = $.iops;
        this.size = $.size;
        this.throughput = $.throughput;
        this.type = $.type;
        this.volumesPerInstance = $.volumesPerInstance;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ClusterCoreInstanceGroupEbsConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ClusterCoreInstanceGroupEbsConfigArgs $;

        public Builder() {
            $ = new ClusterCoreInstanceGroupEbsConfigArgs();
        }

        public Builder(ClusterCoreInstanceGroupEbsConfigArgs defaults) {
            $ = new ClusterCoreInstanceGroupEbsConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param iops Number of I/O operations per second (IOPS) that the volume supports.
         * 
         * @return builder
         * 
         */
        public Builder iops(@Nullable Output<Integer> iops) {
            $.iops = iops;
            return this;
        }

        /**
         * @param iops Number of I/O operations per second (IOPS) that the volume supports.
         * 
         * @return builder
         * 
         */
        public Builder iops(Integer iops) {
            return iops(Output.of(iops));
        }

        /**
         * @param size Volume size, in gibibytes (GiB).
         * 
         * @return builder
         * 
         */
        public Builder size(Output<Integer> size) {
            $.size = size;
            return this;
        }

        /**
         * @param size Volume size, in gibibytes (GiB).
         * 
         * @return builder
         * 
         */
        public Builder size(Integer size) {
            return size(Output.of(size));
        }

        /**
         * @param throughput The throughput, in mebibyte per second (MiB/s).
         * 
         * @return builder
         * 
         */
        public Builder throughput(@Nullable Output<Integer> throughput) {
            $.throughput = throughput;
            return this;
        }

        /**
         * @param throughput The throughput, in mebibyte per second (MiB/s).
         * 
         * @return builder
         * 
         */
        public Builder throughput(Integer throughput) {
            return throughput(Output.of(throughput));
        }

        /**
         * @param type Volume type. Valid options are `gp3`, `gp2`, `io1`, `io2`, `standard`, `st1` and `sc1`. See [EBS Volume Types](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumeTypes.html).
         * 
         * @return builder
         * 
         */
        public Builder type(Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type Volume type. Valid options are `gp3`, `gp2`, `io1`, `io2`, `standard`, `st1` and `sc1`. See [EBS Volume Types](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumeTypes.html).
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        /**
         * @param volumesPerInstance Number of EBS volumes with this configuration to attach to each EC2 instance in the instance group (default is 1).
         * 
         * @return builder
         * 
         */
        public Builder volumesPerInstance(@Nullable Output<Integer> volumesPerInstance) {
            $.volumesPerInstance = volumesPerInstance;
            return this;
        }

        /**
         * @param volumesPerInstance Number of EBS volumes with this configuration to attach to each EC2 instance in the instance group (default is 1).
         * 
         * @return builder
         * 
         */
        public Builder volumesPerInstance(Integer volumesPerInstance) {
            return volumesPerInstance(Output.of(volumesPerInstance));
        }

        public ClusterCoreInstanceGroupEbsConfigArgs build() {
            if ($.size == null) {
                throw new MissingRequiredPropertyException("ClusterCoreInstanceGroupEbsConfigArgs", "size");
            }
            if ($.type == null) {
                throw new MissingRequiredPropertyException("ClusterCoreInstanceGroupEbsConfigArgs", "type");
            }
            return $;
        }
    }

}
