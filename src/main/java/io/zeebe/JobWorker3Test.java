package io.zeebe;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.worker.JobWorker;

public class JobWorker3Test {
    public static void main(final String[] args) {
        // after the client is connected
        final String gatewayAddress = "192.168.159.140:26500";
        System.out.println(System.getenv("ZEEBE_INSECURE_CONNECTION"));
        final ZeebeClient client =
                ZeebeClient.newClientBuilder()
                        .gatewayAddress(gatewayAddress)
                        .build();

        System.out.println("Connected");




        JobWorker worker = client
                .newWorker()
                .jobType("ship-with-insurance")
                .handler((jobClient, job) ->
                {
                    // business logic code
                    System.out.println("---------------------------------start--------------");
                    System.out.println(job.getVariables());
                    System.out.println(job.getWorkflowInstanceKey());
                    jobClient.newCompleteCommand(job.getKey())
                            .send()
                            .join();
                    System.out.println("handler finished");
                    System.out.println("---------------------------------end--------------");
                })
                .open();
        System.out.println("JobWorker1Test3 finished");

//        worker.close();


//        client.close();
//        System.out.println("Closed.");
        // ...
    }
}