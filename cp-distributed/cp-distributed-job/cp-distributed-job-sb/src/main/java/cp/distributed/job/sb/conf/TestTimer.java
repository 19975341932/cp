package cp.distributed.job.sb.conf;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class TestTimer implements SchedulingConfigurer {


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.addTriggerTask(()-> runTime(), triggerContext -> {
            return new CronTrigger("0/5 * * * * ?").nextExecutionTime(triggerContext);
        });
    }

    private void runTime() {
        System.out.println("1111111111");
    }
}
