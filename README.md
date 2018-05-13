# ZUnReadMessage


# 设计思想

* 当某个树形节点收到消息，单链表不行 因为第二层可能是多个。 逆向迭代   弱引用  监听的回调

* UnReadTree 一次性配置。结构清晰。 相比 activity配置中好太多

# 设计具体细节：

* UnReadNode(associate.class)【UnReadNode与class关联】；

* Activity（开始UnReadTree.setLister(UnReadCallback)【包含find的功能通过UnReadCallback.getClass】=能找到这个UnReadNode return,并且这个回调还可以处理 未读消息的通知）

* 添加消息的时候 ，用这个 开始UnReadTree.setLister 返回的UnReadNode 节点去添加未读消息数量 即可！

# 规则注意：

 * 每次UnReadTree.setLister 都会对该节点UnReadNode 的消息数量清零；

 * 每次添加消息 ，都是包含该节点 以及父节点迭代 进行 消息通知；

### JicPack
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
Step 2. Add the dependency
> compile 'com.github.luhaoaimama1:ZUnReadMessage:[Latest release](https://github.com/luhaoaimama1/ZUnReadMessage/releases/)'


# Easy use:

* 第一步 全局配置树
```
       UnReadTree.configure(
                new UnReadNode(Activity.class).addChilds(
                        new UnReadNode(Activity2_1.class).addChilds(
                                new UnReadNode(Activity3_1.class),
                                new UnReadNode(Activity3_2.class)
                        ),
                        new UnReadNode(Activity2_2.class)
                )
        );
```

* 第二步
    * UnReadTree.setListener能得到这个unReadNode
    * 通过unReadNode添加消息即可。
    * 在回调方法中unreadCount 更新UI吧
```
public class Activity implements UnReadNode.UnReadCallback {

    UnReadNode unReadNode;
    public Activity() {
        unReadNode = UnReadTree.setListener(this);
        unReadNode.addUnReadCount(3);
    }

    @Override
    public void unreadCount(int count) {
        System.out.println("Activity:"+count);
    }

}
```

# Update log

## 1.0.1

  * 初始化
