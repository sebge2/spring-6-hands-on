# Testing New Version of Spring 6 and Boot 3

Launch build:

````
mvn -Pnative spring-boot:build-image
docker run --rm -p 8090:8080 'docker.io/sebge2/spring-boot-6-hands-on:latest'
````

Links:
* [Native Spring Boot (in French)](https://www.infoq.com/fr/articles/native-java-spring-boot/)
* [Video from Josh Long](https://www.youtube.com/watch?v=2Wnp6FdrTbI&t=533s)
* [Spring Native Doc](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/)
* [Demo App](https://github.com/snicoll/demo-aot-native)