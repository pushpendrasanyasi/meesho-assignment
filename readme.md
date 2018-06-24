# Project for creating micro services for mail.
## Technologies Used
1. Java - 1.8
2. Jersey - Rest
3. Kafka
4. Gson

## Code Structure
Code is divided into two projects
##### 1. Meesho Mail Service

Main Controller class handles the incoming rest requests for sending the email notification and forwards the request to the Mail service which internally validates and understand the mail request.
It checks for the existence of mail attachment and if it is available, then uses the template with the mail attachment else sends the mail without any attachment, using the different template.


##### 2. Meesho Worker

Simple consumer for the notification request producer. It then redirecties the requets to the mail server which handles the further operation. It only commits the Kafka message, if it sends the success acknowledgement from service.

Some methods are stubbed as required based on general assumption for the mail service and worker.

### How do I get set up? 
```
Import this project in your eclipse or other IDE.
```
### Architecture Diagram used as discussed during F2F discussion
![arch diagram](https://image.ibb.co/dSUkX8/arch.jpg)
