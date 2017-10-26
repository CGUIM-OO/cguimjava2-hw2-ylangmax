import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: B0544243 鄒涵如
 * Try to write some comments for your codes (methods, 15 points)
 * 先從Class Card開始，依序將Card中的suit and rank用if else判斷印成文字。 
 * 再來Class Deck，由nDeck知道到使用者需要幾副牌，用for迴圈依序產生需要幾副牌、花色、號碼，實體化後放入cards (Arraylist)，
 * 在printDeck中，運用Enhanced for loop依序將cards裡的卡印出來。
 * and then done.
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
	
		deck.printDeck();
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: 由nDeck知道到使用者需要幾副牌，用for迴圈依序產生需要幾副牌、花色、號碼，
 * 實體化後放入cards (Arraylist)，在printDeck中，運用Enhanced for loop依序將cards裡的卡印出來。
 * 
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int n=0;n<nDeck;n++){
			for(int s=1;s<5;s++){
				for(int r=1;r<14;r++){
					Card card=new Card(s,r);
					cards.add(card);
				}
			}
		}

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		for(Card card:cards){
			card.printCard();
		}

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: printCard getSuit getRank等功能在Card裡，printCard中寫入判斷花色與AKQJ;
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		if(suit==1){
			System.out.print("Clubs");
		}
		else if(suit==2){
			System.out.print("Diamonds");
		}
		else if(suit==3){
			System.out.print("Hearts");
		}
		else if(suit==4){
			System.out.print("Spades");
		}
		if(rank==1){
			System.out.println(" Ace");
		}
		else if(rank==13){
			System.out.println(" King");
		}
		else if(rank==12){
			System.out.println(" Queen");
		}
		else if(rank==11){
			System.out.println(" Jack");
		}
		else
		System.out.println(" "+rank);
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
