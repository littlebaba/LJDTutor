package com.program.toturtotur.service.impl;

import com.program.toturtotur.service.StudentService;
import com.program.toturtotur.service.TeacherService;
import com.program.tutorcommon.base.BaseServiceImpl;
import com.program.tutorcommon.dao.StudentDao;
import com.program.tutorcommon.dao.TeacherDao;
import com.program.tutorcommon.entity.Student;
import com.program.tutorcommon.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;

/**
 * @author Li on 2018/2/2.
 */
@Service
public class TeacherServiceImpl extends BaseServiceImpl<TeacherDao, Teacher> implements TeacherService {


    @Override
    public Page<Teacher> fetchTopTen(Sort sort) {
        Pageable pg = new PageRequest(0, 10, sort);
        return repository.findAll(pg);
    }

    @Override
    public Page<Teacher> findByPage(Teacher teacher, int pageNo, int limit) {
        PageRequest pageable = new PageRequest(pageNo, limit);
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "id");
        Specification<Teacher> specification = new Specification<Teacher>() {
            @Override
            public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> id = root.get("id");
                Path<String> teachSubjects = root.get("teachSubjects");
                Path<String> profession = root.get("profession");

                ArrayList<Predicate> lists = new ArrayList<>();

                if (!StringUtils.isEmpty(teacher.getId())) {
                    lists.add(criteriaBuilder.equal(id, teacher.getId()));
                }

                if (!StringUtils.isEmpty(teacher.getTeachSubjects())) {
                    lists.add(criteriaBuilder.like(teachSubjects, "%" + teacher.getTeachSubjects() + "%"));
                }

                if (!StringUtils.isEmpty(teacher.getProfession())){
                    lists.add(criteriaBuilder.like(profession,"%"+teacher.getProfession()+"%"));
                }

                return criteriaBuilder.and(lists.toArray(new Predicate[lists.size()]));
            }
        };
        Page<Teacher> page = repository.findAll(specification, pageable);
        return page;
    }
}
