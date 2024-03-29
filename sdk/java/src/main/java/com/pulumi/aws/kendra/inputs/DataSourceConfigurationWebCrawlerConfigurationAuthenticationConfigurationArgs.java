// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kendra.inputs;

import com.pulumi.aws.kendra.inputs.DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationBasicAuthenticationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationArgs Empty = new DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationArgs();

    /**
     * The list of configuration information that&#39;s required to connect to and crawl a website host using basic authentication credentials. The list includes the name and port number of the website host. Detailed below.
     * 
     */
    @Import(name="basicAuthentications")
    private @Nullable Output<List<DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationBasicAuthenticationArgs>> basicAuthentications;

    /**
     * @return The list of configuration information that&#39;s required to connect to and crawl a website host using basic authentication credentials. The list includes the name and port number of the website host. Detailed below.
     * 
     */
    public Optional<Output<List<DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationBasicAuthenticationArgs>>> basicAuthentications() {
        return Optional.ofNullable(this.basicAuthentications);
    }

    private DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationArgs() {}

    private DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationArgs(DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationArgs $) {
        this.basicAuthentications = $.basicAuthentications;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationArgs $;

        public Builder() {
            $ = new DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationArgs();
        }

        public Builder(DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationArgs defaults) {
            $ = new DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param basicAuthentications The list of configuration information that&#39;s required to connect to and crawl a website host using basic authentication credentials. The list includes the name and port number of the website host. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder basicAuthentications(@Nullable Output<List<DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationBasicAuthenticationArgs>> basicAuthentications) {
            $.basicAuthentications = basicAuthentications;
            return this;
        }

        /**
         * @param basicAuthentications The list of configuration information that&#39;s required to connect to and crawl a website host using basic authentication credentials. The list includes the name and port number of the website host. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder basicAuthentications(List<DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationBasicAuthenticationArgs> basicAuthentications) {
            return basicAuthentications(Output.of(basicAuthentications));
        }

        /**
         * @param basicAuthentications The list of configuration information that&#39;s required to connect to and crawl a website host using basic authentication credentials. The list includes the name and port number of the website host. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder basicAuthentications(DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationBasicAuthenticationArgs... basicAuthentications) {
            return basicAuthentications(List.of(basicAuthentications));
        }

        public DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfigurationArgs build() {
            return $;
        }
    }

}
