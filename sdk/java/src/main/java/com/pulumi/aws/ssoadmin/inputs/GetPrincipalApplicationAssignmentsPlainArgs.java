// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssoadmin.inputs;

import com.pulumi.aws.ssoadmin.inputs.GetPrincipalApplicationAssignmentsApplicationAssignment;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetPrincipalApplicationAssignmentsPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetPrincipalApplicationAssignmentsPlainArgs Empty = new GetPrincipalApplicationAssignmentsPlainArgs();

    /**
     * List of principals assigned to the application. See the `application_assignments` attribute reference below.
     * 
     */
    @Import(name="applicationAssignments")
    private @Nullable List<GetPrincipalApplicationAssignmentsApplicationAssignment> applicationAssignments;

    /**
     * @return List of principals assigned to the application. See the `application_assignments` attribute reference below.
     * 
     */
    public Optional<List<GetPrincipalApplicationAssignmentsApplicationAssignment>> applicationAssignments() {
        return Optional.ofNullable(this.applicationAssignments);
    }

    /**
     * ARN of the instance of IAM Identity Center.
     * 
     */
    @Import(name="instanceArn", required=true)
    private String instanceArn;

    /**
     * @return ARN of the instance of IAM Identity Center.
     * 
     */
    public String instanceArn() {
        return this.instanceArn;
    }

    /**
     * An identifier for an object in IAM Identity Center, such as a user or group.
     * 
     */
    @Import(name="principalId", required=true)
    private String principalId;

    /**
     * @return An identifier for an object in IAM Identity Center, such as a user or group.
     * 
     */
    public String principalId() {
        return this.principalId;
    }

    /**
     * Entity type for which the assignment will be created. Valid values are `USER` or `GROUP`.
     * 
     */
    @Import(name="principalType", required=true)
    private String principalType;

    /**
     * @return Entity type for which the assignment will be created. Valid values are `USER` or `GROUP`.
     * 
     */
    public String principalType() {
        return this.principalType;
    }

    private GetPrincipalApplicationAssignmentsPlainArgs() {}

    private GetPrincipalApplicationAssignmentsPlainArgs(GetPrincipalApplicationAssignmentsPlainArgs $) {
        this.applicationAssignments = $.applicationAssignments;
        this.instanceArn = $.instanceArn;
        this.principalId = $.principalId;
        this.principalType = $.principalType;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetPrincipalApplicationAssignmentsPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetPrincipalApplicationAssignmentsPlainArgs $;

        public Builder() {
            $ = new GetPrincipalApplicationAssignmentsPlainArgs();
        }

        public Builder(GetPrincipalApplicationAssignmentsPlainArgs defaults) {
            $ = new GetPrincipalApplicationAssignmentsPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param applicationAssignments List of principals assigned to the application. See the `application_assignments` attribute reference below.
         * 
         * @return builder
         * 
         */
        public Builder applicationAssignments(@Nullable List<GetPrincipalApplicationAssignmentsApplicationAssignment> applicationAssignments) {
            $.applicationAssignments = applicationAssignments;
            return this;
        }

        /**
         * @param applicationAssignments List of principals assigned to the application. See the `application_assignments` attribute reference below.
         * 
         * @return builder
         * 
         */
        public Builder applicationAssignments(GetPrincipalApplicationAssignmentsApplicationAssignment... applicationAssignments) {
            return applicationAssignments(List.of(applicationAssignments));
        }

        /**
         * @param instanceArn ARN of the instance of IAM Identity Center.
         * 
         * @return builder
         * 
         */
        public Builder instanceArn(String instanceArn) {
            $.instanceArn = instanceArn;
            return this;
        }

        /**
         * @param principalId An identifier for an object in IAM Identity Center, such as a user or group.
         * 
         * @return builder
         * 
         */
        public Builder principalId(String principalId) {
            $.principalId = principalId;
            return this;
        }

        /**
         * @param principalType Entity type for which the assignment will be created. Valid values are `USER` or `GROUP`.
         * 
         * @return builder
         * 
         */
        public Builder principalType(String principalType) {
            $.principalType = principalType;
            return this;
        }

        public GetPrincipalApplicationAssignmentsPlainArgs build() {
            if ($.instanceArn == null) {
                throw new MissingRequiredPropertyException("GetPrincipalApplicationAssignmentsPlainArgs", "instanceArn");
            }
            if ($.principalId == null) {
                throw new MissingRequiredPropertyException("GetPrincipalApplicationAssignmentsPlainArgs", "principalId");
            }
            if ($.principalType == null) {
                throw new MissingRequiredPropertyException("GetPrincipalApplicationAssignmentsPlainArgs", "principalType");
            }
            return $;
        }
    }

}
