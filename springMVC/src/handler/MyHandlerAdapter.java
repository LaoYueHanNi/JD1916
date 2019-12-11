package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerAdapter implements HandlerAdapter{

	//判断该控制器的对象是否属于某个类的实例
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof MyHandler);
	}
	
	//该控制器应该调用什么方法处理请求
	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse resp,
			Object handler) throws Exception {
		return ((MyHandler)handler).test(req, resp);
	}
	
	//返回该控制器最后一次修改的时间
	@Override
	public long getLastModified(HttpServletRequest paramHttpServletRequest, Object paramObject) {
		return -1L;
	}

}
