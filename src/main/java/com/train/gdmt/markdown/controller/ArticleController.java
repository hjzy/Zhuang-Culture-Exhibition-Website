package com.train.gdmt.markdown.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.train.gdmt.announcement.model.Announcement;
import com.train.gdmt.markdown.pojo.Article;
import com.train.gdmt.markdown.service.ArticleService;
import com.train.gdmt.markdown.utils.FileUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {


    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    //提交文章
    @RequestMapping("/publish")
    @ResponseBody
    public String publishArticle(Article article) {
        boolean res = articleService.publishArticle(article);
        if(res) {
            return "success";
        }
        return "false";
    }

//    markdown图片上传控制器
    @RequestMapping("/image/upload")
    @ResponseBody
    public JSONObject imageUpload(@RequestParam("editormd-image-file") MultipartFile image) {
        JSONObject jsonObject = new JSONObject();
        if(image != null) {
            String path = FileUtils.uploadFile(image);
            System.out.println(path);
            jsonObject.put("url", path);
            jsonObject.put("success", 1);
            jsonObject.put("message", "upload success!");
            return jsonObject;
        }
        jsonObject.put("success", 0);
        jsonObject.put("message", "upload error!");
        return jsonObject;
    }

    //获取文章并直接显示
    @RequestMapping("/get/{id}")
    public ModelAndView getArticleById(@PathVariable(name = "id")int id) {
        ModelAndView modelAndView = new ModelAndView();
        Article article = articleService.getArticleById(id);
        modelAndView.setViewName("article");
        if(article == null) {
            modelAndView.addObject("article", new Article());
        }
        modelAndView.addObject("article", article);
        return modelAndView;
    }
    //在视图中显示图文内容
    @RequestMapping("/view/{id}")
    public ModelAndView viewArticle(@PathVariable(name = "id")int id ,HttpServletRequest request, HttpServletResponse response) {
        //String announceNum = request.getParameter("num");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("article-view");
        Article article = articleService.getArticleById(id);
        if(article == null) {
            modelAndView.addObject("article", new Article());
        }
        modelAndView.addObject("article", article);
        return modelAndView;
    }
    //在视图中显示所有文章，并进行分页
    @RequestMapping("/page")
    public ModelAndView page(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("article-admin");

        System.out.println("Page Number>>>>>>>>>>>>" + pageNum);
        //引入分页查询，在查询之前获取当前页记录
        PageHelper.startPage(pageNum, pageSize);

        //分页查询
        List<Article> articleList = articleService.getAllArticle();

        //包装查询结果
        PageInfo pageInfo = new PageInfo(articleList, 1);
        pageInfo.setList(articleList);
        //model.addAttribute("sdj1",sdj1);
        //model.addAttribute("pageInfo", pageInfo);
        modelAndView.addObject("pageInfo", pageInfo);
        //model.addAttribute("addUrl", "http://localhost:8081/markdown/toedit");
        modelAndView.addObject("addUrl", "/markdown/toedit");
        //获取当前页
        modelAndView.addObject("pageNum", pageNum);
        //获取一页显示的条
        modelAndView.addObject("pageSize", pageSize);
        //是否为第一页
        modelAndView.addObject("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        modelAndView.addObject("totalPages", pageInfo.getPages());
        //是否为最后一页
        modelAndView.addObject("isLastPage", pageInfo.isIsLastPage());

        return modelAndView;
    }

//    搜索
    @RequestMapping("/search")
    public ModelAndView search(HttpServletRequest request,Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("article-admin");
        String titleStr = request.getParameter("titleStr");
        System.out.println("Page Number>>>>>>>>>>>>" + pageNum);
        //引入分页查询，在查询之前获取当前页记录
        PageHelper.startPage(pageNum, pageSize);

        //分页查询
        List<Article> articleList = articleService.searchArticle(titleStr);

        //包装查询结果
        PageInfo pageInfo = new PageInfo(articleList, 1);
        pageInfo.setList(articleList);
        //model.addAttribute("sdj1",sdj1);
        //model.addAttribute("pageInfo", pageInfo);
        modelAndView.addObject("pageInfo", pageInfo);
        //model.addAttribute("addUrl", "http://localhost:8081/markdown/toedit");
        modelAndView.addObject("addUrl", "/markdown/toedit");
        //获取当前页
        modelAndView.addObject("pageNum", pageNum);
        //获取一页显示的条
        modelAndView.addObject("pageSize", pageSize);
        //是否为第一页
        modelAndView.addObject("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        modelAndView.addObject("totalPages", pageInfo.getPages());
        //是否为最后一页
        modelAndView.addObject("isLastPage", pageInfo.isIsLastPage());

        return modelAndView;
    }
//    删除
    @RequestMapping("/delete/{id}")
  //  @ResponseBody
    public String deleteArticleById(@PathVariable(name = "id")int id) {
       // ModelAndView modelAndView = new ModelAndView();
        boolean res = articleService.deleteArticleById(id);
//        if(res) {
//            return "success";
//        }
//        return "false";
        return "redirect:/article/page";
    }

    @RequestMapping("/toEdit/{id}")
    public ModelAndView toEditArticle(@PathVariable(name = "id")int id ,HttpServletRequest request, HttpServletResponse response) {
        //String announceNum = request.getParameter("num");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("article-edit");
        Article article = articleService.getArticleById(id);
        if (article == null) {
            modelAndView.addObject("article", new Article());
        }
        modelAndView.addObject("article", article);
        return modelAndView;

    }

    @RequestMapping("/edit")
   @ResponseBody
    public String updateArticle(Article article) {
        boolean res = articleService.updateArticleById(article);
        if(res) {
            return "success";
        }
        return "false";
       // return "redirect:/article/page";
    }
}
