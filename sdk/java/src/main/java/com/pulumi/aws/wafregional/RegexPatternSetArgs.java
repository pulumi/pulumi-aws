// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafregional;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RegexPatternSetArgs extends com.pulumi.resources.ResourceArgs {

    public static final RegexPatternSetArgs Empty = new RegexPatternSetArgs();

    /**
     * The name or description of the Regex Pattern Set.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The name or description of the Regex Pattern Set.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * A list of regular expression (regex) patterns that you want AWS WAF to search for, such as `B[a{@literal @}]dB[o0]t`.
     * 
     */
    @Import(name="regexPatternStrings")
    private @Nullable Output<List<String>> regexPatternStrings;

    /**
     * @return A list of regular expression (regex) patterns that you want AWS WAF to search for, such as `B[a{@literal @}]dB[o0]t`.
     * 
     */
    public Optional<Output<List<String>>> regexPatternStrings() {
        return Optional.ofNullable(this.regexPatternStrings);
    }

    private RegexPatternSetArgs() {}

    private RegexPatternSetArgs(RegexPatternSetArgs $) {
        this.name = $.name;
        this.regexPatternStrings = $.regexPatternStrings;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RegexPatternSetArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RegexPatternSetArgs $;

        public Builder() {
            $ = new RegexPatternSetArgs();
        }

        public Builder(RegexPatternSetArgs defaults) {
            $ = new RegexPatternSetArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param name The name or description of the Regex Pattern Set.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name or description of the Regex Pattern Set.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param regexPatternStrings A list of regular expression (regex) patterns that you want AWS WAF to search for, such as `B[a{@literal @}]dB[o0]t`.
         * 
         * @return builder
         * 
         */
        public Builder regexPatternStrings(@Nullable Output<List<String>> regexPatternStrings) {
            $.regexPatternStrings = regexPatternStrings;
            return this;
        }

        /**
         * @param regexPatternStrings A list of regular expression (regex) patterns that you want AWS WAF to search for, such as `B[a{@literal @}]dB[o0]t`.
         * 
         * @return builder
         * 
         */
        public Builder regexPatternStrings(List<String> regexPatternStrings) {
            return regexPatternStrings(Output.of(regexPatternStrings));
        }

        /**
         * @param regexPatternStrings A list of regular expression (regex) patterns that you want AWS WAF to search for, such as `B[a{@literal @}]dB[o0]t`.
         * 
         * @return builder
         * 
         */
        public Builder regexPatternStrings(String... regexPatternStrings) {
            return regexPatternStrings(List.of(regexPatternStrings));
        }

        public RegexPatternSetArgs build() {
            return $;
        }
    }

}
