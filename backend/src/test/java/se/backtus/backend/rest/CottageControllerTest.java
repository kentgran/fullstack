package se.backtus.backend.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import se.backtus.backend.SharedTestContainerConfig;
import se.backtus.backend.services.CottageService;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Import(SharedTestContainerConfig.class)
@AutoConfigureMockMvc(addFilters = false)
class CottageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CottageService cottageService;

    @BeforeEach
    public void setup() {
        when(cottageService.findAll()).thenReturn(Collections.emptyList());
    }

    @Test
    void getAllCottages() throws Exception {
        mockMvc.perform(get("/api/cottages"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));  // Assuming the list is empty
    }
}