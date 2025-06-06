// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ecrpublic;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ecrpublic.outputs.GetAuthorizationTokenResult;
import com.pulumi.core.Output;
import com.pulumi.core.TypeShape;
import com.pulumi.deployment.Deployment;
import com.pulumi.deployment.InvokeOptions;
import com.pulumi.deployment.InvokeOutputOptions;
import com.pulumi.resources.InvokeArgs;
import java.util.concurrent.CompletableFuture;

public final class EcrpublicFunctions {
    /**
     * The Public ECR Authorization Token data source allows the authorization token, token expiration date, user name, and password to be retrieved for a Public ECR repository.
     * 
     * &gt; **NOTE:** This data source can only be used in the `us-east-1` region.
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
     * import com.pulumi.aws.ecrpublic.EcrpublicFunctions;
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
     *         final var token = EcrpublicFunctions.getAuthorizationToken(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetAuthorizationTokenResult> getAuthorizationToken() {
        return getAuthorizationToken(InvokeArgs.Empty, InvokeOptions.Empty);
    }
    /**
     * The Public ECR Authorization Token data source allows the authorization token, token expiration date, user name, and password to be retrieved for a Public ECR repository.
     * 
     * &gt; **NOTE:** This data source can only be used in the `us-east-1` region.
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
     * import com.pulumi.aws.ecrpublic.EcrpublicFunctions;
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
     *         final var token = EcrpublicFunctions.getAuthorizationToken(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetAuthorizationTokenResult> getAuthorizationTokenPlain() {
        return getAuthorizationTokenPlain(InvokeArgs.Empty, InvokeOptions.Empty);
    }
    /**
     * The Public ECR Authorization Token data source allows the authorization token, token expiration date, user name, and password to be retrieved for a Public ECR repository.
     * 
     * &gt; **NOTE:** This data source can only be used in the `us-east-1` region.
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
     * import com.pulumi.aws.ecrpublic.EcrpublicFunctions;
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
     *         final var token = EcrpublicFunctions.getAuthorizationToken(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetAuthorizationTokenResult> getAuthorizationToken(InvokeArgs args) {
        return getAuthorizationToken(args, InvokeOptions.Empty);
    }
    /**
     * The Public ECR Authorization Token data source allows the authorization token, token expiration date, user name, and password to be retrieved for a Public ECR repository.
     * 
     * &gt; **NOTE:** This data source can only be used in the `us-east-1` region.
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
     * import com.pulumi.aws.ecrpublic.EcrpublicFunctions;
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
     *         final var token = EcrpublicFunctions.getAuthorizationToken(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetAuthorizationTokenResult> getAuthorizationTokenPlain(InvokeArgs args) {
        return getAuthorizationTokenPlain(args, InvokeOptions.Empty);
    }
    /**
     * The Public ECR Authorization Token data source allows the authorization token, token expiration date, user name, and password to be retrieved for a Public ECR repository.
     * 
     * &gt; **NOTE:** This data source can only be used in the `us-east-1` region.
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
     * import com.pulumi.aws.ecrpublic.EcrpublicFunctions;
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
     *         final var token = EcrpublicFunctions.getAuthorizationToken(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetAuthorizationTokenResult> getAuthorizationToken(InvokeArgs args, InvokeOptions options) {
        return Deployment.getInstance().invoke("aws:ecrpublic/getAuthorizationToken:getAuthorizationToken", TypeShape.of(GetAuthorizationTokenResult.class), args, Utilities.withVersion(options));
    }
    /**
     * The Public ECR Authorization Token data source allows the authorization token, token expiration date, user name, and password to be retrieved for a Public ECR repository.
     * 
     * &gt; **NOTE:** This data source can only be used in the `us-east-1` region.
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
     * import com.pulumi.aws.ecrpublic.EcrpublicFunctions;
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
     *         final var token = EcrpublicFunctions.getAuthorizationToken(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static Output<GetAuthorizationTokenResult> getAuthorizationToken(InvokeArgs args, InvokeOutputOptions options) {
        return Deployment.getInstance().invoke("aws:ecrpublic/getAuthorizationToken:getAuthorizationToken", TypeShape.of(GetAuthorizationTokenResult.class), args, Utilities.withVersion(options));
    }
    /**
     * The Public ECR Authorization Token data source allows the authorization token, token expiration date, user name, and password to be retrieved for a Public ECR repository.
     * 
     * &gt; **NOTE:** This data source can only be used in the `us-east-1` region.
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
     * import com.pulumi.aws.ecrpublic.EcrpublicFunctions;
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
     *         final var token = EcrpublicFunctions.getAuthorizationToken(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference);
     * 
     *     }
     * }
     * }
     * </pre>
     * &lt;!--End PulumiCodeChooser --&gt;
     * 
     */
    public static CompletableFuture<GetAuthorizationTokenResult> getAuthorizationTokenPlain(InvokeArgs args, InvokeOptions options) {
        return Deployment.getInstance().invokeAsync("aws:ecrpublic/getAuthorizationToken:getAuthorizationToken", TypeShape.of(GetAuthorizationTokenResult.class), args, Utilities.withVersion(options));
    }
}
