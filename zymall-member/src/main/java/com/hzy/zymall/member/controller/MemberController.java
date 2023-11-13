package com.hzy.zymall.member.controller;

import com.hzy.common.utils.PageUtils;
import com.hzy.common.utils.R;
import com.hzy.zymall.member.entity.MemberEntity;
import com.hzy.zymall.member.feign.CouponFeignService;
import com.hzy.zymall.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 会员
 *
 * @author zxwyhzy
 * @email zxwyhzy@gmail.com
 * @date 2023-11-13 16:51:38
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private CouponFeignService couponFeignService;

    @GetMapping("/coupons")
    public R test(){
        MemberEntity zs = new MemberEntity();
        zs.setNickname("张三");
        R coupons = couponFeignService.memberCoupon();
        return R.ok().put("member",zs).put("coupons",coupons);

    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
