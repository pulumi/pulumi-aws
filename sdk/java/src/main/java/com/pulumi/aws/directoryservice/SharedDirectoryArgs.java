// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.directoryservice;

import com.pulumi.aws.directoryservice.inputs.SharedDirectoryTargetArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class SharedDirectoryArgs extends com.pulumi.resources.ResourceArgs {

    public static final SharedDirectoryArgs Empty = new SharedDirectoryArgs();

    /**
     * Identifier of the Managed Microsoft AD directory that you want to share with other accounts.
     * 
     */
    @Import(name="directoryId", required=true)
    private Output<String> directoryId;

    /**
     * @return Identifier of the Managed Microsoft AD directory that you want to share with other accounts.
     * 
     */
    public Output<String> directoryId() {
        return this.directoryId;
    }

    /**
     * Method used when sharing a directory. Valid values are `ORGANIZATIONS` and `HANDSHAKE`. Default is `HANDSHAKE`.
     * 
     */
    @Import(name="method")
    private @Nullable Output<String> method;

    /**
     * @return Method used when sharing a directory. Valid values are `ORGANIZATIONS` and `HANDSHAKE`. Default is `HANDSHAKE`.
     * 
     */
    public Optional<Output<String>> method() {
        return Optional.ofNullable(this.method);
    }

    /**
     * Message sent by the directory owner to the directory consumer to help the directory consumer administrator determine whether to approve or reject the share invitation.
     * 
     */
    @Import(name="notes")
    private @Nullable Output<String> notes;

    /**
     * @return Message sent by the directory owner to the directory consumer to help the directory consumer administrator determine whether to approve or reject the share invitation.
     * 
     */
    public Optional<Output<String>> notes() {
        return Optional.ofNullable(this.notes);
    }

    /**
     * Identifier for the directory consumer account with whom the directory is to be shared. See below.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="target", required=true)
    private Output<SharedDirectoryTargetArgs> target;

    /**
     * @return Identifier for the directory consumer account with whom the directory is to be shared. See below.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<SharedDirectoryTargetArgs> target() {
        return this.target;
    }

    private SharedDirectoryArgs() {}

    private SharedDirectoryArgs(SharedDirectoryArgs $) {
        this.directoryId = $.directoryId;
        this.method = $.method;
        this.notes = $.notes;
        this.target = $.target;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(SharedDirectoryArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private SharedDirectoryArgs $;

        public Builder() {
            $ = new SharedDirectoryArgs();
        }

        public Builder(SharedDirectoryArgs defaults) {
            $ = new SharedDirectoryArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param directoryId Identifier of the Managed Microsoft AD directory that you want to share with other accounts.
         * 
         * @return builder
         * 
         */
        public Builder directoryId(Output<String> directoryId) {
            $.directoryId = directoryId;
            return this;
        }

        /**
         * @param directoryId Identifier of the Managed Microsoft AD directory that you want to share with other accounts.
         * 
         * @return builder
         * 
         */
        public Builder directoryId(String directoryId) {
            return directoryId(Output.of(directoryId));
        }

        /**
         * @param method Method used when sharing a directory. Valid values are `ORGANIZATIONS` and `HANDSHAKE`. Default is `HANDSHAKE`.
         * 
         * @return builder
         * 
         */
        public Builder method(@Nullable Output<String> method) {
            $.method = method;
            return this;
        }

        /**
         * @param method Method used when sharing a directory. Valid values are `ORGANIZATIONS` and `HANDSHAKE`. Default is `HANDSHAKE`.
         * 
         * @return builder
         * 
         */
        public Builder method(String method) {
            return method(Output.of(method));
        }

        /**
         * @param notes Message sent by the directory owner to the directory consumer to help the directory consumer administrator determine whether to approve or reject the share invitation.
         * 
         * @return builder
         * 
         */
        public Builder notes(@Nullable Output<String> notes) {
            $.notes = notes;
            return this;
        }

        /**
         * @param notes Message sent by the directory owner to the directory consumer to help the directory consumer administrator determine whether to approve or reject the share invitation.
         * 
         * @return builder
         * 
         */
        public Builder notes(String notes) {
            return notes(Output.of(notes));
        }

        /**
         * @param target Identifier for the directory consumer account with whom the directory is to be shared. See below.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder target(Output<SharedDirectoryTargetArgs> target) {
            $.target = target;
            return this;
        }

        /**
         * @param target Identifier for the directory consumer account with whom the directory is to be shared. See below.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder target(SharedDirectoryTargetArgs target) {
            return target(Output.of(target));
        }

        public SharedDirectoryArgs build() {
            if ($.directoryId == null) {
                throw new MissingRequiredPropertyException("SharedDirectoryArgs", "directoryId");
            }
            if ($.target == null) {
                throw new MissingRequiredPropertyException("SharedDirectoryArgs", "target");
            }
            return $;
        }
    }

}
