public class Main {
    public static void main(String[] args) {
        // Create an instance of the outer class
        Main outer = new Main();

        // Create an instance of the inner class using the outer class instance
        InnerClass inner = outer.new InnerClass();
        StaticInnerClass StaticInner = new StaticInnerClass();
    }

    // Non-static Inner Class
    class InnerClass {
        // Constructor of InnerClass
        InnerClass() {
            // Creating a new object of Outer Class (Main)
            Main newOuter = new Main();
            System.out.println("New Outer Class object created inside Inner Class: " + newOuter);
        }
    }
    static class StaticInnerClass {
        // Constructor of InnerClass
        StaticInnerClass() {
            // Creating a new object of Outer Class (Main)
            Main newOuter = new Main();
            System.out.println("New Outer Class object created inside Static Inner Class: " + newOuter);
        }
    }
}