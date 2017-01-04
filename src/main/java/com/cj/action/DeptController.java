package com.cj.action;

import com.alibaba.fastjson.JSON;
import com.cj.domain.Dept;
import com.cj.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

/**
 * Created by lanling on 2016/12/14.
 */
@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/depts")
    public ModelAndView showDepts() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("depts", deptService.findAllDepts());
        mav.setViewName("/deptShow.jsp");
        return mav;
    }

    @RequestMapping("/fun")
    @ResponseBody
    public Object fun(MultipartFile file) {
        String res = "{\"name\":\"";
        String originalFilename = file.getOriginalFilename();
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
        File path = new File("d:/test"+fileSuffix);
        try {
            file.transferTo(new File(path.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        res += originalFilename;
        res += "\"}";
        return JSON.parse(res);
    }


    //测试前先在web.xml中打开restful配置
    @RequestMapping("/restful/{deptno}/{dname}/{loc}")
    @ResponseBody
    public Dept restFul(@PathVariable("deptno") Integer deptno, @PathVariable("dname") String dname, @PathVariable("loc") String loc, Dept dept) {
        System.out.println(dept);
        return dept;
    }
}
