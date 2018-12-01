package com.iit.test.spring.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ddlab.rnd.util.XMLUtil;
import com.ddlab.rnd.web.beans.User;

public class LoginController extends AbstractController  
{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		ModelAndView modelNView = new ModelAndView();
		String userName = request.getParameter("username");
		String pwd = request.getParameter("password");
		try {
			boolean userFlag = false;
			List<User> userList = XMLUtil.getUserInfoList();
			for( User user : userList ) {
				if( user.getFirstName().equals(userName) && user.getPassword().equals(pwd)) {
					userFlag = true;
					break;
				}
			}
			if( userFlag )
				modelNView.setViewName("/WEB-INF/pages/success.jsp");
			else
				modelNView.setViewName("/WEB-INF/pages/failurelogin.jsp");
		}
		catch( Exception e ) {
			e.printStackTrace();
			modelNView.setViewName("/WEB-INF/pages/failurelogin.jsp");
		}
		
		return modelNView;
	}

}
