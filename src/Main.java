import java.util.Random;
import java.util.Scanner;
public class Main {
    private static int win_streak;
    private static int loss_streak;
    private static int draw_streak;
    public static void streak(){
        if(win_streak>1)
            System.out.println("\nYou are on a win-streak of "+win_streak+" wins!");
        else if(loss_streak>1)
            System.out.println("\nYou are on a loss-streak of "+loss_streak+" losses!");
        else if(draw_streak >1){
            System.out.println("\nYou are on a draw-streak of "+ draw_streak +" drawn games");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("\nWelcome to the Rock Paper Scissors Game!");
        System.out.println("Type exit anytime to end the game");
        String[] choices = {"rock","paper","scissors"};
        String[] comments = {
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
        String[] win = {
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
        String[] loss = {
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

        String user,comp;
        int cwin=0,uwin=0,draw=0,g=0;
        double w,l,d;
        char play='Y';
        int round=1;
        while(play=='Y'||play=='y'){
            System.out.println("------------------------------");
            System.out.println("Round: "+round);
            round++;
            System.out.print("\nEnter your choice (rock, paper, scissors): ");
            user = sc.next().toLowerCase();
            if(user.equals("exit")){
                System.out.println("Exiting the game...");
                System.out.print("\n------------------------------");
                System.exit(0);
            }
            else if (user.equals("rock") || user.equals("paper") || user.equals("scissors")) {
                System.out.println(comments[rand.nextInt(comments.length)]);
                comp=choices[rand.nextInt(3)];
                Thread.sleep(2500);
                g++;
                System.out.println("You chose: "+user);
                System.out.println("Computer chose: "+comp+"\n");
                if((user.equals("rock") && comp.equals("scissors")) || (user.equals("paper") && comp.equals("rock")) || (user.equals("scissors") && comp.equals("paper"))){
                    System.out.println("\u001B[32mYou Win!\u001B[0m");
                    System.out.println(win[rand.nextInt(win.length)]);
                    uwin++;
                    win_streak++;
                    loss_streak= draw_streak =0;
                }
                else if(user.equals(comp)){
                    System.out.println("It's a Tie!");
                    draw++;
                    draw_streak++;
                    loss_streak=win_streak=0;
                }
                else{
                    System.out.println("\u001B[31mYou Lost!\u001B[0m");
                    System.out.println(loss[rand.nextInt(loss.length)]);
                    cwin++;
                    loss_streak++;
                    win_streak= draw_streak =0;
                }
                streak();
                w=((double) uwin /g)*100.0;
                l=((double) (g - uwin - draw) /g)*100.0;
                d=((double) draw /g)*100.0;
                System.out.println("\nScore: User - "+uwin+" | Computer - "+cwin);
                System.out.println("Games Played: "+g);
                System.out.println("Win %: "+w+"%");
                System.out.println("Loss %: "+l+"%");
                System.out.println("Draw %: "+d+"%");
                System.out.print("\n------------------------------");
                System.out.print("\nDo you wish to play again? (Y/N): ");
                play=sc.next().trim().charAt(0);
            }
            else{
                System.out.println("Invalid choice entered!");
                System.out.print("\n------------------------------");
            }
        }
        System.out.println("Thank you for playing!");
        sc.close();
    }
}