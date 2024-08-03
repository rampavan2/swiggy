public class Main {
    public static void main(String[] args) {
        System.out.println("=============> Magical Arena <=============");
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        MagicalArena match = new MagicalArena(playerA, playerB);
        match.start();
    }
}
