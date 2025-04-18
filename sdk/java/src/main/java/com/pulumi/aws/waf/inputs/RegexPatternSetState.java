// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.waf.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RegexPatternSetState extends com.pulumi.resources.ResourceArgs {

    public static final RegexPatternSetState Empty = new RegexPatternSetState();

    /**
     * Amazon Resource Name (ARN)
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN)
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

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

    private RegexPatternSetState() {}

    private RegexPatternSetState(RegexPatternSetState $) {
        this.arn = $.arn;
        this.name = $.name;
        this.regexPatternStrings = $.regexPatternStrings;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RegexPatternSetState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RegexPatternSetState $;

        public Builder() {
            $ = new RegexPatternSetState();
        }

        public Builder(RegexPatternSetState defaults) {
            $ = new RegexPatternSetState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn Amazon Resource Name (ARN)
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn Amazon Resource Name (ARN)
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
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

        public RegexPatternSetState build() {
            return $;
        }
    }

}
