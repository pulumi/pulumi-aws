// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.computeoptimizer;

import com.pulumi.aws.computeoptimizer.inputs.EnrollmentStatusTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class EnrollmentStatusArgs extends com.pulumi.resources.ResourceArgs {

    public static final EnrollmentStatusArgs Empty = new EnrollmentStatusArgs();

    /**
     * Whether to enroll member accounts of the organization if the account is the management account of an organization. Default is `false`.
     * 
     */
    @Import(name="includeMemberAccounts")
    private @Nullable Output<Boolean> includeMemberAccounts;

    /**
     * @return Whether to enroll member accounts of the organization if the account is the management account of an organization. Default is `false`.
     * 
     */
    public Optional<Output<Boolean>> includeMemberAccounts() {
        return Optional.ofNullable(this.includeMemberAccounts);
    }

    /**
     * The enrollment status of the account. Valid values: `Active`, `Inactive`.
     * 
     */
    @Import(name="status", required=true)
    private Output<String> status;

    /**
     * @return The enrollment status of the account. Valid values: `Active`, `Inactive`.
     * 
     */
    public Output<String> status() {
        return this.status;
    }

    @Import(name="timeouts")
    private @Nullable Output<EnrollmentStatusTimeoutsArgs> timeouts;

    public Optional<Output<EnrollmentStatusTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    private EnrollmentStatusArgs() {}

    private EnrollmentStatusArgs(EnrollmentStatusArgs $) {
        this.includeMemberAccounts = $.includeMemberAccounts;
        this.status = $.status;
        this.timeouts = $.timeouts;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EnrollmentStatusArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EnrollmentStatusArgs $;

        public Builder() {
            $ = new EnrollmentStatusArgs();
        }

        public Builder(EnrollmentStatusArgs defaults) {
            $ = new EnrollmentStatusArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param includeMemberAccounts Whether to enroll member accounts of the organization if the account is the management account of an organization. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includeMemberAccounts(@Nullable Output<Boolean> includeMemberAccounts) {
            $.includeMemberAccounts = includeMemberAccounts;
            return this;
        }

        /**
         * @param includeMemberAccounts Whether to enroll member accounts of the organization if the account is the management account of an organization. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includeMemberAccounts(Boolean includeMemberAccounts) {
            return includeMemberAccounts(Output.of(includeMemberAccounts));
        }

        /**
         * @param status The enrollment status of the account. Valid values: `Active`, `Inactive`.
         * 
         * @return builder
         * 
         */
        public Builder status(Output<String> status) {
            $.status = status;
            return this;
        }

        /**
         * @param status The enrollment status of the account. Valid values: `Active`, `Inactive`.
         * 
         * @return builder
         * 
         */
        public Builder status(String status) {
            return status(Output.of(status));
        }

        public Builder timeouts(@Nullable Output<EnrollmentStatusTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(EnrollmentStatusTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        public EnrollmentStatusArgs build() {
            if ($.status == null) {
                throw new MissingRequiredPropertyException("EnrollmentStatusArgs", "status");
            }
            return $;
        }
    }

}
