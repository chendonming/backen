package com.xl.backen.filter;

import java.io.IOException;
import javax.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CORSFilter implements Filter {
  private final Logger logger = LoggerFactory.getLogger(CORSFilter.class);

  public CORSFilter() {
    logger.info("Simple CORSFilter init.");
  }

  @Override
  public void destroy() {

  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp,
                       FilterChain chain) throws IOException, ServletException {

    HttpServletResponse response = (HttpServletResponse) resp;
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Allow-Methods",
      "POST, GET, OPTIONS, DELETE, PUT");
    response.setHeader("Access-Control-Max-Age", "315360000");
    response.setHeader("Access-Control-Allow-Headers",
      "X-Requested-With, Origin, Content-Type, Accept, Authorization");
    chain.doFilter(req, resp);
  }

  @Override
  public void init(FilterConfig fc) throws ServletException {

  }

}