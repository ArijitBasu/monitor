#MONITOR

Monitor is an API server built using spring and hibernate which monitors the temperatures from different sensors.
It serves the following functions:
1. Saves temperatures from different sensors in its database.

`curl -X POST -H 'Content-Type: application/json' -d '{"sensor": "sensor1", "temperature": 27, "ts": 1576358360}' 'http://localhost:7000/v1/register'`

2. Returns min, max and average between 2 timestamps.

`curl -X GET 'http://localhost:7000/v1/<agg>?startTs=0&endTs=15763583600' `

The service is backed by MySQL which is in no ways the right database for the job. We need to replace the database by a time series database like influxDB or use a new SQL.
Also, we are being flexible here by computing the min, max and avg on the runtime which is not sustainable when dealing with large amounts of data which is the case with monitoring systems.

We should be creating pre aggregates and should be serving the data from the same.

Another important point is that http is not the right protocol for a monitoring service.

###DATABASE SCHEMA
CREATE TABLE `temperature` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `temperature` double NOT NULL,
  `ts` bigint(20) NOT NULL,
  `sensor` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
 
 