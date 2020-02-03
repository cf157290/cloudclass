package com.wscloudclass.interceptor;

import com.wscloudclass.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies=request.getCookies();
        if (cookies!=null&&cookies.length!=0&&request.getSession().getAttribute("user")==null){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals("token")){
                    String token=cookie.getValue();
                    UserDTO userDTO= (UserDTO) redisTemplate.opsForValue().get(token);
                    if (userDTO!=null){
                        request.getSession().setAttribute("user",userDTO);
                    }
                    break;
                }
            }
        }
        if (request.getSession().getAttribute("user")!=null){
            return true;
        }else {
            response.sendRedirect("/");
//            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }

    }
}
