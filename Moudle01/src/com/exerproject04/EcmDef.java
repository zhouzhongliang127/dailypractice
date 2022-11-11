package com.exerproject04;

/**
 * @author zzl
 * @Description
 * @date 2021/10/2 - 22:50
 */
public class EcmDef {

    public static void main(String[] args) {

        try {
            int int1 = Integer.parseInt(args[0]);
            int int2 = Integer.parseInt(args[1]);
            EcmDef ec = new EcmDef();
            System.out.println(" i / j = "+ec.ecm(int1,int2));
        } catch (NumberFormatException e){
            System.out.println("数据类型不一致！");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数！");
        }catch (ArithmeticException e){
            System.out.println("除0");
        }catch (EcDef e){
            System.out.println(e.getMessage());
        }

    }

    public int ecm(int i, int j) throws EcDef{
        if (i < 0 || j < 0) {
            throw new EcDef("分子或分母为复数了！");
        }
        return i / j;
    }
}
