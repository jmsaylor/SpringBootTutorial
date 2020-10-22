package com.johnmsaylor.amigos.dao;

import com.johnmsaylor.amigos.model.Dog;
import com.johnmsaylor.amigos.vault.Vault;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("mongoDog")
public class MongoDbDogAccessService implements DogDao {
    ConnectionString connectionString = new ConnectionString(Vault.getMongoConnectionString());
    MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
    MongoClient mongoClient = MongoClients.create(settings);

    MongoDatabase mongoDatabase = mongoClient.getDatabase("Spring");
    MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("Dogs");

    @Override
    public int insertDog(Dog dog) {
        try {
            var doc = new Document("name", dog.getName())
                    .append("age", dog.getAge())
                    .append("favoriteThings", dog.getFavoriteThings());
            mongoCollection.insertOne(doc);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return 0;
        }
    }

    @Override
    public List<Dog> getAllDogs() {
        List dogList = new ArrayList<>();
        return mongoCollection.find().into(dogList);
    }

    @Override
    public Optional<Dog> getSpecificDog(String name) {
        Document dogMaybe = mongoCollection.find(Filters.eq("name", name)).first();

        return Optional.of(new Dog(dogMaybe.getString("name"), dogMaybe.getInteger("age"), dogMaybe.getString("favoriteThings"))).orElse(null);
    }

    @Override
    public int deleteDog(String name) {
        return 0;
    }

    @Override
    public int changeDogName(String name, String newName) {
        return 0;
    }
}
