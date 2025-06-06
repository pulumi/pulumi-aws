// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.securitylake.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class SubscriberNotificationConfigurationHttpsNotificationConfiguration {
    /**
     * @return The API key name for the notification subscription.
     * 
     */
    private @Nullable String authorizationApiKeyName;
    /**
     * @return The API key value for the notification subscription.
     * 
     */
    private @Nullable String authorizationApiKeyValue;
    /**
     * @return The subscription endpoint in Security Lake.
     * If you prefer notification with an HTTPS endpoint, populate this field.
     * 
     */
    private String endpoint;
    /**
     * @return The HTTP method used for the notification subscription.
     * Valid values are `POST` and `PUT`.
     * 
     */
    private @Nullable String httpMethod;
    /**
     * @return The Amazon Resource Name (ARN) of the EventBridge API destinations IAM role that you created.
     * For more information about ARNs and how to use them in policies, see Managing data access and AWS Managed Policies in the Amazon Security Lake User Guide.
     * 
     */
    private String targetRoleArn;

    private SubscriberNotificationConfigurationHttpsNotificationConfiguration() {}
    /**
     * @return The API key name for the notification subscription.
     * 
     */
    public Optional<String> authorizationApiKeyName() {
        return Optional.ofNullable(this.authorizationApiKeyName);
    }
    /**
     * @return The API key value for the notification subscription.
     * 
     */
    public Optional<String> authorizationApiKeyValue() {
        return Optional.ofNullable(this.authorizationApiKeyValue);
    }
    /**
     * @return The subscription endpoint in Security Lake.
     * If you prefer notification with an HTTPS endpoint, populate this field.
     * 
     */
    public String endpoint() {
        return this.endpoint;
    }
    /**
     * @return The HTTP method used for the notification subscription.
     * Valid values are `POST` and `PUT`.
     * 
     */
    public Optional<String> httpMethod() {
        return Optional.ofNullable(this.httpMethod);
    }
    /**
     * @return The Amazon Resource Name (ARN) of the EventBridge API destinations IAM role that you created.
     * For more information about ARNs and how to use them in policies, see Managing data access and AWS Managed Policies in the Amazon Security Lake User Guide.
     * 
     */
    public String targetRoleArn() {
        return this.targetRoleArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(SubscriberNotificationConfigurationHttpsNotificationConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String authorizationApiKeyName;
        private @Nullable String authorizationApiKeyValue;
        private String endpoint;
        private @Nullable String httpMethod;
        private String targetRoleArn;
        public Builder() {}
        public Builder(SubscriberNotificationConfigurationHttpsNotificationConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.authorizationApiKeyName = defaults.authorizationApiKeyName;
    	      this.authorizationApiKeyValue = defaults.authorizationApiKeyValue;
    	      this.endpoint = defaults.endpoint;
    	      this.httpMethod = defaults.httpMethod;
    	      this.targetRoleArn = defaults.targetRoleArn;
        }

        @CustomType.Setter
        public Builder authorizationApiKeyName(@Nullable String authorizationApiKeyName) {

            this.authorizationApiKeyName = authorizationApiKeyName;
            return this;
        }
        @CustomType.Setter
        public Builder authorizationApiKeyValue(@Nullable String authorizationApiKeyValue) {

            this.authorizationApiKeyValue = authorizationApiKeyValue;
            return this;
        }
        @CustomType.Setter
        public Builder endpoint(String endpoint) {
            if (endpoint == null) {
              throw new MissingRequiredPropertyException("SubscriberNotificationConfigurationHttpsNotificationConfiguration", "endpoint");
            }
            this.endpoint = endpoint;
            return this;
        }
        @CustomType.Setter
        public Builder httpMethod(@Nullable String httpMethod) {

            this.httpMethod = httpMethod;
            return this;
        }
        @CustomType.Setter
        public Builder targetRoleArn(String targetRoleArn) {
            if (targetRoleArn == null) {
              throw new MissingRequiredPropertyException("SubscriberNotificationConfigurationHttpsNotificationConfiguration", "targetRoleArn");
            }
            this.targetRoleArn = targetRoleArn;
            return this;
        }
        public SubscriberNotificationConfigurationHttpsNotificationConfiguration build() {
            final var _resultValue = new SubscriberNotificationConfigurationHttpsNotificationConfiguration();
            _resultValue.authorizationApiKeyName = authorizationApiKeyName;
            _resultValue.authorizationApiKeyValue = authorizationApiKeyValue;
            _resultValue.endpoint = endpoint;
            _resultValue.httpMethod = httpMethod;
            _resultValue.targetRoleArn = targetRoleArn;
            return _resultValue;
        }
    }
}
