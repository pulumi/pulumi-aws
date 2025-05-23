// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.vpclattice.inputs;

import com.pulumi.aws.vpclattice.inputs.ListenerRuleMatchHttpMatchHeaderMatchArgs;
import com.pulumi.aws.vpclattice.inputs.ListenerRuleMatchHttpMatchPathMatchArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ListenerRuleMatchHttpMatchArgs extends com.pulumi.resources.ResourceArgs {

    public static final ListenerRuleMatchHttpMatchArgs Empty = new ListenerRuleMatchHttpMatchArgs();

    /**
     * The header matches.
     * Matches incoming requests with rule based on request header value before applying rule action.
     * See `header_matches` Block for details.
     * 
     */
    @Import(name="headerMatches")
    private @Nullable Output<List<ListenerRuleMatchHttpMatchHeaderMatchArgs>> headerMatches;

    /**
     * @return The header matches.
     * Matches incoming requests with rule based on request header value before applying rule action.
     * See `header_matches` Block for details.
     * 
     */
    public Optional<Output<List<ListenerRuleMatchHttpMatchHeaderMatchArgs>>> headerMatches() {
        return Optional.ofNullable(this.headerMatches);
    }

    /**
     * The HTTP method type.
     * 
     */
    @Import(name="method")
    private @Nullable Output<String> method;

    /**
     * @return The HTTP method type.
     * 
     */
    public Optional<Output<String>> method() {
        return Optional.ofNullable(this.method);
    }

    /**
     * The path match.
     * See `path_match` Block for details.
     * 
     */
    @Import(name="pathMatch")
    private @Nullable Output<ListenerRuleMatchHttpMatchPathMatchArgs> pathMatch;

    /**
     * @return The path match.
     * See `path_match` Block for details.
     * 
     */
    public Optional<Output<ListenerRuleMatchHttpMatchPathMatchArgs>> pathMatch() {
        return Optional.ofNullable(this.pathMatch);
    }

    private ListenerRuleMatchHttpMatchArgs() {}

    private ListenerRuleMatchHttpMatchArgs(ListenerRuleMatchHttpMatchArgs $) {
        this.headerMatches = $.headerMatches;
        this.method = $.method;
        this.pathMatch = $.pathMatch;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ListenerRuleMatchHttpMatchArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ListenerRuleMatchHttpMatchArgs $;

        public Builder() {
            $ = new ListenerRuleMatchHttpMatchArgs();
        }

        public Builder(ListenerRuleMatchHttpMatchArgs defaults) {
            $ = new ListenerRuleMatchHttpMatchArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param headerMatches The header matches.
         * Matches incoming requests with rule based on request header value before applying rule action.
         * See `header_matches` Block for details.
         * 
         * @return builder
         * 
         */
        public Builder headerMatches(@Nullable Output<List<ListenerRuleMatchHttpMatchHeaderMatchArgs>> headerMatches) {
            $.headerMatches = headerMatches;
            return this;
        }

        /**
         * @param headerMatches The header matches.
         * Matches incoming requests with rule based on request header value before applying rule action.
         * See `header_matches` Block for details.
         * 
         * @return builder
         * 
         */
        public Builder headerMatches(List<ListenerRuleMatchHttpMatchHeaderMatchArgs> headerMatches) {
            return headerMatches(Output.of(headerMatches));
        }

        /**
         * @param headerMatches The header matches.
         * Matches incoming requests with rule based on request header value before applying rule action.
         * See `header_matches` Block for details.
         * 
         * @return builder
         * 
         */
        public Builder headerMatches(ListenerRuleMatchHttpMatchHeaderMatchArgs... headerMatches) {
            return headerMatches(List.of(headerMatches));
        }

        /**
         * @param method The HTTP method type.
         * 
         * @return builder
         * 
         */
        public Builder method(@Nullable Output<String> method) {
            $.method = method;
            return this;
        }

        /**
         * @param method The HTTP method type.
         * 
         * @return builder
         * 
         */
        public Builder method(String method) {
            return method(Output.of(method));
        }

        /**
         * @param pathMatch The path match.
         * See `path_match` Block for details.
         * 
         * @return builder
         * 
         */
        public Builder pathMatch(@Nullable Output<ListenerRuleMatchHttpMatchPathMatchArgs> pathMatch) {
            $.pathMatch = pathMatch;
            return this;
        }

        /**
         * @param pathMatch The path match.
         * See `path_match` Block for details.
         * 
         * @return builder
         * 
         */
        public Builder pathMatch(ListenerRuleMatchHttpMatchPathMatchArgs pathMatch) {
            return pathMatch(Output.of(pathMatch));
        }

        public ListenerRuleMatchHttpMatchArgs build() {
            return $;
        }
    }

}
