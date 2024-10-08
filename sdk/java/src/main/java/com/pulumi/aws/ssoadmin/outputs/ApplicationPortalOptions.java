// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssoadmin.outputs;

import com.pulumi.aws.ssoadmin.outputs.ApplicationPortalOptionsSignInOptions;
import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ApplicationPortalOptions {
    /**
     * @return Sign-in options for the access portal. See `sign_in_options` below.
     * 
     */
    private @Nullable ApplicationPortalOptionsSignInOptions signInOptions;
    /**
     * @return Indicates whether this application is visible in the access portal. Valid values are `ENABLED` and `DISABLED`.
     * 
     */
    private @Nullable String visibility;

    private ApplicationPortalOptions() {}
    /**
     * @return Sign-in options for the access portal. See `sign_in_options` below.
     * 
     */
    public Optional<ApplicationPortalOptionsSignInOptions> signInOptions() {
        return Optional.ofNullable(this.signInOptions);
    }
    /**
     * @return Indicates whether this application is visible in the access portal. Valid values are `ENABLED` and `DISABLED`.
     * 
     */
    public Optional<String> visibility() {
        return Optional.ofNullable(this.visibility);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ApplicationPortalOptions defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable ApplicationPortalOptionsSignInOptions signInOptions;
        private @Nullable String visibility;
        public Builder() {}
        public Builder(ApplicationPortalOptions defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.signInOptions = defaults.signInOptions;
    	      this.visibility = defaults.visibility;
        }

        @CustomType.Setter
        public Builder signInOptions(@Nullable ApplicationPortalOptionsSignInOptions signInOptions) {

            this.signInOptions = signInOptions;
            return this;
        }
        @CustomType.Setter
        public Builder visibility(@Nullable String visibility) {

            this.visibility = visibility;
            return this;
        }
        public ApplicationPortalOptions build() {
            final var _resultValue = new ApplicationPortalOptions();
            _resultValue.signInOptions = signInOptions;
            _resultValue.visibility = visibility;
            return _resultValue;
        }
    }
}
