package com.ft.backend.work.web.controller;

import com.ft.backend.work.client.service.UserService;
import com.ft.backend.work.client.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by huanghongyi on 2016/11/19.
 */
@Controller
//@RequestMapping(value = "/l")
public class LoginAndOutController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/logincheck")
    @ResponseBody
    public ModelAndView doLogIn(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession){


        String username=request.getParameter("username");
        String password=request.getParameter("password");

        UserVo userVo=(userService.getByUsernameAndPassword(username,password)).getResult();

        if(userVo !=null){
            try {

                PrintWriter out = response.getWriter();
                httpSession.setAttribute("userVo",userVo);
                response.sendRedirect("workshop/workshopSearch.html");
            }
            catch (Exception e){
            }
        }
       return null;
    }


}
