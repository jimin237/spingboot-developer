import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class JUnitQuiz {
    @Test
    public void juniQuiz1() {
        String name1 = "홍길동";
        String name2 = "홍길금";
        String name3 = "홍길은";

        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();

        assertThat(name1).isEqualTo(name2);
        assertThat(name1).isNotEqualTo(name3);
    }

    @Test
    public void junitQuiz2() {
        int number1 = 1;
        int number2 = 2;
        int number3 = 3;

        assertThat(number1).isGreaterThan(number2);
        assertThat(number2).isLessThan(number2);
    }
}
