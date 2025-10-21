package provider

import (
	"context"
	"net/http"
	"net/http/httptest"
	"testing"

	structpb "github.com/golang/protobuf/ptypes/struct"
	pfbridge "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/pf/tfbridge"
	pulumirpc "github.com/pulumi/pulumi/sdk/v3/proto/go"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func testProviderServer() (pulumirpc.ResourceProviderServer, error) {
	info := *Provider()
	ctx := context.Background()
	p, err := pfbridge.MakeMuxedServer(ctx, info.Name, info,
		/*
		 * We leave the schema blank. This will result in incorrect calls to
		 * GetSchema, but otherwise does not effect the provider. It reduces the
		 * time to test start by minutes.
		 */
		[]byte("{}"),
	)(nil)
	return p, err
}

func TestProviderEndpoints(t *testing.T) {
	stsGetCallerIdentityResponse := `
<GetCallerIdentityResponse xmlns="https://sts.amazonaws.com/doc/2011-06-15/">
	<GetCallerIdentityResult>
	<Arn>arn:aws:iam::123456789012:user/Alice</Arn>
	<UserId>AIDACKCEVSQ6C2EXAMPLE</UserId>
	<Account>123456789012</Account>
	</GetCallerIdentityResult>
	<ResponseMetadata>
		<RequestId>01234567-89ab-cdef-0123-456789abcdef</RequestId>
	</ResponseMetadata>
</GetCallerIdentityResponse>`

	t.Run("requests to AWS use the APN/1.1 marketplace identifier in the User-Agent request header", func(t *testing.T) {
		requestCount := 0
		server := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
			assert.Contains(t, r.Header.Get("User-Agent"), "APN/1.1 (c7qiae2l6usvzoynupds6v7hf)")
			switch requestCount {
			case 0:
				w.Write([]byte(stsGetCallerIdentityResponse))
			case 1:
				w.Write([]byte("{}"))
			default:
				t.Fatalf("Unexpected request count: %d", requestCount)
			}
			requestCount++
		}))
		t.Cleanup(server.Close)

		// Using environment variables since configuring passing variables to
		// provider.Configure is too late on the lifecycle of the provider. These
		// values are fetched when the provider is initialized.
		t.Setenv("AWS_ENDPOINT_URL", server.URL)
		t.Setenv("AWS_SKIP_METADATA_API_CHECK", "true")
		t.Setenv("AWS_SKIP_CREDENTIALS_VALIDATION", "true")
		t.Setenv("AWS_ACCESS_KEY_ID", "test")
		t.Setenv("AWS_SECRET_ACCESS_KEY", "test")
		t.Setenv("AWS_SESSION_TOKEN", "test")
		t.Setenv("AWS_REGION", "us-west-2")

		provider, err := testProviderServer()
		require.NoError(t, err)
		ctx := context.Background()
		_, err = provider.Configure(ctx, &pulumirpc.ConfigureRequest{})
		require.NoError(t, err)
		_, err = provider.Invoke(ctx, &pulumirpc.InvokeRequest{
			Tok: "aws:s3/getObjects:getObjects",
			Args: &structpb.Struct{
				Fields: map[string]*structpb.Value{
					"bucket": {
						Kind: &structpb.Value_StringValue{
							StringValue: "test-bucket",
						},
					},
				},
			},
		})
		require.NoError(t, err)
		assert.Equal(t, 2, requestCount)
	})
}
