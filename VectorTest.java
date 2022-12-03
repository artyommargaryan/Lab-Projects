import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class VectorTest {
    public static void main(String[] args) {
        (new VectorTest()).testAt();
        System.out.println();
        (new VectorTest()).testFront();
        System.out.println();
        (new VectorTest()).testBack();
        System.out.println();
        (new VectorTest()).testEmpty();
        System.out.println();
        (new VectorTest()).testSize();
        System.out.println();
        (new VectorTest()).testCapacity();
        System.out.println();
        (new VectorTest()).testClear();
        System.out.println();
        (new VectorTest()).testReserve();
        System.out.println();
        (new VectorTest()).testShrink_To_Fit();
        System.out.println();
        (new VectorTest()).testInsert();
        System.out.println();
        (new VectorTest()).testPush_Back();
        System.out.println();
        (new VectorTest()).testPop_Back();
        System.out.println();
        (new VectorTest()).testErase();
        System.out.println();
        (new VectorTest()).testResize();
        System.out.println();
        (new VectorTest()).testResize2();
        System.out.println();
        (new VectorTest()).testVectorIterator();
        System.out.println();
        (new VectorTest()).testCopyConstructor();
        System.out.println();
        (new VectorTest()).testToString();
        System.out.println();
        (new VectorTest()).testOperatorEqual();
        System.out.println();
        (new VectorTest()).testOperatorNotEqual();
        System.out.println();
        (new VectorTest()).testOperatorPlus();
        System.out.println();
        (new VectorTest()).testParameterizedConstructor();
        System.out.println();
        (new VectorTest()).testOperatorAdditionAssignment();
        System.out.println();
        (new VectorTest()).testOperatorCopyAssignment();
        System.out.println();
        (new VectorTest()).testOperatorMoveAssignment();
        System.out.println();
        (new VectorTest()).testOperatorLesserThan();
        System.out.println();
        (new VectorTest()).testOperatorLesserThanEqualTo();
        System.out.println();
        (new VectorTest()).testOperatorGreaterThan();
        System.out.println();
        (new VectorTest()).testOperatorGreaterThanEqualTo();
        System.out.println();

    }

    private void testOperatorGreaterThanEqualTo() {
        System.out.println("testOperatorGreaterThanEqualTo");

        Vector<Integer> vector1 = new Vector<>();
        Vector<Integer> vector2 = new Vector<>();

        System.out.println("After creating");
        if (vector2.operatorGreaterThanEqualTo(vector1)) {
            ok("vector2 is greater than vector1 or equal to");
        } else {
            err("vector2 is greater than vector1 or equal to");
        }

        for (int i = 0; i < 15; i++) {
            vector1.push_back(i);
        }

        System.out.println("After push_back vector1");
        if (vector1.operatorGreaterThanEqualTo(vector2)) {
            ok("vector1 is greater than or equal to vector2");
        } else {
            err("vector1 isn't greater than or equal to vector2");
        }

        vector2 = new Vector<>(vector1);

        System.out.println("After copying vector1 to vector2");
        if (vector1.operatorGreaterThanEqualTo(vector2)) {
            ok("vector1 is greater than vector2 or equal to vector2");
        } else {
            err("vector1 isn't lesser than vector2 or equal to vector 2");
        }

        vector2.pop_back();
        System.out.println("After vector2 pop_back");
        if (vector1.operatorGreaterThanEqualTo(vector2)) {
            ok("vector1 is greater than vector2 or equal to");
        } else {
            err("vector1 isn greater than vector2 or equal to");
        }

        vector2.clear();
        vector2 = new Vector<>(15, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

        System.out.println("After  vector2 = new Vector<>(15, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13): ");
        if (vector1.operatorGreaterThanEqualTo(vector2)) {
            ok("vector1 is greater than or equal to vector2");
        } else {
            err("vector1 isn't greater than or equal to vector2");
        }

        System.out.println("operatorGreaterThanEqualTo with chars");

        Vector<Character> vector3 = new Vector<>();
        Vector<Character> vector4 = new Vector<>();

        for (int i = 0; i < 7; ++i) {
            vector3.push_back((char) ('a' + i));
        }

        for (int i = 0; i < 7; ++i) {
            vector4.push_back((char) ('z' - i));
        }

        if (vector4.operatorGreaterThanEqualTo(vector3)) {
            ok("vector3 is greater than or equal to vector4");
        } else {
            err("vector3 isn't greater than or equal to vector4");
        }
    }


    private void testOperatorGreaterThan() {
        System.out.println("testOperatorGreaterThan");

        Vector<Integer> vector1 = new Vector<>();
        Vector<Integer> vector2 = new Vector<>();

        System.out.println("After creating");
        if (!vector1.operatorGreaterThan(vector2)) {
            ok("vector1 isn't greater than vector2");
        } else {
            err("vector1 is greater than vector2");
        }

        for (int i = 0; i < 15; i++) {
            vector1.push_back(i);
        }

        System.out.println("After push_back vector1");
        if (vector1.operatorGreaterThan(vector2)) {
            ok("vector1 is greater than vector22");
        } else {
            err("vector1 isn't greater than vector2");
        }

        vector2 = new Vector<>(vector1);

        System.out.println("After copying vector1 to vector2");
        if (!vector1.operatorGreaterThan(vector2)) {
            ok("vector1 isn't greater than vector2");
        } else {
            err("vector1 is greater than vector2");
        }

        vector2.pop_back();
        System.out.println("After vector2 pop_back");
        if (vector1.operatorGreaterThan(vector2)) {
            ok("vector1 is greater than vector2");
        } else {
            err("vector1 isn't greater than vector2");
        }

        vector2.clear();
        vector2 = new Vector<>(15, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

        System.out.println("After vector2 = new Vector<>(15, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13): ");
        if (vector1.operatorGreaterThan(vector2)) {
            ok("vector1 is greater than vector2");
        } else {
            err("vector1 isn't greater than vector2");
        }

        System.out.println("operatorGreaterThan with chars");

        Vector<Character> vector3 = new Vector<>();
        Vector<Character> vector4 = new Vector<>();

        for (int i = 0; i < 7; ++i) {
            vector3.push_back((char) ('a' + i));
        }

        for (int i = 0; i < 7; ++i) {
            vector4.push_back((char) ('z' - i));
        }

        if (vector4.operatorGreaterThan(vector3)) {
            ok("vector4 is greater than vector3");
        } else {
            err("vector4 isn't greater than vector3");
        }
    }

    private void testOperatorLesserThanEqualTo() {
        System.out.println("testOperatorLesserThanEqualTo");

        Vector<Integer> vector1 = new Vector<>();
        Vector<Integer> vector2 = new Vector<>();

        System.out.println("After creating");
        if (vector1.operatorLesserThanEqualTo(vector2)) {
            ok("vector1 is lesser than vector2 or equal to");
        } else {
            err("vector1 isn't lesser than vector2 or equal to");
        }

        for (int i = 0; i < 15; i++) {
            vector1.push_back(i);
        }

        System.out.println("After push_back vector1");
        if (vector2.operatorLesserThanEqualTo(vector1)) {
            ok("vector2 is lesser than or equal to vector1");
        } else {
            err("vector2 isn't lesser than or equal to vector1");
        }

        vector2 = new Vector<>(vector1);

        System.out.println("After copying vector1 to vector2");
        if (vector1.operatorLesserThanEqualTo(vector2)) {
            ok("vector1 isn lesser than vector2 or equal to");
        } else {
            err("vector1 isn't lesser than vector2 or equal to");
        }

        vector2.pop_back();
        System.out.println("After vector2 pop_back");
        if (vector2.operatorLesserThanEqualTo(vector1)) {
            ok("vector2 is lesser than vector2 or equal to");
        } else {
            err("vector2 isn lesser than vector1 or equal to");
        }

        vector2.clear();
        vector2 = new Vector<>(15, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

        System.out.println("After  vector2 = new Vector<>(15, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13): ");
        if (vector2.operatorLesserThanEqualTo(vector1)) {
            ok("vector2 is lesser than or equal to vector1");
        } else {
            err("vector2 isn't lesser than or equal to vector1");
        }

        System.out.println("operatorLesserThanEqualTo with chars");

        Vector<Character> vector3 = new Vector<>();
        Vector<Character> vector4 = new Vector<>();

        for (int i = 0; i < 7; ++i) {
            vector3.push_back((char) ('a' + i));
        }

        for (int i = 0; i < 7; ++i) {
            vector4.push_back((char) ('z' - i));
        }

        if (vector3.operatorLesserThanEqualTo(vector4)) {
            ok("vector3 is lesser than or equal to vector4");
        } else {
            err("vector3 isn't lesser than or equal to vector4");
        }
    }


    private void testOperatorLesserThan() {
        System.out.println("testOperatorLesserThan");

        Vector<Integer> vector1 = new Vector<>();
        Vector<Integer> vector2 = new Vector<>();

        System.out.println("After creating");
        if (!vector1.operatorLesserThan(vector2)) {
            ok("vector1 isn't lesser than vector2");
        } else {
            err("vector1 is lesser than vector2");
        }

        for (int i = 0; i < 15; i++) {
            vector1.push_back(i);
        }

        System.out.println("After push_back vector1");
        if (vector2.operatorLesserThan(vector1)) {
            ok("vector2 is lesser than vector1");
        } else {
            err("vector2 isn't lesser than vector1");
        }

        vector2 = new Vector<>(vector1);

        System.out.println("After copying vector1 to vector2");
        if (!vector1.operatorLesserThan(vector2)) {
            ok("vector1 isn't lesser than vector2");
        } else {
            err("vector1 is lesser than vector2");
        }

        vector2.pop_back();
        System.out.println("After vector2 pop_back");
        if (vector2.operatorLesserThan(vector1)) {
            ok("vector2 is lesser than vector1");
        } else {
            err("vector2 isn't lesser than vector1");
        }

        vector2.clear();
        vector2 = new Vector<>(15, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

        System.out.println("After  vector2 = new Vector<>(15, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13): ");
        if (vector2.operatorLesserThan(vector1)) {
            ok("vector2 is lesser than vector1");
        } else {
            err("vector2 isn't lesser than vector1");
        }

        System.out.println("operatorLesserThan with chars");

        Vector<Character> vector3 = new Vector<>();
        Vector<Character> vector4 = new Vector<>();

        for (int i = 0; i < 7; ++i) {
            vector3.push_back((char) ('a' + i));
        }

        for (int i = 0; i < 7; ++i) {
            vector4.push_back((char) ('z' - i));
        }

        if (vector3.operatorLesserThan(vector4)) {
            ok("vector3 is lesser than vector4");
        } else {
            err("vector3 isn't lesser than vector4");
        }
    }

    private void testOperatorMoveAssignment() {
        System.out.println("testOperatorMoveAssignment");
        Vector<String> vector1 = new Vector<>();
        Vector<String> vector2 = Vector.operatorMoveAssignment(vector1);

        if (vector2.empty()) {
            ok("Vector is empty");
        } else {
            err("Vector isn't empty");
        }

        if (vector2.equals(vector1)) {
            ok("vector2 is equal to vector 1");
        } else {
            err("vector2 isn't equal to vector 1");
        }

        for (int i = 0; i < 6; i++) {
            vector1.push_back(Integer.toString(i));
        }

        vector2 = Vector.operatorMoveAssignment(vector1);

        if (!vector2.empty()) {
            ok("Vector isn't empty");
        } else {
            err("Vector is empty");
        }

        if (vector2.equals(vector1)) {
            ok("vector2 is equal to vector 1");
        } else {
            err("vector2 isn't equal to vector 1");
        }

        if (vector2.operatorEquals(vector1)) {
            ok("vector2 size, capacity and elements are equal to vector1 size, capacity and elements");
        } else {
            err("vector2 size, capacity and elements are equal to vector 1 size, capacity and elements");
        }
    }

    private void testOperatorCopyAssignment() {
        System.out.println("testOperatorCopyAssignment");
        Vector<String> vector1 = new Vector<>();
        Vector<String> vector2 = Vector.operatorCopyAssignment(vector1);

        if (vector2.empty()) {
            ok("Vector is empty");
        } else {
            err("Vector isn't empty");
        }

        if (!vector2.equals(vector1)) {
            ok("vector2 isn't equal to vector 1");
        } else {
            err("vector2 is equal to vector 1");
        }

        for (int i = 0; i < 6; i++) {
            vector1.push_back(Integer.toString(i));
        }

        vector2 = Vector.operatorCopyAssignment(vector1);

        if (!vector2.empty()) {
            ok("Vector isn't empty");
        } else {
            err("Vector is empty");
        }

        if (!vector2.equals(vector1)) {
            ok("vector2 isn't equal to vector 1");
        } else {
            err("vector2 is equal to vector 1");
        }

        if (vector2.operatorEquals(vector1)) {
            ok("vector2 size, capacity and elements are equal to vector1 size, capacity and elements");
        } else {
            err("vector2 size, capacity and elements are equal to vector 1 size, capacity and elements");
        }
    }

    private void testOperatorAdditionAssignment() {
        Vector<Integer> vector1 = new Vector<>();
        Vector<Integer> vector2 = new Vector<>();

        vector1.operatorAdditionAssignment(vector2);

        if (vector1.empty()) {
            ok("vector1 is empty");
        } else {
            err("vector1 should be empty");
        }

        for (int i = 0; i < 6; i++) {
            vector1.push_back(i);
        }

        vector1.operatorAdditionAssignment(vector2);

        System.out.println("After vector1.operatorAdditionAssignment(vector2): ");

        if (vector1.size() == 6) {
            ok("vector1 size is correct");
        } else {
            err("vector1 size is incorrect");
        }

        if (vector1.capacity() == 10) {
            ok("vector1 capacity is correct");
        } else {
            err("vector1 capacity is incorrect");
        }

        boolean bool = true;
        for (int i = 0; i < vector1.size(); i++) {
            if (vector1.at(i) != i) {
                bool = false;
                break;
            }
        }
        if (bool) {
            ok("vector1 elements are correct");
        } else {
            err("vector1 elements are incorrect");
        }

        vector2.operatorAdditionAssignment(vector1);

        System.out.println("After vector2.operatorAdditionAssignment(vector1): ");

        if (vector2.size() == 6) {
            ok("vector2 size is correct");
        } else {
            err("vector2 size is incorrect");
        }

        if (vector2.capacity() == 10) {
            ok("vector2 capacity is correct");
        } else {
            err("vector2 capacity is incorrect");
        }

        bool = true;
        for (int i = 0; i < vector2.size(); i++) {
            if (vector2.at(i) != i) {
                bool = false;
                break;
            }
        }
        if (bool) {
            ok("vector2 elements are correct");
        } else {
            err("vector2 elements are incorrect");
        }

        vector1.operatorAdditionAssignment(vector2);
        System.out.println("After vector1.operatorAdditionAssignment(vector2): ");

        if (vector1.size() == 12) {
            ok("vector1 size is correct");
        } else {
            err("vector1 size is incorrect");
        }

        if (vector1.capacity() == 20) {
            ok("vector1 capacity is correct");
        } else {
            err("vector1 capacity is incorrect");
        }

        bool = true;
        for (int i = 0; i < 6; i++) {
            if (vector1.at(i) != i) {
                bool = false;
                break;
            }
        }

        int count = 0;
        for (int i = 6; i < 12; i++) {
            if (vector1.at(i) != count) {
                bool = false;
                break;
            }
            count++;
        }

        if (bool) {
            ok("vector1 elements are correct");
        } else {
            err("vector1 elements are incorrect");
        }

        vector2.operatorAdditionAssignment(vector2);
        System.out.println("After vector2.operatorAdditionAssignment(vector2): ");
        if (vector2.size() == 12) {
            ok("vector2 size is correct: " + vector2.size());
        } else {
            err("vector2 size is incorrect: Actual is " + vector2.size() + ", Expecting: " + 12);
        }

        if (vector2.capacity() == 20) {
            ok("vector2 capacity is correct");
        } else {
            err("vector2 capacity is incorrect");
        }

        bool = true;
        for (int i = 0; i < 6; i++) {
            if (vector1.at(i) != i) {
                bool = false;
                break;
            }
        }

        count = 0;
        for (int i = 6; i < 12; i++) {
            if (vector1.at(i) != count) {
                bool = false;
                break;
            }
            count++;
        }

        if (bool) {
            ok("vector2 elements are correct");
        } else {
            err("vector2 elements are incorrect");
        }
    }


    private void testParameterizedConstructor() {
        Vector<String> vector = new Vector<>(5);
        if (vector.empty()) {
            ok("Vector is empty");
        } else {
            err("Vector isn't empty");
        }

        if (vector.capacity() == 5) {
            ok("Vector capacity is 5");
        } else {
            err("Vector capacity isn't 5");
        }

        String[] string = {"1", "2", "3", "4", "5"};
        vector = new Vector<>(7, string);
        if (vector.capacity() == 7) {
            ok("Vector capacity is 7");
        } else {
            err("Vector capacity isn't 7");
        }
        boolean bool = true;
        for (int i = 0; i < string.length; ++i) {
            if (!Objects.equals(vector.at(i), string[i])) {
                bool = false;
                break;
            }
        }

        if (bool) {
            ok("Vector elements are right");
        } else {
            err("Vector elements aren't right");
        }

        vector = new Vector<>(8, "1", "2", "3", "4", "5");
        if (vector.capacity() == 8) {
            ok("Vector capacity is 8");
        } else {
            err("Vector capacity isn't 8");
        }
        if (vector.size() == 5) {
            ok("Vector size is 5");
        } else {
            err("Vector size isn't 5");
        }
        bool = true;
        for (int i = 0; i < vector.size(); ++i) {
            if (!Objects.equals(vector.at(i), Integer.toString(i + 1))) {
                bool = false;
                break;
            }
        }
        if (bool) {
            ok("Vector elements are right");
        } else {
            err("Vector elements aren't right");
        }
    }

    private void testOperatorPlus() {
        System.out.println("testOperatorPlus");
        Vector<Integer> vector1 = new Vector<>();
        Vector<Integer> vector2 = new Vector<>();
        Vector<Integer> vector3 = Vector.operatorPlus(vector1, vector2);
        System.out.println("vector1: " + vector1);
        System.out.println("vector2: " + vector2);
        System.out.println("vector3: " + vector3);
        System.out.println();


        vector1.push_back(1);
        vector3 = Vector.operatorPlus(vector1, vector2);
        System.out.println("vector1: " + vector1);
        System.out.println("vector2: " + vector2);
        System.out.println("vector3: " + vector3);
        System.out.println();

        vector3 = Vector.operatorPlus(vector2, vector1);
        System.out.println("vector1: " + vector1);
        System.out.println("vector2: " + vector2);
        System.out.println("vector3: " + vector3);
        System.out.println();

        vector1 = new Vector<>();
        for (int i = 0; i < 10; i++) {
            vector1.push_back(i);
        }
        for (int i = 10; i < 20; i++) {
            vector2.push_back(i);
        }
        vector3 = Vector.operatorPlus(vector2, vector1);
        System.out.println("vector1: " + vector1);
        System.out.println("vector2: " + vector2);
        System.out.println("vector3: " + vector3);
        System.out.println("vector3 size: " + vector3.size());
        System.out.println("vector3 capacity: " + vector3.capacity());
        System.out.println();
    }

    private void testOperatorNotEqual() {
        System.out.println("testNotEqual");
        Vector<String> vector = new Vector<>();
        Vector<String> vector1 = new Vector<>(vector);

        if (!vector.operatorNotEquals(vector1)) {
            ok("Vectors are equal after creating");
        } else {
            err("Vectors aren't equal after creating");
        }

        for (int i = 0; i < 10; ++i) {
            vector.push_back(Integer.toString(i));
        }

        for (int i = 0; i < 5; ++i) {
            vector.push_back(Integer.toString(i));
        }

        if (vector.operatorNotEquals(vector1)) {
            ok("Vectors aren't equal after 1st pushback");
        } else {
            err("Vectors are equal after 1st pushback");
        }

        vector1 = new Vector<>(vector);

        if (!vector.operatorNotEquals(vector1)) {
            ok("Vectors are equal after copying");
        } else {
            err("Vectors aren't equal after copying");
        }

        vector1.push_back("10");
        if (vector.operatorNotEquals(vector1)) {
            ok("Vectors aren't equal after adding element to one of them");
        } else {
            err("Vectors are equal after adding element to one of them");
        }

        vector.push_back("11");
        if (vector.operatorNotEquals(vector1)) {
            ok("Vectors aren't equal after adding different elements");
        } else {
            err("Vectors are equal after adding different elements");
        }
    }

    private void testOperatorEqual() {
        System.out.println("testEqual");
        Vector<Integer> vector = new Vector<>();
        Vector<Integer> vector1 = new Vector<>(vector);

        if (vector.operatorEquals(vector1)) {
            ok("Vectors are equal after creating");
        } else {
            err("Vectors aren't equal after creating");
        }

        for (int i = 0; i < 10; ++i) {
            vector.push_back(i);
        }

        for (int i = 0; i < 5; ++i) {
            vector.push_back(i);
        }

        if (!vector.operatorEquals(vector1)) {
            ok("Vectors aren't equal after 1st pushback");
        } else {
            err("Vectors are equal after 1st pushback");
        }

        vector1 = new Vector<>(vector);

        if (vector.operatorEquals(vector1)) {
            ok("Vectors are equal after copying");
        } else {
            err("Vectors aren't equal after copying");
        }

        vector1.push_back(10);
        if (!vector.operatorEquals(vector1)) {
            ok("Vectors aren't equal after adding element to one of them");
        } else {
            err("Vectors are equal after adding element to one of them");
        }

        vector.push_back(11);
        if (!vector.operatorEquals(vector1)) {
            ok("Vectors aren't equal after adding different elements");
        } else {
            err("Vectors are equal after adding different elements");
        }
    }

    private void testToString() {
        System.out.println("testToString");
        Vector<Integer> vector = new Vector<>();
        System.out.println("Vector elements after creating: ");
        System.out.print(vector);
        System.out.println();

        for (int i = 0; i < 10; i++) {
            vector.push_back(i);
        }
        System.out.println("Vector elements after push_back: ");
        System.out.print(vector);
        System.out.println();

        Vector<String> vector1 = new Vector<>();
        System.out.println("Vector1 elements after creating: ");
        System.out.print(vector1);
        System.out.println();

        for (int i = 0; i < 10; i++) {
            vector1.push_back(Integer.toString(i));
        }
        System.out.println("Vector1 elements after push_back: ");
        System.out.print(vector1);
        System.out.println();

    }

    private void testCopyConstructor() {
        System.out.println("testCopyConstructor");
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 10; ++i) {
            vector.push_back(i);
        }

        Vector<Integer> vector1 = new Vector<>(vector);
        System.out.println("Vector size: " + vector.size());
        System.out.println("Vector capacity: " + vector.capacity());
        System.out.println("Vector elements: ");
        for (int i = 0; i < vector.size(); ++i) {
            System.out.print(vector.at(i) + " ");
        }
        System.out.println();

        System.out.println("Vector1 size: " + vector1.size());
        System.out.println("Vector1 capacity: " + vector1.capacity());
        System.out.println("Vector1 elements: ");
        for (int i = 0; i < vector1.size(); ++i) {
            System.out.print(vector1.at(i) + " ");
        }
        System.out.println();

        vector1.push_back(10);
        System.out.println("Vector size: " + vector.size());
        System.out.println("Vector capacity: " + vector.capacity());
        System.out.println("Vector elements: ");
        for (int i = 0; i < vector.size(); ++i) {
            System.out.print(vector.at(i) + " ");
        }
        System.out.println();

        System.out.println("Vector1 size: " + vector1.size());
        System.out.println("Vector1 capacity: " + vector1.capacity());
        System.out.println("Vector1 elements: ");
        for (int i = 0; i < vector1.size(); ++i) {
            System.out.print(vector1.at(i) + " ");
        }
        System.out.println();

    }

    private void testErase() {
        System.out.println("testErase");
        Vector<Long> vector = new Vector<>();
        try {
            vector.erase(0);
            err("expecting exception");
        } catch (IndexOutOfBoundsException viobe) {
            ok("exception caught");
        }

        for (long i = 0; i < 10; ++i) {
            vector.push_back(i);
        }

        System.out.println("Vector elements: ");
        for (int i = 0; i < vector.size(); ++i) {
            System.out.print(vector.at(i) + " ");
        }
        System.out.println();

        vector.erase(4);
        System.out.println("Vector size after erase: " + vector.size());
        System.out.println("Vector elements: ");
        for (int i = 0; i < vector.size(); ++i) {
            System.out.print(vector.at(i) + " ");
        }
        System.out.println();

        vector.erase(0, 1);
        System.out.println("Vector size after erase(0,1): " + vector.size());
        System.out.println("Vector elements: ");
        for (int i = 0; i < vector.size(); ++i) {
            System.out.print(vector.at(i) + " ");
        }
        System.out.println();

        vector.erase(2, 5);
        System.out.println("Vector size after erase(2,5): " + vector.size());
        System.out.println("Vector elements: ");
        for (int i = 0; i < vector.size(); ++i) {
            System.out.print(vector.at(i) + " ");
        }
        System.out.println();

    }

    private void testVectorIterator() {
        System.out.println("testVectorIterator");
        Vector<String> vector = new Vector<>();
        Iterator<String> it = vector.iterator();

        for (var x : vector) {
            System.out.println("T: " + x);
        }

        if (!it.hasNext()) {
            ok("On empty vector Iterator hasn't next");
        } else {
            err("On empty vector Iterator hasn't next");
        }

        try {
            it.next();
            err("excepting exception");
        } catch (NoSuchElementException e) {
            ok("exception caught");
        }

        vector.push_back("a");

        if (it.hasNext()) {
            ok("Not empty vector Iterator has next");
        } else {
            err("Not empty vector Iterator has next");
        }

        if (it.next().equals("a")) {
            ok("First element is given one");
        } else {
            err("First element isn't given one");
        }

        try {
            it.next();
            err("expecting exception");
        } catch (NoSuchElementException e) {
            ok("exception caught");
        }

        vector.push_back("b");
        vector.push_back("c");

        if (it.next().equals("b")) {
            ok("Second element is given one");
        } else {
            err("Second element isn't given one");
        }

        if (it.next().equals("c")) {
            ok("Third element is given one");
        } else {
            err("Third element isn't given one");
        }

        try {
            it.next();
            err("expecting exception");
        } catch (NoSuchElementException e) {
            ok("exception caught");
        }

        var it2 = vector.iterator();
        it2.next();
        it2.next();
        vector.pop_back();

        if (!it2.hasNext()) {
            ok("Vector hasn't next");
        } else {
            err("Vector has next");
        }

        try {
            it2.next();
            err("Expecting exception");
        } catch (NoSuchElementException e) {
            ok("exception caught");
        }

    }

    private void testClear() {
        System.out.println("testClear");
        Vector<Boolean> vector = new Vector<>();
        System.out.println("Vector size after creating: " + vector.size());
        System.out.println("Vector capacity after creating: " + vector.capacity());
        System.out.println();

        boolean b = false;
        for (int i = 0; i < 10; ++i) {
            vector.push_back(b);
            b = !b;
        }
        System.out.println("Vector size after push_back: " + vector.size());
        System.out.println("Vector capacity after push_back: " + vector.capacity());
        System.out.println("Vector Elements: ");
        for (int i = 0; i < 10; ++i) {
            System.out.print(vector.at(i) + " ");
        }
        System.out.println();

        vector.clear();
        System.out.println("Vector size after clear: " + vector.size());
        System.out.println("Vector capacity after clear: " + vector.capacity());
        System.out.println("Vector Elements: ");
        for (int i = 0; i < vector.size(); ++i) {
            System.out.print(vector.at(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < 30; ++i) {
            vector.push_back(b);
            b = !b;
        }
        System.out.println("Vector size after push_back: " + vector.size());
        System.out.println("Vector capacity after push_back: " + vector.capacity());
        System.out.println("Vector Elements: ");
        for (int i = 0; i < vector.size(); ++i) {
            System.out.print(vector.at(i) + " ");
        }
        System.out.println();

        vector.clear();
        System.out.println("Vector size after clear: " + vector.size());
        System.out.println("Vector capacity after clear: " + vector.capacity());
        System.out.println("Vector Elements: ");
        for (int i = 0; i < vector.size(); ++i) {
            System.out.print(vector.at(i) + " ");
        }
        System.out.println();
    }

    private void testInsert() {
        System.out.println("testInsert");
        Vector<Short> vector = new Vector<>();
        System.out.println("Vector size after creating: " + vector.size());

        vector.insert(0, (short) 0);
        System.out.println("Vector size after insert(0, \"0\"): " + vector.size());
        System.out.println("Vector Element: " + vector.at(0));

        for (short i = 1; i < 9; ++i) {
            vector.push_back(i);
        }
        System.out.println("Vector size after push_back: " + vector.size());
        System.out.println("Vector Elements: ");
        for (int i = 0; i < 9; ++i) {
            System.out.print(vector.at(i) + " ");
        }
        System.out.println();

        vector.insert(8, (short) 10);
        System.out.println("Vector size after insert(8,\"10\"): " + vector.size());
        System.out.println("Vector capacity after insert(8,\"10\"): " + vector.capacity());
        System.out.println("Vector Elements: ");
        for (int i = 0; i < vector.size(); ++i) {
            System.out.print(vector.at(i) + " ");
        }
        System.out.println();

        vector.insert(8, (short) 11);
        System.out.println("Vector size after insert(8,\"11\"): " + vector.size());
        System.out.println("Vector capacity after insert(8,\"11\"): " + vector.capacity());

        System.out.println("Vector Elements: ");
        for (int i = 0; i < vector.size(); ++i) {
            System.out.print(vector.at(i) + " ");
        }
        System.out.println();
    }

    private void testResize() {
        System.out.println("testResize");
        Vector<Character> vector = new Vector<>();
        System.out.println("Vector size after creating: " + vector.size());

        for (int i = 0; i < 5; ++i) {
            vector.push_back((char) i);
        }
        System.out.println("Vector size after push back: " + vector.size());

        for (int i = 0; i < 5; ++i) {
            System.out.println("Vector element " + i + ": " + vector.at(i));
        }

        vector.resize(4);
        System.out.println("Vector size after resize: " + vector.size());
        System.out.println("Vector capacity after resize: " + vector.capacity());
        for (int i = 0; i < vector.size(); ++i) {
            System.out.println("Vector element " + i + " after resize(4): " + vector.at(i));
        }

        vector.resize(8);
        System.out.println("Vector size after resize: " + vector.size());
        System.out.println("Vector capacity after resize: " + vector.capacity());
        for (int i = 0; i < vector.size(); ++i) {
            System.out.println("Vector element " + i + " after resize(8): " + vector.at(i));
        }

        vector.resize(14);
        System.out.println("Vector size after resize: " + vector.size());
        System.out.println("Vector capacity after resize: " + vector.capacity());
        for (int i = 0; i < vector.size(); ++i) {
            System.out.println("Vector element " + i + " after resize(14): " + vector.at(i));
        }
    }

    private void testResize2() {
        System.out.println("testResize2");
        Vector<Byte> vector = new Vector<>();
        System.out.println("Vector size after creating: " + vector.size());

        for (byte i = 0; i < 5; ++i) {
            vector.push_back(i);
        }
        System.out.println("Vector size after push back: " + vector.size());

        for (int i = 0; i < 5; ++i) {
            System.out.println("Vector element " + i + ": " + vector.at(i));
        }

        vector.resize(4, (byte) 4);
        System.out.println("Vector size after resize: " + vector.size());
        System.out.println("Vector capacity after resize: " + vector.capacity());
        for (int i = 0; i < vector.size(); ++i) {
            System.out.println("Vector element " + i + " after resize(4, 4): " + vector.at(i));
        }

        vector.resize(8, (byte) 8);
        System.out.println("Vector size after resize: " + vector.size());
        System.out.println("Vector capacity after resize: " + vector.capacity());
        for (int i = 0; i < vector.size(); ++i) {
            System.out.println("Vector element " + i + " after resize(8, 8): " + vector.at(i));
        }

        vector.resize(14, (byte) 14);
        System.out.println("Vector size after resize: " + vector.size());
        System.out.println("Vector capacity after resize: " + vector.capacity());
        for (int i = 0; i < vector.size(); ++i) {
            System.out.println("Vector element " + i + " after resize(14, 14): " + vector.at(i));
        }
    }

    private void testPop_Back() {
        System.out.println("testPop_Back");
        Vector<String> vector = new Vector<>();
        System.out.println("Vector size after creating: " + vector.size());

        for (int i = 0; i < 8; ++i) {
            vector.push_back(Integer.toString(i));
        }
        System.out.println("Vector size after push back: " + vector.size());

        for (int i = 0; i < 8; ++i) {
            vector.pop_back();
            System.out.println("Vector size after " + (i + 1) + " pop back: " + vector.size());
        }
    }

    private void testShrink_To_Fit() {
        System.out.println("testShrink_To_Fit");
        Vector<Integer> vector = new Vector<>();
        System.out.println("Vector capacity after creating vector: " + vector.capacity());
        System.out.println("Vector size after creating vector: " + vector.size());
        for (int i = 0; i < 5; ++i) {
            vector.push_back(i);
        }
        System.out.println("Vector capacity after adding elements 1st time: " + vector.capacity());
        System.out.println("Vector size after adding elements 1st time: " + vector.size());

        vector.shrink_to_fit();
        System.out.println("Vector capacity after shrink_to_fit 1st time: " + vector.capacity());
        System.out.println("Vector size after shrink_to_fit 1st time: " + vector.size());

        for (int i = 5; i < 10; ++i) {
            vector.push_back(i);
        }
        System.out.println("Vector capacity after adding elements 2nd time: " + vector.capacity());
        System.out.println("Vector size after adding elements 2nd time: " + vector.size());

        vector.shrink_to_fit();
        System.out.println("Vector capacity after shrink_to_fit 2nd time: " + vector.capacity());
        System.out.println("Vector size after shrink_to_fit 2nd time: " + vector.size());

    }

    private void testReserve() {
        System.out.println("testReserve");
        Vector<Boolean> vector = new Vector<>();
        vector.reserve(5);
        System.out.println("Vector capacity after reserving 5: " + vector.capacity());
        vector.reserve(20);
        System.out.println("Vector capacity after reserving 20: " + vector.capacity());
    }

    private void testPush_Back() {
        System.out.println("testPush_Back");
        Vector<Short> vector = new Vector<>();
        for (short i = 0; i < 10; ++i) {
            vector.push_back(i);
        }

        for (int i = 0; i < 10; ++i) {
            System.out.println(vector.at(i));
        }
    }

    private void testCapacity() {
        System.out.println("testCapacity");
        Vector<Byte> vector = new Vector<>();
        System.out.println("vector capacity is: " + vector.capacity());

        for (byte i = 0; i < 10; ++i) {
            vector.push_back(i);
        }

        for (int i = 0; i < 10; ++i) {
            System.out.println(vector.at(i));
        }

        System.out.println("vector capacity is: " + vector.capacity());

        for (byte i = 10; i < 20; ++i) {
            vector.push_back(i);
        }

        for (int i = 10; i < 20; ++i) {
            System.out.println(vector.at(i));
        }

        System.out.println("vector capacity is: " + vector.capacity());
    }

    private void testBack() {
        System.out.println("testBack");
        Vector<Integer> vector = new Vector<>();
        try {
            vector.back();
            err("expecting exception");
        } catch (IndexOutOfBoundsException e) {
            ok("exception caught");
        }
        vector.push_back(0);
        System.out.println("Back after insert: " + vector.back());
        vector.push_back(1);
        System.out.println("Back after 2nd insert: " + vector.back());
    }

    private void testFront() {
        System.out.println("testFront");
        Vector<String> vector = new Vector<>();
        try {
            vector.front();
            err("expecting exception");
        } catch (IndexOutOfBoundsException e) {
            ok("exception caught");
        }
        vector.push_back("Hello");
        System.out.println("Front after insert: " + vector.front());
        vector.push_back("World");
        System.out.println("Front after 2nd insert: " + vector.front());
    }

    private void testAt() {
        System.out.println("testAt");
        Vector<Character> vector = new Vector<>();
        try {
            vector.at(0);
            err("expecting exception");
        } catch (IndexOutOfBoundsException e) {
            ok("exception caught");
        }
        vector.push_back('h');
        System.out.println("Element at position 0 after insert: " + vector.at(0));
        vector.push_back('w');
        System.out.println("Element at position 0 after 2nd insert: " + vector.at(1));
        try {
            vector.at(11);
            err("expecting exception");
        } catch (IndexOutOfBoundsException e) {
            ok("exception caught");
        }

        for (int i = 0; i < 10; ++i) {
            vector.push_back((char) ('a' + i));
        }

        for (int i = 0; i < vector.size(); ++i) {
            System.out.println(vector.at(i));
        }


    }

    private void testSize() {
        System.out.println("testSize");
        Vector<Integer> vector = new Vector<>();
        System.out.println("Vector size is: " + vector.size());

        vector.push_back(0);
        System.out.println("Vector size after 1st insert is: " + vector.size());

        for (int i = 1; i < 10; ++i) {
            vector.push_back(i);
        }
        System.out.println("Vector size after 10th insert is: " + vector.size());

        vector.push_back(10);
        System.out.println("Vector size after 11th insert is: " + vector.size());
    }

    void testEmpty() {
        System.out.println("testEmpty");
        Vector<String> vector = new Vector<>();

        if (vector.empty()) {
            ok("vector is empty");
        } else {
            err("vector isn't empty");
        }

        //add element
        vector.push_back("Elem1");
        if (!vector.empty()) {
            ok("vector is not empty after 1st insert");
        } else {
            err("vector is empty after 1st insert");
        }
    }

    void ok(String message) {
        System.out.println("OK: " + message);
    }

    void err(String message) {
        System.out.println("ERR: " + message);

    }
}