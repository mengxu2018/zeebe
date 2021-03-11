package io.zeebe;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.ZeebeFuture;
import io.zeebe.client.api.response.WorkflowInstanceEvent;
import io.zeebe.client.api.worker.JobWorker;

import java.util.HashMap;
import java.util.Map;

public class JobWorker1Test {
    public static void main(final String[] args) {
        // after the client is connected
        final String gatewayAddress = "192.168.159.140:26500";
        System.out.println(System.getenv("ZEEBE_INSECURE_CONNECTION"));
        final ZeebeClient client =
                ZeebeClient.newClientBuilder()
                        .gatewayAddress(gatewayAddress)
                        .build();

        System.out.println("Connected");



        // Create a polling job worker which will call the given handler for every job.
//        https://forum.zeebe.io/t/zeebe-job-type-and-execution-concern/1281/2
        JobWorker worker = client
                .newWorker()
                .jobType("initiate-payment")
                .handler((jobClient, job) ->
                {
//                    throw new Exception("")
                    // business logic code
                    System.out.println("job" + job.getVariables());
                    ZeebeFuture future = jobClient.newCompleteCommand(job.getKey())
                            .send();
//                            .join();
                    future.join();
                    System.out.println("work1 handler finished");
                    System.out.println("future.isDone()=" + future.isDone());
//                    jobClient.newCompleteCommand();
                })
                .open();

        System.out.println("JobWorker1Test finished");

//        worker.close();


//        client.close();
//        System.out.println("Closed.");
        // ...
    }
}