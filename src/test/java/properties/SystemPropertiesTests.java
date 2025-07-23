package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("property")
    void systemProperties4Test() {
        String browser = System.getProperty("browser", "chrome");

        System.out.println(browser);
        // gradle property_test
        // chrome

        // gradle property_test -Dbrowser=firefox
        // firefox
    }
}
