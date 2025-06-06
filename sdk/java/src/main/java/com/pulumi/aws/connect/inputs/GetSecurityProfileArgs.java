// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.connect.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetSecurityProfileArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetSecurityProfileArgs Empty = new GetSecurityProfileArgs();

    /**
     * Reference to the hosting Amazon Connect Instance
     * 
     */
    @Import(name="instanceId", required=true)
    private Output<String> instanceId;

    /**
     * @return Reference to the hosting Amazon Connect Instance
     * 
     */
    public Output<String> instanceId() {
        return this.instanceId;
    }

    /**
     * Returns information on a specific Security Profile by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `security_profile_id` is required.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Returns information on a specific Security Profile by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `security_profile_id` is required.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Returns information on a specific Security Profile by Security Profile id
     * 
     */
    @Import(name="securityProfileId")
    private @Nullable Output<String> securityProfileId;

    /**
     * @return Returns information on a specific Security Profile by Security Profile id
     * 
     */
    public Optional<Output<String>> securityProfileId() {
        return Optional.ofNullable(this.securityProfileId);
    }

    /**
     * Map of tags to assign to the Security Profile.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the Security Profile.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetSecurityProfileArgs() {}

    private GetSecurityProfileArgs(GetSecurityProfileArgs $) {
        this.instanceId = $.instanceId;
        this.name = $.name;
        this.securityProfileId = $.securityProfileId;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetSecurityProfileArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetSecurityProfileArgs $;

        public Builder() {
            $ = new GetSecurityProfileArgs();
        }

        public Builder(GetSecurityProfileArgs defaults) {
            $ = new GetSecurityProfileArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param instanceId Reference to the hosting Amazon Connect Instance
         * 
         * @return builder
         * 
         */
        public Builder instanceId(Output<String> instanceId) {
            $.instanceId = instanceId;
            return this;
        }

        /**
         * @param instanceId Reference to the hosting Amazon Connect Instance
         * 
         * @return builder
         * 
         */
        public Builder instanceId(String instanceId) {
            return instanceId(Output.of(instanceId));
        }

        /**
         * @param name Returns information on a specific Security Profile by name
         * 
         * &gt; **NOTE:** `instance_id` and one of either `name` or `security_profile_id` is required.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Returns information on a specific Security Profile by name
         * 
         * &gt; **NOTE:** `instance_id` and one of either `name` or `security_profile_id` is required.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param securityProfileId Returns information on a specific Security Profile by Security Profile id
         * 
         * @return builder
         * 
         */
        public Builder securityProfileId(@Nullable Output<String> securityProfileId) {
            $.securityProfileId = securityProfileId;
            return this;
        }

        /**
         * @param securityProfileId Returns information on a specific Security Profile by Security Profile id
         * 
         * @return builder
         * 
         */
        public Builder securityProfileId(String securityProfileId) {
            return securityProfileId(Output.of(securityProfileId));
        }

        /**
         * @param tags Map of tags to assign to the Security Profile.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags to assign to the Security Profile.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public GetSecurityProfileArgs build() {
            if ($.instanceId == null) {
                throw new MissingRequiredPropertyException("GetSecurityProfileArgs", "instanceId");
            }
            return $;
        }
    }

}
