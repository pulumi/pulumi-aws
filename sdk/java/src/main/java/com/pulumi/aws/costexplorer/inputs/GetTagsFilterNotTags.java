// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.costexplorer.inputs;

import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetTagsFilterNotTags extends com.pulumi.resources.InvokeArgs {

    public static final GetTagsFilterNotTags Empty = new GetTagsFilterNotTags();

    @Import(name="key")
    private @Nullable String key;

    public Optional<String> key() {
        return Optional.ofNullable(this.key);
    }

    @Import(name="matchOptions")
    private @Nullable List<String> matchOptions;

    public Optional<List<String>> matchOptions() {
        return Optional.ofNullable(this.matchOptions);
    }

    @Import(name="values")
    private @Nullable List<String> values;

    public Optional<List<String>> values() {
        return Optional.ofNullable(this.values);
    }

    private GetTagsFilterNotTags() {}

    private GetTagsFilterNotTags(GetTagsFilterNotTags $) {
        this.key = $.key;
        this.matchOptions = $.matchOptions;
        this.values = $.values;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetTagsFilterNotTags defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetTagsFilterNotTags $;

        public Builder() {
            $ = new GetTagsFilterNotTags();
        }

        public Builder(GetTagsFilterNotTags defaults) {
            $ = new GetTagsFilterNotTags(Objects.requireNonNull(defaults));
        }

        public Builder key(@Nullable String key) {
            $.key = key;
            return this;
        }

        public Builder matchOptions(@Nullable List<String> matchOptions) {
            $.matchOptions = matchOptions;
            return this;
        }

        public Builder matchOptions(String... matchOptions) {
            return matchOptions(List.of(matchOptions));
        }

        public Builder values(@Nullable List<String> values) {
            $.values = values;
            return this;
        }

        public Builder values(String... values) {
            return values(List.of(values));
        }

        public GetTagsFilterNotTags build() {
            return $;
        }
    }

}
