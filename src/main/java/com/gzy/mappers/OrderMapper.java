package com.gzy.mappers;

import com.gzy.bean.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    Order queryOrderWithUserAndDetailByOrderNumber(@Param("orderNumber") String orderNumber);
}
