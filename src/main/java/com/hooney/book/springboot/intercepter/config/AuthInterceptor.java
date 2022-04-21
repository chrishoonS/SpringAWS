package com.hooney.book.springboot.intercepter.config;

import com.hooney.book.springboot.intercepter.User;
import com.hooney.book.springboot.intercepter.testEnum.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    /*
     * 실제 controller(handler)가 실행되기 전에 실행
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception{
        // handler 종류 확인 -> HandlerMethod 타입인지 체크, 아니면 그대로 진행
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        MySecured mySecured = handlerMethod.getMethodAnnotation(MySecured.class);

        if(mySecured == null) return true; //인증이 필요없는 요청

        //세션 체크
        HttpSession session = request.getSession();
        if(session == null){
            response.sendRedirect("/my-error");
            return false;
        }

        //세션이 존재하면 유효한 유저 확인
        User user = (User) session.getAttribute("user");
        if(user == null){
            response.sendRedirect("/my-error");
            return false;
        }

        //admin일 경우
        String role = mySecured.role().toString();
        if(role != null){
            if("ADMIN".equals(role)){
                if(user.getRole() != Role.ADMIN){
                    response.sendRedirect("/my-error");
                    return false;
                }
            }
        }

        //접근 허가
        return true;
    }

    /*
     * prehandle 실행 후 실행
     */
    @Override
    public void postHandle(HttpServletRequest request,
                              HttpServletResponse response, Object handler, ModelAndView model) throws Exception{
    }

    /*
     * 전체 요청이 끝나고 마지막에 실행
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception{
    }
}
