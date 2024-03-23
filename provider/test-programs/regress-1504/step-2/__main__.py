import pulumi
import pulumi_aws as aws

ec2_launch_template = aws.ec2.LaunchTemplate(
    "my_launch_template",
    image_id="ami-0c55b159cbfafe1f0",
    instance_type="t2.micro",
    key_name='key2',
    tags={"Name": 'tag2'},
    update_default_version=True)

pulumi.export("launch_template_id", ec2_launch_template.id)
pulumi.export("launch_template_latest_version", ec2_launch_template.latest_version)
