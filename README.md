# spring-kafka

A proof of concept that shows that you can create other services (consumers) that listens to messages sent by the rest server (producer) that goes through kafka.

To run this project:

1. clone this repo
2. use `docker compose up`

You can send a message using the endpoint:
    `localhost:5050/send-message` with json containing:

    ```
    {
        "message": "your message here"
    }
    ```