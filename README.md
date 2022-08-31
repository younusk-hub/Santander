# Santander

Welcome to my Santander tech test.

In this project I have made a working API using SpringBoot, I have a repository class, service class and a controller class. The repository is where the prices and most of the functionality is being stored. The service class implements the interface that was created so that we can receive messages and use them in the repository. The controller is the logic to create the endpoints, I made a Get Method to get the specific instrument you want by adding the instrument name to the URL, for example: "http://localhost:8080/EUR/JPY" will get the latest price stored for EUR/JPY. Also, I have a post method so that I can receive a message and store it if it's the latest price for that specific instrument. For example: By adding this to the body "{ "newPrice": "110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:999" }", we will get a message saying it's been added. Finally, we have a Price class where we create the price objects with the relevant information needed, and have 2 commission methods for Ask and Bid.

My assumptions:

- Firstly, I only receive one lined message at a time, i.e "110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:999". I would like to work on taking in multiple lines as one message in the future.
- I created a PriceInit class where we populate the given prices and store them in the repository to start with so that I had something to work with.
- Lastly, I assumed that the program will receive the latest messages only.

I only tested the methods that were most relevant and created simple tests. I tested Repository to see if it correctly stores, updates and adds the right prices. Tested Service to see if the message will convert into a Price object which we can then use and store. Finally, I tested the Price class to see if they correctly add commission to the Ask and Bid.
