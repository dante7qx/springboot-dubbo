FROM dante2012/java:centos-oraclejre-1.8.0_212

LABEL MAINTAINER="sunchao.zh <dante@dante7qx@126.com>"

ENV JAVA_OPTS="-Xms512m -Xmx512m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m"

ARG apUser=spirit
ARG userHome=/home/spirit
ARG logHome=/home/ap/logs

RUN set -eux; \
    groupadd -r ${apUser} --gid=1000; \
    useradd -r -g ${apUser} --uid=1000 ${apUser}; \
    mkdir -p ${logHome} ${userHome}; \
	chown -R ${apUser}:${apUser} ${logHome} ${userHome}

COPY dubbo-provider-0.0.1-SNAPSHOT.jar /app.jar

USER ${apUser}

EXPOSE 8080

VOLUME ["${logHome}"]

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]