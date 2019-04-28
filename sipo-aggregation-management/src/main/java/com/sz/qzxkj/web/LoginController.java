package com.sz.qzxkj.web;

import com.sz.qzxkj.entity.UserInfo;
import com.sz.qzxkj.utils.CryptographyUtil;
import com.sz.qzxkj.utils.KaptchaUtil;
import com.sz.qzxkj.utils.R;
import com.sz.qzxkj.utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.google.code.kaptcha.Constants;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/signin")
    public ModelAndView login() {
        Map<String,Object> map = new HashMap<>();
        map.put("action","signin");
        return new ModelAndView("/layout/signin",map);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String login(@ModelAttribute UserInfo loginForm,HttpServletRequest request){
        log.info(""+loginForm);
        if(new KaptchaUtil().isKaptchaOnOff()){
            String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
            if(!loginForm.getCaptcha().equalsIgnoreCase(kaptcha)){
                return "layouts/login";
            }
        }
        Subject subject= SecurityUtils.getSubject();

        try{
            String simple = CryptographyUtil.md5("123456", "123456");
            UsernamePasswordToken token = new UsernamePasswordToken(loginForm.getUsername(), simple);
            subject.login(token);
            return "redirect:/layout";
        } catch (AuthenticationException e) {
            return "/login/signin";
        }

    }

    /**
     * 退出
     */
    @ResponseBody
    @GetMapping("/logout")
    public Object logout() {

        return R.ok("退出成功");
    }
}
