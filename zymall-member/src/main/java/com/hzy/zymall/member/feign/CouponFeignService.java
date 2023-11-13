package com.hzy.zymall.member.feign;

import com.hzy.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @title: CouponFeignService 声明式的远程调用
 * @Author zxwyhzy
 * @Date: 2023/11/13 20:51
 * @Version 1.0
 */
@FeignClient("zymall-coupon")
public interface CouponFeignService {
    @GetMapping("/coupon/coupon/member/list")
    R memberCoupon();
}
