// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch.inputs;

import com.pulumi.aws.cloudwatch.inputs.EventConnectionAuthParametersArgs;
import com.pulumi.aws.cloudwatch.inputs.EventConnectionInvocationConnectivityParametersArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class EventConnectionState extends com.pulumi.resources.ResourceArgs {

    public static final EventConnectionState Empty = new EventConnectionState();

    /**
     * The Amazon Resource Name (ARN) of the connection.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) of the connection.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Parameters used for authorization. A maximum of 1 are allowed. Documented below.
     * 
     */
    @Import(name="authParameters")
    private @Nullable Output<EventConnectionAuthParametersArgs> authParameters;

    /**
     * @return Parameters used for authorization. A maximum of 1 are allowed. Documented below.
     * 
     */
    public Optional<Output<EventConnectionAuthParametersArgs>> authParameters() {
        return Optional.ofNullable(this.authParameters);
    }

    /**
     * Type of authorization to use for the connection. One of `API_KEY`,`BASIC`,`OAUTH_CLIENT_CREDENTIALS`.
     * 
     */
    @Import(name="authorizationType")
    private @Nullable Output<String> authorizationType;

    /**
     * @return Type of authorization to use for the connection. One of `API_KEY`,`BASIC`,`OAUTH_CLIENT_CREDENTIALS`.
     * 
     */
    public Optional<Output<String>> authorizationType() {
        return Optional.ofNullable(this.authorizationType);
    }

    /**
     * Description for the connection. Maximum of 512 characters.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return Description for the connection. Maximum of 512 characters.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * Parameters to use for invoking a private API. Documented below.
     * 
     */
    @Import(name="invocationConnectivityParameters")
    private @Nullable Output<EventConnectionInvocationConnectivityParametersArgs> invocationConnectivityParameters;

    /**
     * @return Parameters to use for invoking a private API. Documented below.
     * 
     */
    public Optional<Output<EventConnectionInvocationConnectivityParametersArgs>> invocationConnectivityParameters() {
        return Optional.ofNullable(this.invocationConnectivityParameters);
    }

    /**
     * Identifier of the AWS KMS customer managed key for EventBridge to use, if you choose to use a customer managed key to encrypt this connection. The identifier can be the key Amazon Resource Name (ARN), KeyId, key alias, or key alias ARN.
     * 
     */
    @Import(name="kmsKeyIdentifier")
    private @Nullable Output<String> kmsKeyIdentifier;

    /**
     * @return Identifier of the AWS KMS customer managed key for EventBridge to use, if you choose to use a customer managed key to encrypt this connection. The identifier can be the key Amazon Resource Name (ARN), KeyId, key alias, or key alias ARN.
     * 
     */
    public Optional<Output<String>> kmsKeyIdentifier() {
        return Optional.ofNullable(this.kmsKeyIdentifier);
    }

    /**
     * The name for the connection. Maximum of 64 characters consisting of numbers, lower/upper case letters, .,-,_.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The name for the connection. Maximum of 64 characters consisting of numbers, lower/upper case letters, .,-,_.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * The Amazon Resource Name (ARN) of the secret created from the authorization parameters specified for the connection.
     * 
     */
    @Import(name="secretArn")
    private @Nullable Output<String> secretArn;

    /**
     * @return The Amazon Resource Name (ARN) of the secret created from the authorization parameters specified for the connection.
     * 
     */
    public Optional<Output<String>> secretArn() {
        return Optional.ofNullable(this.secretArn);
    }

    private EventConnectionState() {}

    private EventConnectionState(EventConnectionState $) {
        this.arn = $.arn;
        this.authParameters = $.authParameters;
        this.authorizationType = $.authorizationType;
        this.description = $.description;
        this.invocationConnectivityParameters = $.invocationConnectivityParameters;
        this.kmsKeyIdentifier = $.kmsKeyIdentifier;
        this.name = $.name;
        this.secretArn = $.secretArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EventConnectionState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EventConnectionState $;

        public Builder() {
            $ = new EventConnectionState();
        }

        public Builder(EventConnectionState defaults) {
            $ = new EventConnectionState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn The Amazon Resource Name (ARN) of the connection.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn The Amazon Resource Name (ARN) of the connection.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param authParameters Parameters used for authorization. A maximum of 1 are allowed. Documented below.
         * 
         * @return builder
         * 
         */
        public Builder authParameters(@Nullable Output<EventConnectionAuthParametersArgs> authParameters) {
            $.authParameters = authParameters;
            return this;
        }

        /**
         * @param authParameters Parameters used for authorization. A maximum of 1 are allowed. Documented below.
         * 
         * @return builder
         * 
         */
        public Builder authParameters(EventConnectionAuthParametersArgs authParameters) {
            return authParameters(Output.of(authParameters));
        }

        /**
         * @param authorizationType Type of authorization to use for the connection. One of `API_KEY`,`BASIC`,`OAUTH_CLIENT_CREDENTIALS`.
         * 
         * @return builder
         * 
         */
        public Builder authorizationType(@Nullable Output<String> authorizationType) {
            $.authorizationType = authorizationType;
            return this;
        }

        /**
         * @param authorizationType Type of authorization to use for the connection. One of `API_KEY`,`BASIC`,`OAUTH_CLIENT_CREDENTIALS`.
         * 
         * @return builder
         * 
         */
        public Builder authorizationType(String authorizationType) {
            return authorizationType(Output.of(authorizationType));
        }

        /**
         * @param description Description for the connection. Maximum of 512 characters.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description Description for the connection. Maximum of 512 characters.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param invocationConnectivityParameters Parameters to use for invoking a private API. Documented below.
         * 
         * @return builder
         * 
         */
        public Builder invocationConnectivityParameters(@Nullable Output<EventConnectionInvocationConnectivityParametersArgs> invocationConnectivityParameters) {
            $.invocationConnectivityParameters = invocationConnectivityParameters;
            return this;
        }

        /**
         * @param invocationConnectivityParameters Parameters to use for invoking a private API. Documented below.
         * 
         * @return builder
         * 
         */
        public Builder invocationConnectivityParameters(EventConnectionInvocationConnectivityParametersArgs invocationConnectivityParameters) {
            return invocationConnectivityParameters(Output.of(invocationConnectivityParameters));
        }

        /**
         * @param kmsKeyIdentifier Identifier of the AWS KMS customer managed key for EventBridge to use, if you choose to use a customer managed key to encrypt this connection. The identifier can be the key Amazon Resource Name (ARN), KeyId, key alias, or key alias ARN.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyIdentifier(@Nullable Output<String> kmsKeyIdentifier) {
            $.kmsKeyIdentifier = kmsKeyIdentifier;
            return this;
        }

        /**
         * @param kmsKeyIdentifier Identifier of the AWS KMS customer managed key for EventBridge to use, if you choose to use a customer managed key to encrypt this connection. The identifier can be the key Amazon Resource Name (ARN), KeyId, key alias, or key alias ARN.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyIdentifier(String kmsKeyIdentifier) {
            return kmsKeyIdentifier(Output.of(kmsKeyIdentifier));
        }

        /**
         * @param name The name for the connection. Maximum of 64 characters consisting of numbers, lower/upper case letters, .,-,_.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name for the connection. Maximum of 64 characters consisting of numbers, lower/upper case letters, .,-,_.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param secretArn The Amazon Resource Name (ARN) of the secret created from the authorization parameters specified for the connection.
         * 
         * @return builder
         * 
         */
        public Builder secretArn(@Nullable Output<String> secretArn) {
            $.secretArn = secretArn;
            return this;
        }

        /**
         * @param secretArn The Amazon Resource Name (ARN) of the secret created from the authorization parameters specified for the connection.
         * 
         * @return builder
         * 
         */
        public Builder secretArn(String secretArn) {
            return secretArn(Output.of(secretArn));
        }

        public EventConnectionState build() {
            return $;
        }
    }

}
