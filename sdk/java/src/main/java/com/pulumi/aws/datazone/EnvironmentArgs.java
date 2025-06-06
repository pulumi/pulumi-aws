// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.datazone;

import com.pulumi.aws.datazone.inputs.EnvironmentTimeoutsArgs;
import com.pulumi.aws.datazone.inputs.EnvironmentUserParameterArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class EnvironmentArgs extends com.pulumi.resources.ResourceArgs {

    public static final EnvironmentArgs Empty = new EnvironmentArgs();

    /**
     * The ID of the Amazon Web Services account where the environment exists
     * 
     */
    @Import(name="accountIdentifier")
    private @Nullable Output<String> accountIdentifier;

    /**
     * @return The ID of the Amazon Web Services account where the environment exists
     * 
     */
    public Optional<Output<String>> accountIdentifier() {
        return Optional.ofNullable(this.accountIdentifier);
    }

    /**
     * The Amazon Web Services region where the environment exists.
     * 
     */
    @Import(name="accountRegion")
    private @Nullable Output<String> accountRegion;

    /**
     * @return The Amazon Web Services region where the environment exists.
     * 
     */
    public Optional<Output<String>> accountRegion() {
        return Optional.ofNullable(this.accountRegion);
    }

    /**
     * The blueprint with which the environment is created.
     * 
     */
    @Import(name="blueprintIdentifier")
    private @Nullable Output<String> blueprintIdentifier;

    /**
     * @return The blueprint with which the environment is created.
     * 
     */
    public Optional<Output<String>> blueprintIdentifier() {
        return Optional.ofNullable(this.blueprintIdentifier);
    }

    /**
     * The description of the environment.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return The description of the environment.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * The ID of the domain where the environment exists.
     * 
     */
    @Import(name="domainIdentifier", required=true)
    private Output<String> domainIdentifier;

    /**
     * @return The ID of the domain where the environment exists.
     * 
     */
    public Output<String> domainIdentifier() {
        return this.domainIdentifier;
    }

    /**
     * The business glossary terms that can be used in this environment.
     * 
     */
    @Import(name="glossaryTerms")
    private @Nullable Output<List<String>> glossaryTerms;

    /**
     * @return The business glossary terms that can be used in this environment.
     * 
     */
    public Optional<Output<List<String>>> glossaryTerms() {
        return Optional.ofNullable(this.glossaryTerms);
    }

    /**
     * The name of the environment.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The name of the environment.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * The ID of the profile with which the environment is created.
     * 
     */
    @Import(name="profileIdentifier", required=true)
    private Output<String> profileIdentifier;

    /**
     * @return The ID of the profile with which the environment is created.
     * 
     */
    public Output<String> profileIdentifier() {
        return this.profileIdentifier;
    }

    /**
     * The ID of the project where the environment exists.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="projectIdentifier", required=true)
    private Output<String> projectIdentifier;

    /**
     * @return The ID of the project where the environment exists.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> projectIdentifier() {
        return this.projectIdentifier;
    }

    @Import(name="timeouts")
    private @Nullable Output<EnvironmentTimeoutsArgs> timeouts;

    public Optional<Output<EnvironmentTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    /**
     * The user parameters that are used in the environment. See User Parameters for more information.
     * 
     */
    @Import(name="userParameters")
    private @Nullable Output<List<EnvironmentUserParameterArgs>> userParameters;

    /**
     * @return The user parameters that are used in the environment. See User Parameters for more information.
     * 
     */
    public Optional<Output<List<EnvironmentUserParameterArgs>>> userParameters() {
        return Optional.ofNullable(this.userParameters);
    }

    private EnvironmentArgs() {}

    private EnvironmentArgs(EnvironmentArgs $) {
        this.accountIdentifier = $.accountIdentifier;
        this.accountRegion = $.accountRegion;
        this.blueprintIdentifier = $.blueprintIdentifier;
        this.description = $.description;
        this.domainIdentifier = $.domainIdentifier;
        this.glossaryTerms = $.glossaryTerms;
        this.name = $.name;
        this.profileIdentifier = $.profileIdentifier;
        this.projectIdentifier = $.projectIdentifier;
        this.timeouts = $.timeouts;
        this.userParameters = $.userParameters;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EnvironmentArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EnvironmentArgs $;

        public Builder() {
            $ = new EnvironmentArgs();
        }

        public Builder(EnvironmentArgs defaults) {
            $ = new EnvironmentArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param accountIdentifier The ID of the Amazon Web Services account where the environment exists
         * 
         * @return builder
         * 
         */
        public Builder accountIdentifier(@Nullable Output<String> accountIdentifier) {
            $.accountIdentifier = accountIdentifier;
            return this;
        }

        /**
         * @param accountIdentifier The ID of the Amazon Web Services account where the environment exists
         * 
         * @return builder
         * 
         */
        public Builder accountIdentifier(String accountIdentifier) {
            return accountIdentifier(Output.of(accountIdentifier));
        }

        /**
         * @param accountRegion The Amazon Web Services region where the environment exists.
         * 
         * @return builder
         * 
         */
        public Builder accountRegion(@Nullable Output<String> accountRegion) {
            $.accountRegion = accountRegion;
            return this;
        }

        /**
         * @param accountRegion The Amazon Web Services region where the environment exists.
         * 
         * @return builder
         * 
         */
        public Builder accountRegion(String accountRegion) {
            return accountRegion(Output.of(accountRegion));
        }

        /**
         * @param blueprintIdentifier The blueprint with which the environment is created.
         * 
         * @return builder
         * 
         */
        public Builder blueprintIdentifier(@Nullable Output<String> blueprintIdentifier) {
            $.blueprintIdentifier = blueprintIdentifier;
            return this;
        }

        /**
         * @param blueprintIdentifier The blueprint with which the environment is created.
         * 
         * @return builder
         * 
         */
        public Builder blueprintIdentifier(String blueprintIdentifier) {
            return blueprintIdentifier(Output.of(blueprintIdentifier));
        }

        /**
         * @param description The description of the environment.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description The description of the environment.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param domainIdentifier The ID of the domain where the environment exists.
         * 
         * @return builder
         * 
         */
        public Builder domainIdentifier(Output<String> domainIdentifier) {
            $.domainIdentifier = domainIdentifier;
            return this;
        }

        /**
         * @param domainIdentifier The ID of the domain where the environment exists.
         * 
         * @return builder
         * 
         */
        public Builder domainIdentifier(String domainIdentifier) {
            return domainIdentifier(Output.of(domainIdentifier));
        }

        /**
         * @param glossaryTerms The business glossary terms that can be used in this environment.
         * 
         * @return builder
         * 
         */
        public Builder glossaryTerms(@Nullable Output<List<String>> glossaryTerms) {
            $.glossaryTerms = glossaryTerms;
            return this;
        }

        /**
         * @param glossaryTerms The business glossary terms that can be used in this environment.
         * 
         * @return builder
         * 
         */
        public Builder glossaryTerms(List<String> glossaryTerms) {
            return glossaryTerms(Output.of(glossaryTerms));
        }

        /**
         * @param glossaryTerms The business glossary terms that can be used in this environment.
         * 
         * @return builder
         * 
         */
        public Builder glossaryTerms(String... glossaryTerms) {
            return glossaryTerms(List.of(glossaryTerms));
        }

        /**
         * @param name The name of the environment.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of the environment.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param profileIdentifier The ID of the profile with which the environment is created.
         * 
         * @return builder
         * 
         */
        public Builder profileIdentifier(Output<String> profileIdentifier) {
            $.profileIdentifier = profileIdentifier;
            return this;
        }

        /**
         * @param profileIdentifier The ID of the profile with which the environment is created.
         * 
         * @return builder
         * 
         */
        public Builder profileIdentifier(String profileIdentifier) {
            return profileIdentifier(Output.of(profileIdentifier));
        }

        /**
         * @param projectIdentifier The ID of the project where the environment exists.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder projectIdentifier(Output<String> projectIdentifier) {
            $.projectIdentifier = projectIdentifier;
            return this;
        }

        /**
         * @param projectIdentifier The ID of the project where the environment exists.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder projectIdentifier(String projectIdentifier) {
            return projectIdentifier(Output.of(projectIdentifier));
        }

        public Builder timeouts(@Nullable Output<EnvironmentTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(EnvironmentTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        /**
         * @param userParameters The user parameters that are used in the environment. See User Parameters for more information.
         * 
         * @return builder
         * 
         */
        public Builder userParameters(@Nullable Output<List<EnvironmentUserParameterArgs>> userParameters) {
            $.userParameters = userParameters;
            return this;
        }

        /**
         * @param userParameters The user parameters that are used in the environment. See User Parameters for more information.
         * 
         * @return builder
         * 
         */
        public Builder userParameters(List<EnvironmentUserParameterArgs> userParameters) {
            return userParameters(Output.of(userParameters));
        }

        /**
         * @param userParameters The user parameters that are used in the environment. See User Parameters for more information.
         * 
         * @return builder
         * 
         */
        public Builder userParameters(EnvironmentUserParameterArgs... userParameters) {
            return userParameters(List.of(userParameters));
        }

        public EnvironmentArgs build() {
            if ($.domainIdentifier == null) {
                throw new MissingRequiredPropertyException("EnvironmentArgs", "domainIdentifier");
            }
            if ($.profileIdentifier == null) {
                throw new MissingRequiredPropertyException("EnvironmentArgs", "profileIdentifier");
            }
            if ($.projectIdentifier == null) {
                throw new MissingRequiredPropertyException("EnvironmentArgs", "projectIdentifier");
            }
            return $;
        }
    }

}
