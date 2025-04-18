// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.auditmanager;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.auditmanager.inputs.GetControlArgs;
import com.pulumi.aws.auditmanager.inputs.GetControlPlainArgs;
import com.pulumi.aws.auditmanager.inputs.GetFrameworkArgs;
import com.pulumi.aws.auditmanager.inputs.GetFrameworkPlainArgs;
import com.pulumi.aws.auditmanager.outputs.GetControlResult;
import com.pulumi.aws.auditmanager.outputs.GetFrameworkResult;
import com.pulumi.core.Output;
import com.pulumi.core.TypeShape;
import com.pulumi.deployment.Deployment;
import com.pulumi.deployment.InvokeOptions;
import com.pulumi.deployment.InvokeOutputOptions;
import java.util.concurrent.CompletableFuture;

public final class AuditmanagerFunctions {
    /**
     * Data source for managing an AWS Audit Manager Control.
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
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetControlArgs;
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
     *         final var example = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("1. Risk Management")
     *             .type("Standard")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     * ### With Framework Resource
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetControlArgs;
     * import com.pulumi.aws.auditmanager.Framework;
     * import com.pulumi.aws.auditmanager.FrameworkArgs;
     * import com.pulumi.aws.auditmanager.inputs.FrameworkControlSetArgs;
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
     *         final var example = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("1. Risk Management")
     *             .type("Standard")
     *             .build());
     * 
     *         final var example2 = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("2. Personnel")
     *             .type("Standard")
     *             .build());
     * 
     *         var exampleFramework = new Framework("exampleFramework", FrameworkArgs.builder()
     *             .name("example")
     *             .controlSets(            
     *                 FrameworkControlSetArgs.builder()
     *                     .name("example")
     *                     .controls(FrameworkControlSetControlArgs.builder()
     *                         .id(example.id())
     *                         .build())
     *                     .build(),
     *                 FrameworkControlSetArgs.builder()
     *                     .name("example2")
     *                     .controls(FrameworkControlSetControlArgs.builder()
     *                         .id(example2.id())
     *                         .build())
     *                     .build())
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetControlResult> getControl(GetControlArgs args) {
        return getControl(args, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS Audit Manager Control.
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
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetControlArgs;
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
     *         final var example = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("1. Risk Management")
     *             .type("Standard")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     * ### With Framework Resource
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetControlArgs;
     * import com.pulumi.aws.auditmanager.Framework;
     * import com.pulumi.aws.auditmanager.FrameworkArgs;
     * import com.pulumi.aws.auditmanager.inputs.FrameworkControlSetArgs;
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
     *         final var example = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("1. Risk Management")
     *             .type("Standard")
     *             .build());
     * 
     *         final var example2 = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("2. Personnel")
     *             .type("Standard")
     *             .build());
     * 
     *         var exampleFramework = new Framework("exampleFramework", FrameworkArgs.builder()
     *             .name("example")
     *             .controlSets(            
     *                 FrameworkControlSetArgs.builder()
     *                     .name("example")
     *                     .controls(FrameworkControlSetControlArgs.builder()
     *                         .id(example.id())
     *                         .build())
     *                     .build(),
     *                 FrameworkControlSetArgs.builder()
     *                     .name("example2")
     *                     .controls(FrameworkControlSetControlArgs.builder()
     *                         .id(example2.id())
     *                         .build())
     *                     .build())
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetControlResult> getControlPlain(GetControlPlainArgs args) {
        return getControlPlain(args, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS Audit Manager Control.
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
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetControlArgs;
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
     *         final var example = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("1. Risk Management")
     *             .type("Standard")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     * ### With Framework Resource
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetControlArgs;
     * import com.pulumi.aws.auditmanager.Framework;
     * import com.pulumi.aws.auditmanager.FrameworkArgs;
     * import com.pulumi.aws.auditmanager.inputs.FrameworkControlSetArgs;
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
     *         final var example = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("1. Risk Management")
     *             .type("Standard")
     *             .build());
     * 
     *         final var example2 = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("2. Personnel")
     *             .type("Standard")
     *             .build());
     * 
     *         var exampleFramework = new Framework("exampleFramework", FrameworkArgs.builder()
     *             .name("example")
     *             .controlSets(            
     *                 FrameworkControlSetArgs.builder()
     *                     .name("example")
     *                     .controls(FrameworkControlSetControlArgs.builder()
     *                         .id(example.id())
     *                         .build())
     *                     .build(),
     *                 FrameworkControlSetArgs.builder()
     *                     .name("example2")
     *                     .controls(FrameworkControlSetControlArgs.builder()
     *                         .id(example2.id())
     *                         .build())
     *                     .build())
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetControlResult> getControl(GetControlArgs args, InvokeOptions options) {
        return Deployment.getInstance().invoke("aws:auditmanager/getControl:getControl", TypeShape.of(GetControlResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS Audit Manager Control.
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
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetControlArgs;
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
     *         final var example = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("1. Risk Management")
     *             .type("Standard")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     * ### With Framework Resource
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetControlArgs;
     * import com.pulumi.aws.auditmanager.Framework;
     * import com.pulumi.aws.auditmanager.FrameworkArgs;
     * import com.pulumi.aws.auditmanager.inputs.FrameworkControlSetArgs;
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
     *         final var example = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("1. Risk Management")
     *             .type("Standard")
     *             .build());
     * 
     *         final var example2 = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("2. Personnel")
     *             .type("Standard")
     *             .build());
     * 
     *         var exampleFramework = new Framework("exampleFramework", FrameworkArgs.builder()
     *             .name("example")
     *             .controlSets(            
     *                 FrameworkControlSetArgs.builder()
     *                     .name("example")
     *                     .controls(FrameworkControlSetControlArgs.builder()
     *                         .id(example.id())
     *                         .build())
     *                     .build(),
     *                 FrameworkControlSetArgs.builder()
     *                     .name("example2")
     *                     .controls(FrameworkControlSetControlArgs.builder()
     *                         .id(example2.id())
     *                         .build())
     *                     .build())
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetControlResult> getControl(GetControlArgs args, InvokeOutputOptions options) {
        return Deployment.getInstance().invoke("aws:auditmanager/getControl:getControl", TypeShape.of(GetControlResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS Audit Manager Control.
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
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetControlArgs;
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
     *         final var example = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("1. Risk Management")
     *             .type("Standard")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     * ### With Framework Resource
     * 
     * &lt;!--Start PulumiCodeChooser --&gt;
     * <pre>
     * {@code
     * package generated_program;
     * 
     * import com.pulumi.Context;
     * import com.pulumi.Pulumi;
     * import com.pulumi.core.Output;
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetControlArgs;
     * import com.pulumi.aws.auditmanager.Framework;
     * import com.pulumi.aws.auditmanager.FrameworkArgs;
     * import com.pulumi.aws.auditmanager.inputs.FrameworkControlSetArgs;
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
     *         final var example = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("1. Risk Management")
     *             .type("Standard")
     *             .build());
     * 
     *         final var example2 = AuditmanagerFunctions.getControl(GetControlArgs.builder()
     *             .name("2. Personnel")
     *             .type("Standard")
     *             .build());
     * 
     *         var exampleFramework = new Framework("exampleFramework", FrameworkArgs.builder()
     *             .name("example")
     *             .controlSets(            
     *                 FrameworkControlSetArgs.builder()
     *                     .name("example")
     *                     .controls(FrameworkControlSetControlArgs.builder()
     *                         .id(example.id())
     *                         .build())
     *                     .build(),
     *                 FrameworkControlSetArgs.builder()
     *                     .name("example2")
     *                     .controls(FrameworkControlSetControlArgs.builder()
     *                         .id(example2.id())
     *                         .build())
     *                     .build())
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetControlResult> getControlPlain(GetControlPlainArgs args, InvokeOptions options) {
        return Deployment.getInstance().invokeAsync("aws:auditmanager/getControl:getControl", TypeShape.of(GetControlResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS Audit Manager Framework.
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
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetFrameworkArgs;
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
     *         final var example = AuditmanagerFunctions.getFramework(GetFrameworkArgs.builder()
     *             .name("Essential Eight")
     *             .frameworkType("Standard")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetFrameworkResult> getFramework(GetFrameworkArgs args) {
        return getFramework(args, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS Audit Manager Framework.
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
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetFrameworkArgs;
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
     *         final var example = AuditmanagerFunctions.getFramework(GetFrameworkArgs.builder()
     *             .name("Essential Eight")
     *             .frameworkType("Standard")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetFrameworkResult> getFrameworkPlain(GetFrameworkPlainArgs args) {
        return getFrameworkPlain(args, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS Audit Manager Framework.
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
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetFrameworkArgs;
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
     *         final var example = AuditmanagerFunctions.getFramework(GetFrameworkArgs.builder()
     *             .name("Essential Eight")
     *             .frameworkType("Standard")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetFrameworkResult> getFramework(GetFrameworkArgs args, InvokeOptions options) {
        return Deployment.getInstance().invoke("aws:auditmanager/getFramework:getFramework", TypeShape.of(GetFrameworkResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS Audit Manager Framework.
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
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetFrameworkArgs;
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
     *         final var example = AuditmanagerFunctions.getFramework(GetFrameworkArgs.builder()
     *             .name("Essential Eight")
     *             .frameworkType("Standard")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetFrameworkResult> getFramework(GetFrameworkArgs args, InvokeOutputOptions options) {
        return Deployment.getInstance().invoke("aws:auditmanager/getFramework:getFramework", TypeShape.of(GetFrameworkResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS Audit Manager Framework.
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
     * import com.pulumi.aws.auditmanager.AuditmanagerFunctions;
     * import com.pulumi.aws.auditmanager.inputs.GetFrameworkArgs;
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
     *         final var example = AuditmanagerFunctions.getFramework(GetFrameworkArgs.builder()
     *             .name("Essential Eight")
     *             .frameworkType("Standard")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetFrameworkResult> getFrameworkPlain(GetFrameworkPlainArgs args, InvokeOptions options) {
        return Deployment.getInstance().invokeAsync("aws:auditmanager/getFramework:getFramework", TypeShape.of(GetFrameworkResult.class), args, Utilities.withVersion(options));
    }
}
