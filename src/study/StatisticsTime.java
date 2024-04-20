package study;

/**
 * 统计时间
 *
 * @author llpy
 * @date 2024/04/20
 */
public abstract class StatisticsTime {
	// 模板方法：可以做成final，不让子类去覆盖
	final void make() {
		select();
		addCondiment();
		soak();
		beat();
	}
	
	//选材料
	void select() { System.out.println("第一步：选择新鲜的豆子"); }
	//添加不同的配料：抽象方法，由子类具体实现
	abstract void addCondiment();
	//浸泡
	void soak() { System.out.println("第三步：豆子和配料开始浸泡3H"); }
	//榨汁
	void beat() { System.out.println("第四步：豆子和配料放入豆浆机榨汁"); }
}
