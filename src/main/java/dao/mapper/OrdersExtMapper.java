package dao.mapper;

import entity.User;
import entity.UserQueryVo;

import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface OrdersExtMapper {
   List<OrdersExt> findOrderAndUser();
   
   List<OrderMapExt> findOrderAndUserRstMap();
}

