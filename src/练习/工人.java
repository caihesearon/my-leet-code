package 练习;

/**
 * @author hecai
 * @date 2020/10/4
 */
public class 工人 implements 照顾宠物 {
    @Override
    public void 喂食() {
        System.out.println("工人喂食");
    }

    @Override
    public void 陪他玩() {
        System.out.println("工人陪他玩");

    }
}
