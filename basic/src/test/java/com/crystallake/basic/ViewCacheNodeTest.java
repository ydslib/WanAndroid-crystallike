/**
 * Created by : yds
 * Time: 2020-12-26 9:26 PM
 */
package com.crystallake.basic;


import com.crystallake.basic.utils.click.ViewCacheNode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.crystallake.basic.utils.click.ViewCacheNode.MAX_SIZE;

public class ViewCacheNodeTest {

    @Before
    public void setUp(){

    }

    @Test
    public void should_returnNotNull_when_getOrDefault_with_valid() {
        ViewCacheNode viewCacheNode = ViewCacheNode.getOrDefault(1);
        Assert.assertNotNull("viewCacheNode should not be null",viewCacheNode);
        int size = ViewCacheNode.getSize();
        Assert.assertEquals("the size should be equals to 1",1, size);
    }

    @Test
    public void should_returnNotNull_when_getOrDefault_with_same_id() {
        ViewCacheNode viewCacheNode = ViewCacheNode.getOrDefault(1);
        Assert.assertNotNull("viewCacheNode should not be null",viewCacheNode);
        int size = ViewCacheNode.getSize();
        Assert.assertEquals("the size should be equals to 1",1, size);

        viewCacheNode = ViewCacheNode.getOrDefault(1);
        Assert.assertNotNull("viewCacheNode should not be null",viewCacheNode);
        size = ViewCacheNode.getSize();
        Assert.assertEquals("the size should be equals to 1",1, size);
    }


    @Test
    public void should_returnNotNull_when_getOrDefault_with_not_same_id() {
        ViewCacheNode viewCacheNode = ViewCacheNode.getOrDefault(1);
        Assert.assertNotNull("viewCacheNode should not be null",viewCacheNode);
        int size = ViewCacheNode.getSize();
        Assert.assertEquals("the size should be equals to 1",1, size);

        viewCacheNode = ViewCacheNode.getOrDefault(2);
        Assert.assertNotNull("viewCacheNode should not be null",viewCacheNode);
        size = ViewCacheNode.getSize();
        Assert.assertEquals("the size should be equals to 2",2, size);
    }


    @Test
    public void should_returnNotNull_when_getOrDefault_with_size_greater_than_MAX_SIZE() {
        for(int i=0;i<12;i++){
            ViewCacheNode.getOrDefault(i);
        }
        int size = ViewCacheNode.getSize();
        Assert.assertEquals("the size should be equals to MAX_SIZE",MAX_SIZE, size);
    }


}
