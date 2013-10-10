/**
 * 
 */
package jw.asmsupport.operators.logical;


import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import jw.asmsupport.Parameterized;
import jw.asmsupport.block.ProgramBlock;
import jw.asmsupport.clazz.AClass;
import jw.asmsupport.operators.Operators;
import jw.asmsupport.utils.Stack;


/**
 * 
 * @author 温斯群(Joe Wen)
 *
 */
public class ShortCircuitOr extends ConditionOperator {
    
    protected ShortCircuitOr(ProgramBlock block, Parameterized factor1, Parameterized factor2) {
        super(block, factor1, factor2);
        operator = Operators.CONDITION_OR;
    }
    
    
    @Override
    protected void executingProcess() {
        MethodVisitor mv = insnHelper.getMv();
        AClass ftrCls1 = factor1.getParamterizedType();
        AClass ftrCls2 = factor2.getParamterizedType();
        
        factor1.loadToStack(block);
        insnHelper.unbox(ftrCls1.getType());
        mv.visitJumpInsn(Opcodes.IFNE, trueLbl);
        
        factor2.loadToStack(block);
        insnHelper.unbox(ftrCls2.getType());
        mv.visitJumpInsn(Opcodes.IFNE, trueLbl);

        mv.visitInsn(Opcodes.ICONST_0);
        mv.visitJumpInsn(Opcodes.GOTO, falseLbl);
        mv.visitLabel(trueLbl);
        mv.visitInsn(Opcodes.ICONST_1);
        mv.visitLabel(falseLbl);
        
        Stack stack = block.getMethod().getStack();
        stack.pop();
        stack.pop();
        stack.push(Type.BOOLEAN_TYPE);
    }

}