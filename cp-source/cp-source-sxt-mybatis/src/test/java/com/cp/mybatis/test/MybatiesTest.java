package com.cp.mybatis.test;


import com.cp.mybatis.entity.UserEntity;
import com.cp.mybatis.mapper.UerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatiesTest {

    @Test
    public void insertUser() throws IOException {
        Crudmothod().insertUser();

    }

    @Test
    public void updateUser() throws IOException {
        Crudmothod().updateUser();
    }

    @Test
    public void getUser() throws IOException {
        UserEntity userEntity = Crudmothod().selectById();

        System.out.println(userEntity.getUsername() + "\t" + userEntity.getPassword() + "\t" + userEntity.getEmail());
    }

    @Test
    public void getAll() throws IOException {
        List<UserEntity> userEntities = Crudmothod().selectAll();
        for (UserEntity userEntity : userEntities) {
            System.out.println(userEntity.getUsername() + "\t" + userEntity.getPassword() + "\t" + userEntity.getEmail());
        }


    }

    UerMapper Crudmothod() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        //获取sqlsession true自动提交事务 默认不自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper对象 底层采用代理模式
        UerMapper mapper = sqlSession.getMapper(UerMapper.class);
        return mapper;
    }



}
