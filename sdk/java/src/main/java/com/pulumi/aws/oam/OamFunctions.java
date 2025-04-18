// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.oam;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.oam.inputs.GetLinkArgs;
import com.pulumi.aws.oam.inputs.GetLinkPlainArgs;
import com.pulumi.aws.oam.inputs.GetSinkArgs;
import com.pulumi.aws.oam.inputs.GetSinkPlainArgs;
import com.pulumi.aws.oam.outputs.GetLinkResult;
import com.pulumi.aws.oam.outputs.GetLinksResult;
import com.pulumi.aws.oam.outputs.GetSinkResult;
import com.pulumi.aws.oam.outputs.GetSinksResult;
import com.pulumi.core.Output;
import com.pulumi.core.TypeShape;
import com.pulumi.deployment.Deployment;
import com.pulumi.deployment.InvokeOptions;
import com.pulumi.deployment.InvokeOutputOptions;
import com.pulumi.resources.InvokeArgs;
import java.util.concurrent.CompletableFuture;

public final class OamFunctions {
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Link.
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
     * import com.pulumi.aws.oam.OamFunctions;
     * import com.pulumi.aws.oam.inputs.GetLinkArgs;
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
     *         final var example = OamFunctions.getLink(GetLinkArgs.builder()
     *             .linkIdentifier("arn:aws:oam:us-west-1:111111111111:link/abcd1234-a123-456a-a12b-a123b456c789")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetLinkResult> getLink(GetLinkArgs args) {
        return getLink(args, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Link.
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
     * import com.pulumi.aws.oam.OamFunctions;
     * import com.pulumi.aws.oam.inputs.GetLinkArgs;
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
     *         final var example = OamFunctions.getLink(GetLinkArgs.builder()
     *             .linkIdentifier("arn:aws:oam:us-west-1:111111111111:link/abcd1234-a123-456a-a12b-a123b456c789")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetLinkResult> getLinkPlain(GetLinkPlainArgs args) {
        return getLinkPlain(args, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Link.
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
     * import com.pulumi.aws.oam.OamFunctions;
     * import com.pulumi.aws.oam.inputs.GetLinkArgs;
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
     *         final var example = OamFunctions.getLink(GetLinkArgs.builder()
     *             .linkIdentifier("arn:aws:oam:us-west-1:111111111111:link/abcd1234-a123-456a-a12b-a123b456c789")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetLinkResult> getLink(GetLinkArgs args, InvokeOptions options) {
        return Deployment.getInstance().invoke("aws:oam/getLink:getLink", TypeShape.of(GetLinkResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Link.
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
     * import com.pulumi.aws.oam.OamFunctions;
     * import com.pulumi.aws.oam.inputs.GetLinkArgs;
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
     *         final var example = OamFunctions.getLink(GetLinkArgs.builder()
     *             .linkIdentifier("arn:aws:oam:us-west-1:111111111111:link/abcd1234-a123-456a-a12b-a123b456c789")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetLinkResult> getLink(GetLinkArgs args, InvokeOutputOptions options) {
        return Deployment.getInstance().invoke("aws:oam/getLink:getLink", TypeShape.of(GetLinkResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Link.
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
     * import com.pulumi.aws.oam.OamFunctions;
     * import com.pulumi.aws.oam.inputs.GetLinkArgs;
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
     *         final var example = OamFunctions.getLink(GetLinkArgs.builder()
     *             .linkIdentifier("arn:aws:oam:us-west-1:111111111111:link/abcd1234-a123-456a-a12b-a123b456c789")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetLinkResult> getLinkPlain(GetLinkPlainArgs args, InvokeOptions options) {
        return Deployment.getInstance().invokeAsync("aws:oam/getLink:getLink", TypeShape.of(GetLinkResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Links.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getLinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetLinksResult> getLinks() {
        return getLinks(InvokeArgs.Empty, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Links.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getLinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetLinksResult> getLinksPlain() {
        return getLinksPlain(InvokeArgs.Empty, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Links.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getLinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetLinksResult> getLinks(InvokeArgs args) {
        return getLinks(args, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Links.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getLinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetLinksResult> getLinksPlain(InvokeArgs args) {
        return getLinksPlain(args, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Links.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getLinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetLinksResult> getLinks(InvokeArgs args, InvokeOptions options) {
        return Deployment.getInstance().invoke("aws:oam/getLinks:getLinks", TypeShape.of(GetLinksResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Links.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getLinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetLinksResult> getLinks(InvokeArgs args, InvokeOutputOptions options) {
        return Deployment.getInstance().invoke("aws:oam/getLinks:getLinks", TypeShape.of(GetLinksResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Links.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getLinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetLinksResult> getLinksPlain(InvokeArgs args, InvokeOptions options) {
        return Deployment.getInstance().invokeAsync("aws:oam/getLinks:getLinks", TypeShape.of(GetLinksResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Sink.
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
     * import com.pulumi.aws.oam.OamFunctions;
     * import com.pulumi.aws.oam.inputs.GetSinkArgs;
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
     *         final var example = OamFunctions.getSink(GetSinkArgs.builder()
     *             .sinkIdentifier("arn:aws:oam:us-west-1:111111111111:sink/abcd1234-a123-456a-a12b-a123b456c789")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetSinkResult> getSink(GetSinkArgs args) {
        return getSink(args, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Sink.
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
     * import com.pulumi.aws.oam.OamFunctions;
     * import com.pulumi.aws.oam.inputs.GetSinkArgs;
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
     *         final var example = OamFunctions.getSink(GetSinkArgs.builder()
     *             .sinkIdentifier("arn:aws:oam:us-west-1:111111111111:sink/abcd1234-a123-456a-a12b-a123b456c789")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetSinkResult> getSinkPlain(GetSinkPlainArgs args) {
        return getSinkPlain(args, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Sink.
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
     * import com.pulumi.aws.oam.OamFunctions;
     * import com.pulumi.aws.oam.inputs.GetSinkArgs;
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
     *         final var example = OamFunctions.getSink(GetSinkArgs.builder()
     *             .sinkIdentifier("arn:aws:oam:us-west-1:111111111111:sink/abcd1234-a123-456a-a12b-a123b456c789")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetSinkResult> getSink(GetSinkArgs args, InvokeOptions options) {
        return Deployment.getInstance().invoke("aws:oam/getSink:getSink", TypeShape.of(GetSinkResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Sink.
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
     * import com.pulumi.aws.oam.OamFunctions;
     * import com.pulumi.aws.oam.inputs.GetSinkArgs;
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
     *         final var example = OamFunctions.getSink(GetSinkArgs.builder()
     *             .sinkIdentifier("arn:aws:oam:us-west-1:111111111111:sink/abcd1234-a123-456a-a12b-a123b456c789")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetSinkResult> getSink(GetSinkArgs args, InvokeOutputOptions options) {
        return Deployment.getInstance().invoke("aws:oam/getSink:getSink", TypeShape.of(GetSinkResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Sink.
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
     * import com.pulumi.aws.oam.OamFunctions;
     * import com.pulumi.aws.oam.inputs.GetSinkArgs;
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
     *         final var example = OamFunctions.getSink(GetSinkArgs.builder()
     *             .sinkIdentifier("arn:aws:oam:us-west-1:111111111111:sink/abcd1234-a123-456a-a12b-a123b456c789")
     *             .build());
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetSinkResult> getSinkPlain(GetSinkPlainArgs args, InvokeOptions options) {
        return Deployment.getInstance().invokeAsync("aws:oam/getSink:getSink", TypeShape.of(GetSinkResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Sinks.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getSinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetSinksResult> getSinks() {
        return getSinks(InvokeArgs.Empty, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Sinks.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getSinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetSinksResult> getSinksPlain() {
        return getSinksPlain(InvokeArgs.Empty, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Sinks.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getSinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetSinksResult> getSinks(InvokeArgs args) {
        return getSinks(args, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Sinks.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getSinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetSinksResult> getSinksPlain(InvokeArgs args) {
        return getSinksPlain(args, InvokeOptions.Empty);
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Sinks.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getSinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetSinksResult> getSinks(InvokeArgs args, InvokeOptions options) {
        return Deployment.getInstance().invoke("aws:oam/getSinks:getSinks", TypeShape.of(GetSinksResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Sinks.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getSinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetSinksResult> getSinks(InvokeArgs args, InvokeOutputOptions options) {
        return Deployment.getInstance().invoke("aws:oam/getSinks:getSinks", TypeShape.of(GetSinksResult.class), args, Utilities.withVersion(options));
    }
    /**
     * Data source for managing an AWS CloudWatch Observability Access Manager Sinks.
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
     * import com.pulumi.aws.oam.OamFunctions;
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
     *         final var example = OamFunctions.getSinks(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetSinksResult> getSinksPlain(InvokeArgs args, InvokeOptions options) {
        return Deployment.getInstance().invokeAsync("aws:oam/getSinks:getSinks", TypeShape.of(GetSinksResult.class), args, Utilities.withVersion(options));
    }
}
