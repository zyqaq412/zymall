package com.hzy.zymall.coupon.controller;

import com.hzy.common.utils.PageUtils;
import com.hzy.common.utils.R;
import com.hzy.zymall.coupon.entity.CouponEntity;
import com.hzy.zymall.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 优惠券信息
 *
 * @author zxwyhzy
 * @email zxwyhzy@gmail.com
 * @date 2023-11-13 16:25:24
 */
@RefreshScope // 刷新 动态获取配置文件
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;


    @Value("${couponuser.name}")
    private String name;
    @Value("${couponuser.age}")
    private String age;
    /**
     *  测试配置中心
     * @return
     */
    @GetMapping("/test")
    public R test(){
        return R.ok().put("name",name).put("age",age);
    }

    /**
     *  获取会员全部优惠价 测试用
     * @return 会员全部优惠价
     */
    @GetMapping("/member/list")
    public R memberCoupons(){
        CouponEntity coupon = new CouponEntity();
        coupon.setCouponName("满100减10");
        return R.ok().put("coupon",Arrays.asList(coupon));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
