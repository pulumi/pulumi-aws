import * as lumi from "@lumi/lumi";
import { ARN } from "../index";
import { Group } from "./group";
export declare class GroupPolicyAttachment extends lumi.NamedResource implements GroupPolicyAttachmentArgs {
    readonly group: Group;
    readonly policyArn: ARN;
    constructor(name: string, args: GroupPolicyAttachmentArgs);
}
export interface GroupPolicyAttachmentArgs {
    readonly group: Group;
    readonly policyArn: ARN;
}

