package com.hundsun.core.service.impl;

import cn.hutool.core.io.FileUtil;
import com.hundsun.common.annotation.LicenseApi;
import com.hundsun.common.annotation.ParamsCheck;
import com.hundsun.common.util.HSBlowfish;
import com.hundsun.common.util.XStreamUtil;
import com.hundsun.core.entity.*;
import com.hundsun.core.service.DemoService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

/**
 * Created by jiayq24996 on 2019-06-05
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    @ParamsCheck(ignore = false)
    public String test(User user) {
        /*//文件路径
        String path = this.getClass().getResource("/license.lic").getPath();
        //String base64 =Base64.encodeBase64String(FileUtil.readBytes(path));
        //读取license.lic文件内容(xml格式)
        String contentStr = FileUtil.readUtf8String(path);
        //xml转对象
        Class[] types = {Product.class, Api.class, ExtendField.class, Module.class};
        Product product = XStreamUtil.xmlToBean(contentStr, types);
        //TODO file是老产品的许可证文件（需加密）
        byte[] encode = null;
        try {
            encode = HSBlowfish.encodeWithBase64(file.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setOldModel(encode);
        //将赋值后的对象转xml
        String initStr = XStreamUtil.beanToXml(product);
        //反解析测试
        //Product product1 = XStreamUtil.xmlToBean(initStr, types);
        // 覆盖式写入源文件
        FileUtil.writeString(initStr, "D:\\TEST.lic", "UTF-8");

        Base64.encodeBase64String(FileUtil.readBytes(path));
        System.out.println(product);
        return product.toString();*/
        System.out.println("================路过Service===================");
        return "success";
    }
}
