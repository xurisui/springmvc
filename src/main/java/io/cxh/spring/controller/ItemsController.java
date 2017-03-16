package io.cxh.spring.controller;

import io.cxh.spring.po.Item;
import io.cxh.spring.service.ItemService;
import io.cxh.spring.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Administrator on 2017/3/10.
 */
@Controller
public class ItemsController {

    @Autowired
    private ItemService itemService;

    //查询所有商品
    @RequestMapping("/listItems")
    public ModelAndView listItems() {

//        ArrayList<Item> list = new ArrayList<Item>();
//
//        Item item1 = new Item(1, "phone", 1000f);
//        Item item2 = new Item(2, "book", 1000f);
//        Item item3 = new Item(3, "keyboard", 1000f);
//
//        list.add(item1);
//        list.add(item2);
//        list.add(item3);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("list", list);
//        modelAndView.setViewName("listItems");


        Item item = itemService.getById(3);

        ModelAndView modelAndView = new ModelAndView("listItems");
        modelAndView.addObject("list", Collections.singletonList(item));
        return modelAndView;
    }

/*
    @RequestMapping("/itemEdit")
    //默认参数绑定
    public ModelAndView itemEdit(HttpServletRequest request) {
        String id = request.getParameter("id");
        //根据商品id哈寻商品数据
        Item item = itemService.findItemById(Integer.parseInt(id));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("item",item);
        modelAndView.setViewName("editItem");
        return modelAndView;
    }
 */


/*
 @RequestMapping("/itemEdit")
    //默认参数绑定（response，request，session，model）
    public String itemEdit(HttpServletRequest request,
                            HttpServletResponse respone,
                                    HttpSession session,
                                    Model model) {
        String id = request.getParameter("id");
        //根据商品id哈寻商品数据
        Item item = itemService.findItemById(Integer.parseInt(id));

//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("item",item);
//        modelAndView.setViewName("editItem");
//        return modelAndView;

        model.addAttribute("item", item);
        return "editItem";//返回的String代表逻辑视图名

    }
 */

    @RequestMapping("/itemEdit")
    //简单参数类型绑定（id，   response，request，session，model）
    public String itemEdit(Integer id,
                           HttpServletRequest request,
                           HttpServletResponse respone,
                           HttpSession session,
                           Model model) {
//        String id = request.getParameter("id");
        //根据商品id哈寻商品数据
        Item item = itemService.findItemById(id);

//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("item",item);
//        modelAndView.setViewName("editItem");
//        return modelAndView;

        model.addAttribute("item", item);
        return "editItem";//返回的String代表逻辑视图名

    }

    @RequestMapping("/updateitems")
    //POJO参数类型绑定
//    public String updateitems(Integer id, String name, Float price,
//                              String detail) {
    public String updateitems(Item item, Model model) {

        itemService.update(item);

        return "editItem";
    }

    @RequestMapping("/queryitem")
    //POJO包装类型参数绑定
    public String queryitem(QueryVo queryVo) {

        System.out.println(queryVo);
        return "success";
    }



}
