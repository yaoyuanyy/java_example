package com.yy.example.bianchengzhuji.book_x_x_x;

import com.alibaba.fastjson.JSON;

/**
 * Description:
 * <pre>
 * 本书行将出版之时，美国的个人所得税分为5种不同的费率，其中最大的费率大约为40%。
 * 以前的情况更为复杂，税率也更高。下面所示的程序文本采用25个if语句的合理方式来计算1978年的美国联邦所得税。
 * 税率分别为0.14，0.15，0.16，0.17，0.18，·····。此后的费率增幅大于0.01.有何建议？
 *
 * 具体下问题
 * 假如：基本收税是2000元。进一档加500元，税率分为n挡，分别为0.14，0.15，0.16，0.17，0.18 ... n。求输入任一收税金额，输出相应的税是多少
 *    收税金额         税
 *     2000           2000*0
 *     2500           2500*0.14
 *     3000           3000*0.15
 *     3500           3500*0.16
 *     4000           4000*0.17
 *     ...            ...
 *
 * 两种解法，method1和 method2
 * method1是硬代码，method2更灵活
 * </pre>
 * NB.
 * 参考：https://www.codeleading.com/article/56162626220/
 * @author skyler_11@163.com
 * Created by on 2021-04-14 at 07:45
 */
public class Test_3_7_1 {

    SalaryLevel[] salaryLevels;

    private static double getSalary_Method1(long salary) {
        if(2000 < salary && salary <= 2500) {
            return (salary - 2000) * 0.14;
        }else if(2500 < salary && salary <= 3000) {
            return (salary - 2500) * 0.15;
        }
        // ..
        return 0;
    }

    private static double getSalary_Method2(long salary) {
        Test_3_7_1 test_3_7_1 = new Test_3_7_1();
        test_3_7_1.init(20);
        return test_3_7_1.getTaxOf(salary);
    }

    public void init(int max) {
        salaryLevels = new SalaryLevel[max];
        for (int i = 0; i < max; i++) {
            salaryLevels[i] = new SalaryLevel();
            if(i == 0) {
                salaryLevels[i].bound = 2000;
                salaryLevels[i].tax = 0.14;
                salaryLevels[i].base = 0;
            }else {
                salaryLevels[i].bound = salaryLevels[i - 1].bound + 500;
                salaryLevels[i].tax = salaryLevels[i - 1].tax + 0.01;
                salaryLevels[i].base = salaryLevels[i - 1].base + salaryLevels[i - 1].tax * 500;
            }
        }

        System.out.println("salaryLevels:" + JSON.toJSONString(salaryLevels));
    }

    public double getTaxOf(double salary) {
        int index = ((int)salary - 2000) / 500;
        if(index < 0 || salary <= 2000) {
            System.out.println("salary:" + salary + "index:" + index);
            return 0;
        }
        if(index >= salaryLevels.length) {
            throw new RuntimeException("index >= salaryLevels.length index:" + index + " salaryLevels.length" + salaryLevels.length);
        }
        SalaryLevel salaryLevel = salaryLevels[index];
        System.out.println("salary:" + salary + " index:" + index + " salaryLevel:" + salaryLevel);
        return salaryLevel.base + (salary - salaryLevel.bound) * salaryLevel.tax;
    }

    class SalaryLevel {

        /**
         * 收入金额下边界
         */
        private double bound;
        private double tax;
        private double base;

        public double getBound() {
            return bound;
        }

        public void setBound(double bound) {
            this.bound = bound;
        }

        public double getTax() {
            return tax;
        }

        public void setTax(double tax) {
            this.tax = tax;
        }

        public double getBase() {
            return base;
        }

        public void setBase(double base) {
            this.base = base;
        }

        @Override
        public String toString() {
            return "SalaryLevel{" +
                    "bound=" + bound +
                    ", tax=" + tax +
                    ", base=" + base +
                    '}';
        }
    }

    public static void main(String[] args) {

        //double tax = getSalary_Method1(111l);
//        double tax = getSalary_Method2(111l);
//        System.out.println("tax:" + tax);

        double tax2 = getSalary_Method2(2200l);
        System.out.println("tax2:" + tax2);

//        double tax3 = getSalary_Method2(2700);
//        System.out.println("tax3:" + tax3);
//
//        double tax4 = getSalary_Method2(3900);
//        System.out.println("tax4:" + tax4);
    }
}
