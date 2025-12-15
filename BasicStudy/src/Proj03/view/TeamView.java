package Proj03.view;

import Proj02.Util.CMUtility;
import Proj03.Util.CommonTools;
import Proj03.Util.TSUtility;
import Proj03.domain.Architect;
import Proj03.domain.Designer;
import Proj03.domain.Employee;
import Proj03.domain.Programmer;
import Proj03.service.NameListService;
import Proj03.service.TeamException;
import Proj03.service.TeamService;

public class TeamView {

    private TeamService[] teamServices = new TeamService[20];
    private NameListService nameListService = new NameListService();

    public TeamView() {
        TeamService teamServices = new TeamService();
        this.teamServices[0] = teamServices;
        enterMainMenu();
    }

    public void enterMainMenu() {

        boolean isStillRun = true;

        this.listAllEmployee();

        System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):");

        char ucommand = TSUtility.readMenuSelection();

        while (isStillRun) {

            switch (ucommand) {
                case '1' -> this.getTeam();
                case '2' -> this.addMember();
                case '3' -> this.deleteMember();
                case '4' -> {
                    System.out.print("请确认是否要退出(Y/N):");
                    char quit = TSUtility.readConfirmSelection();
                    if (quit == 'Y') isStillRun = false;
                }
            }
            if (isStillRun == true) {
                TSUtility.readReturn();
                this.listAllEmployee();
                System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):");
                ucommand = TSUtility.readMenuSelection();
            }
        }

    }

    private void listAllEmployee() {
        System.out.println("-----------------------开发团队调度软件-----------------------\n");
        System.out.println("ID\t姓名\t\t年龄\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
        for (Employee ls_employee : nameListService.getAllEmployee()) {
            System.out.println(ls_employee);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void getTeam() {
        System.out.println("-----------------------团队成员列表!-----------------------");
        if (this.teamServices[0].getTotal() == 0) {
            System.out.println("团队列表为空!");
        } else {
            System.out.println("TID/ID\t姓名\t\t年龄\t工资\t\t职位\t\t奖金\t\t股票");
            for (Programmer ls_prog : teamServices[0].getTeam()) {
                if (ls_prog != null) {
                   ls_prog.printInfo();
                }
            }
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void addMember() {
        System.out.println("-----------------------团队成员添加!-----------------------");
        System.out.print("请选择员工id(-1退出):");
        int id = TSUtility.readInt();
        if (id == -1) return;
        for (; ; ) {
            try {
                this.teamServices[0].addMember(this.nameListService.getEmployee(id));
                System.out.println("员工添加成功!");
                break;
            } catch (TeamException e) {
                System.out.print(e.getMessage() + "请重新添加(-1退出):");
                id = TSUtility.readInt();
                if (id == -1) break;
            }
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void deleteMember() {
        System.out.println("-----------------------团队成员删除!-----------------------");
        System.out.print("请选择员工id(-1退出):");
        int id = TSUtility.readInt();
        if (id == -1) return;
        for (; ; ) {
            try {
                Employee employee = this.nameListService.getEmployee(id);
                if (employee != null) {
                    System.out.print("团队成员查询成功，请确认是否确实删除(Y/N):");
                    char confirm = TSUtility.readConfirmSelection();
                    if (confirm == 'N') continue;
                }
                this.teamServices[0].removeaMember(this.nameListService.getEmployee(id));
                System.out.println("员工删除成功!");
                break;
            } catch (TeamException e) {
                System.out.print(e.getMessage() + "请重新选择(-1退出):");
                id = TSUtility.readInt();
                if (id == -1) break;
            }
        }
        System.out.println("-----------------------------------------------------------");
    }


}
