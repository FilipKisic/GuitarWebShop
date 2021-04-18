package com.gibson.tags;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Filip Kisic
 */
public class FooterTagHandler extends SimpleTagSupport {

    private String active;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            switch (active) {
                case "standard":
                    standardFooter(out);
                    break;
                case "oneIncrement":
                    oneIncrementFooter(out);
                    break;
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in FooterTagHandler tag", ex);
        }
    }

    public void setActive(String active) {
        this.active = active;
    }

    private void standardFooter(JspWriter out) throws IOException {
        out.println("<footer>\n"
                + "            <div class=\"row my-5 justify-content-center py-5 footer-row\">\n"
                + "                <div class=\"col-11\">\n"
                + "                    <div class=\"row \">\n"
                + "                        <div class=\"col-xl-8 col-md-4 col-sm-4 col-12 my-auto mx-auto a\">\n"
                + "                            <img src=\"res/images/gibson_logo.png\" class=\"img-fluid\" width=\"250\">\n"
                + "                        </div>\n"
                + "                        <div class=\"col-xl-2 col-md-4 col-sm-4 col-12\">\n"
                + "                            <h6 class=\"mb-3 mb-lg-4 bold-text \"><b>MENU</b></h6>\n"
                + "                            <ul class=\"list-unstyled\">\n"
                + "                                <li><a href=\"index.jsp\" class=\"custom-link\">Home</a></li>\n"
                + "                                <li><a href=\"showlespaul\" class=\"custom-link\">Guitars</a></li>\n"
                + "                                <li><a href=\"contact.jsp\" class=\"custom-link\">Contact</a></li>\n"
                + "                            </ul>\n"
                + "                        </div>\n"
                + "                        <div class=\"col-xl-2 col-md-4 col-sm-4 col-12\">\n"
                + "                            <h6 class=\"mb-3 mb-lg-4 text-muted bold-text mt-sm-0 mt-5\"><b>ADDRESS</b></h6>\n"
                + "                            <p class=\"mb-1\">209 10th Ave S, Ste 460</p>\n"
                + "                            <p>Nashville, Tennessee, USA</p>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                    <div class=\"row \">\n"
                + "                        <div class=\"col-xl-8 col-md-4 col-sm-4 col-auto my-md-0 mt-5 order-sm-1 order-3 align-self-end\">\n"
                + "                            <p class=\"social text-muted mb-0 pb-0 bold-text\">\n"
                + "                                <a href=\"https://www.facebook.com/Gibson/\" class=\"mx-2\"><i\n"
                + "                                        class=\"fa fa-facebook custom-icon\" aria-hidden=\"true\"></i></a>\n"
                + "                                <a href=\"https://www.youtube.com/user/GibsonGuitarCorp\" class=\"mx-2\"><i\n"
                + "                                        class=\"fa fa-youtube custom-icon\" aria-hidden=\"true\"></i></a>\n"
                + "                                <a href=\"https://twitter.com/gibsonguitar\" class=\"mx-2\"><i class=\"fa fa-twitter custom-icon\"\n"
                + "                                                                                           aria-hidden=\"true\"></i></a>\n"
                + "                                <a href=\"https://www.instagram.com/gibsonguitar/\" class=\"mx-2\"><i\n"
                + "                                        class=\"fa fa-instagram custom-icon\" aria-hidden=\"true\"></i></a>\n"
                + "                            </p>\n"
                + "                            <small class=\"rights\"><span>&#174;</span> Gibson All Rights Reserved.</small>\n"
                + "                        </div>\n"
                + "                        <div class=\"col-xl-2 col-md-4 col-sm-4 col-auto order-1 align-self-end \">\n"
                + "                            <h6 class=\"mt-55 mt-2 text-muted bold-text\"><b>Email</b></h6>\n"
                + "                            <small><span><i class=\"fa fa-envelope\" aria-hidden=\"true\"></i></span> info@gibson.com</small>\n"
                + "                        </div>\n"
                + "                        <div class=\"col-xl-2 col-md-4 col-sm-4 col-auto order-2 align-self-end mt-3 \">\n"
                + "                            <h6 class=\"text-muted bold-text\"><b>Questions, comments?</b></h6>\n"
                + "                            <small>We're all ears.</small>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </footer>");
    }

    private void oneIncrementFooter(JspWriter out) throws IOException {
        out.println("<footer>\n"
                + "            <div class=\"row my-5 justify-content-center py-5 footer-row\">\n"
                + "                <div class=\"col-11\">\n"
                + "                    <div class=\"row \">\n"
                + "                        <div class=\"col-xl-8 col-md-4 col-sm-4 col-12 my-auto mx-auto a\">\n"
                + "                            <img src=\"../res/images/gibson_logo.png\" class=\"img-fluid\" width=\"250\">\n"
                + "                        </div>\n"
                + "                        <div class=\"col-xl-2 col-md-4 col-sm-4 col-12\">\n"
                + "                            <h6 class=\"mb-3 mb-lg-4 bold-text \"><b>MENU</b></h6>\n"
                + "                            <ul class=\"list-unstyled\">\n"
                + "                                <li><a href=\"../index.jsp\" class=\"custom-link\">Home</a></li>\n"
                + "                                <li><a href=\"../showlespaul\" class=\"custom-link\">Guitars</a></li>\n"
                + "                                <li><a href=\"../contact.jsp\" class=\"custom-link\">Contact</a></li>\n"
                + "                            </ul>\n"
                + "                        </div>\n"
                + "                        <div class=\"col-xl-2 col-md-4 col-sm-4 col-12\">\n"
                + "                            <h6 class=\"mb-3 mb-lg-4 text-muted bold-text mt-sm-0 mt-5\"><b>ADDRESS</b></h6>\n"
                + "                            <p class=\"mb-1\">209 10th Ave S, Ste 460</p>\n"
                + "                            <p>Nashville, Tennessee, USA</p>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                    <div class=\"row \">\n"
                + "                        <div class=\"col-xl-8 col-md-4 col-sm-4 col-auto my-md-0 mt-5 order-sm-1 order-3 align-self-end\">\n"
                + "                            <p class=\"social text-muted mb-0 pb-0 bold-text\">\n"
                + "                                <a href=\"https://www.facebook.com/Gibson/\" class=\"mx-2\"><i\n"
                + "                                        class=\"fa fa-facebook custom-icon\" aria-hidden=\"true\"></i></a>\n"
                + "                                <a href=\"https://www.youtube.com/user/GibsonGuitarCorp\" class=\"mx-2\"><i\n"
                + "                                        class=\"fa fa-youtube custom-icon\" aria-hidden=\"true\"></i></a>\n"
                + "                                <a href=\"https://twitter.com/gibsonguitar\" class=\"mx-2\"><i class=\"fa fa-twitter custom-icon\"\n"
                + "                                                                                           aria-hidden=\"true\"></i></a>\n"
                + "                                <a href=\"https://www.instagram.com/gibsonguitar/\" class=\"mx-2\"><i\n"
                + "                                        class=\"fa fa-instagram custom-icon\" aria-hidden=\"true\"></i></a>\n"
                + "                            </p>\n"
                + "                            <small class=\"rights\"><span>&#174;</span> Gibson All Rights Reserved.</small>\n"
                + "                        </div>\n"
                + "                        <div class=\"col-xl-2 col-md-4 col-sm-4 col-auto order-1 align-self-end \">\n"
                + "                            <h6 class=\"mt-55 mt-2 text-muted bold-text\"><b>Email</b></h6>\n"
                + "                            <small><span><i class=\"fa fa-envelope\" aria-hidden=\"true\"></i></span> info@gibson.com</small>\n"
                + "                        </div>\n"
                + "                        <div class=\"col-xl-2 col-md-4 col-sm-4 col-auto order-2 align-self-end mt-3 \">\n"
                + "                            <h6 class=\"text-muted bold-text\"><b>Questions, comments?</b></h6>\n"
                + "                            <small>We're all ears.</small>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </footer>");
    }
}
