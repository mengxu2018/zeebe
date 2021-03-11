package io.zeebe;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.response.DeploymentEvent;

public class DeployTest
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

        final DeploymentEvent deployment = client.newDeployCommand()
            .addResourceFromClasspath("order-process.bpmn")
            .send()
            .join();

        final int version = deployment.getWorkflows().get(0).getVersion();
        System.out.println("Workflow deployed. Version: " + version);

        client.close();
        System.out.println("Closed.");
        // ...
    }
}