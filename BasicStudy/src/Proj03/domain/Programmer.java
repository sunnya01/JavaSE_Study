package Proj03.domain;

import Proj03.service.Status;

public class Programmer extends Employee {
    private int memberId;
    private Status status;
    private Equipment equipment;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Programmer(int id, String name, int age, double salary, int memberId, Status status, Equipment equipment) {
        super(id, name, age, salary);
        this.memberId = memberId;
        this.status = status;
        this.equipment = equipment;
    }

    public Programmer() {
    }

    @Override
    public String toString() {

        return toString01() + "\t程序员\t" + this.status + "\t\t\t\t\t" + this.equipment.getDescription();

    }

    @Override
    public String printInfo() {
        return "  " + this.getMemberId() + "/" + this.getId() + "\t" + this.getName() + "\t" + this.getAge() + "\t" + this.getSalary();
    }
}
