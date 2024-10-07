import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config();

const customData = config.require("customData");

const matchmakingRuleSetResource = new aws.gamelift.MatchmakingRuleSet("matchmakingRuleSetResource", {
    ruleSetBody: `
        {
          "name": "players_vs_monster_5_vs_1",
          "ruleLanguageVersion": "1.0",
          "teams": [
            {
              "name": "players",
              "maxPlayers": 5,
              "minPlayers": 5
            },
            {
              "name": "monster",
              "maxPlayers": 1,
              "minPlayers": 1
            }
          ]
        }`,
});

const mc = new aws.gamelift.MatchmakingConfiguration("mc", {
    acceptanceRequired: false,
    flexMatchMode: "STANDALONE",
    ruleSetName: matchmakingRuleSetResource.name,
    requestTimeoutSeconds: 10,
    gameSessionData: "",
    customEventData: customData,
    backfillMode: "MANUAL",
}, {
    ignoreChanges: ["gameSessionQueueArns"]
});

export const CustomEventData = mc.customEventData;
