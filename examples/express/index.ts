// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as express from "express";
import * as serverlessExpress from "aws-serverless-express";
import * as middleware from "aws-serverless-express/middleware";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

let hello = "Hello, world!";
let lambda = new aws.serverless.Function(
  "mylambda", {
    factoryFunc: () => {
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
        serverlessExpress.proxy(server, event, <any>context);
      }
    }
  }, undefined, providerOpts);
