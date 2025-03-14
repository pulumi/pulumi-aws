// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.opensearch.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ServerlessAccessPolicyState extends com.pulumi.resources.ResourceArgs {

    public static final ServerlessAccessPolicyState Empty = new ServerlessAccessPolicyState();

    /**
     * Description of the policy. Typically used to store information about the permissions defined in the policy.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return Description of the policy. Typically used to store information about the permissions defined in the policy.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * Name of the policy.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name of the policy.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * JSON policy document to use as the content for the new policy
     * 
     */
    @Import(name="policy")
    private @Nullable Output<String> policy;

    /**
     * @return JSON policy document to use as the content for the new policy
     * 
     */
    public Optional<Output<String>> policy() {
        return Optional.ofNullable(this.policy);
    }

    /**
     * Version of the policy.
     * 
     */
    @Import(name="policyVersion")
    private @Nullable Output<String> policyVersion;

    /**
     * @return Version of the policy.
     * 
     */
    public Optional<Output<String>> policyVersion() {
        return Optional.ofNullable(this.policyVersion);
    }

    /**
     * Type of access policy. Must be `data`.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="type")
    private @Nullable Output<String> type;

    /**
     * @return Type of access policy. Must be `data`.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<String>> type() {
        return Optional.ofNullable(this.type);
    }

    private ServerlessAccessPolicyState() {}

    private ServerlessAccessPolicyState(ServerlessAccessPolicyState $) {
        this.description = $.description;
        this.name = $.name;
        this.policy = $.policy;
        this.policyVersion = $.policyVersion;
        this.type = $.type;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ServerlessAccessPolicyState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ServerlessAccessPolicyState $;

        public Builder() {
            $ = new ServerlessAccessPolicyState();
        }

        public Builder(ServerlessAccessPolicyState defaults) {
            $ = new ServerlessAccessPolicyState(Objects.requireNonNull(defaults));
        }

        /**
         * @param description Description of the policy. Typically used to store information about the permissions defined in the policy.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description Description of the policy. Typically used to store information about the permissions defined in the policy.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param name Name of the policy.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the policy.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param policy JSON policy document to use as the content for the new policy
         * 
         * @return builder
         * 
         */
        public Builder policy(@Nullable Output<String> policy) {
            $.policy = policy;
            return this;
        }

        /**
         * @param policy JSON policy document to use as the content for the new policy
         * 
         * @return builder
         * 
         */
        public Builder policy(String policy) {
            return policy(Output.of(policy));
        }

        /**
         * @param policyVersion Version of the policy.
         * 
         * @return builder
         * 
         */
        public Builder policyVersion(@Nullable Output<String> policyVersion) {
            $.policyVersion = policyVersion;
            return this;
        }

        /**
         * @param policyVersion Version of the policy.
         * 
         * @return builder
         * 
         */
        public Builder policyVersion(String policyVersion) {
            return policyVersion(Output.of(policyVersion));
        }

        /**
         * @param type Type of access policy. Must be `data`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder type(@Nullable Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type Type of access policy. Must be `data`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        public ServerlessAccessPolicyState build() {
            return $;
        }
    }

}
