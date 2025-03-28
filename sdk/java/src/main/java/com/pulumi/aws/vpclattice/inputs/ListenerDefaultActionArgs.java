// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.vpclattice.inputs;

import com.pulumi.aws.vpclattice.inputs.ListenerDefaultActionFixedResponseArgs;
import com.pulumi.aws.vpclattice.inputs.ListenerDefaultActionForwardArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ListenerDefaultActionArgs extends com.pulumi.resources.ResourceArgs {

    public static final ListenerDefaultActionArgs Empty = new ListenerDefaultActionArgs();

    @Import(name="fixedResponse")
    private @Nullable Output<ListenerDefaultActionFixedResponseArgs> fixedResponse;

    public Optional<Output<ListenerDefaultActionFixedResponseArgs>> fixedResponse() {
        return Optional.ofNullable(this.fixedResponse);
    }

    /**
     * Route requests to one or more target groups. See Forward blocks below.
     * 
     * &gt; **NOTE:** You must specify exactly one of the following argument blocks: `fixed_response` or `forward`.
     * 
     */
    @Import(name="forwards")
    private @Nullable Output<List<ListenerDefaultActionForwardArgs>> forwards;

    /**
     * @return Route requests to one or more target groups. See Forward blocks below.
     * 
     * &gt; **NOTE:** You must specify exactly one of the following argument blocks: `fixed_response` or `forward`.
     * 
     */
    public Optional<Output<List<ListenerDefaultActionForwardArgs>>> forwards() {
        return Optional.ofNullable(this.forwards);
    }

    private ListenerDefaultActionArgs() {}

    private ListenerDefaultActionArgs(ListenerDefaultActionArgs $) {
        this.fixedResponse = $.fixedResponse;
        this.forwards = $.forwards;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ListenerDefaultActionArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ListenerDefaultActionArgs $;

        public Builder() {
            $ = new ListenerDefaultActionArgs();
        }

        public Builder(ListenerDefaultActionArgs defaults) {
            $ = new ListenerDefaultActionArgs(Objects.requireNonNull(defaults));
        }

        public Builder fixedResponse(@Nullable Output<ListenerDefaultActionFixedResponseArgs> fixedResponse) {
            $.fixedResponse = fixedResponse;
            return this;
        }

        public Builder fixedResponse(ListenerDefaultActionFixedResponseArgs fixedResponse) {
            return fixedResponse(Output.of(fixedResponse));
        }

        /**
         * @param forwards Route requests to one or more target groups. See Forward blocks below.
         * 
         * &gt; **NOTE:** You must specify exactly one of the following argument blocks: `fixed_response` or `forward`.
         * 
         * @return builder
         * 
         */
        public Builder forwards(@Nullable Output<List<ListenerDefaultActionForwardArgs>> forwards) {
            $.forwards = forwards;
            return this;
        }

        /**
         * @param forwards Route requests to one or more target groups. See Forward blocks below.
         * 
         * &gt; **NOTE:** You must specify exactly one of the following argument blocks: `fixed_response` or `forward`.
         * 
         * @return builder
         * 
         */
        public Builder forwards(List<ListenerDefaultActionForwardArgs> forwards) {
            return forwards(Output.of(forwards));
        }

        /**
         * @param forwards Route requests to one or more target groups. See Forward blocks below.
         * 
         * &gt; **NOTE:** You must specify exactly one of the following argument blocks: `fixed_response` or `forward`.
         * 
         * @return builder
         * 
         */
        public Builder forwards(ListenerDefaultActionForwardArgs... forwards) {
            return forwards(List.of(forwards));
        }

        public ListenerDefaultActionArgs build() {
            return $;
        }
    }

}
