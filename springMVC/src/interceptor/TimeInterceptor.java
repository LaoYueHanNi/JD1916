package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeInterceptor implements HandlerInterceptor{

	//ÿ�����������Լ�����
	private ThreadLocal<Long> local = new ThreadLocal<Long>();
	//ȡ��ʼʱ��
	@Override
	public boolean preHandle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse,
			Object paramObject) throws Exception {
		local.set(System.currentTimeMillis());
		return true;
	}
	//ȡ����ʱ��
	@Override
	public void postHandle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse,
			Object paramObject, ModelAndView paramModelAndView) throws Exception {
		System.out.println("���ĵ�ʱ��:"+(System.currentTimeMillis()-local.get()));
	}

	@Override
	public void afterCompletion(HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse, Object paramObject, Exception paramException)
			throws Exception {
		
	}

}