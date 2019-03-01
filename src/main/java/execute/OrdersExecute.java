package execute;

import dao.mapper.OrdersExtMapper;
import dao.mapper.OrdersMapper;
import entity.OrderMapExt;
import entity.OrdersExt;
import org.junit.Test;

import java.util.List;

public class OrdersExecute extends MapperClass {

    @Test
    public void findOrderAndUser() throws Exception {
        OrdersMapper mapper = getMapper(OrdersMapper.class);
        List<OrdersExt> orderAndUser = mapper.findOrderAndUser();
        orderAndUser.forEach(p -> System.out.println(p.toString()));
    }

    @Test
    public void findOrderAndUserRstMap() throws Exception {
        OrdersMapper mapper = getMapper(OrdersMapper.class);
        List<OrderMapExt> orderAndUser = mapper.findOrderAndUserRstMap();
        orderAndUser.forEach(p -> System.out.println(p.toString()));
    }

}
