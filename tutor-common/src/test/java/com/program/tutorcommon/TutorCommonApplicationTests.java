package com.program.tutorcommon;

import com.program.tutorcommon.dao.AreaDao;
import com.program.tutorcommon.dao.StudentDao;
import com.program.tutorcommon.dao.TeacherDao;
import com.program.tutorcommon.entity.Area;
import com.program.tutorcommon.entity.Student;
import com.program.tutorcommon.entity.Teacher;
import net.sf.ehcache.CacheManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorCommonApplicationTests {

	@Autowired
	private AreaDao areaDao;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private TeacherDao teacherDao;

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

		List<Student> ls = studentDao.findAll();
		Student s1 = ls.get(0);
		System.out.println(s1.toString());

		List<Teacher> lt = teacherDao.findAll();
		Teacher t1 = lt.get(0);
		System.out.println(t1.toString());

	}

}
