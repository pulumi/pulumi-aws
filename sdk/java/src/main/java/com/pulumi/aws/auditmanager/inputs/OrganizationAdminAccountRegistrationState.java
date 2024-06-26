// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.auditmanager.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class OrganizationAdminAccountRegistrationState extends com.pulumi.resources.ResourceArgs {

    public static final OrganizationAdminAccountRegistrationState Empty = new OrganizationAdminAccountRegistrationState();

    /**
     * Identifier for the organization administrator account.
     * 
     */
    @Import(name="adminAccountId")
    private @Nullable Output<String> adminAccountId;

    /**
     * @return Identifier for the organization administrator account.
     * 
     */
    public Optional<Output<String>> adminAccountId() {
        return Optional.ofNullable(this.adminAccountId);
    }

    /**
     * Identifier for the organization.
     * 
     */
    @Import(name="organizationId")
    private @Nullable Output<String> organizationId;

    /**
     * @return Identifier for the organization.
     * 
     */
    public Optional<Output<String>> organizationId() {
        return Optional.ofNullable(this.organizationId);
    }

    private OrganizationAdminAccountRegistrationState() {}

    private OrganizationAdminAccountRegistrationState(OrganizationAdminAccountRegistrationState $) {
        this.adminAccountId = $.adminAccountId;
        this.organizationId = $.organizationId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(OrganizationAdminAccountRegistrationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private OrganizationAdminAccountRegistrationState $;

        public Builder() {
            $ = new OrganizationAdminAccountRegistrationState();
        }

        public Builder(OrganizationAdminAccountRegistrationState defaults) {
            $ = new OrganizationAdminAccountRegistrationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param adminAccountId Identifier for the organization administrator account.
         * 
         * @return builder
         * 
         */
        public Builder adminAccountId(@Nullable Output<String> adminAccountId) {
            $.adminAccountId = adminAccountId;
            return this;
        }

        /**
         * @param adminAccountId Identifier for the organization administrator account.
         * 
         * @return builder
         * 
         */
        public Builder adminAccountId(String adminAccountId) {
            return adminAccountId(Output.of(adminAccountId));
        }

        /**
         * @param organizationId Identifier for the organization.
         * 
         * @return builder
         * 
         */
        public Builder organizationId(@Nullable Output<String> organizationId) {
            $.organizationId = organizationId;
            return this;
        }

        /**
         * @param organizationId Identifier for the organization.
         * 
         * @return builder
         * 
         */
        public Builder organizationId(String organizationId) {
            return organizationId(Output.of(organizationId));
        }

        public OrganizationAdminAccountRegistrationState build() {
            return $;
        }
    }

}
