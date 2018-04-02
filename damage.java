import java.util.Scanner;

public class damage
{
	public static void main(String[] args)
	{
		boolean gamerunning = true;
		boolean block, critical;
		int health=1000,maxhealth=1000,trollhealth=600,trollmax=600,damage,numaction;

		Scanner kb = new Scanner(System.in);

		System.out.println("You encounter a troll warrior!");

		while(gamerunning)
		{
			System.out.println("\nThe troll's health is " + trollhealth + "/" + trollmax + ".");
			System.out.println("Your health is " + health + "/" + maxhealth + ".");
			block = false;
			System.out.println("Commands: Attack, Heal, Block.");
			String action = kb.nextLine().toUpperCase();

			if(action.equals("ATTACK")){
				numaction = 1;
			}else if(action.equals("HEAL")){
				numaction = 2;
			}else if(action.equals("BLOCK")){
				numaction = 3;
			}else{
				numaction = 4;
			}

			switch(numaction){
				case 1: System.out.println("\nYou leap at the troll and make a vicious sweep with your sword!");
						damage = (int)(Math.random()*99);
						critical = crit();
						if(critical)
						{
							System.out.println("CRITICAL!");
							trollhealth -= (2*damage);
							System.out.println("The troll warrior is marred by a whopping " + (2*damage) + " damage!");
						}else{
							trollhealth -= damage;
							System.out.println("The troll warrior suffers " + damage + " damage!");
						}
						break;
				case 2: System.out.println("\nYou uncork your flask of mead and begin to drink!");
						damage = (int)(Math.random()*110);
						health += damage;
						if(health > maxhealth)
							health = maxhealth;
						System.out.println("You heal for " + damage + "!");
						break;
				case 3: System.out.println("\nYou raise your shield and brace for the attack.");
						block = true;
						break;
				default: System.out.println("\nYou started to daydream!");
						break;
			}

			if(trollhealth<150)
			{
				System.out.println("\nThe troll is in a battle frenzy!");
				damage = (int)(Math.random()*300);
				if(block)
				{
					damage = (int)(damage/2);
					health -= damage;
					System.out.println("This blow would have been worse without your shield! You suffer " + damage + " damage!");
				}else{
					health -= damage;
					System.out.println("You suffer a terrible blow! You recieve " + damage + " damage!");
				}
			}else{
				System.out.println("\nThe troll swings his mighty club!");
				damage = (int)(Math.random()*130);
				if(block)
				{
					damage = (int)(damage/2);
					health -= damage;
					System.out.println("The troll's attack hardly leaves a scratch! You take " + damage + " damage!");
				}else{
					health -=damage;
					System.out.println("You are hit by the broad side of his club! You suffer " + damage + " damage!");
				}
			}

			if(trollhealth <= 0)
			{
				gamerunning = false;
				System.out.println("\nThe troll falls to your sword with a scream!");
				System.out.println("You are victorious!");
			}else if(health <= 0)
			{
				gamerunning = false;
				System.out.println("\nYour wounds are too deep for you to continue fighting.");
				System.out.println("You fall to the floor, dead. Before you pass into the next life you hear the troll's triumphant yelling.");
			}

		}
	}



	public static boolean crit()
	{
		int crit = 195,chance;
		chance = (int)(Math.random()*1000);
		if(crit>chance)
		{
			return true;
		}else{
			return false;
		}
		
	}
}
