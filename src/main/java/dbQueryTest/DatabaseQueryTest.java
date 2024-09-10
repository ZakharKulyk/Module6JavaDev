package dbQueryTest;



import dbDto.*;
import dbServices.DatabaseQueryService;

import java.util.List;

public class DatabaseQueryTest {

    public static void main(String[] args) {
        DatabaseQueryService service = new DatabaseQueryService();

        List<HighestPayedWorker> maxSalaryWorker = service.findMaxSalaryWorker();
        maxSalaryWorker.forEach(System.out::println);

        System.out.println("________");

        List<MaxProjectCountClient> maxProjectCountClient = service.findMaxProjectCountClient();
        maxProjectCountClient.forEach(System.out::println);

        System.out.println("________");

        List<LongestProjectDuration> longestProject = service.findLongestProject();
        longestProject.forEach(System.out::println);

        System.out.println("________");

        List<YoungestAndEldestWorker> youngestAndOldestWorkers = service.findYoungestAndOldestWorkers();
        youngestAndOldestWorkers.forEach(System.out::println);

        System.out.println("________");

        List<AllProjectsCost> allProjectsCosts = service.showProjectsCost();
        allProjectsCosts.stream().forEach(System.out::println);


    }

}
