package hu.uni.miskolc.webalk;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import hu.uni.miskolc.webalk.dao.HallgatoDAO;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezikException;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class HallgatoDAOMongo implements HallgatoDAO
{

    private final MongoCollection<Hallgato> collection;

    public HallgatoDAOMongo(String uri, String database, String collection){
        ConnectionString connectionString = new ConnectionString(uri);

        ClassModel<Hallgato> hallgatoClassModel = ClassModel.builder(Hallgato.class).idPropertyName("neptunKod").build();

        CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).register(hallgatoClassModel).build());
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry).build();


        MongoClient mongoClient = MongoClients.create(clientSettings);
        MongoDatabase db = mongoClient.getDatabase(database);
        this.collection = db.getCollection(collection, Hallgato.class);
    }

    @Override
    public List<Hallgato> getAllHallgato() {
        return collection.find().into(new ArrayList<Hallgato>());
    }

    @Override
    public Hallgato getHallgatoById(String id) throws HallgatoNemTalalhatoException {
        Hallgato hallgato = collection.find(Filters.eq("_id", id)).first();
        if (hallgato == null){
            throw new HallgatoNemTalalhatoException(id);
        }
        return hallgato;
    }

    @Override
    public void createHallgato(Hallgato hallgato) throws HallgatoMarLetezikException {
        try{
            collection.insertOne(hallgato);
        }catch (MongoWriteException exception){
            throw new HallgatoMarLetezikException(hallgato.getNeptunKod());
        }
    }

    @Override
    public void updateHallgato(Hallgato hallgato) {
        collection.replaceOne(Filters.eq("_id", hallgato.getNeptunKod()), hallgato);
    }

    @Override
    public void deleteHallgato(String id) {
        collection.deleteOne(Filters.eq("_id", id));
    }
}
