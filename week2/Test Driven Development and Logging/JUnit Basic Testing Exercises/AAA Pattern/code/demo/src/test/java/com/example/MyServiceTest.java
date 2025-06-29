package com.example;

import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    private ExternalApi mockApi;
    private MyService service;

    @BeforeEach
    public void setUp() {
        // Setup: runs before each test
        mockApi = mock(ExternalApi.class);
        service = new MyService(mockApi);
        System.out.println("Setup completed.");
    }

    @AfterEach
    public void tearDown() {
        // Teardown: runs after each test
        System.out.println("Teardown after test.");
    }

    @Test
    public void testFetchData_UsingAAA() {
        // Arrange
        when(mockApi.getData()).thenReturn("Sample Data");

        // Act
        String result = service.fetchData();

        // Assert
        assertEquals("Sample Data", result);
    }

    @Test
    public void testFetchData_VerifyInteraction_UsingAAA() {
        // Arrange: mock already injected

        // Act
        service.fetchData();

        // Assert
        verify(mockApi).getData();
    }
}
