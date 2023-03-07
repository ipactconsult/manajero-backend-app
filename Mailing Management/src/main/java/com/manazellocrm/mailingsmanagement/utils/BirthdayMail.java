package com.manazellocrm.mailingsmanagement.utils;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BirthdayMail {
    public static final String EMAIL_PART_ONE="\n" +
            "<!doctype html>\n" +
            "<html lang=\"en-US\">\n" +
            "\n" +
            "<head>\n" +
            "    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n" +
            "    <title>Task Notification</title>\n" +
            "    <meta name=\"description\" content=\"Task Notification\">\n" +
            "    <style type=\"text/css\">\n" +
            "        a:hover {text-decoration: underline !important;}\n" +
            "    </style>\n" +
            "</head>\n" +
            "\n" +
            "<body marginheight=\"0\" topmargin=\"0\" marginwidth=\"0\" style=\"margin: 0px; background-color: #f2f3f8;\" leftmargin=\"0\">\n" +
            "    <!--100% body table-->\n" +
            "    <table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\"\n" +
            "        style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">\n" +
            "        <tr>\n" +
            "            <td>\n" +
            "                <table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\"\n" +
            "                    align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
            "                    <tr>\n" +
            "                        <td style=\"height:80px;\">&nbsp;</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td style=\"text-align:center;\">\n" +
            "                          <a href=\"https://rakeshmandal.com\" title=\"logo\" target=\"_blank\">\n" +
            "                            <img width=\"100\" height=\"150\" src=\"https://firebasestorage.googleapis.com/v0/b/crm-manazello.appspot.com/o/customers%2Fimage-3.png?alt=media&token=778b366b-609d-4295-8d58-4a11975ebbe5\" title=\"logo\" alt=\"logo\">\n" +
            "                          </a>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td style=\"height:20px;\">&nbsp;</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td>\n" +
            "                            <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"\n" +
            "                                style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">\n" +
            "                                <tr>\n" +
            "                                    <td style=\"height:40px;\">&nbsp;</td>\n" +
            "                                </tr>\n" +
            "                                <tr>\n" +
            "                                    <td style=\"padding:0 35px;\">\n" +
            "                                        <h1 style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">Birthday Wishes</h1>\n" +
            "                                        <span\n" +
            "                                            style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span>\n" +
            "                                       <img width=\"500\" src='https://firebasestorage.googleapis.com/v0/b/crm-manazello.appspot.com/o/customers%2FHappy%20birthday%2C%20BEST%20WISHES.png?alt=media&token=1fb64025-aa96-44a2-9536-489d93315a94'>" ;
    public static final String EMAIL_PART_TWO="" +
            "                                        </p>\n" +
            "                                      \n" +
            "                                       \n" +
            "                                    </td>\n" +
            "                                </tr>\n" +
            "                                <tr>\n" +
            "                                    <td style=\"height:40px;\">&nbsp;</td>\n" +
            "                                </tr>\n" +
            "                            </table>\n" +
            "                        </td>\n" +
            "                    <tr>\n" +
            "                        <td style=\"height:20px;\">&nbsp;</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td style=\"text-align:center;\">\n" +
            "                            <p style=\"font-size:14px; color:rgba(69, 80, 86, 0.7411764705882353); line-height:18px; margin:0 0 0;\">&copy; <strong>www.manazello.com</strong></p>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td style=\"height:80px;\">&nbsp;</td>\n" +
            "                    </tr>\n" +
            "                </table>\n" +
            "            </td>\n" +
            "        </tr>\n" +
            "    </table>\n" +
            "    <!--/100% body table-->\n" +
            "</body>\n" +
            "\n" +
            "</html>";
}
