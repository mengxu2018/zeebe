package io.zeebe;

import io.zeebe.client.ZeebeClient;

public class ConnectTest
{
    public static void main(final String[] args)
    {
        final String gatewayAddress = "192.168.159.140";

        final ZeebeClient client =
            ZeebeClient.newClientBuilder()
                .gatewayAddress(gatewayAddress)
                .build();
        System.out.println(client.getConfiguration());

        System.out.println("Connected");


        client.close();
        System.out.println("Closed.");
    }
}