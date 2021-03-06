package cn.wensiqun.asmsupport.issues.y2015.m05.net.oschina.i1;

import cn.wensiqun.asmsupport.client.DummyClass;
import cn.wensiqun.asmsupport.client.DummyMethod;
import cn.wensiqun.asmsupport.client.block.MethodBody;
import cn.wensiqun.asmsupport.client.def.var.LocVar;
import cn.wensiqun.asmsupport.client.def.var.Var;
import cn.wensiqun.asmsupport.issues.IssuesConstant;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

public class IntegerAssignTest {
    @Test
    public void test() throws Exception {
        DummyClass dummy = new DummyClass(IntegerAssignTest.class.getPackage().getName() + ".IntegerAssignTest_");
        dummy.public_().setClassOutPutPath(IssuesConstant.classOutPutPath);
        DummyMethod dummyMethod = dummy.newMethod("getIntegerValue")
                .public_().static_().return_(int.class);

        dummyMethod.body(new MethodBody() {

            @Override
            public void body(LocVar... args) {
                Var integer = call(Integer.class, "valueOf", val(100)).asVar();
                return_(integer);
            }
        });
        Class<?> clazz = dummy.build();
        Method method = clazz.getMethod("getIntegerValue");
        int value = (Integer) method.invoke(clazz);
        Assert.assertEquals(100, value);
    }
}
