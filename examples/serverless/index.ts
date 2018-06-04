// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";

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
  { policies: [aws.iam.AWSLambdaFullAccess] },
  (event, context, callback) => {
    console.log("Music table hash key is: " + music.hashKey);
    console.log("Invoked function: " + context.invokedFunctionArn);
    callback(null, {
      statusCode: 200,
      body: hello + "\n\nSucceeed with " + context.getRemainingTimeInMillis() + "ms remaining.\n",
    });
  },
);

// Validate that 'require'd packafges are captured correctly.
function getContentType() {
  let mime = require('mime-types');
  return mime.contentType(".js");
}
const testFunc = new aws.serverless.Function("f", {
  policies: [aws.iam.AWSLambdaFullAccess],
  includePaths: ['./Pulumi.yaml'],
  includePackages: ['source-map'],
}, (ev, ctx, cb) => {
  var aws = require('aws-sdk');
  var os = require('os');
  // TODO[pulumi/pulumi#463] Its reasonable to expect that `./other` would work here, but it currently does not.  For
  // now, validate that the approach that does currently work will serialize the dependencies correctly.
  var answer = require('./bin/other').answer;
  console.log(answer);
  getContentType();
});

exports.functionARN = testFunc.lambda.arn;
