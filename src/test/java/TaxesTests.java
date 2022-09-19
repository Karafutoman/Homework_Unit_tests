import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TaxesTests {
    Taxes tax;


    @BeforeEach
    public void init() {
        System.out.println("Начало тестов");
        tax = new Taxes();
    }

    @BeforeAll
    static void setUpApp() {
        System.out.println("Запускаюсь до выполнения всех тестов...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Запускаюсь после выполнения всех тестов...");
    }


    @ParameterizedTest
    @MethodSource("source")
    public void test1_taxEarningsSixPerCents(int a, int b) {
        int result = tax.taxEarnings(a);
        assertEquals(result, b);
    }
    @Test
    public void test2_taxEarningsSixPerCents() {
        int a = 10_000, expected = 600;
        int result = tax.taxEarnings(a);
        assertNotNull(result);
    }
    @Test
    public void test3_notEquals() {
        int a = 600, b = 100;
        boolean result = tax.notEquals(a, b);
        assertTrue(result);
    }


    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(300, 10), Arguments.of(5_000, 400));
    }
}
