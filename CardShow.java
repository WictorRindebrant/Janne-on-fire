public class CardShow {
    public void showCard(Card card) {
        System.out.println("┌─────────┐");
        System.out.printf("│ %-2s      │\n", card.getRank()); // Top-left rank
        System.out.printf("│ %-2s      │\n", card.getSuit()); // Suit in the center
        System.out.println("│         │");
        System.out.println("│         │");
        System.out.printf("│      %2s │\n", card.getSuit()); // Bottom-right rank
        System.out.printf("│      %2s │\n", card.getRank()); // Bottom-right rank
        System.out.println("└─────────┘" + "\033[0m");
        System.out.println("Card Desc: " + card.getDesc());
    }
}
