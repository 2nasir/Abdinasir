import java.util.*;

public class NFA {
    public static boolean nfa(String input) {
        // Durum geçişlerini temsil eden harita
        Map<String, Map<Character, Set<String>>> transitions = new HashMap<>();

        transitions.put("q0", Map.of('a', Set.of("q1"), 'b', Set.of("q2")));
        transitions.put("q1", Map.of('a', Set.of("q4"), 'b', Set.of("q6")));
        transitions.put("q2", Map.of('a', Set.of("q6"), 'b', Set.of("q5")));
        transitions.put("q4", Map.of('a', Set.of("q4"), 'b', Set.of("q7")));
        transitions.put("q5", Map.of('a', Set.of("q10"), 'b', Set.of("q5")));
        transitions.put("q6", Map.of('a', Set.of("q7"), 'b', Set.of("q10")));
        transitions.put("q7", Map.of('a', Set.of("q7"), 'b', Set.of("q8")));
        transitions.put("q8", Map.of('a', Set.of("q8"), 'b', Set.of("q8")));
        transitions.put("q10", Map.of('a', Set.of("q8"), 'b', Set.of("q10")));

        Set<String> currentStates = new HashSet<>();
        currentStates.add("q0");

        // Giriş dizisini işlemeye başla
        for (char c : input.toCharArray()) {
            Set<String> nextStates = new HashSet<>();

            for (String state : currentStates) {
                if (transitions.containsKey(state) && transitions.get(state).containsKey(c)) {
                    nextStates.addAll(transitions.get(state).get(c));
                }
            }

            currentStates = nextStates;
        }

        // Kabul durumunda olup olmadığını kontrol et
        return currentStates.contains("q8");
    }
}