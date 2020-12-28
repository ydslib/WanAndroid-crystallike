/**
 * Created by : yds
 * Time: 2020-12-24 9:48 PM
 */
package com.crystallake.basic.utils.click;


import android.util.LruCache;

public final class ViewCacheNode {
    private static final String TAG = "[ViewCacheNode]:";

    public int id;
    public long when;
    ViewCacheNode next;
    public boolean isCanClick;
    public static ViewCacheNode mCacheNode;
    private static int size = 0;

    public static final long DELAY = 3000L;
    public static final int MAX_SIZE = 10;

    public ViewCacheNode() {

    }

    public ViewCacheNode(int id) {
        this.id = id;
        when = System.currentTimeMillis();
        isCanClick = true;
    }

    public static void enqueueViewNode(ViewCacheNode node) {
        if (node.id<0){
            return;
        }
        long nowTime = System.currentTimeMillis();
        //判断mCacheNode中是否存在id相同的节点
        if (contains(node)) {
            //在mCacheNode找到node的位置
            ViewCacheNode cur = get(node);
            //如果当前时间减去该节点处上次点击的时间小于500毫秒
//            Log.d(TAG, "before:" + (nowTime - cur.when));
            System.out.println("before:"+(nowTime - cur.when));
            if (nowTime - cur.when > DELAY) {
                cur.isCanClick = true;
//                Log.d(TAG, "after:" + (nowTime - cur.when));
                System.out.println("after:"+(nowTime - cur.when));
                cur.when = nowTime;//则当前节点的时间设置为当前时间


                int index = getNodeIndex(node) - 1;//根据节点找到mCacheNode中的索引。
                ViewCacheNode pre = mCacheNode;//找到cur节点的前一个节点
                if (index < 0) {
                    return;
                }
                int i = 0;
                while (i < index) {
                    pre = pre.next;
                    i++;
                }
                pre = cur.next;//删除当前节点
                cur.next = null;
                while (pre.next != null) {
                    pre = pre.next;
                }
                pre.next = cur;//将cur节点放在最后，里面其它节点的时间一定小于当前节点
            }
        } else {//如果不存在
            ViewCacheNode p = mCacheNode;
            //如果mCacheNode为null,那么直接将mCacheNode指向node
            if (p == null) {
                node.next = p;
                mCacheNode = node;
            } else {
                //如果mCacheNode大小达到最大值
                if (size == MAX_SIZE) {
                    mCacheNode = mCacheNode.next;//删除掉头节点
                    size--;
                }
                //将节点插入到mCacheNode最后面。
                while (p.next != null) {
                    p = p.next;
                }
                node.next = null;
                p.next = node;
            }
            size++;
        }
    }

    public static boolean canClick(ViewCacheNode node) {
        long nowTime = System.currentTimeMillis();
        if (contains(node)) {
            ViewCacheNode cur = get(node);
            return nowTime - cur.when > DELAY;
        } else {
            enqueueViewNode(node);
            return true;
        }
    }


    public static boolean contains(ViewCacheNode node) {
        ViewCacheNode cur = mCacheNode;
        while (cur != null) {
            if (cur.id == node.id) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 根据node节点找到mCacheNode中是否存在id相同的节点
     *
     * @param node
     * @return
     */
    public static ViewCacheNode get(ViewCacheNode node) {
        ViewCacheNode cur = mCacheNode;
        while (cur != null) {
            if (cur.id == node.id) {
                return cur;
            }
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 根据id找到mCacheNode中的ViewCacheNode，如果不存在，则创建一个ViewCacheNode
     *
     * @param id
     * @return
     */
    public static ViewCacheNode getOrDefault(int id) {
        ViewCacheNode cur = mCacheNode;
        while (cur != null) {
            if (cur.id == id) {
                break;
            }
            cur = cur.next;
        }
        if (cur == null) {
            cur = new ViewCacheNode(id);
        }
        enqueueViewNode(cur);
        return cur;
    }

    public static ViewCacheNode getPreNode(ViewCacheNode node) {
        if (!contains(node)) {
            return new ViewCacheNode(-1);
        }
        ViewCacheNode head = new ViewCacheNode(-1);
        head.next = mCacheNode;
        ViewCacheNode cur = mCacheNode;
        ViewCacheNode pre = head;
        while (cur != null) {
            if (cur.id == node.id) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }


    public static int getNodeIndex(ViewCacheNode node) {
        if (!contains(node)) {
            return 0;
        }
        int i = 0;
        ViewCacheNode tmp = mCacheNode;
        while (tmp != null) {
            if (tmp.id == node.id) {
                return i;
            }
            tmp = tmp.next;
            i++;
        }
        return i;
    }

    public static int getSize() {
        return size;
    }

}
