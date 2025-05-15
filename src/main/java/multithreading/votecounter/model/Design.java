package multithreading.votecounter.model;

import java.util.ArrayList;
import java.util.List;

public class Design {
    private int id;
    private String name;
    private List<Long> votes = new ArrayList<>();

    public Design(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Long> getVotes() {
        return votes;
    }

    public String getName() {
        return name;
    }
}
