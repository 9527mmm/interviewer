package com.zxk.service.system;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Company;
import com.zxk.domain.system.User;
import com.zxk.service.store.CompanyService;
import com.zxk.service.store.impl.CompanyServiceImpl;
import com.zxk.service.system.impl.UserServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 18:54
 **/
public class UserServiceTest {

    private static UserService userService = null;

    @BeforeClass
    public static void init() {
        userService = new UserServiceImpl();
    }

    @Test
    public void findAllTest() {
        List<User> all = userService.findAll();
        System.out.println(all);
    }

    @Test
    public void findAllPageInfoTets() {
        PageInfo all = userService.findAll(1, 100);
        System.out.println(all);
    }

    @AfterClass
    public static void destory() {
        userService = null;
    }
}
