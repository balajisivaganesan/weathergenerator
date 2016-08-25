# weathergenerator
This is a weather simulator module which creates weather measurements across various locations and times.

It creates the weather simulation with the follwowing details

1) Location (Name of the location)

2) Lat, Long, Elevation

3) Local Time in ISO8601 format

4) Weather conditions like snow,rainy etc

5) Temperature in C

6) Pressure in hPa

7) Relative humidity in %

The values created are just a simulation and is not meteorologically accurate. The simulator keeps on emitting the data.


Installtion Steps


Just clone the maven repository. Then within the folder execute:

mvn package appassembler:assemble

Once the build is complete, in the target/appassembler/bin folder, there is an executable called "weathersim.bat". Just run this in cmd prompt and the weather data gets simulated. The output is also written in a file which is in the same folder and that is called "weatheroutput.txt"



Currently the size of the loop is 10. If this needs to be changed, update the constants Constants.LOOP_LIMIT to required values


The output snapshot is given below

Melbourne|-37.82,144.95,9|2016-08-05T01:21:25Z|Rain|+16.3|1009.4|91

Sydney|-33.87,151.21,19|2016-09-11T17:54:50Z|Clear|+23.5|1022.5|66

Canberra|-35.34,149.08,589|2016-08-29T22:53:13Z|Snow|-5.5|990.7|50

Perth|-31.95,115.86,15|2016-08-09T11:05:16Z|Cloudy|+19.1|1019.9|75

Darwin|-12.39,130.85,16|2016-09-03T03:05:44Z|Sunny|+33.1|1117.4|14

Cairns|-16.92,145.77,4|2016-08-19T14:32:18Z|Snow|-5.7|987.8|57

Townsville|-19.27,146.81,15|2016-09-13T14:49:16Z|Cloudy|+18.0|1011.9|72

Brisbane|-27.47,153.02,28|2016-09-04T20:58:39Z|Sunny|+35.1|1119.3|22

Adelaide|-34.93,138.59,59|2016-09-04T00:55:30Z|Sunny|+47.1|1119.1|27

New Castle|-32.93,151.78,21|2016-09-14T21:30:09Z|Clear|+23.1|1023.3|63

Hobart|-42.83,147.50,6|2016-09-11T11:25:19Z|Cloudy|+16.5|1018.4|76
