# Utilisez une image OpenJDK 8
FROM openjdk:11

# Exposez le port sur lequel votre application Spring Boot écoute
EXPOSE 8082

# Copiez le fichier JAR de votre application dans l'image
ADD target/publication.jar publication.jar

# Commande pour exécuter l'application lorsque le conteneur démarre
ENTRYPOINT ["java", "-jar", "publication.jar"]