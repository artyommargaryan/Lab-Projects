import java.util.Iterator;

public class Vector {
    private String[] array;
    private int tos = 0;
    private int size;

    Vector() {
        size = 10;
        array = new String[10];
    }

    boolean empty() {
        return tos == 0;
    }

    public void insert(String elem) {
        if (tos == size - 1) {
            size = size + 10;
            array = new String[size];
        }

        array[tos++] = elem;
    }

    public int size() {
        return tos;
    }

    class VectorIterator implements Iterator<String> {
        String[] array;
        int size;

        VectorIterator() {
            size = 10;
            array = new String[10];
        }

        public boolean hasNext() {
            return false;///
        }

        public String next() {
            return null;
        }
    }
}
