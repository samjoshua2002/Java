import java.util.*;

public class array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        Map<String, Double> studentGrades = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            String name = scanner.next();
            double grade = scanner.nextDouble();
            studentGrades.put(name, grade);
        }

        Set<Double> grades = new HashSet<>(studentGrades.values());
        grades.remove(Collections.min(grades));
        double x = Collections.min(grades);

        for (Map.Entry<String, Double> entry : studentGrades.entrySet()) {
            if (entry.getValue() == x) {
                ans.add(entry.getKey());
                break;
            }
        }

        Collections.sort(ans);

        for (String name : ans) {
            System.out.println(name);
        }

        scanner.close();
    }
}
