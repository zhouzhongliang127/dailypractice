package com.exerporject01;

/**
 * @author zzl
 * @Description
 * @date 2021/9/28 - 17:51
 */
public class CustomerList {
    private Customer[] customers;//存储客户对象的数组
    private int total;//记录客户数量

    
    /**
     * 功能描述: <br>
     * <用来初始化customers数组的构造器>
     * @param totalCustomer 指定客户数组的长度
     * @Return: 
     * @Author: zzl
     * @Date: 2021/9/28 18:05
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
        
    }
    
    /**
     * 功能描述: <br>
     * <将指定的客户添加到数组中>
     * @param customer 客户对象
     * @Return: boolean ture：成功 false：失败
     * @Author: zzl
     * @Date: 2021/9/28 18:08
     */
    public boolean addCustomer(Customer customer){
        if(total >= customers.length)
            return false;
        else
            customers[total++] = customer;
        return true;
    }

    /**
     * 功能描述: <br>
     * <修改指定位置上的客户信息>
     * @param index 要修改的客户位置下标
     * @Return: boolean
     * @Author: zzl
     * @Date: 2021/9/28 18:11
     */
    public boolean replaceCustomer(int index, Customer cust){
        if(index < 0 || index >=total) return false;
        else
            customers[index] = cust;
        return true;
    }
/**
 * 功能描述: <br>
 * <删除指定位置的客户>
 * @param index 要删除的客户下标
 * @Return: boolean
 * @Author: zzl
 * @Date: 2021/9/28 18:16
 */
    public boolean deleteCustomer(int index){
        if(index < 0 || index >=total)
            return false;
        else
            for (int i = index+1; i < customers.length; i++) {
                customers[i -1] = customers[i];
            }
            //数组的删除别忘了移动覆盖后尾巴置空
            customers[--total] = null;
            return true;
    }

/**
 * 功能描述: <br>
 * <获取所有客户>
 * @param
 * @Return: com.exer01.Customer[] 返回一个Customer数组
 * @Author: zzl
 * @Date: 2021/9/28 18:25
 */
    public Customer[] getAllCustomer(){
        //因为原数组不满，获取时只需要去有值的那部分即可
        Customer [] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * 功能描述: <br>
     * <获取指定位置上的客户>
     * @param index 指定的位置
     * @Return: com.exer01.Customer
     * @Author: zzl
     * @Date: 2021/9/28 18:27
     */
    public Customer getCustomer(int index){
        if(index < 0 || index >=total)
            return null;
        else
            return customers[index];
    }
    public int getTotal(){
        return  total;
    }
}
