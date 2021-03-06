//  Create the usual class wrapper
//  and main method on your own.

// - Create a function called `printer`
//   which prints the input String parameters
// - It can have any number of parameters

// Examples
// printer("first")
// printer("first", "second")
// printer("first", "second", "third", "fourth")
// ...
public class Printer {
    public static void main(String[] args) {
        printer("Shout", "it", "out", "loud");
    }

    private static void printer(String... words) {
        System.out.println(String.join(" ",words));
    }
}
