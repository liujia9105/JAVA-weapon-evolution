import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by liujia on 1/8/16.
 */
public class SoliderTest {
    private PrintStream fakedOut;

    @Before
    public void setUp() throws Exception {
        fakedOut = mock(PrintStream.class);
    }
    @Test
    public void should_get_profession_is_solider(){
        String name="Tom";
        int blood=20;
        int attackForce=8;

        String weaponName="优质木棒";
        Weapon weapon=new WeaponFactory().createWeapon(weaponName,attackForce);
        String amorName="布甲";
        int defensivePower=3;
        Armor armor =new AmorFactory().createArmor(amorName,defensivePower);
        Solider solider=new Solider(name,blood,attackForce,fakedOut,weapon, armor);
        assertThat(solider.getProfession(),is("战士"));

    }
    @Test
    public void should_solider_without_amor_attackedBy_player_print_profession_weaponName_loseblood_and_blood(){

        Solider tom=new Solider("Tom", 20, 8,fakedOut,new WeaponFactory().createWeapon(),new AmorFactory().createArmor());
        Player jerry=new Player("Jerry",20,8);
        assertThat(tom.attackedBy(jerry),is("普通人Jerry攻击了战士Tom,Tom受到了8点伤害,Tom剩余生命：12."));
    }
    @Test
    public void should_solider_with_amor_attackedBy_player_print_profession_weaponName_loseblood_and_blood(){

        Solider tom=new Solider("Tom", 20, 8,fakedOut,new WeaponFactory().createWeapon(),new AmorFactory().createArmor());
        Player jerry=new Player("Jerry",20,8);
        assertThat(tom.attackedBy(jerry),is("普通人Jerry攻击了战士Tom,Tom受到了8点伤害,Tom剩余生命：12."));
    }
}
