package com.pablofiumara.controlador;

import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.CopyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Controller
public class RevenueReportController {

	@RequestMapping(value = "/pdf")
    public void generatePdf(HttpServletRequest req,HttpServletResponse res)
    {
        res.setContentType("text/html;charset=UTF-8");
        ServletOutputStream outStream=null;
        try 
        {
            String calledFrom = req.getHeader("referer");
            calledFrom=req.getRequestURL().substring(0,req.getRequestURL().lastIndexOf("/"))+"/ReportGenerator.egp";
            calledFrom += "?isPdf=yes&"+req.getQueryString();
            System.out.println(calledFrom+"?isPdf=yes&"+req.getQueryString());



            InputStream input = new URL(calledFrom).openStream();
            StringWriter writer = new StringWriter();
            CopyUtils.copy(input, writer);

            //System.out.println(writer.toString());

            res.setContentType("application/pdf");
            res.setHeader("Content-Disposition", "attachment;filename=report.pdf");
            outStream = res.getOutputStream();

            ITextRenderer renderer = new ITextRenderer();


            renderer.setDocument(calledFrom);
            renderer.layout();
            renderer.createPDF(outStream);

        } 
        catch (Exception e) 
        {
        	System.out.println("Exception");
        }
        finally
        {
            try
            {
                outStream.flush();
                outStream.close();
            }
            catch(Exception ex)
            {
                System.out.println("Exception");
            }

        }


    }

}