public class Card {
    private String number;
    private String desc;
    private String type;
    private String color;
    private String suit;
    private String rank;
    private String coloredText;
    public Card(String number, String type, String desc) {
        this.number = number;
        this.type = type;
        this.desc = desc;
        setSuit();
        setColor();
        setRank();
    }

    private void setColor() {
        if(this.type == "Heart" || this.type == "Square") {
            this.color = "Red";
            this.coloredText = "\033[31m";
        }else if(this.type == "Clove" || this.type == "Spade") {
            this.color = "Black";
            this.coloredText = "\033[30m";
        }
    }

    private void setSuit() {
        if(this.type == "Heart") {
            this.suit = "♥";
        }else if(this.type == "Square") {
            this.suit = "♦";
        }else if(this.type == "Clove") {
            this.suit = "♣";
        }else if(this.type == "Spade") {
            this.suit = "♠";
        }
    }

    public void setRank() {
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        this.rank = ranks[Integer.parseInt(this.number) - 1];
    }

    public String getNumber() {
        return this.number;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    public String getSuit() {
        return this.suit;
    }

    public String getRank() {
        return this.rank;
    }

    public String getColoredText() {
        return this.coloredText;
    }
}
