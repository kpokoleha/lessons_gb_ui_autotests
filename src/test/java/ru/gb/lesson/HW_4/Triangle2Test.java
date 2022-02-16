package ru.gb.lesson.HW_4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Площать треугольника")
public class Triangle2Test {
    private static final Logger logger = LoggerFactory.getLogger(Triangle2Test.class);

    private static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle2(3, 4, 5), 6),
                Arguments.of(new Triangle2(7, 7, 7), 21.21762239271875),
                Arguments.of(new Triangle2(3, 4, 6), 5.332682251925386)

        );
    }

    @DisplayName("Результат расчета по формуле Герона")
    @ParameterizedTest(name = "Площадь треугольника {0} равна {1}")
    @MethodSource("triangles")
    public void TriangleAreaTest(Triangle2 triangle, double expectedTriangleArea) {
        double area = triangle.triangleArea(); //Act
        assertEquals(expectedTriangleArea, area); //Assert

    }
}
