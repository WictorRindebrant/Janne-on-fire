import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CardCreator {
    public CardDeck createDeck() {
        String[] data = {};
        try {
            data = readFile("rules.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        CardDeck deck = new CardDeck();
        deck = createCards(data, deck);

        return deck;
    }

    
    private CardDeck createCards(String[] data, CardDeck deck) {

        Boolean firstTime = true;
        for(String line : data) {
            if(firstTime == true) {
                firstTime = false;
                continue;
            }
            String[] lineList = line.split(": ");
            int number = Integer.parseInt(lineList[0]);
            String type = lineList[1];
            String title = lineList[2];
            String desc = lineList[3];

            deck = createCard(number, type, title, desc, deck);
        
        }
        deck.scrambleDeck();
        return deck;
    }


    private CardDeck createCard(int number, String color, String title, String desc, CardDeck deck) {
        Card card1 = new Card("1", "", "");
        Card card2 = new Card("1", "", "");
        if(color.equals("Red")) {
            card1 = new Card(String.valueOf(number), "Heart",desc);
            card2 = new Card(String.valueOf(number), "Square",desc);
        } else if(color.equals("Black")) {
            card1 = new Card(String.valueOf(number), "Clove",desc);
            card2 = new Card(String.valueOf(number), "Spade",desc);
        }
        deck.addCard(card1);
        deck.addCard(card2);
        return deck;
    }


    public static String[] readFile(String filePath) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        String[] lines = data.split("\n");
        return lines;
    }
}
