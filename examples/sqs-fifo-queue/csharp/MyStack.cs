using Pulumi;
using Pulumi.Aws.Sqs;

class MyStack : Stack
{
    public MyStack()
    {
        var queue = new Queue("demo", new QueueArgs
        {
            FifoQueue = true,
        });

        // Export the name of the queue to allow us to check for ".fifo" name
        this.QueueName = queue.Name;
    }

    [Output]
    public Output<string> QueueName { get; set; }
}
