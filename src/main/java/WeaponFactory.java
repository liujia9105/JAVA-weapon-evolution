/**
 * Created by liujia on 1/9/16.
 */
public class WeaponFactory {
    public Weapon createWeapon() {
        return new NullWeapon();
    }

    public Weapon createWeapon(String weaponName, int attackForce,Buff buff) {
        return new RealWeapon(weaponName,attackForce,buff);
    }
}
