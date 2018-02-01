package com.program.tutorcommon.dao;

import com.program.tutorcommon.entity.Area;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Li on 2018/2/1.
 */
@Repository
@CacheConfig(cacheNames = "areas")
public interface AreaDao extends JpaRepository<Area,Integer> {
    @Override
    @Cacheable
    Area findOne(Integer integer);
}
