// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dms.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;


public final class GetEndpointMongodbSettingArgs extends com.pulumi.resources.ResourceArgs {

    public static final GetEndpointMongodbSettingArgs Empty = new GetEndpointMongodbSettingArgs();

    @Import(name="authMechanism", required=true)
    private Output<String> authMechanism;

    public Output<String> authMechanism() {
        return this.authMechanism;
    }

    @Import(name="authSource", required=true)
    private Output<String> authSource;

    public Output<String> authSource() {
        return this.authSource;
    }

    @Import(name="authType", required=true)
    private Output<String> authType;

    public Output<String> authType() {
        return this.authType;
    }

    @Import(name="docsToInvestigate", required=true)
    private Output<String> docsToInvestigate;

    public Output<String> docsToInvestigate() {
        return this.docsToInvestigate;
    }

    @Import(name="extractDocId", required=true)
    private Output<String> extractDocId;

    public Output<String> extractDocId() {
        return this.extractDocId;
    }

    @Import(name="nestingLevel", required=true)
    private Output<String> nestingLevel;

    public Output<String> nestingLevel() {
        return this.nestingLevel;
    }

    private GetEndpointMongodbSettingArgs() {}

    private GetEndpointMongodbSettingArgs(GetEndpointMongodbSettingArgs $) {
        this.authMechanism = $.authMechanism;
        this.authSource = $.authSource;
        this.authType = $.authType;
        this.docsToInvestigate = $.docsToInvestigate;
        this.extractDocId = $.extractDocId;
        this.nestingLevel = $.nestingLevel;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetEndpointMongodbSettingArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetEndpointMongodbSettingArgs $;

        public Builder() {
            $ = new GetEndpointMongodbSettingArgs();
        }

        public Builder(GetEndpointMongodbSettingArgs defaults) {
            $ = new GetEndpointMongodbSettingArgs(Objects.requireNonNull(defaults));
        }

        public Builder authMechanism(Output<String> authMechanism) {
            $.authMechanism = authMechanism;
            return this;
        }

        public Builder authMechanism(String authMechanism) {
            return authMechanism(Output.of(authMechanism));
        }

        public Builder authSource(Output<String> authSource) {
            $.authSource = authSource;
            return this;
        }

        public Builder authSource(String authSource) {
            return authSource(Output.of(authSource));
        }

        public Builder authType(Output<String> authType) {
            $.authType = authType;
            return this;
        }

        public Builder authType(String authType) {
            return authType(Output.of(authType));
        }

        public Builder docsToInvestigate(Output<String> docsToInvestigate) {
            $.docsToInvestigate = docsToInvestigate;
            return this;
        }

        public Builder docsToInvestigate(String docsToInvestigate) {
            return docsToInvestigate(Output.of(docsToInvestigate));
        }

        public Builder extractDocId(Output<String> extractDocId) {
            $.extractDocId = extractDocId;
            return this;
        }

        public Builder extractDocId(String extractDocId) {
            return extractDocId(Output.of(extractDocId));
        }

        public Builder nestingLevel(Output<String> nestingLevel) {
            $.nestingLevel = nestingLevel;
            return this;
        }

        public Builder nestingLevel(String nestingLevel) {
            return nestingLevel(Output.of(nestingLevel));
        }

        public GetEndpointMongodbSettingArgs build() {
            $.authMechanism = Objects.requireNonNull($.authMechanism, "expected parameter 'authMechanism' to be non-null");
            $.authSource = Objects.requireNonNull($.authSource, "expected parameter 'authSource' to be non-null");
            $.authType = Objects.requireNonNull($.authType, "expected parameter 'authType' to be non-null");
            $.docsToInvestigate = Objects.requireNonNull($.docsToInvestigate, "expected parameter 'docsToInvestigate' to be non-null");
            $.extractDocId = Objects.requireNonNull($.extractDocId, "expected parameter 'extractDocId' to be non-null");
            $.nestingLevel = Objects.requireNonNull($.nestingLevel, "expected parameter 'nestingLevel' to be non-null");
            return $;
        }
    }

}