## Source code for Beer Locker tutorials

#### beerlocker-1

With an ever growing collection of beer, the department is in dire need of a way to store and track the beer.
What better way to do this than to create an application where we can add, remove, update, and view the beer collection.
Like any motivated developer, we want our friends to be able to create their own lockers and also, to control who has access to ours.

In this multipart series we’ll be creating a RESTful API using `Node`, `Express`, `Mongoose` to interact with `MongoDB`,
`Passport` for authentication, `OAuth2orize` for OAuth support, and explore best practices and tools.

When we are done, we should have an API that allows users to

+ authenticate,
+ perform CRUD operations,
+ authorise other applications via OAuth to access the API,
+ have a solid understanding of best practices and tooling, and
+ most important of all, a place to store the beer!

#### beerlocker-2

In our previous version we left off with a basic `Node` application in place capable of accepting `HTTP` requests and responding back with some static `JSON`.

In this part we will dive a bit deeper and learn how to implement CRUD operations on our beer locker.
By the end of this version you will have learned how to connect to a `MongoDB` database,
used Mongoose for object modelling, and have implemented `GET`, `PUT`, `POST`, and `DELETE` endpoints.

#### beerlocker-3.1

The starting code which will utilise `Passport`.
Also, we clean up the code a bit from our previous versions.

#### beerlocker-3.2

In our previous version we ended with a fairly functional API capable of adding, removing, updating, and viewing beer.

In this part we will dive into creating user accounts and authentication using `Passport`.
By the end of this version we will have learned how to add user accounts, implement authentication, and control access to beer lockers.

### beerlocker-4

In our previous version we ended with a functional API capable of creating user accounts, locking down API endpoints, and only allowing access to a user’s own beer locker.

In this version we will dive into creating an `OAuth2` server and allowing access to API endpoints for the authorised user or authorised applications.
We will do this by integrating `OAuth2orize` into our application.

### beerlocker-5

In our previous version we ended with a functional API capable of creating user accounts,
locking down API endpoints, only allowing access to a user's own beer locker, and an `OAuth2` server.

This version considers questions about how to use different authentication strategies,
exploring the use of *Digest authentication* instead of *Basic* authentication.

####beerlocker-6.1

The starting code for the sixth version which uses username and password for authentication.

####beerlocker-6.2

The final version of our `beerlocker` application.

## Credits

This tutorial is based upon a series of articles by  Scott Smith,
[Beer Locker: Building a RESTful API With Node](http://scottksmith.com/blog/2014/05/02/building-restful-apis-with-node/)
