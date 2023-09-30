package com.prospect.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prospect.manager.presentation.controllers.ProspectController;
import com.prospect.manager.presentation.dtos.CompanyDto;
import com.prospect.manager.presentation.dtos.PersonDto;
import com.prospect.manager.presentation.dtos.ProspectDto;
import com.prospect.manager.presentation.services.IProspectService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProspectController.class)
@AutoConfigureDataMongo
public class ProspectContextTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProspectService prospectService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createProspect_NaturalPerson_ShouldReturnCreatedStatus() throws Exception {
        ProspectDto prospectDto = createValidNaturalPersonProspectDto();
        String json = objectMapper.writeValueAsString(prospectDto);

        mockMvc.perform(post("/prospects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());

        verify(prospectService, times(1)).create(prospectDto);
    }

    @Test
    public void createProspect_LegalPerson_ShouldReturnCreatedStatus() throws Exception {
        ProspectDto prospectDto = createValidLegalPersonProspectDto();
        String json = objectMapper.writeValueAsString(prospectDto);

        mockMvc.perform(post("/prospects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());

        verify(prospectService, times(1)).create(prospectDto);
    }

    @Test
    public void createNaturalPersonProspect_WithInvalidName_ShouldReturnBadRequest() throws Exception {
        ProspectDto prospectDto = createNaturalPersonWithInvalidName();
        String json = objectMapper.writeValueAsString(prospectDto);

        mockMvc.perform(post("/prospects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createNaturalPersonProspect_WithInvalidCpf_ShouldReturnBadRequest() throws Exception {
        ProspectDto prospectDto = createNaturalPersonWithInvalidCpf();
        String json = objectMapper.writeValueAsString(prospectDto);

        mockMvc.perform(post("/prospects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createNaturalPersonProspect_WithInvalidEmail_ShouldReturnBadRequest() throws Exception {
        ProspectDto prospectDto = createNaturalPersonWithInvalidEmail();
        String json = objectMapper.writeValueAsString(prospectDto);

        mockMvc.perform(post("/prospects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createNaturalPersonProspect_WithInvalidMcc_ShouldReturnBadRequest() throws Exception {
        ProspectDto prospectDto = createNaturalPersonWithInvalidMcc();
        String json = objectMapper.writeValueAsString(prospectDto);

        mockMvc.perform(post("/prospects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createLegalPersonProspect_WithInvalidCompanyName_ShouldReturnBadRequest() throws Exception {
        ProspectDto prospectDto = createLegalPersonProspectWithInvalidCompanyName();
        String json = objectMapper.writeValueAsString(prospectDto);

        mockMvc.perform(post("/prospects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createLegalPersonProspect_WithInvalidCnpj_ShouldReturnBadRequest() throws Exception {
        ProspectDto prospectDto = createLegalPersonProspectWithInvalidCnpj();
        String json = objectMapper.writeValueAsString(prospectDto);

        mockMvc.perform(post("/prospects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createLegalPersonProspect_WithInvalidMcc_ShouldReturnBadRequest() throws Exception {
        ProspectDto prospectDto = createLegalPersonProspectWithInvalidMcc();
        String json = objectMapper.writeValueAsString(prospectDto);

        mockMvc.perform(post("/prospects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    private ProspectDto createValidNaturalPersonProspectDto() {
        ProspectDto prospectDto = new ProspectDto();
        prospectDto.setNaturalPerson(true);

        PersonDto personDto = new PersonDto();
        personDto.setName("Robert Martins");
        personDto.setCpf("00011122233");
        personDto.setEmail("robert@gmail.com");
        personDto.setMcc(9999);

        prospectDto.setPerson(personDto);

        return prospectDto;

    }

    private ProspectDto createValidLegalPersonProspectDto() {
        ProspectDto prospectDto = new ProspectDto();
        prospectDto.setNaturalPerson(false);

        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyName("Robert Enterprises");
        companyDto.setCnpj("32123212321299");
        companyDto.setMcc(1);

        prospectDto.setCompany(companyDto);

        return prospectDto;
    }

    private ProspectDto createNaturalPersonWithInvalidName() {
        ProspectDto prospectDto = new ProspectDto();
        prospectDto.setNaturalPerson(true);

        PersonDto personDto = new PersonDto();
        personDto.setName("Maximiliano Frederico da Silva Santos Junior");
        personDto.setCpf("00011122233");
        personDto.setEmail("robert@gmail.com");
        personDto.setMcc(1000);

        prospectDto.setPerson(personDto);

        return prospectDto;
    }

    private ProspectDto createNaturalPersonWithInvalidCpf() {
        ProspectDto prospectDto = new ProspectDto();
        prospectDto.setNaturalPerson(true);

        PersonDto personDto = new PersonDto();
        personDto.setName("Robert Martins");
        personDto.setCpf("000111222333");
        personDto.setEmail("robert@gmail.com");
        personDto.setMcc(1005);

        prospectDto.setPerson(personDto);

        return prospectDto;
    }

    private ProspectDto createNaturalPersonWithInvalidEmail() {
        ProspectDto prospectDto = new ProspectDto();
        prospectDto.setNaturalPerson(true);

        PersonDto personDto = new PersonDto();
        personDto.setName("Robert Martins");
        personDto.setCpf("00011122233");
        personDto.setEmail("robert@gmail");
        personDto.setMcc(9998);

        prospectDto.setPerson(personDto);

        return prospectDto;
    }

    private ProspectDto createNaturalPersonWithInvalidMcc() {
        ProspectDto prospectDto = new ProspectDto();
        prospectDto.setNaturalPerson(true);

        PersonDto personDto = new PersonDto();
        personDto.setName("Robert Martins");
        personDto.setCpf("00011122233");
        personDto.setEmail("robert@gmail.com");
        personDto.setMcc(10000);

        prospectDto.setPerson(personDto);

        return prospectDto;
    }

    private ProspectDto createLegalPersonProspectWithInvalidCompanyName() {
        ProspectDto prospectDto = new ProspectDto();
        prospectDto.setNaturalPerson(false);

        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyName("Construções e Engenharia de Desenvolvimento Sustentável Ltda");
        companyDto.setCnpj("32123212321299");
        companyDto.setMcc(9999);

        prospectDto.setCompany(companyDto);

        return prospectDto;
    }

    private ProspectDto createLegalPersonProspectWithInvalidCnpj() {
        ProspectDto prospectDto = new ProspectDto();
        prospectDto.setNaturalPerson(false);

        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyName("Robert PJ");
        companyDto.setCnpj("321232123212999");
        companyDto.setMcc(9999);

        prospectDto.setCompany(companyDto);

        return prospectDto;
    }

    private ProspectDto createLegalPersonProspectWithInvalidMcc() {
        ProspectDto prospectDto = new ProspectDto();
        prospectDto.setNaturalPerson(false);

        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyName("Robert PJ");
        companyDto.setCnpj("32123212321299");
        companyDto.setMcc(10000);

        prospectDto.setCompany(companyDto);

        return prospectDto;
    }

}
