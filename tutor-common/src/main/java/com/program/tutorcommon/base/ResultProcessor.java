package com.program.tutorcommon.base;

import com.program.tutorcommon.dto.TutorResult;

/**
 * @author Li on 2018/2/2.
 */
@FunctionalInterface
public interface ResultProcessor {
    TutorResult process();
}
