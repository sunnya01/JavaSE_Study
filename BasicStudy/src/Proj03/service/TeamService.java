package Proj03.service;

import Proj03.Util.CommonTools;
import Proj03.domain.Architect;
import Proj03.domain.Designer;
import Proj03.domain.Employee;
import Proj03.domain.Programmer;

import javax.print.DocFlavor;
import javax.print.attribute.standard.MediaSize;
import java.util.Arrays;

public class TeamService {
    public int counter = 0;
    public static final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void addMember(Employee e) throws TeamException {
        int insert = 0;
        //1. 成员已满
        int i = CommonTools.isFull(this.team);
        insert = i;
        if (i == -1) throw new TeamException("成员已满!");
        //2. 判断是否开发人员
        if (!(e instanceof Programmer)) throw new TeamException("该员工不是程序员!");
        //3. 判断员工状态
        Status status = ((Programmer) e).getStatus();
        if (status == Status.BUSY) {
            //4. 判断是否在本团队中
            if (isExsist((Programmer) e)) throw new TeamException("员工已经在当前团队中!");
            throw new TeamException("员工已经在别的团队中!");
        } else if (status == Status.VOCATION) {
            //5. 判断是否正在休假
            throw new TeamException("员工正在休假!");
        }
        //6. 统计架构师人数 设计师人数 程序员人数
        int jgs = 0, sjs = 0, cxy = 0;
        for (i = 0; i < this.team.length; i++) {
            if (this.team[i] != null) {
                if (this.team[i] instanceof Architect) {
                    jgs++;
                } else if (this.team[i] instanceof Designer) {
                    sjs++;
                } else if (this.team[i] instanceof Programmer) {
                    cxy++;
                }
            }
        }
        if (e instanceof Architect) {
            if (jgs == 1) throw new TeamException("架构师已经满了!");
        } else if (e instanceof Designer) {
            if (sjs == 2) throw new TeamException("设计师已经满了!");
        } else if (e instanceof Programmer) {
            if (cxy == 3) throw new TeamException("开发人员已经满了!");
        }
        this.team[insert] = (Programmer) e;
        this.team[insert].setMemberId(++this.counter);
        this.team[insert].setStatus(Status.BUSY);
        this.total++;
    }

    public void removeaMember(Employee e) throws TeamException {
        int i = CommonTools.isExsist(this.team, e);
        if (i == -1) throw new TeamException("成员不存在!");
        this.team[i].setStatus(Status.VOCATION);
        this.team[i] = null;
    }

    public void removeaMember(int memberId) throws TeamException {
        int index = 0;
        for (Programmer ls_prog : this.team) {
            if (ls_prog != null) {
                if (ls_prog.getMemberId() == memberId) {
                    ls_prog.setStatus(Status.FREE);
                    this.team[index] = null;
                    this.total--;
                    return;
                }
            }
            index++;
        }
        throw new TeamException("成员不存在!");
    }

    public Programmer[] getTeam() {
        int i = 0;
        Programmer[] programmers = new Programmer[total];
        for (Programmer ls_prog : this.team) {
            if (ls_prog != null)
                programmers[i++] = ls_prog;
        }
        return programmers;
    }

    public TeamService() {
        super();
    }

    public boolean isExsist(Programmer prog) {
        for (int i = 0; i < this.team.length; i++) {
            if (this.team[i] != null) {
                if (this.team[i].getId() == prog.getId()) return true;
            }
        }
        return false;
    }

}
