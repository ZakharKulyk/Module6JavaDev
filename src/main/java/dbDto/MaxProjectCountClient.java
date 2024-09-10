package dbDto;

public class MaxProjectCountClient {
    private String name;
    private int projectCount;

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
