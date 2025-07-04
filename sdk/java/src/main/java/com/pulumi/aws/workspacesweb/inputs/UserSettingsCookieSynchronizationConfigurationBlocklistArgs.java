// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.workspacesweb.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class UserSettingsCookieSynchronizationConfigurationBlocklistArgs extends com.pulumi.resources.ResourceArgs {

    public static final UserSettingsCookieSynchronizationConfigurationBlocklistArgs Empty = new UserSettingsCookieSynchronizationConfigurationBlocklistArgs();

    /**
     * Domain of the cookie.
     * 
     */
    @Import(name="domain", required=true)
    private Output<String> domain;

    /**
     * @return Domain of the cookie.
     * 
     */
    public Output<String> domain() {
        return this.domain;
    }

    /**
     * Name of the cookie.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name of the cookie.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Path of the cookie.
     * 
     */
    @Import(name="path")
    private @Nullable Output<String> path;

    /**
     * @return Path of the cookie.
     * 
     */
    public Optional<Output<String>> path() {
        return Optional.ofNullable(this.path);
    }

    private UserSettingsCookieSynchronizationConfigurationBlocklistArgs() {}

    private UserSettingsCookieSynchronizationConfigurationBlocklistArgs(UserSettingsCookieSynchronizationConfigurationBlocklistArgs $) {
        this.domain = $.domain;
        this.name = $.name;
        this.path = $.path;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(UserSettingsCookieSynchronizationConfigurationBlocklistArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private UserSettingsCookieSynchronizationConfigurationBlocklistArgs $;

        public Builder() {
            $ = new UserSettingsCookieSynchronizationConfigurationBlocklistArgs();
        }

        public Builder(UserSettingsCookieSynchronizationConfigurationBlocklistArgs defaults) {
            $ = new UserSettingsCookieSynchronizationConfigurationBlocklistArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param domain Domain of the cookie.
         * 
         * @return builder
         * 
         */
        public Builder domain(Output<String> domain) {
            $.domain = domain;
            return this;
        }

        /**
         * @param domain Domain of the cookie.
         * 
         * @return builder
         * 
         */
        public Builder domain(String domain) {
            return domain(Output.of(domain));
        }

        /**
         * @param name Name of the cookie.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the cookie.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param path Path of the cookie.
         * 
         * @return builder
         * 
         */
        public Builder path(@Nullable Output<String> path) {
            $.path = path;
            return this;
        }

        /**
         * @param path Path of the cookie.
         * 
         * @return builder
         * 
         */
        public Builder path(String path) {
            return path(Output.of(path));
        }

        public UserSettingsCookieSynchronizationConfigurationBlocklistArgs build() {
            if ($.domain == null) {
                throw new MissingRequiredPropertyException("UserSettingsCookieSynchronizationConfigurationBlocklistArgs", "domain");
            }
            return $;
        }
    }

}
