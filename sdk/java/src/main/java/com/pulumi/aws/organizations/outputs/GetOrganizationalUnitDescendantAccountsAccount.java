// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.organizations.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetOrganizationalUnitDescendantAccountsAccount {
    /**
     * @return The Amazon Resource Name (ARN) of the account.
     * 
     */
    private String arn;
    /**
     * @return The email address associated with the AWS account.
     * 
     */
    private String email;
    /**
     * @return Parent identifier of the organizational units.
     * 
     */
    private String id;
    /**
     * @return The friendly name of the account.
     * 
     */
    private String name;
    /**
     * @return The status of the account in the organization.
     * 
     */
    private String status;

    private GetOrganizationalUnitDescendantAccountsAccount() {}
    /**
     * @return The Amazon Resource Name (ARN) of the account.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return The email address associated with the AWS account.
     * 
     */
    public String email() {
        return this.email;
    }
    /**
     * @return Parent identifier of the organizational units.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return The friendly name of the account.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return The status of the account in the organization.
     * 
     */
    public String status() {
        return this.status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetOrganizationalUnitDescendantAccountsAccount defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String email;
        private String id;
        private String name;
        private String status;
        public Builder() {}
        public Builder(GetOrganizationalUnitDescendantAccountsAccount defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.email = defaults.email;
    	      this.id = defaults.id;
    	      this.name = defaults.name;
    	      this.status = defaults.status;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetOrganizationalUnitDescendantAccountsAccount", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder email(String email) {
            if (email == null) {
              throw new MissingRequiredPropertyException("GetOrganizationalUnitDescendantAccountsAccount", "email");
            }
            this.email = email;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetOrganizationalUnitDescendantAccountsAccount", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetOrganizationalUnitDescendantAccountsAccount", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder status(String status) {
            if (status == null) {
              throw new MissingRequiredPropertyException("GetOrganizationalUnitDescendantAccountsAccount", "status");
            }
            this.status = status;
            return this;
        }
        public GetOrganizationalUnitDescendantAccountsAccount build() {
            final var _resultValue = new GetOrganizationalUnitDescendantAccountsAccount();
            _resultValue.arn = arn;
            _resultValue.email = email;
            _resultValue.id = id;
            _resultValue.name = name;
            _resultValue.status = status;
            return _resultValue;
        }
    }
}
