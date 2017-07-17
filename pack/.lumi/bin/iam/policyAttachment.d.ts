import * as lumi from "@lumi/lumi";
import { ARN } from "../index";
import { Group } from "./group";
import { Role } from "./role";
import { User } from "./user";
export declare class PolicyAttachment extends lumi.NamedResource implements PolicyAttachmentArgs {
    readonly groups?: Group[];
    readonly policyAttachmentName?: string;
    readonly policyArn: ARN;
    readonly roles?: Role[];
    readonly users?: User[];
    constructor(name: string, args: PolicyAttachmentArgs);
}
export interface PolicyAttachmentArgs {
    readonly groups?: Group[];
    readonly policyAttachmentName?: string;
    readonly policyArn: ARN;
    readonly roles?: Role[];
    readonly users?: User[];
}

