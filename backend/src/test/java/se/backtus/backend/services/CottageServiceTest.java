package se.backtus.backend.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.backtus.backend.repository.Cottage;
import se.backtus.backend.repository.CottageRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CottageServiceTest {

    @InjectMocks
    private CottageService cottageService;

    @Mock
    private CottageRepository cottageRepository;

    @Test
    public void testFindAllCottages() {
        List<Cottage> mockCottages = Arrays.asList(new Cottage("1", "peis", "sjøen", "Cottage1"), new Cottage("2", "sauna", "fjeller", "Cottage2"));
        when(cottageRepository.findAll()).thenReturn(mockCottages);

        List<Cottage> cottages = cottageService.findAll();
        assertNotNull(cottages);
        assertEquals(2, cottages.size());
    }
}