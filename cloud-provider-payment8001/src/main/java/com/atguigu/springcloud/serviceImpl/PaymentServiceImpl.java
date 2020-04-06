package com.atguigu.springcloud.serviceImpl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

  @Resource
  private PaymentDao paymentDao;

  public int creat(Payment payment){
        return paymentDao.creat(payment);
  }

  public Payment getPaymentById(@Param("id") Long id){
        return paymentDao.getPaymentById(id);
  }

}
