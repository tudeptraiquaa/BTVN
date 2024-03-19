/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package CustomTags;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tu
 */
public class ConvertToVnDate extends SimpleTagSupport {

    private String value;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            String[] d = value.split("-");
            out.print("<h4>");
            out.print("Ngay "+d[1]+", thang "+d[0]+", nam "+d[2]);
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
            
            out.print("</h4>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in ConvertToVnDate tag", ex);
        }

    }

    public void setValue(String value) {
        this.value = value;
    }

}
