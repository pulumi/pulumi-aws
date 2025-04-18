// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssmincidents;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ssmincidents.inputs.GetReplicationSetArgs;
import com.pulumi.aws.ssmincidents.inputs.GetReplicationSetPlainArgs;
import com.pulumi.aws.ssmincidents.inputs.GetResponsePlanArgs;
import com.pulumi.aws.ssmincidents.inputs.GetResponsePlanPlainArgs;
import com.pulumi.aws.ssmincidents.outputs.GetReplicationSetResult;
import com.pulumi.aws.ssmincidents.outputs.GetResponsePlanResult;
import com.pulumi.core.Output;
import com.pulumi.core.TypeShape;
import com.pulumi.deployment.Deployment;
import com.pulumi.deployment.InvokeOptions;
import com.pulumi.deployment.InvokeOutputOptions;
import java.util.concurrent.CompletableFuture;

public final class SsmincidentsFunctions {
    /**
     * &gt; **NOTE:** The AWS Region specified by a provider must always be one of the Regions specified for the replication set.
     * 
     * Use this data source to manage a replication set in AWS Systems Manager Incident Manager.
     * 
     * ## Example Usage
     * 
     * ### Basic Usage
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.ssmincidents.SsmincidentsFunctions;
     * import com.pulumi.aws.ssmincidents.inputs.GetReplicationSetArgs;
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
     *         final var example = SsmincidentsFunctions.getReplicationSet(GetReplicationSetArgs.builder()
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetReplicationSetResult> getReplicationSet() {
        return getReplicationSet(GetReplicationSetArgs.Empty, InvokeOptions.Empty);
    }
    /**
     * &gt; **NOTE:** The AWS Region specified by a provider must always be one of the Regions specified for the replication set.
     * 
     * Use this data source to manage a replication set in AWS Systems Manager Incident Manager.
     * 
     * ## Example Usage
     * 
     * ### Basic Usage
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.ssmincidents.SsmincidentsFunctions;
     * import com.pulumi.aws.ssmincidents.inputs.GetReplicationSetArgs;
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
     *         final var example = SsmincidentsFunctions.getReplicationSet(GetReplicationSetArgs.builder()
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetReplicationSetResult> getReplicationSetPlain() {
        return getReplicationSetPlain(GetReplicationSetPlainArgs.Empty, InvokeOptions.Empty);
    }
    /**
     * &gt; **NOTE:** The AWS Region specified by a provider must always be one of the Regions specified for the replication set.
     * 
     * Use this data source to manage a replication set in AWS Systems Manager Incident Manager.
     * 
     * ## Example Usage
     * 
     * ### Basic Usage
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.ssmincidents.SsmincidentsFunctions;
     * import com.pulumi.aws.ssmincidents.inputs.GetReplicationSetArgs;
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
     *         final var example = SsmincidentsFunctions.getReplicationSet(GetReplicationSetArgs.builder()
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetReplicationSetResult> getReplicationSet(GetReplicationSetArgs args) {
        return getReplicationSet(args, InvokeOptions.Empty);
    }
    /**
     * &gt; **NOTE:** The AWS Region specified by a provider must always be one of the Regions specified for the replication set.
     * 
     * Use this data source to manage a replication set in AWS Systems Manager Incident Manager.
     * 
     * ## Example Usage
     * 
     * ### Basic Usage
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.ssmincidents.SsmincidentsFunctions;
     * import com.pulumi.aws.ssmincidents.inputs.GetReplicationSetArgs;
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
     *         final var example = SsmincidentsFunctions.getReplicationSet(GetReplicationSetArgs.builder()
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetReplicationSetResult> getReplicationSetPlain(GetReplicationSetPlainArgs args) {
        return getReplicationSetPlain(args, InvokeOptions.Empty);
    }
    /**
     * &gt; **NOTE:** The AWS Region specified by a provider must always be one of the Regions specified for the replication set.
     * 
     * Use this data source to manage a replication set in AWS Systems Manager Incident Manager.
     * 
     * ## Example Usage
     * 
     * ### Basic Usage
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.ssmincidents.SsmincidentsFunctions;
     * import com.pulumi.aws.ssmincidents.inputs.GetReplicationSetArgs;
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
     *         final var example = SsmincidentsFunctions.getReplicationSet(GetReplicationSetArgs.builder()
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetReplicationSetResult> getReplicationSet(GetReplicationSetArgs args, InvokeOptions options) {
        return Deployment.getInstance().invoke("aws:ssmincidents/getReplicationSet:getReplicationSet", TypeShape.of(GetReplicationSetResult.class), args, Utilities.withVersion(options));
    }
    /**
     * &gt; **NOTE:** The AWS Region specified by a provider must always be one of the Regions specified for the replication set.
     * 
     * Use this data source to manage a replication set in AWS Systems Manager Incident Manager.
     * 
     * ## Example Usage
     * 
     * ### Basic Usage
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.ssmincidents.SsmincidentsFunctions;
     * import com.pulumi.aws.ssmincidents.inputs.GetReplicationSetArgs;
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
     *         final var example = SsmincidentsFunctions.getReplicationSet(GetReplicationSetArgs.builder()
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetReplicationSetResult> getReplicationSet(GetReplicationSetArgs args, InvokeOutputOptions options) {
        return Deployment.getInstance().invoke("aws:ssmincidents/getReplicationSet:getReplicationSet", TypeShape.of(GetReplicationSetResult.class), args, Utilities.withVersion(options));
    }
    /**
     * &gt; **NOTE:** The AWS Region specified by a provider must always be one of the Regions specified for the replication set.
     * 
     * Use this data source to manage a replication set in AWS Systems Manager Incident Manager.
     * 
     * ## Example Usage
     * 
     * ### Basic Usage
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.ssmincidents.SsmincidentsFunctions;
     * import com.pulumi.aws.ssmincidents.inputs.GetReplicationSetArgs;
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
     *         final var example = SsmincidentsFunctions.getReplicationSet(GetReplicationSetArgs.builder()
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetReplicationSetResult> getReplicationSetPlain(GetReplicationSetPlainArgs args, InvokeOptions options) {
        return Deployment.getInstance().invokeAsync("aws:ssmincidents/getReplicationSet:getReplicationSet", TypeShape.of(GetReplicationSetResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Use this data source to manage a response plan in AWS Systems Manager Incident Manager.
     * 
     * ## Example Usage
     * 
     * ### Basic Usage
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetResponsePlanResult> getResponsePlan(GetResponsePlanArgs args) {
        return getResponsePlan(args, InvokeOptions.Empty);
    }
    /**
     * Use this data source to manage a response plan in AWS Systems Manager Incident Manager.
     * 
     * ## Example Usage
     * 
     * ### Basic Usage
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetResponsePlanResult> getResponsePlanPlain(GetResponsePlanPlainArgs args) {
        return getResponsePlanPlain(args, InvokeOptions.Empty);
    }
    /**
     * Use this data source to manage a response plan in AWS Systems Manager Incident Manager.
     * 
     * ## Example Usage
     * 
     * ### Basic Usage
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetResponsePlanResult> getResponsePlan(GetResponsePlanArgs args, InvokeOptions options) {
        return Deployment.getInstance().invoke("aws:ssmincidents/getResponsePlan:getResponsePlan", TypeShape.of(GetResponsePlanResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Use this data source to manage a response plan in AWS Systems Manager Incident Manager.
     * 
     * ## Example Usage
     * 
     * ### Basic Usage
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetResponsePlanResult> getResponsePlan(GetResponsePlanArgs args, InvokeOutputOptions options) {
        return Deployment.getInstance().invoke("aws:ssmincidents/getResponsePlan:getResponsePlan", TypeShape.of(GetResponsePlanResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Use this data source to manage a response plan in AWS Systems Manager Incident Manager.
     * 
     * ## Example Usage
     * 
     * ### Basic Usage
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetResponsePlanResult> getResponsePlanPlain(GetResponsePlanPlainArgs args, InvokeOptions options) {
        return Deployment.getInstance().invokeAsync("aws:ssmincidents/getResponsePlan:getResponsePlan", TypeShape.of(GetResponsePlanResult.class), args, Utilities.withVersion(options));
    }
}
