# MAT
## 获取二进制快照的三种方式
+ 使用Attach API
+ 新建虚拟机运行Attach API
+ 使用Jmap工具
## 计算对象占据内存的两种方式
+ Shallow heap  对象自身所占据的内存
+ Retained heap  垃圾回收器所能回收的总内存 对象自身所占据的内存以及通过该对象引用到的其他对象所占据的内存
## 比较重要的视图
### 直方图 histogram
+ 各个类的实例数目
+ 类的SH总和
### 支配树 dominator tree
+ GC roots 到对象的路径
+ 对象到GC roots的路径


# JMC
## 虚拟机内置的高效 profiling 工具 Java Flight Recorder

需要下载对应的jmc软件