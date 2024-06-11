import * as aws from "@pulumi/aws";

const output = aws.rds.getEngineVersionOutput({
  engine: "aurora-postgresql",
  version: "15.2",
  filters: [{
    name: "engine-mode",
    values: ["provisioned"],
  }],
});

export const vs = output.version;
