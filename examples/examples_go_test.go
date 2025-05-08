// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.
//go:build go || all
// +build go all

package examples

import (
	"encoding/json"
	"fmt"
	"math/rand"
	"path/filepath"
	"strings"
	"testing"
	"time"

	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/aws/session"
	appconfigsdk "github.com/aws/aws-sdk-go/service/appconfig"
	s3sdk "github.com/aws/aws-sdk-go/service/s3"
	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/pulumi/pulumi/sdk/v3/go/auto"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func rootSdkPath() string {
	rootSdkPath, _ := filepath.Abs("../sdk")
	return rootSdkPath
}

func getGoBaseOptions(t *testing.T) integration.ProgramTestOptions {
	envRegion := getEnvRegion(t)
	return integration.ProgramTestOptions{
		Dependencies: []string{
			"github.com/pulumi/pulumi-aws/sdk/v7=" + rootSdkPath(),
			"github.com/pulumi/pulumi-aws/sdk/v6=" + rootSdkPath(),
		},
		Config: map[string]string{
			"aws:region": envRegion,
		},
	}
}

func TestAccWebserverGo(t *testing.T) {
	test := getGoBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "webserver-go"),
		})

	integration.ProgramTest(t, &test)
}

func TestTagsCombinationsGo(t *testing.T) {
	type testCase struct {
		name string
		s1   tagsState
		s2   tagsState
	}

	testCases := []testCase{
		{
			"maintain a simple tag",
			tagsState{ResourceTags: map[string]string{"x": "s"}},
			tagsState{ResourceTags: map[string]string{"x": "s"}},
		},
		{
			"add a simple tag",
			tagsState{},
			tagsState{ResourceTags: map[string]string{"x": "s"}},
		},
		{
			"add an empty tag",
			tagsState{},
			tagsState{ResourceTags: map[string]string{"x": ""}},
		},
		{
			"remove an empty default tag",
			tagsState{DefaultTags: map[string]string{"x": "", "y": ""}},
			tagsState{DefaultTags: map[string]string{"x": ""}},
		},
		{
			"remove an empty resource tag",
			tagsState{DefaultTags: map[string]string{"x": "", "y": "s"}, ResourceTags: map[string]string{"x": "", "y": ""}},
			tagsState{DefaultTags: map[string]string{}, ResourceTags: map[string]string{"x": ""}},
		},
		// Also fails in TF (same behavior)
		// result is {"x": "s", "y": "s"}
		// {
		// 	"with default tags, remove resource tags",
		// 	tagsState{DefaultTags: map[string]string{"x": "s", "y": ""}, ResourceTags: map[string]string{"x": "s", "y": "s"}},
		// 	tagsState{DefaultTags: map[string]string{"x": "", "y": ""}, ResourceTags: map[string]string{}},
		// },
		// Also fails in TF (same behavior)
		// result is {"x": "s", "y": "s"}
		// {
		// 	"default tags can be removed when resource tags are added",
		// 	tagsState{DefaultTags: map[string]string{"x": "", "y": "s"}, ResourceTags: nil},
		// 	tagsState{DefaultTags: map[string]string{"x": "s", "y": ""}, ResourceTags: map[string]string{"x": "s"}},
		// 	false,
		// },
		// TODO: bug in Pulumi, default tags are not removed for sdkv2 resources
		// In order for this scenario to work, TF runs refresh with the new provider config
		// and then computes the diff
		// For Pulumi to do this you have to run refresh with --run-program, otherwise refresh will
		// use the old provider config
		// {
		// 	"only default tags, remove default tags",
		// 	tagsState{DefaultTags: map[string]string{"x": "s", "y": "s"}, ResourceTags: map[string]string{}},
		// 	tagsState{DefaultTags: map[string]string{}, ResourceTags: map[string]string{}},
		// },
		{
			"replace tags with empty",
			tagsState{
				DefaultTags:  map[string]string{"x": "s"},
				ResourceTags: nil,
			},
			tagsState{
				DefaultTags:  map[string]string{"x": "", "y": "s"},
				ResourceTags: map[string]string{"x": "", "y": ""},
			},
		},
		{
			"maintain tags",
			tagsState{
				DefaultTags:  map[string]string{"x": "s", "y": "s"},
				ResourceTags: map[string]string{"x": "s", "y": "s"},
			},
			tagsState{
				DefaultTags:  map[string]string{"x": "s", "y": "s"},
				ResourceTags: map[string]string{"x": "s", "y": "s"},
			},
		},
		{
			"regress 1",
			tagsState{DefaultTags: map[string]string{"x": "s"}, ResourceTags: map[string]string{"x": "", "y": ""}},
			tagsState{DefaultTags: map[string]string{"x": "s"}, ResourceTags: map[string]string{"x": "", "y": ""}},
		},
		// Also fails in TF (same behavior)
		// result is {"x": "s"}
		// {
		// 	"regress 2",
		// 	tagsState{DefaultTags: map[string]string{}, ResourceTags: map[string]string{"x": "s", "y": ""}},
		// 	tagsState{DefaultTags: map[string]string{"x": ""}, ResourceTags: map[string]string{}},
		// 	false,
		// },
		{
			"regress 3",
			tagsState{DefaultTags: map[string]string{"x": "", "y": "s"}, ResourceTags: map[string]string{"x": "s", "y": "s"}},
			tagsState{DefaultTags: map[string]string{}, ResourceTags: map[string]string{"x": "", "y": "s"}},
		},
	}

	for i, tc := range testCases {
		tc := tc
		i := i
		t.Run(tc.name, func(t *testing.T) {
			tc.s1.validateTransitionTo(t, i, tc.s2)
		})
	}
}

func TestRandomTagsCombinationsGo(t *testing.T) {
	t.Skipf("Skipping for now until related issues are resolved")
	tagValues := []string{"", "s"} // empty values are conflated with unknowns in TF internals, must test

	tagsValues := []map[string]string{
		nil,
		{},
	}

	for _, tag := range tagValues {
		m := map[string]string{"x": tag}
		tagsValues = append(tagsValues, m)
	}

	for _, tag1 := range tagValues {
		for _, tag2 := range tagValues {
			m := map[string]string{
				"x": tag1,
				"y": tag2,
			}
			tagsValues = append(tagsValues, m)
		}
	}

	states := []tagsState{}

	for _, tags1 := range tagsValues {
		for _, tags2 := range tagsValues {
			states = append(states, tagsState{
				DefaultTags:  tags1,
				ResourceTags: tags2,
			})
		}
	}

	t.Logf("total state space: %v states", len(states))
	t.Logf("random-sampling 100 state transitions")

	for i := 0; i < 100; i++ {
		i := i
		t.Run(fmt.Sprintf("test-%d", i), func(t *testing.T) {
			i := rand.Intn(len(states))
			j := rand.Intn(len(states))
			state1, state2 := states[i], states[j]
			state1.validateTransitionTo(t, i, state2)
		})
	}
}

type tagsState struct {
	DefaultTags  map[string]string `json:"defaultTags"`
	ResourceTags map[string]string `json:"resourceTags"`
}

func (st tagsState) serialize(t *testing.T) string {
	bytes, err := json.Marshal(st)
	require.NoError(t, err)
	return string(bytes)
}

func (st tagsState) validateTransitionTo(t *testing.T, testIdent int, st2 tagsState) {
	t.Logf("state1 = %v", st.serialize(t))
	t.Logf("state2 = %v", st2.serialize(t))

	test2 := pulumitest.NewPulumiTest(t, "tags-combinations-go",
		opttest.LocalProviderPath("aws", filepath.Join(getCwd(t), "..", "bin")),
		opttest.GoModReplacement("github.com/pulumi/pulumi-aws/sdk/v7", rootSdkPath()),
		opttest.SkipInstall(),
	)
	test2.SetConfig(t, "aws:region", getEnvRegion(t))
	test2.SetConfig(t, "state1", st.serialize(t))
	test2.SetConfig(t, "state2", st2.serialize(t))
	test2.SetConfig(t, "testIdent", fmt.Sprintf("test%d", testIdent))

	upRes := test2.Up(t)
	st.assertOutputs(t, upRes.Outputs, 1)

	test2.UpdateSource(t, filepath.Join("tags-combinations-go", "step1"))
	up2Res := test2.Up(t)
	outputs := up2Res.Outputs
	st2.assertOutputs(t, outputs, 2)
}

func (st tagsState) expectedTags() map[string]string {
	r := map[string]string{}
	for k, v := range st.DefaultTags {
		r[k] = v
	}
	for k, v := range st.ResourceTags {
		r[k] = v
	}
	return r
}

func normTags(tags map[string]string) map[string]string {
	if tags == nil {
		return map[string]string{}
	}
	return tags
}

type tagsFetcher = func() (map[string]string, error)

func (st tagsState) assertTagsEqualWithRetry(
	t *testing.T,
	getActualTags tagsFetcher,
	msg string,
) {
	expectTags := st.expectedTags()
	var actualTags map[string]string
	for attempt := 0; attempt < 2; attempt++ {
		var err error = nil
		actualTags, err = getActualTags()
		if err == nil && assert.ObjectsAreEqual(normTags(expectTags), normTags(actualTags)) {
			break
		}
		if err != nil {
			t.Logf("Ignoring error: %v", err)
		} else {
			t.Logf("Ignoring incorrect tags: %#v -- expecting #%v", actualTags, expectTags)
		}
		t.Logf("Failed to fetch tags, will attempt again in 5s")
		time.Sleep(5 * time.Second)
		t.Logf("Trying to fetch tags again, attempt %d", attempt+1)
	}
	assert.Equalf(t, normTags(expectTags), normTags(actualTags), msg)
}

func (st tagsState) assertOutputs(t *testing.T, outputs auto.OutputMap, phase int) {
	for k, v := range outputs {
		switch k {
		case "bucket-name",
			"appconfig-app-arn",
			"appconfig-env-arn":
			continue
		}

		t.Logf("Key: %s", k)

		actualTagsJSON := v.Value.(string)
		var actualTags map[string]string
		err := json.Unmarshal([]byte(actualTagsJSON), &actualTags)
		require.NoError(t, err)
		t.Logf("actualTags: %v", actualTagsJSON)
		t.Logf("phase: %d", phase)
		t.Logf("state: %v", st.serialize(t))
		assert.Equalf(t, normTags(st.expectedTags()), normTags(actualTags), "key=%s", k)
		t.Logf("key=%s tags are as expected: %v", k, actualTagsJSON)

		switch k {
		case "bucket":
			getTags := outputs["get-bucket"].Value.(string)
			isEqual(t, v.Value.(string), getTags, "bucket tags don't equal get-bucket tags")
			bucketName := outputs["bucket-name"].Value.(string)
			st.assertTagsEqualWithRetry(t,
				fetchBucketTags(bucketName),
				"bad bucket tags")
		case "appconfig-app":
			arn := outputs["appconfig-app-arn"].Value.(string)
			getTags := outputs["get-appconfig-app"].Value.(string)
			isEqual(t, v.Value.(string), getTags, "appconfig app tags don't equal get-appconfig-app tags")
			st.assertTagsEqualWithRetry(t,
				fetchAppConfigTags(arn),
				"bad appconfig app tags")
		case "appconfig-env":
			getTags := outputs["get-appconfig-env"].Value.(string)
			isEqual(t, v.Value.(string), getTags, "appconfig env tags don't equal get-appconfig-env tags")
			arn := outputs["appconfig-env-arn"].Value.(string)
			st.assertTagsEqualWithRetry(t,
				fetchAppConfigTags(arn),
				"bad appconfig app tags")
		}
	}
}

func isEqual(t *testing.T, a, b, message string) {
	if a == "null" {
		a = "{}"
	}
	if b == "null" {
		b = "{}"
	}
	assert.Equalf(t, a, b, message)
}

func fetchBucketTags(awsBucket string) tagsFetcher {
	return func() (map[string]string, error) {
		sess := session.Must(session.NewSessionWithOptions(session.Options{
			SharedConfigState: session.SharedConfigEnable,
		}))

		retries := 5
		client := s3sdk.New(sess, &aws.Config{MaxRetries: &retries})

		input := &s3sdk.GetBucketTaggingInput{
			Bucket: &awsBucket,
		}

		result, err := client.GetBucketTagging(input)
		if err != nil && strings.Contains(err.Error(), "NoSuchTagSet") {
			return map[string]string{}, nil
		}
		if err != nil {
			return nil, err
		}

		tags := make(map[string]string)
		for _, tag := range result.TagSet {
			tags[*tag.Key] = *tag.Value
		}

		return tags, nil
	}
}

func fetchAppConfigTags(arn string) tagsFetcher {
	return func() (map[string]string, error) {
		sess := session.Must(session.NewSessionWithOptions(session.Options{
			SharedConfigState: session.SharedConfigEnable,
		}))
		retries := 5
		client := appconfigsdk.New(sess, &aws.Config{MaxRetries: &retries})
		out, err := client.ListTagsForResource(&appconfigsdk.ListTagsForResourceInput{
			ResourceArn: &arn,
		})
		if err != nil {
			return nil, err
		}
		res := map[string]string{}
		for k, v := range out.Tags {
			res[k] = *v
		}
		return res, nil
	}
}
