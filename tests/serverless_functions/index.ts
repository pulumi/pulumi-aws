// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";

// Validate that 'require'd packages are captured correctly.
function getContentType() {
  let mime = require('mime-types');
  return mime.contentType(".js");
}
const testFunc = new aws.serverless.Function("f", {
  policies: [aws.iam.AWSLambdaFullAccess],
  includePaths: ['./Pulumi.yaml'],
  includePackages: ['body-parser'],
}, async (ev, ctx, cb) => {
  var aws = await import('aws-sdk');
  var express = await import('express');
  var os = require('os');
  var slack = require('@slack/client');
  // TODO[pulumi/pulumi#463] Its reasonable to expect that `./other` would work here, but it currently does not.  For
  // now, validate that the approach that does currently work will serialize the dependencies correctly.
  var answer = require('./bin/other').answer;
  console.log(answer);
  getContentType();
});

exports.functionARN = testFunc.lambda.arn;
