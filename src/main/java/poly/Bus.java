package poly;

public class Bus implements Transport {
    private int count;

    @Override
    public void drive() {
        System.out.println("we are driving");

    }

    @Override
    public void pas(int count) {
        this.count = count;

    }

    @Override
    public int price(int fuel) {
        return fuel * 50;
    }
}
