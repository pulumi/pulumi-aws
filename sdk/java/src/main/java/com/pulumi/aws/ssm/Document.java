// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssm;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ssm.DocumentArgs;
import com.pulumi.aws.ssm.inputs.DocumentState;
import com.pulumi.aws.ssm.outputs.DocumentAttachmentsSource;
import com.pulumi.aws.ssm.outputs.DocumentParameter;
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
 * Provides an SSM Document resource
 * 
 * &gt; **NOTE on updating SSM documents:** Only documents with a schema version of 2.0
 * or greater can update their content once created, see [SSM Schema Features](http://docs.aws.amazon.com/systems-manager/latest/userguide/sysman-ssm-docs.html#document-schemas-features). To update a document with an older schema version you must recreate the resource. Not all document types support a schema version of 2.0 or greater. Refer to [SSM document schema features and examples](https://docs.aws.amazon.com/systems-manager/latest/userguide/document-schemas-features.html) for information about which schema versions are supported for the respective `document_type`.
 * 
 * ## Example Usage
 * 
 * ### Create an ssm document in JSON format
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ssm.Document;
 * import com.pulumi.aws.ssm.DocumentArgs;
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
 *         var foo = new Document("foo", DocumentArgs.builder()
 *             .name("test_document")
 *             .documentType("Command")
 *             .content("""
 *   {
 *     "schemaVersion": "1.2",
 *     "description": "Check ip configuration of a Linux instance.",
 *     "parameters": {
 * 
 *     },
 *     "runtimeConfig": {
 *       "aws:runShellScript": {
 *         "properties": [
 *           {
 *             "id": "0.aws:runShellScript",
 *             "runCommand": ["ifconfig"]
 *           }
 *         ]
 *       }
 *     }
 *   }
 *             """)
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Create an ssm document in YAML format
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ssm.Document;
 * import com.pulumi.aws.ssm.DocumentArgs;
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
 *         var foo = new Document("foo", DocumentArgs.builder()
 *             .name("test_document")
 *             .documentFormat("YAML")
 *             .documentType("Command")
 *             .content("""
 * schemaVersion: '1.2'
 * description: Check ip configuration of a Linux instance.
 * parameters: {}
 * runtimeConfig:
 *   'aws:runShellScript':
 *     properties:
 *       - id: '0.aws:runShellScript'
 *         runCommand:
 *           - ifconfig
 *             """)
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
 * Using `pulumi import`, import SSM Documents using the name. For example:
 * 
 * ```sh
 * $ pulumi import aws:ssm/document:Document example example
 * ```
 * The `attachments_source` argument does not have an SSM API method for reading the attachment information detail after creation. If the argument is set in the Pulumi program on an imported resource, Pulumi will always show a difference. To workaround this behavior, either omit the argument from the Pulumi program or use `ignore_changes` to hide the difference. For example:
 * 
 */
@ResourceType(type="aws:ssm/document:Document")
public class Document extends com.pulumi.resources.CustomResource {
    /**
     * The Amazon Resource Name (ARN) of the document.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) of the document.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * One or more configuration blocks describing attachments sources to a version of a document. See `attachments_source` block below for details.
     * 
     */
    @Export(name="attachmentsSources", refs={List.class,DocumentAttachmentsSource.class}, tree="[0,1]")
    private Output</* @Nullable */ List<DocumentAttachmentsSource>> attachmentsSources;

    /**
     * @return One or more configuration blocks describing attachments sources to a version of a document. See `attachments_source` block below for details.
     * 
     */
    public Output<Optional<List<DocumentAttachmentsSource>>> attachmentsSources() {
        return Codegen.optional(this.attachmentsSources);
    }
    /**
     * The content for the SSM document in JSON or YAML format. The content of the document must not exceed 64KB. This quota also includes the content specified for input parameters at runtime. We recommend storing the contents for your new document in an external JSON or YAML file and referencing the file in a command.
     * 
     */
    @Export(name="content", refs={String.class}, tree="[0]")
    private Output<String> content;

    /**
     * @return The content for the SSM document in JSON or YAML format. The content of the document must not exceed 64KB. This quota also includes the content specified for input parameters at runtime. We recommend storing the contents for your new document in an external JSON or YAML file and referencing the file in a command.
     * 
     */
    public Output<String> content() {
        return this.content;
    }
    /**
     * The date the document was created.
     * 
     */
    @Export(name="createdDate", refs={String.class}, tree="[0]")
    private Output<String> createdDate;

    /**
     * @return The date the document was created.
     * 
     */
    public Output<String> createdDate() {
        return this.createdDate;
    }
    /**
     * The default version of the document.
     * 
     */
    @Export(name="defaultVersion", refs={String.class}, tree="[0]")
    private Output<String> defaultVersion;

    /**
     * @return The default version of the document.
     * 
     */
    public Output<String> defaultVersion() {
        return this.defaultVersion;
    }
    /**
     * A description of what the parameter does, how to use it, the default value, and whether or not the parameter is optional.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output<String> description;

    /**
     * @return A description of what the parameter does, how to use it, the default value, and whether or not the parameter is optional.
     * 
     */
    public Output<String> description() {
        return this.description;
    }
    /**
     * The format of the document. Valid values: `JSON`, `TEXT`, `YAML`.
     * 
     */
    @Export(name="documentFormat", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> documentFormat;

    /**
     * @return The format of the document. Valid values: `JSON`, `TEXT`, `YAML`.
     * 
     */
    public Output<Optional<String>> documentFormat() {
        return Codegen.optional(this.documentFormat);
    }
    /**
     * The type of the document. For a list of valid values, see the [API Reference](https://docs.aws.amazon.com/systems-manager/latest/APIReference/API_CreateDocument.html#systemsmanager-CreateDocument-request-DocumentType).
     * 
     */
    @Export(name="documentType", refs={String.class}, tree="[0]")
    private Output<String> documentType;

    /**
     * @return The type of the document. For a list of valid values, see the [API Reference](https://docs.aws.amazon.com/systems-manager/latest/APIReference/API_CreateDocument.html#systemsmanager-CreateDocument-request-DocumentType).
     * 
     */
    public Output<String> documentType() {
        return this.documentType;
    }
    /**
     * The document version.
     * 
     */
    @Export(name="documentVersion", refs={String.class}, tree="[0]")
    private Output<String> documentVersion;

    /**
     * @return The document version.
     * 
     */
    public Output<String> documentVersion() {
        return this.documentVersion;
    }
    /**
     * The Sha256 or Sha1 hash created by the system when the document was created.
     * 
     */
    @Export(name="hash", refs={String.class}, tree="[0]")
    private Output<String> hash;

    /**
     * @return The Sha256 or Sha1 hash created by the system when the document was created.
     * 
     */
    public Output<String> hash() {
        return this.hash;
    }
    /**
     * The hash type of the document. Valid values: `Sha256`, `Sha1`.
     * 
     */
    @Export(name="hashType", refs={String.class}, tree="[0]")
    private Output<String> hashType;

    /**
     * @return The hash type of the document. Valid values: `Sha256`, `Sha1`.
     * 
     */
    public Output<String> hashType() {
        return this.hashType;
    }
    /**
     * The latest version of the document.
     * 
     */
    @Export(name="latestVersion", refs={String.class}, tree="[0]")
    private Output<String> latestVersion;

    /**
     * @return The latest version of the document.
     * 
     */
    public Output<String> latestVersion() {
        return this.latestVersion;
    }
    /**
     * The name of the document.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return The name of the document.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * The Amazon Web Services user that created the document.
     * 
     */
    @Export(name="owner", refs={String.class}, tree="[0]")
    private Output<String> owner;

    /**
     * @return The Amazon Web Services user that created the document.
     * 
     */
    public Output<String> owner() {
        return this.owner;
    }
    /**
     * One or more configuration blocks describing the parameters for the document. See `parameter` block below for details.
     * 
     */
    @Export(name="parameters", refs={List.class,DocumentParameter.class}, tree="[0,1]")
    private Output<List<DocumentParameter>> parameters;

    /**
     * @return One or more configuration blocks describing the parameters for the document. See `parameter` block below for details.
     * 
     */
    public Output<List<DocumentParameter>> parameters() {
        return this.parameters;
    }
    /**
     * Additional permissions to attach to the document. See Permissions below for details.
     * 
     */
    @Export(name="permissions", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> permissions;

    /**
     * @return Additional permissions to attach to the document. See Permissions below for details.
     * 
     */
    public Output<Optional<Map<String,String>>> permissions() {
        return Codegen.optional(this.permissions);
    }
    /**
     * The list of operating system (OS) platforms compatible with this SSM document. Valid values: `Windows`, `Linux`, `MacOS`.
     * 
     */
    @Export(name="platformTypes", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> platformTypes;

    /**
     * @return The list of operating system (OS) platforms compatible with this SSM document. Valid values: `Windows`, `Linux`, `MacOS`.
     * 
     */
    public Output<List<String>> platformTypes() {
        return this.platformTypes;
    }
    /**
     * The schema version of the document.
     * 
     */
    @Export(name="schemaVersion", refs={String.class}, tree="[0]")
    private Output<String> schemaVersion;

    /**
     * @return The schema version of the document.
     * 
     */
    public Output<String> schemaVersion() {
        return this.schemaVersion;
    }
    /**
     * The status of the SSM document. Valid values: `Creating`, `Active`, `Updating`, `Deleting`, `Failed`.
     * 
     */
    @Export(name="status", refs={String.class}, tree="[0]")
    private Output<String> status;

    /**
     * @return The status of the SSM document. Valid values: `Creating`, `Active`, `Updating`, `Deleting`, `Failed`.
     * 
     */
    public Output<String> status() {
        return this.status;
    }
    /**
     * A map of tags to assign to the object. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the object. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
     * The target type which defines the kinds of resources the document can run on. For example, `/AWS::EC2::Instance`. For a list of valid resource types, see [AWS resource and property types reference](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-template-resource-type-ref.html).
     * 
     */
    @Export(name="targetType", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> targetType;

    /**
     * @return The target type which defines the kinds of resources the document can run on. For example, `/AWS::EC2::Instance`. For a list of valid resource types, see [AWS resource and property types reference](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-template-resource-type-ref.html).
     * 
     */
    public Output<Optional<String>> targetType() {
        return Codegen.optional(this.targetType);
    }
    /**
     * The version of the artifact associated with the document. For example, `12.6`. This value is unique across all versions of a document, and can&#39;t be changed.
     * 
     */
    @Export(name="versionName", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> versionName;

    /**
     * @return The version of the artifact associated with the document. For example, `12.6`. This value is unique across all versions of a document, and can&#39;t be changed.
     * 
     */
    public Output<Optional<String>> versionName() {
        return Codegen.optional(this.versionName);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Document(java.lang.String name) {
        this(name, DocumentArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Document(java.lang.String name, DocumentArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Document(java.lang.String name, DocumentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssm/document:Document", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Document(java.lang.String name, Output<java.lang.String> id, @Nullable DocumentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssm/document:Document", name, state, makeResourceOptions(options, id), false);
    }

    private static DocumentArgs makeArgs(DocumentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? DocumentArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
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
    public static Document get(java.lang.String name, Output<java.lang.String> id, @Nullable DocumentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Document(name, id, state, options);
    }
}
