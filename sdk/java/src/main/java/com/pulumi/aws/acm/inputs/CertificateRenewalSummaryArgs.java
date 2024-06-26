// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.acm.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class CertificateRenewalSummaryArgs extends com.pulumi.resources.ResourceArgs {

    public static final CertificateRenewalSummaryArgs Empty = new CertificateRenewalSummaryArgs();

    /**
     * The status of ACM&#39;s managed renewal of the certificate
     * 
     */
    @Import(name="renewalStatus")
    private @Nullable Output<String> renewalStatus;

    /**
     * @return The status of ACM&#39;s managed renewal of the certificate
     * 
     */
    public Optional<Output<String>> renewalStatus() {
        return Optional.ofNullable(this.renewalStatus);
    }

    /**
     * The reason that a renewal request was unsuccessful or is pending
     * 
     */
    @Import(name="renewalStatusReason")
    private @Nullable Output<String> renewalStatusReason;

    /**
     * @return The reason that a renewal request was unsuccessful or is pending
     * 
     */
    public Optional<Output<String>> renewalStatusReason() {
        return Optional.ofNullable(this.renewalStatusReason);
    }

    @Import(name="updatedAt")
    private @Nullable Output<String> updatedAt;

    public Optional<Output<String>> updatedAt() {
        return Optional.ofNullable(this.updatedAt);
    }

    private CertificateRenewalSummaryArgs() {}

    private CertificateRenewalSummaryArgs(CertificateRenewalSummaryArgs $) {
        this.renewalStatus = $.renewalStatus;
        this.renewalStatusReason = $.renewalStatusReason;
        this.updatedAt = $.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CertificateRenewalSummaryArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CertificateRenewalSummaryArgs $;

        public Builder() {
            $ = new CertificateRenewalSummaryArgs();
        }

        public Builder(CertificateRenewalSummaryArgs defaults) {
            $ = new CertificateRenewalSummaryArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param renewalStatus The status of ACM&#39;s managed renewal of the certificate
         * 
         * @return builder
         * 
         */
        public Builder renewalStatus(@Nullable Output<String> renewalStatus) {
            $.renewalStatus = renewalStatus;
            return this;
        }

        /**
         * @param renewalStatus The status of ACM&#39;s managed renewal of the certificate
         * 
         * @return builder
         * 
         */
        public Builder renewalStatus(String renewalStatus) {
            return renewalStatus(Output.of(renewalStatus));
        }

        /**
         * @param renewalStatusReason The reason that a renewal request was unsuccessful or is pending
         * 
         * @return builder
         * 
         */
        public Builder renewalStatusReason(@Nullable Output<String> renewalStatusReason) {
            $.renewalStatusReason = renewalStatusReason;
            return this;
        }

        /**
         * @param renewalStatusReason The reason that a renewal request was unsuccessful or is pending
         * 
         * @return builder
         * 
         */
        public Builder renewalStatusReason(String renewalStatusReason) {
            return renewalStatusReason(Output.of(renewalStatusReason));
        }

        public Builder updatedAt(@Nullable Output<String> updatedAt) {
            $.updatedAt = updatedAt;
            return this;
        }

        public Builder updatedAt(String updatedAt) {
            return updatedAt(Output.of(updatedAt));
        }

        public CertificateRenewalSummaryArgs build() {
            return $;
        }
    }

}
