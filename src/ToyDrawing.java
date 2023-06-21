import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ToyDrawing {
    private List<Toy> toys;

    public ToyDrawing() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public Toy selectToy() throws IOException {
        double randomValue = new Random().nextDouble() * 100;
        if (randomValue > 10) {
            double currentSum = 1;
            for (Toy toy : toys) {
                currentSum += toy.getFrequency();
                if (randomValue < currentSum) {
                    System.out.println("Prize toy is " + toy.getName());
                    saveToyToFile(toy, toy.getId() - 1);
                    return toy;
                }
            }
        } else {
            System.out.println("Nothing drawn, try one more time");
        }
        return null;
    }

    public void saveToyToFile(Toy toy, int index) throws IOException {
        Date date = new Date();
        Toy toyToSave = toys.get(index);
        toyToSave.quantity--;
        toys.remove(index);
        FileWriter writer = new FileWriter("toys.txt", true);
        writer.write(date + " __ " + toyToSave.getName() + " (" + toyToSave.getId() + ")" + "\n");
        writer.close();
    }

    public void printToys() {
        for (Toy toy : toys) {
            System.out.println(toy.getName() + " (" + toy.getId() + "), qty: " + toy.getQuantity() +
                    ", freq: " + toy.getFrequency() + "%");
        }
    }
}
