module github.com/pulumi/pulumi-aws

go 1.12

require (
	github.com/Masterminds/semver v1.4.2 // indirect
	github.com/Masterminds/vcs v1.13.0 // indirect
	github.com/aws/aws-sdk-go v1.19.39
	github.com/chzyer/logex v1.1.11-0.20160617073814-96a4d311aa9b // indirect
	github.com/coreos/bbolt v1.3.1-coreos.1 // indirect
	github.com/golang/dep v0.5.3 // indirect
	github.com/gopherjs/gopherjs v0.0.0-20181103185306-d547d1d9531e // indirect
	github.com/hashicorp/aws-sdk-go-base v0.3.0
	github.com/hashicorp/go-immutable-radix v1.0.0 // indirect
	github.com/hashicorp/go-sockaddr v1.0.0 // indirect
	github.com/hashicorp/serf v0.8.2-0.20171022020050-c20a0b1b1ea9 // indirect
	github.com/hashicorp/terraform v0.12.0
	github.com/jmank88/nuts v0.3.0 // indirect
	github.com/miekg/dns v1.0.14 // indirect
	github.com/mitchellh/go-homedir v1.1.0
	github.com/nightlyone/lockfile v0.0.0-20180618180623-0ad87eef1443 // indirect
	github.com/onsi/ginkgo v1.8.0 // indirect
	github.com/onsi/gomega v1.5.0 // indirect
	github.com/pkg/errors v0.8.0
	github.com/pulumi/pulumi v0.17.6-0.20190410045519-ef5e148a73c0
	github.com/pulumi/pulumi-terraform v0.18.3-0.20190604214533-7ace3e9b5f2d
	github.com/pulumi/scripts v0.0.0-20190517182850-09cb4022bea5 // indirect
	github.com/pulumi/terraform-provider-aws v1.38.1-0.20181019132727-72e8bb4fc26f // indirect
	github.com/sdboyer/constext v0.0.0-20170321163424-836a14457353 // indirect
	github.com/sirupsen/logrus v1.4.0 // indirect
	github.com/smartystreets/assertions v0.0.0-20190116191733-b6c0e53d7304 // indirect
	github.com/stretchr/testify v1.3.1-0.20190311161405-34c6fa2dc709
	github.com/terraform-providers/terraform-provider-aws v0.0.0-20190406034810-72b780bca0d3
)

replace (
	github.com/Nvveen/Gotty => github.com/ijc25/Gotty v0.0.0-20170406111628-a8b993ba6abd
	github.com/golang/glog => github.com/pulumi/glog v0.0.0-20180820174630-7eaa6ffb71e4
	github.com/terraform-providers/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v1.38.1-0.20190531185733-de07b4f12f51
)
