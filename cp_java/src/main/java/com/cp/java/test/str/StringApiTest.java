package com.cp.java.test.str;

/**
 * String核心api
 */
public class StringApiTest {
    static String a= " _qwe482  d ";
    static String b= " _qwe482  d ";
    static String c= " _qwE482  d ";
    static String e= "dsfTsR7s";
    static String f= " ";
    static String g= "";

    public static void main(String[] args) {
        //获取字符串的长度
        System.out.println(a.length());

        //判断两个字符串内容是否相同
        System.out.println(b.equals(c));

        //不区分大小写判断两个字符串内容是否相同
        System.out.println(c.equalsIgnoreCase(a));

        //返回下标所在的cha值(字符)
        // System.out.println(e.charAt(-1));    java.lang.StringIndexOutOfBoundsException
        System.out.println(e.charAt(4));

        //返回字串第一次出现的位置，没出现则返回-1
        System.out.println(a.indexOf(" "));  //0

       // 判断字符串是否以df为前缀开头
        System.out.println(e.startsWith("df"));
        //判断字符串是否以空为后缀结尾
        System.out.println(b.endsWith(" "));
        //返回字符串的小写形式
        System.out.println(e.toLowerCase());

        //判断是否包含字串s
        System.out.println(e.contains("s"));

        //将此字符串转换为一个新的字符数组
        char[] chars = e.toCharArray();
        for(char ch :chars){
            System.out.println(ch);
        }

       // 返回字符串两边消除空格后的字符串
        System.out.println(a.trim());

        //判断字符串是否为空
        System.out.println(f.isEmpty()); //空格也是长度 有长度 不为空 false
        System.out.println(g.isEmpty()); //无空格 true 如果等于null 则抛出空指针异常

        //将字符串与另一个对象进行比较 返回对象为int类型
        System.out.println(a.compareTo(b)); //相等返回0
        System.out.println(a.compareToIgnoreCase(c));

        // 返回字符串的哈希值
        System.out.println(a.hashCode());


    }





}
