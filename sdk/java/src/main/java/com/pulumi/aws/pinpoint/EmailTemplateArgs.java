// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.pinpoint;

import com.pulumi.aws.pinpoint.inputs.EmailTemplateEmailTemplateArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class EmailTemplateArgs extends com.pulumi.resources.ResourceArgs {

    public static final EmailTemplateArgs Empty = new EmailTemplateArgs();

    /**
     * Specifies the content and settings for a message template that can be used in messages that are sent through the email channel. See Email Template
     * 
     */
    @Import(name="emailTemplates")
    private @Nullable Output<List<EmailTemplateEmailTemplateArgs>> emailTemplates;

    /**
     * @return Specifies the content and settings for a message template that can be used in messages that are sent through the email channel. See Email Template
     * 
     */
    public Optional<Output<List<EmailTemplateEmailTemplateArgs>>> emailTemplates() {
        return Optional.ofNullable(this.emailTemplates);
    }

    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * name of the message template. A template name must start with an alphanumeric character and can contain a maximum of 128 characters. The characters can be alphanumeric characters, underscores (_), or hyphens (-). Template names are case sensitive.
     * 
     */
    @Import(name="templateName", required=true)
    private Output<String> templateName;

    /**
     * @return name of the message template. A template name must start with an alphanumeric character and can contain a maximum of 128 characters. The characters can be alphanumeric characters, underscores (_), or hyphens (-). Template names are case sensitive.
     * 
     */
    public Output<String> templateName() {
        return this.templateName;
    }

    private EmailTemplateArgs() {}

    private EmailTemplateArgs(EmailTemplateArgs $) {
        this.emailTemplates = $.emailTemplates;
        this.tags = $.tags;
        this.templateName = $.templateName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EmailTemplateArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EmailTemplateArgs $;

        public Builder() {
            $ = new EmailTemplateArgs();
        }

        public Builder(EmailTemplateArgs defaults) {
            $ = new EmailTemplateArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param emailTemplates Specifies the content and settings for a message template that can be used in messages that are sent through the email channel. See Email Template
         * 
         * @return builder
         * 
         */
        public Builder emailTemplates(@Nullable Output<List<EmailTemplateEmailTemplateArgs>> emailTemplates) {
            $.emailTemplates = emailTemplates;
            return this;
        }

        /**
         * @param emailTemplates Specifies the content and settings for a message template that can be used in messages that are sent through the email channel. See Email Template
         * 
         * @return builder
         * 
         */
        public Builder emailTemplates(List<EmailTemplateEmailTemplateArgs> emailTemplates) {
            return emailTemplates(Output.of(emailTemplates));
        }

        /**
         * @param emailTemplates Specifies the content and settings for a message template that can be used in messages that are sent through the email channel. See Email Template
         * 
         * @return builder
         * 
         */
        public Builder emailTemplates(EmailTemplateEmailTemplateArgs... emailTemplates) {
            return emailTemplates(List.of(emailTemplates));
        }

        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param templateName name of the message template. A template name must start with an alphanumeric character and can contain a maximum of 128 characters. The characters can be alphanumeric characters, underscores (_), or hyphens (-). Template names are case sensitive.
         * 
         * @return builder
         * 
         */
        public Builder templateName(Output<String> templateName) {
            $.templateName = templateName;
            return this;
        }

        /**
         * @param templateName name of the message template. A template name must start with an alphanumeric character and can contain a maximum of 128 characters. The characters can be alphanumeric characters, underscores (_), or hyphens (-). Template names are case sensitive.
         * 
         * @return builder
         * 
         */
        public Builder templateName(String templateName) {
            return templateName(Output.of(templateName));
        }

        public EmailTemplateArgs build() {
            if ($.templateName == null) {
                throw new MissingRequiredPropertyException("EmailTemplateArgs", "templateName");
            }
            return $;
        }
    }

}
