import java.util.Random;

public class MagicalArena {
    private String TURN;
    private Player playerA, playerB;

    public MagicalArena() {
        TURN = "";
    }

    public MagicalArena(Player playerA_, Player playerB_) {
        playerA = new Player(playerA_.health, playerA_.strength, playerA_.attack);
        playerB = new Player(playerB_.health, playerB_.strength, playerB_.attack);

        System.out.println("Player A : health " + playerA.health + ", Strength " + playerA.strength + ", Attack " + playerA.attack);
        System.out.println("Player B : health " + playerB.health + ", Strength " + playerB.strength + ", Attack " + playerB.attack);
        System.out.println();

        if (playerA.health < playerB.health) {
            TURN = "PLAYER_A";
        } else {
            TURN = "PLAYER_B";
        }
    }

    public void start() {
        int playerADiceValue, playerBDiceValue;
        System.out.println("Match Started ..");
        while (true) {
            playerADiceValue = getDiceValue();
            playerBDiceValue = getDiceValue();

            if (TURN.equals("PLAYER_A")) {
                updatePlayer(playerADiceValue, playerBDiceValue, "PLAYER_A");
                TURN = "PLAYER_B";
            } else {
                updatePlayer(playerBDiceValue, playerADiceValue, "PLAYER_B");
                TURN = "PLAYER_A";
            }

            if (playerA.health <= 0) {
                System.out.println("\nPLAYER_A's health is zero");
                break;
            }
            if (playerB.health <= 0) {
                System.out.println("\nPLAYER_B's health is zero");
                break;
            }
        }
    }

    public void updatePlayer(int attackValue, int defendValue, String turn) {
        System.out.println("\n" + turn + " Turn :");
        int diff;
        if (turn.equals("PLAYER_A")) {
            diff = Math.abs(playerA.attack * attackValue - playerB.strength * defendValue);
            playerB.health -= diff;
            System.out.println("playerA-attack " + playerA.attack + ", attack-value " + attackValue + ", playerB-strength " + playerB.strength + ", defend-value " + defendValue + ", diff " + diff);
        } else {
            diff = Math.abs(playerB.attack * attackValue - playerA.strength * defendValue);
            playerA.health -= diff;
            System.out.println("playerB-attack " + playerB.attack + ", attack-value " + attackValue + ", playerA-strength " + playerA.strength + ", defend-value " + defendValue + ", diff " + diff);
        }
        printPlayerDetails();
    }

    public int getDiceValue() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    public void printPlayerDetails() {
        System.out.println("Player A : health " + playerA.health);
        System.out.println("Player B : health " + playerB.health);
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }
}
