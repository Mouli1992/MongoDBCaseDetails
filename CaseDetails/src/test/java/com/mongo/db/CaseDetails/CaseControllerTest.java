package com.mongo.db.CaseDetails;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongo.db.CaseDetails.controller.CaseController;
import com.mongo.db.CaseDetails.domain.CaseDetails;
import com.mongo.db.CaseDetails.service.CaseService;
import lombok.SneakyThrows;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONStringer;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author chandramouli
 */

@WebMvcTest(CaseController.class)
public class CaseControllerTest {
    @Autowired
    private CaseController caseController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CaseService caseServiceTest;

    @Autowired
    Jackson2ObjectMapperBuilder mapperBuilder;


    @SneakyThrows
    @Test
    public void getCaseDetails(){
        //Mock the data returned by Service Class
        CaseDetails caseDetails = new CaseDetails();
        String caseD = "{\\r\\n  \\\"id\\\": \\\"629f7cff97ebe974798cc208\\\",\\r\\n  \\\"caseId\\\": 22,\\r\\n  \\\"caseType\\\": \\\"TEST\\\",\\r\\n  \\\"createdDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n  \\\"updatedDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n  \\\"caseStatus\\\": \\\"TEST\\\",\\r\\n  \\\"caseCreatedBy\\\": \\\"TEST\\\",\\r\\n  \\\"caseUpdatedBy\\\": \\\"TEST\\\",\\r\\n  \\\"caseLog\\\": [\\r\\n    {\\r\\n      \\\"logType\\\": \\\"TEST\\\",\\r\\n      \\\"logLongDesc\\\": \\\"TEST\\\",\\r\\n      \\\"logShortDesc\\\": \\\"TEST\\\",\\r\\n      \\\"createdBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"createdDate\\\": \\\"2022-06-06T02:49:38.229\\\"\\r\\n    }\\r\\n  ],\\r\\n  \\\"customer\\\": [\\r\\n    {\\r\\n      \\\"customerType\\\": \\\"TEST\\\",\\r\\n      \\\"customerId\\\": 1221412,\\r\\n      \\\"customerName\\\": \\\"TEST\\\",\\r\\n      \\\"customerEmail\\\": null,\\r\\n      \\\"createdBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"createdDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"address\\\": {\\r\\n        \\\"country\\\": \\\"TEST\\\",\\r\\n        \\\"city\\\": \\\"TEST\\\",\\r\\n        \\\"postCode\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine1\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine2\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine3\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine4\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine5\\\": \\\"TEST\\\"\\r\\n      }\\r\\n    }\\r\\n  ],\\r\\n  \\\"transactions\\\": [\\r\\n    {\\r\\n      \\\"txnDate\\\": \\\"2022-06-06\\\",\\r\\n      \\\"txnCode\\\": \\\"TEST\\\",\\r\\n      \\\"createdBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"createdDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"txnAmt\\\": 32,\\r\\n      \\\"txnStatus\\\": \\\"TEST\\\"\\r\\n    }\\r\\n  ]\\r\\n}";
        ObjectMapper o = mapperBuilder.build();
        caseDetails = o.readValue(StringEscapeUtils.unescapeJson(caseD),CaseDetails.class);
        when(caseServiceTest.retrieveCaseDetails(anyLong())).thenReturn(caseDetails);

        // Create a mock http request to verify the expected result
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getCaseDetails?caseId=22"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("629f7cff97ebe974798cc208"))
                .andExpect(status().isOk());
    }
    @Test
    @SneakyThrows
    public void saveCaseDetails(){
        //Mock user data to save.
        String caseD = "{\\r\\n  \\\"id\\\": \\\"629f7cff97ebe974798cc208\\\",\\r\\n  \\\"caseId\\\": 23,\\r\\n  \\\"caseType\\\": \\\"TEST\\\",\\r\\n  \\\"createdDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n  \\\"updatedDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n  \\\"caseStatus\\\": \\\"TEST\\\",\\r\\n  \\\"caseCreatedBy\\\": \\\"TEST\\\",\\r\\n  \\\"caseUpdatedBy\\\": \\\"TEST\\\",\\r\\n  \\\"caseLog\\\": [\\r\\n    {\\r\\n      \\\"logType\\\": \\\"TEST\\\",\\r\\n      \\\"logLongDesc\\\": \\\"TEST\\\",\\r\\n      \\\"logShortDesc\\\": \\\"TEST\\\",\\r\\n      \\\"createdBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"createdDate\\\": \\\"2022-06-06T02:49:38.229\\\"\\r\\n    }\\r\\n  ],\\r\\n  \\\"customer\\\": [\\r\\n    {\\r\\n      \\\"customerType\\\": \\\"TEST\\\",\\r\\n      \\\"customerId\\\": 1221412,\\r\\n      \\\"customerName\\\": \\\"TEST\\\",\\r\\n      \\\"customerEmail\\\": null,\\r\\n      \\\"createdBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"createdDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"address\\\": {\\r\\n        \\\"country\\\": \\\"TEST\\\",\\r\\n        \\\"city\\\": \\\"TEST\\\",\\r\\n        \\\"postCode\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine1\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine2\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine3\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine4\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine5\\\": \\\"TEST\\\"\\r\\n      }\\r\\n    }\\r\\n  ],\\r\\n  \\\"transactions\\\": [\\r\\n    {\\r\\n      \\\"txnDate\\\": \\\"2022-06-06\\\",\\r\\n      \\\"txnCode\\\": \\\"TEST\\\",\\r\\n      \\\"createdBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"createdDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"txnAmt\\\": 32,\\r\\n      \\\"txnStatus\\\": \\\"TEST\\\"\\r\\n    }\\r\\n  ]\\r\\n}";
        ObjectMapper o = mapperBuilder.build();
        CaseDetails caseDetails = new CaseDetails();
        caseDetails = o.readValue(StringEscapeUtils.unescapeJson(caseD),CaseDetails.class);
        when(caseServiceTest.insertCaseDetails(any(CaseDetails.class))).thenReturn(caseDetails);
        //Create mock request to save
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/CaseDetails")
                .content(o.writeValueAsString(caseDetails))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value( "629f7cff97ebe974798cc208"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.caseLog[0].logType").value("TEST"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.transactions[0].txnDate").value("2022-06-06"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customer[0].customerName").value("TEST"))
                .andExpect(status().isOk());;

    }

    @Test
    @SneakyThrows
    public void updateTest(){
        String caseD = "{\\r\\n  \\\"id\\\": \\\"629f7cff97ebe974798cc208\\\",\\r\\n  \\\"caseId\\\": 23,\\r\\n  \\\"caseType\\\": \\\"TEST\\\",\\r\\n  \\\"createdDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n  \\\"updatedDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n  \\\"caseStatus\\\": \\\"TEST\\\",\\r\\n  \\\"caseCreatedBy\\\": \\\"TEST\\\",\\r\\n  \\\"caseUpdatedBy\\\": \\\"TEST\\\",\\r\\n  \\\"caseLog\\\": [\\r\\n    {\\r\\n      \\\"logType\\\": \\\"TEST\\\",\\r\\n      \\\"logLongDesc\\\": \\\"TEST\\\",\\r\\n      \\\"logShortDesc\\\": \\\"TEST\\\",\\r\\n      \\\"createdBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"createdDate\\\": \\\"2022-06-06T02:49:38.229\\\"\\r\\n    }\\r\\n  ],\\r\\n  \\\"customer\\\": [\\r\\n    {\\r\\n      \\\"customerType\\\": \\\"TEST\\\",\\r\\n      \\\"customerId\\\": 1221412,\\r\\n      \\\"customerName\\\": \\\"TEST\\\",\\r\\n      \\\"customerEmail\\\": null,\\r\\n      \\\"createdBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"createdDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"address\\\": {\\r\\n        \\\"country\\\": \\\"TEST\\\",\\r\\n        \\\"city\\\": \\\"TEST\\\",\\r\\n        \\\"postCode\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine1\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine2\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine3\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine4\\\": \\\"TEST\\\",\\r\\n        \\\"addressLine5\\\": \\\"TEST\\\"\\r\\n      }\\r\\n    }\\r\\n  ],\\r\\n  \\\"transactions\\\": [\\r\\n    {\\r\\n      \\\"txnDate\\\": \\\"2022-06-06\\\",\\r\\n      \\\"txnCode\\\": \\\"TEST\\\",\\r\\n      \\\"createdBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedBy\\\": \\\"TEST\\\",\\r\\n      \\\"updatedDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"createdDate\\\": \\\"2022-06-06T02:49:38.229\\\",\\r\\n      \\\"txnAmt\\\": 32,\\r\\n      \\\"txnStatus\\\": \\\"TEST\\\"\\r\\n    }\\r\\n  ]\\r\\n}";
        CaseDetails caseDetails = new CaseDetails();
        ObjectMapper objectMapper = mapperBuilder.build();
        caseDetails = objectMapper.readValue(StringEscapeUtils.unescapeJson(caseD), CaseDetails.class);
        when(caseServiceTest.updateCaseDetails(any(CaseDetails.class))).thenReturn(caseDetails);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/updateCaseDetails")
                        .content(objectMapper.writeValueAsString(caseDetails))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("629f7cff97ebe974798cc208"));

    }


}
