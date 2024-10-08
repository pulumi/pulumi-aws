// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch.inputs;

import com.pulumi.aws.cloudwatch.inputs.EventConnectionAuthParametersInvocationHttpParametersBodyArgs;
import com.pulumi.aws.cloudwatch.inputs.EventConnectionAuthParametersInvocationHttpParametersHeaderArgs;
import com.pulumi.aws.cloudwatch.inputs.EventConnectionAuthParametersInvocationHttpParametersQueryStringArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class EventConnectionAuthParametersInvocationHttpParametersArgs extends com.pulumi.resources.ResourceArgs {

    public static final EventConnectionAuthParametersInvocationHttpParametersArgs Empty = new EventConnectionAuthParametersInvocationHttpParametersArgs();

    /**
     * Contains additional body string parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
     * 
     */
    @Import(name="bodies")
    private @Nullable Output<List<EventConnectionAuthParametersInvocationHttpParametersBodyArgs>> bodies;

    /**
     * @return Contains additional body string parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
     * 
     */
    public Optional<Output<List<EventConnectionAuthParametersInvocationHttpParametersBodyArgs>>> bodies() {
        return Optional.ofNullable(this.bodies);
    }

    /**
     * Contains additional header parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
     * 
     */
    @Import(name="headers")
    private @Nullable Output<List<EventConnectionAuthParametersInvocationHttpParametersHeaderArgs>> headers;

    /**
     * @return Contains additional header parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
     * 
     */
    public Optional<Output<List<EventConnectionAuthParametersInvocationHttpParametersHeaderArgs>>> headers() {
        return Optional.ofNullable(this.headers);
    }

    /**
     * Contains additional query string parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
     * 
     */
    @Import(name="queryStrings")
    private @Nullable Output<List<EventConnectionAuthParametersInvocationHttpParametersQueryStringArgs>> queryStrings;

    /**
     * @return Contains additional query string parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
     * 
     */
    public Optional<Output<List<EventConnectionAuthParametersInvocationHttpParametersQueryStringArgs>>> queryStrings() {
        return Optional.ofNullable(this.queryStrings);
    }

    private EventConnectionAuthParametersInvocationHttpParametersArgs() {}

    private EventConnectionAuthParametersInvocationHttpParametersArgs(EventConnectionAuthParametersInvocationHttpParametersArgs $) {
        this.bodies = $.bodies;
        this.headers = $.headers;
        this.queryStrings = $.queryStrings;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EventConnectionAuthParametersInvocationHttpParametersArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EventConnectionAuthParametersInvocationHttpParametersArgs $;

        public Builder() {
            $ = new EventConnectionAuthParametersInvocationHttpParametersArgs();
        }

        public Builder(EventConnectionAuthParametersInvocationHttpParametersArgs defaults) {
            $ = new EventConnectionAuthParametersInvocationHttpParametersArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param bodies Contains additional body string parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
         * 
         * @return builder
         * 
         */
        public Builder bodies(@Nullable Output<List<EventConnectionAuthParametersInvocationHttpParametersBodyArgs>> bodies) {
            $.bodies = bodies;
            return this;
        }

        /**
         * @param bodies Contains additional body string parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
         * 
         * @return builder
         * 
         */
        public Builder bodies(List<EventConnectionAuthParametersInvocationHttpParametersBodyArgs> bodies) {
            return bodies(Output.of(bodies));
        }

        /**
         * @param bodies Contains additional body string parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
         * 
         * @return builder
         * 
         */
        public Builder bodies(EventConnectionAuthParametersInvocationHttpParametersBodyArgs... bodies) {
            return bodies(List.of(bodies));
        }

        /**
         * @param headers Contains additional header parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
         * 
         * @return builder
         * 
         */
        public Builder headers(@Nullable Output<List<EventConnectionAuthParametersInvocationHttpParametersHeaderArgs>> headers) {
            $.headers = headers;
            return this;
        }

        /**
         * @param headers Contains additional header parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
         * 
         * @return builder
         * 
         */
        public Builder headers(List<EventConnectionAuthParametersInvocationHttpParametersHeaderArgs> headers) {
            return headers(Output.of(headers));
        }

        /**
         * @param headers Contains additional header parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
         * 
         * @return builder
         * 
         */
        public Builder headers(EventConnectionAuthParametersInvocationHttpParametersHeaderArgs... headers) {
            return headers(List.of(headers));
        }

        /**
         * @param queryStrings Contains additional query string parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
         * 
         * @return builder
         * 
         */
        public Builder queryStrings(@Nullable Output<List<EventConnectionAuthParametersInvocationHttpParametersQueryStringArgs>> queryStrings) {
            $.queryStrings = queryStrings;
            return this;
        }

        /**
         * @param queryStrings Contains additional query string parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
         * 
         * @return builder
         * 
         */
        public Builder queryStrings(List<EventConnectionAuthParametersInvocationHttpParametersQueryStringArgs> queryStrings) {
            return queryStrings(Output.of(queryStrings));
        }

        /**
         * @param queryStrings Contains additional query string parameters for the connection. You can include up to 100 additional body string parameters per request. Each additional parameter counts towards the event payload size, which cannot exceed 64 KB. Each parameter can contain the following:
         * 
         * @return builder
         * 
         */
        public Builder queryStrings(EventConnectionAuthParametersInvocationHttpParametersQueryStringArgs... queryStrings) {
            return queryStrings(List.of(queryStrings));
        }

        public EventConnectionAuthParametersInvocationHttpParametersArgs build() {
            return $;
        }
    }

}
