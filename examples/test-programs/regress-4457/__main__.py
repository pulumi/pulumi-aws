import pulumi
import pulumi_aws as aws

ami = aws.ec2.get_ami(
    filters=[{"name": "name", "values": ["amzn2-ami-hvm-*"]}],
    owners=["amazon"],
    most_recent=True)

lt1 = aws.ec2.LaunchTemplate(
    "lt1",
    name_prefix="lt1",
    image_id=ami.id,
    instance_type="t2.micro")

ag = aws.autoscaling.Group(
    "ag",
    availability_zones=["us-west-2a"],
    desired_capacity=1,
    max_size=1,
    min_size=1,
    launch_template={
        "id": lt1.id,
        "version": "$Latest",
    })

# EXTRA CODE HERE

pulumi.export('ami', ami.id)
pulumi.export('autoGroupArn', ag.arn)
pulumi.export('autoGroupUrn', ag.urn)
pulumi.export('autoGroupName', ag.name)
