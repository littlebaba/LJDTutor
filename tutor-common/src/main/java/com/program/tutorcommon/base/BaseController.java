package com.program.tutorcommon.base;

import com.program.tutorcommon.dto.TutorResult;
import com.program.tutorcommon.exception.ServiceProcessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Li on 2018/2/1.
 */
public class BaseController {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());
    public TutorResult restProcessor(ResultProcessor processor){
        TutorResult result = null;
        try {
            result = processor.process();
        }catch (ServiceProcessException e1){
            logger.error("ServiceProcess Error Log :"+e1.getLocalizedMessage(),e1);
            result = TutorResult.error(e1.getMessage());
        }catch (Exception e){
            logger.error("Error Log :"+e.getLocalizedMessage(),e);
            result = TutorResult.error("服务器出现异常");
        }
        return result;
    }
}
