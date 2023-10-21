package se.backtus.backend.repository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Getter
@Setter
@Document(collection = "cottages")
public class Cottage {
    @Id
    private String id;
    private String name;
    private String location;
    private String amenities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cottage cottage = (Cottage) o;
        return Objects.equals(id, cottage.id) && Objects.equals(name, cottage.name) && Objects.equals(location, cottage.location) && Objects.equals(amenities, cottage.amenities);
    }
}

