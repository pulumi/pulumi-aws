package elb

import (
	"context"
	"fmt"
	"os"

	"github.com/aws/aws-sdk-go-v2/config"
	elbv2 "github.com/aws/aws-sdk-go-v2/service/elasticloadbalancingv2"
	elbv2t "github.com/aws/aws-sdk-go-v2/service/elasticloadbalancingv2/types"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

type Action = elbv2t.Action
type TargetGroupTuple = elbv2t.TargetGroupTuple

func ModifyListenerDefaultActions(
	ctx context.Context,
	listenerArn string,
	update func([]Action) []Action,
) error {
	client := configureClient()
	response, err := client.DescribeListeners(ctx, &elbv2.DescribeListenersInput{
		ListenerArns: []string{listenerArn},
	})
	if err != nil {
		return err
	}
	if len(response.Listeners) == 0 {
		return fmt.Errorf("no listeners found with ARN %s", listenerArn)
	}
	if len(response.Listeners) > 1 {
		return fmt.Errorf("multiple listeners found with ARN %s", listenerArn)
	}
	listener := response.Listeners[0]
	newActions := update(listener.DefaultActions)
	_, err = client.ModifyListener(ctx, &elbv2.ModifyListenerInput{
		ListenerArn:    &listenerArn,
		DefaultActions: newActions,
	})
	if err != nil {
		return err
	}
	return nil
}

func configureClient() *elbv2.Client {
	loadOpts := []func(*config.LoadOptions) error{}
	if p, ok := os.LookupEnv("AWS_PROFILE"); ok {
		loadOpts = append(loadOpts, config.WithSharedConfigProfile(p))
	}
	if r, ok := os.LookupEnv("AWS_REGION"); ok {
		loadOpts = append(loadOpts, config.WithRegion(r))
	}
	cfg, err := config.LoadDefaultConfig(context.TODO(), loadOpts...)
	contract.AssertNoErrorf(err, "failed to load AWS config")
	return elbv2.NewFromConfig(cfg)
}
