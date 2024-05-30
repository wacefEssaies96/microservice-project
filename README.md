# microservice-project
# Micro-Services-Social Media 
### Getting Started with Micro Service Architecture :
In this application we have a total of 9 microServices :
| MicroService | Description |
| ------------ | ----------- |
| Api-Gateway  | API management tool that sits between a client and a collection of backend services|
| Eureka-Server-MS | This micro service is Our discovery Server  |
| Groupe-management-MS | This micro service is designed to manage groups |
| Chat-Server-MS | This microservice is a chat micro service |
| page-Server-MS | This micro service is designed to manage page on a social media | 
| publication-Server-MS | This micro service is designed to manage all publications |
| commentaire-Server-MS | This micro service is designed to send and manage comments on social media | 
| Event-Server-MS | This micro service is designed to manage all events on the social media| 

### MSs & their PORTS
| MicroService | local PORT |
| ------------ | ----------- |
| Api-Gateway | 8081 |
| Eureka-Server | 8761 |
| Groupe-MS | 8087  |
| page-Server-MS | 8083 |
| commentaire-MS | 8089 |
| Event-Server-MS | 8091 |
| publication-Server-MS | 8085 |

### how to run this application :
1- download the code of this repo 
2- install all the dependencies 
3- run `maven clean install` to all the micro services 
4- go to the root folder then run `docker compose up`
