// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssoadmin;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PermissionSetArgs extends com.pulumi.resources.ResourceArgs {

    public static final PermissionSetArgs Empty = new PermissionSetArgs();

    /**
     * The description of the Permission Set.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return The description of the Permission Set.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
     * 
     */
    @Import(name="instanceArn", required=true)
    private Output<String> instanceArn;

    /**
     * @return The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
     * 
     */
    public Output<String> instanceArn() {
        return this.instanceArn;
    }

    /**
     * The name of the Permission Set.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The name of the Permission Set.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * The relay state URL used to redirect users within the application during the federation authentication process.
     * 
     */
    @Import(name="relayState")
    private @Nullable Output<String> relayState;

    /**
     * @return The relay state URL used to redirect users within the application during the federation authentication process.
     * 
     */
    public Optional<Output<String>> relayState() {
        return Optional.ofNullable(this.relayState);
    }

    /**
     * The length of time that the application user sessions are valid in the ISO-8601 standard. Default: `PT1H`.
     * 
     */
    @Import(name="sessionDuration")
    private @Nullable Output<String> sessionDuration;

    /**
     * @return The length of time that the application user sessions are valid in the ISO-8601 standard. Default: `PT1H`.
     * 
     */
    public Optional<Output<String>> sessionDuration() {
        return Optional.ofNullable(this.sessionDuration);
    }

    /**
     * Key-value map of resource tags. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Key-value map of resource tags. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private PermissionSetArgs() {}

    private PermissionSetArgs(PermissionSetArgs $) {
        this.description = $.description;
        this.instanceArn = $.instanceArn;
        this.name = $.name;
        this.relayState = $.relayState;
        this.sessionDuration = $.sessionDuration;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PermissionSetArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PermissionSetArgs $;

        public Builder() {
            $ = new PermissionSetArgs();
        }

        public Builder(PermissionSetArgs defaults) {
            $ = new PermissionSetArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param description The description of the Permission Set.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description The description of the Permission Set.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param instanceArn The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
         * 
         * @return builder
         * 
         */
        public Builder instanceArn(Output<String> instanceArn) {
            $.instanceArn = instanceArn;
            return this;
        }

        /**
         * @param instanceArn The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
         * 
         * @return builder
         * 
         */
        public Builder instanceArn(String instanceArn) {
            return instanceArn(Output.of(instanceArn));
        }

        /**
         * @param name The name of the Permission Set.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of the Permission Set.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param relayState The relay state URL used to redirect users within the application during the federation authentication process.
         * 
         * @return builder
         * 
         */
        public Builder relayState(@Nullable Output<String> relayState) {
            $.relayState = relayState;
            return this;
        }

        /**
         * @param relayState The relay state URL used to redirect users within the application during the federation authentication process.
         * 
         * @return builder
         * 
         */
        public Builder relayState(String relayState) {
            return relayState(Output.of(relayState));
        }

        /**
         * @param sessionDuration The length of time that the application user sessions are valid in the ISO-8601 standard. Default: `PT1H`.
         * 
         * @return builder
         * 
         */
        public Builder sessionDuration(@Nullable Output<String> sessionDuration) {
            $.sessionDuration = sessionDuration;
            return this;
        }

        /**
         * @param sessionDuration The length of time that the application user sessions are valid in the ISO-8601 standard. Default: `PT1H`.
         * 
         * @return builder
         * 
         */
        public Builder sessionDuration(String sessionDuration) {
            return sessionDuration(Output.of(sessionDuration));
        }

        /**
         * @param tags Key-value map of resource tags. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key-value map of resource tags. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public PermissionSetArgs build() {
            if ($.instanceArn == null) {
                throw new MissingRequiredPropertyException("PermissionSetArgs", "instanceArn");
            }
            return $;
        }
    }

}
