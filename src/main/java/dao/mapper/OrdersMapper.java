package dao.mapper;

import entity.OrderMapExt;
import entity.OrdersExt;
import entity.User;

import java.util.List;

public interface OrdersMapper {
    List<OrdersExt> findOrderAndUser();

    List<OrderMapExt> findOrderAndUserRstMap();

    List<User> findOrdersAndItemsRstMap();
}
