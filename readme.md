./bin/zbctl --insecure deploy order-process2.bpmn

./bin/zbctl --insecure create instance order-process2 --variables '{"orderId": "123456", "orderValue":33}'

./bin/zbctl --insecure create worker initiate-payment --handler cat

./bin/zbctl --insecure publish message "payment-received" --correlationKey="12345"

./bin/zbctl --insecure create worker ship-without-insurance --handler cat




https://avro.apache.org/docs/current/gettingstartedjava.html#download_install
cd F:\workspace\zeebe-workspace\zeebe-test\src\main\resources
java -jar F:\workspace\zeebe-workspace\zeebe-test\lib\avro-tools-1.10.1.jar compile schema user.avsc .
# zeebe
