// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as other from "./other/index"
import * as awsSdk from "aws-sdk";
import * as express from "express";
import * as os from "os";
import * as slack from "@slack/client";
import * as mime from "mime-types";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

// Validate that 'require'd packages are captured correctly.
function getContentType() {
  return mime.contentType(".js");
}

const testFunc = new aws.serverless.Function("f", {
  policies: [aws.iam.ManagedPolicies.AWSLambdaFullAccess],
  includePaths: ['./Pulumi.yaml'],
}, async (ev, ctx, cb) => {
  // These variables exist only to ensure that capturing modules doesn't cause any problems.
  var _awsSdk = awsSdk;
  var _express = express;
  var _os = os;
  var _slack = slack;

  var answer = other.answer;
  console.log(answer);
  getContentType();
}, providerOpts);

exports.functionARN = testFunc.lambda.arn;
