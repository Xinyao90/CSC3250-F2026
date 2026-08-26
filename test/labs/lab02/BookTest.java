package labs.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void newBookShouldBeAvailable() {
        Book book = new Book("Dune", "Frank Herbert");

        assertFalse(book.isCheckedOut());
    }
}
