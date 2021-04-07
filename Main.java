package javaH3;

import java.util.Scanner;

public class Main {
	
	Scanner input = new Scanner(System.in);
	
	User user = new User(0, 2, 4, 8, 0, 0, 0, 0, 0);
	
	public Main() {
		int menu = 0;
		do {
			cls();
			printMenu();
			try {
				menu = input.nextInt();
			} catch (Exception e) {
				System.out.println("You should input integer!");
			}
			if (menu == 1) craftJewelry();
			else if (menu == 2) sellJewelry();
			else if (menu == 3) sellPreciousStone();
			else if (menu == 4) goToMine();
			else if (menu == 5) checkMiningRequirements();
			else if (menu == 6) break;
			else System.out.println("You should input 1-6!");
		}while(true);
	}
	
	
	private void craftJewelry() {
		if(countStones() >= 2 && user.getMoney() >= 1) {
			System.out.println("=========================================================");
			System.out.println("Stone Collection");
			System.out.println("=========================================================");
			System.out.println("| No. | Name                     | Price                 |");
			System.out.printf("| 1.  | Gold                     | %-12f |\n", user.getGold());
			System.out.printf("| 2.  | Diamong                  | %-12f |\n", user.getDiamond());
			System.out.printf("| 3.  | Emerald                  | %-12f |\n", user.getEmerald());
			System.out.printf("| 4.  | Sapphire                 | %-12f |\n", user.getSapphire());
			System.out.printf("| 5.  | Ruby                     | %-12f |\n", user.getRuby());
			System.out.println("=========================================================");		
		}
		else {
			System.out.println("You dont have enough stones or money!");
		}
		int option1 = 0, option2 = 0;
		float stone1=0;
		float stone2=0;
		do {
			System.out.print("Choose the first stone [Exit : 0] : ");
			option1 = input.nextInt();
			if(option1 == 0) return;
			else if(option1 == 1) stone1 = user.getGold();
			else if(option1 == 2) stone1 = user.getDiamond();
			else if(option1 == 3) stone1 = user.getEmerald();
			else if(option1 == 4) stone1 = user.getSapphire();
			else if(option1 == 5) stone1 = user.getRuby();			
		}while(stone1 > user.getMoney());
		do {
			System.out.print("Choose the second stone [Exit : 0] : ");
			option2 = input.nextInt();
			if(option2 == 0) return;
			else if(option2 == 1) stone2 = user.getGold();
			else if(option2 == 2) stone2 = user.getDiamond();
			else if(option2 == 3) stone2 = user.getEmerald();
			else if(option2 == 4) stone2 = user.getSapphire();
			else if(option2 == 5) stone2 = user.getRuby();
		}while(option2 == option1 || stone2 > user.getMoney());
		System.out.println();
		System.out.println("1 X Forge cost 1$T");
		total = 0;
		printFibonacci((int)user.getMoney(), stone1, stone2);
		System.out.println("Total Money : " + user.getMoney() + " $T");
		System.out.println("How many times you want to repeat forging? (Max Price : "+ total +" ) [Exit : 0]");
		int repeat = input.nextInt();
		if(repeat == 0) return;
		if(repeat * 1 > user.getMoney()) {
			System.out.println("You dont have enough money!");
			return;
		}
		else {
			user.setMoney(user.getMoney() - (1*repeat));
			if(option1 == 1) user.setGold(0);
			else if(option1 == 2) user.setDiamond(0);
			else if(option1 == 3) user.setEmerald(0);
			else if(option1 == 4) user.setSapphire(0);
			else if(option1 == 5) user.setRuby(0);
			if(option2 == 1) user.setGold(0);
			else if(option2 == 2) user.setDiamond(0);
			else if(option2 == 3) user.setEmerald(0);
			else if(option2 == 4) user.setSapphire(0);
			else if(option2 == 5) user.setRuby(0);
			total = 0;
			printFibonacci(repeat, stone1, stone2);
			System.out.println("You get a jewelry worth " + total + " $T");
			System.out.print("Please input a name for this jewelry : ");
			String jname = input.next();
			Jewelry nj = new Jewelry(jname, (float)total);
			Jewelry.list.add(nj);
			System.out.println();
			System.out.println("Added " + jname + " to the jewelry inventory");
		}
	}
	
	private void sellJewelry() {
		if(Jewelry.list.size() > 0) {
			do {
				System.out.println("===============");
				System.out.println("Jewelry Collections");
				System.out.println("=================================================");
				System.out.printf("| %-3s | %-20s | %-16s |\n", "No.", "Name", "Price");
				System.out.println("=================================================");
				for (int i = 0; i < Jewelry.list.size(); i++) {
					System.out.printf("| %-3d | %-20s | %-16.2f |\n", i+1, Jewelry.list.get(i).getName(), Jewelry.list.get(i).getPrice());				
				}
				System.out.println("=================================================");
				System.out.println("What jewelry do you want to sell? [Exit : "+Jewelry.list.size()+1+"]");
				System.out.print("Choose : ");
				int option = input.nextInt();
				if(option > 0 && option < Jewelry.list.size()+1) {
					System.out.println("You get " + Jewelry.list.get(option-1).getPrice() + " $T profit!!");
					user.setMoney(user.getMoney() + Jewelry.list.get(option-1).getPrice());
					Jewelry.list.remove(option-1);
				}
				else {
					break;
				}	
			}while(true);
		}
	}

	private void sellPreciousStone() {
		while(true) {
			System.out.println("Price for stones per grams");
			System.out.println("+====================================");
			System.out.println("1. Gold : 3$T         | Owned : " + user.getGold() + " gr");
			System.out.println("2. Diamond : 5$T      | Owned : " + user.getDiamond()+ " gr");
			System.out.println("3. Emerald : 7$T      | Owned : " + user.getEmerald() + " gr");
			System.out.println("4. Sapphire : 10$T    | Owned : " + user.getSapphire() + " gr");
			System.out.println("5. Ruby : 13$T        | Owned : " + user.getRuby() + " gr");
			System.out.println("+====================================");
			System.out.println();
			System.out.println("What stones do you want to sell ? [Exit : 6]");
			int option=0;
			System.out.print("Choose : ");
			try {
				option = input.nextInt();
			} catch (Exception e) {
				System.out.println("You should input integer!");
			}
			if(option == 1) {
				user.setMoney(user.getMoney() + (user.getGold() * 3));
				user.setGold(0);
			}
			else if(option == 2) {
				user.setMoney(user.getMoney()+(user.getDiamond() * 5));
				user.setDiamond(0);;
			}
			else if(option == 3) {
				user.setMoney(user.getMoney() + (user.getEmerald() * 7));
				user.setEmerald(0);
			}
			else if(option == 4) {
				user.setMoney(user.getMoney() + (user.getSapphire() * 10));
				user.setSapphire(0);
			}
			else if(option == 5) {
				user.setMoney(user.getMoney() + (user.getRuby() * 13));
				user.setRuby(0);
			}
			else if(option == 6) break;
		}
	}

	private void goToMine() {
		int loop=0;
		System.out.println("How many times do you want to mine ? [exit : 0]");
		System.out.print("Input : ");
		try {
			loop = input.nextInt();			
		} catch (Exception e) {
			System.out.println("You should input integer!");
		}
		if(loop == 0) return;
		if((user.getWorker()-(1*loop)) >= 0 && (user.getDrill()-(1*loop)) >= 0 && (user.getSite()-(1*loop)) >= 0) {
			user.setWorker(user.getWorker() - (1*loop));
			user.setDrill(user.getDrill() - (1*loop));
			user.setSite(user.getSite() - (1*loop));
			user.setGold(user.getGold() + (float)((float)0.4 * (float)loop));
			user.setDiamond(user.getDiamond() + (float)((float)0.250 * (float)loop));
			user.setEmerald(user.getEmerald() + (float)((float)0.2 * (float)loop));
			user.setSapphire(user.getSapphire() + (float)((float)0.1 * (float)loop));
			user.setRuby(user.getRuby() + (float)((float)0.05 * (float)loop));
			
			System.out.println("You get " + 0.4*loop + " gr of Gold");
			System.out.println("You get " + 0.250*loop + " gr of Diamond");
			System.out.println("You get " + 0.2*loop + " gr of Emerald");
			System.out.println("You get " + 0.1*loop + " gr of Sapphire");
			System.out.println("You get " + 0.05*loop + " gr of Ruby");
			System.out.println("Already sent to the inventory");
		}
		else {
			System.out.println("You cant go mining");
		}
	}

	private void checkMiningRequirements() {
		if(user.getMoney() > 0) {
			while(true) {	
				System.out.println("Mining Requirement Durability");
				System.out.println("=============================");
				System.out.println("Worker Durability: " + user.getWorker());
				System.out.println("Drill Durability: " + user.getDrill());
				System.out.println("Site Durability: " + user.getSite());
				System.out.println();
				System.out.println(" Mining Requirements Price");
				System.out.println("==========================");
				System.out.println("1. Worker : 1$T for 2 Durability");
				System.out.println("2. Drill: 2$T for 4 Durability");
				System.out.println("3. Site : 3$T for 8 Durability");
				System.out.println("==========================");
				System.out.println("Total Money : " + user.getMoney() + "$T");
				System.out.println("What requirements do you want to increase ? [exit : 4]");
				System.out.print("Choose : ");
				int option = 0;
				try {
					option= input.nextInt();				
				} catch (Exception e) {
					System.out.println("You should input integer!");
				}
				if(option == 1 && user.getMoney() > 1) {
					user.setMoney(user.getMoney() - 1);
					user.setWorker(user.getWorker() + 2);
					System.out.println("Worker durability Increased by 2");
				}
				else if(option == 2 && user.getMoney() > 2) {
					user.setMoney(user.getMoney() - 2);
					user.setDrill(user.getDrill() + 4);
					System.out.println("Drill durability Increased by 4");
				}
				else if(option == 3 && user.getMoney() > 3) {
					user.setMoney(user.getMoney() - 3);
					user.setSite(user.getSite() + 8);
					System.out.println("Site durability Increased by 8");
				}
				else if(option == 4) break;	
				else {
					System.out.println("You dont have enough money");
				}
			}
		}
		else {
			System.out.println("You dont have enough money");
		}
	}

	private int countStones() {
		int total = 0;
		if(user.getGold() > 0) total++;
		if(user.getDiamond() > 0) total++;
		if(user.getEmerald() > 0) total++;
		if(user.getSapphire() > 0) total++;
		if(user.getRuby() > 0) total++;
		return total;
	}
	
	static float total=0;    
	static void printFibonacci(int count, float n1, float n2){    
		if(count>0){    
			total = n1 + n2;      
			printFibonacci(count-1, n2, total);    
		}    
	}
	
	private void printMenu() {
		System.out.println("Welcome to $T Mining Simulator\n");
		System.out.println("==============================");
		System.out.println("Total Money : " + user.getMoney() + "$T");
		System.out.println("==============================\n");
		System.out.println("1. Craft Jewelry");
		System.out.println("2. Sell Jewelry");
		System.out.println("3. Sell Precious Stone");
		System.out.println("4. Go to Mine");
		System.out.println("5. Check Mining Requirements");
		System.out.println("6. Exit");
		System.out.print("Choose : ");
	}
	
	private void cls() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
