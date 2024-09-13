package quicksight

import (
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/info"
	"github.com/pulumi/pulumi/sdk/v3/go/common/tokens"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

const (
	quicksightMod = "Quicksight" // Quicksight
)

func ConfigureQuicksight(
	providerInfo *info.Provider,
	awsResource func(mod string, name string) tokens.Type,
	awsDataSource func(mod string, name string) tokens.ModuleMember,
) {
	quickSightResources := map[string]*info.Resource{
		"aws_quicksight_account_subscription": {Tok: awsResource(quicksightMod, "AccountSubscription")},
		"aws_quicksight_data_set":             {Tok: awsResource(quicksightMod, "DataSet")},
		"aws_quicksight_group":                {Tok: awsResource(quicksightMod, "Group")},
		"aws_quicksight_user":                 {Tok: awsResource(quicksightMod, "User")},
		"aws_quicksight_group_membership":     {Tok: awsResource(quicksightMod, "GroupMembership")},
		"aws_quicksight_data_source":          {Tok: awsResource(quicksightMod, "DataSource")},
		"aws_quicksight_folder":               {Tok: awsResource(quicksightMod, "Folder")},
		"aws_quicksight_template":             {Tok: awsResource(quicksightMod, "Template")},
		"aws_quicksight_analysis":             {Tok: awsResource(quicksightMod, "Analysis")},
		"aws_quicksight_dashboard":            {Tok: awsResource(quicksightMod, "Dashboard")},
	}

	for k, v := range quickSightResources {
		providerInfo.Resources[k] = v
	}

	quickSightDataSources := map[string]*info.DataSource{
		"aws_quicksight_data_set": {Tok: awsDataSource(quicksightMod, "getDataSet")},
		"aws_quicksight_group":    {Tok: awsDataSource(quicksightMod, "getQuicksightGroup")},
		"aws_quicksight_user":     {Tok: awsDataSource(quicksightMod, "getQuicksightUser")},
	}

	for k, v := range quickSightDataSources {
		providerInfo.DataSources[k] = v
	}

	st, err := readSharedTypesFile("provider/pkg/quicksight/shared-types-rewrites.json")
	contract.AssertNoErrorf(err, "failed to read shared-types-rewrites.json")

	shareTypes(st, providerInfo)
}
