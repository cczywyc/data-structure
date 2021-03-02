package com.wangyc.dataStruture.linkedList;

import com.wangyc.dataStructure.linkedList.HeroNode;
import com.wangyc.dataStructure.linkedList.SingleLinkedList;
import org.junit.Test;

/**
 * 链表测试类
 *
 * @author wangyc
 */
public class SingleLinkedListTest {

    /**
     * 往链表尾部添加数据
     */
    @Test
    public void add() {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.list();
    }

    /**
     * 按编号插入节点
     */
    @Test
    public void addByOrder() {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        // 加入按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        singleLinkedList.list();
    }

    /**
     * 修改节点信息
     */
    @Test
    public void update() {
        HeroNode hero1 = new HeroNode(1, "宁晓蓓", "烽火股神");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        // 加入按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        // 测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小宁", "傻逼");
        singleLinkedList.update(newHeroNode);

        singleLinkedList.list();
    }

    /**
     * 删除节点
     */
    @Test
    public void delete() {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        // 加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        // 删除节点
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);

        singleLinkedList.list();
    }
}
