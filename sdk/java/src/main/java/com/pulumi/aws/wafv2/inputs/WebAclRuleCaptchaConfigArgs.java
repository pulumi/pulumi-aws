// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.aws.wafv2.inputs.WebAclRuleCaptchaConfigImmunityTimePropertyArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class WebAclRuleCaptchaConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final WebAclRuleCaptchaConfigArgs Empty = new WebAclRuleCaptchaConfigArgs();

    /**
     * Defines custom immunity time. See Immunity Time Property below for details.
     * 
     */
    @Import(name="immunityTimeProperty")
    private @Nullable Output<WebAclRuleCaptchaConfigImmunityTimePropertyArgs> immunityTimeProperty;

    /**
     * @return Defines custom immunity time. See Immunity Time Property below for details.
     * 
     */
    public Optional<Output<WebAclRuleCaptchaConfigImmunityTimePropertyArgs>> immunityTimeProperty() {
        return Optional.ofNullable(this.immunityTimeProperty);
    }

    private WebAclRuleCaptchaConfigArgs() {}

    private WebAclRuleCaptchaConfigArgs(WebAclRuleCaptchaConfigArgs $) {
        this.immunityTimeProperty = $.immunityTimeProperty;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(WebAclRuleCaptchaConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private WebAclRuleCaptchaConfigArgs $;

        public Builder() {
            $ = new WebAclRuleCaptchaConfigArgs();
        }

        public Builder(WebAclRuleCaptchaConfigArgs defaults) {
            $ = new WebAclRuleCaptchaConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param immunityTimeProperty Defines custom immunity time. See Immunity Time Property below for details.
         * 
         * @return builder
         * 
         */
        public Builder immunityTimeProperty(@Nullable Output<WebAclRuleCaptchaConfigImmunityTimePropertyArgs> immunityTimeProperty) {
            $.immunityTimeProperty = immunityTimeProperty;
            return this;
        }

        /**
         * @param immunityTimeProperty Defines custom immunity time. See Immunity Time Property below for details.
         * 
         * @return builder
         * 
         */
        public Builder immunityTimeProperty(WebAclRuleCaptchaConfigImmunityTimePropertyArgs immunityTimeProperty) {
            return immunityTimeProperty(Output.of(immunityTimeProperty));
        }

        public WebAclRuleCaptchaConfigArgs build() {
            return $;
        }
    }

}