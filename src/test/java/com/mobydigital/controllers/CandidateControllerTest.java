package com.mobydigital.controllers;


import com.mobydigital.controller.CandidateController;
import com.mobydigital.model.entities.Candidate;
import com.mobydigital.service.ICandidateService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.google.gson.Gson;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import static com.mobydigital.testUtils.TestEntityFactory.getCandidate;
import static com.mobydigital.testUtils.TestEntityFactory.getCandidateDTO;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static com.mobydigital.testUtils.TestEntityFactory.getCandidateNoDate;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest (controllers = CandidateController.class)
class CandidateControllerTest  {

    @MockBean
    ICandidateService iCandidateService;

    @Autowired
    protected MockMvc mockMvc;

    @Test
    @WithMockUser

    void addCandidateTest() throws Exception {
        when(iCandidateService.createCandidate(getCandidateNoDate())).thenReturn(getCandidateNoDate());
        String candidateJson = new Gson().toJson(getCandidateNoDate());
        mockMvc.perform(post("/candidates/add", getCandidateNoDate())
                     .contentType(MediaType.APPLICATION_JSON)
                     .content(candidateJson))
                .andExpect(status().isCreated());

    }

   }

