# Utilisez une image OpenJDK 8
FROM openjdk:8

# Exposez le port sur lequel votre application Spring Boot écoute
EXPOSE 8761

# Copiez le fichier JAR de votre application dans l'image
ADD target/EurekaServer-0.0.1-SNAPSHOT.jar eureka.jar

# Commande pour exécuter l'application lorsque le conteneur démarre
ENTRYPOINT ["java", "-jar", "/eureka.jar"]