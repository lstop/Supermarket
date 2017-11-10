package com.lstop.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lstop.pojo.User;
import com.lstop.service.UsersService;
@Controller
public class UserController {
	@Autowired(required=false)
	private UsersService usersService;
	@ModelAttribute
	private void aaa(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
	}
	@RequestMapping(path = "/userlogin",method = RequestMethod.POST)
	public String selectByUnameAndUpassword(User user,HttpSession session) {
		/*List<User> users = usersService.selectByUnameAndUpassword(user);
		if(users!=null && users.size()>0) {
			session.setAttribute("user", users.get(0));
			return "redirect:admin_index.jsp";
		}
		return "redirect:login.jsp";*/
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(new UsernamePasswordToken(user.getUname(), user.getUpassword()));
			System.out.println("Success");
			List<User> users = usersService.selectByUnameAndUpassword(user);
			session.setAttribute("user", users.get(0));
			System.out.println(users);
			return "redirect:admin_index.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:login.jsp";
			// TODO: handle exception
		}
		
		
	}
	@RequestMapping(path = "/userlogout",method = RequestMethod.POST)
	public void userLogOut(HttpSession session,HttpServletResponse response) throws IOException {
		session.invalidate();
		response.getWriter().print("success");
	}
	
	@RequestMapping(path = "/adduser",method = RequestMethod.POST)
	public String adduser(User user) throws IOException {
		if(usersService.insert(user)>0) {
			return "redirect:listuserbypage";
		}
		return "main/userAdd";
	}
	@RequestMapping("/listuser")
	public String listuser(Map<String, Object> map) throws IOException {
		List<User> users = usersService.selectAll();
		map.put("users", users);
		return "userAdmin";
	}
	@RequestMapping(value="/listuserbypage",method=RequestMethod.GET)
	public String listuser(Map<String, Object> map,HttpServletRequest request) {
		System.out.println("1");
		int page = request.getParameter("page")==null?1:new Integer(request.getParameter("page"));
		int perpage = request.getParameter("perpage")==null?2:new Integer(request.getParameter("perpage"));
		System.out.println(page+" "+perpage);
		System.out.println("2");
		List<User> users = usersService.selectByPage((page-1)*perpage, perpage);
		System.out.println(3);
		map.put("users", users);
		map.put("pagehide", page);
		map.put("perpagehide", perpage);
		map.put("sizehide", (usersService.selectAll().size()+perpage-1)/perpage);
		System.out.println(map);
		return "userAdmin";
	}
	@RequestMapping("/main/reshow")
	public String reshow(User user,Map<String, Object> map) throws IOException {
		User user2 = usersService.selectByPrimaryKey(user.getUid());
		map.put("user", user2);
		return "main/userModify";
	}
	@RequestMapping("/modifyuser")
	public String modifyuser(User user) throws IOException {
		if(usersService.updateByPrimaryKey(user)>0) {
			return "redirect:listuserbypage";
		}
		return "main/userModify";
	}
	@RequestMapping("/deleteuser")
	public String deleteuser(User user) throws IOException {
		if(usersService.deleteByPrimaryKey(user.getUid())>0) {
			return "redirect:listuserbypage";
		}
		return "main/userModify";
	}
	
}
