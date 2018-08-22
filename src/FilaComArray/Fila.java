package FilaComArray;

public class Fila {

    private int first = 0;
    private int[] data;
    private int qtd = 0;
    private int capacity = 10;

    public Fila(){
        this.data = new int[this.capacity];
    }

    public Fila(int capacity){
        this.capacity = capacity;
        this.data = new int[this.capacity];
    }

    public void enqueue(int element)
    {
        if (this.isFull()) this.resize();
        this.data[(this.first + this.qtd) % this.capacity] = element;
        this.qtd++;
    }

    public int dequeue() throws EListaVazia{
        if (this.isEmpty()) throw new EListaVazia("A lista está vazia!!");

        int first_element = this.data[this.first];
        this.data[this.first] = 0;
        this.first++;
        this.qtd--;
        return first_element;
    }

    private void resize() {
        this.capacity *= 2;
        int []b = new int[this.capacity];
        for (int i = 0; i < this.qtd; i++) {
            b[(i + this.first) % this.capacity] = this.data[(i + this.first) % this.capacity];
        }
        this.data = b;
    }

    public int size() {
        return this.qtd;
    }

    public boolean isEmpty() {
        return this.qtd == 0;
    }

    public boolean isFull() {
        return this.size() == this.data.length;
    }

    public static void main(String[] args) throws EListaVazia {
        Fila f = new Fila();
        System.out.println(f.size());
        f.enqueue(5);
        System.out.println(f.size());
        System.out.println(f.dequeue());
        System.out.println(f.size());
    }
}
