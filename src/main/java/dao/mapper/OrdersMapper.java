package dao.mapper;

import entity.OrderMapExt;
import entity.OrdersExt;

import java.util.List;

public interface OrdersMapper {
    List<OrdersExt> findOrderAndUser();

    List<OrderMapExt> findOrderAndUserRstMap();
}
