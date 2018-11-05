import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.dao.SpDao;
import com.offcn.po.Sp;

public class TestDao {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");

		SpDao dao = context.getBean(SpDao.class);
		
		Sp sp = new Sp();
		sp.setName("大白菜");
		sp.setLowprice(0.25F);
		sp.setAvgprice(0.30F);
		sp.setHprice(0.5F);
		sp.setGuige("普通");
		sp.setUnit("斤");
		sp.setCreatedate(new Date());
		
		
		Sp sp1 = new Sp();
		sp1.setName("大白菜2");
		sp1.setLowprice(0.25F);
		sp1.setAvgprice(0.30F);
		sp1.setHprice(0.5F);
		sp1.setGuige("普通");
		sp1.setUnit("斤");
		sp1.setCreatedate(new Date());
		List<Sp> list=new ArrayList<Sp>();
		
		list.add(sp);
		list.add(sp1);
		
		dao.saves(list);
		
		List<Sp> lists = dao.getSpByBeginToEnd("2018-11-1", "2018-11-2");
		
		for(Sp s:lists){
			System.out.println(s);
		}
		
		
	}

}
