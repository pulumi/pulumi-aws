import * as aws from "@pulumi/aws";

const output = aws.rds.getEngineVersionOutput({
  engine: "aurora-postgresql",
  // we need to specify the version because we want to test
  // the upstream behavior when version is set
  version: "15.8",
  filters: [{
    name: "engine-mode",
    values: ["provisioned"],
  }],
});

export const vs = output.version;
