package se.backtus.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.backtus.backend.repository.Cottage;
import se.backtus.backend.services.CottageService;

import java.util.List;

@RestController
@RequestMapping("/api/cottages")
public class CottageController {

    public CottageController(CottageService cottageService) {
        this.cottageService = cottageService;
        System.out.println("started!");
    }

    @Autowired
    private CottageService cottageService;

    @GetMapping("/")
    public List<Cottage> getAllCottages() {
        return cottageService.findAll();
    }
}
