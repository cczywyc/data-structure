package com.wangyc.dataStructure.linkedList;

/**
 * 链表的定义及功能实现
 *
 * @author wangyc
 */
public class SingleLinkedList {

    /** 链表头节点的定义，不存放值，指向链表的下一个节点，作为链表的入口 */
    private final HeroNode head = new HeroNode(0, "", "");

    /**
     * 返回链表的头节点
     * @return 链表的头节点
     */
    public HeroNode getHead() {
        return head;
    }

    /**
     * 链表的遍历
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //定义辅助变量
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 链表尾部插入节点
     * @param heroNode 插入的节点
     */
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    /**
     * 按节点顺序插入链表
     * @param heroNode 插入的节点
     */
    public void addByOrder(HeroNode heroNode) {
        //辅助节点
        HeroNode temp = head;
        //待添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                //插入的位置找到
                break;
            } else if (temp.next.no == heroNode.no) {
                //要插入节点的顺序已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("要插入的节点的编号 %d 已经存在，不能插入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 修改节点的信息
     * @param heroNode 修改的节点信息
     */
    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        //是否找到要修改的节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode.no);
        }
    }

    /**
     * 删除指定节点
     * @param no 要删除节点的编号
     */
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }
}
