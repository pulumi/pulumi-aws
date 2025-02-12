// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53.inputs;

import com.pulumi.aws.route53.inputs.ProfilesProfileTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ProfilesProfileState extends com.pulumi.resources.ResourceArgs {

    public static final ProfilesProfileState Empty = new ProfilesProfileState();

    /**
     * ARN of the Profile.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN of the Profile.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Name of the Profile.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name of the Profile.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    @Import(name="ownerId")
    private @Nullable Output<String> ownerId;

    public Optional<Output<String>> ownerId() {
        return Optional.ofNullable(this.ownerId);
    }

    /**
     * Share status of the Profile.
     * 
     */
    @Import(name="shareStatus")
    private @Nullable Output<String> shareStatus;

    /**
     * @return Share status of the Profile.
     * 
     */
    public Optional<Output<String>> shareStatus() {
        return Optional.ofNullable(this.shareStatus);
    }

    /**
     * Status of the Profile.
     * 
     */
    @Import(name="status")
    private @Nullable Output<String> status;

    /**
     * @return Status of the Profile.
     * 
     */
    public Optional<Output<String>> status() {
        return Optional.ofNullable(this.status);
    }

    /**
     * Status message of the Profile.
     * 
     */
    @Import(name="statusMessage")
    private @Nullable Output<String> statusMessage;

    /**
     * @return Status message of the Profile.
     * 
     */
    public Optional<Output<String>> statusMessage() {
        return Optional.ofNullable(this.statusMessage);
    }

    /**
     * Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    @Import(name="timeouts")
    private @Nullable Output<ProfilesProfileTimeoutsArgs> timeouts;

    public Optional<Output<ProfilesProfileTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    private ProfilesProfileState() {}

    private ProfilesProfileState(ProfilesProfileState $) {
        this.arn = $.arn;
        this.name = $.name;
        this.ownerId = $.ownerId;
        this.shareStatus = $.shareStatus;
        this.status = $.status;
        this.statusMessage = $.statusMessage;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
        this.timeouts = $.timeouts;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ProfilesProfileState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ProfilesProfileState $;

        public Builder() {
            $ = new ProfilesProfileState();
        }

        public Builder(ProfilesProfileState defaults) {
            $ = new ProfilesProfileState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn ARN of the Profile.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN of the Profile.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param name Name of the Profile.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the Profile.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        public Builder ownerId(@Nullable Output<String> ownerId) {
            $.ownerId = ownerId;
            return this;
        }

        public Builder ownerId(String ownerId) {
            return ownerId(Output.of(ownerId));
        }

        /**
         * @param shareStatus Share status of the Profile.
         * 
         * @return builder
         * 
         */
        public Builder shareStatus(@Nullable Output<String> shareStatus) {
            $.shareStatus = shareStatus;
            return this;
        }

        /**
         * @param shareStatus Share status of the Profile.
         * 
         * @return builder
         * 
         */
        public Builder shareStatus(String shareStatus) {
            return shareStatus(Output.of(shareStatus));
        }

        /**
         * @param status Status of the Profile.
         * 
         * @return builder
         * 
         */
        public Builder status(@Nullable Output<String> status) {
            $.status = status;
            return this;
        }

        /**
         * @param status Status of the Profile.
         * 
         * @return builder
         * 
         */
        public Builder status(String status) {
            return status(Output.of(status));
        }

        /**
         * @param statusMessage Status message of the Profile.
         * 
         * @return builder
         * 
         */
        public Builder statusMessage(@Nullable Output<String> statusMessage) {
            $.statusMessage = statusMessage;
            return this;
        }

        /**
         * @param statusMessage Status message of the Profile.
         * 
         * @return builder
         * 
         */
        public Builder statusMessage(String statusMessage) {
            return statusMessage(Output.of(statusMessage));
        }

        /**
         * @param tags Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @param tagsAll Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        public Builder timeouts(@Nullable Output<ProfilesProfileTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(ProfilesProfileTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        public ProfilesProfileState build() {
            return $;
        }
    }

}
