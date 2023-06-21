import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ToyDrawing drawing = new ToyDrawing();
        Toy toy1 = new Toy(1, "Teddy Bear", 10, 15);
        Toy toy2 = new Toy(2, "Barbie", 5, 25);
        Toy toy3 = new Toy(3, "Cat Tom", 15, 40);
        Toy toy4 = new Toy(4, "Mouse Jerry", 5, 20);
        drawing.addToy(toy1);
        drawing.addToy(toy2);
        drawing.addToy(toy3);
        drawing.addToy(toy4);
        drawing.printToys();
        drawing.selectToy();
    }
}