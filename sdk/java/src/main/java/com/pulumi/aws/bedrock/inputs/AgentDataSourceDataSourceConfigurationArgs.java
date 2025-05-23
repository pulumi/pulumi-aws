// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.aws.bedrock.inputs.AgentDataSourceDataSourceConfigurationConfluenceConfigurationArgs;
import com.pulumi.aws.bedrock.inputs.AgentDataSourceDataSourceConfigurationS3ConfigurationArgs;
import com.pulumi.aws.bedrock.inputs.AgentDataSourceDataSourceConfigurationSalesforceConfigurationArgs;
import com.pulumi.aws.bedrock.inputs.AgentDataSourceDataSourceConfigurationSharePointConfigurationArgs;
import com.pulumi.aws.bedrock.inputs.AgentDataSourceDataSourceConfigurationWebConfigurationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AgentDataSourceDataSourceConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final AgentDataSourceDataSourceConfigurationArgs Empty = new AgentDataSourceDataSourceConfigurationArgs();

    /**
     * Details about the configuration of the Confluence data source. See `confluence_data_source_configuration` block for details.
     * 
     */
    @Import(name="confluenceConfiguration")
    private @Nullable Output<AgentDataSourceDataSourceConfigurationConfluenceConfigurationArgs> confluenceConfiguration;

    /**
     * @return Details about the configuration of the Confluence data source. See `confluence_data_source_configuration` block for details.
     * 
     */
    public Optional<Output<AgentDataSourceDataSourceConfigurationConfluenceConfigurationArgs>> confluenceConfiguration() {
        return Optional.ofNullable(this.confluenceConfiguration);
    }

    /**
     * Details about the configuration of the S3 object containing the data source. See `s3_data_source_configuration` block for details.
     * 
     */
    @Import(name="s3Configuration")
    private @Nullable Output<AgentDataSourceDataSourceConfigurationS3ConfigurationArgs> s3Configuration;

    /**
     * @return Details about the configuration of the S3 object containing the data source. See `s3_data_source_configuration` block for details.
     * 
     */
    public Optional<Output<AgentDataSourceDataSourceConfigurationS3ConfigurationArgs>> s3Configuration() {
        return Optional.ofNullable(this.s3Configuration);
    }

    /**
     * Details about the configuration of the Salesforce data source. See `salesforce_data_source_configuration` block for details.
     * 
     */
    @Import(name="salesforceConfiguration")
    private @Nullable Output<AgentDataSourceDataSourceConfigurationSalesforceConfigurationArgs> salesforceConfiguration;

    /**
     * @return Details about the configuration of the Salesforce data source. See `salesforce_data_source_configuration` block for details.
     * 
     */
    public Optional<Output<AgentDataSourceDataSourceConfigurationSalesforceConfigurationArgs>> salesforceConfiguration() {
        return Optional.ofNullable(this.salesforceConfiguration);
    }

    /**
     * Details about the configuration of the SharePoint data source. See `share_point_data_source_configuration` block for details.
     * 
     */
    @Import(name="sharePointConfiguration")
    private @Nullable Output<AgentDataSourceDataSourceConfigurationSharePointConfigurationArgs> sharePointConfiguration;

    /**
     * @return Details about the configuration of the SharePoint data source. See `share_point_data_source_configuration` block for details.
     * 
     */
    public Optional<Output<AgentDataSourceDataSourceConfigurationSharePointConfigurationArgs>> sharePointConfiguration() {
        return Optional.ofNullable(this.sharePointConfiguration);
    }

    /**
     * Type of storage for the data source. Valid values: `S3`, `WEB`, `CONFLUENCE`, `SALESFORCE`, `SHAREPOINT`, `CUSTOM`, `REDSHIFT_METADATA`.
     * 
     */
    @Import(name="type", required=true)
    private Output<String> type;

    /**
     * @return Type of storage for the data source. Valid values: `S3`, `WEB`, `CONFLUENCE`, `SALESFORCE`, `SHAREPOINT`, `CUSTOM`, `REDSHIFT_METADATA`.
     * 
     */
    public Output<String> type() {
        return this.type;
    }

    /**
     * Details about the configuration of the web data source. See `web_data_source_configuration` block for details.
     * 
     */
    @Import(name="webConfiguration")
    private @Nullable Output<AgentDataSourceDataSourceConfigurationWebConfigurationArgs> webConfiguration;

    /**
     * @return Details about the configuration of the web data source. See `web_data_source_configuration` block for details.
     * 
     */
    public Optional<Output<AgentDataSourceDataSourceConfigurationWebConfigurationArgs>> webConfiguration() {
        return Optional.ofNullable(this.webConfiguration);
    }

    private AgentDataSourceDataSourceConfigurationArgs() {}

    private AgentDataSourceDataSourceConfigurationArgs(AgentDataSourceDataSourceConfigurationArgs $) {
        this.confluenceConfiguration = $.confluenceConfiguration;
        this.s3Configuration = $.s3Configuration;
        this.salesforceConfiguration = $.salesforceConfiguration;
        this.sharePointConfiguration = $.sharePointConfiguration;
        this.type = $.type;
        this.webConfiguration = $.webConfiguration;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AgentDataSourceDataSourceConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AgentDataSourceDataSourceConfigurationArgs $;

        public Builder() {
            $ = new AgentDataSourceDataSourceConfigurationArgs();
        }

        public Builder(AgentDataSourceDataSourceConfigurationArgs defaults) {
            $ = new AgentDataSourceDataSourceConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param confluenceConfiguration Details about the configuration of the Confluence data source. See `confluence_data_source_configuration` block for details.
         * 
         * @return builder
         * 
         */
        public Builder confluenceConfiguration(@Nullable Output<AgentDataSourceDataSourceConfigurationConfluenceConfigurationArgs> confluenceConfiguration) {
            $.confluenceConfiguration = confluenceConfiguration;
            return this;
        }

        /**
         * @param confluenceConfiguration Details about the configuration of the Confluence data source. See `confluence_data_source_configuration` block for details.
         * 
         * @return builder
         * 
         */
        public Builder confluenceConfiguration(AgentDataSourceDataSourceConfigurationConfluenceConfigurationArgs confluenceConfiguration) {
            return confluenceConfiguration(Output.of(confluenceConfiguration));
        }

        /**
         * @param s3Configuration Details about the configuration of the S3 object containing the data source. See `s3_data_source_configuration` block for details.
         * 
         * @return builder
         * 
         */
        public Builder s3Configuration(@Nullable Output<AgentDataSourceDataSourceConfigurationS3ConfigurationArgs> s3Configuration) {
            $.s3Configuration = s3Configuration;
            return this;
        }

        /**
         * @param s3Configuration Details about the configuration of the S3 object containing the data source. See `s3_data_source_configuration` block for details.
         * 
         * @return builder
         * 
         */
        public Builder s3Configuration(AgentDataSourceDataSourceConfigurationS3ConfigurationArgs s3Configuration) {
            return s3Configuration(Output.of(s3Configuration));
        }

        /**
         * @param salesforceConfiguration Details about the configuration of the Salesforce data source. See `salesforce_data_source_configuration` block for details.
         * 
         * @return builder
         * 
         */
        public Builder salesforceConfiguration(@Nullable Output<AgentDataSourceDataSourceConfigurationSalesforceConfigurationArgs> salesforceConfiguration) {
            $.salesforceConfiguration = salesforceConfiguration;
            return this;
        }

        /**
         * @param salesforceConfiguration Details about the configuration of the Salesforce data source. See `salesforce_data_source_configuration` block for details.
         * 
         * @return builder
         * 
         */
        public Builder salesforceConfiguration(AgentDataSourceDataSourceConfigurationSalesforceConfigurationArgs salesforceConfiguration) {
            return salesforceConfiguration(Output.of(salesforceConfiguration));
        }

        /**
         * @param sharePointConfiguration Details about the configuration of the SharePoint data source. See `share_point_data_source_configuration` block for details.
         * 
         * @return builder
         * 
         */
        public Builder sharePointConfiguration(@Nullable Output<AgentDataSourceDataSourceConfigurationSharePointConfigurationArgs> sharePointConfiguration) {
            $.sharePointConfiguration = sharePointConfiguration;
            return this;
        }

        /**
         * @param sharePointConfiguration Details about the configuration of the SharePoint data source. See `share_point_data_source_configuration` block for details.
         * 
         * @return builder
         * 
         */
        public Builder sharePointConfiguration(AgentDataSourceDataSourceConfigurationSharePointConfigurationArgs sharePointConfiguration) {
            return sharePointConfiguration(Output.of(sharePointConfiguration));
        }

        /**
         * @param type Type of storage for the data source. Valid values: `S3`, `WEB`, `CONFLUENCE`, `SALESFORCE`, `SHAREPOINT`, `CUSTOM`, `REDSHIFT_METADATA`.
         * 
         * @return builder
         * 
         */
        public Builder type(Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type Type of storage for the data source. Valid values: `S3`, `WEB`, `CONFLUENCE`, `SALESFORCE`, `SHAREPOINT`, `CUSTOM`, `REDSHIFT_METADATA`.
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        /**
         * @param webConfiguration Details about the configuration of the web data source. See `web_data_source_configuration` block for details.
         * 
         * @return builder
         * 
         */
        public Builder webConfiguration(@Nullable Output<AgentDataSourceDataSourceConfigurationWebConfigurationArgs> webConfiguration) {
            $.webConfiguration = webConfiguration;
            return this;
        }

        /**
         * @param webConfiguration Details about the configuration of the web data source. See `web_data_source_configuration` block for details.
         * 
         * @return builder
         * 
         */
        public Builder webConfiguration(AgentDataSourceDataSourceConfigurationWebConfigurationArgs webConfiguration) {
            return webConfiguration(Output.of(webConfiguration));
        }

        public AgentDataSourceDataSourceConfigurationArgs build() {
            if ($.type == null) {
                throw new MissingRequiredPropertyException("AgentDataSourceDataSourceConfigurationArgs", "type");
            }
            return $;
        }
    }

}
