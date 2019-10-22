# Java Test Task

### Pre Requirment
- Apache Tomcat
- Intellij
- JDK 11

### Steps
> git clone https://github.com/SoumenITMO/Java-Test-Task-Weather.git
- Import cloned project as maven project
- Change configuration from "Run/Debug Configuration ". Where it will be needed to locate tomcat home and locate war file
  to deploy
  
### After successful deployment according setup configuration navigate url to browser

### To get weather service example URL given below it may vary according to configuration.
````
GET Method
````
- http://localhost:8081/home/weather?citycode=Bishop

### Few Citycodes given below for testing purpose 
- Bishop
- Jilib
- Eyl
- Kahriz
- Cadale
- Dahasuways
- Hobyo
- Njombe
- Xilli

### To get Timezone according zip code service example URL given below it may vary according to configuration.
````
POST Method
````
- http://localhost:8081/home/tzone?zipcode=10123
