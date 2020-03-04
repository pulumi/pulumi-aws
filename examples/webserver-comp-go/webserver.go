// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package main

import (
	"fmt"

	"github.com/pulumi/pulumi-aws/sdk/go/aws/ec2"
	"github.com/pulumi/pulumi/sdk/go/pulumi"
)

type Server struct {
	pulumi.ResourceState

	Instance *ec2.Instance
}

type ServerArgs struct {
	Size           pulumi.StringInput
	SecurityGroups pulumi.StringArrayInput
}

func NewServer(ctx *pulumi.Context, name string, args *ServerArgs, options ...pulumi.ResourceOption) (*Server, error) {
	var server Server
	if err := ctx.RegisterComponentResource("main:index:server", name, &server, options...); err != nil {
		return nil, err
	}
	defer ctx.RegisterResourceOutputs(&server, pulumi.Map{})

	options = append(options, pulumi.Parent(&server))

	instance, err := ec2.NewInstance(ctx, fmt.Sprintf("%s/webserver", name), &ec2.InstanceArgs{
		InstanceType:   args.Size,
		SecurityGroups: args.SecurityGroups,
		Ami:            args.Size.ToStringOutput().ApplyString(func(size string) string { return getLinuxAMI(region, size) }),
	}, options...)
	if err != nil {
		return nil, err
	}
	server.Instance = instance

	return &server, nil
}

func NewMicroServer(ctx *pulumi.Context, name string, securityGroups pulumi.StringArrayInput, options ...pulumi.ResourceOption) (*Server, error) {
	return NewServer(ctx, name, &ServerArgs{
		Size:           pulumi.String("t2.micro"),
		SecurityGroups: securityGroups,
	}, options...)
}

func NewNanoServer(ctx *pulumi.Context, name string, securityGroups pulumi.StringArrayInput, options ...pulumi.ResourceOption) (*Server, error) {
	return NewServer(ctx, name, &ServerArgs{
		Size:           pulumi.String("t2.nano"),
		SecurityGroups: securityGroups,
	}, options...)
}
