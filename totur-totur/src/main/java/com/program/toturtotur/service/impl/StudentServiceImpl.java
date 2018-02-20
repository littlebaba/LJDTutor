package com.program.toturtotur.service.impl;

import com.program.toturtotur.service.StudentService;
import com.program.tutorcommon.base.BaseServiceImpl;
import com.program.tutorcommon.dao.StudentDao;
import com.program.tutorcommon.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Li on 2018/2/2.
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentDao,Student> implements StudentService{


    @Override
    public Page<Student> fetchTopTen(Sort sort) {
        Pageable pg = new PageRequest(0,10,sort);
        return repository.findAll(pg);
    }

    @Override
    public Page<Student> findByPage(Student student, int pageNo, int limit) {
        PageRequest pageable = new PageRequest(pageNo,limit);
        Sort.Order order = new Sort.Order(Sort.Direction.ASC,"id");
        Specification<Student> specification = new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> id = root.get("id");

                ArrayList<Predicate> list = new ArrayList<>();
                if (student.getId() != null){
                    list.add(criteriaBuilder.equal(id,student.getId()));
                }

                Predicate predicate = criteriaBuilder.and(list.toArray(new Predicate[list.size()]));

                return predicate;
            }
        };
        Page<Student> page = repository.findAll(specification,pageable);
        return page;
    }
}
