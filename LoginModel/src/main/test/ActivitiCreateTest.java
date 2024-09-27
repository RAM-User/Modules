import org.activiti.engine.*;
import org.junit.Test;

public class ActivitiCreateTest {
    /**
     * 使用activiti提供的默认方式来创建mysql的表
     */
    @Test
    public void testCreateDbTable1() {
        // 需要使用avtiviti提供的工具类 ProcessEngines ,使用方法getDefaultProcessEngine
        // getDefaultProcessEngine会默认从resources下读取名字为activiti.cfg.xml的文件
        // 创建processEngine时，就会创建mysql的表
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
    }

    @Test
    public void testGetService() {
        //获取各个service实例
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        HistoryService historyService = processEngine.getHistoryService();
    }

    /**
     * 一般创建方式
     */
    @Test
    public void testCreateDbTable2() {
        // ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        // 配置文件的名字可以自定义,bean的名字也可以自定义
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml","processEngineConfiguration");
        // 获取流程引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
    }
}
