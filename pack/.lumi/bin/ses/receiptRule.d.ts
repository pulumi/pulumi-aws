import * as lumi from "@lumi/lumi";
export declare class ReceiptRule extends lumi.NamedResource implements ReceiptRuleArgs {
    readonly addHeaderAction?: {
        headerName: string;
        headerValue: string;
        position: number;
    }[];
    readonly after?: string;
    readonly bounceAction?: {
        message: string;
        position: number;
        sender: string;
        smtpReplyCode: string;
        statusCode?: string;
        topicArn?: string;
    }[];
    readonly enabled: boolean;
    readonly lambdaAction?: {
        functionArn: string;
        invocationType: string;
        position: number;
        topicArn?: string;
    }[];
    readonly receiptRuleName?: string;
    readonly recipients?: string[];
    readonly ruleSetName: string;
    readonly s3Action?: {
        bucketName: string;
        kmsKeyArn?: string;
        objectKeyPrefix?: string;
        position: number;
        topicArn?: string;
    }[];
    readonly scanEnabled: boolean;
    readonly snsAction?: {
        position: number;
        topicArn: string;
    }[];
    readonly stopAction?: {
        position: number;
        scope: string;
        topicArn?: string;
    }[];
    readonly tlsPolicy: string;
    readonly workmailAction?: {
        organizationArn: string;
        position: number;
        topicArn?: string;
    }[];
    constructor(name: string, args: ReceiptRuleArgs);
}
export interface ReceiptRuleArgs {
    readonly addHeaderAction?: {
        headerName: string;
        headerValue: string;
        position: number;
    }[];
    readonly after?: string;
    readonly bounceAction?: {
        message: string;
        position: number;
        sender: string;
        smtpReplyCode: string;
        statusCode?: string;
        topicArn?: string;
    }[];
    readonly enabled?: boolean;
    readonly lambdaAction?: {
        functionArn: string;
        invocationType: string;
        position: number;
        topicArn?: string;
    }[];
    readonly receiptRuleName?: string;
    readonly recipients?: string[];
    readonly ruleSetName: string;
    readonly s3Action?: {
        bucketName: string;
        kmsKeyArn?: string;
        objectKeyPrefix?: string;
        position: number;
        topicArn?: string;
    }[];
    readonly scanEnabled?: boolean;
    readonly snsAction?: {
        position: number;
        topicArn: string;
    }[];
    readonly stopAction?: {
        position: number;
        scope: string;
        topicArn?: string;
    }[];
    readonly tlsPolicy?: string;
    readonly workmailAction?: {
        organizationArn: string;
        position: number;
        topicArn?: string;
    }[];
}

