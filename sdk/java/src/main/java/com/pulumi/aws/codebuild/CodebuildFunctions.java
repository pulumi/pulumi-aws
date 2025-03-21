// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codebuild;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.codebuild.inputs.GetFleetArgs;
import com.pulumi.aws.codebuild.inputs.GetFleetPlainArgs;
import com.pulumi.aws.codebuild.outputs.GetFleetResult;
import com.pulumi.core.Output;
import com.pulumi.core.TypeShape;
import com.pulumi.deployment.Deployment;
import com.pulumi.deployment.InvokeOptions;
import com.pulumi.deployment.InvokeOutputOptions;
import java.util.concurrent.CompletableFuture;

public final class CodebuildFunctions {
    /**
     * Retrieve information about an CodeBuild Fleet.
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
     * import com.pulumi.aws.codebuild.Fleet;
     * import com.pulumi.aws.codebuild.FleetArgs;
     * import com.pulumi.aws.codebuild.inputs.FleetScalingConfigurationArgs;
     * import com.pulumi.aws.codebuild.CodebuildFunctions;
     * import com.pulumi.aws.codebuild.inputs.GetFleetArgs;
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
     *         var testFleet = new Fleet("testFleet", FleetArgs.builder()
     *             .baseCapacity(2)
     *             .computeType("BUILD_GENERAL1_SMALL")
     *             .environmentType("LINUX_CONTAINER")
     *             .name("full-example-codebuild-fleet")
     *             .overflowBehavior("QUEUE")
     *             .scalingConfiguration(FleetScalingConfigurationArgs.builder()
     *                 .maxCapacity(5)
     *                 .scalingType("TARGET_TRACKING_SCALING")
     *                 .targetTrackingScalingConfigs(FleetScalingConfigurationTargetTrackingScalingConfigArgs.builder()
     *                     .metricType("FLEET_UTILIZATION_RATE")
     *                     .targetValue(97.5)
     *                     .build())
     *                 .build())
     *             .build());
     * 
     *         final var test = CodebuildFunctions.getFleet(GetFleetArgs.builder()
     *             .name(testFleet.name())
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
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
     * import com.pulumi.aws.codebuild.CodebuildFunctions;
     * import com.pulumi.aws.codebuild.inputs.GetFleetArgs;
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
     *         final var example = CodebuildFunctions.getFleet(GetFleetArgs.builder()
     *             .name("my-codebuild-fleet-name")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetFleetResult> getFleet(GetFleetArgs args) {
        return getFleet(args, InvokeOptions.Empty);
    }
    /**
     * Retrieve information about an CodeBuild Fleet.
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
     * import com.pulumi.aws.codebuild.Fleet;
     * import com.pulumi.aws.codebuild.FleetArgs;
     * import com.pulumi.aws.codebuild.inputs.FleetScalingConfigurationArgs;
     * import com.pulumi.aws.codebuild.CodebuildFunctions;
     * import com.pulumi.aws.codebuild.inputs.GetFleetArgs;
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
     *         var testFleet = new Fleet("testFleet", FleetArgs.builder()
     *             .baseCapacity(2)
     *             .computeType("BUILD_GENERAL1_SMALL")
     *             .environmentType("LINUX_CONTAINER")
     *             .name("full-example-codebuild-fleet")
     *             .overflowBehavior("QUEUE")
     *             .scalingConfiguration(FleetScalingConfigurationArgs.builder()
     *                 .maxCapacity(5)
     *                 .scalingType("TARGET_TRACKING_SCALING")
     *                 .targetTrackingScalingConfigs(FleetScalingConfigurationTargetTrackingScalingConfigArgs.builder()
     *                     .metricType("FLEET_UTILIZATION_RATE")
     *                     .targetValue(97.5)
     *                     .build())
     *                 .build())
     *             .build());
     * 
     *         final var test = CodebuildFunctions.getFleet(GetFleetArgs.builder()
     *             .name(testFleet.name())
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
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
     * import com.pulumi.aws.codebuild.CodebuildFunctions;
     * import com.pulumi.aws.codebuild.inputs.GetFleetArgs;
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
     *         final var example = CodebuildFunctions.getFleet(GetFleetArgs.builder()
     *             .name("my-codebuild-fleet-name")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetFleetResult> getFleetPlain(GetFleetPlainArgs args) {
        return getFleetPlain(args, InvokeOptions.Empty);
    }
    /**
     * Retrieve information about an CodeBuild Fleet.
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
     * import com.pulumi.aws.codebuild.Fleet;
     * import com.pulumi.aws.codebuild.FleetArgs;
     * import com.pulumi.aws.codebuild.inputs.FleetScalingConfigurationArgs;
     * import com.pulumi.aws.codebuild.CodebuildFunctions;
     * import com.pulumi.aws.codebuild.inputs.GetFleetArgs;
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
     *         var testFleet = new Fleet("testFleet", FleetArgs.builder()
     *             .baseCapacity(2)
     *             .computeType("BUILD_GENERAL1_SMALL")
     *             .environmentType("LINUX_CONTAINER")
     *             .name("full-example-codebuild-fleet")
     *             .overflowBehavior("QUEUE")
     *             .scalingConfiguration(FleetScalingConfigurationArgs.builder()
     *                 .maxCapacity(5)
     *                 .scalingType("TARGET_TRACKING_SCALING")
     *                 .targetTrackingScalingConfigs(FleetScalingConfigurationTargetTrackingScalingConfigArgs.builder()
     *                     .metricType("FLEET_UTILIZATION_RATE")
     *                     .targetValue(97.5)
     *                     .build())
     *                 .build())
     *             .build());
     * 
     *         final var test = CodebuildFunctions.getFleet(GetFleetArgs.builder()
     *             .name(testFleet.name())
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
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
     * import com.pulumi.aws.codebuild.CodebuildFunctions;
     * import com.pulumi.aws.codebuild.inputs.GetFleetArgs;
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
     *         final var example = CodebuildFunctions.getFleet(GetFleetArgs.builder()
     *             .name("my-codebuild-fleet-name")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetFleetResult> getFleet(GetFleetArgs args, InvokeOptions options) {
        return Deployment.getInstance().invoke("aws:codebuild/getFleet:getFleet", TypeShape.of(GetFleetResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Retrieve information about an CodeBuild Fleet.
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
     * import com.pulumi.aws.codebuild.Fleet;
     * import com.pulumi.aws.codebuild.FleetArgs;
     * import com.pulumi.aws.codebuild.inputs.FleetScalingConfigurationArgs;
     * import com.pulumi.aws.codebuild.CodebuildFunctions;
     * import com.pulumi.aws.codebuild.inputs.GetFleetArgs;
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
     *         var testFleet = new Fleet("testFleet", FleetArgs.builder()
     *             .baseCapacity(2)
     *             .computeType("BUILD_GENERAL1_SMALL")
     *             .environmentType("LINUX_CONTAINER")
     *             .name("full-example-codebuild-fleet")
     *             .overflowBehavior("QUEUE")
     *             .scalingConfiguration(FleetScalingConfigurationArgs.builder()
     *                 .maxCapacity(5)
     *                 .scalingType("TARGET_TRACKING_SCALING")
     *                 .targetTrackingScalingConfigs(FleetScalingConfigurationTargetTrackingScalingConfigArgs.builder()
     *                     .metricType("FLEET_UTILIZATION_RATE")
     *                     .targetValue(97.5)
     *                     .build())
     *                 .build())
     *             .build());
     * 
     *         final var test = CodebuildFunctions.getFleet(GetFleetArgs.builder()
     *             .name(testFleet.name())
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
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
     * import com.pulumi.aws.codebuild.CodebuildFunctions;
     * import com.pulumi.aws.codebuild.inputs.GetFleetArgs;
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
     *         final var example = CodebuildFunctions.getFleet(GetFleetArgs.builder()
     *             .name("my-codebuild-fleet-name")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetFleetResult> getFleet(GetFleetArgs args, InvokeOutputOptions options) {
        return Deployment.getInstance().invoke("aws:codebuild/getFleet:getFleet", TypeShape.of(GetFleetResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Retrieve information about an CodeBuild Fleet.
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
     * import com.pulumi.aws.codebuild.Fleet;
     * import com.pulumi.aws.codebuild.FleetArgs;
     * import com.pulumi.aws.codebuild.inputs.FleetScalingConfigurationArgs;
     * import com.pulumi.aws.codebuild.CodebuildFunctions;
     * import com.pulumi.aws.codebuild.inputs.GetFleetArgs;
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
     *         var testFleet = new Fleet("testFleet", FleetArgs.builder()
     *             .baseCapacity(2)
     *             .computeType("BUILD_GENERAL1_SMALL")
     *             .environmentType("LINUX_CONTAINER")
     *             .name("full-example-codebuild-fleet")
     *             .overflowBehavior("QUEUE")
     *             .scalingConfiguration(FleetScalingConfigurationArgs.builder()
     *                 .maxCapacity(5)
     *                 .scalingType("TARGET_TRACKING_SCALING")
     *                 .targetTrackingScalingConfigs(FleetScalingConfigurationTargetTrackingScalingConfigArgs.builder()
     *                     .metricType("FLEET_UTILIZATION_RATE")
     *                     .targetValue(97.5)
     *                     .build())
     *                 .build())
     *             .build());
     * 
     *         final var test = CodebuildFunctions.getFleet(GetFleetArgs.builder()
     *             .name(testFleet.name())
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
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
     * import com.pulumi.aws.codebuild.CodebuildFunctions;
     * import com.pulumi.aws.codebuild.inputs.GetFleetArgs;
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
     *         final var example = CodebuildFunctions.getFleet(GetFleetArgs.builder()
     *             .name("my-codebuild-fleet-name")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetFleetResult> getFleetPlain(GetFleetPlainArgs args, InvokeOptions options) {
        return Deployment.getInstance().invokeAsync("aws:codebuild/getFleet:getFleet", TypeShape.of(GetFleetResult.class), args, Utilities.withVersion(options));
    }
}
