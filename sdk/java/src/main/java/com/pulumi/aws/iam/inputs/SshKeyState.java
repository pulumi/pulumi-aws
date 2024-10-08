// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iam.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class SshKeyState extends com.pulumi.resources.ResourceArgs {

    public static final SshKeyState Empty = new SshKeyState();

    /**
     * Specifies the public key encoding format to use in the response. To retrieve the public key in ssh-rsa format, use `SSH`. To retrieve the public key in PEM format, use `PEM`.
     * 
     */
    @Import(name="encoding")
    private @Nullable Output<String> encoding;

    /**
     * @return Specifies the public key encoding format to use in the response. To retrieve the public key in ssh-rsa format, use `SSH`. To retrieve the public key in PEM format, use `PEM`.
     * 
     */
    public Optional<Output<String>> encoding() {
        return Optional.ofNullable(this.encoding);
    }

    /**
     * The MD5 message digest of the SSH public key.
     * 
     */
    @Import(name="fingerprint")
    private @Nullable Output<String> fingerprint;

    /**
     * @return The MD5 message digest of the SSH public key.
     * 
     */
    public Optional<Output<String>> fingerprint() {
        return Optional.ofNullable(this.fingerprint);
    }

    /**
     * The SSH public key. The public key must be encoded in ssh-rsa format or PEM format.
     * 
     */
    @Import(name="publicKey")
    private @Nullable Output<String> publicKey;

    /**
     * @return The SSH public key. The public key must be encoded in ssh-rsa format or PEM format.
     * 
     */
    public Optional<Output<String>> publicKey() {
        return Optional.ofNullable(this.publicKey);
    }

    /**
     * The unique identifier for the SSH public key.
     * 
     */
    @Import(name="sshPublicKeyId")
    private @Nullable Output<String> sshPublicKeyId;

    /**
     * @return The unique identifier for the SSH public key.
     * 
     */
    public Optional<Output<String>> sshPublicKeyId() {
        return Optional.ofNullable(this.sshPublicKeyId);
    }

    /**
     * The status to assign to the SSH public key. Active means the key can be used for authentication with an AWS CodeCommit repository. Inactive means the key cannot be used. Default is `active`.
     * 
     */
    @Import(name="status")
    private @Nullable Output<String> status;

    /**
     * @return The status to assign to the SSH public key. Active means the key can be used for authentication with an AWS CodeCommit repository. Inactive means the key cannot be used. Default is `active`.
     * 
     */
    public Optional<Output<String>> status() {
        return Optional.ofNullable(this.status);
    }

    /**
     * The name of the IAM user to associate the SSH public key with.
     * 
     */
    @Import(name="username")
    private @Nullable Output<String> username;

    /**
     * @return The name of the IAM user to associate the SSH public key with.
     * 
     */
    public Optional<Output<String>> username() {
        return Optional.ofNullable(this.username);
    }

    private SshKeyState() {}

    private SshKeyState(SshKeyState $) {
        this.encoding = $.encoding;
        this.fingerprint = $.fingerprint;
        this.publicKey = $.publicKey;
        this.sshPublicKeyId = $.sshPublicKeyId;
        this.status = $.status;
        this.username = $.username;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(SshKeyState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private SshKeyState $;

        public Builder() {
            $ = new SshKeyState();
        }

        public Builder(SshKeyState defaults) {
            $ = new SshKeyState(Objects.requireNonNull(defaults));
        }

        /**
         * @param encoding Specifies the public key encoding format to use in the response. To retrieve the public key in ssh-rsa format, use `SSH`. To retrieve the public key in PEM format, use `PEM`.
         * 
         * @return builder
         * 
         */
        public Builder encoding(@Nullable Output<String> encoding) {
            $.encoding = encoding;
            return this;
        }

        /**
         * @param encoding Specifies the public key encoding format to use in the response. To retrieve the public key in ssh-rsa format, use `SSH`. To retrieve the public key in PEM format, use `PEM`.
         * 
         * @return builder
         * 
         */
        public Builder encoding(String encoding) {
            return encoding(Output.of(encoding));
        }

        /**
         * @param fingerprint The MD5 message digest of the SSH public key.
         * 
         * @return builder
         * 
         */
        public Builder fingerprint(@Nullable Output<String> fingerprint) {
            $.fingerprint = fingerprint;
            return this;
        }

        /**
         * @param fingerprint The MD5 message digest of the SSH public key.
         * 
         * @return builder
         * 
         */
        public Builder fingerprint(String fingerprint) {
            return fingerprint(Output.of(fingerprint));
        }

        /**
         * @param publicKey The SSH public key. The public key must be encoded in ssh-rsa format or PEM format.
         * 
         * @return builder
         * 
         */
        public Builder publicKey(@Nullable Output<String> publicKey) {
            $.publicKey = publicKey;
            return this;
        }

        /**
         * @param publicKey The SSH public key. The public key must be encoded in ssh-rsa format or PEM format.
         * 
         * @return builder
         * 
         */
        public Builder publicKey(String publicKey) {
            return publicKey(Output.of(publicKey));
        }

        /**
         * @param sshPublicKeyId The unique identifier for the SSH public key.
         * 
         * @return builder
         * 
         */
        public Builder sshPublicKeyId(@Nullable Output<String> sshPublicKeyId) {
            $.sshPublicKeyId = sshPublicKeyId;
            return this;
        }

        /**
         * @param sshPublicKeyId The unique identifier for the SSH public key.
         * 
         * @return builder
         * 
         */
        public Builder sshPublicKeyId(String sshPublicKeyId) {
            return sshPublicKeyId(Output.of(sshPublicKeyId));
        }

        /**
         * @param status The status to assign to the SSH public key. Active means the key can be used for authentication with an AWS CodeCommit repository. Inactive means the key cannot be used. Default is `active`.
         * 
         * @return builder
         * 
         */
        public Builder status(@Nullable Output<String> status) {
            $.status = status;
            return this;
        }

        /**
         * @param status The status to assign to the SSH public key. Active means the key can be used for authentication with an AWS CodeCommit repository. Inactive means the key cannot be used. Default is `active`.
         * 
         * @return builder
         * 
         */
        public Builder status(String status) {
            return status(Output.of(status));
        }

        /**
         * @param username The name of the IAM user to associate the SSH public key with.
         * 
         * @return builder
         * 
         */
        public Builder username(@Nullable Output<String> username) {
            $.username = username;
            return this;
        }

        /**
         * @param username The name of the IAM user to associate the SSH public key with.
         * 
         * @return builder
         * 
         */
        public Builder username(String username) {
            return username(Output.of(username));
        }

        public SshKeyState build() {
            return $;
        }
    }

}
