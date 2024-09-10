package dbDto;

import java.util.Date;

public class YoungestAndEldestWorker {
    String type;
    String name;
    Date dateOfBirth;

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public String toString() {
        return "YoungestAndEldestWorker{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

