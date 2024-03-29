import * as aws from "@pulumi/aws";

export const vs = aws.rds.getEngineVersionOutput({engine: "postgres"});
