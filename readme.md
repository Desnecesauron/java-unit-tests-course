

Use this command to run the docker with mysql in container

```
docker run -d -p 3306:3306 --name mysql-docker-container -e MYSQL_ROOT_PASSWORD=admin123 -e MYSQL_DATABASE=rest_with_spring_boot -e MYSQL_USER=root -e MYSQL_PASSWORD=admin123 mysql/mysql-server:latest
```