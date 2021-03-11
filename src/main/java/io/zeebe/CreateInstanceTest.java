package io.zeebe;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.response.DeploymentEvent;
import io.zeebe.client.api.response.WorkflowInstanceEvent;

import java.util.HashMap;
import java.util.Map;

public class CreateInstanceTest
{
    public static void main(final String[] args)
    {
        // after the client is connected
        final String gatewayAddress = "192.168.159.147:27500";
        System.out.println(System.getenv("ZEEBE_INSECURE_CONNECTION"));
        final ZeebeClient client =
                ZeebeClient.newClientBuilder()
                        .gatewayAddress(gatewayAddress)
                        .build();

        System.out.println("Connected");

//        final DeploymentEvent deployment = client.newDeployCommand()
//            .addResourceFromClasspath("order-process.bpmn")
//            .send()
//            .join();
//
//        final int version = deployment.getWorkflows().get(0).getVersion();
//        System.out.println("Workflow deployed. Version: " + version);
        final Map<String, Object> data = new HashMap<>();
        data.put("orderId", 323);
        data.put("orderValue", 412);

        final WorkflowInstanceEvent wfInstance = client.newCreateInstanceCommand()
                .bpmnProcessId("order-process3")
                .latestVersion()
                .variables(data)
                .send()
                .join();

        final long workflowInstanceKey = wfInstance.getWorkflowInstanceKey();

        System.out.println("Workflow instance created. Key: " + workflowInstanceKey);
        client.close();
        System.out.println("Closed.");
        // ...
    }
}