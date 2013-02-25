package com.test.hsf.inferface;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taobao.hsf.hsfunit.HSFEasyStarter;
import com.taobao.hsf.hsfunit.util.ServiceUtil;
import com.taobao.matrix.group.service.GroupResult;
import com.taobao.matrix.group.service.GroupService;
import com.taobao.matrix.group.service.dataobject.GroupInfoDO;

/**
 * @author E-mail: hwy1782@gmail.com
 * @date  : 2013-2-22 上午09:38:19
 * 
 */
public class BangpaiServiceTest extends HsfConfigLoader{
	
	@Test
	public void test_getBangpaiMsg(){
		
		long groupId = 114119450L;
		//114119450
		GroupInfoDO rst = HsfServiceFactory.createGroupService().getGroupInfoByModel(groupId);
		
		System.out.println("id = "+rst.getId()+" name = "+rst.getName()+" catalogId = "+rst.getCatalogId());
	}
	
	@Test
	public void test_InsertBangpai(){
		
		GroupService bangpaiService = (GroupService) ctx.getBean("bangpaiService");
		ServiceUtil.waitServiceReady(bangpaiService);
		
		long userId = 183511405L;
		String groupName = "daitian_test14";
		GroupResult<Long> rst = bangpaiService.createGroupByModel(userId, groupName);
		
		System.out.println("rst = "+rst.getValue());
		System.out.println("error msg  = "+rst.getMessage());
	}
	
	@Test
	public void test_getUserGroup(){
		
		GroupService bangpaiService = (GroupService) ctx.getBean("bangpaiService");
		ServiceUtil.waitServiceReady(bangpaiService);
		
		long userId = 183511405L;
		GroupResult<List<GroupInfoDO>> tmpRst = bangpaiService.getUserGroup(0, userId);
		
		List<GroupInfoDO> rst = tmpRst.getValue();
		for(GroupInfoDO e : rst){
			System.out.println("id = "+e.getId()+" name = "+e.getName()+" catalogId = "+e.getCatalogId());
		}
		
		System.out.println("error msg  = "+tmpRst.getMessage());
	}
	
	@Test
	public void test_isUserInGroup(){
		
		GroupService bangpaiService = (GroupService) ctx.getBean("bangpaiService");
		ServiceUtil.waitServiceReady(bangpaiService);
		
		long userId = 183511405L;
		long groupId = 114119450L;
		GroupResult<Boolean> tmpRst = bangpaiService.isUserInGroup(userId, groupId);

		System.out.println("rst = "+tmpRst.getValue());
		
		System.out.println("error msg  = "+tmpRst.getMessage());
	}
	
}
