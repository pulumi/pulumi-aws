---
subcategory: "S3"
layout: "aws"
page_title: "AWS: aws_s3_bucket"
description: |-
Provides a S3 bucket resource.
---

# Resource: aws_s3_bucket

Provides a S3 bucket resource.

-> This functionality is for managing S3 in an AWS Partition. To manage [S3 on Outposts](https://docs.aws.amazon.com/AmazonS3/latest/dev/S3onOutposts.html), see the `aws_s3control_bucket` resource.

-> **NOTE:** This resource might not work well if using an alternative s3-compatible provider. Please use `aws.s3.BucketV2` instead.

## Example Usage

### Private Bucket w/ Tags

```terraform
resource "aws_s3_bucket_legacy" "b" {
  bucket = "my-tf-test-bucket"
  acl    = "private"

  tags = {
    Name        = "My bucket"
    Environment = "Dev"
  }
}
```

### Static Website Hosting

```terraform
resource "aws_s3_bucket_legacy" "b" {
  bucket = "s3-website-test.mydomain.com"
  acl    = "public-read"
  policy = file("policy.json")

  website {
    index_document = "index.html"
    error_document = "error.html"

    routing_rules = <<EOF
[{
    "Condition": {
        "KeyPrefixEquals": "docs/"
    },
    "Redirect": {
        "ReplaceKeyPrefixWith": "documents/"
    }
}]
EOF
  }
}
```

### Using CORS

```terraform
resource "aws_s3_bucket_legacy" "b" {
  bucket = "s3-website-test.mydomain.com"
  acl    = "public-read"

  cors_rule {
    allowed_headers = ["*"]
    allowed_methods = ["PUT", "POST"]
    allowed_origins = ["https://s3-website-test.mydomain.com"]
    expose_headers  = ["ETag"]
    max_age_seconds = 3000
  }
}
```

### Using versioning

```terraform
resource "aws_s3_bucket_legacy" "b" {
  bucket = "my-tf-test-bucket"
  acl    = "private"

  versioning {
    enabled = true
  }
}
```

### Enable Logging

```terraform
resource "aws_s3_bucket_legacy" "log_bucket" {
  bucket = "my-tf-log-bucket"
  acl    = "log-delivery-write"
}

resource "aws_s3_bucket_legacy" "b" {
  bucket = "my-tf-test-bucket"
  acl    = "private"

  logging {
    target_bucket = aws_s3_bucket_legacy.log_bucket.id
    target_prefix = "log/"
  }
}
```

### Using object lifecycle

```terraform
resource "aws_s3_bucket_legacy" "bucket" {
  bucket = "my-bucket"
  acl    = "private"

  lifecycle_rule {
    id      = "log"
    enabled = true

    prefix = "log/"

    tags = {
      rule      = "log"
      autoclean = "true"
    }

    transition {
      days          = 30
      storage_class = "STANDARD_IA" # or "ONEZONE_IA"
    }

    transition {
      days          = 60
      storage_class = "GLACIER"
    }

    expiration {
      days = 90
    }
  }

  lifecycle_rule {
    id      = "tmp"
    prefix  = "tmp/"
    enabled = true

    expiration {
      date = "2016-01-12"
    }
  }
}

resource "aws_s3_bucket_legacy" "versioning_bucket" {
  bucket = "my-versioning-bucket"
  acl    = "private"

  versioning {
    enabled = true
  }

  lifecycle_rule {
    prefix  = "config/"
    enabled = true

    noncurrent_version_transition {
      days          = 30
      storage_class = "STANDARD_IA"
    }

    noncurrent_version_transition {
      days          = 60
      storage_class = "GLACIER"
    }

    noncurrent_version_expiration {
      days = 90
    }
  }
}
```

### Using replication configuration

~> **NOTE:** See the `aws_s3_bucket_replication_configuration` resource to support bi-directional replication configuration and additional features.

```terraform
provider "aws" {
  region = "eu-west-1"
}

provider "aws" {
  alias  = "central"
  region = "eu-central-1"
}

resource "aws_iam_role" "replication" {
  name = "tf-iam-role-replication-12345"

  assume_role_policy = <<POLICY
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": "sts:AssumeRole",
      "Principal": {
        "Service": "s3.amazonaws.com"
      },
      "Effect": "Allow",
      "Sid": ""
    }
  ]
}
POLICY
}

resource "aws_iam_policy" "replication" {
  name = "tf-iam-role-policy-replication-12345"

  policy = <<POLICY
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": [
        "s3:GetReplicationConfiguration",
        "s3:ListBucket"
      ],
      "Effect": "Allow",
      "Resource": [
        "${aws_s3_bucket_legacy.source.arn}"
      ]
    },
    {
      "Action": [
        "s3:GetObjectVersionForReplication",
        "s3:GetObjectVersionAcl",
         "s3:GetObjectVersionTagging"
      ],
      "Effect": "Allow",
      "Resource": [
        "${aws_s3_bucket_legacy.source.arn}/*"
      ]
    },
    {
      "Action": [
        "s3:ReplicateObject",
        "s3:ReplicateDelete",
        "s3:ReplicateTags"
      ],
      "Effect": "Allow",
      "Resource": "${aws_s3_bucket_legacy.destination.arn}/*"
    }
  ]
}
POLICY
}

resource "aws_iam_role_policy_attachment" "replication" {
  role       = aws_iam_role.replication.name
  policy_arn = aws_iam_policy.replication.arn
}

resource "aws_s3_bucket_legacy" "destination" {
  bucket = "tf-test-bucket-destination-12345"

  versioning {
    enabled = true
  }
}

resource "aws_s3_bucket_legacy" "source" {
  provider = aws.central
  bucket   = "tf-test-bucket-source-12345"
  acl      = "private"

  versioning {
    enabled = true
  }

  replication_configuration {
    role = aws_iam_role.replication.arn

    rules {
      id     = "foobar"
      status = "Enabled"

      filter {
        tags = {}
      }
      destination {
        bucket        = aws_s3_bucket_legacy.destination.arn
        storage_class = "STANDARD"

        replication_time {
          status  = "Enabled"
          minutes = 15
        }

        metrics {
          status  = "Enabled"
          minutes = 15
        }
      }
    }
  }
}
```

### Enable Default Server Side Encryption

```terraform
resource "aws_kms_key" "mykey" {
  description             = "This key is used to encrypt bucket objects"
  deletion_window_in_days = 10
}

resource "aws_s3_bucket_legacy" "mybucket" {
  bucket = "mybucket"

  server_side_encryption_configuration {
    rule {
      apply_server_side_encryption_by_default {
        kms_master_key_id = aws_kms_key.mykey.arn
        sse_algorithm     = "aws:kms"
      }
    }
  }
}
```

### Using ACL policy grants

```terraform
data "aws_canonical_user_id" "current_user" {}

resource "aws_s3_bucket_legacy" "bucket" {
  bucket = "mybucket"

  grant {
    id          = data.aws_canonical_user_id.current_user.id
    type        = "CanonicalUser"
    permissions = ["FULL_CONTROL"]
  }

  grant {
    type        = "Group"
    permissions = ["READ_ACP", "WRITE"]
    uri         = "http://acs.amazonaws.com/groups/s3/LogDelivery"
  }
}
```

## Argument Reference

The following arguments are supported:

* `bucket` - (Optional, Forces new resource) The name of the bucket. If omitted, this provider will assign a random, unique name. Must be lowercase and less than or equal to 63 characters in length. A full list of bucket naming rules [may be found here](https://docs.aws.amazon.com/AmazonS3/latest/userguide/bucketnamingrules.html).
* `bucket_prefix` - (Optional, Forces new resource) Creates a unique bucket name beginning with the specified prefix. Conflicts with `bucket`. Must be lowercase and less than or equal to 37 characters in length. A full list of bucket naming rules [may be found here](https://docs.aws.amazon.com/AmazonS3/latest/userguide/bucketnamingrules.html).
* `acl` - (Optional) The [canned ACL](https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#canned-acl) to apply. Valid values are `private`, `public-read`, `public-read-write`, `aws-exec-read`, `authenticated-read`, and `log-delivery-write`. Defaults to `private`.  Conflicts with `grant`.
* `grant` - (Optional) An [ACL policy grant](https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#sample-acl) (documented below). Conflicts with `acl`.
* `policy` - (Optional) A valid [bucket policy](https://docs.aws.amazon.com/AmazonS3/latest/dev/example-bucket-policies.html) JSON document. Note that if the policy document is not specific enough (but still valid), this provider may view the policy as constantly changing in a `pulumi preview`. In this case, please make sure you use the verbose/specific version of the policy.

* `tags` - (Optional) A map of tags to assign to the bucket. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
* `force_destroy` - (Optional, Default:`false`) A boolean that indicates all objects (including any [locked objects](https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock-overview.html)) should be deleted from the bucket so that the bucket can be destroyed without error. These objects are *not* recoverable.
* `website` - (Optional) A website object (documented below).
* `cors_rule` - (Optional) A rule of [Cross-Origin Resource Sharing](https://docs.aws.amazon.com/AmazonS3/latest/dev/cors.html) (documented below).
* `versioning` - (Optional) A state of [versioning](https://docs.aws.amazon.com/AmazonS3/latest/dev/Versioning.html) (documented below)
* `logging` - (Optional) A settings of [bucket logging](https://docs.aws.amazon.com/AmazonS3/latest/UG/ManagingBucketLogging.html) (documented below).
* `lifecycle_rule` - (Optional) A configuration of [object lifecycle management](http://docs.aws.amazon.com/AmazonS3/latest/dev/object-lifecycle-mgmt.html) (documented below).
* `acceleration_status` - (Optional) Sets the accelerate configuration of an existing bucket. Can be `Enabled` or `Suspended`.
* `request_payer` - (Optional) Specifies who should bear the cost of Amazon S3 data transfer.
  Can be either `BucketOwner` or `Requester`. By default, the owner of the S3 bucket would incur
  the costs of any data transfer. See [Requester Pays Buckets](http://docs.aws.amazon.com/AmazonS3/latest/dev/RequesterPaysBuckets.html)
  developer guide for more information.
* `replication_configuration` - (Optional) A configuration of [replication configuration](http://docs.aws.amazon.com/AmazonS3/latest/dev/crr.html) (documented below).
* `server_side_encryption_configuration` - (Optional) A configuration of [server-side encryption configuration](http://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-encryption.html) (documented below)
* `object_lock_configuration` - (Optional) A configuration of [S3 object locking](https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock.html) (documented below)

~> **NOTE:** You cannot use `acceleration_status` in `cn-north-1` or `us-gov-west-1`

The `website` object supports the following:

* `index_document` - (Required, unless using `redirect_all_requests_to`) Amazon S3 returns this index document when requests are made to the root domain or any of the subfolders.
* `error_document` - (Optional) An absolute path to the document to return in case of a 4XX error.
* `redirect_all_requests_to` - (Optional) A hostname to redirect all website requests for this bucket to. Hostname can optionally be prefixed with a protocol (`http://` or `https://`) to use when redirecting requests. The default is the protocol that is used in the original request.
* `routing_rules` - (Optional) A json array containing [routing rules](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-s3-websiteconfiguration-routingrules.html)
  describing redirect behavior and when redirects are applied.

The `CORS` object supports the following:

* `allowed_headers` (Optional) Specifies which headers are allowed.
* `allowed_methods` (Required) Specifies which methods are allowed. Can be `GET`, `PUT`, `POST`, `DELETE` or `HEAD`.
* `allowed_origins` (Required) Specifies which origins are allowed.
* `expose_headers` (Optional) Specifies expose header in the response.
* `max_age_seconds` (Optional) Specifies time in seconds that browser can cache the response for a preflight request.

The `versioning` object supports the following:

* `enabled` - (Optional) Enable versioning. Once you version-enable a bucket, it can never return to an unversioned state. You can, however, suspend versioning on that bucket.
* `mfa_delete` - (Optional) Enable MFA delete for either `Change the versioning state of your bucket` or `Permanently delete an object version`. Default is `false`. This cannot be used to toggle this setting but is available to allow managed buckets to reflect the state in AWS

The `logging` object supports the following:

* `target_bucket` - (Required) The name of the bucket that will receive the log objects.
* `target_prefix` - (Optional) To specify a key prefix for log objects.

The `lifecycle_rule` object supports the following:

* `id` - (Optional) Unique identifier for the rule. Must be less than or equal to 255 characters in length.
* `prefix` - (Optional) Object key prefix identifying one or more objects to which the rule applies.
* `tags` - (Optional) Specifies object tags key and value.
* `enabled` - (Required) Specifies lifecycle rule status.
* `abort_incomplete_multipart_upload_days` (Optional) Specifies the number of days after initiating a multipart upload when the multipart upload must be completed.
* `expiration` - (Optional) Specifies a period in the object's expire (documented below).
* `transition` - (Optional) Specifies a period in the object's transitions (documented below).
* `noncurrent_version_expiration` - (Optional) Specifies when noncurrent object versions expire (documented below).
* `noncurrent_version_transition` - (Optional) Specifies when noncurrent object versions transitions (documented below).

At least one of `abort_incomplete_multipart_upload_days`, `expiration`, `transition`, `noncurrent_version_expiration`, `noncurrent_version_transition` must be specified.

The `expiration` object supports the following

* `date` (Optional) Specifies the date after which you want the corresponding action to take effect.
* `days` (Optional) Specifies the number of days after object creation when the specific rule action takes effect.
* `expired_object_delete_marker` (Optional) On a versioned bucket (versioning-enabled or versioning-suspended bucket), you can add this element in the lifecycle configuration to direct Amazon S3 to delete expired object delete markers. This cannot be specified with Days or Date in a Lifecycle Expiration Policy.

The `transition` object supports the following

* `date` (Optional) Specifies the date after which you want the corresponding action to take effect.
* `days` (Optional) Specifies the number of days after object creation when the specific rule action takes effect.
* `storage_class` (Required) Specifies the Amazon S3 [storage class](https://docs.aws.amazon.com/AmazonS3/latest/API/API_Transition.html#AmazonS3-Type-Transition-StorageClass) to which you want the object to transition.

The `noncurrent_version_expiration` object supports the following

* `days` (Required) Specifies the number of days noncurrent object versions expire.

The `noncurrent_version_transition` object supports the following

* `days` (Required) Specifies the number of days noncurrent object versions transition.
* `storage_class` (Required) Specifies the Amazon S3 [storage class](https://docs.aws.amazon.com/AmazonS3/latest/API/API_Transition.html#AmazonS3-Type-Transition-StorageClass) to which you want the object to transition.

The `replication_configuration` object supports the following:

~> **NOTE:** See the `aws_s3_bucket_replication_configuration` resource documentation to avoid conflicts. Replication configuration can only be defined in one resource not both.  When using the independent replication configuration resource the following lifecycle rule is needed on the `aws_s3_bucket_legacy` resource.

```
lifecycle {
  ignore_changes = [
    replication_configuration
  ]
}
```

* `role` - (Required) The ARN of the IAM role for Amazon S3 to assume when replicating the objects.
* `rules` - (Required) Specifies the rules managing the replication (documented below).

The `rules` object supports the following:

~> **NOTE:** Amazon S3's latest version of the replication configuration is V2, which includes the `filter` attribute for replication rules.
With the `filter` attribute, you can specify object filters based on the object key prefix, tags, or both to scope the objects that the rule applies to.
Replication configuration V1 supports filtering based on only the `prefix` attribute. For backwards compatibility, Amazon S3 continues to support the V1 configuration.

* `delete_marker_replication_status` - (Optional) Whether delete markers are replicated. The only valid value is `Enabled`. To disable, omit this argument. This argument is only valid with V2 replication configurations (i.e., when `filter` is used).
* `destination` - (Required) Specifies the destination for the rule (documented below).
* `filter` - (Optional, Conflicts with `prefix`) Filter that identifies subset of objects to which the replication rule applies (documented below).
* `id` - (Optional) Unique identifier for the rule. Must be less than or equal to 255 characters in length.
* `prefix` - (Optional, Conflicts with `filter`) Object keyname prefix identifying one or more objects to which the rule applies. Must be less than or equal to 1024 characters in length.
* `priority` - (Optional) The priority associated with the rule. Priority should only be set if `filter` is configured. If not provided, defaults to `0`. Priority must be unique between multiple rules.
* `source_selection_criteria` - (Optional) Specifies special object selection criteria (documented below).
* `status` - (Required) The status of the rule. Either `Enabled` or `Disabled`. The rule is ignored if status is not Enabled.

~> **NOTE:** Replication to multiple destination buckets requires that `priority` is specified in the `rules` object. If the corresponding rule requires no filter, an empty configuration block `filter {}` must be specified.

The `destination` object supports the following:

* `bucket` - (Required) The ARN of the S3 bucket where you want Amazon S3 to store replicas of the object identified by the rule.
* `storage_class` - (Optional) The [storage class](https://docs.aws.amazon.com/AmazonS3/latest/API/API_Destination.html#AmazonS3-Type-Destination-StorageClass) used to store the object. By default, Amazon S3 uses the storage class of the source object to create the object replica.
* `replica_kms_key_id` - (Optional) Destination KMS encryption key ARN for SSE-KMS replication. Must be used in conjunction with
  `sse_kms_encrypted_objects` source selection criteria.
* `access_control_translation` - (Optional) Specifies the overrides to use for object owners on replication. Must be used in conjunction with `account_id` owner override configuration.
* `account_id` - (Optional) The Account ID to use for overriding the object owner on replication. Must be used in conjunction with `access_control_translation` override configuration.
* `replication_time` - (Optional) Enables S3 Replication Time Control (S3 RTC) (documented below).
* `metrics` - (Optional) Enables replication metrics (required for S3 RTC) (documented below).

The `replication_time` object supports the following:

* `status` - (Optional) The status of RTC. Either `Enabled` or `Disabled`.
* `minutes` - (Optional) Threshold within which objects are to be replicated. The only valid value is `15`.

The `metrics` object supports the following:

* `status` - (Optional) The status of replication metrics. Either `Enabled` or `Disabled`.
* `minutes` - (Optional) Threshold within which objects are to be replicated. The only valid value is `15`.

The `source_selection_criteria` object supports the following:

* `sse_kms_encrypted_objects` - (Optional) Match SSE-KMS encrypted objects (documented below). If specified, `replica_kms_key_id`
  in `destination` must be specified as well.

The `sse_kms_encrypted_objects` object supports the following:

* `enabled` - (Required) Boolean which indicates if this criteria is enabled.

The `filter` object supports the following:

* `prefix` - (Optional) Object keyname prefix that identifies subset of objects to which the rule applies. Must be less than or equal to 1024 characters in length.
* `tags` - (Optional)  A map of tags that identifies subset of objects to which the rule applies.
  The rule applies only to objects having all the tags in its tagset.

The `server_side_encryption_configuration` object supports the following:

* `rule` - (required) A single object for server-side encryption by default configuration. (documented below)

The `rule` object supports the following:

* `apply_server_side_encryption_by_default` - (required) A single object for setting server-side encryption by default. (documented below)
* `bucket_key_enabled` - (Optional) Whether or not to use [Amazon S3 Bucket Keys](https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html) for SSE-KMS.

The `apply_server_side_encryption_by_default` object supports the following:

* `sse_algorithm` - (required) The server-side encryption algorithm to use. Valid values are `AES256` and `aws:kms`
* `kms_master_key_id` - (optional) The AWS KMS master key ID used for the SSE-KMS encryption. This can only be used when you set the value of `sse_algorithm` as `aws:kms`. The default `aws/s3` AWS KMS master key is used if this element is absent while the `sse_algorithm` is `aws:kms`.

The `grant` object supports the following:

* `id` - (optional) Canonical user id to grant for. Used only when `type` is `CanonicalUser`.
* `type` - (required) - Type of grantee to apply for. Valid values are `CanonicalUser` and `Group`. `AmazonCustomerByEmail` is not supported.
* `permissions` - (required) List of permissions to apply for grantee. Valid values are `READ`, `WRITE`, `READ_ACP`, `WRITE_ACP`, `FULL_CONTROL`.
* `uri` - (optional) Uri address to grant for. Used only when `type` is `Group`.

The `access_control_translation` object supports the following:

* `owner` - (Required) The override value for the owner on replicated objects. Currently only `Destination` is supported.

The `object_lock_configuration` object supports the following:

* `object_lock_enabled` - (Required) Indicates whether this bucket has an Object Lock configuration enabled. Valid value is `Enabled`.
* `rule` - (Optional) The Object Lock rule in place for this bucket.

The `rule` object supports the following:

* `default_retention` - (Required) The default retention period that you want to apply to new objects placed in this bucket.

The `default_retention` object supports the following:

* `mode` - (Required) The default Object Lock retention mode you want to apply to new objects placed in this bucket. Valid values are `GOVERNANCE` and `COMPLIANCE`.
* `days` - (Optional) The number of days that you want to specify for the default retention period.
* `years` - (Optional) The number of years that you want to specify for the default retention period.

Either `days` or `years` must be specified, but not both.

~> **NOTE on `object_lock_configuration`:** You can only enable S3 Object Lock for new buckets. If you need to turn on S3 Object Lock for an existing bucket, please contact AWS Support.
When you create a bucket with S3 Object Lock enabled, Amazon S3 automatically enables versioning for the bucket.
Once you create a bucket with S3 Object Lock enabled, you can't disable Object Lock or suspend versioning for the bucket.

## Attributes Reference

In addition to all arguments above, the following attributes are exported:

* `id` - The name of the bucket.
* `arn` - The ARN of the bucket. Will be of format `arn:aws:s3:::bucketname`.
* `bucket_domain_name` - The bucket domain name. Will be of format `bucketname.s3.amazonaws.com`.
* `bucket_regional_domain_name` - The bucket region-specific domain name. The bucket domain name including the region name, please refer [here](https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region) for format. Note: The AWS CloudFront allows specifying S3 region-specific endpoint when creating S3 origin, it will prevent [redirect issues](https://forums.aws.amazon.com/thread.jspa?threadID=216814) from CloudFront to S3 Origin URL.
* `hosted_zone_id` - The [Route 53 Hosted Zone ID](https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_website_region_endpoints) for this bucket's region.
* `region` - The AWS region this bucket resides in.
* `tags_all` - A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
* `website_endpoint` - The website endpoint, if the bucket is configured with a website. If not, this will be an empty string.
* `website_domain` - The domain of the website endpoint, if the bucket is configured with a website. If not, this will be an empty string. This is used to create Route 53 alias records.

## Import

S3 bucket can be imported using the `bucket`, e.g.,

```
$ terraform import aws_s3_bucket_legacy.bucket bucket-name
```

The `policy` argument is not imported and will be deprecated in a future version of the provider. Use the `aws_s3_bucket_policy` resource to manage the S3 Bucket Policy instead.
