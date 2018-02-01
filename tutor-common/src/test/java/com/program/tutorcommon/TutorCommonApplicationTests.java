package com.program.tutorcommon;

import com.program.tutorcommon.dao.AreaDao;
import com.program.tutorcommon.entity.Area;
import net.sf.ehcache.CacheManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorCommonApplicationTests {

	@Autowired
	private AreaDao areaDao;

//	@Autowired
//	private CacheManager cacheManager;


	@Before
	public void before() {
		areaDao.save(new Area("城关区"));
	}

	@Test
	public void contextLoads() {
		Area a1 = areaDao.findOne(1);
		System.out.println("第一次查询："+a1.getArea());
		Area a2 = areaDao.findOne(1);
		System.out.println("第二次查询："+a2.getArea());
	}

}
