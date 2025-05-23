// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.alb;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.alb.ListenerRuleArgs;
import com.pulumi.aws.alb.inputs.ListenerRuleState;
import com.pulumi.aws.alb.outputs.ListenerRuleAction;
import com.pulumi.aws.alb.outputs.ListenerRuleCondition;
import com.pulumi.core.Alias;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a Load Balancer Listener Rule resource.
 * 
 * &gt; **Note:** `aws.alb.ListenerRule` is known as `aws.lb.ListenerRule`. The functionality is identical.
 * 
 * ## Example Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.lb.LoadBalancer;
 * import com.pulumi.aws.lb.Listener;
 * import com.pulumi.aws.lb.ListenerRule;
 * import com.pulumi.aws.lb.ListenerRuleArgs;
 * import com.pulumi.aws.lb.inputs.ListenerRuleActionArgs;
 * import com.pulumi.aws.lb.inputs.ListenerRuleConditionArgs;
 * import com.pulumi.aws.lb.inputs.ListenerRuleConditionPathPatternArgs;
 * import com.pulumi.aws.lb.inputs.ListenerRuleConditionHostHeaderArgs;
 * import com.pulumi.aws.lb.inputs.ListenerRuleActionForwardArgs;
 * import com.pulumi.aws.lb.inputs.ListenerRuleActionForwardStickinessArgs;
 * import com.pulumi.aws.lb.inputs.ListenerRuleActionRedirectArgs;
 * import com.pulumi.aws.lb.inputs.ListenerRuleConditionHttpHeaderArgs;
 * import com.pulumi.aws.lb.inputs.ListenerRuleActionFixedResponseArgs;
 * import com.pulumi.aws.cognito.UserPool;
 * import com.pulumi.aws.cognito.UserPoolClient;
 * import com.pulumi.aws.cognito.UserPoolDomain;
 * import com.pulumi.aws.lb.inputs.ListenerRuleActionAuthenticateCognitoArgs;
 * import com.pulumi.aws.lb.inputs.ListenerRuleActionAuthenticateOidcArgs;
 * import java.util.List;
 * import java.util.ArrayList;
 * import java.util.Map;
 * import java.io.File;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * 
 * public class App {
 *     public static void main(String[] args) {
 *         Pulumi.run(App::stack);
 *     }
 * 
 *     public static void stack(Context ctx) {
 *         var frontEnd = new LoadBalancer("frontEnd");
 * 
 *         var frontEndListener = new Listener("frontEndListener");
 * 
 *         var static_ = new ListenerRule("static", ListenerRuleArgs.builder()
 *             .listenerArn(frontEndListener.arn())
 *             .priority(100)
 *             .actions(ListenerRuleActionArgs.builder()
 *                 .type("forward")
 *                 .targetGroupArn(staticAwsLbTargetGroup.arn())
 *                 .build())
 *             .conditions(            
 *                 ListenerRuleConditionArgs.builder()
 *                     .pathPattern(ListenerRuleConditionPathPatternArgs.builder()
 *                         .values("/static/*")
 *                         .build())
 *                     .build(),
 *                 ListenerRuleConditionArgs.builder()
 *                     .hostHeader(ListenerRuleConditionHostHeaderArgs.builder()
 *                         .values("example.com")
 *                         .build())
 *                     .build())
 *             .build());
 * 
 *         // Forward action
 *         var hostBasedWeightedRouting = new ListenerRule("hostBasedWeightedRouting", ListenerRuleArgs.builder()
 *             .listenerArn(frontEndListener.arn())
 *             .priority(99)
 *             .actions(ListenerRuleActionArgs.builder()
 *                 .type("forward")
 *                 .targetGroupArn(staticAwsLbTargetGroup.arn())
 *                 .build())
 *             .conditions(ListenerRuleConditionArgs.builder()
 *                 .hostHeader(ListenerRuleConditionHostHeaderArgs.builder()
 *                     .values("my-service.*.mycompany.io")
 *                     .build())
 *                 .build())
 *             .build());
 * 
 *         // Weighted Forward action
 *         var hostBasedRouting = new ListenerRule("hostBasedRouting", ListenerRuleArgs.builder()
 *             .listenerArn(frontEndListener.arn())
 *             .priority(99)
 *             .actions(ListenerRuleActionArgs.builder()
 *                 .type("forward")
 *                 .forward(ListenerRuleActionForwardArgs.builder()
 *                     .targetGroups(                    
 *                         ListenerRuleActionForwardTargetGroupArgs.builder()
 *                             .arn(main.arn())
 *                             .weight(80)
 *                             .build(),
 *                         ListenerRuleActionForwardTargetGroupArgs.builder()
 *                             .arn(canary.arn())
 *                             .weight(20)
 *                             .build())
 *                     .stickiness(ListenerRuleActionForwardStickinessArgs.builder()
 *                         .enabled(true)
 *                         .duration(600)
 *                         .build())
 *                     .build())
 *                 .build())
 *             .conditions(ListenerRuleConditionArgs.builder()
 *                 .hostHeader(ListenerRuleConditionHostHeaderArgs.builder()
 *                     .values("my-service.*.mycompany.io")
 *                     .build())
 *                 .build())
 *             .build());
 * 
 *         // Redirect action
 *         var redirectHttpToHttps = new ListenerRule("redirectHttpToHttps", ListenerRuleArgs.builder()
 *             .listenerArn(frontEndListener.arn())
 *             .actions(ListenerRuleActionArgs.builder()
 *                 .type("redirect")
 *                 .redirect(ListenerRuleActionRedirectArgs.builder()
 *                     .port("443")
 *                     .protocol("HTTPS")
 *                     .statusCode("HTTP_301")
 *                     .build())
 *                 .build())
 *             .conditions(ListenerRuleConditionArgs.builder()
 *                 .httpHeader(ListenerRuleConditionHttpHeaderArgs.builder()
 *                     .httpHeaderName("X-Forwarded-For")
 *                     .values("192.168.1.*")
 *                     .build())
 *                 .build())
 *             .build());
 * 
 *         // Fixed-response action
 *         var healthCheck = new ListenerRule("healthCheck", ListenerRuleArgs.builder()
 *             .listenerArn(frontEndListener.arn())
 *             .actions(ListenerRuleActionArgs.builder()
 *                 .type("fixed-response")
 *                 .fixedResponse(ListenerRuleActionFixedResponseArgs.builder()
 *                     .contentType("text/plain")
 *                     .messageBody("HEALTHY")
 *                     .statusCode("200")
 *                     .build())
 *                 .build())
 *             .conditions(ListenerRuleConditionArgs.builder()
 *                 .queryStrings(                
 *                     ListenerRuleConditionQueryStringArgs.builder()
 *                         .key("health")
 *                         .value("check")
 *                         .build(),
 *                     ListenerRuleConditionQueryStringArgs.builder()
 *                         .value("bar")
 *                         .build())
 *                 .build())
 *             .build());
 * 
 *         // Authenticate-cognito Action
 *         var pool = new UserPool("pool");
 * 
 *         var client = new UserPoolClient("client");
 * 
 *         var domain = new UserPoolDomain("domain");
 * 
 *         var admin = new ListenerRule("admin", ListenerRuleArgs.builder()
 *             .listenerArn(frontEndListener.arn())
 *             .actions(            
 *                 ListenerRuleActionArgs.builder()
 *                     .type("authenticate-cognito")
 *                     .authenticateCognito(ListenerRuleActionAuthenticateCognitoArgs.builder()
 *                         .userPoolArn(pool.arn())
 *                         .userPoolClientId(client.id())
 *                         .userPoolDomain(domain.domain())
 *                         .build())
 *                     .build(),
 *                 ListenerRuleActionArgs.builder()
 *                     .type("forward")
 *                     .targetGroupArn(staticAwsLbTargetGroup.arn())
 *                     .build())
 *             .build());
 * 
 *         // Authenticate-oidc Action
 *         var oidc = new ListenerRule("oidc", ListenerRuleArgs.builder()
 *             .listenerArn(frontEndListener.arn())
 *             .actions(            
 *                 ListenerRuleActionArgs.builder()
 *                     .type("authenticate-oidc")
 *                     .authenticateOidc(ListenerRuleActionAuthenticateOidcArgs.builder()
 *                         .authorizationEndpoint("https://example.com/authorization_endpoint")
 *                         .clientId("client_id")
 *                         .clientSecret("client_secret")
 *                         .issuer("https://example.com")
 *                         .tokenEndpoint("https://example.com/token_endpoint")
 *                         .userInfoEndpoint("https://example.com/user_info_endpoint")
 *                         .build())
 *                     .build(),
 *                 ListenerRuleActionArgs.builder()
 *                     .type("forward")
 *                     .targetGroupArn(staticAwsLbTargetGroup.arn())
 *                     .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import rules using their ARN. For example:
 * 
 * ```sh
 * $ pulumi import aws:alb/listenerRule:ListenerRule front_end arn:aws:elasticloadbalancing:us-west-2:187416307283:listener-rule/app/test/8e4497da625e2d8a/9ab28ade35828f96/67b3d2d36dd7c26b
 * ```
 * 
 */
@ResourceType(type="aws:alb/listenerRule:ListenerRule")
public class ListenerRule extends com.pulumi.resources.CustomResource {
    /**
     * An Action block. Action blocks are documented below.
     * 
     */
    @Export(name="actions", refs={List.class,ListenerRuleAction.class}, tree="[0,1]")
    private Output<List<ListenerRuleAction>> actions;

    /**
     * @return An Action block. Action blocks are documented below.
     * 
     */
    public Output<List<ListenerRuleAction>> actions() {
        return this.actions;
    }
    /**
     * The ARN of the rule (matches `id`)
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The ARN of the rule (matches `id`)
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * A Condition block. Multiple condition blocks of different types can be set and all must be satisfied for the rule to match. Condition blocks are documented below.
     * 
     */
    @Export(name="conditions", refs={List.class,ListenerRuleCondition.class}, tree="[0,1]")
    private Output<List<ListenerRuleCondition>> conditions;

    /**
     * @return A Condition block. Multiple condition blocks of different types can be set and all must be satisfied for the rule to match. Condition blocks are documented below.
     * 
     */
    public Output<List<ListenerRuleCondition>> conditions() {
        return this.conditions;
    }
    /**
     * The ARN of the listener to which to attach the rule.
     * 
     */
    @Export(name="listenerArn", refs={String.class}, tree="[0]")
    private Output<String> listenerArn;

    /**
     * @return The ARN of the listener to which to attach the rule.
     * 
     */
    public Output<String> listenerArn() {
        return this.listenerArn;
    }
    /**
     * The priority for the rule between `1` and `50000`. Leaving it unset will automatically set the rule with next available priority after currently existing highest rule. A listener can&#39;t have multiple rules with the same priority.
     * 
     */
    @Export(name="priority", refs={Integer.class}, tree="[0]")
    private Output<Integer> priority;

    /**
     * @return The priority for the rule between `1` and `50000`. Leaving it unset will automatically set the rule with next available priority after currently existing highest rule. A listener can&#39;t have multiple rules with the same priority.
     * 
     */
    public Output<Integer> priority() {
        return this.priority;
    }
    /**
     * A map of tags to assign to the resource. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the resource. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     */
    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public ListenerRule(java.lang.String name) {
        this(name, ListenerRuleArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public ListenerRule(java.lang.String name, ListenerRuleArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public ListenerRule(java.lang.String name, ListenerRuleArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:alb/listenerRule:ListenerRule", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private ListenerRule(java.lang.String name, Output<java.lang.String> id, @Nullable ListenerRuleState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:alb/listenerRule:ListenerRule", name, state, makeResourceOptions(options, id), false);
    }

    private static ListenerRuleArgs makeArgs(ListenerRuleArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? ListenerRuleArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .aliases(List.of(
                Output.of(Alias.builder().type("aws:applicationloadbalancing/listenerRule:ListenerRule").build())
            ))
            .build();
        return com.pulumi.resources.CustomResourceOptions.merge(defaultOptions, options, id);
    }

    /**
     * Get an existing Host resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state
     * @param options Optional settings to control the behavior of the CustomResource.
     */
    public static ListenerRule get(java.lang.String name, Output<java.lang.String> id, @Nullable ListenerRuleState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new ListenerRule(name, id, state, options);
    }
}
