// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.glue;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.glue.ConnectionArgs;
import com.pulumi.aws.glue.inputs.ConnectionState;
import com.pulumi.aws.glue.outputs.ConnectionPhysicalConnectionRequirements;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a Glue Connection resource.
 * 
 * ## Example Usage
 * 
 * ### Non-VPC Connection
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.glue.Connection;
 * import com.pulumi.aws.glue.ConnectionArgs;
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
 *         var example = new Connection("example", ConnectionArgs.builder()
 *             .name("example")
 *             .connectionProperties(Map.ofEntries(
 *                 Map.entry("JDBC_CONNECTION_URL", "jdbc:mysql://example.com/exampledatabase"),
 *                 Map.entry("PASSWORD", "examplepassword"),
 *                 Map.entry("USERNAME", "exampleusername")
 *             ))
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Non-VPC Connection with secret manager reference
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.secretsmanager.SecretsmanagerFunctions;
 * import com.pulumi.aws.secretsmanager.inputs.GetSecretArgs;
 * import com.pulumi.aws.glue.Connection;
 * import com.pulumi.aws.glue.ConnectionArgs;
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
 *         final var example = SecretsmanagerFunctions.getSecret(GetSecretArgs.builder()
 *             .name("example-secret")
 *             .build());
 * 
 *         var exampleConnection = new Connection("exampleConnection", ConnectionArgs.builder()
 *             .name("example")
 *             .connectionProperties(Map.ofEntries(
 *                 Map.entry("JDBC_CONNECTION_URL", "jdbc:mysql://example.com/exampledatabase"),
 *                 Map.entry("SECRET_ID", example.name())
 *             ))
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### VPC Connection
 * 
 * For more information, see the [AWS Documentation](https://docs.aws.amazon.com/glue/latest/dg/populate-add-connection.html#connection-JDBC-VPC).
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.glue.Connection;
 * import com.pulumi.aws.glue.ConnectionArgs;
 * import com.pulumi.aws.glue.inputs.ConnectionPhysicalConnectionRequirementsArgs;
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
 *         var example = new Connection("example", ConnectionArgs.builder()
 *             .name("example")
 *             .connectionProperties(Map.ofEntries(
 *                 Map.entry("JDBC_CONNECTION_URL", String.format("jdbc:mysql://%s/exampledatabase", exampleAwsRdsCluster.endpoint())),
 *                 Map.entry("PASSWORD", "examplepassword"),
 *                 Map.entry("USERNAME", "exampleusername")
 *             ))
 *             .physicalConnectionRequirements(ConnectionPhysicalConnectionRequirementsArgs.builder()
 *                 .availabilityZone(exampleAwsSubnet.availabilityZone())
 *                 .securityGroupIdLists(exampleAwsSecurityGroup.id())
 *                 .subnetId(exampleAwsSubnet.id())
 *                 .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Connection using a custom connector
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.secretsmanager.SecretsmanagerFunctions;
 * import com.pulumi.aws.secretsmanager.inputs.GetSecretArgs;
 * import com.pulumi.aws.glue.Connection;
 * import com.pulumi.aws.glue.ConnectionArgs;
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
 *         // Define the custom connector using the connection_type of `CUSTOM` with the match_criteria of `template_connection`
 *         // Example here being a snowflake jdbc connector with a secret having user and password as keys
 *         final var example = SecretsmanagerFunctions.getSecret(GetSecretArgs.builder()
 *             .name("example-secret")
 *             .build());
 * 
 *         var example1 = new Connection("example1", ConnectionArgs.builder()
 *             .name("example1")
 *             .connectionType("CUSTOM")
 *             .connectionProperties(Map.ofEntries(
 *                 Map.entry("CONNECTOR_CLASS_NAME", "net.snowflake.client.jdbc.SnowflakeDriver"),
 *                 Map.entry("CONNECTION_TYPE", "Jdbc"),
 *                 Map.entry("CONNECTOR_URL", "s3://example/snowflake-jdbc.jar"),
 *                 Map.entry("JDBC_CONNECTION_URL", "[[\"default=jdbc:snowflake://example.com/?user=${user}&password=${password}\"],\",\"]")
 *             ))
 *             .matchCriterias("template-connection")
 *             .build());
 * 
 *         // Reference the connector using match_criteria with the connector created above.
 *         var example2 = new Connection("example2", ConnectionArgs.builder()
 *             .name("example2")
 *             .connectionType("CUSTOM")
 *             .connectionProperties(Map.ofEntries(
 *                 Map.entry("CONNECTOR_CLASS_NAME", "net.snowflake.client.jdbc.SnowflakeDriver"),
 *                 Map.entry("CONNECTION_TYPE", "Jdbc"),
 *                 Map.entry("CONNECTOR_URL", "s3://example/snowflake-jdbc.jar"),
 *                 Map.entry("JDBC_CONNECTION_URL", "jdbc:snowflake://example.com/?user=${user}&password=${password}"),
 *                 Map.entry("SECRET_ID", example.name())
 *             ))
 *             .matchCriterias(            
 *                 "Connection",
 *                 example1.name())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Azure Cosmos Connection
 * 
 * For more information, see the [AWS Documentation](https://docs.aws.amazon.com/glue/latest/dg/connection-properties.html#connection-properties-azurecosmos).
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.secretsmanager.Secret;
 * import com.pulumi.aws.secretsmanager.SecretArgs;
 * import com.pulumi.aws.secretsmanager.SecretVersion;
 * import com.pulumi.aws.secretsmanager.SecretVersionArgs;
 * import com.pulumi.aws.glue.Connection;
 * import com.pulumi.aws.glue.ConnectionArgs;
 * import static com.pulumi.codegen.internal.Serialization.*;
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
 *         var example = new Secret("example", SecretArgs.builder()
 *             .name("example-secret")
 *             .build());
 * 
 *         var exampleSecretVersion = new SecretVersion("exampleSecretVersion", SecretVersionArgs.builder()
 *             .secretId(example.id())
 *             .secretString(serializeJson(
 *                 jsonObject(
 *                     jsonProperty("username", "exampleusername"),
 *                     jsonProperty("password", "examplepassword")
 *                 )))
 *             .build());
 * 
 *         var exampleConnection = new Connection("exampleConnection", ConnectionArgs.builder()
 *             .name("example")
 *             .connectionType("AZURECOSMOS")
 *             .connectionProperties(Map.of("SparkProperties", example.name().applyValue(_name -> serializeJson(
 *                 jsonObject(
 *                     jsonProperty("secretId", _name),
 *                     jsonProperty("spark.cosmos.accountEndpoint", "https://exampledbaccount.documents.azure.com:443/")
 *                 )))))
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Azure SQL Connection
 * 
 * For more information, see the [AWS Documentation](https://docs.aws.amazon.com/glue/latest/dg/connection-properties.html#connection-properties-azuresql).
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.secretsmanager.Secret;
 * import com.pulumi.aws.secretsmanager.SecretArgs;
 * import com.pulumi.aws.secretsmanager.SecretVersion;
 * import com.pulumi.aws.secretsmanager.SecretVersionArgs;
 * import com.pulumi.aws.glue.Connection;
 * import com.pulumi.aws.glue.ConnectionArgs;
 * import static com.pulumi.codegen.internal.Serialization.*;
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
 *         var example = new Secret("example", SecretArgs.builder()
 *             .name("example-secret")
 *             .build());
 * 
 *         var exampleSecretVersion = new SecretVersion("exampleSecretVersion", SecretVersionArgs.builder()
 *             .secretId(example.id())
 *             .secretString(serializeJson(
 *                 jsonObject(
 *                     jsonProperty("username", "exampleusername"),
 *                     jsonProperty("password", "examplepassword")
 *                 )))
 *             .build());
 * 
 *         var exampleConnection = new Connection("exampleConnection", ConnectionArgs.builder()
 *             .name("example")
 *             .connectionType("AZURECOSMOS")
 *             .connectionProperties(Map.of("SparkProperties", example.name().applyValue(_name -> serializeJson(
 *                 jsonObject(
 *                     jsonProperty("secretId", _name),
 *                     jsonProperty("url", "jdbc:sqlserver:exampledbserver.database.windows.net:1433;database=exampledatabase")
 *                 )))))
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Google BigQuery Connection
 * 
 * For more information, see the [AWS Documentation](https://docs.aws.amazon.com/glue/latest/dg/connection-properties.html#connection-properties-bigquery).
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.secretsmanager.Secret;
 * import com.pulumi.aws.secretsmanager.SecretArgs;
 * import com.pulumi.aws.secretsmanager.SecretVersion;
 * import com.pulumi.aws.secretsmanager.SecretVersionArgs;
 * import com.pulumi.std.StdFunctions;
 * import com.pulumi.std.inputs.Base64encodeArgs;
 * import com.pulumi.aws.glue.Connection;
 * import com.pulumi.aws.glue.ConnectionArgs;
 * import static com.pulumi.codegen.internal.Serialization.*;
 * import java.util.List;
 * import java.util.ArrayList;
 * import java.util.Map;
 * import java.io.File;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * 
 * public class App }{{@code
 *     public static void main(String[] args) }{{@code
 *         Pulumi.run(App::stack);
 *     }}{@code
 * 
 *     public static void stack(Context ctx) }{{@code
 *         var example = new Secret("example", SecretArgs.builder()
 *             .name("example-secret")
 *             .build());
 * 
 *         var exampleSecretVersion = new SecretVersion("exampleSecretVersion", SecretVersionArgs.builder()
 *             .secretId(example.id())
 *             .secretString(serializeJson(
 *                 jsonObject(
 *                     jsonProperty("credentials", StdFunctions.base64encode(Base64encodeArgs.builder()
 *                         .input("""
 * }{{@code
 *   "type": "service_account",
 *   "project_id": "example-project",
 *   "private_key_id": "example-key",
 *   "private_key": "-----BEGIN RSA PRIVATE KEY-----\nREDACTED\n-----END RSA PRIVATE KEY-----",
 *   "client_email": "example-project}{@literal @}{@code appspot.gserviceaccount.com",
 *   "client_id": example-client",
 *   "auth_uri": "https://accounts.google.com/o/oauth2/auth",
 *   "token_uri": "https://oauth2.googleapis.com/token",
 *   "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
 *   "client_x509_cert_url": "https://www.googleapis.com/robot/v1/metadata/x509/example-project%%40appspot.gserviceaccount.com",
 *   "universe_domain": "googleapis.com"
 * }}{@code
 *                         """)
 *                         .build()).result())
 *                 )))
 *             .build());
 * 
 *         var exampleConnection = new Connection("exampleConnection", ConnectionArgs.builder()
 *             .name("example")
 *             .connectionType("BIGQUERY")
 *             .connectionProperties(Map.of("SparkProperties", example.name().applyValue(_name -> serializeJson(
 *                 jsonObject(
 *                     jsonProperty("secretId", _name)
 *                 )))))
 *             .build());
 * 
 *     }}{@code
 * }}{@code
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### OpenSearch Service Connection
 * 
 * For more information, see the [AWS Documentation](https://docs.aws.amazon.com/glue/latest/dg/connection-properties.html#connection-properties-opensearch).
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.secretsmanager.Secret;
 * import com.pulumi.aws.secretsmanager.SecretArgs;
 * import com.pulumi.aws.secretsmanager.SecretVersion;
 * import com.pulumi.aws.secretsmanager.SecretVersionArgs;
 * import com.pulumi.aws.glue.Connection;
 * import com.pulumi.aws.glue.ConnectionArgs;
 * import static com.pulumi.codegen.internal.Serialization.*;
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
 *         var example = new Secret("example", SecretArgs.builder()
 *             .name("example-secret")
 *             .build());
 * 
 *         var exampleSecretVersion = new SecretVersion("exampleSecretVersion", SecretVersionArgs.builder()
 *             .secretId(example.id())
 *             .secretString(serializeJson(
 *                 jsonObject(
 *                     jsonProperty("opensearch.net.http.auth.user", "exampleusername"),
 *                     jsonProperty("opensearch.net.http.auth.pass", "examplepassword")
 *                 )))
 *             .build());
 * 
 *         var exampleConnection = new Connection("exampleConnection", ConnectionArgs.builder()
 *             .name("example")
 *             .connectionType("OPENSEARCH")
 *             .connectionProperties(Map.of("SparkProperties", example.name().applyValue(_name -> serializeJson(
 *                 jsonObject(
 *                     jsonProperty("secretId", _name),
 *                     jsonProperty("opensearch.nodes", "https://search-exampledomain-ixlmh4jieahrau3bfebcgp8cnm.us-east-1.es.amazonaws.com"),
 *                     jsonProperty("opensearch.port", "443"),
 *                     jsonProperty("opensearch.aws.sigv4.region", "us-east-1"),
 *                     jsonProperty("opensearch.nodes.wan.only", "true"),
 *                     jsonProperty("opensearch.aws.sigv4.enabled", "true")
 *                 )))))
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Snowflake Connection
 * 
 * For more information, see the [AWS Documentation](https://docs.aws.amazon.com/glue/latest/dg/connection-properties.html#connection-properties-snowflake).
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.secretsmanager.Secret;
 * import com.pulumi.aws.secretsmanager.SecretArgs;
 * import com.pulumi.aws.secretsmanager.SecretVersion;
 * import com.pulumi.aws.secretsmanager.SecretVersionArgs;
 * import com.pulumi.aws.glue.Connection;
 * import com.pulumi.aws.glue.ConnectionArgs;
 * import static com.pulumi.codegen.internal.Serialization.*;
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
 *         var example = new Secret("example", SecretArgs.builder()
 *             .name("example-secret")
 *             .build());
 * 
 *         var exampleSecretVersion = new SecretVersion("exampleSecretVersion", SecretVersionArgs.builder()
 *             .secretId(example.id())
 *             .secretString(serializeJson(
 *                 jsonObject(
 *                     jsonProperty("sfUser", "exampleusername"),
 *                     jsonProperty("sfPassword", "examplepassword")
 *                 )))
 *             .build());
 * 
 *         var exampleConnection = new Connection("exampleConnection", ConnectionArgs.builder()
 *             .name("example")
 *             .connectionType("SNOWFLAKE")
 *             .connectionProperties(Map.of("SparkProperties", example.name().applyValue(_name -> serializeJson(
 *                 jsonObject(
 *                     jsonProperty("secretId", _name),
 *                     jsonProperty("sfRole", "EXAMPLEETLROLE"),
 *                     jsonProperty("sfUrl", "exampleorg-exampleconnection.snowflakecomputing.com")
 *                 )))))
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### DynamoDB Connection
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.glue.Connection;
 * import com.pulumi.aws.glue.ConnectionArgs;
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
 *         var test = new Connection("test", ConnectionArgs.builder()
 *             .name("example")
 *             .connectionType("DYNAMODB")
 *             .athenaProperties(Map.ofEntries(
 *                 Map.entry("lambda_function_arn", "arn:aws:lambda:us-east-1:123456789012:function:athenafederatedcatalog_athena_abcdefgh"),
 *                 Map.entry("disable_spill_encryption", "false"),
 *                 Map.entry("spill_bucket", "example-bucket")
 *             ))
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
 * Using `pulumi import`, import Glue Connections using the `CATALOG-ID` (AWS account ID if not custom) and `NAME`. For example:
 * 
 * ```sh
 * $ pulumi import aws:glue/connection:Connection MyConnection 123456789012:MyConnection
 * ```
 * 
 */
@ResourceType(type="aws:glue/connection:Connection")
public class Connection extends com.pulumi.resources.CustomResource {
    /**
     * ARN of the Glue Connection.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN of the Glue Connection.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Map of key-value pairs used as connection properties specific to the Athena compute environment.
     * 
     */
    @Export(name="athenaProperties", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> athenaProperties;

    /**
     * @return Map of key-value pairs used as connection properties specific to the Athena compute environment.
     * 
     */
    public Output<Optional<Map<String,String>>> athenaProperties() {
        return Codegen.optional(this.athenaProperties);
    }
    /**
     * ID of the Data Catalog in which to create the connection. If none is supplied, the AWS account ID is used by default.
     * 
     */
    @Export(name="catalogId", refs={String.class}, tree="[0]")
    private Output<String> catalogId;

    /**
     * @return ID of the Data Catalog in which to create the connection. If none is supplied, the AWS account ID is used by default.
     * 
     */
    public Output<String> catalogId() {
        return this.catalogId;
    }
    /**
     * Map of key-value pairs used as parameters for this connection. For more information, see the [AWS Documentation](https://docs.aws.amazon.com/glue/latest/dg/connection-properties.html).
     * 
     * **Note:** Some connection types require the `SparkProperties` property with a JSON document that contains the actual connection properties. For specific examples, refer to Example Usage.
     * 
     */
    @Export(name="connectionProperties", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> connectionProperties;

    /**
     * @return Map of key-value pairs used as parameters for this connection. For more information, see the [AWS Documentation](https://docs.aws.amazon.com/glue/latest/dg/connection-properties.html).
     * 
     * **Note:** Some connection types require the `SparkProperties` property with a JSON document that contains the actual connection properties. For specific examples, refer to Example Usage.
     * 
     */
    public Output<Optional<Map<String,String>>> connectionProperties() {
        return Codegen.optional(this.connectionProperties);
    }
    /**
     * Type of the connection. Valid values: `AZURECOSMOS`, `AZURESQL`, `BIGQUERY`, `CUSTOM`, `DYNAMODB`, `JDBC`, `KAFKA`, `MARKETPLACE`, `MONGODB`, `NETWORK`, `OPENSEARCH`, `SNOWFLAKE`. Defaults to `JDBC`.
     * 
     */
    @Export(name="connectionType", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> connectionType;

    /**
     * @return Type of the connection. Valid values: `AZURECOSMOS`, `AZURESQL`, `BIGQUERY`, `CUSTOM`, `DYNAMODB`, `JDBC`, `KAFKA`, `MARKETPLACE`, `MONGODB`, `NETWORK`, `OPENSEARCH`, `SNOWFLAKE`. Defaults to `JDBC`.
     * 
     */
    public Output<Optional<String>> connectionType() {
        return Codegen.optional(this.connectionType);
    }
    /**
     * Description of the connection.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return Description of the connection.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * List of criteria that can be used in selecting this connection.
     * 
     */
    @Export(name="matchCriterias", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> matchCriterias;

    /**
     * @return List of criteria that can be used in selecting this connection.
     * 
     */
    public Output<Optional<List<String>>> matchCriterias() {
        return Codegen.optional(this.matchCriterias);
    }
    /**
     * Name of the connection.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the connection.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Map of physical connection requirements, such as VPC and SecurityGroup. See `physical_connection_requirements` Block for details.
     * 
     */
    @Export(name="physicalConnectionRequirements", refs={ConnectionPhysicalConnectionRequirements.class}, tree="[0]")
    private Output</* @Nullable */ ConnectionPhysicalConnectionRequirements> physicalConnectionRequirements;

    /**
     * @return Map of physical connection requirements, such as VPC and SecurityGroup. See `physical_connection_requirements` Block for details.
     * 
     */
    public Output<Optional<ConnectionPhysicalConnectionRequirements>> physicalConnectionRequirements() {
        return Codegen.optional(this.physicalConnectionRequirements);
    }
    /**
     * Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
    public Connection(java.lang.String name) {
        this(name, ConnectionArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Connection(java.lang.String name, @Nullable ConnectionArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Connection(java.lang.String name, @Nullable ConnectionArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:glue/connection:Connection", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Connection(java.lang.String name, Output<java.lang.String> id, @Nullable ConnectionState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:glue/connection:Connection", name, state, makeResourceOptions(options, id), false);
    }

    private static ConnectionArgs makeArgs(@Nullable ConnectionArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? ConnectionArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .additionalSecretOutputs(List.of(
                "athenaProperties",
                "connectionProperties"
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
    public static Connection get(java.lang.String name, Output<java.lang.String> id, @Nullable ConnectionState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Connection(name, id, state, options);
    }
}
