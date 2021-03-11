package io.zeebe;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.response.PublishMessageResponse;
import io.zeebe.client.api.response.WorkflowInstanceEvent;

import java.util.HashMap;
import java.util.Map;

public class PublishMessage2Test
{
    public static void main(final String[] args)
    {
        // after the client is connected
        final String gatewayAddress = "192.168.159.140:26500";
        System.out.println(System.getenv("ZEEBE_INSECURE_CONNECTION"));
        final ZeebeClient client =
                ZeebeClient.newClientBuilder()
                        .gatewayAddress(gatewayAddress)
                        .build();

        System.out.println("Connected");

        PublishMessageResponse t = client.newPublishMessageCommand().messageName("payment-received").correlationKey("323").send().join();
        System.out.println(t.getMessageKey());

        System.out.println("PublishMessage2Test finished");


//
    }
}