package com.offcn.cat;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.po.Sp;
import com.offcn.service.SpService;
/***
 * 新增代码注释
 * @author Administrator
 *
 */
public class CatXinFaDi {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");

		SpService service = context.getBean(SpService.class);
		
		for(int i=1;i<35;i++){
		String url="http://www.xinfadi.com.cn/marketanalysis/0/list/"+i+".shtml?prodname=%E5%A4%A7%E7%99%BD%E8%8F%9C&begintime=2017-01-01&endtime=2018-11-01";
		String html = getUrlHtml(url);
		List<Sp> list = partsHtml(html);
		service.saves(list);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	/**
	 * 获取制定url地址的html源码
	 */
	public static String getUrlHtml(String url){
		String html=null;
		CloseableHttpClient client = HttpClients.createDefault();
		
		HttpGet get = new HttpGet(url);
		
		try {
			CloseableHttpResponse response = client.execute(get);
			
			int code=response.getStatusLine().getStatusCode();
			if(code==200){
				HttpEntity entity = response.getEntity();
				
				html=EntityUtils.toString(entity, "utf-8");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return html;
	}
	
	/**
	 * 解析新发地数据
	 */
	public static List<Sp> partsHtml(String html){
		List<Sp> list=new ArrayList<Sp>();
		
		Document doc = Jsoup.parse(html);
		
		//抓取数据所在表格节点
		Element table = doc.select(".hq_table").first();
		
		//获取每行tr
		Elements trs = table.select("tr");
		
		//移除第一个tr
		trs.remove(0);
		//遍历tr
		for (Element e : trs) {
			/*System.out.println(e.text());*/
			String row=e.text();
			String[] ds = row.split(" ");
			Sp sp = new Sp();
			sp.setName(ds[0]);
			sp.setLowprice(Float.parseFloat(ds[1]));
			sp.setAvgprice(Float.parseFloat(ds[2]));
			sp.setHprice(Float.parseFloat(ds[3]));
			sp.setGuige(ds[4]);
			sp.setUnit(ds[5]);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sp.setCreatedate(df.parse(ds[6]));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			System.out.println(sp);
			list.add(sp);
		}
		return list;
	}
	
	public void test1(){
		System.out.println("test1");
	}

	public void www(){
		System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwww");
	}
}
