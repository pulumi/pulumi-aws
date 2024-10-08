// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionBodyContainsArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionHeaderArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionJsonArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionStatusCodeArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionArgs extends com.pulumi.resources.ResourceArgs {

    public static final WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionArgs Empty = new WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionArgs();

    /**
     * Configures inspection of the response body. See `body_contains` for more details.
     * 
     */
    @Import(name="bodyContains")
    private @Nullable Output<WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionBodyContainsArgs> bodyContains;

    /**
     * @return Configures inspection of the response body. See `body_contains` for more details.
     * 
     */
    public Optional<Output<WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionBodyContainsArgs>> bodyContains() {
        return Optional.ofNullable(this.bodyContains);
    }

    /**
     * Configures inspection of the response header.See `header` for more details.
     * 
     */
    @Import(name="header")
    private @Nullable Output<WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionHeaderArgs> header;

    /**
     * @return Configures inspection of the response header.See `header` for more details.
     * 
     */
    public Optional<Output<WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionHeaderArgs>> header() {
        return Optional.ofNullable(this.header);
    }

    /**
     * Configures inspection of the response JSON. See `json` for more details.
     * 
     */
    @Import(name="json")
    private @Nullable Output<WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionJsonArgs> json;

    /**
     * @return Configures inspection of the response JSON. See `json` for more details.
     * 
     */
    public Optional<Output<WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionJsonArgs>> json() {
        return Optional.ofNullable(this.json);
    }

    /**
     * Configures inspection of the response status code.See `status_code` for more details.
     * 
     */
    @Import(name="statusCode")
    private @Nullable Output<WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionStatusCodeArgs> statusCode;

    /**
     * @return Configures inspection of the response status code.See `status_code` for more details.
     * 
     */
    public Optional<Output<WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionStatusCodeArgs>> statusCode() {
        return Optional.ofNullable(this.statusCode);
    }

    private WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionArgs() {}

    private WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionArgs(WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionArgs $) {
        this.bodyContains = $.bodyContains;
        this.header = $.header;
        this.json = $.json;
        this.statusCode = $.statusCode;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionArgs $;

        public Builder() {
            $ = new WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionArgs();
        }

        public Builder(WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionArgs defaults) {
            $ = new WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param bodyContains Configures inspection of the response body. See `body_contains` for more details.
         * 
         * @return builder
         * 
         */
        public Builder bodyContains(@Nullable Output<WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionBodyContainsArgs> bodyContains) {
            $.bodyContains = bodyContains;
            return this;
        }

        /**
         * @param bodyContains Configures inspection of the response body. See `body_contains` for more details.
         * 
         * @return builder
         * 
         */
        public Builder bodyContains(WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionBodyContainsArgs bodyContains) {
            return bodyContains(Output.of(bodyContains));
        }

        /**
         * @param header Configures inspection of the response header.See `header` for more details.
         * 
         * @return builder
         * 
         */
        public Builder header(@Nullable Output<WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionHeaderArgs> header) {
            $.header = header;
            return this;
        }

        /**
         * @param header Configures inspection of the response header.See `header` for more details.
         * 
         * @return builder
         * 
         */
        public Builder header(WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionHeaderArgs header) {
            return header(Output.of(header));
        }

        /**
         * @param json Configures inspection of the response JSON. See `json` for more details.
         * 
         * @return builder
         * 
         */
        public Builder json(@Nullable Output<WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionJsonArgs> json) {
            $.json = json;
            return this;
        }

        /**
         * @param json Configures inspection of the response JSON. See `json` for more details.
         * 
         * @return builder
         * 
         */
        public Builder json(WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionJsonArgs json) {
            return json(Output.of(json));
        }

        /**
         * @param statusCode Configures inspection of the response status code.See `status_code` for more details.
         * 
         * @return builder
         * 
         */
        public Builder statusCode(@Nullable Output<WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionStatusCodeArgs> statusCode) {
            $.statusCode = statusCode;
            return this;
        }

        /**
         * @param statusCode Configures inspection of the response status code.See `status_code` for more details.
         * 
         * @return builder
         * 
         */
        public Builder statusCode(WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionStatusCodeArgs statusCode) {
            return statusCode(Output.of(statusCode));
        }

        public WebAclRuleStatementManagedRuleGroupStatementManagedRuleGroupConfigAwsManagedRulesAcfpRuleSetResponseInspectionArgs build() {
            return $;
        }
    }

}
