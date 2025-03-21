// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cognito.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Boolean;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class UserPoolDeviceConfiguration {
    /**
     * @return Whether a challenge is required on a new device. Only applicable to a new device.
     * 
     */
    private @Nullable Boolean challengeRequiredOnNewDevice;
    /**
     * @return Whether a device is only remembered on user prompt. `false` equates to &#34;Always&#34; remember, `true` is &#34;User Opt In,&#34; and not using a `device_configuration` block is &#34;No.&#34;
     * 
     */
    private @Nullable Boolean deviceOnlyRememberedOnUserPrompt;

    private UserPoolDeviceConfiguration() {}
    /**
     * @return Whether a challenge is required on a new device. Only applicable to a new device.
     * 
     */
    public Optional<Boolean> challengeRequiredOnNewDevice() {
        return Optional.ofNullable(this.challengeRequiredOnNewDevice);
    }
    /**
     * @return Whether a device is only remembered on user prompt. `false` equates to &#34;Always&#34; remember, `true` is &#34;User Opt In,&#34; and not using a `device_configuration` block is &#34;No.&#34;
     * 
     */
    public Optional<Boolean> deviceOnlyRememberedOnUserPrompt() {
        return Optional.ofNullable(this.deviceOnlyRememberedOnUserPrompt);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(UserPoolDeviceConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean challengeRequiredOnNewDevice;
        private @Nullable Boolean deviceOnlyRememberedOnUserPrompt;
        public Builder() {}
        public Builder(UserPoolDeviceConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.challengeRequiredOnNewDevice = defaults.challengeRequiredOnNewDevice;
    	      this.deviceOnlyRememberedOnUserPrompt = defaults.deviceOnlyRememberedOnUserPrompt;
        }

        @CustomType.Setter
        public Builder challengeRequiredOnNewDevice(@Nullable Boolean challengeRequiredOnNewDevice) {

            this.challengeRequiredOnNewDevice = challengeRequiredOnNewDevice;
            return this;
        }
        @CustomType.Setter
        public Builder deviceOnlyRememberedOnUserPrompt(@Nullable Boolean deviceOnlyRememberedOnUserPrompt) {

            this.deviceOnlyRememberedOnUserPrompt = deviceOnlyRememberedOnUserPrompt;
            return this;
        }
        public UserPoolDeviceConfiguration build() {
            final var _resultValue = new UserPoolDeviceConfiguration();
            _resultValue.challengeRequiredOnNewDevice = challengeRequiredOnNewDevice;
            _resultValue.deviceOnlyRememberedOnUserPrompt = deviceOnlyRememberedOnUserPrompt;
            return _resultValue;
        }
    }
}
