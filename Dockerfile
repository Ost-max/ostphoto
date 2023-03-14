FROM tomcat:9.0-alpine

LABEL maintainer="ost-max@ya.ru"

ADD target/OstPhoto-0.0.1.war /usr/local/tomcat/webapps/
COPY tomcat-users.xml /usr/local/tomcat/conf/

EXPOSE 8080

CMD ["catalina.sh", "run"]