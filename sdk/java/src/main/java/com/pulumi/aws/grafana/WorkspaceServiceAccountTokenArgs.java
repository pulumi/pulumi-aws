// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.grafana;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class WorkspaceServiceAccountTokenArgs extends com.pulumi.resources.ResourceArgs {

    public static final WorkspaceServiceAccountTokenArgs Empty = new WorkspaceServiceAccountTokenArgs();

    /**
     * A name for the token to create. The name must be unique within the workspace.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return A name for the token to create. The name must be unique within the workspace.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Sets how long the token will be valid, in seconds. You can set the time up to 30 days in the future.
     * 
     */
    @Import(name="secondsToLive", required=true)
    private Output<Integer> secondsToLive;

    /**
     * @return Sets how long the token will be valid, in seconds. You can set the time up to 30 days in the future.
     * 
     */
    public Output<Integer> secondsToLive() {
        return this.secondsToLive;
    }

    /**
     * The ID of the service account for which to create a token.
     * 
     */
    @Import(name="serviceAccountId", required=true)
    private Output<String> serviceAccountId;

    /**
     * @return The ID of the service account for which to create a token.
     * 
     */
    public Output<String> serviceAccountId() {
        return this.serviceAccountId;
    }

    /**
     * The Grafana workspace with which the service account token is associated.
     * 
     */
    @Import(name="workspaceId", required=true)
    private Output<String> workspaceId;

    /**
     * @return The Grafana workspace with which the service account token is associated.
     * 
     */
    public Output<String> workspaceId() {
        return this.workspaceId;
    }

    private WorkspaceServiceAccountTokenArgs() {}

    private WorkspaceServiceAccountTokenArgs(WorkspaceServiceAccountTokenArgs $) {
        this.name = $.name;
        this.secondsToLive = $.secondsToLive;
        this.serviceAccountId = $.serviceAccountId;
        this.workspaceId = $.workspaceId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(WorkspaceServiceAccountTokenArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private WorkspaceServiceAccountTokenArgs $;

        public Builder() {
            $ = new WorkspaceServiceAccountTokenArgs();
        }

        public Builder(WorkspaceServiceAccountTokenArgs defaults) {
            $ = new WorkspaceServiceAccountTokenArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param name A name for the token to create. The name must be unique within the workspace.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name A name for the token to create. The name must be unique within the workspace.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param secondsToLive Sets how long the token will be valid, in seconds. You can set the time up to 30 days in the future.
         * 
         * @return builder
         * 
         */
        public Builder secondsToLive(Output<Integer> secondsToLive) {
            $.secondsToLive = secondsToLive;
            return this;
        }

        /**
         * @param secondsToLive Sets how long the token will be valid, in seconds. You can set the time up to 30 days in the future.
         * 
         * @return builder
         * 
         */
        public Builder secondsToLive(Integer secondsToLive) {
            return secondsToLive(Output.of(secondsToLive));
        }

        /**
         * @param serviceAccountId The ID of the service account for which to create a token.
         * 
         * @return builder
         * 
         */
        public Builder serviceAccountId(Output<String> serviceAccountId) {
            $.serviceAccountId = serviceAccountId;
            return this;
        }

        /**
         * @param serviceAccountId The ID of the service account for which to create a token.
         * 
         * @return builder
         * 
         */
        public Builder serviceAccountId(String serviceAccountId) {
            return serviceAccountId(Output.of(serviceAccountId));
        }

        /**
         * @param workspaceId The Grafana workspace with which the service account token is associated.
         * 
         * @return builder
         * 
         */
        public Builder workspaceId(Output<String> workspaceId) {
            $.workspaceId = workspaceId;
            return this;
        }

        /**
         * @param workspaceId The Grafana workspace with which the service account token is associated.
         * 
         * @return builder
         * 
         */
        public Builder workspaceId(String workspaceId) {
            return workspaceId(Output.of(workspaceId));
        }

        public WorkspaceServiceAccountTokenArgs build() {
            if ($.secondsToLive == null) {
                throw new MissingRequiredPropertyException("WorkspaceServiceAccountTokenArgs", "secondsToLive");
            }
            if ($.serviceAccountId == null) {
                throw new MissingRequiredPropertyException("WorkspaceServiceAccountTokenArgs", "serviceAccountId");
            }
            if ($.workspaceId == null) {
                throw new MissingRequiredPropertyException("WorkspaceServiceAccountTokenArgs", "workspaceId");
            }
            return $;
        }
    }

}
