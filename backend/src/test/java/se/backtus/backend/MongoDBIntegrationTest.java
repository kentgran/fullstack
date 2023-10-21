package se.backtus.backend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import se.backtus.backend.repository.Cottage;
import se.backtus.backend.repository.CottageRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@DataMongoTest
public class MongoDBIntegrationTest {

    @Autowired
    private CottageRepository cottageRepository;

    @Container
    public static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }
    @Test
    public void testWriteAndRead() {
        // Write to MongoDB
        Cottage cottageToSave = new Cottage();
        cottageToSave.setId("101");
        cottageToSave.setAmenities("sofa");
        cottageToSave.setLocation("fjellet");
        cottageToSave.setName("Hyttaa");
        cottageRepository.save(cottageToSave);

        // Read from MongoDB
        Cottage retrievedCottage = cottageRepository.findById(cottageToSave.getId()).orElse(null);

        // Verify
        assertEquals(cottageToSave, retrievedCottage);
    }
}
