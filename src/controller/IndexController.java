package controller;

import bash.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * @name:
 * @Author: chenxiao
 * @date: 2020/4/7
 * @describe:
 */
@Controller
public class IndexController  {
    @ResponseBody
    @GetMapping("/getMessage")
    public String getMessage(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","chenxiao");
        map.put("age",12);
        map.put("school","中山大学南方学院");
        return map.toString();
    }
    @GetMapping("/View")
    public ModelAndView getView(Model model)
    {
        ModelAndView mv = new ModelAndView("view");
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","chenxiao");
        map.put("age",12);
        map.put("school","中山大学南方学院");
        mv.addObject("map",map);
        return mv;
    }
    @GetMapping("/Myview")
    public String getMyview(Model model)
    {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","chenxiao");
        map.put("age",18);
        map.put("school","中山大学南方学院");
        model.addAttribute("map",map);
        return "view";
    }

    @RequestMapping("/getData")
    public @ResponseBody
    User getData()
    {
       /* HashMap<String,Object> map = new HashMap<>();
        map.put("name","chenxiao");
        map.put("age",18);
        map.put("school","中山大学南方学院");*/
        User user = new User("chenxiao","中山大学南方学院",18);
        return user;
    }
}
