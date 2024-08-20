// Copyright 2016-2024, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as express from "express";
import * as serverlessExpress from "aws-serverless-express";
import * as middleware from "aws-serverless-express/middleware";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const hello = "Hello, world!";

const lambda = new aws.lambda.CallbackFunction<any, any>("mylambda", {
  callbackFactory: () => {
    const app = express();
    app.use(middleware.eventContext());
    let ctx;

    app.get("/", (req, res) => {
      console.log("Invoked url: " + req.url);

      // Test fetch.
      // Per https://docs.aws.amazon.com/lambda/latest/dg/nodejs-handler.html
      // fetch is available in Node.js 18 and later runtimes
      fetch('https://www.pulumi.com/robots.txt').then(resp => {
        res.json({
          message: hello + "\n\nSucceeded with " + ctx.getRemainingTimeInMillis() + "ms remaining.",
          fetchStatus: resp.status,
          fetched: resp.text(),
        });
      });
    });

    const server = serverlessExpress.createServer(app);

    return (event, context) => {
      console.log("Lambda invoked");
      console.log("Invoked function: " + context.invokedFunctionArn);
      console.log("Proxying to express");
      ctx = context;
      serverlessExpress.proxy(server, event, <any>context);
    }
  }
}, providerOpts);

export const lambdaARN = lambda.arn;
export const lambdaRuntime = lambda.runtime;
