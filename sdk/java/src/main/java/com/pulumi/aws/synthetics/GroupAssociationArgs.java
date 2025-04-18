// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.synthetics;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class GroupAssociationArgs extends com.pulumi.resources.ResourceArgs {

    public static final GroupAssociationArgs Empty = new GroupAssociationArgs();

    /**
     * ARN of the canary.
     * 
     */
    @Import(name="canaryArn", required=true)
    private Output<String> canaryArn;

    /**
     * @return ARN of the canary.
     * 
     */
    public Output<String> canaryArn() {
        return this.canaryArn;
    }

    /**
     * Name of the group that the canary will be associated with.
     * 
     */
    @Import(name="groupName", required=true)
    private Output<String> groupName;

    /**
     * @return Name of the group that the canary will be associated with.
     * 
     */
    public Output<String> groupName() {
        return this.groupName;
    }

    private GroupAssociationArgs() {}

    private GroupAssociationArgs(GroupAssociationArgs $) {
        this.canaryArn = $.canaryArn;
        this.groupName = $.groupName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GroupAssociationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GroupAssociationArgs $;

        public Builder() {
            $ = new GroupAssociationArgs();
        }

        public Builder(GroupAssociationArgs defaults) {
            $ = new GroupAssociationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param canaryArn ARN of the canary.
         * 
         * @return builder
         * 
         */
        public Builder canaryArn(Output<String> canaryArn) {
            $.canaryArn = canaryArn;
            return this;
        }

        /**
         * @param canaryArn ARN of the canary.
         * 
         * @return builder
         * 
         */
        public Builder canaryArn(String canaryArn) {
            return canaryArn(Output.of(canaryArn));
        }

        /**
         * @param groupName Name of the group that the canary will be associated with.
         * 
         * @return builder
         * 
         */
        public Builder groupName(Output<String> groupName) {
            $.groupName = groupName;
            return this;
        }

        /**
         * @param groupName Name of the group that the canary will be associated with.
         * 
         * @return builder
         * 
         */
        public Builder groupName(String groupName) {
            return groupName(Output.of(groupName));
        }

        public GroupAssociationArgs build() {
            if ($.canaryArn == null) {
                throw new MissingRequiredPropertyException("GroupAssociationArgs", "canaryArn");
            }
            if ($.groupName == null) {
                throw new MissingRequiredPropertyException("GroupAssociationArgs", "groupName");
            }
            return $;
        }
    }

}
