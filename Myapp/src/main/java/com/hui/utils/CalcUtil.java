package com.hui.utils;

import com.hui.entity.Frac;

import java.util.Stack;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-26 22:24
 */
public class CalcUtil {

    /**
     * 采用调度场算法，获取指定运算式的结果值
     *
     * @param express 运算式
     * @return
     */
    public static String getExpressValue(String express) {
        //存放运算符包括 +、-、*、÷、(、)
        Stack<Character> ops = new Stack<Character>();
        //存放操作数
        Stack<Frac> fracs = new Stack<Frac>();

        char[] chars = express.toCharArray();
        char c = ' ';

        for (int i = 0; i < chars.length; i++) {
            //获取当前的字符
            c = chars[i];

            //左括号，入栈
            if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                //运算符栈顶元素不是‘(’
                while (ops.peek() != '(') {
                    //拿取操作栈中的两个分数
                    Frac frac1 = fracs.pop();
                    Frac frac2 = fracs.pop();
                    //得到运算后的值
                    Frac result = calculate(ops.pop(), frac1.getNum(), frac1.getDenom(),
                            frac2.getNum(), frac2.getDenom());

                    if (result.getNum() < 0) {
                        return "#";
                    }
                    //将结果压栈
                    fracs.push(result);
                }
                //将(出栈
                ops.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '÷') {
                //运算符栈不为空，当前运算符小于栈顶运算符优先级
                while (!ops.empty() && !priority(c, ops.peek())) {
                    //取操作栈中的两个分数
                    Frac frac1 = fracs.pop();
                    Frac frac2 = fracs.pop();
                    //得到计算后的值
                    Frac result = calculate(ops.pop(), frac1.getNum(), frac1.getDenom(),
                            frac2.getNum(), frac2.getDenom());
                    if (result.getNum() < 0) {
                        return "#";
                    }
                    //将结果压栈
                    fracs.push(result);
                }
                //将运算符入栈
                ops.push(c);
            } else {//操作数的时候
                if (c >= '0' && c <= '9') {
                    StringBuilder buf = new StringBuilder();
                    //取出一个完整的数值 比如 1/2、3、6/19
                    while (i < chars.length && (chars[i] == '/' || ((chars[i] >= '0') && chars[i] <= '9'))) {
                        buf.append(chars[i]);
                        i++;
                    }
                    i--;
                    //buf里面是一个操作数
                    String val = buf.toString();
                    //标记‘/’的位置
                    int flag = val.length();
                    for (int k = 0; k < val.length(); k++) {
                        //当得到的数在/标记/的位置，然后生成分数对象
                        if (val.charAt(k) == '/') {
                            flag = k;
                        }
                    }
                    //分子
                    StringBuilder numBuf = new StringBuilder();
                    //分母
                    StringBuilder denomBuf = new StringBuilder();
                    for (int j = 0; j < flag; j++) {
                        numBuf.append(val.charAt(j));
                    }
                    //判断是否为分数
                    if (flag != val.length()) {
                        for (int q = flag + 1; q < val.length(); q++) {
                            denomBuf.append(val.charAt(q));
                        }
                    } else {//不是分数 分母为1
                        denomBuf.append('1');
                    }
                    //入栈
                    fracs.push(new Frac(Integer.parseInt(numBuf.toString()), Integer.parseInt(denomBuf.toString())));
                }
            }
        }

        while (!ops.empty()) {
            Frac frac1 = fracs.pop();
            Frac frac2 = fracs.pop();

            //得到运算后的值
            Frac result = calculate(ops.pop(), frac1.getNum(), frac1.getDenom(),
                    frac2.getNum(), frac2.getDenom());
            if (result.getNum() < 0) {
                return "#";
            }
            //结果压栈
            fracs.push(result);
        }

        Frac result = fracs.pop();
        //将分数约分
        return getFinalResult(result);

    }

    /**
     * 获取最终数值，将分数约分
     *
     * @param result
     * @return
     */
    private static String getFinalResult(Frac result) {
        int denom = result.getDenom();//分母
        int num = result.getNum();//分子
        if (denom == 0) {
            return "0";
        }
        //获取最大公约数
        int greatcd = greatcd(num, denom);

        if (denom / greatcd == 1) {//分母为1
            return String.valueOf(num / greatcd);
        } else {
            //如果分子大于分母则化成真分数的形式
            if (result.getNum() > denom) {
                result = getRealFraction(result);
                return result.getInter() + "'" + result.getNum() / greatcd + "/" + result.getDenom() / greatcd;
            } else {
                return num / greatcd + "/" + denom / greatcd;
            }
        }
    }

    /**
     * 得到真分数
     *
     * @param result
     * @return
     */
    private static Frac getRealFraction(Frac result) {
        int num = result.getNum();
        int denom = result.getDenom();
        //分子部分
        int newNum = num % denom;
        //整数部分
        int inter = num / denom;
        Frac frac = new Frac(newNum, denom);
        frac.setInter(inter);

        return frac;
    }

    /**
     * 判断两个运算符的优先级
     *
     * @param opt1
     * @param opt2
     * @return 当opt1的优先级大于opt2时返回true
     */
    private static boolean priority(char opt1, char opt2) {
        if ((opt1 == '+' || opt1 == '-') && (opt2 == '*' || opt2 == '÷')) {
            return false;
        } else if ((opt1 == '+' || opt1 == '-') && (opt2 == '+' || opt2 == '-')) {
            return false;
        } else if ((opt1 == '*' || opt1 == '÷') && (opt2 == '*' || opt2 == '÷')) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 对两个分数进行相应的运算，获取结果
     *
     * @param op  运算符
     * @param num1 分子1
     * @param denom1 分母1
     * @param num2 分子2
     * @param denom2 分母2
     * @return 结果
     */
    private static Frac calculate(Character op, int num1, int denom1, int num2, int denom2) {
        int[] res = new int[2];
        //注：计算的两个分数存储在栈中 ，取出时顺序会颠倒
        switch (op) {
            case '+':
                res[0] = num1 * denom2 + num2 * denom1;
                res[1] = denom1 * denom2;
                break;
            case '-':
                res[0] = num2 * denom1 - num1 * denom2;
                res[1] = denom1 * denom2;
                break;
            case '*':
                res[0] = num1 * num2;
                res[1] = denom1 * denom2;
                break;
            case '÷':
                res[0] = num2 * denom1;
                res[1] = num1 * denom2;
                break;
        }
        return new Frac(res[0], res[1]);
    }

    /**
     * 获取分子分母的最大公约数，辗转相除法
     * greatest common divisor 最大公约数
     * @param num   分子 numerator
     * @param denom 分母 denominator
     * @return 最大公约数
     */
    private static int greatcd(int num, int denom) {
        num = Math.abs(num);
        denom = Math.abs(denom);
        while (denom != 0) {
            // 求余
            int remainder = num % denom;
            // 交换数，等同递归调用
            num = denom;
            denom = remainder;
        }
        return num;
    }
}
