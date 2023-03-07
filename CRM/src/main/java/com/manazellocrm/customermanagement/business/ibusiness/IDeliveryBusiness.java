package com.manazellocrm.customermanagement.business.ibusiness;

import com.manazellocrm.customermanagement.entities.Delivery;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IDeliveryBusiness {
    Delivery validateDelivery(Delivery delivery);
    Delivery addDelivery (Delivery delivery, String idOrder) throws NoSuchAlgorithmException;
    Delivery updateDelivery (Delivery delivery, String id);
    List<Delivery> getAllDeliveries ();
    Delivery getDeliveryByID(String id);
    List<Delivery> findAllDeliveryDESC(String archive);
    List<Delivery> findAllDeliveryASC(String archive);
    Delivery archiveDelivery(Delivery delivery, String id);
    Delivery cancelArchiveDelivery(Delivery delivery, String id);
    List<Delivery> getAllDeliveriesNonArchived(String archive);
    void getDelivery(Delivery delivery);
}
