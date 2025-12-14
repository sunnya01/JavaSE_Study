package Proj03.domain;

import Proj03.service.Status;

public class Designer extends Programmer {

    private double bonus;

    public Designer(int id, String name, int age, double salary, int memberId, Status status, Equipment equipment, double bonus) {
        super(id, name, age, salary, memberId, status, equipment);
        this.bonus = bonus;
    }

    public Designer() {
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return toString01() + "\t设计师\t" + super.getStatus() + "\t" + this.bonus
                + "\t\t\t" + super.getEquipment().getDescription();
    }
}
