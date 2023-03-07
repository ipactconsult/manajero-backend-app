package com.manazellocrm.customermanagement.business.businessimpl;

import com.manazellocrm.customermanagement.business.ibusiness.IDeliveryBusiness;
import com.manazellocrm.customermanagement.business.ibusiness.IOrdersBusiness;
import com.manazellocrm.customermanagement.entities.Delivery;
import com.manazellocrm.customermanagement.entities.Order;
import com.manazellocrm.customermanagement.entities.Status;
import com.manazellocrm.customermanagement.repositories.DeliveryRepository;
import com.manazellocrm.customermanagement.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class DeliveryBusiness implements IDeliveryBusiness {
    final JavaMailSender javaMailSender;

    private final DeliveryRepository deliveryRepository;
    private final OrderRepository orderRepository;
    private final IOrdersBusiness iOrdersBusiness;

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
    public void getDelivery(Delivery delivery) {
        String message = "Delivery code " + delivery.getShipCode() +
                "\n  " +
                " Hello ,\n"
                + delivery.getOrder().getDeals().getVisit().getCustomer().getName() +
                "\n" +
                "  Thank you for placing your order on Manazello. We are currently working on your order : "+delivery.getShippingStatus();

        String infos = "  <br/>  Client information :  " +
                "\n" +
                delivery.getOrder().getDeals().getVisit().getCustomer().getAddress() + " , "
                + delivery.getOrder().getDeals().getVisit().getCustomer().getCity() + " , "
                + delivery.getOrder().getDeals().getVisit().getCustomer().getCountry() +
                "\n"
                + "    at " + delivery.getShipDate().toInstant();
        String total = "   <br/> Total " + delivery.getShippingPrice() + delivery.getCurrency();
        String body = EmailTemplate.EMAIL + message + infos + total + EmailTemplate.email2;
        sendEmail(" Order status ", body, delivery.getOrder().getDeals().getVisit().getCustomer().getWorkEmail());

    }

    @Override
    public Delivery validateDelivery(Delivery delivery) {
        Optional<Delivery> deliveryOptional = deliveryRepository.findById(delivery.getId());
        Date date = new Date();
        Instant instanceNow = date.toInstant();
        delivery.setModifiedAt(instanceNow);
        delivery.setShippingStatus(Status.DELIVERED);
                getDelivery(delivery);
        return (deliveryOptional.isPresent() ?
                deliveryRepository.save(delivery)
                : null);
    }

    @Override
    public Delivery addDelivery(Delivery delivery, String idOrder) throws NoSuchAlgorithmException {
        Optional<Order> ordersDetails = orderRepository.findById(idOrder);
        Date date = new Date();
        Instant instanceNow = date.toInstant();
        Random r = SecureRandom.getInstanceStrong();
        int randomInt = r.nextInt((100 - 50 + 1) + 50);
        delivery.setShipCode("#" + randomInt);
        delivery.setCreatedAt(instanceNow);
        ordersDetails.ifPresent(order -> {
            delivery.setOrder(ordersDetails.get());
            ordersDetails.get().setStatus(Status.DISPATCHED);
            iOrdersBusiness.updateOrder(ordersDetails.get(), idOrder);

        });
        delivery.setShippingStatus(Status.DISPATCHED);
        String message = "Delivery code " + delivery.getShipCode() +
                "\n  " +
                " Hello ,\n"
                + delivery.getOrder().getDeals().getVisit().getCustomer().getName() +
                "\n" +
                "  Thank you for placing your order on Manazello. We will call you as soon as possible on your phone.";
        String body = EmailTemplate.EMAIL + message + EmailTemplate.email2;
        sendEmail(" Order dispatched ", body, delivery.getOrder().getDeals().getVisit().getCustomer().getWorkEmail());

        return deliveryRepository.save(delivery);
    }



    @Override
    public Delivery updateDelivery(Delivery delivery, String id) {
        Optional<Delivery> deliveryOptional = deliveryRepository.findById(id);
        Date date = new Date();
        Instant instanceNow = date.toInstant();
        delivery.setModifiedAt(instanceNow);

        return (deliveryOptional.isPresent() ?
                deliveryRepository.save(delivery)
                : null);
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery getDeliveryByID(String id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Delivery> findAllDeliveryDESC(String archive) {
        return deliveryRepository.findDeliveriesByArchiveOrderByCreatedAtDesc(archive);
    }

    @Override
    public List<Delivery> findAllDeliveryASC(String archive) {
        return deliveryRepository.findDeliveriesByArchiveOrderByCreatedAtAsc(archive);
    }

    @Override
    public Delivery archiveDelivery(Delivery delivery, String id) {
        Optional<Delivery> deliveryOptional = deliveryRepository.findById(id);
        Date date = new Date();
        Instant dateToUpdate = date.toInstant();
        delivery.setModifiedAt(dateToUpdate);
        delivery.setArchive(true);
        return (deliveryOptional.isPresent() ?
                deliveryRepository.save(delivery)
                : null);
    }

    @Override
    public Delivery cancelArchiveDelivery(Delivery delivery, String id) {
        Optional<Delivery> deliveryOptional = deliveryRepository.findById(id);
        Date date = new Date();
        Instant dateToUpdate = date.toInstant();
        delivery.setModifiedAt(dateToUpdate);
        delivery.setArchive(false);
        return (deliveryOptional.isPresent() ?
                deliveryRepository.save(delivery)
                : null);
    }

    @Override
    public List<Delivery> getAllDeliveriesNonArchived(String archive) {
        return deliveryRepository.findDeliveriesByArchive(archive);
    }
}
