import java.util.Scanner;
import java.util.Random;

public class Start{
    private String name,
                   l_atk,
                   h_atk,
                   heal;
    private int hp,
                doDamage = 0;
    private boolean attack,
                    turnOver = false;
    private Scanner in = new Scanner(System.in);
    private Random gen = new Random();
    
    Start(String name, int cls){
        this.name = name;
        
        switch(cls){
            //class
            case 1:
                //knight
                hp = 200;
                l_atk = "LIGHT SWING";
                h_atk = "HEAVY SWING";
                heal = "PRAYER";
                break;
            case 2:
                //mage
                hp = 125;
                l_atk = "MAGIC BLAST";
                h_atk = "WAND SMACK";
                heal = "TEARSTONE";
                break;
            case 3:
                //viking
                hp = 175;
                l_atk = "PUNCH";
                h_atk = "AXE SWING";
                heal = "ORANGE";
                break;
            default:
                this.name = "CRY-BABY";
                hp = 10;
                l_atk = "CRY";
                h_atk = "WEEP";
                heal = "SUCK THUMB";
        }
    }
    
    private void updatePlayer(){
        turnOver = false;
        System.out.println(name + " has " + hp + "hp remaining!\n"
                + "What will be your next action, " + name + "?\n"
                        + "Type \u005c\u0022HELP\u005c\u0022 or \u005c\u0022COMMANDS\u005c\u0022 to view your actions.");
        do{
            String command = in.nextLine().trim();
            command = command.toUpperCase();
            if (command.equals("HELP") || command.equals("COMMANDS")) {
                System.out.println("Type any of the following to attack: \n"
                        + l_atk + " or " + h_atk + ".\n"
                        + "To heal, use " + heal);
            }else{
                if(command.equals(l_atk)){
                    doDamage = gen.nextInt(5) + 20;
                    attack = true;
                    System.out.println(name + " used " + l_atk + "\n"
                            + name + " did " + doDamage + " points of damage!");
                    turnOver = true;
                }else
                if(command.equals(h_atk)){
                    doDamage = gen.nextInt(5) + 30;
                    attack = true;
                    System.out.println(name + " used " + h_atk + "\n"
                            + name + " did " + doDamage + " points of damage!");
                    turnOver = true;
                }else
                if(command.equals(heal)){
                    doDamage = gen.nextInt(5) + 17;
                    attack = false;
                    hp += doDamage;
                    System.out.println(name + " used " + heal + "\n"
                            + name + " recovered " + doDamage + "hp!");
                    turnOver = true;
                    
                }else{
                    System.out.println("\u005c\u0022"+ command + "\u005c\u0022 is not a recognized command");
                    turnOver = false;
                }
            }
        }while(!turnOver);
    }
    
    private void takeDamage(int d){
        hp -= d;
    }
    
    private void update(){
        boolean isRunning = true;
        Mechanics M = new Mechanics();
        Enemy E = new Enemy("PIG-FOOT", 100, 7, "CLOMP", "SCREECH");
        M.gameStart(name);
        
        do{
            updatePlayer();
            isRunning = E.updateEnemy(attack, doDamage);
            takeDamage(E.doDamage);
            if(hp <= 0){
                hp = 0;
                System.out.println(name + "! You have fallen in battle!");
                isRunning = false;
                System.out.println("GAME OVER");
            }
        }while(isRunning);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What is your hero's name?: ");
        String name = sc.nextLine();
        System.out.print("Select your class:  \n"
                + "1. Knight \n"
                + "2. Mage \n"
                + "3. Viking \n"
                + "Select class by number: ");
        int cls = sc.nextInt();
        System.out.println();
        Start S = new Start(name, cls);
        S.update();
    }
}