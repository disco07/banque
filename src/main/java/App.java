import com.mongodb.client.*;
import modele.*;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.model.Filters;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class App {

    public static void main(String[] args) {

        ConnectionString connectionString = new ConnectionString(
                "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&ssl=false");
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
                .codecRegistry(codecRegistry).build();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {

            MongoDatabase database = mongoClient.getDatabase("banque");
            MongoCollection<Person> persons = database.getCollection("person", Person.class);

            persons.deleteMany(new Document());

            Person drissa = new Person().setName("Kone").setSurname("Drissa").setAge(29).setAddress(
                    new Address().setNum_rue(1).setRue("Charles Geniaux").setCode_postale("35000").setVille("Rennes"));

            Person yacou = new Person().setName("Kone").setSurname("Yacouba").setAge(31).setAddress(
                    new Address().setNum_rue(1).setRue("Charles Geniaux").setCode_postale("35000").setVille("Paris"));

            Person yaya = new Person().setName("Kone").setSurname("Yaya").setAge(27).setAddress(
                    new Address().setNum_rue(1).setRue("Charles Geniaux").setCode_postale("35000").setVille("Paris"));

            Compte compte = new Compte();
            compte.deposerArgent(200);
            compte.retirerArgent(50);
            compte.setNum_compte(new CreateRib().setNumero_compte(new CreateRib().generate()));

            persons.insertOne(drissa);
            persons.insertOne(yacou);
            persons.insertOne(yaya);


            List<Person> people = persons.find().into(new ArrayList<>());
            people.forEach(System.out::println);

            drissa.setCompte(compte);

            persons.replaceOne(Filters.eq("_id", drissa.getId()), drissa);

            List<Person> people2 = persons.find().into(new ArrayList<>());
            people2.forEach(System.out::println);

            System.out.println(persons.find(Filters.eq("address.ville", "Rennes")).first());

        }
    }
}
