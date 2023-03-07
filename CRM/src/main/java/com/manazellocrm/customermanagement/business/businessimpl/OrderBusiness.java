package com.manazellocrm.customermanagement.business.businessimpl;

import com.manazellocrm.customermanagement.business.ibusiness.IContractBusiness;
import com.manazellocrm.customermanagement.business.ibusiness.IOrdersBusiness;
import com.manazellocrm.customermanagement.entities.Contract;
import com.manazellocrm.customermanagement.entities.Order;
import com.manazellocrm.customermanagement.entities.Status;
import com.manazellocrm.customermanagement.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.*;

@RequiredArgsConstructor
@Service
public class OrderBusiness implements IOrdersBusiness {
    final JavaMailSender javaMailSender;
    private final RestTemplate rest;
    private final OrderRepository orderRepository;
    private final IContractBusiness iContractBusiness;

    public void sendEmail(String subject, String body, String email) {
        MimeMessage emailMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(emailMessage, true);
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(body, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(emailMessage);
    }

    @Override
    public Order addOrder(Order order, String idProduct) throws NoSuchAlgorithmException {
        Date date = new Date();
        Instant instanceNow = date.toInstant();
        Random r = SecureRandom.getInstanceStrong();

        int randomInt = r.nextInt((100 - 50 + 1) + 50);
        order.setCreatedAt(instanceNow);
        order.setArchive("No");
        order.setStatus(Status.Pending);
        order.setOrderCode("#" + randomInt);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        Object product = rest.exchange("https://pim-manazello-backend.herokuapp.com/material/show/finished-product/" + idProduct, HttpMethod.GET,
                entity, Object.class).getBody();
        order.setProduct(product);

        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order, String id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        Date date = new Date();
        Instant instanceNow = date.toInstant();
        order.setModifiedAt(instanceNow);
        return (orderOptional.isPresent() ?
                orderRepository.save(order)
                : null);
    }

    @Override
    public Order assignContractToOrder( String id, Contract contract) {
        Optional<Order> orderOptional = orderRepository.findById(id);
       if(orderOptional.isEmpty()){
           return null;
       }else  if(orderOptional.get().getStatus()== Status.SALE) {

            iContractBusiness.addContract(contract);
            Date date = new Date();
            Instant instanceNow = date.toInstant();
            orderOptional.get().setModifiedAt(instanceNow);
            orderOptional.get().setContract(contract);
            return orderRepository.save(orderOptional.get());
        }  else{
            return  null;
        }

    }

    @Override
    public List<Order> findOrdersContractsNull() {
        return orderRepository.findOrdersByContractNull();
    }

    @Override
    public List<Order> findOrdersContractsNotNull() {
        return orderRepository.findOrdersByContractNotNull();
    }

    @Override
    public List<Order> findAllOrdersConfirmed() {
        return orderRepository.findOrdersByStatus(Status.SALE);
    }

    @Override
    public Order deliverOrder(Order order, String id) {
        Optional<Order> orderOptional = orderRepository.findById(id);

        Date date = new Date();
        Instant instanceNow = date.toInstant();
        order.setModifiedAt(instanceNow);
        order.setStatus(Status.DELIVERED);
        return getOrder(order, orderOptional);
    }

    @Override
    @Transactional
    public Order validateOrder(Order order, String id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        Date date = new Date();
        Instant instanceNow = date.toInstant();
        order.setModifiedAt(instanceNow);
        order.setStatus(Status.Done);
        return getOrder(order, orderOptional);
    }

    @Override
    @Transactional
    public Order inProgressOrder(Order order, String id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        Date date = new Date();
        Instant instanceNow = date.toInstant();
        order.setModifiedAt(instanceNow);
        order.setStatus(Status.InProgress);
        return getOrder(order, orderOptional);
    }

    @Override
    @Transactional
    public Order saleOrder(Order order, String id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        Date date = new Date();
        Instant instanceNow = date.toInstant();
        order.setModifiedAt(instanceNow);
        order.setStatus(Status.SALE);
     return getOrder(order, orderOptional);
 }

    private Order getOrder(Order order, Optional<Order> orderOptional) {
        String message = "Order code " + order.getOrderCode() +
                "\n  " +
                " Hello ,\n"
                + order.getDeals().getVisit().getCustomer().getName() +
                "\n" +
                "  Thank you for placing your order on Manazello. We are currently working on your order : "+order.getStatus();

        String infos = "  <br/>  Client information :  " +
                "\n" +
                order.getDeals().getVisit().getCustomer().getAddress() + " , "
                + order.getDeals().getVisit().getCustomer().getCity() + " , "
                + order.getDeals().getVisit().getCustomer().getCountry() +
                "\n"
                + "    at " + order.getOrderDate().toInstant();
        String total = "   <br/> Total " + order.getOrderPaid() + order.getCurrency();
        String body = EmailTemplate.EMAIL + message + infos + total + EmailTemplate.email2;
        sendEmail(" Order status ", body, order.getDeals().getVisit().getCustomer().getWorkEmail());
        return (orderOptional.isPresent() ?
                orderRepository.save(order)
                : null);
    }


    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderByID(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> findAllOrderDESC() {
        return orderRepository.findOrdersByArchiveOrderByCreatedAtDesc("No");
    }

    @Override
    public List<Order> findAllOrderASC() {
        return orderRepository.findOrdersByArchiveOrderByCreatedAtAsc("No");
    }

    @Override
    public Order archiveOrder(Order order, String id) {
        Optional<Order> ordersDetails = orderRepository.findById(id);
        Date date = new Date();
        Instant dateToUpdate = date.toInstant();
        order.setModifiedAt(dateToUpdate);
        order.setArchive("True");
        return (ordersDetails.isPresent() ?
                orderRepository.save(order)
                : null);
    }

    @Override
    public Order cancelArchiveOrder(Order order, String id) {
        Optional<Order> ordersDetails = orderRepository.findById(id);
        Date date = new Date();
        Instant dateToUpdate = date.toInstant();
        order.setModifiedAt(dateToUpdate);
        order.setArchive("No");
        return (ordersDetails.isPresent() ?
                orderRepository.save(order)
                : null);
    }

    @Override
    public List<Order> getAllOrdersNonArchived() {

        return orderRepository.findOrdersByArchive("No");
    }

    @Override
    public List<Order> getAllOrdersArchived() {
        return orderRepository.findOrdersByArchive("True");
    }
}
