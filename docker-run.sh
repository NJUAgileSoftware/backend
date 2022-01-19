echo "退出docker"
exit
echo "开始构建镜像"
docker build -t com.bolingcavalry.mavendockerplugindemo /jenkinshome/workspace/AgileSoftware
echo "构建结束，开始运行"
docker run com.bolingcavalry.mavendockerplugindemo -p 8080:8080
echo "运行成功"