package study;

/**
 * 统计时间
 *
 * @author llpy
 * @date 2024/04/20
 */
public abstract class TimingTemplate {

	private long start;

	// 模板方法：可以做成final，不让子类去覆盖
	public final void run(Object s) {
		start();
		Object method = method(s);
		System.out.println("本次执行结果为："+method+"，执行时间为："+end()+"ms");
	}
	
	//选材料
	void start() {
		this.start = utils.getTimeMillis();
	}
	//添加不同的配料：抽象方法，由子类具体实现
	protected abstract Object method(Object s);
	//浸泡
	long end() {
		long end = utils.getTimeMillis();
		return end -start;
	}
}
