package springtask;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * 定时任务service
 * @author zyc
 *
 */
@Component  
public class SpringTaskService {
	private static Logger logger = Logger.getLogger(SpringTaskService.class);
	
	private static int i = 0;
    /**  
     * 定时计算。每天凌晨 01:00 执行一次  
     */    
    @Scheduled(cron = "0 0 1 * * *")    
	public void timeTask(){
		i++;
		logger.info(new Date()+":第"+i+"次执行定时任务。\n");
	}
    
    /**  
     * 心跳更新。启动时执行一次，之后每隔60秒执行一次  
     */    
    @Scheduled(fixedRate = 1000*60)   
    public void print(){  
        System.out.println("Annotation：print run");  
    } 
}
