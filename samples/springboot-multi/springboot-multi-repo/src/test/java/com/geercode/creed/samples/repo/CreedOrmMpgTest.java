package com.geercode.creed.samples.repo;

import com.geercode.creed.archetype.orm.CreedOrm;
import org.junit.Test;

/**
 * <p>Description : Mpg测试</p>
 * <p>Created on  : 2018-09-12 14:32</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class CreedOrmMpgTest {
    @Test
    public void genAllTest() {
        CreedOrm.mpg().genAll();
        CreedOrm.mpg().genXml();
    }
}
