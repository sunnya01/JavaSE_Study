package Proj03.domain;

import Proj03.service.Status;

public class Architect extends Designer {
    private int stock;//股票

    public Architect(int id, String name, int age, double salary, int memberId, Status status, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, memberId, status, equipment, bonus);
        this.stock = stock;
    }

    public Architect() {
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return toString01() + "\t架构师\t" + super.getStatus() + "\t" + super.getBonus()
                + "\t" + this.stock + "\t" + super.getEquipment().getDescription();
    }
}
