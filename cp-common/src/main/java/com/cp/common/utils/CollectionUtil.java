package com.cp.common.utils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionUtil {
    /**
     * 集合中没有isBlank（）----CollectionUtils集合类
     * union(str,str):并集，intersection(str,str):交集，disjunction(str,str)：补集；substract(str,str)：差集
     * @param args
     */

    public static void main(String[] args) {

        //数组
        String[] arrayA = new String[] { "1", "2", "3", "4"};
        String[] arrayB = new String[] { "3", "4", "5", "6" };
        //将数组转化为集合
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);
        List listC = new ArrayList<Object>();

       //1、交集
        List<String>  jiaoList = new ArrayList<>(listA);
        jiaoList.retainAll(listB);
        System.out.println(jiaoList);
        //输出:[3, 4]

        System.out.println(CollectionUtils.isEmpty(listA));
        System.out.println(CollectionUtils.isEmpty(listC));
        // CollectionUtils.isBlank() 集合中没有isBlank（）

    }
}
