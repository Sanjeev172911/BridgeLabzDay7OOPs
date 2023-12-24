import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

public class DeckOfCards {
    ArrayList<Suit> suits;
    DeckOfCards(){
        suits =new ArrayList<>();
        Suit spade=new Suit("Spade");
        Suit heart=new Suit("Heart");
        Suit club=new Suit("club");
        Suit diamond=new Suit("Diamond");
        suits.add(spade);
        suits.add(heart);
        suits.add(club);
        suits.add(diamond);
    }
}


class Card{
    String value;
    String name;
    int priority;
    Card(String value,String name,int priority){
        this.value=value;
        this.name=name;
        this.priority=priority;
    }

}

class Suit{
    ArrayList<Card>suit;
    Suit(String name){
        suit=new ArrayList<>();
        for(int i=2;i<=10;i++){
            String value=i+"";
            Card card=new Card(value,name,i);
            suit.add(card);
        }

        Card colorCard=new Card("Ace",name,14);
        suit.add(colorCard);
        colorCard=new Card("King",name,13);
        suit.add(colorCard);
        colorCard=new Card("queen",name,12);
        suit.add(colorCard);
        colorCard=new Card("jack",name,11);
        suit.add(colorCard);
    }

    public void removeCard(int index){
        suit.remove(index);
    }
}

class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1,Card card2) {
        // Compare persons based on age
        return Integer.compare(card2.priority, card1.priority);
    }
}

class Player{
    int id;
    ArrayList<Card>Cards;


    Player(int id){
        this.id=id;
        Cards=new ArrayList<>();
    }

    public void addCard(Card card){
        Cards.add(card);
    }

    public void sortCards(){
        Cards.sort(new CardComparator());
    }
}

class playGame{
    public static void main(String[] args) {
        DeckOfCards allCards=new DeckOfCards();
        ArrayList<Player>players=new ArrayList<>();
        Random random=new Random();
        for(int i=0;i<4;i++){
            Player newPlayer=new Player(i);
            players.add(newPlayer);
        }

        for(int i=0;i<52;i++){
            boolean flag=true;
            while(flag){
                int suitsIndex=random.nextInt(4);

                Suit oneSuit=allCards.suits.get(suitsIndex);
                ArrayList<Card>cards=oneSuit.suit;
                int size=cards.size();

                if(size==0)continue;
                else flag=false;

                int cardIndex=random.nextInt(size);
                int playerId=i%4;
                players.get(playerId).Cards.add(cards.get(cardIndex));
                oneSuit.removeCard(cardIndex);
            }
        }

        for(int i=0;i<4;i++){
            Player player=players.get(i);
            System.out.println("-----------------Player "+i+"-----------------");
            System.out.println();

            for(Card card:player.Cards){
                System.out.println(card.value+" "+card.name);
            }
            System.out.println();
        }

        // Question 5
        System.out.println("After Arranging the Cards using Rank");

        for(int i=0;i<4;i++){
            Player player=players.get(i);
            player.sortCards();
            System.out.println("-----------------Player "+i+"-----------------");
            System.out.println();

            for(Card card:player.Cards){
                System.out.println(card.value+" "+card.name);
            }
            System.out.println();
        }
    }
}
