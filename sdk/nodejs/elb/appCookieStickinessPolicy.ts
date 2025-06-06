// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides an application cookie stickiness policy, which allows an ELB to wed its sticky cookie's expiration to a cookie generated by your application.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const lb = new aws.elb.LoadBalancer("lb", {
 *     name: "test-lb",
 *     availabilityZones: ["us-east-1a"],
 *     listeners: [{
 *         instancePort: 8000,
 *         instanceProtocol: "http",
 *         lbPort: 80,
 *         lbProtocol: "http",
 *     }],
 * });
 * const foo = new aws.elb.AppCookieStickinessPolicy("foo", {
 *     name: "foo_policy",
 *     loadBalancer: lb.name,
 *     lbPort: 80,
 *     cookieName: "MyAppCookie",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import application cookie stickiness policies using the ELB name, port, and policy name separated by colons (`:`). For example:
 *
 * ```sh
 * $ pulumi import aws:elb/appCookieStickinessPolicy:AppCookieStickinessPolicy example my-elb:80:my-policy
 * ```
 */
export class AppCookieStickinessPolicy extends pulumi.CustomResource {
    /**
     * Get an existing AppCookieStickinessPolicy resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: AppCookieStickinessPolicyState, opts?: pulumi.CustomResourceOptions): AppCookieStickinessPolicy {
        return new AppCookieStickinessPolicy(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:elb/appCookieStickinessPolicy:AppCookieStickinessPolicy';

    /**
     * Returns true if the given object is an instance of AppCookieStickinessPolicy.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is AppCookieStickinessPolicy {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === AppCookieStickinessPolicy.__pulumiType;
    }

    /**
     * Application cookie whose lifetime the ELB's cookie should follow.
     */
    public readonly cookieName!: pulumi.Output<string>;
    /**
     * Load balancer port to which the policy
     * should be applied. This must be an active listener on the load
     * balancer.
     */
    public readonly lbPort!: pulumi.Output<number>;
    /**
     * Name of load balancer to which the policy
     * should be attached.
     */
    public readonly loadBalancer!: pulumi.Output<string>;
    /**
     * Name of the stickiness policy.
     */
    public readonly name!: pulumi.Output<string>;

    /**
     * Create a AppCookieStickinessPolicy resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: AppCookieStickinessPolicyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: AppCookieStickinessPolicyArgs | AppCookieStickinessPolicyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as AppCookieStickinessPolicyState | undefined;
            resourceInputs["cookieName"] = state ? state.cookieName : undefined;
            resourceInputs["lbPort"] = state ? state.lbPort : undefined;
            resourceInputs["loadBalancer"] = state ? state.loadBalancer : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
        } else {
            const args = argsOrState as AppCookieStickinessPolicyArgs | undefined;
            if ((!args || args.cookieName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'cookieName'");
            }
            if ((!args || args.lbPort === undefined) && !opts.urn) {
                throw new Error("Missing required property 'lbPort'");
            }
            if ((!args || args.loadBalancer === undefined) && !opts.urn) {
                throw new Error("Missing required property 'loadBalancer'");
            }
            resourceInputs["cookieName"] = args ? args.cookieName : undefined;
            resourceInputs["lbPort"] = args ? args.lbPort : undefined;
            resourceInputs["loadBalancer"] = args ? args.loadBalancer : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        const aliasOpts = { aliases: [{ type: "aws:elasticloadbalancing/appCookieStickinessPolicy:AppCookieStickinessPolicy" }] };
        opts = pulumi.mergeOptions(opts, aliasOpts);
        super(AppCookieStickinessPolicy.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering AppCookieStickinessPolicy resources.
 */
export interface AppCookieStickinessPolicyState {
    /**
     * Application cookie whose lifetime the ELB's cookie should follow.
     */
    cookieName?: pulumi.Input<string>;
    /**
     * Load balancer port to which the policy
     * should be applied. This must be an active listener on the load
     * balancer.
     */
    lbPort?: pulumi.Input<number>;
    /**
     * Name of load balancer to which the policy
     * should be attached.
     */
    loadBalancer?: pulumi.Input<string>;
    /**
     * Name of the stickiness policy.
     */
    name?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a AppCookieStickinessPolicy resource.
 */
export interface AppCookieStickinessPolicyArgs {
    /**
     * Application cookie whose lifetime the ELB's cookie should follow.
     */
    cookieName: pulumi.Input<string>;
    /**
     * Load balancer port to which the policy
     * should be applied. This must be an active listener on the load
     * balancer.
     */
    lbPort: pulumi.Input<number>;
    /**
     * Name of load balancer to which the policy
     * should be attached.
     */
    loadBalancer: pulumi.Input<string>;
    /**
     * Name of the stickiness policy.
     */
    name?: pulumi.Input<string>;
}
