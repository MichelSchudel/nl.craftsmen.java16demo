package nl.craftsmen.java16demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void testPoint() {
        Point point = new Point(1, 2);
        assertThat(point.x()).isEqualTo(1);
        assertThat(point.y()).isEqualTo(2);
    }

    @Test
    void testLombok() {
        Point point = Point.builder().x(3).y(4).build();
        assertThat(point.x()).isEqualTo(3);
        assertThat(point.y()).isEqualTo(4);
    }

    @Test
    void testJacksonSerialize() throws IOException {
        Point point = new Point(5, 6);
        ObjectMapper objectMapper = new ObjectMapper();
        String serializedPoint = objectMapper.writeValueAsString(point);
        assertThat(serializedPoint).contains("5").contains("6");
    }

    @Test
    void testJacksonDeserialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = """
                            
                { "x": 7, "y": 8}
                            
                """;
        Point point = objectMapper.readValue(json.getBytes(), Point.class);
        assertThat(point.x()).isEqualTo(7);
        assertThat(point.y()).isEqualTo(8);
    }

}
