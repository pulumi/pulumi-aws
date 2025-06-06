// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.rds.inputs;

import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetSnapshotPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetSnapshotPlainArgs Empty = new GetSnapshotPlainArgs();

    /**
     * Returns the list of snapshots created by the specific db_instance
     * 
     */
    @Import(name="dbInstanceIdentifier")
    private @Nullable String dbInstanceIdentifier;

    /**
     * @return Returns the list of snapshots created by the specific db_instance
     * 
     */
    public Optional<String> dbInstanceIdentifier() {
        return Optional.ofNullable(this.dbInstanceIdentifier);
    }

    /**
     * Returns information on a specific snapshot_id.
     * 
     */
    @Import(name="dbSnapshotIdentifier")
    private @Nullable String dbSnapshotIdentifier;

    /**
     * @return Returns information on a specific snapshot_id.
     * 
     */
    public Optional<String> dbSnapshotIdentifier() {
        return Optional.ofNullable(this.dbSnapshotIdentifier);
    }

    /**
     * Set this value to true to include manual DB snapshots that are public and can be
     * copied or restored by any AWS account, otherwise set this value to false. The default is `false`.
     * 
     */
    @Import(name="includePublic")
    private @Nullable Boolean includePublic;

    /**
     * @return Set this value to true to include manual DB snapshots that are public and can be
     * copied or restored by any AWS account, otherwise set this value to false. The default is `false`.
     * 
     */
    public Optional<Boolean> includePublic() {
        return Optional.ofNullable(this.includePublic);
    }

    /**
     * Set this value to true to include shared manual DB snapshots from other
     * AWS accounts that this AWS account has been given permission to copy or restore, otherwise set this value to false.
     * The default is `false`.
     * 
     */
    @Import(name="includeShared")
    private @Nullable Boolean includeShared;

    /**
     * @return Set this value to true to include shared manual DB snapshots from other
     * AWS accounts that this AWS account has been given permission to copy or restore, otherwise set this value to false.
     * The default is `false`.
     * 
     */
    public Optional<Boolean> includeShared() {
        return Optional.ofNullable(this.includeShared);
    }

    /**
     * If more than one result is returned, use the most
     * recent Snapshot.
     * 
     */
    @Import(name="mostRecent")
    private @Nullable Boolean mostRecent;

    /**
     * @return If more than one result is returned, use the most
     * recent Snapshot.
     * 
     */
    public Optional<Boolean> mostRecent() {
        return Optional.ofNullable(this.mostRecent);
    }

    /**
     * Type of snapshots to be returned. If you don&#39;t specify a SnapshotType
     * value, then both automated and manual snapshots are returned. Shared and public DB snapshots are not
     * included in the returned results by default. Possible values are, `automated`, `manual`, `shared`, `public` and `awsbackup`.
     * 
     */
    @Import(name="snapshotType")
    private @Nullable String snapshotType;

    /**
     * @return Type of snapshots to be returned. If you don&#39;t specify a SnapshotType
     * value, then both automated and manual snapshots are returned. Shared and public DB snapshots are not
     * included in the returned results by default. Possible values are, `automated`, `manual`, `shared`, `public` and `awsbackup`.
     * 
     */
    public Optional<String> snapshotType() {
        return Optional.ofNullable(this.snapshotType);
    }

    /**
     * Mapping of tags, each pair of which must exactly match
     * a pair on the desired DB snapshot.
     * 
     * &gt; **NOTE:** One of either `db_instance_identifier` or `db_snapshot_identifier` is required.
     * 
     */
    @Import(name="tags")
    private @Nullable Map<String,String> tags;

    /**
     * @return Mapping of tags, each pair of which must exactly match
     * a pair on the desired DB snapshot.
     * 
     * &gt; **NOTE:** One of either `db_instance_identifier` or `db_snapshot_identifier` is required.
     * 
     */
    public Optional<Map<String,String>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetSnapshotPlainArgs() {}

    private GetSnapshotPlainArgs(GetSnapshotPlainArgs $) {
        this.dbInstanceIdentifier = $.dbInstanceIdentifier;
        this.dbSnapshotIdentifier = $.dbSnapshotIdentifier;
        this.includePublic = $.includePublic;
        this.includeShared = $.includeShared;
        this.mostRecent = $.mostRecent;
        this.snapshotType = $.snapshotType;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetSnapshotPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetSnapshotPlainArgs $;

        public Builder() {
            $ = new GetSnapshotPlainArgs();
        }

        public Builder(GetSnapshotPlainArgs defaults) {
            $ = new GetSnapshotPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param dbInstanceIdentifier Returns the list of snapshots created by the specific db_instance
         * 
         * @return builder
         * 
         */
        public Builder dbInstanceIdentifier(@Nullable String dbInstanceIdentifier) {
            $.dbInstanceIdentifier = dbInstanceIdentifier;
            return this;
        }

        /**
         * @param dbSnapshotIdentifier Returns information on a specific snapshot_id.
         * 
         * @return builder
         * 
         */
        public Builder dbSnapshotIdentifier(@Nullable String dbSnapshotIdentifier) {
            $.dbSnapshotIdentifier = dbSnapshotIdentifier;
            return this;
        }

        /**
         * @param includePublic Set this value to true to include manual DB snapshots that are public and can be
         * copied or restored by any AWS account, otherwise set this value to false. The default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includePublic(@Nullable Boolean includePublic) {
            $.includePublic = includePublic;
            return this;
        }

        /**
         * @param includeShared Set this value to true to include shared manual DB snapshots from other
         * AWS accounts that this AWS account has been given permission to copy or restore, otherwise set this value to false.
         * The default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includeShared(@Nullable Boolean includeShared) {
            $.includeShared = includeShared;
            return this;
        }

        /**
         * @param mostRecent If more than one result is returned, use the most
         * recent Snapshot.
         * 
         * @return builder
         * 
         */
        public Builder mostRecent(@Nullable Boolean mostRecent) {
            $.mostRecent = mostRecent;
            return this;
        }

        /**
         * @param snapshotType Type of snapshots to be returned. If you don&#39;t specify a SnapshotType
         * value, then both automated and manual snapshots are returned. Shared and public DB snapshots are not
         * included in the returned results by default. Possible values are, `automated`, `manual`, `shared`, `public` and `awsbackup`.
         * 
         * @return builder
         * 
         */
        public Builder snapshotType(@Nullable String snapshotType) {
            $.snapshotType = snapshotType;
            return this;
        }

        /**
         * @param tags Mapping of tags, each pair of which must exactly match
         * a pair on the desired DB snapshot.
         * 
         * &gt; **NOTE:** One of either `db_instance_identifier` or `db_snapshot_identifier` is required.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Map<String,String> tags) {
            $.tags = tags;
            return this;
        }

        public GetSnapshotPlainArgs build() {
            return $;
        }
    }

}
