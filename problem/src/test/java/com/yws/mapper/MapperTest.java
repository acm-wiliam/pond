package com.yws.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yws.mapper.ProblemMapper;
import com.yws.pojo.Problems;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest //寻找配置类是在本类的所在包及其父包中寻找
public class MapperTest {

    @Autowired
    private ProblemMapper pm;

    @Test
    void mybatisTest(){
//        List<Problems> problems = pm.selectList(null);
//        for(Problems p:problems){
//            System.out.println(p);
//        }
        System.out.println(pm.selectById(3));
    }

    @Test
    void Testsave(){
        Problems p=new Problems();
        p.setPbname("三数之和");
        p.setSource("LeetCode");
        p.setTag("数组");
        p.setDescription("测试123");
        p.setInput("测试123");
        p.setOutput("测试123");
        pm.insert(p);

    }
    @Test
    void TestUpdate(){
        Problems p=new Problems();
        p.setId(4);
        p.setPbname("四数之和");
        p.setSource("LeetCode");
        p.setTag("数组");
        p.setDescription("测试1233333");
        p.setInput("测试1233333");
        p.setOutput("测试1233333");
        pm.updateById(p);

    }

    @Test
    void Testdelete(){
        pm.deleteById(4);
    }

    @Test
    void TestFindAll(){
        for(Problems p:pm.selectList(null))
            System.out.println(p);
    }

    @Test   //进行分页操作
    void TestGetPage(){
        IPage page = new Page(2,3);
        pm.selectPage(page,null);
        System.out.println(page.getCurrent());  //当前页数
        System.out.println(page.getSize());     //分页大小
        System.out.println(page.getTotal());    //总共有多少条
        System.out.println(page.getPages());    //总共几页
        System.out.println(page.getRecords());  //所有数据
    }

    @Test
    void TestGetBycondition(){      //附加其他查询条件
        QueryWrapper<Problems> qw = new QueryWrapper<>();
        qw.like("description","整数");    //通过对字段搜寻
        pm.selectList(qw);
    }
    @Test
    void TestGetBycondition2(){
        String descrip="整数";
//        String descrip=null;      //附加其他查询条件
        LambdaQueryWrapper<Problems> lqw = new LambdaQueryWrapper<>();
//        lqw.like(Problems::getDescription,descrip); //直接获取语法字段
        lqw.like(descrip!=null,Problems::getDescription,descrip); //直接获取语法字段
        pm.selectList(lqw);
    }
}
