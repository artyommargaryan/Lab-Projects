import java.util.Iterator;
import java.util.NoSuchElementException;

public class Vector<T> implements Iterable<T> {
    private final int MAX_CAPACITY = Integer.MAX_VALUE;
    private T[] array;
    private int size = 0;
    private int capacity = 10;

    Vector() {
        array = (T[]) new Object[capacity];
    }

    @SafeVarargs
    Vector(int capacity, T... array) {
        if (capacity < array.length) {
            throw new VectorIndexOutOfBoundsException("Capacity is smaller than Varargs size");
        }
        this.capacity = capacity;
        this.array = (T[]) new Object[this.capacity];
        for (T t : array) {
            this.array[size++] = t;
        }
    }

    Vector(Vector<T> vector) {
        capacity = vector.capacity;
        size = vector.size;
        array = (T[]) new Object[capacity];
        if (size >= 0) System.arraycopy(vector.array, 0, array, 0, size);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size(); ++i) {
            result.append(this.at(i).toString()).append(" ");
        }

        return String.valueOf(result);
    }

    public static <T> Vector<T> operatorCopyAssignment(Vector<T> vector) {
        return new Vector<>(vector);
    }

    public static <T> Vector<T> operatorMoveAssignment(Vector<T> vector) {
        return vector;
    }

    public boolean operatorEquals(Vector<T> vector) {
        if (this.capacity != vector.capacity) {
            return false;
        }
        if (this.size != vector.size) {
            return false;
        }
        for (int i = 0; i < this.size; ++i) {
            if (this.at(i) != vector.at(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean operatorNotEquals(Vector<T> vector) {
        return !this.operatorEquals(vector);
    }

    public static <T> Vector<T> operatorPlus(Vector<T> vector1, Vector<T> vector2) {
        Vector<T> vector = new Vector<>();

        for (T t : vector1) {
            vector.push_back(t);
        }

        for (T t : vector2) {
            vector.push_back(t);
        }
        return vector;
    }

    public void operatorAdditionAssignment(Vector<T> vector) {
        if (this == vector) {
            Vector<T> tmp = new Vector<>(vector);
            for (T t : tmp) {
                this.push_back(t);
            }
            return;
        }
        for (T t : vector) {
            this.push_back(t);
        }
    }

    public boolean operatorLesser(Vector<T> vector) {
        if (this.empty() && vector.empty()) {
            return false;
        }

        if (this.capacity > vector.capacity) {
            return false;
        } else if (this.capacity < vector.capacity) {
            return true;
        }

        if (this.size > vector.size) {
            return false;
        }
        if (this.size < vector.size) {
            return true;
        }

        if (!(this.at(0) instanceof Comparable)) {
            throw new VectorsNotComparableException("Vectors of this type aren't comparable");
        }

        System.out.println();
        System.out.println(String.class);

        if (array.getClass().toString().equals(String.class.toString())) {
            for (int i = 0; i < this.size; ++i) {
                if ((this.at(i).toString()).compareTo((vector.at(i)).toString()) >= 0) {
                    return false;
                }
            }

            return true;
        }

        if (array.getClass().toString().equals(Character.class.toString())) {
            for (int i = 0; i < this.size; ++i) {
                if ((this.at(i).hashCode() >= (vector.at(i).hashCode()))) {
                    return false;
                }
            }

            return true;
        }

        for (int i = 0; i < this.size; ++i) {
            if (Integer.parseInt(this.at(i).toString()) >= Integer.parseInt(((vector.at(i)).toString()))) {
                System.out.println("This: " + this.at(i));
                System.out.println("Vector: " + this.at(i));
                return false;
            }
        }

        return true;
    }

    T at(int position) {
        if (position > size) {
            throw new VectorIndexOutOfBoundsException(size);
        }
//        if (array[position] == null) {
//            throw new VectorIndexOutOfBoundsException("Vector element at " + position + " out of range");
//        }

        return array[position];
    }

    T front() {
        if (this.empty()) {
            throw new VectorIndexOutOfBoundsException();
        }

        return at(0);
    }

    T back() {
        if (this.empty()) {
            throw new VectorIndexOutOfBoundsException();
        }

        return at(size - 1);
    }

    boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void clear() {
        size = 0;
        capacity = 10;
        array = (T[]) new Object[capacity];
    }

    public void reserve(int n) {
        if (n <= capacity) {
            return;
        }
        capacity = n;
        array = (T[]) new Object[capacity];
    }

    public void shrink_to_fit() {
        capacity = size;
        T[] tmp = array;
        array = (T[]) new Object[capacity];
        System.arraycopy(tmp, 0, array, 0, size);
    }

    public void insert(int position, T elem) {
        if (this.empty() && position == 0) {
            push_back(elem);
            return;
        }

        if (size == capacity) {
            capacity = Math.min(capacity + 10, MAX_CAPACITY);
        }
        T[] tmp = array;
        array = (T[]) new Object[capacity];

        int count = 0;

        for (int i = 0; i < size; ++i) {
            if (i == position) {
                array[count++] = elem;
            }
            array[count++] = tmp[i];
        }
        ++size;
    }

    public void push_back(T elem) {
        if (size == capacity) {
            if (capacity == MAX_CAPACITY) {
                throw new VectorIndexOutOfBoundsException("MAX_CAPACITY is reached you can not add element");
            }
            capacity = Math.min(capacity + 10, MAX_CAPACITY);

            T[] tmp = array;
            array = (T[]) new Object[capacity];
            if (size >= 0) System.arraycopy(tmp, 0, array, 0, size);
        }

        array[size] = elem;
        size++;
    }

    public void pop_back() {
        if (this.empty()) {
            return;
        }

        array[size--] = null;
    }

    public void erase(int position) {
        if (position >= size) {
            throw new VectorIndexOutOfBoundsException("Position: " + position + "is out of bounds");
        }
        T[] tmp = array;
        array = (T[]) new Object[capacity];
        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (i != position) {
                array[count++] = tmp[i];
            }
        }
        size--;
    }

    public void erase(int startPosition, int endPosition) {
        if (startPosition > endPosition) {
            throw new VectorIndexOutOfBoundsException("startPosition is bigger than endPosition");
        }
        if (startPosition >= 0 && endPosition < size) {
            T[] tmp = array;
            array = (T[]) new Object[capacity];
            int count = 0;
            for (int i = 0; i < size; ++i) {
                if (i < startPosition || i > endPosition) {
                    array[count++] = tmp[i];
                }
            }
            size = count;
        } else {
            throw new VectorIndexOutOfBoundsException("either startPosition or endPosition or both are invalid");
        }
    }

    public void resize(int n) {
        T[] tmp = array;
        if (n < size) {
            array = (T[]) new Object[capacity];
            if (n >= 0) System.arraycopy(tmp, 0, array, 0, n);
        } else {
            if (n > capacity) {
                capacity = n;
            }
            array = (T[]) new Object[capacity];
            for (int i = 0; i < n; ++i) {
                if (i < size) {
                    array[i] = tmp[i];
                } else {
                    array[i] = null;
                }
            }
        }
        size = n;
    }

    public void resize(int n, T str) {
        T[] tmp = array;
        if (n < size) {
            array = (T[]) new Object[capacity];
            if (n >= 0) System.arraycopy(tmp, 0, array, 0, n);
        } else {
            if (n > capacity) {
                capacity = n;
            }
            array = (T[]) new Object[capacity];
            for (int i = 0; i < n; ++i) {
                if (i < size) {
                    array[i] = tmp[i];
                } else {
                    array[i] = str;
                }
            }
        }
        size = n;
    }

    public Iterator<T> iterator() {
        return new VectorIterator();
    }

    private class VectorIterator implements Iterator<T> {
        int cursor = 0;

        public boolean hasNext() {
            return this.cursor < size;
        }

        public T next() {
            int i = this.cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            } else {
                this.cursor = i + 1;
                return array[i];
            }
        }

    }

    static class VectorIndexOutOfBoundsException extends IndexOutOfBoundsException {
        public VectorIndexOutOfBoundsException() {
        }

        public VectorIndexOutOfBoundsException(String s) {
            super(s);
        }

        public VectorIndexOutOfBoundsException(int index) {
            super("Index out of range: " + index);
        }

        public VectorIndexOutOfBoundsException(long index) {
            super("Index out of range: " + index);
        }
    }

    static class VectorsNotComparableException extends RuntimeException {
        public VectorsNotComparableException() {
        }

        public VectorsNotComparableException(String message) {
            super(message);
        }
    }
}
