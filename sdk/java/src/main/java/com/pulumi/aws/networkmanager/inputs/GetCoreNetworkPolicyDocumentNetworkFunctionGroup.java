// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkmanager.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetCoreNetworkPolicyDocumentNetworkFunctionGroup extends com.pulumi.resources.InvokeArgs {

    public static final GetCoreNetworkPolicyDocumentNetworkFunctionGroup Empty = new GetCoreNetworkPolicyDocumentNetworkFunctionGroup();

    /**
     * Optional description of the network function group.
     * 
     */
    @Import(name="description")
    private @Nullable String description;

    /**
     * @return Optional description of the network function group.
     * 
     */
    public Optional<String> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * This identifies the network function group container.
     * 
     */
    @Import(name="name", required=true)
    private String name;

    /**
     * @return This identifies the network function group container.
     * 
     */
    public String name() {
        return this.name;
    }

    /**
     * This will be either `true`, that attachment acceptance is required, or `false`, that it is not required.
     * 
     */
    @Import(name="requireAttachmentAcceptance", required=true)
    private Boolean requireAttachmentAcceptance;

    /**
     * @return This will be either `true`, that attachment acceptance is required, or `false`, that it is not required.
     * 
     */
    public Boolean requireAttachmentAcceptance() {
        return this.requireAttachmentAcceptance;
    }

    private GetCoreNetworkPolicyDocumentNetworkFunctionGroup() {}

    private GetCoreNetworkPolicyDocumentNetworkFunctionGroup(GetCoreNetworkPolicyDocumentNetworkFunctionGroup $) {
        this.description = $.description;
        this.name = $.name;
        this.requireAttachmentAcceptance = $.requireAttachmentAcceptance;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetCoreNetworkPolicyDocumentNetworkFunctionGroup defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetCoreNetworkPolicyDocumentNetworkFunctionGroup $;

        public Builder() {
            $ = new GetCoreNetworkPolicyDocumentNetworkFunctionGroup();
        }

        public Builder(GetCoreNetworkPolicyDocumentNetworkFunctionGroup defaults) {
            $ = new GetCoreNetworkPolicyDocumentNetworkFunctionGroup(Objects.requireNonNull(defaults));
        }

        /**
         * @param description Optional description of the network function group.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable String description) {
            $.description = description;
            return this;
        }

        /**
         * @param name This identifies the network function group container.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            $.name = name;
            return this;
        }

        /**
         * @param requireAttachmentAcceptance This will be either `true`, that attachment acceptance is required, or `false`, that it is not required.
         * 
         * @return builder
         * 
         */
        public Builder requireAttachmentAcceptance(Boolean requireAttachmentAcceptance) {
            $.requireAttachmentAcceptance = requireAttachmentAcceptance;
            return this;
        }

        public GetCoreNetworkPolicyDocumentNetworkFunctionGroup build() {
            if ($.name == null) {
                throw new MissingRequiredPropertyException("GetCoreNetworkPolicyDocumentNetworkFunctionGroup", "name");
            }
            if ($.requireAttachmentAcceptance == null) {
                throw new MissingRequiredPropertyException("GetCoreNetworkPolicyDocumentNetworkFunctionGroup", "requireAttachmentAcceptance");
            }
            return $;
        }
    }

}
