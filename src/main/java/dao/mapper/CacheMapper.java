package dao.mapper;

import entity.OrdersExt;

import java.util.List;

public interface CacheMapper {
    List<OrdersExt> findOrderAndLazyLoading() throws Exception;
}
