## RabbitMQ

    docker run -d --hostname my-rabbit --name rabbitmq -p 15672:15672 -p 5672:5672 -e RABBITMQ_DEFAULT_USER=user -e  RABBITMQ_DEFAULT_PASS=user rabbitmq:3-management

## Docker Image oluşturma aşamaları
    ÖRN:
    docker build --build-arg 
    JAR_FILE=ConfigServerGit/build/libs/ConfigServerGit-v.0.1.jar -t  
    javaboost2/configservergit:01 .

    - docker build --build-arg  JAR_FILE=ConfigServerGit/build/libs/ConfigServerGit-v.0.1.jar -t  javaboost2/configservergit:01 .

    - docker build --build-arg  JAR_FILE=AuthMicroService/build/libs/AuthMicroService-v.0.1.jar -t  javaboost2/java5authservice:01 .
    