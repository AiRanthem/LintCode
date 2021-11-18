package src.toy_factory_496;

public class ToyFactory {
    /**
     * @param type a string
     * @return Get object of the type
     */
    public Toy getToy(String type) {
        if (type.equals("Dog")) {
            return new Dog();
        } else {
            return new Cat();
        }
    }
}
