import * as lumi from "@lumi/lumi";
import { ARN } from "../index";
import { User } from "./user";
export declare class UserPolicyAttachment extends lumi.NamedResource implements UserPolicyAttachmentArgs {
    readonly policyArn: ARN;
    readonly user: User;
    constructor(name: string, args: UserPolicyAttachmentArgs);
}
export interface UserPolicyAttachmentArgs {
    readonly policyArn: ARN;
    readonly user: User;
}

