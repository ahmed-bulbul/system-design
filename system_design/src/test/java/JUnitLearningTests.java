
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JUnitLearningTests {

    private MyService myService;

    // Example setup before each test
    @BeforeEach
    void setUp() {
        myService = new MyService();
    }

    // Basic test with an assertion
    @Test
    void testAddition() {
        int result = myService.add(2, 3);
        assertEquals(5, result, "2 + 3 should equal 5");
    }

    // Test exception handling
    @Test
    void testDivideByZeroThrowsException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> myService.divide(10, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    // Parameterized test with a single parameter
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testIsPositive(int number) {
        assertTrue(myService.isPositive(number), number + " should be positive");
    }

    // Parameterized test with multiple parameters
    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "5, 5, 10",
        "10, -2, 8"
    })
    void testAdditionParameterized(int a, int b, int expected) {
        assertEquals(expected, myService.add(a, b), a + " + " + b + " should equal " + expected);
    }

    // Test lifecycle: before and after all tests
    @BeforeAll
    static void beforeAllTests() {
        System.out.println("This runs before all tests.");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("This runs after all tests.");
    }

    // Test with a mock (using Mockito)
    @Test
    void testWithMockito() {
        MyService mockService = mock(MyService.class);
        when(mockService.add(10, 20)).thenReturn(30);

        int result = mockService.add(10, 20);
        assertEquals(30, result);

        // Verify the method call
        verify(mockService).add(10, 20);
    }

    // Example of disabling a test
    @Disabled("This is a demonstration of @Disabled annotation")
    @Test
    void disabledTest() {
        fail("This test should be disabled");
    }
}

// Example service class to test
class MyService {
    int add(int a, int b) {
        a++;
        b++;
        return a + b;
    }

    int divide(int a, int b) {
        return a / b;
    }

    boolean isPositive(int number) {
        return number > 0;
    }
}