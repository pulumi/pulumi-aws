// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sns;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.sns.inputs.GetTopicArgs;
import com.pulumi.aws.sns.inputs.GetTopicPlainArgs;
import com.pulumi.aws.sns.outputs.GetTopicResult;
import com.pulumi.core.Output;
import com.pulumi.core.TypeShape;
import com.pulumi.deployment.Deployment;
import com.pulumi.deployment.InvokeOptions;
import com.pulumi.deployment.InvokeOutputOptions;
import java.util.concurrent.CompletableFuture;

public final class SnsFunctions {
    /**
     * Use this data source to get the ARN of a topic in AWS Simple Notification
     * Service (SNS). By using this data source, you can reference SNS topics
     * without having to hard code the ARNs as input.
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
     * import com.pulumi.aws.sns.SnsFunctions;
     * import com.pulumi.aws.sns.inputs.GetTopicArgs;
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
     *         final var example = SnsFunctions.getTopic(GetTopicArgs.builder()
     *             .name("an_example_topic")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetTopicResult> getTopic(GetTopicArgs args) {
        return getTopic(args, InvokeOptions.Empty);
    }
    /**
     * Use this data source to get the ARN of a topic in AWS Simple Notification
     * Service (SNS). By using this data source, you can reference SNS topics
     * without having to hard code the ARNs as input.
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
     * import com.pulumi.aws.sns.SnsFunctions;
     * import com.pulumi.aws.sns.inputs.GetTopicArgs;
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
     *         final var example = SnsFunctions.getTopic(GetTopicArgs.builder()
     *             .name("an_example_topic")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetTopicResult> getTopicPlain(GetTopicPlainArgs args) {
        return getTopicPlain(args, InvokeOptions.Empty);
    }
    /**
     * Use this data source to get the ARN of a topic in AWS Simple Notification
     * Service (SNS). By using this data source, you can reference SNS topics
     * without having to hard code the ARNs as input.
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
     * import com.pulumi.aws.sns.SnsFunctions;
     * import com.pulumi.aws.sns.inputs.GetTopicArgs;
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
     *         final var example = SnsFunctions.getTopic(GetTopicArgs.builder()
     *             .name("an_example_topic")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetTopicResult> getTopic(GetTopicArgs args, InvokeOptions options) {
        return Deployment.getInstance().invoke("aws:sns/getTopic:getTopic", TypeShape.of(GetTopicResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Use this data source to get the ARN of a topic in AWS Simple Notification
     * Service (SNS). By using this data source, you can reference SNS topics
     * without having to hard code the ARNs as input.
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
     * import com.pulumi.aws.sns.SnsFunctions;
     * import com.pulumi.aws.sns.inputs.GetTopicArgs;
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
     *         final var example = SnsFunctions.getTopic(GetTopicArgs.builder()
     *             .name("an_example_topic")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetTopicResult> getTopic(GetTopicArgs args, InvokeOutputOptions options) {
        return Deployment.getInstance().invoke("aws:sns/getTopic:getTopic", TypeShape.of(GetTopicResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Use this data source to get the ARN of a topic in AWS Simple Notification
     * Service (SNS). By using this data source, you can reference SNS topics
     * without having to hard code the ARNs as input.
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
     * import com.pulumi.aws.sns.SnsFunctions;
     * import com.pulumi.aws.sns.inputs.GetTopicArgs;
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
     *         final var example = SnsFunctions.getTopic(GetTopicArgs.builder()
     *             .name("an_example_topic")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetTopicResult> getTopicPlain(GetTopicPlainArgs args, InvokeOptions options) {
        return Deployment.getInstance().invokeAsync("aws:sns/getTopic:getTopic", TypeShape.of(GetTopicResult.class), args, Utilities.withVersion(options));
    }
}
