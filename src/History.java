import java.util.ArrayList;
import java.util.List;

public class History {
    private List<String> al = new ArrayList<>();

    public void addHistory(String record) {
        al.add(record);
    }

    public void viewHistory() {
        System.out.println("========Calculator History=======");

        if (al.isEmpty()) {
            System.out.println("No Previous Calculations to display");
            return;
        }

        for (var results : al) {
            System.out.println(results);
        }
    }
}
