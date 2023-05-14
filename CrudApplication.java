package crud_operation;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudApplication 
{
	 static ArrayList<User> users = new ArrayList<>();

	    public static void createUser() 
	    {
	    	Scanner s1 = new Scanner(System.in);
	        System.out.print("Enter user ID: ");
	        int id = s1.nextInt();

	        System.out.print("Enter user name: ");
	        String name = s1.next();
	        
	        System.out.print("Enter user email id: ");
	        String email=s1.next();

	        User u = new User(id,name,email);
	        users.add(u);

	        System.out.println("User created successfully...\n");
	    }

	    public static void readUser() 
	    {
	        Scanner s1 = new Scanner(System.in);

	        System.out.print("Enter user ID: ");
	        int id = s1.nextInt();

	        User u = userById(id);

	        if (u != null) {
	            System.out.println("User found:\n"+u);
	        } 
	        else 
	        {
	            System.out.println("User not found.\n");
	        }
	    }

	    public static void updateUser() {
	        Scanner s1 = new Scanner(System.in);

	        System.out.print("--------\nEnter user ID: ");
	        int id = s1.nextInt();

	        User u = userById(id);

	        if (u != null) {
	            System.out.println("Current user information: \n"+u);
                System.out.print("\n1. Name \n2. Email id \nEnter your choice to update:");
                int s=s1.nextInt();
                switch(s)
                {
                case 1:{
                	System.out.print("Enter new user name: ");
     	            String name = s1.next();
     	            if (name.trim().length() > 0) 
     	            {
     	                u.setName(name);
     	            }
     	            System.out.println("User updated successfully....\n");
     	            break;
     	            }
                case 2:{
                	System.out.print("Enter new user Email id: ");
     	            String em = s1.next();
     	            if (em.trim().length() > 0) {
     	                u.setEmail(em);
     	            }
     	            System.out.println("User updated successfully....\n");
     	            break;
                }
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                }
	        } else {
	            System.out.println("User not found.\n");
	        }
	    }

	    public static void deleteUser() 
	    {
	        Scanner s1 = new Scanner(System.in);

	        System.out.print("Enter user ID: ");
	        int id = s1.nextInt();
	        User u = userById(id);
	        if (u != null) {
	            users.remove(u);
	            System.out.println("User deleted successfully....\n");
	        } else {
	            System.out.println("User not found.\n");
	        }
	    }

	    public static void listAllUsers() 
	    {
	        System.out.println("List of all users:");
	        for (User u : users) {
	            System.out.println(u);
	        }
	    }

	    public static User userById(int id) 
	    {
	        for (User u : users) {
	            if (u.getId() == id) {
	                return u;
	            }
	        }
	        return null;
	    }
	    
 public static void main(String[] args) {
	    	
	        Scanner scanner = new Scanner(System.in);
	        boolean exit = true;
	        while (exit) {
	            System.out.println("Welcome to User CRUD Application! \n1. Create User \n2. Read User \n3. Update User \n4. Delete User \n5. List All Users \n6. Exit");

	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    createUser();
	                    break;
	                case 2:
	                    readUser();
	                    break;
	                case 3:
	                    updateUser();
	                    break;
	                case 4:
	                    deleteUser();
	                    break;
	                case 5:
	                    listAllUsers();
	                    break;
	                case 6:
	                    System.out.println("Exiting User CRUD Application...");
	                    exit=false;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.\n");
	            }
	        }
	    }
	}

class User 
{
	    private int id;
	    private String name;
	    private String email;
	    
	    public int getId()
	    {
	    	return id;
	    }
	    public void setId()
	    {
	    	this.id = id;
	    }
	    
	    public String getName()
	    {
	    	return name;
	    }
	    public void setName(String name)
	    {
	    	this.name=name;
	    }
	    
	    public String getEmail()
	    {
	    	return email;
	    }
	    public void setEmail(String email)
	    {
	    	this.email=email;
	    }
	    
	    public String toString()
	    {
	    	return "Id: "+id+"\nName: "+name+"\nEmail: "+email+"\n-------";
	    }
	    
	    public User(int id, String name, String email) 
	    {
	        this.id = id;
	        this.name= name;
	        this.email= email;
	    }
}
	        
