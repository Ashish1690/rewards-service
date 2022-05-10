#How to run app locally?
mvn spring-boot:run

#How to Test rewards endpoint?
curl -X POST \
http://localhost:8080/rewards-service/reward/points \
-H 'accept: application/json' \
-H 'cache-control: no-cache' \
-H 'content-type: application/json' \
-d '{
"transactionAmount" : 120
}'

#Unit test
All possible scenarios has been tested
