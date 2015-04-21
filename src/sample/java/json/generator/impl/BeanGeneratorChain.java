package json.generator.impl;

import json.JSONPool;
import json.generator.AbstractGeneratorChain;
import json.generator.IValueGeneratorChain.GeneratorContext;
import cn.wensiqun.asmsupport.client.Param;
import cn.wensiqun.asmsupport.client.ProgramBlock;
import cn.wensiqun.asmsupport.client.def.var.FieldVar;
import cn.wensiqun.asmsupport.client.def.var.LocVar;
import cn.wensiqun.asmsupport.core.block.ProgramBlockInternal;
import cn.wensiqun.asmsupport.core.clazz.ProductClass;
import cn.wensiqun.asmsupport.core.definition.KernelParameterized;
import cn.wensiqun.asmsupport.core.definition.variable.GlobalVariable;
import cn.wensiqun.asmsupport.core.definition.variable.LocalVariable;
import cn.wensiqun.asmsupport.standard.def.clazz.AClass;

public class BeanGeneratorChain extends AbstractGeneratorChain {

    @Override
    public boolean match(AClass type) {
        String typeStr = type.getName();
        if(typeStr.startsWith("java.") ||
                typeStr.startsWith("javax.") ) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean doGenerate(GeneratorContext context, ProgramBlock<? extends ProgramBlockInternal> block,
            LocVar encoder, AClass type, Param value) {
        JSONPool jsonPool = context.getJsonPool();
        if(type instanceof ProductClass) {
            if(jsonPool.getOrRegister(((ProductClass)type).getReallyClass()) != null) {
                FieldVar pool = block.this_().field("jsonPool");
                block.call(block.call(pool, "getOrRegister", block.val(type)), "parse", encoder, value);
                return true;
            }
        }
        return false;
    }
    
}
