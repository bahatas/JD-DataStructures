package streamexamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Questions {
    public static void main(String[] args) {

    }

    /**
     *
     * the task is to group an array of employee records into a data map organized by job title.
     * Here is a traditional way to loop through the list and construct a data map.
     *
     * TRADITIONAL SOLUTION
     */

    public Map<String, List<Employee>> groupByTitle(List<Employee> employeeList) {

        Map<String, List<Employee>> resultMap = new HashMap<>();

        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            List<Employee> subEmployeeList = resultMap.getOrDefault(employee.getTitle(), new ArrayList<Employee>());
            subEmployeeList.add(employee);
            resultMap.put(employee.getTitle(), subEmployeeList);
        }
        return resultMap;

    }

    /**
     * STREAM SOLUTION
     */
    public Map<String, List<Employee>> groupByTitle2(List<Employee> employeeList) {

        return employeeList.stream().collect(Collectors.groupingBy(ee -> ee.getTitle()));
    }
}