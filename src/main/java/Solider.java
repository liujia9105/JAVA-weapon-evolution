/**
 * Created by liujia on 1/8/16.
 */
public class Solider extends Player{
    private final Weapon weapon;
    private final Armor armor;
    private String profession;

    public Solider(String name, int blood, int attackForce, Weapon weapon, Armor armor) {
        super(name,blood,attackForce);
        this.weapon=weapon;
        this.armor = armor;
        this.profession="战士";
    }

    public String attackedBy(Player attacker) {

        int loseBlood = attacker.attackOut()-this.getArmor().getDefensivePower();
        this.setHealthPoint(this.getHealthPoint() - loseBlood);
        return (attacker.getProfession()+attacker.getName() +attacker.attackWith()+getProfession()+ this.getName() + "," + this.getName() + "受到了" + loseBlood + "点伤害," + this.getName() + "剩余生命：" + this.getHealthPoint() + ".");


    }

    public String getProfession() {
        return profession;
    }

    public Armor getArmor() {
        return armor;
    }

    public String attackWith(){
        if (this.weapon.getWeaponName()!=""){
            return "用"+this.weapon.getWeaponName()+"攻击了";
        }
        else {
            return this.weapon.getWeaponName()+"攻击了";
        }
    }

    public int attackOut(){return this.getAttackForce()+this.weapon.getAttackerForce();}

}
