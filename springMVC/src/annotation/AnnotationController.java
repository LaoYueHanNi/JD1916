package annotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//控制器得类
@Controller
@RequestMapping("/test")
public class AnnotationController {

		//返回ModelAndView的对象
		//处理请求得访问
		@RequestMapping("/h1.action")
		public ModelAndView test1() {
			ModelAndView mv = new ModelAndView("first");
			mv.addObject("msg","annotation");
			return mv;
		}
		
		//返回值2:返回String,逻辑视图名
			//传入参数:Model对象
		@RequestMapping("/h2.action")
		public String test(Model model) {
			model.addAttribute("msg", "annotation2");
			return "first";
		}
		
		//返回值3:返回void,不需要视图解析器
		@RequestMapping("/h3.action")
		public void test3(HttpServletResponse resp,HttpServletRequest req) {
			try {
				PrintWriter pw = resp.getWriter();
				pw.println("xixihaha1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	/*
	 * //注册功能 public String test4(User user) { //调用service层的方法进行业务逻辑处理 }
	 */

}
