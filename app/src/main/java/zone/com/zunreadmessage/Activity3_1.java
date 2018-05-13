package zone.com.zunreadmessage;


import zone.com.unread.UnReadNode;
import zone.com.unread.UnReadTree;

/**
 * Created by Zone on 2018/5/13.
 */
public class Activity3_1 implements UnReadNode.UnReadCallback {
    UnReadNode unReadNode;
    public Activity3_1() {
        unReadNode = UnReadTree.setListener(this);
        unReadNode.addUnReadCount(9);
    }

    @Override
    public void unreadCount(int count) {
        System.out.println("Activity3_1:"+count);
    }
}
