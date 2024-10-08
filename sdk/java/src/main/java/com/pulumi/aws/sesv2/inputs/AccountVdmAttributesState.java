// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sesv2.inputs;

import com.pulumi.aws.sesv2.inputs.AccountVdmAttributesDashboardAttributesArgs;
import com.pulumi.aws.sesv2.inputs.AccountVdmAttributesGuardianAttributesArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AccountVdmAttributesState extends com.pulumi.resources.ResourceArgs {

    public static final AccountVdmAttributesState Empty = new AccountVdmAttributesState();

    /**
     * Specifies additional settings for your VDM configuration as applicable to the Dashboard.
     * 
     */
    @Import(name="dashboardAttributes")
    private @Nullable Output<AccountVdmAttributesDashboardAttributesArgs> dashboardAttributes;

    /**
     * @return Specifies additional settings for your VDM configuration as applicable to the Dashboard.
     * 
     */
    public Optional<Output<AccountVdmAttributesDashboardAttributesArgs>> dashboardAttributes() {
        return Optional.ofNullable(this.dashboardAttributes);
    }

    /**
     * Specifies additional settings for your VDM configuration as applicable to the Guardian.
     * 
     */
    @Import(name="guardianAttributes")
    private @Nullable Output<AccountVdmAttributesGuardianAttributesArgs> guardianAttributes;

    /**
     * @return Specifies additional settings for your VDM configuration as applicable to the Guardian.
     * 
     */
    public Optional<Output<AccountVdmAttributesGuardianAttributesArgs>> guardianAttributes() {
        return Optional.ofNullable(this.guardianAttributes);
    }

    /**
     * Specifies the status of your VDM configuration. Valid values: `ENABLED`, `DISABLED`.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="vdmEnabled")
    private @Nullable Output<String> vdmEnabled;

    /**
     * @return Specifies the status of your VDM configuration. Valid values: `ENABLED`, `DISABLED`.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<String>> vdmEnabled() {
        return Optional.ofNullable(this.vdmEnabled);
    }

    private AccountVdmAttributesState() {}

    private AccountVdmAttributesState(AccountVdmAttributesState $) {
        this.dashboardAttributes = $.dashboardAttributes;
        this.guardianAttributes = $.guardianAttributes;
        this.vdmEnabled = $.vdmEnabled;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AccountVdmAttributesState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AccountVdmAttributesState $;

        public Builder() {
            $ = new AccountVdmAttributesState();
        }

        public Builder(AccountVdmAttributesState defaults) {
            $ = new AccountVdmAttributesState(Objects.requireNonNull(defaults));
        }

        /**
         * @param dashboardAttributes Specifies additional settings for your VDM configuration as applicable to the Dashboard.
         * 
         * @return builder
         * 
         */
        public Builder dashboardAttributes(@Nullable Output<AccountVdmAttributesDashboardAttributesArgs> dashboardAttributes) {
            $.dashboardAttributes = dashboardAttributes;
            return this;
        }

        /**
         * @param dashboardAttributes Specifies additional settings for your VDM configuration as applicable to the Dashboard.
         * 
         * @return builder
         * 
         */
        public Builder dashboardAttributes(AccountVdmAttributesDashboardAttributesArgs dashboardAttributes) {
            return dashboardAttributes(Output.of(dashboardAttributes));
        }

        /**
         * @param guardianAttributes Specifies additional settings for your VDM configuration as applicable to the Guardian.
         * 
         * @return builder
         * 
         */
        public Builder guardianAttributes(@Nullable Output<AccountVdmAttributesGuardianAttributesArgs> guardianAttributes) {
            $.guardianAttributes = guardianAttributes;
            return this;
        }

        /**
         * @param guardianAttributes Specifies additional settings for your VDM configuration as applicable to the Guardian.
         * 
         * @return builder
         * 
         */
        public Builder guardianAttributes(AccountVdmAttributesGuardianAttributesArgs guardianAttributes) {
            return guardianAttributes(Output.of(guardianAttributes));
        }

        /**
         * @param vdmEnabled Specifies the status of your VDM configuration. Valid values: `ENABLED`, `DISABLED`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder vdmEnabled(@Nullable Output<String> vdmEnabled) {
            $.vdmEnabled = vdmEnabled;
            return this;
        }

        /**
         * @param vdmEnabled Specifies the status of your VDM configuration. Valid values: `ENABLED`, `DISABLED`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder vdmEnabled(String vdmEnabled) {
            return vdmEnabled(Output.of(vdmEnabled));
        }

        public AccountVdmAttributesState build() {
            return $;
        }
    }

}
