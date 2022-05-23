import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.PriorityQueue;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;

public class PriorityQueueTest {

    public static Stream<Arguments> getParameters() {
        return Stream.of(
                arguments(new int[]{-709, -90, 542, 411, 464, -133, 600, 66, -840, -88}, new int[]{-840, -709, -133, -90, -88, 66, 411, 464, 542, 600}),
                arguments(new int[]{-905, 866, 895, -329, -381, 536, -593, -643, -623, -306}, new int[]{-905, -643, -623, -593, -381, -329, -306, 536, 866, 895}),
                arguments(new int[]{-989, -209, 547, 132, -615, 683, 828, -526, -104, 276}, new int[]{-989, -615, -526, -209, -104, 132, 276, 547, 683, 828}),
                arguments(new int[]{805, -747, 108, 938, 218, 435, 550, 14, -420, 181}, new int[]{-747, -420, 14, 108, 181, 218, 435, 550, 805, 938}),
                arguments(new int[]{56, -314, 709, -274, -33, 523, 628, 781, 303, -495}, new int[]{-495, -314, -274, -33, 56, 303, 523, 628, 709, 782})
        );
    }

    @ParameterizedTest(name="#{index} = Test with Argument={0},{1}")
    @MethodSource("getParameters")
    public void PriorityQueue_RunTest(int[] input, int [] expected) {
        PriorityQueue pq = new PriorityQueue();
        for( int i : input )
            pq.offer(i);
        for( int e : expected )
            assertEquals(e, pq.poll());
    }

    @Test
    public void whenExceptionThrown_thenInitialCapacityLessThanOne(){
        assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue pq = new PriorityQueue(-1);
        });
    }

    @Test
    public void whenExceptionThrown_thenObjectCanNotCompare() {
        assertThrows(ClassCastException.class, () -> {
            PriorityQueue pq = new PriorityQueue();
            pq.offer(12345);
            pq.offer("Hello world!");
        });
    }
    @Test
    public void whenExceptionThrown_thenCollectionAreNull() {
        assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().offer(null);
        });
    }
}
