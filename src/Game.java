
public class Game {
	private static int bookPlayer;
	private static int bookComputer;
	
	public Game() {
		bookPlayer=0;
		bookComputer=0;
	}
	
	//display method
	public void display(SingleLinkedList player,SingleLinkedList table,SingleLinkedList computer,int turn) {
		System.out.println("-------------------- TURN "+ turn+" --------------------");
		System.out.print("Player: ");
		player.display();
		System.out.print("                            book: "+this.bookPlayer);
		System.out.print("                                                         Table: ");
		table.display();
		System.out.println();
		System.out.print("Computer: ");
		computer.display();
		System.out.print("                            book: "+this.bookComputer);
	}
	//display method
	
	//control book method for player
	public void controlScorePlayer(SingleLinkedList player,SingleLinkedList temp) {
		//controlling player
		int bookCount=0;
		for (int i = 0; i < 6; i++) {//loop continues for every card(1,2,3,4,5) and counts this cards number
			bookCount=0;
			int playerSize=player.size();
			for (int j = 0; j < playerSize; j++) {
				if(player.search(i+1)) {
					bookCount++;
					player.delete(i+1);
					temp.add(i+1);
				}
			}
			if(bookCount==4) {//if there are 4 same numbers
				for(int j=0;j<4;j++) {
					temp.delete(i+1);//these cards are deleted
				}
				this.bookPlayer++;//player gain book score
			}
		}
		for (int i = 0; i < 6; i++) {//re-initialize player cards
			int tempSize=temp.size();
			for (int j = 0; j < tempSize; j++) {
				if(temp.search(i+1)) {
					player.add(i+1);
					temp.delete(i+1);
				}
			}
		}
		//controlling player
	}
	//control book method for player
	
	//control book method for computer
	public void controlScoreComputer(SingleLinkedList computer,SingleLinkedList temp) {
		//controlling computer
				int bookCount1=0;
				for (int i = 0; i < 6; i++) {//loop continues for every card(1,2,3,4,5) and counts this cards number
					bookCount1=0;
					int computerSize=computer.size();
					for (int j = 0; j < computerSize; j++) {
						if(computer.search(i+1)) {
							bookCount1++;
							computer.delete(i+1);
							temp.add(i+1);
						}
					}
					if(bookCount1==4) {//if there are 4 same numbers
						for(int j=0;j<4;j++) {
							temp.delete(i+1);//these cards are deleted
						}
						this.bookComputer++;//player gain book score
					}
				}
				for (int i = 0; i < 6; i++) {//re-initialize player cards
					int tempSize=temp.size();
					for (int j = 0; j < tempSize; j++) {
						if(temp.search(i+1)) {
							computer.add(i+1);
							temp.delete(i+1);
						}
					}
				}
				//controlling computer
	}
	//control book method for computer
	
	//initialize the cards method
	public void initializeCards(SingleLinkedList player,SingleLinkedList table,SingleLinkedList computer) {
		
		//cards are added into table.
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				table.add(i+1);
			}
		}
		//cards are added into table.
		
		//cards are added into player from table randomly
		for (int i = 0; i < 7; i++) {
			int random=(int)(Math.random()*6)+1;
			if(table.search(random)) {
				player.add(random);
				table.delete(random);
			}
			else {
				i--;//if random number does not exist in table, loop turns again
			}
		}
		//cards are added into player from table randomly
		
		//cards are added into computer from table randomly
		for (int i = 0; i < 7; i++) {
			int random=(int)(Math.random()*6)+1;
			if(table.search(random)) {
				computer.add(random);
				table.delete(random);
			}
			else {
				i--;
			}
		}
		//cards are added into player from table randomly
	}
	//initialize the cards method

	/**
	 * @return the bookPlayer
	 */
	public static int getBookPlayer() {
		return bookPlayer;
	}

	/**
	 * @param bookPlayer the bookPlayer to set
	 */
	public static void setBookPlayer(int bookPlayer) {
		Game.bookPlayer = bookPlayer;
	}

	/**
	 * @return the bookComputer
	 */
	public static int getBookComputer() {
		return bookComputer;
	}

	/**
	 * @param bookComputer the bookComputer to set
	 */
	public static void setBookComputer(int bookComputer) {
		Game.bookComputer = bookComputer;
	}
	
}
