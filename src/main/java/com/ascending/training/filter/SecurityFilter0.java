//package com.ascending.training.filter;
//
//import com.ascending.training.model.User;
//import com.ascending.training.service.JWTService;
//import com.ascending.training.service.UserService;
//import com.sun.org.apache.bcel.internal.ExceptionConst;
//import io.jsonwebtoken.Claims;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.context.support.SpringBeanAutowiringSupport;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(filterName = "securityFilter", urlPatterns = {"/*"},dispatcherTypes = {DispatcherType.REQUEST})
//public class SecurityFilter implements Filter {
//
//    @Autowired private JWTService jwtService;
//
//    @Autowired private UserService userService;
//
//    private static String AUTH_URI = "/auth";
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        //1 extract Authorization Header
//        //2 remove Bearer to get token
//        //3 decrypt token to get claim
//        //4 verify username information in our database from claim
//        //5 doFilter dispatch to controller
//
//        if (userService == null){
//            SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
//        }
//        HttpServletRequest req = (HttpServletRequest)request;
//        int statusCode = authorization((HttpServletRequest)request);
//        if (statusCode == HttpServletResponse.SC_ACCEPTED) chain.doFilter(request, response);
//        else ((HttpServletResponse)response).sendError(statusCode);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//    private int authorization(HttpServletRequest req){
//        int statusCode = HttpServletResponse.SC_UNAUTHORIZED;
//        String uri = req.getRequestURI();
//        String verb = req.getMethod();
//        if (uri.equalsIgnoreCase(AUTH_URI)) return HttpServletResponse.SC_ACCEPTED;
//
//        try{
//            String token = req.getHeader("Authorization").replaceAll("^(.*?) ", "");
//            if (token == null || token.isEmpty()) return statusCode;
//
//            Claims claims = jwtService.decryptJwtToken(token);
//            //TODO pass username and check role
//
//            if(claims.getId()!= null){
//                User u = userService.findByID(Long.valueOf(claims.getId()));
//                if(u==null) return statusCode;
//                statusCode = HttpServletResponse.SC_ACCEPTED;
//            }
//
////            String allowedResources = "/";
////            switch(verb) {
////                case "GET"    : allowedResources = (String)claims.get("allowedReadResources");   break;
////                case "POST"   : allowedResources = (String)claims.get("allowedCreateResources"); break;
////                case "PUT"    : allowedResources = (String)claims.get("allowedUpdateResources"); break;
////                case "DELETE" : allowedResources = (String)claims.get("allowedDeleteResources"); break;
////            }
////
////            for (String s : allowedResources.split(",")) {
////                if (uri.trim().toLowerCase().startsWith(s.trim().toLowerCase())) {
////                    statusCode = HttpServletResponse.SC_ACCEPTED;
////                    break;
////                }
////            }
//
//        }catch (Exception e){
//            logger.error("can't verify the token",e);
//        }
//        return statusCode;
//    }
//}
//
