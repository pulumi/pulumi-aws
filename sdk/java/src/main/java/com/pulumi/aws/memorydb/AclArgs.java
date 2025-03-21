// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.memorydb;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AclArgs extends com.pulumi.resources.ResourceArgs {

    public static final AclArgs Empty = new AclArgs();

    /**
     * Name of the ACL. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name of the ACL. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     * 
     */
    @Import(name="namePrefix")
    private @Nullable Output<String> namePrefix;

    /**
     * @return Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     * 
     */
    public Optional<Output<String>> namePrefix() {
        return Optional.ofNullable(this.namePrefix);
    }

    /**
     * A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * Set of MemoryDB user names to be included in this ACL.
     * 
     */
    @Import(name="userNames")
    private @Nullable Output<List<String>> userNames;

    /**
     * @return Set of MemoryDB user names to be included in this ACL.
     * 
     */
    public Optional<Output<List<String>>> userNames() {
        return Optional.ofNullable(this.userNames);
    }

    private AclArgs() {}

    private AclArgs(AclArgs $) {
        this.name = $.name;
        this.namePrefix = $.namePrefix;
        this.tags = $.tags;
        this.userNames = $.userNames;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AclArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AclArgs $;

        public Builder() {
            $ = new AclArgs();
        }

        public Builder(AclArgs defaults) {
            $ = new AclArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param name Name of the ACL. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the ACL. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param namePrefix Creates a unique name beginning with the specified prefix. Conflicts with `name`.
         * 
         * @return builder
         * 
         */
        public Builder namePrefix(@Nullable Output<String> namePrefix) {
            $.namePrefix = namePrefix;
            return this;
        }

        /**
         * @param namePrefix Creates a unique name beginning with the specified prefix. Conflicts with `name`.
         * 
         * @return builder
         * 
         */
        public Builder namePrefix(String namePrefix) {
            return namePrefix(Output.of(namePrefix));
        }

        /**
         * @param tags A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param userNames Set of MemoryDB user names to be included in this ACL.
         * 
         * @return builder
         * 
         */
        public Builder userNames(@Nullable Output<List<String>> userNames) {
            $.userNames = userNames;
            return this;
        }

        /**
         * @param userNames Set of MemoryDB user names to be included in this ACL.
         * 
         * @return builder
         * 
         */
        public Builder userNames(List<String> userNames) {
            return userNames(Output.of(userNames));
        }

        /**
         * @param userNames Set of MemoryDB user names to be included in this ACL.
         * 
         * @return builder
         * 
         */
        public Builder userNames(String... userNames) {
            return userNames(List.of(userNames));
        }

        public AclArgs build() {
            return $;
        }
    }

}
