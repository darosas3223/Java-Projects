
import java.util.Random;

    public class Enemy{
        private String enemy_name,
                       l_atk,
                       h_atk;
        private int enemy_hp,
                    modifier;
        public int doDamage;
        private boolean standard_attack = false,
                       heavy_attack = false;
        private Random gen = new Random();
        
        //create
        public Enemy(String name, int hp, int modifier, String l_atk, String h_atk){
            this.enemy_name = name;
            this.enemy_hp = hp;
            this.modifier = modifier;
            this.l_atk = l_atk;
            this.h_atk = h_atk;
            System.out.println("An enemy " + enemy_name + " has entered the battle!");
        }
        
        public void enemyAttack(int attack){
            if(attack%2 == 1){
                standard_attack = true;
            }else{
                heavy_attack = true;
            }
            int x = 0;
            
            if(standard_attack){
                x = gen.nextInt(5) + 10 + modifier;
                System.out.println(enemy_name + " used " + l_atk + "\n"
                        + enemy_name + " did " + x + " points of damage!\n");
                standard_attack = false;
            }else{
                if(heavy_attack){
                    x = gen.nextInt(5) + 3 * modifier;
                    System.out.println(enemy_name + " used " + h_atk + "\n"
                        + enemy_name + " did " + x + " points of damage!\n");
                heavy_attack = false;
                }
            }
            doDamage = x;
        }
        
        public boolean updateEnemy(boolean hit, int damage){
            if(hit){
                enemy_hp -= damage;
                if(enemy_hp < 0){
                    System.out.println(enemy_name + " has been defeated!\n");
                    return false;
                }
            }
            System.out.println(enemy_name + " has " + enemy_hp + "hp remaining!\n");
            //do an attack
            int r = gen.nextInt(10);
            enemyAttack(r);
            return true;
        }
    }