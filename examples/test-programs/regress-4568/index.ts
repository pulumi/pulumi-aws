import * as aws from "@pulumi/aws";

const efsFilesystem = new aws.efs.FileSystem("my-efs", {
    lifecyclePolicies: [{
        transitionToIa: "AFTER_30_DAYS",
    }, {
        transitionToPrimaryStorageClass: "AFTER_1_ACCESS",
    }],
});

export const lifecyclePolicies = aws.efs.getFileSystemOutput({ fileSystemId: efsFilesystem.id }).lifecyclePolicies;
