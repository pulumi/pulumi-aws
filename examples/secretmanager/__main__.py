import json
from pulumi_aws.secretsmanager import Secret, SecretVersion

# Create an AWS Secret for RDS
rds_secret = Secret("db",
    description="RDS Database secret",
    kms_key_id="alias/aws/secretsmanager",  # default KMS key
)

# Define the secret value
secret_string = json.dumps({
    "username": "username",
    "password": "password",
    "engine": "mysql",
    "host": "<endpoint>",
    "port": 3306,
    "dbname": "<db_name>",
})

# Create a secret version in AWS Secrets Manager with the secret value
rds_secret_version = SecretVersion("version",
    secret_id=rds_secret.id,
    secret_string=secret_string,
)
