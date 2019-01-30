package com.study.ssm.controller;


import java.util.*;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.study.ssm.model.EchartsVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.ssm.model.User;
import com.study.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	

	/**
	 * 根据用户ID获取用户信息
	 * @Title getUser
	 * @param id
	 * @return User
	 * @author Dujian
	 * @Date 2018年10月11日
	 */
	@RequestMapping("/getUser")	
	@ResponseBody
	public User getUser(Integer id){
	
		return userService.getUserById(id);
		
	}
	
	/**
	 * 获取用户集合
	 * @Title getUserList
	 * @param model
	 * @return String
	 * @author Dujian
	 * @Date 2018年10月11日
	 */
	@RequestMapping("/userList")
	public String getUserList(Model model){
		List<User> userList = userService.getUserList();
		model.addAttribute("userList", userList);
		return "userList";
	}


	/**
	 * 新增用户
	 * @Title insertUser
	 * @param user
	 * @return String
	 * @author Dujian
	 * @Date 2018年10月11日
	 */
	@RequestMapping("/insertUser")	
	@ResponseBody
	public String insertUser( User user){
		
		int row = userService.insertUser(user);
		if (row>0) {
			return "添加用户成功";
		}else {
			return "添加用户失败";
		}
	}
	/**
	 * 修改用户
	 * @Title updateUser
	 * @param user
	 * @return String
	 * @author Dujian
	 * @Date 2018年10月11日
	 */
	@RequestMapping("/updateUser")	
	@ResponseBody
	public String updateUser( User user){
		int row=userService.updateUser(user);
		if (row>0) {
			return "修改用户成功";
		}else {
			return "修改用户失败";
		}
	}
	
	/**
	 * 删除用户
	 * @Title deleteUser
	 * @param id
	 * @return String
	 * @author Dujian
	 * @Date 2018年10月11日
	 */
	@RequestMapping("/deleteUser")	
	@ResponseBody
	public String deleteUser(Integer id) {
		int row=userService.deleteUser(id);
		if (row>0) {
			return "删除用户成功";
		}else {
			return "删除用户失败";
		}
	}
	/**
	 * @Author DuJian
	 * @Description 测试echarts的异步加载返回数据给柱状图
	 * @Date 2019/1/30 9:07
	 * @Param []
	 * @Return com.study.ssm.model.EchartsVO
	 **/
	@RequestMapping("/echarts")
	@ResponseBody
	public EchartsVO echarts(){
		EchartsVO<Integer, Integer> echartsVO = new EchartsVO<>();
		/*测试数据
		List<Integer> ages = Arrays.asList(24, 25, 26, 27);
		List<Integer> nums = Arrays.asList(2, 5, 3, 1);
		*/
		List<Integer> ages =new ArrayList<>();
		List<Integer> nums = new ArrayList<>();

		List<HashMap> maps = userService.getEcharts();
		maps.forEach(map->{
				ages.add((Integer) map.get("age"));
				nums.add((Integer) map.get("count"));
			echartsVO.setxAxisCategory(ages);
			echartsVO.setDatas(nums);
		});

		return echartsVO;
	}

	@RequestMapping("/echartsPie")
	@ResponseBody
	public Map echartsPie(){
		HashMap<String, Integer> map = new HashMap<>();
		map.put("大专",25);
		map.put("本科",53);
		map.put("研究生",12);
		map.put("大专以下",3);
		return map;
	}
}
