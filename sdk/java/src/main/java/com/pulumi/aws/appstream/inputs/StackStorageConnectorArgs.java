// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appstream.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class StackStorageConnectorArgs extends com.pulumi.resources.ResourceArgs {

    public static final StackStorageConnectorArgs Empty = new StackStorageConnectorArgs();

    /**
     * Type of storage connector.
     * Valid values are `HOMEFOLDERS`, `GOOGLE_DRIVE`, or `ONE_DRIVE`.
     * 
     */
    @Import(name="connectorType", required=true)
    private Output<String> connectorType;

    /**
     * @return Type of storage connector.
     * Valid values are `HOMEFOLDERS`, `GOOGLE_DRIVE`, or `ONE_DRIVE`.
     * 
     */
    public Output<String> connectorType() {
        return this.connectorType;
    }

    /**
     * Names of the domains for the account.
     * 
     */
    @Import(name="domains")
    private @Nullable Output<List<String>> domains;

    /**
     * @return Names of the domains for the account.
     * 
     */
    public Optional<Output<List<String>>> domains() {
        return Optional.ofNullable(this.domains);
    }

    /**
     * ARN of the storage connector.
     * 
     */
    @Import(name="resourceIdentifier")
    private @Nullable Output<String> resourceIdentifier;

    /**
     * @return ARN of the storage connector.
     * 
     */
    public Optional<Output<String>> resourceIdentifier() {
        return Optional.ofNullable(this.resourceIdentifier);
    }

    private StackStorageConnectorArgs() {}

    private StackStorageConnectorArgs(StackStorageConnectorArgs $) {
        this.connectorType = $.connectorType;
        this.domains = $.domains;
        this.resourceIdentifier = $.resourceIdentifier;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(StackStorageConnectorArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private StackStorageConnectorArgs $;

        public Builder() {
            $ = new StackStorageConnectorArgs();
        }

        public Builder(StackStorageConnectorArgs defaults) {
            $ = new StackStorageConnectorArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param connectorType Type of storage connector.
         * Valid values are `HOMEFOLDERS`, `GOOGLE_DRIVE`, or `ONE_DRIVE`.
         * 
         * @return builder
         * 
         */
        public Builder connectorType(Output<String> connectorType) {
            $.connectorType = connectorType;
            return this;
        }

        /**
         * @param connectorType Type of storage connector.
         * Valid values are `HOMEFOLDERS`, `GOOGLE_DRIVE`, or `ONE_DRIVE`.
         * 
         * @return builder
         * 
         */
        public Builder connectorType(String connectorType) {
            return connectorType(Output.of(connectorType));
        }

        /**
         * @param domains Names of the domains for the account.
         * 
         * @return builder
         * 
         */
        public Builder domains(@Nullable Output<List<String>> domains) {
            $.domains = domains;
            return this;
        }

        /**
         * @param domains Names of the domains for the account.
         * 
         * @return builder
         * 
         */
        public Builder domains(List<String> domains) {
            return domains(Output.of(domains));
        }

        /**
         * @param domains Names of the domains for the account.
         * 
         * @return builder
         * 
         */
        public Builder domains(String... domains) {
            return domains(List.of(domains));
        }

        /**
         * @param resourceIdentifier ARN of the storage connector.
         * 
         * @return builder
         * 
         */
        public Builder resourceIdentifier(@Nullable Output<String> resourceIdentifier) {
            $.resourceIdentifier = resourceIdentifier;
            return this;
        }

        /**
         * @param resourceIdentifier ARN of the storage connector.
         * 
         * @return builder
         * 
         */
        public Builder resourceIdentifier(String resourceIdentifier) {
            return resourceIdentifier(Output.of(resourceIdentifier));
        }

        public StackStorageConnectorArgs build() {
            if ($.connectorType == null) {
                throw new MissingRequiredPropertyException("StackStorageConnectorArgs", "connectorType");
            }
            return $;
        }
    }

}
