package com.manazello.administration.business.ibusiness;

import com.manazello.administration.business.businesimpl.Iservice;
import com.manazello.administration.entities.RentalRequest;
import com.manazello.administration.entities.enumeration.Status;
import com.manazello.administration.repositories.AdministrationRepository;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class RentalRequestServiceImpl implements Iservice<RentalRequest> {
    final AdministrationRepository administrationRepository;
    final JavaMailSender javaMailSender;
    public RentalRequestServiceImpl(AdministrationRepository administrationRepository, JavaMailSender javaMailSender) {
        this.administrationRepository = administrationRepository;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public RentalRequest add(RentalRequest entity) {
        return administrationRepository.save(entity);
    }

    @Override
    public List<RentalRequest> findAllActive() {
        return administrationRepository.findRentalRequestsByArchived(false);
    }
    @Override
    public List<RentalRequest> findAllArchived() {
        return administrationRepository.findRentalRequestsByArchived(true);
    }
    @Override
    public RentalRequest update(RentalRequest entity) {
        MimeMessage messsg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
String body="<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"  style=\"background-color:#171941;\" >\n" +
        "\n" +
        "  \n" +
        "  \n" +
        "   \n" +
        "  \n" +
        "    <tbody>\n" +
        "      <tr>\n" +
        "        <td align=\"center\">\n" +
        "          <table class=\"col-600\" width=\"600\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "            <tbody>\n" +
        "              <tr>\n" +
        "                <td align=\"center\" valign=\"top\" background=\"https://images.unsplash.com/photo-1580983559367-0dc2f8934365?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80\"  style=\"background-size:cover;filter: brightness(80%);\n" +
        "                   background-position:top;height=400\" >\n" +
        "                  <table class=\"col-600\" width=\"600\" height=\"400\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "  \n" +
        "                    <tbody>\n" +
        "                      <tr>\n" +
        "                        <td height=\"40\"></td>\n" +
        "                      </tr>\n" +
        "  \n" +
        "                      <tr>\n" +
        "                        <td align=\"center\" style=\"line-height: 0px;\">\n" +
        "                          \n" +
        "                          <img style=\"display:block; line-height:0px; font-size:0px; border:0px;\" src=\"https://scontent.ftun14-1.fna.fbcdn.net/v/t1.15752-9/275736074_508685984214271_8372235976777966412_n.png?_nc_cat=107&ccb=1-5&_nc_sid=ae9488&_nc_ohc=8Vjc4gazmHQAX8M3idW&_nc_ht=scontent.ftun14-1.fna&oh=03_AVKYDJDslebcDtMxpa-YXMiCE5Xz1gRoPpYAYYE73xToaw&oe=6255806E\" width=\"230\" height=\"103\" alt=\"logo\">\n" +
        "                        </td>\n" +
        "                      </tr>\n" +
        "  \n" +
        "                      <tr>\n" +
        "                        <td align=\"center\" style=\"font-family: 'Raleway', sans-serif; font-size:37px; color:white; line-height:24px; font-weight: bold; letter-spacing: 7px;\">\n" +
        "                          REQUEST <span style=\"font-family: 'Raleway', sans-serif; font-size:37px; color:#ffffff; line-height:39px; font-weight: 300; letter-spacing: 7px;\">CONFIRMATION</span>\n" +
        "                        </td>\n" +
        "                      </tr>\n" +
        "  \n" +
        "                      <tr>\n" +
        "                        <td align=\"center\" style=\"font-family: 'Lato', sans-serif; font-size:15px; color:#ffffff; line-height:24px; font-weight: 300;\">\n" +
        "                         ManaZello is made for managing Entreprise Resource Planning  \n" +
        "                        </td>\n" +
        "                      </tr>\n" +
        "  \n" +
        "                      <tr>\n" +
        "                        <td height=\"50\"></td>\n" +
        "                      </tr>\n" +
        "                    </tbody>\n" +
        "                  </table>\n" +
        "                </td>\n" +
        "              </tr>\n" +
        "            </tbody>\n" +
        "          </table>\n" +
        "        </td>\n" +
        "      </tr>\n" +
        "  \n" +
        "      <!-- END HEADER/BANNER -->\n" +
        "  \n" +
        "      <!-- START 3 BOX SHOWCASE -->\n" +
        "  \n" +
        "      <tr>\n" +
        "        <td align=\"center\">\n" +
        "          <table class=\"col-600\" width=\"600\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-left:20px; margin-right:20px; border-left: 1px solid #dbd9d9; border-right: 1px solid #dbd9d9;\">\n" +
        "            <tbody>\n" +
        "              <tr>\n" +
        "                <td height=\"35\"></td>\n" +
        "              </tr>\n" +
        "  \n" +
        "              <tr>\n" +
        "                <td align=\"center\" style=\"font-family: 'Raleway', sans-serif; font-size:22px; font-weight: bold; color:#fff;\">ManaZello Features</td>\n" +
        "              </tr>\n" +
        "  \n" +
        "              <tr>\n" +
        "                <td height=\"10\"></td>\n" +
        "              </tr>\n" +
        "  \n" +
        "              <tr>\n" +
        "                <td align=\"center\" style=\"font-family: 'Lato', sans-serif; font-size:14px; color:#fff; line-height:24px; font-weight: 300;\">\n" +
        "                  ManaZello  meets your needs in the best possible way thanks to  their functionality.\n" +
        "                </td>\n" +
        "              </tr>\n" +
        "  \n" +
        "            </tbody>\n" +
        "          </table>\n" +
        "        </td>\n" +
        "      </tr>\n" +
        "  \n" +
        "      <tr>\n" +
        "        <td align=\"center\">\n" +
        "          <table class=\"col-600\" width=\"600\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-left: 1px solid #dbd9d9; border-right: 1px solid #dbd9d9; \">\n" +
        "            <tbody>\n" +
        "              <tr>\n" +
        "                <td height=\"10\"></td>\n" +
        "              </tr>\n" +
        "              <tr>\n" +
        "                <td>\n" +
        "  \n" +
        "                  <table class=\"col3\" width=\"183\" border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "                    <tbody>\n" +
        "                      <tr>\n" +
        "                        <td height=\"30\"></td>\n" +
        "                      </tr>\n" +
        "                      <tr>\n" +
        "                        <td align=\"center\">\n" +
        "                          <table class=\"insider\" width=\"133\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "  \n" +
        "                            <tbody>\n" +
        "                              <tr align=\"center\" style=\"line-height:0px;\">\n" +
        "                                <td>\n" +
        "                                  <img style=\"display:block; line-height:0px; font-size:0px; border:0px;background-color:#fff; \" \n" +
        "                                  src=\"https://cdn-icons-png.flaticon.com/512/155/155360.png?w=740\" width=\"69\" height=\"78\" alt=\"icon\">\n" +
        "                                </td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr>\n" +
        "                                <td height=\"15\"></td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr align=\"center\">\n" +
        "                                <td style=\"font-family: 'Raleway', Arial, sans-serif; font-size:20px; color:#fff; line-height:24px; font-weight: bold;\">Project Management</td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr>\n" +
        "                                <td height=\"10\"></td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr align=\"center\">\n" +
        "                           \n" +
        "  \n" +
        "                            </tbody>\n" +
        "                          </table>\n" +
        "                        </td>\n" +
        "                      </tr>\n" +
        "                      <tr>\n" +
        "                        <td height=\"30\"></td>\n" +
        "                      </tr>\n" +
        "                    </tbody>\n" +
        "                  </table>\n" +
        "  \n" +
        "                  <table width=\"1\" height=\"20\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\">\n" +
        "                    <tbody>\n" +
        "                      <tr>\n" +
        "                        <td height=\"20\" style=\"font-size: 0;line-height: 0;border-collapse: collapse;\">\n" +
        "                          <p style=\"padding-left: 24px;\">&nbsp;</p>\n" +
        "                        </td>\n" +
        "                      </tr>\n" +
        "                    </tbody>\n" +
        "                  </table>\n" +
        "  \n" +
        "                  <table class=\"col3\" width=\"183\" border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "                    <tbody>\n" +
        "                      <tr>\n" +
        "                        <td height=\"30\"></td>\n" +
        "                      </tr>\n" +
        "                      <tr>\n" +
        "                        <td align=\"center\">\n" +
        "                          <table class=\"insider\" width=\"133\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "  \n" +
        "                            <tbody>\n" +
        "                              <tr align=\"center\" style=\"line-height:0px;\">\n" +
        "                                <td>\n" +
        "                                  <img style=\"display:block; line-height:0px; font-size:0px; border:0px;background-color:#fff; \" src=\"https://designmodo.com/demo/emailtemplate/images/icon-team.png\" width=\"69\" height=\"78\" alt=\"icon\">\n" +
        "                                </td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr>\n" +
        "                                <td height=\"15\"></td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr align=\"center\">\n" +
        "                                <td style=\"font-family: 'Raleway', sans-serif; font-size:20px; color:#fff; line-height:24px; font-weight: bold;\">HR</td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr>\n" +
        "                                <td height=\"10\"></td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              \n" +
        "  \n" +
        "                            </tbody>\n" +
        "                          </table>\n" +
        "                        </td>\n" +
        "                      </tr>\n" +
        "                      <tr>\n" +
        "                        <td height=\"30\"></td>\n" +
        "                      </tr>\n" +
        "                    </tbody>\n" +
        "                  </table>\n" +
        "  \n" +
        "                  <table width=\"1\" height=\"20\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\">\n" +
        "                    <tbody>\n" +
        "                      <tr>\n" +
        "                        <td height=\"20\" style=\"font-size: 0;line-height: 0;border-collapse: collapse;\">\n" +
        "                          <p style=\"padding-left: 24px;\">&nbsp;</p>\n" +
        "                        </td>\n" +
        "                      </tr>\n" +
        "                    </tbody>\n" +
        "                  </table>\n" +
        "  \n" +
        "                  <table class=\"col3\" width=\"183\" border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "                    <tbody>\n" +
        "                      <tr>\n" +
        "                        <td height=\"30\"></td>\n" +
        "                      </tr>\n" +
        "                      <tr>\n" +
        "                        <td align=\"center\">\n" +
        "                          <table class=\"insider\" width=\"133\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "  \n" +
        "                            <tbody>\n" +
        "                              <tr align=\"center\" style=\"line-height:0px;\">\n" +
        "                                <td>\n" +
        "                                  <img style=\"display:block; line-height:0px; font-size:0px; border:0px;background-color:#fff; \" src=\"https://cdn-icons-png.flaticon.com/512/326/326859.png?w=740\" width=\"69\" height=\"78\" alt=\"icon\">\n" +
        "                                </td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr>\n" +
        "                                <td height=\"15\"></td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr align=\"center\">\n" +
        "                                <td style=\"font-family: 'Raleway',  sans-serif; font-size:20px; color:#fff; line-height:24px; font-weight: bold;\">CRM</td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                     \n" +
        "  \n" +
        "                            </tbody>\n" +
        "                          </table>\n" +
        "                        </td>\n" +
        "                      </tr>\n" +
        "                      <tr>\n" +
        "                        <td height=\"30\"></td>\n" +
        "                      </tr>\n" +
        "                    </tbody>\n" +
        "                  </table>\n" +
        " \n" +
        "\n" +
        "                </td>\n" +
        "              </tr>\n" +
        "            </tbody>\n" +
        "          </table>\n" +
        "          \n" +
        "        </td>\n" +
        "      </tr>\n" +
        "   <!--test-->\n" +
        "   \n" +
        "\n" +
        "  <tr>\n" +
        "    <td align=\"center\">\n" +
        "      <table class=\"col-600\" width=\"600\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-left: 1px solid #dbd9d9; border-right: 1px solid #dbd9d9; \">\n" +
        "        <tbody>\n" +
        "          <tr>\n" +
        "            <td height=\"10\"></td>\n" +
        "          </tr>\n" +
        "          <tr>\n" +
        "            <td>\n" +
        "\n" +
        "              <table class=\"col3\" width=\"183\" border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "                <tbody>\n" +
        "                  <tr>\n" +
        "                    <td height=\"30\"></td>\n" +
        "                  </tr>\n" +
        "                  <tr>\n" +
        "                    <td align=\"center\">\n" +
        "                      <table class=\"insider\" width=\"133\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "\n" +
        "                        <tbody>\n" +
        "                          <tr align=\"center\" style=\"line-height:0px;\">\n" +
        "                            <td>\n" +
        "                              <img style=\"display:block; line-height:0px; font-size:0px; border:0px;background-color:#fff; \" src=\"https://cdn-icons-png.flaticon.com/512/1247/1247025.png?w=740\" width=\"69\" height=\"78\" alt=\"icon\">\n" +
        "                            </td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr>\n" +
        "                            <td height=\"15\"></td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr align=\"center\">\n" +
        "                            <td style=\"font-family: 'Raleway', Arial, sans-serif; font-size:20px; color:#fff; line-height:24px; font-weight: bold;\">Litigation and Recovery</td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr>\n" +
        "                            <td height=\"10\"></td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr align=\"center\">\n" +
        "                       \n" +
        "\n" +
        "                        </tbody>\n" +
        "                      </table>\n" +
        "                    </td>\n" +
        "                  </tr>\n" +
        "                  <tr>\n" +
        "                    <td height=\"30\"></td>\n" +
        "                  </tr>\n" +
        "                </tbody>\n" +
        "              </table>\n" +
        "\n" +
        "              <table width=\"1\" height=\"20\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\">\n" +
        "                <tbody>\n" +
        "                  <tr>\n" +
        "                    <td height=\"20\" style=\"font-size: 0;line-height: 0;border-collapse: collapse;\">\n" +
        "                      <p style=\"padding-left: 24px;\">&nbsp;</p>\n" +
        "                    </td>\n" +
        "                  </tr>\n" +
        "                </tbody>\n" +
        "              </table>\n" +
        "\n" +
        "              <table class=\"col3\" width=\"183\" border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "                <tbody>\n" +
        "                  <tr>\n" +
        "                    <td height=\"30\"></td>\n" +
        "                  </tr>\n" +
        "                  <tr>\n" +
        "                    <td align=\"center\">\n" +
        "                      <table class=\"insider\" width=\"133\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "\n" +
        "                        <tbody>\n" +
        "                          <tr align=\"center\" style=\"line-height:0px;\">\n" +
        "                            <td>\n" +
        "                              <img style=\"display:block; line-height:0px; font-size:0px; border:0px;background-color:#fff; \" src=\"https://cdn-icons-png.flaticon.com/512/1235/1235653.png?w=740\" width=\"69\" height=\"78\" alt=\"icon\">\n" +
        "                            </td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr>\n" +
        "                            <td height=\"15\"></td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr align=\"center\">\n" +
        "                            <td style=\"font-family: 'Raleway', sans-serif; font-size:20px; color:#fff; line-height:24px; font-weight: bold;\">Communications & Marketing</td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr>\n" +
        "                            <td height=\"10\"></td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          \n" +
        "\n" +
        "                        </tbody>\n" +
        "                      </table>\n" +
        "                    </td>\n" +
        "                  </tr>\n" +
        "                  <tr>\n" +
        "                    <td height=\"30\"></td>\n" +
        "                  </tr>\n" +
        "                </tbody>\n" +
        "              </table>\n" +
        "\n" +
        "              <table width=\"1\" height=\"20\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\">\n" +
        "                <tbody>\n" +
        "                  <tr>\n" +
        "                    <td height=\"20\" style=\"font-size: 0;line-height: 0;border-collapse: collapse;\">\n" +
        "                      <p style=\"padding-left: 24px;\">&nbsp;</p>\n" +
        "                    </td>\n" +
        "                  </tr>\n" +
        "                </tbody>\n" +
        "              </table>\n" +
        "\n" +
        "              <table class=\"col3\" width=\"183\" border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "                <tbody>\n" +
        "                  <tr>\n" +
        "                    <td height=\"30\"></td>\n" +
        "                  </tr>\n" +
        "                  <tr>\n" +
        "                    <td align=\"center\">\n" +
        "                      <table class=\"insider\" width=\"133\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "\n" +
        "                        <tbody>\n" +
        "                          <tr align=\"center\" style=\"line-height:0px;\">\n" +
        "                            <td>\n" +
        "                              <img style=\"display:block; line-height:0px; font-size:0px; border:0px;background-color:#fff; \" src=\"https://cdn-icons-png.flaticon.com/512/994/994397.png?w=740\" width=\"69\" height=\"78\" alt=\"icon\">\n" +
        "                            </td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr>\n" +
        "                            <td height=\"15\"></td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr align=\"center\">\n" +
        "                            <td style=\"font-family: 'Raleway',  sans-serif; font-size:20px; color:#fff; line-height:24px; font-weight: bold;\">Accounting</td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                 \n" +
        "\n" +
        "                        </tbody>\n" +
        "                      </table>\n" +
        "                    </td>\n" +
        "                  </tr>\n" +
        "                  <tr>\n" +
        "                    <td height=\"30\"></td>\n" +
        "                  </tr>\n" +
        "                </tbody>\n" +
        "              </table>\n" +
        "\n" +
        "\n" +
        "            </td>\n" +
        "          </tr>\n" +
        "        </tbody>\n" +
        "      </table>\n" +
        "      \n" +
        "    </td>\n" +
        "  </tr>\n" +
        "<!----end test-->\n" +
        " <!--test-->\n" +
        "   \n" +
        "\n" +
        " <tr>\n" +
        "    <td align=\"center\">\n" +
        "      <table class=\"col-600\" width=\"600\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-left: 1px solid #dbd9d9; border-right: 1px solid #dbd9d9; \">\n" +
        "        <tbody>\n" +
        "          <tr>\n" +
        "            <td height=\"10\"></td>\n" +
        "          </tr>\n" +
        "          <tr>\n" +
        "            <td>\n" +
        "\n" +
        "              <table class=\"col3\" width=\"183\" border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "                <tbody>\n" +
        "                  <tr>\n" +
        "                    <td height=\"30\"></td>\n" +
        "                  </tr>\n" +
        "                  <tr>\n" +
        "                    <td align=\"center\">\n" +
        "                      <table class=\"insider\" width=\"133\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "\n" +
        "                        <tbody>\n" +
        "                          <tr align=\"center\" style=\"line-height:0px;\">\n" +
        "                            <td>\n" +
        "                              <img style=\"display:block; line-height:0px; font-size:0px; border:0px;background-color:#fff; \" src=\"https://cdn-icons-png.flaticon.com/512/1237/1237097.png?w=740\" width=\"69\" height=\"78\" alt=\"icon\">\n" +
        "                            </td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr>\n" +
        "                            <td height=\"15\"></td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr align=\"center\">\n" +
        "                            <td style=\"font-family: 'Raleway', Arial, sans-serif; font-size:20px; color:#fff; line-height:24px; font-weight: bold;\">Financial Management</td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr>\n" +
        "                            <td height=\"10\"></td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr align=\"center\">\n" +
        "                       \n" +
        "\n" +
        "                        </tbody>\n" +
        "                      </table>\n" +
        "                    </td>\n" +
        "                  </tr>\n" +
        "                  <tr>\n" +
        "                    <td height=\"30\"></td>\n" +
        "                  </tr>\n" +
        "                </tbody>\n" +
        "              </table>\n" +
        "\n" +
        "              <table width=\"1\" height=\"20\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\">\n" +
        "                <tbody>\n" +
        "                  <tr>\n" +
        "                    <td height=\"20\" style=\"font-size: 0;line-height: 0;border-collapse: collapse;\">\n" +
        "                      <p style=\"padding-left: 24px;\">&nbsp;</p>\n" +
        "                    </td>\n" +
        "                  </tr>\n" +
        "                </tbody>\n" +
        "              </table>\n" +
        "\n" +
        "              <table class=\"col3\" width=\"183\" border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "                <tbody>\n" +
        "                  <tr>\n" +
        "                    <td height=\"30\"></td>\n" +
        "                  </tr>\n" +
        "                  <tr>\n" +
        "                    <td align=\"center\">\n" +
        "                      <table class=\"insider\" width=\"133\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "\n" +
        "                        <tbody>\n" +
        "                          <tr align=\"center\" style=\"line-height:0px;\">\n" +
        "                            <td>\n" +
        "                              <img style=\"display:block; line-height:0px; font-size:0px; border:0px;background-color:#fff; \" src=\"https://cdn-icons-png.flaticon.com/512/1186/1186337.png?w=740\" width=\"69\" height=\"78\" alt=\"icon\">\n" +
        "                            </td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr>\n" +
        "                            <td height=\"15\"></td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr align=\"center\">\n" +
        "                            <td style=\"font-family: 'Raleway', sans-serif; font-size:20px; color:#fff; line-height:24px; font-weight: bold;\">Product & Inventory Management</td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          <tr>\n" +
        "                            <td height=\"10\"></td>\n" +
        "                          </tr>\n" +
        "\n" +
        "                          \n" +
        "\n" +
        "                        </tbody>\n" +
        "                      </table>\n" +
        "                    </td>\n" +
        "                  </tr>\n" +
        "                  <tr>\n" +
        "                    <td height=\"30\"></td>\n" +
        "                  </tr>\n" +
        "                </tbody>\n" +
        "              </table>\n" +
        "\n" +
        "              <table width=\"1\" height=\"20\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\">\n" +
        "                <tbody>\n" +
        "                  <tr>\n" +
        "                    <td height=\"20\" style=\"font-size: 0;line-height: 0;border-collapse: collapse;\">\n" +
        "                      <p style=\"padding-left: 24px;\">&nbsp;</p>\n" +
        "                    </td>\n" +
        "                  </tr>\n" +
        "                </tbody>\n" +
        "              </table>\n" +
        "\n" +
        "              \n" +
        "\n" +
        "\n" +
        "            </td>\n" +
        "          </tr>\n" +
        "        </tbody>\n" +
        "      </table>\n" +
        "      \n" +
        "    </td>\n" +
        "  </tr>\n" +
        "<!----end test-->\n" +
        "      <tr>\n" +
        "        <td height=\"5\"></td>\n" +
        "      </tr>\n" +
        "  \n" +
        "      <!-- END 3 BOX SHOWCASE -->\n" +
        "  \n" +
        "      <!-- START AWESOME TITLE -->\n" +
        "  \n" +
        "      <tr>\n" +
        "        <td align=\"center\">\n" +
        "          <table align=\"center\" class=\"col-600\" width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
        "            <tbody>\n" +
        "              <tr>\n" +
        "                <td align=\"center\" bgcolor=\"#2a3b4c\">\n" +
        "                  <table class=\"col-600\" width=\"600\" align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
        "                    <tbody>\n" +
        "                      <tr>\n" +
        "                        <td height=\"33\"></td>\n" +
        "                      </tr>\n" +
        "                      <tr>\n" +
        "                        <td>\n" +
        "  \n" +
        "                          <table class=\"col1\" width=\"183\" border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "  \n" +
        "                            <tbody>\n" +
        "                              <tr>\n" +
        "                                <td height=\"18\"></td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr>\n" +
        "                                <td align=\"center\">\n" +
        "                                  <img style=\"display:block; line-height:0px; font-size:0px; border:0px;background-color:#fff; \" class=\"images_style\" src=\"https://cdn-icons-png.flaticon.com/512/1215/1215090.png?w=740\" alt=\"img\" width=\"156\" height=\"136\">\n" +
        "                                </td>\n" +
        "  \n" +
        "                              </tr>\n" +
        "                            </tbody>\n" +
        "                          </table>\n" +
        "  \n" +
        "                          <table class=\"col3_one\" width=\"380\" border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "  \n" +
        "                            <tbody>\n" +
        "                              <tr align=\"left\" valign=\"top\">\n" +
        "                                <td style=\"font-family: 'Raleway', sans-serif; font-size:20px; color:#4ED3F2; line-height:30px; font-weight: bold;\">Welcome to ManaZello! </td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr>\n" +
        "                                <td height=\"5\"></td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr align=\"left\" valign=\"top\">\n" +
        "                                <td style=\"font-family: 'Lato', sans-serif; font-size:14px; color:#fff; line-height:24px; font-weight: 300;\">\n" +
        "                                    you can now access your account by clicking on this link and complete your registration.                                </td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr>\n" +
        "                                <td height=\"10\"></td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr align=\"left\" valign=\"top\">\n" +
        "                                <td>\n" +
        "                                  <table class=\"button\" style=\"border: 2px solid #fff;\" bgcolor=\"#2b3c4d\" width=\"30%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "                                    <tbody>\n" +
        "                                      <tr>\n" +
        "                                        <td width=\"10\"></td>\n" +
        "                                        <td height=\"30\" align=\"center\" style=\"font-family: 'Open Sans', Arial, sans-serif; font-size:13px; color:#ffffff;\">\n" +
        "                                          <a href=\"#\" style=\"color:#ffffff;\">Read more</a>\n" +
        "                                        </td>\n" +
        "                                        <td width=\"10\"></td>\n" +
        "                                      </tr>\n" +
        "                                    </tbody>\n" +
        "                                  </table>\n" +
        "                                </td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                            </tbody>\n" +
        "                          </table>\n" +
        "                        </td>\n" +
        "                      </tr>\n" +
        "                      <tr>\n" +
        "                        <td height=\"33\"></td>\n" +
        "                      </tr>\n" +
        "                    </tbody>\n" +
        "                  </table>\n" +
        "                </td>\n" +
        "              </tr>\n" +
        "            </tbody>\n" +
        "          </table>\n" +
        "        </td>\n" +
        "      </tr>\n" +
        "  \n" +
        "      <!-- END AWESOME TITLE -->\n" +
        "  \n" +
        "      <!-- START WHAT WE DO -->\n" +
        "  \n" +
        "      <tr>\n" +
        "        <td align=\"center\">\n" +
        "          <table class=\"col-600\" width=\"600\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-left:20px; margin-right:20px;\">\n" +
        "  \n" +
        "            <tbody>\n" +
        "              <tr>\n" +
        "                <td align=\"center\">\n" +
        "                  <table class=\"col-600\" width=\"600\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\" border-left: 1px solid #dbd9d9; border-right: 1px solid #dbd9d9;\">\n" +
        "                    <tbody>\n" +
        "                      <tr>\n" +
        "                        <td height=\"50\"></td>\n" +
        "                      </tr>\n" +
        "                      <tr>\n" +
        "                        <td align=\"right\">\n" +
        "  \n" +
        "                          <table class=\"col2\" width=\"287\" border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "                            <tbody>\n" +
        "                              <tr>\n" +
        "                                <td align=\"center\" style=\"line-height:0px;\">\n" +
        "                                  <img style=\"display:block; line-height:0px; font-size:0px; border:0px;\" class=\"images_style\" src=\"https://cdn-icons-png.flaticon.com/512/1001/1001015.png?w=740\" width=\"169\" height=\"138\">\n" +
        "                                </td>\n" +
        "                              </tr>\n" +
        "                            </tbody>\n" +
        "                          </table>\n" +
        "  \n" +
        "                          <table width=\"287\" border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" class=\"col2\" style=\"\">\n" +
        "                            <tbody>\n" +
        "                              <tr>\n" +
        "                                <td align=\"center\">\n" +
        "                                  <table class=\"insider\" width=\"237\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "  \n" +
        "                                    <tbody>\n" +
        "                                      <tr align=\"left\">\n" +
        "                                        <td style=\"font-family: 'Raleway', sans-serif; font-size:23px; color:#fff; line-height:30px; font-weight: bold;\">What we do?</td>\n" +
        "                                      </tr>\n" +
        "  \n" +
        "                                      <tr>\n" +
        "                                        <td height=\"5\"></td>\n" +
        "                                      </tr>\n" +
        "  \n" +
        "                                      <tr>\n" +
        "                                        <td style=\"font-family: 'Lato', sans-serif; font-size:14px; color:#fff; line-height:24px; font-weight: 300;\">\n" +
        "                                          We create responsive websites with modern designs and features for small businesses and organizations that are professionally developed and SEO optimized.\n" +
        "                                        </td>\n" +
        "                                      </tr>\n" +
        "  \n" +
        "                                    </tbody>\n" +
        "                                  </table>\n" +
        "                                </td>\n" +
        "                              </tr>\n" +
        "                            </tbody>\n" +
        "                          </table>\n" +
        "                        </td>\n" +
        "                      </tr>\n" +
        "                    </tbody>\n" +
        "                  </table>\n" +
        "                </td>\n" +
        "              </tr>\n" +
        "  \n" +
        "              <!-- END WHAT WE DO -->\n" +
        "  \n" +
        "             \n" +
        "  \n" +
        "             \n" +
        "  \n" +
        "              <!-- START FOOTER -->\n" +
        "  \n" +
        "              <tr>\n" +
        "                <td align=\"center\">\n" +
        "                  <table align=\"center\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\" border-left: 1px solid #dbd9d9; border-right: 1px solid #dbd9d9;\">\n" +
        "                    <tbody>\n" +
        "                      <tr>\n" +
        "                        <td height=\"50\"></td>\n" +
        "                      </tr>\n" +
        "                      <tr>\n" +
        "                        <td align=\"center\" bgcolor=\"#34495e\" background=\"https://designmodo.com/demo/emailtemplate/images/footer.jpg\" height=\"185\">\n" +
        "                          <table class=\"col-600\" width=\"600\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "                            <tbody>\n" +
        "                              <tr>\n" +
        "                                <td height=\"25\"></td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr>\n" +
        "                                <td align=\"center\" style=\"font-family: 'Raleway',  sans-serif; font-size:26px; font-weight: 500; color:#4ED3F2;\">Follow us for some cool stuffs</td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                              <tr>\n" +
        "                                <td height=\"25\"></td>\n" +
        "                              </tr>\n" +
        "  \n" +
        "                            </tbody>\n" +
        "                          </table>\n" +
        "                          <table align=\"center\" width=\"35%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
        "                            <tbody>\n" +
        "                              <tr>\n" +
        "                                <td align=\"center\" width=\"30%\" style=\"vertical-align: top;\">\n" +
        "                                  <a href=\"https://www.facebook.com/designmodo\" target=\"_blank\"> <img src=\"https://designmodo.com/demo/emailtemplate/images/icon-fb.png\"> </a>\n" +
        "                                </td>\n" +
        "  \n" +
        "                                <td align=\"center\" class=\"margin\" width=\"30%\" style=\"vertical-align: top;\">\n" +
        "                                  <a href=\"https://twitter.com/designmodo\" target=\"_blank\"> <img src=\"https://designmodo.com/demo/emailtemplate/images/icon-twitter.png\"> </a>\n" +
        "                                </td>\n" +
        "  \n" +
        "                                <td align=\"center\" width=\"30%\" style=\"vertical-align: top;\">\n" +
        "                                  <a href=\"https://plus.google.com/+Designmodo/posts\" target=\"_blank\"> <img src=\"https://designmodo.com/demo/emailtemplate/images/icon-googleplus.png\"> </a>\n" +
        "                                </td>\n" +
        "                              </tr>\n" +
        "                            </tbody>\n" +
        "                          </table>\n" +
        "  \n" +
        "                        </td>\n" +
        "                      </tr>\n" +
        "                    </tbody>\n" +
        "                  </table>\n" +
        "                </td>\n" +
        "              </tr>\n" +
        "            </tbody>\n" +
        "          </table>\n" +
        "        </td>\n" +
        "      </tr>\n" +
        "  \n" +
        "      <!-- END FOOTER -->\n" +
        "  ";
        try {
            helper = new MimeMessageHelper(messsg, true);
            helper.setTo(entity.getEmail());
          //  System.out.println(entity.getEmail());
            helper.setSubject("test");
            helper.setText(body,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }



        javaMailSender.send(messsg);

        return administrationRepository.save(entity);
    }

    @Override
    public RentalRequest findById(String id) {
        return administrationRepository.findById(id).orElse(null);
    }

    @Override
    public RentalRequest archived(RentalRequest entity) {
        entity.setArchived(false);
        return null;
    }

    @Override
    public int countUnderValidation() {
        return administrationRepository.countAllByStatus(Status.UNDER_VALIDATION);
    }

    @Override
    public int countPending() {
        return administrationRepository.countAllByStatus(Status.PENDING);
    }

    @Override
    public int countApproved() {
        return administrationRepository.countAllByStatus(Status.APPROVED);
    }

    @Override
    public int countDenied() {
        return administrationRepository.countAllByStatus(Status.DENIED);
    }
}
