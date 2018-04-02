# GraphQL vs Traditional REST API with MongoDB - Conference talk demo

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
java -jar target/graphql-vs-rest-0.0.3-SNAPSHOT.jar
```

If you want to also initalize some init data run with additiaonal paramater

```
java -jar target/graphql-vs-rest-0.0.3-SNAPSHOT.jar initdata

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

## GraphQL End point


### GraphQL schema


Check full GraphQl schema here

- https://github.com/vladimir-dejanovic/graphql-vs-traditional-rest-api-conftalk_demo/blob/master/src/main/resources/schema.graphqls


### Test with GraphiQL

Once application is up and running, hit [http://localhost:8080/](http://localhost:8080/) with browser and you will get GraphiQL UI.
Here you can enter queries and get back response


### Basic query
Run this query

```
query {  
  allPosts {
    id
    title
    body
  }
}
```

Response should be something like this 

```
{
  "data": {
    "allPosts": [
      {
        "id": "321",
        "title": "Who is Radial Edward",
        "body": "Edward Wong Hau Pepelu Tivrusky IV (エドワード・ウォン・ハウ・ペペル・チブルスキー4世 Edowādo Won Hau Peperu Chiburusukī 4-sei?), commonly called Ed, colloquially known as Radical Edward and born on January 1, 2058 as Françoise Appledelhi, is a child prodigy skilled in hacking originally from Earth. She is a comically-eccentric teenager around 13 years of age."
      },
      {
        "id": "543",
        "title": "Who is Son Goku",
        "body": "Son Goku (孫悟空 Son Gokū), born Kakarot (カカロット Kakarotto), is a male Saiyan and the main protagonist of the Dragon Ball meta-series created by Akira Toriyama. Cheerful, tenacious, and also a bit naïve, Goku is a Saiyan originally sent to Earth as an infant with the mission to destroy it. However, an accident alters his memory, causing him to grow up pure-hearted and later become Earth's greatest defender, as well as the informal leader of the Dragon Team. Throughout his life, he trains hard and constantly strives to be the greatest warrior possible and to fight stronger opponents, which has kept the Earth and the Universe safe from destruction many times"
      }
    ]
  }
}
```

### Query filtering fields in response

Great thing about GraphQL is that you can select which fields should be present in response

run this query 

```
query {  
  allPosts {
    id
    title
  }
}
```

and response should be like this 

```
{
  "data": {
    "allPosts": [
      {
        "id": "321",
        "title": "Who is Radial Edward"
      },
      {
        "id": "543",
        "title": "Who is Son Goku"
      }
    ]
  }
}
``` 

### Get Author data in response

Since now Author is part of Post in schema, we can request this info in our query

```
query {  
  allPosts {
   title
   createdBy {
    name
  } 
  }
}
```

should produce this response

```
{
  "data": {
    "allPosts": [
      {
        "title": "Who is Radial Edward",
        "createdBy": {
          "name": "Ed Wong IV"
        }
      },
      {
        "title": "Who is Son Goku",
        "createdBy": {
          "name": "Son Goku"
        }
      }
    ]
  }
}
```


## TAGS

### rest-0.1

REST points done
- [https://github.com/vladimir-dejanovic/graphql-vs-traditional-rest-api-conftalk_demo/releases/tag/rest-0.1](https://github.com/vladimir-dejanovic/graphql-vs-traditional-rest-api-conftalk_demo/releases/tag/rest-0.1)

### graphql-0.1

GraphQL end point with init GraphQL schema
- [https://github.com/vladimir-dejanovic/graphql-vs-traditional-rest-api-conftalk_demo/releases/tag/graphql-0.1](https://github.com/vladimir-dejanovic/graphql-vs-traditional-rest-api-conftalk_demo/releases/tag/graphql-0.1)
