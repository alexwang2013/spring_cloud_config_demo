# spring_cloud_config_demo

* start config server

* start config client

* check the current property
curl http://localhost:8080/whoami/alex

* check the current config
http://localhost:8888/config-client/development/master

* change properties

   * change properties in alexrepo/config-client-development.properties
   * commit new change to alexrepo.

* refresh config server
curl -X POST http://localhost:8888/actuator/refresh

* refresh config client
curl -X POST http://localhost:8080/actuator/refresh

* check the new changed property
curl http://localhost:8080/whoami/alex

# TODO auto refresh config client
* rabbitmq
* spring cloud bus
