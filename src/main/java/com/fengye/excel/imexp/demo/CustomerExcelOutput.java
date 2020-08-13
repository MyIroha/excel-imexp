package com.fengye.excel.imexp.demo;

import com.fengye.excel.imexp.demo.model.CustomerVO;
import com.fengye.excel.imexp.excel.AbstractExcelOutput;
import com.fengye.excel.imexp.model.OutputHandlerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * 客户信息导出处理类
 * @author zhoufeng
 *
 */
@Component
public class CustomerExcelOutput extends AbstractExcelOutput<CustomerVO> {
	private static final Logger _logger = LoggerFactory.getLogger(CustomerExcelOutput.class);

    /**
	 * 导出Excel数据
	 * @return
	 */
	@Override
	public OutputHandlerVO<CustomerVO> queryOutputData(Object object) {
		OutputHandlerVO<CustomerVO> vo = new OutputHandlerVO();

		CustomerVO cvo = new CustomerVO();
		cvo.setShopName("小米");
		cvo.setNikeName("小红");
		cvo.setMobile("1346");
		cvo.setGoodsName("小米6");
		cvo.setGoodsCode("mi-6");
		cvo.setNumber(1);
		cvo.setRealName("红红");
		cvo.setPrice(new BigDecimal(12.6));
		cvo.setTotalPrice(new BigDecimal(12.6));
		cvo.setCustomeDate(new Date());
		List<CustomerVO> list = new ArrayList<>();
		list.add(cvo);
		vo.setDataArray(list);

		return vo;
	}

    /**
     * 下载模板 创建Excel列下拉框
	 * @return
     */
	@Override
	public OutputHandlerVO<CustomerVO> queryTemplateComboBox(Object object) {
		OutputHandlerVO<CustomerVO> vo = new OutputHandlerVO();
		Map<String,String[]> paramMap = new HashMap();
		//excel第三行为下拉选择框
		String[] nameArray = {"红米","小米"};
		paramMap.put("shopName", nameArray);
		vo.setSelectMap(paramMap);
		return vo;
	}

}
