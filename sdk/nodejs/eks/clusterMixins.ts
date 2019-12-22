import { Cluster } from "./cluster";

declare module "./cluster" {
    interface Cluster {
        /**
         * Uses the outputs of the cluster to construct a KubeConfig for the current cluster
         */
        kubeconfig() : string
    }
}

Cluster.prototype.kubeconfig = function (this: Cluster)  {
    let args = ["token", "-i", this.name];

    if (this.roleArn) {
        args = [...args, "-r", this.roleArn];
    }

    let config = {
        apiVersion: "v1",
        clusters: [{
            cluster: {
                server: this.endpoint,
                "certificate-authority-data": this.certificateAuthority.data,
            },
            name: "kubernetes",
        }],
        contexts: [{
            context: {
                cluster: "kubernetes",
                user: "aws",
            },
            name: "aws",
        }],
        "current-context": "aws",
        kind: "Config",
        users: [{
            name: "aws",
            user: {
                exec: {
                    apiVersion: "client.authentication.k8s.io/v1alpha1",
                    command: "aws-iam-authenticator",
                    args: args,
                },
            },
        }],
    }

    return JSON.stringify(config);
};
