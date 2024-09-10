package dbDto;

import java.util.Date;

public class LongestProjectDuration {
    String name;
    int month;

    public void setName(String name) {
        this.name = name;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "LongestProjectDuration{" +
                "name='" + name + '\'' +
                ", month=" + month +
                '}';
    }
}
