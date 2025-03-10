// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kendra.inputs;

import com.pulumi.aws.kendra.inputs.IndexIndexStatisticFaqStatisticArgs;
import com.pulumi.aws.kendra.inputs.IndexIndexStatisticTextDocumentStatisticArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class IndexIndexStatisticArgs extends com.pulumi.resources.ResourceArgs {

    public static final IndexIndexStatisticArgs Empty = new IndexIndexStatisticArgs();

    /**
     * A block that specifies the number of question and answer topics in the index. Detailed below.
     * 
     */
    @Import(name="faqStatistics")
    private @Nullable Output<List<IndexIndexStatisticFaqStatisticArgs>> faqStatistics;

    /**
     * @return A block that specifies the number of question and answer topics in the index. Detailed below.
     * 
     */
    public Optional<Output<List<IndexIndexStatisticFaqStatisticArgs>>> faqStatistics() {
        return Optional.ofNullable(this.faqStatistics);
    }

    /**
     * A block that specifies the number of text documents indexed. Detailed below.
     * 
     */
    @Import(name="textDocumentStatistics")
    private @Nullable Output<List<IndexIndexStatisticTextDocumentStatisticArgs>> textDocumentStatistics;

    /**
     * @return A block that specifies the number of text documents indexed. Detailed below.
     * 
     */
    public Optional<Output<List<IndexIndexStatisticTextDocumentStatisticArgs>>> textDocumentStatistics() {
        return Optional.ofNullable(this.textDocumentStatistics);
    }

    private IndexIndexStatisticArgs() {}

    private IndexIndexStatisticArgs(IndexIndexStatisticArgs $) {
        this.faqStatistics = $.faqStatistics;
        this.textDocumentStatistics = $.textDocumentStatistics;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(IndexIndexStatisticArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private IndexIndexStatisticArgs $;

        public Builder() {
            $ = new IndexIndexStatisticArgs();
        }

        public Builder(IndexIndexStatisticArgs defaults) {
            $ = new IndexIndexStatisticArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param faqStatistics A block that specifies the number of question and answer topics in the index. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder faqStatistics(@Nullable Output<List<IndexIndexStatisticFaqStatisticArgs>> faqStatistics) {
            $.faqStatistics = faqStatistics;
            return this;
        }

        /**
         * @param faqStatistics A block that specifies the number of question and answer topics in the index. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder faqStatistics(List<IndexIndexStatisticFaqStatisticArgs> faqStatistics) {
            return faqStatistics(Output.of(faqStatistics));
        }

        /**
         * @param faqStatistics A block that specifies the number of question and answer topics in the index. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder faqStatistics(IndexIndexStatisticFaqStatisticArgs... faqStatistics) {
            return faqStatistics(List.of(faqStatistics));
        }

        /**
         * @param textDocumentStatistics A block that specifies the number of text documents indexed. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder textDocumentStatistics(@Nullable Output<List<IndexIndexStatisticTextDocumentStatisticArgs>> textDocumentStatistics) {
            $.textDocumentStatistics = textDocumentStatistics;
            return this;
        }

        /**
         * @param textDocumentStatistics A block that specifies the number of text documents indexed. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder textDocumentStatistics(List<IndexIndexStatisticTextDocumentStatisticArgs> textDocumentStatistics) {
            return textDocumentStatistics(Output.of(textDocumentStatistics));
        }

        /**
         * @param textDocumentStatistics A block that specifies the number of text documents indexed. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder textDocumentStatistics(IndexIndexStatisticTextDocumentStatisticArgs... textDocumentStatistics) {
            return textDocumentStatistics(List.of(textDocumentStatistics));
        }

        public IndexIndexStatisticArgs build() {
            return $;
        }
    }

}
