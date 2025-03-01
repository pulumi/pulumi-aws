// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bcmdata.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ExportExportDataQueryArgs extends com.pulumi.resources.ResourceArgs {

    public static final ExportExportDataQueryArgs Empty = new ExportExportDataQueryArgs();

    /**
     * Query statement.
     * 
     */
    @Import(name="queryStatement", required=true)
    private Output<String> queryStatement;

    /**
     * @return Query statement.
     * 
     */
    public Output<String> queryStatement() {
        return this.queryStatement;
    }

    /**
     * Table configuration.
     * 
     */
    @Import(name="tableConfigurations")
    private @Nullable Output<Map<String,Map<String,String>>> tableConfigurations;

    /**
     * @return Table configuration.
     * 
     */
    public Optional<Output<Map<String,Map<String,String>>>> tableConfigurations() {
        return Optional.ofNullable(this.tableConfigurations);
    }

    private ExportExportDataQueryArgs() {}

    private ExportExportDataQueryArgs(ExportExportDataQueryArgs $) {
        this.queryStatement = $.queryStatement;
        this.tableConfigurations = $.tableConfigurations;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ExportExportDataQueryArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ExportExportDataQueryArgs $;

        public Builder() {
            $ = new ExportExportDataQueryArgs();
        }

        public Builder(ExportExportDataQueryArgs defaults) {
            $ = new ExportExportDataQueryArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param queryStatement Query statement.
         * 
         * @return builder
         * 
         */
        public Builder queryStatement(Output<String> queryStatement) {
            $.queryStatement = queryStatement;
            return this;
        }

        /**
         * @param queryStatement Query statement.
         * 
         * @return builder
         * 
         */
        public Builder queryStatement(String queryStatement) {
            return queryStatement(Output.of(queryStatement));
        }

        /**
         * @param tableConfigurations Table configuration.
         * 
         * @return builder
         * 
         */
        public Builder tableConfigurations(@Nullable Output<Map<String,Map<String,String>>> tableConfigurations) {
            $.tableConfigurations = tableConfigurations;
            return this;
        }

        /**
         * @param tableConfigurations Table configuration.
         * 
         * @return builder
         * 
         */
        public Builder tableConfigurations(Map<String,Map<String,String>> tableConfigurations) {
            return tableConfigurations(Output.of(tableConfigurations));
        }

        public ExportExportDataQueryArgs build() {
            if ($.queryStatement == null) {
                throw new MissingRequiredPropertyException("ExportExportDataQueryArgs", "queryStatement");
            }
            return $;
        }
    }

}
