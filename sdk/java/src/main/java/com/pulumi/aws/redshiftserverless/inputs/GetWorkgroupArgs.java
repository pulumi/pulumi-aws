// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.redshiftserverless.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;


public final class GetWorkgroupArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetWorkgroupArgs Empty = new GetWorkgroupArgs();

    /**
     * The name of the workgroup associated with the database.
     * 
     */
    @Import(name="workgroupName", required=true)
    private Output<String> workgroupName;

    /**
     * @return The name of the workgroup associated with the database.
     * 
     */
    public Output<String> workgroupName() {
        return this.workgroupName;
    }

    private GetWorkgroupArgs() {}

    private GetWorkgroupArgs(GetWorkgroupArgs $) {
        this.workgroupName = $.workgroupName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetWorkgroupArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetWorkgroupArgs $;

        public Builder() {
            $ = new GetWorkgroupArgs();
        }

        public Builder(GetWorkgroupArgs defaults) {
            $ = new GetWorkgroupArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param workgroupName The name of the workgroup associated with the database.
         * 
         * @return builder
         * 
         */
        public Builder workgroupName(Output<String> workgroupName) {
            $.workgroupName = workgroupName;
            return this;
        }

        /**
         * @param workgroupName The name of the workgroup associated with the database.
         * 
         * @return builder
         * 
         */
        public Builder workgroupName(String workgroupName) {
            return workgroupName(Output.of(workgroupName));
        }

        public GetWorkgroupArgs build() {
            $.workgroupName = Objects.requireNonNull($.workgroupName, "expected parameter 'workgroupName' to be non-null");
            return $;
        }
    }

}