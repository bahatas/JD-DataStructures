package streamexamples;

import lombok.SneakyThrows;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Questions {
    public static void main(String[] args) {

        List<Product> res = new ArrayList<>();
        res.add(new Product(1l, "pr1", "Baby", 100.00));
        res.add(new Product(2l, "pr2", "Books", 150.00));
        res.add(new Product(4l, "pr4", "Books", 330.00));
        res.add(new Product(3l, "pr3", "Baby", 15.00));
        Questions q = new Questions();
        q.summaryStatistics(res);
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

    /**
     * The traditional way is to create a for-loop to sum up the salary of each employee
     * and then calculate the average by dividing the total sum by number of record.
     */

    public double calculateAverage(List<Employee> employeeList) {
        int salary = 0;
        for (Employee employee : employeeList) {
            salary += employee.getSalary();
        }
        return (double) salary / employeeList.size();
    }


    /**
     * STREAM SOLUTION
     */
    public double calculateAverage2(List<Employee> employeeList) {

        return employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }


    /**
     * Exercise 1 — Obtain a list of products belongs to category “Books” with price > 100
     * This is obviously a filtering logic, the output should fulfill the two filtering requirements. So, you can apply 2 filter() operations to obtain the result.
     */
    List<Product> getListOfProducts(List<Product> list) {
        return list.stream()
                .filter(e -> e.getCategory().equalsIgnoreCase("Books"))
                .filter(e -> e.getPrice() > 100)
                .collect(Collectors.toList());
    }


    /**
     * Exercise 2 — Obtain a list of order with products belong to category “Baby”
     * <p>
     * anyMatch method returns boolean to be able to use filter
     */

    List<Order> getListOfProductsBabayCat(List<Order> orderList) {

        return orderList.stream()
                .filter(p -> p.getProducts().stream()
                        .anyMatch(c -> c.getCategory().equalsIgnoreCase("Baby")))
                .collect(Collectors.toList());
    }

    /**
     * Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount
     */

    List<Product> discountListOfProducts(List<Product> list, double discountRate) {
//        discountRate = 10.00;
        list = Product.findAll();
        return list.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
                .map(product -> product.withPrice(product.getPrice() * (100 - discountRate) / 100))
                .collect(Collectors.toList());
    }


    /**
     * Exercise 4 — Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
     * <p>
     * This exercise illustrates the usage of flatMap(). You can firstly start from an order list and then filter the list by customer tier and order date
     * . Next, get the product list from each order record and use flatMap() to emit product records into the stream.
     * For example, if we have 3 order records and each order contains 10 products, then flatMap() will emit 10 data elements for each order record,
     * resulting in 30 (3 x 10) product record output in the stream.
     * <p>
     * Since product list would contain duplicated product records if multiple orders would include the same product.
     * In order to generate a unique product list, applying distinct() operation can help to produce the unique list.
     */
    List<Product> getListOfProductsdates(List<Order> orderList) {

        return orderList.stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(order -> order.getOrderDate().isBefore(LocalDate.of(2021, 04, 1)))
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }


    /**
     * Exercise 5 — Get the cheapest products of “Books” category
     * one of the effective ways to obtain the product with the lowest price is to sort the product list by price in
     * an ascending order and get the first element. Java Stream API provides sorted() operation for stream data
     * sorting based on specific field attributes.
     * In order to obtain the first element in the stream, you can use the terminal operation findFirst().
     * The operation returns the first data element wrapped by Optional as it is possible that the output stream can be empty.
     * <p>
     * This solution can only return a single product record with the lowest price.
     * If there are multiple product records with the same lowest price,
     * the solution should be modified such that it looks for the lowest price amount
     * first and then filters product records by the price amount so as to get a list of products with the same lowest price.
     */
    @SneakyThrows
    Product getListOfcheapProduct(List<Product> list) {

        if (list.isEmpty()) throw new Exception("There are no product yet");
        return list.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .sorted(Comparator.comparing(product -> product.getPrice()))
                .findFirst().get();
    }

    //updated with usage of min instead of sorting
    Optional<Product> getListOfcheapProduct2(List<Product> list) {

        return list.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .min(Comparator.comparing(product -> product.getPrice()));
    }

    /**
     * Exercise 6 — Get the 3 most recent placed order
     * Similar to previous exercise, the obvious solution is to sort the order records by order date field.
     * The tricky part is that the sorting this time should be in descending order such that you can obtain
     * the order records with the most recent order date.
     * <p>
     * It can be achieved simply by calling Comparator.reversed().
     */
    List<Order> getMostRecentOrderList(List<Order> orderList) {

        return orderList.stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .collect(Collectors.toList());

    }

    /**
     * Exercise 7 — Get a list of orders which were ordered on 15-Mar-2021,
     * log the order records to the console and then return its product list
     * <p>
     * You can see that this exercise involves two actions —
     * (1) write order records to the console and (2) produce a list of products.
     * Generating different output from a stream is not possible,
     * how can we fulfill this requirement? Apart from running the stream flow twice,
     * operation peek() allows execution of system logic as part of a stream flow.
     * The sample solution runs peek() to write order records to the console right after data filtering,
     * then subsequent operations such as flatMap() will be executed for the output of product records.
     */
    List<Product> logOrdersOnDate(List<Order> orderList, LocalDate date) {

//        date=LocalDate.of(2021,3,15); this line cause an error for lamba op
        return orderList.stream()
                .filter(order -> order.getOrderDate().isEqual(date))
                .peek(order -> {
                    System.out.println(order.toString());
                })
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Exercise 8 — Calculate total lump sum of all orders placed in Feb 2021
     * <p>
     * All previous exercise was to output a record list by a terminal operation,
     * let’s do some calculation this time. This exercise is to sum up all the products ordered in Feb 2021.
     * As you’ve gone through previous exercises,
     * you can easily obtain the list of products using filter() and flatMap() operations.
     * Next, you can make use of mapToDouble()
     * operation to convert the stream into a stream of data type Double by specifying the price field as the mapping value.
     * At last, terminal operation sum() will help you add up all values and return the total value.
     */

    double totalLumpSumOfOrdersOnDate(List<Order> orderList, LocalDate date) {
        return orderList.stream()
                .filter(order -> order.getOrderDate().isEqual(date))
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(product -> product.getPrice())
                .sum();

    }


    /**
     * Exercise 9 — Calculate order average payment placed on 14-Mar-2021
     * <p>
     * In addition to total sum, stream API offers operation for average value calculation as well.
     * You might find that the return data type is different from sum()
     * as it is an Optional data type. The reason is that the data stream would be empty
     * and so calculation won’t output an average value for a empty data stream.
     */

    double avarageLumpSumOfOrdersOnDate(List<Order> orderList, LocalDate date) {

        return orderList.stream()
                .filter(order -> order.getOrderDate().isEqual(date))
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .average().getAsDouble();
    }

    /**
     * Exercise 10 — Obtain a collection of statistic figures
     * (i.e. sum, average, max, min, count) for all products of category “Books”
     * <p>
     * What if you need to get sum, average, max, min and count at the same time?
     * Should we run the data stream 5 times to get those figures one by one?
     * Such an approach is not quite effective.
     * Luckily, stream API provides a convenient
     * way to get all those values at once by using terminal operation summaryStatistics().
     * <p>
     * It returns a data type DoubleSummaryStatistics which contains all the required figures.
     */

    DoubleSummaryStatistics summaryStatistics(List<Product> list) {

        DoubleSummaryStatistics statistics = list.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .mapToDouble(book -> book.getPrice())
                .summaryStatistics();

        System.out.println(String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f",
                statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum()));


        return statistics;


    }


    /**
     * Exercise 11 — Obtain a data map with order id and order’s product count
     * <p>
     * Except for value calculation, all previous exercises just output a record list.
     * The helper class Collectors provide a number of useful operations for data consolidation
     * and data collection output.
     * Let’s check out the exercise to create a data map with order id as the key
     * while the associated value is product count.
     * The terminal operation Collectors.toMap() accepts two arguments
     * for your specify the key and value respectively.
     */

    Map<Long, Integer> getIdAndCount(List<Order> list) {
        return list.stream()
                .collect(
                        Collectors.toMap(
                                order -> order.getId(),
                                order -> order.getProducts().size())
                );
    }

    /**
     * Exercise 12 — Produce a data map with order records grouped by customer
     * This exercise is to consolidate a list of orders by customer.
     * Collectors.groupingBy() is a handy function,
     * you can just simply specify what is the key data element,
     * it will then aggregate data for you.
     */

    Map<Customer, List<Order>> getOrderListOfAllCostumers(List<Order> list) {
        return list.stream()
                .collect(
                        Collectors.groupingBy(order -> order.getCustomer())
                );
    }

    /**
     * Exercise 13 — Produce a data map with order record and product total sum
     * <p>
     * The data map output this time is not a simple extraction of data fields from the stream,
     * you need to create a sub-stream for each order in order to calculate the product total sum.
     * Since, the key element is the order record itself instead of an order id,
     * so Function.identity() is used to tell Collectors.toMap() to use the data element as the key.
     */

    Map<Order, Double> getOrderAndProductTotalSum(List<Order> list) {

        return list.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        order -> order.getProducts().stream().mapToDouble(Product::getPrice).sum()
                ));
    }


    /**
     * Exercise 14 — Obtain a data map with list of product name by category
     *
     * This exercise helps you get familiar with the way to transform the data output of data map entries.
     * If you only use Collectors.groupingBy(Product::getCategory),
     * then the output will be Map<Category, List of Products>
     *     but the expected output should be Map<Category, List of Product Name>.
     *     You can use Collectors.mapping() to convert product objects
     *     to product names for the data map construction.
     */

    Map<String,List<String>> getAllProductsByCategory(List<Product> list){

       return list.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getName,Collectors.toList())
                ));
    }

    /**
     * Exercise 15 — Get the most expensive product by category
     *
     * Similar to data transformation using Collectors.mapping(),
     * Collectors.maxBy() helps to obtain the record with max value as part of data map construction.
     * By providing a comparator for product price,
     * maxBy() is able to get the product with the largest value for each category.
     * @return
     */

    Map<String, Optional<Product>> getTheMostExpensiveProductByCategory(List<Product> list){

       return list.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparing(Product::getPrice))));

    }
}