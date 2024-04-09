package com.sourav.spring_jdbc;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class CRUD {
	//dependencies
	String configFile = "com/sourav/spring_jdbc/jdbc-config-file.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(configFile);
    JdbcTemplate template = (JdbcTemplate)context.getBean("template");
	Scanner in=new Scanner(System.in);
	void insert()
	{
		int id;
		String name,city;
		System.out.println("Enter the jersey number of the player");
		id=in.nextInt();
		in.nextLine(); // Consume the newline character
		System.out.println("Enter the name of the player");
		name=in.nextLine();
		System.out.println("Enter the franchise of the player");
		city=in.nextLine();
		String query = "insert into emp values(?,?,?)";
		int response = template.update(query,id,name,city);
		System.out.println(response+"row affected !");
	}
	void delete()
	{
		System.out.println("Enter the jersey number of the player:");
		int del=in.nextInt();
		String deleteQuery= "delete from emp where id=?";
		int response=template.update(deleteQuery,del);
		System.out.println(response+"row affected !");
	}
	void update() 
	{
		int id;
		String newName,newCity;
		System.out.println("Enter the jersey number of the player to be updated");
		id=in.nextInt();
		in.nextLine(); // Consume the newline character
		System.out.println("Enter the updated name of the player");
		newName=in.nextLine();
		System.out.println("Enter the updated franchise of the player");
		newCity=in.nextLine();
	    String updateQuery = "UPDATE emp SET name = ?, city = ? WHERE id = ?";
	    int response = template.update(updateQuery, newName, newCity, id);
	    System.out.println(response + " row affected !");
	}
	void displayAll() {
	    String selectQuery = "SELECT * FROM emp";
	    List<Map<String, Object>> rows = template.queryForList(selectQuery);
	    for (Map<String, Object> row : rows) {
	        int id = (int) row.get("id");
	        String name = (String) row.get("name");
	        String city = (String) row.get("city");
	        System.out.println("ID: " + id + ", Name: " + name + ", Franchise: " + city);
	    }
	}
}
