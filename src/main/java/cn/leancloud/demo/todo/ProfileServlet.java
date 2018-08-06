package cn.leancloud.demo.todo;

import com.alibaba.fastjson.JSONObject;
import com.avos.avoscloud.AVUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {
    resp.setContentType("application/json; charset=UTF-8");
    JSONObject result = new JSONObject();
    if (AVUser.getCurrentUser() == null) {
      result.put("currentUser", null);
    } else {
      result.put("currentUser", AVUser.getCurrentUser());
    }
    resp.getWriter().write(result.toJSONString());
  }
}
