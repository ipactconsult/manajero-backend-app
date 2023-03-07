package com.manazellocrm.customermanagement.business.businessimpl;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmailTemplate {
    public static final String EMAIL="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
            "<head>\n" +
            "<!--[if gte mso 9]>\n" +
            "<xml>\n" +
            "  <o:OfficeDocumentSettings>\n" +
            "    <o:AllowPNG/>\n" +
            "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
            "  </o:OfficeDocumentSettings>\n" +
            "</xml>\n" +
            "<![endif]-->\n" +
            "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
            "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
            "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
            "  <title></title>\n" +
            "  \n" +
            "    <style type=\"text/css\">\n" +
            "      @media only screen and (min-width: 610px) {\n" +
            "  .u-row {\n" +
            "    width: 590px !important;\n" +
            "  }\n" +
            "  .u-row .u-col {\n" +
            "    vertical-align: top;\n" +
            "  }\n" +
            "\n" +
            "  .u-row .u-col-100 {\n" +
            "    width: 590px !important;\n" +
            "  }\n" +
            "\n" +
            "}\n" +
            "\n" +
            "@media (max-width: 610px) {\n" +
            "  .u-row-container {\n" +
            "    max-width: 100% !important;\n" +
            "    padding-left: 0px !important;\n" +
            "    padding-right: 0px !important;\n" +
            "  }\n" +
            "  .u-row .u-col {\n" +
            "    min-width: 320px !important;\n" +
            "    max-width: 100% !important;\n" +
            "    display: block !important;\n" +
            "  }\n" +
            "  .u-row {\n" +
            "    width: calc(100% - 40px) !important;\n" +
            "  }\n" +
            "  .u-col {\n" +
            "    width: 100% !important;\n" +
            "  }\n" +
            "  .u-col > div {\n" +
            "    margin: 0 auto;\n" +
            "  }\n" +
            "}\n" +
            "body {\n" +
            "  margin: 0;\n" +
            "  padding: 0;\n" +
            "}\n" +
            "\n" +
            "table,\n" +
            "tr,\n" +
            "td {\n" +
            "  vertical-align: top;\n" +
            "  border-collapse: collapse;\n" +
            "}\n" +
            "\n" +
            "p {\n" +
            "  margin: 0;\n" +
            "}\n" +
            "\n" +
            ".ie-container table,\n" +
            ".mso-container table {\n" +
            "  table-layout: fixed;\n" +
            "}\n" +
            "\n" +
            "* {\n" +
            "  line-height: inherit;\n" +
            "}\n" +
            "\n" +
            "a[x-apple-data-detectors='true'] {\n" +
            "  color: inherit !important;\n" +
            "  text-decoration: none !important;\n" +
            "}\n" +
            "\n" +
            "table, td { color: #000000; } a { color: #ffffff; text-decoration: underline; }\n" +
            "    </style>\n" +
            "  \n" +
            "  \n" +
            "\n" +
            "</head>\n" +
            "\n" +
            "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #04045d;color: #000000\">\n" +
            "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
            "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
            "  <table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #04045d;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
            "  <tbody>\n" +
            "  <tr style=\"vertical-align: top\">\n" +
            "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
            "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #04045d;\"><![endif]-->\n" +
            "    \n" +
            "\n" +
            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 590px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
            "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:590px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
            "      \n" +
            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"590\" style=\"width: 590px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 590px;display: table-cell;vertical-align: top;\">\n" +
            "  <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
            "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
            "  \n" +
            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
            "  <tbody>\n" +
            "    <tr>\n" +
            "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
            "        \n" +
            "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
            "  <tr>\n" +
            "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
            "      \n" +
            "      <img align=\"center\" border=\"0\" src=\"https://firebasestorage.googleapis.com/v0/b/crm-manazello.appspot.com/o/customers%2Fimage-3.png?alt=media&token=778b366b-609d-4295-8d58-4a11975ebbe5\" alt=\"\" title=\"\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 372px;\" width=\"372\"/>\n" +
            "      \n" +
            "    </td>\n" +
            "  </tr>\n" +
            "</table>\n" +
            "\n" +
            "      </td>\n" +
            "    </tr>\n" +
            "  </tbody>\n" +
            "</table>\n" +
            "\n" +
            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
            "  <tbody>\n" +
            "    <tr>\n" +
            "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
            "        \n" +
            "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
            "    <tbody>\n" +
            "      <tr style=\"vertical-align: top\">\n" +
            "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
            "          <span>&#160;</span>\n" +
            "        </td>\n" +
            "      </tr>\n" +
            "    </tbody>\n" +
            "  </table>\n" +
            "\n" +
            "      </td>\n" +
            "    </tr>\n" +
            "  </tbody>\n" +
            "</table>\n" +
            "\n" +
            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
            "  </div>\n" +
            "</div>\n" +
            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
            "    </div>\n" +
            "  </div>\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 590px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
            "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:590px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
            "      \n" +
            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"590\" style=\"width: 590px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 590px;display: table-cell;vertical-align: top;\">\n" +
            "  <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
            "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
            "  \n" +
            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
            "  <tbody>\n" +
            "    <tr>\n" +
            "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:11px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
            "        \n" +
            "  <h1 style=\"margin: 0px; color: #ffffff; line-height: 150%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: verdana,geneva; font-size: 32px;\">\n" +
            "    HELLO!\n" +
            "  </h1>\n" +
            "\n" +
            "      </td>\n" +
            "    </tr>\n" +
            "  </tbody>\n" +
            "</table>\n" +
            "\n" +
            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
            "  </div>\n" +
            "</div>\n" +
            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
            "    </div>\n" +
            "  </div>\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 590px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
            "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:590px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
            "      \n" +
            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"590\" style=\"width: 590px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 590px;display: table-cell;vertical-align: top;\">\n" +
            "  <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
            "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
            "  \n" +
            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
            "  <tbody>\n" +
            "    <tr>\n" +
            "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
            "        \n" +
            "  <div style=\"color: #ffffff; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
            "    <p style=\"font-size: 14px; line-height: 140%;\">Thank you for your interest in Manazello.</p>\n" ;
            public static final String email2=
            "  </div>\n" +
            "\n" +
            "      </td>\n" +
            "    </tr>\n" +
            "  </tbody>\n" +
            "</table>\n" +
            "\n" +
            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
            "  <tbody>\n" +
            "    <tr>\n" +
            "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
            "        \n" +
            "<div align=\"center\">\n" +
            "  <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;font-family:arial,helvetica,sans-serif;\"><tr><td style=\"font-family:arial,helvetica,sans-serif;\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"\" style=\"height:37px; v-text-anchor:middle; width:94px;\" arcsize=\"11%\" stroke=\"f\" fillcolor=\"#3AAEE0\"><w:anchorlock/><center style=\"color:#FFFFFF;font-family:arial,helvetica,sans-serif;\"><![endif]-->\n" +
            "    <a href=\"\" target=\"_blank\" style=\"box-sizing: border-box;display: inline-block;font-family:arial,helvetica,sans-serif;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #FFFFFF; background-color: #3AAEE0; border-radius: 4px;-webkit-border-radius: 4px; -moz-border-radius: 4px; width:auto; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;\">\n" +
            "      <span style=\"display:block;padding:10px 20px;line-height:120%;\"><span style=\"font-size: 14px; line-height: 16.8px;\">Click me</span></span>\n" +
            "    </a>\n" +
            "  <!--[if mso]></center></v:roundrect></td></tr></table><![endif]-->\n" +
            "</div>\n" +
            "\n" +
            "      </td>\n" +
            "    </tr>\n" +
            "  </tbody>\n" +
            "</table>\n" +
            "\n" +
            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
            "  <tbody>\n" +
            "    <tr>\n" +
            "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
            "        \n" +
            "<div align=\"center\">\n" +
            "  <div style=\"display: table; max-width:73px;\">\n" +
            "  <!--[if (mso)|(IE)]><table width=\"73\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"center\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:73px;\"><tr><![endif]-->\n" +
            "  \n" +
            "    \n" +
            "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 5px;\" valign=\"top\"><![endif]-->\n" +
            "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 5px\">\n" +
            "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
            "        <a href=\"https://facebook.com/\" title=\"Facebook\" target=\"_blank\">\n" +
            "          <img src=\"https://firebasestorage.googleapis.com/v0/b/crm-manazello.appspot.com/o/customers%2Fimage-1.png?alt=media&token=ad929319-43ad-4e87-9276-026ef1f299c9\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
            "        </a>\n" +
            "      </td></tr>\n" +
            "    </tbody></table>\n" +
            "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
            "    \n" +
            "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\n" +
            "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\n" +
            "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
            "        <a href=\"https://linkedin.com/\" title=\"LinkedIn\" target=\"_blank\">\n" +
            "          <img src=\"https://firebasestorage.googleapis.com/v0/b/crm-manazello.appspot.com/o/customers%2Fimage-2.png?alt=media&token=4612cdb7-99b3-4b5a-af64-d505af8c4779\" alt=\"LinkedIn\" title=\"LinkedIn\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
            "        </a>\n" +
            "      </td></tr>\n" +
            "    </tbody></table>\n" +
            "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
            "    \n" +
            "    \n" +
            "    <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
            "  </div>\n" +
            "</div>\n" +
            "\n" +
            "      </td>\n" +
            "    </tr>\n" +
            "  </tbody>\n" +
            "</table>\n" +
            "\n" +
            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
            "  <tbody>\n" +
            "    <tr>\n" +
            "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:20px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
            "        \n" +
            "  <div>\n" +
            "    <div align=\"center\" >\n" +
            "    <a\n" +
            "     href=\"http://localhost:4200/\" >\n" +
            "  Manazello Ⓒ 2022\n" +
            "</a>\n" +
            "</div>\n" +
            "  </div>\n" +
            "\n" +
            "      </td>\n" +
            "    </tr>\n" +
            "  </tbody>\n" +
            "</table>\n" +
            "\n" +
            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
            "  </div>\n" +
            "</div>\n" +
            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
            "    </div>\n" +
            "  </div>\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
            "    </td>\n" +
            "  </tr>\n" +
            "  </tbody>\n" +
            "  </table>\n" +
            "  <!--[if mso]></div><![endif]-->\n" +
            "  <!--[if IE]></div><![endif]-->\n" +
            "</body>\n" +
            "\n" +
            "</html>\n";
}
