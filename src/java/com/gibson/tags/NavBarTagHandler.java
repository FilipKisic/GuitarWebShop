package com.gibson.tags;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Filip Kisic
 */
public class NavBarTagHandler extends SimpleTagSupport {

    private String active;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            switch (active) {
                case "index":
                    setHomeActive(out);
                    break;
                case "guitar":
                    setGuitarActive(out);
                    break;
                case "contact":
                    setContactActive(out);
                    break;
                case "details":
                case "cart":
                    setOneIncrementPath(out);
                    break;
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in NavBarTagHandler tag", ex);
        }
    }

    public void setActive(String active) {
        this.active = active;
    }

    private void setHomeActive(JspWriter out) throws IOException {
        out.println("<nav class=\"navbar sticky-top navbar-expand-lg navbar-custom\">\n"
                + "            <a class=\"navbar-brand\" href=\"#\">\n"
                + "                <img src=\"res/images/gibson_logo.png\" width=\"120\">\n"
                + "            </a>\n"
                + "            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\n"
                + "                    aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                + "                <span class=\"navbar-toggler-icon\"></span>\n"
                + "            </button>\n"
                + "            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"
                + "                <ul class=\"navbar-nav mr-auto\">\n"
                + "                    <li class=\"nav-item active\">\n"
                + "                        <a class=\"nav-link\" href=\"index.jsp\">Home <span class=\"sr-only\">(current)</span></a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item dropdown\">\n"
                + "                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\"\n"
                + "                           data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n"
                + "                            Guitars\n"
                + "                        </a>\n"
                + "                        <div class=\"dropdown-menu custom-menu\" aria-labelledby=\"navbarDropdown\">\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"showlespaul\">Les Paul</a>\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"showsg\">SG</a>\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"showes\">ES</a>\n"
                + "                        </div>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"contact.jsp\">Contact</a>\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <a class=\"nav-link\" href=\"login.jsp\">Login</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }

    //ORIGNAL VERSION
    /*
        out.println("<nav class=\"navbar sticky-top navbar-expand-lg navbar-custom\">\n"
                + "            <a class=\"navbar-brand\" href=\"#\">\n"
                + "                <img src=\"res/images/gibson_logo.png\" width=\"120\">\n"
                + "            </a>\n"
                + "            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\n"
                + "                    aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                + "                <span class=\"navbar-toggler-icon\"></span>\n"
                + "            </button>\n"
                + "            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"
                + "                <ul class=\"navbar-nav mr-auto\">\n"
                + "                    <li class=\"nav-item active\">\n"
                + "                        <a class=\"nav-link\" href=\"index.jsp\">Home <span class=\"sr-only\">(current)</span></a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item dropdown\">\n"
                + "                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\"\n"
                + "                           data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n"
                + "                            Guitars\n"
                + "                        </a>\n"
                + "                        <div class=\"dropdown-menu custom-menu\" aria-labelledby=\"navbarDropdown\">\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"showlespaul\">Les Paul</a>\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"showsg\">SG</a>\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"showes\">ES</a>\n"
                + "                        </div>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"contact.jsp\">Contact</a>\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <%if (session.getAttribute(\"username\") == null) {%>\n"
                + "                <a class=\"nav-link\" href=\"login.jsp\">Login</a>\n"
                + "                <%} else {%>\n"
                + "                <a class=\"nav-link\" href=\"#\"><%= session.getAttribute(\"username\")%></a>\n"
                + "                <% }%>\n"
                + "            </div>\n"
                + "        </nav>");
     */
    private void setGuitarActive(JspWriter out) throws IOException {
        out.println("<nav class=\"navbar sticky-top navbar-expand-lg navbar-custom\">\n"
                + "            <a class=\"navbar-brand\" href=\"#\">\n"
                + "                <img src=\"res/images/gibson_logo.png\" width=\"120\">\n"
                + "            </a>\n"
                + "            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\n"
                + "                    aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                + "                <span class=\"navbar-toggler-icon\"></span>\n"
                + "            </button>\n"
                + "            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"
                + "                <ul class=\"navbar-nav mr-auto\">\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"index.jsp\">Home</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item dropdown active\">\n"
                + "                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\"\n"
                + "                           data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n"
                + "                            Guitars\n"
                + "                        </a>\n"
                + "                        <div class=\"dropdown-menu custom-menu\" aria-labelledby=\"navbarDropdown\">\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"showlespaul\">Les Paul</a>\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"showsg\">SG</a>\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"showes\">ES</a>\n"
                + "                        </div>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"contact.jsp\">Contact</a>\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <a class=\"nav-link\" href=\"login.jsp\">Login</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }

    private void setContactActive(JspWriter out) throws IOException {
        out.println("<nav class=\"navbar sticky-top navbar-expand-lg navbar-custom\">\n"
                + "            <a class=\"navbar-brand\" href=\"#\">\n"
                + "                <img src=\"res/images/gibson_logo.png\" width=\"120\">\n"
                + "            </a>\n"
                + "            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\n"
                + "                    aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                + "                <span class=\"navbar-toggler-icon\"></span>\n"
                + "            </button>\n"
                + "            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"
                + "                <ul class=\"navbar-nav mr-auto\">\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"index.jsp\">Home</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item dropdown\">\n"
                + "                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\"\n"
                + "                           data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n"
                + "                            Guitars\n"
                + "                        </a>\n"
                + "                        <div class=\"dropdown-menu custom-menu\" aria-labelledby=\"navbarDropdown\">\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"showlespaul\">Les Paul</a>\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"showsg\">SG</a>\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"showes\">ES</a>\n"
                + "                        </div>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item active\">\n"
                + "                        <a class=\"nav-link\" href=\"contact.jsp\">Contact</a>\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <a class=\"nav-link\" href=\"login.jsp\">Login</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }

    private void setOneIncrementPath(JspWriter out) throws IOException {
        out.println("<nav class=\"navbar sticky-top navbar-expand-lg navbar-custom\">\n"
                + "            <a class=\"navbar-brand\" href=\"#\">\n"
                + "                <img src=\"../res/images/gibson_logo.png\" width=\"120\">\n"
                + "            </a>\n"
                + "            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\n"
                + "                    aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                + "                <span class=\"navbar-toggler-icon\"></span>\n"
                + "            </button>\n"
                + "            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"
                + "                <ul class=\"navbar-nav mr-auto\">\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"../index.jsp\">Home</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item dropdown active\">\n"
                + "                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\"\n"
                + "                           data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n"
                + "                            Guitars\n"
                + "                        </a>\n"
                + "                        <div class=\"dropdown-menu custom-menu\" aria-labelledby=\"navbarDropdown\">\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"../showlespaul\">Les Paul</a>\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"../showsg\">SG</a>\n"
                + "                            <a class=\"dropdown-item custom-item\" href=\"../showes\">ES</a>\n"
                + "                        </div>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"../contact.jsp\">Contact</a>\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <a class=\"nav-link\" href=\"../login.jsp\">Login</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }
}
