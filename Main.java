import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        CardCreator creator = new CardCreator();
        CardDeck deck = creator.createDeck();

        menu(deck);
    }


    public static void menu(CardDeck deck) {
        CardShow cardShow = new CardShow();
        String[] clear_command = {"cmd.exe", "/c", ""};
        if(checkShell() == "Linux" || checkShell() == "Mac") {
            clear_command[2] = "clear && chcp 65001 > NUL";
        } else {
            clear_command[2] = "cls && chcp 65001 > NUL";
        }

        ArrayList<String> players = new ArrayList<>();
        int choice;

        while (true) {
            exec_console_command(clear_command);
            // Display menu options
            System.out.println("=== Card Game Menu ===");
            System.out.println("1. Start New Game");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // Get user input
            choice = scanner.nextInt();

            // Handle user input
            switch (choice) {
                case 1:
                exec_console_command(clear_command);
                    System.out.println("Enter the number of players (1 - 10):");
                    int playerAmount = scanner.nextInt();
                    exec_console_command(clear_command);
                    for(int i = 0; i < playerAmount; i++) {
                        System.out.println("Enter the name of player" + (i + 1) + ":");
                        String player = scanner.next();
                        System.out.println();
                        players.add(player);
                    }
                    for(String player : players) {
                        System.out.println(player);
                    }

                    int cardPos = 1;
                    int playerIndex = 0;
                    scanner.nextLine();
                    exec_console_command(clear_command);
                    for(Card card : deck.getDeck()) {
                        System.out.println("Press enter to draw a card (" + cardPos + "/" + deck.getDeck().size() + ")");
                        scanner.nextLine();
                        exec_console_command(clear_command);
                        System.out.println("Player: " + players.get(playerIndex));
                        cardShow.showCard(card);
                        System.out.println();
                        cardPos++;
                        playerIndex++;
                        if(playerIndex > players.size() - 1) {
                            playerIndex = 0;
                        }
                    }
                    scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Exiting the game. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }


    public static void exec_console_command(String[] command) {
        try {
            var process = new ProcessBuilder(command).redirectOutput(ProcessBuilder.Redirect.INHERIT).start();
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String checkShell() {
        String shellPath = System.getenv("SHELL");
        String os = System.getProperty("os.name").toLowerCase();
        String shell = "";
        System.out.println(shell);

        if (shellPath != null && (shellPath.contains("bash") || shellPath.contains("zsh") || shellPath.contains("sh"))) {
            // If the shell is Git Bash, WSL, or another Unix-like shell, use "clear"
            shell = "Linux";
        } else if (os.contains("win")) {
            // For Windows systems (CMD or PowerShell), use "cls" to clear the screen
            shell = "Windows";
        } else {
            // Default for other OSes, use "clear"
            shell = "Mac";
        }
        return shell;
    }
}
