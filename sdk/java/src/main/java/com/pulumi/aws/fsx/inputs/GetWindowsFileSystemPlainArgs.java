// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.fsx.inputs;

import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetWindowsFileSystemPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetWindowsFileSystemPlainArgs Empty = new GetWindowsFileSystemPlainArgs();

    /**
     * Identifier of the file system (e.g. `fs-12345678`).
     * 
     */
    @Import(name="id", required=true)
    private String id;

    /**
     * @return Identifier of the file system (e.g. `fs-12345678`).
     * 
     */
    public String id() {
        return this.id;
    }

    /**
     * The tags to associate with the file system.
     * 
     */
    @Import(name="tags")
    private @Nullable Map<String,String> tags;

    /**
     * @return The tags to associate with the file system.
     * 
     */
    public Optional<Map<String,String>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetWindowsFileSystemPlainArgs() {}

    private GetWindowsFileSystemPlainArgs(GetWindowsFileSystemPlainArgs $) {
        this.id = $.id;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetWindowsFileSystemPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetWindowsFileSystemPlainArgs $;

        public Builder() {
            $ = new GetWindowsFileSystemPlainArgs();
        }

        public Builder(GetWindowsFileSystemPlainArgs defaults) {
            $ = new GetWindowsFileSystemPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param id Identifier of the file system (e.g. `fs-12345678`).
         * 
         * @return builder
         * 
         */
        public Builder id(String id) {
            $.id = id;
            return this;
        }

        /**
         * @param tags The tags to associate with the file system.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Map<String,String> tags) {
            $.tags = tags;
            return this;
        }

        public GetWindowsFileSystemPlainArgs build() {
            $.id = Objects.requireNonNull($.id, "expected parameter 'id' to be non-null");
            return $;
        }
    }

}