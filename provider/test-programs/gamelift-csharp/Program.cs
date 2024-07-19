using Pulumi;
using Pulumi.Aws.S3;
using Pulumi.Aws.GameLift;
using System.Collections.Generic;

return await Deployment.RunAsync(() =>
{
    var cfg = new Pulumi.Config();

    var customData = cfg.Require("customData");

    var matchmakingRuleSetResource = new MatchmakingRuleSet("matchmakingRuleSetResource", new()
    {
        RuleSetBody = @"{
         ""name"": ""players_vs_monster_5_vs_1"",
         ""ruleLanguageVersion"": ""1.0"",
         ""teams"": [{
                ""name"": ""players"",
                ""maxPlayers"": 5,
                ""minPlayers"": 5
            }, {
                ""name"": ""monster"",
                ""maxPlayers"": 1,
                ""minPlayers"": 1
            }]
        }",
        Name = "RuleSetName",
    });

    var mc = new MatchmakingConfiguration("mc", new MatchmakingConfigurationArgs
    {
        AcceptanceRequired = false,
        FlexMatchMode = "STANDALONE",
        Name = "Name",
        RuleSetName = matchmakingRuleSetResource.Name,
        RequestTimeoutSeconds = 10,
        GameSessionData = string.Empty,
        CustomEventData = customData,
        BackfillMode = "MANUAL",
    }, new CustomResourceOptions
    {
        IgnoreChanges = new List<string> {"gameSessionQueueArns"}
    });

    return new Dictionary<string, object?>
    {
        ["CustomEventData"] = mc.CustomEventData
    };
});
