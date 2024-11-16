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
		sc.nextLine();
		return choice;	
	}
	
	public static void addCar(Car[] carList) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean full = true, validid = false, repeat = false;
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
			
			do {
				
				System.out.println("Enter new car ID: ");
				newid = sc.nextInt();
				sc.nextLine();
				
				repeat = false;
				
				for (int k = 0; k < carList.length; k++) {
					if (carList[k] != null && newid == carList[k].getId()) {
						repeat = true;
						System.out.println("This ID already exists");
						break;
					}
				}
			} while(repeat);
			
			System.out.println("Enter new car service fee: ");
			newfee = sc.nextDouble();
			sc.nextLine();
			
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
		
		Car editcar = null;
		String editname = "";
		int editcarid = 0, editparam = 0, editid;
		double editfee = 0;
		boolean found = false;
		
		while (!found) {
			System.out.println("Enter car ID: ");
			editcarid = sc.nextInt();
			
			for (int i = 0; i < carList.length; i++) {
				if (carList[i] != null && editcarid == carList[i].getId()) {
					editcar = carList[i];
					found = true;
				}
			}
			
			if (!found) {
				System.out.println("Not found, enter again");
			}
		}
		
		if (found) {
			System.out.println("The selected car:");
			editcar.printme();
			System.out.println("Select parameter to edit: ");
			System.out.println("1. Car name");
			System.out.println("2. Car ID");
			System.out.println("3. Car service fee");
			System.out.println("Enter selection: ");
			editparam = sc.nextInt();
			sc.nextLine();
		}
		
		if (editparam == 1) {
			System.out.println("Enter the new car name: ");
			editname = sc.nextLine();
			editcar.setName(editname);
		} else if (editparam == 2) {
			System.out.println("Enter the new car ID: ");
			editid = sc.nextInt();
			sc.nextLine();
			editcar.setId(editid);
		} else if (editparam == 3) {
			editfee = sc.nextDouble();
			sc.nextLine();
			editcar.setFee(editfee);
		}
		
		System.out.println("Updated car details:");
		editcar.printme();
	}

  public static void expensiveFixes(Car[] carList) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter specified price: ");
    double price = sc.nextDouble();
    
    for (int i = 0; i < carList.length; i++) {
    	if (carList[i] != null && carList[i].getFee() > price) {
    		carList[i].printme();
    	}
    }
    
  }

	public static void displayProfit(Car[] inventory) {
		DecimalFormat f = new DecimalFormat("0.00");
		double total = 0;
		for (int i = 0; i < inventory.length; i ++) {
			if (inventory[i]!= null) total += inventory[i].getFee();
		}
		System.out.println("Your expected profit from fixing all the cars is $" + f.format(total));
	}

}
