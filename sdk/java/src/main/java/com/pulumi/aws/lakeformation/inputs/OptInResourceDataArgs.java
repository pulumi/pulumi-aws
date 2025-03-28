// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lakeformation.inputs;

import com.pulumi.aws.lakeformation.inputs.OptInResourceDataCatalogArgs;
import com.pulumi.aws.lakeformation.inputs.OptInResourceDataDataCellsFilterArgs;
import com.pulumi.aws.lakeformation.inputs.OptInResourceDataDataLocationArgs;
import com.pulumi.aws.lakeformation.inputs.OptInResourceDataDatabaseArgs;
import com.pulumi.aws.lakeformation.inputs.OptInResourceDataLfTagArgs;
import com.pulumi.aws.lakeformation.inputs.OptInResourceDataLfTagExpressionArgs;
import com.pulumi.aws.lakeformation.inputs.OptInResourceDataLfTagPolicyArgs;
import com.pulumi.aws.lakeformation.inputs.OptInResourceDataTableArgs;
import com.pulumi.aws.lakeformation.inputs.OptInResourceDataTableWithColumnsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class OptInResourceDataArgs extends com.pulumi.resources.ResourceArgs {

    public static final OptInResourceDataArgs Empty = new OptInResourceDataArgs();

    /**
     * Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment. See Catalog for more details.
     * 
     */
    @Import(name="catalogs")
    private @Nullable Output<List<OptInResourceDataCatalogArgs>> catalogs;

    /**
     * @return Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment. See Catalog for more details.
     * 
     */
    public Optional<Output<List<OptInResourceDataCatalogArgs>>> catalogs() {
        return Optional.ofNullable(this.catalogs);
    }

    /**
     * Data cell filter. See Data Cells Filter for more details.
     * 
     */
    @Import(name="dataCellsFilters")
    private @Nullable Output<List<OptInResourceDataDataCellsFilterArgs>> dataCellsFilters;

    /**
     * @return Data cell filter. See Data Cells Filter for more details.
     * 
     */
    public Optional<Output<List<OptInResourceDataDataCellsFilterArgs>>> dataCellsFilters() {
        return Optional.ofNullable(this.dataCellsFilters);
    }

    /**
     * Location of an Amazon S3 path where permissions are granted or revoked. See Data Location for more details.
     * 
     */
    @Import(name="dataLocations")
    private @Nullable Output<List<OptInResourceDataDataLocationArgs>> dataLocations;

    /**
     * @return Location of an Amazon S3 path where permissions are granted or revoked. See Data Location for more details.
     * 
     */
    public Optional<Output<List<OptInResourceDataDataLocationArgs>>> dataLocations() {
        return Optional.ofNullable(this.dataLocations);
    }

    /**
     * Database for the resource. Unique to the Data Catalog. A database is a set of associated table definitions organized into a logical group. You can Grant and Revoke database permissions to a principal. See Database for more details.
     * 
     */
    @Import(name="database")
    private @Nullable Output<OptInResourceDataDatabaseArgs> database;

    /**
     * @return Database for the resource. Unique to the Data Catalog. A database is a set of associated table definitions organized into a logical group. You can Grant and Revoke database permissions to a principal. See Database for more details.
     * 
     */
    public Optional<Output<OptInResourceDataDatabaseArgs>> database() {
        return Optional.ofNullable(this.database);
    }

    /**
     * LF-tag key and values attached to a resource.
     * 
     */
    @Import(name="lfTag")
    private @Nullable Output<OptInResourceDataLfTagArgs> lfTag;

    /**
     * @return LF-tag key and values attached to a resource.
     * 
     */
    public Optional<Output<OptInResourceDataLfTagArgs>> lfTag() {
        return Optional.ofNullable(this.lfTag);
    }

    /**
     * Logical expression composed of one or more LF-Tag key:value pairs. See LF-Tag Expression for more details.
     * 
     */
    @Import(name="lfTagExpressions")
    private @Nullable Output<List<OptInResourceDataLfTagExpressionArgs>> lfTagExpressions;

    /**
     * @return Logical expression composed of one or more LF-Tag key:value pairs. See LF-Tag Expression for more details.
     * 
     */
    public Optional<Output<List<OptInResourceDataLfTagExpressionArgs>>> lfTagExpressions() {
        return Optional.ofNullable(this.lfTagExpressions);
    }

    /**
     * List of LF-Tag conditions or saved LF-Tag expressions that define a resource&#39;s LF-Tag policy. See LF-Tag Policy for more details.
     * 
     */
    @Import(name="lfTagPolicies")
    private @Nullable Output<List<OptInResourceDataLfTagPolicyArgs>> lfTagPolicies;

    /**
     * @return List of LF-Tag conditions or saved LF-Tag expressions that define a resource&#39;s LF-Tag policy. See LF-Tag Policy for more details.
     * 
     */
    public Optional<Output<List<OptInResourceDataLfTagPolicyArgs>>> lfTagPolicies() {
        return Optional.ofNullable(this.lfTagPolicies);
    }

    /**
     * Table for the resource. A table is a metadata definition that represents your data. You can Grant and Revoke table privileges to a principal. See Table for more details.
     * 
     */
    @Import(name="table")
    private @Nullable Output<OptInResourceDataTableArgs> table;

    /**
     * @return Table for the resource. A table is a metadata definition that represents your data. You can Grant and Revoke table privileges to a principal. See Table for more details.
     * 
     */
    public Optional<Output<OptInResourceDataTableArgs>> table() {
        return Optional.ofNullable(this.table);
    }

    /**
     * Table with columns for the resource. A principal with permissions to this resource can select metadata from the columns of a table in the Data Catalog and the underlying data in Amazon S3. See Table With Columns for more details.
     * 
     */
    @Import(name="tableWithColumns")
    private @Nullable Output<OptInResourceDataTableWithColumnsArgs> tableWithColumns;

    /**
     * @return Table with columns for the resource. A principal with permissions to this resource can select metadata from the columns of a table in the Data Catalog and the underlying data in Amazon S3. See Table With Columns for more details.
     * 
     */
    public Optional<Output<OptInResourceDataTableWithColumnsArgs>> tableWithColumns() {
        return Optional.ofNullable(this.tableWithColumns);
    }

    private OptInResourceDataArgs() {}

    private OptInResourceDataArgs(OptInResourceDataArgs $) {
        this.catalogs = $.catalogs;
        this.dataCellsFilters = $.dataCellsFilters;
        this.dataLocations = $.dataLocations;
        this.database = $.database;
        this.lfTag = $.lfTag;
        this.lfTagExpressions = $.lfTagExpressions;
        this.lfTagPolicies = $.lfTagPolicies;
        this.table = $.table;
        this.tableWithColumns = $.tableWithColumns;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(OptInResourceDataArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private OptInResourceDataArgs $;

        public Builder() {
            $ = new OptInResourceDataArgs();
        }

        public Builder(OptInResourceDataArgs defaults) {
            $ = new OptInResourceDataArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param catalogs Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment. See Catalog for more details.
         * 
         * @return builder
         * 
         */
        public Builder catalogs(@Nullable Output<List<OptInResourceDataCatalogArgs>> catalogs) {
            $.catalogs = catalogs;
            return this;
        }

        /**
         * @param catalogs Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment. See Catalog for more details.
         * 
         * @return builder
         * 
         */
        public Builder catalogs(List<OptInResourceDataCatalogArgs> catalogs) {
            return catalogs(Output.of(catalogs));
        }

        /**
         * @param catalogs Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment. See Catalog for more details.
         * 
         * @return builder
         * 
         */
        public Builder catalogs(OptInResourceDataCatalogArgs... catalogs) {
            return catalogs(List.of(catalogs));
        }

        /**
         * @param dataCellsFilters Data cell filter. See Data Cells Filter for more details.
         * 
         * @return builder
         * 
         */
        public Builder dataCellsFilters(@Nullable Output<List<OptInResourceDataDataCellsFilterArgs>> dataCellsFilters) {
            $.dataCellsFilters = dataCellsFilters;
            return this;
        }

        /**
         * @param dataCellsFilters Data cell filter. See Data Cells Filter for more details.
         * 
         * @return builder
         * 
         */
        public Builder dataCellsFilters(List<OptInResourceDataDataCellsFilterArgs> dataCellsFilters) {
            return dataCellsFilters(Output.of(dataCellsFilters));
        }

        /**
         * @param dataCellsFilters Data cell filter. See Data Cells Filter for more details.
         * 
         * @return builder
         * 
         */
        public Builder dataCellsFilters(OptInResourceDataDataCellsFilterArgs... dataCellsFilters) {
            return dataCellsFilters(List.of(dataCellsFilters));
        }

        /**
         * @param dataLocations Location of an Amazon S3 path where permissions are granted or revoked. See Data Location for more details.
         * 
         * @return builder
         * 
         */
        public Builder dataLocations(@Nullable Output<List<OptInResourceDataDataLocationArgs>> dataLocations) {
            $.dataLocations = dataLocations;
            return this;
        }

        /**
         * @param dataLocations Location of an Amazon S3 path where permissions are granted or revoked. See Data Location for more details.
         * 
         * @return builder
         * 
         */
        public Builder dataLocations(List<OptInResourceDataDataLocationArgs> dataLocations) {
            return dataLocations(Output.of(dataLocations));
        }

        /**
         * @param dataLocations Location of an Amazon S3 path where permissions are granted or revoked. See Data Location for more details.
         * 
         * @return builder
         * 
         */
        public Builder dataLocations(OptInResourceDataDataLocationArgs... dataLocations) {
            return dataLocations(List.of(dataLocations));
        }

        /**
         * @param database Database for the resource. Unique to the Data Catalog. A database is a set of associated table definitions organized into a logical group. You can Grant and Revoke database permissions to a principal. See Database for more details.
         * 
         * @return builder
         * 
         */
        public Builder database(@Nullable Output<OptInResourceDataDatabaseArgs> database) {
            $.database = database;
            return this;
        }

        /**
         * @param database Database for the resource. Unique to the Data Catalog. A database is a set of associated table definitions organized into a logical group. You can Grant and Revoke database permissions to a principal. See Database for more details.
         * 
         * @return builder
         * 
         */
        public Builder database(OptInResourceDataDatabaseArgs database) {
            return database(Output.of(database));
        }

        /**
         * @param lfTag LF-tag key and values attached to a resource.
         * 
         * @return builder
         * 
         */
        public Builder lfTag(@Nullable Output<OptInResourceDataLfTagArgs> lfTag) {
            $.lfTag = lfTag;
            return this;
        }

        /**
         * @param lfTag LF-tag key and values attached to a resource.
         * 
         * @return builder
         * 
         */
        public Builder lfTag(OptInResourceDataLfTagArgs lfTag) {
            return lfTag(Output.of(lfTag));
        }

        /**
         * @param lfTagExpressions Logical expression composed of one or more LF-Tag key:value pairs. See LF-Tag Expression for more details.
         * 
         * @return builder
         * 
         */
        public Builder lfTagExpressions(@Nullable Output<List<OptInResourceDataLfTagExpressionArgs>> lfTagExpressions) {
            $.lfTagExpressions = lfTagExpressions;
            return this;
        }

        /**
         * @param lfTagExpressions Logical expression composed of one or more LF-Tag key:value pairs. See LF-Tag Expression for more details.
         * 
         * @return builder
         * 
         */
        public Builder lfTagExpressions(List<OptInResourceDataLfTagExpressionArgs> lfTagExpressions) {
            return lfTagExpressions(Output.of(lfTagExpressions));
        }

        /**
         * @param lfTagExpressions Logical expression composed of one or more LF-Tag key:value pairs. See LF-Tag Expression for more details.
         * 
         * @return builder
         * 
         */
        public Builder lfTagExpressions(OptInResourceDataLfTagExpressionArgs... lfTagExpressions) {
            return lfTagExpressions(List.of(lfTagExpressions));
        }

        /**
         * @param lfTagPolicies List of LF-Tag conditions or saved LF-Tag expressions that define a resource&#39;s LF-Tag policy. See LF-Tag Policy for more details.
         * 
         * @return builder
         * 
         */
        public Builder lfTagPolicies(@Nullable Output<List<OptInResourceDataLfTagPolicyArgs>> lfTagPolicies) {
            $.lfTagPolicies = lfTagPolicies;
            return this;
        }

        /**
         * @param lfTagPolicies List of LF-Tag conditions or saved LF-Tag expressions that define a resource&#39;s LF-Tag policy. See LF-Tag Policy for more details.
         * 
         * @return builder
         * 
         */
        public Builder lfTagPolicies(List<OptInResourceDataLfTagPolicyArgs> lfTagPolicies) {
            return lfTagPolicies(Output.of(lfTagPolicies));
        }

        /**
         * @param lfTagPolicies List of LF-Tag conditions or saved LF-Tag expressions that define a resource&#39;s LF-Tag policy. See LF-Tag Policy for more details.
         * 
         * @return builder
         * 
         */
        public Builder lfTagPolicies(OptInResourceDataLfTagPolicyArgs... lfTagPolicies) {
            return lfTagPolicies(List.of(lfTagPolicies));
        }

        /**
         * @param table Table for the resource. A table is a metadata definition that represents your data. You can Grant and Revoke table privileges to a principal. See Table for more details.
         * 
         * @return builder
         * 
         */
        public Builder table(@Nullable Output<OptInResourceDataTableArgs> table) {
            $.table = table;
            return this;
        }

        /**
         * @param table Table for the resource. A table is a metadata definition that represents your data. You can Grant and Revoke table privileges to a principal. See Table for more details.
         * 
         * @return builder
         * 
         */
        public Builder table(OptInResourceDataTableArgs table) {
            return table(Output.of(table));
        }

        /**
         * @param tableWithColumns Table with columns for the resource. A principal with permissions to this resource can select metadata from the columns of a table in the Data Catalog and the underlying data in Amazon S3. See Table With Columns for more details.
         * 
         * @return builder
         * 
         */
        public Builder tableWithColumns(@Nullable Output<OptInResourceDataTableWithColumnsArgs> tableWithColumns) {
            $.tableWithColumns = tableWithColumns;
            return this;
        }

        /**
         * @param tableWithColumns Table with columns for the resource. A principal with permissions to this resource can select metadata from the columns of a table in the Data Catalog and the underlying data in Amazon S3. See Table With Columns for more details.
         * 
         * @return builder
         * 
         */
        public Builder tableWithColumns(OptInResourceDataTableWithColumnsArgs tableWithColumns) {
            return tableWithColumns(Output.of(tableWithColumns));
        }

        public OptInResourceDataArgs build() {
            return $;
        }
    }

}
