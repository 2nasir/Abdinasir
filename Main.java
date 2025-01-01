public class Main {
    public static void main(String[] args) {
        // Test örnekleri
        String[] testStrings = {"aabb"};

        for (String s : testStrings) {
            if (NFA.nfa(s)) {
                System.out.println("'" + s + "' kabul edildi.");
            } else {
                System.out.println("'" + s + "' reddedildi.");
            }
        }
    }
}
