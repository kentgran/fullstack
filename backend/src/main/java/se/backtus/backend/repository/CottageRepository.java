package se.backtus.backend.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CottageRepository extends MongoRepository<Cottage, String> {
    // Custom query methods can be defined here
}

