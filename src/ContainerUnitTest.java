import static org.junit.jupiter.api.Assertions.*;

class ContainerUnitTest {

    @org.junit.jupiter.api.Test
    void TestPushFront() {
        Container<String> cont1 = new Container<>();
        cont1.pushFront("World");
        cont1.pushFront("Hello");
        //assertEquals("Hello", cont1.get(0));
        assertEquals(2, cont1.getSize());
    }

    @org.junit.jupiter.api.Test
    void TestPushBack() {
        Container<String> cont1 = new Container<>();
        cont1.pushFront("Hello");
        cont1.pushBack("World");
        assertEquals("World", cont1.get(1));
        assertEquals(2, cont1.getSize());
    }

    @org.junit.jupiter.api.Test
    void TestInsert() {
        Container<String> cont1 = new Container<>();
        cont1.pushFront("Hello");
        cont1.pushBack("World");
        cont1.pushBack("People");
        cont1.insert("My", 1);
        assertEquals("My", cont1.get(1));
        assertEquals(4, cont1.getSize());
    }

    @org.junit.jupiter.api.Test
    void TestGet() {
        Container<String> cont1 = new Container<>();
        cont1.pushFront("Hello");
        cont1.pushBack("World");
        assertEquals("Hello", cont1.get(0));
        assertEquals("World", cont1.get(1));
    }

    @org.junit.jupiter.api.Test
    void TestRemove() {
        Container<String> cont1 = new Container<>();
        cont1.pushFront("Hello");
        cont1.pushBack("World");
        cont1.pushBack("People");
        cont1.remove(1);
        assertEquals("People", cont1.get(1));
        assertEquals(2, cont1.getSize());
    }

}