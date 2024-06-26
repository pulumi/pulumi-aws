// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkmanager.inputs;

import com.pulumi.aws.networkmanager.inputs.GetCoreNetworkPolicyDocumentSegmentActionViaWithEdgeOverrideArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetCoreNetworkPolicyDocumentSegmentActionViaArgs extends com.pulumi.resources.ResourceArgs {

    public static final GetCoreNetworkPolicyDocumentSegmentActionViaArgs Empty = new GetCoreNetworkPolicyDocumentSegmentActionViaArgs();

    /**
     * A list of strings. The network function group to use for the service insertion action.
     * 
     */
    @Import(name="networkFunctionGroups")
    private @Nullable Output<List<String>> networkFunctionGroups;

    /**
     * @return A list of strings. The network function group to use for the service insertion action.
     * 
     */
    public Optional<Output<List<String>>> networkFunctionGroups() {
        return Optional.ofNullable(this.networkFunctionGroups);
    }

    /**
     * Any edge overrides and the preferred edge to use.
     * 
     */
    @Import(name="withEdgeOverrides")
    private @Nullable Output<List<GetCoreNetworkPolicyDocumentSegmentActionViaWithEdgeOverrideArgs>> withEdgeOverrides;

    /**
     * @return Any edge overrides and the preferred edge to use.
     * 
     */
    public Optional<Output<List<GetCoreNetworkPolicyDocumentSegmentActionViaWithEdgeOverrideArgs>>> withEdgeOverrides() {
        return Optional.ofNullable(this.withEdgeOverrides);
    }

    private GetCoreNetworkPolicyDocumentSegmentActionViaArgs() {}

    private GetCoreNetworkPolicyDocumentSegmentActionViaArgs(GetCoreNetworkPolicyDocumentSegmentActionViaArgs $) {
        this.networkFunctionGroups = $.networkFunctionGroups;
        this.withEdgeOverrides = $.withEdgeOverrides;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetCoreNetworkPolicyDocumentSegmentActionViaArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetCoreNetworkPolicyDocumentSegmentActionViaArgs $;

        public Builder() {
            $ = new GetCoreNetworkPolicyDocumentSegmentActionViaArgs();
        }

        public Builder(GetCoreNetworkPolicyDocumentSegmentActionViaArgs defaults) {
            $ = new GetCoreNetworkPolicyDocumentSegmentActionViaArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param networkFunctionGroups A list of strings. The network function group to use for the service insertion action.
         * 
         * @return builder
         * 
         */
        public Builder networkFunctionGroups(@Nullable Output<List<String>> networkFunctionGroups) {
            $.networkFunctionGroups = networkFunctionGroups;
            return this;
        }

        /**
         * @param networkFunctionGroups A list of strings. The network function group to use for the service insertion action.
         * 
         * @return builder
         * 
         */
        public Builder networkFunctionGroups(List<String> networkFunctionGroups) {
            return networkFunctionGroups(Output.of(networkFunctionGroups));
        }

        /**
         * @param networkFunctionGroups A list of strings. The network function group to use for the service insertion action.
         * 
         * @return builder
         * 
         */
        public Builder networkFunctionGroups(String... networkFunctionGroups) {
            return networkFunctionGroups(List.of(networkFunctionGroups));
        }

        /**
         * @param withEdgeOverrides Any edge overrides and the preferred edge to use.
         * 
         * @return builder
         * 
         */
        public Builder withEdgeOverrides(@Nullable Output<List<GetCoreNetworkPolicyDocumentSegmentActionViaWithEdgeOverrideArgs>> withEdgeOverrides) {
            $.withEdgeOverrides = withEdgeOverrides;
            return this;
        }

        /**
         * @param withEdgeOverrides Any edge overrides and the preferred edge to use.
         * 
         * @return builder
         * 
         */
        public Builder withEdgeOverrides(List<GetCoreNetworkPolicyDocumentSegmentActionViaWithEdgeOverrideArgs> withEdgeOverrides) {
            return withEdgeOverrides(Output.of(withEdgeOverrides));
        }

        /**
         * @param withEdgeOverrides Any edge overrides and the preferred edge to use.
         * 
         * @return builder
         * 
         */
        public Builder withEdgeOverrides(GetCoreNetworkPolicyDocumentSegmentActionViaWithEdgeOverrideArgs... withEdgeOverrides) {
            return withEdgeOverrides(List.of(withEdgeOverrides));
        }

        public GetCoreNetworkPolicyDocumentSegmentActionViaArgs build() {
            return $;
        }
    }

}
