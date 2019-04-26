package com.bd.springphoenixhbase.pic.rest;

import com.bd.springphoenixhbase.pic.service.PhoenixTest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张博【zhangb@lianliantech.cn】
 */
@RestController
@RequestMapping("/PhoenixTestRest")
@Api(description = "PhoenixTest 事务测试", value = "PhoenixTest 事务测试")
public class PhoenixTestRest {

    private PhoenixTest phoenixTest;

    public PhoenixTestRest(PhoenixTest phoenixTest) {
        this.phoenixTest = phoenixTest;
    }

    @RequestMapping(value = "/insertSVDPic", method = RequestMethod.POST)
    @ApiOperation(value="insertSVDPic")
    public void insertSVDPic() throws Exception {
        try {
            phoenixTest.insertSVDPic();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @RequestMapping(value = "/deleteSVDPic", method = RequestMethod.DELETE)
    @ApiOperation(value="deleteSVDPic")
    public void deleteSVDPic() throws Exception {
        try {
            phoenixTest.deleteSVDPic();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value = "/selectAll", method = RequestMethod.POST)
    @ApiOperation(value="selectAll")
    public void selectAll() throws Exception {
        try {
            phoenixTest.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
