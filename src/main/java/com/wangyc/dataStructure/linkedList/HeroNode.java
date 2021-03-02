package com.wangyc.dataStructure.linkedList;

/**
 * 链表节点的定义，每个HeroNode对象就是一个链表的节点
 * 这里通过链表对水浒英雄好汉进行管理
 *
 * @author wangyc
 */
public class HeroNode {
    /** 英雄编号 */
    public int no;
    /** 英雄姓名 */
    public String name;
    /** 英雄昵称 */
    public String nickName;
    /** 节点的next域,指向下一个节点 */
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}