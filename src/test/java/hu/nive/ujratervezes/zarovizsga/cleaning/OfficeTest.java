package hu.nive.ujratervezes.zarovizsga.cleaning;

import org.junit.jupiter.api.Test;

public class OfficeTest {

    @Test
    void create() {
        Office office = new Office("Budapest, Fo ut. 2.", 300, 5);
        assertEquals("Budapest, Fo ut. 2.", office.getAddress());
    }

    @Test
    void clean() {
        Office office = new Office("Budapest, Fo ut. 2.", 300, 5);
        assertEquals(150_000, office.clean());
    }
}
