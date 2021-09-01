package com.zxk.service.store;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Company;
import com.zxk.service.store.impl.CompanyServiceImpl;
import com.zxk.utils.UUIDUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 11:11
 **/
public class CompanyServiceTest {
    private static CompanyService companyService = null;

    @BeforeClass
    public static void init() {
        companyService = new CompanyServiceImpl();
    }

    @Test
    public void findAllTest() {
        List<Company> all = companyService.findAll();
        System.out.println(all);
    }

    @Test
    public void findAllPageInfoTets() {
        PageInfo all = companyService.findAll(1, 100);
        System.out.println(all);
    }

    @AfterClass
    public static void destory() {
        companyService = null;
    }
}
