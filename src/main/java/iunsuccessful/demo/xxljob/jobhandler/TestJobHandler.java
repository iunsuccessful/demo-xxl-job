package iunsuccessful.demo.xxljob.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

/**
 *
 * job 是在运程执行的，没有调用我们这个项目的方法，下午写个更新数据试试
 * <p/>
 *
 * @author Created by 依韵 on 2019/2/15 .
 */
@JobHandler(value = "testJobHandler")
@Component
public class TestJobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String s) throws Exception {

        XxlJobLogger.log("=========== test job handler | start ===========");



        return ReturnT.SUCCESS;
    }
}
