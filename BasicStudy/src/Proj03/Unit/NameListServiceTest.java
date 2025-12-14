package Proj03.Unit;

import Proj03.domain.Employee;
import Proj03.domain.Programmer;
import Proj03.service.NameListService;
import Proj03.service.Status;
import Proj03.service.TeamException;
import Proj03.service.TeamService;
import org.junit.Test;

/**
 * 测试类
 */
public class NameListServiceTest {
    @Test
    public void test01() {

        NameListService nameListService = new NameListService();

        for (Employee ls_employee : nameListService.getAllEmployee()) {
            System.out.println(ls_employee.toString());
        }
    }

    @Test
    public void test02() {

        NameListService nameListService = new NameListService();

        try {
            System.out.println(nameListService.getEmployee(12));
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void test03() {
        TeamService ts = new TeamService();
        NameListService nameListService = new NameListService();
//        nameListService.getEmployee(12)
        try {
           Programmer programmer = (Programmer)nameListService.getEmployee(2);
           programmer.setStatus(Status.VOCATION);
        } catch (TeamException e) {
            throw new RuntimeException(e);
        }
        try {
            ts.addMember(nameListService.getEmployee(2));
            ts.addMember(nameListService.getEmployee(3));
            ts.addMember(nameListService.getEmployee(4));
            ts.addMember(nameListService.getEmployee(5));
            ts.addMember(nameListService.getEmployee(6));
//            ts.addMember(nameListService.getEmployee(7));
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }

        try {
            ts.removeaMember(3);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }

//        try {
//            ts.addMember(nameListService.getEmployee(4));
//        } catch (TeamException e) {
//            System.out.println(e.getMessage());
//        }

        System.out.println(ts.getTeam());

    }

}
