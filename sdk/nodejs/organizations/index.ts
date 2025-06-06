// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { AccountArgs, AccountState } from "./account";
export type Account = import("./account").Account;
export const Account: typeof import("./account").Account = null as any;
utilities.lazyLoad(exports, ["Account"], () => require("./account"));

export { DelegatedAdministratorArgs, DelegatedAdministratorState } from "./delegatedAdministrator";
export type DelegatedAdministrator = import("./delegatedAdministrator").DelegatedAdministrator;
export const DelegatedAdministrator: typeof import("./delegatedAdministrator").DelegatedAdministrator = null as any;
utilities.lazyLoad(exports, ["DelegatedAdministrator"], () => require("./delegatedAdministrator"));

export { GetDelegatedAdministratorsArgs, GetDelegatedAdministratorsResult, GetDelegatedAdministratorsOutputArgs } from "./getDelegatedAdministrators";
export const getDelegatedAdministrators: typeof import("./getDelegatedAdministrators").getDelegatedAdministrators = null as any;
export const getDelegatedAdministratorsOutput: typeof import("./getDelegatedAdministrators").getDelegatedAdministratorsOutput = null as any;
utilities.lazyLoad(exports, ["getDelegatedAdministrators","getDelegatedAdministratorsOutput"], () => require("./getDelegatedAdministrators"));

export { GetDelegatedServicesArgs, GetDelegatedServicesResult, GetDelegatedServicesOutputArgs } from "./getDelegatedServices";
export const getDelegatedServices: typeof import("./getDelegatedServices").getDelegatedServices = null as any;
export const getDelegatedServicesOutput: typeof import("./getDelegatedServices").getDelegatedServicesOutput = null as any;
utilities.lazyLoad(exports, ["getDelegatedServices","getDelegatedServicesOutput"], () => require("./getDelegatedServices"));

export { GetOrganizationResult } from "./getOrganization";
export const getOrganization: typeof import("./getOrganization").getOrganization = null as any;
export const getOrganizationOutput: typeof import("./getOrganization").getOrganizationOutput = null as any;
utilities.lazyLoad(exports, ["getOrganization","getOrganizationOutput"], () => require("./getOrganization"));

export { GetOrganizationalUnitArgs, GetOrganizationalUnitResult, GetOrganizationalUnitOutputArgs } from "./getOrganizationalUnit";
export const getOrganizationalUnit: typeof import("./getOrganizationalUnit").getOrganizationalUnit = null as any;
export const getOrganizationalUnitOutput: typeof import("./getOrganizationalUnit").getOrganizationalUnitOutput = null as any;
utilities.lazyLoad(exports, ["getOrganizationalUnit","getOrganizationalUnitOutput"], () => require("./getOrganizationalUnit"));

export { GetOrganizationalUnitChildAccountsArgs, GetOrganizationalUnitChildAccountsResult, GetOrganizationalUnitChildAccountsOutputArgs } from "./getOrganizationalUnitChildAccounts";
export const getOrganizationalUnitChildAccounts: typeof import("./getOrganizationalUnitChildAccounts").getOrganizationalUnitChildAccounts = null as any;
export const getOrganizationalUnitChildAccountsOutput: typeof import("./getOrganizationalUnitChildAccounts").getOrganizationalUnitChildAccountsOutput = null as any;
utilities.lazyLoad(exports, ["getOrganizationalUnitChildAccounts","getOrganizationalUnitChildAccountsOutput"], () => require("./getOrganizationalUnitChildAccounts"));

export { GetOrganizationalUnitDescendantAccountsArgs, GetOrganizationalUnitDescendantAccountsResult, GetOrganizationalUnitDescendantAccountsOutputArgs } from "./getOrganizationalUnitDescendantAccounts";
export const getOrganizationalUnitDescendantAccounts: typeof import("./getOrganizationalUnitDescendantAccounts").getOrganizationalUnitDescendantAccounts = null as any;
export const getOrganizationalUnitDescendantAccountsOutput: typeof import("./getOrganizationalUnitDescendantAccounts").getOrganizationalUnitDescendantAccountsOutput = null as any;
utilities.lazyLoad(exports, ["getOrganizationalUnitDescendantAccounts","getOrganizationalUnitDescendantAccountsOutput"], () => require("./getOrganizationalUnitDescendantAccounts"));

export { GetOrganizationalUnitDescendantOrganizationalUnitsArgs, GetOrganizationalUnitDescendantOrganizationalUnitsResult, GetOrganizationalUnitDescendantOrganizationalUnitsOutputArgs } from "./getOrganizationalUnitDescendantOrganizationalUnits";
export const getOrganizationalUnitDescendantOrganizationalUnits: typeof import("./getOrganizationalUnitDescendantOrganizationalUnits").getOrganizationalUnitDescendantOrganizationalUnits = null as any;
export const getOrganizationalUnitDescendantOrganizationalUnitsOutput: typeof import("./getOrganizationalUnitDescendantOrganizationalUnits").getOrganizationalUnitDescendantOrganizationalUnitsOutput = null as any;
utilities.lazyLoad(exports, ["getOrganizationalUnitDescendantOrganizationalUnits","getOrganizationalUnitDescendantOrganizationalUnitsOutput"], () => require("./getOrganizationalUnitDescendantOrganizationalUnits"));

export { GetOrganizationalUnitsArgs, GetOrganizationalUnitsResult, GetOrganizationalUnitsOutputArgs } from "./getOrganizationalUnits";
export const getOrganizationalUnits: typeof import("./getOrganizationalUnits").getOrganizationalUnits = null as any;
export const getOrganizationalUnitsOutput: typeof import("./getOrganizationalUnits").getOrganizationalUnitsOutput = null as any;
utilities.lazyLoad(exports, ["getOrganizationalUnits","getOrganizationalUnitsOutput"], () => require("./getOrganizationalUnits"));

export { GetPoliciesArgs, GetPoliciesResult, GetPoliciesOutputArgs } from "./getPolicies";
export const getPolicies: typeof import("./getPolicies").getPolicies = null as any;
export const getPoliciesOutput: typeof import("./getPolicies").getPoliciesOutput = null as any;
utilities.lazyLoad(exports, ["getPolicies","getPoliciesOutput"], () => require("./getPolicies"));

export { GetPoliciesForTargetArgs, GetPoliciesForTargetResult, GetPoliciesForTargetOutputArgs } from "./getPoliciesForTarget";
export const getPoliciesForTarget: typeof import("./getPoliciesForTarget").getPoliciesForTarget = null as any;
export const getPoliciesForTargetOutput: typeof import("./getPoliciesForTarget").getPoliciesForTargetOutput = null as any;
utilities.lazyLoad(exports, ["getPoliciesForTarget","getPoliciesForTargetOutput"], () => require("./getPoliciesForTarget"));

export { GetPolicyArgs, GetPolicyResult, GetPolicyOutputArgs } from "./getPolicy";
export const getPolicy: typeof import("./getPolicy").getPolicy = null as any;
export const getPolicyOutput: typeof import("./getPolicy").getPolicyOutput = null as any;
utilities.lazyLoad(exports, ["getPolicy","getPolicyOutput"], () => require("./getPolicy"));

export { GetResourceTagsArgs, GetResourceTagsResult, GetResourceTagsOutputArgs } from "./getResourceTags";
export const getResourceTags: typeof import("./getResourceTags").getResourceTags = null as any;
export const getResourceTagsOutput: typeof import("./getResourceTags").getResourceTagsOutput = null as any;
utilities.lazyLoad(exports, ["getResourceTags","getResourceTagsOutput"], () => require("./getResourceTags"));

export { OrganizationArgs, OrganizationState } from "./organization";
export type Organization = import("./organization").Organization;
export const Organization: typeof import("./organization").Organization = null as any;
utilities.lazyLoad(exports, ["Organization"], () => require("./organization"));

export { OrganizationalUnitArgs, OrganizationalUnitState } from "./organizationalUnit";
export type OrganizationalUnit = import("./organizationalUnit").OrganizationalUnit;
export const OrganizationalUnit: typeof import("./organizationalUnit").OrganizationalUnit = null as any;
utilities.lazyLoad(exports, ["OrganizationalUnit"], () => require("./organizationalUnit"));

export { PolicyArgs, PolicyState } from "./policy";
export type Policy = import("./policy").Policy;
export const Policy: typeof import("./policy").Policy = null as any;
utilities.lazyLoad(exports, ["Policy"], () => require("./policy"));

export { PolicyAttachmentArgs, PolicyAttachmentState } from "./policyAttachment";
export type PolicyAttachment = import("./policyAttachment").PolicyAttachment;
export const PolicyAttachment: typeof import("./policyAttachment").PolicyAttachment = null as any;
utilities.lazyLoad(exports, ["PolicyAttachment"], () => require("./policyAttachment"));

export { ResourcePolicyArgs, ResourcePolicyState } from "./resourcePolicy";
export type ResourcePolicy = import("./resourcePolicy").ResourcePolicy;
export const ResourcePolicy: typeof import("./resourcePolicy").ResourcePolicy = null as any;
utilities.lazyLoad(exports, ["ResourcePolicy"], () => require("./resourcePolicy"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:organizations/account:Account":
                return new Account(name, <any>undefined, { urn })
            case "aws:organizations/delegatedAdministrator:DelegatedAdministrator":
                return new DelegatedAdministrator(name, <any>undefined, { urn })
            case "aws:organizations/organization:Organization":
                return new Organization(name, <any>undefined, { urn })
            case "aws:organizations/organizationalUnit:OrganizationalUnit":
                return new OrganizationalUnit(name, <any>undefined, { urn })
            case "aws:organizations/policy:Policy":
                return new Policy(name, <any>undefined, { urn })
            case "aws:organizations/policyAttachment:PolicyAttachment":
                return new PolicyAttachment(name, <any>undefined, { urn })
            case "aws:organizations/resourcePolicy:ResourcePolicy":
                return new ResourcePolicy(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "organizations/account", _module)
pulumi.runtime.registerResourceModule("aws", "organizations/delegatedAdministrator", _module)
pulumi.runtime.registerResourceModule("aws", "organizations/organization", _module)
pulumi.runtime.registerResourceModule("aws", "organizations/organizationalUnit", _module)
pulumi.runtime.registerResourceModule("aws", "organizations/policy", _module)
pulumi.runtime.registerResourceModule("aws", "organizations/policyAttachment", _module)
pulumi.runtime.registerResourceModule("aws", "organizations/resourcePolicy", _module)
