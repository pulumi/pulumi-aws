// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.amp.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class ScraperDestinationAmp {
    /**
     * @return The Amazon Resource Name (ARN) of the prometheus workspace.
     * 
     */
    private String workspaceArn;

    private ScraperDestinationAmp() {}
    /**
     * @return The Amazon Resource Name (ARN) of the prometheus workspace.
     * 
     */
    public String workspaceArn() {
        return this.workspaceArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ScraperDestinationAmp defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String workspaceArn;
        public Builder() {}
        public Builder(ScraperDestinationAmp defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.workspaceArn = defaults.workspaceArn;
        }

        @CustomType.Setter
        public Builder workspaceArn(String workspaceArn) {
            if (workspaceArn == null) {
              throw new MissingRequiredPropertyException("ScraperDestinationAmp", "workspaceArn");
            }
            this.workspaceArn = workspaceArn;
            return this;
        }
        public ScraperDestinationAmp build() {
            final var _resultValue = new ScraperDestinationAmp();
            _resultValue.workspaceArn = workspaceArn;
            return _resultValue;
        }
    }
}
