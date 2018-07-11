// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";
import * as other from "./other/index"

// Validate that 'require'd packages are captured correctly.
function getContentType() {
  let mime = require('mime-types');
  return mime.contentType(".js");
}
const testFunc = new aws.serverless.Function("f", {
  policies: [aws.iam.AWSLambdaFullAccess],
  includePaths: ['./Pulumi.yaml'],
}, async (ev, ctx, cb) => {
  var aws = await import('aws-sdk');
  var express = await import('express');
  var os = require('os');
  var slack = require('@slack/client');

  var answer = other.answer;
  console.log(answer);
  getContentType();
});

exports.functionARN = testFunc.lambda.arn;
