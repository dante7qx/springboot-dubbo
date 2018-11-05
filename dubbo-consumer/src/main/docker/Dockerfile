FROM java:8
LABEL auther ch.sun <ch.sun@haihangyun.com>

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENV APPS_HOME=/AppServer
RUN mkdir -p $APPS_HOME/
WORKDIR $APPS_HOME/
ADD dubbo-consumer-0.0.1-SNAPSHOT.jar $APPS_HOME/app.jar
    
RUN sh -c 'touch $APPS_HOME/app.jar'

ENV JAVA_OPTS="-Xms1024m -Xmx1024m"

EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar $APPS_HOME/app.jar" ]