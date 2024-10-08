// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssoadmin.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ApplicationAssignmentState extends com.pulumi.resources.ResourceArgs {

    public static final ApplicationAssignmentState Empty = new ApplicationAssignmentState();

    /**
     * ARN of the application.
     * 
     */
    @Import(name="applicationArn")
    private @Nullable Output<String> applicationArn;

    /**
     * @return ARN of the application.
     * 
     */
    public Optional<Output<String>> applicationArn() {
        return Optional.ofNullable(this.applicationArn);
    }

    /**
     * An identifier for an object in IAM Identity Center, such as a user or group.
     * 
     */
    @Import(name="principalId")
    private @Nullable Output<String> principalId;

    /**
     * @return An identifier for an object in IAM Identity Center, such as a user or group.
     * 
     */
    public Optional<Output<String>> principalId() {
        return Optional.ofNullable(this.principalId);
    }

    /**
     * Entity type for which the assignment will be created. Valid values are `USER` or `GROUP`.
     * 
     */
    @Import(name="principalType")
    private @Nullable Output<String> principalType;

    /**
     * @return Entity type for which the assignment will be created. Valid values are `USER` or `GROUP`.
     * 
     */
    public Optional<Output<String>> principalType() {
        return Optional.ofNullable(this.principalType);
    }

    private ApplicationAssignmentState() {}

    private ApplicationAssignmentState(ApplicationAssignmentState $) {
        this.applicationArn = $.applicationArn;
        this.principalId = $.principalId;
        this.principalType = $.principalType;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ApplicationAssignmentState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ApplicationAssignmentState $;

        public Builder() {
            $ = new ApplicationAssignmentState();
        }

        public Builder(ApplicationAssignmentState defaults) {
            $ = new ApplicationAssignmentState(Objects.requireNonNull(defaults));
        }

        /**
         * @param applicationArn ARN of the application.
         * 
         * @return builder
         * 
         */
        public Builder applicationArn(@Nullable Output<String> applicationArn) {
            $.applicationArn = applicationArn;
            return this;
        }

        /**
         * @param applicationArn ARN of the application.
         * 
         * @return builder
         * 
         */
        public Builder applicationArn(String applicationArn) {
            return applicationArn(Output.of(applicationArn));
        }

        /**
         * @param principalId An identifier for an object in IAM Identity Center, such as a user or group.
         * 
         * @return builder
         * 
         */
        public Builder principalId(@Nullable Output<String> principalId) {
            $.principalId = principalId;
            return this;
        }

        /**
         * @param principalId An identifier for an object in IAM Identity Center, such as a user or group.
         * 
         * @return builder
         * 
         */
        public Builder principalId(String principalId) {
            return principalId(Output.of(principalId));
        }

        /**
         * @param principalType Entity type for which the assignment will be created. Valid values are `USER` or `GROUP`.
         * 
         * @return builder
         * 
         */
        public Builder principalType(@Nullable Output<String> principalType) {
            $.principalType = principalType;
            return this;
        }

        /**
         * @param principalType Entity type for which the assignment will be created. Valid values are `USER` or `GROUP`.
         * 
         * @return builder
         * 
         */
        public Builder principalType(String principalType) {
            return principalType(Output.of(principalType));
        }

        public ApplicationAssignmentState build() {
            return $;
        }
    }

}
