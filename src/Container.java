import java.util.Arrays;

/**
 * Класс контейнер, позволяющий хранить произвольное количество объектов.
 * Имеются методы добавления, извлечения и удаления элементов.
 * @param <T>
 * @autor Matytsin Alexander
 */
public class Container<T> {
    /** Размерность контейнера */
    private int size;
    /** Массив, в котором хранятся элементы контейнера */
    private T[] array;

    /**
     * Конструктор по умолчанию
     */
    public Container() {
        size = 0;
        array = (T[]) new Object[10];
    }

    /**
     * Конструктор с входным параметром
     * @param size размер контейнера
     */
    public Container(int size) {
        this.size = size;
        array = (T[]) new Object[size];
    }

    /**
     * Метод добавления элемента в начало контейнера
     * @param elem добавляемый элемент
     */
    public void pushFront(T elem) {
        T[] newArray = (T[]) new Object[size + 1];
        newArray[0] = elem;

        for (int i = 0; i < size; ++i) {
            newArray[i + 1] = array[i];
        }

        array = newArray;
        size++;
    }

    /**
     * Метод добавления элемента в конец контейнера
     * @param elem добавляемый элемент
     */
    public void pushBack(T elem) {
        T[] newArray = Arrays.copyOf(array, size + 1);
        newArray[size] = elem;

        array = newArray;
        size++;
    }

    /**
     * Вставка элемента на указанную позицию
     * @param elem добавляемый элемент
     * @param position позиция
     * @throws ArrayIndexOutOfBoundsException
     */
    public void insert(T elem, int position) throws ArrayIndexOutOfBoundsException {
        if (position >= 0 && position <= size) {
            T[] newArray = Arrays.copyOf(array, size + 1);

            for (int i = 0; i < position; ++i) {
                newArray[i] = array[i];
            }

            newArray[position] = elem;

            for (int i = position; i < size; ++i) {
                newArray[i + 1] = array[i];
            }

            array = newArray;
            size++;
        }
        else throw new IndexOutOfBoundsException("Index " + position + " out of range " + size);
    }

    /**
     * Возвращение элемента с указанной позиции
     * @param position позиция
     * @return значение элемента
     * @throws IndexOutOfBoundsException
     */
    public T get(int position) throws IndexOutOfBoundsException {
        if (position >= 0 && position < size) {
            return array[position];
        }
        else throw new IndexOutOfBoundsException("Index " + position + " out of range " + size);
    }

    /**
     * Удаление элемента по указанному положению в контейнере
     * @param position позиция
     * @throws IndexOutOfBoundsException
     */
    public void remove(int position) throws IndexOutOfBoundsException {
        if (position >= 0 && position < size) {
            T[] newArray = Arrays.copyOf(array, size - 1);

            for (int i = 0; i < position; ++i) {
                newArray[i] = array[i];
            }
            for (int i = position; i < size - 1; ++i) {
                newArray[i] = array[i + 1];
            }

            array = newArray;
            size--;
        }
        else throw new IndexOutOfBoundsException("Index " + position + " out of range " + size);
    }

    public int getSize() {
            return this.size;
    }

}
