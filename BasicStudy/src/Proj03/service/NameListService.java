package Proj03.service;

import Proj03.domain.*;

import java.util.Arrays;

public class NameListService {
    private Employee[] employee;

    public NameListService() {

        Equipment lr_equi = null;
        double salary = 0;
        double bonus = 0;
        int stock = 0;
        int type = 0;
        int id = 0;
        int age = 0;

        employee = new Employee[Data.EMPLOYEES.length];

        for (int i = 0; i < Data.EMPLOYEES.length; i++) {

            //获取员工类型
            type = Integer.parseInt(Data.EMPLOYEES[i][0]);

            //新建属性变量
            id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            if (Data.EMPLOYEES[i].length >= 5)
                salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            if (Data.EMPLOYEES[i].length >= 6)
                bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
            if (Data.EMPLOYEES[i].length >= 7)
                stock = Integer.parseInt(Data.EMPLOYEES[i][6]);

            //新建设备对象
            if (i > 1) {
                switch (Integer.parseInt(Data.EQUIPMENTS[i][0])) {
                    case Data.PC -> lr_equi = new PC(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
                    case Data.NOTEBOOK -> lr_equi = new NoteBook(Data.EQUIPMENTS[i][1], Double.parseDouble(Data.EQUIPMENTS[i][2]));
                    case Data.PRINTER -> lr_equi = new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
                    default -> lr_equi = null;
                }
            }

            switch (type) {
                case Data.DESIGNER -> employee[i] = new Designer(id, name, age, salary, lr_equi, bonus);
                case Data.ARCHITECT -> employee[i] = new Architect(id, name, age, salary, lr_equi, bonus, stock);
                case Data.EMPLOYEE -> employee[i] = new Employee(id, name, age, salary);
                case Data.PROGRAMMER -> employee[i] = new Programmer(id, name, age, salary, lr_equi);
                default -> {
                    break;
                }
            }

        }
    }

    public Employee[] getAllEmployee() {
        return employee;
    }

    public Employee getEmployee(int id) throws TeamException {
//        Arrays.binarySearch(id);
        return null;
    }
}
