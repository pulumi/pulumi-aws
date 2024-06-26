// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dynamodb.inputs;

import com.pulumi.aws.dynamodb.inputs.TableImportTableInputFormatOptionsCsvArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class TableImportTableInputFormatOptionsArgs extends com.pulumi.resources.ResourceArgs {

    public static final TableImportTableInputFormatOptionsArgs Empty = new TableImportTableInputFormatOptionsArgs();

    /**
     * This block contains the processing options for the CSV file being imported:
     * 
     */
    @Import(name="csv")
    private @Nullable Output<TableImportTableInputFormatOptionsCsvArgs> csv;

    /**
     * @return This block contains the processing options for the CSV file being imported:
     * 
     */
    public Optional<Output<TableImportTableInputFormatOptionsCsvArgs>> csv() {
        return Optional.ofNullable(this.csv);
    }

    private TableImportTableInputFormatOptionsArgs() {}

    private TableImportTableInputFormatOptionsArgs(TableImportTableInputFormatOptionsArgs $) {
        this.csv = $.csv;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(TableImportTableInputFormatOptionsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private TableImportTableInputFormatOptionsArgs $;

        public Builder() {
            $ = new TableImportTableInputFormatOptionsArgs();
        }

        public Builder(TableImportTableInputFormatOptionsArgs defaults) {
            $ = new TableImportTableInputFormatOptionsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param csv This block contains the processing options for the CSV file being imported:
         * 
         * @return builder
         * 
         */
        public Builder csv(@Nullable Output<TableImportTableInputFormatOptionsCsvArgs> csv) {
            $.csv = csv;
            return this;
        }

        /**
         * @param csv This block contains the processing options for the CSV file being imported:
         * 
         * @return builder
         * 
         */
        public Builder csv(TableImportTableInputFormatOptionsCsvArgs csv) {
            return csv(Output.of(csv));
        }

        public TableImportTableInputFormatOptionsArgs build() {
            return $;
        }
    }

}
