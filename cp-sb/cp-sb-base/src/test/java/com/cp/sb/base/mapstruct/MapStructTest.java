package com.cp.sb.base.mapstruct;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class MapStructTest {

    @Test
    public void test(){
        PersonVo person = new PersonVo();
      //  person.setDescrib("测试");
        person.setAge(18);
        person.setName("张三");
        person.setHeight(170.5);
        person.setSource(new BigDecimal("100"));
        person.setCreateTime("2022-05-01");

        PersonDTO dto = IPersonMapper.INSTANCT.conver(person);

        System.out.println(dto);

    }


}
