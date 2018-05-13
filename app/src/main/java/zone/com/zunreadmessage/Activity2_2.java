package zone.com.zunreadmessage;


import zone.com.unread.UnReadNode;
import zone.com.unread.UnReadTree;

/**
 * Created by Zone on 2018/5/13.
 */
public class Activity2_2 implements UnReadNode.UnReadCallback {

    UnReadNode unReadNode;
    public Activity2_2() {
        unReadNode = UnReadTree.setListener(this);
        unReadNode.addUnReadCount(5);
    }

    @Override
    public void unreadCount(int count) {
        System.out.println("Activity2_2:"+count);
    }
}
