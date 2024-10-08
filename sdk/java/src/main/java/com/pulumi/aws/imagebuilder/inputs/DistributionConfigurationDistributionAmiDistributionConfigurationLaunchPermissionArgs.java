// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.imagebuilder.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs extends com.pulumi.resources.ResourceArgs {

    public static final DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs Empty = new DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs();

    /**
     * Set of AWS Organization ARNs to assign.
     * 
     */
    @Import(name="organizationArns")
    private @Nullable Output<List<String>> organizationArns;

    /**
     * @return Set of AWS Organization ARNs to assign.
     * 
     */
    public Optional<Output<List<String>>> organizationArns() {
        return Optional.ofNullable(this.organizationArns);
    }

    /**
     * Set of AWS Organizational Unit ARNs to assign.
     * 
     */
    @Import(name="organizationalUnitArns")
    private @Nullable Output<List<String>> organizationalUnitArns;

    /**
     * @return Set of AWS Organizational Unit ARNs to assign.
     * 
     */
    public Optional<Output<List<String>>> organizationalUnitArns() {
        return Optional.ofNullable(this.organizationalUnitArns);
    }

    /**
     * Set of EC2 launch permission user groups to assign. Use `all` to distribute a public AMI.
     * 
     */
    @Import(name="userGroups")
    private @Nullable Output<List<String>> userGroups;

    /**
     * @return Set of EC2 launch permission user groups to assign. Use `all` to distribute a public AMI.
     * 
     */
    public Optional<Output<List<String>>> userGroups() {
        return Optional.ofNullable(this.userGroups);
    }

    /**
     * Set of AWS Account identifiers to assign.
     * 
     */
    @Import(name="userIds")
    private @Nullable Output<List<String>> userIds;

    /**
     * @return Set of AWS Account identifiers to assign.
     * 
     */
    public Optional<Output<List<String>>> userIds() {
        return Optional.ofNullable(this.userIds);
    }

    private DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs() {}

    private DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs(DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs $) {
        this.organizationArns = $.organizationArns;
        this.organizationalUnitArns = $.organizationalUnitArns;
        this.userGroups = $.userGroups;
        this.userIds = $.userIds;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs $;

        public Builder() {
            $ = new DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs();
        }

        public Builder(DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs defaults) {
            $ = new DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param organizationArns Set of AWS Organization ARNs to assign.
         * 
         * @return builder
         * 
         */
        public Builder organizationArns(@Nullable Output<List<String>> organizationArns) {
            $.organizationArns = organizationArns;
            return this;
        }

        /**
         * @param organizationArns Set of AWS Organization ARNs to assign.
         * 
         * @return builder
         * 
         */
        public Builder organizationArns(List<String> organizationArns) {
            return organizationArns(Output.of(organizationArns));
        }

        /**
         * @param organizationArns Set of AWS Organization ARNs to assign.
         * 
         * @return builder
         * 
         */
        public Builder organizationArns(String... organizationArns) {
            return organizationArns(List.of(organizationArns));
        }

        /**
         * @param organizationalUnitArns Set of AWS Organizational Unit ARNs to assign.
         * 
         * @return builder
         * 
         */
        public Builder organizationalUnitArns(@Nullable Output<List<String>> organizationalUnitArns) {
            $.organizationalUnitArns = organizationalUnitArns;
            return this;
        }

        /**
         * @param organizationalUnitArns Set of AWS Organizational Unit ARNs to assign.
         * 
         * @return builder
         * 
         */
        public Builder organizationalUnitArns(List<String> organizationalUnitArns) {
            return organizationalUnitArns(Output.of(organizationalUnitArns));
        }

        /**
         * @param organizationalUnitArns Set of AWS Organizational Unit ARNs to assign.
         * 
         * @return builder
         * 
         */
        public Builder organizationalUnitArns(String... organizationalUnitArns) {
            return organizationalUnitArns(List.of(organizationalUnitArns));
        }

        /**
         * @param userGroups Set of EC2 launch permission user groups to assign. Use `all` to distribute a public AMI.
         * 
         * @return builder
         * 
         */
        public Builder userGroups(@Nullable Output<List<String>> userGroups) {
            $.userGroups = userGroups;
            return this;
        }

        /**
         * @param userGroups Set of EC2 launch permission user groups to assign. Use `all` to distribute a public AMI.
         * 
         * @return builder
         * 
         */
        public Builder userGroups(List<String> userGroups) {
            return userGroups(Output.of(userGroups));
        }

        /**
         * @param userGroups Set of EC2 launch permission user groups to assign. Use `all` to distribute a public AMI.
         * 
         * @return builder
         * 
         */
        public Builder userGroups(String... userGroups) {
            return userGroups(List.of(userGroups));
        }

        /**
         * @param userIds Set of AWS Account identifiers to assign.
         * 
         * @return builder
         * 
         */
        public Builder userIds(@Nullable Output<List<String>> userIds) {
            $.userIds = userIds;
            return this;
        }

        /**
         * @param userIds Set of AWS Account identifiers to assign.
         * 
         * @return builder
         * 
         */
        public Builder userIds(List<String> userIds) {
            return userIds(Output.of(userIds));
        }

        /**
         * @param userIds Set of AWS Account identifiers to assign.
         * 
         * @return builder
         * 
         */
        public Builder userIds(String... userIds) {
            return userIds(List.of(userIds));
        }

        public DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs build() {
            return $;
        }
    }

}
