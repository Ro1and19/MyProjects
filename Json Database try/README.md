# JSON Database with Java

## Description

Develop a Java-based client-server application that enables you to store data on the server in JSON format. Practice parallelization for processing multiple requests to enhance your career prospects.

## Example

The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

### Starting the server:

```java
> java Main
Server started!
```

### Starting the clients:

```java
> java Main -t set -k text -v "Hello World!"
Client started!
Sent: {"type":"set","key":"text","value":"Hello World!"}
Received: {"response":"OK"}

> java Main -in setFile.json 
Client started!
Sent:
{
   "type":"set",
   "key":"person",
   "value":{
      "name":"Elon Musk",
      "car":{
         "model":"Tesla Roadster",
         "year":"2018"
      },
      "rocket":{
         "name":"Falcon 9",
         "launches":"87"
      }
   }
}
Received: {"response":"OK"}

> java Main -in getFile.json 
Client started!
Sent: {"type":"get","key":["person","name"]}
Received: {"response":"OK","value":"Elon Musk"}

> java Main -in updateFile.json 
Client started!
Sent: {"type":"set","key":["person","rocket","launches"],"value":"88"}
Received: {"response":"OK"}

> java Main -in secondGetFile.json 
Client started!
Sent: {"type":"get","key":["person"]}
Received:
{
   "response":"OK",
   "value":{
      "name":"Elon Musk",
      "car":{
         "model":"Tesla Roadster",
         "year":"2018"
      },
      "rocket":{
         "name":"Falcon 9",
         "launches":"88"
      }
   }
}

> java Main -in deleteFile.json 
Client started!
Sent: {"type":"delete","key":["person","car","year"]}
Received: {"response":"OK"}

> java Main -in secondGetFile.json 
Client started!
Sent: {"type":"get","key":["person"]}
Received:
{
   "response":"OK",
   "value":{
      "name":"Elon Musk",
      "car":{
         "model":"Tesla Roadster"
      },
      "rocket":{
         "name":"Falcon 9",
         "launches":"88"
      }
   }
}

> java Main -t exit 
Client started!
Sent: {"type":"exit"}
Received: {"response":"OK"}
```
