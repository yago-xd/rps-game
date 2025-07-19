import java.util.Random;
import java.util.Scanner;
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();
    private static int win_streak;
    private static int loss_streak;
    private static int draw_streak;
    private static final String[] choices = {"rock","paper","scissors"};
    private static final String[] comments = {
            "Hmm... interesting move.",
            "Rock, paper, scissors... the eternal battle!",
            "Let’s see how this one turns out.",
            "You’re keeping me on my toes!",
            "Strategy? Luck? Who knows!",
            "This round could go either way...",
            "I’ve got a good feeling about this one.",
            "I wonder if you’re trying to trick me.",
            "It’s like we’re reading each other’s minds!",
            "Classic choice. Bold and timeless."
    };
    private static final String[] winMsg = {
            "Victory is yours! 🏆",
            "You crushed it! 💥",
            "Flawless win! 😎",
            "Outsmarted the computer! 🧠",
            "You're on fire! 🔥",
            "That was a clean win! ✨",
            "Impressive move! 🎯",
            "You’ve got the magic touch! 🪄",
            "Well played, champion! 👑",
            "Another W for the legend! 🐐"
    };
    private static final String[] lossMsg = {
            "Oof... the computer outplayed you. 🤖",
            "Tough luck! Try again? 💔",
            "Defeat... but you'll bounce back! 📉",
            "That one slipped away! 🫤",
            "You're giving the computer hope! 😅",
            "Next time, you got this! 🔄",
            "Too bad, so sad! 😢",
            "The computer is flexing! 💪🤖",
            "That strategy didn’t work... 😬",
            "Even legends fall sometimes! 🥀"
    };
    private static int cwin=0,uwin=0,draw=0,games=0;
    public static void streak(){
        if(win_streak>1)
            System.out.println("\nYou are on a win-streak of "+win_streak+" wins!");
        else if(loss_streak>1)
            System.out.println("\nYou are on a loss-streak of "+loss_streak+" losses!");
        else if(draw_streak >1){
            System.out.println("\nYou are on a draw-streak of "+ draw_streak +" drawn games");
        }
    }
    public static void welcome() {
        System.out.println("\nWelcome to the Rock Paper Scissors Game!");
        System.out.println("Type exit anytime to end the game");
    }
    public static String getUser() {
        System.out.print("\nEnter your choice (rock, paper, scissors): ");
        String input = sc.next().toLowerCase();
        while (!input.equals("rock") && !input.equals("paper") && !input.equals("scissors") && !input.equals("exit")) {
            System.out.println("Invalid choice!");
            System.out.print("Enter rock, paper or scissors: ");
            input = sc.next().toLowerCase();
        }
        return input;
    }
    public static String getComp() throws InterruptedException {
        System.out.println(comments[rand.nextInt(comments.length)]);
        Thread.sleep(2500);
        return choices[rand.nextInt(3)];
    }
    static void updateStreaks(String result) {
        switch (result) {
            case "win" -> { win_streak++; loss_streak = draw_streak = 0; }
            case "loss" -> { loss_streak++; win_streak = draw_streak = 0; }
            case "draw" -> { draw_streak++; win_streak = loss_streak = 0; }
        }
    }
    public static void play(String user,String comp){
        games++;
        System.out.println("You chose: " + user);
        System.out.println("Computer chose: " + comp + "\n");
        if(user.equals(comp)){
            System.out.println("It's a Tie!");
            draw++;
            updateStreaks("draw");
        }
        else if((user.equals("rock") && comp.equals("scissors")) ||
                (user.equals("paper") && comp.equals("rock")) ||
                (user.equals("scissors") && comp.equals("paper"))){
            System.out.println("\u001B[32mYou Win!\u001B[0m");
            System.out.println(winMsg[rand.nextInt(winMsg.length)]);
            uwin++;
            updateStreaks("win");
        }
        else{
            System.out.println("\u001B[31mYou Lost!\u001B[0m");
            System.out.println(lossMsg[rand.nextInt(lossMsg.length)]);
            cwin++;
            updateStreaks("loss");
        }
        streak();
    }
    public static void score() {
        double wp = (uwin * 100.0) / games;
        double lp = (cwin * 100.0) / games;
        double dp = (draw * 100.0) / games;
        System.out.println("\nScore: User - " + uwin + " | Computer - " + cwin);
        System.out.println("Games Played: " + games);
        System.out.printf("Win %%: %.2f%%\n", wp);
        System.out.printf("Loss %%: %.2f%%\n", lp);
        System.out.printf("Draw %%: %.2f%%\n", dp);
    }
    public static char replay() {
        System.out.print("\nDo you wish to play again? (Y/N): ");
        return sc.next().trim().charAt(0);
    }
    public static void main(String[] args) throws InterruptedException {
        welcome();
        char play = 'Y';
        int round = 1;
        while (play == 'Y' || play == 'y') {
            System.out.println("\n------------------------------");
            System.out.println("Round: " + round++);
            String user = getUser();
            if (user.equals("exit")) break;
            String comp = getComp();
            play(user,comp);
            score();
            play = replay();
        }
        System.out.println("Thank you for playing!");
    }
}