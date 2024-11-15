import java.util.*;

public class CarManagementApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Car[] carList = new Car[10];
		int c = 0;
		
		while (c != 9) {
			
			c = menu();
			
			if (c == 1) {
				addCar(carList);
			} else if (c == 2) {
				editCar(carList);
			} else if (c == 6) {
        expensiveFixes(carList);
		}
		
		if (c == 9) {
			System.out.println("Goodbye");
		}
		
		sc.close();
	}

	public static int menu() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("----------------------------------------");
		System.out.println("Menu:");
		System.out.println("1. Add a car");
		System.out.println("2. Edit a car");
		System.out.println("3. Set a specific car to fixed");
		System.out.println("4. Display all cars in inventory");
		System.out.println("5. Delete a car by ID");
		System.out.println("6. Display all cars with service costs exceeding a specified price");
		System.out.println("7. Set a specific car to not fixed");
		System.out.println("8. Display expected profit from fixing all cars");
		System.out.println("9. Exit");
		System.out.println("----------------------------------------");
		
		
		System.out.println("Select an option: ");
		int choice = sc.nextInt();
		return choice;	
	}
	
	public static void addCar(Car[] carList) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean full = true;
		String newname = "";
		int newid = 0;
		double newfee = 0;
		
		for (int i = 0; i < carList.length; i++) {
			if (carList[i] == null) {
				full = false;
			}
		}
		
		if (!full) {
			System.out.println("Enter new car name: ");
			newname = sc.nextLine();
			System.out.println("Enter new car ID: ");
			newid = sc.nextInt();
			
			while (newid == 0) {
				System.out.println("Invalid ID, enter another: ");
				newid = sc.nextInt();
			}
			
			sc.nextLine();
			
			System.out.println("Enter new car service fee: ");
			newfee = sc.nextDouble();
			
			for (int j = 0; j < carList.length; j++) {
				if (carList[j] == null) {
					carList[j] = new Car(newname, newid, false, newfee);
					break;
				}
			}
			System.out.println("Car added");
	
		} else {
			System.out.println("System is full, delete a car first");
		}
	}
	
	public static void editCar(Car[] carList) {
		
		Scanner sc = new Scanner(System.in);
		
	}

  public static void expensiveFixes(Car[] carList) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter specified price: ");
    double price = sc.nextDouble();
    
  }
}
