# graphql-vs-traditional-rest-api-conftalk_demo

This is demo code for my conference talk GraphQL vs Traditional REST API. I had two repos which are combined and improved in this one
- [https://github.com/vladimir-dejanovic/simple-springboot-rest-mongo-conftalk-demo](https://github.com/vladimir-dejanovic/simple-springboot-rest-mongo-conftalk-demo)
- [https://github.com/vladimir-dejanovic/simple-springboot-graphql-mongo-conftalk-demo](https://github.com/vladimir-dejanovic/simple-springboot-graphql-mongo-conftalk-demo)

## How to start project

You can build java code and start it as stand alone app. In this case you need to provide MongoDB instance. Other way is to use docker-compose to start all needed dependencies as docker containers.

To build code just run 

```
mvn clean package
```

to build code and created docker image run 

```
mvn clean install
```


### Stand alone Java applicatoin 


```
java -jar target/graphql-vs-rest-0.0.2-SNAPSHOT.jar
```

If you want to also initalize some init data run with additiaonal paramater

```
java -jar target/graphql-vs-rest-0.0.2-SNAPSHOT.jar initdata

```

### Using Docker compose

After you build code and docker image is created just run this command

``` bash
docker-compose up
```

This will start two docker images. One with MongoDB database, other with Java application 


## REST End points

There are multipel REST end points that are exposed

### Authours end point
- [http://localhost:8080/authors](http://localhost:8080/authors)

to retrive all authours run this command
```
curl http://localhost:8080/authors
```

to retrieve info about specific author run this command

```
curl http://localhost:8080/authors/<author id>
```

### Posts end point
- [http://localhost:8080/posts](http://localhost:8080/posts)

to retrive all posts run this command

```
curl http://localhost:8080/posts
```

To retrieve all post from specific author run this command

```
curl http://localhost:8080/posts?author_id=<author id>
```

### Comments end point
- [http://localhost:8080/comments](http://localhost:8080/comments)

to retrive all comments run this command

```
curl http://localhost:8080/comments
```

To retrieve comments for specific port run this command

```
curl http://localhost:8080/comments?post_id=<post id>
```