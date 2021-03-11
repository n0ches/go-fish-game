import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//initializing of linked lists
		Scanner sc=new Scanner(System.in);
		SingleLinkedList player=new SingleLinkedList();
		SingleLinkedList computer=new SingleLinkedList();
		SingleLinkedList table=new SingleLinkedList();
		SingleLinkedList temp=new SingleLinkedList();//this linked list used for computer's asked card. Computer should ask for the card that needs it the most.
		SingleLinkedList tempPlayer=new SingleLinkedList();//for the book control of player
		SingleLinkedList tempComputer=new SingleLinkedList();//for the book control of computer
		//initializing of linked lists
		int turn=1;//turn variable
		Game myGame=new Game();//calling game class
		myGame.initializeCards(player, table, computer);//assigning numbers to cards
		myGame.display(player, table, computer, turn);//displaying
		
		//do-while loop for the game loop
		do {
			boolean goFishFlag=true;//flag for go fish statement. if it is true, player asks the card. if it is not true, computer asks
			//player asks
			while(goFishFlag &&player.size()!=0 &&table.size()!=0&&computer.size()!=0) {
		
				//taking input and take card
				System.out.print("\nYour ask: ");
				int input=sc.nextInt();
				if(player.search(input)) { //controlling for the cards in player according to input
					if(computer.search(input)) {
						player.add(input);//player gain the card
						computer.delete(input);//computer lose the card
						turn++;
					}
					else {
						System.out.println("Computer says 'Go Fish'");//go fish statement
						while(goFishFlag) {//this loop continues until gofish flag returns false
							int random=(int)(Math.random()*6)+1;//random card number
							if(table.search(random)) {//controlling for the cards in table according to random
								player.add(random);//player gain card
								table.delete(random);//table lose the card
								goFishFlag=false;//gofish return false
								turn++;
							}
						}
					}
					//controlling book for  player
					myGame.controlScorePlayer(player, tempPlayer);
					//controlling book for player
					
					//display
					myGame.display(player, table, computer, turn);
					//display
				}
				else {
					System.out.println("You can't ask that card becaue you don't have it!");
					goFishFlag=false;
				}
			}
			//player asks
			
			//computer asks
			while(!goFishFlag&&player.size()!=0 &&table.size()!=0&&computer.size()!=0) {
			
				//computer asks the card that needs it the most
				int random=0;
				int randomReal=0;
				int randCount=0;
			
					//in this loop, program looks the computer cards  and determines the computer's most needed card.
					for (int i = 0; i < 6; i++) {
						int numberCount=0;	//loop continues for every card(1,2,3,4,5) and counts this cards number
						int computerSize=computer.size();
						for (int j = 0; j < computerSize; j++) {
							if(computer.search(i+1)) { 
								numberCount++;
								computer.delete(i+1);
								temp.add(i+1);
								}
						}	
						if(numberCount>randCount) {//if any card's number more than another one new number that asked by computer, asked number will be it
							randCount=numberCount;
							randomReal=i+1;
						}
					
						
							int tempSize=temp.size();
							for (int m = 0; m < tempSize; m++) {//re-initialize for computer card.
								if(temp.search(i+1)) {
									computer.add(i+1);
									temp.delete(i+1);
								}
							}
					
					
					}
					//in this loop, program looks the computer cards  and determines the computer's most needed card.
					random=randomReal;//computer asks most needed card.
					//computer asks the card that needs it the most
					
					//same taking card operation as player for computer
					System.out.print("\nComputer asks: ");
					System.out.print(random);
					if(computer.search(random)) {
						if(player.search(random)) {
							computer.add(random);
							player.delete(random);
							turn++;
						}
						else {
							System.out.println("\nPlayer says 'Go Fish'");
							while(!goFishFlag) {
								int random1=(int)(Math.random()*6)+1;
								if(table.search(random1)) {
									computer.add(random1);
									table.delete(random1);
									goFishFlag=true;
									turn++;
								}
							}
						}
						//same taking card operation as player for computer
						
						//controlling book for computer
						myGame.controlScoreComputer(computer, tempComputer);
						System.out.println();
						//display
						myGame.display(player, table, computer, turn);
					}
				
				
			}
		}while(player.size()!=0 && computer.size()!=0 && table.size()!=0);
		//do-while loop for the game loop
		
	//determining the winning player
	System.out.println();
	System.out.println("-------------------------------------------------------");
	if(myGame.getBookPlayer()>myGame.getBookComputer()) {
		System.out.println("Game is over!");
		System.out.println("You win the game!");
	}
	else if(myGame.getBookPlayer()<myGame.getBookComputer()) {
		System.out.println("Game is over!");
		System.out.println("Computer wins the game!");
	}
	else {
		System.out.println("Game is over without any winner!");
	}
	//determining the winning player
}
	
}


