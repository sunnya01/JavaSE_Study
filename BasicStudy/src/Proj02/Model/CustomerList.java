package Proj02.Model;

/**
 * @author sunchaowei
 * @version 1.0
 * @Description CustomerList为Customer对象的管理模块
 * 内部用数组管理一组Customer对象，并提供对应的添加、修改、删除、和遍历方法
 * 供CustomerView调用
 * @date 2025.12.09
 */
public class CustomerList {
    private Customer[] customers;//用来保存客户对象的数组
    private int total;//记录已保存的客户对象的数量 测试报错

    /**
     * 用来初始化cutomer数组大小的构造器
     *
     * @param totalCustomer 指定数组的大小
     */
    public CustomerList(int totalCustomer) {

        customers = new Customer[totalCustomer];

    }

    /**
     * 修改指定索引位置上的客户信息
     *
     * @param uv_index    数组索引值
     * @param ur_customer
     * @param kind        r 代表替换客户 d 代表删除客户 i 代表新增客户
     * @return
     */
    public boolean mainTainCustomer(char kind,int uv_index,Customer ur_customer) {

        switch (kind) {
            case 'i':
                //循环判断避免删除过后造成插入异常
                for (int lv_index = 0;lv_index < customers.length;lv_index++){
                    if (customers[lv_index] == null){
                        //按照索引赋值
                        customers[lv_index] = ur_customer;
                        total++;
                        return true;
                    }
                }
                return false;
            case 'r':
            case 'd':
                //如果数组索引不在范围内 返回false 或者所在位置为空指针 返回false
                if (uv_index < 0 || uv_index > total - 1 || customers[uv_index] == null) return false;
                if (kind == 'r') {
                    //按照索引赋值
                    customers[uv_index] = ur_customer;
                    return true;
                } else if (kind == 'd') {
                    //按照索引赋值
                    customers[uv_index] = null;
                    total--;
                    return true;
                }
            default:
                return false;
        }

    }

    public Customer[] getAllCustomer() {

        int lv_internal = 0;

        Customer[] lr_cust = new Customer[total];

        for (int i = 0;i < this.customers.length;i++){

            if (this.customers[i] != null )lr_cust[lv_internal++] = this.customers[i];

        }

        return lr_cust;
    }

    public Customer getSingle(int uv_index) {
        if (uv_index < 0 || uv_index > this.customers.length - 1)return null;
        return customers[uv_index];
    }

    public int getTotal() {
        return total;
    }

}
