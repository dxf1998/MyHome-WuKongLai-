package com.dxf.Controller;

import java.util.Iterator;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxf.model.Member;
import com.dxf.util.controller.AbstractBaseController;

@Controller
public class MemberController extends AbstractBaseController {
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@Valid Member vo, BindingResult result) { // 增加前的准备操作路径
		if (result.hasErrors()) { // 现在表示执行的验证出现错误
			Iterator<ObjectError> iterator = result.getAllErrors().iterator(); // 获取全部错误信息
			while (iterator.hasNext()) {
				ObjectError error = iterator.next(); // 取出每一个错误
				System.out.println("【错误信息】code = " + error.getCode() + "，message = " + error.getDefaultMessage());
			}
			return result.getAllErrors();
		} else {
			return vo;
		}
	}

	@RequestMapping(value = "/addPre", method = RequestMethod.GET)
	public String addPre() { // 增加前的准备操作路径
		return "member_add";
	}
}