package com.hmmes.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Collections; 

import net.sf.json.JSONObject;
//import net.sf.json.JSON;
import org.json.JSONArray;
import com.alibaba.fastjson.JSON;  
//import com.alibaba.fastjson.JSONObject;  
import com.alibaba.fastjson.annotation.JSONField;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.context.*;
import org.springframework.web.context.support.*;

import com.hmmes.bean.JsonBean;
import com.hmmes.bean.ZbggBean;
import com.hmmes.bean.CgflBean;
import com.hmmes.bean.ZbwzBean;
import com.hmmes.bean.TbxxBean;
import com.hmmes.bean.GysdaBean;


import com.hmmes.bean.BaseBean.DELETED;

import com.hmmes.model.ZbggModel;
import com.hmmes.model.TbxxModel;


import com.hmmes.service.ZbggService;
import com.hmmes.service.GysdaService;
import com.hmmes.service.TbxxService;



import com.hmmes.utils.HtmlUtil;
import com.hmmes.utils.SessionUtils;
import com.hmmes.utils.DateUtil;
import com.hmmes.utils.StringUtil;



 
@Controller
@RequestMapping("/spManage") 
public class ZbspAction extends BaseAction{
	
	private final static Logger log= Logger.getLogger(ZbggAction.class);
	
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private ZbggService<ZbggBean> zbggService; 
	

	@Autowired
	private TbxxService<TbxxBean> tbxxService;	
	@Autowired 
	private GysdaService<GysdaBean> gysdaService; 


	/**
	 * ilook 首页
	 * @param url
	 * @param classifyId
	 * @return
	 */

	@RequestMapping("/sp")
	public ModelAndView  zpsp(ZbggModel model,HttpServletRequest request) throws Exception{
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 String todate=sdf.format(new Date()) ;//销售订单结束时间，当天
		 String syear=DateUtil.getNowYear();
		 String smonth=DateUtil.getNowMonth();
		 Date fd=sdf.parse(syear+"-"+smonth+"-"+"1");
		 Calendar rightNow = Calendar.getInstance();
         rightNow.setTime(fd);
         // righNow.add(Calendar.YEAR,-1);//日期减1年
         rightNow.add(Calendar.MONTH,-1);//日期-1个月,两个月计划
         //rightNow.add(Calendar.DAY_OF_YEAR,-2);//日期-2天
         Date dt1=rightNow.getTime();
		 String fromdate=sdf.format(dt1);//销售订单开始时间
         request.setAttribute("fromdate",fromdate);
         request.setAttribute("todate",todate);

		
		Map<String,Object>  context = getRootMap();
		model.setDeleted(DELETED.NO.key);
		List<ZbggBean> dataList = zbggService.queryByList(model);
		//设置页面数据
		context.put("dataList", dataList);
		return forword("cgpt/spManage",context); 
	}	
	@RequestMapping("/spBrow")
	public ModelAndView  zpbrow(ZbggModel model,HttpServletRequest request) throws Exception{
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 String todate=sdf.format(new Date()) ;//销售订单结束时间，当天
		 String syear=DateUtil.getNowYear();
		 String smonth=DateUtil.getNowMonth();
		 Date fd=sdf.parse(syear+"-"+smonth+"-"+"1");
		 Calendar rightNow = Calendar.getInstance();
         rightNow.setTime(fd);
         // righNow.add(Calendar.YEAR,-1);//日期减1年
         rightNow.add(Calendar.MONTH,-1);//日期-1个月,两个月计划
         //rightNow.add(Calendar.DAY_OF_YEAR,-2);//日期-2天
         Date dt1=rightNow.getTime();
		 String fromdate=sdf.format(dt1);//销售订单开始时间
         request.setAttribute("fromdate",fromdate);
         request.setAttribute("todate",todate);

		
		Map<String,Object>  context = getRootMap();
		model.setDeleted(DELETED.NO.key);
		List<ZbggBean> dataList = zbggService.queryByList(model);
		//设置页面数据
		context.put("dataList", dataList);
		return forword("cgpt/spBrow",context); 
	}	
     /**
	 * json 列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList")   
	public void  dataList(ZbggModel model,HttpServletResponse response) throws Exception{
		JSONObject context = new JSONObject();	
		model.setQd(1);
		List<ZbggBean> dataList = zbggService.queryByList(model);
		List<ZbggBean> result = new ArrayList<ZbggBean>();

		for (Object ele : dataList)
		{
			ZbggBean st = (ZbggBean)ele;
	
			result.add(st);
		}

	    JSONArray jsonArr= new JSONArray(result);
		String jsonStr="{\"total\":"+model.getPager().getRowCount()+",\"rows\":"+jsonArr.toString()+"}";
//System.out.println("高绪山：ZbggAction--dataList"+jsonStr);
        response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonStr);
	
		return ;
	}

	@RequestMapping("/dataListDist")   
	public void  dataListDist(ZbggModel model,HttpServletResponse response) throws Exception{
		JSONObject context = new JSONObject();	
		model.setQd(1);
		List<ZbggBean> dataList = zbggService.queryByListDist(model);
		List<ZbggBean> result = new ArrayList<ZbggBean>();

		for (Object ele : dataList)
		{
			ZbggBean st = (ZbggBean)ele;
	
			result.add(st);
		}

	    JSONArray jsonArr= new JSONArray(result);
		String jsonStr="{\"total\":"+model.getPager().getRowCount()+",\"rows\":"+jsonArr.toString()+"}";
//System.out.println("高绪山：ZbggAction--dataList"+jsonStr);
        response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonStr);
	
		return ;
	}


	@RequestMapping("/dataListForGgbh")   //根据招标公告编号，查询招标物资显示明细DataGrid 
	public void  dataListForGgbhAndGysId(String ggbh,HttpServletRequest request,HttpServletResponse response) throws Exception{

		JSONObject context = new JSONObject();	
		Integer kb=0; 
		List<ZbggBean> dataListzb=zbggService.queryListByGgbh(ggbh);
		if (dataListzb!=null && dataListzb.size()>0 )
		{
			kb=dataListzb.get(0).getKb();
		}
		List<TbxxBean> dataList = tbxxService.queryListByGgbh(ggbh);
		List<TbxxBean> result = new ArrayList<TbxxBean>();

		for (TbxxBean bean : dataList)
		{
			GysdaBean gysbean=gysdaService.queryById(bean.getGysId());
		    String gysStr=gysbean.getName();
	        bean.setGysStr(gysStr);
			bean.setKb(kb);
			result.add(bean);
		}
	    JSONArray jsonArr= new JSONArray(result);
		String jsonStr="{\"total\":"+result.size()+",\"rows\":"+jsonArr.toString()+"}";
//System.out.println("高绪山：tbxx"+jsonStr);
        context.put("tbxx",jsonStr);
		context.put(SUCCESS, true);	
	    HtmlUtil.writerJson(response, context);

		return ;
	}

 
	@RequestMapping("/getId")
	public void getId(Integer id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		JSONObject context = new JSONObject();
		ZbggBean bean  = zbggService.queryById(id);
		String ggbh= bean.getGgbh()	;
		if(bean  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
	    String username = SessionUtils.getUser(request).getNickName();
		String lrr=bean.getCreateBy();
	    if(bean.getState()!= 1 ){
			sendFailureMessage(response, "该招标公告已暂停或作废!");
			return;
		}
	    if(bean.getSp()!= null && bean.getSp()==1 ){
			sendFailureMessage(response, "该招标公告已被("+bean.getSpBy()+")审批!");
			return;
		}
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    String sdate;
		Date ddate=null;
        sdate=sdf1.format(new Date());	
		try {
    	    ddate = sdf1.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
	    List<ZbggBean> dataListzb = zbggService.queryListByGgbh(ggbh);
		for (ZbggBean zbbean : dataListzb){ 
			zbbean.setSp(1);	
			zbbean.setSpBy(username);	
			zbbean.setSpTime(new java.sql.Timestamp(ddate.getTime()));  //java.util.Date -->java.sql.Date
			zbggService.updateBean(zbbean);
		}
			
	    sendSuccessMessage(response, "审批成功~");
		return ; 
	}


 
}
