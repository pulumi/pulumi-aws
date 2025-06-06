// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.glue.inputs;

import com.pulumi.aws.glue.inputs.PartitionStorageDescriptorColumnArgs;
import com.pulumi.aws.glue.inputs.PartitionStorageDescriptorSerDeInfoArgs;
import com.pulumi.aws.glue.inputs.PartitionStorageDescriptorSkewedInfoArgs;
import com.pulumi.aws.glue.inputs.PartitionStorageDescriptorSortColumnArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PartitionStorageDescriptorArgs extends com.pulumi.resources.ResourceArgs {

    public static final PartitionStorageDescriptorArgs Empty = new PartitionStorageDescriptorArgs();

    /**
     * List of locations that point to the path where a Delta table is located.
     * 
     */
    @Import(name="additionalLocations")
    private @Nullable Output<List<String>> additionalLocations;

    /**
     * @return List of locations that point to the path where a Delta table is located.
     * 
     */
    public Optional<Output<List<String>>> additionalLocations() {
        return Optional.ofNullable(this.additionalLocations);
    }

    /**
     * A list of reducer grouping columns, clustering columns, and bucketing columns in the table.
     * 
     */
    @Import(name="bucketColumns")
    private @Nullable Output<List<String>> bucketColumns;

    /**
     * @return A list of reducer grouping columns, clustering columns, and bucketing columns in the table.
     * 
     */
    public Optional<Output<List<String>>> bucketColumns() {
        return Optional.ofNullable(this.bucketColumns);
    }

    /**
     * A list of the Columns in the table.
     * 
     */
    @Import(name="columns")
    private @Nullable Output<List<PartitionStorageDescriptorColumnArgs>> columns;

    /**
     * @return A list of the Columns in the table.
     * 
     */
    public Optional<Output<List<PartitionStorageDescriptorColumnArgs>>> columns() {
        return Optional.ofNullable(this.columns);
    }

    /**
     * True if the data in the table is compressed, or False if not.
     * 
     */
    @Import(name="compressed")
    private @Nullable Output<Boolean> compressed;

    /**
     * @return True if the data in the table is compressed, or False if not.
     * 
     */
    public Optional<Output<Boolean>> compressed() {
        return Optional.ofNullable(this.compressed);
    }

    /**
     * The input format: SequenceFileInputFormat (binary), or TextInputFormat, or a custom format.
     * 
     */
    @Import(name="inputFormat")
    private @Nullable Output<String> inputFormat;

    /**
     * @return The input format: SequenceFileInputFormat (binary), or TextInputFormat, or a custom format.
     * 
     */
    public Optional<Output<String>> inputFormat() {
        return Optional.ofNullable(this.inputFormat);
    }

    /**
     * The physical location of the table. By default this takes the form of the warehouse location, followed by the database location in the warehouse, followed by the table name.
     * 
     */
    @Import(name="location")
    private @Nullable Output<String> location;

    /**
     * @return The physical location of the table. By default this takes the form of the warehouse location, followed by the database location in the warehouse, followed by the table name.
     * 
     */
    public Optional<Output<String>> location() {
        return Optional.ofNullable(this.location);
    }

    /**
     * Must be specified if the table contains any dimension columns.
     * 
     */
    @Import(name="numberOfBuckets")
    private @Nullable Output<Integer> numberOfBuckets;

    /**
     * @return Must be specified if the table contains any dimension columns.
     * 
     */
    public Optional<Output<Integer>> numberOfBuckets() {
        return Optional.ofNullable(this.numberOfBuckets);
    }

    /**
     * The output format: SequenceFileOutputFormat (binary), or IgnoreKeyTextOutputFormat, or a custom format.
     * 
     */
    @Import(name="outputFormat")
    private @Nullable Output<String> outputFormat;

    /**
     * @return The output format: SequenceFileOutputFormat (binary), or IgnoreKeyTextOutputFormat, or a custom format.
     * 
     */
    public Optional<Output<String>> outputFormat() {
        return Optional.ofNullable(this.outputFormat);
    }

    /**
     * User-supplied properties in key-value form.
     * 
     */
    @Import(name="parameters")
    private @Nullable Output<Map<String,String>> parameters;

    /**
     * @return User-supplied properties in key-value form.
     * 
     */
    public Optional<Output<Map<String,String>>> parameters() {
        return Optional.ofNullable(this.parameters);
    }

    /**
     * Serialization/deserialization (SerDe) information.
     * 
     */
    @Import(name="serDeInfo")
    private @Nullable Output<PartitionStorageDescriptorSerDeInfoArgs> serDeInfo;

    /**
     * @return Serialization/deserialization (SerDe) information.
     * 
     */
    public Optional<Output<PartitionStorageDescriptorSerDeInfoArgs>> serDeInfo() {
        return Optional.ofNullable(this.serDeInfo);
    }

    /**
     * Information about values that appear very frequently in a column (skewed values).
     * 
     */
    @Import(name="skewedInfo")
    private @Nullable Output<PartitionStorageDescriptorSkewedInfoArgs> skewedInfo;

    /**
     * @return Information about values that appear very frequently in a column (skewed values).
     * 
     */
    public Optional<Output<PartitionStorageDescriptorSkewedInfoArgs>> skewedInfo() {
        return Optional.ofNullable(this.skewedInfo);
    }

    /**
     * A list of Order objects specifying the sort order of each bucket in the table.
     * 
     */
    @Import(name="sortColumns")
    private @Nullable Output<List<PartitionStorageDescriptorSortColumnArgs>> sortColumns;

    /**
     * @return A list of Order objects specifying the sort order of each bucket in the table.
     * 
     */
    public Optional<Output<List<PartitionStorageDescriptorSortColumnArgs>>> sortColumns() {
        return Optional.ofNullable(this.sortColumns);
    }

    /**
     * True if the table data is stored in subdirectories, or False if not.
     * 
     */
    @Import(name="storedAsSubDirectories")
    private @Nullable Output<Boolean> storedAsSubDirectories;

    /**
     * @return True if the table data is stored in subdirectories, or False if not.
     * 
     */
    public Optional<Output<Boolean>> storedAsSubDirectories() {
        return Optional.ofNullable(this.storedAsSubDirectories);
    }

    private PartitionStorageDescriptorArgs() {}

    private PartitionStorageDescriptorArgs(PartitionStorageDescriptorArgs $) {
        this.additionalLocations = $.additionalLocations;
        this.bucketColumns = $.bucketColumns;
        this.columns = $.columns;
        this.compressed = $.compressed;
        this.inputFormat = $.inputFormat;
        this.location = $.location;
        this.numberOfBuckets = $.numberOfBuckets;
        this.outputFormat = $.outputFormat;
        this.parameters = $.parameters;
        this.serDeInfo = $.serDeInfo;
        this.skewedInfo = $.skewedInfo;
        this.sortColumns = $.sortColumns;
        this.storedAsSubDirectories = $.storedAsSubDirectories;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PartitionStorageDescriptorArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PartitionStorageDescriptorArgs $;

        public Builder() {
            $ = new PartitionStorageDescriptorArgs();
        }

        public Builder(PartitionStorageDescriptorArgs defaults) {
            $ = new PartitionStorageDescriptorArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param additionalLocations List of locations that point to the path where a Delta table is located.
         * 
         * @return builder
         * 
         */
        public Builder additionalLocations(@Nullable Output<List<String>> additionalLocations) {
            $.additionalLocations = additionalLocations;
            return this;
        }

        /**
         * @param additionalLocations List of locations that point to the path where a Delta table is located.
         * 
         * @return builder
         * 
         */
        public Builder additionalLocations(List<String> additionalLocations) {
            return additionalLocations(Output.of(additionalLocations));
        }

        /**
         * @param additionalLocations List of locations that point to the path where a Delta table is located.
         * 
         * @return builder
         * 
         */
        public Builder additionalLocations(String... additionalLocations) {
            return additionalLocations(List.of(additionalLocations));
        }

        /**
         * @param bucketColumns A list of reducer grouping columns, clustering columns, and bucketing columns in the table.
         * 
         * @return builder
         * 
         */
        public Builder bucketColumns(@Nullable Output<List<String>> bucketColumns) {
            $.bucketColumns = bucketColumns;
            return this;
        }

        /**
         * @param bucketColumns A list of reducer grouping columns, clustering columns, and bucketing columns in the table.
         * 
         * @return builder
         * 
         */
        public Builder bucketColumns(List<String> bucketColumns) {
            return bucketColumns(Output.of(bucketColumns));
        }

        /**
         * @param bucketColumns A list of reducer grouping columns, clustering columns, and bucketing columns in the table.
         * 
         * @return builder
         * 
         */
        public Builder bucketColumns(String... bucketColumns) {
            return bucketColumns(List.of(bucketColumns));
        }

        /**
         * @param columns A list of the Columns in the table.
         * 
         * @return builder
         * 
         */
        public Builder columns(@Nullable Output<List<PartitionStorageDescriptorColumnArgs>> columns) {
            $.columns = columns;
            return this;
        }

        /**
         * @param columns A list of the Columns in the table.
         * 
         * @return builder
         * 
         */
        public Builder columns(List<PartitionStorageDescriptorColumnArgs> columns) {
            return columns(Output.of(columns));
        }

        /**
         * @param columns A list of the Columns in the table.
         * 
         * @return builder
         * 
         */
        public Builder columns(PartitionStorageDescriptorColumnArgs... columns) {
            return columns(List.of(columns));
        }

        /**
         * @param compressed True if the data in the table is compressed, or False if not.
         * 
         * @return builder
         * 
         */
        public Builder compressed(@Nullable Output<Boolean> compressed) {
            $.compressed = compressed;
            return this;
        }

        /**
         * @param compressed True if the data in the table is compressed, or False if not.
         * 
         * @return builder
         * 
         */
        public Builder compressed(Boolean compressed) {
            return compressed(Output.of(compressed));
        }

        /**
         * @param inputFormat The input format: SequenceFileInputFormat (binary), or TextInputFormat, or a custom format.
         * 
         * @return builder
         * 
         */
        public Builder inputFormat(@Nullable Output<String> inputFormat) {
            $.inputFormat = inputFormat;
            return this;
        }

        /**
         * @param inputFormat The input format: SequenceFileInputFormat (binary), or TextInputFormat, or a custom format.
         * 
         * @return builder
         * 
         */
        public Builder inputFormat(String inputFormat) {
            return inputFormat(Output.of(inputFormat));
        }

        /**
         * @param location The physical location of the table. By default this takes the form of the warehouse location, followed by the database location in the warehouse, followed by the table name.
         * 
         * @return builder
         * 
         */
        public Builder location(@Nullable Output<String> location) {
            $.location = location;
            return this;
        }

        /**
         * @param location The physical location of the table. By default this takes the form of the warehouse location, followed by the database location in the warehouse, followed by the table name.
         * 
         * @return builder
         * 
         */
        public Builder location(String location) {
            return location(Output.of(location));
        }

        /**
         * @param numberOfBuckets Must be specified if the table contains any dimension columns.
         * 
         * @return builder
         * 
         */
        public Builder numberOfBuckets(@Nullable Output<Integer> numberOfBuckets) {
            $.numberOfBuckets = numberOfBuckets;
            return this;
        }

        /**
         * @param numberOfBuckets Must be specified if the table contains any dimension columns.
         * 
         * @return builder
         * 
         */
        public Builder numberOfBuckets(Integer numberOfBuckets) {
            return numberOfBuckets(Output.of(numberOfBuckets));
        }

        /**
         * @param outputFormat The output format: SequenceFileOutputFormat (binary), or IgnoreKeyTextOutputFormat, or a custom format.
         * 
         * @return builder
         * 
         */
        public Builder outputFormat(@Nullable Output<String> outputFormat) {
            $.outputFormat = outputFormat;
            return this;
        }

        /**
         * @param outputFormat The output format: SequenceFileOutputFormat (binary), or IgnoreKeyTextOutputFormat, or a custom format.
         * 
         * @return builder
         * 
         */
        public Builder outputFormat(String outputFormat) {
            return outputFormat(Output.of(outputFormat));
        }

        /**
         * @param parameters User-supplied properties in key-value form.
         * 
         * @return builder
         * 
         */
        public Builder parameters(@Nullable Output<Map<String,String>> parameters) {
            $.parameters = parameters;
            return this;
        }

        /**
         * @param parameters User-supplied properties in key-value form.
         * 
         * @return builder
         * 
         */
        public Builder parameters(Map<String,String> parameters) {
            return parameters(Output.of(parameters));
        }

        /**
         * @param serDeInfo Serialization/deserialization (SerDe) information.
         * 
         * @return builder
         * 
         */
        public Builder serDeInfo(@Nullable Output<PartitionStorageDescriptorSerDeInfoArgs> serDeInfo) {
            $.serDeInfo = serDeInfo;
            return this;
        }

        /**
         * @param serDeInfo Serialization/deserialization (SerDe) information.
         * 
         * @return builder
         * 
         */
        public Builder serDeInfo(PartitionStorageDescriptorSerDeInfoArgs serDeInfo) {
            return serDeInfo(Output.of(serDeInfo));
        }

        /**
         * @param skewedInfo Information about values that appear very frequently in a column (skewed values).
         * 
         * @return builder
         * 
         */
        public Builder skewedInfo(@Nullable Output<PartitionStorageDescriptorSkewedInfoArgs> skewedInfo) {
            $.skewedInfo = skewedInfo;
            return this;
        }

        /**
         * @param skewedInfo Information about values that appear very frequently in a column (skewed values).
         * 
         * @return builder
         * 
         */
        public Builder skewedInfo(PartitionStorageDescriptorSkewedInfoArgs skewedInfo) {
            return skewedInfo(Output.of(skewedInfo));
        }

        /**
         * @param sortColumns A list of Order objects specifying the sort order of each bucket in the table.
         * 
         * @return builder
         * 
         */
        public Builder sortColumns(@Nullable Output<List<PartitionStorageDescriptorSortColumnArgs>> sortColumns) {
            $.sortColumns = sortColumns;
            return this;
        }

        /**
         * @param sortColumns A list of Order objects specifying the sort order of each bucket in the table.
         * 
         * @return builder
         * 
         */
        public Builder sortColumns(List<PartitionStorageDescriptorSortColumnArgs> sortColumns) {
            return sortColumns(Output.of(sortColumns));
        }

        /**
         * @param sortColumns A list of Order objects specifying the sort order of each bucket in the table.
         * 
         * @return builder
         * 
         */
        public Builder sortColumns(PartitionStorageDescriptorSortColumnArgs... sortColumns) {
            return sortColumns(List.of(sortColumns));
        }

        /**
         * @param storedAsSubDirectories True if the table data is stored in subdirectories, or False if not.
         * 
         * @return builder
         * 
         */
        public Builder storedAsSubDirectories(@Nullable Output<Boolean> storedAsSubDirectories) {
            $.storedAsSubDirectories = storedAsSubDirectories;
            return this;
        }

        /**
         * @param storedAsSubDirectories True if the table data is stored in subdirectories, or False if not.
         * 
         * @return builder
         * 
         */
        public Builder storedAsSubDirectories(Boolean storedAsSubDirectories) {
            return storedAsSubDirectories(Output.of(storedAsSubDirectories));
        }

        public PartitionStorageDescriptorArgs build() {
            return $;
        }
    }

}
