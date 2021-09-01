package com.zxk.service.store;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Course;
import com.zxk.service.store.impl.CourseServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 11:11
 **/
public class CourseServiceTest {
    private static CourseService courseService = null;

    @BeforeClass
    public static void init() {
        courseService = new CourseServiceImpl();
    }

    @Test
    public void findAllTest() {
        List<Course> all = courseService.findAll();
        System.out.println(all);
    }

    @Test
    public void findByIDTest() {
        Course c = courseService.findById("53b07aff52f14a558f47b89c92171a69");
        System.out.println(c);
    }
    @Test
    public void findAllPageInfoTets() {
        PageInfo all = courseService.findAll(1, 100);
        System.out.println(all);
    }

    @AfterClass
    public static void destory() {
        courseService = null;
    }
}
