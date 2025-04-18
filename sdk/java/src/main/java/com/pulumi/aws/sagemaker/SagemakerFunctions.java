// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.sagemaker.inputs.GetPrebuiltEcrImageArgs;
import com.pulumi.aws.sagemaker.inputs.GetPrebuiltEcrImagePlainArgs;
import com.pulumi.aws.sagemaker.outputs.GetPrebuiltEcrImageResult;
import com.pulumi.core.Output;
import com.pulumi.core.TypeShape;
import com.pulumi.deployment.Deployment;
import com.pulumi.deployment.InvokeOptions;
import com.pulumi.deployment.InvokeOutputOptions;
import java.util.concurrent.CompletableFuture;

public final class SagemakerFunctions {
    /**
     * Get information about prebuilt Amazon SageMaker AI  Docker images.
     * 
     * &gt; **NOTE:** The AWS provider creates a validly constructed `registry_path` but does not verify that the `registry_path` corresponds to an existing image. For example, using a `registry_path` containing an `image_tag` that does not correspond to a Docker image in the ECR repository, will result in an error.
     * 
     * ## Example Usage
     * 
     * Basic usage:
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.sagemaker.SagemakerFunctions;
     * import com.pulumi.aws.sagemaker.inputs.GetPrebuiltEcrImageArgs;
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
     *         final var test = SagemakerFunctions.getPrebuiltEcrImage(GetPrebuiltEcrImageArgs.builder()
     *             .repositoryName("sagemaker-scikit-learn")
     *             .imageTag("2.2-1.0.11.0")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetPrebuiltEcrImageResult> getPrebuiltEcrImage(GetPrebuiltEcrImageArgs args) {
        return getPrebuiltEcrImage(args, InvokeOptions.Empty);
    }
    /**
     * Get information about prebuilt Amazon SageMaker AI  Docker images.
     * 
     * &gt; **NOTE:** The AWS provider creates a validly constructed `registry_path` but does not verify that the `registry_path` corresponds to an existing image. For example, using a `registry_path` containing an `image_tag` that does not correspond to a Docker image in the ECR repository, will result in an error.
     * 
     * ## Example Usage
     * 
     * Basic usage:
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.sagemaker.SagemakerFunctions;
     * import com.pulumi.aws.sagemaker.inputs.GetPrebuiltEcrImageArgs;
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
     *         final var test = SagemakerFunctions.getPrebuiltEcrImage(GetPrebuiltEcrImageArgs.builder()
     *             .repositoryName("sagemaker-scikit-learn")
     *             .imageTag("2.2-1.0.11.0")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetPrebuiltEcrImageResult> getPrebuiltEcrImagePlain(GetPrebuiltEcrImagePlainArgs args) {
        return getPrebuiltEcrImagePlain(args, InvokeOptions.Empty);
    }
    /**
     * Get information about prebuilt Amazon SageMaker AI  Docker images.
     * 
     * &gt; **NOTE:** The AWS provider creates a validly constructed `registry_path` but does not verify that the `registry_path` corresponds to an existing image. For example, using a `registry_path` containing an `image_tag` that does not correspond to a Docker image in the ECR repository, will result in an error.
     * 
     * ## Example Usage
     * 
     * Basic usage:
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.sagemaker.SagemakerFunctions;
     * import com.pulumi.aws.sagemaker.inputs.GetPrebuiltEcrImageArgs;
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
     *         final var test = SagemakerFunctions.getPrebuiltEcrImage(GetPrebuiltEcrImageArgs.builder()
     *             .repositoryName("sagemaker-scikit-learn")
     *             .imageTag("2.2-1.0.11.0")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetPrebuiltEcrImageResult> getPrebuiltEcrImage(GetPrebuiltEcrImageArgs args, InvokeOptions options) {
        return Deployment.getInstance().invoke("aws:sagemaker/getPrebuiltEcrImage:getPrebuiltEcrImage", TypeShape.of(GetPrebuiltEcrImageResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Get information about prebuilt Amazon SageMaker AI  Docker images.
     * 
     * &gt; **NOTE:** The AWS provider creates a validly constructed `registry_path` but does not verify that the `registry_path` corresponds to an existing image. For example, using a `registry_path` containing an `image_tag` that does not correspond to a Docker image in the ECR repository, will result in an error.
     * 
     * ## Example Usage
     * 
     * Basic usage:
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.sagemaker.SagemakerFunctions;
     * import com.pulumi.aws.sagemaker.inputs.GetPrebuiltEcrImageArgs;
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
     *         final var test = SagemakerFunctions.getPrebuiltEcrImage(GetPrebuiltEcrImageArgs.builder()
     *             .repositoryName("sagemaker-scikit-learn")
     *             .imageTag("2.2-1.0.11.0")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetPrebuiltEcrImageResult> getPrebuiltEcrImage(GetPrebuiltEcrImageArgs args, InvokeOutputOptions options) {
        return Deployment.getInstance().invoke("aws:sagemaker/getPrebuiltEcrImage:getPrebuiltEcrImage", TypeShape.of(GetPrebuiltEcrImageResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Get information about prebuilt Amazon SageMaker AI  Docker images.
     * 
     * &gt; **NOTE:** The AWS provider creates a validly constructed `registry_path` but does not verify that the `registry_path` corresponds to an existing image. For example, using a `registry_path` containing an `image_tag` that does not correspond to a Docker image in the ECR repository, will result in an error.
     * 
     * ## Example Usage
     * 
     * Basic usage:
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.sagemaker.SagemakerFunctions;
     * import com.pulumi.aws.sagemaker.inputs.GetPrebuiltEcrImageArgs;
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
     *         final var test = SagemakerFunctions.getPrebuiltEcrImage(GetPrebuiltEcrImageArgs.builder()
     *             .repositoryName("sagemaker-scikit-learn")
     *             .imageTag("2.2-1.0.11.0")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetPrebuiltEcrImageResult> getPrebuiltEcrImagePlain(GetPrebuiltEcrImagePlainArgs args, InvokeOptions options) {
        return Deployment.getInstance().invokeAsync("aws:sagemaker/getPrebuiltEcrImage:getPrebuiltEcrImage", TypeShape.of(GetPrebuiltEcrImageResult.class), args, Utilities.withVersion(options));
    }
}
