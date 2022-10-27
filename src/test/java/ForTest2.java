import org.testng.annotations.Test;

public class ForTest2 {
    @Test(dataProvider = "data-provider", dataProviderClass = ForTest.class)

    public void testMethod(String data) {
        System.out.println("Data is: " + data);
    }
}
