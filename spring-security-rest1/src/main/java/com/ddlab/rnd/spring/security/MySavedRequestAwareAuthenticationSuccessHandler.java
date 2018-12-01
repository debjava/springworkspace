package com.ddlab.rnd.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

public class MySavedRequestAwareAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws ServletException, IOException {
        final SavedRequest savedRequest = requestCache.getRequest(request, response);
        
        if (savedRequest == null) {
            clearAuthenticationAttributes(request);
            System.out.println("---------------COMING_______--__--------------");
            System.out.println("---------------COMING_______--__--------------");
            setDefaultTargetUrl("/api/home");
            getRedirectStrategy().sendRedirect(request, response, "/api/home");
            return;
        }
        final String targetUrlParameter = getTargetUrlParameter();
        System.out.println("targetUrlParameter------------->"+targetUrlParameter);
        if (isAlwaysUseDefaultTargetUrl() || (targetUrlParameter != null && StringUtils.hasText(request.getParameter(targetUrlParameter)))) {
            requestCache.removeRequest(request, response);
            clearAuthenticationAttributes(request);
            return;
        }

        clearAuthenticationAttributes(request);
//        System.out.println("---------------COMING_______--__--------------");
//        setDefaultTargetUrl("/home");
//        getRedirectStrategy().sendRedirect(request, response, "/home");
//        super.onSuccessfulAuthentication(request, response, authentication);


        // Use the DefaultSavedRequest URL
//         final String targetUrl = savedRequest.getRedirectUrl();
//         logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
//         getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    public void setRequestCache(final RequestCache requestCache) {
        this.requestCache = requestCache;
    }
    
    
}
