package com.bd.springphoenixhbase.pic.service;


import com.bd.springphoenixhbase.pic.model.SVDPic;

import java.util.List;

/**
 * @author 张博【zhangb@lianliantech.cn】
 */
public interface PhoenixTest {

    void insertSVDPic() throws RuntimeException;

    void deleteSVDPic() throws RuntimeException;

    List<SVDPic> selectAll();
}
