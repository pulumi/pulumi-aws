// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch.outputs;

import com.pulumi.aws.cloudwatch.outputs.MetricAlarmMetricQueryMetric;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class MetricAlarmMetricQuery {
    /**
     * @return The ID of the account where the metrics are located, if this is a cross-account alarm.
     * 
     */
    private @Nullable String accountId;
    /**
     * @return The math expression to be performed on the returned data, if this object is performing a math expression. This expression can use the id of the other metrics to refer to those metrics, and can also use the id of other expressions to use the result of those expressions. For more information about metric math expressions, see Metric Math Syntax and Functions in the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/using-metric-math.html#metric-math-syntax).
     * 
     */
    private @Nullable String expression;
    /**
     * @return A short name used to tie this object to the results in the response. If you are performing math expressions on this set of data, this name represents that data and can serve as a variable in the mathematical expression. The valid characters are letters, numbers, and underscore. The first character must be a lowercase letter.
     * 
     */
    private String id;
    /**
     * @return A human-readable label for this metric or expression. This is especially useful if this is an expression, so that you know what the value represents.
     * 
     */
    private @Nullable String label;
    /**
     * @return The metric to be returned, along with statistics, period, and units. Use this parameter only if this object is retrieving a metric and not performing a math expression on returned data.
     * 
     */
    private @Nullable MetricAlarmMetricQueryMetric metric;
    /**
     * @return Granularity in seconds of returned data points.
     * For metrics with regular resolution, valid values are any multiple of `60`.
     * For high-resolution metrics, valid values are `1`, `5`, `10`, `20`, `30`, or any multiple of `60`.
     * 
     */
    private @Nullable Integer period;
    /**
     * @return Specify exactly one `metric_query` to be `true` to use that `metric_query` result as the alarm.
     * 
     * &gt; **NOTE:**  You must specify either `metric` or `expression`. Not both.
     * 
     */
    private @Nullable Boolean returnData;

    private MetricAlarmMetricQuery() {}
    /**
     * @return The ID of the account where the metrics are located, if this is a cross-account alarm.
     * 
     */
    public Optional<String> accountId() {
        return Optional.ofNullable(this.accountId);
    }
    /**
     * @return The math expression to be performed on the returned data, if this object is performing a math expression. This expression can use the id of the other metrics to refer to those metrics, and can also use the id of other expressions to use the result of those expressions. For more information about metric math expressions, see Metric Math Syntax and Functions in the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/using-metric-math.html#metric-math-syntax).
     * 
     */
    public Optional<String> expression() {
        return Optional.ofNullable(this.expression);
    }
    /**
     * @return A short name used to tie this object to the results in the response. If you are performing math expressions on this set of data, this name represents that data and can serve as a variable in the mathematical expression. The valid characters are letters, numbers, and underscore. The first character must be a lowercase letter.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return A human-readable label for this metric or expression. This is especially useful if this is an expression, so that you know what the value represents.
     * 
     */
    public Optional<String> label() {
        return Optional.ofNullable(this.label);
    }
    /**
     * @return The metric to be returned, along with statistics, period, and units. Use this parameter only if this object is retrieving a metric and not performing a math expression on returned data.
     * 
     */
    public Optional<MetricAlarmMetricQueryMetric> metric() {
        return Optional.ofNullable(this.metric);
    }
    /**
     * @return Granularity in seconds of returned data points.
     * For metrics with regular resolution, valid values are any multiple of `60`.
     * For high-resolution metrics, valid values are `1`, `5`, `10`, `20`, `30`, or any multiple of `60`.
     * 
     */
    public Optional<Integer> period() {
        return Optional.ofNullable(this.period);
    }
    /**
     * @return Specify exactly one `metric_query` to be `true` to use that `metric_query` result as the alarm.
     * 
     * &gt; **NOTE:**  You must specify either `metric` or `expression`. Not both.
     * 
     */
    public Optional<Boolean> returnData() {
        return Optional.ofNullable(this.returnData);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(MetricAlarmMetricQuery defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String accountId;
        private @Nullable String expression;
        private String id;
        private @Nullable String label;
        private @Nullable MetricAlarmMetricQueryMetric metric;
        private @Nullable Integer period;
        private @Nullable Boolean returnData;
        public Builder() {}
        public Builder(MetricAlarmMetricQuery defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.accountId = defaults.accountId;
    	      this.expression = defaults.expression;
    	      this.id = defaults.id;
    	      this.label = defaults.label;
    	      this.metric = defaults.metric;
    	      this.period = defaults.period;
    	      this.returnData = defaults.returnData;
        }

        @CustomType.Setter
        public Builder accountId(@Nullable String accountId) {

            this.accountId = accountId;
            return this;
        }
        @CustomType.Setter
        public Builder expression(@Nullable String expression) {

            this.expression = expression;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("MetricAlarmMetricQuery", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder label(@Nullable String label) {

            this.label = label;
            return this;
        }
        @CustomType.Setter
        public Builder metric(@Nullable MetricAlarmMetricQueryMetric metric) {

            this.metric = metric;
            return this;
        }
        @CustomType.Setter
        public Builder period(@Nullable Integer period) {

            this.period = period;
            return this;
        }
        @CustomType.Setter
        public Builder returnData(@Nullable Boolean returnData) {

            this.returnData = returnData;
            return this;
        }
        public MetricAlarmMetricQuery build() {
            final var _resultValue = new MetricAlarmMetricQuery();
            _resultValue.accountId = accountId;
            _resultValue.expression = expression;
            _resultValue.id = id;
            _resultValue.label = label;
            _resultValue.metric = metric;
            _resultValue.period = period;
            _resultValue.returnData = returnData;
            return _resultValue;
        }
    }
}
