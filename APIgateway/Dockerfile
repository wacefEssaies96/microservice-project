# Utilisez une image OpenJDK 8
FROM openjdk:8

# Exposez le port sur lequel votre application Spring Boot écoute
EXPOSE 8181

# Copiez le fichier JAR de votre application dans l'image
ADD target/APIgateway-0.0.1-SNAPSHOT.jar gateway.jar

# Commande pour exécuter l'application lorsque le conteneur démarre
ENTRYPOINT ["java", "-jar", "/gateway.jar"]