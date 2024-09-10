package dbDto;

public class AllProjectsCost {
    int projectId;
    int projectCost;

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setProjectCost(int projectCost) {
        this.projectCost = projectCost;
    }

    @Override
    public String toString() {
        return "AllProjectsCost{" +
                "projectId=" + projectId +
                ", projectCost=" + projectCost +
                '}';
    }
}
