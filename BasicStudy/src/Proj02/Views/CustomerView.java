package Proj02.Views;

import Proj02.Model.Customer;
import Proj02.Model.CustomerList;
import Proj02.Util.CMUtility;

public class CustomerView {

    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        customerList.mainTainCustomer('i', 0, new Customer(
                        "suncw11",
                        '1',
                        10,
                        "18892621702",
                        "3349773905@qq.com"
                )

        );
        customerList.mainTainCustomer('i', 0, new Customer(
                        "suncw22",
                        '1',
                        10,
                        "18892621702",
                        "3349773905@qq.com"
                )

        );
        customerList.mainTainCustomer('i', 0, new Customer(
                        "suncw33",
                        '1',
                        10,
                        "18892621702",
                        "3349773905@qq.com"
                )

        );
        enterMainMenu();
        for (; ; ) {
            char lv_ucomm = CMUtility.readMenuSelection();
            switch (lv_ucomm) {
                case '1':
                    this.addNewCustomer();
                    break;
                case '2':
                    this.modifyCustomer();
                    break;
                case '3':
                    this.deleteCustomer();
                    break;
                case '4':
                    this.listAllCustomer();
                    break;
                case '5':
                    System.out.print("确认是否退出(y/n)?");
                    if (CMUtility.readChar() == 'y') return;
                    this.enterMainMenu();
                    continue;
                default:
                    break;
            }
            System.out.print("输入任意内容结束当前功能...");
            CMUtility.readString(10);
            enterMainMenu();
        }
    }

    /**
     * 主页面
     */
    public void enterMainMenu() {
        System.out.println("------------------客户信息管理软件------------------");
        System.out.println("------------------1.添加客户------------------");
        System.out.println("------------------2.修改客户------------------");
        System.out.println("------------------3.删除客户------------------");
        System.out.println("------------------4.客户列表------------------");
        System.out.println("------------------5.退出------------------");
        System.out.print("------------------请选择(1~5):");
    }

    /**
     * 添加客户
     */
    public void addNewCustomer() {
        System.out.println("*-------正在添加客户...");
        Customer lr_cust = new Customer();
        this.printInput(1, lr_cust);
        this.printInput(2, lr_cust);
        this.printInput(3, lr_cust);
        this.printInput(4, lr_cust);
        this.printInput(5, lr_cust);
        boolean is_success = customerList.mainTainCustomer('i', 0, lr_cust);
        if (is_success == false) System.out.println("保存失败!");
        System.out.println("保存成功");
    }

    /**
     * 修改客户
     */
    public void modifyCustomer() {
        System.out.println("*-------正在修改客户...");
        this.listAllCustomer();
        System.out.print("请选择待修改的客户编号(-1表示退出):");
        for (; ; ) {
            int lv_ucommon = CMUtility.readInt();
            if (lv_ucommon == -1) return;
            Customer lr_cust = customerList.getSingle(lv_ucommon - 1);
            if (lr_cust != null) {
                this.printInput(1, lr_cust);
                this.printInput(2, lr_cust);
                this.printInput(3, lr_cust);
                this.printInput(4, lr_cust);
                this.printInput(5, lr_cust);
                System.out.println("输入完成");
                break;
            } else {
                System.out.println("客户不存在,请重新输入!");
            }

        }

    }

    /**
     * 删除客户
     */
    public void deleteCustomer() {
        System.out.println("*-------正在删除客户...");
        this.listAllCustomer();
        System.out.print("请选择待删除的客户编号(-1表示退出):");
        for (; ; ) {
            int lv_del = CMUtility.readInt();
            if (lv_del == -1) break;
            boolean isDel = customerList.mainTainCustomer('d', lv_del - 1, null);
            if (isDel == false) {
                System.out.println("删除失败客户不存在!");
            } else {
                System.out.println("删除成功!");
            }
            System.out.print("请选择待删除的客户编号(-1表示退出):");
        }
    }

    /**
     * 显示客户列表
     */
    public void listAllCustomer() {

        System.out.println("*-------正在查看客户...");
        System.out.println("---------------------客户列表-begin---------------------");
        if (this.customerList.getTotal() == 0) {
            System.out.println("未查询到有效数据!");
        } else {
            Customer[] lt_cust = this.customerList.getAllCustomer();
            System.out.println("编号\t\t\t\t姓名\t\t\t\t性别\t\t\t\t年龄\t\t\t\t电话\t\t\t\t邮箱");
            for (int lv_index = 0; lv_index < lt_cust.length; lv_index++) {
                System.out.println((lv_index + 1) + "\t\t\t\t"
                        + lt_cust[lv_index].getName() + "\t\t\t\t"
                        + lt_cust[lv_index].getGender() + "\t\t\t\t"
                        + lt_cust[lv_index].getAge() + "\t\t\t\t"
                        + lt_cust[lv_index].getPhone() + "\t\t\t\t"
                        + lt_cust[lv_index].getEmail()
                );
            }
        }
        System.out.println("---------------------客户列表-ended---------------------");
    }

    public void printInput(int kind, Customer lr_cust) {

//        System.out.println("\n");

        switch (kind) {
            case 1:
                System.out.print("输入客户姓名:");
                lr_cust.setName(CMUtility.readString(10, lr_cust.getName()));
                break;
            case 2:
                System.out.print("输入客户性别:");
                lr_cust.setGender(CMUtility.readChar(lr_cust.getGender()));
                break;
            case 3:
                System.out.print("输入客户年龄:");
                lr_cust.setAge(CMUtility.readInt(lr_cust.getAge()));
                break;
            case 4:
                System.out.print("输入客户电话号码:");
                lr_cust.setPhone(CMUtility.readString(11, lr_cust.getPhone()));
                break;
            case 5:
                System.out.print("输入客户电子邮箱:");
                lr_cust.setEmail(CMUtility.readString(20, lr_cust.getEmail()));
                break;
            default:
                return;
        }
    }

}
