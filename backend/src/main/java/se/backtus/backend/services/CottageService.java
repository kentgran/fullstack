package se.backtus.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import se.backtus.backend.repository.Cottage;
import se.backtus.backend.repository.CottageRepository;

import java.util.List;

@Service
public class CottageService {
    @Autowired
    private CottageRepository cottageRepository;

    public CottageService() {
    }

    public Cottage createCottage(Cottage cottage) {
        return cottageRepository.save(cottage);
    }

    public List<Cottage> findAll() {
        return cottageRepository.findAll();
    }
}
