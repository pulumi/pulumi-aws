// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.vpclattice.outputs;

import com.pulumi.aws.vpclattice.outputs.ListenerRuleMatchHttpMatchPathMatchMatch;
import com.pulumi.core.annotations.CustomType;
import java.lang.Boolean;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ListenerRuleMatchHttpMatchPathMatch {
    /**
     * @return Indicates whether the match is case sensitive. Defaults to false.
     * 
     */
    private @Nullable Boolean caseSensitive;
    /**
     * @return The header match type.
     * 
     */
    private ListenerRuleMatchHttpMatchPathMatchMatch match;

    private ListenerRuleMatchHttpMatchPathMatch() {}
    /**
     * @return Indicates whether the match is case sensitive. Defaults to false.
     * 
     */
    public Optional<Boolean> caseSensitive() {
        return Optional.ofNullable(this.caseSensitive);
    }
    /**
     * @return The header match type.
     * 
     */
    public ListenerRuleMatchHttpMatchPathMatchMatch match() {
        return this.match;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ListenerRuleMatchHttpMatchPathMatch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean caseSensitive;
        private ListenerRuleMatchHttpMatchPathMatchMatch match;
        public Builder() {}
        public Builder(ListenerRuleMatchHttpMatchPathMatch defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.caseSensitive = defaults.caseSensitive;
    	      this.match = defaults.match;
        }

        @CustomType.Setter
        public Builder caseSensitive(@Nullable Boolean caseSensitive) {
            this.caseSensitive = caseSensitive;
            return this;
        }
        @CustomType.Setter
        public Builder match(ListenerRuleMatchHttpMatchPathMatchMatch match) {
            this.match = Objects.requireNonNull(match);
            return this;
        }
        public ListenerRuleMatchHttpMatchPathMatch build() {
            final var o = new ListenerRuleMatchHttpMatchPathMatch();
            o.caseSensitive = caseSensitive;
            o.match = match;
            return o;
        }
    }
}