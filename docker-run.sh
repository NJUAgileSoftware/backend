exit
docker build -t com.bolingcavalry.mavendockerplugindemo /jenkinshome/workspace/AgileSoftware
docker run com.bolingcavalry.mavendockerplugindemo -p 8080:8080