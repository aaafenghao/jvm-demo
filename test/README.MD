@Warmup -- 预热迭代
@Measurement -- 测试迭代

@Warmup(
iterations=10, 预热迭代的次数
time=100,   每次迭代持续的时间
timeUnit=TimeUnit.MILLISECONDS, 单位
batchSize=10)  每次操作包含多少次对测试方法的调用


@State  --程序状态

@Setup  --必须是状态类中的方法 初始化程序状态

@TearDown  --必须是状态类中的方法 效验程序状态

@CompilerControl  --方法内联与否



