import org.testng.annotations.Test;

public class ForTest3 {

    @Test
    public void groupTestOne() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method One. thread id is: " + id);
    }

    @Test
    public void groupTestTwo() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method two. Thread id is: " + id);
    }

    @Test
    public void groupTestThree() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method three. Thread id is: " + id);
    }
}
