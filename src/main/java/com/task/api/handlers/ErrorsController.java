package com.task.api.handlers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorsController implements ErrorController
{
    @RequestMapping("/error")
    public void handleError(HttpServletRequest request)
    {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if(status != null)
        {
            int statusCode = Integer.parseInt(status.toString());
            throw new IllegalArgumentException("Unexpected value " + statusCode);
        }
    }

    @Override
    public String getErrorPath()
    {
        return "/error";
    }
}
