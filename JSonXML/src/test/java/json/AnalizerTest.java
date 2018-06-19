package json;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AnalizerTest {
    private static final String TEST_USD_RATE = "27.00661";

    @Test
    public void positiveReadJSONScenario() {
        Analizer analizer = new json.Analizer();
        String output = analizer.readJSON();
        assertEquals(TEST_USD_RATE, output);
    }
}
