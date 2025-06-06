// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.connect.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetSecurityProfilePlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetSecurityProfilePlainArgs Empty = new GetSecurityProfilePlainArgs();

    /**
     * Reference to the hosting Amazon Connect Instance
     * 
     */
    @Import(name="instanceId", required=true)
    private String instanceId;

    /**
     * @return Reference to the hosting Amazon Connect Instance
     * 
     */
    public String instanceId() {
        return this.instanceId;
    }

    /**
     * Returns information on a specific Security Profile by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `security_profile_id` is required.
     * 
     */
    @Import(name="name")
    private @Nullable String name;

    /**
     * @return Returns information on a specific Security Profile by name
     * 
     * &gt; **NOTE:** `instance_id` and one of either `name` or `security_profile_id` is required.
     * 
     */
    public Optional<String> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Returns information on a specific Security Profile by Security Profile id
     * 
     */
    @Import(name="securityProfileId")
    private @Nullable String securityProfileId;

    /**
     * @return Returns information on a specific Security Profile by Security Profile id
     * 
     */
    public Optional<String> securityProfileId() {
        return Optional.ofNullable(this.securityProfileId);
    }

    /**
     * Map of tags to assign to the Security Profile.
     * 
     */
    @Import(name="tags")
    private @Nullable Map<String,String> tags;

    /**
     * @return Map of tags to assign to the Security Profile.
     * 
     */
    public Optional<Map<String,String>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetSecurityProfilePlainArgs() {}

    private GetSecurityProfilePlainArgs(GetSecurityProfilePlainArgs $) {
        this.instanceId = $.instanceId;
        this.name = $.name;
        this.securityProfileId = $.securityProfileId;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetSecurityProfilePlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetSecurityProfilePlainArgs $;

        public Builder() {
            $ = new GetSecurityProfilePlainArgs();
        }

        public Builder(GetSecurityProfilePlainArgs defaults) {
            $ = new GetSecurityProfilePlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param instanceId Reference to the hosting Amazon Connect Instance
         * 
         * @return builder
         * 
         */
        public Builder instanceId(String instanceId) {
            $.instanceId = instanceId;
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
        public Builder name(@Nullable String name) {
            $.name = name;
            return this;
        }

        /**
         * @param securityProfileId Returns information on a specific Security Profile by Security Profile id
         * 
         * @return builder
         * 
         */
        public Builder securityProfileId(@Nullable String securityProfileId) {
            $.securityProfileId = securityProfileId;
            return this;
        }

        /**
         * @param tags Map of tags to assign to the Security Profile.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Map<String,String> tags) {
            $.tags = tags;
            return this;
        }

        public GetSecurityProfilePlainArgs build() {
            if ($.instanceId == null) {
                throw new MissingRequiredPropertyException("GetSecurityProfilePlainArgs", "instanceId");
            }
            return $;
        }
    }

}
