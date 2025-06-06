// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.guardduty.inputs;

import com.pulumi.aws.guardduty.inputs.OrganizationConfigurationDatasourcesArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class OrganizationConfigurationState extends com.pulumi.resources.ResourceArgs {

    public static final OrganizationConfigurationState Empty = new OrganizationConfigurationState();

    /**
     * *Deprecated:* Use `auto_enable_organization_members` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
     * 
     * @deprecated
     * auto_enable is deprecated. Use auto_enable_organization_members instead.
     * 
     */
    @Deprecated /* auto_enable is deprecated. Use auto_enable_organization_members instead. */
    @Import(name="autoEnable")
    private @Nullable Output<Boolean> autoEnable;

    /**
     * @return *Deprecated:* Use `auto_enable_organization_members` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
     * 
     * @deprecated
     * auto_enable is deprecated. Use auto_enable_organization_members instead.
     * 
     */
    @Deprecated /* auto_enable is deprecated. Use auto_enable_organization_members instead. */
    public Optional<Output<Boolean>> autoEnable() {
        return Optional.ofNullable(this.autoEnable);
    }

    /**
     * Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
     * 
     */
    @Import(name="autoEnableOrganizationMembers")
    private @Nullable Output<String> autoEnableOrganizationMembers;

    /**
     * @return Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
     * 
     */
    public Optional<Output<String>> autoEnableOrganizationMembers() {
        return Optional.ofNullable(this.autoEnableOrganizationMembers);
    }

    /**
     * Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `aws.guardduty.OrganizationConfigurationFeature` resources.
     * 
     * &gt; **NOTE:** One of `auto_enable` or `auto_enable_organization_members` must be specified.
     * 
     */
    @Import(name="datasources")
    private @Nullable Output<OrganizationConfigurationDatasourcesArgs> datasources;

    /**
     * @return Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `aws.guardduty.OrganizationConfigurationFeature` resources.
     * 
     * &gt; **NOTE:** One of `auto_enable` or `auto_enable_organization_members` must be specified.
     * 
     */
    public Optional<Output<OrganizationConfigurationDatasourcesArgs>> datasources() {
        return Optional.ofNullable(this.datasources);
    }

    /**
     * The detector ID of the GuardDuty account.
     * 
     */
    @Import(name="detectorId")
    private @Nullable Output<String> detectorId;

    /**
     * @return The detector ID of the GuardDuty account.
     * 
     */
    public Optional<Output<String>> detectorId() {
        return Optional.ofNullable(this.detectorId);
    }

    private OrganizationConfigurationState() {}

    private OrganizationConfigurationState(OrganizationConfigurationState $) {
        this.autoEnable = $.autoEnable;
        this.autoEnableOrganizationMembers = $.autoEnableOrganizationMembers;
        this.datasources = $.datasources;
        this.detectorId = $.detectorId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(OrganizationConfigurationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private OrganizationConfigurationState $;

        public Builder() {
            $ = new OrganizationConfigurationState();
        }

        public Builder(OrganizationConfigurationState defaults) {
            $ = new OrganizationConfigurationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param autoEnable *Deprecated:* Use `auto_enable_organization_members` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
         * 
         * @return builder
         * 
         * @deprecated
         * auto_enable is deprecated. Use auto_enable_organization_members instead.
         * 
         */
        @Deprecated /* auto_enable is deprecated. Use auto_enable_organization_members instead. */
        public Builder autoEnable(@Nullable Output<Boolean> autoEnable) {
            $.autoEnable = autoEnable;
            return this;
        }

        /**
         * @param autoEnable *Deprecated:* Use `auto_enable_organization_members` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
         * 
         * @return builder
         * 
         * @deprecated
         * auto_enable is deprecated. Use auto_enable_organization_members instead.
         * 
         */
        @Deprecated /* auto_enable is deprecated. Use auto_enable_organization_members instead. */
        public Builder autoEnable(Boolean autoEnable) {
            return autoEnable(Output.of(autoEnable));
        }

        /**
         * @param autoEnableOrganizationMembers Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
         * 
         * @return builder
         * 
         */
        public Builder autoEnableOrganizationMembers(@Nullable Output<String> autoEnableOrganizationMembers) {
            $.autoEnableOrganizationMembers = autoEnableOrganizationMembers;
            return this;
        }

        /**
         * @param autoEnableOrganizationMembers Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
         * 
         * @return builder
         * 
         */
        public Builder autoEnableOrganizationMembers(String autoEnableOrganizationMembers) {
            return autoEnableOrganizationMembers(Output.of(autoEnableOrganizationMembers));
        }

        /**
         * @param datasources Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `aws.guardduty.OrganizationConfigurationFeature` resources.
         * 
         * &gt; **NOTE:** One of `auto_enable` or `auto_enable_organization_members` must be specified.
         * 
         * @return builder
         * 
         */
        public Builder datasources(@Nullable Output<OrganizationConfigurationDatasourcesArgs> datasources) {
            $.datasources = datasources;
            return this;
        }

        /**
         * @param datasources Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `aws.guardduty.OrganizationConfigurationFeature` resources.
         * 
         * &gt; **NOTE:** One of `auto_enable` or `auto_enable_organization_members` must be specified.
         * 
         * @return builder
         * 
         */
        public Builder datasources(OrganizationConfigurationDatasourcesArgs datasources) {
            return datasources(Output.of(datasources));
        }

        /**
         * @param detectorId The detector ID of the GuardDuty account.
         * 
         * @return builder
         * 
         */
        public Builder detectorId(@Nullable Output<String> detectorId) {
            $.detectorId = detectorId;
            return this;
        }

        /**
         * @param detectorId The detector ID of the GuardDuty account.
         * 
         * @return builder
         * 
         */
        public Builder detectorId(String detectorId) {
            return detectorId(Output.of(detectorId));
        }

        public OrganizationConfigurationState build() {
            return $;
        }
    }

}
