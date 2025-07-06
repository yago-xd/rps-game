import java.util.Random;
import java.util.Scanner;
public class Main {
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
        String user,comp;
        int cwin=0,uwin=0,draw=0,g=0;
        double w,l,d;
        char play='Y';
        while(play=='Y'||play=='y'){
            System.out.println("------------------------------");
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
                Thread.sleep(3000);
                g++;
                System.out.println("You chose: "+user);
                System.out.println("Computer chose: "+comp);
                if((user.equals("rock") && comp.equals("scissors")) || (user.equals("paper") && comp.equals("rock")) || (user.equals("scissors") && comp.equals("paper"))){
                    System.out.println("You Win!");
                    uwin++;
                }
                else if(user.equals(comp)){
                    System.out.println("It's a Tie!");
                    draw++;
                }
                else{
                    System.out.println("You Lost!");
                    cwin++;
                }
                w=((double) uwin /g)*100.0;
                l=((double) (g - uwin - draw) /g)*100.;
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