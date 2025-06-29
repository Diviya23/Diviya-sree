package com.example;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    private ExternalApi mockApi;
    private MyService service;

    @BeforeEach
    public void setUp() {
        
        mockApi = mock(ExternalApi.class);
        service = new MyService(mockApi);
        System.out.println("Setup completed.");
    }

    @AfterEach
    public void tearDown() {
        
        System.out.println("Teardown after test.");
    }

    @Test
    public void testFetchData_UsingAAA() {
       
        when(mockApi.getData()).thenReturn("Sample Data");

        
        String result = service.fetchData();

        
        assertEquals("Sample Data", result);
    }

    @Test
    public void testFetchData_VerifyInteraction_UsingAAA() {
        
        service.fetchData();

       
        verify(mockApi).getData();
    }
}
