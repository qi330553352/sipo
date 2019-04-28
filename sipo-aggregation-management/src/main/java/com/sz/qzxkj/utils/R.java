/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.sz.qzxkj.utils;

import com.sz.qzxkj.enumeration.RetEnum;

import java.util.HashMap;

/**
 * 创 建 时 间: 2019/3/25
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class R<T> extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public R(int code, String msg) {
		put("code", code);
		put("msg", msg);
		put("data", null);
		put("error",false);
	}

	public static R fail() {

		return new R(RetEnum.ERROR.getRet(), RetEnum.ERROR.getMsg());
	}
	
	public static R fail(String msg) {
		return fail(RetEnum.ERROR.getRet(), msg);
	}
	
	public static R fail(int code, String msg) {
		R r = new R(code,msg);
		r.put("error",true);
		r.put("data",null);
		return r;
	}

	public static <T> R fail(T data) {
		R r = new R(RetEnum.ERROR.getRet(),RetEnum.ERROR.getMsg());
		r.put("data",data);
		r.put("error",true);
		return r;
	}


	public static <T> R fail(int code,String msg,T data) {
		R r = new R(code,msg);
		r.put("data",data);
		r.put("error",true);
		return r;
	}



	public static R ok() {

		return new R(RetEnum.SUCCESS.getRet(),RetEnum.SUCCESS.getMsg());
	}



	public static R ok(String msg) {
		R r = new R(RetEnum.SUCCESS.getRet(),msg);
		r.put("data",msg);
		r.put("error",false);

		return r;
	}

	public static R ok(int code, String msg) {
		R r = new R(code,msg);
		r.put("code", code);
		r.put("msg", msg);
		r.put("data", null);
		r.put("error",false);

		return r;
	}


	public static <T> R ok(T data) {
		R r = new R(RetEnum.SUCCESS.getRet(),RetEnum.SUCCESS.getMsg());
		r.put("data",data);
		r.put("error",false);
		return r;
	}


	public static <T> R ok(int code,String msg,T data) {
		R r = new R(code,msg);
		r.put("data",data);
		r.put("error",false);
		return r;
	}


	@Override
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}


}
