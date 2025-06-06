// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { CertificateArgs, CertificateState } from "./certificate";
export type Certificate = import("./certificate").Certificate;
export const Certificate: typeof import("./certificate").Certificate = null as any;
utilities.lazyLoad(exports, ["Certificate"], () => require("./certificate"));

export { EndpointArgs, EndpointState } from "./endpoint";
export type Endpoint = import("./endpoint").Endpoint;
export const Endpoint: typeof import("./endpoint").Endpoint = null as any;
utilities.lazyLoad(exports, ["Endpoint"], () => require("./endpoint"));

export { EventSubscriptionArgs, EventSubscriptionState } from "./eventSubscription";
export type EventSubscription = import("./eventSubscription").EventSubscription;
export const EventSubscription: typeof import("./eventSubscription").EventSubscription = null as any;
utilities.lazyLoad(exports, ["EventSubscription"], () => require("./eventSubscription"));

export { GetCertificateArgs, GetCertificateResult, GetCertificateOutputArgs } from "./getCertificate";
export const getCertificate: typeof import("./getCertificate").getCertificate = null as any;
export const getCertificateOutput: typeof import("./getCertificate").getCertificateOutput = null as any;
utilities.lazyLoad(exports, ["getCertificate","getCertificateOutput"], () => require("./getCertificate"));

export { GetEndpointArgs, GetEndpointResult, GetEndpointOutputArgs } from "./getEndpoint";
export const getEndpoint: typeof import("./getEndpoint").getEndpoint = null as any;
export const getEndpointOutput: typeof import("./getEndpoint").getEndpointOutput = null as any;
utilities.lazyLoad(exports, ["getEndpoint","getEndpointOutput"], () => require("./getEndpoint"));

export { GetReplicationInstanceArgs, GetReplicationInstanceResult, GetReplicationInstanceOutputArgs } from "./getReplicationInstance";
export const getReplicationInstance: typeof import("./getReplicationInstance").getReplicationInstance = null as any;
export const getReplicationInstanceOutput: typeof import("./getReplicationInstance").getReplicationInstanceOutput = null as any;
utilities.lazyLoad(exports, ["getReplicationInstance","getReplicationInstanceOutput"], () => require("./getReplicationInstance"));

export { GetReplicationSubnetGroupArgs, GetReplicationSubnetGroupResult, GetReplicationSubnetGroupOutputArgs } from "./getReplicationSubnetGroup";
export const getReplicationSubnetGroup: typeof import("./getReplicationSubnetGroup").getReplicationSubnetGroup = null as any;
export const getReplicationSubnetGroupOutput: typeof import("./getReplicationSubnetGroup").getReplicationSubnetGroupOutput = null as any;
utilities.lazyLoad(exports, ["getReplicationSubnetGroup","getReplicationSubnetGroupOutput"], () => require("./getReplicationSubnetGroup"));

export { GetReplicationTaskArgs, GetReplicationTaskResult, GetReplicationTaskOutputArgs } from "./getReplicationTask";
export const getReplicationTask: typeof import("./getReplicationTask").getReplicationTask = null as any;
export const getReplicationTaskOutput: typeof import("./getReplicationTask").getReplicationTaskOutput = null as any;
utilities.lazyLoad(exports, ["getReplicationTask","getReplicationTaskOutput"], () => require("./getReplicationTask"));

export { ReplicationConfigArgs, ReplicationConfigState } from "./replicationConfig";
export type ReplicationConfig = import("./replicationConfig").ReplicationConfig;
export const ReplicationConfig: typeof import("./replicationConfig").ReplicationConfig = null as any;
utilities.lazyLoad(exports, ["ReplicationConfig"], () => require("./replicationConfig"));

export { ReplicationInstanceArgs, ReplicationInstanceState } from "./replicationInstance";
export type ReplicationInstance = import("./replicationInstance").ReplicationInstance;
export const ReplicationInstance: typeof import("./replicationInstance").ReplicationInstance = null as any;
utilities.lazyLoad(exports, ["ReplicationInstance"], () => require("./replicationInstance"));

export { ReplicationSubnetGroupArgs, ReplicationSubnetGroupState } from "./replicationSubnetGroup";
export type ReplicationSubnetGroup = import("./replicationSubnetGroup").ReplicationSubnetGroup;
export const ReplicationSubnetGroup: typeof import("./replicationSubnetGroup").ReplicationSubnetGroup = null as any;
utilities.lazyLoad(exports, ["ReplicationSubnetGroup"], () => require("./replicationSubnetGroup"));

export { ReplicationTaskArgs, ReplicationTaskState } from "./replicationTask";
export type ReplicationTask = import("./replicationTask").ReplicationTask;
export const ReplicationTask: typeof import("./replicationTask").ReplicationTask = null as any;
utilities.lazyLoad(exports, ["ReplicationTask"], () => require("./replicationTask"));

export { S3EndpointArgs, S3EndpointState } from "./s3endpoint";
export type S3Endpoint = import("./s3endpoint").S3Endpoint;
export const S3Endpoint: typeof import("./s3endpoint").S3Endpoint = null as any;
utilities.lazyLoad(exports, ["S3Endpoint"], () => require("./s3endpoint"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:dms/certificate:Certificate":
                return new Certificate(name, <any>undefined, { urn })
            case "aws:dms/endpoint:Endpoint":
                return new Endpoint(name, <any>undefined, { urn })
            case "aws:dms/eventSubscription:EventSubscription":
                return new EventSubscription(name, <any>undefined, { urn })
            case "aws:dms/replicationConfig:ReplicationConfig":
                return new ReplicationConfig(name, <any>undefined, { urn })
            case "aws:dms/replicationInstance:ReplicationInstance":
                return new ReplicationInstance(name, <any>undefined, { urn })
            case "aws:dms/replicationSubnetGroup:ReplicationSubnetGroup":
                return new ReplicationSubnetGroup(name, <any>undefined, { urn })
            case "aws:dms/replicationTask:ReplicationTask":
                return new ReplicationTask(name, <any>undefined, { urn })
            case "aws:dms/s3Endpoint:S3Endpoint":
                return new S3Endpoint(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "dms/certificate", _module)
pulumi.runtime.registerResourceModule("aws", "dms/endpoint", _module)
pulumi.runtime.registerResourceModule("aws", "dms/eventSubscription", _module)
pulumi.runtime.registerResourceModule("aws", "dms/replicationConfig", _module)
pulumi.runtime.registerResourceModule("aws", "dms/replicationInstance", _module)
pulumi.runtime.registerResourceModule("aws", "dms/replicationSubnetGroup", _module)
pulumi.runtime.registerResourceModule("aws", "dms/replicationTask", _module)
pulumi.runtime.registerResourceModule("aws", "dms/s3Endpoint", _module)
