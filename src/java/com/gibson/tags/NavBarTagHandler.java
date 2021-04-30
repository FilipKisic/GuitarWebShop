package com.gibson.tags;

import com.gibson.utils.Constants;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Filip Kisic
 */
public class NavBarTagHandler extends SimpleTagSupport {

    private String active;
    private String loggedInUser;
    private String username;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        loggedInUser = (String) getJspContext().getAttribute(Constants.USERNAME, PageContext.SESSION_SCOPE);
        username = loggedInUser == null ? "Login" : loggedInUser;
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
                case "history":
                    setAdminHistory(out);
                    break;
                case "adminIndex":
                    setAdminIndex(out);
                    break;
                case "adminGuitar":
                    setAdminGuitar(out);
                    break;
                case "adminContact":
                    setAdminContact(out);
                    break;
                case "adminDetails":
                    setOneIncrementAdmin(out);
                    break;
                case "adminInfo":
                    setAdminInfo(out);
                    break;
                case "adminCrud":
                    setAdminCrud(out);
                    break;
                default:
                    setNoActive(out);
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
                + "                <a class=\"nav-link fas fa-shopping-bag\" href=\"cart/?itemId=0&remove=false\"></a>"
                + "                <a class=\"nav-link\" href=\"login.jsp\">" + username + "</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }

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
                + "                </ul>"
                + "                <a class=\"nav-link fas fa-shopping-bag\" href=\"cart/?itemId=0&remove=false\"></a>\n"
                + "                <a class=\"nav-link\" href=\"login.jsp\">" + username + "</a>\n"
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
                + "                <a class=\"nav-link fas fa-shopping-bag\" href=\"cart/?itemId=0&remove=false\"></a>"
                + "                <a class=\"nav-link\" href=\"login.jsp\">" + username + "</a>\n"
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
                + "                <a class=\"nav-link fas fa-shopping-bag\" href=\"../cart/?itemId=0&remove=false\"></a>"
                + "                <a class=\"nav-link\" href=\"../login.jsp\">" + username + "</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }

    private void setNoActive(JspWriter out) throws IOException {
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
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"contact.jsp\">Contact</a>\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <a class=\"nav-link\" href=\"login.jsp\">" + username + "</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }

    private void setAdminHistory(JspWriter out) throws IOException {
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
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"contact.jsp\">Contact</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item active\">\n"
                + "                        <a class=\"nav-link\" href=\"allHistory\">History</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"info\">Info</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"crud\">Manage Items</a>\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <a class=\"nav-link fas fa-shopping-bag\" href=\"cart/?itemId=0&remove=false\"></a>"
                + "                <a class=\"nav-link\" href=\"login.jsp\">" + username + "</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }

    private void setAdminIndex(JspWriter out) throws IOException {
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
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"contact.jsp\">Contact</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"allHistory\">History</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"info\">Info</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"crud\">Manage Items</a>\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <a class=\"nav-link fas fa-shopping-bag\" href=\"cart/?itemId=0&remove=false\"></a>"
                + "                <a class=\"nav-link\" href=\"login.jsp\">" + username + "</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }

    private void setAdminGuitar(JspWriter out) throws IOException {
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
                + "                    <li class=\"nav-item active dropdown\">\n"
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
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"allHistory\">History</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"info\">Info</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"crud\">Manage Items</a>\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <a class=\"nav-link fas fa-shopping-bag\" href=\"cart/?itemId=0&remove=false\"></a>"
                + "                <a class=\"nav-link\" href=\"login.jsp\">" + username + "</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }

    private void setAdminContact(JspWriter out) throws IOException {
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
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"allHistory\">History</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"info\">Info</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"crud\">Manage Items</a>\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <a class=\"nav-link fas fa-shopping-bag\" href=\"cart/?itemId=0&remove=false\"></a>"
                + "                <a class=\"nav-link\" href=\"login.jsp\">" + username + "</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }

    private void setOneIncrementAdmin(JspWriter out) throws IOException {
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
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"../allHistory\">History</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"../info\">Info</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"../crud\">Manage Items</a>\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <a class=\"nav-link fas fa-shopping-bag\" href=\"../cart/?itemId=0&remove=false\"></a>"
                + "                <a class=\"nav-link\" href=\"../login.jsp\">" + username + "</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }

    private void setAdminInfo(JspWriter out) throws IOException {
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
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"contact.jsp\">Contact</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"allHistory\">History</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item active\">\n"
                + "                        <a class=\"nav-link\" href=\"info\">Info</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"crud\">Manage Items</a>\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <a class=\"nav-link fas fa-shopping-bag\" href=\"cart/?itemId=0&remove=false\"></a>"
                + "                <a class=\"nav-link\" href=\"login.jsp\">" + username + "</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }

    private void setAdminCrud(JspWriter out) throws IOException {
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
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"contact.jsp\">Contact</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"allHistory\">History</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item\">\n"
                + "                        <a class=\"nav-link\" href=\"info\">Info</a>\n"
                + "                    </li>\n"
                + "                    <li class=\"nav-item active\">\n"
                + "                        <a class=\"nav-link\" href=\"crud\">Manage Items</a>\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <a class=\"nav-link fas fa-shopping-bag\" href=\"cart/?itemId=0&remove=false\"></a>"
                + "                <a class=\"nav-link\" href=\"login.jsp\">" + username + "</a>\n"
                + "            </div>\n"
                + "        </nav>");
    }
}
