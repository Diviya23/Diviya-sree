package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // 1. Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub method
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Inject into service
        MyService service = new MyService(mockApi);

        // 4. Assert
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }
}
