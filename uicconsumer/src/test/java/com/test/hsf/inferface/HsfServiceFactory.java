package com.test.hsf.inferface;

import com.taobao.hsf.hsfunit.util.ServiceUtil;
import com.taobao.matrix.group.service.GroupService;

/**
 * @author E-mail: hwy1782@gmail.com
 * @date  : 2013-2-25 上午10:30:42
 * 
 */
public class HsfServiceFactory extends HsfConfigLoader{
	
	public static GroupService createGroupService(){
		GroupService bangpaiService = (GroupService) ctx.getBean("bangpaiService");
		ServiceUtil.waitServiceReady(bangpaiService);
		return bangpaiService;
	}
	
}
