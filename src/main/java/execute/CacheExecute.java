package execute;

import dao.mapper.CacheMapper;
import entity.OrdersExt;
import org.junit.Test;

import java.util.List;

public class CacheExecute extends MapperClass {

    @Test
    public void testFindOrderAndUser() throws Exception {
        CacheMapper mapper = getMapper(CacheMapper.class);
        List<OrdersExt> orderAndLazyLoading = mapper.findOrderAndLazyLoading();
        orderAndLazyLoading.forEach(p -> p.toString());
    }
}
