// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.organizations.outputs;

import com.pulumi.aws.organizations.outputs.GetOrganizationAccount;
import com.pulumi.aws.organizations.outputs.GetOrganizationNonMasterAccount;
import com.pulumi.aws.organizations.outputs.GetOrganizationRoot;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetOrganizationResult {
    /**
     * @return List of organization accounts including the master account. For a list excluding the master account, see the `non_master_accounts` attribute. All elements have these attributes:
     * 
     */
    private List<GetOrganizationAccount> accounts;
    /**
     * @return ARN of the root
     * 
     */
    private String arn;
    /**
     * @return A list of AWS service principal names that have integration enabled with your organization. Organization must have `feature_set` set to `ALL`. For additional information, see the [AWS Organizations User Guide](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_integrate_services.html).
     * 
     */
    private List<String> awsServiceAccessPrincipals;
    /**
     * @return A list of Organizations policy types that are enabled in the Organization Root. Organization must have `feature_set` set to `ALL`. For additional information about valid policy types (e.g., `SERVICE_CONTROL_POLICY`), see the [AWS Organizations API Reference](https://docs.aws.amazon.com/organizations/latest/APIReference/API_EnablePolicyType.html).
     * 
     */
    private List<String> enabledPolicyTypes;
    /**
     * @return FeatureSet of the organization.
     * 
     */
    private String featureSet;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return ARN of the account that is designated as the master account for the organization.
     * 
     */
    private String masterAccountArn;
    /**
     * @return The email address that is associated with the AWS account that is designated as the master account for the organization.
     * 
     */
    private String masterAccountEmail;
    /**
     * @return Unique identifier (ID) of the master account of an organization.
     * 
     */
    private String masterAccountId;
    /**
     * @return Name of the master account of an organization.
     * 
     */
    private String masterAccountName;
    /**
     * @return List of organization accounts excluding the master account. For a list including the master account, see the `accounts` attribute. All elements have these attributes:
     * 
     */
    private List<GetOrganizationNonMasterAccount> nonMasterAccounts;
    /**
     * @return List of organization roots. All elements have these attributes:
     * 
     */
    private List<GetOrganizationRoot> roots;

    private GetOrganizationResult() {}
    /**
     * @return List of organization accounts including the master account. For a list excluding the master account, see the `non_master_accounts` attribute. All elements have these attributes:
     * 
     */
    public List<GetOrganizationAccount> accounts() {
        return this.accounts;
    }
    /**
     * @return ARN of the root
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return A list of AWS service principal names that have integration enabled with your organization. Organization must have `feature_set` set to `ALL`. For additional information, see the [AWS Organizations User Guide](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_integrate_services.html).
     * 
     */
    public List<String> awsServiceAccessPrincipals() {
        return this.awsServiceAccessPrincipals;
    }
    /**
     * @return A list of Organizations policy types that are enabled in the Organization Root. Organization must have `feature_set` set to `ALL`. For additional information about valid policy types (e.g., `SERVICE_CONTROL_POLICY`), see the [AWS Organizations API Reference](https://docs.aws.amazon.com/organizations/latest/APIReference/API_EnablePolicyType.html).
     * 
     */
    public List<String> enabledPolicyTypes() {
        return this.enabledPolicyTypes;
    }
    /**
     * @return FeatureSet of the organization.
     * 
     */
    public String featureSet() {
        return this.featureSet;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return ARN of the account that is designated as the master account for the organization.
     * 
     */
    public String masterAccountArn() {
        return this.masterAccountArn;
    }
    /**
     * @return The email address that is associated with the AWS account that is designated as the master account for the organization.
     * 
     */
    public String masterAccountEmail() {
        return this.masterAccountEmail;
    }
    /**
     * @return Unique identifier (ID) of the master account of an organization.
     * 
     */
    public String masterAccountId() {
        return this.masterAccountId;
    }
    /**
     * @return Name of the master account of an organization.
     * 
     */
    public String masterAccountName() {
        return this.masterAccountName;
    }
    /**
     * @return List of organization accounts excluding the master account. For a list including the master account, see the `accounts` attribute. All elements have these attributes:
     * 
     */
    public List<GetOrganizationNonMasterAccount> nonMasterAccounts() {
        return this.nonMasterAccounts;
    }
    /**
     * @return List of organization roots. All elements have these attributes:
     * 
     */
    public List<GetOrganizationRoot> roots() {
        return this.roots;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetOrganizationResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetOrganizationAccount> accounts;
        private String arn;
        private List<String> awsServiceAccessPrincipals;
        private List<String> enabledPolicyTypes;
        private String featureSet;
        private String id;
        private String masterAccountArn;
        private String masterAccountEmail;
        private String masterAccountId;
        private String masterAccountName;
        private List<GetOrganizationNonMasterAccount> nonMasterAccounts;
        private List<GetOrganizationRoot> roots;
        public Builder() {}
        public Builder(GetOrganizationResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.accounts = defaults.accounts;
    	      this.arn = defaults.arn;
    	      this.awsServiceAccessPrincipals = defaults.awsServiceAccessPrincipals;
    	      this.enabledPolicyTypes = defaults.enabledPolicyTypes;
    	      this.featureSet = defaults.featureSet;
    	      this.id = defaults.id;
    	      this.masterAccountArn = defaults.masterAccountArn;
    	      this.masterAccountEmail = defaults.masterAccountEmail;
    	      this.masterAccountId = defaults.masterAccountId;
    	      this.masterAccountName = defaults.masterAccountName;
    	      this.nonMasterAccounts = defaults.nonMasterAccounts;
    	      this.roots = defaults.roots;
        }

        @CustomType.Setter
        public Builder accounts(List<GetOrganizationAccount> accounts) {
            if (accounts == null) {
              throw new MissingRequiredPropertyException("GetOrganizationResult", "accounts");
            }
            this.accounts = accounts;
            return this;
        }
        public Builder accounts(GetOrganizationAccount... accounts) {
            return accounts(List.of(accounts));
        }
        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetOrganizationResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder awsServiceAccessPrincipals(List<String> awsServiceAccessPrincipals) {
            if (awsServiceAccessPrincipals == null) {
              throw new MissingRequiredPropertyException("GetOrganizationResult", "awsServiceAccessPrincipals");
            }
            this.awsServiceAccessPrincipals = awsServiceAccessPrincipals;
            return this;
        }
        public Builder awsServiceAccessPrincipals(String... awsServiceAccessPrincipals) {
            return awsServiceAccessPrincipals(List.of(awsServiceAccessPrincipals));
        }
        @CustomType.Setter
        public Builder enabledPolicyTypes(List<String> enabledPolicyTypes) {
            if (enabledPolicyTypes == null) {
              throw new MissingRequiredPropertyException("GetOrganizationResult", "enabledPolicyTypes");
            }
            this.enabledPolicyTypes = enabledPolicyTypes;
            return this;
        }
        public Builder enabledPolicyTypes(String... enabledPolicyTypes) {
            return enabledPolicyTypes(List.of(enabledPolicyTypes));
        }
        @CustomType.Setter
        public Builder featureSet(String featureSet) {
            if (featureSet == null) {
              throw new MissingRequiredPropertyException("GetOrganizationResult", "featureSet");
            }
            this.featureSet = featureSet;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetOrganizationResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder masterAccountArn(String masterAccountArn) {
            if (masterAccountArn == null) {
              throw new MissingRequiredPropertyException("GetOrganizationResult", "masterAccountArn");
            }
            this.masterAccountArn = masterAccountArn;
            return this;
        }
        @CustomType.Setter
        public Builder masterAccountEmail(String masterAccountEmail) {
            if (masterAccountEmail == null) {
              throw new MissingRequiredPropertyException("GetOrganizationResult", "masterAccountEmail");
            }
            this.masterAccountEmail = masterAccountEmail;
            return this;
        }
        @CustomType.Setter
        public Builder masterAccountId(String masterAccountId) {
            if (masterAccountId == null) {
              throw new MissingRequiredPropertyException("GetOrganizationResult", "masterAccountId");
            }
            this.masterAccountId = masterAccountId;
            return this;
        }
        @CustomType.Setter
        public Builder masterAccountName(String masterAccountName) {
            if (masterAccountName == null) {
              throw new MissingRequiredPropertyException("GetOrganizationResult", "masterAccountName");
            }
            this.masterAccountName = masterAccountName;
            return this;
        }
        @CustomType.Setter
        public Builder nonMasterAccounts(List<GetOrganizationNonMasterAccount> nonMasterAccounts) {
            if (nonMasterAccounts == null) {
              throw new MissingRequiredPropertyException("GetOrganizationResult", "nonMasterAccounts");
            }
            this.nonMasterAccounts = nonMasterAccounts;
            return this;
        }
        public Builder nonMasterAccounts(GetOrganizationNonMasterAccount... nonMasterAccounts) {
            return nonMasterAccounts(List.of(nonMasterAccounts));
        }
        @CustomType.Setter
        public Builder roots(List<GetOrganizationRoot> roots) {
            if (roots == null) {
              throw new MissingRequiredPropertyException("GetOrganizationResult", "roots");
            }
            this.roots = roots;
            return this;
        }
        public Builder roots(GetOrganizationRoot... roots) {
            return roots(List.of(roots));
        }
        public GetOrganizationResult build() {
            final var _resultValue = new GetOrganizationResult();
            _resultValue.accounts = accounts;
            _resultValue.arn = arn;
            _resultValue.awsServiceAccessPrincipals = awsServiceAccessPrincipals;
            _resultValue.enabledPolicyTypes = enabledPolicyTypes;
            _resultValue.featureSet = featureSet;
            _resultValue.id = id;
            _resultValue.masterAccountArn = masterAccountArn;
            _resultValue.masterAccountEmail = masterAccountEmail;
            _resultValue.masterAccountId = masterAccountId;
            _resultValue.masterAccountName = masterAccountName;
            _resultValue.nonMasterAccounts = nonMasterAccounts;
            _resultValue.roots = roots;
            return _resultValue;
        }
    }
}
