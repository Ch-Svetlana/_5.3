import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Randoms implements Iterable<Integer> {
    private List<Integer> unused;
    protected Random random;


    public Randoms(int min, int max) {
        unused = IntStream.range(min, max + 1).boxed().collect(Collectors.toList());
        random = new Random();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return (unused.size() > 0);
            }

            @Override
            public Integer next() {
                int size = unused.size();
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                int idx = random.nextInt(size);
                int result = unused.get(idx);
                unused.set(idx,unused.get(size-1));
                unused.remove(size-1);
                return result;
            }
        };
    }


}
