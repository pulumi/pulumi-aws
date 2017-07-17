import * as lumi from "@lumi/lumi";
import { ARN } from "../index";
import { Role } from "./role";
export declare class RolePolicyAttachment extends lumi.NamedResource implements RolePolicyAttachmentArgs {
    readonly policyArn: ARN;
    readonly role: Role;
    constructor(name: string, args: RolePolicyAttachmentArgs);
}
export interface RolePolicyAttachmentArgs {
    readonly policyArn: ARN;
    readonly role: Role;
}

