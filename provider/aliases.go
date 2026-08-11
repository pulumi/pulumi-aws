package provider

import (
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi/sdk/v3/go/common/tokens"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

// applyLegacyResourceAliases preserves URN compatibility for historical token corrections and module moves.
func applyLegacyResourceAliases(prov *tfbridge.ProviderInfo) {
	addLegacyAlias := func(token string, prev, current tokens.Type, info *tfbridge.ResourceInfo) {
		_, ok := prov.Resources[token]
		contract.Assertf(!ok, "We don't alias an existing resource")
		if info == nil {
			info = new(tfbridge.ResourceInfo)
		}
		info.Tok = current
		info.Aliases = append(info.Aliases, tfbridge.AliasInfo{Type: new(string(prev))})
		prov.Resources[token] = info
	}

	// Fix the spelling mistake on `aws_ses_configuration_set` Tok
	addLegacyAlias("aws_ses_configuration_set",
		awsResource(sesMod, "ConfgurationSet"), awsResource(sesMod, "ConfigurationSet"),
		nil)

	// Preserve URNs from before the `elb` resources moved out of the `elasticloadbalancing` module.
	addLegacyAlias("aws_app_cookie_stickiness_policy",
		awsResource(legacyElbMod, "AppCookieStickinessPolicy"),
		awsResource(elbMod, "AppCookieStickinessPolicy"),
		nil)
	addLegacyAlias("aws_elb",
		awsResource(legacyElbMod, "LoadBalancer"), awsResource(elbMod, "LoadBalancer"),
		nil)
	addLegacyAlias("aws_elb_attachment",
		awsResource(legacyElbMod, "Attachment"), awsResource(elbMod, "Attachment"),
		nil)
	addLegacyAlias("aws_lb_cookie_stickiness_policy",
		awsResource(legacyElbMod, "LoadBalancerCookieStickinessPolicy"),
		awsResource(elbMod, "LoadBalancerCookieStickinessPolicy"),
		nil)
	addLegacyAlias("aws_load_balancer_policy",
		awsResource(legacyElbMod, "LoadBalancerPolicy"), awsResource(elbMod, "LoadBalancerPolicy"),
		nil)
	addLegacyAlias("aws_load_balancer_listener_policy",
		awsResource(legacyElbMod, "ListenerPolicy"), awsResource(elbMod, "ListenerPolicy"),
		nil)
	addLegacyAlias("aws_lb_ssl_negotiation_policy",
		awsResource(legacyElbMod, "SslNegotiationPolicy"), awsResource(elbMod, "SslNegotiationPolicy"),
		nil)
	addLegacyAlias("aws_load_balancer_backend_server_policy",
		awsResource(legacyElbMod, "LoadBalancerBackendServerPolicy"),
		awsResource(elbMod, "LoadBalancerBackendServerPolicy"),
		nil)

	// Preserve URNs from before the `lb` resources moved out of the `elasticloadbalancingv2` module.
	addLegacyAlias("aws_lb",
		awsResource(legacyElbv2Mod, "LoadBalancer"), awsResource(lbMod, "LoadBalancer"),
		nil)
	addLegacyAlias("aws_lb_listener",
		awsResource(legacyElbv2Mod, "Listener"), awsResource(lbMod, "Listener"),
		nil)
	addLegacyAlias("aws_lb_listener_certificate",
		awsResource(legacyElbv2Mod, "ListenerCertificate"), awsResource(lbMod, "ListenerCertificate"),
		nil)
	addLegacyAlias("aws_lb_listener_rule",
		awsResource(legacyElbv2Mod, "ListenerRule"), awsResource(lbMod, "ListenerRule"),
		nil)
	addLegacyAlias("aws_lb_target_group",
		awsResource(legacyElbv2Mod, "TargetGroup"),
		awsResource(lbMod, "TargetGroup"),
		&tfbridge.ResourceInfo{
			Fields: map[string]*tfbridge.SchemaInfo{
				// https://docs.aws.amazon.com/elasticloadbalancing/latest/APIReference/API_CreateTargetGroup.html
				"name": tfbridge.AutoName("name", 32, "-"),
				"deregistration_delay": {
					Type: "integer",
				},
			},
		})
	addLegacyAlias("aws_lb_target_group_attachment",
		awsResource(legacyElbv2Mod, "TargetGroupAttachment"), awsResource(lbMod, "TargetGroupAttachment"),
		nil)

	// Ec2 Transit Gateway
	addLegacyAlias("aws_ec2_transit_gateway_peering_attachment_accepter",
		awsResource(ec2Mod, "TransitGatewayPeeringAttachmentAccepter"),
		awsResource(ec2TransitGatewayMod, "PeeringAttachmentAccepter"),
		nil)

	// Preserve URNs from before the `alb` resources moved out of the `applicationloadbalancing` module.
	addLegacyAlias("aws_alb", awsResource(legacyAlbMod, "LoadBalancer"),
		awsResource(albMod, "LoadBalancer"), &tfbridge.ResourceInfo{
			Fields: map[string]*tfbridge.SchemaInfo{
				"load_balancer_type": {Type: awsType(albMod, "LoadBalancerType", "LoadBalancerType")},
				"ip_address_type": {
					Type:     "string",
					AltTypes: []tokens.Type{awsType(albMod, "IpAddressType", "IpAddressType")},
				},
			},
			Docs: &tfbridge.DocInfo{Source: "lb.html.markdown"},
		})
	addLegacyAlias("aws_alb_listener", awsResource(legacyAlbMod, "Listener"),
		awsResource(albMod, "Listener"), &tfbridge.ResourceInfo{
			Docs: &tfbridge.DocInfo{Source: "lb_listener.html.markdown"},
		})
	addLegacyAlias("aws_alb_listener_certificate", awsResource(legacyAlbMod, "ListenerCertificate"),
		awsResource(albMod, "ListenerCertificate"), &tfbridge.ResourceInfo{
			Docs: &tfbridge.DocInfo{Source: "lb_listener_certificate.html.markdown"},
		})
	addLegacyAlias("aws_alb_listener_rule", awsResource(legacyAlbMod, "ListenerRule"),
		awsResource(albMod, "ListenerRule"), &tfbridge.ResourceInfo{
			Docs: &tfbridge.DocInfo{Source: "lb_listener_rule.html.markdown"},
		})
	addLegacyAlias("aws_alb_target_group", awsResource(legacyAlbMod, "TargetGroup"),
		awsResource(albMod, "TargetGroup"), &tfbridge.ResourceInfo{
			Docs: &tfbridge.DocInfo{Source: "lb_target_group.html.markdown"},
			Fields: map[string]*tfbridge.SchemaInfo{
				"deregistration_delay": {
					Type: "integer",
				},
			},
		})
	addLegacyAlias("aws_alb_target_group_attachment", awsResource(legacyAlbMod, "TargetGroupAttachment"),
		awsResource(albMod, "TargetGroupAttachment"), &tfbridge.ResourceInfo{
			Docs: &tfbridge.DocInfo{Source: "lb_target_group_attachment.html.markdown"},
		})
}
