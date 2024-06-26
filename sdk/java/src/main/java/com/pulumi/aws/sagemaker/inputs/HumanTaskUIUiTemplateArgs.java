// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class HumanTaskUIUiTemplateArgs extends com.pulumi.resources.ResourceArgs {

    public static final HumanTaskUIUiTemplateArgs Empty = new HumanTaskUIUiTemplateArgs();

    /**
     * The content of the Liquid template for the worker user interface.
     * 
     */
    @Import(name="content")
    private @Nullable Output<String> content;

    /**
     * @return The content of the Liquid template for the worker user interface.
     * 
     */
    public Optional<Output<String>> content() {
        return Optional.ofNullable(this.content);
    }

    /**
     * The SHA-256 digest of the contents of the template.
     * 
     */
    @Import(name="contentSha256")
    private @Nullable Output<String> contentSha256;

    /**
     * @return The SHA-256 digest of the contents of the template.
     * 
     */
    public Optional<Output<String>> contentSha256() {
        return Optional.ofNullable(this.contentSha256);
    }

    /**
     * The URL for the user interface template.
     * 
     */
    @Import(name="url")
    private @Nullable Output<String> url;

    /**
     * @return The URL for the user interface template.
     * 
     */
    public Optional<Output<String>> url() {
        return Optional.ofNullable(this.url);
    }

    private HumanTaskUIUiTemplateArgs() {}

    private HumanTaskUIUiTemplateArgs(HumanTaskUIUiTemplateArgs $) {
        this.content = $.content;
        this.contentSha256 = $.contentSha256;
        this.url = $.url;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(HumanTaskUIUiTemplateArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private HumanTaskUIUiTemplateArgs $;

        public Builder() {
            $ = new HumanTaskUIUiTemplateArgs();
        }

        public Builder(HumanTaskUIUiTemplateArgs defaults) {
            $ = new HumanTaskUIUiTemplateArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param content The content of the Liquid template for the worker user interface.
         * 
         * @return builder
         * 
         */
        public Builder content(@Nullable Output<String> content) {
            $.content = content;
            return this;
        }

        /**
         * @param content The content of the Liquid template for the worker user interface.
         * 
         * @return builder
         * 
         */
        public Builder content(String content) {
            return content(Output.of(content));
        }

        /**
         * @param contentSha256 The SHA-256 digest of the contents of the template.
         * 
         * @return builder
         * 
         */
        public Builder contentSha256(@Nullable Output<String> contentSha256) {
            $.contentSha256 = contentSha256;
            return this;
        }

        /**
         * @param contentSha256 The SHA-256 digest of the contents of the template.
         * 
         * @return builder
         * 
         */
        public Builder contentSha256(String contentSha256) {
            return contentSha256(Output.of(contentSha256));
        }

        /**
         * @param url The URL for the user interface template.
         * 
         * @return builder
         * 
         */
        public Builder url(@Nullable Output<String> url) {
            $.url = url;
            return this;
        }

        /**
         * @param url The URL for the user interface template.
         * 
         * @return builder
         * 
         */
        public Builder url(String url) {
            return url(Output.of(url));
        }

        public HumanTaskUIUiTemplateArgs build() {
            return $;
        }
    }

}
