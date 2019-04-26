package com.bd.springphoenixhbase.pic.service.impl;

import com.bd.springphoenixhbase.pic.mapper.svd_pic.PicMapper;
import com.bd.springphoenixhbase.pic.model.SVDPic;
import com.bd.springphoenixhbase.pic.model.svd_pic.Pic;
import com.bd.springphoenixhbase.pic.service.PhoenixTest;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author 张博【zhangb@lianliantech.cn】
 */
@Service
public class PhoenixTestImpl implements PhoenixTest {

    private PicMapper picMapper;


    public PhoenixTestImpl(PicMapper picMapper) {
        this.picMapper = picMapper;
    }

    @Transactional(rollbackFor= RuntimeException.class)
    @Override
    public void insertSVDPic() throws RuntimeException {

        Pic svdPic = new Pic();

        String[] strings = {"jpg"};

        FileUtils.listFiles(new File("/Users/zhangbo/Documents/ncaiData/aoi/deducing/bumping/HI6421V710WSB/CF1907332A/2AI029JM1/DHF447-12-G4/JPG"), strings, false)
                .forEach(s -> {

                    try {

                        svdPic.setId(s.getName().split("\\.")[0]);

                        svdPic.setFile(FileUtils.readFileToByteArray(s.getAbsoluteFile()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        try {

            picMapper.insert(svdPic);

            //int o = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("插入回滚测试！！");
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void deleteSVDPic() throws RuntimeException {
        try {

            picMapper.deleteByPrimaryKey("DHF447-12-G4_X_3_Y_24");
            //int o = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除回滚测试！！");
        }
    }

    @Override
    public List<SVDPic> selectAll() {

        try {

            List<Pic> pics = picMapper.selectAll();

            Pic pic = picMapper.selectByPrimaryKey("DHF447-12-G4_X_3_Y_24");

            pics.forEach( s -> {

                try (OutputStream outputStream = new FileOutputStream("/Users/zhangbo/Downloads/".concat(s.getId()).concat("pics.jpg"))) {

                    outputStream.write(s.getFile());

                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            try (OutputStream outputStream = new FileOutputStream("/Users/zhangbo/Downloads/".concat(pic.getId()).concat(".jpg"))) {

                outputStream.write(pic.getFile());

                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return null;
    }
}
