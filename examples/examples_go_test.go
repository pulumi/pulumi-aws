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
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func TestAccWebserverGo(t *testing.T) {
	test := integration.ProgramTestOptions{
		Dir: filepath.Join(getCwd(t), "webserver-go"),
		Dependencies: []string{
			"github.com/pulumi/pulumi-aws/sdk/v6",
		},
		Config: map[string]string{"aws:region": getEnvRegion(t)},
	}

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
		{
			"regress 2",
			tagsState{DefaultTags: map[string]string{}, ResourceTags: map[string]string{"x": "s", "y": ""}},
			tagsState{DefaultTags: map[string]string{"x": ""}, ResourceTags: map[string]string{}},
		},
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

	integration.ProgramTest(t, &integration.ProgramTestOptions{
		Dir:                    "tags-combinations-go",
		ExtraRuntimeValidation: st.validateStateResult(1),
		EditDirs: []integration.EditDir{{
			Dir:                    filepath.Join("tags-combinations-go", "step1"),
			Additive:               true,
			ExtraRuntimeValidation: st2.validateStateResult(2),
		}},
		Config: map[string]string{
			"aws:region": getEnvRegion(t),
			"state1":     st.serialize(t),
			"state2":     st2.serialize(t),
			"testIdent":  fmt.Sprintf("test%d", testIdent),
		},
		Quick: true,
	})
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

type tagsFetcher = func() (map[string]string, error)

func (st tagsState) assertTagsEqualWithRetry(
	t *testing.T,
	getActualTags tagsFetcher,
	msg string,
) {
	expectTags := st.expectedTags()
	var actualTags map[string]string
	for attempt := 0; attempt < 10; attempt++ {
		var err error = nil
		actualTags, err = getActualTags()
		if err == nil && assert.ObjectsAreEqual(expectTags, actualTags) {
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
	require.Equalf(t, expectTags, actualTags, msg)
}

func (st tagsState) validateStateResult(phase int) func(
	t *testing.T,
	stack integration.RuntimeValidationStackInfo,
) {

	return func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
		for k, v := range stack.Outputs {
			switch k {
			case "bucket-name", "legacy-bucket-name", "appconfig-app-arn", "appconfig-env-arn", "get-appconfig-env":
				continue
			}

			actualTagsJSON := v.(string)
			var actualTags map[string]string
			err := json.Unmarshal([]byte(actualTagsJSON), &actualTags)
			require.NoError(t, err)
			t.Logf("phase: %d", phase)
			t.Logf("state: %v", st.serialize(t))
			require.Equalf(t, st.expectedTags(), actualTags, "key=%s", k)
			t.Logf("key=%s tags are as expected: %v", k, actualTagsJSON)

			if k == "bucket" {
				// getTags := stack.Outputs["get-bucket"].(string)
				// assert.Equal(t, v.(string), getTags)
				bucketName := stack.Outputs["bucket-name"].(string)
				st.assertTagsEqualWithRetry(t,
					fetchBucketTags(bucketName),
					"bad bucket tags")
			}
			if k == "legacy-bucket" {
				// getTags := stack.Outputs["get-legacy-bucket"].(string)
				// assert.Equal(t, v.(string), getTags)
				bucketName := stack.Outputs["legacy-bucket-name"].(string)
				st.assertTagsEqualWithRetry(t,
					fetchBucketTags(bucketName),
					"bad legacy bucket tags")
			}
			if k == "appconfig-app" {
				arn := stack.Outputs["appconfig-app-arn"].(string)
				st.assertTagsEqualWithRetry(t,
					fetchAppConfigTags(arn),
					"bad appconfig app tags")
			}
			if k == "appconfig-env" {
				getTags := stack.Outputs["get-appconfig-env"].(string)
				isEqual(t, v.(string), getTags)
				arn := stack.Outputs["appconfig-env-arn"].(string)
				st.assertTagsEqualWithRetry(t,
					fetchAppConfigTags(arn),
					"bad appconfig app tags")
			}
		}
	}
}

func isEqual(t *testing.T, a, b string) {
	if a == "null" {
		a = "{}"
	}
	if b == "null" {
		b = "{}"
	}
	assert.Equal(t, a, b)
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
