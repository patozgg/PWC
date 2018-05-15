package com.camunda.na.training;

/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * This is a very simple javax.servlet.Filter implementation, in this case to illustrate that you can
 *   easily set a Filter in a Spring Boot application that will provide information on each and every
 *   request and response.
 *
 *	Using a filter and Copyrighter to extract the response and request. 
 * https://stackoverflow.com/questions/3242236/capture-and-log-the-response-body (This solution)
 * 
 * Attribution for the how-to for the declaration of the Bean in the Spring @Configuration-annotated class
 *   (from StackOverflow):
 *  
 *   https://stackoverflow.com/questions/26151057/add-a-servlet-filter-in-a-spring-boot-application#26157610 (Another Solution).
 *
 * @author Ryan Johnston, Director of Operations, Camunda, Inc  
 * @author Patricio Zambrano, Technical Consultant, Camunda, Inc.
 */
@WebFilter("/*")
public class TestFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {
        // NOOP.
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
    
        

        HttpServletResponseCopier responseCopier = new HttpServletResponseCopier((HttpServletResponse) response);

        try {
            chain.doFilter(request, responseCopier);
            responseCopier.flushBuffer();
        } finally {
            byte[] copy = responseCopier.getCopy();
            //Request
        
            System.out.println("This is a Request: "+ ((HttpServletRequest)request).getRequestURL().toString());
            
            
            //Response
            System.out.println("This is a Response: " + new String( copy));
          
            // Do your logging job here. This is just a basic example.
        }
    }

    public void destroy() {
        // NOOP.
    }

}
