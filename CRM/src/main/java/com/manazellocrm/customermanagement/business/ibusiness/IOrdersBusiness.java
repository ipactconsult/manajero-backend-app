package com.manazellocrm.customermanagement.business.ibusiness;


import com.manazellocrm.customermanagement.entities.Contract;
import com.manazellocrm.customermanagement.entities.Order;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IOrdersBusiness {
    Order validateOrder(Order order, String id);
    Order saleOrder(Order order, String id);
    Order inProgressOrder(Order order, String id);
    Order addOrder (Order order, String idProduct) throws NoSuchAlgorithmException;
    Order updateOrder (Order order, String id);
    List<Order> getAllOrders ();
    Order getOrderByID(String id);
    List<Order> findAllOrderDESC();
    List<Order> findAllOrderASC();
    Order archiveOrder(Order order, String id);
    Order cancelArchiveOrder(Order order, String id);
    List<Order> getAllOrdersNonArchived();
    List<Order> getAllOrdersArchived();
    Order assignContractToOrder( String id, Contract contract);
    List<Order> findOrdersContractsNull();
    List<Order> findOrdersContractsNotNull();
    List<Order> findAllOrdersConfirmed();
    Order deliverOrder(Order order, String id);
}
