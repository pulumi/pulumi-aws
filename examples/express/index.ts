// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";
import * as express from "express";
import * as serverlessExpress from "aws-serverless-express";
import * as middleware from "aws-serverless-express/middleware";

let music = new aws.dynamodb.Table("music", {
  attributes: [
    { name: "Album", type: "S" },
    { name: "Artist", type: "S" },
    { name: "NumberOfSongs", type: "N" },
    { name: "Sales", type: "N" },
  ],
  hashKey: "Album",
  rangeKey: "Artist",
  readCapacity: 1,
  writeCapacity: 1,
  globalSecondaryIndexes: [
    {
      name: "myGSI",
      hashKey: "Sales",
      rangeKey: "Artist",
      readCapacity: 1,
      writeCapacity: 1,
      nonKeyAttributes: ["NumberOfSongs", "Album"],
      projectionType: "INCLUDE",
    },
    {
      name: "myGSI2",
      hashKey: "NumberOfSongs",
      rangeKey: "Sales",
      nonKeyAttributes: ["Album", "Artist"],
      projectionType: "INCLUDE",
      readCapacity: 2,
      writeCapacity: 2,
    },
  ],
});

let hello = "Hello, world!";
let lambda = new aws.serverless.Function(
  "mylambda",
  { policies: [aws.iam.AWSLambdaFullAccess], isFactoryFunction: true },
  () => {
    const app = express();
    app.use(middleware.eventContext());
    let ctx;

    app.get("/", (req, res) => {
      console.log("Invoked url: " + req.url);
      res.json( { message: hello + "\n\nSucceeded with " + ctx.getRemainingTimeInMillis() + "ms remaining.\n" });
    });

    const server = serverlessExpress.createServer(app);

    return (event, context) => {
      console.log("Lambda invoked");
      console.log("Invoked function: " + context.invokedFunctionArn);
      console.log("Proxying to express");
      ctx = context;
      serverlessExpress.proxy(server, event, context);
    }
  },
);
