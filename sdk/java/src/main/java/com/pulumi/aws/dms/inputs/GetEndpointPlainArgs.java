// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dms.inputs;

import com.pulumi.aws.dms.inputs.GetEndpointElasticsearchSetting;
import com.pulumi.aws.dms.inputs.GetEndpointKafkaSetting;
import com.pulumi.aws.dms.inputs.GetEndpointMongodbSetting;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetEndpointPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetEndpointPlainArgs Empty = new GetEndpointPlainArgs();

    @Import(name="elasticsearchSettings")
    private @Nullable List<GetEndpointElasticsearchSetting> elasticsearchSettings;

    public Optional<List<GetEndpointElasticsearchSetting>> elasticsearchSettings() {
        return Optional.ofNullable(this.elasticsearchSettings);
    }

    /**
     * Database endpoint identifier. Identifiers must contain from 1 to 255 alphanumeric characters or hyphens, begin with a letter, contain only ASCII letters, digits, and hyphens, not end with a hyphen, and not contain two consecutive hyphens.
     * 
     */
    @Import(name="endpointId", required=true)
    private String endpointId;

    /**
     * @return Database endpoint identifier. Identifiers must contain from 1 to 255 alphanumeric characters or hyphens, begin with a letter, contain only ASCII letters, digits, and hyphens, not end with a hyphen, and not contain two consecutive hyphens.
     * 
     */
    public String endpointId() {
        return this.endpointId;
    }

    @Import(name="extraConnectionAttributes")
    private @Nullable String extraConnectionAttributes;

    public Optional<String> extraConnectionAttributes() {
        return Optional.ofNullable(this.extraConnectionAttributes);
    }

    @Import(name="kafkaSettings")
    private @Nullable List<GetEndpointKafkaSetting> kafkaSettings;

    public Optional<List<GetEndpointKafkaSetting>> kafkaSettings() {
        return Optional.ofNullable(this.kafkaSettings);
    }

    @Import(name="mongodbSettings")
    private @Nullable List<GetEndpointMongodbSetting> mongodbSettings;

    public Optional<List<GetEndpointMongodbSetting>> mongodbSettings() {
        return Optional.ofNullable(this.mongodbSettings);
    }

    @Import(name="tags")
    private @Nullable Map<String,String> tags;

    public Optional<Map<String,String>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetEndpointPlainArgs() {}

    private GetEndpointPlainArgs(GetEndpointPlainArgs $) {
        this.elasticsearchSettings = $.elasticsearchSettings;
        this.endpointId = $.endpointId;
        this.extraConnectionAttributes = $.extraConnectionAttributes;
        this.kafkaSettings = $.kafkaSettings;
        this.mongodbSettings = $.mongodbSettings;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetEndpointPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetEndpointPlainArgs $;

        public Builder() {
            $ = new GetEndpointPlainArgs();
        }

        public Builder(GetEndpointPlainArgs defaults) {
            $ = new GetEndpointPlainArgs(Objects.requireNonNull(defaults));
        }

        public Builder elasticsearchSettings(@Nullable List<GetEndpointElasticsearchSetting> elasticsearchSettings) {
            $.elasticsearchSettings = elasticsearchSettings;
            return this;
        }

        public Builder elasticsearchSettings(GetEndpointElasticsearchSetting... elasticsearchSettings) {
            return elasticsearchSettings(List.of(elasticsearchSettings));
        }

        /**
         * @param endpointId Database endpoint identifier. Identifiers must contain from 1 to 255 alphanumeric characters or hyphens, begin with a letter, contain only ASCII letters, digits, and hyphens, not end with a hyphen, and not contain two consecutive hyphens.
         * 
         * @return builder
         * 
         */
        public Builder endpointId(String endpointId) {
            $.endpointId = endpointId;
            return this;
        }

        public Builder extraConnectionAttributes(@Nullable String extraConnectionAttributes) {
            $.extraConnectionAttributes = extraConnectionAttributes;
            return this;
        }

        public Builder kafkaSettings(@Nullable List<GetEndpointKafkaSetting> kafkaSettings) {
            $.kafkaSettings = kafkaSettings;
            return this;
        }

        public Builder kafkaSettings(GetEndpointKafkaSetting... kafkaSettings) {
            return kafkaSettings(List.of(kafkaSettings));
        }

        public Builder mongodbSettings(@Nullable List<GetEndpointMongodbSetting> mongodbSettings) {
            $.mongodbSettings = mongodbSettings;
            return this;
        }

        public Builder mongodbSettings(GetEndpointMongodbSetting... mongodbSettings) {
            return mongodbSettings(List.of(mongodbSettings));
        }

        public Builder tags(@Nullable Map<String,String> tags) {
            $.tags = tags;
            return this;
        }

        public GetEndpointPlainArgs build() {
            $.endpointId = Objects.requireNonNull($.endpointId, "expected parameter 'endpointId' to be non-null");
            return $;
        }
    }

}