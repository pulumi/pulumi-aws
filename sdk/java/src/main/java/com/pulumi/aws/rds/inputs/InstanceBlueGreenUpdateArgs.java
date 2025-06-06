// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.rds.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class InstanceBlueGreenUpdateArgs extends com.pulumi.resources.ResourceArgs {

    public static final InstanceBlueGreenUpdateArgs Empty = new InstanceBlueGreenUpdateArgs();

    /**
     * Enables low-downtime updates when `true`.
     * Default is `false`.
     * 
     * [instance-replication]:
     * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.Replication.html
     * [instance-maintenance]:
     * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_UpgradeDBInstance.Maintenance.html
     * [blue-green]:
     * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/blue-green-deployments.html
     * 
     */
    @Import(name="enabled")
    private @Nullable Output<Boolean> enabled;

    /**
     * @return Enables low-downtime updates when `true`.
     * Default is `false`.
     * 
     * [instance-replication]:
     * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.Replication.html
     * [instance-maintenance]:
     * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_UpgradeDBInstance.Maintenance.html
     * [blue-green]:
     * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/blue-green-deployments.html
     * 
     */
    public Optional<Output<Boolean>> enabled() {
        return Optional.ofNullable(this.enabled);
    }

    private InstanceBlueGreenUpdateArgs() {}

    private InstanceBlueGreenUpdateArgs(InstanceBlueGreenUpdateArgs $) {
        this.enabled = $.enabled;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(InstanceBlueGreenUpdateArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private InstanceBlueGreenUpdateArgs $;

        public Builder() {
            $ = new InstanceBlueGreenUpdateArgs();
        }

        public Builder(InstanceBlueGreenUpdateArgs defaults) {
            $ = new InstanceBlueGreenUpdateArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param enabled Enables low-downtime updates when `true`.
         * Default is `false`.
         * 
         * [instance-replication]:
         * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.Replication.html
         * [instance-maintenance]:
         * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_UpgradeDBInstance.Maintenance.html
         * [blue-green]:
         * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/blue-green-deployments.html
         * 
         * @return builder
         * 
         */
        public Builder enabled(@Nullable Output<Boolean> enabled) {
            $.enabled = enabled;
            return this;
        }

        /**
         * @param enabled Enables low-downtime updates when `true`.
         * Default is `false`.
         * 
         * [instance-replication]:
         * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.Replication.html
         * [instance-maintenance]:
         * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_UpgradeDBInstance.Maintenance.html
         * [blue-green]:
         * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/blue-green-deployments.html
         * 
         * @return builder
         * 
         */
        public Builder enabled(Boolean enabled) {
            return enabled(Output.of(enabled));
        }

        public InstanceBlueGreenUpdateArgs build() {
            return $;
        }
    }

}
