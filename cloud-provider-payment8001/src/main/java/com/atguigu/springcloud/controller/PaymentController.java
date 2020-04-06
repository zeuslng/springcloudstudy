package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

  @Resource
  private PaymentService paymentService;

  @PostMapping("/payment/create")
  public CommonResult creat(@RequestBody Payment payment){
    int result = paymentService.creat(payment);
    log.info("******插入结果哈哈哈哈哈："+result);

    if(result>0){
      return new CommonResult(200,"插入数据库成功，红红火火恍恍惚惚",result);
    }else{
      return new CommonResult(444,"插入数据库失败",null);
    }

  }
  @GetMapping("/payment/get/{id}")
  public CommonResult getPaymentById(@PathVariable("id") Long id){
    Payment payment = paymentService.getPaymentById(id);
    log.info("******查询结果："+payment);

    if(payment!=null){
      return new CommonResult(200,"查询成功",payment);
    }else{
      return new CommonResult(444,"没有对应记录，查询id："+id,null);
    }

  }

}
