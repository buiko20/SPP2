package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Downloader {

    protected void DownloadFile(HttpServletRequest request, HttpServletResponse response, String fileName) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String shortname=fileName.substring(fileName.lastIndexOf("\\")+1, fileName.length());
        response.setHeader("Content-Disposition", "attachment; filename=\""+shortname+"\"");
        response.setHeader("Content-Transfer-Encoding","binary;");

        String fileExt=shortname.substring(shortname.lastIndexOf(".")+1).toString();
        //Выставляем заголовок ответа
        String ContDispType="application/force-download";

        if (fileExt.toString().equalsIgnoreCase("pdf")) { ContDispType="application/pdf"; }
        if (fileExt.toString().equalsIgnoreCase("xls")) { ContDispType="application/vnd.ms-excel"; } //   "application/x-xls"

        response.setHeader("Content-Type",ContDispType);

        try
        {
            BufferedInputStream in = new BufferedInputStream (new FileInputStream(fileName));
            BufferedOutputStream binout = new BufferedOutputStream(response.getOutputStream());

            int ch=in.read();

            while(ch!=-1)
            {
                binout.write(ch);
                ch=in.read();
            }
            binout.close();
            in.close();
        }
        catch(IOException ioe) { }

    }

}
