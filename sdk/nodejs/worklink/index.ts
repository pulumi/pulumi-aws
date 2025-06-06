// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { FleetArgs, FleetState } from "./fleet";
export type Fleet = import("./fleet").Fleet;
export const Fleet: typeof import("./fleet").Fleet = null as any;
utilities.lazyLoad(exports, ["Fleet"], () => require("./fleet"));

export { WebsiteCertificateAuthorityAssociationArgs, WebsiteCertificateAuthorityAssociationState } from "./websiteCertificateAuthorityAssociation";
export type WebsiteCertificateAuthorityAssociation = import("./websiteCertificateAuthorityAssociation").WebsiteCertificateAuthorityAssociation;
export const WebsiteCertificateAuthorityAssociation: typeof import("./websiteCertificateAuthorityAssociation").WebsiteCertificateAuthorityAssociation = null as any;
utilities.lazyLoad(exports, ["WebsiteCertificateAuthorityAssociation"], () => require("./websiteCertificateAuthorityAssociation"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:worklink/fleet:Fleet":
                return new Fleet(name, <any>undefined, { urn })
            case "aws:worklink/websiteCertificateAuthorityAssociation:WebsiteCertificateAuthorityAssociation":
                return new WebsiteCertificateAuthorityAssociation(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "worklink/fleet", _module)
pulumi.runtime.registerResourceModule("aws", "worklink/websiteCertificateAuthorityAssociation", _module)
